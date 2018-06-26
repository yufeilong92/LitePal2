package com.xuechuan.refiterxjava.mvp;

import com.xuechuan.refiterxjava.db.Students;

/**
 * @version V 1.0 xxxxxxxx
 * @Title: RefiteRxjava
 * @Package com.xuechuan.refiterxjava.mvp
 * @Description: todo
 * @author: L-BackPacker
 * @date: 2018/6/26 14:57
 * @verdescript 版本号 修改时间  修改人 修改的概要说明
 * @Copyright: 2018
 */
public interface RequestRestusView {
    public void Success(Students com);
    public void Error(Students msg);

}
