package com.xuechuan.refiterxjava.mvp.model;

import com.xuechuan.refiterxjava.db.Students;
import com.xuechuan.refiterxjava.mvp.RequestRestusView;
import com.xuechuan.refiterxjava.mvp.contract.loginContract;

import org.litepal.LitePal;
import org.litepal.LitePalApplication;
import org.litepal.LitePalDB;
import org.litepal.crud.DataSupport;
import org.litepal.crud.LitePalSupport;
import org.litepal.crud.async.FindMultiExecutor;

import java.util.List;

import retrofit2.http.GET;

/**
 * @version V 1.0 xxxxxxxx
 * @Title: RefiteRxjava
 * @Package com.xuechuan.refiterxjava.mvp.model
 * @Description: todo
 * @author: L-BackPacker
 * @date: 2018/6/26 11:48
 * @verdescript 版本号 修改时间  修改人 修改的概要说明
 * @Copyright: 2018
 */
public class loginModel implements loginContract.Model {

    @Override
    public void login(String name, String paw, RequestRestusView view) {
        Students duration = LitePal.where("name=" + name + " and paw=" + paw)
                .findFirst(Students.class);
        if (duration == null) {
            view.Error(null);
        } else
            view.Success(duration);


    }
}
