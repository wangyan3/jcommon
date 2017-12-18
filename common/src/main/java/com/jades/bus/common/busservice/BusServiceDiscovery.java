package com.jades.bus.common.busservice;


import com.jades.bus.common.util.ClassUtil;

import android.util.SparseArray;

/**
 * find business service
 * Created by wangyan on 2017/12/18.
 */

public class BusServiceDiscovery implements IBusServiceDiscovery{

    private SparseArray<Class<IBusService>> mBusServiceClassesSparseArray = new SparseArray<>();//implements IBusService
    private SparseArray<IBusService> mIBusServiceSparseArray = new SparseArray<>();//extends IBusService

    public BusServiceDiscovery() {
    }

    @Override
    public <TBusService extends IBusService, TBusServiceImpl extends TBusService> void register(Class<TBusService> busServiceClass, Class<TBusServiceImpl> busServiceImplClass) {
            Class<TBusService> currentBusServiceClass = (Class<TBusService>) mBusServiceClassesSparseArray.get(busServiceClass.hashCode());
            if(currentBusServiceClass==null){
                mBusServiceClassesSparseArray.put(busServiceClass.hashCode(),(Class<IBusService>)busServiceImplClass);
            }
    }

    @Override
    public <TBusService extends IBusService> void unRegister(Class<TBusService> busServiceClass) {
        mBusServiceClassesSparseArray.remove(busServiceClass.hashCode());
        mIBusServiceSparseArray.remove(busServiceClass.hashCode());
    }

    @Override
    public <TBusService extends IBusService> TBusService getBusService(Class<TBusService> busServiceClass) {
        TBusService busService = (TBusService) mIBusServiceSparseArray.get(busServiceClass.hashCode());

        if(busService == null){
            Class<TBusService> existBusServiceClass = (Class<TBusService>) mBusServiceClassesSparseArray.get(busService.hashCode());
            if(existBusServiceClass!=null){
                busService = ClassUtil.newInstance(existBusServiceClass);

                mIBusServiceSparseArray.put(busServiceClass.hashCode(),busService);
            }
        }

        return busService;

    }

    @Override
    public <TBuService extends IBusService> void deleteBusService(Class<TBuService> buServiceClass) {
        TBuService buService = (TBuService) mIBusServiceSparseArray.get(buServiceClass.hashCode());

        if(buService!=null){
            mIBusServiceSparseArray.delete(buService.hashCode());
        }
    }

    @Override
    public void clearAll() {
        mIBusServiceSparseArray.clear();
    }
}
