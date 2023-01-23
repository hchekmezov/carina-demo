package com.qaprosoft.carina.demo.myMobile.android.sideMenu;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.demo.myMobile.common.sideMenu.WebViewPageBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = WebViewPageBase.class)
public class WebViewPage extends WebViewPageBase {

    @FindBy(id = "com.solvd.carinademoapplication:id/toolbar")
    private ExtendedWebElement toolbar;

    @FindBy(xpath = "//android.widget.TextView[@text='Web View']")
    private ExtendedWebElement pageTitle;

    public WebViewPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isOpened() {
        return toolbar.isElementPresent() && pageTitle.isElementPresent();
    }
}
