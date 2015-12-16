package com.jdk2010.invoice.skqfpj.service;

import java.util.List;

import com.jdk2010.base.service.IBaseService;
import com.jdk2010.invoice.skqfpj.model.SkqFpj;
import com.jdk2010.invoice.skqfpjmx.model.SkqFpjmx;

public interface ISkqFpjService extends IBaseService {

    public List<SkqFpjmx> selectFpxf(String nsrwjbm);

    public void saveFpj(SkqFpj fpj);
}
