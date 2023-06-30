package com.rcomputer.genapp.model;
// Generated 30-Jun-2023 1:54:00 PM by Hibernate Tools 4.0.0

import java.math.BigDecimal;
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
 * Txxxuq932xwwqqhspxxxactivityjob generated by hbm2java
 */
@Entity
@XmlRootElement
@Table(name = "activityjob")
public class Txxxuq932xwwqqhspxxxactivityjob implements java.io.Serializable {

	private Integer a0xxuobxbxxxxxxxxxxxsid;
	private Jxxxuq201xwwqqhxxxxxcustomer jxxxuq201xwwqqhxxxxxcustomer;
	private Fxxxuq188xwwqqhxxxxxactivity fxxxuq188xwwqqhxxxxxactivity;
	private String a0xxunajbvxxxxxxxxxxjobno;
	private Date b2xxcxxrlxxxxxxxxxxxproddatet;
	private BigDecimal b3xxzqxrlvxxxxxxxxxxqtyalloc;
	private Integer b4xxuxcobvxxxxxxxxxxpono;
	private BigDecimal z1xxzxxrlvxxxxxxxxxxqtyostnd;
	private BigDecimal z2xxzxxrlvxxxxxxxxxxqtyalstk;
	private BigDecimal z3xxzxxrlvxxxxxxxxxxqtyissud;
	private BigDecimal z4xxzxxrlvxxxxxxxxxxjobtotl;
	private Integer z5xxzzfxhhxxxxxxxxxxstatusfl;
	private Integer c2xxuxxrbvxxxxxxxxxxvendor;
	private Date z4xxcztxlxxxxxxxxxxxstatusfldt;
	private Integer z5xxzzprhvxxxxxxxxxxprintmstat;
	private Date z6xxczqxlhxxxxxxxxxxprinmtfldt;
	private Integer z7xxzzprhvxxxxxxxxxxprintmstatj;
	private Date z8xxczqxlhxxxxxxxxxxprinmtfldtj;
	private String c3xxuxxrbv17xxxxxxxxtype;
	private String z9xxuxxrbvxxxxxxxxxxmatcodeout;
	private BigDecimal zaxxzxxrlvxxxxxxxxxxqtyout;
	private String y3xxuxznbvxxxxxxxxxxnotes;
	private String zbxxutoylhxxxxxxxxxxowner;
	private String zzxxu2oxxhxxxxxxxxxxowner2;
	private String y4xxuzdrbvxxxxxxxxxxdocmnt;
	private Set<Xoxxuq943xwwqqhxxxxxactivityjobdetails> xoxxuq943xwwqqhxxxxxactivityjobdetailses = new HashSet<Xoxxuq943xwwqqhxxxxxactivityjobdetails>(
			0);

	public Txxxuq932xwwqqhspxxxactivityjob() {
	}

	public Txxxuq932xwwqqhspxxxactivityjob(String a0xxunajbvxxxxxxxxxxjobno) {
		this.a0xxunajbvxxxxxxxxxxjobno = a0xxunajbvxxxxxxxxxxjobno;
	}
	public Txxxuq932xwwqqhspxxxactivityjob(
			Jxxxuq201xwwqqhxxxxxcustomer jxxxuq201xwwqqhxxxxxcustomer,
			Fxxxuq188xwwqqhxxxxxactivity fxxxuq188xwwqqhxxxxxactivity,
			String a0xxunajbvxxxxxxxxxxjobno,
			Date b2xxcxxrlxxxxxxxxxxxproddatet,
			BigDecimal b3xxzqxrlvxxxxxxxxxxqtyalloc,
			Integer b4xxuxcobvxxxxxxxxxxpono,
			BigDecimal z1xxzxxrlvxxxxxxxxxxqtyostnd,
			BigDecimal z2xxzxxrlvxxxxxxxxxxqtyalstk,
			BigDecimal z3xxzxxrlvxxxxxxxxxxqtyissud,
			BigDecimal z4xxzxxrlvxxxxxxxxxxjobtotl,
			Integer z5xxzzfxhhxxxxxxxxxxstatusfl,
			Integer c2xxuxxrbvxxxxxxxxxxvendor,
			Date z4xxcztxlxxxxxxxxxxxstatusfldt,
			Integer z5xxzzprhvxxxxxxxxxxprintmstat,
			Date z6xxczqxlhxxxxxxxxxxprinmtfldt,
			Integer z7xxzzprhvxxxxxxxxxxprintmstatj,
			Date z8xxczqxlhxxxxxxxxxxprinmtfldtj,
			String c3xxuxxrbv17xxxxxxxxtype,
			String z9xxuxxrbvxxxxxxxxxxmatcodeout,
			BigDecimal zaxxzxxrlvxxxxxxxxxxqtyout,
			String y3xxuxznbvxxxxxxxxxxnotes,
			String zbxxutoylhxxxxxxxxxxowner,
			String zzxxu2oxxhxxxxxxxxxxowner2,
			String y4xxuzdrbvxxxxxxxxxxdocmnt,
			Set<Xoxxuq943xwwqqhxxxxxactivityjobdetails> xoxxuq943xwwqqhxxxxxactivityjobdetailses) {
		this.jxxxuq201xwwqqhxxxxxcustomer = jxxxuq201xwwqqhxxxxxcustomer;
		this.fxxxuq188xwwqqhxxxxxactivity = fxxxuq188xwwqqhxxxxxactivity;
		this.a0xxunajbvxxxxxxxxxxjobno = a0xxunajbvxxxxxxxxxxjobno;
		this.b2xxcxxrlxxxxxxxxxxxproddatet = b2xxcxxrlxxxxxxxxxxxproddatet;
		this.b3xxzqxrlvxxxxxxxxxxqtyalloc = b3xxzqxrlvxxxxxxxxxxqtyalloc;
		this.b4xxuxcobvxxxxxxxxxxpono = b4xxuxcobvxxxxxxxxxxpono;
		this.z1xxzxxrlvxxxxxxxxxxqtyostnd = z1xxzxxrlvxxxxxxxxxxqtyostnd;
		this.z2xxzxxrlvxxxxxxxxxxqtyalstk = z2xxzxxrlvxxxxxxxxxxqtyalstk;
		this.z3xxzxxrlvxxxxxxxxxxqtyissud = z3xxzxxrlvxxxxxxxxxxqtyissud;
		this.z4xxzxxrlvxxxxxxxxxxjobtotl = z4xxzxxrlvxxxxxxxxxxjobtotl;
		this.z5xxzzfxhhxxxxxxxxxxstatusfl = z5xxzzfxhhxxxxxxxxxxstatusfl;
		this.c2xxuxxrbvxxxxxxxxxxvendor = c2xxuxxrbvxxxxxxxxxxvendor;
		this.z4xxcztxlxxxxxxxxxxxstatusfldt = z4xxcztxlxxxxxxxxxxxstatusfldt;
		this.z5xxzzprhvxxxxxxxxxxprintmstat = z5xxzzprhvxxxxxxxxxxprintmstat;
		this.z6xxczqxlhxxxxxxxxxxprinmtfldt = z6xxczqxlhxxxxxxxxxxprinmtfldt;
		this.z7xxzzprhvxxxxxxxxxxprintmstatj = z7xxzzprhvxxxxxxxxxxprintmstatj;
		this.z8xxczqxlhxxxxxxxxxxprinmtfldtj = z8xxczqxlhxxxxxxxxxxprinmtfldtj;
		this.c3xxuxxrbv17xxxxxxxxtype = c3xxuxxrbv17xxxxxxxxtype;
		this.z9xxuxxrbvxxxxxxxxxxmatcodeout = z9xxuxxrbvxxxxxxxxxxmatcodeout;
		this.zaxxzxxrlvxxxxxxxxxxqtyout = zaxxzxxrlvxxxxxxxxxxqtyout;
		this.y3xxuxznbvxxxxxxxxxxnotes = y3xxuxznbvxxxxxxxxxxnotes;
		this.zbxxutoylhxxxxxxxxxxowner = zbxxutoylhxxxxxxxxxxowner;
		this.zzxxu2oxxhxxxxxxxxxxowner2 = zzxxu2oxxhxxxxxxxxxxowner2;
		this.y4xxuzdrbvxxxxxxxxxxdocmnt = y4xxuzdrbvxxxxxxxxxxdocmnt;
		this.xoxxuq943xwwqqhxxxxxactivityjobdetailses = xoxxuq943xwwqqhxxxxxactivityjobdetailses;
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
	@JoinColumn(name = "customej")
	public Jxxxuq201xwwqqhxxxxxcustomer getJxxxuq201xwwqqhxxxxxcustomer() {
		return this.jxxxuq201xwwqqhxxxxxcustomer;
	}

	public void setJxxxuq201xwwqqhxxxxxcustomer(
			Jxxxuq201xwwqqhxxxxxcustomer jxxxuq201xwwqqhxxxxxcustomer) {
		this.jxxxuq201xwwqqhxxxxxcustomer = jxxxuq201xwwqqhxxxxxcustomer;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "activitycode")
	public Fxxxuq188xwwqqhxxxxxactivity getFxxxuq188xwwqqhxxxxxactivity() {
		return this.fxxxuq188xwwqqhxxxxxactivity;
	}

	public void setFxxxuq188xwwqqhxxxxxactivity(
			Fxxxuq188xwwqqhxxxxxactivity fxxxuq188xwwqqhxxxxxactivity) {
		this.fxxxuq188xwwqqhxxxxxactivity = fxxxuq188xwwqqhxxxxxactivity;
	}

	@Column(name = "jobno", nullable = false, length = 32)
	@NotNull
	@Size(max = 32)
	public String getA0xxunajbvxxxxxxxxxxjobno() {
		return this.a0xxunajbvxxxxxxxxxxjobno;
	}

	public void setA0xxunajbvxxxxxxxxxxjobno(String a0xxunajbvxxxxxxxxxxjobno) {
		this.a0xxunajbvxxxxxxxxxxjobno = a0xxunajbvxxxxxxxxxxjobno;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "proddatet", length = 29)
	public Date getB2xxcxxrlxxxxxxxxxxxproddatet() {
		return this.b2xxcxxrlxxxxxxxxxxxproddatet;
	}

	public void setB2xxcxxrlxxxxxxxxxxxproddatet(
			Date b2xxcxxrlxxxxxxxxxxxproddatet) {
		this.b2xxcxxrlxxxxxxxxxxxproddatet = b2xxcxxrlxxxxxxxxxxxproddatet;
	}

	@Column(name = "qtyalloc", precision = 14)
	public BigDecimal getB3xxzqxrlvxxxxxxxxxxqtyalloc() {
		return this.b3xxzqxrlvxxxxxxxxxxqtyalloc;
	}

	public void setB3xxzqxrlvxxxxxxxxxxqtyalloc(
			BigDecimal b3xxzqxrlvxxxxxxxxxxqtyalloc) {
		this.b3xxzqxrlvxxxxxxxxxxqtyalloc = b3xxzqxrlvxxxxxxxxxxqtyalloc;
	}

	@Column(name = "pono")
	public Integer getB4xxuxcobvxxxxxxxxxxpono() {
		return this.b4xxuxcobvxxxxxxxxxxpono;
	}

	public void setB4xxuxcobvxxxxxxxxxxpono(Integer b4xxuxcobvxxxxxxxxxxpono) {
		this.b4xxuxcobvxxxxxxxxxxpono = b4xxuxcobvxxxxxxxxxxpono;
	}

	@Column(name = "qtyostnd", precision = 14)
	public BigDecimal getZ1xxzxxrlvxxxxxxxxxxqtyostnd() {
		return this.z1xxzxxrlvxxxxxxxxxxqtyostnd;
	}

	public void setZ1xxzxxrlvxxxxxxxxxxqtyostnd(
			BigDecimal z1xxzxxrlvxxxxxxxxxxqtyostnd) {
		this.z1xxzxxrlvxxxxxxxxxxqtyostnd = z1xxzxxrlvxxxxxxxxxxqtyostnd;
	}

	@Column(name = "qtyalstk", precision = 14)
	public BigDecimal getZ2xxzxxrlvxxxxxxxxxxqtyalstk() {
		return this.z2xxzxxrlvxxxxxxxxxxqtyalstk;
	}

	public void setZ2xxzxxrlvxxxxxxxxxxqtyalstk(
			BigDecimal z2xxzxxrlvxxxxxxxxxxqtyalstk) {
		this.z2xxzxxrlvxxxxxxxxxxqtyalstk = z2xxzxxrlvxxxxxxxxxxqtyalstk;
	}

	@Column(name = "qtyissud", precision = 14)
	public BigDecimal getZ3xxzxxrlvxxxxxxxxxxqtyissud() {
		return this.z3xxzxxrlvxxxxxxxxxxqtyissud;
	}

	public void setZ3xxzxxrlvxxxxxxxxxxqtyissud(
			BigDecimal z3xxzxxrlvxxxxxxxxxxqtyissud) {
		this.z3xxzxxrlvxxxxxxxxxxqtyissud = z3xxzxxrlvxxxxxxxxxxqtyissud;
	}

	@Column(name = "jobtotl", precision = 14)
	public BigDecimal getZ4xxzxxrlvxxxxxxxxxxjobtotl() {
		return this.z4xxzxxrlvxxxxxxxxxxjobtotl;
	}

	public void setZ4xxzxxrlvxxxxxxxxxxjobtotl(
			BigDecimal z4xxzxxrlvxxxxxxxxxxjobtotl) {
		this.z4xxzxxrlvxxxxxxxxxxjobtotl = z4xxzxxrlvxxxxxxxxxxjobtotl;
	}

	@Column(name = "statusfl")
	public Integer getZ5xxzzfxhhxxxxxxxxxxstatusfl() {
		return this.z5xxzzfxhhxxxxxxxxxxstatusfl;
	}

	public void setZ5xxzzfxhhxxxxxxxxxxstatusfl(
			Integer z5xxzzfxhhxxxxxxxxxxstatusfl) {
		this.z5xxzzfxhhxxxxxxxxxxstatusfl = z5xxzzfxhhxxxxxxxxxxstatusfl;
	}

	@Column(name = "vendor")
	public Integer getC2xxuxxrbvxxxxxxxxxxvendor() {
		return this.c2xxuxxrbvxxxxxxxxxxvendor;
	}

	public void setC2xxuxxrbvxxxxxxxxxxvendor(Integer c2xxuxxrbvxxxxxxxxxxvendor) {
		this.c2xxuxxrbvxxxxxxxxxxvendor = c2xxuxxrbvxxxxxxxxxxvendor;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "statusfldt", length = 29)
	public Date getZ4xxcztxlxxxxxxxxxxxstatusfldt() {
		return this.z4xxcztxlxxxxxxxxxxxstatusfldt;
	}

	public void setZ4xxcztxlxxxxxxxxxxxstatusfldt(
			Date z4xxcztxlxxxxxxxxxxxstatusfldt) {
		this.z4xxcztxlxxxxxxxxxxxstatusfldt = z4xxcztxlxxxxxxxxxxxstatusfldt;
	}

	@Column(name = "printmstat")
	public Integer getZ5xxzzprhvxxxxxxxxxxprintmstat() {
		return this.z5xxzzprhvxxxxxxxxxxprintmstat;
	}

	public void setZ5xxzzprhvxxxxxxxxxxprintmstat(
			Integer z5xxzzprhvxxxxxxxxxxprintmstat) {
		this.z5xxzzprhvxxxxxxxxxxprintmstat = z5xxzzprhvxxxxxxxxxxprintmstat;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "prinmtfldt", length = 29)
	public Date getZ6xxczqxlhxxxxxxxxxxprinmtfldt() {
		return this.z6xxczqxlhxxxxxxxxxxprinmtfldt;
	}

	public void setZ6xxczqxlhxxxxxxxxxxprinmtfldt(
			Date z6xxczqxlhxxxxxxxxxxprinmtfldt) {
		this.z6xxczqxlhxxxxxxxxxxprinmtfldt = z6xxczqxlhxxxxxxxxxxprinmtfldt;
	}

	@Column(name = "printmstatj")
	public Integer getZ7xxzzprhvxxxxxxxxxxprintmstatj() {
		return this.z7xxzzprhvxxxxxxxxxxprintmstatj;
	}

	public void setZ7xxzzprhvxxxxxxxxxxprintmstatj(
			Integer z7xxzzprhvxxxxxxxxxxprintmstatj) {
		this.z7xxzzprhvxxxxxxxxxxprintmstatj = z7xxzzprhvxxxxxxxxxxprintmstatj;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "prinmtfldtj", length = 29)
	public Date getZ8xxczqxlhxxxxxxxxxxprinmtfldtj() {
		return this.z8xxczqxlhxxxxxxxxxxprinmtfldtj;
	}

	public void setZ8xxczqxlhxxxxxxxxxxprinmtfldtj(
			Date z8xxczqxlhxxxxxxxxxxprinmtfldtj) {
		this.z8xxczqxlhxxxxxxxxxxprinmtfldtj = z8xxczqxlhxxxxxxxxxxprinmtfldtj;
	}

	@Column(name = "type", length = 12)
	@Size(max = 12)
	public String getC3xxuxxrbv17xxxxxxxxtype() {
		return this.c3xxuxxrbv17xxxxxxxxtype;
	}

	public void setC3xxuxxrbv17xxxxxxxxtype(String c3xxuxxrbv17xxxxxxxxtype) {
		this.c3xxuxxrbv17xxxxxxxxtype = c3xxuxxrbv17xxxxxxxxtype;
	}

	@Column(name = "matcodeout", length = 32)
	@Size(max = 32)
	public String getZ9xxuxxrbvxxxxxxxxxxmatcodeout() {
		return this.z9xxuxxrbvxxxxxxxxxxmatcodeout;
	}

	public void setZ9xxuxxrbvxxxxxxxxxxmatcodeout(
			String z9xxuxxrbvxxxxxxxxxxmatcodeout) {
		this.z9xxuxxrbvxxxxxxxxxxmatcodeout = z9xxuxxrbvxxxxxxxxxxmatcodeout;
	}

	@Column(name = "qtyout", precision = 14)
	public BigDecimal getZaxxzxxrlvxxxxxxxxxxqtyout() {
		return this.zaxxzxxrlvxxxxxxxxxxqtyout;
	}

	public void setZaxxzxxrlvxxxxxxxxxxqtyout(
			BigDecimal zaxxzxxrlvxxxxxxxxxxqtyout) {
		this.zaxxzxxrlvxxxxxxxxxxqtyout = zaxxzxxrlvxxxxxxxxxxqtyout;
	}

	@Column(name = "notes", length = 60)
	@Size(max = 60)
	public String getY3xxuxznbvxxxxxxxxxxnotes() {
		return this.y3xxuxznbvxxxxxxxxxxnotes;
	}

	public void setY3xxuxznbvxxxxxxxxxxnotes(String y3xxuxznbvxxxxxxxxxxnotes) {
		this.y3xxuxznbvxxxxxxxxxxnotes = y3xxuxznbvxxxxxxxxxxnotes;
	}

	@Column(name = "owner", length = 40)
	@Size(max = 40)
	public String getZbxxutoylhxxxxxxxxxxowner() {
		return this.zbxxutoylhxxxxxxxxxxowner;
	}

	public void setZbxxutoylhxxxxxxxxxxowner(String zbxxutoylhxxxxxxxxxxowner) {
		this.zbxxutoylhxxxxxxxxxxowner = zbxxutoylhxxxxxxxxxxowner;
	}

	@Column(name = "owner2", length = 40)
	@Size(max = 40)
	public String getZzxxu2oxxhxxxxxxxxxxowner2() {
		return this.zzxxu2oxxhxxxxxxxxxxowner2;
	}

	public void setZzxxu2oxxhxxxxxxxxxxowner2(String zzxxu2oxxhxxxxxxxxxxowner2) {
		this.zzxxu2oxxhxxxxxxxxxxowner2 = zzxxu2oxxhxxxxxxxxxxowner2;
	}

	@Column(name = "docmnt", length = 90)
	@Size(max = 90)
	public String getY4xxuzdrbvxxxxxxxxxxdocmnt() {
		return this.y4xxuzdrbvxxxxxxxxxxdocmnt;
	}

	public void setY4xxuzdrbvxxxxxxxxxxdocmnt(String y4xxuzdrbvxxxxxxxxxxdocmnt) {
		this.y4xxuzdrbvxxxxxxxxxxdocmnt = y4xxuzdrbvxxxxxxxxxxdocmnt;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "txxxuq932xwwqqhspxxxactivityjob")
	public Set<Xoxxuq943xwwqqhxxxxxactivityjobdetails> getXoxxuq943xwwqqhxxxxxactivityjobdetailses() {
		return this.xoxxuq943xwwqqhxxxxxactivityjobdetailses;
	}

	public void setXoxxuq943xwwqqhxxxxxactivityjobdetailses(
			Set<Xoxxuq943xwwqqhxxxxxactivityjobdetails> xoxxuq943xwwqqhxxxxxactivityjobdetailses) {
		this.xoxxuq943xwwqqhxxxxxactivityjobdetailses = xoxxuq943xwwqqhxxxxxactivityjobdetailses;
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
