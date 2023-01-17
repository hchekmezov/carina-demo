package com.qaprosoft.carina.demo.myMobile.android;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.demo.myMobile.common.WebViewPageBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = WebViewPageBase.class)
public class WebViewPage extends WebViewPageBase {
    @FindBy(id = "com.solvd.carinademoapplication:id/toolbar")
    private ExtendedWebElement toolbar;

    @FindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout" +
            "/android.widget.FrameLayout/android.widget.LinearLayout/" +
            "android.widget.FrameLayout/android.support.v4.widget.DrawerLayout/" +
            "android.view.ViewGroup/android.view.ViewGroup/android.widget.TextView")
    private ExtendedWebElement pageTitle;

    public WebViewPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isOpened() {
        return toolbar.isElementPresent() && pageTitle.isElementPresent();
    }
}
