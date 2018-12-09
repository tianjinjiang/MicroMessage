package com.kimtian.service.impl;

import com.kimtian.bean.Message;
import com.kimtian.dao.MessageDao;
import com.kimtian.service.ListService;

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

    public static void main(String[] args) {
        MessageDao messageDao = new MessageDao();
        List<Message> messageList = messageDao.searchMessageList("", "乐");
        for (Message message : messageList) {
            System.out.println(message.getId() + "," + message.getCommand());
        }
    }
}
