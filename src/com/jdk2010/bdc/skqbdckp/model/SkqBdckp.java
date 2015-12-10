package com.jdk2010.bdc.skqbdckp.model;
import java.util.Date;
import com.jdk2010.framework.dal.model.Model;
import com.jdk2010.framework.dal.parse.annotation.TableField;

public class SkqBdckp extends Model<SkqBdckp> {
        	/* id */
    	private Integer id;
        	/* 楼牌ID */
    	private Integer parentid;
        	/* 楼牌号 */
    	private String lpmc;
        	/* 付款方名称 */
    	private String fkfmc;
        	/* 付款方代码 */
    	private String fkfdm;
        	/* 纳税人微机编码 */
    	private String nsrwjbm;
        	/* 机器编号 */
    	private String jqbh;
        	/* 开票金额 */
    	private Double hjzje;
        	/* 款项性质 */
    	private Integer kxxz;
        	/* 发票代码 */
    	private String fpdm;
        	/* 发票号码 */
    	private Integer fphm;
        	/* 开票类型 */
    	private Integer kplx;
        	/* 开票日期 */
    	private Date kprq;
        	/* 上传日期 */
    	private Date scrq;
        	/* 项目ID */
    	private Integer bdcid;
        	/* 子项目ID */
    	private Integer bdczxmid;
        	/* 项目明细ID */
    	private Integer bdcxmmxid;
             	 
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
		public String getLpmc() {
			return lpmc;
		}
		public void setLpmc(String lpmc) {
			this.lpmc = lpmc;
		}
        	 
  		@TableField
		public String getFkfmc() {
			return fkfmc;
		}
		public void setFkfmc(String fkfmc) {
			this.fkfmc = fkfmc;
		}
        	 
  		@TableField
		public String getFkfdm() {
			return fkfdm;
		}
		public void setFkfdm(String fkfdm) {
			this.fkfdm = fkfdm;
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
		public Double getHjzje() {
			return hjzje;
		}
		public void setHjzje(Double hjzje) {
			this.hjzje = hjzje;
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
		public Integer getBdcid() {
			return bdcid;
		}
		public void setBdcid(Integer bdcid) {
			this.bdcid = bdcid;
		}
        	 
  		@TableField
		public Integer getBdczxmid() {
			return bdczxmid;
		}
		public void setBdczxmid(Integer bdczxmid) {
			this.bdczxmid = bdczxmid;
		}
        	 
  		@TableField
		public Integer getBdcxmmxid() {
			return bdcxmmxid;
		}
		public void setBdcxmmxid(Integer bdcxmmxid) {
			this.bdcxmmxid = bdcxmmxid;
		}
    }