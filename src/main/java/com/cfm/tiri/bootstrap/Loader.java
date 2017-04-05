package com.cfm.tiri.bootstrap;

import com.cfm.tiri.jpa.Trailer;
//import com.cfm.tiri.jpa.TrailerType;
import com.cfm.tiri.jpa.Truck;

import com.cfm.tiri.repositories.TrailerRepository;
//import com.cfm.tiri.repositories.TrailerTypeRepository;
import com.cfm.tiri.repositories.TruckRepository;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Component
public class Loader implements ApplicationListener<ContextRefreshedEvent> {

	private TruckRepository truckRepository;
	private TrailerRepository trailerRepository;
//	private TrailerTypeRepository trailerTypeRepository;
	private Logger log = Logger.getLogger(Loader.class);

	@Autowired
	public void setTruckRepository(TruckRepository truckRepository) {
		this.truckRepository = truckRepository;
	}
	
	@Autowired
	public void setTrailerRepository(TrailerRepository trailerRepository) {
		this.trailerRepository = trailerRepository;
	}
	
/*	@Autowired
	public void setTrailerTypeRepository(TrailerTypeRepository trailerTypeRepository) {
		this.trailerTypeRepository = trailerTypeRepository;
	}*/

	@Override
	public void onApplicationEvent(ContextRefreshedEvent event) {

		Truck wSC98NH = new Truck();
		wSC98NH.setRegistrationNumber("WSC98NH");
		wSC98NH.setProducer("Renault");
		wSC98NH.setModel("Magnum");
		wSC98NH.setEuroStandard("EURO3");
		wSC98NH.setProductionYear(2012);
		wSC98NH.setHorsePower(440);
		wSC98NH.setActive(true);
		wSC98NH.setCreationDate();
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
		wSC01LU.setCreationDate();
		truckRepository.save(wSC01LU);

		log.info("Zapisano ciągnik - id: " + wSC01LU.getId());
		
		Trailer wSC223D = new Trailer();
		wSC223D.setRegistrationNumber("WSC223D");
		wSC223D.setProducer("Wielton");
		wSC223D.setModel("34223");
		wSC223D.setProductionYear(2013);
		wSC223D.setIdTrailerType(2);
		wSC223D.setActive(true);
		wSC223D.setCreationDate();
		trailerRepository.save(wSC223D);

		log.info("Zapisano naczepę - id: " + wSC223D.getId());
		
		Trailer wSC0001 = new Trailer();
		wSC0001.setRegistrationNumber("WSC0001");
		wSC0001.setProducer("Wielton");
		wSC0001.setModel("23432");
		wSC0001.setProductionYear(2010);
		wSC0001.setIdTrailerType(2);
		wSC0001.setActive(false);
		wSC0001.setCreationDate();
		trailerRepository.save(wSC0001);

		log.info("Zapisano naczepę - id: " + wSC0001.getId());
		/*
		TrailerType kontenerowa = new TrailerType();
		kontenerowa.setTrailerType("kontenerowa");
		trailerTypeRepository.save(kontenerowa);

		log.info("Zapisano katetorię naczepy: " + kontenerowa.getId());
		
		TrailerType chlodnia = new TrailerType();
		chlodnia.setTrailerType("chłodnia");
		trailerTypeRepository.save(chlodnia);

		log.info("Zapisano katetorię naczepy: " + chlodnia.getId());*/
		
	}
}