package com.lloydsbanking.widget;

import com.lloydsbanking.engine.InternalCombustionEngine;
import com.lloydsbanking.fuel.FuelType;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;


public class WidgetMachineUnitTest {

    private Widget sut;

    @Test
    public void itShouldCalculateTheExpectedValue(){

        //test fixtures
        InternalCombustionEngine engine = new InternalCombustionEngine(FuelType.PETROL);
        engine.fill(50);

        //given
        sut = new WidgetMachine(engine);

        //when
        double totalCost = sut.produceWidgets(2);

        //then
        assertThat(totalCost).isEqualTo(9.0);
    }

}