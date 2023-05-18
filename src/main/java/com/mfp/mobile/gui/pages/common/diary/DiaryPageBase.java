package com.mfp.mobile.gui.pages.common.diary;

import com.mfp.mobile.gui.pages.common.diary.customDashboard.CustomDashboardPageBase;
import com.qaprosoft.carina.core.gui.AbstractPage;
import org.openqa.selenium.WebDriver;

public abstract class DiaryPageBase extends AbstractPage {
    public DiaryPageBase(WebDriver driver) {
        super(driver);
    }

    public abstract boolean isOpened();

    public abstract DiaryPageBase clearUserDiary();

    public abstract AbstractPage openPageFromMoreModel(DiaryMealTitle diaryMealTitle, MoreModelElement element);

    public abstract CustomDashboardPageBase openCustomDashboardPage();

    public abstract int getCaloriesGoalIntValue();

    public abstract int getCaloriesRemainingIntValue();
}
