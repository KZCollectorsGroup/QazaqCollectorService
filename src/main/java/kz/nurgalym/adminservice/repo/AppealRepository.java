package kz.nurgalym.adminservice.repo;

import kz.nurgalym.adminservice.model.Appeal;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AppealRepository extends JpaRepository<Appeal, Long> {
}
