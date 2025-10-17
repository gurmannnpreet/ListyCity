package com.example.listycity;

/**
 * Represents a City with a name and its corresponding province.
 */
public class City implements Comparable {
    private String city;
    private String province;

    /**
     * Constructs a City object with the specified name and province.
     * @param city The name of the city.
     * @param province The name of the province.
     */
    City(String city, String province) {
        this.city = city;
        this.province = province;
    }

    /**
     * Retrieves the name of the city.
     * @return The name of the city.
     */
    String getCityName() {
        return this.city;
    }

    /**
     * Retrieves the name of the province.
     * @return The name of the province.
     */
    String getProvinceName() {
        return this.province;
    }

    /**
     * Compares this city to another city based on their names.
     * @param o The other city to compare to.
     * @return A negative integer, zero, or a positive integer as this city's name
     *         is less than, equal to, or greater than the specified city's name.
     */
    @Override
    public int compareTo(Object o) {
        City city = (City) o;
        return this.city.compareTo(city.getCityName()); // this.city refers to the city name
    }
}
