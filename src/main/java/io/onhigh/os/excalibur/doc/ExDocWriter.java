package io.onhigh.os.excalibur.doc;

import io.onhigh.os.excalibur.doc.xlsx.schema.ExWorkbook;

/**
 * @author Marat Kadzhaev
 * @since 22 февр. 2023
 */
public interface ExDocWriter {

    ExWorkbook write();

}
