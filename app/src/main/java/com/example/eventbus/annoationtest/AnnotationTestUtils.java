package com.example.eventbus.annoationtest;

import android.app.Activity;
import android.util.Log;
import android.view.View;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

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
                    Log.d("hql", "变量的值:" + value);
                    if (value != null && ((value.length() > test.max()) || value.length() < test.min())) {
                        Log.d("hql", "max:" + test.max() + ">>min:" + test.min() + ">description:" + test.description());
                    }
                }
            }


        }
        Method[] methods = clazz.getDeclaredMethods();
        Log.d("hql", "方法 list :" + methods.length);
        for (Method method : methods) {
            Log.d("hql", "方法 method:" + method.toString());
            TestMethod testMethod = method.getAnnotation(TestMethod.class);
            if (null != testMethod) {
                Log.d("hql", "方法 method:" + method.getParameterTypes().length);
                Log.d("hql", "方法 testMethod   type =" + testMethod.type());
                Log.d("hql", "方法 testMethod   getName =" + testMethod.name());
            }
        }

    }

    /**
     *
     * @param activity
     */
    public static void invokeClick(final Activity activity) {
        Class<? extends Activity> aClass = activity.getClass();
        final Method[] methods = aClass.getDeclaredMethods();

        Field[] declaredFields = aClass.getDeclaredFields();
        for (Field f : declaredFields) {
            if (null == f) {
                continue;
            }
            f.setAccessible(true);
            final BindView bindView = f.getAnnotation(BindView.class);
            if (null == bindView) {
                continue;
            }


            View.OnClickListener clickListener = (View.OnClickListener) Proxy.newProxyInstance(
                    View.OnClickListener.class.getClassLoader(),
                    new Class[]{View.OnClickListener.class},
                    new InvocationHandler() {
                        @Override
                        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                            Log.d("hql", "invoke method :" + method.toString());
                            if (null != method) {
                                for (Method m : methods) {
                                    BindClick declaredAnnotation = m.getAnnotation(BindClick.class);
                                    if (null == declaredAnnotation) {
                                        continue;
                                    }
                                    m.setAccessible(true);
                                    return m.invoke(activity);
                                }
                            }
                            return null;
                        }
                    });


            int viewId = bindView.id();
            View view = activity.findViewById(viewId);
            try {
                Method setOnClickListener = View.class.getMethod("setOnClickListener", View.OnClickListener.class);
                setOnClickListener.invoke(view, clickListener);
                Log.d("hql", "setOnClickListener method ");
            } catch (NoSuchMethodException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            }


//            for (Method method:methods ) {
//                BindClick bindClick = method.getAnnotation(BindClick.class);
//                if(null == bindClick){
//                    continue;
//                }
//                if(viewId == bindClick.id()){
//
//                }
//            }

        }


    }

}
