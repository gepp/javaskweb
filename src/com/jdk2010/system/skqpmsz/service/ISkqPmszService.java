package com.jdk2010.system.skqpmsz.service; 
import com.jdk2010.base.service.IBaseService;
import com.jdk2010.system.skqpmsz.model.SkqPmsz;
public interface ISkqPmszService  extends IBaseService{
    public SkqPmsz getPmszBySmsy(String smsy);
}
