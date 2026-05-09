package sales_savvy.repository;

import sales_savvy.entity.User;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer>
{

	Optional<User> findByUsername(String username);

	Optional<User> findByEmail(String email);

}
