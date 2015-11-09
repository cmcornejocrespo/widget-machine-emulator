/**********************************************************************
 * This source code is the property of Lloyds Banking Group PLC.
 * <p>
 * All Rights Reserved.
 ***********************************************************************/
package com.lloydsbanking.engine;

import com.lloydsbanking.fuel.FuelType;

import static java.lang.String.format;

/**
 * The type Steam engine.
 */
public class SteamEngine implements Engine {

    //we could have done via via param
    private static final int STEAM_ENGINE_BATCH_SIZE = 2;

    private final Engine delegateEngine;

    /**
     * Instantiates a new Steam engine.
     *
     * @param fuelType the fuel type
     */
    public SteamEngine(final FuelType fuelType) {

        if (!fuelType.equals(FuelType.WOOD) && !fuelType.equals(FuelType.COAL))
            throw new IllegalStateException(format("This engine doesn't support %s fuel.", fuelType.toString()));

        delegateEngine = new EngineCommonFeatures(fuelType, STEAM_ENGINE_BATCH_SIZE);
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
