package kz.nurgalym.adminservice.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import kz.nurgalym.adminservice.dto.ContentBodyDto;
import kz.nurgalym.adminservice.service.ContentBodyService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Validated
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/content-body")
@Tag(name = "Сообщения", description = "Методы для работы с Сообщениями")
public class ContentBodyController {
    private final ContentBodyService contentBodyService;

    @GetMapping("/{contentId}")
    @Operation(summary = "Метод возвращающий Сообщения по ID обращения")
    public ResponseEntity<List<ContentBodyDto>> findAllByContentId(@PathVariable(value = "contentId") Long id) {
        return new ResponseEntity<>(contentBodyService.findAllByContentId(id), HttpStatus.OK);
    }

    @PostMapping
    @Operation(summary = "Метод для создания/редактирования Сообщения")
    public ResponseEntity<ContentBodyDto> save(@RequestBody ContentBodyDto contentBodyDto) {
        return new ResponseEntity<>(contentBodyService.save(contentBodyDto), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Метод для удаления Сообщения")
    public ResponseEntity<Void> delete(@PathVariable(value = "id") Long id) {
        contentBodyService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
