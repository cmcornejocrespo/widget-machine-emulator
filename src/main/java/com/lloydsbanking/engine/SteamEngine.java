/**********************************************************************
* This source code is the property of Lloyds Banking Group PLC.
*
* All Rights Reserved.
***********************************************************************/
package com.lloydsbanking.engine;

import com.lloydsbanking.fuel.FuelType;

import static java.lang.String.format;

public class SteamEngine implements Engine {

    private static final int STEAM_ENGINE_BATCH_SIZE = 2;

    private final Engine delegateEngine;

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