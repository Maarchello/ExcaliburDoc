package io.onhigh.os.excalibur.doc.api;

/**
 * @author Marat Kadzhaev
 * @since 22 февр. 2023
 */
public class ExAttributeDef {

    private int order;
    private String name;
    private Object value;

    public ExAttributeDef(int order, String name, Object value) {
        this.order = order;
        this.name = name;
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getOrder() {
        return order;
    }

    public void setOrder(int order) {
        this.order = order;
    }

    public Object getValue() {
        return value;
    }

    public void setValue(Object value) {
        this.value = value;
    }
}
