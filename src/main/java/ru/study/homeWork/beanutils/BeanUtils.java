package ru.study.homeWork.beanutils;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;

public class BeanUtils {
    /**
     * Scans object "from" for all getters. If object "to"
     * contains correspondent setter, it will invoke it
     * to set property value for "to" which equals to the property
     * of "from".
     * <p/>
     * The type in setter should be compatible to the value returned
     * by getter (if not, no invocation performed).
     * Compatible means that parameter type in setter should
     * be the same or be superclass of the return type of the getter.
     * <p/>
     * The method takes care only about public methods.
     *
     * @param to   Object which properties will be set.
     * @param from Object which properties will be used to get values.
     *                  
     */

    public static void assign(Object to, Object from) throws InvocationTargetException, IllegalAccessException {
        Class clazzTo = to.getClass();
        Class clazzFrom = from.getClass();
        Method[] methodsToSetter = getSetterMethods(clazzTo.getMethods());
        Method[] methodsFromGetter = getGetterMethods(clazzFrom.getMethods());
        for (Method methodGet : methodsFromGetter) {
            String getMethodName = methodGet.getName().substring(3);
            for (Method methodSet : methodsToSetter) {
                String setMethodName = methodSet.getName().substring(3);
                if (setMethodName.equals(getMethodName) && methodGet.getReturnType().equals(methodSet.getParameterTypes()[0])) {
                    methodSet.invoke(to,  methodGet.invoke(from));
                }
            }
        }

    }

    private static boolean isGetter(Method method) {
        if (!method.getName().startsWith("get")) return false;
        if (method.getParameterTypes().length != 0) return false;
        if (void.class.equals(method.getReturnType())) return false;
        return true;
    }

    private static boolean isSetter(Method method) {
        if (!method.getName().startsWith("set")) return false;
        if (method.getParameterTypes().length != 1) return false;
        return true;
    }

    private static Method[] getGetterMethods(Method[] methods) {
        ArrayList<Method> getMethods = new ArrayList<>(methods.length);
        for (Method method : methods) {
            if (isGetter(method)) getMethods.add(method);
        }
        return getMethods.toArray(new Method[0]);
    }

    private static Method[] getSetterMethods(Method[] methods) {
        ArrayList<Method> setMethods = new ArrayList<>(methods.length);
        for (Method method : methods) {
            if (isSetter(method)) setMethods.add(method);
        }
        return setMethods.toArray(new Method[0]);
    }

}
