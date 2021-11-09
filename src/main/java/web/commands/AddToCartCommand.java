package web.commands;

import business.entities.Cupcake;
import business.services.UserFacade;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

public class AddToCartCommand extends CommandProtectedPage {
    private UserFacade userFacade;

    public AddToCartCommand(String pageToShow, String role) {
        super(pageToShow, role);
        userFacade = new UserFacade(database);
    }


    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {

        int topId = Integer.parseInt(request.getParameter("top"));
        int bottomId = Integer.parseInt(request.getParameter("bot"));
        int amount = Integer.parseInt(request.getParameter("amount"));
        String top = String.valueOf(topId);
        String bot = String.valueOf(bottomId);

        List<Cupcake> cupcakeList = (List<Cupcake>) request.getSession().getAttribute("ShoppingCart");
        if (cupcakeList == null) {
            cupcakeList = new ArrayList<>();
        }
        Cupcake c = new Cupcake(top, bot, amount);
        c.setPrice(2);
        cupcakeList.add(c);




        request.getSession().setAttribute("cupcakeList", cupcakeList);
        int price = 0;
        for (Cupcake item : cupcakeList) {
            price += item.getPrice();
        }

        return pageToShow;
    }
}
