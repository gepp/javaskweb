package com.jdk2010.invoice.skqfpj.model;

import java.util.Date;
import com.jdk2010.framework.dal.model.Model;
import com.jdk2010.framework.dal.parse.annotation.TableField;

public class SkqFpj extends Model<SkqFpj> {
	/* id */
	private Integer id;
	/* 发票编码 */
	private String fpbm;
	/* 发票编码 */
	private String fpdm;
	/* 发票起始号码 */
	private Integer fpqsh;
	/* 发票截止号码 */
	private Integer fpjzh;
	/* 发票单位 */
	private Integer fpdw;
	/* 纳税人微机编码 */
	private String nsrwjbm;
	/* 发票领购日期 */
	private Date fplgrq;

	private String swjgbm;

	@TableField
	public String getSwjgbm() {
		return swjgbm;
	}

	public void setSwjgbm(String swjgbm) {
		this.swjgbm = swjgbm;
	}

	@TableField
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
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
	public String getNsrwjbm() {
		return nsrwjbm;
	}

	public void setNsrwjbm(String nsrwjbm) {
		this.nsrwjbm = nsrwjbm;
	}

	@TableField
	public Date getFplgrq() {
		return fplgrq;
	}

	public void setFplgrq(Date fplgrq) {
		this.fplgrq = fplgrq;
	}
}