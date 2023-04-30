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
 * Yxxxuq632xwwqqhxxxxxperioddates generated by hbm2java
 */
@Entity
@XmlRootElement
@Table(name = "perioddates")
public class Yxxxuq632xwwqqhxxxxxperioddates implements java.io.Serializable {

	private Integer a0xxuobxbxxxxxxxxxxxsid;
	private String a0xxukwpbv47xxxxxxxxperiod;
	private String b1xxuszsbvxxxxxxxxxxdescript;
	private Date b2xxdwsrbvxxxxxxxxxxstartdate;
	private Date b3xxdwerbvxxxxxxxxxxenddate;
	private Integer b4xxew1rbvxxxxxxxxxxstartofweek;
	private Integer b5xxewbrbvxxxxxxxxxxstartofbweek;
	private Integer b6xxewfrbvxxxxxxxxxxendofbweek;
	private Integer z1xxzzfxhhxxxxxxxxxxstatusfl;
	private Date z2xxcztxlxxxxxxxxxxxstatusfldt;
	private String y3xxuxznbvxxxxxxxxxxnotes;
	private String z3xxutoxlhxxxxxxxxxxowner;
	private String zzxxu2oxxhxxxxxxxxxxowner2;
	private Set<Yxxxch65exwwqqhxxxxxglentries> yxxxch65exwwqqhxxxxxglentrieses = new HashSet<Yxxxch65exwwqqhxxxxxglentries>(
			0);

	public Yxxxuq632xwwqqhxxxxxperioddates() {
	}

	public Yxxxuq632xwwqqhxxxxxperioddates(String a0xxukwpbv47xxxxxxxxperiod) {
		this.a0xxukwpbv47xxxxxxxxperiod = a0xxukwpbv47xxxxxxxxperiod;
	}
	public Yxxxuq632xwwqqhxxxxxperioddates(String a0xxukwpbv47xxxxxxxxperiod,
			String b1xxuszsbvxxxxxxxxxxdescript,
			Date b2xxdwsrbvxxxxxxxxxxstartdate,
			Date b3xxdwerbvxxxxxxxxxxenddate,
			Integer b4xxew1rbvxxxxxxxxxxstartofweek,
			Integer b5xxewbrbvxxxxxxxxxxstartofbweek,
			Integer b6xxewfrbvxxxxxxxxxxendofbweek,
			Integer z1xxzzfxhhxxxxxxxxxxstatusfl,
			Date z2xxcztxlxxxxxxxxxxxstatusfldt,
			String y3xxuxznbvxxxxxxxxxxnotes, String z3xxutoxlhxxxxxxxxxxowner,
			String zzxxu2oxxhxxxxxxxxxxowner2,
			Set<Yxxxch65exwwqqhxxxxxglentries> yxxxch65exwwqqhxxxxxglentrieses) {
		this.a0xxukwpbv47xxxxxxxxperiod = a0xxukwpbv47xxxxxxxxperiod;
		this.b1xxuszsbvxxxxxxxxxxdescript = b1xxuszsbvxxxxxxxxxxdescript;
		this.b2xxdwsrbvxxxxxxxxxxstartdate = b2xxdwsrbvxxxxxxxxxxstartdate;
		this.b3xxdwerbvxxxxxxxxxxenddate = b3xxdwerbvxxxxxxxxxxenddate;
		this.b4xxew1rbvxxxxxxxxxxstartofweek = b4xxew1rbvxxxxxxxxxxstartofweek;
		this.b5xxewbrbvxxxxxxxxxxstartofbweek = b5xxewbrbvxxxxxxxxxxstartofbweek;
		this.b6xxewfrbvxxxxxxxxxxendofbweek = b6xxewfrbvxxxxxxxxxxendofbweek;
		this.z1xxzzfxhhxxxxxxxxxxstatusfl = z1xxzzfxhhxxxxxxxxxxstatusfl;
		this.z2xxcztxlxxxxxxxxxxxstatusfldt = z2xxcztxlxxxxxxxxxxxstatusfldt;
		this.y3xxuxznbvxxxxxxxxxxnotes = y3xxuxznbvxxxxxxxxxxnotes;
		this.z3xxutoxlhxxxxxxxxxxowner = z3xxutoxlhxxxxxxxxxxowner;
		this.zzxxu2oxxhxxxxxxxxxxowner2 = zzxxu2oxxhxxxxxxxxxxowner2;
		this.yxxxch65exwwqqhxxxxxglentrieses = yxxxch65exwwqqhxxxxxglentrieses;
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

	@Column(name = "period", nullable = false, length = 2)
	@NotNull
	@Size(max = 2)
	public String getA0xxukwpbv47xxxxxxxxperiod() {
		return this.a0xxukwpbv47xxxxxxxxperiod;
	}

	public void setA0xxukwpbv47xxxxxxxxperiod(String a0xxukwpbv47xxxxxxxxperiod) {
		this.a0xxukwpbv47xxxxxxxxperiod = a0xxukwpbv47xxxxxxxxperiod;
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

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "startdate", length = 29)
	public Date getB2xxdwsrbvxxxxxxxxxxstartdate() {
		return this.b2xxdwsrbvxxxxxxxxxxstartdate;
	}

	public void setB2xxdwsrbvxxxxxxxxxxstartdate(
			Date b2xxdwsrbvxxxxxxxxxxstartdate) {
		this.b2xxdwsrbvxxxxxxxxxxstartdate = b2xxdwsrbvxxxxxxxxxxstartdate;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "enddate", length = 29)
	public Date getB3xxdwerbvxxxxxxxxxxenddate() {
		return this.b3xxdwerbvxxxxxxxxxxenddate;
	}

	public void setB3xxdwerbvxxxxxxxxxxenddate(Date b3xxdwerbvxxxxxxxxxxenddate) {
		this.b3xxdwerbvxxxxxxxxxxenddate = b3xxdwerbvxxxxxxxxxxenddate;
	}

	@Column(name = "startofweek")
	public Integer getB4xxew1rbvxxxxxxxxxxstartofweek() {
		return this.b4xxew1rbvxxxxxxxxxxstartofweek;
	}

	public void setB4xxew1rbvxxxxxxxxxxstartofweek(
			Integer b4xxew1rbvxxxxxxxxxxstartofweek) {
		this.b4xxew1rbvxxxxxxxxxxstartofweek = b4xxew1rbvxxxxxxxxxxstartofweek;
	}

	@Column(name = "startofbweek")
	public Integer getB5xxewbrbvxxxxxxxxxxstartofbweek() {
		return this.b5xxewbrbvxxxxxxxxxxstartofbweek;
	}

	public void setB5xxewbrbvxxxxxxxxxxstartofbweek(
			Integer b5xxewbrbvxxxxxxxxxxstartofbweek) {
		this.b5xxewbrbvxxxxxxxxxxstartofbweek = b5xxewbrbvxxxxxxxxxxstartofbweek;
	}

	@Column(name = "endofbweek")
	public Integer getB6xxewfrbvxxxxxxxxxxendofbweek() {
		return this.b6xxewfrbvxxxxxxxxxxendofbweek;
	}

	public void setB6xxewfrbvxxxxxxxxxxendofbweek(
			Integer b6xxewfrbvxxxxxxxxxxendofbweek) {
		this.b6xxewfrbvxxxxxxxxxxendofbweek = b6xxewfrbvxxxxxxxxxxendofbweek;
	}

	@Column(name = "statusfl")
	public Integer getZ1xxzzfxhhxxxxxxxxxxstatusfl() {
		return this.z1xxzzfxhhxxxxxxxxxxstatusfl;
	}

	public void setZ1xxzzfxhhxxxxxxxxxxstatusfl(
			Integer z1xxzzfxhhxxxxxxxxxxstatusfl) {
		this.z1xxzzfxhhxxxxxxxxxxstatusfl = z1xxzzfxhhxxxxxxxxxxstatusfl;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "statusfldt", length = 29)
	public Date getZ2xxcztxlxxxxxxxxxxxstatusfldt() {
		return this.z2xxcztxlxxxxxxxxxxxstatusfldt;
	}

	public void setZ2xxcztxlxxxxxxxxxxxstatusfldt(
			Date z2xxcztxlxxxxxxxxxxxstatusfldt) {
		this.z2xxcztxlxxxxxxxxxxxstatusfldt = z2xxcztxlxxxxxxxxxxxstatusfldt;
	}

	@Column(name = "notes")
	public String getY3xxuxznbvxxxxxxxxxxnotes() {
		return this.y3xxuxznbvxxxxxxxxxxnotes;
	}

	public void setY3xxuxznbvxxxxxxxxxxnotes(String y3xxuxznbvxxxxxxxxxxnotes) {
		this.y3xxuxznbvxxxxxxxxxxnotes = y3xxuxznbvxxxxxxxxxxnotes;
	}

	@Column(name = "owner", length = 40)
	@Size(max = 40)
	public String getZ3xxutoxlhxxxxxxxxxxowner() {
		return this.z3xxutoxlhxxxxxxxxxxowner;
	}

	public void setZ3xxutoxlhxxxxxxxxxxowner(String z3xxutoxlhxxxxxxxxxxowner) {
		this.z3xxutoxlhxxxxxxxxxxowner = z3xxutoxlhxxxxxxxxxxowner;
	}

	@Column(name = "owner2", length = 40)
	@Size(max = 40)
	public String getZzxxu2oxxhxxxxxxxxxxowner2() {
		return this.zzxxu2oxxhxxxxxxxxxxowner2;
	}

	public void setZzxxu2oxxhxxxxxxxxxxowner2(String zzxxu2oxxhxxxxxxxxxxowner2) {
		this.zzxxu2oxxhxxxxxxxxxxowner2 = zzxxu2oxxhxxxxxxxxxxowner2;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "yxxxuq632xwwqqhxxxxxperioddates")
	public Set<Yxxxch65exwwqqhxxxxxglentries> getYxxxch65exwwqqhxxxxxglentrieses() {
		return this.yxxxch65exwwqqhxxxxxglentrieses;
	}

	public void setYxxxch65exwwqqhxxxxxglentrieses(
			Set<Yxxxch65exwwqqhxxxxxglentries> yxxxch65exwwqqhxxxxxglentrieses) {
		this.yxxxch65exwwqqhxxxxxglentrieses = yxxxch65exwwqqhxxxxxglentrieses;
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