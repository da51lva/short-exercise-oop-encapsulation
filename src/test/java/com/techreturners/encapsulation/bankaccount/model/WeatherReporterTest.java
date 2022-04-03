package com.techreturners.encapsulation.bankaccount.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.text.MessageFormat;

import static com.github.stefanbirkner.systemlambda.SystemLambda.tapSystemOut;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class WeatherReporterTest {

    private static final String LONDON_WEATHER = "🌦";
    private static final String CALIFORNIA_WEATHER = "\uD83C\uDF05🌅";
    private static final String CAPE_TOWN_WEATHER = "🌤";
    private static final String ELSEWHERE_WEATHER = "\uD83D\uDD06";

    private static final String HOT_TEMP_MESSAGE = "It's too hot \uD83E\uDD75🥵!";
    private static final String COLD_TEMP_MESSAGE = "It's too cold 🥶\uD83E\uDD76!";
    private static final String PERFECT_TEMP_MESSAGE = "Ahhh...it's just right 😊!";


    @Test
    public void testLondonPrefectTemperature() throws Exception {

        String systemOutputString = tapSystemOut(() -> {
            WeatherReporter wr = new WeatherReporter("London", 20);
            wr.printWeatherReport();
        });

        assertEquals(MessageFormat.format(
                "I am in {0} and it is {1}. {2}. The temperature in Fahrenheit is {3}.", "London",
                LONDON_WEATHER, PERFECT_TEMP_MESSAGE, 68), systemOutputString.trim());
    }

    @Test
    public void testCaliforniaPrefectTemperature() throws Exception {
        String systemOutputString = tapSystemOut(() -> {
            WeatherReporter wr = new WeatherReporter("California", 20);
            wr.printWeatherReport();
        });

        assertEquals(MessageFormat.format(
                "I am in {0} and it is {1}. {2}. The temperature in Fahrenheit is {3}.", "California",
                CALIFORNIA_WEATHER, PERFECT_TEMP_MESSAGE, 68), systemOutputString.trim());
    }

    @Test
    public void testCapeTownPrefectTemperature() throws Exception {
        String systemOutputString = tapSystemOut(() -> {
            WeatherReporter wr = new WeatherReporter("Cape Town", 20);
            wr.printWeatherReport();
        });

        assertEquals(MessageFormat.format(
                "I am in {0} and it is {1}. {2}. The temperature in Fahrenheit is {3}.", "Cape Town",
                CAPE_TOWN_WEATHER, PERFECT_TEMP_MESSAGE, 68), systemOutputString.trim());
    }

    public void testElseWherePerfectTemperature() throws Exception {
        String systemOutputString = tapSystemOut(() -> {
            WeatherReporter wr = new WeatherReporter("Paris", 20);
            wr.printWeatherReport();
        });

        assertEquals(MessageFormat.format(
                "I am in {0} and it is {1}. {2}. The temperature in Fahrenheit is {3}.", "Paris",
                ELSEWHERE_WEATHER, PERFECT_TEMP_MESSAGE, 68), systemOutputString.trim());

        systemOutputString = tapSystemOut(() -> {
            WeatherReporter wr = new WeatherReporter("Dublin", 20);
            wr.printWeatherReport();
        });

        assertEquals(MessageFormat.format(
                "I am in {0} and it is {1}. {2}. The temperature in Fahrenheit is {3}.", "Dublin",
                ELSEWHERE_WEATHER, PERFECT_TEMP_MESSAGE, 68), systemOutputString.trim());

        systemOutputString = tapSystemOut(() -> {
            WeatherReporter wr = new WeatherReporter("", 20);
            wr.printWeatherReport();
        });

        assertEquals(MessageFormat.format(
                "I am in {0} and it is {1}. {2}. The temperature in Fahrenheit is {3}.", "",
                ELSEWHERE_WEATHER, PERFECT_TEMP_MESSAGE, 68), systemOutputString.trim());
    }

    @Test
    public void testLondonHotTemperature() throws Exception {
        String systemOutputString = tapSystemOut(() -> {
            WeatherReporter wr = new WeatherReporter("London", 31);
            wr.printWeatherReport();
        });

        assertEquals(MessageFormat.format(
                "I am in {0} and it is {1}. {2}. The temperature in Fahrenheit is {3}.", "London",
                LONDON_WEATHER, HOT_TEMP_MESSAGE, 87.8), systemOutputString.trim());

        systemOutputString = tapSystemOut(() -> {
            WeatherReporter wr = new WeatherReporter("London", 30.000001);
            wr.printWeatherReport();
        });

        assertEquals(MessageFormat.format(
                "I am in {0} and it is {1}. {2}. The temperature in Fahrenheit is {3}.", "London",
                LONDON_WEATHER, HOT_TEMP_MESSAGE, 86.0000018), systemOutputString.trim());

        systemOutputString = tapSystemOut(() -> {
            WeatherReporter wr = new WeatherReporter("London", 100);
            wr.printWeatherReport();
        });

        assertEquals(MessageFormat.format(
                "I am in {0} and it is {1}. {2}. The temperature in Fahrenheit is {3}.", "London",
                LONDON_WEATHER, HOT_TEMP_MESSAGE, 212), systemOutputString.trim());
    }

    @Test
    public void testLondonColdTemperature() throws Exception {
        String systemOutputString = tapSystemOut(() -> {
            WeatherReporter wr = new WeatherReporter("London", 9);
            wr.printWeatherReport();
        });

        assertEquals(MessageFormat.format(
                "I am in {0} and it is {1}. {2}. The temperature in Fahrenheit is {3}.", "London",
                LONDON_WEATHER, COLD_TEMP_MESSAGE, 48.2), systemOutputString.trim());

        systemOutputString = tapSystemOut(() -> {
            WeatherReporter wr = new WeatherReporter("London", 9.999999);
            wr.printWeatherReport();
        });

        assertEquals(MessageFormat.format(
                "I am in {0} and it is {1}. {2}. The temperature in Fahrenheit is {3}.", "London",
                LONDON_WEATHER, COLD_TEMP_MESSAGE, 49.9999982), systemOutputString.trim());

        systemOutputString = tapSystemOut(() -> {
            WeatherReporter wr = new WeatherReporter("London", -10);
            wr.printWeatherReport();
        });

        assertEquals(MessageFormat.format(
                "I am in {0} and it is {1}. {2}. The temperature in Fahrenheit is {3}.", "London",
                LONDON_WEATHER, COLD_TEMP_MESSAGE, 14), systemOutputString.trim());
    }

    @Test
    public void testPerfectTemperatureEdgeCases() throws Exception {
        String systemOutputString = tapSystemOut(() -> {
            WeatherReporter wr = new WeatherReporter("London", 30);
            wr.printWeatherReport();
        });

        assertEquals(MessageFormat.format(
                "I am in {0} and it is {1}. {2}. The temperature in Fahrenheit is {3}.", "London",
                LONDON_WEATHER, PERFECT_TEMP_MESSAGE, 86), systemOutputString.trim());

        systemOutputString = tapSystemOut(() -> {
            WeatherReporter wr = new WeatherReporter("London", 10);
            wr.printWeatherReport();
        });

        assertEquals(MessageFormat.format(
                "I am in {0} and it is {1}. {2}. The temperature in Fahrenheit is {3}.", "London",
                LONDON_WEATHER, PERFECT_TEMP_MESSAGE, 50), systemOutputString.trim());
    }
}