package io.onhigh.os.excalibur.doc.xlsx.schema;

import java.util.List;

/**
 * @author Marat Kadzhaev
 * @since 22 февр. 2023
 */
public final class ExSheetFactory {

    public static ExSheet createSheet(String name, List<?> content) {
        return new ExSheetImpl(name, content);
    }

}
