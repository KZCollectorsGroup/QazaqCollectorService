package kz.nurgalym.adminservice.service;

import kz.nurgalym.adminservice.dto.AppealDto;
import kz.nurgalym.adminservice.helper.PageDto;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface AppealService {
    PageDto<AppealDto> findAllWithPage(Pageable pageable);

    List<AppealDto> findAll();

    AppealDto findById(Long id);

    AppealDto save(AppealDto appealDto);

    void deleteById(Long id);

}