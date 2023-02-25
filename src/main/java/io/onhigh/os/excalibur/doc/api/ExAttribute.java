package io.onhigh.os.excalibur.doc.api;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author Marat Kadzhaev
 * @since 22 февр. 2023
 */
@Target({ ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface ExAttribute {

    /**
     *  Column name for XLSX
     *  Tag name for XML
     */
    String name() default "";

    /**
     * Zero-based
     * Column order for XLSX
     * Tag order for XML
     * @return
     */
    int order() default -1;

}
