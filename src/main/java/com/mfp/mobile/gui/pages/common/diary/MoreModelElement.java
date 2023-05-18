package com.mfp.mobile.gui.pages.common.diary;

import com.qaprosoft.carina.core.gui.AbstractPage;

public enum MoreModelElement {
    QUICK_ADD("Quick Add", QuickAddPageBase.class),
    REMINDERS("Reminders", RemindersPageBase.class);

    private final String buttonName;
    private final Class<? extends AbstractPage> baseClass;

    MoreModelElement(String buttonName, Class<? extends AbstractPage> baseClass) {
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
