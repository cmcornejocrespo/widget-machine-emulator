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
    public void itShouldReturnTheExpectedValueWhenUsingUsingInternalCombustionEngineAndPetrolFuel(){

        //test fixtures
        Engine engine = new InternalCombustionEngine(FuelType.PETROL);
        engine.fill(50);

        //given
        sut = new WidgetMachine(engine);

        //when
        double totalCost = sut.produceWidgets(2);

        //then
        assertThat(totalCost).isEqualTo(9.0);
    }

    @Test
    public void itShouldReturnTheExpectedValueWhenUsingInternalCombustionEngineAndDieselFuel(){

        //test fixtures
        Engine engine = new InternalCombustionEngine(FuelType.DIESEL);
        engine.fill(100);

        //given
        sut = new WidgetMachine(engine);

        //when
        double totalCost = sut.produceWidgets(50);

        //then
        assertThat(totalCost).isEqualTo(84.0);
    }

    @Test
    public void itShouldReturnTheExpectedValueWhenUsingSteamEngineAndWoodFuel(){

        //test fixtures
        Engine engine = new SteamEngine(FuelType.WOOD);
        engine.fill(25);

        //given
        sut = new WidgetMachine(engine);

        //when
        double totalCost = sut.produceWidgets(30);

        //then
        assertThat(totalCost).isEqualTo(65.25);
    }

    @Test
    public void itShouldReturnTheExpectedValueWhenUsingSteamEngineAndCoalFuel(){

        //test fixtures
        Engine engine = new SteamEngine(FuelType.COAL);
        engine.fill(75);

        //given
        sut = new WidgetMachine(engine);

        //when
        double totalCost = sut.produceWidgets(80);

        //then
        assertThat(totalCost).isEqualTo(226.0);
    }
}