package com.ppaluch.integracje.integracje.controller;

import com.ppaluch.integracje.integracje.dto.Laptop;
import com.ppaluch.integracje.integracje.service.LaptopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/api")
public class LaptopController {
    @Autowired
    private LaptopService laptopService;

    public static List<Laptop> txtList;

    @GetMapping("/start")
    public String getStartPage(Model theModel) {
        return "index";
    }

    @GetMapping("/laptops")
    public String getLaptops(Model theModel) {
        List<Laptop> list =  laptopService.getAllLaptops();
        txtList = list;
        theModel.addAttribute("laptops", list);
        return "laptops";
    }

    @GetMapping("/laptops/save")
    public String saveAllToTxt() {
        laptopService.saveLaptops(txtList);
        return "index";
    }

    @RequestMapping(value = "/laptops/edit", method = RequestMethod.GET)
    public String showFormForEdit(@RequestParam("index") Integer index, Model theModel)   {
        theModel.addAttribute("laptop", txtList.get(index - 1));
        return "edit";
    }


    @RequestMapping(value = "/laptops/saveEdited", method = RequestMethod.POST)
    public String saveEditedLaptop(@ModelAttribute("laptop") @Valid Laptop laptop, BindingResult bindingResult, Model model) throws Exception {
        if (bindingResult.hasErrors()) {
            return "edit";
        } else {
            txtList.set(laptop.getIndex() - 1, laptop);
            model.addAttribute("laptops", txtList);
            return "laptops";
        }
    }


}

