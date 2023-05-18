package com.mfp.mobile.gui.pages.android.diary;

import com.mfp.mobile.gui.pages.common.diary.DiaryPageBase;
import com.mfp.mobile.gui.pages.common.diary.EditDiaryPageBase;
import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.utils.factory.DeviceType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = EditDiaryPageBase.class)
public class EditDiaryPage extends EditDiaryPageBase {
    public EditDiaryPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "com.myfitnesspal.android:id/select_all")
    private ExtendedWebElement selectAllCheckbox;

    @FindBy(xpath = "//android.widget.CheckBox[@resource-id='com.myfitnesspal.android:id/select_all']" +
            "//preceding-sibling::android.widget.TextView")
    private ExtendedWebElement selectAllTextView;

    @FindBy(id = "com.myfitnesspal.android:id/nutrition_action_item")
    private ExtendedWebElement trashBinIcon;

    @FindBy(id = "com.myfitnesspal.android:id/parentPanel")
    private DeletePanel deletePanel;

    @Override
    public boolean isOpened() {
        return selectAllCheckbox.isElementPresent()
                && selectAllTextView.isElementPresent();
    }

    @Override
    public DiaryPageBase deleteAllItems() {
        selectAllCheckbox.check();
        trashBinIcon.click();
        Assert.assertTrue(deletePanel.isPanelPresent(),
                "[Edit Diary Page] Delete Panel is not present after clicking trashBinIcon!");
        DiaryPageBase diaryPage = deletePanel.clickDeleteButton();
        return diaryPage;
    }
}
