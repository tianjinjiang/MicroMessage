package com.kimtian.service.impl;

import com.kimtian.bean.Message;
import com.kimtian.dao.MessageDao;

import java.util.List;

/**
 * 列表相关的业务功能
 *
 * @author kimtian
 **/
public class ListServiceImpl {
    public List<Message> queryMessageList(String command, String description) {
        MessageDao messageDao = new MessageDao();
        return messageDao.searchList(command, description);
    }
}
