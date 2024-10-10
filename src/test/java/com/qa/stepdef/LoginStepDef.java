package com.qa.stepdef;

import com.qa.Data.ExcelUtils;
import com.qa.pages.LoginPage;
import com.qa.pages.ProductsPage;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.Assert;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class LoginStepDef {

    private ExcelUtils excelUtils;
    private String filePath = System.getProperty("user.dir") + "\\src\\test\\java\\com\\qa\\Data\\Test_Data.xlsx"; // Dynamic path

    @Before
    public void setUp() throws IOException {
        excelUtils = new ExcelUtils(filePath);
    }




    @Given("I am on Homepage of application")
    public void verifyHomepage()
    {

    }



    @When("I click on login button")
    public void iLogin() {
        new LoginPage().pressLoginBtn();
    }

    @When("I enter username and password from excel")
    public void enterUsernameAndPasswordFromExcel() throws IOException, InterruptedException {


        String username = excelUtils.getCellValue(1, 0);
        String password = excelUtils.getCellValue(1, 1);

        new LoginPage().enterUserName(username);
        new LoginPage().enterPassword(password);

        }


        @Then("login should fail with an error")
        public void loginShouldFailWithAnError()
        {
           String err=excelUtils.getCellValue(1, 2);
            System.out.println(err);
            Assert.assertEquals(new LoginPage().getErrTxt(), err);
        }


    @Then("I should see Products page with title")
    public void iShouldSeeProductsPageWithTitle() {
        String title = excelUtils.getCellValue(2, 3);
       Assert.assertEquals(new ProductsPage().getTitle(), title);
    }

    @When("I enter correct username and password")
    public void entervalidUsernameAndPassword() throws InterruptedException {
        String username = excelUtils.getCellValue(2, 0);
        String password = excelUtils.getCellValue(2, 1);

        new LoginPage().enterUserName(username);
        new LoginPage().enterPassword(password);
    }
}
