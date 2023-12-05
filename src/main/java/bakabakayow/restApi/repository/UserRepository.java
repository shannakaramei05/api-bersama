package bakabakayow.restApi.repository;

import bakabakayow.restApi.constants.UserRole;
import bakabakayow.restApi.model.Bookings;
import bakabakayow.restApi.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<Users,Long> {
    Optional<Users> findUserByEmail (String email);
    List<Users> findUsersByRole (UserRole role);
}
