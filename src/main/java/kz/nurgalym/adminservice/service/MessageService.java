package kz.nurgalym.adminservice.service;

import kz.nurgalym.adminservice.dto.MessageDto;

import java.util.List;

public interface MessageService {
    List<MessageDto> findAllByAppealId(Long appealId);

    MessageDto findById(Long id);

    MessageDto save(MessageDto messageDto);

    void deleteById(Long id);

}