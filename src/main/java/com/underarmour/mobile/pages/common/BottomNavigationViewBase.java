package com.underarmour.mobile.pages.common;

import com.qaprosoft.carina.core.gui.AbstractPage;
import com.qaprosoft.carina.core.gui.AbstractUIObject;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;

public abstract class BottomNavigationViewBase extends AbstractUIObject {
    public BottomNavigationViewBase(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public abstract boolean isPresent();

    public abstract boolean isItemClickable(BottomNavigationViewItem item);

    public abstract AbstractPage openPage(BottomNavigationViewItem item);
}
