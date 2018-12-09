package com.kimtian.dao;

import com.kimtian.bean.Message;
import com.kimtian.db.DBAcess;
import org.apache.ibatis.session.SqlSession;

import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * 对message表操作的数据层
 *
 * @author kimtian
 **/
public class MessageDao {

//    public List<Message> searchMessageList(String command, String description) {
//        List<Message> messageList = new ArrayList<>();
//        try {
//            Class.forName("com.mysql.jdbc.Driver");
//            String url = "jdbc:mysql://localhost:3306/kimTest?characterEncoding=utf-8&useSSL=false&autoReconnect=true";
//            String user = "root";
//            String password = "jiang11!";
//            Connection connection = DriverManager.getConnection(url, user, password);
//            StringBuilder sql = new StringBuilder("select ID,COMMAND,DESCRIPTION,CONTENT from message where 1=1");
//            List<String> paramList = new ArrayList<String>();
//            if (command != null && !"".equals(command.trim())) {
//                System.out.println("111111");
//                sql.append(" AND COMMAND = ?");
//                paramList.add(command);
//            }
//            if (description != null && !"".equals(description.trim())) {
//                sql.append(" AND description like '%' ? '%'");
//                paramList.add(description);
//            }
//            PreparedStatement preparedStatement = connection.prepareStatement(sql.toString());
//            for (int i = 0; i < paramList.size(); i++) {
//                preparedStatement.setString(i + 1, paramList.get(i));
//            }
//            ResultSet rs = preparedStatement.executeQuery();
//            while (rs.next()) {
//                Message message = new Message();
//                message.setId(rs.getLong("ID"));
//                message.setCommand(rs.getString("COMMAND"));
//                message.setDescription(rs.getString("DESCRIPTION"));
//                message.setContent(rs.getString("CONTENT"));
//                messageList.add(message);
//            }
//            for (Message message : messageList) {
//                System.out.println(message.getId() + "," + message.getCommand() + "," + message.getContent() + "," + message.getDescription());
//            }
//        } catch (ClassNotFoundException e) {
//            e.printStackTrace();
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        return messageList;
//    }

    /**
     * 根据查询条件查询消息列表
     *
     * @param command     指令
     * @param description 描述
     * @return List<Message> 消息列表
     **/
    public List<Message> searchMessageList(String command, String description) {
        DBAcess dbAcess = new DBAcess();
        List<Message> messageList = new ArrayList<>();
        SqlSession sqlSession = null;
        try {
            Message message = new Message();
            message.setCommand(command);
            message.setDescription(description);
            sqlSession = dbAcess.getSqlSession();
            messageList = sqlSession.selectList("Message.searchMessageList", message);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (sqlSession != null) {
                sqlSession.close();
            }
        }
        return messageList;
    }
}
