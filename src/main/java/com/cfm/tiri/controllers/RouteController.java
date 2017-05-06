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

import com.cfm.tiri.domain.Route;
import com.cfm.tiri.services.RouteService;
import com.cfm.tiri.services.SquadService;

@Controller
public class RouteController {
	
	private RouteService routeService;
	private SquadService squadService;


    
    @Autowired
    public void setSquadService(SquadService squadService) {
        this.squadService = squadService;
    }
    
    @Autowired
    public void setRouteService(RouteService routeService) {
        this.routeService = routeService;
    }
    
    
    @RequestMapping(value = "/routes", method = RequestMethod.GET)
    public String list(Model model){
        model.addAttribute("routes", routeService.listAllRoutesOrderByRouteDateDesc());
        model.addAttribute("activeSquads", squadService.listActiveSquads(true));
        model.addAttribute("squads", squadService.listAllSquads());
        System.out.println("Returning refuelings:");
        return "routes";
    }

    
    
    

    @RequestMapping("route/edit/{id}")
    public String edit(@PathVariable long id, Model model){
        model.addAttribute("routes", routeService.getRouteById(id));
        model.addAttribute("activeSquads", squadService.listActiveSquads(true));
        return "routeform";
    }
    
    //Adding refueling
    @RequestMapping("refueling/new")
    public String newRefueling(Model model){
        model.addAttribute("refueling", new Route());
        model.addAttribute("activeSquads", squadService.listActiveSquads(true));
        return "refuelingform";
    }
    
    //Validation of form
    @RequestMapping(value="refueling", method=RequestMethod.GET)
    public String backToRefuelingForm(Model model) {
        model.addAttribute("activeSquads", squadService.listActiveSquads(true));
        return "refuelingform";
    }
    
    @RequestMapping(value="refueling", method=RequestMethod.POST)
    public String saveRefueling(@ModelAttribute("refueling") @Valid Route route, BindingResult result, Model model) {
        if (result.hasErrors()) {
            //form is not filled properly
            model.addAttribute("activeSquads", squadService.listActiveSquads(true));
            return "refuelingform";
        } else {
            //form is filled properly
        	routeService.saveRoute(route);
            return "redirect:/routes";
        }
    }
    
    
    
    //Adding loading
    @RequestMapping("load/new")
    public String newLoad(Model model){
        model.addAttribute("load", new Route());
        model.addAttribute("activeSquads", squadService.listActiveSquads(true));
        return "loadform";
    }
    
    //Validation of form
    @RequestMapping(value="load", method=RequestMethod.GET)
    public String backToLoadForm(Model model) {
        model.addAttribute("activeSquads", squadService.listActiveSquads(true));
        return "loadform";
    }
    
    @RequestMapping(value="load", method=RequestMethod.POST)
    public String saveLoad(@ModelAttribute("load") @Valid Route route, BindingResult result, Model model) {
        if (result.hasErrors()) {
            //form is not filled properly
            model.addAttribute("activeSquads", squadService.listActiveSquads(true));
            return "loadform";
        } else {
            //form is filled properly
        	routeService.saveRoute(route);
            return "redirect:/routes";
        }
    }
    
    

    //Adding unloading
    @RequestMapping("unload/new")
    public String newUnload(Model model){
        model.addAttribute("unload", new Route());
        model.addAttribute("activeSquads", squadService.listActiveSquads(true));
        return "unloadform";
    }
    
    //Validation of form
    @RequestMapping(value="unload", method=RequestMethod.GET)
    public String backToUnloadForm(Model model) {
        model.addAttribute("activeSquads", squadService.listActiveSquads(true));
        return "unloadform";
    }
    
    @RequestMapping(value="unload", method=RequestMethod.POST)
    public String saveUnload(@ModelAttribute("unload") @Valid Route route, BindingResult result, Model model) {
        if (result.hasErrors()) {
            //form is not filled properly
            model.addAttribute("activeSquads", squadService.listActiveSquads(true));
            return "unloadform";
        } else {
            //form is filled properly
        	routeService.saveRoute(route);
            return "redirect:/routes";
        }
    }
    
    
    
    
    
    
    
    
    
    //delete route
	@RequestMapping("route/delete/{id}")
	public String delete(@PathVariable long id){
		routeService.deleteRoute(id);
	    return "redirect:/routes";
	}
	



}
