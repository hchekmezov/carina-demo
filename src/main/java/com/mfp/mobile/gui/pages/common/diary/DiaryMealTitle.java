package com.mfp.mobile.gui.pages.common.diary;

public enum DiaryMealTitle {
    BREAKFAST("Breakfast"),
    LUNCH("Lunch"),
    DINNER("Dinner"),
    SNACKS("Snacks");

    private final String title;

    DiaryMealTitle(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }
}
