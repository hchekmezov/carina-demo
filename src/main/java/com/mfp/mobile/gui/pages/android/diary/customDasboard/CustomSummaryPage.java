package com.mfp.mobile.gui.pages.android.diary.customDasboard;

import com.mfp.mobile.gui.pages.common.IConstant;
import com.mfp.mobile.gui.pages.common.diary.customDashboard.CustomSummaryNutrient;
import com.mfp.mobile.gui.pages.common.diary.customDashboard.CustomSummaryPageBase;
import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.utils.mobile.IMobileUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = CustomSummaryPageBase.class)
public class CustomSummaryPage extends CustomSummaryPageBase implements IMobileUtils {
    public CustomSummaryPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//android.view.ViewGroup[@resource-id='com.myfitnesspal.android:id/toolbar']" +
            "/android.widget.TextView")
    private ExtendedWebElement pageTitle;

    @FindBy(id = "com.myfitnesspal.android:id/tvCustomSummaryHeader")
    private ExtendedWebElement textHeader;

    @FindBy(id = "com.myfitnesspal.android:id/cb%s")
    private ExtendedWebElement nutrientById;

    @FindBy(xpath = "//android.widget.Button[@content-desc='Done']")
    private ExtendedWebElement saveButton;

    @FindBy(id = "com.myfitnesspal.android:id/tvNutrientSelected")
    private ExtendedWebElement selectedNutrientInfo;

    @FindBy(id = "com.myfitnesspal.android:id/progress_spinner")
    private ExtendedWebElement progressSpinner;

    @Override
    public boolean isOpened() {
        return pageTitle.isElementPresent()
                && pageTitle.getText().equals(IConstant.CUSTOM_SUMMARY)
                && textHeader.isElementPresent();
    }

    @Override
    public boolean isNutrientPresent(CustomSummaryNutrient customSummaryNutrient) {
        return swipe(nutrientById.format(customSummaryNutrient.getNutrientId()), Direction.VERTICAL, 3, 500);
    }

    @Override
    public boolean isNutrientChecked(CustomSummaryNutrient customSummaryNutrient) {
        Assert.assertTrue(isNutrientPresent(customSummaryNutrient),
                String.format("[Custom Summary Page] Nutrient %s is not present!", customSummaryNutrient));
        return nutrientById.format(customSummaryNutrient.getNutrientId()).isChecked();
    }

    @Override
    public boolean isSaveButtonPresent() {
        return saveButton.isElementPresent();
    }

    @Override
    public boolean isSaveButtonEnabled() {
        return Boolean.parseBoolean(saveButton.getAttribute("enabled"));
    }

    @Override
    public boolean isSelectedNutrientInfoPresent() {
        return swipe(selectedNutrientInfo, Direction.DOWN, 3, 500);
    }

    @Override
    public boolean isSpinnerRoundingOver() {
        return waitUntil(ExpectedConditions.invisibilityOfElementLocated(progressSpinner.getBy()),
                IConstant.THIRTY_SECONDS);
    }

    @Override
    public void checkNutrient(CustomSummaryNutrient customSummaryNutrient) {
        Assert.assertTrue(isNutrientPresent(customSummaryNutrient),
                String.format("[Custom Summary Page] Nutrient %s is not present!", customSummaryNutrient));
        nutrientById.format(customSummaryNutrient.getNutrientId()).check();
    }

    @Override
    public void uncheckNutrient(CustomSummaryNutrient customSummaryNutrient) {
        Assert.assertTrue(isNutrientPresent(customSummaryNutrient),
                String.format("[Custom Summary Page] Nutrient %s is not present!", customSummaryNutrient));
        nutrientById.format(customSummaryNutrient.getNutrientId()).uncheck();
    }

    @Override
    public String getSelectedNutrientInfoText() {
        Assert.assertTrue(isSelectedNutrientInfoPresent(),
                "[Custom Summary Page] Selected Nutrient Info is not present!");
        return selectedNutrientInfo.getText();
    }
}
