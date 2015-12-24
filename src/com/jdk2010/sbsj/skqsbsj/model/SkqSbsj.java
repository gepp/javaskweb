package com.jdk2010.sbsj.skqsbsj.model;
import java.util.Date;
import com.jdk2010.framework.dal.model.Model;
import com.jdk2010.framework.dal.parse.annotation.TableField;

public class SkqSbsj extends Model<SkqSbsj> {
        	/* id */
    	private Integer id;
        	/* 所属开始时间 */
    	private Date sskssj;
        	/* 所属截止时间 */
    	private Date ssjzsj;
        	/* 正常票份数 */
    	private Integer zcpfs;
        	/* 退票份数 */
    	private Integer tpfs;
        	/* 废票份数 */
    	private Integer fpfs;
        	/* 正常票总金额 */
    	private Double zcpzje;
        	/* 退票总金额 */
    	private Double tpzje;
        	/* 纳税人微机编码 */
    	private String nsrwjbm;
        	/* 机器编号 */
    	private String jqbh;
        	/* 申报类型 */
    	private Integer sblx;
        	/* 开票截止日期 */
    	private Date kpjzsj;
        	/* 单张开票限额 */
    	private Double dzkpxe;
        	/* 月累计开票限额 */
    	private Double yljkpxe;
        	/* 月累计退票限额 */
    	private Double yljtpxe;
        	/* 下载状态 */
    	private Integer xzzt;
        	/* 下载日期 */
    	private Date xzrq;
        	/* 创建日期 */
    	private Date cjrq;
        	/* 申报日期 */
    	private Date sbrq;
        	/* MAC */
    	private String mac;
             	 
  		@TableField
		public Integer getId() {
			return id;
		}
		public void setId(Integer id) {
			this.id = id;
		}
        	 
  		@TableField
		public Date getSskssj() {
			return sskssj;
		}
		public void setSskssj(Date sskssj) {
			this.sskssj = sskssj;
		}
        	 
  		@TableField
		public Date getSsjzsj() {
			return ssjzsj;
		}
		public void setSsjzsj(Date ssjzsj) {
			this.ssjzsj = ssjzsj;
		}
        	 
  		@TableField
		public Integer getZcpfs() {
			return zcpfs;
		}
		public void setZcpfs(Integer zcpfs) {
			this.zcpfs = zcpfs;
		}
        	 
  		@TableField
		public Integer getTpfs() {
			return tpfs;
		}
		public void setTpfs(Integer tpfs) {
			this.tpfs = tpfs;
		}
        	 
  		@TableField
		public Integer getFpfs() {
			return fpfs;
		}
		public void setFpfs(Integer fpfs) {
			this.fpfs = fpfs;
		}
        	 
  		@TableField
		public Double getZcpzje() {
			return zcpzje;
		}
		public void setZcpzje(Double zcpzje) {
			this.zcpzje = zcpzje;
		}
        	 
  		@TableField
		public Double getTpzje() {
			return tpzje;
		}
		public void setTpzje(Double tpzje) {
			this.tpzje = tpzje;
		}
        	 
  		@TableField
		public String getNsrwjbm() {
			return nsrwjbm;
		}
		public void setNsrwjbm(String nsrwjbm) {
			this.nsrwjbm = nsrwjbm;
		}
        	 
  		@TableField
		public String getJqbh() {
			return jqbh;
		}
		public void setJqbh(String jqbh) {
			this.jqbh = jqbh;
		}
        	 
  		@TableField
		public Integer getSblx() {
			return sblx;
		}
		public void setSblx(Integer sblx) {
			this.sblx = sblx;
		}
        	 
  		@TableField
		public Date getKpjzsj() {
			return kpjzsj;
		}
		public void setKpjzsj(Date kpjzsj) {
			this.kpjzsj = kpjzsj;
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
		public Integer getXzzt() {
			return xzzt;
		}
		public void setXzzt(Integer xzzt) {
			this.xzzt = xzzt;
		}
        	 
  		@TableField
		public Date getXzrq() {
			return xzrq;
		}
		public void setXzrq(Date xzrq) {
			this.xzrq = xzrq;
		}
        	 
  		@TableField
		public Date getCjrq() {
			return cjrq;
		}
		public void setCjrq(Date cjrq) {
			this.cjrq = cjrq;
		}
        	 
  		@TableField
		public Date getSbrq() {
			return sbrq;
		}
		public void setSbrq(Date sbrq) {
			this.sbrq = sbrq;
		}
        	 
  		@TableField
		public String getMac() {
			return mac;
		}
		public void setMac(String mac) {
			this.mac = mac;
		}
		String nsrmc;

		public String getNsrmc() {
			return nsrmc;
		}
		public void setNsrmc(String nsrmc) {
			this.nsrmc = nsrmc;
		}
		
    }