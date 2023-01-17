package com.qaprosoft.carina.demo.myMobile.common;

import com.qaprosoft.carina.core.gui.AbstractPage;
import com.qaprosoft.carina.demo.myMobile.android.enums.LoginField;
import com.qaprosoft.carina.demo.myMobile.android.enums.Sex;
import org.openqa.selenium.WebDriver;

public abstract class LoginPageBase extends AbstractPage {

    public LoginPageBase(WebDriver driver) {
        super(driver);
    }

    public abstract WebViewPageBase clickSignUpButton();

    public abstract boolean isOpened();

    public abstract boolean isSexChecked(Sex sex);

    public abstract boolean isPrivacyCheckboxChecked();

    public abstract boolean isSignUpButtonEnabled();

    public abstract boolean isSexElementPresent(Sex sex);

    public abstract boolean isLoginFieldPresent(LoginField loginField);

    public abstract boolean isPrivacyCheckboxPresent();

    public abstract String getTextInField(LoginField loginField);

    public abstract void typeName(String name);

    public abstract void typePassword(String password);

    public abstract void checkSexRadioButton(Sex sex);

    public abstract void checkPrivacyCheckbox();
}
