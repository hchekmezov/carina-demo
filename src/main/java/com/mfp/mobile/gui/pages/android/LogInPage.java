package com.mfp.mobile.gui.pages.android;

import com.mfp.mobile.gui.pages.common.*;
import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.utils.factory.DeviceType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = LogInPageBase.class)
public class LogInPage extends LogInPageBase {
    public LogInPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//android.view.ViewGroup[@resource-id='com.myfitnesspal.android:id/toolbar']" +
            "/android.widget.TextView")
    private ExtendedWebElement title;

    @FindBy(id = "com.myfitnesspal.android:id/email_address_edit")
    private ExtendedWebElement emailField;

    @FindBy(id = "com.myfitnesspal.android:id/password_edit")
    private ExtendedWebElement passwordField;

    @FindBy(id = "com.myfitnesspal.android:id/forgot_password_button")
    private ExtendedWebElement forgotPasswordButton;

    @FindBy(id = "com.myfitnesspal.android:id/login_button")
    private ExtendedWebElement logInButton;

    @Override
    public void typeEmailAndPassword(String email, String password) {
        emailField.type(email);
        passwordField.type(password);
    }

    @Override
    public DashboardPageBase getDashboardPage() {
        logInButton.click();
        MFPCommonPageBase mfpCommonPage = initPage(getDriver(), MFPCommonPageBase.class);
        Assert.assertTrue(mfpCommonPage.waitUntilSpinnerRounding(),
                "[LogIn Page] Progress Spinner rounding too long, that means user is not logged in!");
        ExistingUserTutorialPageBase existingUserTutorialPage = initPage(getDriver(),
                ExistingUserTutorialPageBase.class);
        Assert.assertTrue(existingUserTutorialPage.isOpened(),
                "[Existing User Tutorial Page] Existing User Tutorial Page is not opened, that means" +
                        " user is not logged in!");
        return existingUserTutorialPage.clickCloseTutorialBoxButton();
    }

    @Override
    public boolean isOpened() {
        return emailField.isElementPresent()
                && passwordField.isElementPresent()
                && logInButton.isElementPresent();
    }

    @Override
    public boolean isLogInButtonEnabled() {
        return Boolean.parseBoolean(logInButton.getAttribute("enabled"));
    }

    @Override
    public ForgotPasswordPageBase clickForgotPasswordButton() {
        forgotPasswordButton.click();
        return initPage(driver, ForgotPasswordPageBase.class);
    }
}
