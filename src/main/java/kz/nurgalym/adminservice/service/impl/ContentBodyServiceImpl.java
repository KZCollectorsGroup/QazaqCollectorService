package kz.nurgalym.adminservice.service.impl;

import kz.nurgalym.adminservice.dto.ContentBodyDto;
import kz.nurgalym.adminservice.dto.ContentBodyLangDto;
import kz.nurgalym.adminservice.exception.CustomException;
import kz.nurgalym.adminservice.mapper.ContentBodyMapper;
import kz.nurgalym.adminservice.model.ContentBody;
import kz.nurgalym.adminservice.repo.ContentBodyRepository;
import kz.nurgalym.adminservice.service.ContentBodyService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ContentBodyServiceImpl implements ContentBodyService {
    private final ContentBodyRepository contentBodyRepository;
    private final ContentBodyMapper contentBodyMapper;


    @Override
    public List<ContentBodyDto> findAllByContentId(Long contentId) {
        return contentBodyRepository.findAllByContentId(contentId).stream()
                .map(contentBodyMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public ContentBodyDto findById(Long id) {
        ContentBody contentBody = contentBodyRepository.findById(id).orElseThrow(() ->
                new CustomException(String.format("Сообщение с таким ID %s не найден", id), HttpStatus.BAD_REQUEST));

        return contentBodyMapper.toDto(contentBody);
    }

    @Override
    public ContentBodyDto save(ContentBodyDto contentBodyDto) {
        ContentBody contentBody = contentBodyMapper.toDomain(contentBodyDto);
//        brandValidator.validate(brand);
        ContentBody saveContentBody = contentBodyRepository.save(contentBody);

        return findById(saveContentBody.getId());
    }

    @Override
    public void deleteById(Long id) {
        ContentBody byCode = contentBodyRepository.findById(id).orElseThrow(() ->
                new CustomException(String.format("Сообщение с таким ID %s не найден", id), HttpStatus.BAD_REQUEST));
        contentBodyRepository.delete(byCode);
    }

}