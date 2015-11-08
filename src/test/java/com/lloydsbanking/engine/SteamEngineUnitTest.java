package com.lloydsbanking.engine;

import com.lloydsbanking.fuel.FuelType;
import org.junit.Test;

import static org.junit.Assert.fail;


public class SteamEngineUnitTest {

    private Engine sut;

    @Test(expected = IllegalStateException.class)
    public void itShouldNotAllowToCreateACombustionEngineWithInvalidFuelTypePetrol() {

        sut = createEngine(FuelType.PETROL);

        fail("it shouldn't reach here");
    }

    @Test(expected = IllegalStateException.class)
    public void itShouldNotAllowToCreateACombustionEngineWithInvalidFuelTypeDiesel() {

        sut = createEngine(FuelType.DIESEL);

        fail("it shouldn't reach here");

    }

    //private test helpers
    private Engine createEngine(FuelType fuelType) {
        return new SteamEngine(fuelType);
    }
}