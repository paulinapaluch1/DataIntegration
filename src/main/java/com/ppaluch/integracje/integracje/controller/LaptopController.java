package com.ppaluch.integracje.integracje.controller;

import com.ppaluch.integracje.integracje.dto.LaptopGuiDto;
import com.ppaluch.integracje.integracje.service.LaptopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

import static com.ppaluch.integracje.integracje.service.LaptopService.STATUS_EDITED;

@Controller
@RequestMapping("/api")
public class LaptopController {

    public static final String  XML_PATH = "katalog.xml";
    @Autowired
    private LaptopService laptopService;

    public static List<LaptopGuiDto> laptopList;

    @GetMapping("/start")
    public String getStartPage(Model theModel) {
        return "index";
    }

    @GetMapping("/laptops")
    public String getLaptops(Model theModel) {
        List<LaptopGuiDto> list =  laptopService.getAllLaptops();
        laptopList = list;
        theModel.addAttribute("laptops", list);
        theModel.addAttribute("readRecords", laptopList.size());
        theModel.addAttribute("newRecords", laptopService.countNewLaptops(list));
        theModel.addAttribute("duplicateRecords",laptopService.countDuplicateLaptops(list));
        return "laptops";
    }

    @GetMapping("/laptops/save")
    public String saveAllToTxt() {
        laptopService.saveLaptops(laptopList);
        return "index";
    }

    @GetMapping("/laptops/xml")
    public String getLaptopsFromXml(Model theModel) {
        List<LaptopGuiDto> list =  laptopService.getAllLaptopsFromXml(XML_PATH);
        laptopList = list;
        theModel.addAttribute("laptops", list);
        theModel.addAttribute("readRecords", laptopList.size());
        theModel.addAttribute("newRecords", laptopService.countNewLaptops(list));
        theModel.addAttribute("duplicateRecords",laptopService.countDuplicateLaptops(list));
        return "laptops";
    }

    @GetMapping("/laptops/saveXml")
    public String saveAllToXml() {
        laptopService.saveLaptopsToXml(laptopList, XML_PATH);
        return "index";
    }

    @GetMapping("/laptops/database")
    public String getLaptopsFromDatabase(Model theModel) {
        List<LaptopGuiDto> list =  laptopService.getAllLaptopsFromDatabase();
        laptopList = list;
        theModel.addAttribute("laptops", list);
        theModel.addAttribute("readRecords", laptopList.size());
        theModel.addAttribute("newRecords", laptopService.countNewLaptops(list));
        theModel.addAttribute("duplicateRecords",laptopService.countDuplicateLaptops(list));
        return "laptops";
    }

    @GetMapping("/laptops/saveToDatabase")
    public String saveAllToDatabase() {
        laptopService.updateLaptopsInDatabase(laptopList);
        return "index";
    }


    @RequestMapping(value = "/laptops/edit", method = RequestMethod.GET)
    public String showFormForEdit(@RequestParam("index") Integer index, Model theModel)   {
        theModel.addAttribute("laptop", laptopList.get(index - 1));
        return "edit";
    }


    @RequestMapping(value = "/laptops/saveEdited", method = RequestMethod.POST)
    public String saveEditedLaptop(@ModelAttribute("laptop") @Valid LaptopGuiDto laptop, BindingResult bindingResult, Model theModel){
        if (bindingResult.hasErrors()) {
            return "edit";
        } else {
            laptop.setStatus(STATUS_EDITED);
            laptopList.set(laptop.getLaptopIndex() - 1, laptop);
            theModel.addAttribute("laptops", laptopList);
            return "laptops";
        }
    }


}

