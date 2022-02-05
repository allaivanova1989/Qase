package utils;

import com.codeborne.selenide.Screenshots;

import com.google.common.io.Files;
import io.qameta.allure.Attachment;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;

public class AllureUtils {
    @Attachment(value="{0}",type = "image/png")
    public static byte[] takescreenshot() throws IOException {
        File screenshot = Screenshots.getLastScreenshot();
        FileUtils.copyFile(screenshot, new File("target\\allure-results\\screenshots\\" + screenshot.getName()));
        return Files.toByteArray(screenshot);
    }
}