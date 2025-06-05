package com.testclass;

import com.pageclass.ValidateloginPageclass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class ValidateloginTestclass {


        WebDriver driver;
        ValidateloginPageclass loginPage;

        @BeforeClass
        public void setUp() {
            driver = new ChromeDriver();
            driver.get("https://demowebshop.tricentis.com/login");
            loginPage = new ValidateloginPageclass();
        }

        @Test
        public void testLogin() {
            loginPage.setUsername("rootuser@gmail.com");
            loginPage.setPassword("root123");
            loginPage.click();
        }

        @AfterClass
        public void tearDown() {
            driver.quit();
        }
        }
