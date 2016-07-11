package br.com.munieri.checkout.view.controller;

import br.com.munieri.checkout.domain.product.Product;
import br.com.munieri.checkout.domain.product.service.ProductService;
import br.com.munieri.checkout.view.converter.ProductConverter;
import br.com.munieri.checkout.view.dto.ProductDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping(value = "/checkout/adm")
public class ProductController {

    @Autowired
    ProductService service;

    @RequestMapping("/index")
    public String index() {
        return "checkout/adm/index";
    }

    @RequestMapping(value = "/form", method = RequestMethod.GET)
    public String form(){
        return "checkout/adm/form";
    }

    @RequestMapping(value = "/show/{id}", method = RequestMethod.GET)
    public ModelAndView show(@PathVariable Long id) {
        Product product = service.findById(id);
        ModelAndView modelAndView = new ModelAndView("checkout/adm/show");
        modelAndView.addObject(ProductConverter.convertToDTO(product));
        return modelAndView;
    }

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public ModelAndView list() {
        ModelAndView modelAndView = new ModelAndView("checkout/adm/list");
        List<ProductDTO> dtos = ProductConverter.convertListToDTO(service.findAll());
        modelAndView.addObject(dtos);
        return modelAndView;
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String save(ProductDTO productDTO){

        Product product = ProductConverter.convertToEntity(productDTO);

        service.save(product);
        return "redirect:/checkout/adm/list";
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public String update(ProductDTO productDTO){

        Product product = ProductConverter.convertToEntity(productDTO);

        service.update(product);
        return "redirect:/checkout/adm/list";
    }

    @RequestMapping(value = "/edit", method = RequestMethod.GET)
    public ModelAndView edit(Long id) {
        Product product = service.findById(id);
        ModelAndView modelAndView = new ModelAndView("checkout/adm/edit");
        modelAndView.addObject(ProductConverter.convertToDTO(product));
        return modelAndView;
    }

    @RequestMapping(value = "/delete", method = RequestMethod.GET)
    public String deletar(Long id){
        service.delete(id);
        return "redirect:/checkout/adm/list";
    }
}
