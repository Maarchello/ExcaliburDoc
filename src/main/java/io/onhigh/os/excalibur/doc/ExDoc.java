package io.onhigh.os.excalibur.doc;

import io.onhigh.os.excalibur.doc.xlsx.ExDocWriterXlsxBuilder;

/**
 * @author Marat Kadzhaev
 * @since 22 февр. 2023
 */
public class ExDoc {

    public static ExDocWriterXlsxBuilder builderXlsx() {
        return new ExDocWriterXlsxBuilder();
    }

}
