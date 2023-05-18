package com.mfp.mobile.gui.pages.common.diary.customDashboard;

public enum CustomDashboardItem {
    CALORIE_FOCUS("CaloriesRem"),
    MACRONUTRIENT_FOCUS("MacrosRem"),
    HEART_HEALTHY("HeartHealthy"),
    LOW_CARB("LowCarb"),
    CUSTOM("CustomSummary");

    private final String itemId;

    CustomDashboardItem(String itemId) {
        this.itemId = itemId;
    }

    public String getItemId() {
        return itemId;
    }
}
