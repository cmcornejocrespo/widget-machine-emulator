package com.lloydsbanking.widget;

import com.lloydsbanking.engine.Engine;
import com.lloydsbanking.engine.InternalCombustionEngine;
import com.lloydsbanking.engine.SteamEngine;
import com.lloydsbanking.fuel.FuelType;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;


public class WidgetMachineUnitTest {

    private Widget sut;

    @Test
    public void itShouldReturnTheExpectedValueWhenUsingUsingInternalCombustionEngineAndPetrolFuel() {

        //test fixtures
        Engine engine = createCombustionEngineAndFill(FuelType.PETROL, 50);

        //given
        sut = new WidgetMachine(engine);

        //when
        double totalCost = sut.produceWidgets(2);

        //then
        assertThat(totalCost).isEqualTo(9.0);
    }

    @Test
    public void itShouldReturnTheExpectedValueWhenUsingInternalCombustionEngineAndDieselFuel() {

        //test fixtures
        Engine engine = createCombustionEngineAndFill(FuelType.DIESEL, 100);

        //given
        sut = new WidgetMachine(engine);

        //when
        double totalCost = sut.produceWidgets(50);

        //then
        assertThat(totalCost).isEqualTo(84.0);
    }

    @Test
    public void itShouldReturnTheExpectedValueWhenUsingSteamEngineAndWoodFuel() {

        //test fixtures
        Engine engine = createSteamEngineAndFill(FuelType.WOOD, 25);

        //given
        sut = new WidgetMachine(engine);

        //when
        double totalCost = sut.produceWidgets(30);

        //then
        assertThat(totalCost).isEqualTo(65.25);
    }

    @Test
    public void itShouldReturnTheExpectedValueWhenUsingSteamEngineAndCoalFuel() {

        //test fixtures
        Engine engine = createSteamEngineAndFill(FuelType.COAL, 75);

        //given
        sut = new WidgetMachine(engine);

        //when
        double totalCost = sut.produceWidgets(80);

        //then
        assertThat(totalCost).isEqualTo(226.0);
    }

    //private test helpers
    private Engine createCombustionEngineAndFill(final FuelType petrol, final int fuelLevel) {

        Engine engine = new InternalCombustionEngine(petrol);

        engine.fill(fuelLevel);
        return engine;
    }

    private Engine createSteamEngineAndFill(final FuelType petrol, final int fuelLevel) {

        Engine engine = new SteamEngine(petrol);

        engine.fill(fuelLevel);
        return engine;
    }
}