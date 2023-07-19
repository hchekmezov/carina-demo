package com.underarmour.mobile.pages.common.categories;

public enum SortVariant {
    NOW_TRENDING("Now Trending"),
    BEST_SELLERS("Best Sellers"),
    PRICE_LOW_TO_HIGH("Price (Low - High)"),
    PRICE_HIGH_TO_LOW("Price (High - Low)"),
    TOP_RATED("Top Rated"),
    NEWEST("Newest");

    private final String id;

    SortVariant(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }
}
