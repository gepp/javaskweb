package com.jdk2010.sbsj.skqjsgz.model;
import java.util.Date;
import com.jdk2010.framework.dal.model.Model;
import com.jdk2010.framework.dal.parse.annotation.TableField;

public class SkqJsgz extends Model<SkqJsgz> {
        	/* id */
    	private Integer id;
        	/* 税务机关编码 */
    	private String swjgbm;
        	/* 税目编码 */
    	private String smbm;
        	/* 税目简称 */
    	private String smjc;
        	/* 特征标示 */
    	private Integer tzbs;
        	/* 计税规则 */
    	private String jsgz;
        	/* 启用标示 */
    	private Integer qybj;
             	 
  		@TableField
		public Integer getId() {
			return id;
		}
		public void setId(Integer id) {
			this.id = id;
		}
        	 
  		@TableField
		public String getSwjgbm() {
			return swjgbm;
		}
		public void setSwjgbm(String swjgbm) {
			this.swjgbm = swjgbm;
		}
        	 
  		@TableField
		public String getSmbm() {
			return smbm;
		}
		public void setSmbm(String smbm) {
			this.smbm = smbm;
		}
        	 
  		@TableField
		public String getSmjc() {
			return smjc;
		}
		public void setSmjc(String smjc) {
			this.smjc = smjc;
		}
        	 
  		@TableField
		public Integer getTzbs() {
			return tzbs;
		}
		public void setTzbs(Integer tzbs) {
			this.tzbs = tzbs;
		}
        	 
  		@TableField
		public String getJsgz() {
			return jsgz;
		}
		public void setJsgz(String jsgz) {
			this.jsgz = jsgz;
		}
        	 
  		@TableField
		public Integer getQybj() {
			return qybj;
		}
		public void setQybj(Integer qybj) {
			this.qybj = qybj;
		}
    }