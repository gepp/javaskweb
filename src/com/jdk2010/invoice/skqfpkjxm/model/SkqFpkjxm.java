package com.jdk2010.invoice.skqfpkjxm.model;
import java.util.Date;
import com.jdk2010.framework.dal.model.Model;
import com.jdk2010.framework.dal.parse.annotation.TableField;

public class SkqFpkjxm extends Model<SkqFpkjxm> {
        	/* ID */
    	private Integer id;
        	/* 发票开具ID */
    	private Integer parentid;
        	/* 项目名称 */
    	private String xmmc;
        	/* 小数位数 */
    	private Integer xsws;
        	/* 数量 */
    	private Double sl;
        	/* 单价 */
    	private Double dj;
        	/* 金额 */
    	private Double je;
        	/* 税目编码 */
    	private String smbm;
        	/* 计税项目 */
    	private Integer jsxm;
             	 
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
		public Integer getXsws() {
			return xsws;
		}
		public void setXsws(Integer xsws) {
			this.xsws = xsws;
		}
        	 
  		@TableField
		public Double getSl() {
			return sl;
		}
		public void setSl(Double sl) {
			this.sl = sl;
		}
        	 
  		@TableField
		public Double getDj() {
			return dj;
		}
		public void setDj(Double dj) {
			this.dj = dj;
		}
        	 
  		@TableField
		public Double getJe() {
			return je;
		}
		public void setJe(Double je) {
			this.je = je;
		}
        	 
  		@TableField
		public String getSmbm() {
			return smbm;
		}
		public void setSmbm(String smbm) {
			this.smbm = smbm;
		}
        	 
  		@TableField
		public Integer getJsxm() {
			return jsxm;
		}
		public void setJsxm(Integer jsxm) {
			this.jsxm = jsxm;
		}
    }