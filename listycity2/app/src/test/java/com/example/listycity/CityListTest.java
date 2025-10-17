package com.example.listycity;
import org.junit.jupiter.api.Assertions;
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
        City city = new City("Edmonton", "Northwest Territories");
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
        //
        City firstCity = cityList.getCities().get(0);
        assertTrue(cityList.hasCity(firstCity));
        City city = new City("Winnipeg", "Manitoba");
        cityList.add(city);
        assertTrue(cityList.hasCity(firstCity));
        assertTrue(cityList.hasCity(city));
        assertTrue(cityList.getCities().contains(city));

    }
    @Test
    void testDelete() {
        CityList cityList = mockCityList();
        //
        City city = new City("Vancouver", "British Columbia");
        City firstCity = cityList.getCities().get(0);
        cityList.add(city);
        cityList.delete(firstCity);
        assertFalse(cityList.hasCity(firstCity));
        cityList.delete(city);
        assertFalse(cityList.hasCity(city));
    }
    @Test
    void testDeleteException() {
        CityList cityList = mockCityList();
        City city = new City("Edmonton", "Northwest Territories");
        cityList.add(city);
        assertThrows(IllegalArgumentException.class, () -> {
            cityList.add(city);
        });
    }
    @Test
    void testCountCities() {
        CityList cityList = mockCityList();
        City city = new City ("Calgary","Alberta");
        assertEquals(1, cityList.countCities());
        cityList.add(city);
        assertEquals(2, cityList.countCities());
        cityList.delete(city);
        assertEquals(1, cityList.countCities());
    }
}
