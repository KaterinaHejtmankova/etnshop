package cz.etn.etnshop.controller;

import cz.etn.etnshop.dao.Product;
import cz.etn.etnshop.utils.ValidatorResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import cz.etn.etnshop.service.ProductService;

@Controller
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductService productService;

    @RequestMapping("/list")
    public ModelAndView list() {
        ModelAndView modelAndView = new ModelAndView("product/list");
        modelAndView.addObject("products", productService.getProducts());
        return modelAndView;
    }

    @RequestMapping(value = "/create", method = RequestMethod.GET)
    public ModelAndView create(@ModelAttribute Product product) {
        ModelAndView modelAndView = new ModelAndView("product/create");
        return modelAndView;
    }

    @RequestMapping(value = "/edit", method = RequestMethod.GET)
    public ModelAndView edit(@RequestParam(value = "id") int id) {
        ModelAndView modelAndView = new ModelAndView("product/edit");
        modelAndView.addObject("product", productService.getEntityById(id));
        return modelAndView;
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public ModelAndView save(@ModelAttribute Product product) {
        ModelAndView modelAndView = new ModelAndView("product/edit");
        ValidatorResult validatorResult = product.validate();
        if (validatorResult.isValid()) {
            productService.updateEntity(product);
            return new ModelAndView("redirect:/product/list");
        } else {
            return modelAndView.addObject("errors", validatorResult);
        }
    }

    @RequestMapping(value = "/saveNew", method = RequestMethod.POST)
    public ModelAndView saveNew(@ModelAttribute Product product) {
        ModelAndView modelAndView = new ModelAndView("product/create");
        ValidatorResult validatorResult = product.validate();
        if (validatorResult.isValid()) {
            productService.addEntity(product);
            return new ModelAndView("redirect:/product/list");
        } else {
            return modelAndView.addObject("errors", validatorResult);
        }
    }

    @RequestMapping(value = "/search", method = RequestMethod.GET)
    public ModelAndView search(@RequestParam(value = "name") String name) {
        ModelAndView modelAndView = new ModelAndView("product/list");
        modelAndView.addObject("products", productService.getProducts(name));
        return modelAndView;
    }

}
