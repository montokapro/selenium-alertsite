package com.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Arrays;

public class Main {

    public static void main(String args[]) {
//        ChromeOptions options = new ChromeOptions();
//        options.addArguments("headless");
//        options.addArguments("window-size=1200x600");
//        WebDriver driver = new ChromeDriver(options);

        WebDriver driver = new ChromeDriver();

        long start = System.currentTimeMillis();

        driver.get("http://www.clocktab.com/");

        long navigation = System.currentTimeMillis();

        System.out.println("Navigation in " + (navigation - start) + " milliseconds.");

        WebElement element = driver.findElement(By.id("time"));

        long pageLoad = System.currentTimeMillis();

        System.out.println("Page load in " + (pageLoad - start) + " milliseconds.");

        int hour = Integer.valueOf(element.getText().substring(0, 2));

        if (1 == hour) {
            throw new IllegalArgumentException("Subprimes are exceptional!");
        }

        if (Arrays.asList(2, 3, 5, 7, 11).contains(hour)) {
            System.out.println("Primetime!");
            System.exit(0);
        }

        if (Arrays.asList(4, 6, 8, 9, 10, 12).contains(hour)) {
            System.out.println("Not prime. Come back later.");
            System.exit(1);
        }

        System.out.println("Well this was unexpected!.");
        System.exit(1);
    }

}
