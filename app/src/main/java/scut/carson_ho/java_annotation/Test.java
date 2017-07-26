package scut.carson_ho.java_annotation;

/**
 * Created by Carson_Ho on 17/7/26.
 */

@Carson_Annotation(id = 1,msg="我是类Test")
public class Test {

    @Carson_Annotation(id = 2,msg="我是变量a")
    int a;

    // 方法上采用了两个注解

    @Carson_Annotation(id = 3,msg="我是方法b")
    @Carson_Annotation2(id = 4,msg="我是方法bb（来自第2个注解）")
    public void bMethod(){}

    }