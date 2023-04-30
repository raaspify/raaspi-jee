package com.rcomputer.genapp.model;
// Generated 13-Apr-2023 9:07:31 PM by Hibernate Tools 4.0.0

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
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
 * Yxxxch621xwwqqhxxxxxacperiod generated by hbm2java
 */
@Entity
@XmlRootElement
@Table(name = "acperiod")
public class Yxxxch621xwwqqhxxxxxacperiod implements java.io.Serializable {

	private Integer a0xxuobxbxxxxxxxxxxxsid;
	private String a0xxukwpbv47xxxxxxxxrowid;
	private String a1xxuxwpbv47xxxxxxxxcurrperiod;
	private String b1xxuxzsbvxxxxxxxxxxdescript;
	private Date b2xxdwerbvxxxxxxxxxxcurrbusdate;
	private Date b3xxdwerbvxxxxxxxxxxcurrcaldate;
	private Date b4xxdwerbvxxxxxxxxxxcurrlocaldate;
	private Integer z1xxzzfxhhxxxxxxxxxxstatusfl;
	private Date z2xxcztxlxxxxxxxxxxxstatusfldt;
	private String y3xxuznxbvxxxxxxxxxxnotes;
	private String z3xxutoxlhxxxxxxxxxxowner;
	private String zzxxu2oxxhxxxxxxxxxxowner2;

	public Yxxxch621xwwqqhxxxxxacperiod() {
	}

	public Yxxxch621xwwqqhxxxxxacperiod(String a0xxukwpbv47xxxxxxxxrowid) {
		this.a0xxukwpbv47xxxxxxxxrowid = a0xxukwpbv47xxxxxxxxrowid;
	}
	public Yxxxch621xwwqqhxxxxxacperiod(String a0xxukwpbv47xxxxxxxxrowid,
			String a1xxuxwpbv47xxxxxxxxcurrperiod,
			String b1xxuxzsbvxxxxxxxxxxdescript,
			Date b2xxdwerbvxxxxxxxxxxcurrbusdate,
			Date b3xxdwerbvxxxxxxxxxxcurrcaldate,
			Date b4xxdwerbvxxxxxxxxxxcurrlocaldate,
			Integer z1xxzzfxhhxxxxxxxxxxstatusfl,
			Date z2xxcztxlxxxxxxxxxxxstatusfldt,
			String y3xxuznxbvxxxxxxxxxxnotes, String z3xxutoxlhxxxxxxxxxxowner,
			String zzxxu2oxxhxxxxxxxxxxowner2) {
		this.a0xxukwpbv47xxxxxxxxrowid = a0xxukwpbv47xxxxxxxxrowid;
		this.a1xxuxwpbv47xxxxxxxxcurrperiod = a1xxuxwpbv47xxxxxxxxcurrperiod;
		this.b1xxuxzsbvxxxxxxxxxxdescript = b1xxuxzsbvxxxxxxxxxxdescript;
		this.b2xxdwerbvxxxxxxxxxxcurrbusdate = b2xxdwerbvxxxxxxxxxxcurrbusdate;
		this.b3xxdwerbvxxxxxxxxxxcurrcaldate = b3xxdwerbvxxxxxxxxxxcurrcaldate;
		this.b4xxdwerbvxxxxxxxxxxcurrlocaldate = b4xxdwerbvxxxxxxxxxxcurrlocaldate;
		this.z1xxzzfxhhxxxxxxxxxxstatusfl = z1xxzzfxhhxxxxxxxxxxstatusfl;
		this.z2xxcztxlxxxxxxxxxxxstatusfldt = z2xxcztxlxxxxxxxxxxxstatusfldt;
		this.y3xxuznxbvxxxxxxxxxxnotes = y3xxuznxbvxxxxxxxxxxnotes;
		this.z3xxutoxlhxxxxxxxxxxowner = z3xxutoxlhxxxxxxxxxxowner;
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

	@Column(name = "rowid", nullable = false, length = 2)
	@NotNull
	@Size(max = 2)
	public String getA0xxukwpbv47xxxxxxxxrowid() {
		return this.a0xxukwpbv47xxxxxxxxrowid;
	}

	public void setA0xxukwpbv47xxxxxxxxrowid(String a0xxukwpbv47xxxxxxxxrowid) {
		this.a0xxukwpbv47xxxxxxxxrowid = a0xxukwpbv47xxxxxxxxrowid;
	}

	@Column(name = "currperiod", length = 2)
	@Size(max = 2)
	public String getA1xxuxwpbv47xxxxxxxxcurrperiod() {
		return this.a1xxuxwpbv47xxxxxxxxcurrperiod;
	}

	public void setA1xxuxwpbv47xxxxxxxxcurrperiod(
			String a1xxuxwpbv47xxxxxxxxcurrperiod) {
		this.a1xxuxwpbv47xxxxxxxxcurrperiod = a1xxuxwpbv47xxxxxxxxcurrperiod;
	}

	@Column(name = "descript", length = 120)
	@Size(max = 120)
	public String getB1xxuxzsbvxxxxxxxxxxdescript() {
		return this.b1xxuxzsbvxxxxxxxxxxdescript;
	}

	public void setB1xxuxzsbvxxxxxxxxxxdescript(
			String b1xxuxzsbvxxxxxxxxxxdescript) {
		this.b1xxuxzsbvxxxxxxxxxxdescript = b1xxuxzsbvxxxxxxxxxxdescript;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "currbusdate", length = 29)
	public Date getB2xxdwerbvxxxxxxxxxxcurrbusdate() {
		return this.b2xxdwerbvxxxxxxxxxxcurrbusdate;
	}

	public void setB2xxdwerbvxxxxxxxxxxcurrbusdate(
			Date b2xxdwerbvxxxxxxxxxxcurrbusdate) {
		this.b2xxdwerbvxxxxxxxxxxcurrbusdate = b2xxdwerbvxxxxxxxxxxcurrbusdate;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "currcaldate", length = 29)
	public Date getB3xxdwerbvxxxxxxxxxxcurrcaldate() {
		return this.b3xxdwerbvxxxxxxxxxxcurrcaldate;
	}

	public void setB3xxdwerbvxxxxxxxxxxcurrcaldate(
			Date b3xxdwerbvxxxxxxxxxxcurrcaldate) {
		this.b3xxdwerbvxxxxxxxxxxcurrcaldate = b3xxdwerbvxxxxxxxxxxcurrcaldate;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "currlocaldate", length = 29)
	public Date getB4xxdwerbvxxxxxxxxxxcurrlocaldate() {
		return this.b4xxdwerbvxxxxxxxxxxcurrlocaldate;
	}

	public void setB4xxdwerbvxxxxxxxxxxcurrlocaldate(
			Date b4xxdwerbvxxxxxxxxxxcurrlocaldate) {
		this.b4xxdwerbvxxxxxxxxxxcurrlocaldate = b4xxdwerbvxxxxxxxxxxcurrlocaldate;
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
	public String getY3xxuznxbvxxxxxxxxxxnotes() {
		return this.y3xxuznxbvxxxxxxxxxxnotes;
	}

	public void setY3xxuznxbvxxxxxxxxxxnotes(String y3xxuznxbvxxxxxxxxxxnotes) {
		this.y3xxuznxbvxxxxxxxxxxnotes = y3xxuznxbvxxxxxxxxxxnotes;
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
