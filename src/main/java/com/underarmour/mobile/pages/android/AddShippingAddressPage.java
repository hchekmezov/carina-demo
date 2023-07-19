package com.underarmour.mobile.pages.android;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.underarmour.mobile.pages.common.AddShippingAddressPageBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = AddShippingAddressPageBase.class)
public class AddShippingAddressPage extends AddShippingAddressPageBase {

    @FindBy(xpath = "//*[@resource-id='com.ua.shop:id/toolbar']/android.widget.TextView[@text='Add Shipping Address']")
    private ExtendedWebElement title;

    @FindBy(id = "com.ua.shop:id/input_address_one")
    private ExtendedWebElement requiredAddressOne;

    @FindBy(id = "com.ua.shop:id/input_city")
    private ExtendedWebElement requiredCity;

    @FindBy(id = "com.ua.shop:id/input_state")
    private ExtendedWebElement requiredState;

    @FindBy(id = "com.ua.shop:id/input_zip")
    private ExtendedWebElement requiredZip;

    @FindBy(id = "com.ua.shop:id/address_save")
    private ExtendedWebElement saveButton;

    public AddShippingAddressPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isOpened() {
        return title.isElementPresent() && saveButton.isElementPresent();
    }
}
