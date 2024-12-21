package kz.nurgalym.adminservice.service.impl;

import kz.nurgalym.adminservice.dto.AppealDto;
import kz.nurgalym.adminservice.exception.CustomException;
import kz.nurgalym.adminservice.helper.PageDto;
import kz.nurgalym.adminservice.mapper.AppealMapper;
import kz.nurgalym.adminservice.model.Appeal;
import kz.nurgalym.adminservice.repo.AppealRepository;
import kz.nurgalym.adminservice.service.AppealService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class AppealServiceImpl implements AppealService {
    private final AppealRepository appealRepository;
    private final AppealMapper appealMapper;

    @Override
    public PageDto<AppealDto> findAllWithPage(Pageable pageable) {
        Page<Appeal> all = appealRepository.findAll(pageable);

        List<AppealDto> appealDtos = all.getContent().stream()
                .map(appealMapper::toDto)
                .toList();

        return PageDto.<AppealDto>builder().pageCount(all.getTotalPages())
                .recordCount(all.getTotalElements())
                .records(appealDtos)
                .pageSize(pageable.getPageSize())
                .pageNumber(pageable.getPageNumber())
                .build();
    }

    @Override
    public List<AppealDto> findAll() {
        return appealRepository.findAll().stream()
                .map(appealMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public AppealDto findById(Long id) {
        Appeal appeal = appealRepository.findById(id).orElseThrow(() ->
                new CustomException(String.format("Обращение с таким ID %s не найден", id), HttpStatus.BAD_REQUEST));

        return appealMapper.toDto(appeal);
    }

    @Override
    public AppealDto save(AppealDto appealDto) {
        Appeal appeal = appealMapper.toDomain(appealDto);
//        brandValidator.validate(brand);
        Appeal saveAppeal = appealRepository.save(appeal);

        return findById(saveAppeal.getId());
    }

    @Override
    public void deleteById(Long id) {
        Appeal byCode = appealRepository.findById(id).orElseThrow(() ->
                new CustomException(String.format("Обращение с таким ID %s не найден", id), HttpStatus.BAD_REQUEST));
        appealRepository.delete(byCode);
    }

}