package com.mfp.mobile.gui.pages.ios.diary;

import com.mfp.mobile.gui.pages.common.diary.customDashboard.CustomDashboardPageBase;
import com.mfp.mobile.gui.pages.common.diary.DiaryPageBase;
import com.mfp.mobile.gui.pages.common.diary.DiaryMealTitle;
import com.mfp.mobile.gui.pages.common.diary.MoreModelElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import com.zebrunner.carina.utils.exception.NotImplementedException;
import com.zebrunner.carina.utils.factory.DeviceType;
import org.openqa.selenium.WebDriver;

@DeviceType(pageType = DeviceType.Type.IOS_PHONE, parentClass = DiaryPageBase.class)
public class DiaryPage extends DiaryPageBase {

    public DiaryPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isOpened() {
        throw new NotImplementedException();
    }

    @Override
    public int getCaloriesGoalIntValue() {
        throw new NotImplementedException();
    }

    @Override
    public int getCaloriesRemainingIntValue() {
        throw new NotImplementedException();
    }

    @Override
    public DiaryPageBase clearUserDiary() {
        throw new NotImplementedException();
    }

    @Override
    public AbstractPage openPageFromMoreModel(DiaryMealTitle diarySectionTitle, MoreModelElement element) {
        throw new NotImplementedException();
    }

    @Override
    public CustomDashboardPageBase openCustomDashboardPage() {
        throw new NotImplementedException();
    }
}
