package com.cpal.dao;

import com.cpal.vo.Type;

import java.util.ArrayList;
import java.util.List;

public class TaxDAO {

    public List<Type> getStates() {
        return returnAllStates();
    }

    private static List<Type> returnAllStates() {
        List<Type> types = new ArrayList<>();
        types.add(new Type("Alabama", "AL"));
        types.add(new Type("Alaska", "AK"));
        types.add(new Type("Arizona", "AZ"));
        types.add(new Type("Arkansas", "AR"));
        types.add(new Type("California", "CA"));
        types.add(new Type("Colorado", "CO"));
        types.add(new Type("Connecticut", "CT"));
        types.add(new Type("Delaware", "DE"));
        types.add(new Type("Florida", "FL"));
        types.add(new Type("Georgia", "GA"));
        types.add(new Type("Hawaii", "HI"));
        types.add(new Type("Idaho", "ID"));
        types.add(new Type("Illinois", "IL"));
        types.add(new Type("Indiana", "IN"));
        types.add(new Type("Iowa", "IA"));
        types.add(new Type("Kansas", "KS"));
        types.add(new Type("Kentucky", "KY"));
        types.add(new Type("Louisiana", "LA"));
        types.add(new Type("Maine", "ME"));
        types.add(new Type("Maryland", "MD"));
        types.add(new Type("Massachusetts", "MA"));
        types.add(new Type("Michigan", "MI"));
        types.add(new Type("Minnesota", "MN"));
        types.add(new Type("Mississippi", "MS"));
        types.add(new Type("Missouri", "MO"));
        types.add(new Type("Montana", "MT"));
        types.add(new Type("Nebraska", "NE"));
        types.add(new Type("Nevada", "NV"));
        types.add(new Type("New Hampshire", "NH"));
        types.add(new Type("New Jersey", "NJ"));
        types.add(new Type("New Mexico", "NM"));
        types.add(new Type("New York", "NY"));
        types.add(new Type("North Carolina", "NC"));
        types.add(new Type("North Dakota", "ND"));
        types.add(new Type("Ohio", "OH"));
        types.add(new Type("Oklahoma", "OK"));
        types.add(new Type("Oregon", "OR"));
        types.add(new Type("Pennsylvania", "PA"));
        types.add(new Type("Rhode Island", "RI"));
        types.add(new Type("South Carolina", "SC"));
        types.add(new Type("South Dakota", "SD"));
        types.add(new Type("Tennessee", "TN"));
        types.add(new Type("Texas", "TX"));
        types.add(new Type("Utah", "UT"));
        types.add(new Type("Vermont", "VT"));
        types.add(new Type("Virginia", "VA"));
        types.add(new Type("Washington", "WA"));
        types.add(new Type("West Virginia", "WV"));
        types.add(new Type("Wisconsin", "WI"));
        types.add(new Type("Wyoming", "WY"));

        return types;
    }
}
