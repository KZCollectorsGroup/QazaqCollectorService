package kz.nurgalym.adminservice.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import kz.nurgalym.adminservice.dto.MessageDto;
import kz.nurgalym.adminservice.service.MessageService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Validated
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/message")
@Tag(name = "Сообщения", description = "Методы для работы с Сообщениями")
public class MessageController {
    private final MessageService messageService;

    @GetMapping("/{appealId}")
    @Operation(summary = "Метод возвращающий Сообщения по ID обращения")
    public ResponseEntity<List<MessageDto>> findAllByAppealId(@PathVariable(value = "appealId") Long id) {
        return new ResponseEntity<>(messageService.findAllByAppealId(id), HttpStatus.OK);
    }

    @PostMapping
    @Operation(summary = "Метод для создания/редактирования Сообщения")
    public ResponseEntity<MessageDto> save(@RequestBody MessageDto messageDto) {
        return new ResponseEntity<>(messageService.save(messageDto), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Метод для удаления Сообщения")
    public ResponseEntity<Void> delete(@PathVariable(value = "id") Long id) {
        messageService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
