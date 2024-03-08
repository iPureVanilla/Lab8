package com.example.lab8;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;


//import org.junit.Before;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class CustomListTest {

    private CustomList list;
    private City mockCity(){
        return new City("Edmonton", "Alberta");
    }
    /**
     * create a mocklist for my citylist
     * @return CustomList
     */
    public CustomList MockCityList(){
        list = new CustomList(null,new ArrayList<>());
        return list;
    }
    /**
     * get the size of the list
     * increase the list by adding a new city
     * check if our current size matches the initial size plus one
     */
    @Test
    public void addCityTest(){
        list = MockCityList();
        int listSize = list.getCount();
        list.addCity(new City("Estevan","SK"));
        assertEquals(list.getCount(), listSize + 1);
    }
    @Test
    public void hasCityTest(){
        list = MockCityList();
        assertTrue(list.hasCity(mockCity()));
    }
    @Test
    void testDeleteCity(){
        list = MockCityList(); // compare mockcity (edmonton ab to first city in list), and result is 0 meaning it's same(assertequals)
        City city = new City("Vancouver", "British Columbia");
        assertThrows(IllegalArgumentException.class, ()->{
            list.deleteCity(city);
        });
    }
    @Test
    void testCountCity(){
        list = MockCityList();
        City city = new City("Vancouver", "British Columbia");
        list.add(city);
        assertEquals(2, list.countCities());
    }

}
