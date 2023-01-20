package com.qaprosoft.carina.demo.myMobile.android;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.demo.myMobile.android.enums.LoginField;
import com.qaprosoft.carina.demo.myMobile.android.enums.Sex;
import com.qaprosoft.carina.demo.myMobile.common.LoginPageBase;
import com.qaprosoft.carina.demo.myMobile.common.WebViewPageBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = LoginPageBase.class)
public class LoginPage extends LoginPageBase {

    @FindBy(id = "com.solvd.carinademoapplication:id/name")
    private ExtendedWebElement nameField;

    @FindBy(id = "com.solvd.carinademoapplication:id/password")
    private ExtendedWebElement passwordField;

    @FindBy(id = "com.solvd.carinademoapplication:id/radio_female")
    private ExtendedWebElement radioFemale;

    @FindBy(id = "com.solvd.carinademoapplication:id/radio_male")
    private ExtendedWebElement radioMale;

    @FindBy(id = "com.solvd.carinademoapplication:id/checkbox")
    private ExtendedWebElement privacyCheckbox;

    @FindBy(id = "com.solvd.carinademoapplication:id/login_button")
    private ExtendedWebElement signUpButton;

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public void typeName(String name) {
        nameField.type(name);
    }

    @Override
    public void typePassword(String password) {
        passwordField.type(password);
    }

    @Override
    public String getTextInField(LoginField loginField) {
        if (loginField.equals(LoginField.NAME)) {
            return nameField.getText();
        } else {
            return passwordField.getText();
        }
    }

    @Override
    public void checkSexRadioButton(Sex sex) {
        if (sex.equals(Sex.FEMALE)) {
            radioFemale.check();
        } else if (sex.equals(Sex.MALE)) {
            radioMale.check();
        }
    }

    @Override
    public void checkPrivacyCheckbox() {
        privacyCheckbox.check();
    }

    @Override
    public WebViewPageBase clickSignUpButton() {
        signUpButton.click();
        return initPage(getDriver(), WebViewPageBase.class);
    }

    @Override
    public boolean isOpened() {
        return nameField.isElementPresent() && radioFemale.isElementPresent();
    }

    @Override
    public boolean isSexRadioButtonChecked(Sex sex) {
        if (sex.equals(Sex.MALE)) {
            return radioMale.isChecked();
        } else {
            return radioFemale.isChecked();
        }
    }

    @Override
    public boolean isPrivacyCheckboxChecked() {
        return privacyCheckbox.isChecked();
    }

    @Override
    public boolean isSignUpButtonEnabled() {
        return Boolean.parseBoolean(signUpButton.getAttribute("enabled"));
    }

    @Override
    public boolean isSexRadioButtonPresent(Sex sex) {
        if (sex.equals(Sex.MALE)) {
            return radioMale.isElementPresent();
        } else {
            return radioFemale.isElementPresent();
        }
    }

    @Override
    public boolean isLoginFieldPresent(LoginField loginField) {
        if (loginField.equals(LoginField.NAME)) {
            return nameField.isElementPresent();
        } else {
            return passwordField.isElementPresent();
        }
    }

    @Override
    public boolean isPrivacyCheckboxPresent() {
        return privacyCheckbox.isElementPresent();
    }
}

