package SGS.AbstractComponents;


import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.WebDriver;



public class AbstractComponent {

	WebDriver driver;

	public AbstractComponent(WebDriver driver) {
		this.driver = driver;
	}
	
	@SuppressWarnings("unused")
	public void switchToWindow() {
		
		Set <String> handles =driver.getWindowHandles();
		Iterator<String> it = handles.iterator();
		//iterate through your windows
		while (it.hasNext()){
		String parent = it.next();
		String newwin = it.next();
		driver.switchTo().window(newwin);
		
	}}
	
	@SuppressWarnings("unused")
	public void switchToParent() {
		
		Set <String> handles =driver.getWindowHandles();
		Iterator<String> it = handles.iterator();
		//iterate through your windows
		while (it.hasNext()){
		String parent = it.next();
		String newwin = it.next();
		driver.switchTo().window(parent);
		
	}
	}
	public void closeBrowser() {

		driver.quit();

	}
}
