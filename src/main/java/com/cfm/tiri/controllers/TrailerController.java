package com.cfm.tiri.controllers;

import com.cfm.tiri.domain.Trailer;
import com.cfm.tiri.domain.TrailerType;
import com.cfm.tiri.services.TrailerService;
import com.cfm.tiri.services.TrailerTypeService;
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
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class TrailerController {

    private TrailerService trailerService;
    private TrailerTypeService trailerTypeService;

    @Autowired
    public void setTrailerService(TrailerService trailerService) {
        this.trailerService = trailerService;
    }
    
    @Autowired
    public void setTrailerTypeService(TrailerTypeService trailerTypeService) {
        this.trailerTypeService = trailerTypeService;
    }

    @RequestMapping(value = "/trailers", method = RequestMethod.GET)
    public String list(Model model){
        model.addAttribute("trailers", trailerService.listAllTrailers());
        return "trailers";
    }

    @RequestMapping("trailer/{id}")
    public String showTrailer(@PathVariable long id, Model model){
        model.addAttribute("trailer", trailerService.getTrailerById(id));
        return "trailershow";
    }

    @RequestMapping("trailer/edit/{id}")
    public String edit(@PathVariable long id, Model model){
        model.addAttribute("trailer", trailerService.getTrailerById(id));
        return "trailerform";
    }

    @RequestMapping("trailer/new")
    public String newTrailer(Model model){
        model.addAttribute("trailer", new Trailer());
        return "trailerform";
    }

    //Validation of form
    @RequestMapping(value="trailer", method=RequestMethod.GET)
    public String backToForm() {
        return "trailerform";
    }

    @RequestMapping(value="trailer", method=RequestMethod.POST)
    public String saveTrailer(@ModelAttribute("trailer") @Valid Trailer trailer, BindingResult result) {
        if (result.hasErrors()) {
            //form is not filled properly
            return "trailerform";
        } else {
            //form is filled properly
        	trailerService.saveTrailer(trailer);
            return "redirect:/trailers/" ;
        }
    }
    
    @ModelAttribute("allTrailerTypes")
    public List<TrailerType> listAllTrailerTypes() {
        return (List<TrailerType>) this.trailerTypeService.listAllTrailerTypes();
    }
    
	@RequestMapping(value = "trailers/search", method = RequestMethod.GET)
	public String listActive(
			@RequestParam(defaultValue="0", value = "option", required = false) int option,
			Model model) {
		
		switch (option){
		case 1:
			model.addAttribute("trailers", trailerService.listActiveTrailers(true));
			break;
		case 2:
			model.addAttribute("trailers", trailerService.listActiveTrailers(false));
			break;
		case 0:
			model.addAttribute("trailers", trailerService.listAllTrailers());
			break;
		}
		
		return "trailers";
	}

}
