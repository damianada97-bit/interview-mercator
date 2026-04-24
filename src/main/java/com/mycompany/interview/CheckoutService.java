
package com.mycompany.interview;


import java.util.stream.Collectors;
import java.util.List;
import java.util.Map;


public class CheckoutService {


    enum Product {
        APPLE(60L, 2L, 1L),
        ORANGE(25L, 3L, 2L);

        private final Long price;
        private final Long groupSize;
        private final Long payFor;

        Product(Long price, Long groupSize, Long payFor) {
            this.price = price;
            this.groupSize = groupSize;
            this.payFor = payFor;

        }

        public Long getPrice() {
            return price;
        }

        public Long getPayFor() {
            return payFor;
        }

        public Long getGroupSize() {
            return groupSize;
        }

        public static Product from(String name) { //takes from enum
            return Product.valueOf(name.toUpperCase());
        }
    }

    // Generic offer method
    private Long calculateOffer(Long count, Long price, Long groupSize, Long payFor) {
        Long payable = (count / groupSize) * payFor + (count % groupSize);
        return payable * price;
    }

    public Long checkout(List<String> items) {

        // Count products
        Map<Product, Long> counts = items.stream()
                .map(Product::from)
                .collect(Collectors.groupingBy(p -> p, Collectors.counting()));
        //this method operates on Long not int value, productCount-> how many times is value in the list,
        // Longs are better overall in enterpise applications

        Long total = 0L;

        for (var entry : counts.entrySet()) {
            Product product = entry.getKey();
            Long count = entry.getValue();
            total += calculateOffer(count, product.getPrice(), product.getGroupSize(), product.getPayFor());
        }

        return total;
    }
}



    // zrobic mape ktora bedzie brala fruit+price+offer
    // stworzenie optymalizacji listy dla potencjalnych nowych produktow/ofert bez hardkodowania w metodzie
    // bez dziwnych operacji w jednym jest co 2 w drugim co 3



    

