package com.rcomputer.genapp.model;
// Generated 9-May-2023 8:57:32 PM by Hibernate Tools 4.0.0

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
 * Xoxxuq9f4xwwqqhxxxxxprocessattributes generated by hbm2java
 */
@Entity
@XmlRootElement
@Table(name = "processattributes")
public class Xoxxuq9f4xwwqqhxxxxxprocessattributes
		implements
			java.io.Serializable {

	private Integer a0xxuobxbxxxxxxxxxxxsid;
	private Xxxxuq9ccxwwqqhxxxxxprocessdetails xxxxuq9ccxwwqqhxxxxxprocessdetails;
	private String a4xxuuxxbv19xxxxxxxxname;
	private String a9xxtxsolxxxxxxxxxxxvalue;
	private String a9xxtxsclxxxxxxxxxxxtype;
	private String a8xxuxxrlxxxxxxxxxxxrange;
	private Integer zaxxzxxxavxxxxxxxxxxstep;
	private Integer z1xxzzfxhhxxxxxxxxxxstatusfl;
	private Date z2xxcztxlxxxxxxxxxxxstatusfldt;
	private String yaxxzxxxavxxxxxxxxxxnotes;
	private String z4xxutoxlhxxxxxxxxxxowner;
	private String zzxxu2oxxhxxxxxxxxxxowner2;

	public Xoxxuq9f4xwwqqhxxxxxprocessattributes() {
	}

	public Xoxxuq9f4xwwqqhxxxxxprocessattributes(
			Xxxxuq9ccxwwqqhxxxxxprocessdetails xxxxuq9ccxwwqqhxxxxxprocessdetails) {
		this.xxxxuq9ccxwwqqhxxxxxprocessdetails = xxxxuq9ccxwwqqhxxxxxprocessdetails;
	}
	public Xoxxuq9f4xwwqqhxxxxxprocessattributes(
			Xxxxuq9ccxwwqqhxxxxxprocessdetails xxxxuq9ccxwwqqhxxxxxprocessdetails,
			String a4xxuuxxbv19xxxxxxxxname, String a9xxtxsolxxxxxxxxxxxvalue,
			String a9xxtxsclxxxxxxxxxxxtype, String a8xxuxxrlxxxxxxxxxxxrange,
			Integer zaxxzxxxavxxxxxxxxxxstep,
			Integer z1xxzzfxhhxxxxxxxxxxstatusfl,
			Date z2xxcztxlxxxxxxxxxxxstatusfldt,
			String yaxxzxxxavxxxxxxxxxxnotes, String z4xxutoxlhxxxxxxxxxxowner,
			String zzxxu2oxxhxxxxxxxxxxowner2) {
		this.xxxxuq9ccxwwqqhxxxxxprocessdetails = xxxxuq9ccxwwqqhxxxxxprocessdetails;
		this.a4xxuuxxbv19xxxxxxxxname = a4xxuuxxbv19xxxxxxxxname;
		this.a9xxtxsolxxxxxxxxxxxvalue = a9xxtxsolxxxxxxxxxxxvalue;
		this.a9xxtxsclxxxxxxxxxxxtype = a9xxtxsclxxxxxxxxxxxtype;
		this.a8xxuxxrlxxxxxxxxxxxrange = a8xxuxxrlxxxxxxxxxxxrange;
		this.zaxxzxxxavxxxxxxxxxxstep = zaxxzxxxavxxxxxxxxxxstep;
		this.z1xxzzfxhhxxxxxxxxxxstatusfl = z1xxzzfxhhxxxxxxxxxxstatusfl;
		this.z2xxcztxlxxxxxxxxxxxstatusfldt = z2xxcztxlxxxxxxxxxxxstatusfldt;
		this.yaxxzxxxavxxxxxxxxxxnotes = yaxxzxxxavxxxxxxxxxxnotes;
		this.z4xxutoxlhxxxxxxxxxxowner = z4xxutoxlhxxxxxxxxxxowner;
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
	@JoinColumn(name = "pdetails", nullable = false)
	@NotNull
	public Xxxxuq9ccxwwqqhxxxxxprocessdetails getXxxxuq9ccxwwqqhxxxxxprocessdetails() {
		return this.xxxxuq9ccxwwqqhxxxxxprocessdetails;
	}

	public void setXxxxuq9ccxwwqqhxxxxxprocessdetails(
			Xxxxuq9ccxwwqqhxxxxxprocessdetails xxxxuq9ccxwwqqhxxxxxprocessdetails) {
		this.xxxxuq9ccxwwqqhxxxxxprocessdetails = xxxxuq9ccxwwqqhxxxxxprocessdetails;
	}

	@Column(name = "name", length = 32)
	@Size(max = 32)
	public String getA4xxuuxxbv19xxxxxxxxname() {
		return this.a4xxuuxxbv19xxxxxxxxname;
	}

	public void setA4xxuuxxbv19xxxxxxxxname(String a4xxuuxxbv19xxxxxxxxname) {
		this.a4xxuuxxbv19xxxxxxxxname = a4xxuuxxbv19xxxxxxxxname;
	}

	@Column(name = "value", length = 32)
	@Size(max = 32)
	public String getA9xxtxsolxxxxxxxxxxxvalue() {
		return this.a9xxtxsolxxxxxxxxxxxvalue;
	}

	public void setA9xxtxsolxxxxxxxxxxxvalue(String a9xxtxsolxxxxxxxxxxxvalue) {
		this.a9xxtxsolxxxxxxxxxxxvalue = a9xxtxsolxxxxxxxxxxxvalue;
	}

	@Column(name = "type", length = 32)
	@Size(max = 32)
	public String getA9xxtxsclxxxxxxxxxxxtype() {
		return this.a9xxtxsclxxxxxxxxxxxtype;
	}

	public void setA9xxtxsclxxxxxxxxxxxtype(String a9xxtxsclxxxxxxxxxxxtype) {
		this.a9xxtxsclxxxxxxxxxxxtype = a9xxtxsclxxxxxxxxxxxtype;
	}

	@Column(name = "range", length = 32)
	@Size(max = 32)
	public String getA8xxuxxrlxxxxxxxxxxxrange() {
		return this.a8xxuxxrlxxxxxxxxxxxrange;
	}

	public void setA8xxuxxrlxxxxxxxxxxxrange(String a8xxuxxrlxxxxxxxxxxxrange) {
		this.a8xxuxxrlxxxxxxxxxxxrange = a8xxuxxrlxxxxxxxxxxxrange;
	}

	@Column(name = "step")
	public Integer getZaxxzxxxavxxxxxxxxxxstep() {
		return this.zaxxzxxxavxxxxxxxxxxstep;
	}

	public void setZaxxzxxxavxxxxxxxxxxstep(Integer zaxxzxxxavxxxxxxxxxxstep) {
		this.zaxxzxxxavxxxxxxxxxxstep = zaxxzxxxavxxxxxxxxxxstep;
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

	@Column(name = "notes", length = 60)
	@Size(max = 60)
	public String getYaxxzxxxavxxxxxxxxxxnotes() {
		return this.yaxxzxxxavxxxxxxxxxxnotes;
	}

	public void setYaxxzxxxavxxxxxxxxxxnotes(String yaxxzxxxavxxxxxxxxxxnotes) {
		this.yaxxzxxxavxxxxxxxxxxnotes = yaxxzxxxavxxxxxxxxxxnotes;
	}

	@Column(name = "owner", length = 40)
	@Size(max = 40)
	public String getZ4xxutoxlhxxxxxxxxxxowner() {
		return this.z4xxutoxlhxxxxxxxxxxowner;
	}

	public void setZ4xxutoxlhxxxxxxxxxxowner(String z4xxutoxlhxxxxxxxxxxowner) {
		this.z4xxutoxlhxxxxxxxxxxowner = z4xxutoxlhxxxxxxxxxxowner;
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
