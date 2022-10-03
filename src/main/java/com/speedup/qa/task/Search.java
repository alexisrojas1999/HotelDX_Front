package com.speedup.qa.task;

import com.speedup.qa.interactions.Wait;
import com.speedup.qa.models.DataSearch;
import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.PerformsTasks;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.ClickOnBy;
import net.serenitybdd.screenplay.actions.Enter;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

import static com.speedup.qa.userinterfaces.Search.*;

public class Search implements Task {

    private DataSearch dataSearch;
    public Search(DataSearch dataSearch){
        this.dataSearch=dataSearch;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(Click.on(LOCATION_CLICK), Wait.waitFor(1));
        actor.attemptsTo(Click.on(LOCATION.of(dataSearch.getLocation())), Wait.waitFor(1));
        actor.attemptsTo(Click.on(SELECT_ROOM), Wait.waitFor(1));
        actor.attemptsTo(Click.on(ROOM.of(dataSearch.getRoom())), Wait.waitFor(1));
        actor.attemptsTo(Click.on(SELECT_ADULT), Wait.waitFor(1));
        actor.attemptsTo(Click.on(ADULT.of(dataSearch.getAdult())), Wait.waitFor(1));
        actor.attemptsTo(Click.on(SELECT_CHILD), Wait.waitFor(1));
        actor.attemptsTo(Click.on(CHILDREN.of(dataSearch.getChild())) ,Wait.waitFor(1));
        actor.attemptsTo(Enter.theValue(dataSearch.getCheckout()).into(CHECKOUT), Wait.waitFor(1));
        actor.attemptsTo(Enter.theValue(dataSearch.getCheckin()).into(CHECKIN),Wait.waitFor(1));
        actor.attemptsTo(Click.on( SEARCH_BUTTON), Wait.waitFor(1));

        WebElementFacade PrecioHotel1 = BrowseTheWeb.as(actor).findBy(com.speedup.qa.userinterfaces.Search.GET_PRICE_HOTEL1.getCssOrXPathSelector());
        WebElementFacade PrecioHotel2 = BrowseTheWeb.as(actor).findBy(com.speedup.qa.userinterfaces.Search.GET_PRICE_HOTEL2.getCssOrXPathSelector());
        WebElementFacade PrecioHotel3 = BrowseTheWeb.as(actor).findBy(com.speedup.qa.userinterfaces.Search.GET_PRICE_HOTEL3.getCssOrXPathSelector());




        StringBuilder t1 = new StringBuilder(PrecioHotel1.getText());
        StringBuilder t2 = new StringBuilder(PrecioHotel2.getText());
        StringBuilder t3 = new StringBuilder(PrecioHotel3.getText());



        int Precio1=Integer.parseInt(String.valueOf(t1.deleteCharAt(0)));
        int Precio2=Integer.parseInt(String.valueOf(t2.deleteCharAt(0)));
        int Precio3=Integer.parseInt(String.valueOf(t3.deleteCharAt(0)));

        System.out.println("el precio de los hoteles  son");
        System.out.println("$"+Precio1);
        System.out.println("$"+Precio2);
        System.out.println("$"+Precio3);


        int menorvalor;
        if(Precio1 < Precio2 && Precio1 < Precio3 ){
            actor.attemptsTo(Click.on(CLICK_BUTTON));
            menorvalor = Precio1;
        }else if (Precio2 < Precio1 && Precio2 < Precio3){
            actor.attemptsTo(Click.on(CLICK_BUTTON2));
            menorvalor = Precio2;
        }else {
            actor.attemptsTo(Click.on(CLICK_BUTTON3));
            menorvalor = Precio3;
        }
        System.out.println("El hotel menos costoso es de $"+menorvalor);

        String checkinDate = dataSearch.getCheckin();
        String checkoutDate = dataSearch.getCheckout();

        LocalDate ci = LocalDate.parse(checkinDate, DateTimeFormatter.ofPattern("MM/dd/yyyy"));
        LocalDate co = LocalDate.parse(checkoutDate, DateTimeFormatter.ofPattern("MM/dd/yyyy"));
        long numdias = ci.until(co, ChronoUnit.DAYS)+1;

        System.out.println("reservacion para \n"+numdias +" dias");


        WebElementFacade PrecioTOTAL = BrowseTheWeb.as(actor).findBy(GET_PRICE_TOTAL.getCssOrXPathSelector());

        StringBuilder PT = new StringBuilder(PrecioTOTAL.getText());
        double PrecioT=Double.parseDouble(String.valueOf(PT.deleteCharAt(0)));

        System.out.println("el precio mas barrato es para" +numdias +" dias\n"+"$"+PrecioT);


        double preciototalcalculado = numdias*menorvalor;

        if (preciototalcalculado == PrecioT){
            System.out.println("El valor total es el correcto");
        }else {
            System.out.println("El valor total no coincide con la formula aplicada");
        }

    }

    public static Search  withData (DataSearch dataSearch) {

        return new Search(dataSearch);
    }


}
