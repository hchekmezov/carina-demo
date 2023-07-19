package com.underarmour.mobile.pages.common.categories;

import com.qaprosoft.carina.core.gui.AbstractPage;
import org.openqa.selenium.WebDriver;

public abstract class FilterPageBase extends AbstractPage {
    public FilterPageBase(WebDriver driver) {
        super(driver);
    }

    public abstract boolean isOpened();

    public abstract void chooseFilter(SortVariant variant);

    public abstract MensBestSellersPageBase clickShowResultsButton();
}
