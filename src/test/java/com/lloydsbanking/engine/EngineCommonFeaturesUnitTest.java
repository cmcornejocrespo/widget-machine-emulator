package com.lloydsbanking.engine;

import com.lloydsbanking.fuel.FuelType;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.fail;

public class EngineCommonFeaturesUnitTest {

    private Engine sut;

    @Test
    public void itShouldCreateAPetrolCombustionEngineWithValidValues() {

        //when
        sut = createEngine(FuelType.PETROL);

        //then
        assertThat(sut.getFuelType()).isEqualTo(FuelType.PETROL);
        assertThat(sut.isEmpty()).isTrue();
        assertThat(sut.getBatchSize()).isEqualTo(8);
        assertThat(sut.getFuelType().getValue()).isEqualTo(9.0);
        assertThat(sut.isRunning()).isFalse();

    }

    @Test
    public void itShouldCreateADieselCombustionEngineWithValidValues() {

        //when
        sut = createEngine(FuelType.DIESEL);

        //then
        assertThat(sut.getFuelType()).isEqualTo(FuelType.DIESEL);
        assertThat(sut.isEmpty()).isTrue();
        assertThat(sut.getBatchSize()).isEqualTo(8);
        assertThat(sut.getFuelType().getValue()).isEqualTo(12.0);
        assertThat(sut.isRunning()).isFalse();

    }

    @Test(expected = IllegalStateException.class)
    public void itShouldThrowExpectedExceptionGivenInvalidFuelType() {

        //when
        sut = createEngine(FuelType.COAL);
    }

    @Test
    public void itShouldAllowToFillThenEngineWhenIsEmpty() {

        //given
        Engine engine = createEngine(FuelType.DIESEL);

        //when
        engine.fill(50);

        //then
        assertThat(engine.getFuelLevel()).isEqualTo(50);

    }

    @Test
    public void itShouldNotAllowToFillTheDepositWhenIsFull() {

        //given
        Engine engine = createEngine(FuelType.DIESEL);

        //when
        engine.fill(150);

        //then
        assertThat(engine.getFuelLevel()).isEqualTo(100);

    }

    @Test
    public void itShouldNotAllowNegativeFilling() {

        //given
        Engine petrolEngine = createEngine(FuelType.PETROL);

        //when
        petrolEngine.fill(-1);

        //then
        assertThat(petrolEngine.getFuelLevel()).isEqualTo(0);

    }

    @Test(expected = IllegalStateException.class)
    public void itShouldNotAllowToStartTheEngineWhenIsEmpty() {

        //given
        Engine petrolEngine = createEngine(FuelType.PETROL);

        //when
        petrolEngine.start();

        fail("it shouldn't reach here");
    }

    @Test
    public void itShouldAllowToStartTheEngineWhenIsNotEmpty() {

        //given
        Engine petrolEngine = createEngine(FuelType.PETROL);
        petrolEngine.fill(25);

        //when
        petrolEngine.start();

        assertThat(petrolEngine.isRunning()).isTrue();

    }

    @Test
    public void itShouldAllowToStopTheEngineWhenIsRunning() {

        //given
        Engine petrolEngine = createEngine(FuelType.PETROL);
        petrolEngine.fill(25);
        petrolEngine.start();

        //when
        petrolEngine.stop();

        assertThat(petrolEngine.isRunning()).isFalse();

    }

    @Test(expected = IllegalStateException.class)
    public void itShouldNotAllowToStopTheEngineWhenIsNotRunning() {

        //given
        Engine petrolEngine = createEngine(FuelType.PETROL);

        //when
        petrolEngine.stop();

        fail("it shouldn't reach here");

    }

    //private test helpers
    private Engine createEngine(final FuelType fuelType) {
        return new InternalCombustionEngine(fuelType);
    }

}