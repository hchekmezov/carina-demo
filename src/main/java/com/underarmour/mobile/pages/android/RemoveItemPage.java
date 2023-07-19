package com.underarmour.mobile.pages.android;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.underarmour.mobile.pages.common.BagPageBase;
import com.underarmour.mobile.pages.common.RemoveItemPageBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = RemoveItemPageBase.class)
public class RemoveItemPage extends RemoveItemPageBase {
    public RemoveItemPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "com.ua.shop:id/alertTitle")
    private ExtendedWebElement alertTitle;

    @FindBy(id = "android:id/button1")
    private ExtendedWebElement removeButton;

    @Override
    public boolean isOpened() {
        return alertTitle.isElementPresent() && alertTitle.getText().equals("Remove Item")
                && removeButton.isElementPresent();
    }

    @Override
    public BagPageBase clickRemoveButton() {
        removeButton.click();
        return initPage(driver, BagPageBase.class);
    }
}
