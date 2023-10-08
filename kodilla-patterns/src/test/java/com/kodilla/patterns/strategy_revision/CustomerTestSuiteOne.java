package com.kodilla.patterns.strategy_revision;

import com.kodilla.strategy_revision.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CustomerTestSuiteOne {

    @Test
    void testDefaultInvestingStrategy(){
        // given
        CustomerOne steven = new IndividualCustomerOne("Steven Links");
        CustomerOne john = new IndividualYoungCustomerOne("John Hemerald");
        CustomerOne kodilla = new CorporateCustomerOne("Kodilla");

        // when
        String stevenShouldBuy = steven.predict();
        System.out.println("Steven should buy: " + stevenShouldBuy);
        String johnShouldBuy = john.predict();
        System.out.println("John should buy: " + johnShouldBuy);
        String kodillaShouldBuy = kodilla.predict();
        System.out.println("Kodilla should buy: " + kodillaShouldBuy);

        // then
        assertEquals("predictWhatToBuy() from ConservativePredictorOne", stevenShouldBuy);
        assertEquals("predictWhatToBuy() from AggressivePredictorOne", johnShouldBuy);
        assertEquals("predictWhatToBuy() from BalancedPredictorOne", kodillaShouldBuy);
    }

    @Test
    void testIndividualTestStrategy(){
        // given
        CustomerOne steven = new IndividualCustomerOne("Steven LInks");

        // when
        String stevenShouldBuy = steven.predict();
        System.out.println("Steven should buy: " + stevenShouldBuy);
        steven.setBuyingPredictorOne(new AggressivePredictorOne());
        stevenShouldBuy = steven.predict();
        System.out.println("Steven should buy: " + stevenShouldBuy);

        // then
        assertEquals("predictWhatToBuy() from AggressivePredictorOne", stevenShouldBuy);
    }
}
