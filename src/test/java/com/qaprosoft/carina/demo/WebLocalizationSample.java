package com.qaprosoft.carina.demo;

import com.qaprosoft.carina.core.foundation.AbstractTest;
import com.qaprosoft.carina.core.foundation.utils.Configuration;
import com.qaprosoft.carina.core.foundation.utils.ownership.MethodOwner;
import com.qaprosoft.carina.core.foundation.utils.resources.L10N;
import com.qaprosoft.carina.core.foundation.utils.resources.L10Nparser;
import com.qaprosoft.carina.demo.gui.pages.localizationSample.WikipediaHomePage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.lang.invoke.MethodHandles;
import java.util.Locale;

/**
 * This sample shows how create Web Localization test with Resource Bundle.
 *
 * @author qpsdemo
 */

public class WebLocalizationSample extends AbstractTest {

    private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

    @Test
    @MethodOwner(owner = "qpsdemo")
    public void testLanguages() {

        WikipediaHomePage wikipediaHomePage = new WikipediaHomePage(getDriver());
        wikipediaHomePage.open();

        String welcomeText = wikipediaHomePage.getWelcomeText();
        String expectedWelcomeText = L10N.getText("HomePage.welcomeText");

        Assert.assertEquals(welcomeText, expectedWelcomeText, "Wikipedia welcome text was not the expected.");
    }

    @Test
    @MethodOwner(owner = "qpsdemo")
    /**
     * Do not execute on CI. Config properties should be filled correctly.
     * For example: for Japan language you should use:
     * locale=ja_JP
     * language=ja_JP
     * browser_language=ja_JP
     *
     * add_new_localization=true - for creation and false for checking.
     * add_new_localization_path=./src/main/resources/L10N/
     * add_new_localization_encoding=ISO-2022-JP
     * add_new_localization_property_name=locale_
     * Read more details in com.qaprosoft.carina.core.foundation.utils.resources.L10Nparser
     */
    public void testAddNewLanguages() {

        WikipediaHomePage wikipediaHomePage = new WikipediaHomePage(getDriver());
        wikipediaHomePage.open();

        String welcomeText = wikipediaHomePage.getWelcomeText();
        String expectedWelcomeText = L10N.getText("HomePage.welcomeText");
        SoftAssert sa = new SoftAssert();
        sa.assertEquals(welcomeText, expectedWelcomeText, "Wikipedia welcome text was not the expected.");

        // To set correct locale for creating new localization text.
        // Can be changed dynamically during test execution.
        L10Nparser.setActualLocale(Configuration.get(Configuration.Parameter.LOCALE));

        Locale actualLocale = L10Nparser.getActualLocale();
        LOGGER.info(actualLocale.toString());

        sa.assertTrue(wikipediaHomePage.checkLocalization(actualLocale), "Localization error: " + L10Nparser.getAssertErrorMsg());
        sa.assertTrue(wikipediaHomePage.checkMultipleLocalization(actualLocale), "Localization error: " + L10Nparser.getAssertErrorMsg());
        sa.assertAll();
    }

}