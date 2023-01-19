package com.qaprosoft.carina.demo.myMobile.android;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.demo.myMobile.android.enums.ZoomButton;
import com.qaprosoft.carina.demo.myMobile.common.MapPageBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = MapPageBase.class)
public class MapPage extends MapPageBase {

    @FindBy(xpath = "//android.widget.TextView[@text='Map']")
    private ExtendedWebElement pageTitle;

    @FindBy(xpath = "//android.widget.FrameLayout[@resource-id=\"com.solvd.carinademoapplication:id/content_frame\"]" +
            "//android.widget.ImageView[@clickable='false']")
    private ExtendedWebElement googleImage;

    @FindBy(xpath = "//android.widget.ImageView[@content-desc=\"Zoom in\"]")
    private ExtendedWebElement zoomInButton;

    @FindBy(xpath = "//android.widget.ImageView[@content-desc=\"Zoom out\"]" +
            "/preceding-sibling::android.widget.ImageView[@content-desc=\"Zoom in\"]")
    private ExtendedWebElement zoomOutButton;
    // following-sibling – возвращает множество элементов на том же уровне, следующих за текущим.
    // preceding-sibling – возвращает множество элементов на том же уровне, предшествующих текущему.

    public MapPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isOpened() {
        return googleImage.isElementPresent() && pageTitle.isElementPresent();
    }

    @Override
    public boolean isZoomButtonPresent(ZoomButton zoomButton) {
        if (zoomButton.equals(ZoomButton.OUT)) {
            return zoomOutButton.isElementPresent();
        } else {
            return zoomInButton.isElementPresent();
        }
    }
}
