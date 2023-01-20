package com.qaprosoft.carina.demo.myMobile.android;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import com.qaprosoft.carina.demo.myMobile.android.enums.SideMenuButton;
import com.qaprosoft.carina.demo.myMobile.common.SideMenuPageBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = SideMenuPageBase.class)
public class SideMenuPage extends SideMenuPageBase {

    @FindBy(xpath = "//android.widget.CheckedTextView[@text='%s']")
    private ExtendedWebElement buttonOfSideMenu;

    @FindBy(id = "com.solvd.carinademoapplication:id/navigation_header_container")
    private ExtendedWebElement navHeaderContainer;

    public SideMenuPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isButtonOfSideMenuPresent(SideMenuButton sideMenuButton) {
        return buttonOfSideMenu.format(sideMenuButton.getPageTitle()).isElementPresent();
    }

    @Override
    public boolean isOpened() {
        return navHeaderContainer.isElementPresent();
    }

    @Override
    public AbstractPage clickButtonOfSideMenu(SideMenuButton sideMenuButton) {
        buttonOfSideMenu.format(sideMenuButton.getPageTitle()).click();
        return initPage(getDriver(), sideMenuButton.getBaseClass());
    }
}
