package scut.carson_ho.java_annotation;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * Created by Carson_Ho on 17/7/26.
 */

// 因为注解@Carson_Annotation需要在程序运行时使用
// 所以必须采用元注解Retention(RetentionPolicy.RUNTIME)
@Retention(RetentionPolicy.RUNTIME)
public @interface Carson_Annotation {

    // 注解@Carson_Annotation中有2个属性：id 和 msg
    int id();
    String msg() default "Hi";
}
