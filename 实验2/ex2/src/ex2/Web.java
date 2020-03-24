package ex2;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;

import jxl.read.biff.BiffException;

public class Web {
	
	private static String url = "http://103.120.226.190/selenium-demo/git-repo";
	private static WebDriver driver;
	
	public Web() {
		
		System.setProperty("webdriver.gecko.driver", "firefox\\geckodriver.exe");
		System.setProperty("webdriver.firefox.bin","E:\\firefox.exe"); 
		
		driver = new FirefoxDriver();
		
		driver.manage().timeouts().implicitlyWait(500,  TimeUnit.MILLISECONDS);
		
		driver.get(url);
	}
	
	public boolean test(String sid, String gitAddress) {
		
		WebElement username = driver.findElement(By.xpath("/html/body/div/div/div/div/div/div/div[2]/div/form/div[1]/input"));
		WebElement password = driver.findElement(By.xpath("/html/body/div/div/div/div/div/div/div[2]/div/form/div[2]/input"));
		WebElement submit = driver.findElement(By.xpath("/html/body/div/div/div/div/div/div/div[2]/div/form/div[3]/input"));
		
		username.clear();
		password.clear();
		
		username.sendKeys(sid);
		password.sendKeys(gitAddress);
		submit.click();
		
		WebElement info = driver.findElement(By.xpath("/html/body/div/div/div/div/div/div/div[2]/div/form/div[5]/code"));
		String userinfo = info.getText();
//		System.out.println(userinfo);
		
		if (userinfo.equals(gitAddress)) {
			System.out.println("用户" + sid + "信息正确！");
			return true;
		} else {
			System.out.println("错误：用户" + sid + "的信息应为" + gitAddress + ", 输出为" + userinfo);
			return false;
		}
	}
	
	public static void main(String[] args) throws BiffException, IOException {
		
		Web webTest = new Web();
		ReadExcel excel = new ReadExcel("Selenium Lab2020.xls");
		
		String [][] data = excel.getData(0);
		
		boolean isAllPass = true;
		
		for (int i = 0; i < data.length; i++) {
			System.out.print((i + 1) + " : ");
			isAllPass &= webTest.test(data[i][1], data[i][2]);
		}
		
		
		if (isAllPass) {
			System.out.println("恭喜！所有的用户信息都正确！");
		}
	}
	
}
