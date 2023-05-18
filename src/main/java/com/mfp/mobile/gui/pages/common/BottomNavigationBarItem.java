package com.mfp.mobile.gui.pages.common;

import com.mfp.mobile.gui.pages.common.diary.DiaryPageBase;
import com.qaprosoft.carina.core.gui.AbstractPage;

public enum BottomNavigationBarItem {
    DASHBOARD_BUTTON("Dashboard", DashboardPageBase.class),
    DIARY_BUTTON("Diary", DiaryPageBase.class),
    NEWSFEED_BUTTON("Newsfeed", NewsfeedPageBase.class),
    PLANS_BUTTON("Plans", PlansPageBase.class),
    MORE_BUTTON("More", MorePageBase.class);

    private final String buttonName;
    private final Class<? extends AbstractPage> baseClass;

    BottomNavigationBarItem(String buttonName, Class<? extends AbstractPage> baseClass) {
        this.buttonName = buttonName;
        this.baseClass = baseClass;
    }

    public String getButtonName() {
        return buttonName;
    }

    public Class<? extends AbstractPage> getBaseClass() {
        return baseClass;
    }
}
