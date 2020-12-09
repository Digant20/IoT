package com.iot.sample.controller;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.iot.sample.errors.UserExistsException;
import com.iot.sample.errors.UserNotFoundException;
import com.iot.sample.json.schema.validation.ValidJson;
import com.iot.sample.model.User;
import com.iot.sample.service.UserService;

import static com.iot.sample.SchemaLocations.THESCHEMA;

@RestController
@RequestMapping("/api")
public class UserController {
	
	private final Logger log = LoggerFactory.getLogger(UserController.class);
	
	private final UserService userService;
	
	public UserController(UserService userSer) {
		this.userService = userSer;
	}
//	
//	@PostMapping("/paintings")
//    public ResponseEntity<Void> createPainting(@ValidJson(PAINTING) Painting painting) {
//        System.out.println("Validated painting: " + painting);
//        return ResponseEntity.ok().build();
//    }
	
	//endpoint for adding a new user
	
	@PostMapping("/users")
	public ResponseEntity<User> createUser(@ValidJson(THESCHEMA) @RequestBody User user){
		log.debug("REST request to save user : {}", user);
		if (user.getId() != null) {
			
			throw new UserExistsException("User already exists");
		}
		
		User result = userService.save(user);
		
		return ResponseEntity.ok().body(result);
				
		
	}
	
	
	
	@PutMapping("/users")
    public ResponseEntity<User> updateCustomer(@ValidJson(THESCHEMA) @RequestBody User user) {
        log.debug("REST request to update user : {}", user);
        if (user.getEmail() == null) {
        	
        	throw new UserNotFoundException("User Not Found");
        	
        }

        User result = userService.update(user);
        return ResponseEntity.ok().body(result);
    }

	
	/**
     * {@code GET  /users} : get all the users.
     *
     * @param pageable the pagination information.
     * @param criteria the criteria which the requested entities should match.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list of users in body.
     */
    @GetMapping("/users")
    public ResponseEntity<List<User>> getAllUsers() {
    	List<User> theUser = userService.getAll();
       
        return ResponseEntity.ok().body(theUser);
    }
	
	
    
    /**
     * {@code GET  /users/:id} : get the "id" of the user.
     *
     * @param id the id of the user to retrieve.
     * @return the {@link Optional<User>.
     */
    @GetMapping("/users/{id}")
    public Optional<User> getUser(@PathVariable String id) {
        log.debug("REST request to get User : {}", id);
        Optional<User> user = userService.findOne(id);
        if(user == null) {
        	throw new UserNotFoundException("User does not exist.");
        }
        return user;
    }
    
    
    /**
     * {@code DELETE  /users/:id} : delete the "id" user.
     *
     * @param id the id of the user to delete.
     * @return the {@link ResponseEntity} with status {@code 204 (NO_CONTENT)}.
     */
    @DeleteMapping("/users/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable String id) {
        log.debug("REST request to delete Customer : {}", id);
        Optional<User> theUser = userService.findOne(id);
        if(theUser == null) {
        	throw new UserNotFoundException("User does not exist.");
        }
        userService.delete(id);
        return ResponseEntity.ok().build();
    }
    
		
}
