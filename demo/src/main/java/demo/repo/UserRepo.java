package demo.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import demo.model.User;
@Repository
public interface UserRepo extends JpaRepository<User, Long> {
	
}