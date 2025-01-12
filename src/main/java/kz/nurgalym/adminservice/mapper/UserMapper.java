package kz.nurgalym.adminservice.mapper;

import kz.nurgalym.adminservice.dto.UserDto;
import kz.nurgalym.adminservice.model.Content;
import kz.nurgalym.adminservice.model.User;
import org.mapstruct.AfterMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import org.mapstruct.MappingTarget;

import java.util.Date;
import java.util.Objects;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface UserMapper {

    User toDomain(UserDto userDto);

    UserDto toDto(User user);

    @AfterMapping
    default void updateDates(@MappingTarget User user) {
        if (Objects.isNull(user.getId()) || user.getId() == 0) {
            user.setCreatedDate(new Date());
        } else {
            user.setUpdatedDate(new Date());
        }
    }
}
