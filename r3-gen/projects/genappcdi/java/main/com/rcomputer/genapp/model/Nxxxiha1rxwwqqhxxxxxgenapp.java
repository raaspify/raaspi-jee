package com.rcomputer.genapp.model;
// Generated 11-Jul-2023 11:51:00 AM by Hibernate Tools 4.0.0

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
 * Nxxxiha1rxwwqqhxxxxxgenapp generated by hbm2java
 */
@Entity
@XmlRootElement
@Table(name = "rgenapp")
public class Nxxxiha1rxwwqqhxxxxxgenapp implements java.io.Serializable {

	private Integer a0xxuobxbxxxxxxxxxxxsid;
	private String a0xxukxxbvxxxxxxxxxxappname;
	private String a1xxfxxxbvxxxxxxxxxxdescript;
	private String a1xxfxxxbvxxxxxxxxxxapptype;
	private Boolean a1xxfwxxbvxxxxxxxxxxappwaccounting;
	private Boolean a1xxfemxbvxxxxxxxxxxappwemail;
	private Boolean a1xxfjmxbvxxxxxxxxxxappwjmsmq;
	private String b1xxfxxxbvxxappxxxxxxxxvendor;
	private String b3xxfxxxbvxxxxxxxxxxappversion;
	private String b5xxfxxxbvxxxxxxxxxxappplatform;
	private String b6xxfxxxbvxxxxxxxxxxappmodelpkg;
	private String b7xxfxxxbvxxxxxxxxxxappactionpkg;
	private String b8xxfxxxbvxxxxxxxxxxappskin;
	private String b5xxfxxxbvxxxxxxxxxxappdeploytype;
	private String b7xxuxxxbvxxxxxxxxxxcreatefidata;
	private String b7xxuxxxbvxxxxxxxxxxrevengdata;
	private String b7xxuxxxbvxxxxxxxxxxinitializefidata;
	private Integer zexxzzfxhhxxxxxxxxxxstatusfl;
	private Date zfxxcztxlxxxxxxxxxxxstatusfldt;
	private String zgxxuxznbvxxxxxxxxxxnotes;
	private String zhxxutoxlhxxxxxxxxxxowner;
	private String zzxxu2oxxhxxxxxxxxxxowner2;
	private Set<Nxxxiha2rxwwqqhxxxxxgendb> nxxxiha2rxwwqqhxxxxxgendbs = new HashSet<Nxxxiha2rxwwqqhxxxxxgendb>(
			0);

	public Nxxxiha1rxwwqqhxxxxxgenapp() {
	}

	public Nxxxiha1rxwwqqhxxxxxgenapp(String a0xxukxxbvxxxxxxxxxxappname) {
		this.a0xxukxxbvxxxxxxxxxxappname = a0xxukxxbvxxxxxxxxxxappname;
	}
	public Nxxxiha1rxwwqqhxxxxxgenapp(String a0xxukxxbvxxxxxxxxxxappname,
			String a1xxfxxxbvxxxxxxxxxxdescript,
			String a1xxfxxxbvxxxxxxxxxxapptype,
			Boolean a1xxfwxxbvxxxxxxxxxxappwaccounting,
			Boolean a1xxfemxbvxxxxxxxxxxappwemail,
			Boolean a1xxfjmxbvxxxxxxxxxxappwjmsmq,
			String b1xxfxxxbvxxappxxxxxxxxvendor,
			String b3xxfxxxbvxxxxxxxxxxappversion,
			String b5xxfxxxbvxxxxxxxxxxappplatform,
			String b6xxfxxxbvxxxxxxxxxxappmodelpkg,
			String b7xxfxxxbvxxxxxxxxxxappactionpkg,
			String b8xxfxxxbvxxxxxxxxxxappskin,
			String b5xxfxxxbvxxxxxxxxxxappdeploytype,
			String b7xxuxxxbvxxxxxxxxxxcreatefidata,
			String b7xxuxxxbvxxxxxxxxxxrevengdata,
			String b7xxuxxxbvxxxxxxxxxxinitializefidata,
			Integer zexxzzfxhhxxxxxxxxxxstatusfl,
			Date zfxxcztxlxxxxxxxxxxxstatusfldt,
			String zgxxuxznbvxxxxxxxxxxnotes, String zhxxutoxlhxxxxxxxxxxowner,
			String zzxxu2oxxhxxxxxxxxxxowner2,
			Set<Nxxxiha2rxwwqqhxxxxxgendb> nxxxiha2rxwwqqhxxxxxgendbs) {
		this.a0xxukxxbvxxxxxxxxxxappname = a0xxukxxbvxxxxxxxxxxappname;
		this.a1xxfxxxbvxxxxxxxxxxdescript = a1xxfxxxbvxxxxxxxxxxdescript;
		this.a1xxfxxxbvxxxxxxxxxxapptype = a1xxfxxxbvxxxxxxxxxxapptype;
		this.a1xxfwxxbvxxxxxxxxxxappwaccounting = a1xxfwxxbvxxxxxxxxxxappwaccounting;
		this.a1xxfemxbvxxxxxxxxxxappwemail = a1xxfemxbvxxxxxxxxxxappwemail;
		this.a1xxfjmxbvxxxxxxxxxxappwjmsmq = a1xxfjmxbvxxxxxxxxxxappwjmsmq;
		this.b1xxfxxxbvxxappxxxxxxxxvendor = b1xxfxxxbvxxappxxxxxxxxvendor;
		this.b3xxfxxxbvxxxxxxxxxxappversion = b3xxfxxxbvxxxxxxxxxxappversion;
		this.b5xxfxxxbvxxxxxxxxxxappplatform = b5xxfxxxbvxxxxxxxxxxappplatform;
		this.b6xxfxxxbvxxxxxxxxxxappmodelpkg = b6xxfxxxbvxxxxxxxxxxappmodelpkg;
		this.b7xxfxxxbvxxxxxxxxxxappactionpkg = b7xxfxxxbvxxxxxxxxxxappactionpkg;
		this.b8xxfxxxbvxxxxxxxxxxappskin = b8xxfxxxbvxxxxxxxxxxappskin;
		this.b5xxfxxxbvxxxxxxxxxxappdeploytype = b5xxfxxxbvxxxxxxxxxxappdeploytype;
		this.b7xxuxxxbvxxxxxxxxxxcreatefidata = b7xxuxxxbvxxxxxxxxxxcreatefidata;
		this.b7xxuxxxbvxxxxxxxxxxrevengdata = b7xxuxxxbvxxxxxxxxxxrevengdata;
		this.b7xxuxxxbvxxxxxxxxxxinitializefidata = b7xxuxxxbvxxxxxxxxxxinitializefidata;
		this.zexxzzfxhhxxxxxxxxxxstatusfl = zexxzzfxhhxxxxxxxxxxstatusfl;
		this.zfxxcztxlxxxxxxxxxxxstatusfldt = zfxxcztxlxxxxxxxxxxxstatusfldt;
		this.zgxxuxznbvxxxxxxxxxxnotes = zgxxuxznbvxxxxxxxxxxnotes;
		this.zhxxutoxlhxxxxxxxxxxowner = zhxxutoxlhxxxxxxxxxxowner;
		this.zzxxu2oxxhxxxxxxxxxxowner2 = zzxxu2oxxhxxxxxxxxxxowner2;
		this.nxxxiha2rxwwqqhxxxxxgendbs = nxxxiha2rxwwqqhxxxxxgendbs;
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

	@Column(name = "appname", nullable = false, length = 40)
	@NotNull
	@Size(max = 40)
	public String getA0xxukxxbvxxxxxxxxxxappname() {
		return this.a0xxukxxbvxxxxxxxxxxappname;
	}

	public void setA0xxukxxbvxxxxxxxxxxappname(
			String a0xxukxxbvxxxxxxxxxxappname) {
		this.a0xxukxxbvxxxxxxxxxxappname = a0xxukxxbvxxxxxxxxxxappname;
	}

	@Column(name = "descript", length = 120)
	@Size(max = 120)
	public String getA1xxfxxxbvxxxxxxxxxxdescript() {
		return this.a1xxfxxxbvxxxxxxxxxxdescript;
	}

	public void setA1xxfxxxbvxxxxxxxxxxdescript(
			String a1xxfxxxbvxxxxxxxxxxdescript) {
		this.a1xxfxxxbvxxxxxxxxxxdescript = a1xxfxxxbvxxxxxxxxxxdescript;
	}

	@Column(name = "apptype", length = 20)
	@Size(max = 20)
	public String getA1xxfxxxbvxxxxxxxxxxapptype() {
		return this.a1xxfxxxbvxxxxxxxxxxapptype;
	}

	public void setA1xxfxxxbvxxxxxxxxxxapptype(
			String a1xxfxxxbvxxxxxxxxxxapptype) {
		this.a1xxfxxxbvxxxxxxxxxxapptype = a1xxfxxxbvxxxxxxxxxxapptype;
	}

	@Column(name = "appwaccounting")
	public Boolean getA1xxfwxxbvxxxxxxxxxxappwaccounting() {
		return this.a1xxfwxxbvxxxxxxxxxxappwaccounting;
	}

	public void setA1xxfwxxbvxxxxxxxxxxappwaccounting(
			Boolean a1xxfwxxbvxxxxxxxxxxappwaccounting) {
		this.a1xxfwxxbvxxxxxxxxxxappwaccounting = a1xxfwxxbvxxxxxxxxxxappwaccounting;
	}

	@Column(name = "appwemail")
	public Boolean getA1xxfemxbvxxxxxxxxxxappwemail() {
		return this.a1xxfemxbvxxxxxxxxxxappwemail;
	}

	public void setA1xxfemxbvxxxxxxxxxxappwemail(
			Boolean a1xxfemxbvxxxxxxxxxxappwemail) {
		this.a1xxfemxbvxxxxxxxxxxappwemail = a1xxfemxbvxxxxxxxxxxappwemail;
	}

	@Column(name = "appwjmsmq")
	public Boolean getA1xxfjmxbvxxxxxxxxxxappwjmsmq() {
		return this.a1xxfjmxbvxxxxxxxxxxappwjmsmq;
	}

	public void setA1xxfjmxbvxxxxxxxxxxappwjmsmq(
			Boolean a1xxfjmxbvxxxxxxxxxxappwjmsmq) {
		this.a1xxfjmxbvxxxxxxxxxxappwjmsmq = a1xxfjmxbvxxxxxxxxxxappwjmsmq;
	}

	@Column(name = "appvendor", length = 20)
	@Size(max = 20)
	public String getB1xxfxxxbvxxappxxxxxxxxvendor() {
		return this.b1xxfxxxbvxxappxxxxxxxxvendor;
	}

	public void setB1xxfxxxbvxxappxxxxxxxxvendor(
			String b1xxfxxxbvxxappxxxxxxxxvendor) {
		this.b1xxfxxxbvxxappxxxxxxxxvendor = b1xxfxxxbvxxappxxxxxxxxvendor;
	}

	@Column(name = "appversion", length = 20)
	@Size(max = 20)
	public String getB3xxfxxxbvxxxxxxxxxxappversion() {
		return this.b3xxfxxxbvxxxxxxxxxxappversion;
	}

	public void setB3xxfxxxbvxxxxxxxxxxappversion(
			String b3xxfxxxbvxxxxxxxxxxappversion) {
		this.b3xxfxxxbvxxxxxxxxxxappversion = b3xxfxxxbvxxxxxxxxxxappversion;
	}

	@Column(name = "appplatform", length = 40)
	@Size(max = 40)
	public String getB5xxfxxxbvxxxxxxxxxxappplatform() {
		return this.b5xxfxxxbvxxxxxxxxxxappplatform;
	}

	public void setB5xxfxxxbvxxxxxxxxxxappplatform(
			String b5xxfxxxbvxxxxxxxxxxappplatform) {
		this.b5xxfxxxbvxxxxxxxxxxappplatform = b5xxfxxxbvxxxxxxxxxxappplatform;
	}

	@Column(name = "appmodelpkg", length = 40)
	@Size(max = 40)
	public String getB6xxfxxxbvxxxxxxxxxxappmodelpkg() {
		return this.b6xxfxxxbvxxxxxxxxxxappmodelpkg;
	}

	public void setB6xxfxxxbvxxxxxxxxxxappmodelpkg(
			String b6xxfxxxbvxxxxxxxxxxappmodelpkg) {
		this.b6xxfxxxbvxxxxxxxxxxappmodelpkg = b6xxfxxxbvxxxxxxxxxxappmodelpkg;
	}

	@Column(name = "appactionpkg", length = 40)
	@Size(max = 40)
	public String getB7xxfxxxbvxxxxxxxxxxappactionpkg() {
		return this.b7xxfxxxbvxxxxxxxxxxappactionpkg;
	}

	public void setB7xxfxxxbvxxxxxxxxxxappactionpkg(
			String b7xxfxxxbvxxxxxxxxxxappactionpkg) {
		this.b7xxfxxxbvxxxxxxxxxxappactionpkg = b7xxfxxxbvxxxxxxxxxxappactionpkg;
	}

	@Column(name = "appskin", length = 20)
	@Size(max = 20)
	public String getB8xxfxxxbvxxxxxxxxxxappskin() {
		return this.b8xxfxxxbvxxxxxxxxxxappskin;
	}

	public void setB8xxfxxxbvxxxxxxxxxxappskin(
			String b8xxfxxxbvxxxxxxxxxxappskin) {
		this.b8xxfxxxbvxxxxxxxxxxappskin = b8xxfxxxbvxxxxxxxxxxappskin;
	}

	@Column(name = "appdeploytype", length = 20)
	@Size(max = 20)
	public String getB5xxfxxxbvxxxxxxxxxxappdeploytype() {
		return this.b5xxfxxxbvxxxxxxxxxxappdeploytype;
	}

	public void setB5xxfxxxbvxxxxxxxxxxappdeploytype(
			String b5xxfxxxbvxxxxxxxxxxappdeploytype) {
		this.b5xxfxxxbvxxxxxxxxxxappdeploytype = b5xxfxxxbvxxxxxxxxxxappdeploytype;
	}

	@Column(name = "createfidata", length = 4096000)
	@Size(max = 4096000)
	public String getB7xxuxxxbvxxxxxxxxxxcreatefidata() {
		return this.b7xxuxxxbvxxxxxxxxxxcreatefidata;
	}

	public void setB7xxuxxxbvxxxxxxxxxxcreatefidata(
			String b7xxuxxxbvxxxxxxxxxxcreatefidata) {
		this.b7xxuxxxbvxxxxxxxxxxcreatefidata = b7xxuxxxbvxxxxxxxxxxcreatefidata;
	}

	@Column(name = "revengdata", length = 4096000)
	@Size(max = 4096000)
	public String getB7xxuxxxbvxxxxxxxxxxrevengdata() {
		return this.b7xxuxxxbvxxxxxxxxxxrevengdata;
	}

	public void setB7xxuxxxbvxxxxxxxxxxrevengdata(
			String b7xxuxxxbvxxxxxxxxxxrevengdata) {
		this.b7xxuxxxbvxxxxxxxxxxrevengdata = b7xxuxxxbvxxxxxxxxxxrevengdata;
	}

	@Column(name = "initializefidata", length = 4096000)
	@Size(max = 4096000)
	public String getB7xxuxxxbvxxxxxxxxxxinitializefidata() {
		return this.b7xxuxxxbvxxxxxxxxxxinitializefidata;
	}

	public void setB7xxuxxxbvxxxxxxxxxxinitializefidata(
			String b7xxuxxxbvxxxxxxxxxxinitializefidata) {
		this.b7xxuxxxbvxxxxxxxxxxinitializefidata = b7xxuxxxbvxxxxxxxxxxinitializefidata;
	}

	@Column(name = "statusfl")
	public Integer getZexxzzfxhhxxxxxxxxxxstatusfl() {
		return this.zexxzzfxhhxxxxxxxxxxstatusfl;
	}

	public void setZexxzzfxhhxxxxxxxxxxstatusfl(
			Integer zexxzzfxhhxxxxxxxxxxstatusfl) {
		this.zexxzzfxhhxxxxxxxxxxstatusfl = zexxzzfxhhxxxxxxxxxxstatusfl;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "statusfldt", length = 29)
	public Date getZfxxcztxlxxxxxxxxxxxstatusfldt() {
		return this.zfxxcztxlxxxxxxxxxxxstatusfldt;
	}

	public void setZfxxcztxlxxxxxxxxxxxstatusfldt(
			Date zfxxcztxlxxxxxxxxxxxstatusfldt) {
		this.zfxxcztxlxxxxxxxxxxxstatusfldt = zfxxcztxlxxxxxxxxxxxstatusfldt;
	}

	@Column(name = "notes", length = 60)
	@Size(max = 60)
	public String getZgxxuxznbvxxxxxxxxxxnotes() {
		return this.zgxxuxznbvxxxxxxxxxxnotes;
	}

	public void setZgxxuxznbvxxxxxxxxxxnotes(String zgxxuxznbvxxxxxxxxxxnotes) {
		this.zgxxuxznbvxxxxxxxxxxnotes = zgxxuxznbvxxxxxxxxxxnotes;
	}

	@Column(name = "owner", length = 40)
	@Size(max = 40)
	public String getZhxxutoxlhxxxxxxxxxxowner() {
		return this.zhxxutoxlhxxxxxxxxxxowner;
	}

	public void setZhxxutoxlhxxxxxxxxxxowner(String zhxxutoxlhxxxxxxxxxxowner) {
		this.zhxxutoxlhxxxxxxxxxxowner = zhxxutoxlhxxxxxxxxxxowner;
	}

	@Column(name = "owner2", length = 40)
	@Size(max = 40)
	public String getZzxxu2oxxhxxxxxxxxxxowner2() {
		return this.zzxxu2oxxhxxxxxxxxxxowner2;
	}

	public void setZzxxu2oxxhxxxxxxxxxxowner2(String zzxxu2oxxhxxxxxxxxxxowner2) {
		this.zzxxu2oxxhxxxxxxxxxxowner2 = zzxxu2oxxhxxxxxxxxxxowner2;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "nxxxiha1rxwwqqhxxxxxgenapp")
	public Set<Nxxxiha2rxwwqqhxxxxxgendb> getNxxxiha2rxwwqqhxxxxxgendbs() {
		return this.nxxxiha2rxwwqqhxxxxxgendbs;
	}

	public void setNxxxiha2rxwwqqhxxxxxgendbs(
			Set<Nxxxiha2rxwwqqhxxxxxgendb> nxxxiha2rxwwqqhxxxxxgendbs) {
		this.nxxxiha2rxwwqqhxxxxxgendbs = nxxxiha2rxwwqqhxxxxxgendbs;
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
