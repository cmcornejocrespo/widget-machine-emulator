package com.lloydsbanking.widget;

/**
 * The interface Widget.
 */
public interface Widget {

    /**
     * Produce widgets.
     *
     * @param quantity the quantity
     * @return the amount that costs producing the quantity of widgets
     */
    double produceWidgets(int quantity);
}
