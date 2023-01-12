package com.qaprosoft.carina.demo.myMobile.common;

import com.qaprosoft.carina.core.gui.AbstractPage;
import org.openqa.selenium.WebDriver;

public abstract class LoginPageBase extends AbstractPage {
    public LoginPageBase(WebDriver driver) {
        super(driver);
    }

    public abstract WebViewPageBase openWebViewPageByClickSignUpBtn();

    public abstract boolean isNameFieldPresent();

    public abstract boolean isPasswordFieldPresent();

    public abstract boolean isMaleRadioPresent();

    public abstract boolean isFemaleRadioPresent();

    public abstract boolean isPrivacyCheckboxPresent();

    public abstract boolean isFemaleRadioUnchecked();

    public abstract boolean isMaleRadioUnchecked();

    public abstract boolean isPrivacyCheckboxUnchecked();

    public abstract boolean isSignUpBtnDisabled();

    public abstract boolean isTypedCorrectName(String name);

    public abstract boolean isTypedCorrectPassword(String password);

    public abstract void typeName(String name);

    public abstract void typePassword(String password);

    public abstract void checkMailRadioButton();

    public abstract void checkPrivacyCheckbox();
}
