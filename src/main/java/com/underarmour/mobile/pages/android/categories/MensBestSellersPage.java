package com.underarmour.mobile.pages.android.categories;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.underarmour.mobile.pages.common.categories.FilterPageBase;
import com.underarmour.mobile.pages.common.categories.MensBestSellersPageBase;
import com.underarmour.mobile.pages.common.categories.SortVariant;
import com.zebrunner.carina.utils.android.IAndroidUtils;
import com.zebrunner.carina.utils.factory.DeviceType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.invoke.MethodHandles;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = MensBestSellersPageBase.class)
public class MensBestSellersPage extends MensBestSellersPageBase implements IAndroidUtils {

    private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

    @FindBy(xpath = "//*[@resource-id='com.ua.shop:id/toolbar']/android.widget.TextView[@text=\"MEN'S BEST SELLERS\"]")
    private ExtendedWebElement title;

    @FindBy(id = "com.ua.shop:id/results")
    private ExtendedWebElement results;

    @FindBy(id = "com.ua.shop:id/filter")
    private ExtendedWebElement filterButton;

    @FindBy(id = "com.ua.shop:id/price")
    private List<ExtendedWebElement> prices;

    private List<Float> pricesFloat = new ArrayList<>();

    public MensBestSellersPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isOpened() {
        return title.isElementPresent() && results.isElementPresent();
    }

    @Override
    public FilterPageBase clickFilterButton() {
        filterButton.click();
        return initPage(driver, FilterPageBase.class);
    }

    @Override
    public boolean isProductsSortedProperly(SortVariant variant) {

        swipeUp(1, 1000);
        LOGGER.info("[Men's Best Sellers Page] Entered " + variant);

        switch (variant) {

            case PRICE_LOW_TO_HIGH:
                return isSortedPriceLowToHigh();
            default:
                LOGGER.info("[Men's Best Sellers Page] Entered wrong SortVariant!");
                return false;

        }
    }

    private boolean isSortedPriceLowToHigh() {
        if (prices != null || !prices.isEmpty()) {
            for (ExtendedWebElement price : prices) {
                String priceString = price.getText();
                float priceFloat = 0.0f;
                if (countOccurrencesOfSymbol(priceString, '$') == 2) {
                    priceString = priceString
                            .substring(0, priceString.indexOf('-') - 1)
                            .trim()
                            .replaceAll("\\$", "");
                } else if (countOccurrencesOfSymbol(priceString, '$') == 1) {
                    priceString = priceString.trim().replaceAll("\\$", "");
                }
                priceFloat = Float.parseFloat(priceString);
                pricesFloat.add(priceFloat);

            }

            return IntStream.range(0, pricesFloat.size() - 2)
                    .allMatch(i -> pricesFloat.get(i) <= pricesFloat.get(i + 1));
        } else {
            throw new RuntimeException("Prices should be!");
        }
    }

    private int countOccurrencesOfSymbol(String str, char symbol) {
        return (int) str.chars()
                .filter(c -> c == symbol)
                .count();
    }
}
