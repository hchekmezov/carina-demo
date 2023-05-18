package com.mfp.mobile.gui.pages.common.diary;

import com.qaprosoft.carina.core.gui.AbstractPage;
import org.openqa.selenium.WebDriver;

public abstract class QuickAddPageBase extends AbstractPage {
    public QuickAddPageBase(WebDriver driver) {
        super(driver);
    }

    public abstract void typeFat(int value);

    public abstract void typeCarbohydrates(int value);

    public abstract void typeProtein(int value);

    public abstract void typeNutrients(int fat, int carbohydrates, int protein);

    public abstract int getCaloriesIntValue();

    public abstract boolean isOpened();
}
