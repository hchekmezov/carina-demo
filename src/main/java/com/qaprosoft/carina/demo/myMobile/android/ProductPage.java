package com.qaprosoft.carina.demo.myMobile.android;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.demo.myMobile.common.ProductPageBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = ProductPageBase.class)
public class ProductPage extends ProductPageBase {

    @FindBy(id = "com.joom:id/gallery")
    private ExtendedWebElement productPhoto;

    @FindBy(id = "com.joom:id/info")
    private ExtendedWebElement infoBar;

    public ProductPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isOpened() {
        return productPhoto.isElementPresent() && infoBar.isElementPresent();
    }
}
