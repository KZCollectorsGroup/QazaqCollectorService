package kz.nurgalym.adminservice.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import kz.nurgalym.adminservice.dto.AppealDto;
import kz.nurgalym.adminservice.helper.PageDto;
import kz.nurgalym.adminservice.model.Appeal;
import kz.nurgalym.adminservice.service.AppealService;
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
@RequestMapping("/api/appeal")
@Tag(name = "Обращения", description = "Методы для работы с Обращениями")
public class AppealController {
    private final AppealService appealService;

    @GetMapping
    @Operation(summary = "Метод возвращающий список Обращении с пагинацией")
    public ResponseEntity<PageDto<AppealDto>> findAllForFilter(@PageableDefault(size = 15, sort = {Appeal.Fields.id}, direction = Sort.Direction.DESC) Pageable pageable) {
        return new ResponseEntity<>(appealService.findAllWithPage(pageable), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    @Operation(summary = "Метод возвращающий Обращение по ID")
    public ResponseEntity<AppealDto> findById(@PathVariable(value = "id") Long id) {
        return new ResponseEntity<>(appealService.findById(id), HttpStatus.OK);
    }

    @PostMapping
    @Operation(summary = "Метод для создания/редактирования Обращения")
    public ResponseEntity<AppealDto> save(@RequestBody AppealDto appealDto) {
        return new ResponseEntity<>(appealService.save(appealDto), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Метод для удаления Обращения")
    public ResponseEntity<Void> delete(@PathVariable(value = "id") Long id) {
        appealService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/all")
    @Operation(summary = "Метод возвращающий список всех Обращении")
    public List<AppealDto> findAll() {
        return appealService.findAll();
    }

}
