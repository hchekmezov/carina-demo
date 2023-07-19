package com.underarmour.mobile.pages.android;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.underarmour.mobile.pages.common.*;
import com.zebrunner.carina.utils.android.IAndroidUtils;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.utils.mobile.IMobileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.asserts.SoftAssert;

import java.lang.invoke.MethodHandles;
import java.util.List;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = SearchPageBase.class)
public class SearchPage extends SearchPageBase implements IMobileUtils {

    private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

    @FindBy(id = "com.ua.shop:id/search_edittext")
    private ExtendedWebElement toFindField;

    @FindBy(id = "com.ua.shop:id/search_icon")
    private ExtendedWebElement searchIcon;

    @FindBy(id = "com.ua.shop:id/product_name")
    private List<ExtendedWebElement> allProductNames;

    @FindBy(xpath = "//*[@resource-id='com.ua.shop:id/product_name' and @text=\"%s\"]")
    private ExtendedWebElement productByName;

    @FindBy(xpath = "//*[@resource-id='com.ua.shop:id/product_name' and @text=\"%s\"]" +
            "//following-sibling::*[@resource-id='com.ua.shop:id/product_price']" +
            "/*[@resource-id='com.ua.shop:id/product_summary_price_base']")
    private ExtendedWebElement productPriceByName;

    @FindBy(id = "com.ua.shop:id/search_number_of_results")
    private ExtendedWebElement searchNumberOfResults;

    public SearchPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isOpened() {
        return toFindField.isElementPresent()
                && !initPage(driver, UnderArmourCommonPageBase.class)
                .getBottomNavigationView()
                .isItemClickable(BottomNavigationViewItem.SEARCH);
    }

    @Override
    public void searchByName(String name) {
        toFindField.click();
        toFindField.type(name);
        Dimension dimension = driver.manage().window().getSize();
        int x = (int) ((double)dimension.getWidth() * 0.915);
        int y = (int) (((double)dimension.getHeight() * 0.945));
        tap(x, y, 1);
        hideKeyboard();
    }

    @Override
    public boolean searchResultContainsExpectedString(String expectedString) {
        if (waitUntil(ExpectedConditions.presenceOfElementLocated(searchNumberOfResults.getBy()),
                IConstant.THIRTY_SECONDS)) {
            if (!allProductNames.isEmpty()) {
                for (ExtendedWebElement element : allProductNames) {
                    if (element.getText().toLowerCase().contains(expectedString.toLowerCase())) {
                        return true;
                    }
                }
                return false;

            } else {
                throw new RuntimeException("Product Names should not be empty!");
            }
        } else {
            throw new RuntimeException("Search Number Of Results should be present!");
        }
    }

    @Override
    public ProductPageBase openProduct(String productName) {
        waitUntil(ExpectedConditions.presenceOfElementLocated(productByName.format(productName).getBy()),
                IConstant.THIRTY_SECONDS);
        productByName.format(productName).click();
        return initPage(getDriver(), ProductPageBase.class);
    }

    @Override
    public float getPrice(String productName) {
        String strValue = productPriceByName.format(productName).getText();
        strValue = strValue.replaceAll("\\$", "");
        return Float.parseFloat(strValue);
    }

    @Override
    public ProductPageBase openFirstProduct() {
        waitUntil(ExpectedConditions.numberOfElementsToBeMoreThan(By.id("com.ua.shop:id/product_name"), 0),
                IConstant.THIRTY_SECONDS);
        allProductNames.get(0).click();
        return initPage(driver, ProductPageBase.class);
    }
}
