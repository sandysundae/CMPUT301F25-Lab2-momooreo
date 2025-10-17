package com.example.listycity;
/**
 * This is a class that defines a City.
 */
public class City implements Comparable {
    /**
     * This is a string that holds the city's name
     */
    private String city;
    /**
     * This is a string that holds the city's province
     */
    private String province;

    /**
     * This is a constructor that makes a city using a given city name and province name
     * @param city
     *  This is a proposed city
     * @param province
     *  This is the province of the proposed city
     */
    City(String city, String province){
        this.city = city;
        this.province = province;
    }

    /**
     * this is a function that returns the city's name
     * @return
     *  Returns the city's name
     */
    String getCityName(){
        return this.city;
    }

    /**
     * this is a function that returns the name of the province of a city
     * @return
     *  Return's the city's province
     */
    String getProvinceName(){
        return this.province;
    }
    /**
     * This is the overridden function for the compareTo function from Comparable, which this class implements
     * @param o
     *  the object to be compared.
     * @return
     *  returns the comparison between two city's names
     */
    @Override
    public int compareTo(Object o) {
        City city = (City) o;
        return this.city.compareTo(city.getCityName()); // this.city refers to the city name
    }
}
