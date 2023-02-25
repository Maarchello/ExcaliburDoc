package io.onhigh.os.excalibur.doc.xlsx.schema;

import java.io.Closeable;
import java.nio.file.Path;

/**
 * @author Marat Kadzhaev
 * @since 22 февр. 2023
 */
public interface ExWorkbook extends Closeable {

    byte[] getAsBytes();

    void saveToDisk(Path path);

}
