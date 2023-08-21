package com.juaracoding.pages;

import com.juaracoding.drivers.DriverSingleton;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ChartPage {
    private WebDriver driver;

    public ChartPage(){
        this.driver = DriverSingleton.getDriver();
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//a[@class='empty-cart']")
    WebElement btnClear;

    @FindBy(xpath = "//a[@class='button wc-backward']")
    WebElement btnReturnShop;

    public void btnReturnShopClick(){
        try {
            //kalau ada isi, dihapus dulu
            btnClear.click();
        } finally {
            btnReturnShop.click();
        }
    }
}

