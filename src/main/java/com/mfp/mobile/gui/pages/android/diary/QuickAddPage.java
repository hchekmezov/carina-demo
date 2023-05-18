package com.mfp.mobile.gui.pages.android.diary;

import com.mfp.mobile.gui.pages.common.diary.QuickAddPageBase;
import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.utils.factory.DeviceType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = QuickAddPageBase.class)
public class QuickAddPage extends QuickAddPageBase {
    public QuickAddPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "com.myfitnesspal.android:id/tvQuickCalories")
    private ExtendedWebElement caloriesValue;

    @FindBy(id = "com.myfitnesspal.android:id/tvQuickFat")
    private ExtendedWebElement fatValue;

    @FindBy(id = "com.myfitnesspal.android:id/tvQuickCarbs")
    private ExtendedWebElement carbohydratesValue;

    @FindBy(id = "com.myfitnesspal.android:id/tvQuickProtein")
    private ExtendedWebElement proteinValue;

    @FindBy(xpath = "//android.widget.Button[@content-desc='NO THANKS']")
    private ExtendedWebElement dontTrackTimeButton;

    @Override
    public void typeFat(int value) {
        fatValue.type(String.valueOf(value));
    }

    @Override
    public void typeCarbohydrates(int value) {
        carbohydratesValue.type(String.valueOf(value));
    }

    @Override
    public void typeProtein(int value) {
        proteinValue.type(String.valueOf(value));
    }

    @Override
    public void typeNutrients(int fat, int carbohydrates, int protein) {
        typeFat(fat);
        typeCarbohydrates(carbohydrates);
        typeProtein(protein);
    }

    @Override
    public int getCaloriesIntValue() {
        return Integer.parseInt(caloriesValue.getText());
    }

    @Override
    public boolean isOpened() {
        if (dontTrackTimeButton.isElementPresent()) {
            dontTrackTimeButton.click();
        }
        return caloriesValue.isElementPresent()
                && fatValue.isElementPresent();
    }

}
