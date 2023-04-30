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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
 * Dxxxch1d3xwwqqhxxlxxcompany generated by hbm2java
 */
@Entity
@XmlRootElement
@Table(name = "company")
public class Dxxxch1d3xwwqqhxxlxxcompany implements java.io.Serializable {

	private Integer a0xxuobxbxxxxxxxxxxxsid;
	private Fxxxuq111xwwqqhxxxxxaddress fxxxuq111xwwqqhxxxxxaddress;
	private String a0xxukcxbvxxxxxxxxxxcompanycode;
	private String b1xxuszsbvxxxxxxxxxxdescript;
	private String b2xxuzsxbvxxxxxxxxxxlegalname;
	private String b2xxuzsxbvxxxxxxxxxxglprefix;
	private Integer b3xxzzfxhhxxxxxxxxxxstatusfl;
	private Date b4xxcztxlxxxxxxxxxxxstatusfldt;
	private String b5xxuxznbvxxxxxxxxxxnotes;
	private String b6xxutoxlhxxxxxxxxxxowner;
	private String zzxxu2oxxhxxxxxxxxxxowner2;
	private Set<Jxxxuq201xwwqqhxxxxxcustomer> jxxxuq201xwwqqhxxxxxcustomers = new HashSet<Jxxxuq201xwwqqhxxxxxcustomer>(
			0);
	private Set<Jxxxbh400xwwqqhxxxxxemployee> jxxxbh400xwwqqhxxxxxemployees = new HashSet<Jxxxbh400xwwqqhxxxxxemployee>(
			0);
	private Set<Jxxxuq300xwwqqhxxxxxvendor> jxxxuq300xwwqqhxxxxxvendors = new HashSet<Jxxxuq300xwwqqhxxxxxvendor>(
			0);
	private Set<Yxxxch601xwwqqhxxxxxaccount> yxxxch601xwwqqhxxxxxaccounts = new HashSet<Yxxxch601xwwqqhxxxxxaccount>(
			0);
	private Set<Fxxxuq8axxwwqqhxxxxxproject> fxxxuq8axxwwqqhxxxxxprojects = new HashSet<Fxxxuq8axxwwqqhxxxxxproject>(
			0);
	private Set<Fxxxcq144xwwqqhxxxxxlocation> fxxxcq144xwwqqhxxxxxlocations = new HashSet<Fxxxcq144xwwqqhxxxxxlocation>(
			0);

	public Dxxxch1d3xwwqqhxxlxxcompany() {
	}

	public Dxxxch1d3xwwqqhxxlxxcompany(String a0xxukcxbvxxxxxxxxxxcompanycode) {
		this.a0xxukcxbvxxxxxxxxxxcompanycode = a0xxukcxbvxxxxxxxxxxcompanycode;
	}
	public Dxxxch1d3xwwqqhxxlxxcompany(
			Fxxxuq111xwwqqhxxxxxaddress fxxxuq111xwwqqhxxxxxaddress,
			String a0xxukcxbvxxxxxxxxxxcompanycode,
			String b1xxuszsbvxxxxxxxxxxdescript,
			String b2xxuzsxbvxxxxxxxxxxlegalname,
			String b2xxuzsxbvxxxxxxxxxxglprefix,
			Integer b3xxzzfxhhxxxxxxxxxxstatusfl,
			Date b4xxcztxlxxxxxxxxxxxstatusfldt,
			String b5xxuxznbvxxxxxxxxxxnotes, String b6xxutoxlhxxxxxxxxxxowner,
			String zzxxu2oxxhxxxxxxxxxxowner2,
			Set<Jxxxuq201xwwqqhxxxxxcustomer> jxxxuq201xwwqqhxxxxxcustomers,
			Set<Jxxxbh400xwwqqhxxxxxemployee> jxxxbh400xwwqqhxxxxxemployees,
			Set<Jxxxuq300xwwqqhxxxxxvendor> jxxxuq300xwwqqhxxxxxvendors,
			Set<Yxxxch601xwwqqhxxxxxaccount> yxxxch601xwwqqhxxxxxaccounts,
			Set<Fxxxuq8axxwwqqhxxxxxproject> fxxxuq8axxwwqqhxxxxxprojects,
			Set<Fxxxcq144xwwqqhxxxxxlocation> fxxxcq144xwwqqhxxxxxlocations) {
		this.fxxxuq111xwwqqhxxxxxaddress = fxxxuq111xwwqqhxxxxxaddress;
		this.a0xxukcxbvxxxxxxxxxxcompanycode = a0xxukcxbvxxxxxxxxxxcompanycode;
		this.b1xxuszsbvxxxxxxxxxxdescript = b1xxuszsbvxxxxxxxxxxdescript;
		this.b2xxuzsxbvxxxxxxxxxxlegalname = b2xxuzsxbvxxxxxxxxxxlegalname;
		this.b2xxuzsxbvxxxxxxxxxxglprefix = b2xxuzsxbvxxxxxxxxxxglprefix;
		this.b3xxzzfxhhxxxxxxxxxxstatusfl = b3xxzzfxhhxxxxxxxxxxstatusfl;
		this.b4xxcztxlxxxxxxxxxxxstatusfldt = b4xxcztxlxxxxxxxxxxxstatusfldt;
		this.b5xxuxznbvxxxxxxxxxxnotes = b5xxuxznbvxxxxxxxxxxnotes;
		this.b6xxutoxlhxxxxxxxxxxowner = b6xxutoxlhxxxxxxxxxxowner;
		this.zzxxu2oxxhxxxxxxxxxxowner2 = zzxxu2oxxhxxxxxxxxxxowner2;
		this.jxxxuq201xwwqqhxxxxxcustomers = jxxxuq201xwwqqhxxxxxcustomers;
		this.jxxxbh400xwwqqhxxxxxemployees = jxxxbh400xwwqqhxxxxxemployees;
		this.jxxxuq300xwwqqhxxxxxvendors = jxxxuq300xwwqqhxxxxxvendors;
		this.yxxxch601xwwqqhxxxxxaccounts = yxxxch601xwwqqhxxxxxaccounts;
		this.fxxxuq8axxwwqqhxxxxxprojects = fxxxuq8axxwwqqhxxxxxprojects;
		this.fxxxcq144xwwqqhxxxxxlocations = fxxxcq144xwwqqhxxxxxlocations;
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

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "mailtocode")
	public Fxxxuq111xwwqqhxxxxxaddress getFxxxuq111xwwqqhxxxxxaddress() {
		return this.fxxxuq111xwwqqhxxxxxaddress;
	}

	public void setFxxxuq111xwwqqhxxxxxaddress(
			Fxxxuq111xwwqqhxxxxxaddress fxxxuq111xwwqqhxxxxxaddress) {
		this.fxxxuq111xwwqqhxxxxxaddress = fxxxuq111xwwqqhxxxxxaddress;
	}

	@Column(name = "companycode", nullable = false, length = 32)
	@NotNull
	@Size(max = 32)
	public String getA0xxukcxbvxxxxxxxxxxcompanycode() {
		return this.a0xxukcxbvxxxxxxxxxxcompanycode;
	}

	public void setA0xxukcxbvxxxxxxxxxxcompanycode(
			String a0xxukcxbvxxxxxxxxxxcompanycode) {
		this.a0xxukcxbvxxxxxxxxxxcompanycode = a0xxukcxbvxxxxxxxxxxcompanycode;
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

	@Column(name = "legalname", length = 60)
	@Size(max = 60)
	public String getB2xxuzsxbvxxxxxxxxxxlegalname() {
		return this.b2xxuzsxbvxxxxxxxxxxlegalname;
	}

	public void setB2xxuzsxbvxxxxxxxxxxlegalname(
			String b2xxuzsxbvxxxxxxxxxxlegalname) {
		this.b2xxuzsxbvxxxxxxxxxxlegalname = b2xxuzsxbvxxxxxxxxxxlegalname;
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
	public Integer getB3xxzzfxhhxxxxxxxxxxstatusfl() {
		return this.b3xxzzfxhhxxxxxxxxxxstatusfl;
	}

	public void setB3xxzzfxhhxxxxxxxxxxstatusfl(
			Integer b3xxzzfxhhxxxxxxxxxxstatusfl) {
		this.b3xxzzfxhhxxxxxxxxxxstatusfl = b3xxzzfxhhxxxxxxxxxxstatusfl;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "statusfldt", length = 29)
	public Date getB4xxcztxlxxxxxxxxxxxstatusfldt() {
		return this.b4xxcztxlxxxxxxxxxxxstatusfldt;
	}

	public void setB4xxcztxlxxxxxxxxxxxstatusfldt(
			Date b4xxcztxlxxxxxxxxxxxstatusfldt) {
		this.b4xxcztxlxxxxxxxxxxxstatusfldt = b4xxcztxlxxxxxxxxxxxstatusfldt;
	}

	@Column(name = "notes", length = 60)
	@Size(max = 60)
	public String getB5xxuxznbvxxxxxxxxxxnotes() {
		return this.b5xxuxznbvxxxxxxxxxxnotes;
	}

	public void setB5xxuxznbvxxxxxxxxxxnotes(String b5xxuxznbvxxxxxxxxxxnotes) {
		this.b5xxuxznbvxxxxxxxxxxnotes = b5xxuxznbvxxxxxxxxxxnotes;
	}

	@Column(name = "owner", length = 40)
	@Size(max = 40)
	public String getB6xxutoxlhxxxxxxxxxxowner() {
		return this.b6xxutoxlhxxxxxxxxxxowner;
	}

	public void setB6xxutoxlhxxxxxxxxxxowner(String b6xxutoxlhxxxxxxxxxxowner) {
		this.b6xxutoxlhxxxxxxxxxxowner = b6xxutoxlhxxxxxxxxxxowner;
	}

	@Column(name = "owner2", length = 40)
	@Size(max = 40)
	public String getZzxxu2oxxhxxxxxxxxxxowner2() {
		return this.zzxxu2oxxhxxxxxxxxxxowner2;
	}

	public void setZzxxu2oxxhxxxxxxxxxxowner2(String zzxxu2oxxhxxxxxxxxxxowner2) {
		this.zzxxu2oxxhxxxxxxxxxxowner2 = zzxxu2oxxhxxxxxxxxxxowner2;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "dxxxch1d3xwwqqhxxlxxcompany")
	public Set<Jxxxuq201xwwqqhxxxxxcustomer> getJxxxuq201xwwqqhxxxxxcustomers() {
		return this.jxxxuq201xwwqqhxxxxxcustomers;
	}

	public void setJxxxuq201xwwqqhxxxxxcustomers(
			Set<Jxxxuq201xwwqqhxxxxxcustomer> jxxxuq201xwwqqhxxxxxcustomers) {
		this.jxxxuq201xwwqqhxxxxxcustomers = jxxxuq201xwwqqhxxxxxcustomers;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "dxxxch1d3xwwqqhxxlxxcompany")
	public Set<Jxxxbh400xwwqqhxxxxxemployee> getJxxxbh400xwwqqhxxxxxemployees() {
		return this.jxxxbh400xwwqqhxxxxxemployees;
	}

	public void setJxxxbh400xwwqqhxxxxxemployees(
			Set<Jxxxbh400xwwqqhxxxxxemployee> jxxxbh400xwwqqhxxxxxemployees) {
		this.jxxxbh400xwwqqhxxxxxemployees = jxxxbh400xwwqqhxxxxxemployees;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "dxxxch1d3xwwqqhxxlxxcompany")
	public Set<Jxxxuq300xwwqqhxxxxxvendor> getJxxxuq300xwwqqhxxxxxvendors() {
		return this.jxxxuq300xwwqqhxxxxxvendors;
	}

	public void setJxxxuq300xwwqqhxxxxxvendors(
			Set<Jxxxuq300xwwqqhxxxxxvendor> jxxxuq300xwwqqhxxxxxvendors) {
		this.jxxxuq300xwwqqhxxxxxvendors = jxxxuq300xwwqqhxxxxxvendors;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "dxxxch1d3xwwqqhxxlxxcompany")
	public Set<Yxxxch601xwwqqhxxxxxaccount> getYxxxch601xwwqqhxxxxxaccounts() {
		return this.yxxxch601xwwqqhxxxxxaccounts;
	}

	public void setYxxxch601xwwqqhxxxxxaccounts(
			Set<Yxxxch601xwwqqhxxxxxaccount> yxxxch601xwwqqhxxxxxaccounts) {
		this.yxxxch601xwwqqhxxxxxaccounts = yxxxch601xwwqqhxxxxxaccounts;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "dxxxch1d3xwwqqhxxlxxcompany")
	public Set<Fxxxuq8axxwwqqhxxxxxproject> getFxxxuq8axxwwqqhxxxxxprojects() {
		return this.fxxxuq8axxwwqqhxxxxxprojects;
	}

	public void setFxxxuq8axxwwqqhxxxxxprojects(
			Set<Fxxxuq8axxwwqqhxxxxxproject> fxxxuq8axxwwqqhxxxxxprojects) {
		this.fxxxuq8axxwwqqhxxxxxprojects = fxxxuq8axxwwqqhxxxxxprojects;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "dxxxch1d3xwwqqhxxlxxcompany")
	public Set<Fxxxcq144xwwqqhxxxxxlocation> getFxxxcq144xwwqqhxxxxxlocations() {
		return this.fxxxcq144xwwqqhxxxxxlocations;
	}

	public void setFxxxcq144xwwqqhxxxxxlocations(
			Set<Fxxxcq144xwwqqhxxxxxlocation> fxxxcq144xwwqqhxxxxxlocations) {
		this.fxxxcq144xwwqqhxxxxxlocations = fxxxcq144xwwqqhxxxxxlocations;
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