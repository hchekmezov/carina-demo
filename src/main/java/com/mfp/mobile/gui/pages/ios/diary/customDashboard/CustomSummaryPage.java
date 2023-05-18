package com.mfp.mobile.gui.pages.ios.diary.customDashboard;

import com.mfp.mobile.gui.pages.common.diary.customDashboard.CustomSummaryNutrient;
import com.mfp.mobile.gui.pages.common.diary.customDashboard.CustomSummaryPageBase;
import com.zebrunner.carina.utils.exception.NotImplementedException;
import com.zebrunner.carina.utils.factory.DeviceType;
import org.openqa.selenium.WebDriver;

@DeviceType(pageType = DeviceType.Type.IOS_PHONE, parentClass = CustomSummaryPageBase.class)
public class CustomSummaryPage extends CustomSummaryPageBase {
    public CustomSummaryPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isOpened() {
        throw new NotImplementedException();
    }

    @Override
    public boolean isNutrientChecked(CustomSummaryNutrient customSummaryNutrient) {
        throw new NotImplementedException();
    }

    @Override
    public boolean isNutrientPresent(CustomSummaryNutrient customSummaryNutrient) {
        throw new NotImplementedException();
    }

    @Override
    public boolean isSaveButtonPresent() {
        throw new NotImplementedException();
    }

    @Override
    public boolean isSaveButtonEnabled() {
        throw new NotImplementedException();
    }

    @Override
    public boolean isSelectedNutrientInfoPresent() {
        throw new NotImplementedException();
    }

    @Override
    public void checkNutrient(CustomSummaryNutrient customSummaryNutrient) {
        throw new NotImplementedException();
    }

    @Override
    public void uncheckNutrient(CustomSummaryNutrient customSummaryNutrient) {
        throw new NotImplementedException();
    }

    @Override
    public String getSelectedNutrientInfoText() {
        throw new NotImplementedException();
    }

    @Override
    public boolean isSpinnerRoundingOver() {
        throw new NotImplementedException();
    }
}
