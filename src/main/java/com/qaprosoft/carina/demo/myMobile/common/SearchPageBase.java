package com.qaprosoft.carina.demo.myMobile.common;

import com.qaprosoft.carina.core.gui.AbstractPage;
import org.openqa.selenium.WebDriver;

public abstract class SearchPageBase extends AbstractPage {

    public SearchPageBase(WebDriver driver) {
        super(driver);
    }

    public abstract boolean isSearchBarPresent();

    public abstract boolean isSearchFieldPresent();

    public abstract void clickSearchBar();

    public abstract boolean isOpened();

    public abstract void typeToSearchField(String product);

    public abstract String getSearchBarText();

    public abstract ProductPageBase openProductPage();
}
