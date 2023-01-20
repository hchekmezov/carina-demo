package com.qaprosoft.carina.demo.myMobile.android;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.demo.myMobile.common.SideMenuPageBase;
import com.qaprosoft.carina.demo.myMobile.common.WebViewPageBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = WebViewPageBase.class)
public class WebViewPage extends WebViewPageBase {

    // @FindBy(xpath = "//android.widget.ImageButton[@content-desc='Navigate up']")
    @FindBy(xpath = "//android.view.ViewGroup/android.widget.ImageButton")
    private ExtendedWebElement sideMenuButton;

    @FindBy(id = "com.solvd.carinademoapplication:id/toolbar")
    private ExtendedWebElement toolbar;

    @FindBy(xpath = "//android.widget.TextView[@text='Web View']")
    private ExtendedWebElement pageTitle;

    public WebViewPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public SideMenuPageBase clickSideMenuButton() {
        sideMenuButton.click();
        return initPage(getDriver(), SideMenuPageBase.class);
    }

    @Override
    public boolean isOpened() {
        return toolbar.isElementPresent() && pageTitle.isElementPresent();
    }

    @Override
    public boolean isSideMenuButtonPresent() {
        return sideMenuButton.isElementPresent();
    }

}
