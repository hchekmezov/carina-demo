package com.qaprosoft.carina.demo.myMobile.android;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.demo.myMobile.common.MapPageBase;
import com.qaprosoft.carina.demo.myMobile.common.SideMenuPageBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = SideMenuPageBase.class)
public class SideMenuPage extends SideMenuPageBase {

    @FindBy(xpath = "//android.widget.CheckedTextView[@text='Map']")
    private ExtendedWebElement mapButton;

    @FindBy(xpath = "//android.widget.CheckedTextView[@text='Charts']")
    private ExtendedWebElement chartsButton;

    @FindBy(id = "com.solvd.carinademoapplication:id/navigation_header_container")
    private ExtendedWebElement navHeaderContainer;

    public SideMenuPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isMapButtonPresent() {
        return mapButton.isElementPresent();
    }

    @Override
    public boolean isOpened() {
        return navHeaderContainer.isElementPresent() && chartsButton.isElementPresent();
    }

    @Override
    public MapPageBase clickMapButton() {
        mapButton.click();
        return initPage(getDriver(), MapPageBase.class);
    }
}
