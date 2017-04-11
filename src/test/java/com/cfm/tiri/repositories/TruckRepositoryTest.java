package com.cfm.tiri.repositories;

import com.cfm.tiri.configuration.RepositoryConfiguration;
import com.cfm.tiri.domain.Truck;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = {RepositoryConfiguration.class})
public class TruckRepositoryTest {

    private TruckRepository truckRepository;

    @Autowired
    public void setTruckRepository(TruckRepository truckRepository) {
        this.truckRepository = truckRepository;
    }

    @Test
    public void testSaveTruck(){
        //setup truck
    	Truck truck = new Truck();
    	truck.setRegistrationNumber("WW1234");
    	truck.setProducer("Mercedes");
    	truck.setModel("Actros");
    	truck.setEuroStandard("setEuroStandard");
    	truck.setProductionYear(2012);
    	truck.setHorsePower(440);

        //save truck, verify has ID value after save
        assertNull(truck.getId()); //null before save
        truckRepository.save(truck);
        assertNotNull(truck.getId()); //not null after save
        //fetch from DB
        Truck fetchedTruck = truckRepository.findOne(truck.getId());

        //should not be null
        assertNotNull(fetchedTruck);

        //should equal
        assertEquals(truck.getId(), fetchedTruck.getId());
        assertEquals(truck.getRegistrationNumber(), fetchedTruck.getRegistrationNumber());

        //update registration number and save
        fetchedTruck.setRegistrationNumber("AA1234");
        truckRepository.save(fetchedTruck);

        //get from DB, should be updated
        Truck fetchedUpdatedTruck= truckRepository.findOne(fetchedTruck.getId());
        assertEquals(fetchedTruck.getRegistrationNumber(), fetchedUpdatedTruck.getRegistrationNumber());

        //verify number of trucks in DB
        long truckCount = truckRepository.count();
        assertEquals(truckCount, 1);

        //get all trucks, list should only have one
        Iterable<Truck> trucks = truckRepository.findAll();

        int count = 0;

        for(Truck t : trucks){
            count++;
        }

        assertEquals(count, 1);
    }
}
