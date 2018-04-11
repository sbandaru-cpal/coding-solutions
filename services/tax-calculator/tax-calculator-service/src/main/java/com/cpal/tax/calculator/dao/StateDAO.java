package com.cpal.tax.calculator.dao;

import com.cpal.tax.calculator.vo.TypeData;

import java.util.ArrayList;
import java.util.List;

public class StateDAO {

    public List<TypeData> findAllStates() {
        return getAllStates();
    }

    private static List<TypeData> getAllStates() {
        List<TypeData> typeData = new ArrayList<>();
        typeData.add(new TypeData("Alabama", "AL"));
        typeData.add(new TypeData("Alaska", "AK"));
        typeData.add(new TypeData("Arizona", "AZ"));
        typeData.add(new TypeData("Arkansas", "AR"));
        typeData.add(new TypeData("California", "CA"));
        typeData.add(new TypeData("Colorado", "CO"));
        typeData.add(new TypeData("Connecticut", "CT"));
        typeData.add(new TypeData("Delaware", "DE"));
        typeData.add(new TypeData("Florida", "FL"));
        typeData.add(new TypeData("Georgia", "GA"));
        typeData.add(new TypeData("Hawaii", "HI"));
        typeData.add(new TypeData("Idaho", "ID"));
        typeData.add(new TypeData("Illinois", "IL"));
        typeData.add(new TypeData("Indiana", "IN"));
        typeData.add(new TypeData("Iowa", "IA"));
        typeData.add(new TypeData("Kansas", "KS"));
        typeData.add(new TypeData("Kentucky", "KY"));
        typeData.add(new TypeData("Louisiana", "LA"));
        typeData.add(new TypeData("Maine", "ME"));
        typeData.add(new TypeData("Maryland", "MD"));
        typeData.add(new TypeData("Massachusetts", "MA"));
        typeData.add(new TypeData("Michigan", "MI"));
        typeData.add(new TypeData("Minnesota", "MN"));
        typeData.add(new TypeData("Mississippi", "MS"));
        typeData.add(new TypeData("Missouri", "MO"));
        typeData.add(new TypeData("Montana", "MT"));
        typeData.add(new TypeData("Nebraska", "NE"));
        typeData.add(new TypeData("Nevada", "NV"));
        typeData.add(new TypeData("New Hampshire", "NH"));
        typeData.add(new TypeData("New Jersey", "NJ"));
        typeData.add(new TypeData("New Mexico", "NM"));
        typeData.add(new TypeData("New York", "NY"));
        typeData.add(new TypeData("North Carolina", "NC"));
        typeData.add(new TypeData("North Dakota", "ND"));
        typeData.add(new TypeData("Ohio", "OH"));
        typeData.add(new TypeData("Oklahoma", "OK"));
        typeData.add(new TypeData("Oregon", "OR"));
        typeData.add(new TypeData("Pennsylvania", "PA"));
        typeData.add(new TypeData("Rhode Island", "RI"));
        typeData.add(new TypeData("South Carolina", "SC"));
        typeData.add(new TypeData("South Dakota", "SD"));
        typeData.add(new TypeData("Tennessee", "TN"));
        typeData.add(new TypeData("Texas", "TX"));
        typeData.add(new TypeData("Utah", "UT"));
        typeData.add(new TypeData("Vermont", "VT"));
        typeData.add(new TypeData("Virginia", "VA"));
        typeData.add(new TypeData("Washington", "WA"));
        typeData.add(new TypeData("West Virginia", "WV"));
        typeData.add(new TypeData("Wisconsin", "WI"));
        typeData.add(new TypeData("Wyoming", "WY"));

        return typeData;
    }
}
