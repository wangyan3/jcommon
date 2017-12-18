package com.jades.bus.common.busservice;

/**
 * Created by wangyan on 2017/12/18.
 */

public interface IBusServiceDiscovery {

    /**
     * register business service
     * @param busServiceClass
     *        business interface
     * @param busServiceImplClass
     *        implements of business interface
     * @param <TBusService>
     * @param <TBusServiceImpl>
     */
    <TBusService extends IBusService,TBusServiceImpl extends TBusService> void register(Class<TBusService> busServiceClass, Class<TBusServiceImpl> busServiceImplClass);


    /**
     * unregister business service,if the interface has instance,this action will delete it
     * @param busServiceClass
     * @param <TBusService>
     */
    <TBusService extends IBusService> void unRegister(Class<TBusService> busServiceClass);


    /**
     * get instance of business service's implements
     * @param busServiceClass
     * @param <TBusService>
     * @return
     */
    <TBusService extends IBusService> TBusService getBusService(Class<TBusService> busServiceClass);


    /**
     * delete instance of business service's implements,not unregister it
     * @param buServiceClass
     * @param <TBuService>
     */
    <TBuService extends IBusService> void deleteBusService(Class<TBuService> buServiceClass);

    /**
     * clear all registered instances
     */
    void clearAll();
}
