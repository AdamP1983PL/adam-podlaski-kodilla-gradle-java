package com.kodilla.stream.sand;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SandStorageTestSuite {

    @Test
    void testGetSandBeansQuantity(){
        //given
        List<SandStorage> continents = new ArrayList<>();
        continents.add(new Europe());
        continents.add(new Asia());
        continents.add(new Africa());

        //when
        BigDecimal totalSand = BigDecimal.ZERO;
        for(SandStorage continent : continents){
            totalSand = totalSand.add(continent.getSandsBeansQuantity());
        }

        //then
        BigDecimal expectedSand = new BigDecimal("211111110903703703670");
        assertEquals(expectedSand, totalSand);
    }

    @Test
    void testGetSandBeansQuantityWithReduce(){
        //given
        List<SandStorage> continents = new ArrayList<>();
        continents.add(new Europe());
        continents.add(new Asia());
        continents.add(new Africa());

        //When
        BigDecimal totalSand = continents.stream()                              // [1]
                .map(s -> s.getSandsBeansQuantity())                              // [2]
                .reduce(BigDecimal.ZERO, (sum, current) -> sum = sum.add(current));  // [3]

        //Then
        BigDecimal expectedSand = new BigDecimal("211111110903703703670");      // [4]
        assertEquals(expectedSand, totalSand);
    }


}

