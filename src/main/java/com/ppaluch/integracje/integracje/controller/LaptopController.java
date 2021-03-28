package com.ppaluch.integracje.integracje.controller;

import com.ppaluch.integracje.integracje.dto.Laptop;
import com.ppaluch.integracje.integracje.service.LaptopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/api")
public class LaptopController {

    public static String XML_PATH = "katalog.xml";
    @Autowired
    private LaptopService laptopService;

    public static List<Laptop> laptopList;

    @GetMapping("/start")
    public String getStartPage(Model theModel) {
        return "index";
    }

    @GetMapping("/laptops")
    public String getLaptops(Model theModel) {
        List<Laptop> list =  laptopService.getAllLaptops();
        laptopList = list;
        theModel.addAttribute("laptops", list);
        return "laptops";
    }

    @GetMapping("/laptops/save")
    public String saveAllToTxt() {
        laptopService.saveLaptops(laptopList);
        return "index";
    }

    @GetMapping("/laptops/xml")
    public String getLaptopsFromXml(Model theModel) {
        List<Laptop> list =  laptopService.getAllLaptopsFromXml(XML_PATH);
        laptopList = list;
        theModel.addAttribute("laptops", list);
        return "laptops";
    }

    @GetMapping("/laptops/saveXml")
    public String saveAllToXml() {
        laptopService.saveLaptopsToXml(laptopList, XML_PATH);
        return "index";
    }


    @RequestMapping(value = "/laptops/edit", method = RequestMethod.GET)
    public String showFormForEdit(@RequestParam("index") Integer index, Model theModel)   {
        theModel.addAttribute("laptop", laptopList.get(index - 1));
        return "edit";
    }


    @RequestMapping(value = "/laptops/saveEdited", method = RequestMethod.POST)
    public String saveEditedLaptop(@ModelAttribute("laptop") @Valid Laptop laptop, BindingResult bindingResult, Model model) throws Exception {
        if (bindingResult.hasErrors()) {
            return "edit";
        } else {
            laptopList.set(laptop.getIndex() - 1, laptop);
            model.addAttribute("laptops", laptopList);
            return "laptops";
        }
    }


}

