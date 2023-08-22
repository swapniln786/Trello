package HandlingDropdowns;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class CheckForDefaultSelectedOption {
public static void main(String[] args) {
	WebDriver  driver=new ChromeDriver();
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	driver.get("https://www.facebook.com/");
	driver.navigate().to("https://www.facebook.com/signup");
	//identify the day dropdown
	WebElement day = driver.findElement(By.id("day"));
	Select daySelect=new Select(day);
	String selectedDayOption = daySelect.getFirstSelectedOption().getText();
	System.out.println("Selected Day Option = "+selectedDayOption);
	//identify the month dropdown
	WebElement month = driver.findElement(By.id("month"));
	Select monthSelect=new Select(month);
	String selectedMonthOption = monthSelect.getFirstSelectedOption().getText();
	System.out.println("Selected Month Option = "+selectedMonthOption);
	//identify the year dropdown
	WebElement year = driver.findElement(By.id("year"));
	Select selectYear=new Select(year);
	String selectedYearOption = selectYear.getFirstSelectedOption().getText();
	System.out.println("Selected Year Option = "+selectedYearOption);
	driver.manage().window().minimize();
	driver.quit();
	
	
}
}
