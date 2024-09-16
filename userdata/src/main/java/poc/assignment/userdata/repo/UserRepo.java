package poc.assignment.userdata.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import poc.assignment.userdata.entity.User;

public interface UserRepo extends JpaRepository<User, Long> {

	//@Query("from User where userName=?1")
	List<User> findUserByUserName(String userName);

	//List<User> findAllSorted(Sort sort);

}
