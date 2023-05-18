package com.mfp.mobile.gui.pages.common.diary.customDashboard;

public enum CustomSummaryNutrient {
    FAT("Fat"),
    SATURATED_FAT("SatFat"),
    POLYUNSATURATED_FAT("PolyFat"),
    MONOUNSATURATED_FAT("MonoFat"),
    TRANS_FAT("TransFat"),
    CHOLESTEROL("Cholesterol"),
    SODIUM("Sodium"),
    POTASSIUM("Potassium"),
    CARBOHYDRATES("Carbs"),
    FIBER("Fiber"),
    SUGAR("Sugar"),
    PROTEIN("Protein"),
    VITAMIN_A("VitaminA"),
    VITAMIN_C("VitaminC"),
    CALCIUM("Calcium"),
    IRON("Iron");

    private final String nutrientId;

    CustomSummaryNutrient(String nutrientId) {
        this.nutrientId = nutrientId;
    }

    public String getNutrientId() {
        return nutrientId;
    }
}
