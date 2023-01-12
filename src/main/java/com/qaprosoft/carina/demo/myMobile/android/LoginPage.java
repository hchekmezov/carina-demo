package com.qaprosoft.carina.demo.myMobile.android;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.demo.myMobile.common.LoginPageBase;
import com.qaprosoft.carina.demo.myMobile.common.WebViewPageBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = LoginPageBase.class)
public class LoginPage extends LoginPageBase {

    @FindBy(id = "com.solvd.carinademoapplication:id/name")
    protected ExtendedWebElement nameField;

    @FindBy(id = "com.solvd.carinademoapplication:id/password")
    protected ExtendedWebElement passwordField;

    @FindBy(id = "com.solvd.carinademoapplication:id/radio_female")
    protected ExtendedWebElement radioFemale;

    @FindBy(id = "com.solvd.carinademoapplication:id/radio_male")
    protected ExtendedWebElement radioMale;

    @FindBy(id = "com.solvd.carinademoapplication:id/checkbox")
    protected ExtendedWebElement privateCheckbox;

    @FindBy(id = "com.solvd.carinademoapplication:id/login_button")
    protected ExtendedWebElement signUpBtn;

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
    public void checkMailRadioButton() {
        radioMale.click();
    }

    @Override
    public void checkPrivacyCheckbox() {
        privateCheckbox.click();
    }

    @Override
    public boolean isPageOpened() {
        return signUpBtn.isElementPresent();
    }

    @Override
    public boolean isTypedCorrectName(String name) {
        return nameField.getAttribute("text").equals(name);
    }

    @Override
    public boolean isTypedCorrectPassword(String password) {
        return passwordField.getAttribute("text").equals(password);
    }

    @Override
    public boolean isNameFieldPresent() {
        return nameField.isElementPresent();
    }

    @Override
    public boolean isPasswordFieldPresent() {
        return passwordField.isElementPresent();
    }

    @Override
    public boolean isMaleRadioPresent() {
        return radioMale.isElementPresent();
    }

    @Override
    public boolean isFemaleRadioPresent() {
        return radioFemale.isElementPresent();
    }

    @Override
    public boolean isPrivacyCheckboxPresent() {
        return privateCheckbox.isElementPresent();
    }

    @Override
    public boolean isFemaleRadioUnchecked() {
        return !radioFemale.isChecked();
    }

    @Override
    public boolean isMaleRadioUnchecked() {
        return !radioMale.isChecked();
    }

    @Override
    public boolean isPrivacyCheckboxUnchecked() {
        return !privateCheckbox.isChecked();
    }

    @Override
    public boolean isSignUpBtnDisabled() {
        return signUpBtn.getAttribute("enabled").equalsIgnoreCase("false");
    }

    @Override
    public WebViewPageBase openWebViewPageByClickSignUpBtn() {
        signUpBtn.click();
        return initPage(getDriver(), WebViewPageBase.class);
    }
}
