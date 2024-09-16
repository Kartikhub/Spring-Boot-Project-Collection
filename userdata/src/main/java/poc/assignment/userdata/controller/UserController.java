package poc.assignment.userdata.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import poc.assignment.userdata.entity.User;
import poc.assignment.userdata.service.UserService;

@RestController
@RequestMapping("/userdata")
public class UserController {
	
	@Autowired
	private UserService userService;

	@PostMapping("/saveUser")
	public ResponseEntity<User> saveUser(@RequestBody @Valid User user) {
		User userSave = userService.saveUser(user);
		return ResponseEntity.status(HttpStatus.CREATED).body(userSave);
	}
	
	@GetMapping("/getByuserName/{userName}")
	public ResponseEntity<List<User>> findById(@PathVariable String userName) {
		 List<User> getUserByName = userService.findUserByUserName(userName);
		return ResponseEntity.status(HttpStatus.OK).body(getUserByName);
	}
	
	@PostMapping("/updateById/{userId}")
	public ResponseEntity<User> updateUserById(@RequestBody User user, @PathVariable Long id){
		User updateById = userService.updateUser(user, id);
		return ResponseEntity.status(HttpStatus.CREATED).body(updateById);
	}
	
//	@GetMapping("/sortByField/field")
//	public ResponseEntity<List<User>> sortByField(@PathVariable String field){
//		List<User> findAllSorted = userService.getAllSorted(field);
//		return ResponseEntity.status(HttpStatus.OK).body(findAllSorted);
//	}
	
}
