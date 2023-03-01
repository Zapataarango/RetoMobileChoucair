package com.exito.appcompania.automation.tasks;


import com.exito.appcompania.automation.interactions.Wait;
import com.exito.appcompania.automation.interactions.tap;
import com.exito.appcompania.automation.models.User;
import lombok.AllArgsConstructor;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;

import static com.exito.appcompania.automation.userinterfaces.LogInPage.*;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isEnabled;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

@AllArgsConstructor
public class LogIn implements Task {

    private User user;

    public static LogIn onExitoApp(User user) {
        return Tasks.instrumented(LogIn.class, user);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Click.on(BTN_LOGIN),
                Enter.theValue(user.getEmail()).into(INPUT_EMAIL),
                Enter.theValue(user.getPassword()).into(INPUT_PASSWORD),
                Click.on(BTN_CONFIRM_LOGIN),
                Wait.seconds(5),
                tap.onCoordinates(911, 1553)
        );
        actor.remember("GREETING", LBL_GREETING.resolveFor(actor).getText());
    }
}
