package com.qaprosoft.carina.demo.myMobile.android.components;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.demo.myMobile.common.components.BottomBarBase;
import com.qaprosoft.carina.demo.myMobile.enums.BottomBarButton;
import com.zebrunner.carina.utils.android.IAndroidUtils;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.utils.mobile.IMobileUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = BottomBarBase.class)
public class BottomBar extends BottomBarBase implements IMobileUtils, IAndroidUtils {
    public BottomBar(WebDriver driver) {
        super(driver);
    }


    @FindBy(xpath = "//android.widget.ImageView[@content-desc='Home' and @resource-id='com.joom:id/icon']/..")
    private ExtendedWebElement homeButton;

    @FindBy(xpath = "//android.widget.ImageView[@content-desc='Search' and @resource-id='com.joom:id/icon']/..")
    private ExtendedWebElement searchButton;

    @FindBy(xpath = "//android.widget.ImageView[@content-desc='Shopping cart' and @resource-id='com.joom:id/icon']/..")
    private ExtendedWebElement cartButton;

    @FindBy(xpath = "//android.widget.ImageView[@content-desc='Favorites' and @resource-id='com.joom:id/icon']/..")
    private ExtendedWebElement favoritesButton;

    @FindBy(xpath = "//android.widget.ImageView[@content-desc='Profile' and @resource-id='com.joom:id/icon']/..")
    private ExtendedWebElement profileButton;

    @Override
    public void clickButton(BottomBarButton barButton) {
        switch (barButton) {
            case HOME:
                homeButton.click();
                break;
            case SEARCH:
                searchButton.click();
                break;
            case CART:
                cartButton.click();
                break;
            case FAVORITES:
                favoritesButton.click();
                break;
            case PROFILE:
                profileButton.click();
                break;
            default:
                throw new RuntimeException("Wrong input in clickButton()-method!");
        }
    }

    @Override
    public boolean isClickable(BottomBarButton barButton) {
        switch (barButton) {
            case HOME:
                return Boolean.parseBoolean(homeButton.getAttribute("clickable"));
            case SEARCH:
                return Boolean.parseBoolean(searchButton.getAttribute("clickable"));
            case CART:
                return Boolean.parseBoolean(cartButton.getAttribute("clickable"));
            case FAVORITES:
                return Boolean.parseBoolean(favoritesButton.getAttribute("clickable"));
            case PROFILE:
                return Boolean.parseBoolean(profileButton.getAttribute("clickable"));
            default:
                throw new RuntimeException("Wrong input in isClickable()-method!");
        }
    }

    @Override
    public boolean isPresent() {
        return homeButton.isElementPresent()
                && searchButton.isElementPresent()
                && cartButton.isElementPresent()
                && favoritesButton.isElementPresent()
                && profileButton.isElementPresent();
    }
}
