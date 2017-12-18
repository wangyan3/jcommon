package com.jades.bus.common.busservice;

/**
 * Created by wangyan on 2017/12/18.
 */

public class BusServiceFactory implements IBusServiceDiscovery{

    private static BusServiceFactory sBusServiceFactoryInstance;
    private IBusServiceDiscovery mIBusServiceDiscovery;

    public static BusServiceFactory setBusServiceDiscovery(IBusServiceDiscovery iBusServiceDiscovery){
        if(sBusServiceFactoryInstance ==null){
            synchronized (BusServiceFactory.class){
                if (sBusServiceFactoryInstance == null) {
                    if(iBusServiceDiscovery==null){
                        iBusServiceDiscovery = new BusServiceDiscovery();
                    }

                    sBusServiceFactoryInstance = new BusServiceFactory(iBusServiceDiscovery);

                }
            }
        }

        return  sBusServiceFactoryInstance;
    }
    public static BusServiceFactory getInstance(){
        if(sBusServiceFactoryInstance ==null){
            synchronized (BusServiceFactory.class){
                if(sBusServiceFactoryInstance==null){
                    sBusServiceFactoryInstance = new BusServiceFactory(new BusServiceDiscovery());
                }
            }
        }
        return sBusServiceFactoryInstance;
    }
    public BusServiceFactory(IBusServiceDiscovery IBusServiceDiscovery) {
        mIBusServiceDiscovery = IBusServiceDiscovery;
    }

    @Override
    public <TBusService extends IBusService, TBusServiceImpl extends TBusService> void register(Class<TBusService> busServiceClass, Class<TBusServiceImpl> busServiceImplClass) {
        mIBusServiceDiscovery.register(busServiceClass,busServiceImplClass);
    }

    @Override
    public <TBusService extends IBusService> void unRegister(Class<TBusService> busServiceClass) {
        mIBusServiceDiscovery.unRegister(busServiceClass);
    }

    @Override
    public <TBusService extends IBusService> TBusService getBusService(Class<TBusService> busServiceClass) {
        return mIBusServiceDiscovery.getBusService(busServiceClass);
    }

    @Override
    public <TBuService extends IBusService> void deleteBusService(Class<TBuService> buServiceClass) {
        mIBusServiceDiscovery.deleteBusService(buServiceClass);
    }

    @Override
    public void clearAll() {
        mIBusServiceDiscovery.clearAll();
    }
}
