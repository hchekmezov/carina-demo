package com.underarmour.mobile.pages.android.categories;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.underarmour.mobile.pages.common.categories.FilterPageBase;
import com.underarmour.mobile.pages.common.categories.MensBestSellersPageBase;
import com.underarmour.mobile.pages.common.categories.SortVariant;
import com.zebrunner.carina.utils.factory.DeviceType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.invoke.MethodHandles;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = FilterPageBase.class)
public class FilterPage extends FilterPageBase {

    private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

    @FindBy(id = "com.ua.shop:id/toolbar")
    private ExtendedWebElement title;

    @FindBy(xpath = "//*[@resource-id='com.ua.shop:id/recycler_view']/android.widget.TextView" +
            "//following-sibling::android.widget.RadioButton[@text='%s']")
    private ExtendedWebElement filter;

    @FindBy(id = "com.ua.shop:id/show_results")
    private ExtendedWebElement showResultsButton;

    public FilterPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isOpened() {
        return title.isElementPresent() && title.getText().equals("FILTER & SORT");
    }

    @Override
    public void chooseFilter(SortVariant variant) {
        filter.format(variant.getId()).click();
    }

    @Override
    public MensBestSellersPageBase clickShowResultsButton() {
        showResultsButton.click();
        return initPage(driver, MensBestSellersPageBase.class);
    }
}
