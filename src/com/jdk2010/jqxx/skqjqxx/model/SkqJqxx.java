package com.jdk2010.jqxx.skqjqxx.model;
import java.util.Date;
import com.jdk2010.framework.dal.model.Model;
import com.jdk2010.framework.dal.parse.annotation.TableField;

public class SkqJqxx extends Model<SkqJqxx> {
        	/* id */
    	private Integer id;
        	/* 纳税人微机编码 */
    	private String nsrwjbm;
        	/* 机器型号编码 */
    	private String jqxhbm;
        	/* 机器编号 */
    	private String jqbh;
        	/* 税控卡号 */
    	private String skkh;
        	/* 用户卡号 */
    	private String yhkh;
        	/* 卡启用日期 */
    	private Date kqyrq;
        	/* 卡有效日期 */
    	private Date kyxrq;
        	/* 申报方式 */
    	private String sbfs;
        	/* 明细申报标志 */
    	private String mxsbbz;
        	/* 开票截止日期 */
    	private Date kpjzrq;
        	/* 单张开票限额 */
    	private Double dzkpxe;
        	/* 月累计开票限额 */
    	private Double yljkpxe;
        	/* 月累计开票限额 */
    	private Double yljtpxe;
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
		public String getJqxhbm() {
			return jqxhbm;
		}
		public void setJqxhbm(String jqxhbm) {
			this.jqxhbm = jqxhbm;
		}
        	 
  		@TableField
		public String getJqbh() {
			return jqbh;
		}
		public void setJqbh(String jqbh) {
			this.jqbh = jqbh;
		}
        	 
  		@TableField
		public String getSkkh() {
			return skkh;
		}
		public void setSkkh(String skkh) {
			this.skkh = skkh;
		}
        	 
  		@TableField
		public String getYhkh() {
			return yhkh;
		}
		public void setYhkh(String yhkh) {
			this.yhkh = yhkh;
		}
        	 
  		@TableField
		public Date getKqyrq() {
			return kqyrq;
		}
		public void setKqyrq(Date kqyrq) {
			this.kqyrq = kqyrq;
		}
        	 
  		@TableField
		public Date getKyxrq() {
			return kyxrq;
		}
		public void setKyxrq(Date kyxrq) {
			this.kyxrq = kyxrq;
		}
        	 
  		@TableField
		public String getSbfs() {
			return sbfs;
		}
		public void setSbfs(String sbfs) {
			this.sbfs = sbfs;
		}
        	 
  		@TableField
		public String getMxsbbz() {
			return mxsbbz;
		}
		public void setMxsbbz(String mxsbbz) {
			this.mxsbbz = mxsbbz;
		}
        	 
  		@TableField
		public Date getKpjzrq() {
			return kpjzrq;
		}
		public void setKpjzrq(Date kpjzrq) {
			this.kpjzrq = kpjzrq;
		}
        	 
  		@TableField
		public Double getDzkpxe() {
			return dzkpxe;
		}
		public void setDzkpxe(Double dzkpxe) {
			this.dzkpxe = dzkpxe;
		}
        	 
  		@TableField
		public Double getYljkpxe() {
			return yljkpxe;
		}
		public void setYljkpxe(Double yljkpxe) {
			this.yljkpxe = yljkpxe;
		}
        	 
  		@TableField
		public Double getYljtpxe() {
			return yljtpxe;
		}
		public void setYljtpxe(Double yljtpxe) {
			this.yljtpxe = yljtpxe;
		}
        	 
  		@TableField
		public Integer getStatus() {
			return status;
		}
		public void setStatus(Integer status) {
			this.status = status;
		}
    }