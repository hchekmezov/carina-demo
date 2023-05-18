package com.mfp.mobile.gui.pages.common;

import com.qaprosoft.carina.core.gui.AbstractPage;
import org.openqa.selenium.WebDriver;

public abstract class LogInPageBase extends AbstractPage {
    public LogInPageBase(WebDriver driver) {
        super(driver);
    }

    public abstract void typeEmailAndPassword(String email, String password);

    public abstract DashboardPageBase getDashboardPage();

    public abstract boolean isOpened();

    public abstract boolean isLogInButtonEnabled();

}
