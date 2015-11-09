/**********************************************************************
 * This source code is the property of Lloyds Banking Group PLC.
 * <p>
 * All Rights Reserved.
 ***********************************************************************/
package com.lloydsbanking.widget;

import com.lloydsbanking.engine.Engine;

/**
 * The type Widget machine.
 */
public class WidgetMachine implements Widget {

    private final Engine engine;

    /**
     * Instantiates a new Widget machine.
     *
     * @param engine the engine
     */
    public WidgetMachine(final Engine engine) {
        this.engine = engine;
    }

    private double produce(final int quantity) {

        final int batchSize = engine.getBatchSize();
        final double costPerBatch = engine.getFuelType().getValue();

        int batch = 0;
        int batchCount = 0;

        while (batch < quantity) {
            batch = batch + batchSize;
            batchCount++;
        }

        return batchCount * costPerBatch;
    }

    @Override
    public double produceWidgets(final int quantity) {

        engine.start();

        double cost = 0.0;

        if (engine.isRunning()) {
            cost = produce(quantity);
        }

        engine.stop();

        return cost;
    }
}
