package com.underarmour.mobile.pages.android;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.underarmour.mobile.pages.common.KlarnaBasePage;
import com.underarmour.mobile.pages.common.PaymentMethodPageBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = KlarnaBasePage.class)
public class KlarnaPage extends KlarnaBasePage {
    public KlarnaPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//*[@resource-id='com.ua.shop:id/toolbar']/android.widget.TextView[@text='Klarna']")
    private ExtendedWebElement title;

    @FindBy(id = "com.ua.shop:id/klarna_radio_button")
    private ExtendedWebElement klarnaRadioButton;

    @FindBy(xpath = "//android.widget.ImageButton[@content-desc='Navigate up']")
    private ExtendedWebElement backButton;

    @Override
    public boolean isOpened() {
        return klarnaRadioButton.isElementPresent() && title.isElementPresent();
    }

    @Override
    public PaymentMethodPageBase clickBackButton() {
        backButton.click();
        return initPage(driver, PaymentMethodPageBase.class);
    }
}
