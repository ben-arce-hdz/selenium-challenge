package com.selenium.uiautomation.util;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;
import org.springframework.util.FileCopyUtils;

import java.io.IOException;
import java.nio.file.Path;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;

@Lazy
@Service
public class ScreenShotUtil {

    private static final String PNG = ".png";
    private static final String IMAGE = "image_";
    private final SimpleDateFormat sdf = new SimpleDateFormat("yy.MM.dd.HH.mm.ss");

    private @Value("${screenshot.path}") Path path;
    private @Autowired ApplicationContext ctx;

    public byte[] takeScreenShot() throws IOException {
        var sourceFile = this.ctx.getBean(TakesScreenshot.class).getScreenshotAs(OutputType.FILE);
        var timestamp = new Timestamp(System.currentTimeMillis());
        FileCopyUtils.copy(sourceFile, path.resolve(IMAGE + sdf.format(timestamp) + PNG).toFile());
        return FileUtils.readFileToByteArray(sourceFile);
    }
}