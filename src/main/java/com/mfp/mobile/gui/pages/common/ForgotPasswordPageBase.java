package com.mfp.mobile.gui.pages.common;

import com.qaprosoft.carina.core.gui.AbstractPage;
import org.openqa.selenium.WebDriver;

public abstract class ForgotPasswordPageBase extends AbstractPage {
    public ForgotPasswordPageBase(WebDriver driver) {
        super(driver);
    }

    public abstract boolean isOpened();

    public abstract void typeEmail(String email);

    public abstract void clickSubmitButton();

    public abstract boolean isConfirmationMessagePanelDisplayed();

    public abstract LogInPageBase clickConfirmationMessagePanelOkButton();
}
