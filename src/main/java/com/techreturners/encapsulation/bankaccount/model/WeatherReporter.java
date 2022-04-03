package com.techreturners.encapsulation.bankaccount.model;

import java.text.MessageFormat;

public class WeatherReporter {

    private static final double TEMP_CONVERSION_CONSTANT_1 = 1.8; // I can't think of better names for these constants
    private static final double TEMP_CONVERSION_CONSTANT_2 = 32;  // Used for converting Celsius to Fahrenheit

    private static final int HOT_TEMP = 30;
    private static final int COLD_TEMP = 10;

    private String location;
    private double temperatureInC;

    public WeatherReporter(String location, double temperatureInC) {
        this.location = location;
        this.temperatureInC = temperatureInC;
    }

    public void printWeatherReport() {
        String weatherReportMessage = MessageFormat.format(
                "I am in {0} and it is {1}. {2}. The temperature in Fahrenheit is {3}.", location,
                checkLocationWeather(), checkTemperature(), celsiusToFahrenheit(temperatureInC));
        System.out.println(weatherReportMessage);
    }

    private double celsiusToFahrenheit(double temperatureInC) {
        return TEMP_CONVERSION_CONSTANT_1 * temperatureInC + TEMP_CONVERSION_CONSTANT_2;
    }

    private String checkLocationWeather() {
        if (location.equals("London")) {

            return "🌦";

        } else if (location.equals("California")) {

            return "\uD83C\uDF05🌅";

        } else if (location.equals("Cape Town")) {

            return "🌤";

        }
        return "🔆\uD83D\uDD06";
    }

    private String checkTemperature() {
        if (temperatureInC > HOT_TEMP) {

            return "It's too hot \uD83E\uDD75🥵!";

        } else if (temperatureInC < COLD_TEMP) {

            return "It's too cold 🥶\uD83E\uDD76!";

        }
        return "Ahhh...it's just right 😊!";
    }

}
