package kz.nurgalym.adminservice.repo;

import kz.nurgalym.adminservice.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {
}
