package com.gia.pokebook.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.gia.pokebook.models.Poke;

@Repository
public interface PokeRepository extends CrudRepository<Poke, Long>{
	 // this method retrieves all the books from the database
	 List<Poke> findAll();
	 // this method finds books with descriptions containing the search string
	 List<Poke> findByDescriptionContaining(String search);
	
}
