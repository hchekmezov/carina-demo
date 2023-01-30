package com.qaprosoft.carina.demo.myMobile.android;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.demo.myMobile.common.ProductPageBase;
import com.qaprosoft.carina.demo.myMobile.enums.DiscountPercent;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.utils.mobile.IMobileUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = ProductPageBase.class)
public class ProductPage extends ProductPageBase implements IMobileUtils {

    @FindBy(id = "com.joom:id/gallery")
    private ExtendedWebElement productPhoto;

    @FindBy(xpath = "(//android.widget.TextView[@content-desc='Discount %s'])[1]/..")
    private ExtendedWebElement similarProductBox;

    @FindBy(id = "com.joom:id/info")
    private ExtendedWebElement infoBar;

    @FindBy(xpath = "//android.widget.TextView[@text='Similar products']/../../..")
    private ExtendedWebElement similarProductsContainer;

    @FindBy(id = "com.joom:id/main_overlay_container")
    private ExtendedWebElement mainOverlayContainer;

    public ProductPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isOpened() {
        return productPhoto.isElementPresent()
                && infoBar.isElementPresent()
                && mainOverlayContainer.isElementPresent();
    }

    @Override
    public boolean isSimilarProductsContainerPresent() {
        boolean result = swipe(similarProductsContainer, mainOverlayContainer, Direction.UP);
        if (result) {
            swipeUp(2, 1000);
        }
        return result;
    }

    @Override
    public boolean isSimilarProductBoxPresent(DiscountPercent discountPercent) {
        boolean result = swipe(similarProductBox.format(discountPercent.getDiscountPercentStringValue()),
                similarProductsContainer, Direction.LEFT);
        if (result) {
            swipeLeft(1, 1000);
        }
        return result;
    }
}
