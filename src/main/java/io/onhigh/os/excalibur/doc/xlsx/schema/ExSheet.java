package io.onhigh.os.excalibur.doc.xlsx.schema;

import java.util.List;

/**
 * @author Marat Kadzhaev
 * @since 22 февр. 2023
 */
public interface ExSheet {

    String getName();

    /**
     * Each object means separate row
     * @return list of object with metadata
     */
    List<?> getContent();

    default int getOrder() {
        return 0;
    }

}
