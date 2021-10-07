package com.gia.pokebook.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.gia.pokebook.models.Poke;
import com.gia.pokebook.services.PokeService;

@RestController
public class PokeAPI {
    private final PokeService pokeService;
    
    public PokeAPI(PokeService pokeService){
        this.pokeService = pokeService;
    }
    @RequestMapping("/api/poke")
    public List<Poke> index() {
        return pokeService.allPoke();
    }
    
    @RequestMapping(value="/api/expense", method=RequestMethod.POST)
    public Poke create(@RequestParam(value="expense") String expense, @RequestParam(value="vendor") String vendor, @RequestParam(value="amount") Double amount, @RequestParam(value="description") String description) {
        Poke poke = new Poke(expense, vendor, amount, description);
        
        return pokeService.createPoke(poke);
    }
    
    @RequestMapping("/api/expense/{id}")
    public Poke show(@PathVariable("id") Long id) {
        Poke poke= pokeService.findPoke(id);
        return poke;
    }
    // other methods removed for brevity
    @RequestMapping(value="/api/expense/{id}", method=RequestMethod.PUT)
    public Poke update(
    		@PathVariable("id") Long id, 
    		@RequestParam(value="expense") String expense, 
    		@RequestParam(value="vendor") String vendor, 
    		@RequestParam(value="amount") Double amount,
    		@RequestParam(value="description") String description) {
    		Poke poke = pokeService.updatePoke(id, expense, vendor, amount, description);
        return poke;
    }
    
    @RequestMapping(value="/api/expense/{id}", method=RequestMethod.DELETE)
    public void destroy(@PathVariable("id") Long id) {
        pokeService.deletePoke(id);
    }
}