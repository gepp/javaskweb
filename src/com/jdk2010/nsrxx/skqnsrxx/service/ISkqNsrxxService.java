package com.jdk2010.nsrxx.skqnsrxx.service;

import com.jdk2010.base.service.IBaseService;
import com.jdk2010.nsrxx.skqnsrxx.model.SkqNsrxx;

public interface ISkqNsrxxService extends IBaseService {
    public SkqNsrxx getNsrxxByNsrwjbm(String nsrwjbm);
    
    public String getNsrwjbmByNsrsbh(String nsrsbh);
}
