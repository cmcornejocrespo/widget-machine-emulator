package com.lloydsbanking.engine;

import com.lloydsbanking.fuel.FuelType;
import org.junit.Test;

import static org.junit.Assert.fail;


public class InternalCombustionEngineUnitTest {

    private Engine sut;

    @Test(expected = IllegalStateException.class)
    public void itShouldNotAllowToCreateACombustionEngineWithInvalidFuelTypeWood() {

        sut = createEngine(FuelType.WOOD);

        fail("it shouldn't reach here");
    }

    @Test(expected = IllegalStateException.class)
    public void itShouldNotAllowToCreateACombustionEngineWithInvalidFuelTypeCoal() {

        sut = createEngine(FuelType.COAL);

        fail("it shouldn't reach here");

    }

    //private test helpers
    private Engine createEngine(FuelType fuelType) {
        return new InternalCombustionEngine(fuelType);
    }
}