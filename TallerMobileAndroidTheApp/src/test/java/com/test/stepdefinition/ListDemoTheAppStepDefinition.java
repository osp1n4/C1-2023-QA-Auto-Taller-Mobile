package com.test.stepdefinition;

import com.test.setup.SetUp;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import org.apache.log4j.Logger;
import org.assertj.core.api.Assertions;
import org.junit.Before;

import static com.sofkau.task.ClickHomeTask.clickHomeTask;
import static com.sofkau.task.ListaDemTask.listaDemTask;

public class ListDemoTheAppStepDefinition extends SetUp {
    public static Logger LOGGER= Logger.getLogger(TheAppStepDefinition.class);

    @Before
    public void before(){
        OnStage.setTheStage(new OnlineCast());

    }

    @Given("el usuario esta en la app TheApp")
    public void elUsuarioEstaEnLaAppTheApp() {
        actor.can(BrowseTheWeb.with(theMobileDevice));


    }
    @When("el usuario usuario elige la nube de su interes")
    public void elUsuarioUsuarioEligeLaNubeDeSuInteres() {
        try {
            actor.attemptsTo(
                    listaDemTask()

            );
            LOGGER.info("El usuario ingresa a la lista de demo");

        } catch (Exception e) {
            LOGGER.info("Fallo al selecionar la lista demo");
            LOGGER.info(e.getMessage());
            Assertions.fail("");
        }
    }
    @Then("el usuario debera observar un mensaje de confirmacion")
    public void elUsuarioDeberaObservarUnMensajeDeConfirmacion() {

    }
}
