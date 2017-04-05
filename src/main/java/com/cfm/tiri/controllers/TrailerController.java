package com.cfm.tiri.controllers;

import com.cfm.tiri.jpa.Trailer;
import com.cfm.tiri.services.TrailerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class TrailerController {

    private TrailerService trailerService;

    @Autowired
    public void setTrailerService(TrailerService trailerService) {
        this.trailerService = trailerService;
    }

    @RequestMapping(value = "/trailers", method = RequestMethod.GET)
    public String list(Model model){
        model.addAttribute("trailers", trailerService.listAllTrailers());
        System.out.println("Returning trailers:");
        return "trailers";
    }

    @RequestMapping("trailer/{id}")
    public String showTrailer(@PathVariable Integer id, Model model){
        model.addAttribute("trailer", trailerService.getTrailerById(id));
        return "trailershow";
    }

    @RequestMapping("trailer/edit/{id}")
    public String edit(@PathVariable Integer id, Model model){
        model.addAttribute("trailer", trailerService.getTrailerById(id));
        return "trailerform";
    }

    @RequestMapping("trailer/new")
    public String newTrailer(Model model){
        model.addAttribute("trailer", new Trailer());
        return "trailerform";
    }

    @RequestMapping(value = "trailer", method = RequestMethod.POST)
    public String saveTrailer(Trailer trailer){

    	trailerService.saveTrailer(trailer);

        return "redirect:/trailer/" + trailer.getId();
    }
    


}
