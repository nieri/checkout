package br.com.munieri.checkout.view.controller;

import br.com.munieri.checkout.view.dto.CartDTO;
import br.com.munieri.checkout.view.dto.OrderDTO;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping(value = "/checkout/app")
@SessionAttributes("orderDTO")

public class CheckoutController {

    private OrderDTO orderDTO;

    @RequestMapping("/order")
    public ModelAndView checkout(HttpSession session ) {

        CartDTO cart = (CartDTO) session.getAttribute("cartDTO");

        if (orderDTO == null) {
            orderDTO = new OrderDTO(cart.getItems(), cart.getPaymentAmount());
        }

        ModelAndView modelAndView = new ModelAndView("redirect:/checkout/app/checkout");
        modelAndView.addObject(orderDTO);
        return modelAndView;
    }
}
