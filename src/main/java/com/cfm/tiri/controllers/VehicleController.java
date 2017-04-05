package com.cfm.tiri.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.cfm.tiri.services.TrailerService;
import com.cfm.tiri.services.TruckService;

@Controller
public class VehicleController {

    private TrailerService trailerService;
    private TruckService truckService;

    @Autowired
    public void setTrailerService(TrailerService trailerService) {
        this.trailerService = trailerService;
    }
    
    @Autowired
    public void setTruckService(TruckService truckService) {
        this.truckService = truckService;
    }
    

    @RequestMapping(value = "/vehicles", method = RequestMethod.GET)
    public String list(Model model){
        model.addAttribute("trailers", trailerService.listAllTrailers());
        model.addAttribute("trucks", truckService.listAllTrucks());
        System.out.println("Returning vehicles:");
        return "vehicles";
    }
    


    
}