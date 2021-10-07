package com.gia.pokebook.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.gia.pokebook.models.Poke;
import com.gia.pokebook.repositories.PokeRepository;

@Service
public class PokeService {
	   // adding the book repository as a dependency
    private final PokeRepository pokeRepository;
    	
    public PokeService(PokeRepository pokeRepository) {
        this.pokeRepository = pokeRepository;
    }
    // returns all the books
    public List<Poke> allPoke() {
        return pokeRepository.findAll();
    }
    // creates a book
    public Poke createPoke(Poke b) {
        return pokeRepository.save(b);
    }
    // retrieves a book
    public Poke findPoke(Long id) {
        Optional<Poke> optionalPoke= pokeRepository.findById(id);
        if(optionalPoke.isPresent()) {
            return optionalPoke.get();
        } else {
            return null;
        }
    }
    
	public Poke updatePoke(Long id, String expense, String vendor, Double amount, String description) {
		Poke poke = new Poke(expense, vendor, amount, description);
		poke.setId(id);
		pokeRepository.save(poke);
		return null;
	}
	public Poke updatePoke(Poke poke) {
		return pokeRepository.save(poke);
		
	}
	public void deletePoke(Long id) {
		pokeRepository.deleteById(id);
		
	}
}
