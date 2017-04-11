package com.cfm.tiri.bootstrap;

import com.cfm.tiri.domain.Role;
import com.cfm.tiri.domain.Trailer;
import com.cfm.tiri.domain.TrailerType;
import com.cfm.tiri.domain.Truck;
import com.cfm.tiri.domain.User;
import com.cfm.tiri.repositories.RoleRepository;
import com.cfm.tiri.repositories.TrailerRepository;
import com.cfm.tiri.repositories.TrailerTypeRepository;
import com.cfm.tiri.repositories.TruckRepository;
import com.cfm.tiri.repositories.UserRepository;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Component
public class Loader implements ApplicationListener<ContextRefreshedEvent> {

	private TruckRepository truckRepository;
	private TrailerRepository trailerRepository;
	private TrailerTypeRepository trailerTypeRepository;
	private RoleRepository roleRepository;
	private UserRepository userRepository;
	private Logger log = Logger.getLogger(Loader.class);

	@Autowired
	public void setTruckRepository(TruckRepository truckRepository) {
		this.truckRepository = truckRepository;
	}
	
	@Autowired
	public void setTrailerRepository(TrailerRepository trailerRepository) {
		this.trailerRepository = trailerRepository;
	}
	
	@Autowired
	public void setTrailerTypeRepository(TrailerTypeRepository trailerTypeRepository) {
		this.trailerTypeRepository = trailerTypeRepository;
	}
	
	@Autowired
	public void setRoleRepository(RoleRepository roleRepository) {
		this.roleRepository = roleRepository;
	}
	
	@Autowired
	public void setUserRepository(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	@Override
	public void onApplicationEvent(ContextRefreshedEvent event) {

//TRUCK
		
		Truck wSC98NH = new Truck();
		wSC98NH.setRegistrationNumber("WSC98NH");
		wSC98NH.setProducer("Renault");
		wSC98NH.setModel("Magnum");
		wSC98NH.setEuroStandard("EURO3");
		wSC98NH.setProductionYear(2012);
		wSC98NH.setHorsePower(440);
		wSC98NH.setActive(true);
		wSC98NH.setVersion(0);
		truckRepository.save(wSC98NH);

		log.info("Zapisano ciągnik - id: " + wSC98NH.getId());

		Truck wSC01LU = new Truck();
		wSC01LU.setRegistrationNumber("WSC01LU");
		wSC01LU.setProducer("Renault");
		wSC01LU.setModel("Magnum");
		wSC01LU.setEuroStandard("EURO5");
		wSC01LU.setProductionYear(2013);
		wSC01LU.setHorsePower(440);
		wSC01LU.setActive(true);
		wSC01LU.setVersion(0);
		truckRepository.save(wSC01LU);
		
		log.info("Zapisano ciągnik - id: " + wSC01LU.getId());

//TRAILER_TYPE


		
		TrailerType kontenerowa = new TrailerType();
		kontenerowa.setName("kontenerowa");
		kontenerowa.setVersion(0);
		trailerTypeRepository.save(kontenerowa);

		log.info("Zapisano katetorię naczepy: " + kontenerowa.getId());
		
		TrailerType chlodnia = new TrailerType();
		chlodnia.setName("chłodnia");
		chlodnia.setVersion(0);
		trailerTypeRepository.save(chlodnia);

		log.info("Zapisano katetorię naczepy: " + chlodnia.getId());
		
//TRAILER
		
		Trailer wSC223D = new Trailer();
		wSC223D.setRegistrationNumber("WSC223D");
		wSC223D.setProducer("Wielton");
		wSC223D.setModel("34223");
		wSC223D.setProductionYear(2013);
		wSC223D.setTrailerType(chlodnia);
		wSC223D.setActive(true);
		wSC223D.setVersion(0);
		trailerRepository.save(wSC223D);

		log.info("Zapisano naczepę - id: " + wSC223D.getId());
		
		Trailer wSC0001 = new Trailer();
		wSC0001.setRegistrationNumber("WSC0001");
		wSC0001.setProducer("Wielton");
		wSC0001.setModel("23432");
		wSC0001.setProductionYear(2010);
		wSC0001.setTrailerType(kontenerowa);
		wSC0001.setActive(false);
		wSC0001.setVersion(0);
		trailerRepository.save(wSC0001);
		
		log.info("Zapisano naczepę - id: " + wSC0001.getId());
		
		Role admin = new Role();
		admin.setName("ADMIN");
		admin.setVersion(0);
		roleRepository.save(admin);
		
		log.info("Zapisano rolę - id: " + admin.getId());
		
		Role user = new Role();
		user.setName("USER");
		user.setVersion(0);
		roleRepository.save(user);
		
		log.info("Zapisano rolę - id: " + user.getId());
		
		User user1 = new User();
		user1.setFirstName("Adam");
		user1.setLastName("Kowalski");
		user1.setLogin("akowalski");
		user1.setPassword("akowalski");
		user1.setMobilePhone("602123123");
		user1.setEmail("akowalski@tester.pl");
		user1.setRole(admin);
		user1.setActive(true);
	
		userRepository.save(user1);
		
		log.info("Zapisano użytkownika - id: " + user1.getId());
		
		User user2 = new User();
		user2.setFirstName("Katarzyna");
		user2.setLastName("Nowak");
		user2.setLogin("knowak");
		user2.setPassword("knowak");
		user2.setMobilePhone("602234123");
		user2.setEmail("knowak@tester.pl");
		user2.setRole(user);
		user2.setActive(true);
	
		userRepository.save(user2);
		
		log.info("Zapisano użytkownika - id: " + user2.getId());
	}
}