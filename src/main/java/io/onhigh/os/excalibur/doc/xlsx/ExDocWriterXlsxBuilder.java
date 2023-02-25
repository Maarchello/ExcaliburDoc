package io.onhigh.os.excalibur.doc.xlsx;

import io.onhigh.os.excalibur.doc.ExDocWriter;
import io.onhigh.os.excalibur.doc.xlsx.schema.ExSheet;
import io.onhigh.os.excalibur.doc.xlsx.schema.ExSheetFactory;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Marat Kadzhaev
 * @since 22 февр. 2023
 */
public class ExDocWriterXlsxBuilder {

    private final List<ExSheet> sheets = new ArrayList<>();

    public ExDocWriterXlsxBuilder sheet(String name, List<?> content) {
        sheets.add(ExSheetFactory.createSheet(name, content));
        return this;
    }

    public ExDocWriter build() {
        return new ExDocWriterXlsx(sheets);
    }

}
