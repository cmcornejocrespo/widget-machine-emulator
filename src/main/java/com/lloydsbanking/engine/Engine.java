package com.lloydsbanking.engine;

import com.lloydsbanking.fuel.FuelType;

/**
 * The interface Engine.
 */
public interface Engine {

    /**
     * Start.
     */
    void start();

    /**
     * Stop.
     */
    void stop();

    /**
     * Is running boolean.
     *
     * @return the boolean
     */
    boolean isRunning();

    /**
     * Fill.
     *
     * @param fuelLevel the fuel level
     */
    void fill(int fuelLevel);

    /**
     * Gets fuel type.
     *
     * @return the fuel type
     */
    FuelType getFuelType();

    /**
     * Gets batch size.
     *
     * @return the batch size
     */
    int getBatchSize();

    /**
     * Is empty boolean.
     *
     * @return the boolean
     */
    boolean isEmpty();

    /**
     * Gets fuel level.
     *
     * @return the fuel level
     */
    int getFuelLevel();
}
