package com.usa.reto3.service;

import com.usa.reto3.model.Message;
import com.usa.reto3.repository.MessageRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author nancy
 */
@Service
public class MessageService {

    @Autowired
    private MessageRepository metodosCrud;

    public List<Message> getAll() {
        return metodosCrud.getAll();
    }

    public Optional<Message> getMessage(int messageId) {
        return metodosCrud.getMessage(messageId);
    }

    public Message save(Message message) {
        if (message.getIdMessage() == null) {
            return metodosCrud.save(message);
        } else {
            Optional<Message> e = metodosCrud.getMessage(message.getIdMessage());
            if (e.isEmpty()) {
                return metodosCrud.save(message);
            } else {
                return message;
            }
        }
    }

}
