package com.mfp.mobile.gui.pages.android.diary;

import com.mfp.mobile.gui.pages.common.*;
import com.mfp.mobile.gui.pages.common.diary.*;
import com.mfp.mobile.gui.pages.common.diary.customDashboard.CustomDashboardPageBase;
import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.utils.mobile.IMobileUtils;
import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;

import java.lang.invoke.MethodHandles;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = DiaryPageBase.class)
public class DiaryPage extends DiaryPageBase implements IMobileUtils {

    public DiaryPage(WebDriver driver) {
        super(driver);
    }

    private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

    @FindBy(xpath = "//androidx.appcompat.widget.LinearLayoutCompat" +
            "//preceding-sibling::android.widget.TextView")
    private ExtendedWebElement title;

    @FindBy(id = "com.myfitnesspal.android:id/edit_action_item")
    private ExtendedWebElement editDiaryIcon;

    @FindBy(id = "com.myfitnesspal.android:id/goal")
    private ExtendedWebElement caloriesGoal;

    @FindBy(id = "com.myfitnesspal.android:id/remaining_diary")
    private ExtendedWebElement caloriesRemaining;

    @FindBy(xpath = "//android.widget.LinearLayout[@resource-id='com.myfitnesspal.android:id/daily_summary_container']" +
            "//android.widget.ImageView")
    private ExtendedWebElement dashboardMoreButton;

    @FindBy(xpath = "(//android.widget.TextView[@text='%s']" +
            "/../../following-sibling::android.widget.LinearLayout)[1]" +
            "/android.view.ViewGroup/android.widget.Button[@resource-id='com.myfitnesspal.android:id/more']")
      private ExtendedWebElement moreButton;

    @FindBy(id = "com.myfitnesspal.android:id/custom")
    private MoreModel moreModel;

    @Override
    public boolean isOpened() {
        return title.isElementPresent()
                && title.getText().equals(BottomNavigationBarItem.DIARY_BUTTON.getButtonName())
                && !(initPage(getDriver(), MFPCommonPageBase.class))
                .getBottomNavigateBar()
                .isBottomNavBarButtonClickable(BottomNavigationBarItem.DIARY_BUTTON);

    }

    @Override
    public int getCaloriesGoalIntValue() {
        return Integer.parseInt(StringUtils.remove(caloriesGoal.getText(), ','));
    }

    @Override
    public int getCaloriesRemainingIntValue() {
        return Integer.parseInt(StringUtils.remove(caloriesRemaining.getText(), ','));
    }

    @Override
    public DiaryPageBase clearUserDiary() {
        if (editDiaryIcon.isElementPresent()) {
            editDiaryIcon.click();
            EditDiaryPageBase editDiaryPage = initPage(getDriver(), EditDiaryPageBase.class);
            Assert.assertTrue(editDiaryPage.isOpened(),
                    "[Edit Diary Page] Edit Diary Page is not opened after clicking Edit Diary Icon!");
            DiaryPageBase diaryPage = editDiaryPage.deleteAllItems();
            return diaryPage;
        } else {
            LOGGER.info("Diary Page already cleared, so no need to clean it!");
            return initPage(getDriver(), DiaryPageBase.class);
        }
    }

    @Override
    public AbstractPage openPageFromMoreModel(DiaryMealTitle diaryMealTitle, MoreModelElement element) {
        Assert.assertTrue(swipe(moreButton.format(diaryMealTitle.getTitle()), Direction.VERTICAL, 3, 500),
                String.format("[Diary Page] There is no more button for title %s", diaryMealTitle.getTitle()));
        moreButton.format(diaryMealTitle.getTitle()).click();
        Assert.assertTrue(moreModel.isOpened(),
                "[Diary Page] More Model is not opened after clicking More Button!");
        return moreModel.openPage(element);
    }

    @Override
    public CustomDashboardPageBase openCustomDashboardPage() {
        Assert.assertTrue(dashboardMoreButton.isElementPresent(),
                "[Diary Page] Dashboard More Button is not present!");
        dashboardMoreButton.click();
        return initPage(getDriver(), CustomDashboardPageBase.class);
    }
}
