package com.cfm.tiri.controllers;

import com.cfm.tiri.domain.Truck;
import com.cfm.tiri.services.TruckService;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Controller
public class TruckController extends WebMvcConfigurerAdapter {

    private TruckService truckService;

    @Autowired
    public void setTruckService(TruckService truckService) {
        this.truckService = truckService;
    }

    @RequestMapping(value = "/trucks", method = RequestMethod.GET)
    public String list(Model model){
        model.addAttribute("trucks", truckService.listAllTrucks());
        System.out.println("Returning trucks:");
        return "trucks";
    }

    @RequestMapping("truck/{id}")
    public String showTruck(@PathVariable Integer id, Model model){
        model.addAttribute("truck", truckService.getTruckById(id));
        return "truckshow";
    }

    @RequestMapping("truck/edit/{id}")
    public String edit(@PathVariable Integer id, Model model){
        model.addAttribute("truck", truckService.getTruckById(id));
        return "truckform";
    }
    
    @RequestMapping("truck/new")
    public String newTruck(Model model){
        model.addAttribute("truck", new Truck());
        return "truckform";
    }
    
    //Validation of form
    @RequestMapping(value="truck", method=RequestMethod.GET)
    public String backToForm() {
        return "truckform";
    }

    @RequestMapping(value="truck", method=RequestMethod.POST)
    public String saveTruck(@ModelAttribute("truck") @Valid Truck truck, BindingResult result) {
        if (result.hasErrors()) {
            //form is not filled properly
            return "truckform";
        } else {
            //form is filled properly
        	truckService.saveTruck(truck);
            return "redirect:/truck/" + truck.getId();
        }
    }
    
    @RequestMapping(value = "trucks/active/{active}", method = RequestMethod.GET)
    public String listActive(@PathVariable Boolean active, Model model){
        System.out.println("Returning active trucks:");
        model.addAttribute("trucks", truckService.listActiveTrucks(active));
        return "trucks";
    }
    

}
