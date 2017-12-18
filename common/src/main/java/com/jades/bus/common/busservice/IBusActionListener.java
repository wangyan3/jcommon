package com.jades.bus.common.busservice;

import java.io.Serializable;

/**
 * Created by wangyan on 2017/12/18.
 */

public interface IBusActionListener<TParam> extends Serializable{
    void onFinish(boolean isSuccess, String desc, TParam param);
}
