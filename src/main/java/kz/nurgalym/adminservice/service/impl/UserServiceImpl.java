package kz.nurgalym.adminservice.service.impl;

import kz.nurgalym.adminservice.dto.UserDto;
import kz.nurgalym.adminservice.exception.CustomException;
import kz.nurgalym.adminservice.helper.PageDto;
import kz.nurgalym.adminservice.mapper.UserMapper;
import kz.nurgalym.adminservice.model.User;
import kz.nurgalym.adminservice.repo.UserRepository;
import kz.nurgalym.adminservice.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final UserMapper userMapper;

    @Override
    public PageDto<UserDto> findAllWithPage(Pageable pageable) {
        Page<User> all = userRepository.findAll(pageable);

        List<UserDto> userDtos = all.getContent().stream()
                .map(userMapper::toDto)
                .toList();

        return PageDto.<UserDto>builder().pageCount(all.getTotalPages())
                .recordCount(all.getTotalElements())
                .records(userDtos)
                .pageSize(pageable.getPageSize())
                .pageNumber(pageable.getPageNumber())
                .build();
    }

    @Override
    public List<UserDto> findAll() {
        return userRepository.findAll().stream()
                .map(userMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public UserDto findById(Long id) {
        User user = userRepository.findById(id).orElseThrow(() ->
                new CustomException(String.format("Пользователь с таким ID %s не найден", id), HttpStatus.BAD_REQUEST));

        return userMapper.toDto(user);
    }

    @Override
    public UserDto save(UserDto userDto) {
        User user = userMapper.toDomain(userDto);
//        brandValidator.validate(brand);
        User saveUser = userRepository.save(user);

        return findById(saveUser.getId());
    }

    @Override
    public void deleteById(Long id) {
        User byCode = userRepository.findById(id).orElseThrow(() ->
                new CustomException(String.format("Пользователь с таким ID %s не найден", id), HttpStatus.BAD_REQUEST));
        userRepository.delete(byCode);
    }

}