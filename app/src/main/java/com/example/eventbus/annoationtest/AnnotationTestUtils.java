package com.example.eventbus.annoationtest;

import android.util.Log;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class AnnotationTestUtils {
    public static void valid(Object obj) throws IllegalAccessException {
        Class<?> clazz = obj.getClass();
        Field[] fields = clazz.getDeclaredFields();
        Log.d("hql", "长度" + fields.length);
        for (Field field : fields) {
            Log.d("hql", "属性 field:" + field.toString());
            TestField test = field.getAnnotation(TestField.class);//获取属性上的@Test注解
            if (test != null) {
                field.setAccessible(true);//设置属性可访问
                if ("class java.lang.String".equals(field.getGenericType().toString())) {//字符串类型的才判断长度
                    String value = (String) field.get(obj);
                    Log.d("hql", "变量的值:"+value);
                    if (value != null && ((value.length() > test.max()) || value.length() < test.min())) {
                        Log.d("hql", "max:" + test.max() + ">>min:" + test.min()+">description:"+test.description());
                    }
                }
            }


        }
        Method[] methods = clazz.getDeclaredMethods();
        Log.d("hql", "方法 list :" + methods.length);
        for (Method method : methods) {
            Log.d("hql", "方法 method:" + method.toString());
            TestMethod testMethod = method.getAnnotation(TestMethod.class);
            if (null != testMethod){
                Log.d("hql", "方法 method:" + method.getParameterTypes().length);
                Log.d("hql", "方法 testMethod   type =" + testMethod.type());
                Log.d("hql", "方法 testMethod   getName =" + testMethod.name());
            }
        }

    }

}
