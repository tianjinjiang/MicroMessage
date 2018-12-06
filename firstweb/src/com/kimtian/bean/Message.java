package com.kimtian.bean;

/**
 * 消息类
 *
 * @author kimtian
 **/
public class Message {
    /**
     * 主键
     **/
    private Long id;
    /**
     * 指令
     **/
    private String command;
    /**
     * 描述
     **/
    private String description;
    /**
     * 内容
     **/
    private String content;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCommand() {
        return command;
    }

    public void setCommand(String command) {
        this.command = command;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
