package com.kimtian.dao;

import com.kimtian.bean.Message;
import com.kimtian.db.DBAcess;
import org.apache.ibatis.session.SqlSession;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * 对message表操作的数据层
 *
 * @author kimtian
 **/
public class MessageDao {

//    public List<Message> searchList(String command, String description) {
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
        SqlSession sqlSession = null;
        try {
            sqlSession = dbAcess.getSqlSession();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (sqlSession != null) {
                sqlSession.close();
            }
        }
        List list = new ArrayList();
        Message message = new Message();
        message.setId(1L);
        message.setCommand("111");
        message.setContent("2222");
        message.setDescription("3333");
        list.add(message);
        return list;
    }

    public static void main(String[] args) {
        MessageDao messageDao = new MessageDao();
        List<Message> aaa = messageDao.searchMessageList("", "");
        for (Message m : aaa) {
            System.out.println(m.getId());
        }
    }
}
