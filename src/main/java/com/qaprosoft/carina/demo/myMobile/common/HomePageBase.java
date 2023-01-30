package com.qaprosoft.carina.demo.myMobile.common;

import com.qaprosoft.carina.core.gui.AbstractPage;
import com.qaprosoft.carina.demo.myMobile.enums.DiscountPercent;
import org.openqa.selenium.WebDriver;

public abstract class HomePageBase extends AbstractPage {
    public HomePageBase(WebDriver driver) {
        super(driver);
    }

    public abstract boolean isTabsPresent();

    public abstract boolean isProductBoxPresent(DiscountPercent discountPercent);

    public abstract boolean isProductBoxPresent(String productDescPart);

    public abstract boolean isOpened();

    public abstract boolean isBottomSheetIndicatorPresent();

    public abstract boolean isSearchBarPresent();

    public abstract boolean isAddToFavoritesClicked();

    public abstract SearchPageBase clickSearchBar();

    public abstract void clickBottomSheetIndicator();

    public abstract ProductPageBase clickProductBox();

    public abstract void clickBestButton();

    public abstract void clickAddToFavorites();
}
