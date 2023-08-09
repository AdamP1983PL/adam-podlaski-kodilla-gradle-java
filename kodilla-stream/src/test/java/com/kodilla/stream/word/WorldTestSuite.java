package com.kodilla.stream.word;

import com.kodilla.stream.world.Continent;
import com.kodilla.stream.world.Country;
import com.kodilla.stream.world.World;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class WorldTestSuite {

    @Test
    void testGetPeopleQuantity(){
        //given
        Country Poland = new Country("Poland", new BigDecimal("38000000"));
        Country Germany = new Country("Germany", new BigDecimal("82000000"));
        Country France = new Country("France", new BigDecimal("65000000"));

        Country India = new Country("India", new BigDecimal("1350000000"));
        Country China = new Country("China", new BigDecimal("1420000000"));
        Country Pakistan = new Country("Pakistan", new BigDecimal("201000000"));

        Country Nigeria = new Country("Nigeria", new BigDecimal("196000000"));
        Country Uganda = new Country("Uganda", new BigDecimal("44000000"));
        Country Madagascar = new Country("Madagascar", new BigDecimal("26000000"));

        Continent europe = new Continent("Europe");
        europe.addCountry(Poland);
        europe.addCountry(Germany);
        europe.addCountry(France);

        Continent asia = new Continent("Asia");
        asia.addCountry(India);
        asia.addCountry(China);
        asia.addCountry(Pakistan);

        Continent africa = new Continent("Africa");
        africa.addCountry(Nigeria);
        africa.addCountry(Uganda);
        africa.addCountry(Madagascar);

        World world = new World();
        world.addContinent(europe);
        world.addContinent(asia);
        world.addContinent(africa);

        //when
        BigDecimal allPeople = world.getPeopleQuantity();
        BigDecimal expectedValue = new BigDecimal("3422000000");

        //then
        assertEquals(expectedValue, allPeople);




    }
}
