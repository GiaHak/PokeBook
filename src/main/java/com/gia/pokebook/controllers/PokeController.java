package com.gia.pokebook.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.gia.pokebook.models.Poke;
import com.gia.pokebook.services.PokeService;

@Controller
public class PokeController {
    private final PokeService pokeService;
    
    public PokeController(PokeService pokeService) {
        this.pokeService = pokeService;
    }
    
 @RequestMapping(value="/expense", method=RequestMethod.POST)
    public String create(@Valid @ModelAttribute("poke") Poke poke, BindingResult result) {
        if (result.hasErrors()) {
            return "/expense/index.jsp";
        } else {
            pokeService.createPoke(poke);
            return "redirect:/expense";
        }
 }
@RequestMapping("/expense" )
public String index (Model model,@ModelAttribute ("poke")Poke poke){
    List<Poke> pokes = pokeService.allPoke();
    model.addAttribute("pokes", pokes);
    return "index.jsp";
}
	@RequestMapping("/expense/details/{id}")
	public String details(Model model, @PathVariable("id")Long id) {
		Poke poke = pokeService.findPoke(id);
		model.addAttribute("poke",poke);
		return "details.jsp"; 
	}
	 @RequestMapping("/expense/edit/{id}")
	    public String edit(@PathVariable("id") Long id, Model model) {
		 Poke poke = pokeService.findPoke(id);;
	        model.addAttribute("poke", poke);
	        return "/edit.jsp";
	    }
	 @RequestMapping(value="/expense/edit/{id}", method=RequestMethod.PUT)
	    public String update(@Valid @ModelAttribute("poke") Poke poke, BindingResult result) {
	        if (result.hasErrors()) {
	            return "/expense/edit.jsp";
	        } else {
	            pokeService.updatePoke(poke);
	            return "redirect:/expense";
	        }
	    }
	 
	 @RequestMapping(value="/destroy/{id}", method=RequestMethod.DELETE)
	    public String destroy(@PathVariable("id") Long id) {
	        pokeService.deletePoke(id);
	        return "redirect:/expense";
	    }
}



