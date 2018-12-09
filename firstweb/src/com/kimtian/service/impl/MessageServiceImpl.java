package com.kimtian.service.impl;

import com.kimtian.bean.Message;
import com.kimtian.common.Constant;
import com.kimtian.dao.MessageDao;
import com.kimtian.service.MessageService;

import java.util.List;

/**
 * 这是一个消息回复服务类
 *
 * @author kimtian
 */

public class MessageServiceImpl implements MessageService {
    @Override
    public String returnMessage(String command) {
        MessageDao messageDao = new MessageDao();
        if (Constant.HELP_COMMAND.equals(command)) {
            List<Message> messageList = messageDao.searchMessageList("", "");
            StringBuffer stringBuffer = new StringBuffer();
            for (int i = 0; i < messageList.size(); i++) {
                if (i != 0) {
                    stringBuffer.append("<br/>");
                }
                stringBuffer.append("回复[" + messageList.get(i).getCommand() + "],可以" + messageList.get(i).getDescription() + "。");
            }
            return stringBuffer.toString();
        } else {
            List<Message> messageList = messageDao.searchMessageList(command, "");
            if (messageList != null && messageList.size() > 0) {
                return messageList.get(0).getContent();
            }
            return Constant.RETURN_MESSGE;
        }
    }
}
