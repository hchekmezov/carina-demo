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
    public void checkRadioElement(String elementName) {
        if (elementName.equalsIgnoreCase("radio_female")) {
            radioFemale.check();
        } else if (elementName.equalsIgnoreCase("radio_male")) {
            radioMale.check();
        } else {
            privacyCheckbox.check();
        }
    }

    @Override
    public boolean isOpened() {
        return isElementPresent("name") && isElementPresent("radio_male");
    }

    @Override
    public String getTextInField(String fieldName) {
        String text = "text";
        if (fieldName.equalsIgnoreCase("password")) {
            return passwordField.getAttribute(text);
        } else if (fieldName.equalsIgnoreCase("name")) {
            return nameField.getAttribute(text);
        } else {
            return null;
        }
    }

    @Override
    public boolean isElementPresent(String elementName) {
        switch (elementName) {
            case "name":
                return nameField.isElementPresent();
            case "password":
                return passwordField.isElementPresent();
            case "radio_male":
                return radioMale.isElementPresent();
            case "radio_female":
                return radioFemale.isElementPresent();
            case "checkbox":
                return privacyCheckbox.isElementPresent();
            default:
                return false;
        }
    }


    @Override
    public boolean isElementUnchecked(String elementName) {
        if (elementName.equalsIgnoreCase("radio_male")) {
            return !radioMale.isChecked(); // there is no .isUnchecked()-method
        } else if (elementName.equalsIgnoreCase("radio_female")) {
            return !radioFemale.isChecked();
        } else if (elementName.equalsIgnoreCase("checkbox")) {
            return !privacyCheckbox.isChecked();
        } else {
            return false;
        }
    }

    @Override
    public boolean isElementsChecked(String elementName) {
        if (elementName.equalsIgnoreCase("radio_male")) {
            return radioMale.isChecked();
        } else if (elementName.equalsIgnoreCase("radio_female")) {
            return radioFemale.isChecked();
        } else if (elementName.equalsIgnoreCase("checkbox")) {
            return privacyCheckbox.isChecked();
        } else {
            return false;
        }
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
