package utils;

import com.aventstack.extentreports.ExtentTest;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class BaseTestClass {
    protected WebDriver driver;
    protected ExtentTest test;

    // Method to initialize WebDriver (can be customized based on your setup)
    @BeforeClass
    public void setup() {
        driver = DriverSetup.getDriver();
    }

    // Method to quit WebDriver
    @AfterClass
    public void teardown() {
        if (driver != null) {
            driver.quit();
        }
        ExtentManager.flush();
    }

    // Method to capture screenshot
    public String takeScreenshot(String testName) {
        TakesScreenshot ts = (TakesScreenshot) driver;
        File source = ts.getScreenshotAs(OutputType.FILE);
        String dest = "target/screenshots/" + testName + ".png";
        try {
            FileHandler.copy(source, new File(dest));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return dest;
    }

    public void implictWait() {
        int time = Integer.parseInt(CommonMethods.readPropertiesFile("waitTime"));
        driver.manage().timeouts().implicitlyWait(time, TimeUnit.SECONDS);
    }

    // Method to read data from Excel file
   /* public String readDataFromExcel(String filePath, int sheetIndex, int rowNum, int cellNum) {
        String cellValue = null;
        try (FileInputStream fis = new FileInputStream(new File(filePath));
             Workbook workbook = new XSSFWorkbook(fis)) {
            Sheet sheet = workbook.getSheetAt(sheetIndex);
            Row row = sheet.getRow(rowNum);
            Cell cell = row.getCell(cellNum);
            cellValue = cell.getStringCellValue();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return cellValue;
    }*/
}
