package kz.nurgalym.adminservice.repo;

import kz.nurgalym.adminservice.model.Content;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContentRepository extends JpaRepository<Content, Long> {
}
