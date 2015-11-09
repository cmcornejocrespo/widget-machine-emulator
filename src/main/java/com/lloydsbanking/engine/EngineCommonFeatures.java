/**********************************************************************
 * This source code is the property of Lloyds Banking Group PLC.
 * <p>
 * All Rights Reserved.
 ***********************************************************************/
package com.lloydsbanking.engine;

import com.lloydsbanking.fuel.FuelType;

/**
 * The type Engine common features.
 */
public class EngineCommonFeatures implements Engine {

    private final FuelType fuelType;
    private final int batchSize;
    private boolean running;
    private int fuelLevel;

    /**
     * Instantiates a new Engine common features.
     *
     * @param fuelType  the fuel type
     * @param batchSize the batch size
     */
    public EngineCommonFeatures(final FuelType fuelType, int batchSize) {

        this.fuelType = fuelType;
        this.batchSize = batchSize;
    }

    @Override
    public void start() {

        if (!isEmpty()) {
            running = true;
        } else {
            throw new IllegalStateException("Not able to start engine.");
        }
    }

    @Override
    public void stop() {

        if (isRunning()) {
            running = false;
        } else {
            throw new IllegalStateException("Not able to stop engine.");
        }
    }

    public boolean isRunning() {
        return running;
    }

    @Override
    public void fill(final int fuelLevel) {

        if (fuelLevel >= 0 && fuelLevel <= 100) {

            this.fuelLevel = fuelLevel;
        } else if (fuelLevel > 100) {

            this.fuelLevel = 100;
        } else {
            this.fuelLevel = 0;
        }
    }

    @Override
    public FuelType getFuelType() {
        return fuelType;
    }

    @Override
    public int getBatchSize() {
        return batchSize;
    }

    @Override
    public boolean isEmpty() {
        return fuelLevel == 0;
    }

    @Override
    public int getFuelLevel() {
        return fuelLevel;
    }
}
