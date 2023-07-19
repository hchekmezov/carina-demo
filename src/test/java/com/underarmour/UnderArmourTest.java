package com.underarmour;

import com.qaprosoft.carina.core.foundation.IAbstractTest;
import com.underarmour.mobile.pages.common.*;
import com.underarmour.mobile.pages.common.categories.*;
import com.zebrunner.carina.core.registrar.ownership.MethodOwner;
import com.zebrunner.carina.utils.R;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.lang.invoke.MethodHandles;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class UnderArmourTest implements IAbstractTest {

    private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

    private static final String productName = "Men's UA Branded Bucket Hat";

    @Test()
    @MethodOwner(owner = "hchekmezov")
    public void testFirstLaunch() {
        UnderArmourCommonPageBase underArmourCommonPageBase = initPage(getDriver(), UnderArmourCommonPageBase.class);
        PreviewPageBase previewPageBase = initPage(getDriver(), PreviewPageBase.class);
        Assert.assertTrue(previewPageBase.isOpened(), "[Preview Page] Preview Page is not opened!");
        WhoDoYouFollowPageBase whoDoYouFollowPageBase = previewPageBase.clickSkipButton();
        Assert.assertTrue(whoDoYouFollowPageBase.isOpened(), "[WhoDoYouFollow Page] WhoDoYouFollow Page " +
                "is not opened!");
//        WhoDoYouShopForPageBase whoDoYouShopForPageBase = whoDoYouFollowPageBase.clickSkipButton();
//        Assert.assertTrue(whoDoYouShopForPageBase.isOpened(), "[WhoDoYouShopFor Page] WhoDoYouShopFor Page " +
//                "is not opened!");
//        ActivitiesInterestsPageBase activitiesInterestsPageBase = whoDoYouShopForPageBase.clickSkipButton();
//        Assert.assertTrue(activitiesInterestsPageBase.isOpened(), "[ActivitiesInterests Page] " +
//                "ActivitiesInterests Page is not opened!");
//        ForYouPageBase forYouPageBase = activitiesInterestsPageBase.clickSkipButton();
/*        ForYouPageBase forYouPageBase = whoDoYouFollowPageBase.clickSkipButton();
        Assert.assertTrue(forYouPageBase.isOpened(), "[For You Page] For You Page is not opened!");
        SearchPageBase searchPageBase = (SearchPageBase) underArmourCommonPageBase
                .getBottomNavigationView()
                .openPage(BottomNavigationViewItem.SEARCH);
        Assert.assertTrue(searchPageBase.isOpened(), "[Search Page] Search Page is not opened!");
        searchPageBase.searchByName(IConstant.T_SHIRT);
        boolean containsExpectedString = searchPageBase.searchResultContainsExpectedString(IConstant.T_SHIRT);
        Assert.assertTrue(containsExpectedString, "[Search Page] Result on Search Page is not contain " +
                "expected name!");*/
    }

    @Test(enabled = false)
    @MethodOwner(owner = "hchekmezov")
    public void testForAddingToCart() {
        UnderArmourCommonPageBase underArmourCommonPageBase = initPage(getDriver(), UnderArmourCommonPageBase.class);
        PreviewPageBase previewPageBase = initPage(getDriver(), PreviewPageBase.class);
        Assert.assertTrue(previewPageBase.isOpened(), "[Preview Page] Preview Page is not opened!");
        WhoDoYouFollowPageBase whoDoYouFollowPageBase = previewPageBase.clickSkipButton();
        Assert.assertTrue(whoDoYouFollowPageBase.isOpened(), "[WhoDoYouFollow Page] WhoDoYouFollow Page " +
                "is not opened!");
//        WhoDoYouShopForPageBase whoDoYouShopForPageBase = whoDoYouFollowPageBase.clickSkipButton();
//        Assert.assertTrue(whoDoYouShopForPageBase.isOpened(), "[WhoDoYouShopFor Page] WhoDoYouShopFor Page " +
//                "is not opened!");
//        ActivitiesInterestsPageBase activitiesInterestsPageBase = whoDoYouShopForPageBase.clickSkipButton();
//        Assert.assertTrue(activitiesInterestsPageBase.isOpened(), "[ActivitiesInterests Page] " +
//                "ActivitiesInterests Page is not opened!");
//        ForYouPageBase forYouPageBase = activitiesInterestsPageBase.clickSkipButton();
/*        ForYouPageBase forYouPageBase = whoDoYouFollowPageBase.clickSkipButton();
        Assert.assertTrue(forYouPageBase.isOpened(), "[For You Page] For You Page is not opened!");
        BagPageBase bagPageBase = (BagPageBase) underArmourCommonPageBase
                .getBottomNavigationView()
                .openPage(BottomNavigationViewItem.BAG);
        Assert.assertTrue(bagPageBase.isOpened(), "[Bag Page] Bag Page is not opened!");
        bagPageBase.clearBag();
        String[] products = {"Men's UA Antler Trucker Hat","Men's UA Branded Bucket Hat",
                "Men's UA Rival Fleece Graphic Hoodie" };
        for (String product : products) {
            addToCart(product);
        }
        bagPageBase = (BagPageBase) underArmourCommonPageBase
                .getBottomNavigationView()
                .openPage(BottomNavigationViewItem.BAG);
        Assert.assertTrue(bagPageBase.isOpened(), "[Bag Page] Bag Page is not opened!");
        Assert.assertTrue(bagPageBase.checkCartQuantity(products));
        Assert.assertEquals(bagPageBase.getProductPriceByBag(), bagPageBase.getProductPrice(),
                "[Bag Page] Sum of price of all elements is not the same to sum which displayed on " +
                        "Bag Page! On Bag Page:" + bagPageBase.getProductPriceByBag() + ", found programmatically: " +
                        bagPageBase.getProductPrice());*/


//        SearchPageBase searchPageBase = (SearchPageBase) underArmourCommonPageBase
//                .getBottomNavigationView()
//                .openPage(BottomNavigationViewItem.SEARCH);
//        Assert.assertTrue(searchPageBase.isOpened(), "[Search Page] Search Page is not opened!");
//        searchPageBase.searchByName(productName);
//        boolean containsExpectedString = searchPageBase.searchResultContainsExpectedString(productName);
//        Assert.assertTrue(containsExpectedString, "[Search Page] Result on Search Page is not contain " +
//                "expected name!");
//        float priceFromSearchPage = searchPageBase.getPrice(productName);
//        ProductPageBase productPageBase = searchPageBase.openProduct(productName);
//        Assert.assertTrue(productPageBase.isOpened(), "[Product Page] Product Page is not opened!");
//        Assert.assertTrue(productPageBase.isOpenedNeededProduct(productName), "[Product Page] Product Page " +
//                "for not needed product!");
//        float priceFromProductPage = productPageBase.getPrice();
//        Assert.assertEquals(productPageBase.getProductName(), productName, "[Product Page] Actual product " +
//                "name is not equal to expected! Actual: <" + productPageBase.getProductName() + ">, Expected: <" +
//                productName + ">.");
//        Assert.assertEquals(priceFromProductPage, priceFromSearchPage, "[Product Page] Actual product " +
//                "price is not equal to expected! Actual: <" + priceFromProductPage + ">, Expected: <" +
//                priceFromSearchPage + ">.");
//        Assert.assertTrue(productPageBase.clickAddToBagButton(), "[Product Page] Something wrong with Add " +
//                "To Bag button!");
//        searchPageBase = productPageBase.clickBackArrow();
//        Assert.assertTrue(searchPageBase.isOpened(), "[Search Page] Search Page is not opened after " +
//                "clicking back arrow!");
//        bagPageBase = (BagPageBase) underArmourCommonPageBase
//                .getBottomNavigationView()
//                .openPage(BottomNavigationViewItem.BAG);
//        Assert.assertTrue(bagPageBase.isOpened(), "[Bag Page] Bag Page is not opened!");
    }


    private void addToCart(String name) {
        UnderArmourCommonPageBase underArmourCommonPageBase = initPage(getDriver(), UnderArmourCommonPageBase.class);
        SearchPageBase searchPageBase = (SearchPageBase) underArmourCommonPageBase
                .getBottomNavigationView()
                .openPage(BottomNavigationViewItem.SEARCH);
        Assert.assertTrue(searchPageBase.isOpened(), "[Search Page] Search Page is not opened!");
        searchPageBase.searchByName(name);
        boolean containsExpectedString = searchPageBase.searchResultContainsExpectedString(name);
        Assert.assertTrue(containsExpectedString, "[Search Page] Result on Search Page is not contain " +
                "expected name!");
        float priceFromSearchPage = searchPageBase.getPrice(name);
        ProductPageBase productPageBase = searchPageBase.openProduct(name);
        Assert.assertTrue(productPageBase.isOpened(), "[Product Page] Product Page is not opened!");
        Assert.assertTrue(productPageBase.isOpenedNeededProduct(name), "[Product Page] Product Page " +
                "for not needed product!");
        float priceFromProductPage = productPageBase.getPrice();
        Assert.assertEquals(productPageBase.getProductName(), name, "[Product Page] Actual product " +
                "name is not equal to expected! Actual: <" + productPageBase.getProductName() + ">, Expected: <" +
                name + ">.");
        Assert.assertEquals(priceFromProductPage, priceFromSearchPage, "[Product Page] Actual product " +
                "price is not equal to expected! Actual: <" + priceFromProductPage + ">, Expected: <" +
                priceFromSearchPage + ">.");
        Assert.assertTrue(productPageBase.clickAddToBagButton(), "[Product Page] Something wrong with Add " +
                "To Bag button!");
        searchPageBase = productPageBase.clickBackArrow();
        Assert.assertTrue(searchPageBase.isOpened(), "[Search Page] Search Page is not opened after " +
                "clicking back arrow!");
    }


    @Test(enabled = false) // вспомогательный тест
    @MethodOwner(owner = "hchekmezov")
    public void testBagAdding() {
        String[] products = {"Men's UA Antler Trucker Hat","Men's UA Branded Bucket Hat",
                "Men's UA Rival Fleece Graphic Hoodie" };
        UnderArmourCommonPageBase underArmourCommonPageBase = initPage(getDriver(), UnderArmourCommonPageBase.class);
        PreviewPageBase previewPageBase = initPage(getDriver(), PreviewPageBase.class);
        Assert.assertTrue(previewPageBase.isOpened(), "[Preview Page] Preview Page is not opened!");
        WhoDoYouFollowPageBase whoDoYouFollowPageBase = previewPageBase.clickSkipButton();
        Assert.assertTrue(whoDoYouFollowPageBase.isOpened(), "[WhoDoYouFollow Page] WhoDoYouFollow Page " +
                "is not opened!");
//        WhoDoYouShopForPageBase whoDoYouShopForPageBase = whoDoYouFollowPageBase.clickSkipButton();
//        Assert.assertTrue(whoDoYouShopForPageBase.isOpened(), "[WhoDoYouShopFor Page] WhoDoYouShopFor Page " +
//                "is not opened!");
//        ActivitiesInterestsPageBase activitiesInterestsPageBase = whoDoYouShopForPageBase.clickSkipButton();
//        Assert.assertTrue(activitiesInterestsPageBase.isOpened(), "[ActivitiesInterests Page] " +
//                "ActivitiesInterests Page is not opened!");
//        ForYouPageBase forYouPageBase = activitiesInterestsPageBase.clickSkipButton();
/*        ForYouPageBase forYouPageBase = whoDoYouFollowPageBase.clickSkipButton();
        Assert.assertTrue(forYouPageBase.isOpened(), "[For You Page] For You Page is not opened!");
        for (String product : products) {
            addToCart(product);
        }
        BagPageBase bagPageBase = (BagPageBase) underArmourCommonPageBase
                .getBottomNavigationView()
                .openPage(BottomNavigationViewItem.BAG);
        Assert.assertTrue(bagPageBase.isOpened(), "[Bag Page] Bag Page is not opened!");
        Assert.assertTrue(bagPageBase.checkCartQuantity(products));
        Assert.assertEquals(bagPageBase.getProductPriceByBag(), bagPageBase.getProductPrice(),
                "[Bag Page] Sum of price of all elements is not the same to sum which displayed on " +
                        "Bag Page! On Bag Page:" + bagPageBase.getProductPriceByBag() + ", found programmatically: " +
                        bagPageBase.getProductPrice());*/
    }


    @Test()
    @MethodOwner(owner = "hchekmezov")
    public void testCheckout() {
        UnderArmourCommonPageBase underArmourCommonPageBase = initPage(getDriver(), UnderArmourCommonPageBase.class);
        PreviewPageBase previewPageBase = initPage(getDriver(), PreviewPageBase.class);
        Assert.assertTrue(previewPageBase.isOpened(), "[Preview Page] Preview Page is not opened!");
        WhoDoYouFollowPageBase whoDoYouFollowPageBase = previewPageBase.clickSkipButton();
        Assert.assertTrue(whoDoYouFollowPageBase.isOpened(), "[WhoDoYouFollow Page] WhoDoYouFollow Page " +
                "is not opened!");
        // TODO: FOR EMULATOR
//        WhoDoYouShopForPageBase whoDoYouShopForPageBase = whoDoYouFollowPageBase.clickSkipButton();
//        Assert.assertTrue(whoDoYouShopForPageBase.isOpened(), "[WhoDoYouShopFor Page] WhoDoYouShopFor Page " +
//                "is not opened!");
//        ActivitiesInterestsPageBase activitiesInterestsPageBase = whoDoYouShopForPageBase.clickSkipButton();
//        Assert.assertTrue(activitiesInterestsPageBase.isOpened(), "[ActivitiesInterests Page] " +
//                "ActivitiesInterests Page is not opened!");
//        ForYouPageBase forYouPageBase = activitiesInterestsPageBase.clickSkipButton();
/*        ForYouPageBase forYouPageBase = whoDoYouFollowPageBase.clickSkipButton();
        Assert.assertTrue(forYouPageBase.isOpened(), "[For You Page] For You Page is not opened!");
        MorePageBase morePageBase = (MorePageBase) underArmourCommonPageBase
                .getBottomNavigationView()
                .openPage(BottomNavigationViewItem.MORE);
        Assert.assertTrue(morePageBase.isOpened(), "[More Page] More Page is not opened!");
        if (!morePageBase.isUserLoggedIn()) {
            CreateAccOrLoginPageBase createAccOrLoginPageBase = morePageBase.clickLoginButton();
            Assert.assertTrue(createAccOrLoginPageBase.isOpened(), "[Create Acc Or Login Page] Create Acc or " +
                    "Login Page is not opened after clicking login button!");
            createAccOrLoginPageBase.selectLayout(CreateAccOrLoginLayout.LOGIN_LAYOUT);
            morePageBase = (MorePageBase) createAccOrLoginPageBase.login(R.TESTDATA.get("email"),
                    R.TESTDATA.get("password_underarmour"),
                    MorePageBase.class);
            Assert.assertTrue(morePageBase.isOpened(), "[More Page] More Page is not opened after logging in!");
        }
        BagPageBase bagPageBase = (BagPageBase) underArmourCommonPageBase
                .getBottomNavigationView()
                .openPage(BottomNavigationViewItem.BAG);
        Assert.assertTrue(bagPageBase.isOpened(), "[Bag Page] Bag Page is not opened!");
        bagPageBase.clearBag();
        String[] products = {"Men's UA Antler Trucker Hat","Men's UA Branded Bucket Hat"};
        for (String product : products) {
            addToCart(product);
        }
        bagPageBase = (BagPageBase) underArmourCommonPageBase
                .getBottomNavigationView()
                .openPage(BottomNavigationViewItem.BAG);
        Assert.assertTrue(bagPageBase.isOpened(), "[Bag Page] Bag Page is not opened!");
        CheckoutPageBase checkoutPageBase = bagPageBase.clickCheckoutButton();
        Assert.assertTrue(checkoutPageBase.isOpened(), "[Checkout Page] Checkout Page is not opened!");
        Assert.assertFalse(checkoutPageBase.isPlaceOrderButtonEnabled(), "[Checkout Page] Place Order " +
                "button should be disabled!");
        ShippingAddressPageBase shippingAddressPageBase = checkoutPageBase.openShippingAddressPage();
        Assert.assertTrue(shippingAddressPageBase.isOpened(), "[Shipping Address Page] Shipping Address " +
                "Page is not opened!");
        Assert.assertTrue(shippingAddressPageBase.isAnyShippingAddressExists(), "[Shipping Address Page] " +
                "On this page is not exist any of predefined addresses, make it manual please for future automated " +
                "tests!");
        shippingAddressPageBase.chooseRandomAvailableAddress();
        checkoutPageBase = shippingAddressPageBase.clickBackButton();
        Assert.assertTrue(checkoutPageBase.isOpened(), "[Checkout Page] Checkout Page is not opened!");
        PaymentMethodPageBase paymentPageBase = checkoutPageBase.openPaymentPage();
        Assert.assertTrue(paymentPageBase.isOpened(), "[Payment Page] Payment Page is not opened!");
        KlarnaBasePage klarnaBasePage = (KlarnaBasePage) paymentPageBase.openPaymentMethod(PaymentMethod.KLARNA);
        Assert.assertTrue(klarnaBasePage.isOpened(), "[Klarna Page] Klarna Page is not opened!");
        paymentPageBase = klarnaBasePage.clickBackButton();
        Assert.assertTrue(paymentPageBase.isOpened(), "[Payment Page] Payment Page is not opened after " +
                "clicking back button!");
        checkoutPageBase = paymentPageBase.clickBackButton();
        Assert.assertTrue(checkoutPageBase.isOpened(), "[Checkout Page] Checkout Page is not opened after " +
                "clicking back button!");
        Assert.assertTrue(checkoutPageBase.isPlaceOrderButtonEnabled(), "[Checkout Page] Place Order button " +
                "should be enalbed!");*/
    }



    @Test(enabled = false)
    @MethodOwner(owner = "hchekmezov")
    public void testSortProducts() {
/*        UnderArmourCommonPageBase underArmourCommonPageBase = initPage(getDriver(), UnderArmourCommonPageBase.class);
        PreviewPageBase previewPageBase = initPage(getDriver(), PreviewPageBase.class);
        Assert.assertTrue(previewPageBase.isOpened(), "[Preview Page] Preview Page is not opened!");
        WhoDoYouFollowPageBase whoDoYouFollowPageBase = previewPageBase.clickSkipButton();
        Assert.assertTrue(whoDoYouFollowPageBase.isOpened(), "[WhoDoYouFollow Page] WhoDoYouFollow Page " +
                "is not opened!");
        ForYouPageBase forYouPageBase = whoDoYouFollowPageBase.clickSkipButton();
        Assert.assertTrue(forYouPageBase.isOpened(), "[For You Page] For You Page is not opened!");
        CategoriesPageBase categoriesPageBase = (CategoriesPageBase) underArmourCommonPageBase
                .getBottomNavigationView()
                .openPage(BottomNavigationViewItem.CATEGORIES);
        Assert.assertTrue(categoriesPageBase.isOpened(), "[Categories Page] Categories Page is not opened!");
        MensCategoriesPageBase mensCategoriesPageBase = (MensCategoriesPageBase) categoriesPageBase
                .chooseVariant(CategoriesVariant.MEN);
        Assert.assertTrue(mensCategoriesPageBase.isOpened(), "[Mens Categories Page] Mens Categories Page " +
                "is not opened!");
        MensBestSellersPageBase mensBestSellersPageBase = (MensBestSellersPageBase) mensCategoriesPageBase
                .chooseVariant(MensCategoriesVariant.BEST_SELLERS);
        Assert.assertTrue(mensBestSellersPageBase.isOpened(), "[Men's Best Sellers Page] Mens Best Sellers " +
                "Page is not opened!");
        FilterPageBase filterPageBase = mensBestSellersPageBase.clickFilterButton();
        Assert.assertTrue(filterPageBase.isOpened(), "[Filter Page] Filter Page is not opened!");
        filterPageBase.chooseFilter(SortVariant.PRICE_LOW_TO_HIGH);
        mensBestSellersPageBase = filterPageBase.clickShowResultsButton();
        Assert.assertTrue(mensBestSellersPageBase.isOpened(), "[Menss Best Sellers Page] Mens Best Sellers " +
                "Page is not opened after filter's apply!");
        Assert.assertTrue(mensBestSellersPageBase.isProductsSortedProperly(SortVariant.PRICE_LOW_TO_HIGH),
                "[Men's Best Sellers Page] Products are not sorted properly! It needed to be sorted as "
                        + SortVariant.PRICE_LOW_TO_HIGH);*/
    }


    @Test()
    @MethodOwner(owner = "hchekmezov")
    public void testAddToWishlist() {
        int wishlistCount = 0;
        List<String> productNames = new ArrayList<>();
        UnderArmourCommonPageBase underArmourCommonPageBase = initPage(getDriver(), UnderArmourCommonPageBase.class);
        PreviewPageBase previewPageBase = initPage(getDriver(), PreviewPageBase.class);
        Assert.assertTrue(previewPageBase.isOpened(), "[Preview Page] Preview Page is not opened!");
        WhoDoYouFollowPageBase whoDoYouFollowPageBase = previewPageBase.clickSkipButton();
        Assert.assertTrue(whoDoYouFollowPageBase.isOpened(), "[WhoDoYouFollow Page] WhoDoYouFollow Page " +
                "is not opened!");
        WhoDoYouShopForPageBase whoDoYouShopForPageBase = whoDoYouFollowPageBase.clickSkipButton();
        Assert.assertTrue(whoDoYouShopForPageBase.isOpened(), "[WhoDoYouShopFor Page] WhoDoYouShopFor Page " +
                "is not opened!");
        ActivitiesInterestsPageBase activitiesInterestsPageBase = whoDoYouShopForPageBase.clickSkipButton();
        Assert.assertTrue(activitiesInterestsPageBase.isOpened(), "[ActivitiesInterests Page] " +
                "ActivitiesInterests Page is not opened!");
        ForYouPageBase forYouPageBase = activitiesInterestsPageBase.clickSkipButton();
        Assert.assertTrue(forYouPageBase.isOpened(), "[For You Page] For You Page is not opened!");
        SearchPageBase searchPageBase = (SearchPageBase) underArmourCommonPageBase
                .getBottomNavigationView()
                .openPage(BottomNavigationViewItem.SEARCH);
        Assert.assertTrue(searchPageBase.isOpened(), "[Search Page] Search Page is not opened!");
        searchPageBase.searchByName("t-shirt");
        ProductPageBase productPageBase = searchPageBase.openFirstProduct();
        Assert.assertTrue(productPageBase.isOpened(), "[Product Page] Product Page is not opened!");
        productNames.add(productPageBase.getProductName());
        productPageBase.clickFavoriteButton();
        wishlistCount++;
        searchPageBase = productPageBase.clickBackArrow();
        Assert.assertTrue(searchPageBase.isOpened(), "[Search Page] Search Page is not opened after " +
                "clicking back button!");
        searchPageBase.searchByName("hoodie");
        productPageBase = searchPageBase.openFirstProduct();
        Assert.assertTrue(productPageBase.isOpened(), "[Product Page] Product Page is not opened!");
        productNames.add(productPageBase.getProductName());
        productPageBase.clickFavoriteButton();
        wishlistCount++;
        searchPageBase = productPageBase.clickBackArrow();
        Assert.assertTrue(searchPageBase.isOpened(), "[Search Page] Search Page is not opened after " +
                "clicking back button!");
        BagPageBase bagPageBase = (BagPageBase) underArmourCommonPageBase
                .getBottomNavigationView()
                .openPage(BottomNavigationViewItem.BAG);
        Assert.assertTrue(bagPageBase.isOpened(), "[Bag Page] Bag Page is not opened!");
        bagPageBase.chooseBagCategory(BagCategory.SAVED_ITEMS);
        Assert.assertTrue(bagPageBase.checkWishlistQuantity(productNames.toArray(new String[0])),
                "[Bag Page] Wishlist looks not as expected!");
        Assert.assertEquals(wishlistCount, bagPageBase.getCountOfProducts(),
                "[Bag Page] Wishlist should contains " + wishlistCount +
                        " products, but it contains " + bagPageBase.getCountOfProducts() + " products!");

    }
}
