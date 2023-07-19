package com.mfp.mobile.gui.pages.android;

import com.mfp.mobile.gui.pages.common.ForgotPasswordPageBase;
import com.mfp.mobile.gui.pages.common.LogInPageBase;
import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.utils.factory.DeviceType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = ForgotPasswordPageBase.class)
public class ForgotPasswordPage extends ForgotPasswordPageBase {

    @FindBy(xpath = "//*[@resource-id='com.myfitnesspal.android:id/toolbar']" +
            "/android.widget.TextView[@text='Forgot Password']")
    private ExtendedWebElement title;

    @FindBy(id = "com.myfitnesspal.android:id/txtEmail")
    private ExtendedWebElement emailField;

    @FindBy(id = "com.myfitnesspal.android:id/btnDone")
    private ExtendedWebElement submitButton;


    @FindBy(id = "com.myfitnesspal.android:id/parentPanel")
    private ConfirmationMessagePanel confirmationMessagePanel;

    @Override
    public boolean isOpened() {
        return title.isElementPresent() && emailField.isElementPresent();
    }

    @Override
    public void typeEmail(String email) {
        emailField.type(email);
    }

    @Override
    public void clickSubmitButton() {
        submitButton.click();
    }

    @Override
    public boolean isConfirmationMessagePanelDisplayed() {
        return confirmationMessagePanel.isPresent();
    }

    @Override
    public LogInPageBase clickConfirmationMessagePanelOkButton() {
        return confirmationMessagePanel.clickOkButton();
    }

    public ForgotPasswordPage(WebDriver driver) {
        super(driver);
    }
}
