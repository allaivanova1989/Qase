package tests;

import lombok.extern.log4j.Log4j2;

import org.testng.ITestListener;
import org.testng.ITestResult;
import utils.AllureUtils;


@Log4j2
public class TestListener implements ITestListener {

    public void onTestFailure(ITestResult result) {

       AllureUtils.takeScreenshot();
       log.info("Test failed: %s \n", result.getName());

    }


}