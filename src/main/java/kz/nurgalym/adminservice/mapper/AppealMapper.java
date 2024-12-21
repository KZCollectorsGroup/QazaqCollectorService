package kz.nurgalym.adminservice.mapper;

import kz.nurgalym.adminservice.dto.AppealDto;
import kz.nurgalym.adminservice.model.Appeal;
import org.mapstruct.*;

import java.util.Date;
import java.util.Objects;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface AppealMapper {

    Appeal toDomain(AppealDto appealDto);

    AppealDto toDto(Appeal appeal);

    @AfterMapping
    default void updateDates(@MappingTarget Appeal appeal) {
        if (Objects.isNull(appeal.getId()) || appeal.getId() == 0) {
            appeal.setCreatedDate(new Date());
        } else {
            appeal.setUpdatedDate(new Date());
        }
    }
}
