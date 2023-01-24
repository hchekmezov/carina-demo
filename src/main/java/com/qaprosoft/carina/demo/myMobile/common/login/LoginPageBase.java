package com.qaprosoft.carina.demo.myMobile.common.login;

import com.qaprosoft.carina.core.gui.AbstractPage;
import com.qaprosoft.carina.demo.myMobile.android.enums.LoginField;
import com.qaprosoft.carina.demo.myMobile.android.enums.Sex;
import com.qaprosoft.carina.demo.myMobile.common.sideMenu.WebViewPageBase;
import org.openqa.selenium.WebDriver;

import javax.activation.UnsupportedDataTypeException;

public abstract class LoginPageBase extends AbstractPage {

    public LoginPageBase(WebDriver driver) {
        super(driver);
    }

    public abstract WebViewPageBase clickSignUpButton();

    public abstract boolean isOpened();

    public abstract boolean isSexRadioButtonChecked(Sex sex) throws UnsupportedDataTypeException;

    public abstract boolean isPrivacyCheckboxChecked();

    public abstract boolean isSignUpButtonEnabled();

    public abstract boolean isSexRadioButtonPresent(Sex sex) throws UnsupportedDataTypeException;

    public abstract boolean isLoginFieldPresent(LoginField loginField);

    public abstract boolean isPrivacyCheckboxPresent();

    public abstract String getTextInField(LoginField loginField);

    public abstract void typeName(String name);

    public abstract void typePassword(String password);

    public abstract void checkSexRadioButton(Sex sex) throws UnsupportedDataTypeException;

    public abstract void checkPrivacyCheckbox();
}
