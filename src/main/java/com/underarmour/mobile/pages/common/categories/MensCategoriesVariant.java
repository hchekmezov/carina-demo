package com.underarmour.mobile.pages.common.categories;

import com.qaprosoft.carina.core.gui.AbstractPage;

public enum MensCategoriesVariant {
    NEW_ARRIVALS("//*[@resource-id='com.ua.shop:id/title' and @text='New Arrivals']", null),
    BEST_SELLERS("//*[@resource-id='com.ua.shop:id/title' and @text='Best Sellers']",
            MensBestSellersPageBase.class),
    PROJECT_ROCK("//*[@resource-id='com.ua.shop:id/title' and @text='Project Rock']", null),
    FEATURED("//*[@resource-id='com.ua.shop:id/title' and @text='Featured']", null),
    SHOP_BY_CATEGORY("//*[@resource-id='com.ua.shop:id/title' and @text='Shop by Category']", null),
    SHOP_BY_SPORT("//*[@resource-id='com.ua.shop:id/title' and @text='Shop by Sport']", null),
    OUTLET("//*[@resource-id='com.ua.shop:id/title' and @text='Outlet']", null),
    ALL_MEN("//*[@resource-id='com.ua.shop:id/title' and @text='All Men']", null);

    private final String xpath;
    private final Class<? extends AbstractPage> baseClass;

    MensCategoriesVariant(String xpath, Class<? extends AbstractPage> baseClass) {
        this.xpath = xpath;
        this.baseClass = baseClass;
    }

    public String getXpath() {
        return xpath;
    }

    public Class<? extends AbstractPage> getBaseClass() {
        return baseClass;
    }
}
