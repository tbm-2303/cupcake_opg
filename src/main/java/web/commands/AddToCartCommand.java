package web.commands;

import business.entities.Bot;
import business.entities.Cupcake;
import business.entities.Top;
import business.exceptions.UserException;
import business.persistence.CupcakeMapper;
import business.services.CupcakeFacade;
import business.services.UserFacade;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

public class AddToCartCommand extends CommandProtectedPage {
    private UserFacade userFacade;
    private CupcakeFacade cupcakeFacade;

    public AddToCartCommand(String pageToShow, String role) {
        super(pageToShow, role);
        userFacade = new UserFacade(database);
        cupcakeFacade = new CupcakeFacade(database);
    }


    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        try {
            int topId = Integer.parseInt(request.getParameter("top"));
            int bottomId = Integer.parseInt(request.getParameter("bot"));
            int amount = Integer.parseInt(request.getParameter("amount"));

            Top top = cupcakeFacade.getTop(topId);
            Bot bot = cupcakeFacade.getBot(bottomId);
            Cupcake cupcake = new Cupcake(top.getName(), bot.getName(), amount);
            int price = top.getPrice() + bot.getPrice();
            cupcake.setPrice(price);

            List<Cupcake> shoppingCart = (List<Cupcake>) request.getSession().getAttribute("ShoppingCart");
            if (shoppingCart == null) {
                shoppingCart = new ArrayList<>();
            }

            shoppingCart.add(cupcake);
            request.getSession().setAttribute("shoppingCart", shoppingCart);

            return "addtocart_confirmationpage";

        } catch (NumberFormatException | UserException ex) {
            request.setAttribute("error", "Du glemte at vælge noget");
            return "orderpage";
        }
    }
}
