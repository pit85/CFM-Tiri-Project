package com.cfm.tiri.repositories;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.*;

import java.util.List;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import com.cfm.tiri.domain.Role;
import com.cfm.tiri.domain.Squad;
import com.cfm.tiri.domain.Trailer;
import com.cfm.tiri.domain.TrailerType;
import com.cfm.tiri.domain.Truck;
import com.cfm.tiri.domain.User;

@RunWith(SpringRunner.class)
@DataJpaTest
public class TrailerRepositoryTest {
	
	@Autowired
	private TestEntityManager entityManager;
	
	@Autowired
	private TrailerRepository trailerRepository;
	
	@Autowired
	private SquadRepository squadRepository;
	

	
	@Test
	public void whenFindByRegistrationNumber_thenReturnTrailer() {
	    // given
		TrailerType trailerType = new TrailerType("firanka");
	    entityManager.persist(trailerType);
	    entityManager.flush();
		
	    Trailer testTrailer = new Trailer("TEST001", "Wielton", "test-01", 2001, true, trailerType); 
	    entityManager.persist(testTrailer);
	    entityManager.flush();
	 
	    // when
	    Trailer found = trailerRepository.findByRegistrationNumber(testTrailer.getRegistrationNumber());
	 
	    // then
	    assertThat(found.getRegistrationNumber()).isEqualTo(testTrailer.getRegistrationNumber());
	    
	}
	    
	@Test
	public void whenFindActiveAndFree_thenReturnActiveAndFreeTrailer(){
		
		// create entities 
		TrailerType trailerType = new TrailerType("firanka");
	    entityManager.persist(trailerType);
	    entityManager.flush();
		
	    Trailer activeTrailer1 = new Trailer("TEST001", "Wielton", "test-01", 2001, true, trailerType); 
	    entityManager.persist(activeTrailer1);
	    entityManager.flush();
	    
	    Trailer activeTrailer2 = new Trailer("TEST002", "Wielton", "test-02", 2002, true, trailerType); 
	    entityManager.persist(activeTrailer2);
	    entityManager.flush();
	    
	    Trailer notActiveTrailer1 = new Trailer("TEST003", "Wielton", "test-03", 2002, false, trailerType); 
	    entityManager.persist(notActiveTrailer1);
	    entityManager.flush();
	    
	    Truck activeTruck1 = new Truck(1, "TEST005", "Renault", "440E", "EURO5", 2004,  440, true);
	    entityManager.persist(activeTruck1);
	    entityManager.flush();
	    
	    Role userRole = new Role("kierowca");
	    entityManager.persist(userRole);
	    entityManager.flush();
	    
	    User activeUser1 = new User("Adam", "Miałczynski", userRole, "haslo", "600060060", "adam.mialczynski@test.pl", true);
	    entityManager.persist(activeUser1);
	    entityManager.flush();
	    
	    Squad activeSquad1 = new Squad(activeTruck1, activeTrailer1, activeUser1);
	    entityManager.persist(activeSquad1);
	    entityManager.flush();
	    
	    assertThat(activeSquad1.getId()).isEqualTo(1);
	    
	    
	    //make sure that collection contain only active trailers, trailers which do not belong to any squad and to squad which is mentioned
	    List<Trailer> activeAndFree = (List<Trailer>) trailerRepository.findActiveAndFree(activeSquad1.getId());
	    
	    //active squads
	    List<Squad> activeSquads = (List<Squad>) squadRepository.findByActive(true);
	    
		for(int i = 0; i < activeAndFree.size() ; i++){
			
			//check if trailer is active
			assertThat(activeAndFree.get(i).getActive()).isEqualTo(true);
		        
			//check if objects do not belong to any active squad
			
			
			for(int j = 0; j < activeSquads.size(); j++){
				
				assertThat(activeSquads.get(j).getTrailer()).isNotEqualTo(activeAndFree.get(i));
				
			}
			
			
			//Check if trailer does not belong to mentioned squad
			
//			assertThat(activeAndFree.get(i)).isNotEqualTo(activeSquad1.getTrailer());
		        
		}
	    
		//native querry supposed to return one trailer
		
		
		//assertEquals(activeSquads.size(),100);
		
	}
	
	
}