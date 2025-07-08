// TestModel.java
package main.java.model;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;

public class TestModel {
    private final IntegerProperty counter = new SimpleIntegerProperty(0);

    /** Incrementa el contador en 1 */
    public void increment() { counter.set(counter.get() + 1); }

    /** Propiedad para enlazar con la vista */
    public IntegerProperty counterProperty() { return counter; }
}
