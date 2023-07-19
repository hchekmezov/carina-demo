package com.underarmour.mobile.pages.android;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.underarmour.mobile.pages.common.CheckoutPageBase;
import com.underarmour.mobile.pages.common.PaymentMethodPageBase;
import com.underarmour.mobile.pages.common.ShippingAddressPageBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = CheckoutPageBase.class)
public class CheckoutPage extends CheckoutPageBase {

    @FindBy(xpath = "//*[@resource-id='com.ua.shop:id/toolbar']/android.widget.TextView[@text='Checkout']")
    private ExtendedWebElement title;

    @FindBy(id = "com.ua.shop:id/checkout_place_order")
    private ExtendedWebElement placeOrderButton;

    @FindBy(id = "com.ua.shop:id/checkout_label_shipping_address")
    private ExtendedWebElement shippingAddressButton;

    @FindBy(id = "com.ua.shop:id/checkout_payment_method")
    private ExtendedWebElement paymentMethodButton;

    public CheckoutPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isOpened() {
        return title.isElementPresent() && placeOrderButton.isElementPresent();
    }

    @Override
    public ShippingAddressPageBase openShippingAddressPage() {
        shippingAddressButton.click();
        return initPage(driver, ShippingAddressPageBase.class);
    }

    @Override
    public PaymentMethodPageBase openPaymentPage() {
        paymentMethodButton.click();
        return initPage(driver, PaymentMethodPageBase.class);
    }

    @Override
    public boolean isPlaceOrderButtonEnabled() {
        return Boolean.parseBoolean(placeOrderButton.getAttribute("enabled"));
    }
}
