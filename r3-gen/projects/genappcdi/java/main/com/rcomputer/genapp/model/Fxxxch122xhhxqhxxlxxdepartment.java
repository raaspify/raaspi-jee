package com.rcomputer.genapp.model;
// Generated 9-May-2023 8:57:32 PM by Hibernate Tools 4.0.0

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
 * Fxxxch122xhhxqhxxlxxdepartment generated by hbm2java
 */
@Entity
@XmlRootElement
@Table(name = "department")
public class Fxxxch122xhhxqhxxlxxdepartment implements java.io.Serializable {

	private Integer a0xxuobxbxxxxxxxxxxxsid;
	private String a0xxukexbvxxxxxxxxxxdepcode;
	private String b1xxuszsbvxxxxxxxxxxdescript;
	private String b2xxuzsxbvxxxxxxxxxxglprefix;
	private Integer z2xxzzfxhhxxxxxxxxxxstatusfl;
	private Date z3xxcztxlxxxxxxxxxxxstatusfldt;
	private String z4xxuznxbvxxxxxxxxxxnotes;
	private String z5xxutoxlhxxxxxxxxxxowner;
	private String zzxxu2oxxhxxxxxxxxxxowner2;
	private Set<Jxxxbh400xwwqqhxxxxxemployee> jxxxbh400xwwqqhxxxxxemployees = new HashSet<Jxxxbh400xwwqqhxxxxxemployee>(
			0);
	private Set<Fxxxuq8axxwwqqhxxxxxproject> fxxxuq8axxwwqqhxxxxxprojects = new HashSet<Fxxxuq8axxwwqqhxxxxxproject>(
			0);
	private Set<Yxxxch601xwwqqhxxxxxaccount> yxxxch601xwwqqhxxxxxaccounts = new HashSet<Yxxxch601xwwqqhxxxxxaccount>(
			0);

	public Fxxxch122xhhxqhxxlxxdepartment() {
	}

	public Fxxxch122xhhxqhxxlxxdepartment(String a0xxukexbvxxxxxxxxxxdepcode) {
		this.a0xxukexbvxxxxxxxxxxdepcode = a0xxukexbvxxxxxxxxxxdepcode;
	}
	public Fxxxch122xhhxqhxxlxxdepartment(String a0xxukexbvxxxxxxxxxxdepcode,
			String b1xxuszsbvxxxxxxxxxxdescript,
			String b2xxuzsxbvxxxxxxxxxxglprefix,
			Integer z2xxzzfxhhxxxxxxxxxxstatusfl,
			Date z3xxcztxlxxxxxxxxxxxstatusfldt,
			String z4xxuznxbvxxxxxxxxxxnotes, String z5xxutoxlhxxxxxxxxxxowner,
			String zzxxu2oxxhxxxxxxxxxxowner2,
			Set<Jxxxbh400xwwqqhxxxxxemployee> jxxxbh400xwwqqhxxxxxemployees,
			Set<Fxxxuq8axxwwqqhxxxxxproject> fxxxuq8axxwwqqhxxxxxprojects,
			Set<Yxxxch601xwwqqhxxxxxaccount> yxxxch601xwwqqhxxxxxaccounts) {
		this.a0xxukexbvxxxxxxxxxxdepcode = a0xxukexbvxxxxxxxxxxdepcode;
		this.b1xxuszsbvxxxxxxxxxxdescript = b1xxuszsbvxxxxxxxxxxdescript;
		this.b2xxuzsxbvxxxxxxxxxxglprefix = b2xxuzsxbvxxxxxxxxxxglprefix;
		this.z2xxzzfxhhxxxxxxxxxxstatusfl = z2xxzzfxhhxxxxxxxxxxstatusfl;
		this.z3xxcztxlxxxxxxxxxxxstatusfldt = z3xxcztxlxxxxxxxxxxxstatusfldt;
		this.z4xxuznxbvxxxxxxxxxxnotes = z4xxuznxbvxxxxxxxxxxnotes;
		this.z5xxutoxlhxxxxxxxxxxowner = z5xxutoxlhxxxxxxxxxxowner;
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

	@Column(name = "depcode", nullable = false, length = 32)
	@NotNull
	@Size(max = 32)
	public String getA0xxukexbvxxxxxxxxxxdepcode() {
		return this.a0xxukexbvxxxxxxxxxxdepcode;
	}

	public void setA0xxukexbvxxxxxxxxxxdepcode(
			String a0xxukexbvxxxxxxxxxxdepcode) {
		this.a0xxukexbvxxxxxxxxxxdepcode = a0xxukexbvxxxxxxxxxxdepcode;
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
	public Integer getZ2xxzzfxhhxxxxxxxxxxstatusfl() {
		return this.z2xxzzfxhhxxxxxxxxxxstatusfl;
	}

	public void setZ2xxzzfxhhxxxxxxxxxxstatusfl(
			Integer z2xxzzfxhhxxxxxxxxxxstatusfl) {
		this.z2xxzzfxhhxxxxxxxxxxstatusfl = z2xxzzfxhhxxxxxxxxxxstatusfl;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "statusfldt", length = 29)
	public Date getZ3xxcztxlxxxxxxxxxxxstatusfldt() {
		return this.z3xxcztxlxxxxxxxxxxxstatusfldt;
	}

	public void setZ3xxcztxlxxxxxxxxxxxstatusfldt(
			Date z3xxcztxlxxxxxxxxxxxstatusfldt) {
		this.z3xxcztxlxxxxxxxxxxxstatusfldt = z3xxcztxlxxxxxxxxxxxstatusfldt;
	}

	@Column(name = "notes", length = 60)
	@Size(max = 60)
	public String getZ4xxuznxbvxxxxxxxxxxnotes() {
		return this.z4xxuznxbvxxxxxxxxxxnotes;
	}

	public void setZ4xxuznxbvxxxxxxxxxxnotes(String z4xxuznxbvxxxxxxxxxxnotes) {
		this.z4xxuznxbvxxxxxxxxxxnotes = z4xxuznxbvxxxxxxxxxxnotes;
	}

	@Column(name = "owner", length = 40)
	@Size(max = 40)
	public String getZ5xxutoxlhxxxxxxxxxxowner() {
		return this.z5xxutoxlhxxxxxxxxxxowner;
	}

	public void setZ5xxutoxlhxxxxxxxxxxowner(String z5xxutoxlhxxxxxxxxxxowner) {
		this.z5xxutoxlhxxxxxxxxxxowner = z5xxutoxlhxxxxxxxxxxowner;
	}

	@Column(name = "owner2", length = 40)
	@Size(max = 40)
	public String getZzxxu2oxxhxxxxxxxxxxowner2() {
		return this.zzxxu2oxxhxxxxxxxxxxowner2;
	}

	public void setZzxxu2oxxhxxxxxxxxxxowner2(String zzxxu2oxxhxxxxxxxxxxowner2) {
		this.zzxxu2oxxhxxxxxxxxxxowner2 = zzxxu2oxxhxxxxxxxxxxowner2;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "fxxxch122xhhxqhxxlxxdepartment")
	public Set<Jxxxbh400xwwqqhxxxxxemployee> getJxxxbh400xwwqqhxxxxxemployees() {
		return this.jxxxbh400xwwqqhxxxxxemployees;
	}

	public void setJxxxbh400xwwqqhxxxxxemployees(
			Set<Jxxxbh400xwwqqhxxxxxemployee> jxxxbh400xwwqqhxxxxxemployees) {
		this.jxxxbh400xwwqqhxxxxxemployees = jxxxbh400xwwqqhxxxxxemployees;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "fxxxch122xhhxqhxxlxxdepartment")
	public Set<Fxxxuq8axxwwqqhxxxxxproject> getFxxxuq8axxwwqqhxxxxxprojects() {
		return this.fxxxuq8axxwwqqhxxxxxprojects;
	}

	public void setFxxxuq8axxwwqqhxxxxxprojects(
			Set<Fxxxuq8axxwwqqhxxxxxproject> fxxxuq8axxwwqqhxxxxxprojects) {
		this.fxxxuq8axxwwqqhxxxxxprojects = fxxxuq8axxwwqqhxxxxxprojects;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "fxxxch122xhhxqhxxlxxdepartment")
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
