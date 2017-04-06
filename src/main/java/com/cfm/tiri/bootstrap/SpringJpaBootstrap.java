package com.cfm.tiri.bootstrap;

import com.cfm.tiri.jpa.Trailer;
import com.cfm.tiri.jpa.TrailerType;
import com.cfm.tiri.jpa.Truck;
import com.cfm.tiri.jpa.Role;
import com.cfm.tiri.jpa.User;
import com.cfm.tiri.repositories.TruckRepository;
import com.cfm.tiri.repositories.UserRepository;
import com.cfm.tiri.repositories.TrailerTypeRepository;
import com.cfm.tiri.repositories.RoleRepository;
import com.cfm.tiri.repositories.TrailerRepository;
import com.cfm.tiri.services.RoleService;
import com.cfm.tiri.services.UserService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;
 
import java.math.BigDecimal;
import java.util.List;
 
@Component
public class SpringJpaBootstrap implements ApplicationListener<ContextRefreshedEvent> {
 
    private TruckRepository truckRepository;
    private TrailerTypeRepository trailerTypeRepository;
    private TrailerRepository trailerRepository;
    private UserRepository userRepository;
    private RoleRepository roleRepository;
    
    private UserService userService;
    private RoleService roleService;
 
    private Logger log = Logger.getLogger(SpringJpaBootstrap.class);
 
    @Autowired
    public void setTruckRepository(TruckRepository truckRepository) {
        this.truckRepository = truckRepository;
    }
    
    @Autowired
    public void setTrailerTypeRepository(TrailerTypeRepository trailerTypeRepository) {
        this.trailerTypeRepository = trailerTypeRepository;
    }
    
    @Autowired
    public void setTrailerRepository(TrailerRepository trailerRepository) {
        this.trailerRepository = trailerRepository;
    }
    
    @Autowired
    public void setUserRepository(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    
    @Autowired
    public void setRoleRepository(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }
 
    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }
 
    @Autowired
    public void setRoleService(RoleService roleService) {
        this.roleService = roleService;
    }
 
 
    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        loadTrucks();
        loadTrailers();
        loadUsers();
        loadRoles();
        assignUsersToUserRole();
        assignUsersToAdminRole();
    }
 
    private void loadTrucks() {

    	Truck wSC98NH = new Truck();
		wSC98NH.setRegistrationNumber("WSC98NH");
		wSC98NH.setProducer("Renault");
		wSC98NH.setModel("Magnum");
		wSC98NH.setEuroStandard("EURO3");
		wSC98NH.setProductionYear(2012);
		wSC98NH.setHorsePower(440);
		wSC98NH.setActive(true);
//		wSC98NH.setCreationDate();
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
//		wSC01LU.setCreationDate();
		truckRepository.save(wSC01LU);
		
		log.info("Zapisano ciągnik - id: " + wSC01LU.getId());
    }
    
    private void loadTrailers() {

    	TrailerType kontenerowa = new TrailerType();
		kontenerowa.setName("kontenerowa");
		trailerTypeRepository.save(kontenerowa);

		log.info("Zapisano katetorię naczepy: " + kontenerowa.getId());
		
		TrailerType chlodnia = new TrailerType();
		chlodnia.setName("chłodnia");
		trailerTypeRepository.save(chlodnia);

		log.info("Zapisano katetorię naczepy: " + chlodnia.getId());

    	Trailer wSC223D = new Trailer();
		wSC223D.setRegistrationNumber("WSC223D");
		wSC223D.setProducer("Wielton");
		wSC223D.setModel("34223");
		wSC223D.setProductionYear(2013);
		wSC223D.setTrailerType(chlodnia);
		wSC223D.setActive(true);
//		wSC223D.setCreationDate();
		trailerRepository.save(wSC223D);

		log.info("Zapisano naczepę - id: " + wSC223D.getId());
		
		Trailer wSC0001 = new Trailer();
		wSC0001.setRegistrationNumber("WSC0001");
		wSC0001.setProducer("Wielton");
		wSC0001.setModel("23432");
		wSC0001.setProductionYear(2010);
		wSC0001.setTrailerType(kontenerowa);
		wSC0001.setActive(false);
//		wSC0001.setCreationDate();
		trailerRepository.save(wSC0001);
		
		log.info("Zapisano naczepę - id: " + wSC0001.getId());
    }
    
    
 
    private void loadUsers() {
        User user1 = new User();
        user1.setUsername("user");
        user1.setPassword("user");
        userService.saveOrUpdate(user1);

        User user2 = new User();
        user2.setUsername("admin");
        user2.setPassword("admin");
        userService.saveOrUpdate(user2);

    }

    private void loadRoles() {
        Role role = new Role();
        role.setRole("USER");
        roleService.saveOrUpdate(role);
        log.info("Saved role" + role.getRole());
        Role adminRole = new Role();
        adminRole.setRole("ADMIN");
        roleService.saveOrUpdate(adminRole);
        log.info("Saved role" + adminRole.getRole());
    }
    private void assignUsersToUserRole() {
        List<Role> roles = (List<Role>) roleService.listAll();
        List<User> users = (List<User>) userService.listAll();

        roles.forEach(role -> {
            if (role.getRole().equalsIgnoreCase("USER")) {
                users.forEach(user -> {
                    if (user.getUsername().equals("user")) {
                        user.addRole(role);
                        userService.saveOrUpdate(user);
                    }
                });
            }
        });
    }
    private void assignUsersToAdminRole() {
        List<Role> roles = (List<Role>) roleService.listAll();
        List<User> users = (List<User>) userService.listAll();

        roles.forEach(role -> {
            if (role.getRole().equalsIgnoreCase("ADMIN")) {
                users.forEach(user -> {
                    if (user.getUsername().equals("admin")) {
                        user.addRole(role);
                        userService.saveOrUpdate(user);
                    }
                });
            }
        });
    }
}
