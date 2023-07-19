package com.mfp.mobile.gui.pages.ios;

import com.mfp.mobile.gui.pages.common.ForgotPasswordPageBase;
import com.mfp.mobile.gui.pages.common.LogInPageBase;
import com.zebrunner.carina.utils.exception.NotImplementedException;
import com.zebrunner.carina.utils.factory.DeviceType;
import org.openqa.selenium.WebDriver;

@DeviceType(pageType = DeviceType.Type.IOS_PHONE, parentClass = ForgotPasswordPageBase.class)
public class ForgotPasswordPage extends ForgotPasswordPageBase {
    public ForgotPasswordPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isOpened() {
        throw new NotImplementedException();
    }

    @Override
    public void typeEmail(String email) {
        throw new NotImplementedException();
    }

    @Override
    public void clickSubmitButton() {
        throw new NotImplementedException();
    }

    @Override
    public boolean isConfirmationMessagePanelDisplayed() {
        throw new NotImplementedException();
    }

    @Override
    public LogInPageBase clickConfirmationMessagePanelOkButton() {
        throw new NotImplementedException();
    }
}
