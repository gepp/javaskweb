package com.jdk2010.invoice.skqfpj.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.jdk2010.base.service.BaseServiceImpl;
import com.jdk2010.framework.dal.client.DalClient;
import com.jdk2010.framework.util.DateUtil;
import com.jdk2010.invoice.skqfpj.model.SkqFpj;
import com.jdk2010.invoice.skqfpj.service.ISkqFpjService;
import com.jdk2010.invoice.skqfpjmx.model.SkqFpjmx;

@Service("skqFpjService")
public class SkqFpjServiceImpl extends BaseServiceImpl implements ISkqFpjService {
    @Resource
    DalClient dalClient;

    @Override
    public List<SkqFpjmx> selectFpxf(String nsrwjbm) {
        String sql = "select * from SKQ_FPJMX where NSRWJBM='" + nsrwjbm + "' and FPXFZT=0";
        List<SkqFpjmx> fpjmxList = dalClient.queryForObjectList(sql, SkqFpjmx.class);
        return fpjmxList;
    }

    @Override
    public void saveFpj(SkqFpj fpj) {
        dalClient.save(fpj);
        ArrayList fpjList = new ArrayList();
        fpjList.add(fpj);
      ArrayList alFpjmx = this.splitFp(fpjList);
      Iterator it1 = alFpjmx.iterator();
      while (it1.hasNext()) {
          HashMap hmFpjmx = (HashMap) it1.next();
          String sql2 = "insert into SKQ_FPJMX(FPBM,FPDM,FPQSH,FPJZH,FPDW,NSRWJBM,FPLGRQ,JQBH,FPXFZT,FPLGZT,MXSCZT) values('"
                  + (String) hmFpjmx.get("fpbm")
                  + "','"
                  + (String) hmFpjmx.get("fpdm")
                  + "',"
                  + (Integer) hmFpjmx.get("fpqsh")
                  + ","
                  + (Integer) hmFpjmx.get("fpjzh")
                  + ","
                  + (Integer) hmFpjmx.get("fpdw")
                  + ",'"
                  + (String) hmFpjmx.get("nsrwjbm")
                  + "','"
                  +hmFpjmx.get("fplgrq")
                  + "','"
                  + (String) hmFpjmx.get("jqbh") + "',0,1,0)";
          dalClient.update(sql2);
      }
    }

    private ArrayList splitFp(ArrayList hqfp) {
        ArrayList split = new ArrayList();
        Iterator it = hqfp.iterator();
        while (it.hasNext()) {
            SkqFpj old = (SkqFpj) it.next();
            int sl = (Integer) old.getFpdw();
            HashMap newhm = new HashMap();
            if (sl == 1) {
                int start =old.getFpqsh();
                int end = old.getFpjzh();
                int fpsl = end - start + 1;
                int fpzs = fpsl / sl;
                newhm.put("nsrwjbm",old.getNsrwjbm());
                newhm.put("jqbh","");
                newhm.put("fpbm", old.getFpbm());
                newhm.put("fpdm", old.getFpdm());
                newhm.put("fpdw", 1);
                newhm.put("fpqsh", start);
                newhm.put("fpjzh", start + fpzs - 1);
                newhm.put("fplgrq",DateUtil.getNowTime());
                split.add(newhm);
            } else {
                int start =old.getFpqsh();
                int end = old.getFpjzh();
                int fpsl = end - start + 1;
                int fpzs = fpsl / sl;

                for (int i = 0; i < sl; i++) {
                    newhm = new HashMap();
                    newhm.put("nsrwjbm",old.getNsrwjbm());
                    newhm.put("jqbh","");
                    newhm.put("fpbm", old.getFpbm());
                    newhm.put("fpdm", old.getFpdm());
                    newhm.put("fpdw", 1);
                    newhm.put("fpqsh", start);
                    newhm.put("fpjzh", start + fpzs - 1);
                    newhm.put("fplgrq",DateUtil.getNowTime());

                    split.add(newhm);
                    start = start + fpzs;
                }
            }

        }
        return split;
    }

}
