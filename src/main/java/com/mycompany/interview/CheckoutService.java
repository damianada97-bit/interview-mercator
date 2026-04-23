
package com.mycompany.interview;

import java.util.List;

public class CheckoutService {

    private static final int APPLE_PRICE = 60; //2
    private static final int ORANGE_PRICE = 25;

    public int checkout(List<String> items) {
        int appleCount = 0; //1
        int orangeCount = 0;

        for (String item : items) {
            if (item.equalsIgnoreCase("Apple")) {
                appleCount++;
            } else if (item.equalsIgnoreCase("Orange")) {
                orangeCount++;
            }
        }

        return calculateApples(appleCount) + calculateOranges(orangeCount);
    }

    private int calculateApples(int count) {
        int payable = (count / 2) + (count % 2);
        return payable * APPLE_PRICE;
    }

    private int calculateOranges(int count) {
        int payable = (count / 3) * 2 + (count % 3);
        return payable * ORANGE_PRICE;
    }
}

    

