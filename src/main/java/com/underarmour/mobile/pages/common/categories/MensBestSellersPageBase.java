package com.underarmour.mobile.pages.common.categories;

import com.qaprosoft.carina.core.gui.AbstractPage;
import org.openqa.selenium.WebDriver;

public abstract class MensBestSellersPageBase extends AbstractPage {
    public MensBestSellersPageBase(WebDriver driver) {
        super(driver);
    }

    public abstract boolean isOpened();

    public abstract FilterPageBase clickFilterButton();

    public abstract boolean isProductsSortedProperly(SortVariant variant);
}
