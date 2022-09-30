package com.speedup.qa.Stepdefinitions;

import com.speedup.qa.models.DataSearch;
import com.speedup.qa.task.OpenBrowser;
import com.speedup.qa.task.Search;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actors.Cast;
import net.serenitybdd.screenplay.actors.OnStage;
import net.thucydides.core.annotations.Managed;
import org.jetbrains.annotations.NotNull;
import org.openqa.selenium.WebDriver;

import java.util.List;

import static net.serenitybdd.screenplay.actors.OnStage.setTheStage;
import static net.serenitybdd.screenplay.actors.OnStage.theActorCalled;

public class SearchStep {
    @Managed
    private WebDriver myBrowser;

    @Before
    public void setUpOnstage() {
        setTheStage(Cast.whereEveryoneCan(BrowseTheWeb.with(myBrowser)));
        theActorCalled("Alexis Rojas ");
    }

    @Given("^that the user is looking for a hotel$")
    public void thatTheUserIsLookingForAHotel() {
        OnStage.theActorInTheSpotlight().wasAbleTo(OpenBrowser.browser());
    }


    @When("^the user fills out the following information$")
    public void theUserFillsOutTheFollowingInformation(List<DataSearch> dataSearch) {
        OnStage.theActorInTheSpotlight().attemptsTo(Search.withData(dataSearch.get(0)));

    }

    @Then("^the user should the available rooms$")
    public void theUserShouldTheAvailableRooms() {

    }



}
