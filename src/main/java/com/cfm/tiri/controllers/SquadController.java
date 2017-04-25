package com.cfm.tiri.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.cfm.tiri.domain.Squad;
import com.cfm.tiri.services.SquadService;
import com.cfm.tiri.services.TrailerService;
import com.cfm.tiri.services.TruckService;
import com.cfm.tiri.services.UserService;

@Controller
public class SquadController {
	
	private SquadService squadService;
	private TruckService truckService;
	private TrailerService trailerService;
	private UserService userService;


    @Autowired
    public void setSquadService(SquadService squadService) {
        this.squadService = squadService;
    }
	
    @Autowired
    public void setTruckService(TruckService truckService) {
        this.truckService = truckService;
    }
    
    @Autowired
    public void setTrailerService(TrailerService trailerService) {
        this.trailerService = trailerService;
    }
    
    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    
    @RequestMapping(value = "/squads", method = RequestMethod.GET)
    public String list(Model model){
        model.addAttribute("squads", squadService.listAllSquads());
        model.addAttribute("allActiveAndFreeDrivers", userService.listActiveAndFreeDrivers(0));
        model.addAttribute("allActiveAndFreeTrucks", truckService.listActiveAndFreeTrucks(0));
        model.addAttribute("allActiveAndFreeTrailers", trailerService.listActiveAndFreeTrailers(0));
        System.out.println("Returning squads:");
        return "squads";
    }

    @RequestMapping("squad/{id}")
    public String showSquad(@PathVariable Integer id, Model model){
        model.addAttribute("squad", squadService.getSquadById(id));
        return "squadshow";
    }

    @RequestMapping("squad/edit/{id}")
    public String edit(@PathVariable Integer id, Model model){
        model.addAttribute("squad", squadService.getSquadById(id));
        model.addAttribute("allActiveAndFreeDrivers", userService.listActiveAndFreeDrivers(id));
        model.addAttribute("allActiveAndFreeTrucks", truckService.listActiveAndFreeTrucks(id));
        model.addAttribute("allActiveAndFreeTrailers", trailerService.listActiveAndFreeTrailers(id));
        return "squadform";
    }

    @RequestMapping("squad/new")
    public String newSquad(Model model){
        model.addAttribute("squad", new Squad());
        model.addAttribute("allActiveAndFreeDrivers", userService.listActiveAndFreeDrivers(0));
        model.addAttribute("allActiveAndFreeTrucks", truckService.listActiveAndFreeTrucks(0));
        model.addAttribute("allActiveAndFreeTrailers", trailerService.listActiveAndFreeTrailers(0));
        return "squadform";
    }
    
    //Validation of form
    @RequestMapping(value="squad", method=RequestMethod.GET)
    public String backToForm() {
        return "squadform";
    }
    
    @RequestMapping(value="squad", method=RequestMethod.POST)
    public String saveSquad(@ModelAttribute("squad") @Valid Squad squad, BindingResult result) {
        if (result.hasErrors()) {
            //form is not filled properly
            return "squadform";
        } else {
            //form is filled properly
        	squadService.saveSquad(squad);
            return "redirect:/squad/" + squad.getId();
        }
    }
    
    @RequestMapping(value = "squads/active/{active}", method = RequestMethod.GET)
    public String listActive(@PathVariable Boolean active, Model model){
        System.out.println("Returning active squads:");
        model.addAttribute("squads", squadService.listActiveSquads(active));
        return "squads";
    }
    
    @ModelAttribute("activeSquads")
    public List<Squad> listAllActiveSquads() {
        return (List<Squad>) this.squadService.listActiveSquads(true);
    }


}
