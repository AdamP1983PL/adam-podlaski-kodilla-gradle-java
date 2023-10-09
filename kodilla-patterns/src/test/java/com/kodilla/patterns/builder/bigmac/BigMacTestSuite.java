package com.kodilla.patterns.builder.bigmac;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BigMacTestSuite {

    @Test
    void testBigMacNew(){
        // given
        BigMac masterChef = new BigMac.BigMacBuilder()
                .bun("heavily baked")
                .burgers(3)
                .sauce("mayonnaise")
                .sauce("ketchup")
                .ingredient("onion")
                .ingredient("bacon")
                .ingredient("cheese")
                .ingredient("garlic")
                .ingredient("cucumber")
                .ingredient("fries")
                .build();

        System.out.println(masterChef);
        
        // when
        int howManySauces = masterChef.getSauces().size();
        int howManyIngredients = masterChef.getIngredients().size();

        // then
        assertEquals(2, howManySauces);
        assertEquals(6, howManyIngredients);
    }
}
