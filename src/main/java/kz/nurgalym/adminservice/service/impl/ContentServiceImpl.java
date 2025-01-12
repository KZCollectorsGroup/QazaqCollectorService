package kz.nurgalym.adminservice.service.impl;

import kz.nurgalym.adminservice.dto.ContentDto;
import kz.nurgalym.adminservice.exception.CustomException;
import kz.nurgalym.adminservice.helper.PageDto;
import kz.nurgalym.adminservice.mapper.ContentMapper;
import kz.nurgalym.adminservice.model.Content;
import kz.nurgalym.adminservice.repo.ContentRepository;
import kz.nurgalym.adminservice.service.ContentService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ContentServiceImpl implements ContentService {
    private final ContentRepository contentRepository;
    private final ContentMapper contentMapper;

    @Override
    public PageDto<ContentDto> findAllWithPage(Pageable pageable) {
        Page<Content> all = contentRepository.findAll(pageable);

        List<ContentDto> contentDtos = all.getContent().stream()
                .map(contentMapper::toDto)
                .toList();

        return PageDto.<ContentDto>builder().pageCount(all.getTotalPages())
                .recordCount(all.getTotalElements())
                .records(contentDtos)
                .pageSize(pageable.getPageSize())
                .pageNumber(pageable.getPageNumber())
                .build();
    }

    @Override
    public List<ContentDto> findAll() {
        return contentRepository.findAll().stream()
                .map(contentMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public ContentDto findById(Long id) {
        Content content = contentRepository.findById(id).orElseThrow(() ->
                new CustomException(String.format("Обращение с таким ID %s не найден", id), HttpStatus.BAD_REQUEST));

        return contentMapper.toDto(content);
    }

    @Override
    public ContentDto save(ContentDto contentDto) {
        Content content = contentMapper.toDomain(contentDto);
//        brandValidator.validate(brand);
        Content saveContent = contentRepository.save(content);

        return findById(saveContent.getId());
    }

    @Override
    public void deleteById(Long id) {
        Content byCode = contentRepository.findById(id).orElseThrow(() ->
                new CustomException(String.format("Обращение с таким ID %s не найден", id), HttpStatus.BAD_REQUEST));
        contentRepository.delete(byCode);
    }

}