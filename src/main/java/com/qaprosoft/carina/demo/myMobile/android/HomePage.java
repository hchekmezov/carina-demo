package com.qaprosoft.carina.demo.myMobile.android;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.demo.myMobile.common.HomePageBase;
import com.qaprosoft.carina.demo.myMobile.common.ProductPageBase;
import com.qaprosoft.carina.demo.myMobile.enums.DiscountPercent;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.utils.mobile.IMobileUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = HomePageBase.class)
public class HomePage extends HomePageBase implements IMobileUtils {

    @FindBy(id = "com.joom:id/tabs")
    private ExtendedWebElement tabs;

    @FindBy(xpath = "//android.widget.LinearLayout[@content-desc=\"Sale\"]")
    private ExtendedWebElement saleButton;

    @FindBy(xpath = "//android.widget.LinearLayout[@content-desc=\"Best\"]")
    private ExtendedWebElement bestButton;

    @FindBy(xpath = "(//android.widget.TextView[@content-desc='Discount %s'])[1]/..")
    private ExtendedWebElement productBox;

    @FindBy(id = "com.joom:id/container")
    private ExtendedWebElement containerOfProducts;

    @FindBy(id = "com.joom:id/bottom_sheet_indicator")
    private ExtendedWebElement bottomSheetIndicator;

    public HomePage(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isTabsPresent() {
        return tabs.isElementPresent();
    }

    @Override
    public boolean isProductBoxPresent(DiscountPercent discountPercent) {
        return swipe(productBox.format(discountPercent.getDiscountPercentStringValue()),
                containerOfProducts, Direction.UP, 10);
    }

    @Override
    public boolean isOpened() {
        return bestButton.isElementPresent() && containerOfProducts.isElementPresent();
    }

    @Override
    public boolean isBottomSheetIndicatorPresent() {
        return bottomSheetIndicator.isElementPresent();
    }

    @Override
    public void clickBottomSheetIndicator() {
        bottomSheetIndicator.click();
    }

    @Override
    public ProductPageBase clickProductPageBox(DiscountPercent discountPercent) {
        productBox.format(discountPercent.getDiscountPercentStringValue()).click();
        return initPage(getDriver(), ProductPageBase.class);
    }
}
