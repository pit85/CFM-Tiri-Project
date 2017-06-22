/*package com.cfm.tiri.repositories;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import com.cfm.tiri.domain.Trailer;

public class TrailerRepositoryTest {
	
	@Autowired
	private TrailerRepository trailerRepository;
	
	@Autowired private JdbcTemplate jdbcTemplate; 
	
    @PersistenceContext private EntityManager em;
    
    //------------------------------------------------- find all
    
    public void testFindAll() {
    	Iterable<Trailer> trailers = trailerRepository.findAll();
    	assertThat(trailers.toString())
    	
    }


}
*/