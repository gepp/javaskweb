package com.jdk2010.sbsj.skqhzsjmx.model;
import java.util.Date;
import com.jdk2010.framework.dal.model.Model;
import com.jdk2010.framework.dal.parse.annotation.TableField;

public class SkqHzsjmx extends Model<SkqHzsjmx> {
        	/* id */
    	private Integer id;
        	/* 申报汇总ID */
    	private Integer parentid;
        	/* 税目编码 */
    	private String smbm;
        	/* 开票金额 */
    	private Double kpje;
        	/* 抵扣金额 */
    	private Double dkje;
        	/* 月核定营业额 */
    	private Double yhdyye;
        	/* 标示 */
    	private Integer flag;
        	/* 申报金额 */
    	private Double sbje;
             	 
  		@TableField
		public Integer getId() {
			return id;
		}
		public void setId(Integer id) {
			this.id = id;
		}
        	 
  		@TableField
		public Integer getParentid() {
			return parentid;
		}
		public void setParentid(Integer parentid) {
			this.parentid = parentid;
		}
        	 
  		@TableField
		public String getSmbm() {
			return smbm;
		}
		public void setSmbm(String smbm) {
			this.smbm = smbm;
		}
        	 
  		@TableField
		public Double getKpje() {
			return kpje;
		}
		public void setKpje(Double kpje) {
			this.kpje = kpje;
		}
        	 
  		@TableField
		public Double getDkje() {
			return dkje;
		}
		public void setDkje(Double dkje) {
			this.dkje = dkje;
		}
        	 
  		@TableField
		public Double getYhdyye() {
			return yhdyye;
		}
		public void setYhdyye(Double yhdyye) {
			this.yhdyye = yhdyye;
		}
        	 
  		@TableField
		public Integer getFlag() {
			return flag;
		}
		public void setFlag(Integer flag) {
			this.flag = flag;
		}
        	 
  		@TableField
		public Double getSbje() {
			return sbje;
		}
		public void setSbje(Double sbje) {
			this.sbje = sbje;
		}
    }