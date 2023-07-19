package com.underarmour.mobile.pages.common.categories;

import com.qaprosoft.carina.core.gui.AbstractPage;

public enum CategoriesVariant {
    NEW_ARRIVALS("//*[@resource-id='com.ua.shop:id/title' and @text='New Arrivals']", null),
    MEN("//*[@resource-id='com.ua.shop:id/title' and @text='Men']", MensCategoriesPageBase.class),
    WOMEN("//*[@resource-id='com.ua.shop:id/title' and @text='Women']", null),
    KIDS("//*[@resource-id='com.ua.shop:id/title' and @text='Kids']", null),
    SHOES("//*[@resource-id='com.ua.shop:id/title' and @text='Shoes']", null),
    SHOP_BY_SPORT("//*[@resource-id='com.ua.shop:id/title' and @text='Shop by Sport']", null),
    BACK_TO_SCHOOL("//*[@resource-id='com.ua.shop:id/title' and @text='Men']", null),
    PROJECT_ROCK("//*[@resource-id='com.ua.shop:id/title' and @text='Project Rock']", null),
    FAN_GEAR("//*[@resource-id='com.ua.shop:id/title' and @text='Fan Gear']", null),
    OUTLET("//*[@resource-id='com.ua.shop:id/title' and @text='Outlet']", null),
    GIFT_CARDS("//*[@resource-id='com.ua.shop:id/title' and @text='Gift Cards']", null);

    private final String xpath;
    private final Class<? extends AbstractPage> baseClass;

    CategoriesVariant(String xpath, Class<? extends AbstractPage> baseClass) {
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
