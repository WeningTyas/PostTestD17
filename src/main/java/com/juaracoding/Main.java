package com.juaracoding;

import com.juaracoding.drivers.DriverSingleton;
import com.juaracoding.pages.DashboardPage;
import com.juaracoding.pages.LoginPage;
import com.juaracoding.utils.Scroll;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

public class Main {
    static WebDriver driver;

    public static void main(String[] args) {
        DriverSingleton.getInstance("chrome");
        driver = DriverSingleton.getDriver();
        driver.get("https://shop.demoqa.com/");
        System.out.println("Buka Browser dan buka URL");

        loginTest(driver);

        DriverSingleton.delay(3);
        DriverSingleton.closeObjectInstance();
    }

    public static void loginTest(WebDriver driver){
        Scroll scroll = new Scroll(driver);
        scroll.scrollBy(0, 200);
        System.out.println("Scroll ke bawah, utk munculkan header");

        DashboardPage dashboard = new DashboardPage();
        dashboard.menuClick("Login");
        System.out.println("Klik menu My Account");

        scroll.scrollBy(0, 500);

        LoginPage loginPage = new LoginPage();
        loginPage.login();
        System.out.println("Test Login");

        scroll.scrollBy(0, 500);
        loginPage.verifikasi();
    }
}
