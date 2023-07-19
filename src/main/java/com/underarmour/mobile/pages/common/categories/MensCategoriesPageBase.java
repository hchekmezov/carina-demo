package com.underarmour.mobile.pages.common.categories;

import com.qaprosoft.carina.core.gui.AbstractPage;
import org.openqa.selenium.WebDriver;

public abstract class MensCategoriesPageBase extends AbstractPage {
    public MensCategoriesPageBase(WebDriver driver) {
        super(driver);
    }

    public abstract boolean isOpened();

    public abstract AbstractPage chooseVariant(MensCategoriesVariant variant);
}
