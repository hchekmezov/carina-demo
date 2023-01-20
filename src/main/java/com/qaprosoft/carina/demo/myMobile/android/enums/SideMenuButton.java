package com.qaprosoft.carina.demo.myMobile.android.enums;

import com.qaprosoft.carina.core.gui.AbstractPage;
import com.qaprosoft.carina.demo.myMobile.common.ChartsPageBase;
import com.qaprosoft.carina.demo.myMobile.common.MapPageBase;
import com.qaprosoft.carina.demo.myMobile.common.UIElementsPageBase;
import com.qaprosoft.carina.demo.myMobile.common.WebViewPageBase;

public enum SideMenuButton {
    WEB_VIEW_BUTTON("Web View", WebViewPageBase.class),
    CHARTS_BUTTON("Charts", ChartsPageBase.class),
    MAP_BUTTON("Map", MapPageBase.class),
    UI_ELEMENTS_BUTTON("UI elements", UIElementsPageBase.class);

    private final String pageTitle;
    private final Class<? extends AbstractPage> baseClass;

    SideMenuButton(String pageTitle, Class<? extends AbstractPage> baseClass) {
        this.pageTitle= pageTitle;
        this.baseClass = baseClass;
    }

    public String getPageTitle() {
        return pageTitle;
    }

    public Class<? extends AbstractPage> getBaseClass() {
        return baseClass;
    }
}
