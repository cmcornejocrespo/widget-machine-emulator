/**********************************************************************
 * This source code is the property of Lloyds Banking Group PLC.
 *
 * All Rights Reserved.
 ***********************************************************************/
package com.lloydsbanking.engine;

import com.lloydsbanking.fuel.FuelType;

import static java.lang.String.format;

public class InternalCombustionEngine implements Engine {

    //we could have done via via param
    private static final int BATCH_SIZE = 8;

    private final Engine delegateEngine;

    public InternalCombustionEngine(final FuelType fuelType) {

        if (!fuelType.equals(FuelType.DIESEL) && !fuelType.equals(FuelType.PETROL))
            throw new IllegalStateException(format("This engine doesn't support %s fuel.", fuelType.toString()));

        delegateEngine = new EngineCommonFeatures(fuelType, BATCH_SIZE);
    }

    @Override
    public void start() {
        delegateEngine.start();
    }

    @Override
    public void stop() {
        delegateEngine.stop();
    }

    @Override
    public boolean isRunning() {
        return delegateEngine.isRunning();
    }

    @Override
    public void fill(int fuelLevel) {
        delegateEngine.fill(fuelLevel);
    }

    @Override
    public FuelType getFuelType() {
        return delegateEngine.getFuelType();
    }

    @Override
    public int getBatchSize() {
        return delegateEngine.getBatchSize();
    }

    @Override
    public boolean isEmpty() {
        return delegateEngine.isEmpty();
    }

    @Override
    public int getFuelLevel() {
        return delegateEngine.getFuelLevel();
    }
}
