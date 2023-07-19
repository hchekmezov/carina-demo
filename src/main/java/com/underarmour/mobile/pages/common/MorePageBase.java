package com.underarmour.mobile.pages.common;

import com.qaprosoft.carina.core.gui.AbstractPage;
import org.openqa.selenium.WebDriver;

public abstract class MorePageBase extends AbstractPage {
    public MorePageBase(WebDriver driver) {
        super(driver);
    }

    public abstract boolean isOpened();

    public abstract CreateAccOrLoginPageBase clickLoginButton();

    public abstract boolean isUserLoggedIn();
}
