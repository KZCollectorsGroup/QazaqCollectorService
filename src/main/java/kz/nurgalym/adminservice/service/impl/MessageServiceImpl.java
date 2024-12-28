package kz.nurgalym.adminservice.service.impl;

import kz.nurgalym.adminservice.dto.MessageDto;
import kz.nurgalym.adminservice.exception.CustomException;
import kz.nurgalym.adminservice.mapper.MessageMapper;
import kz.nurgalym.adminservice.model.Message;
import kz.nurgalym.adminservice.repo.MessageRepository;
import kz.nurgalym.adminservice.service.MessageService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class MessageServiceImpl implements MessageService {
    private final MessageRepository messageRepository;
    private final MessageMapper messageMapper;


    @Override
    public List<MessageDto> findAllByAppealId(Long appealId) {
        return messageRepository.findAllByAppealId(appealId).stream()
                .map(messageMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public MessageDto findById(Long id) {
        Message message = messageRepository.findById(id).orElseThrow(() ->
                new CustomException(String.format("Сообщение с таким ID %s не найден", id), HttpStatus.BAD_REQUEST));

        return messageMapper.toDto(message);
    }

    @Override
    public MessageDto save(MessageDto messageDto) {
        Message message = messageMapper.toDomain(messageDto);
//        brandValidator.validate(brand);
        Message saveMessage = messageRepository.save(message);

        return findById(saveMessage.getId());
    }

    @Override
    public void deleteById(Long id) {
        Message byCode = messageRepository.findById(id).orElseThrow(() ->
                new CustomException(String.format("Сообщение с таким ID %s не найден", id), HttpStatus.BAD_REQUEST));
        messageRepository.delete(byCode);
    }

}