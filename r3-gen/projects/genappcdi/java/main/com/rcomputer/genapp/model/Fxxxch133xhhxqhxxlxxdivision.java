package com.rcomputer.genapp.model;
// Generated 13-Apr-2023 9:07:31 PM by Hibernate Tools 4.0.0

import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 * Fxxxch133xhhxqhxxlxxdivision generated by hbm2java
 */
@Entity
@XmlRootElement
@Table(name = "division")
public class Fxxxch133xhhxqhxxlxxdivision implements java.io.Serializable {

	private Integer a0xxuobxbxxxxxxxxxxxsid;
	private String a0xxukoxbvxxxxxxxxxxdivcode;
	private String b1xxuszsbvxxxxxxxxxxdescript;
	private String b2xxuzsxbvxxxxxxxxxxglprefix;
	private Integer z3xxzzfxhhxxxxxxxxxxstatusfl;
	private Date z4xxcztxlxxxxxxxxxxxstatusfldt;
	private String z5xxuznxbvxxxxxxxxxxnotes;
	private String z6xxutoxlhxxxxxxxxxxowner;
	private String zzxxu2oxxhxxxxxxxxxxowner2;
	private Set<Jxxxbh400xwwqqhxxxxxemployee> jxxxbh400xwwqqhxxxxxemployees = new HashSet<Jxxxbh400xwwqqhxxxxxemployee>(
			0);
	private Set<Fxxxuq8axxwwqqhxxxxxproject> fxxxuq8axxwwqqhxxxxxprojects = new HashSet<Fxxxuq8axxwwqqhxxxxxproject>(
			0);
	private Set<Yxxxch601xwwqqhxxxxxaccount> yxxxch601xwwqqhxxxxxaccounts = new HashSet<Yxxxch601xwwqqhxxxxxaccount>(
			0);

	public Fxxxch133xhhxqhxxlxxdivision() {
	}

	public Fxxxch133xhhxqhxxlxxdivision(String a0xxukoxbvxxxxxxxxxxdivcode) {
		this.a0xxukoxbvxxxxxxxxxxdivcode = a0xxukoxbvxxxxxxxxxxdivcode;
	}
	public Fxxxch133xhhxqhxxlxxdivision(String a0xxukoxbvxxxxxxxxxxdivcode,
			String b1xxuszsbvxxxxxxxxxxdescript,
			String b2xxuzsxbvxxxxxxxxxxglprefix,
			Integer z3xxzzfxhhxxxxxxxxxxstatusfl,
			Date z4xxcztxlxxxxxxxxxxxstatusfldt,
			String z5xxuznxbvxxxxxxxxxxnotes, String z6xxutoxlhxxxxxxxxxxowner,
			String zzxxu2oxxhxxxxxxxxxxowner2,
			Set<Jxxxbh400xwwqqhxxxxxemployee> jxxxbh400xwwqqhxxxxxemployees,
			Set<Fxxxuq8axxwwqqhxxxxxproject> fxxxuq8axxwwqqhxxxxxprojects,
			Set<Yxxxch601xwwqqhxxxxxaccount> yxxxch601xwwqqhxxxxxaccounts) {
		this.a0xxukoxbvxxxxxxxxxxdivcode = a0xxukoxbvxxxxxxxxxxdivcode;
		this.b1xxuszsbvxxxxxxxxxxdescript = b1xxuszsbvxxxxxxxxxxdescript;
		this.b2xxuzsxbvxxxxxxxxxxglprefix = b2xxuzsxbvxxxxxxxxxxglprefix;
		this.z3xxzzfxhhxxxxxxxxxxstatusfl = z3xxzzfxhhxxxxxxxxxxstatusfl;
		this.z4xxcztxlxxxxxxxxxxxstatusfldt = z4xxcztxlxxxxxxxxxxxstatusfldt;
		this.z5xxuznxbvxxxxxxxxxxnotes = z5xxuznxbvxxxxxxxxxxnotes;
		this.z6xxutoxlhxxxxxxxxxxowner = z6xxutoxlhxxxxxxxxxxowner;
		this.zzxxu2oxxhxxxxxxxxxxowner2 = zzxxu2oxxhxxxxxxxxxxowner2;
		this.jxxxbh400xwwqqhxxxxxemployees = jxxxbh400xwwqqhxxxxxemployees;
		this.fxxxuq8axxwwqqhxxxxxprojects = fxxxuq8axxwwqqhxxxxxprojects;
		this.yxxxch601xwwqqhxxxxxaccounts = yxxxch601xwwqqhxxxxxaccounts;
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

	@Column(name = "divcode", nullable = false, length = 32)
	@NotNull
	@Size(max = 32)
	public String getA0xxukoxbvxxxxxxxxxxdivcode() {
		return this.a0xxukoxbvxxxxxxxxxxdivcode;
	}

	public void setA0xxukoxbvxxxxxxxxxxdivcode(
			String a0xxukoxbvxxxxxxxxxxdivcode) {
		this.a0xxukoxbvxxxxxxxxxxdivcode = a0xxukoxbvxxxxxxxxxxdivcode;
	}

	@Column(name = "descript", length = 120)
	@Size(max = 120)
	public String getB1xxuszsbvxxxxxxxxxxdescript() {
		return this.b1xxuszsbvxxxxxxxxxxdescript;
	}

	public void setB1xxuszsbvxxxxxxxxxxdescript(
			String b1xxuszsbvxxxxxxxxxxdescript) {
		this.b1xxuszsbvxxxxxxxxxxdescript = b1xxuszsbvxxxxxxxxxxdescript;
	}

	@Column(name = "glprefix", length = 20)
	@Size(max = 20)
	public String getB2xxuzsxbvxxxxxxxxxxglprefix() {
		return this.b2xxuzsxbvxxxxxxxxxxglprefix;
	}

	public void setB2xxuzsxbvxxxxxxxxxxglprefix(
			String b2xxuzsxbvxxxxxxxxxxglprefix) {
		this.b2xxuzsxbvxxxxxxxxxxglprefix = b2xxuzsxbvxxxxxxxxxxglprefix;
	}

	@Column(name = "statusfl")
	public Integer getZ3xxzzfxhhxxxxxxxxxxstatusfl() {
		return this.z3xxzzfxhhxxxxxxxxxxstatusfl;
	}

	public void setZ3xxzzfxhhxxxxxxxxxxstatusfl(
			Integer z3xxzzfxhhxxxxxxxxxxstatusfl) {
		this.z3xxzzfxhhxxxxxxxxxxstatusfl = z3xxzzfxhhxxxxxxxxxxstatusfl;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "statusfldt", length = 29)
	public Date getZ4xxcztxlxxxxxxxxxxxstatusfldt() {
		return this.z4xxcztxlxxxxxxxxxxxstatusfldt;
	}

	public void setZ4xxcztxlxxxxxxxxxxxstatusfldt(
			Date z4xxcztxlxxxxxxxxxxxstatusfldt) {
		this.z4xxcztxlxxxxxxxxxxxstatusfldt = z4xxcztxlxxxxxxxxxxxstatusfldt;
	}

	@Column(name = "notes", length = 60)
	@Size(max = 60)
	public String getZ5xxuznxbvxxxxxxxxxxnotes() {
		return this.z5xxuznxbvxxxxxxxxxxnotes;
	}

	public void setZ5xxuznxbvxxxxxxxxxxnotes(String z5xxuznxbvxxxxxxxxxxnotes) {
		this.z5xxuznxbvxxxxxxxxxxnotes = z5xxuznxbvxxxxxxxxxxnotes;
	}

	@Column(name = "owner", length = 40)
	@Size(max = 40)
	public String getZ6xxutoxlhxxxxxxxxxxowner() {
		return this.z6xxutoxlhxxxxxxxxxxowner;
	}

	public void setZ6xxutoxlhxxxxxxxxxxowner(String z6xxutoxlhxxxxxxxxxxowner) {
		this.z6xxutoxlhxxxxxxxxxxowner = z6xxutoxlhxxxxxxxxxxowner;
	}

	@Column(name = "owner2", length = 40)
	@Size(max = 40)
	public String getZzxxu2oxxhxxxxxxxxxxowner2() {
		return this.zzxxu2oxxhxxxxxxxxxxowner2;
	}

	public void setZzxxu2oxxhxxxxxxxxxxowner2(String zzxxu2oxxhxxxxxxxxxxowner2) {
		this.zzxxu2oxxhxxxxxxxxxxowner2 = zzxxu2oxxhxxxxxxxxxxowner2;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "fxxxch133xhhxqhxxlxxdivision")
	public Set<Jxxxbh400xwwqqhxxxxxemployee> getJxxxbh400xwwqqhxxxxxemployees() {
		return this.jxxxbh400xwwqqhxxxxxemployees;
	}

	public void setJxxxbh400xwwqqhxxxxxemployees(
			Set<Jxxxbh400xwwqqhxxxxxemployee> jxxxbh400xwwqqhxxxxxemployees) {
		this.jxxxbh400xwwqqhxxxxxemployees = jxxxbh400xwwqqhxxxxxemployees;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "fxxxch133xhhxqhxxlxxdivision")
	public Set<Fxxxuq8axxwwqqhxxxxxproject> getFxxxuq8axxwwqqhxxxxxprojects() {
		return this.fxxxuq8axxwwqqhxxxxxprojects;
	}

	public void setFxxxuq8axxwwqqhxxxxxprojects(
			Set<Fxxxuq8axxwwqqhxxxxxproject> fxxxuq8axxwwqqhxxxxxprojects) {
		this.fxxxuq8axxwwqqhxxxxxprojects = fxxxuq8axxwwqqhxxxxxprojects;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "fxxxch133xhhxqhxxlxxdivision")
	public Set<Yxxxch601xwwqqhxxxxxaccount> getYxxxch601xwwqqhxxxxxaccounts() {
		return this.yxxxch601xwwqqhxxxxxaccounts;
	}

	public void setYxxxch601xwwqqhxxxxxaccounts(
			Set<Yxxxch601xwwqqhxxxxxaccount> yxxxch601xwwqqhxxxxxaccounts) {
		this.yxxxch601xwwqqhxxxxxaccounts = yxxxch601xwwqqhxxxxxaccounts;
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