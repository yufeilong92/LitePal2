package com.xuechuan.refiterxjava.mvp.presenter;

import com.xuechuan.refiterxjava.db.Students;
import com.xuechuan.refiterxjava.mvp.RequestRestusView;
import com.xuechuan.refiterxjava.mvp.contract.loginContract;

/**
 * @version V 1.0 xxxxxxxx
 * @Title: RefiteRxjava
 * @Package com.xuechuan.refiterxjava.mvp.presenter
 * @Description: todo
 * @author: L-BackPacker
 * @date: 2018/6/26 11:48
 * @verdescript 版本号 修改时间  修改人 修改的概要说明
 * @Copyright: 2018
 */
public class loginPresenter implements loginContract.Presenter {
    loginContract.Model model;
    loginContract.View view;

    @Override
    public void initModelView(loginContract.Model model, loginContract.View view) {
        this.model = model;
        this.view = view;
    }

    @Override
    public void login(String name, String paw) {
        model.login(name, paw, new RequestRestusView() {
            @Override
            public void Success(Students com) {
                view.Success(com);
            }

            @Override
            public void Error(Students msg) {
                view.Error(msg);
            }
        });
    }
}
