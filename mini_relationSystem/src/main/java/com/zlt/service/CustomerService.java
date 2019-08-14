/**
 * @Description: java类作用描述
 * @Author: weixia
 * @CreateDate: 2019/8/12$ 17:46$
 * @UpdateUser: yc
 * @UpdateDate: 2019/8/12$ 17:46$
 * @UpdateRemark: 修改内容
 * @Version: 1.0
 */
package com.zlt.service;

import com.zlt.entity.Customer;
import com.zlt.entity.PageBean;
import com.zlt.util.CustomerDao;

import javax.servlet.http.HttpServletRequest;

public class CustomerService {
    private CustomerDao cusdao=new CustomerDao();
    public PageBean<Customer> findCustomer(int pageNum,int pageSize){
        return cusdao.find(pageNum,pageSize);
    }

    public PageBean<Customer> searchCustomer(int pageNum, int pageSize, HttpServletRequest request){
        return cusdao.search(pageNum,pageSize,request);
    }

    public int editCustomer(HttpServletRequest request){
        return cusdao.edit(request);
    }
}
