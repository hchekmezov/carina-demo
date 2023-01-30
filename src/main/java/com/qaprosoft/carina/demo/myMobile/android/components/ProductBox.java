package com.qaprosoft.carina.demo.myMobile.android.components;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.demo.myMobile.common.components.ProductBoxBase;
import com.qaprosoft.carina.demo.myMobile.enums.DiscountPercent;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.utils.mobile.IMobileUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = ProductBoxBase.class)
public class ProductBox extends ProductBoxBase implements IMobileUtils {
    public ProductBox(WebDriver driver) {
        super(driver);
    }

    private String productDescPart;
    private DiscountPercent discountPercent;

    @FindBy(xpath = "//android.view.ViewGroup[@resource-id='com.joom:id/feed_swipe_refresh']" +
            "/android.widget.GridView/android.view.ViewGroup" +
            "/android.widget.ImageView[contains(@content-desc, '%s')]/..")
    private ExtendedWebElement productBoxByPhotoDesc;

    @FindBy(xpath = "(//android.widget.TextView[@content-desc='Discount %s'])[1]/..")
    private ExtendedWebElement productBoxByDiscount;

    @FindBy(xpath = "//android.widget.GridView[@resource-id='com.joom:id/feed_recycler']" +
            "//android.view.ViewGroup/android.widget.TextView[text()='Add to collection']")
    private ExtendedWebElement addToCollectionLabel;

    @FindBy(xpath = "(//android.view.ViewGroup[@resource-id='com.joom:id/feed_swipe_refresh']" +
            "/android.widget.GridView/android.view.ViewGroup" +
            "/android.widget.ImageView[contains(@content-desc, '%s')]" +
            "//following-sibling::android.widget.ImageView)[1]")
    private ExtendedWebElement addToFavoritesButtonByPhotoDesc;

    @FindBy(xpath = "((//android.widget.TextView[@content-desc='Discount %s'])[1]" +
            "//preceding-sibling::android.widget.ImageView)[2]")
    private ExtendedWebElement addToFavoritesButtonByDiscount;

    @Override
    public DiscountPercent getProductBoxDiscount() {
        return discountPercent;
    }

    @Override
    public boolean isAddToFavoritesClicked() {
        if (discountPercent != null) {
            return addToFavoritesButtonByDiscount.format(discountPercent.getDiscountPercentStringValue())
                    .getAttribute("content-desc").equalsIgnoreCase("Remove from favorites");
        } else {
            return addToFavoritesButtonByPhotoDesc.format(productDescPart)
                    .getAttribute("content-desc").equalsIgnoreCase("Remove from favorites");
        }
    }

    @Override
    public void setProductDescPart(String productDescPart) {
        this.productDescPart = productDescPart;
    }

    @Override
    public void setDiscountPercent(DiscountPercent discountPercent) {
        this.discountPercent = discountPercent;
    }

    @Override
    public void clickOnProductBox() {
        if (discountPercent != null) {
            productBoxByDiscount.format(discountPercent.getDiscountPercentStringValue()).click();
        } else {
            productBoxByPhotoDesc.format(productDescPart).click();
        }
    }

    @Override
    public void clickAddToFavorites() {
        if(discountPercent != null) {
            addToFavoritesButtonByDiscount.format(discountPercent.getDiscountPercentStringValue()).click();
        } else {
            addToFavoritesButtonByPhotoDesc.format(productDescPart).click();
        }
    }

    @Override
    public boolean swipeToProductBox(ExtendedWebElement container) {
        if (discountPercent != null) {
            return swipe(productBoxByDiscount.format(discountPercent.getDiscountPercentStringValue()),
                    container, Direction.UP);
        } else {
            return swipe(productBoxByPhotoDesc.format(productDescPart), container, Direction.UP);
        }
    }
}
