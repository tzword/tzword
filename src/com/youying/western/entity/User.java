package com.youying.western.entity;

import java.util.Date;


public class User  implements java.io.Serializable {

	private static final long serialVersionUID = 1L;

     private Integer id;
     private String name;
     private String fullname;
     private String mobile;
     private String password;
     private Integer sex;
     private Date createDt;
     private Date lastDt;
     private Integer state;


    public Integer getId() {
        return this.id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }
    
    public void setName(String name) {
        this.name = name;
    }

    public String getFullname() {
        return this.fullname;
    }
    
    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getMobile() {
        return this.mobile;
    }
    
    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getPassword() {
        return this.password;
    }
    
    public void setPassword(String password) {
        this.password = password;
    }


    public Date getCreateDt() {
        return this.createDt;
    }
    
    public void setCreateDt(Date createDt) {
        this.createDt = createDt;
    }

    public Date getLastDt() {
        return this.lastDt;
    }
    
    public void setLastDt(Date lastDt) {
        this.lastDt = lastDt;
    }

	public Integer getSex() {
		return sex;
	}

	public void setSex(Integer sex) {
		this.sex = sex;
	}

	public Integer getState() {
		return state;
	}

	public void setState(Integer state) {
		this.state = state;
	}

}