package com.jdk2010.nsrxx.skqnsrszsm.service;

import java.util.List;

import com.jdk2010.base.service.IBaseService;
import com.jdk2010.nsrxx.skqnsrszsm.model.SkqNsrszsm;

public interface ISkqNsrszsmService extends IBaseService {
    public List<SkqNsrszsm> getNsrszsmList(String nsrwjbm);

    public void deleteNsrszsmByNsrwjbm(String nsrwjbm);
}
