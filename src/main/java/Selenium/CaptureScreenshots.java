package Selenium;

import java.awt.AWTException;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class CaptureScreenshots {

	
	public static void captureSSUsingTakesScreenshot(){
		
		
	}
	
	public static void captureSSUsingTakesScreenshot(WebDriver driver,String sScreenshotFile) throws IOException{
		TakesScreenshot tss = (TakesScreenshot) driver;
		
		File image = tss.getScreenshotAs(OutputType.FILE);
		
		FileUtils.copyFile(image, new File ("./Screenshot/"+sScreenshotFile+"_"+System.currentTimeMillis()+".jpeg"));
		
	}
	
	public static void captureSSUsingRobot(String sScreenshotFile) throws AWTException, IOException {
		
		Robot robo = new Robot();
		
		Rectangle rect = new Rectangle(Toolkit.getDefaultToolkit().getScreenSize());
		
		BufferedImage image = robo.createScreenCapture(rect);
		
		ImageIO.write(image, "jpeg", new File ("./Screenshot/"+sScreenshotFile+"_"+System.currentTimeMillis()+".jpeg"));
	}
}
