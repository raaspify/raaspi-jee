package com.rcomputer.genapp.model;
// Generated 13-Apr-2023 9:07:31 PM by Hibernate Tools 4.0.0

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
 * Fxxxuq188xwwqqhxxxxxactivity generated by hbm2java
 */
@Entity
@XmlRootElement
@Table(name = "activity")
public class Fxxxuq188xwwqqhxxxxxactivity implements java.io.Serializable {

	private Integer a0xxuobxbxxxxxxxxxxxsid;
	private Fxxxuq188xwwqqhxxxxxactivity fxxxuq188xwwqqhxxxxxactivity;
	private String a0xxukaxbvxxxxxxxxxxactivitycode;
	private BigDecimal z1xxzxqrlvxxxxxxxxxxquantity;
	private String b1xxuszsbvxxxxxxxxxxdescript;
	private Date b2xxcxxrlxxxxxxxxxxxdate;
	private String b3xxuxxrbvxxxxxxxxxxsource1;
	private String y1xxuxxrbvxxxxxxxxxxsource2;
	private String b4xxuxxrbvxxxxxxxxxxupccode;
	private BigDecimal b5xxzxxrlvxxxxxxxxxxcost;
	private BigDecimal b6xxzcxrlvxxxxxxxxxxreplcost;
	private BigDecimal b7xxzpxrlvxxxxxxxxxxselprice;
	private BigDecimal z2xxzxxrlvxxsxxxxxxxspricold;
	private BigDecimal b8xxzxxrhhxxsxxxxxxxspricnew;
	private Date b9xxcxxrhhxxsxxxxxxxspriceffdt;
	private String c1xxuxxrbvxxxxxxxxxxshipcode;
	private Integer z3xxzzprhvxxxxxxxxxxprintmstat;
	private Date z4xxczqxlhxxxxxxxxxxprinmtfldt;
	private String y2xxuxxrbvxxxxxxxxxxmisccode1;
	private String y3xxuxxrbvxxxxxxxxxxmisccode2;
	private BigDecimal c2xxzxxrlvxxxxxxxxxxqtylevel1;
	private String c3xxuuxrbv18xxxxxxxxunit;
	private BigDecimal c4xxzxxrlvxxxxxxxxxxcaseqty;
	private String c5xxuxxrbv37xxxxxxxxtype;
	private Boolean c6xxfxz1bvxxxxxxxxxxtax1;
	private Boolean c7xxfxz2bvxxxxxxxxxxtax2;
	private Boolean y4xxfxz3xxxvxxxxxxxxxxtax3;
	private String y5xxuxxrbvxxxxxxxxxxaliascode;
	private BigDecimal z5xxzxxrlvxxxxxxxxxxavgprice;
	private BigDecimal z6xxzxxrlvxxxxxxxxxxavgcost;
	private Integer z7xxzzfxhhxxxxxxxxxxstatusfl;
	private Date z8xxcztxlxxxxxxxxxxxstatusfldt;
	private String g2xxuxn1lvxxxxxxxxxxsubcodesn;
	private String g2xxuxn2lvxxxxxxxxxxsubcodesn2;
	private String g2xxuxn3lvxxxxxxxxxxsubcodesn3;
	private BigDecimal zbxxzxxrlvxxxxxxxxxxcuordqty;
	private BigDecimal zcxxzxxrlvxxxxxxxxxxvenorqty;
	private BigDecimal zdxxzxxrlvxxxxxxxxxxcupicqty;
	private BigDecimal zexxzxxrlvxxxxxxxxxxvenpiqty;
	private BigDecimal zfxxzxxrlvxxxxxxxxxxcuinvqty;
	private BigDecimal zgxxzxxrlvxxxxxxxxxxcushiqty;
	private BigDecimal zhxxzxxrlvxxxxxxxxxxvenshqty;
	private Date c8xxcxxrlxxxxxxxxxxxeffdate;
	private String c9xxuwmrbv40xxxxxxxxintegrset;
	private String y7xxuznxbvxxxxxxxxxxnotes;
	private String y8xxuzdrbvxxxxxxxxxxdocmnt;
	private String zixxutoxlhxxxxxxxxxxowner;
	private String zzxxu2oxxhxxxxxxxxxxowner2;
	private String zjxxuxxrbvxxxxxxxxxxbarupc;
	private Set<Xoxxuq943xwwqqhxxxxxactivityjobdetails> xoxxuq943xwwqqhxxxxxactivityjobdetailses = new HashSet<Xoxxuq943xwwqqhxxxxxactivityjobdetails>(
			0);
	private Set<Txxxuq932xwwqqhspxxxactivityjob> txxxuq932xwwqqhspxxxactivityjobs = new HashSet<Txxxuq932xwwqqhspxxxactivityjob>(
			0);
	private Set<Fxxxuq1kkxwwqqhfxxxxtask> fxxxuq1kkxwwqqhfxxxxtasks = new HashSet<Fxxxuq1kkxwwqqhfxxxxtask>(
			0);
	private Set<Fxxxuq188xwwqqhxxxxxactivity> fxxxuq188xwwqqhxxxxxactivities = new HashSet<Fxxxuq188xwwqqhxxxxxactivity>(
			0);
	private Set<Jxxxuq54exwwqqhxxxxxgroupmembers> jxxxuq54exwwqqhxxxxxgroupmemberses = new HashSet<Jxxxuq54exwwqqhxxxxxgroupmembers>(
			0);
	private Set<Fxxxuq89bxwwqqhxxxxxschedule> fxxxuq89bxwwqqhxxxxxschedules = new HashSet<Fxxxuq89bxwwqqhxxxxxschedule>(
			0);

	public Fxxxuq188xwwqqhxxxxxactivity() {
	}

	public Fxxxuq188xwwqqhxxxxxactivity(String a0xxukaxbvxxxxxxxxxxactivitycode) {
		this.a0xxukaxbvxxxxxxxxxxactivitycode = a0xxukaxbvxxxxxxxxxxactivitycode;
	}
	public Fxxxuq188xwwqqhxxxxxactivity(
			Fxxxuq188xwwqqhxxxxxactivity fxxxuq188xwwqqhxxxxxactivity,
			String a0xxukaxbvxxxxxxxxxxactivitycode,
			BigDecimal z1xxzxqrlvxxxxxxxxxxquantity,
			String b1xxuszsbvxxxxxxxxxxdescript,
			Date b2xxcxxrlxxxxxxxxxxxdate,
			String b3xxuxxrbvxxxxxxxxxxsource1,
			String y1xxuxxrbvxxxxxxxxxxsource2,
			String b4xxuxxrbvxxxxxxxxxxupccode,
			BigDecimal b5xxzxxrlvxxxxxxxxxxcost,
			BigDecimal b6xxzcxrlvxxxxxxxxxxreplcost,
			BigDecimal b7xxzpxrlvxxxxxxxxxxselprice,
			BigDecimal z2xxzxxrlvxxsxxxxxxxspricold,
			BigDecimal b8xxzxxrhhxxsxxxxxxxspricnew,
			Date b9xxcxxrhhxxsxxxxxxxspriceffdt,
			String c1xxuxxrbvxxxxxxxxxxshipcode,
			Integer z3xxzzprhvxxxxxxxxxxprintmstat,
			Date z4xxczqxlhxxxxxxxxxxprinmtfldt,
			String y2xxuxxrbvxxxxxxxxxxmisccode1,
			String y3xxuxxrbvxxxxxxxxxxmisccode2,
			BigDecimal c2xxzxxrlvxxxxxxxxxxqtylevel1,
			String c3xxuuxrbv18xxxxxxxxunit,
			BigDecimal c4xxzxxrlvxxxxxxxxxxcaseqty,
			String c5xxuxxrbv37xxxxxxxxtype,
			Boolean c6xxfxz1bvxxxxxxxxxxtax1,
			Boolean c7xxfxz2bvxxxxxxxxxxtax2,
			Boolean y4xxfxz3xxxvxxxxxxxxxxtax3,
			String y5xxuxxrbvxxxxxxxxxxaliascode,
			BigDecimal z5xxzxxrlvxxxxxxxxxxavgprice,
			BigDecimal z6xxzxxrlvxxxxxxxxxxavgcost,
			Integer z7xxzzfxhhxxxxxxxxxxstatusfl,
			Date z8xxcztxlxxxxxxxxxxxstatusfldt,
			String g2xxuxn1lvxxxxxxxxxxsubcodesn,
			String g2xxuxn2lvxxxxxxxxxxsubcodesn2,
			String g2xxuxn3lvxxxxxxxxxxsubcodesn3,
			BigDecimal zbxxzxxrlvxxxxxxxxxxcuordqty,
			BigDecimal zcxxzxxrlvxxxxxxxxxxvenorqty,
			BigDecimal zdxxzxxrlvxxxxxxxxxxcupicqty,
			BigDecimal zexxzxxrlvxxxxxxxxxxvenpiqty,
			BigDecimal zfxxzxxrlvxxxxxxxxxxcuinvqty,
			BigDecimal zgxxzxxrlvxxxxxxxxxxcushiqty,
			BigDecimal zhxxzxxrlvxxxxxxxxxxvenshqty,
			Date c8xxcxxrlxxxxxxxxxxxeffdate,
			String c9xxuwmrbv40xxxxxxxxintegrset,
			String y7xxuznxbvxxxxxxxxxxnotes,
			String y8xxuzdrbvxxxxxxxxxxdocmnt,
			String zixxutoxlhxxxxxxxxxxowner,
			String zzxxu2oxxhxxxxxxxxxxowner2,
			String zjxxuxxrbvxxxxxxxxxxbarupc,
			Set<Xoxxuq943xwwqqhxxxxxactivityjobdetails> xoxxuq943xwwqqhxxxxxactivityjobdetailses,
			Set<Txxxuq932xwwqqhspxxxactivityjob> txxxuq932xwwqqhspxxxactivityjobs,
			Set<Fxxxuq1kkxwwqqhfxxxxtask> fxxxuq1kkxwwqqhfxxxxtasks,
			Set<Fxxxuq188xwwqqhxxxxxactivity> fxxxuq188xwwqqhxxxxxactivities,
			Set<Jxxxuq54exwwqqhxxxxxgroupmembers> jxxxuq54exwwqqhxxxxxgroupmemberses,
			Set<Fxxxuq89bxwwqqhxxxxxschedule> fxxxuq89bxwwqqhxxxxxschedules) {
		this.fxxxuq188xwwqqhxxxxxactivity = fxxxuq188xwwqqhxxxxxactivity;
		this.a0xxukaxbvxxxxxxxxxxactivitycode = a0xxukaxbvxxxxxxxxxxactivitycode;
		this.z1xxzxqrlvxxxxxxxxxxquantity = z1xxzxqrlvxxxxxxxxxxquantity;
		this.b1xxuszsbvxxxxxxxxxxdescript = b1xxuszsbvxxxxxxxxxxdescript;
		this.b2xxcxxrlxxxxxxxxxxxdate = b2xxcxxrlxxxxxxxxxxxdate;
		this.b3xxuxxrbvxxxxxxxxxxsource1 = b3xxuxxrbvxxxxxxxxxxsource1;
		this.y1xxuxxrbvxxxxxxxxxxsource2 = y1xxuxxrbvxxxxxxxxxxsource2;
		this.b4xxuxxrbvxxxxxxxxxxupccode = b4xxuxxrbvxxxxxxxxxxupccode;
		this.b5xxzxxrlvxxxxxxxxxxcost = b5xxzxxrlvxxxxxxxxxxcost;
		this.b6xxzcxrlvxxxxxxxxxxreplcost = b6xxzcxrlvxxxxxxxxxxreplcost;
		this.b7xxzpxrlvxxxxxxxxxxselprice = b7xxzpxrlvxxxxxxxxxxselprice;
		this.z2xxzxxrlvxxsxxxxxxxspricold = z2xxzxxrlvxxsxxxxxxxspricold;
		this.b8xxzxxrhhxxsxxxxxxxspricnew = b8xxzxxrhhxxsxxxxxxxspricnew;
		this.b9xxcxxrhhxxsxxxxxxxspriceffdt = b9xxcxxrhhxxsxxxxxxxspriceffdt;
		this.c1xxuxxrbvxxxxxxxxxxshipcode = c1xxuxxrbvxxxxxxxxxxshipcode;
		this.z3xxzzprhvxxxxxxxxxxprintmstat = z3xxzzprhvxxxxxxxxxxprintmstat;
		this.z4xxczqxlhxxxxxxxxxxprinmtfldt = z4xxczqxlhxxxxxxxxxxprinmtfldt;
		this.y2xxuxxrbvxxxxxxxxxxmisccode1 = y2xxuxxrbvxxxxxxxxxxmisccode1;
		this.y3xxuxxrbvxxxxxxxxxxmisccode2 = y3xxuxxrbvxxxxxxxxxxmisccode2;
		this.c2xxzxxrlvxxxxxxxxxxqtylevel1 = c2xxzxxrlvxxxxxxxxxxqtylevel1;
		this.c3xxuuxrbv18xxxxxxxxunit = c3xxuuxrbv18xxxxxxxxunit;
		this.c4xxzxxrlvxxxxxxxxxxcaseqty = c4xxzxxrlvxxxxxxxxxxcaseqty;
		this.c5xxuxxrbv37xxxxxxxxtype = c5xxuxxrbv37xxxxxxxxtype;
		this.c6xxfxz1bvxxxxxxxxxxtax1 = c6xxfxz1bvxxxxxxxxxxtax1;
		this.c7xxfxz2bvxxxxxxxxxxtax2 = c7xxfxz2bvxxxxxxxxxxtax2;
		this.y4xxfxz3xxxvxxxxxxxxxxtax3 = y4xxfxz3xxxvxxxxxxxxxxtax3;
		this.y5xxuxxrbvxxxxxxxxxxaliascode = y5xxuxxrbvxxxxxxxxxxaliascode;
		this.z5xxzxxrlvxxxxxxxxxxavgprice = z5xxzxxrlvxxxxxxxxxxavgprice;
		this.z6xxzxxrlvxxxxxxxxxxavgcost = z6xxzxxrlvxxxxxxxxxxavgcost;
		this.z7xxzzfxhhxxxxxxxxxxstatusfl = z7xxzzfxhhxxxxxxxxxxstatusfl;
		this.z8xxcztxlxxxxxxxxxxxstatusfldt = z8xxcztxlxxxxxxxxxxxstatusfldt;
		this.g2xxuxn1lvxxxxxxxxxxsubcodesn = g2xxuxn1lvxxxxxxxxxxsubcodesn;
		this.g2xxuxn2lvxxxxxxxxxxsubcodesn2 = g2xxuxn2lvxxxxxxxxxxsubcodesn2;
		this.g2xxuxn3lvxxxxxxxxxxsubcodesn3 = g2xxuxn3lvxxxxxxxxxxsubcodesn3;
		this.zbxxzxxrlvxxxxxxxxxxcuordqty = zbxxzxxrlvxxxxxxxxxxcuordqty;
		this.zcxxzxxrlvxxxxxxxxxxvenorqty = zcxxzxxrlvxxxxxxxxxxvenorqty;
		this.zdxxzxxrlvxxxxxxxxxxcupicqty = zdxxzxxrlvxxxxxxxxxxcupicqty;
		this.zexxzxxrlvxxxxxxxxxxvenpiqty = zexxzxxrlvxxxxxxxxxxvenpiqty;
		this.zfxxzxxrlvxxxxxxxxxxcuinvqty = zfxxzxxrlvxxxxxxxxxxcuinvqty;
		this.zgxxzxxrlvxxxxxxxxxxcushiqty = zgxxzxxrlvxxxxxxxxxxcushiqty;
		this.zhxxzxxrlvxxxxxxxxxxvenshqty = zhxxzxxrlvxxxxxxxxxxvenshqty;
		this.c8xxcxxrlxxxxxxxxxxxeffdate = c8xxcxxrlxxxxxxxxxxxeffdate;
		this.c9xxuwmrbv40xxxxxxxxintegrset = c9xxuwmrbv40xxxxxxxxintegrset;
		this.y7xxuznxbvxxxxxxxxxxnotes = y7xxuznxbvxxxxxxxxxxnotes;
		this.y8xxuzdrbvxxxxxxxxxxdocmnt = y8xxuzdrbvxxxxxxxxxxdocmnt;
		this.zixxutoxlhxxxxxxxxxxowner = zixxutoxlhxxxxxxxxxxowner;
		this.zzxxu2oxxhxxxxxxxxxxowner2 = zzxxu2oxxhxxxxxxxxxxowner2;
		this.zjxxuxxrbvxxxxxxxxxxbarupc = zjxxuxxrbvxxxxxxxxxxbarupc;
		this.xoxxuq943xwwqqhxxxxxactivityjobdetailses = xoxxuq943xwwqqhxxxxxactivityjobdetailses;
		this.txxxuq932xwwqqhspxxxactivityjobs = txxxuq932xwwqqhspxxxactivityjobs;
		this.fxxxuq1kkxwwqqhfxxxxtasks = fxxxuq1kkxwwqqhfxxxxtasks;
		this.fxxxuq188xwwqqhxxxxxactivities = fxxxuq188xwwqqhxxxxxactivities;
		this.jxxxuq54exwwqqhxxxxxgroupmemberses = jxxxuq54exwwqqhxxxxxgroupmemberses;
		this.fxxxuq89bxwwqqhxxxxxschedules = fxxxuq89bxwwqqhxxxxxschedules;
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
	@JoinColumn(name = "parentcode")
	public Fxxxuq188xwwqqhxxxxxactivity getFxxxuq188xwwqqhxxxxxactivity() {
		return this.fxxxuq188xwwqqhxxxxxactivity;
	}

	public void setFxxxuq188xwwqqhxxxxxactivity(
			Fxxxuq188xwwqqhxxxxxactivity fxxxuq188xwwqqhxxxxxactivity) {
		this.fxxxuq188xwwqqhxxxxxactivity = fxxxuq188xwwqqhxxxxxactivity;
	}

	@Column(name = "activitycode", nullable = false, length = 32)
	@NotNull
	@Size(max = 32)
	public String getA0xxukaxbvxxxxxxxxxxactivitycode() {
		return this.a0xxukaxbvxxxxxxxxxxactivitycode;
	}

	public void setA0xxukaxbvxxxxxxxxxxactivitycode(
			String a0xxukaxbvxxxxxxxxxxactivitycode) {
		this.a0xxukaxbvxxxxxxxxxxactivitycode = a0xxukaxbvxxxxxxxxxxactivitycode;
	}

	@Column(name = "quantity", precision = 14)
	public BigDecimal getZ1xxzxqrlvxxxxxxxxxxquantity() {
		return this.z1xxzxqrlvxxxxxxxxxxquantity;
	}

	public void setZ1xxzxqrlvxxxxxxxxxxquantity(
			BigDecimal z1xxzxqrlvxxxxxxxxxxquantity) {
		this.z1xxzxqrlvxxxxxxxxxxquantity = z1xxzxqrlvxxxxxxxxxxquantity;
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
	@Column(name = "date", length = 29)
	public Date getB2xxcxxrlxxxxxxxxxxxdate() {
		return this.b2xxcxxrlxxxxxxxxxxxdate;
	}

	public void setB2xxcxxrlxxxxxxxxxxxdate(Date b2xxcxxrlxxxxxxxxxxxdate) {
		this.b2xxcxxrlxxxxxxxxxxxdate = b2xxcxxrlxxxxxxxxxxxdate;
	}

	@Column(name = "source1", length = 35)
	@Size(max = 35)
	public String getB3xxuxxrbvxxxxxxxxxxsource1() {
		return this.b3xxuxxrbvxxxxxxxxxxsource1;
	}

	public void setB3xxuxxrbvxxxxxxxxxxsource1(
			String b3xxuxxrbvxxxxxxxxxxsource1) {
		this.b3xxuxxrbvxxxxxxxxxxsource1 = b3xxuxxrbvxxxxxxxxxxsource1;
	}

	@Column(name = "source2", length = 35)
	@Size(max = 35)
	public String getY1xxuxxrbvxxxxxxxxxxsource2() {
		return this.y1xxuxxrbvxxxxxxxxxxsource2;
	}

	public void setY1xxuxxrbvxxxxxxxxxxsource2(
			String y1xxuxxrbvxxxxxxxxxxsource2) {
		this.y1xxuxxrbvxxxxxxxxxxsource2 = y1xxuxxrbvxxxxxxxxxxsource2;
	}

	@Column(name = "upccode", length = 25)
	@Size(max = 25)
	public String getB4xxuxxrbvxxxxxxxxxxupccode() {
		return this.b4xxuxxrbvxxxxxxxxxxupccode;
	}

	public void setB4xxuxxrbvxxxxxxxxxxupccode(
			String b4xxuxxrbvxxxxxxxxxxupccode) {
		this.b4xxuxxrbvxxxxxxxxxxupccode = b4xxuxxrbvxxxxxxxxxxupccode;
	}

	@Column(name = "cost", precision = 14)
	public BigDecimal getB5xxzxxrlvxxxxxxxxxxcost() {
		return this.b5xxzxxrlvxxxxxxxxxxcost;
	}

	public void setB5xxzxxrlvxxxxxxxxxxcost(BigDecimal b5xxzxxrlvxxxxxxxxxxcost) {
		this.b5xxzxxrlvxxxxxxxxxxcost = b5xxzxxrlvxxxxxxxxxxcost;
	}

	@Column(name = "replcost", precision = 14)
	public BigDecimal getB6xxzcxrlvxxxxxxxxxxreplcost() {
		return this.b6xxzcxrlvxxxxxxxxxxreplcost;
	}

	public void setB6xxzcxrlvxxxxxxxxxxreplcost(
			BigDecimal b6xxzcxrlvxxxxxxxxxxreplcost) {
		this.b6xxzcxrlvxxxxxxxxxxreplcost = b6xxzcxrlvxxxxxxxxxxreplcost;
	}

	@Column(name = "selprice", precision = 14)
	public BigDecimal getB7xxzpxrlvxxxxxxxxxxselprice() {
		return this.b7xxzpxrlvxxxxxxxxxxselprice;
	}

	public void setB7xxzpxrlvxxxxxxxxxxselprice(
			BigDecimal b7xxzpxrlvxxxxxxxxxxselprice) {
		this.b7xxzpxrlvxxxxxxxxxxselprice = b7xxzpxrlvxxxxxxxxxxselprice;
	}

	@Column(name = "spricold", precision = 14)
	public BigDecimal getZ2xxzxxrlvxxsxxxxxxxspricold() {
		return this.z2xxzxxrlvxxsxxxxxxxspricold;
	}

	public void setZ2xxzxxrlvxxsxxxxxxxspricold(
			BigDecimal z2xxzxxrlvxxsxxxxxxxspricold) {
		this.z2xxzxxrlvxxsxxxxxxxspricold = z2xxzxxrlvxxsxxxxxxxspricold;
	}

	@Column(name = "spricnew", precision = 14)
	public BigDecimal getB8xxzxxrhhxxsxxxxxxxspricnew() {
		return this.b8xxzxxrhhxxsxxxxxxxspricnew;
	}

	public void setB8xxzxxrhhxxsxxxxxxxspricnew(
			BigDecimal b8xxzxxrhhxxsxxxxxxxspricnew) {
		this.b8xxzxxrhhxxsxxxxxxxspricnew = b8xxzxxrhhxxsxxxxxxxspricnew;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "spriceffdt", length = 29)
	public Date getB9xxcxxrhhxxsxxxxxxxspriceffdt() {
		return this.b9xxcxxrhhxxsxxxxxxxspriceffdt;
	}

	public void setB9xxcxxrhhxxsxxxxxxxspriceffdt(
			Date b9xxcxxrhhxxsxxxxxxxspriceffdt) {
		this.b9xxcxxrhhxxsxxxxxxxspriceffdt = b9xxcxxrhhxxsxxxxxxxspriceffdt;
	}

	@Column(name = "shipcode", length = 25)
	@Size(max = 25)
	public String getC1xxuxxrbvxxxxxxxxxxshipcode() {
		return this.c1xxuxxrbvxxxxxxxxxxshipcode;
	}

	public void setC1xxuxxrbvxxxxxxxxxxshipcode(
			String c1xxuxxrbvxxxxxxxxxxshipcode) {
		this.c1xxuxxrbvxxxxxxxxxxshipcode = c1xxuxxrbvxxxxxxxxxxshipcode;
	}

	@Column(name = "printmstat")
	public Integer getZ3xxzzprhvxxxxxxxxxxprintmstat() {
		return this.z3xxzzprhvxxxxxxxxxxprintmstat;
	}

	public void setZ3xxzzprhvxxxxxxxxxxprintmstat(
			Integer z3xxzzprhvxxxxxxxxxxprintmstat) {
		this.z3xxzzprhvxxxxxxxxxxprintmstat = z3xxzzprhvxxxxxxxxxxprintmstat;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "prinmtfldt", length = 29)
	public Date getZ4xxczqxlhxxxxxxxxxxprinmtfldt() {
		return this.z4xxczqxlhxxxxxxxxxxprinmtfldt;
	}

	public void setZ4xxczqxlhxxxxxxxxxxprinmtfldt(
			Date z4xxczqxlhxxxxxxxxxxprinmtfldt) {
		this.z4xxczqxlhxxxxxxxxxxprinmtfldt = z4xxczqxlhxxxxxxxxxxprinmtfldt;
	}

	@Column(name = "misccode1", length = 25)
	@Size(max = 25)
	public String getY2xxuxxrbvxxxxxxxxxxmisccode1() {
		return this.y2xxuxxrbvxxxxxxxxxxmisccode1;
	}

	public void setY2xxuxxrbvxxxxxxxxxxmisccode1(
			String y2xxuxxrbvxxxxxxxxxxmisccode1) {
		this.y2xxuxxrbvxxxxxxxxxxmisccode1 = y2xxuxxrbvxxxxxxxxxxmisccode1;
	}

	@Column(name = "misccode2", length = 25)
	@Size(max = 25)
	public String getY3xxuxxrbvxxxxxxxxxxmisccode2() {
		return this.y3xxuxxrbvxxxxxxxxxxmisccode2;
	}

	public void setY3xxuxxrbvxxxxxxxxxxmisccode2(
			String y3xxuxxrbvxxxxxxxxxxmisccode2) {
		this.y3xxuxxrbvxxxxxxxxxxmisccode2 = y3xxuxxrbvxxxxxxxxxxmisccode2;
	}

	@Column(name = "qtylevel1", precision = 14)
	public BigDecimal getC2xxzxxrlvxxxxxxxxxxqtylevel1() {
		return this.c2xxzxxrlvxxxxxxxxxxqtylevel1;
	}

	public void setC2xxzxxrlvxxxxxxxxxxqtylevel1(
			BigDecimal c2xxzxxrlvxxxxxxxxxxqtylevel1) {
		this.c2xxzxxrlvxxxxxxxxxxqtylevel1 = c2xxzxxrlvxxxxxxxxxxqtylevel1;
	}

	@Column(name = "unit", length = 12)
	@Size(max = 12)
	public String getC3xxuuxrbv18xxxxxxxxunit() {
		return this.c3xxuuxrbv18xxxxxxxxunit;
	}

	public void setC3xxuuxrbv18xxxxxxxxunit(String c3xxuuxrbv18xxxxxxxxunit) {
		this.c3xxuuxrbv18xxxxxxxxunit = c3xxuuxrbv18xxxxxxxxunit;
	}

	@Column(name = "caseqty", precision = 14)
	public BigDecimal getC4xxzxxrlvxxxxxxxxxxcaseqty() {
		return this.c4xxzxxrlvxxxxxxxxxxcaseqty;
	}

	public void setC4xxzxxrlvxxxxxxxxxxcaseqty(
			BigDecimal c4xxzxxrlvxxxxxxxxxxcaseqty) {
		this.c4xxzxxrlvxxxxxxxxxxcaseqty = c4xxzxxrlvxxxxxxxxxxcaseqty;
	}

	@Column(name = "type", length = 12)
	@Size(max = 12)
	public String getC5xxuxxrbv37xxxxxxxxtype() {
		return this.c5xxuxxrbv37xxxxxxxxtype;
	}

	public void setC5xxuxxrbv37xxxxxxxxtype(String c5xxuxxrbv37xxxxxxxxtype) {
		this.c5xxuxxrbv37xxxxxxxxtype = c5xxuxxrbv37xxxxxxxxtype;
	}

	@Column(name = "tax1")
	public Boolean getC6xxfxz1bvxxxxxxxxxxtax1() {
		return this.c6xxfxz1bvxxxxxxxxxxtax1;
	}

	public void setC6xxfxz1bvxxxxxxxxxxtax1(Boolean c6xxfxz1bvxxxxxxxxxxtax1) {
		this.c6xxfxz1bvxxxxxxxxxxtax1 = c6xxfxz1bvxxxxxxxxxxtax1;
	}

	@Column(name = "tax2")
	public Boolean getC7xxfxz2bvxxxxxxxxxxtax2() {
		return this.c7xxfxz2bvxxxxxxxxxxtax2;
	}

	public void setC7xxfxz2bvxxxxxxxxxxtax2(Boolean c7xxfxz2bvxxxxxxxxxxtax2) {
		this.c7xxfxz2bvxxxxxxxxxxtax2 = c7xxfxz2bvxxxxxxxxxxtax2;
	}

	@Column(name = "tax3")
	public Boolean getY4xxfxz3xxxvxxxxxxxxxxtax3() {
		return this.y4xxfxz3xxxvxxxxxxxxxxtax3;
	}

	public void setY4xxfxz3xxxvxxxxxxxxxxtax3(Boolean y4xxfxz3xxxvxxxxxxxxxxtax3) {
		this.y4xxfxz3xxxvxxxxxxxxxxtax3 = y4xxfxz3xxxvxxxxxxxxxxtax3;
	}

	@Column(name = "aliascode", length = 25)
	@Size(max = 25)
	public String getY5xxuxxrbvxxxxxxxxxxaliascode() {
		return this.y5xxuxxrbvxxxxxxxxxxaliascode;
	}

	public void setY5xxuxxrbvxxxxxxxxxxaliascode(
			String y5xxuxxrbvxxxxxxxxxxaliascode) {
		this.y5xxuxxrbvxxxxxxxxxxaliascode = y5xxuxxrbvxxxxxxxxxxaliascode;
	}

	@Column(name = "avgprice", precision = 14)
	public BigDecimal getZ5xxzxxrlvxxxxxxxxxxavgprice() {
		return this.z5xxzxxrlvxxxxxxxxxxavgprice;
	}

	public void setZ5xxzxxrlvxxxxxxxxxxavgprice(
			BigDecimal z5xxzxxrlvxxxxxxxxxxavgprice) {
		this.z5xxzxxrlvxxxxxxxxxxavgprice = z5xxzxxrlvxxxxxxxxxxavgprice;
	}

	@Column(name = "avgcost", precision = 14)
	public BigDecimal getZ6xxzxxrlvxxxxxxxxxxavgcost() {
		return this.z6xxzxxrlvxxxxxxxxxxavgcost;
	}

	public void setZ6xxzxxrlvxxxxxxxxxxavgcost(
			BigDecimal z6xxzxxrlvxxxxxxxxxxavgcost) {
		this.z6xxzxxrlvxxxxxxxxxxavgcost = z6xxzxxrlvxxxxxxxxxxavgcost;
	}

	@Column(name = "statusfl")
	public Integer getZ7xxzzfxhhxxxxxxxxxxstatusfl() {
		return this.z7xxzzfxhhxxxxxxxxxxstatusfl;
	}

	public void setZ7xxzzfxhhxxxxxxxxxxstatusfl(
			Integer z7xxzzfxhhxxxxxxxxxxstatusfl) {
		this.z7xxzzfxhhxxxxxxxxxxstatusfl = z7xxzzfxhhxxxxxxxxxxstatusfl;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "statusfldt", length = 29)
	public Date getZ8xxcztxlxxxxxxxxxxxstatusfldt() {
		return this.z8xxcztxlxxxxxxxxxxxstatusfldt;
	}

	public void setZ8xxcztxlxxxxxxxxxxxstatusfldt(
			Date z8xxcztxlxxxxxxxxxxxstatusfldt) {
		this.z8xxcztxlxxxxxxxxxxxstatusfldt = z8xxcztxlxxxxxxxxxxxstatusfldt;
	}

	@Column(name = "subcodesn", length = 35)
	@Size(max = 35)
	public String getG2xxuxn1lvxxxxxxxxxxsubcodesn() {
		return this.g2xxuxn1lvxxxxxxxxxxsubcodesn;
	}

	public void setG2xxuxn1lvxxxxxxxxxxsubcodesn(
			String g2xxuxn1lvxxxxxxxxxxsubcodesn) {
		this.g2xxuxn1lvxxxxxxxxxxsubcodesn = g2xxuxn1lvxxxxxxxxxxsubcodesn;
	}

	@Column(name = "subcodesn2", length = 35)
	@Size(max = 35)
	public String getG2xxuxn2lvxxxxxxxxxxsubcodesn2() {
		return this.g2xxuxn2lvxxxxxxxxxxsubcodesn2;
	}

	public void setG2xxuxn2lvxxxxxxxxxxsubcodesn2(
			String g2xxuxn2lvxxxxxxxxxxsubcodesn2) {
		this.g2xxuxn2lvxxxxxxxxxxsubcodesn2 = g2xxuxn2lvxxxxxxxxxxsubcodesn2;
	}

	@Column(name = "subcodesn3", length = 35)
	@Size(max = 35)
	public String getG2xxuxn3lvxxxxxxxxxxsubcodesn3() {
		return this.g2xxuxn3lvxxxxxxxxxxsubcodesn3;
	}

	public void setG2xxuxn3lvxxxxxxxxxxsubcodesn3(
			String g2xxuxn3lvxxxxxxxxxxsubcodesn3) {
		this.g2xxuxn3lvxxxxxxxxxxsubcodesn3 = g2xxuxn3lvxxxxxxxxxxsubcodesn3;
	}

	@Column(name = "cuordqty", precision = 14)
	public BigDecimal getZbxxzxxrlvxxxxxxxxxxcuordqty() {
		return this.zbxxzxxrlvxxxxxxxxxxcuordqty;
	}

	public void setZbxxzxxrlvxxxxxxxxxxcuordqty(
			BigDecimal zbxxzxxrlvxxxxxxxxxxcuordqty) {
		this.zbxxzxxrlvxxxxxxxxxxcuordqty = zbxxzxxrlvxxxxxxxxxxcuordqty;
	}

	@Column(name = "venorqty", precision = 14)
	public BigDecimal getZcxxzxxrlvxxxxxxxxxxvenorqty() {
		return this.zcxxzxxrlvxxxxxxxxxxvenorqty;
	}

	public void setZcxxzxxrlvxxxxxxxxxxvenorqty(
			BigDecimal zcxxzxxrlvxxxxxxxxxxvenorqty) {
		this.zcxxzxxrlvxxxxxxxxxxvenorqty = zcxxzxxrlvxxxxxxxxxxvenorqty;
	}

	@Column(name = "cupicqty", precision = 14)
	public BigDecimal getZdxxzxxrlvxxxxxxxxxxcupicqty() {
		return this.zdxxzxxrlvxxxxxxxxxxcupicqty;
	}

	public void setZdxxzxxrlvxxxxxxxxxxcupicqty(
			BigDecimal zdxxzxxrlvxxxxxxxxxxcupicqty) {
		this.zdxxzxxrlvxxxxxxxxxxcupicqty = zdxxzxxrlvxxxxxxxxxxcupicqty;
	}

	@Column(name = "venpiqty", precision = 14)
	public BigDecimal getZexxzxxrlvxxxxxxxxxxvenpiqty() {
		return this.zexxzxxrlvxxxxxxxxxxvenpiqty;
	}

	public void setZexxzxxrlvxxxxxxxxxxvenpiqty(
			BigDecimal zexxzxxrlvxxxxxxxxxxvenpiqty) {
		this.zexxzxxrlvxxxxxxxxxxvenpiqty = zexxzxxrlvxxxxxxxxxxvenpiqty;
	}

	@Column(name = "cuinvqty", precision = 14)
	public BigDecimal getZfxxzxxrlvxxxxxxxxxxcuinvqty() {
		return this.zfxxzxxrlvxxxxxxxxxxcuinvqty;
	}

	public void setZfxxzxxrlvxxxxxxxxxxcuinvqty(
			BigDecimal zfxxzxxrlvxxxxxxxxxxcuinvqty) {
		this.zfxxzxxrlvxxxxxxxxxxcuinvqty = zfxxzxxrlvxxxxxxxxxxcuinvqty;
	}

	@Column(name = "cushiqty", precision = 14)
	public BigDecimal getZgxxzxxrlvxxxxxxxxxxcushiqty() {
		return this.zgxxzxxrlvxxxxxxxxxxcushiqty;
	}

	public void setZgxxzxxrlvxxxxxxxxxxcushiqty(
			BigDecimal zgxxzxxrlvxxxxxxxxxxcushiqty) {
		this.zgxxzxxrlvxxxxxxxxxxcushiqty = zgxxzxxrlvxxxxxxxxxxcushiqty;
	}

	@Column(name = "venshqty", precision = 14)
	public BigDecimal getZhxxzxxrlvxxxxxxxxxxvenshqty() {
		return this.zhxxzxxrlvxxxxxxxxxxvenshqty;
	}

	public void setZhxxzxxrlvxxxxxxxxxxvenshqty(
			BigDecimal zhxxzxxrlvxxxxxxxxxxvenshqty) {
		this.zhxxzxxrlvxxxxxxxxxxvenshqty = zhxxzxxrlvxxxxxxxxxxvenshqty;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "effdate", length = 29)
	public Date getC8xxcxxrlxxxxxxxxxxxeffdate() {
		return this.c8xxcxxrlxxxxxxxxxxxeffdate;
	}

	public void setC8xxcxxrlxxxxxxxxxxxeffdate(Date c8xxcxxrlxxxxxxxxxxxeffdate) {
		this.c8xxcxxrlxxxxxxxxxxxeffdate = c8xxcxxrlxxxxxxxxxxxeffdate;
	}

	@Column(name = "integrset", length = 20)
	@Size(max = 20)
	public String getC9xxuwmrbv40xxxxxxxxintegrset() {
		return this.c9xxuwmrbv40xxxxxxxxintegrset;
	}

	public void setC9xxuwmrbv40xxxxxxxxintegrset(
			String c9xxuwmrbv40xxxxxxxxintegrset) {
		this.c9xxuwmrbv40xxxxxxxxintegrset = c9xxuwmrbv40xxxxxxxxintegrset;
	}

	@Column(name = "notes", length = 60)
	@Size(max = 60)
	public String getY7xxuznxbvxxxxxxxxxxnotes() {
		return this.y7xxuznxbvxxxxxxxxxxnotes;
	}

	public void setY7xxuznxbvxxxxxxxxxxnotes(String y7xxuznxbvxxxxxxxxxxnotes) {
		this.y7xxuznxbvxxxxxxxxxxnotes = y7xxuznxbvxxxxxxxxxxnotes;
	}

	@Column(name = "docmnt", length = 90)
	@Size(max = 90)
	public String getY8xxuzdrbvxxxxxxxxxxdocmnt() {
		return this.y8xxuzdrbvxxxxxxxxxxdocmnt;
	}

	public void setY8xxuzdrbvxxxxxxxxxxdocmnt(String y8xxuzdrbvxxxxxxxxxxdocmnt) {
		this.y8xxuzdrbvxxxxxxxxxxdocmnt = y8xxuzdrbvxxxxxxxxxxdocmnt;
	}

	@Column(name = "owner", length = 40)
	@Size(max = 40)
	public String getZixxutoxlhxxxxxxxxxxowner() {
		return this.zixxutoxlhxxxxxxxxxxowner;
	}

	public void setZixxutoxlhxxxxxxxxxxowner(String zixxutoxlhxxxxxxxxxxowner) {
		this.zixxutoxlhxxxxxxxxxxowner = zixxutoxlhxxxxxxxxxxowner;
	}

	@Column(name = "owner2", length = 40)
	@Size(max = 40)
	public String getZzxxu2oxxhxxxxxxxxxxowner2() {
		return this.zzxxu2oxxhxxxxxxxxxxowner2;
	}

	public void setZzxxu2oxxhxxxxxxxxxxowner2(String zzxxu2oxxhxxxxxxxxxxowner2) {
		this.zzxxu2oxxhxxxxxxxxxxowner2 = zzxxu2oxxhxxxxxxxxxxowner2;
	}

	@Column(name = "barupc", length = 30)
	@Size(max = 30)
	public String getZjxxuxxrbvxxxxxxxxxxbarupc() {
		return this.zjxxuxxrbvxxxxxxxxxxbarupc;
	}

	public void setZjxxuxxrbvxxxxxxxxxxbarupc(String zjxxuxxrbvxxxxxxxxxxbarupc) {
		this.zjxxuxxrbvxxxxxxxxxxbarupc = zjxxuxxrbvxxxxxxxxxxbarupc;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "fxxxuq188xwwqqhxxxxxactivity")
	public Set<Xoxxuq943xwwqqhxxxxxactivityjobdetails> getXoxxuq943xwwqqhxxxxxactivityjobdetailses() {
		return this.xoxxuq943xwwqqhxxxxxactivityjobdetailses;
	}

	public void setXoxxuq943xwwqqhxxxxxactivityjobdetailses(
			Set<Xoxxuq943xwwqqhxxxxxactivityjobdetails> xoxxuq943xwwqqhxxxxxactivityjobdetailses) {
		this.xoxxuq943xwwqqhxxxxxactivityjobdetailses = xoxxuq943xwwqqhxxxxxactivityjobdetailses;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "fxxxuq188xwwqqhxxxxxactivity")
	public Set<Txxxuq932xwwqqhspxxxactivityjob> getTxxxuq932xwwqqhspxxxactivityjobs() {
		return this.txxxuq932xwwqqhspxxxactivityjobs;
	}

	public void setTxxxuq932xwwqqhspxxxactivityjobs(
			Set<Txxxuq932xwwqqhspxxxactivityjob> txxxuq932xwwqqhspxxxactivityjobs) {
		this.txxxuq932xwwqqhspxxxactivityjobs = txxxuq932xwwqqhspxxxactivityjobs;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "fxxxuq188xwwqqhxxxxxactivity")
	public Set<Fxxxuq1kkxwwqqhfxxxxtask> getFxxxuq1kkxwwqqhfxxxxtasks() {
		return this.fxxxuq1kkxwwqqhfxxxxtasks;
	}

	public void setFxxxuq1kkxwwqqhfxxxxtasks(
			Set<Fxxxuq1kkxwwqqhfxxxxtask> fxxxuq1kkxwwqqhfxxxxtasks) {
		this.fxxxuq1kkxwwqqhfxxxxtasks = fxxxuq1kkxwwqqhfxxxxtasks;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "fxxxuq188xwwqqhxxxxxactivity")
	public Set<Fxxxuq188xwwqqhxxxxxactivity> getFxxxuq188xwwqqhxxxxxactivities() {
		return this.fxxxuq188xwwqqhxxxxxactivities;
	}

	public void setFxxxuq188xwwqqhxxxxxactivities(
			Set<Fxxxuq188xwwqqhxxxxxactivity> fxxxuq188xwwqqhxxxxxactivities) {
		this.fxxxuq188xwwqqhxxxxxactivities = fxxxuq188xwwqqhxxxxxactivities;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "fxxxuq188xwwqqhxxxxxactivity")
	public Set<Jxxxuq54exwwqqhxxxxxgroupmembers> getJxxxuq54exwwqqhxxxxxgroupmemberses() {
		return this.jxxxuq54exwwqqhxxxxxgroupmemberses;
	}

	public void setJxxxuq54exwwqqhxxxxxgroupmemberses(
			Set<Jxxxuq54exwwqqhxxxxxgroupmembers> jxxxuq54exwwqqhxxxxxgroupmemberses) {
		this.jxxxuq54exwwqqhxxxxxgroupmemberses = jxxxuq54exwwqqhxxxxxgroupmemberses;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "fxxxuq188xwwqqhxxxxxactivity")
	public Set<Fxxxuq89bxwwqqhxxxxxschedule> getFxxxuq89bxwwqqhxxxxxschedules() {
		return this.fxxxuq89bxwwqqhxxxxxschedules;
	}

	public void setFxxxuq89bxwwqqhxxxxxschedules(
			Set<Fxxxuq89bxwwqqhxxxxxschedule> fxxxuq89bxwwqqhxxxxxschedules) {
		this.fxxxuq89bxwwqqhxxxxxschedules = fxxxuq89bxwwqqhxxxxxschedules;
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
