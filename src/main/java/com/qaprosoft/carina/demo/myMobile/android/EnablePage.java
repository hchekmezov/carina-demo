package com.qaprosoft.carina.demo.myMobile.android;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.demo.myMobile.common.EnablePageBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = EnablePageBase.class)
public class EnablePage extends EnablePageBase {

    @FindBy(id = "com.joom:id/title")
    private ExtendedWebElement title;

    @FindBy(id = "com.joom:id/subtitle")
    private ExtendedWebElement subTitle;

    @FindBy(id = "com.joom:id/button_title")
    private ExtendedWebElement enableButton;

    @FindBy(id = "com.android.permissioncontroller:id/permission_deny_button")
    private ExtendedWebElement dontAllowButton;

    public EnablePage(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isOpened() {
        return title.isElementPresent() && subTitle.isElementPresent();
    }

    @Override
    public boolean isDontAllowButtonPresent() {
        return dontAllowButton.isElementPresent();
    }

    @Override
    public void clickEnableButton() {
        enableButton.click();
    }

    @Override
    public void clickDontAllowButton() {
        dontAllowButton.click();
    }
}
