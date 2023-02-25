package io.onhigh.os.excalibur.doc.xlsx.schema;

import org.apache.poi.ss.usermodel.Workbook;

/**
 * @author Marat Kadzhaev
 * @since 25 февр. 2023
 */
public final class ExWorkbookFactory {

    public static ExWorkbook createWorkbook(Workbook origin) {
        return new ExWorkbookImpl(origin);
    }

}
