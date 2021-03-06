package com.kimtian.test;

import com.kimtian.bean.Message;
import com.kimtian.common.Constant;
import com.kimtian.service.impl.ListServiceImpl;
import com.kimtian.service.impl.MessageServiceImpl;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class MessageTest {
    ListServiceImpl listService;
    MessageServiceImpl messageService;

    @Test
    public void testQueryMessageList() {
        String command = "娱乐";
        String description = "乐";
        listService = new ListServiceImpl();
        //不传参数的查询
        List<Message> result = listService.queryMessageList("", "");
        //传了command参数的查询
        List<Message> result1 = listService.queryMessageList(command, "");
        //传了description参数的模糊查询
        List<Message> result2 = listService.queryMessageList("", description);
        //两个参数的查询
        List<Message> result3 = listService.queryMessageList(command, description);
        System.out.println(result.contains(result));
        System.out.println(result2.contains(result1));
        System.out.println(result2.contains(result3));
    }

    @Test
    public void testDeleteById() {
        Long id = 1L;
        listService = new ListServiceImpl();
        //不传参数的查询
        List<Message> result = listService.queryMessageList("", "");
        //删除
        listService.deleteById(id);
        List<Message> result2 = listService.queryMessageList("", "");
        Assert.assertTrue(result.size() - 1 <= result2.size());
    }

    @Test
    public void testDeleteBatch() {
        Message message = new Message();
        message.setId(6L);
        Message message1 = new Message();
        message1.setId(7L);
        Message message2 = new Message();
        message2.setId(11L);
        Message message3 = new Message();
        message3.setId(12L);
        List<Message> messageList = new ArrayList<>();
        messageList.add(message);
        messageList.add(message1);
        messageList.add(message2);
        messageList.add(message3);
        listService = new ListServiceImpl();
        //不传参数的查询
        List<Message> result = listService.queryMessageList("", "");
        //最开始列表的数量
        int beginListSize = result.size();
        //要删除的列表的数量
        int deleteListSize = messageList.size();
        //批量删除
        listService.deleteBatch(messageList);
        List<Message> result2 = listService.queryMessageList("", "");
        //删除后的列表的数量
        int lastListSize = result2.size();
        Assert.assertTrue(beginListSize - deleteListSize <= lastListSize);
    }

    @Test
    public void testReturnMessage() {
        String command = "娱乐";
        messageService = new MessageServiceImpl();
        String messgeContent = messageService.returnMessage(command);
        Assert.assertNotNull(messgeContent, "");
        String messgeContent1 = messageService.returnMessage(Constant.HELP_COMMAND);
        Assert.assertTrue(messgeContent1 != null && !messgeContent.equals(""));
        String messgeContent2 = messageService.returnMessage(" gggghajhfds ");
        Assert.assertEquals(messgeContent2, Constant.RETURN_MESSGE);
    }

    @Test
    public void testInserMessage() {
        ListServiceImpl listService = new ListServiceImpl();
        Message message = new Message();
        message.setCommand("新增");
        message.setDescription("这是一个新增");
        message.setContent("新增的内容");
        Message message1 = new Message();
        message1.setCommand("新增test");
        message1.setDescription("这是一个新增test");
        message1.setContent("新增的内容test");
        List<Message> messageList = new ArrayList<>();
        messageList.add(message);
        messageList.add(message1);
        listService.addMessage(messageList);
    }

    @Test
    public void testUpdateMessage() {
        ListServiceImpl listService = new ListServiceImpl();
        Message message = new Message();
        message.setId(13L);
        message.setCommand("新增");
        message.setDescription("这是一个新增");
        message.setContent("新增的内容");
        listService.updateMessage(message);
    }
}
