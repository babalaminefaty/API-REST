package sn.faty.API.REST.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sn.faty.API.REST.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {


}
