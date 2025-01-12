package kz.nurgalym.adminservice.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import kz.nurgalym.adminservice.dto.ContentDto;
import kz.nurgalym.adminservice.helper.PageDto;
import kz.nurgalym.adminservice.model.Content;
import kz.nurgalym.adminservice.service.ContentService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Validated
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/content")
@Tag(name = "Обращения", description = "Методы для работы с Обращениями")
public class ContentController {
    private final ContentService contentService;

    @GetMapping
    @Operation(summary = "Метод возвращающий список Обращении с пагинацией")
    public ResponseEntity<PageDto<ContentDto>> findAllForFilter(@PageableDefault(size = 15, sort = {Content.Fields.id}, direction = Sort.Direction.DESC) Pageable pageable) {
        return new ResponseEntity<>(contentService.findAllWithPage(pageable), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    @Operation(summary = "Метод возвращающий Обращение по ID")
    public ResponseEntity<ContentDto> findById(@PathVariable(value = "id") Long id) {
        return new ResponseEntity<>(contentService.findById(id), HttpStatus.OK);
    }

    @PostMapping
    @Operation(summary = "Метод для создания/редактирования Обращения")
    public ResponseEntity<ContentDto> save(@RequestBody ContentDto contentDto) {
        return new ResponseEntity<>(contentService.save(contentDto), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Метод для удаления Обращения")
    public ResponseEntity<Void> delete(@PathVariable(value = "id") Long id) {
        contentService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/all")
    @Operation(summary = "Метод возвращающий список всех Обращении")
    public List<ContentDto> findAll() {
        return contentService.findAll();
    }

}
