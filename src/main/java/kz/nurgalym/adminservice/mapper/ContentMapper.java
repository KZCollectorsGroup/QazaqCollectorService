package kz.nurgalym.adminservice.mapper;

import kz.nurgalym.adminservice.dto.ContentDto;
import kz.nurgalym.adminservice.model.Content;
import org.mapstruct.*;

import java.util.Date;
import java.util.Objects;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface ContentMapper {

    @Mapping(target = "mainMessage", ignore = true)
    @Mapping(target = "announcement", ignore = true)
    Content toDomain(ContentDto contentDto);

    ContentDto toDto(Content content);

    @AfterMapping
    default void updateDates(@MappingTarget Content content) {
        if (Objects.isNull(content.getId()) || content.getId() == 0) {
            content.setCreatedDate(new Date());
        } else {
            content.setUpdatedDate(new Date());
        }
    }
}
