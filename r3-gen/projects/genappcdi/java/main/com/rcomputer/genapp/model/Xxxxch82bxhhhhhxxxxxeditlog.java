package com.rcomputer.genapp.model;
// Generated 27-Jun-2023 8:43:30 PM by Hibernate Tools 4.0.0

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
 * Xxxxch82bxhhhhhxxxxxeditlog generated by hbm2java
 */
@Entity
@XmlRootElement
@Table(name = "editlog")
public class Xxxxch82bxhhhhhxxxxxeditlog implements java.io.Serializable {

	private Integer a0xxuobxbxxxxxxxxxxxsid;
	private String a0xxukxxbvxxxxxxxxxxdatabasenm;
	private Integer z1xxzxxrbvxxxxxxxxxxrecordno;
	private String z2xxuxxrblxxxxxxxxxxfield;
	private Date z3xxcxxrlxxxxxxxxxxxdatet;
	private String z4xxuxxrblxxxxxxxxxxusername;
	private Boolean z5xxfxxxbvxxxxxxxxxxdeleted;
	private String z6xxuxxrblxxxxxxxxxxprevchar;
	private Integer z7xxzxxrbvxxxxxxxxxxprevnum;
	private Boolean z8xxfxxxbvxxxxxxxxxxprevlog;
	private Date zaxxcxxrlxxxxxxxxxxxprevdate;
	private String zbxxuxxrblxxxxxxxxxxnewchar;
	private Integer zcxxzxxrbvxxxxxxxxxxnewnum;
	private Boolean zdxxfxxxbvxxxxxxxxxxnewlog;
	private Date zexxcxxrlxxxxxxxxxxxnewdate;
	private String zfxxutoxlhxxxxxxxxxxowner;
	private String zzxxu2oxxhxxxxxxxxxxowner2;

	public Xxxxch82bxhhhhhxxxxxeditlog() {
	}

	public Xxxxch82bxhhhhhxxxxxeditlog(String a0xxukxxbvxxxxxxxxxxdatabasenm) {
		this.a0xxukxxbvxxxxxxxxxxdatabasenm = a0xxukxxbvxxxxxxxxxxdatabasenm;
	}
	public Xxxxch82bxhhhhhxxxxxeditlog(String a0xxukxxbvxxxxxxxxxxdatabasenm,
			Integer z1xxzxxrbvxxxxxxxxxxrecordno,
			String z2xxuxxrblxxxxxxxxxxfield, Date z3xxcxxrlxxxxxxxxxxxdatet,
			String z4xxuxxrblxxxxxxxxxxusername,
			Boolean z5xxfxxxbvxxxxxxxxxxdeleted,
			String z6xxuxxrblxxxxxxxxxxprevchar,
			Integer z7xxzxxrbvxxxxxxxxxxprevnum,
			Boolean z8xxfxxxbvxxxxxxxxxxprevlog,
			Date zaxxcxxrlxxxxxxxxxxxprevdate,
			String zbxxuxxrblxxxxxxxxxxnewchar,
			Integer zcxxzxxrbvxxxxxxxxxxnewnum,
			Boolean zdxxfxxxbvxxxxxxxxxxnewlog,
			Date zexxcxxrlxxxxxxxxxxxnewdate, String zfxxutoxlhxxxxxxxxxxowner,
			String zzxxu2oxxhxxxxxxxxxxowner2) {
		this.a0xxukxxbvxxxxxxxxxxdatabasenm = a0xxukxxbvxxxxxxxxxxdatabasenm;
		this.z1xxzxxrbvxxxxxxxxxxrecordno = z1xxzxxrbvxxxxxxxxxxrecordno;
		this.z2xxuxxrblxxxxxxxxxxfield = z2xxuxxrblxxxxxxxxxxfield;
		this.z3xxcxxrlxxxxxxxxxxxdatet = z3xxcxxrlxxxxxxxxxxxdatet;
		this.z4xxuxxrblxxxxxxxxxxusername = z4xxuxxrblxxxxxxxxxxusername;
		this.z5xxfxxxbvxxxxxxxxxxdeleted = z5xxfxxxbvxxxxxxxxxxdeleted;
		this.z6xxuxxrblxxxxxxxxxxprevchar = z6xxuxxrblxxxxxxxxxxprevchar;
		this.z7xxzxxrbvxxxxxxxxxxprevnum = z7xxzxxrbvxxxxxxxxxxprevnum;
		this.z8xxfxxxbvxxxxxxxxxxprevlog = z8xxfxxxbvxxxxxxxxxxprevlog;
		this.zaxxcxxrlxxxxxxxxxxxprevdate = zaxxcxxrlxxxxxxxxxxxprevdate;
		this.zbxxuxxrblxxxxxxxxxxnewchar = zbxxuxxrblxxxxxxxxxxnewchar;
		this.zcxxzxxrbvxxxxxxxxxxnewnum = zcxxzxxrbvxxxxxxxxxxnewnum;
		this.zdxxfxxxbvxxxxxxxxxxnewlog = zdxxfxxxbvxxxxxxxxxxnewlog;
		this.zexxcxxrlxxxxxxxxxxxnewdate = zexxcxxrlxxxxxxxxxxxnewdate;
		this.zfxxutoxlhxxxxxxxxxxowner = zfxxutoxlhxxxxxxxxxxowner;
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

	@Column(name = "databasenm", nullable = false, length = 20)
	@NotNull
	@Size(max = 20)
	public String getA0xxukxxbvxxxxxxxxxxdatabasenm() {
		return this.a0xxukxxbvxxxxxxxxxxdatabasenm;
	}

	public void setA0xxukxxbvxxxxxxxxxxdatabasenm(
			String a0xxukxxbvxxxxxxxxxxdatabasenm) {
		this.a0xxukxxbvxxxxxxxxxxdatabasenm = a0xxukxxbvxxxxxxxxxxdatabasenm;
	}

	@Column(name = "recordno")
	public Integer getZ1xxzxxrbvxxxxxxxxxxrecordno() {
		return this.z1xxzxxrbvxxxxxxxxxxrecordno;
	}

	public void setZ1xxzxxrbvxxxxxxxxxxrecordno(
			Integer z1xxzxxrbvxxxxxxxxxxrecordno) {
		this.z1xxzxxrbvxxxxxxxxxxrecordno = z1xxzxxrbvxxxxxxxxxxrecordno;
	}

	@Column(name = "field", length = 20)
	@Size(max = 20)
	public String getZ2xxuxxrblxxxxxxxxxxfield() {
		return this.z2xxuxxrblxxxxxxxxxxfield;
	}

	public void setZ2xxuxxrblxxxxxxxxxxfield(String z2xxuxxrblxxxxxxxxxxfield) {
		this.z2xxuxxrblxxxxxxxxxxfield = z2xxuxxrblxxxxxxxxxxfield;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "datet", length = 29)
	public Date getZ3xxcxxrlxxxxxxxxxxxdatet() {
		return this.z3xxcxxrlxxxxxxxxxxxdatet;
	}

	public void setZ3xxcxxrlxxxxxxxxxxxdatet(Date z3xxcxxrlxxxxxxxxxxxdatet) {
		this.z3xxcxxrlxxxxxxxxxxxdatet = z3xxcxxrlxxxxxxxxxxxdatet;
	}

	@Column(name = "username", length = 20)
	@Size(max = 20)
	public String getZ4xxuxxrblxxxxxxxxxxusername() {
		return this.z4xxuxxrblxxxxxxxxxxusername;
	}

	public void setZ4xxuxxrblxxxxxxxxxxusername(
			String z4xxuxxrblxxxxxxxxxxusername) {
		this.z4xxuxxrblxxxxxxxxxxusername = z4xxuxxrblxxxxxxxxxxusername;
	}

	@Column(name = "deleted")
	public Boolean getZ5xxfxxxbvxxxxxxxxxxdeleted() {
		return this.z5xxfxxxbvxxxxxxxxxxdeleted;
	}

	public void setZ5xxfxxxbvxxxxxxxxxxdeleted(
			Boolean z5xxfxxxbvxxxxxxxxxxdeleted) {
		this.z5xxfxxxbvxxxxxxxxxxdeleted = z5xxfxxxbvxxxxxxxxxxdeleted;
	}

	@Column(name = "prevchar", length = 30)
	@Size(max = 30)
	public String getZ6xxuxxrblxxxxxxxxxxprevchar() {
		return this.z6xxuxxrblxxxxxxxxxxprevchar;
	}

	public void setZ6xxuxxrblxxxxxxxxxxprevchar(
			String z6xxuxxrblxxxxxxxxxxprevchar) {
		this.z6xxuxxrblxxxxxxxxxxprevchar = z6xxuxxrblxxxxxxxxxxprevchar;
	}

	@Column(name = "prevnum")
	public Integer getZ7xxzxxrbvxxxxxxxxxxprevnum() {
		return this.z7xxzxxrbvxxxxxxxxxxprevnum;
	}

	public void setZ7xxzxxrbvxxxxxxxxxxprevnum(
			Integer z7xxzxxrbvxxxxxxxxxxprevnum) {
		this.z7xxzxxrbvxxxxxxxxxxprevnum = z7xxzxxrbvxxxxxxxxxxprevnum;
	}

	@Column(name = "prevlog")
	public Boolean getZ8xxfxxxbvxxxxxxxxxxprevlog() {
		return this.z8xxfxxxbvxxxxxxxxxxprevlog;
	}

	public void setZ8xxfxxxbvxxxxxxxxxxprevlog(
			Boolean z8xxfxxxbvxxxxxxxxxxprevlog) {
		this.z8xxfxxxbvxxxxxxxxxxprevlog = z8xxfxxxbvxxxxxxxxxxprevlog;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "prevdate", length = 29)
	public Date getZaxxcxxrlxxxxxxxxxxxprevdate() {
		return this.zaxxcxxrlxxxxxxxxxxxprevdate;
	}

	public void setZaxxcxxrlxxxxxxxxxxxprevdate(
			Date zaxxcxxrlxxxxxxxxxxxprevdate) {
		this.zaxxcxxrlxxxxxxxxxxxprevdate = zaxxcxxrlxxxxxxxxxxxprevdate;
	}

	@Column(name = "newchar", length = 30)
	@Size(max = 30)
	public String getZbxxuxxrblxxxxxxxxxxnewchar() {
		return this.zbxxuxxrblxxxxxxxxxxnewchar;
	}

	public void setZbxxuxxrblxxxxxxxxxxnewchar(
			String zbxxuxxrblxxxxxxxxxxnewchar) {
		this.zbxxuxxrblxxxxxxxxxxnewchar = zbxxuxxrblxxxxxxxxxxnewchar;
	}

	@Column(name = "newnum")
	public Integer getZcxxzxxrbvxxxxxxxxxxnewnum() {
		return this.zcxxzxxrbvxxxxxxxxxxnewnum;
	}

	public void setZcxxzxxrbvxxxxxxxxxxnewnum(Integer zcxxzxxrbvxxxxxxxxxxnewnum) {
		this.zcxxzxxrbvxxxxxxxxxxnewnum = zcxxzxxrbvxxxxxxxxxxnewnum;
	}

	@Column(name = "newlog")
	public Boolean getZdxxfxxxbvxxxxxxxxxxnewlog() {
		return this.zdxxfxxxbvxxxxxxxxxxnewlog;
	}

	public void setZdxxfxxxbvxxxxxxxxxxnewlog(Boolean zdxxfxxxbvxxxxxxxxxxnewlog) {
		this.zdxxfxxxbvxxxxxxxxxxnewlog = zdxxfxxxbvxxxxxxxxxxnewlog;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "newdate", length = 29)
	public Date getZexxcxxrlxxxxxxxxxxxnewdate() {
		return this.zexxcxxrlxxxxxxxxxxxnewdate;
	}

	public void setZexxcxxrlxxxxxxxxxxxnewdate(Date zexxcxxrlxxxxxxxxxxxnewdate) {
		this.zexxcxxrlxxxxxxxxxxxnewdate = zexxcxxrlxxxxxxxxxxxnewdate;
	}

	@Column(name = "owner", length = 40)
	@Size(max = 40)
	public String getZfxxutoxlhxxxxxxxxxxowner() {
		return this.zfxxutoxlhxxxxxxxxxxowner;
	}

	public void setZfxxutoxlhxxxxxxxxxxowner(String zfxxutoxlhxxxxxxxxxxowner) {
		this.zfxxutoxlhxxxxxxxxxxowner = zfxxutoxlhxxxxxxxxxxowner;
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
