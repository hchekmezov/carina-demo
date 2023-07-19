package com.underarmour.mobile.pages.android;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.underarmour.mobile.pages.common.CheckoutPageBase;
import com.underarmour.mobile.pages.common.ShippingAddressPageBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import java.util.List;
import java.util.Random;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = ShippingAddressPageBase.class)
public class ShippingAddressPage extends ShippingAddressPageBase {

    @FindBy(xpath = "//*[@resource-id='com.ua.shop:id/toolbar']/android.widget.TextView[@text='Shipping Address']")
    private ExtendedWebElement title;

    @FindBy(id = "com.ua.shop:id/shipping_method")
    private ExtendedWebElement shippingMethodButton;

    @FindBy(xpath = "(//*[@resource-id='com.ua.shop:id/shipping_address_recyclerview']/android.widget.RelativeLayout)[1]")
    private ExtendedWebElement addNewAddressButton;

    @FindBy(id = "com.ua.shop:id/shipping_address_name")
    private List<ExtendedWebElement> shippingAddressNames;

    @FindBy(xpath = "//android.widget.ImageButton[@content-desc='Navigate up']")
    private ExtendedWebElement backButton;

    public ShippingAddressPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isOpened() {
        return title.isElementPresent() && shippingMethodButton.isElementPresent();
    }

    @Override
    public boolean isAnyShippingAddressExists() {
        return (shippingAddressNames != null && !shippingAddressNames.isEmpty());
    }

    @Override
    public CheckoutPageBase clickBackButton() {
        backButton.click();
        return initPage(driver, CheckoutPageBase.class);
    }

    @Override
    public void chooseRandomAvailableAddress() {
        Random random = new Random();
        int randomNumber = random.nextInt(shippingAddressNames.size());
        shippingAddressNames.get(randomNumber).click();
    }
}
