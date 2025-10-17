package com.example.listycity;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * This is a class that keeps a list of city objects
 */
public class CityList {
    private List<City> cities = new ArrayList<>();
    /**
     * This adds a city to the list if the city does not exist
     * @param city
     * This is a candidate city to add
     */
    public void add(City city) {
        if (cities.contains(city)) {
            throw new IllegalArgumentException();
        }
        cities.add(city);
    }
    /**
     * This returns a sorted list of cities
     * @return
     * Return the sorted list
     */
    public List<City> getCities() {
        List<City> list = cities;
        Collections.sort(list);
        return list;
    }

    /**
     * This returns true or false depending on whether a proposed city is in the CityList
     * @param city
     *  the proposed city
     * @return
     *  returns true or false
     */
    public Boolean hasCity(City city){
        return this.cities.contains(city);
    }

    /**
     * This deletes a proposed city from the CityList, or throws an exception if the city is not in the CityList
     * @param city
     *  the proposed city
     */
    public void delete(City city){
        if (this.hasCity(city)){
            this.cities.remove(city);
        }
        else {
            throw new IllegalArgumentException();
        }
    }

    /**
     * This gives the length of the CityList
     * @return
     *  returns an int, the length of the CityList
     */
    public int countCities(){
        return this.cities.size();
    }
}
