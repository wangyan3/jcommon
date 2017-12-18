package com.jades.bus.common.busservice;

/**
 * Created by wangyan on 2017/12/18.
 */

public interface IBusService {
    /**
     * description of business
     * @return
     */
    String getDesc();

    /**
     * enable of business
     * @return
     */
    boolean isEnabled();
}
