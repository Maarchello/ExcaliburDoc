package io.onhigh.os.excalibur.doc.xlsx;

import io.onhigh.os.excalibur.doc.xlsx.schema.ExWorkbook;
import org.apache.poi.ss.usermodel.Workbook;

import java.io.IOException;

/**
 * @author Marat Kadzhaev
 * @since 22 февр. 2023
 */
public abstract class AbstractExWorkbook implements ExWorkbook {

    protected final Workbook origin;

    public AbstractExWorkbook(Workbook origin) {
        this.origin = origin;
    }

    @Override
    public void close() throws IOException {
        if (origin == null) {
            return;
        }

        origin.close();
    }
}
