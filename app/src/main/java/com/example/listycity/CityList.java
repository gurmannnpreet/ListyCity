package com.example.listycity;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * This is a class that manages a list of City objects.
 */
public class CityList {
    private List<City> cities = new ArrayList<>();

    public CityList() {
    }

    /**
     * Adds a city to the list if it does not already exist.
     * @param city The city to be added.
     * @throws IllegalArgumentException if the city already exists in the list.
     */
    public void add(City city) {
        if (cities.contains(city)) {
            throw new IllegalArgumentException();
        }
        cities.add(city);
    }

    /**
     * Checks if a city exists in the list.
     * @param city The city to check.
     * @return true if the city exists, false otherwise.
     */
    public boolean hasCity(City city) {
        return cities.contains(city);
    }

    /**
     * Removes a city from the list if it exists.
     * @param city The city to be removed.
     * @throws IllegalArgumentException if the city does not exist in the list.
     */
    public void delete(City city) {
        if (!cities.contains(city)) {
            throw new IllegalArgumentException();
        }
        cities.remove(city);
    }

    /**
     * Counts the number of cities in the list.
     * @return The total number of cities in the list.
     */
    public int countCities() {
        return cities.size();
    }

    /**
     * Retrieves a sorted list of cities.
     * @return A sorted list of cities.
     */
    public List<City> getCities() {
        List<City> list = cities;
        Collections.sort(list);
        return list;
    }
}
