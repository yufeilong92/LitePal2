package com.xuechuan.refiterxjava.mvp.contract;

import com.xuechuan.refiterxjava.db.Students;
import com.xuechuan.refiterxjava.mvp.RequestRestusView;

/**
 * @version V 1.0 xxxxxxxx
 * @Title: RefiteRxjava
 * @Package com.xuechuan.refiterxjava.mvp.contract
 * @Description: todo
 * @author: L-BackPacker
 * @date: 2018/6/26 11:48
 * @verdescript 版本号 修改时间  修改人 修改的概要说明
 * @Copyright: 2018
 */
public interface loginContract {
    interface Model {
        public void login(String name, String paw, RequestRestusView view);
    }

    interface View {
        public void Success(Students com);

        public void Error(Students msg);
    }

    interface Presenter {
        public void initModelView(Model model, View view);

        public void login(String name, String paw);
    }
}
