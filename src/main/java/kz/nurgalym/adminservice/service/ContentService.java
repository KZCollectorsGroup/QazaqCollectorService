package kz.nurgalym.adminservice.service;

import kz.nurgalym.adminservice.dto.ContentDto;
import kz.nurgalym.adminservice.helper.PageDto;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ContentService {
    PageDto<ContentDto> findAllWithPage(Pageable pageable);

    List<ContentDto> findAll();

    ContentDto findById(Long id);

    ContentDto save(ContentDto contentDto);

    void deleteById(Long id);

}