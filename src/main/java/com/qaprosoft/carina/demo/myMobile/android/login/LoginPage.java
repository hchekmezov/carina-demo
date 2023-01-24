package com.qaprosoft.carina.demo.myMobile.android.login;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.demo.myMobile.android.enums.Sex;
import com.qaprosoft.carina.demo.myMobile.android.enums.LoginField;
import com.qaprosoft.carina.demo.myMobile.common.login.LoginPageBase;
import com.qaprosoft.carina.demo.myMobile.common.sideMenu.WebViewPageBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import javax.activation.UnsupportedDataTypeException;

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

    /**
     *
     * @param sex a parameter of Sex Enum, Sex.OTHER unsupported
     */
    @Override
    public void checkSexRadioButton(Sex sex) throws UnsupportedDataTypeException {
        if (sex.equals(Sex.FEMALE)) {
            radioFemale.check();
        } else if (sex.equals(Sex.MALE)) {
            radioMale.check();
        } else {
            throw new UnsupportedDataTypeException("You can't use " + Sex.OTHER + " value here!");
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

    /**
     * Sex.OTHER = Sex.FEMALE in this method
     * @param sex a parameter of Sex Enum
     * @return true if sex radio button checked and false if not
     */
    @Override
    public boolean isSexRadioButtonChecked(Sex sex) throws UnsupportedDataTypeException {
        if (sex.equals(Sex.MALE)) {
            return radioMale.isChecked();
        } else if (sex.equals(Sex.FEMALE)) {
            return radioFemale.isChecked();
        } else {
            throw new UnsupportedDataTypeException("You can't use " + Sex.OTHER + " value here!");
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

    /**
     * Sex.OTHER = Sex.FEMALE in this method
     * @param sex a parameter of Sex Enum
     * @return true if sex radio button present and false if not
     */
    @Override
    public boolean isSexRadioButtonPresent(Sex sex) throws UnsupportedDataTypeException {
        if (sex.equals(Sex.MALE)) {
            return radioMale.isElementPresent();
        } else if (sex.equals(Sex.FEMALE)) {
            return radioFemale.isElementPresent();
        } else {
            throw new UnsupportedDataTypeException("You can't use " + Sex.OTHER + " value here!");
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

