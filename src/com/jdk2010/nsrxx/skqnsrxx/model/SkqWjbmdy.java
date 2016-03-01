package com.jdk2010.nsrxx.skqnsrxx.model;

import com.jdk2010.framework.dal.model.Model;
import com.jdk2010.framework.dal.parse.annotation.TableField;

public class SkqWjbmdy extends Model<Model<SkqWjbmdy>> {
	private Integer id;
	private String jqbh;
	private String oldWjbm;
	private String newWjbm;

	@TableField
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@TableField
	public String getJqbh() {
		return jqbh;
	}

	public void setJqbh(String jqbh) {
		this.jqbh = jqbh;
	}

	@TableField
	public String getOldWjbm() {
		return oldWjbm;
	}

	public void setOldWjbm(String oldWjbm) {
		this.oldWjbm = oldWjbm;
	}

	@TableField
	public String getNewWjbm() {
		return newWjbm;
	}

	public void setNewWjbm(String newWjbm) {
		this.newWjbm = newWjbm;
	}

}
