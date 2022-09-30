package com.speedup.qa.userinterfaces;

import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.screenplay.targets.Target;

public class Search {
    public static final Target LOCATION_CLICK = Target
            .the("select location")
            .located(By.xpath("(//div[@class='dx-field-item-content dx-field-item-content-location-bottom'])[2]"));

    public static final Target LOCATION = Target
            .the("Select los angeles")
            .locatedBy("//div[@class='dx-scrollview-content']//div[.='{0}']");

    public static final Target CHECKOUT  = Target
            .the("select checkout date")
            .located(By.xpath("/html/body/div/div/div/div[2]/div[1]/div/div/div[1]/div/div[1]/div[2]/div[1]/div/div/div/div/div/div/div/div/div/div/div/div[2]/div/div[2]/div/div/div/div/div/div/input"));


    public static final Target CHECKIN = Target
            .the("Select calendar")
            .located(By.xpath("(//input[@class='dx-texteditor-input'])[2]"));


    public static final Target SELECT_ROOM = Target
            .the("Select rooms")
            .locatedBy("(//input[@class='dx-texteditor-input'])[4]");

    public static final Target ROOM = Target
            .the("Select rooms number")
            .locatedBy("(//div[@class='dx-item-content dx-list-item-content'])[11]");

    public static final Target SELECT_ADULT = Target
            .the("Select number adults")
            .locatedBy("(//input[@class='dx-texteditor-input'])[5]");

    public static final Target ADULT = Target
            .the("Select number adults")
            .locatedBy("(//div[@class='dx-item-content dx-list-item-content'])[15]");


    public static final Target SELECT_CHILD = Target
            .the("Select number children")
            .locatedBy("(//input[@class='dx-texteditor-input'])[6]");

    public static final Target CHILDREN = Target
            .the("Select number children")
            .locatedBy("(//div[@class='dx-item-content dx-list-item-content'])[19]");


    public static final Target SEARCH_BUTTON= Target
            .the("Click boton search")
            .locatedBy("/html/body/div[1]/div/div/div[2]/div[1]/div/div[1]/div[1]/div/div[1]/div[3]/div/div");

    public static final Target SELECT_HOTEL = Target
            .the("Select hotel")
            .located(By.xpath("(//*[@class='dx-button-content']//descendant::span[1])[5]"));

    public static final Target GET_PRICE_HOTEL1 = Target
            .the("Obtener precio del primer hotel")
            .locatedBy("(//*[@class='rate-number'])[1]");

    public static final Target GET_PRICE_HOTEL2 = Target
            .the("Obtener precio del segundo hotel")
            .locatedBy("(//*[@class='rate-number'])[2]");

    public static final Target GET_PRICE_HOTEL3 = Target
            .the("Obtener precio del tercer hotel")
            .locatedBy("(//*[@class='rate-number'])[3]");

    public static final Target CLICK_BUTTON = Target
            .the("Seleccionar hotel")
            .located(By.xpath("(//*[contains(@aria-label,'Book it')])[1]"));

    public static final Target CLICK_BUTTON2 = Target
            .the("Seleccionar hotel")
            .located(By.xpath("(//*[contains(@aria-label,'Book it')])[2]"));


    public static final Target CLICK_BUTTON3 = Target
            .the("Seleccionar hotel")
            .located(By.xpath("(//*[contains(@aria-label,'Book it')])[3]"));

    public static final Target GET_PRICE_TOTAL = Target
            .the("Obtener precio total")
            .locatedBy("(//h4[@class='total-price'])[1]");

}
