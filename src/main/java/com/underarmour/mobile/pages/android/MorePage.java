package com.underarmour.mobile.pages.android;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.underarmour.mobile.pages.common.BottomNavigationViewItem;
import com.underarmour.mobile.pages.common.CreateAccOrLoginPageBase;
import com.underarmour.mobile.pages.common.MorePageBase;
import com.underarmour.mobile.pages.common.UnderArmourCommonPageBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.invoke.MethodHandles;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = MorePageBase.class)
public class MorePage extends MorePageBase {

    private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

    @FindBy(id = "com.ua.shop:id/header_view")
    private ExtendedWebElement headerView;

    @FindBy(id = "com.ua.shop:id/login_button")
    private ExtendedWebElement loginButton;


    public MorePage(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isOpened() {
        return headerView.isElementPresent()
                && !initPage(driver, UnderArmourCommonPageBase.class)
                .getBottomNavigationView()
                .isItemClickable(BottomNavigationViewItem.MORE);
    }

    @Override
    public CreateAccOrLoginPageBase clickLoginButton() {
        loginButton.click();
        return initPage(driver, CreateAccOrLoginPageBase.class);
    }

    @Override
    public boolean isUserLoggedIn() {
        boolean result = !loginButton.isElementPresent();
        if (result) {
            LOGGER.info("[More Page] User already logged in, skip logging!");
        }
        return result;
    }
}
