package com.underarmour.mobile.pages.android;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.underarmour.mobile.pages.common.IConstant;
import com.underarmour.mobile.pages.common.ProductPageBase;
import com.underarmour.mobile.pages.common.SearchPageBase;
import com.zebrunner.carina.utils.android.IAndroidUtils;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.utils.mobile.IMobileUtils;
import com.zebrunner.carina.webdriver.locator.Context;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.invoke.MethodHandles;
import java.time.Duration;
import java.util.List;


@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = ProductPageBase.class)
public class ProductPage extends ProductPageBase implements IAndroidUtils {

    private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

    @FindBy(id = "com.ua.shop:id/favorite")
    private ExtendedWebElement favoriteButton;

    @FindBy(id = "com.ua.shop:id/scroll_view")
    private ExtendedWebElement scrollView;

    @FindBy(id = "com.ua.shop:id/add_to_bag_loading")
    private ExtendedWebElement addToBagLoading;

    @FindBy(id = "com.ua.shop:id/slider_item_image")
    private ExtendedWebElement sliderProductImage;

    @FindBy(id = "com.ua.shop:id/name")
    private ExtendedWebElement productName;

    @FindBy(id = "com.ua.shop:id/price")
    private ExtendedWebElement productPrice;

    @FindBy(id = "com.ua.shop:id/add_to_bag")
    private ExtendedWebElement addToBagButton;

    @FindBy(xpath = "//*[@resource-id='com.ua.shop:id/size_selector_carousel']//*[@resource-id='com.ua.shop:id/size']")
    private List<ExtendedWebElement> allSizes;


    @FindBy(xpath = "//*[@resource-id='com.ua.shop:id/size_selector_carousel']//*[@resource-id='com.ua.shop:id/size']" +
            "/..")
    private List<ExtendedWebElement> allSizesParents;

    @FindBy(id = "com.ua.shop:id/back_arrow")
    private ExtendedWebElement backArrow;

    public ProductPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isOpened() {
        return productName.isElementPresent() && sliderProductImage.isElementPresent();
    }

    @Override
    public boolean isOpenedNeededProduct(String neededProductName) {
        return productName.getText().equals(neededProductName);
    }

    @Override
    public float getPrice() {
        swipe(productPrice, Direction.VERTICAL, 5, 400);
        String strValue = productPrice.getText();
        strValue = strValue.replaceAll("\\$", "");
        return Float.parseFloat(strValue);
    }

    @Override
    public String getProductName() {
        swipe(productName, Direction.VERTICAL, 5, 400);
        return productName.getText();
    }

    @Override
    public boolean clickAddToBagButton() {
        if (swipe(addToBagButton, Direction.UP)) {
            boolean flag = false;
            if (addToBagButton.getText().equals(IConstant.SIZE_NOT_AVAILABLE)) {
                for (int i = 0; i < allSizes.size(); i++) {
                    if (Boolean.parseBoolean(allSizes.get(i).getAttribute("enabled"))) {
                        allSizesParents.get(i).click();
                        flag = true;
                        break;
                    }
                }
                if (!flag) {
                    swipe(productName, Direction.DOWN);
                    LOGGER.info("[Product Page] Product <" + productName.getText() + "' does not have any available " +
                            "sizes! Try to chose another product!");
                } else {
                    addToBagButton.click();
                }

            } else {
                flag = true;
                addToBagButton.click();
            }
            return flag;
        } else {
            LOGGER.info(addToBagButton.getName() + " is not found!");
            return false;
        }

    }

    @Override
    public SearchPageBase clickBackArrow() {
        waitUntil(ExpectedConditions.invisibilityOfElementLocated(addToBagLoading.getBy()), IConstant.THIRTY_SECONDS);
        backArrow.click();
        return initPage(driver, SearchPageBase.class);
    }

    @Override
    public void clickFavoriteButton() {
        favoriteButton.click();
    }
}
