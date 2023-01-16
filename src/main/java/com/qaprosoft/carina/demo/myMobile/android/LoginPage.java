package com.qaprosoft.carina.demo.myMobile.android;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.demo.myMobile.android.additional.CheckableItem;
import com.qaprosoft.carina.demo.myMobile.android.additional.LoginFormItem;
import com.qaprosoft.carina.demo.myMobile.android.enums.LoginFields;
import com.qaprosoft.carina.demo.myMobile.android.enums.Sex;
import com.qaprosoft.carina.demo.myMobile.common.LoginPageBase;
import com.qaprosoft.carina.demo.myMobile.common.WebViewPageBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import java.util.Arrays;
import java.util.List;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = LoginPageBase.class)
public class LoginPage extends LoginPageBase {

    private final String name = "Login Page";

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

    private final List<LoginFormItem> loginFormItems = Arrays.asList(
            new LoginFormItem(driver, nameField),
            new LoginFormItem(driver, passwordField),
            new LoginFormItem(driver, radioMale),
            new LoginFormItem(driver, radioFemale),
            new LoginFormItem(driver, privacyCheckbox),
            new LoginFormItem(driver, signUpButton));

    private final List<CheckableItem> checkableItems = Arrays.asList(
            new CheckableItem(driver, radioFemale),
            new CheckableItem(driver, radioMale),
            new CheckableItem(driver, privacyCheckbox));

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
    public boolean isOpened() {
        return nameField.isElementPresent() && radioFemale.isElementPresent();
    }

    @Override
    public String getTextInField(LoginFields loginField) {
        if (loginField.equals(LoginFields.NAME)) {
            return nameField.getText();
        } else {
            return passwordField.getText();
        }
    }

    @Override
    public List<LoginFormItem> getLoginFormItems() {
        return loginFormItems;
    }

    @Override
    public List<CheckableItem> getCheckableItems() {
        return checkableItems;
    }

    @Override
    public boolean isSexChecked(Sex sex) {
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
    public String getName() {
        return name;
    }

    @Override
    public boolean isSignUpButtonEnabled() {
        return Boolean.parseBoolean(signUpButton.getAttribute("enabled"));
    }

    @Override
    public WebViewPageBase clickSignUpButton() {
        signUpButton.click();
        return initPage(getDriver(), WebViewPageBase.class);
    }
}

