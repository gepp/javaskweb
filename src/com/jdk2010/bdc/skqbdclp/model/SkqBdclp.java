package com.jdk2010.bdc.skqbdclp.model;

import java.util.Date;
import com.jdk2010.framework.dal.model.Model;
import com.jdk2010.framework.dal.parse.annotation.TableField;

public class SkqBdclp extends Model<SkqBdclp> {
	/* id */
	private Integer id;
	/* 项目明细ID */
	private Integer parentid;
	/* 楼牌号 */
	private String lpmc;
	/* 楼层 */
	private Integer lc;
	/* 楼牌序号 */
	private Integer lpxh;
	/* 面积 */
	private Double mj;
	/* 单价 */
	private Double dj;
	/* 类型 */
	private Integer lx;
	/* 创建时间 */
	private Date cjsj;
	/* 纳税人微机编码 */
	private String nsrwjbm;
	/* 已开金额 */
	private Double ykje;
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
	public Integer getLc() {
		return lc;
	}

	public void setLc(Integer lc) {
		this.lc = lc;
	}

	@TableField
	public Integer getLpxh() {
		return lpxh;
	}

	public void setLpxh(Integer lpxh) {
		this.lpxh = lpxh;
	}

	@TableField
	public Double getMj() {
		return mj;
	}

	public void setMj(Double mj) {
		this.mj = mj;
	}

	@TableField
	public Double getDj() {
		return dj;
	}

	public void setDj(Double dj) {
		this.dj = dj;
	}

	@TableField
	public Integer getLx() {
		return lx;
	}

	public void setLx(Integer lx) {
		this.lx = lx;
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

	@TableField
	public Double getYkje() {
		return ykje;
	}

	public void setYkje(Double ykje) {
		this.ykje = ykje;
	}

	@TableField
	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	private Integer lpzt;
	private String kpxz;
	private Double bdcykje;
	private Integer upflag;

	@TableField
	public Integer getLpzt() {
		return lpzt;
	}

	public void setLpzt(Integer lpzt) {
		this.lpzt = lpzt;
	}

	@TableField
	public String getKpxz() {
		return kpxz;
	}

	public void setKpxz(String kpxz) {
		this.kpxz = kpxz;
	}

	@TableField
	public Double getBdcykje() {
		return bdcykje;
	}

	public void setBdcykje(Double bdcykje) {
		this.bdcykje = bdcykje;
	}

	@TableField
	public Integer getUpflag() {
		return upflag;
	}

	public void setUpflag(Integer upflag) {
		this.upflag = upflag;
	}

}