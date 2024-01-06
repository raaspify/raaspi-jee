package com.rcomputer.genapp.model;
// Generated 1-Jan-2024 8:59:20 PM by Hibernate Tools 4.0.0

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
 * Yxxxiq555xwwqqhxxxxxholiday generated by hbm2java
 */
@Entity
@XmlRootElement
@Table(name = "holiday")
public class Yxxxiq555xwwqqhxxxxxholiday implements java.io.Serializable {

	private Integer a0xxuobxbxxxxxxxxxxxsid;
	private Dxxxiq155xwwqqhxxxxxresidency dxxxiq155xwwqqhxxxxxresidency;
	private Jxxxbh400xwwqqhxxxxxemployee jxxxbh400xwwqqhxxxxxemployee;
	private String a0xxukxxbvxxxxxxxxxxsholiday;
	private Date b1xxcsxxbvxxxxxxxxxxholiday;
	private String b2xxuszsbvxxxxxxxxxxdescript;
	private String b3xxuxxrbv48xxxxxxxxtype;
	private Integer z1xxzzfxhhxxxxxxxxxxstatusfl;
	private Date z2xxcztxlxxxxxxxxxxxstatusfldt;
	private String z2xxutoxlhxxxxxxxxxxowner;
	private String zzxxu2oxxhxxxxxxxxxxowner2;

	public Yxxxiq555xwwqqhxxxxxholiday() {
	}

	public Yxxxiq555xwwqqhxxxxxholiday(String a0xxukxxbvxxxxxxxxxxsholiday) {
		this.a0xxukxxbvxxxxxxxxxxsholiday = a0xxukxxbvxxxxxxxxxxsholiday;
	}
	public Yxxxiq555xwwqqhxxxxxholiday(
			Dxxxiq155xwwqqhxxxxxresidency dxxxiq155xwwqqhxxxxxresidency,
			Jxxxbh400xwwqqhxxxxxemployee jxxxbh400xwwqqhxxxxxemployee,
			String a0xxukxxbvxxxxxxxxxxsholiday,
			Date b1xxcsxxbvxxxxxxxxxxholiday,
			String b2xxuszsbvxxxxxxxxxxdescript,
			String b3xxuxxrbv48xxxxxxxxtype,
			Integer z1xxzzfxhhxxxxxxxxxxstatusfl,
			Date z2xxcztxlxxxxxxxxxxxstatusfldt,
			String z2xxutoxlhxxxxxxxxxxowner, String zzxxu2oxxhxxxxxxxxxxowner2) {
		this.dxxxiq155xwwqqhxxxxxresidency = dxxxiq155xwwqqhxxxxxresidency;
		this.jxxxbh400xwwqqhxxxxxemployee = jxxxbh400xwwqqhxxxxxemployee;
		this.a0xxukxxbvxxxxxxxxxxsholiday = a0xxukxxbvxxxxxxxxxxsholiday;
		this.b1xxcsxxbvxxxxxxxxxxholiday = b1xxcsxxbvxxxxxxxxxxholiday;
		this.b2xxuszsbvxxxxxxxxxxdescript = b2xxuszsbvxxxxxxxxxxdescript;
		this.b3xxuxxrbv48xxxxxxxxtype = b3xxuxxrbv48xxxxxxxxtype;
		this.z1xxzzfxhhxxxxxxxxxxstatusfl = z1xxzzfxhhxxxxxxxxxxstatusfl;
		this.z2xxcztxlxxxxxxxxxxxstatusfldt = z2xxcztxlxxxxxxxxxxxstatusfldt;
		this.z2xxutoxlhxxxxxxxxxxowner = z2xxutoxlhxxxxxxxxxxowner;
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

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "residency")
	public Dxxxiq155xwwqqhxxxxxresidency getDxxxiq155xwwqqhxxxxxresidency() {
		return this.dxxxiq155xwwqqhxxxxxresidency;
	}

	public void setDxxxiq155xwwqqhxxxxxresidency(
			Dxxxiq155xwwqqhxxxxxresidency dxxxiq155xwwqqhxxxxxresidency) {
		this.dxxxiq155xwwqqhxxxxxresidency = dxxxiq155xwwqqhxxxxxresidency;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "employee")
	public Jxxxbh400xwwqqhxxxxxemployee getJxxxbh400xwwqqhxxxxxemployee() {
		return this.jxxxbh400xwwqqhxxxxxemployee;
	}

	public void setJxxxbh400xwwqqhxxxxxemployee(
			Jxxxbh400xwwqqhxxxxxemployee jxxxbh400xwwqqhxxxxxemployee) {
		this.jxxxbh400xwwqqhxxxxxemployee = jxxxbh400xwwqqhxxxxxemployee;
	}

	@Column(name = "sholiday", nullable = false, length = 32)
	@NotNull
	@Size(max = 32)
	public String getA0xxukxxbvxxxxxxxxxxsholiday() {
		return this.a0xxukxxbvxxxxxxxxxxsholiday;
	}

	public void setA0xxukxxbvxxxxxxxxxxsholiday(
			String a0xxukxxbvxxxxxxxxxxsholiday) {
		this.a0xxukxxbvxxxxxxxxxxsholiday = a0xxukxxbvxxxxxxxxxxsholiday;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "holiday", length = 29)
	public Date getB1xxcsxxbvxxxxxxxxxxholiday() {
		return this.b1xxcsxxbvxxxxxxxxxxholiday;
	}

	public void setB1xxcsxxbvxxxxxxxxxxholiday(Date b1xxcsxxbvxxxxxxxxxxholiday) {
		this.b1xxcsxxbvxxxxxxxxxxholiday = b1xxcsxxbvxxxxxxxxxxholiday;
	}

	@Column(name = "descript", length = 120)
	@Size(max = 120)
	public String getB2xxuszsbvxxxxxxxxxxdescript() {
		return this.b2xxuszsbvxxxxxxxxxxdescript;
	}

	public void setB2xxuszsbvxxxxxxxxxxdescript(
			String b2xxuszsbvxxxxxxxxxxdescript) {
		this.b2xxuszsbvxxxxxxxxxxdescript = b2xxuszsbvxxxxxxxxxxdescript;
	}

	@Column(name = "type", length = 12)
	@Size(max = 12)
	public String getB3xxuxxrbv48xxxxxxxxtype() {
		return this.b3xxuxxrbv48xxxxxxxxtype;
	}

	public void setB3xxuxxrbv48xxxxxxxxtype(String b3xxuxxrbv48xxxxxxxxtype) {
		this.b3xxuxxrbv48xxxxxxxxtype = b3xxuxxrbv48xxxxxxxxtype;
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

	@Column(name = "owner", length = 40)
	@Size(max = 40)
	public String getZ2xxutoxlhxxxxxxxxxxowner() {
		return this.z2xxutoxlhxxxxxxxxxxowner;
	}

	public void setZ2xxutoxlhxxxxxxxxxxowner(String z2xxutoxlhxxxxxxxxxxowner) {
		this.z2xxutoxlhxxxxxxxxxxowner = z2xxutoxlhxxxxxxxxxxowner;
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
