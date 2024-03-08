package com.example.lab8;



import static org.junit.jupiter.api.Assertions.assertEquals;


import android.content.Context;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class CustomListTest {
    private CustomList list;
    /**
     * create a mocklist for my citylist
     * @return list
     */
    public CustomList MockCityList(){
        list = new CustomList(null,new ArrayList<>());
        return list;
    }
    /**
     * get the size of the list
     * increase the list by adding a new city
     * check if our current size matches the initial size
     plus one
     */
    @Test
    public void addCityTest(){
        list = MockCityList();
        int listSize = list.getCount();
        list.addCity(new City("Estevan", "SK"));
        assertEquals(list.getCount(),listSize + 1);
    }
    @Test
    public void testHasCity() {
        CustomList customList = new CustomList(getContext(), getCities());
        Assertions.assertTrue(customList.hasCity(new City("City1", "Province1")));
        Assertions.assertFalse(customList.hasCity(new City("City5", "Province5")));
    }

    @Test
    public void testDeleteCity() {
        CustomList customList = new CustomList(getContext(), getCities());
        Assertions.assertTrue(customList.hasCity(new City("City2", "Province2")));
        customList.deleteCity(new City("City2", "Province2"));
        Assertions.assertFalse(customList.hasCity(new City("City2", "Province2")));
    }

    @Test
    public void testCountCities() {
        CustomList customList = new CustomList(getContext(), getCities());
        assertEquals(4, customList.countCities());
        customList.addCity(new City("City5", "Province5"));
        assertEquals(5, customList.countCities());
    }

    // Helper methods to provide sample data for testing
    private Context getContext() {
        return null; // Provide implementation if necessary
    }

    private ArrayList<City> getCities() {
        ArrayList<City> cities = new ArrayList<>();
        cities.add(new City("City1", "Province1"));
        cities.add(new City("City2", "Province2"));
        cities.add(new City("City3", "Province3"));
        cities.add(new City("City4", "Province4"));
        return cities;
    }
}