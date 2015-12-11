package com.jdk2010.jqxx.skqjqszsm.service;

import java.util.List;

import com.jdk2010.base.service.IBaseService;
import com.jdk2010.jqxx.skqjqszsm.model.SkqJqszsm;

public interface ISkqJqszsmService extends IBaseService {

    public List<SkqJqszsm> getJqszsmListByJqbh(String nsrwjbm);
}
