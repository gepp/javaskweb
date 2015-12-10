package com.jdk2010.nsrxx.skqnsrszsm.model;
import java.util.Date;
import com.jdk2010.framework.dal.model.Model;
import com.jdk2010.framework.dal.parse.annotation.TableField;

public class SkqNsrszsm extends Model<SkqNsrszsm> {
        	/* id */
    	private Integer id;
        	/* 纳税人微机编码 */
    	private String nsrwjbm;
        	/* 税种编码 */
    	private String szbm;
        	/* 税种编码 */
    	private String smbm;
        	/* 税种编码 */
    	private String smmc;
        	/* 税种编码 */
    	private String smjc;
        	/* 税率 */
    	private Double sl;
        	/* 状态 */
    	private Integer status;
             	 
  		@TableField
		public Integer getId() {
			return id;
		}
		public void setId(Integer id) {
			this.id = id;
		}
        	 
  		@TableField
		public String getNsrwjbm() {
			return nsrwjbm;
		}
		public void setNsrwjbm(String nsrwjbm) {
			this.nsrwjbm = nsrwjbm;
		}
        	 
  		@TableField
		public String getSzbm() {
			return szbm;
		}
		public void setSzbm(String szbm) {
			this.szbm = szbm;
		}
        	 
  		@TableField
		public String getSmbm() {
			return smbm;
		}
		public void setSmbm(String smbm) {
			this.smbm = smbm;
		}
        	 
  		@TableField
		public String getSmmc() {
			return smmc;
		}
		public void setSmmc(String smmc) {
			this.smmc = smmc;
		}
        	 
  		@TableField
		public String getSmjc() {
			return smjc;
		}
		public void setSmjc(String smjc) {
			this.smjc = smjc;
		}
        	 
  		@TableField
		public Double getSl() {
			return sl;
		}
		public void setSl(Double sl) {
			this.sl = sl;
		}
        	 
  		@TableField
		public Integer getStatus() {
			return status;
		}
		public void setStatus(Integer status) {
			this.status = status;
		}
    }