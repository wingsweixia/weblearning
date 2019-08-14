/**
 * @Description: java类作用描述
 * @Author: weixia
 * @CreateDate: 2019/8/12$ 11:12$
 * @UpdateUser: yc
 * @UpdateDate: 2019/8/12$ 11:12$
 * @UpdateRemark: 修改内容
 * @Version: 1.0
 */
package com.zlt.entity;

public class Customer {
    private String name;
    private String eamil;
    private String gender;
    private String description;
    private String tel;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEamil() {
        return eamil;
    }

    public void setEamil(String eamil) {
        this.eamil = eamil;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }
}
