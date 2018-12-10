package com.kimtian.service.impl;

import com.kimtian.bean.Message;
import com.kimtian.dao.MessageDao;
import com.kimtian.service.ListService;

import java.util.ArrayList;
import java.util.List;

/**
 * 列表相关的业务功能
 *
 * @author kimtian
 **/
public class ListServiceImpl implements ListService {
    @Override
    public List<Message> queryMessageList(String command, String description) {
        MessageDao messageDao = new MessageDao();
        return messageDao.searchMessageList(command, description);
    }

    @Override
    public void deleteById(Long id) {
        MessageDao messageDao = new MessageDao();
        messageDao.deleteOne(id);
    }

    @Override
    public void deleteBatch(List<Message> messageList) {
        MessageDao messageDao = new MessageDao();
        List<Long> idList = new ArrayList<>();
        for (Message message : messageList) {
            idList.add(message.getId());
        }
        messageDao.deleteBatch(idList);
    }

    @Override
    public void addMessage(List<Message> messageList) {
        MessageDao messageDao = new MessageDao();
        messageDao.insertMessage(messageList);
    }

    @Override
    public void updateMessage(Message message) {
        MessageDao messageDao = new MessageDao();
        messageDao.updateMessage(message);
    }
}
