package test.pageobjects;

import application.page.base.ApplicationPageBase;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import page.objects.HomePage;
import page.objects.LogIn;
import reporting.TestLogger;
import sheet.google.api.GoogleSheetReader;

import java.io.IOException;
import java.util.List;
import java.util.Properties;


    public class GoogleSheetLoginTest extends ApplicationPageBase {

        LogIn objLoginPage = null;
        HomePage objHomePage = null;


        @BeforeMethod
        public void initializationOfElements() {

            objLoginPage= PageFactory.initElements(driver, LogIn.class);
            objHomePage = PageFactory.initElements(driver, HomePage.class);
        }

        /**
         *
         * Read data from Google Sheet
         * Make sure you have created client_secret.json from your account where you have Google Sheet Data file
         * Delete .credentials directory from your module if it is exists. Other wise it will take existing/old credentials
         * thus it may give unauthorized access error(error code starting with 4, such as 403,404)
         * We can supply data to test method by two ways
         * 1. We can use @DataProvider to feed data to the test method
         * 2. We can supply data to the test method directly
         *
         * */

        @DataProvider(name = "googleSheet")
        public Object[][] getTestDataFromGoogleSheet() throws IOException {

            Properties properties = loadProperties();
            String spreadsheetId = properties.getProperty("GOOGLE.spreadsheetId");
            String range = properties.getProperty("GOOGLE.range");
            /**
             *
             * Two ways to convert  List to Array in GoogleSheetReader.java class
             * Both method will give data from Google Sheet
             *
             * */
            //  String[][] data = GoogleSheetReader.getSpreadSheetRecordsToSupplyDataProvider(spreadsheetId, range);
            String[][] data = GoogleSheetReader.getSpreadSheetRecordsToSupplyDataProviderAlternativeWay(spreadsheetId,range);
            return data;

        }



        @Test(dataProvider = "googleSheet")
        public  void invalidSignin(String email, String password, String expectedErroMessage){

            objHomePage.getLogIn();
            objLoginPage.login(email, password);
            String expectedText = expectedErroMessage;
            String actulText = objLoginPage.getErroMessage();
            Assert.assertEquals(actulText, expectedText);

        }

        /**
         *
         * Second way to feed data to @Test method
         * 2. We can supply data to the test method directly
         * This test is disabled if you like to run this you have to make enabled = true
         *
         * */
        @Test(enabled = false)
        public  void invalidSigninByGoogleSheetApi() throws IOException {

            Properties properties = loadProperties();
            String spreadsheetId = properties.getProperty("GOOGLE.spreadsheetId");
            String range = properties.getProperty("GOOGLE.range");
            TestLogger.log("Using Sheet Number " + range.charAt(5)+ " and fields range  " + range.substring(6));
            List<List <Object>> getRecords = GoogleSheetReader.getSpreadSheetRecords(spreadsheetId,range);

            objHomePage.getLogIn();

            for (List cell: getRecords) {

                objLoginPage.login(cell.get(0).toString(), cell.get(1).toString());

                String expectedText = cell.get(2).toString();

                String actulText = objLoginPage.getErroMessage();
                Assert.assertEquals(actulText, expectedText);

            }
        }
    }

