package kz.nurgalym.adminservice.repo;

import kz.nurgalym.adminservice.model.ContentBody;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ContentBodyRepository extends JpaRepository<ContentBody, Long> {

    List<ContentBody> findAllByContentId(Long content);
}
