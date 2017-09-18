package scut.carson_ho.java_annotation;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "annotation";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /**
         * 讲解1：获取类上的注解
         */

        // 1. 判断Test类是否应用了注解@Carson_Annotation
        boolean hasAnnotation = Test.class.isAnnotationPresent(Carson_Annotation.class);

        // 2. 如果应用了注解 = hasAnnotation = true
        //    则获取类上的注解对象
        if ( hasAnnotation ) {
            Carson_Annotation classAnnotation = Test.class.getAnnotation(Carson_Annotation.class);

            // 3. 获取注解对象的值
            Log.d(TAG, "我是Test类上的注解");
            Log.d(TAG, "id:" + classAnnotation.id());
            Log.d(TAG, "msg:" + classAnnotation.msg());
        }

        /**
         * 讲解2：获取类成员变量a上的注解
         */
        try {
            // 1. 获取类上的成员变量a
            Field a = Test.class.getDeclaredField("a");
            a.setAccessible(true);
            
            // 2. 获取成员变量a上的注解@Carson_Annotation
            Carson_Annotation variableAnnotation = a.getAnnotation(Carson_Annotation.class);

            // 3. 若成员变量应用了注解 = hasAnnotation = true
            //    则获取注解对象上的值 = id & msg
            if ( variableAnnotation != null ) {
                Log.d(TAG, "我是类成员变量a上的注解");
                Log.d(TAG, "id:" + variableAnnotation.id());
                Log.d(TAG, "msg:" + variableAnnotation.msg());

            }

            /**
             * 讲解3：获取类方法bMethod上的注解
             */

            // 1. 获取类方法bMethod
            Method testMethod = Test.class.getDeclaredMethod("bMethod");


            // 2. 获取方法上的注解
            if ( testMethod != null ) {
                // 因为方法上有2个注解，所以采用getAnnotations()获得所有类型的注解
                Annotation[] ans = testMethod.getAnnotations();

                Log.d(TAG, "我是类方法bMethod的注解");

                // 3. 获取注解的值（通过循环）
                for( int i = 0;i < ans.length  ;i++) {

                    Log.d(TAG, "类方法bMethod的" + "注解"+ i+ ans[i].annotationType().getSimpleName());
                }
            }
        } catch (NoSuchFieldException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            System.out.println(e.getMessage());
        } catch (SecurityException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            System.out.println(e.getMessage());
        } catch (NoSuchMethodException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            System.out.println(e.getMessage());
        }



    }


}
