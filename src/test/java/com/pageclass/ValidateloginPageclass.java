package com.pageclass;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class ValidateloginPageclass {

    WebDriver driver;
By username= By.id("Email");
By password= By.id("Password");
By clicklogin= By.cssSelector("input.button-1.login-button");

public ValidateloginPageclass(){


    this.driver=driver;
}
public void setUsername(String username){

    driver.findElement(By.id(username)).sendKeys(username);
}
public void setPassword(String password){
    driver.findElement(By.id(password)).sendKeys(password);

}
public void click (){
    driver.findElement(clicklogin).click();

}
}



