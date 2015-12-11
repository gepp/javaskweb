package com.jdk2010.jqxx.skqjqxx.service; 
import java.util.List;

import com.jdk2010.base.service.IBaseService;
import com.jdk2010.jqxx.skqjqxx.model.SkqJqxx;
public interface ISkqJqxxService  extends IBaseService{
    public List<SkqJqxx> getJqxxListByNsrwjbm(String nsrwjbm);
}
