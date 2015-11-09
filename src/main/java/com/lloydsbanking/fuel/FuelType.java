/**********************************************************************
 * This source code is the property of Lloyds Banking Group PLC.
 * <p>
 * All Rights Reserved.
 ***********************************************************************/
package com.lloydsbanking.fuel;

/**
 * The enum Fuel type.
 */
public enum FuelType {

    /**
     * Petrol fuel type.
     */
    PETROL(9.00), /**
     * Diesel fuel type.
     */
    DIESEL(12.00), /**
     * Wood fuel type.
     */
    WOOD(4.35), /**
     * Coal fuel type.
     */
    COAL(5.65);

    private double costPerBatch;

    private FuelType(double costPerBatch) {
        this.costPerBatch = costPerBatch;
    }

    /**
     * Gets value.
     *
     * @return the value
     */
    public double getValue() {
        return costPerBatch;
    }
}
