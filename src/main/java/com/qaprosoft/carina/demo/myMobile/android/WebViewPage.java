package com.qaprosoft.carina.demo.myMobile.android;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.demo.myMobile.common.MapPageBase;
import com.qaprosoft.carina.demo.myMobile.common.WebViewPageBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = WebViewPageBase.class)
public class WebViewPage extends WebViewPageBase {

    @FindBy(xpath = "//android.widget.ImageButton[@content-desc]")
    private ExtendedWebElement imageButton;

    @FindBy(xpath = "//android.widget.CheckedTextView[@text='Map']")
    private ExtendedWebElement mapButton;

    @FindBy(id = "com.solvd.carinademoapplication:id/toolbar")
    private ExtendedWebElement toolbar;

    @FindBy(xpath = "//android.widget.TextView[@text='Web View']")
    private ExtendedWebElement pageTitle;

    public WebViewPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public void clickImageButton() {
        imageButton.click();
    }

    @Override
    public boolean isOpened() {
        return toolbar.isElementPresent() && pageTitle.isElementPresent();
    }

    @Override
    public boolean isMapButtonPresent() {
        return mapButton.isElementPresent();
    }

    @Override
    public boolean isImageButtonPresent() {
        return imageButton.isElementPresent();
    }

    @Override
    public MapPageBase clickMapButton() {
        mapButton.click();
        return initPage(getDriver(), MapPageBase.class);
    }
}
