package com.kimtian.service;

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
}
