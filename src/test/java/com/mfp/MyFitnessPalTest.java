package com.mfp;

import com.mfp.mobile.gui.pages.common.*;
import com.mfp.mobile.gui.pages.common.BottomNavigationBarItem;
import com.mfp.mobile.gui.pages.common.diary.*;
import com.mfp.mobile.gui.pages.common.diary.customDashboard.CustomDashboardItem;
import com.mfp.mobile.gui.pages.common.diary.customDashboard.CustomDashboardPageBase;
import com.mfp.mobile.gui.pages.common.diary.customDashboard.CustomSummaryNutrient;
import com.mfp.mobile.gui.pages.common.diary.customDashboard.CustomSummaryPageBase;
import com.qaprosoft.carina.core.foundation.IAbstractTest;
import com.zebrunner.agent.core.registrar.Screenshot;
import com.zebrunner.carina.core.registrar.ownership.MethodOwner;
import com.zebrunner.carina.utils.R;
import com.zebrunner.carina.utils.mobile.IMobileUtils;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;


public class MyFitnessPalTest implements IAbstractTest, IMobileUtils {

    @Test(enabled = false)
    @MethodOwner(owner = "hchekmezov")
    public void bottomMenuItemsTest() {
        MFPCommonPageBase mfpCommonPage = initPage(getDriver(), MFPCommonPageBase.class);
        DashboardPageBase dashboardPage = mfpCommonPage.login(R.TESTDATA.get("email"),
                                                                        R.TESTDATA.get("password"));
        Assert.assertTrue(dashboardPage.isOpened(),
                "[Dashboard Page] Dashboard Page is not opened after clicking Log In Button!");
        DiaryPageBase diaryPage = (DiaryPageBase) mfpCommonPage.getBottomNavigateBar().
                                    clickBottomNavBarButton(BottomNavigationBarItem.DIARY_BUTTON);
        Assert.assertTrue(diaryPage.isOpened(),
                "[Diary Page] Diary Page is not opened after clicking Diary Icon!");
        NewsfeedPageBase newsfeedPage = (NewsfeedPageBase) mfpCommonPage.getBottomNavigateBar().
                                    clickBottomNavBarButton(BottomNavigationBarItem.NEWSFEED_BUTTON);
        Assert.assertTrue(newsfeedPage.isOpened(),
                "[Newsfeed Page] Newsfeed Page is not opened after clicking Newsfeed Icon!");
        PlansPageBase plansPage = (PlansPageBase) mfpCommonPage.getBottomNavigateBar().
                clickBottomNavBarButton(BottomNavigationBarItem.PLANS_BUTTON);
        Assert.assertTrue(plansPage.isOpened(),
                "[Plans Page] Plans Page is not opened after clicking Plans Icon!");
        MorePageBase morePage = (MorePageBase) mfpCommonPage.getBottomNavigateBar().
                clickBottomNavBarButton(BottomNavigationBarItem.MORE_BUTTON);
        Assert.assertTrue(morePage.isOpened(),
                "[More Page] More Page is not opened after clicking More Icon!");

    }

    @Test(enabled = false)
    @MethodOwner(owner = "hchekmezov")
    public void caloriesEqualsTest() {
        // 1
        MFPCommonPageBase mfpCommonPage = initPage(getDriver(), MFPCommonPageBase.class);
        DashboardPageBase dashboardPage = mfpCommonPage.login(R.TESTDATA.get("email"),
                R.TESTDATA.get("password"));
        Assert.assertTrue(dashboardPage.isOpened(),
                "[Dashboard Page] Dashboard Page is not opened after logging in!");
        DiaryPageBase diaryPage = (DiaryPageBase) mfpCommonPage.getBottomNavigateBar().
                clickBottomNavBarButton(BottomNavigationBarItem.DIARY_BUTTON);
        Assert.assertTrue(diaryPage.isOpened(),
                "[Diary Page] Diary Page is not opened after clicking Diary Icon!");
        // 2
        diaryPage = diaryPage.clearUserDiary();
        Assert.assertEquals(diaryPage.getCaloriesGoalIntValue(), diaryPage.getCaloriesRemainingIntValue(),
                "[Diary Page] Calories Goal value is not the same as Calories Remaining value!");
    }

    @Test(enabled = false)
    @MethodOwner(owner = "hchekmezov")
    public void caloriesQuickAddTest() {
        // 1
        MFPCommonPageBase mfpCommonPage = initPage(getDriver(), MFPCommonPageBase.class);
        DashboardPageBase dashboardPage = mfpCommonPage.login(R.TESTDATA.get("email"),
                R.TESTDATA.get("password"));
        Assert.assertTrue(dashboardPage.isOpened(),
                "[Dashboard Page] Dashboard Page is not opened after logging in!");
        DiaryPageBase diaryPage = (DiaryPageBase) mfpCommonPage.getBottomNavigateBar().
                clickBottomNavBarButton(BottomNavigationBarItem.DIARY_BUTTON);
        Assert.assertTrue(diaryPage.isOpened(),
                "[Diary Page] Diary Page is not opened after clicking Diary Icon!");
        // 2
        QuickAddPageBase quickAddPage = (QuickAddPageBase) diaryPage.openPageFromMoreModel(DiaryMealTitle.SNACKS,
                MoreModelElement.QUICK_ADD);
        Assert.assertTrue(quickAddPage.isOpened(),
                "[Quick Add Page] Quick Add Page is not opened!");
        // 3
        quickAddPage.typeNutrients(IConstant.ONE, IConstant.ONE, IConstant.ONE);
        hideKeyboard();
        Assert.assertEquals(quickAddPage.getCaloriesIntValue(), IConstant.SEVENTEEN,
                "[Quick Add Page] Wrong calories value!");
    }

    @Test(enabled = false)
    @MethodOwner(owner = "hchekmezov")
    public void customSummaryPageTest() {
        SoftAssert softAssert = new SoftAssert();
        // 1
        MFPCommonPageBase mfpCommonPage = initPage(getDriver(), MFPCommonPageBase.class);
        DashboardPageBase dashboardPage = mfpCommonPage.login(R.TESTDATA.get("email"),
                R.TESTDATA.get("password"));
        Assert.assertTrue(dashboardPage.isOpened(),
                "[Dashboard Page] Dashboard Page is not opened after logging in!");
        DiaryPageBase diaryPage = (DiaryPageBase) mfpCommonPage.getBottomNavigateBar().
                clickBottomNavBarButton(BottomNavigationBarItem.DIARY_BUTTON);
        Assert.assertTrue(diaryPage.isOpened(),
                "[Diary Page] Diary Page is not opened after clicking Diary Icon!");
        // 2
        CustomDashboardPageBase customDashboardPage = diaryPage.openCustomDashboardPage();
        Assert.assertTrue(customDashboardPage.isOpened(),
                "[Custom Dashboard Page] Custom Dashboard Page is not opened!");
        // 3
        CustomSummaryPageBase customSummaryPage =
                (CustomSummaryPageBase) customDashboardPage.clickCustomDashboardItem(CustomDashboardItem.CUSTOM);
        Assert.assertTrue(customSummaryPage.isOpened(),
                "[Custom Summary Page] Custom Summary Page in not opened!");
        CustomSummaryNutrient[] neededNutrients = {CustomSummaryNutrient.FAT, CustomSummaryNutrient.PROTEIN,
                                                    CustomSummaryNutrient.CARBOHYDRATES};
        for(CustomSummaryNutrient nutrient: neededNutrients) {
            softAssert.assertTrue(customSummaryPage.isNutrientChecked(nutrient),
                    String.format("[Custom Summary Page] Nutrient %s is not checked by default!", nutrient));
        }
        softAssert.assertAll();
    }

    @Test()
    @MethodOwner(owner = "hchekmezov")
    public void nutrientsValidationTest() {
        SoftAssert softAssert = new SoftAssert();
        // 1
        MFPCommonPageBase mfpCommonPage = initPage(getDriver(), MFPCommonPageBase.class);
        DashboardPageBase dashboardPage = mfpCommonPage.login(R.TESTDATA.get("email"),
                R.TESTDATA.get("password"));
        Assert.assertTrue(dashboardPage.isOpened(),
                "[Dashboard Page] Dashboard Page is not opened after logging in!");
        DiaryPageBase diaryPage = (DiaryPageBase) mfpCommonPage.getBottomNavigateBar().
                clickBottomNavBarButton(BottomNavigationBarItem.DIARY_BUTTON);
        Assert.assertTrue(diaryPage.isOpened(),
                "[Diary Page] Diary Page is not opened after clicking Diary Icon!");
        // 2
        CustomDashboardPageBase customDashboardPage = diaryPage.openCustomDashboardPage();
        Assert.assertTrue(customDashboardPage.isOpened(),
                "[Custom Dashboard Page] Custom Dashboard Page is not opened!");
        // 3
        CustomSummaryPageBase customSummaryPage =
                (CustomSummaryPageBase) customDashboardPage.clickCustomDashboardItem(CustomDashboardItem.CUSTOM);
        Assert.assertTrue(customSummaryPage.isOpened(),
                "[Custom Summary Page] Custom Summary Page in not opened!");
        Assert.assertTrue(customSummaryPage.isSpinnerRoundingOver(),
                "[Custom Summary Page] Rounding spinner is not disappeared!");
        // 4
        Assert.assertEquals(customSummaryPage.getSelectedNutrientInfoText(), IConstant.NUTRIENT_SELECTED_3_OF_3,
                "[Custom Summary Page] The text doesn't match!");
        Assert.assertTrue(customSummaryPage.isSaveButtonPresent(),
                "[Custom Summary Page] Save Button is not present!");
        Assert.assertTrue(customSummaryPage.isSaveButtonEnabled(),
                "[Custom Summary Page] Save button is not active by default!");
        // 5
        customSummaryPage.uncheckNutrient(CustomSummaryNutrient.FAT);
        Assert.assertFalse(customSummaryPage.isNutrientChecked(CustomSummaryNutrient.FAT),
                String.format("[Custom Summary Page] Nutrient %s is checked after unchecking!",
                        CustomSummaryNutrient.FAT));
        Assert.assertEquals(customSummaryPage.getSelectedNutrientInfoText(), IConstant.NUTRIENT_SELECTED_2_OF_3,
                "[Custom Summary Page] The text doesn't match!");
        Assert.assertFalse(customSummaryPage.isSaveButtonEnabled(),
                "[Custom Summary Page] Save button is active while it should not be!");
        // 6
        CustomSummaryNutrient[] neededNutrients = {CustomSummaryNutrient.FAT,
                                                            CustomSummaryNutrient.VITAMIN_C};
        for(CustomSummaryNutrient nutrient : neededNutrients) {
            customSummaryPage.checkNutrient(nutrient);
            softAssert.assertTrue(customSummaryPage.isNutrientChecked(nutrient),
                    String.format("[Custom Summary Page] Nutrient %s is not checked after checking it!", nutrient));
        }
        softAssert.assertAll();
        Assert.assertEquals(customSummaryPage.getSelectedNutrientInfoText(), IConstant.NUTRIENT_SELECTED_4_OF_3,
                "[Custom Summary Page] The text doesn't match!");
        Assert.assertFalse(customSummaryPage.isSaveButtonEnabled(),
                "[Custom Summary Page] Save button is active while it should not be!");
    }
}
