package com.rcomputer.genapp.model;
// Generated 30-Jun-2023 1:54:00 PM by Hibernate Tools 4.0.0

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
 * Yxxxuq1n1xwwqqqxxxxxblobdata generated by hbm2java
 */
@Entity
@XmlRootElement
@Table(name = "blobdata")
public class Yxxxuq1n1xwwqqqxxxxxblobdata implements java.io.Serializable {

	private Integer a0xxuobxbxxxxxxxxxxxsid;
	private String a0xxukbdlvxxxxxxxxxxfromtable;
	private String a1xxuxxxbv49xxxxxxxxfromkey;
	private String a2xxuxxxbv50xxxxxxxxqualifier;
	private Integer a3xxexnsbvxxxxxxxxxxsequence;
	private String a4xxexxxbvxxxxxxxxxxtype;
	private byte[] b1xxuzbxbvxxxxxxxxxxdata;
	private Integer z1xxzzfxhhxxxxxxxxxxstatusfl;
	private Date z2xxcztxlxxxxxxxxxxxstatusfldt;
	private String y3xxuxznbvxxxxxxxxxxnotes;
	private String z3xxutoxlhxxxxxxxxxxowner;
	private String zzxxu2oxxhxxxxxxxxxxowner2;

	public Yxxxuq1n1xwwqqqxxxxxblobdata() {
	}

	public Yxxxuq1n1xwwqqqxxxxxblobdata(String a0xxukbdlvxxxxxxxxxxfromtable,
			String a1xxuxxxbv49xxxxxxxxfromkey,
			String a2xxuxxxbv50xxxxxxxxqualifier) {
		this.a0xxukbdlvxxxxxxxxxxfromtable = a0xxukbdlvxxxxxxxxxxfromtable;
		this.a1xxuxxxbv49xxxxxxxxfromkey = a1xxuxxxbv49xxxxxxxxfromkey;
		this.a2xxuxxxbv50xxxxxxxxqualifier = a2xxuxxxbv50xxxxxxxxqualifier;
	}
	public Yxxxuq1n1xwwqqqxxxxxblobdata(String a0xxukbdlvxxxxxxxxxxfromtable,
			String a1xxuxxxbv49xxxxxxxxfromkey,
			String a2xxuxxxbv50xxxxxxxxqualifier,
			Integer a3xxexnsbvxxxxxxxxxxsequence,
			String a4xxexxxbvxxxxxxxxxxtype, byte[] b1xxuzbxbvxxxxxxxxxxdata,
			Integer z1xxzzfxhhxxxxxxxxxxstatusfl,
			Date z2xxcztxlxxxxxxxxxxxstatusfldt,
			String y3xxuxznbvxxxxxxxxxxnotes, String z3xxutoxlhxxxxxxxxxxowner,
			String zzxxu2oxxhxxxxxxxxxxowner2) {
		this.a0xxukbdlvxxxxxxxxxxfromtable = a0xxukbdlvxxxxxxxxxxfromtable;
		this.a1xxuxxxbv49xxxxxxxxfromkey = a1xxuxxxbv49xxxxxxxxfromkey;
		this.a2xxuxxxbv50xxxxxxxxqualifier = a2xxuxxxbv50xxxxxxxxqualifier;
		this.a3xxexnsbvxxxxxxxxxxsequence = a3xxexnsbvxxxxxxxxxxsequence;
		this.a4xxexxxbvxxxxxxxxxxtype = a4xxexxxbvxxxxxxxxxxtype;
		this.b1xxuzbxbvxxxxxxxxxxdata = b1xxuzbxbvxxxxxxxxxxdata;
		this.z1xxzzfxhhxxxxxxxxxxstatusfl = z1xxzzfxhhxxxxxxxxxxstatusfl;
		this.z2xxcztxlxxxxxxxxxxxstatusfldt = z2xxcztxlxxxxxxxxxxxstatusfldt;
		this.y3xxuxznbvxxxxxxxxxxnotes = y3xxuxznbvxxxxxxxxxxnotes;
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

	@Column(name = "fromtable", nullable = false, length = 35)
	@NotNull
	@Size(max = 35)
	public String getA0xxukbdlvxxxxxxxxxxfromtable() {
		return this.a0xxukbdlvxxxxxxxxxxfromtable;
	}

	public void setA0xxukbdlvxxxxxxxxxxfromtable(
			String a0xxukbdlvxxxxxxxxxxfromtable) {
		this.a0xxukbdlvxxxxxxxxxxfromtable = a0xxukbdlvxxxxxxxxxxfromtable;
	}

	@Column(name = "fromkey", nullable = false, length = 35)
	@NotNull
	@Size(max = 35)
	public String getA1xxuxxxbv49xxxxxxxxfromkey() {
		return this.a1xxuxxxbv49xxxxxxxxfromkey;
	}

	public void setA1xxuxxxbv49xxxxxxxxfromkey(
			String a1xxuxxxbv49xxxxxxxxfromkey) {
		this.a1xxuxxxbv49xxxxxxxxfromkey = a1xxuxxxbv49xxxxxxxxfromkey;
	}

	@Column(name = "qualifier", nullable = false, length = 32)
	@NotNull
	@Size(max = 32)
	public String getA2xxuxxxbv50xxxxxxxxqualifier() {
		return this.a2xxuxxxbv50xxxxxxxxqualifier;
	}

	public void setA2xxuxxxbv50xxxxxxxxqualifier(
			String a2xxuxxxbv50xxxxxxxxqualifier) {
		this.a2xxuxxxbv50xxxxxxxxqualifier = a2xxuxxxbv50xxxxxxxxqualifier;
	}

	@Column(name = "sequence")
	public Integer getA3xxexnsbvxxxxxxxxxxsequence() {
		return this.a3xxexnsbvxxxxxxxxxxsequence;
	}

	public void setA3xxexnsbvxxxxxxxxxxsequence(
			Integer a3xxexnsbvxxxxxxxxxxsequence) {
		this.a3xxexnsbvxxxxxxxxxxsequence = a3xxexnsbvxxxxxxxxxxsequence;
	}

	@Column(name = "type", length = 40)
	@Size(max = 40)
	public String getA4xxexxxbvxxxxxxxxxxtype() {
		return this.a4xxexxxbvxxxxxxxxxxtype;
	}

	public void setA4xxexxxbvxxxxxxxxxxtype(String a4xxexxxbvxxxxxxxxxxtype) {
		this.a4xxexxxbvxxxxxxxxxxtype = a4xxexxxbvxxxxxxxxxxtype;
	}

	@Column(name = "data")
	public byte[] getB1xxuzbxbvxxxxxxxxxxdata() {
		return this.b1xxuzbxbvxxxxxxxxxxdata;
	}

	public void setB1xxuzbxbvxxxxxxxxxxdata(byte[] b1xxuzbxbvxxxxxxxxxxdata) {
		this.b1xxuzbxbvxxxxxxxxxxdata = b1xxuzbxbvxxxxxxxxxxdata;
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
