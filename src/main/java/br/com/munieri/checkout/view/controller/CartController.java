package br.com.munieri.checkout.view.controller;

import br.com.munieri.checkout.domain.product.Product;
import br.com.munieri.checkout.domain.product.service.ProductService;
import br.com.munieri.checkout.view.converter.ProductConverter;
import br.com.munieri.checkout.view.dto.CartDTO;
import br.com.munieri.checkout.view.dto.ItemDTO;
import br.com.munieri.checkout.view.dto.ProductDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value = "/checkout/app")
@SessionAttributes("cartDTO")
public class CartController {

    private CartDTO cartDTO;

    @Autowired
    ProductService productService;

    @RequestMapping("/cart")
    public String index() {
        return "checkout/app/cart";
    }

    @RequestMapping(value = "/form", method = RequestMethod.GET)
    public String form() {
        return "checkout/adm/form";
    }

    @RequestMapping(value = "/checkout", method = RequestMethod.GET)
    public String checkout() {
        return "checkout/app/checkout";
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public ModelAndView add(ItemDTO item) {

        if (cartDTO == null) {
            cartDTO = new CartDTO();
        }

        Product productEntity = ProductConverter.convertToEntity(item.getProductDTO());
        productEntity = productService.find(productEntity);

        ProductDTO productDTO = ProductConverter.convertToDTO(productEntity);
        item.setProductDTO(productDTO);

        cartDTO.addItem(item);

        ModelAndView modelAndView = new ModelAndView("redirect:/checkout/app/cart");
        modelAndView.addObject(cartDTO);
        return modelAndView;
    }

    @RequestMapping(value = "/delete", method = RequestMethod.GET)
    public String deletar(Integer index){
        cartDTO.remove(index);
        return "redirect:/checkout/app/cart";
    }

    @RequestMapping(value = "/update", method = RequestMethod.GET)
    public ModelAndView update(Long id){

        Product productEntity = productService.findById(id);

        cartDTO.addItem(productEntity);

        ModelAndView modelAndView = new ModelAndView("redirect:/checkout/app/cart");
        modelAndView.addObject(cartDTO);
        return modelAndView;
    }

    @RequestMapping(value = "/remove", method = RequestMethod.GET)
    public ModelAndView remove(Long id){

        Product productEntity = productService.findById(id);

        cartDTO.removeItem(productEntity);

        ModelAndView modelAndView = new ModelAndView("redirect:/checkout/app/cart");
        modelAndView.addObject(cartDTO);
        return modelAndView;
    }
}
