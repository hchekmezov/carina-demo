package com.mfp.mobile.gui.pages.ios.diary;

import com.mfp.mobile.gui.pages.common.diary.RemindersPageBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import org.openqa.selenium.WebDriver;

@DeviceType(pageType = DeviceType.Type.IOS_PHONE, parentClass = RemindersPageBase.class)
public class RemindersPage extends RemindersPageBase {
    public RemindersPage(WebDriver driver) {
        super(driver);
    }
}
