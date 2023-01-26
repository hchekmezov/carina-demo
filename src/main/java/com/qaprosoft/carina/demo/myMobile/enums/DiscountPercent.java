package com.qaprosoft.carina.demo.myMobile.enums;

public enum DiscountPercent {
    THREE_PERCENT("3%"),
    TWENTY_PERCENT("20%"),
    THIRTY_FIVE_PERCENT("35%"),
    THIRTY_NINE_PERCENT("39%"),
    FIFTY_TWO_PERCENT("52"),
    SIXTY_PERCENT("60%"),
    SEVENTY_PERCENT("70%"),
    EIGHTY_PERCENT("80%"),
    NINETY_PERCENT("90%");

    private final String discountPercent;


    DiscountPercent(String discountPercent) {
        this.discountPercent = discountPercent;
    }

    public String getDiscountPercentStringValue() {
        return discountPercent;
    }
}
