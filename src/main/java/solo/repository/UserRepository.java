package solo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import solo.model.User;

public interface UserRepository extends JpaRepository<User,Long> {

}
