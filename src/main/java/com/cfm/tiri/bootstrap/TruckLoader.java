package com.cfm.tiri.bootstrap;

import com.cfm.tiri.jpa.Truck;
import com.cfm.tiri.repositories.TruckRepository;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;
 
@Component
public class TruckLoader implements ApplicationListener<ContextRefreshedEvent> {
 
    private TruckRepository truckRepository;
 
    private Logger log = Logger.getLogger(TruckLoader.class);
 
    @Autowired
    public void setTruckRepository(TruckRepository truckRepository) {
        this.truckRepository = truckRepository;
    }
 
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
    }
}