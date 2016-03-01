package com.jdk2010.jzaz.skqjzaz.service; 
import com.jdk2010.base.service.IBaseService;
public interface ISkqJzazService  extends IBaseService{
	public long getJzazLsh();
	
	public long getJzazFbLsh(String parentid);
	
	public double getJzazKpje(String id);
	
	public double getJzazSyje(String id,String parentid,double zbxmje);
}
