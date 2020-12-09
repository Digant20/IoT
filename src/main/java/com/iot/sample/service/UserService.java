package com.iot.sample.service;


import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.iot.sample.errors.UserNotFoundException;
import com.iot.sample.model.User;
import com.iot.sample.repository.UserRepo;

@Service
@Transactional
public class UserService {

	
    private final Logger log = LoggerFactory.getLogger(UserService.class);

    private final UserRepo userRepo;
	
    public UserService(UserRepo userRepo) {
    	this.userRepo = userRepo;
    }
    
    
    /**
     * Save a user.
     *
     * @param user the entity to save.
     * @return the persisted entity.
     */
    public User save(User user) {
        log.debug("Request to save User : {}", user);
        return userRepo.save(user);
    }
    
    //update
    public User update(User user) {
	    log.debug("Request to save user : {}", user);
		Optional<User> usr=userRepo.findById(user.getId());
		if(!(usr.isPresent()))
		{
			throw new UserNotFoundException("User not found");
		} 
	return userRepo.save(user);
        
    }
    
    
    /**
     * Get one user by id.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    @Transactional(readOnly = true)
    public Optional<User> findOne(String id) {
        log.debug("Request to get User : {}", id);
        return userRepo.findById(id);
    }

    /**
     * Get one user by id.
     * @return the entity.
     */
    public List<User> getAll() {

		return userRepo.findAll();
	}

    

    /**
     * Get one user by user id.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
 /*   @Transactional(readOnly = true)
    public Optional<User> findByUser(String id) {
        log.debug("Request to get Customer : {}", id);
        return userRepo.findByUserId(id);
    }
*/
    
    
    
    
    
    /**
     * Delete the customer by id.
     *
     * @param id the id of the entity.
     */
    public void delete(String id) {
        log.debug("Request to delete Customer : {}", id);
        userRepo.deleteById(id);
        
    }


	    
	
	
}
