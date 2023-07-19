package com.underarmour.mobile.pages.android;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import com.underarmour.mobile.pages.common.CheckoutPageBase;
import com.underarmour.mobile.pages.common.IConstant;
import com.underarmour.mobile.pages.common.PaymentMethod;
import com.underarmour.mobile.pages.common.PaymentMethodPageBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = PaymentMethodPageBase.class)
public class PaymentMethodPage extends PaymentMethodPageBase {

    @FindBy(xpath = "//*[@resource-id='com.ua.shop:id/toolbar']/android.widget.TextView[@text='Payment Method']")
    private ExtendedWebElement title;

    @FindBy(id = "com.ua.shop:id/paypal_checkout_divider")
    private ExtendedWebElement paypalCheckoutDivider;

    @FindBy(xpath = "//android.widget.ImageButton[@content-desc='Navigate up']")
    private ExtendedWebElement backButton;

    @FindBy(id = "%s")
    private ExtendedWebElement chosenPaymentMethod;

    @FindBy(id = "com.ua.shop:id/square_2")
    private ExtendedWebElement squareLoader;

    public PaymentMethodPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isOpened() {
        return paypalCheckoutDivider.isElementPresent() && title.isElementPresent();
    }

    @Override
    public AbstractPage openPaymentMethod(PaymentMethod paymentMethod) {
        chosenPaymentMethod.format(paymentMethod.getId()).click();
        waitUntil(ExpectedConditions.invisibilityOfElementLocated(squareLoader.getBy()), IConstant.THIRTY_SECONDS);
        return initPage(driver, paymentMethod.getBaseClass());
    }

    @Override
    public CheckoutPageBase clickBackButton() {
        backButton.click();
        return initPage(driver, CheckoutPageBase.class);
    }
}
