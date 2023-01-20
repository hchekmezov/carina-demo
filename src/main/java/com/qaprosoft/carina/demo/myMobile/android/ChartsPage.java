package com.qaprosoft.carina.demo.myMobile.android;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.demo.myMobile.common.ChartsPageBase;
import com.qaprosoft.carina.demo.myMobile.common.SideMenuPageBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = ChartsPageBase.class)
public class ChartsPage extends ChartsPageBase {

    @FindBy(xpath = "//android.view.ViewGroup/android.widget.ImageButton")
    private ExtendedWebElement navigateButton;

    @FindBy(xpath = "//android.widget.TextView[@text='Charts']")
    private ExtendedWebElement pageTitle;

    @FindBy(id = "com.solvd.carinademoapplication:id/content_frame")
    private ExtendedWebElement contentFrame;

    public ChartsPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isOpened() {
        return pageTitle.isElementPresent() && contentFrame.isElementPresent();
    }

    @Override
    public boolean isNavigateButtonPresent() {
        return navigateButton.isElementPresent();
    }

    @Override
    public SideMenuPageBase clickNavigateButton() {
        navigateButton.click();
        return initPage(getDriver(), SideMenuPageBase.class);
    }

}
