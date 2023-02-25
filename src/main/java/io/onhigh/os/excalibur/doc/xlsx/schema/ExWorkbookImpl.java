package io.onhigh.os.excalibur.doc.xlsx.schema;

import io.onhigh.os.excalibur.doc.xlsx.AbstractExWorkbook;
import org.apache.poi.ss.usermodel.Workbook;

import java.io.ByteArrayOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * @author Marat Kadzhaev
 * @since 22 февр. 2023
 */
public class ExWorkbookImpl extends AbstractExWorkbook {

    public ExWorkbookImpl(Workbook origin) {
        super(origin);
    }

    @Override
    public byte[] getAsBytes() {
        try(ByteArrayOutputStream baos = new ByteArrayOutputStream()) {
            origin.write(baos);
            return baos.toByteArray();
        } catch (IOException e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    @Override
    public void saveToDisk(Path path) {
        byte[] asBytes = getAsBytes();
        try {
            Files.write(path, asBytes);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
