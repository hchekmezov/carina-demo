package com.qaprosoft.carina.demo.myMobile.common.components;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractUIObject;
import com.qaprosoft.carina.demo.myMobile.enums.DiscountPercent;
import com.zebrunner.carina.utils.mobile.IMobileUtils;
import org.openqa.selenium.WebDriver;

public abstract class ProductBoxBase extends AbstractUIObject implements IMobileUtils {
    public ProductBoxBase(WebDriver driver) {
        super(driver);
    }

    public abstract DiscountPercent getProductBoxDiscount();

    public abstract void setProductDescPart(String productDescPart);

    public abstract void setDiscountPercent(DiscountPercent discountPercent);

    public abstract boolean swipeToProductBox(ExtendedWebElement container);

    public abstract boolean isAddToFavoritesClicked();

    public abstract void clickOnProductBox();

    public abstract void clickAddToFavorites();
}
