package com.underarmour.mobile.pages.android;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.underarmour.mobile.pages.common.*;
import com.zebrunner.carina.utils.android.IAndroidUtils;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.locator.ExtendedFindBy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import java.lang.invoke.MethodHandles;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = BagPageBase.class)
public class BagPage extends BagPageBase implements IAndroidUtils {

    private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

    public BagPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "com.ua.shop:id/square_2")
    private ExtendedWebElement squareLoader;

    @FindBy(id = "com.ua.shop:id/checkout")
    private ExtendedWebElement checkoutButton;

    @FindBy(xpath = "//android.widget.LinearLayout[@content-desc='Bag']")
    private ExtendedWebElement bagContainer;

    @FindBy(xpath = "//android.widget.LinearLayout[@content-desc='Saved Items']")
    private ExtendedWebElement savedItemsContainer;

    @FindBy(id = "com.ua.shop:id/remove")
    private List<ExtendedWebElement> removeList;

    @FindBy(id = "com.ua.shop:id/empty_content_title")
    private ExtendedWebElement bagEmptyTitle;

    @FindBy(id = "com.ua.shop:id/cart_item")
    private List<ExtendedWebElement> currentCartItems;

    @FindBy(id = "com.ua.shop:id/cart_subtotal_checkout_price")
    private ExtendedWebElement bagTotalPrice;

    @FindBy(id = "com.ua.shop:id/product_title")
    private List<ExtendedWebElement> productTitles;

    @FindBy(id = "com.ua.shop:id/price")
    private List<ExtendedWebElement> productPrices;

    @FindBy(xpath = "//*[@resource-id='com.ua.shop:id/quantity']/android.widget.TextView")
    private List<ExtendedWebElement> productQuantities;

    private List<String> currentCartNames;
    private List<String> allCartNames;
    private List<Float> allCartPrices;
    private List<Integer> allCartQuantities;

    @Override
    public boolean isOpened() {
        return bagContainer.isElementPresent()
                && savedItemsContainer.isElementPresent()
                && !initPage(driver, UnderArmourCommonPageBase.class)
                   .getBottomNavigationView()
                   .isItemClickable(BottomNavigationViewItem.BAG);
    }

    @Override
    public boolean checkCartQuantity(String... namesNeededToBe) {
        quantityGettingForBag();

        SoftAssert softAssert = new SoftAssert();

        for (String product : namesNeededToBe) {
            softAssert.assertTrue(allCartNames.contains(product), "[Bag Page] Product <" + product + "> is " +
                    "not shown in the bag!");
        }
        softAssert.assertAll();

        priceChecking();

        return true;
    }


    @Override
    public boolean checkWishlistQuantity(String... namesNeededToBe) {
        quantityGettingForWishlist();
        SoftAssert softAssert = new SoftAssert();

        for (String product : namesNeededToBe) {
            softAssert.assertTrue(allCartNames.contains(product), "[Bag Page] Product <" + product + "> is " +
                    "not shown in the wishlist!");
        }
        softAssert.assertAll();

        return true;
    }

    @Override
    public int getCountOfProducts() {
        return allCartNames.size();
    }

    private void quantityGettingForBag() {
        currentCartNames = new ArrayList<>();
        allCartNames = new ArrayList<>();
        allCartPrices = new ArrayList<>();
        allCartQuantities = new ArrayList<>();

        while(currentCartItems != null && !currentCartItems.isEmpty()) {

            boolean flag = true;

            for (int i = 0; i < productTitles.size(); i++) {
                if (!currentCartNames.contains(productTitles.get(i).getText())) {
                    currentCartNames.add(productTitles.get(i).getText());
                }
            }

            for (int i = 0; i < currentCartNames.size(); i++) {
                if (!allCartNames.contains(currentCartNames.get(i))) {
                    flag = false;
                    allCartNames.add(currentCartNames.get(i));
                    allCartPrices.add(Float.parseFloat(productPrices.get(i).getText().replaceAll("\\$", "")));
                    allCartQuantities.add(Integer.parseInt(productQuantities.get(i).getText()));
                }
            }

            if (!flag) {
                currentCartNames = new ArrayList<>();
                swipeUp(1, 500);
            } else {
                break;
            }

        }
    }

    private void quantityGettingForWishlist() {
        currentCartNames = new ArrayList<>();
        allCartNames = new ArrayList<>();

        while(currentCartItems != null && !currentCartItems.isEmpty()) {

            boolean flag = true;

            for (int i = 0; i < productTitles.size(); i++) {
                if (!currentCartNames.contains(productTitles.get(i).getText())) {
                    currentCartNames.add(productTitles.get(i).getText());
                }
            }

            for (int i = 0; i < currentCartNames.size(); i++) {
                if (!allCartNames.contains(currentCartNames.get(i))) {
                    flag = false;
                    allCartNames.add(currentCartNames.get(i));
                }
            }

            if (!flag) {
                currentCartNames = new ArrayList<>();
                swipeUp(1, 500);
            } else {
                break;
            }

        }
    }

    private void priceChecking() {
        int sum = allCartQuantities.stream()
                .mapToInt(Integer::intValue)
                .sum();
        Assert.assertEquals(String.format(IConstant.BAG_NOTIFICATION, sum),
                driver.findElement(By.id(BottomNavigationViewItem.BAG.getId()))
                        .getAttribute("content-desc"),
                "[Bag Page] Actual content-desc is not as expected! Actual: " + driver
                        .findElement(By.id(BottomNavigationViewItem.BAG.getId()))
                        .getAttribute("content-desc") + ", Expected: " +
                        String.format(IConstant.BAG_NOTIFICATION, sum));
    }

    @Override
    public void clearBag() {
        if(bagEmptyTitle == null || !bagEmptyTitle.isElementPresent()) {
            while(removeList != null && !removeList.isEmpty()) {
                for (ExtendedWebElement element : removeList) {
                    element.click();
                    RemoveItemPageBase removeItemPageBase = initPage(driver, RemoveItemPageBase.class);
                    Assert.assertTrue(removeItemPageBase.isOpened(), "[Remove Item Page] Remove Item Page " +
                            "is not opened!");
                    removeItemPageBase.clickRemoveButton();

                    if (bagEmptyTitle != null && bagEmptyTitle.isElementPresent()) {
                        return;
                    }
                }
            }
        }
    }

    @Override
    public String getProductTitle() {
        return Arrays.toString(allCartNames.toArray());
    }

    @Override
    public float getProductPrice() {
        float result = 0.0f;
        for (Float price : allCartPrices) {
            result += price;
        }
        return result;
    }

    @Override
    public float getProductPriceByBag() {
        return Float.parseFloat(bagTotalPrice.getText().replaceAll("\\$", ""));
    }

    @Override
    public CheckoutPageBase clickCheckoutButton() {
        if (!checkoutButton.isElementPresent()) {
            throw new RuntimeException(checkoutButton.getName() + " is not present!");
        }
        checkoutButton.click();
        return initPage(driver, CheckoutPageBase.class);
    }

    @Override
    public void chooseBagCategory(BagCategory category) {
        switch (category) {
            case BAG:
                if (!Boolean.parseBoolean(bagContainer.getAttribute("selected")))
                    bagContainer.click();
                waitUntil(ExpectedConditions.invisibilityOfElementLocated(squareLoader.getBy()),
                        IConstant.THIRTY_SECONDS);
                break;
            case SAVED_ITEMS:
                if (!Boolean.parseBoolean(savedItemsContainer.getAttribute("selected")))
                    savedItemsContainer.click();
                waitUntil(ExpectedConditions.invisibilityOfElementLocated(squareLoader.getBy()),
                        IConstant.THIRTY_SECONDS);
                break;
        }
    }
}
