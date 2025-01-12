package kz.nurgalym.adminservice.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import kz.nurgalym.adminservice.dto.UserDto;
import kz.nurgalym.adminservice.helper.PageDto;
import kz.nurgalym.adminservice.model.User;
import kz.nurgalym.adminservice.service.UserService;
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
@RequestMapping("/api/user")
@Tag(name = "Пользователи", description = "Методы для работы с Пользователями")
public class UserController {
    private final UserService userService;

    @GetMapping
    @Operation(summary = "Метод возвращающий список Пользователей с пагинацией")
    public ResponseEntity<PageDto<UserDto>> findAllForFilter(@PageableDefault(size = 15, sort = {User.Fields.id}, direction = Sort.Direction.DESC) Pageable pageable) {
        return new ResponseEntity<>(userService.findAllWithPage(pageable), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    @Operation(summary = "Метод возвращающий Пользователя по ID")
    public ResponseEntity<UserDto> findById(@PathVariable(value = "id") Long id) {
        return new ResponseEntity<>(userService.findById(id), HttpStatus.OK);
    }

    @PostMapping
    @Operation(summary = "Метод для создания/редактирования Пользователя")
    public ResponseEntity<UserDto> save(@RequestBody UserDto userDto) {
        return new ResponseEntity<>(userService.save(userDto), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Метод для удаления Пользователя")
    public ResponseEntity<Void> delete(@PathVariable(value = "id") Long id) {
        userService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/all")
    @Operation(summary = "Метод возвращающий список всех Пользователей")
    public List<UserDto> findAll() {
        return userService.findAll();
    }

}
