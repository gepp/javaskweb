package com.jdk2010.invoice.skqfpjmx.model;
import java.util.Date;
import com.jdk2010.framework.dal.model.Model;
import com.jdk2010.framework.dal.parse.annotation.TableField;

public class SkqFpjmx extends Model<SkqFpjmx> {
        	/* ID */
    	private Integer id;
        	/* 纳税人微机编码 */
    	private String nsrwjbm;
        	/* 发票编码 */
    	private String fpbm;
        	/* 发票编码 */
    	private String fpdm;
        	/* 发票起始号 */
    	private Integer fpqsh;
        	/* 发票截止号 */
    	private Integer fpjzh;
        	/* 发票单位 */
    	private Integer fpdw;
        	/* 机器编号 */
    	private String jqbh;
        	/* 发票下发状态 */
    	private Integer fpxfzt;
        	/* 发票领购状态 */
    	private Integer fplgzt;
        	/* 明细上传状态 */
    	private Integer mxsczt;
        	/* 发票领购日期 */
    	private Date fplgrq;
             	 
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
		public String getFpbm() {
			return fpbm;
		}
		public void setFpbm(String fpbm) {
			this.fpbm = fpbm;
		}
        	 
  		@TableField
		public String getFpdm() {
			return fpdm;
		}
		public void setFpdm(String fpdm) {
			this.fpdm = fpdm;
		}
        	 
  		@TableField
		public Integer getFpqsh() {
			return fpqsh;
		}
		public void setFpqsh(Integer fpqsh) {
			this.fpqsh = fpqsh;
		}
        	 
  		@TableField
		public Integer getFpjzh() {
			return fpjzh;
		}
		public void setFpjzh(Integer fpjzh) {
			this.fpjzh = fpjzh;
		}
        	 
  		@TableField
		public Integer getFpdw() {
			return fpdw;
		}
		public void setFpdw(Integer fpdw) {
			this.fpdw = fpdw;
		}
        	 
  		@TableField
		public String getJqbh() {
			return jqbh;
		}
		public void setJqbh(String jqbh) {
			this.jqbh = jqbh;
		}
        	 
  		@TableField
		public Integer getFpxfzt() {
			return fpxfzt;
		}
		public void setFpxfzt(Integer fpxfzt) {
			this.fpxfzt = fpxfzt;
		}
        	 
  		@TableField
		public Integer getFplgzt() {
			return fplgzt;
		}
		public void setFplgzt(Integer fplgzt) {
			this.fplgzt = fplgzt;
		}
        	 
  		@TableField
		public Integer getMxsczt() {
			return mxsczt;
		}
		public void setMxsczt(Integer mxsczt) {
			this.mxsczt = mxsczt;
		}
        	 
  		@TableField
		public Date getFplgrq() {
			return fplgrq;
		}
		public void setFplgrq(Date fplgrq) {
			this.fplgrq = fplgrq;
		}
		
		private String nsrsbh;
		
		
		public String getNsrsbh() {
			return nsrsbh;
		}
		public void setNsrsbh(String nsrsbh) {
			this.nsrsbh = nsrsbh;
		}

		private String nsrmc;

		public String getNsrmc() {
			return nsrmc;
		}
		public void setNsrmc(String nsrmc) {
			this.nsrmc = nsrmc;
		}
		
    }