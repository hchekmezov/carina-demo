package com.qaprosoft.carina.demo.myMobile.android;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.demo.myMobile.android.components.BottomBar;
import com.qaprosoft.carina.demo.myMobile.android.components.ProductBox;
import com.qaprosoft.carina.demo.myMobile.common.ProductPageBase;
import com.qaprosoft.carina.demo.myMobile.common.SearchPageBase;
import com.qaprosoft.carina.demo.myMobile.common.components.BottomBarBase;
import com.qaprosoft.carina.demo.myMobile.common.components.ProductBoxBase;
import com.zebrunner.carina.utils.android.IAndroidUtils;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.utils.mobile.IMobileUtils;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;


@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = SearchPageBase.class)
public class SearchPage extends SearchPageBase implements IMobileUtils, IAndroidUtils {
    private final ProductBoxBase productBox;

    private final BottomBarBase bottomBar;

    @FindBy(id = "com.joom:id/search")
    private ExtendedWebElement searchBar;

    @FindBy(id = "com.joom:id/search_field_input")
    private ExtendedWebElement searchFieldForInput;

    @FindBy(id = "com.joom:id/search_field_hint")
    private ExtendedWebElement searchFieldHint;

    @FindBy(id = "com.joom:id/feed_recycler")
    private ExtendedWebElement contentBoxesContainer;

    public SearchPage(WebDriver driver) {
        super(driver);
        productBox = new ProductBox(driver);
        bottomBar = new BottomBar(driver);
    }

    @Override
    public boolean isOpened() {
        return contentBoxesContainer.isElementPresent();
    }

    @Override
    public boolean isSearchBarPresent() {
        return searchBar.isElementPresent();
    }

    @Override
    public boolean isSearchFieldPresent() {
        return searchFieldForInput.isElementPresent();
    }

    @Override
    public BottomBarBase getBottomBar() {
        return bottomBar;
    }

    @Override
    public void clickSearchBar() {
        searchBar.click();
    }

    @Override
    public String getSearchBarText() {
        return searchFieldHint.getText();
    }

    @Override
    public void typeToSearchField(String product) {
        searchFieldForInput.type(product);
        Dimension dimension = driver.manage().window().getSize();
        int x = (int) ((double)dimension.getWidth() * 0.915);
        int y = (int) (((double)dimension.getHeight() * 0.945));
        tap(x, y, 1);
    }

    @Override
    public ProductPageBase openProductPage() {
        productBox.setProductDescPart(getSearchBarText());
        productBox.clickOnProductBox();
        return initPage(getDriver(), ProductPageBase.class);
    }
}
