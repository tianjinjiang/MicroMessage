package kimtian.service;

/**
 * 这是一个消息回复服务类
 *
 * @author kimtian
 */
public interface MessageService {
    /**
     * 根据指令回复消息
     *
     * @param command 指令
     * @return String 返回的消息
     **/
    String returnMessage(String command);

}
