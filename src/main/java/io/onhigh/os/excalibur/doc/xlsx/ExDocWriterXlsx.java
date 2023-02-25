package io.onhigh.os.excalibur.doc.xlsx;

import io.onhigh.os.excalibur.doc.ExDocWriter;
import io.onhigh.os.excalibur.doc.api.ExAttribute;
import io.onhigh.os.excalibur.doc.api.ExAttributeDef;
import io.onhigh.os.excalibur.doc.util.Assert;
import io.onhigh.os.excalibur.doc.util.ReflectionUtils;
import io.onhigh.os.excalibur.doc.xlsx.schema.ExSheet;
import io.onhigh.os.excalibur.doc.xlsx.schema.ExWorkbook;
import io.onhigh.os.excalibur.doc.xlsx.schema.ExWorkbookFactory;
import io.onhigh.os.excalibur.doc.xlsx.schema.ExWorkbookImpl;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * @author Marat Kadzhaev
 * @since 22 февр. 2023
 */
public class ExDocWriterXlsx implements ExDocWriter {

    private final List<ExSheet> sheets;

    public ExDocWriterXlsx(List<ExSheet> sheets) {
        this.sheets = sheets;
    }

    @Override
    public ExWorkbook write() {

        Workbook workbook = new XSSFWorkbook();

        for (ExSheet exSheet : sheets) {

            Sheet sheet = workbook.createSheet(exSheet.getName());

            for (int i = 0; i < exSheet.getContent().size(); i++) {

                Object rowData = exSheet.getContent().get(i);

                List<ExAttributeDef> attributeDefs = Arrays.stream(rowData.getClass().getDeclaredFields())
                        .filter(field -> field.isAnnotationPresent(ExAttribute.class))
                        .map(toAttributeDefinition(exSheet, rowData))
                        .collect(Collectors.toList());

                Row row = sheet.createRow(i);

                // first row means header for now, but it has to be changed
                if (i == 0) {
                    List<String> headerNames = attributeDefs.stream()
                            .sorted(Comparator.comparingInt(ExAttributeDef::getOrder))
                            .map(ExAttributeDef::getName)
                            .distinct()
                            .collect(Collectors.toList());

                    for (int j = 0; j < headerNames.size(); j++) {
                        row.createCell(j).setCellValue(headerNames.get(j));
                    }

                    continue;
                }

                for (int k = 0; k < attributeDefs.size(); k++) {
                    ExAttributeDef exAttributeDef = attributeDefs.get(k);

                    int attributeDefOrder = exAttributeDef.getOrder();
                    Cell cell = row.createCell(attributeDefOrder == -1 ? k : attributeDefOrder);
                    cell.setCellValue((String) exAttributeDef.getValue());
                }
            }
        }

        return ExWorkbookFactory.createWorkbook(workbook);
    }

    private Function<Field, ExAttributeDef> toAttributeDefinition(ExSheet exSheet, Object rowData) {
        return field -> {
            ExAttribute exAttribute = field.getAnnotation(ExAttribute.class);
            Assert.checkNotBlank(exSheet.getName());

            Object fieldValue = ReflectionUtils.getFieldValue(field, rowData);
            return new ExAttributeDef(exAttribute.order(), exAttribute.name(), fieldValue);
        };
    }
}
