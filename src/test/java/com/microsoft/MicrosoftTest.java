package com.microsoft;


import com.desktop.MicrosoftPage;
import com.qaprosoft.carina.core.foundation.IAbstractTest;
import com.zebrunner.carina.core.registrar.ownership.MethodOwner;
import com.zebrunner.carina.utils.R;
import com.zebrunner.carina.utils.resources.L10N;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.List;

public class MicrosoftTest implements IAbstractTest {

    @Test
    @MethodOwner(owner = "hchekmezov")
    public void microsoftTest() {
        MicrosoftPage microsoftPage = new MicrosoftPage(getDriver());
        microsoftPage.open();

        Assert.assertEquals(L10N.getText("MicrosoftPage.educationDiv"), microsoftPage.getEducationDivText(),
                "Not equals!");

        SoftAssert softAssert = new SoftAssert();
        List<String> lst = microsoftPage.getEducationLinksText();
        for(int i = 0; i < lst.size(); i++) {
            softAssert.assertEquals(L10N.getText("MicrosoftPage.educationLinks" + i),
                    lst.get(i), "Not equals!");
        }
        softAssert.assertAll();

        R.CONFIG.put("locale", "uk_UA", true);
        L10N.setLocale("uk_UA");
        L10N.load();

        microsoftPage = new MicrosoftPage(getDriver());
        microsoftPage.open();

        Assert.assertEquals(L10N.getText("MicrosoftPage.educationDiv"), microsoftPage.getEducationDivText(),
                "Not equals!");

        softAssert = new SoftAssert();
        lst = microsoftPage.getEducationLinksText();
        for(int i = 0; i < lst.size(); i++) {
            softAssert.assertEquals(L10N.getText("MicrosoftPage.educationLinks" + i),
                    lst.get(i), "Not equals!");
        }
        softAssert.assertAll();

    }
}
