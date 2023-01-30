package com.qaprosoft.carina.demo.myMobile.android;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.demo.myMobile.android.components.ProductBox;
import com.qaprosoft.carina.demo.myMobile.common.HomePageBase;
import com.qaprosoft.carina.demo.myMobile.common.ProductPageBase;
import com.qaprosoft.carina.demo.myMobile.common.SearchPageBase;
import com.qaprosoft.carina.demo.myMobile.common.components.ProductBoxBase;
import com.qaprosoft.carina.demo.myMobile.enums.DiscountPercent;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.utils.mobile.IMobileUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = HomePageBase.class)
public class HomePage extends HomePageBase implements IMobileUtils {

    private final ProductBoxBase productBox;

    @FindBy(id = "com.joom:id/tabs")
    private ExtendedWebElement tabs;

    @FindBy(id = "com.joom:id/search")
    private ExtendedWebElement searchBar;

    @FindBy(xpath = "//android.widget.LinearLayout[@content-desc=\"Sale\"]")
    private ExtendedWebElement saleButton;

    @FindBy(xpath = "//android.widget.LinearLayout[@content-desc=\"Best\"]")
    private ExtendedWebElement bestButton;

    @FindBy(id = "com.joom:id/container")
    private ExtendedWebElement containerOfProducts;

    @FindBy(id = "com.joom:id/bottom_sheet_indicator")
    private ExtendedWebElement bottomSheetIndicator;

    public HomePage(WebDriver driver) {
        super(driver);
        productBox = new ProductBox(driver);
    }

    @Override
    public boolean isTabsPresent() {
        return tabs.isElementPresent();
    }

    @Override
    public boolean isProductBoxPresent(DiscountPercent discountPercent) {
        productBox.setDiscountPercent(discountPercent);
        return productBox.swipeToProductBox(containerOfProducts);
    }

    @Override
    public boolean isProductBoxPresent(String productDescPart) {
        productBox.setProductDescPart(productDescPart);
        return productBox.swipeToProductBox(containerOfProducts);
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
    public boolean isSearchBarPresent() {
        return searchBar.isElementPresent();
    }

    @Override
    public boolean isAddToFavoritesClicked() {
        return productBox.isAddToFavoritesClicked();
    }

    @Override
    public SearchPageBase clickSearchBar() {
        searchBar.click();
        return initPage(getDriver(), SearchPageBase.class);
    }

    @Override
    public void clickBottomSheetIndicator() {
        bottomSheetIndicator.click();
    }

    @Override
    public ProductPageBase clickProductBox() {
        productBox.clickOnProductBox();
        return initPage(getDriver(), ProductPageBase.class);
    }

    @Override
    public void clickAddToFavorites() {
        productBox.clickAddToFavorites();
    }

    @Override
    public void clickBestButton() {
        bestButton.click();
    }
}
