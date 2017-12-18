package com.jades.bus.common.util;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * Created by wangyan on 2017/12/18.
 */

public class ClassUtil {

    public static <T> T newInstance(Class<T> clazz)  {
        T instance = null;

        Constructor<?>[] cs = clazz.getDeclaredConstructors();

        try {
            instance = (T) cs[0].newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }


        return instance;

    }
}
