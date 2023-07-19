package com.underarmour.mobile.pages.common;

import com.qaprosoft.carina.core.gui.AbstractPage;
import org.openqa.selenium.WebDriver;

public abstract class BagPageBase extends AbstractPage {
    public BagPageBase(WebDriver driver) {
        super(driver);
    }

    public abstract boolean isOpened();

    public abstract void clearBag();

    public abstract String getProductTitle();

    public abstract float getProductPrice();

    public abstract float getProductPriceByBag();

    public abstract boolean checkCartQuantity(String... namesNeededToBe);

    public abstract CheckoutPageBase clickCheckoutButton();

    public abstract void chooseBagCategory(BagCategory category);

    public abstract boolean checkWishlistQuantity(String... namesNeededToBe);

    public abstract int getCountOfProducts();
}
