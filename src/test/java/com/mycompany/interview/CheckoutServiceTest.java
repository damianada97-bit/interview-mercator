

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.mycompany.interview;

import org.junit.jupiter.api.Test;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CheckoutServiceTest {

    private final CheckoutService checkoutService = new CheckoutService();

    @Test
    void shouldApplyAppleOffer() {
        assertEquals(60, checkoutService.checkout(List.of("Apple", "Apple")));
    }

    @Test
    void shouldApplyOrangeOffer() {
        assertEquals(50, checkoutService.checkout(List.of("Orange", "Orange", "Orange")));
    }

    @Test
    void shouldApplyBothOffers() {
        assertEquals(110, checkoutService.checkout(
                List.of("Apple", "Apple", "Orange", "Orange", "Orange")));
    }

    @Test
    void mixedExampleFromSpec() {
        assertEquals(145, checkoutService.checkout(
                List.of("Apple", "Apple", "Orange", "Apple")));
    }
}