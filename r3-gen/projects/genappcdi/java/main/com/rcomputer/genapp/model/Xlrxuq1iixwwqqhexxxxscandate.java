package com.rcomputer.genapp.model;
// Generated 9-May-2023 8:57:32 PM by Hibernate Tools 4.0.0

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
 * Xlrxuq1iixwwqqhexxxxscandate generated by hbm2java
 */
@Entity
@XmlRootElement
@Table(name = "scandate")
public class Xlrxuq1iixwwqqhexxxxscandate implements java.io.Serializable {

	private Integer a0xxuobxbxxxxxxxxxxxsid;
	private String a0xxukxrlvxxxxxxxxxxsdsatetimeofscan;
	private Date b1xxcsxraxxxxxxxxxxxdatetimeofscan;
	private Date z1xxcxxrlvxxxxxxxxxxlastdate;
	private Date z2xxcxxrlvxxxxxxxxxxbkupdate;
	private String z1xxutoxlhxxxxxxxxxxowner;
	private String zzxxu2oxxhxxxxxxxxxxowner2;

	public Xlrxuq1iixwwqqhexxxxscandate() {
	}

	public Xlrxuq1iixwwqqhexxxxscandate(
			String a0xxukxrlvxxxxxxxxxxsdsatetimeofscan) {
		this.a0xxukxrlvxxxxxxxxxxsdsatetimeofscan = a0xxukxrlvxxxxxxxxxxsdsatetimeofscan;
	}
	public Xlrxuq1iixwwqqhexxxxscandate(
			String a0xxukxrlvxxxxxxxxxxsdsatetimeofscan,
			Date b1xxcsxraxxxxxxxxxxxdatetimeofscan,
			Date z1xxcxxrlvxxxxxxxxxxlastdate,
			Date z2xxcxxrlvxxxxxxxxxxbkupdate,
			String z1xxutoxlhxxxxxxxxxxowner, String zzxxu2oxxhxxxxxxxxxxowner2) {
		this.a0xxukxrlvxxxxxxxxxxsdsatetimeofscan = a0xxukxrlvxxxxxxxxxxsdsatetimeofscan;
		this.b1xxcsxraxxxxxxxxxxxdatetimeofscan = b1xxcsxraxxxxxxxxxxxdatetimeofscan;
		this.z1xxcxxrlvxxxxxxxxxxlastdate = z1xxcxxrlvxxxxxxxxxxlastdate;
		this.z2xxcxxrlvxxxxxxxxxxbkupdate = z2xxcxxrlvxxxxxxxxxxbkupdate;
		this.z1xxutoxlhxxxxxxxxxxowner = z1xxutoxlhxxxxxxxxxxowner;
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

	@Column(name = "sdsatetimeofscan", nullable = false, length = 25)
	@NotNull
	@Size(max = 25)
	public String getA0xxukxrlvxxxxxxxxxxsdsatetimeofscan() {
		return this.a0xxukxrlvxxxxxxxxxxsdsatetimeofscan;
	}

	public void setA0xxukxrlvxxxxxxxxxxsdsatetimeofscan(
			String a0xxukxrlvxxxxxxxxxxsdsatetimeofscan) {
		this.a0xxukxrlvxxxxxxxxxxsdsatetimeofscan = a0xxukxrlvxxxxxxxxxxsdsatetimeofscan;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "datetimeofscan", length = 29)
	public Date getB1xxcsxraxxxxxxxxxxxdatetimeofscan() {
		return this.b1xxcsxraxxxxxxxxxxxdatetimeofscan;
	}

	public void setB1xxcsxraxxxxxxxxxxxdatetimeofscan(
			Date b1xxcsxraxxxxxxxxxxxdatetimeofscan) {
		this.b1xxcsxraxxxxxxxxxxxdatetimeofscan = b1xxcsxraxxxxxxxxxxxdatetimeofscan;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "lastdate", length = 29)
	public Date getZ1xxcxxrlvxxxxxxxxxxlastdate() {
		return this.z1xxcxxrlvxxxxxxxxxxlastdate;
	}

	public void setZ1xxcxxrlvxxxxxxxxxxlastdate(
			Date z1xxcxxrlvxxxxxxxxxxlastdate) {
		this.z1xxcxxrlvxxxxxxxxxxlastdate = z1xxcxxrlvxxxxxxxxxxlastdate;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "bkupdate", length = 29)
	public Date getZ2xxcxxrlvxxxxxxxxxxbkupdate() {
		return this.z2xxcxxrlvxxxxxxxxxxbkupdate;
	}

	public void setZ2xxcxxrlvxxxxxxxxxxbkupdate(
			Date z2xxcxxrlvxxxxxxxxxxbkupdate) {
		this.z2xxcxxrlvxxxxxxxxxxbkupdate = z2xxcxxrlvxxxxxxxxxxbkupdate;
	}

	@Column(name = "owner", length = 40)
	@Size(max = 40)
	public String getZ1xxutoxlhxxxxxxxxxxowner() {
		return this.z1xxutoxlhxxxxxxxxxxowner;
	}

	public void setZ1xxutoxlhxxxxxxxxxxowner(String z1xxutoxlhxxxxxxxxxxowner) {
		this.z1xxutoxlhxxxxxxxxxxowner = z1xxutoxlhxxxxxxxxxxowner;
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
