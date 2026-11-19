package listeners;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import base.BaseTest;
import utils.ScreenshotUtil;

public class TestListener
        implements ITestListener {

    @Override
    public void onTestStart(
            ITestResult result) {
        System.out.println(
                result.getName()
                        + " Started");
    }

    @Override
    public void onTestSuccess(
            ITestResult result) {
        System.out.println(
                result.getName()
                        + " Passed");
    }

    @Override
    public void onTestFailure(
            ITestResult result) {
        System.out.println(
                result.getName()
                        + " Failed");

        WebDriver driver =
                ((BaseTest) result.getInstance())
                        .getDriver();

        ScreenshotUtil
                .captureScreenshot(
                        driver,
                        result.getName());
    }

    @Override
    public void onFinish(
            ITestContext context) {
        System.out.println(
                "Execution Complete");
    }
}
