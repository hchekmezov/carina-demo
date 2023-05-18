package com.mfp.mobile.gui.pages.common.diary.customDashboard;

import com.qaprosoft.carina.core.gui.AbstractPage;
import org.openqa.selenium.WebDriver;

public abstract class CustomSummaryPageBase extends AbstractPage {
    public CustomSummaryPageBase(WebDriver driver) {
        super(driver);
    }

    public abstract boolean isOpened();

    public abstract boolean isNutrientChecked(CustomSummaryNutrient customSummaryNutrient);

    public abstract boolean isNutrientPresent(CustomSummaryNutrient customSummaryNutrient);

    public abstract boolean isSaveButtonPresent();

    public abstract boolean isSaveButtonEnabled();

    public abstract boolean isSelectedNutrientInfoPresent();

    public abstract boolean isSpinnerRoundingOver();

    public abstract void checkNutrient(CustomSummaryNutrient customSummaryNutrient);

    public abstract void uncheckNutrient(CustomSummaryNutrient customSummaryNutrient);

    public abstract String getSelectedNutrientInfoText();
}
