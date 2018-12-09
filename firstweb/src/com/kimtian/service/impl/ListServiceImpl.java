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

    public static void main(String[] args) {
        ListServiceImpl listService = new ListServiceImpl();
        Message message = new Message();
        message.setId(6L);
        Message message1 = new Message();
        message.setId(7L);
        Message message2 = new Message();
        message.setId(8L);
        Message message3 = new Message();
        message.setId(10L);
        List<Message> messageList = new ArrayList<>();
        messageList.add(message);
        messageList.add(message1);
        messageList.add(message2);
        messageList.add(message3);
        listService.deleteBatch(messageList);
    }
}
