package kz.nurgalym.adminservice.service;

import kz.nurgalym.adminservice.dto.ContentBodyDto;

import java.util.List;

public interface ContentBodyService {
    List<ContentBodyDto> findAllByContentId(Long contentId);

    ContentBodyDto findById(Long id);

    ContentBodyDto save(ContentBodyDto contentBodyDto);

    void deleteById(Long id);

}