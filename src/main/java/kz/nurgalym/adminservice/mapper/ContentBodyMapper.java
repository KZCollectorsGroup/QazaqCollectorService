package kz.nurgalym.adminservice.mapper;

import kz.nurgalym.adminservice.dto.ContentBodyDto;
import kz.nurgalym.adminservice.model.ContentBody;
import org.mapstruct.*;

import java.util.Date;
import java.util.Objects;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface ContentBodyMapper {

    @Mapping(target = "ru", ignore = true)
    @Mapping(target = "kz", ignore = true)
    @Mapping(target = "content", ignore = true)
    ContentBody toDomain(ContentBodyDto contentBodyDto);

    ContentBodyDto toDto(ContentBody contentBody);

    @AfterMapping
    default void updateDates(@MappingTarget ContentBody contentBody) {
        if (Objects.isNull(contentBody.getId()) || contentBody.getId() == 0) {
            contentBody.setCreatedDate(new Date());
            contentBody.setUpdatedDate(new Date());
        } else {
            contentBody.setUpdatedDate(new Date());
        }
    }
}
