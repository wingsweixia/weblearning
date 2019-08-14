package com.zlt.servlet;

import com.zlt.entity.Customer;
import com.zlt.entity.PageBean;
import com.zlt.service.CustomerService;
import com.zlt.util.DBDao;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/customer")
public class CustomerServlet extends BaseServlet {
    private  DBDao DB=new DBDao();
    //添加客户
    public String addCustomer(HttpServletRequest request, HttpServletResponse response){
        String name=request.getParameter("username");
        String cgender=request.getParameter("gender");
        String tel=request.getParameter("tel");
        String email=request.getParameter("email");
        String description=request.getParameter("des");
        String sql="insert into relationuser values('"+
                name+"','"+cgender+"','"
                +tel+"','"+email+"','"+
                description+"')";
        int re=DB.insert(sql);
        return TIP+re;
    }

    //查询所有客户信息，结果分页显示
    public String selectCustomer(HttpServletRequest request,HttpServletResponse response){
        CustomerService cs=new CustomerService();
        int pageNum=Integer.parseInt(request.getParameter("pageNum"));
        int pageSize=Integer.parseInt(request.getParameter("pageSize"));
        PageBean<Customer> pagebean=cs.findCustomer(pageNum,pageSize);
        request.setAttribute("pagebean",pagebean);
        return FORWARD+"/showCustomer.jsp";
    }

    //删除指定客户信息
    public String deleteCustomer(HttpServletRequest request,HttpServletResponse response){
        int re=DB.update("delete from relationuser where tel='"+request.getParameter("tel")+"'");
        return TIP+re;
    }

    //查找满足条件的客户信息，查询结果分页显示
    public String find(HttpServletRequest request,HttpServletResponse response){
        CustomerService cs=new CustomerService();
        int pageNum=Integer.parseInt(request.getParameter("pageNum"));
        int pageSize=Integer.parseInt(request.getParameter("pageSize"));
        PageBean<Customer> pagebean=cs.searchCustomer(pageNum,pageSize,request);
        request.setAttribute("pagebean",pagebean);
        return FORWARD+"/showCustomer.jsp";
    }

    //修改客户信息
    public String editCustomer(HttpServletRequest request,HttpServletResponse response){
        CustomerService cs=new CustomerService();
        int re=cs.editCustomer(request);
        return TIP+re;
    }

    //请求指定客户信息，跳转至信息编辑页面
    public String editPrepare(HttpServletRequest request,HttpServletResponse response){
        CustomerService cs=new CustomerService();
        int pageNum=Integer.parseInt(request.getParameter("pageNum"));
        int pageSize=Integer.parseInt(request.getParameter("pageSize"));
        PageBean<Customer> pagebean=cs.searchCustomer(pageNum,pageSize,request);
        request.setAttribute("pagebean",pagebean);
        return FORWARD+"/editCustomer.jsp";
    }
}
