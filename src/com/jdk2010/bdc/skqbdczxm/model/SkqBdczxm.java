package com.jdk2010.bdc.skqbdczxm.model;
import java.util.Date;
import com.jdk2010.framework.dal.model.Model;
import com.jdk2010.framework.dal.parse.annotation.TableField;

public class SkqBdczxm extends Model<SkqBdczxm> {
        	/* id */
    	private Integer id;
        	/* 主项目ID */
    	private Integer parentid;
        	/* 项目名称 */
    	private String xmmc;
        	/* 税务机关编码 */
    	private String zgswjg;
        	/* 创建者 */
    	private String cjz;
        	/* 创建时间 */
    	private Date cjsj;
        	/* 纳税人微机编码 */
    	private String nsrwjbm;
             	 
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
		public String getXmmc() {
			return xmmc;
		}
		public void setXmmc(String xmmc) {
			this.xmmc = xmmc;
		}
        	 
  		@TableField
		public String getZgswjg() {
			return zgswjg;
		}
		public void setZgswjg(String zgswjg) {
			this.zgswjg = zgswjg;
		}
        	 
  		@TableField
		public String getCjz() {
			return cjz;
		}
		public void setCjz(String cjz) {
			this.cjz = cjz;
		}
        	 
  		@TableField
		public Date getCjsj() {
			return cjsj;
		}
		public void setCjsj(Date cjsj) {
			this.cjsj = cjsj;
		}
        	 
  		@TableField
		public String getNsrwjbm() {
			return nsrwjbm;
		}
		public void setNsrwjbm(String nsrwjbm) {
			this.nsrwjbm = nsrwjbm;
		}
    }