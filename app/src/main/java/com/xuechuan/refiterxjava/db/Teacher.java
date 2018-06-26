package com.xuechuan.refiterxjava.db;

import org.litepal.crud.LitePalSupport;

/**
 * @version V 1.0 xxxxxxxx
 * @Title: RefiteRxjava
 * @Package com.xuechuan.refiterxjava.db
 * @Description: todo
 * @author: L-BackPacker
 * @date: 2018/6/26 17:58
 * @verdescript 版本号 修改时间  修改人 修改的概要说明
 * @Copyright: 2018
 */
public class Teacher extends LitePalSupport {
    private String name;
    private String age;
    private String paw;
    private int id;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getPaw() {
        return paw;
    }

    public void setPaw(String paw) {
        this.paw = paw;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
