package com.mfp.mobile.gui.pages.android;

import com.mfp.mobile.gui.pages.common.ConfirmationMessagePanelBase;
import com.mfp.mobile.gui.pages.common.LogInPageBase;
import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.utils.factory.DeviceType;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = ConfirmationMessagePanelBase.class)
public class ConfirmationMessagePanel extends ConfirmationMessagePanelBase {
    public ConfirmationMessagePanel(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    @FindBy(id = "com.myfitnesspal.android:id/alertTitle")
    private ExtendedWebElement confirmationMessagePanelTitle;

    @FindBy(id = "android:id/button1")
    private ExtendedWebElement confirmationMessagePanelOkButton;

    @Override
    public boolean isPresent() {
        return confirmationMessagePanelOkButton.isElementPresent()
                && confirmationMessagePanelTitle.isElementPresent()
                && confirmationMessagePanelTitle.getText().equals("Your Info Has Been Sent");
    }

    @Override
    public LogInPageBase clickOkButton() {
        confirmationMessagePanelOkButton.click();
        return initPage(driver, LogInPageBase.class);
    }
}
