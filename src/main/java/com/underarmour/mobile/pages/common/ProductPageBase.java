package com.underarmour.mobile.pages.common;

import com.qaprosoft.carina.core.gui.AbstractPage;
import com.zebrunner.carina.utils.android.IAndroidUtils;
import org.openqa.selenium.WebDriver;

public abstract class ProductPageBase extends AbstractPage {
    public ProductPageBase(WebDriver driver) {
        super(driver);
    }

    public abstract boolean isOpened();

    public abstract boolean isOpenedNeededProduct(String neededProductName);

    public abstract float getPrice();

    public abstract String getProductName();

    public abstract boolean clickAddToBagButton();

    public abstract SearchPageBase clickBackArrow();

    public abstract void clickFavoriteButton();
}
