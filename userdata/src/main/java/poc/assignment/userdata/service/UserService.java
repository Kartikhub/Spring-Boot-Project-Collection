package poc.assignment.userdata.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import poc.assignment.userdata.entity.User;
import poc.assignment.userdata.repo.UserRepo;

@Service
public class UserService {

	@Autowired
	private UserRepo userRepo;

	public User saveUser(User user) {
		return userRepo.save(user);

	}

	// Search User by Name or Surname or Pincode
	public List<User> findUserByUserName(String userName) {
		return userRepo.findUserByUserName(userName);
	}

	// Edit User base on user id
	public User updateUser(User user, Long id) {
		User getUser = userRepo.findById(id).get();
		return userRepo.save(getUser);
	}

	// Sort User by DOB & Joining Date

//	public List<User> getAllSorted(String field) {
//		return userRepo.findAllSorted(Sort.by(Direction.ASC, field));
//	}

}
