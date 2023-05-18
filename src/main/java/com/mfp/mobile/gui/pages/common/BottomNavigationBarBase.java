package com.mfp.mobile.gui.pages.common;

import com.qaprosoft.carina.core.gui.AbstractPage;
import com.qaprosoft.carina.core.gui.AbstractUIObject;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;

public abstract class BottomNavigationBarBase extends AbstractUIObject {
    public BottomNavigationBarBase(WebDriver driver) {
        super(driver);
    }

    public BottomNavigationBarBase(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public abstract AbstractPage clickBottomNavBarButton(BottomNavigationBarItem item);

    public abstract boolean isBottomNavBarButtonClickable(BottomNavigationBarItem item);

    public abstract boolean isBottomNavBarPresent();
}
