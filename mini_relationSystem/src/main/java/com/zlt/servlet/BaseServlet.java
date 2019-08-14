package com.zlt.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;


public abstract class BaseServlet extends HttpServlet {
    public static String FORWARD;
    public static String REDIRECT;      //定义变量标识响应类型
    public static String TIP;

    public void init(){
        FORWARD="f:";
        REDIRECT="r:"+getServletContext().getContextPath();//变量初始化
        TIP="t:";
    }

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        String methodname=request.getParameter("Method");
        Class clazz=this.getClass();                //反射获取控制器Class类对象
        if(methodname==null){
            return ;
        }
        try {
            //获取指定方法，通过方法名及参数确定指定方法
            Method method=clazz.getMethod(methodname,HttpServletRequest.class,HttpServletResponse.class);
            //方法执行结果，带有响应类型前缀
            String result= (String) method.invoke(this,request,response);
            if(result==null)
                return;
            else if("t:".equals(result.substring(0,2)))
                if("1".equals(result.substring(2)))
                    response.getWriter().print("<script>history.back(-1);</script>");
                else
                    response.getWriter().print("<script>alert('操作失败');history.back(-1);</script>");
            if("r:".equals(result.substring(0,2)))
                response.sendRedirect(result.substring(2));
            else if("f:".equals(result.substring(0,2)))
                request.getRequestDispatcher(result.substring(2)).forward(request,response);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }

    }
}
