package kimtian.service.impl;

import com.kimtian.bean.Message;
import kimtian.common.Constant;
import kimtian.dao.MessageDao;
import kimtian.service.MessageService;

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
        List<Message> messageList = messageDao.searchMessageList(command, "");
        if (messageList != null && messageList.size() > 0) {
            return messageList.get(0).getContent();
        }
        return Constant.RETURN_MESSGE;
    }
}
