package io.onhigh.os.excalibur.doc.util;

/**
 * @author Marat Kadzhaev
 * @since 22 февр. 2023
 */
public class Assert {

    public static void checkNotBlank(String val) {
        if (val == null || val.trim().isBlank()) {
            throw new IllegalArgumentException("Argument must not be blank");
        }
    }

    public static void checkNotEmpty(String val) {
        if (val == null || val.trim().isBlank()) {
            throw new IllegalArgumentException("Argument must not be blank");
        }
    }

}
