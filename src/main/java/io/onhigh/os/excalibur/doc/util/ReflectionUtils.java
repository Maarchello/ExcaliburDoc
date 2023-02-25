package io.onhigh.os.excalibur.doc.util;

import java.lang.reflect.Field;
import java.util.function.Function;

/**
 * @author Marat Kadzhaev
 * @since 22 февр. 2023
 */
public class ReflectionUtils {

    public static Object getFieldValue(Field field, Object src) {
        try {
            boolean accessible = field.canAccess(src);
            field.setAccessible(true);

            Object val = field.get(src);
            field.setAccessible(accessible);
            return val;
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }

}
