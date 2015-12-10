package com.jdk2010.sbsj.skqsbsjmx.model;
import java.util.Date;
import com.jdk2010.framework.dal.model.Model;
import com.jdk2010.framework.dal.parse.annotation.TableField;

public class SkqSbsjmx extends Model<SkqSbsjmx> {
        	/* id */
    	private Integer id;
        	/* 申报数据ID */
    	private Integer parentid;
        	/* 税目编码 */
    	private String smbm;
        	/* 金额 */
    	private Double je;
        	/* 开票类型 */
    	private Integer kplx;
             	 
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
		public Double getJe() {
			return je;
		}
		public void setJe(Double je) {
			this.je = je;
		}
        	 
  		@TableField
		public Integer getKplx() {
			return kplx;
		}
		public void setKplx(Integer kplx) {
			this.kplx = kplx;
		}
    }