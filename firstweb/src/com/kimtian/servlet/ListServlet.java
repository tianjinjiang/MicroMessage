package com.kimtian.servlet;


import com.kimtian.service.impl.ListServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.*;
import java.io.IOException;

/**
 * 列表页面初始化控制
 *
 * @author kimtian
 **/
public class ListServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //设置页面编码
        req.setCharacterEncoding("UTF-8");
        //接收页面的值
        String command = req.getParameter("command");
        String description = req.getParameter("description");
        System.out.println(command + "，" + description);
        ListServiceImpl listServiceimpl = new ListServiceImpl();
        //向页面传值
        req.setAttribute("command", command);
        req.setAttribute("description", description);
        //查询消息列表并传给页面
        req.setAttribute("messageList", listServiceimpl.queryMessageList(command, description));
        //向页面跳转
        req.getRequestDispatcher("/WEB-INF/jsp/back/list.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req, resp);
    }
}
