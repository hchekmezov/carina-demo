package com.underarmour.mobile.pages.common;

import com.qaprosoft.carina.core.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.testng.asserts.SoftAssert;

public abstract class SearchPageBase extends AbstractPage {
    public SearchPageBase(WebDriver driver) {
        super(driver);
    }

    public abstract boolean isOpened();

    public abstract void searchByName(String name);

    public abstract boolean searchResultContainsExpectedString(String expectedString);

    public abstract ProductPageBase openProduct(String productName);

    public abstract float getPrice(String productName);

    public abstract ProductPageBase openFirstProduct();
}
