
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
    @Test
    void emptyCartShouldReturnZero() {
        assertEquals(0, checkoutService.checkout(List.of()));
    }
}