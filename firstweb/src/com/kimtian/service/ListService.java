package kimtian.service;

import com.kimtian.bean.Message;

import java.util.List;

/**
 * 列表服务接口
 *
 * @author kimtian
 **/
public interface ListService {
    /**
     * 查询消息列表
     *
     * @param command     指令
     * @param description 描述
     * @return List<Message> 消息列表
     **/
    List<Message> queryMessageList(String command, String description);

    /**
     * 根据ID删除消息
     *
     * @param id ID编号
     **/
    void deleteById(Long id);
    /**
     * 批量删除消息
     *
     * @param messagesList 消息列表
     **/
    void deleteBatch(List<Message> messagesList);
}
