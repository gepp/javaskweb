package com.jdk2010.jqxx.skqjqxx.service;

import java.util.List;

import com.jdk2010.base.service.IBaseService;
import com.jdk2010.jqxx.skqjqxx.model.SkqJqxx;

public interface ISkqJqxxService extends IBaseService {
    
	public List<SkqJqxx> getJqxxListByNsrwjbm(String nsrwjbm);

	public SkqJqxx getJqxxByJqbh(String jqbh);
	
	public void deleteJqszsmByJqbh(String jqbh);
	
	public boolean isExistsSKKH(String skkh);
	
	public boolean isExistsYHKH(String yhkh);
	
	public boolean isExistsJQBH(String jqbh);
	
}
