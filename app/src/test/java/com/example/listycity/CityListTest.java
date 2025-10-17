package com.example.listycity;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
class CityListTest {
    private CityList mockCityList() {
        CityList cityList = new CityList();
        cityList.add(mockCity());
        return cityList;
    }

    private City mockCity() {
        return new City("Edmonton", "Alberta");
    }

    @Test
    void testAdd() {
        CityList cityList = mockCityList();
        assertEquals(1, cityList.getCities().size());
        City city = new City("Regina", "Saskatchewan");
        cityList.add(city);
        assertEquals(2, cityList.getCities().size());
        assertTrue(cityList.getCities().contains(city));
    }
    @Test
    void testAddException() {
        CityList cityList = mockCityList();
        City city = new City("Yellowknife", "Northwest Territories");
        cityList.add(city);
        assertThrows(IllegalArgumentException.class, () -> {
            cityList.add(city);
        });
    }
    @Test
    void testGetCities() {
        CityList cityList = mockCityList();
        // This line checks if the first city in the cityList (retrieved by cityList.getCities().get(0))
        // is the same as the city returned by mockCity()
        assertEquals(0, mockCity().compareTo(cityList.getCities().get(0)));
        // This pushes down the original city
        City city = new City("Charlottetown", "Prince Edward Island");
        cityList.add(city);
        // Now the original city should be at position 1
        assertEquals(0, city.compareTo(cityList.getCities().get(0)));
        assertEquals(0, mockCity().compareTo(cityList.getCities().get(1)));
    }

    @Test
    void testHasCity() {
        CityList cityList = mockCityList();
        City edmonton = mockCity();
        City regina = new City("Regina", "Saskatchewan");

        assertTrue(cityList.hasCity(edmonton));
        assertFalse(cityList.hasCity(regina));

        cityList.add(regina);
        assertTrue(cityList.hasCity(regina));
    }

    @Test
    void testDelete() {
        CityList cityList = mockCityList();
        City regina = new City("Regina", "Saskatchewan");
        cityList.add(regina);

        assertEquals(2, cityList.countCities());
        assertTrue(cityList.hasCity(regina));

        cityList.delete(regina);

        assertEquals(1, cityList.countCities());
        assertFalse(cityList.hasCity(regina));
        assertFalse(cityList.getCities().contains(regina));
    }

    @Test
    void testDeleteException() {
        CityList cityList = mockCityList();
        City notPresent = new City("Calgary", "Alberta");
        assertThrows(IllegalArgumentException.class, () -> cityList.delete(notPresent));
    }

    @Test
    void testCountCities() {
        CityList cityList = mockCityList();
        assertEquals(1, cityList.countCities());

        cityList.add(new City("Regina", "Saskatchewan"));
        cityList.add(new City("Toronto", "Ontario"));
        assertEquals(3, cityList.countCities());

        cityList.delete(new City("Toronto", "Ontario"));
        assertEquals(2, cityList.countCities());
    }
}