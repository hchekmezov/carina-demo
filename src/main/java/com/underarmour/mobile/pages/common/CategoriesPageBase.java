package com.underarmour.mobile.pages.common;

import com.qaprosoft.carina.core.gui.AbstractPage;
import com.underarmour.mobile.pages.common.categories.CategoriesVariant;
import org.openqa.selenium.WebDriver;

public abstract class CategoriesPageBase extends AbstractPage {
    public CategoriesPageBase(WebDriver driver) {
        super(driver);
    }

    public abstract boolean isOpened();

    public abstract AbstractPage chooseVariant(CategoriesVariant variant);
}
