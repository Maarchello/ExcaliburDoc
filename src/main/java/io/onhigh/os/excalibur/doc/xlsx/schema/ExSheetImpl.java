package io.onhigh.os.excalibur.doc.xlsx.schema;

import java.util.List;

/**
 * @author Marat Kadzhaev
 * @since 22 февр. 2023
 */
public class ExSheetImpl implements ExSheet{

    private final int order;
    private final String name;
    private final List<?> content;

    public ExSheetImpl(int order, String name, List<?> content) {
        this.order = order;
        this.name = name;
        this.content = content;
    }

    public ExSheetImpl(String name, List<?> content) {
        this(0, name ,content);
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public List<?> getContent() {
        return content;
    }

    @Override
    public int getOrder() {
        return order;
    }
}
