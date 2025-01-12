package kz.nurgalym.adminservice.service;

import kz.nurgalym.adminservice.dto.UserDto;
import kz.nurgalym.adminservice.helper.PageDto;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface UserService {
    PageDto<UserDto> findAllWithPage(Pageable pageable);

    List<UserDto> findAll();

    UserDto findById(Long id);

    UserDto save(UserDto userDto);

    void deleteById(Long id);

}