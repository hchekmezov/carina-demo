package com.mfp.mobile.gui.pages.ios.diary;

import com.mfp.mobile.gui.pages.common.diary.DeletePanelBase;
import com.mfp.mobile.gui.pages.common.diary.DiaryPageBase;
import com.zebrunner.carina.utils.exception.NotImplementedException;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.utils.factory.ICustomTypePageFactory;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;

@DeviceType(pageType = DeviceType.Type.IOS_PHONE, parentClass = DeletePanelBase.class)
public class DeletePanel extends DeletePanelBase implements ICustomTypePageFactory {

    public DeletePanel(WebDriver driver) {
        super(driver);
    }

    public DeletePanel(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    @Override
    public boolean isPanelPresent() {
        throw new NotImplementedException();
    }

    @Override
    public DiaryPageBase clickDeleteButton() {
        throw new NotImplementedException();
    }
}
