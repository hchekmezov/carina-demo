package com.mfp.mobile.gui.pages.ios;

import com.mfp.mobile.gui.pages.common.ConfirmationMessagePanelBase;
import com.mfp.mobile.gui.pages.common.LogInPageBase;
import com.zebrunner.carina.utils.exception.NotImplementedException;
import com.zebrunner.carina.utils.factory.DeviceType;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;

@DeviceType(pageType = DeviceType.Type.IOS_PHONE, parentClass = ConfirmationMessagePanelBase.class)
public class ConfirmationMessagePanel extends ConfirmationMessagePanelBase {
    public ConfirmationMessagePanel(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    @Override
    public boolean isPresent() {
       throw new NotImplementedException();
    }

    @Override
    public LogInPageBase clickOkButton() {
        throw new NotImplementedException();
    }
}
