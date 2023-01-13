package com.qaprosoft.carina.demo.myMobile.common;

import com.qaprosoft.carina.core.gui.AbstractPage;
import org.openqa.selenium.WebDriver;

public abstract class LoginPageBase extends AbstractPage {
    public LoginPageBase(WebDriver driver) {
        super(driver);
    }

    public abstract WebViewPageBase clickSignUpButton();

    public abstract boolean isOpened();

    public abstract boolean isElementPresent(String elementName);

    public abstract boolean isElementUnchecked(String elementName);

    public abstract boolean isElementsChecked(String elementName);

    public abstract boolean isSignUpButtonEnabled();

    public abstract String getTextInField(String fieldName);

    public abstract void typeName(String name);

    public abstract void typePassword(String password);

    public abstract void checkRadioElement(String elementName);

}
