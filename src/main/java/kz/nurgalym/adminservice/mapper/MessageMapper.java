package kz.nurgalym.adminservice.mapper;

import kz.nurgalym.adminservice.dto.MessageDto;
import kz.nurgalym.adminservice.model.Message;
import org.mapstruct.*;

import java.util.Date;
import java.util.Objects;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface MessageMapper {

    @Mapping(target = "appeal", ignore = true)
    Message toDomain(MessageDto messageDto);

    MessageDto toDto(Message message);

    @AfterMapping
    default void updateDates(@MappingTarget Message message) {
        if (Objects.isNull(message.getId()) || message.getId() == 0) {
            message.setCreatedDate(new Date());
            message.setUpdatedDate(new Date());
        } else {
            message.setUpdatedDate(new Date());
        }
    }
}
