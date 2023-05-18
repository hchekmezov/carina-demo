package com.mfp.mobile.gui.pages.ios.diary;

import com.mfp.mobile.gui.pages.common.diary.DiaryPageBase;
import com.mfp.mobile.gui.pages.common.diary.EditDiaryPageBase;
import com.zebrunner.carina.utils.exception.NotImplementedException;
import com.zebrunner.carina.utils.factory.DeviceType;
import org.openqa.selenium.WebDriver;

@DeviceType(pageType = DeviceType.Type.IOS_PHONE, parentClass = EditDiaryPageBase.class)
public class EditDiaryPage extends EditDiaryPageBase {

    public EditDiaryPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isOpened() {
        throw new NotImplementedException();
    }

    @Override
    public DiaryPageBase deleteAllItems() {
        throw new NotImplementedException();
    }
}
