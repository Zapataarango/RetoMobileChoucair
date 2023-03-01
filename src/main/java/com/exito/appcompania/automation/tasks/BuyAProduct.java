package com.exito.appcompania.automation.tasks;

import com.exito.appcompania.automation.interactions.Wait;
import com.exito.appcompania.automation.models.Product;
import lombok.AllArgsConstructor;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;

import static com.exito.appcompania.automation.userinterfaces.BuyProductsPage.*;

@AllArgsConstructor
public class BuyAProduct implements Task {

    private Product product;

    public static BuyAProduct onExitoApp(Product product) {
        return Tasks.instrumented(BuyAProduct.class, product);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        System.out.println(product.getCategory());
        actor.attemptsTo(
                Click.on(BTN_SEE_MORE),
                Click.on(BTN_RECEIVE_HOME),
                Click.on(BTN_SELECT_DIRECTION),
                Wait.seconds(1),
                Click.on(BTN_CATEGORY.of(product.getCategory())),
                Click.on(BTN_SUBCATEGORY.of(product.getSubcategory())),
                Wait.seconds(4),
                Click.on(BTN_PRODUCT.of(product.getProduct())),
                Click.on(BTN_CART),
                Click.on(BTN_VIEW_CART),
                Wait.seconds(12)
        );
        System.out.println("NOMBRE DEL PRODUCTO:" + LBL_PRODUCT.resolveFor(actor).getText());
        actor.remember("PRODUCT_NAME", LBL_PRODUCT.resolveFor(actor).getText());
    }
}
