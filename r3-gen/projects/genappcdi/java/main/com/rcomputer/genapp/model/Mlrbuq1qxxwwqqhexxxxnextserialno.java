package com.rcomputer.genapp.model;
// Generated 13-Apr-2023 9:07:31 PM by Hibernate Tools 4.0.0

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 * Mlrbuq1qxxwwqqhexxxxnextserialno generated by hbm2java
 */
@Entity
@XmlRootElement
@Table(name = "nextserialno")
public class Mlrbuq1qxxwwqqhexxxxnextserialno implements java.io.Serializable {

	private Integer a0xxuobxbxxxxxxxxxxxsid;
	private String a0xxukxxbvxxxxxxxxxxnxtserno;
	private String z1xxuxxrbvxxxxxxxxxxcurserno;
	private String z2xxuxxrbvxxxxxxxxxxprevsern;
	private Boolean z3xxfxxxbvxxxxxxxxxxis9999;
	private String z4xxuxxrbvxxxxxxxxxxrefno;
	private String zaxxutoxlhxxxxxxxxxxowner;
	private String zzxxu2oxxhxxxxxxxxxxowner2;

	public Mlrbuq1qxxwwqqhexxxxnextserialno() {
	}

	public Mlrbuq1qxxwwqqhexxxxnextserialno(String a0xxukxxbvxxxxxxxxxxnxtserno) {
		this.a0xxukxxbvxxxxxxxxxxnxtserno = a0xxukxxbvxxxxxxxxxxnxtserno;
	}
	public Mlrbuq1qxxwwqqhexxxxnextserialno(
			String a0xxukxxbvxxxxxxxxxxnxtserno,
			String z1xxuxxrbvxxxxxxxxxxcurserno,
			String z2xxuxxrbvxxxxxxxxxxprevsern,
			Boolean z3xxfxxxbvxxxxxxxxxxis9999,
			String z4xxuxxrbvxxxxxxxxxxrefno, String zaxxutoxlhxxxxxxxxxxowner,
			String zzxxu2oxxhxxxxxxxxxxowner2) {
		this.a0xxukxxbvxxxxxxxxxxnxtserno = a0xxukxxbvxxxxxxxxxxnxtserno;
		this.z1xxuxxrbvxxxxxxxxxxcurserno = z1xxuxxrbvxxxxxxxxxxcurserno;
		this.z2xxuxxrbvxxxxxxxxxxprevsern = z2xxuxxrbvxxxxxxxxxxprevsern;
		this.z3xxfxxxbvxxxxxxxxxxis9999 = z3xxfxxxbvxxxxxxxxxxis9999;
		this.z4xxuxxrbvxxxxxxxxxxrefno = z4xxuxxrbvxxxxxxxxxxrefno;
		this.zaxxutoxlhxxxxxxxxxxowner = zaxxutoxlhxxxxxxxxxxowner;
		this.zzxxu2oxxhxxxxxxxxxxowner2 = zzxxu2oxxhxxxxxxxxxxowner2;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "sid", unique = true, nullable = false)
	public Integer getA0xxuobxbxxxxxxxxxxxsid() {
		return this.a0xxuobxbxxxxxxxxxxxsid;
	}

	public void setA0xxuobxbxxxxxxxxxxxsid(Integer a0xxuobxbxxxxxxxxxxxsid) {
		this.a0xxuobxbxxxxxxxxxxxsid = a0xxuobxbxxxxxxxxxxxsid;
	}

	@Column(name = "nxtserno", nullable = false, length = 4)
	@NotNull
	@Size(max = 4)
	public String getA0xxukxxbvxxxxxxxxxxnxtserno() {
		return this.a0xxukxxbvxxxxxxxxxxnxtserno;
	}

	public void setA0xxukxxbvxxxxxxxxxxnxtserno(
			String a0xxukxxbvxxxxxxxxxxnxtserno) {
		this.a0xxukxxbvxxxxxxxxxxnxtserno = a0xxukxxbvxxxxxxxxxxnxtserno;
	}

	@Column(name = "curserno", length = 4)
	@Size(max = 4)
	public String getZ1xxuxxrbvxxxxxxxxxxcurserno() {
		return this.z1xxuxxrbvxxxxxxxxxxcurserno;
	}

	public void setZ1xxuxxrbvxxxxxxxxxxcurserno(
			String z1xxuxxrbvxxxxxxxxxxcurserno) {
		this.z1xxuxxrbvxxxxxxxxxxcurserno = z1xxuxxrbvxxxxxxxxxxcurserno;
	}

	@Column(name = "prevsern", length = 4)
	@Size(max = 4)
	public String getZ2xxuxxrbvxxxxxxxxxxprevsern() {
		return this.z2xxuxxrbvxxxxxxxxxxprevsern;
	}

	public void setZ2xxuxxrbvxxxxxxxxxxprevsern(
			String z2xxuxxrbvxxxxxxxxxxprevsern) {
		this.z2xxuxxrbvxxxxxxxxxxprevsern = z2xxuxxrbvxxxxxxxxxxprevsern;
	}

	@Column(name = "is9999")
	public Boolean getZ3xxfxxxbvxxxxxxxxxxis9999() {
		return this.z3xxfxxxbvxxxxxxxxxxis9999;
	}

	public void setZ3xxfxxxbvxxxxxxxxxxis9999(Boolean z3xxfxxxbvxxxxxxxxxxis9999) {
		this.z3xxfxxxbvxxxxxxxxxxis9999 = z3xxfxxxbvxxxxxxxxxxis9999;
	}

	@Column(name = "refno", length = 14)
	@Size(max = 14)
	public String getZ4xxuxxrbvxxxxxxxxxxrefno() {
		return this.z4xxuxxrbvxxxxxxxxxxrefno;
	}

	public void setZ4xxuxxrbvxxxxxxxxxxrefno(String z4xxuxxrbvxxxxxxxxxxrefno) {
		this.z4xxuxxrbvxxxxxxxxxxrefno = z4xxuxxrbvxxxxxxxxxxrefno;
	}

	@Column(name = "owner", length = 40)
	@Size(max = 40)
	public String getZaxxutoxlhxxxxxxxxxxowner() {
		return this.zaxxutoxlhxxxxxxxxxxowner;
	}

	public void setZaxxutoxlhxxxxxxxxxxowner(String zaxxutoxlhxxxxxxxxxxowner) {
		this.zaxxutoxlhxxxxxxxxxxowner = zaxxutoxlhxxxxxxxxxxowner;
	}

	@Column(name = "owner2", length = 40)
	@Size(max = 40)
	public String getZzxxu2oxxhxxxxxxxxxxowner2() {
		return this.zzxxu2oxxhxxxxxxxxxxowner2;
	}

	public void setZzxxu2oxxhxxxxxxxxxxowner2(String zzxxu2oxxhxxxxxxxxxxowner2) {
		this.zzxxu2oxxhxxxxxxxxxxowner2 = zzxxu2oxxhxxxxxxxxxxowner2;
	}

	// The following is extra code specified in the hbm.xml files

	private Boolean flaggedAsEditable = false;
	private Boolean flaggedAsDeleteable = false;
	private Boolean flaggedAsNew = false;
	@Transient
	public boolean getFlaggedAsEditable() {
		return flaggedAsEditable;
	}
	public void setFlaggedAsEditable(Boolean value) {
		flaggedAsEditable = value;
	}
	@Transient
	public boolean getFlaggedAsDeleteable() {
		return flaggedAsDeleteable;
	}
	public void setFlaggedAsDeleteable(Boolean value) {
		flaggedAsDeleteable = value;
	}
	@Transient
	public boolean getFlaggedAsNew() {
		return flaggedAsNew;
	}
	public void setFlaggedAsNew(Boolean value) {
		flaggedAsNew = value;
	}

	// end of extra code specified in the hbm.xml files

}
