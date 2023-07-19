package com.underarmour.mobile.pages.common;

import com.qaprosoft.carina.core.gui.AbstractPage;

public enum BottomNavigationViewItem {

    FOR_YOU("com.ua.shop:id/for_you", ForYouPageBase.class),
    CATEGORIES("com.ua.shop:id/browse", CategoriesPageBase.class),
    SEARCH("com.ua.shop:id/search", SearchPageBase.class),
    BAG("com.ua.shop:id/z_bag", BagPageBase.class),
    MORE("com.ua.shop:id/more", MorePageBase.class);

    private final String id;
    private final Class<? extends AbstractPage> basePage;

    BottomNavigationViewItem(String id, Class<? extends AbstractPage> basePage) {
        this.id = id;
        this.basePage = basePage;
    }

    public String getId() {
        return id;
    }

    public Class<? extends AbstractPage> getBasePageClass() {
        return basePage;
    }
}
