/**
 * @Description: java类作用描述
 * @Author: weixia
 * @CreateDate: 2019/8/12$ 17:23$
 * @UpdateUser: yc
 * @UpdateDate: 2019/8/12$ 17:23$
 * @UpdateRemark: 修改内容
 * @Version: 1.0
 */
package com.zlt.util;

import com.zlt.entity.Customer;
import com.zlt.entity.PageBean;

import javax.servlet.http.HttpServletRequest;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CustomerDao {
    private DBDao db=new DBDao();

    public PageBean<Customer> find(int pageNum,int PageSize){
        List<Customer> list=new ArrayList<>();
        String sql="select count(tel) from relationuser";
        ResultSet re=db.select(sql);
        int totalRecord=0;
        while(true){
            try {
                if (!re.next()) break;
                else
                    totalRecord=re.getInt(1);
            } catch (SQLException e) {
                e.printStackTrace();
            }

        }
        PageBean<Customer> pagebean=new PageBean<>(pageNum,PageSize,totalRecord);
        sql="select * from relationuser limit "+pagebean.getStartIndex()+","+PageSize;
        re=db.select(sql);
        while(true){
            try {
                if (!re.next()) break;
                else{
                    Customer cs=new Customer();
                    cs.setName(re.getString(1));
                    cs.setGender(re.getString(2));
                    cs.setTel(re.getString(3));
                    cs.setEamil(re.getString(4));
                    cs.setDescription(re.getString(5));
                    list.add(cs);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        pagebean.setList(list);
        return pagebean;
    }

    public PageBean<Customer> search(int pageNum, int pageSize, HttpServletRequest re){
        List<Customer> list=new ArrayList<>();
        String sql="select count(*) from relationuser where";
        if(re.getParameter("username")!=""&&re.getParameter("username")!=null)
            sql+=" username like '%"+re.getParameter("username")+"%' and";
        if(re.getParameter("cgender")!=""&&re.getParameter("cgender")!=null)
            sql+=" true and gender='"+re.getParameter("cgender")+"' and";
        if(re.getParameter("tel")!=""&&re.getParameter("tel")!=null)
            sql+=" true and tel like '%"+re.getParameter("tel")+"%' and";
        if(re.getParameter("email")!=""&&re.getParameter("email")!=null)
            sql+=" true and email like '%"+re.getParameter("email")+"%' and";
        PageBean<Customer> pagebean=new PageBean<>();
        sql+=" true";
        pagebean.setPageNum(pageNum);
        pagebean.setPageSize(pageSize);
        ResultSet res=db.select(sql);
        while(true){
            try {
                if (!res.next()) break;
                else
                    pagebean.setTotalRecord(res.getInt(1));
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        sql=sql.replace("count(*)","*");
        sql+=" limit "+pagebean.getStartIndex()+","+pageSize;
        res=db.select(sql);
        while(true){
            try {
                if (!res.next()) break;
                else{
                    Customer cs=new Customer();
                    cs.setName(res.getString(1));
                    cs.setGender(res.getString(2));
                    cs.setTel(res.getString(3));
                    cs.setEamil(res.getString(4));
                    cs.setDescription(res.getString(5));
                    list.add(cs);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        pagebean.setList(list);
        return pagebean;
    }

    public int edit(HttpServletRequest request){
        String sql="update relationuser set username='"+request.getParameter("username")+"',gender='"+
                request.getParameter("gender")+"',tel='"+
                request.getParameter("tel")+"',email='"+
                request.getParameter("email")+"',des='"+
                request.getParameter("des")+"' where tel='"+request.getParameter("oritel")+"'";
        return db.update(sql);
    }
}
