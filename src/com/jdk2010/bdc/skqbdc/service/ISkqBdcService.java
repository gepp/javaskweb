package com.jdk2010.bdc.skqbdc.service; 
import com.jdk2010.base.service.IBaseService;
import com.jdk2010.bdc.skqbdc.model.SkqBdc;
public interface ISkqBdcService  extends IBaseService{
	public SkqBdc loadBdc(String id);
}
