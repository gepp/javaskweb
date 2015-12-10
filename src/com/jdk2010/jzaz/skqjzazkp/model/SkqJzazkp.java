package com.jdk2010.jzaz.skqjzazkp.model;
import java.util.Date;
import com.jdk2010.framework.dal.model.Model;
import com.jdk2010.framework.dal.parse.annotation.TableField;

public class SkqJzazkp extends Model<SkqJzazkp> {
        	/* id */
    	private Integer id;
        	/* 项目ID */
    	private Integer parentid;
        	/* 款项性质 */
    	private Integer kxxz;
        	/* 发票代码 */
    	private String fpdm;
        	/* 发票号码 */
    	private Integer fphm;
        	/* 开票类型 */
    	private Integer kplx;
        	/* 开票金额 */
    	private Double hjzje;
        	/* 开票日期 */
    	private Date kprq;
        	/* 上传日期 */
    	private Date scrq;
        	/* JSXM */
    	private Integer jsxm;
        	/* SFDK */
    	private Integer sfdk;
             	 
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
		public Integer getKxxz() {
			return kxxz;
		}
		public void setKxxz(Integer kxxz) {
			this.kxxz = kxxz;
		}
        	 
  		@TableField
		public String getFpdm() {
			return fpdm;
		}
		public void setFpdm(String fpdm) {
			this.fpdm = fpdm;
		}
        	 
  		@TableField
		public Integer getFphm() {
			return fphm;
		}
		public void setFphm(Integer fphm) {
			this.fphm = fphm;
		}
        	 
  		@TableField
		public Integer getKplx() {
			return kplx;
		}
		public void setKplx(Integer kplx) {
			this.kplx = kplx;
		}
        	 
  		@TableField
		public Double getHjzje() {
			return hjzje;
		}
		public void setHjzje(Double hjzje) {
			this.hjzje = hjzje;
		}
        	 
  		@TableField
		public Date getKprq() {
			return kprq;
		}
		public void setKprq(Date kprq) {
			this.kprq = kprq;
		}
        	 
  		@TableField
		public Date getScrq() {
			return scrq;
		}
		public void setScrq(Date scrq) {
			this.scrq = scrq;
		}
        	 
  		@TableField
		public Integer getJsxm() {
			return jsxm;
		}
		public void setJsxm(Integer jsxm) {
			this.jsxm = jsxm;
		}
        	 
  		@TableField
		public Integer getSfdk() {
			return sfdk;
		}
		public void setSfdk(Integer sfdk) {
			this.sfdk = sfdk;
		}
    }