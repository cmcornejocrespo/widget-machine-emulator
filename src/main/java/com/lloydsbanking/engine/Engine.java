package com.lloydsbanking.engine;

import com.lloydsbanking.fuel.FuelType;

public interface Engine {

    void start();

    void stop();

    boolean isRunning();

    void fill(int fuelLevel);

    FuelType getFuelType();

    int getBatchSize();

    boolean isEmpty();

    int getFuelLevel();
}
