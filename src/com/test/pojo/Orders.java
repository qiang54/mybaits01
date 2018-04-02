package com.test.pojo;

import java.util.Date;
import java.util.List;

public class Orders {
    private Integer oid;

    private Integer user_id;

    private String number;


    private String note;

   private User user;
   

    public User getUser() {
	return user;
}

public void setUser(User user) {
	this.user = user;
}

	public Integer getOid() {
		return oid;
	}

	public void setOid(Integer oid) {
		this.oid = oid;
	}

	public Integer getUser_id() {
		return user_id;
	}

	public void setUser_id(Integer user_id) {
		this.user_id = user_id;
	}

	public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number == null ? null : number.trim();
    }


    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note == null ? null : note.trim();
    }
}