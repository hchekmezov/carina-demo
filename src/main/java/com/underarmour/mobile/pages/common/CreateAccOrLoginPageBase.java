package com.underarmour.mobile.pages.common;

import com.qaprosoft.carina.core.gui.AbstractPage;
import org.openqa.selenium.WebDriver;

public abstract class CreateAccOrLoginPageBase extends AbstractPage {
    public CreateAccOrLoginPageBase(WebDriver driver) {
        super(driver);
    }

    public abstract boolean isOpened();

    public abstract void selectLayout(CreateAccOrLoginLayout createOrLoginLayout);

    public abstract AbstractPage login(String email, String password, Class<? extends AbstractPage> baseClass);
}
