//package utils;
//
//import com.codeborne.selenide.Screenshots;
//
//import com.google.common.io.Files;
//import io.qameta.allure.Attachment;
//import org.apache.commons.io.FileUtils;
//import org.openqa.selenium.OutputType;
//import org.openqa.selenium.TakesScreenshot;
//
//import java.io.File;
//import java.io.IOException;
//
//import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
//
////public class AllureUtils {
////    @Attachment(value="screenshot",type = "image/png")
////    public static byte[] screenshot() throws IOException {
////        File screenshot = Screenshots.getLastScreenshot();
////        FileUtils.copyFile(screenshot, new File("target\\allure-results\\screenshots\\" + screenshot.getName()));
////        return Files.toByteArray(screenshot);
////    }
//    public class AllureUtils {
//        @Attachment(value="screenshot", type = "image/png")
//        public static byte[] takeScreenshot(){
//            return ((TakesScreenshot)getWebDriver()).getScreenshotAs(OutputType.BYTES);
//        }
//}