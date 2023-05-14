package com.rcomputer.genapp.model;
// Generated 9-May-2023 8:57:32 PM by Hibernate Tools 4.0.0

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
 * Fpxxuq9eexwwqqhefxxxmachine generated by hbm2java
 */
@Entity
@XmlRootElement
@Table(name = "machine")
public class Fpxxuq9eexwwqqhefxxxmachine implements java.io.Serializable {

	private Integer a0xxuobxbxxxxxxxxxxxsid;
	private Fpxxuq9eexwwqqhefxxxmachine fpxxuq9eexwwqqhefxxxmachine;
	private String a0xxukmxbvxxxxxxxxxxmachinecode;
	private BigDecimal z1xxziqxlvxxxxxxxxxxquantity;
	private String b1xxuszsbvxxxxxxxxxxdescript;
	private Date z2xxcxxrlxxxxxxxxxxxdateadded;
	private String b3xxuxxrbvxxxxxxxxxxsource1;
	private String y1xxuxxrbvxxxxxxxxxxsource2;
	private String b5xxuxxrbvxxxxxxxxxxupccode;
	private BigDecimal b6xxzicxbvxxxxxxxxxxcost;
	private BigDecimal b7xxzxxxbvxxxxxxxxxxreplcost;
	private BigDecimal b8xxzpxxbvxxxxxxxxxxselprice;
	private BigDecimal b9xxzxxxlvxxsxxxxxxxspricold;
	private BigDecimal c1xxzxxxhhxxsxxxxxxxspricnew;
	private Date c2xxcxxrhhxxsxxxxxxxspriceffdt;
	private String c3xxuxxrbvxxxxxxxxxxshipcode;
	private Integer z2xxzzprhvxxxxxxxxxxprintmstat;
	private Date z3xxczqxlhxxxxxxxxxxprinmtfldt;
	private String y2xxuxxrbvxxxxxxxxxxmisccode1;
	private String y3xxuxxrbvxxxxxxxxxxmisccode2;
	private BigDecimal c4xxzxxxbvxxxxxxxxxxqtylevel1;
	private String c5xxuuxrbv18xxxxxxxxunit;
	private BigDecimal y4xxuxxrbvxxxxxxxxxxcaseqty;
	private String c6xxuxxrbv16xxxxxxxxtype;
	private Boolean c7xxfxz1bvxxxxxxxxxxtax1;
	private Boolean c8xxfxz2bvxxxxxxxxxxtax2;
	private Boolean y6xxfxz3bvxxxxxxxxxxtax3;
	private String f1xxuxxrbvxxxxxxxxxxaliascode;
	private BigDecimal f3xxzxxxlvxxxxxxxxxxavgprice;
	private BigDecimal z4xxzxxxlvxxxxxxxxxxavgcost;
	private Integer z5xxzzfxhhxxxxxxxxxxstatusfl;
	private Date z6xxcztxlxxxxxxxxxxxstatusfldt;
	private String g2xxuxn1lvxxxxxxxxxxsubcodesn;
	private String g2xxuxn2lvxxxxxxxxxxsubcodesn2;
	private String g2xxuxn3lvxxxxxxxxxxsubcodesn3;
	private BigDecimal z7xxzxxxlvxxxxxxxxxxcuordqty;
	private BigDecimal z8xxzxxxlvxxxxxxxxxxvenorqty;
	private BigDecimal z9xxzxxxlvxxxxxxxxxxcupicqty;
	private BigDecimal zaxxzxxxlvxxxxxxxxxxvenpiqty;
	private BigDecimal zbxxzxxxlvxxxxxxxxxxcuinvqty;
	private BigDecimal zcxxzxxxlvxxxxxxxxxxcushiqty;
	private BigDecimal zdxxzxxxlvxxxxxxxxxxvenshqty;
	private Date h1xxcxxrlxxxxxxxxxxxeffdate;
	private String h2xxuwmrbv40xxxxxxxxintegrset;
	private String y7xxuxznbvxxxxxxxxxxnotes;
	private String y8xxuzdrbvxxxxxxxxxxdocmnt;
	private String zexxutoxlhxxxxxxxxxxowner;
	private String zzxxu2oxxhxxxxxxxxxxowner2;
	private String zxxrbvxxxvxxxxxxxxxxbarupc;
	private Set<Xoxxuq9bfxwwqqhexxxxjobassignmentdetails> xoxxuq9bfxwwqqhexxxxjobassignmentdetailses = new HashSet<Xoxxuq9bfxwwqqhexxxxjobassignmentdetails>(
			0);
	private Set<Jxxxuq54exwwqqhxxxxxgroupmembers> jxxxuq54exwwqqhxxxxxgroupmemberses = new HashSet<Jxxxuq54exwwqqhxxxxxgroupmembers>(
			0);
	private Set<Trxxuq9aaxwwqqhefxxxjobassignment> trxxuq9aaxwwqqhefxxxjobassignments = new HashSet<Trxxuq9aaxwwqqhefxxxjobassignment>(
			0);
	private Set<Fpxxuq9eexwwqqhefxxxmachine> fpxxuq9eexwwqqhefxxxmachines = new HashSet<Fpxxuq9eexwwqqhefxxxmachine>(
			0);

	public Fpxxuq9eexwwqqhefxxxmachine() {
	}

	public Fpxxuq9eexwwqqhefxxxmachine(String a0xxukmxbvxxxxxxxxxxmachinecode) {
		this.a0xxukmxbvxxxxxxxxxxmachinecode = a0xxukmxbvxxxxxxxxxxmachinecode;
	}
	public Fpxxuq9eexwwqqhefxxxmachine(
			Fpxxuq9eexwwqqhefxxxmachine fpxxuq9eexwwqqhefxxxmachine,
			String a0xxukmxbvxxxxxxxxxxmachinecode,
			BigDecimal z1xxziqxlvxxxxxxxxxxquantity,
			String b1xxuszsbvxxxxxxxxxxdescript,
			Date z2xxcxxrlxxxxxxxxxxxdateadded,
			String b3xxuxxrbvxxxxxxxxxxsource1,
			String y1xxuxxrbvxxxxxxxxxxsource2,
			String b5xxuxxrbvxxxxxxxxxxupccode,
			BigDecimal b6xxzicxbvxxxxxxxxxxcost,
			BigDecimal b7xxzxxxbvxxxxxxxxxxreplcost,
			BigDecimal b8xxzpxxbvxxxxxxxxxxselprice,
			BigDecimal b9xxzxxxlvxxsxxxxxxxspricold,
			BigDecimal c1xxzxxxhhxxsxxxxxxxspricnew,
			Date c2xxcxxrhhxxsxxxxxxxspriceffdt,
			String c3xxuxxrbvxxxxxxxxxxshipcode,
			Integer z2xxzzprhvxxxxxxxxxxprintmstat,
			Date z3xxczqxlhxxxxxxxxxxprinmtfldt,
			String y2xxuxxrbvxxxxxxxxxxmisccode1,
			String y3xxuxxrbvxxxxxxxxxxmisccode2,
			BigDecimal c4xxzxxxbvxxxxxxxxxxqtylevel1,
			String c5xxuuxrbv18xxxxxxxxunit,
			BigDecimal y4xxuxxrbvxxxxxxxxxxcaseqty,
			String c6xxuxxrbv16xxxxxxxxtype,
			Boolean c7xxfxz1bvxxxxxxxxxxtax1,
			Boolean c8xxfxz2bvxxxxxxxxxxtax2,
			Boolean y6xxfxz3bvxxxxxxxxxxtax3,
			String f1xxuxxrbvxxxxxxxxxxaliascode,
			BigDecimal f3xxzxxxlvxxxxxxxxxxavgprice,
			BigDecimal z4xxzxxxlvxxxxxxxxxxavgcost,
			Integer z5xxzzfxhhxxxxxxxxxxstatusfl,
			Date z6xxcztxlxxxxxxxxxxxstatusfldt,
			String g2xxuxn1lvxxxxxxxxxxsubcodesn,
			String g2xxuxn2lvxxxxxxxxxxsubcodesn2,
			String g2xxuxn3lvxxxxxxxxxxsubcodesn3,
			BigDecimal z7xxzxxxlvxxxxxxxxxxcuordqty,
			BigDecimal z8xxzxxxlvxxxxxxxxxxvenorqty,
			BigDecimal z9xxzxxxlvxxxxxxxxxxcupicqty,
			BigDecimal zaxxzxxxlvxxxxxxxxxxvenpiqty,
			BigDecimal zbxxzxxxlvxxxxxxxxxxcuinvqty,
			BigDecimal zcxxzxxxlvxxxxxxxxxxcushiqty,
			BigDecimal zdxxzxxxlvxxxxxxxxxxvenshqty,
			Date h1xxcxxrlxxxxxxxxxxxeffdate,
			String h2xxuwmrbv40xxxxxxxxintegrset,
			String y7xxuxznbvxxxxxxxxxxnotes,
			String y8xxuzdrbvxxxxxxxxxxdocmnt,
			String zexxutoxlhxxxxxxxxxxowner,
			String zzxxu2oxxhxxxxxxxxxxowner2,
			String zxxrbvxxxvxxxxxxxxxxbarupc,
			Set<Xoxxuq9bfxwwqqhexxxxjobassignmentdetails> xoxxuq9bfxwwqqhexxxxjobassignmentdetailses,
			Set<Jxxxuq54exwwqqhxxxxxgroupmembers> jxxxuq54exwwqqhxxxxxgroupmemberses,
			Set<Trxxuq9aaxwwqqhefxxxjobassignment> trxxuq9aaxwwqqhefxxxjobassignments,
			Set<Fpxxuq9eexwwqqhefxxxmachine> fpxxuq9eexwwqqhefxxxmachines) {
		this.fpxxuq9eexwwqqhefxxxmachine = fpxxuq9eexwwqqhefxxxmachine;
		this.a0xxukmxbvxxxxxxxxxxmachinecode = a0xxukmxbvxxxxxxxxxxmachinecode;
		this.z1xxziqxlvxxxxxxxxxxquantity = z1xxziqxlvxxxxxxxxxxquantity;
		this.b1xxuszsbvxxxxxxxxxxdescript = b1xxuszsbvxxxxxxxxxxdescript;
		this.z2xxcxxrlxxxxxxxxxxxdateadded = z2xxcxxrlxxxxxxxxxxxdateadded;
		this.b3xxuxxrbvxxxxxxxxxxsource1 = b3xxuxxrbvxxxxxxxxxxsource1;
		this.y1xxuxxrbvxxxxxxxxxxsource2 = y1xxuxxrbvxxxxxxxxxxsource2;
		this.b5xxuxxrbvxxxxxxxxxxupccode = b5xxuxxrbvxxxxxxxxxxupccode;
		this.b6xxzicxbvxxxxxxxxxxcost = b6xxzicxbvxxxxxxxxxxcost;
		this.b7xxzxxxbvxxxxxxxxxxreplcost = b7xxzxxxbvxxxxxxxxxxreplcost;
		this.b8xxzpxxbvxxxxxxxxxxselprice = b8xxzpxxbvxxxxxxxxxxselprice;
		this.b9xxzxxxlvxxsxxxxxxxspricold = b9xxzxxxlvxxsxxxxxxxspricold;
		this.c1xxzxxxhhxxsxxxxxxxspricnew = c1xxzxxxhhxxsxxxxxxxspricnew;
		this.c2xxcxxrhhxxsxxxxxxxspriceffdt = c2xxcxxrhhxxsxxxxxxxspriceffdt;
		this.c3xxuxxrbvxxxxxxxxxxshipcode = c3xxuxxrbvxxxxxxxxxxshipcode;
		this.z2xxzzprhvxxxxxxxxxxprintmstat = z2xxzzprhvxxxxxxxxxxprintmstat;
		this.z3xxczqxlhxxxxxxxxxxprinmtfldt = z3xxczqxlhxxxxxxxxxxprinmtfldt;
		this.y2xxuxxrbvxxxxxxxxxxmisccode1 = y2xxuxxrbvxxxxxxxxxxmisccode1;
		this.y3xxuxxrbvxxxxxxxxxxmisccode2 = y3xxuxxrbvxxxxxxxxxxmisccode2;
		this.c4xxzxxxbvxxxxxxxxxxqtylevel1 = c4xxzxxxbvxxxxxxxxxxqtylevel1;
		this.c5xxuuxrbv18xxxxxxxxunit = c5xxuuxrbv18xxxxxxxxunit;
		this.y4xxuxxrbvxxxxxxxxxxcaseqty = y4xxuxxrbvxxxxxxxxxxcaseqty;
		this.c6xxuxxrbv16xxxxxxxxtype = c6xxuxxrbv16xxxxxxxxtype;
		this.c7xxfxz1bvxxxxxxxxxxtax1 = c7xxfxz1bvxxxxxxxxxxtax1;
		this.c8xxfxz2bvxxxxxxxxxxtax2 = c8xxfxz2bvxxxxxxxxxxtax2;
		this.y6xxfxz3bvxxxxxxxxxxtax3 = y6xxfxz3bvxxxxxxxxxxtax3;
		this.f1xxuxxrbvxxxxxxxxxxaliascode = f1xxuxxrbvxxxxxxxxxxaliascode;
		this.f3xxzxxxlvxxxxxxxxxxavgprice = f3xxzxxxlvxxxxxxxxxxavgprice;
		this.z4xxzxxxlvxxxxxxxxxxavgcost = z4xxzxxxlvxxxxxxxxxxavgcost;
		this.z5xxzzfxhhxxxxxxxxxxstatusfl = z5xxzzfxhhxxxxxxxxxxstatusfl;
		this.z6xxcztxlxxxxxxxxxxxstatusfldt = z6xxcztxlxxxxxxxxxxxstatusfldt;
		this.g2xxuxn1lvxxxxxxxxxxsubcodesn = g2xxuxn1lvxxxxxxxxxxsubcodesn;
		this.g2xxuxn2lvxxxxxxxxxxsubcodesn2 = g2xxuxn2lvxxxxxxxxxxsubcodesn2;
		this.g2xxuxn3lvxxxxxxxxxxsubcodesn3 = g2xxuxn3lvxxxxxxxxxxsubcodesn3;
		this.z7xxzxxxlvxxxxxxxxxxcuordqty = z7xxzxxxlvxxxxxxxxxxcuordqty;
		this.z8xxzxxxlvxxxxxxxxxxvenorqty = z8xxzxxxlvxxxxxxxxxxvenorqty;
		this.z9xxzxxxlvxxxxxxxxxxcupicqty = z9xxzxxxlvxxxxxxxxxxcupicqty;
		this.zaxxzxxxlvxxxxxxxxxxvenpiqty = zaxxzxxxlvxxxxxxxxxxvenpiqty;
		this.zbxxzxxxlvxxxxxxxxxxcuinvqty = zbxxzxxxlvxxxxxxxxxxcuinvqty;
		this.zcxxzxxxlvxxxxxxxxxxcushiqty = zcxxzxxxlvxxxxxxxxxxcushiqty;
		this.zdxxzxxxlvxxxxxxxxxxvenshqty = zdxxzxxxlvxxxxxxxxxxvenshqty;
		this.h1xxcxxrlxxxxxxxxxxxeffdate = h1xxcxxrlxxxxxxxxxxxeffdate;
		this.h2xxuwmrbv40xxxxxxxxintegrset = h2xxuwmrbv40xxxxxxxxintegrset;
		this.y7xxuxznbvxxxxxxxxxxnotes = y7xxuxznbvxxxxxxxxxxnotes;
		this.y8xxuzdrbvxxxxxxxxxxdocmnt = y8xxuzdrbvxxxxxxxxxxdocmnt;
		this.zexxutoxlhxxxxxxxxxxowner = zexxutoxlhxxxxxxxxxxowner;
		this.zzxxu2oxxhxxxxxxxxxxowner2 = zzxxu2oxxhxxxxxxxxxxowner2;
		this.zxxrbvxxxvxxxxxxxxxxbarupc = zxxrbvxxxvxxxxxxxxxxbarupc;
		this.xoxxuq9bfxwwqqhexxxxjobassignmentdetailses = xoxxuq9bfxwwqqhexxxxjobassignmentdetailses;
		this.jxxxuq54exwwqqhxxxxxgroupmemberses = jxxxuq54exwwqqhxxxxxgroupmemberses;
		this.trxxuq9aaxwwqqhefxxxjobassignments = trxxuq9aaxwwqqhefxxxjobassignments;
		this.fpxxuq9eexwwqqhefxxxmachines = fpxxuq9eexwwqqhefxxxmachines;
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
	public Fpxxuq9eexwwqqhefxxxmachine getFpxxuq9eexwwqqhefxxxmachine() {
		return this.fpxxuq9eexwwqqhefxxxmachine;
	}

	public void setFpxxuq9eexwwqqhefxxxmachine(
			Fpxxuq9eexwwqqhefxxxmachine fpxxuq9eexwwqqhefxxxmachine) {
		this.fpxxuq9eexwwqqhefxxxmachine = fpxxuq9eexwwqqhefxxxmachine;
	}

	@Column(name = "machinecode", nullable = false, length = 32)
	@NotNull
	@Size(max = 32)
	public String getA0xxukmxbvxxxxxxxxxxmachinecode() {
		return this.a0xxukmxbvxxxxxxxxxxmachinecode;
	}

	public void setA0xxukmxbvxxxxxxxxxxmachinecode(
			String a0xxukmxbvxxxxxxxxxxmachinecode) {
		this.a0xxukmxbvxxxxxxxxxxmachinecode = a0xxukmxbvxxxxxxxxxxmachinecode;
	}

	@Column(name = "quantity", precision = 14)
	public BigDecimal getZ1xxziqxlvxxxxxxxxxxquantity() {
		return this.z1xxziqxlvxxxxxxxxxxquantity;
	}

	public void setZ1xxziqxlvxxxxxxxxxxquantity(
			BigDecimal z1xxziqxlvxxxxxxxxxxquantity) {
		this.z1xxziqxlvxxxxxxxxxxquantity = z1xxziqxlvxxxxxxxxxxquantity;
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
	@Column(name = "dateadded", length = 29)
	public Date getZ2xxcxxrlxxxxxxxxxxxdateadded() {
		return this.z2xxcxxrlxxxxxxxxxxxdateadded;
	}

	public void setZ2xxcxxrlxxxxxxxxxxxdateadded(
			Date z2xxcxxrlxxxxxxxxxxxdateadded) {
		this.z2xxcxxrlxxxxxxxxxxxdateadded = z2xxcxxrlxxxxxxxxxxxdateadded;
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
	public String getB5xxuxxrbvxxxxxxxxxxupccode() {
		return this.b5xxuxxrbvxxxxxxxxxxupccode;
	}

	public void setB5xxuxxrbvxxxxxxxxxxupccode(
			String b5xxuxxrbvxxxxxxxxxxupccode) {
		this.b5xxuxxrbvxxxxxxxxxxupccode = b5xxuxxrbvxxxxxxxxxxupccode;
	}

	@Column(name = "cost", precision = 14)
	public BigDecimal getB6xxzicxbvxxxxxxxxxxcost() {
		return this.b6xxzicxbvxxxxxxxxxxcost;
	}

	public void setB6xxzicxbvxxxxxxxxxxcost(BigDecimal b6xxzicxbvxxxxxxxxxxcost) {
		this.b6xxzicxbvxxxxxxxxxxcost = b6xxzicxbvxxxxxxxxxxcost;
	}

	@Column(name = "replcost", precision = 14)
	public BigDecimal getB7xxzxxxbvxxxxxxxxxxreplcost() {
		return this.b7xxzxxxbvxxxxxxxxxxreplcost;
	}

	public void setB7xxzxxxbvxxxxxxxxxxreplcost(
			BigDecimal b7xxzxxxbvxxxxxxxxxxreplcost) {
		this.b7xxzxxxbvxxxxxxxxxxreplcost = b7xxzxxxbvxxxxxxxxxxreplcost;
	}

	@Column(name = "selprice", precision = 14)
	public BigDecimal getB8xxzpxxbvxxxxxxxxxxselprice() {
		return this.b8xxzpxxbvxxxxxxxxxxselprice;
	}

	public void setB8xxzpxxbvxxxxxxxxxxselprice(
			BigDecimal b8xxzpxxbvxxxxxxxxxxselprice) {
		this.b8xxzpxxbvxxxxxxxxxxselprice = b8xxzpxxbvxxxxxxxxxxselprice;
	}

	@Column(name = "spricold", precision = 14)
	public BigDecimal getB9xxzxxxlvxxsxxxxxxxspricold() {
		return this.b9xxzxxxlvxxsxxxxxxxspricold;
	}

	public void setB9xxzxxxlvxxsxxxxxxxspricold(
			BigDecimal b9xxzxxxlvxxsxxxxxxxspricold) {
		this.b9xxzxxxlvxxsxxxxxxxspricold = b9xxzxxxlvxxsxxxxxxxspricold;
	}

	@Column(name = "spricnew", precision = 14)
	public BigDecimal getC1xxzxxxhhxxsxxxxxxxspricnew() {
		return this.c1xxzxxxhhxxsxxxxxxxspricnew;
	}

	public void setC1xxzxxxhhxxsxxxxxxxspricnew(
			BigDecimal c1xxzxxxhhxxsxxxxxxxspricnew) {
		this.c1xxzxxxhhxxsxxxxxxxspricnew = c1xxzxxxhhxxsxxxxxxxspricnew;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "spriceffdt", length = 29)
	public Date getC2xxcxxrhhxxsxxxxxxxspriceffdt() {
		return this.c2xxcxxrhhxxsxxxxxxxspriceffdt;
	}

	public void setC2xxcxxrhhxxsxxxxxxxspriceffdt(
			Date c2xxcxxrhhxxsxxxxxxxspriceffdt) {
		this.c2xxcxxrhhxxsxxxxxxxspriceffdt = c2xxcxxrhhxxsxxxxxxxspriceffdt;
	}

	@Column(name = "shipcode", length = 25)
	@Size(max = 25)
	public String getC3xxuxxrbvxxxxxxxxxxshipcode() {
		return this.c3xxuxxrbvxxxxxxxxxxshipcode;
	}

	public void setC3xxuxxrbvxxxxxxxxxxshipcode(
			String c3xxuxxrbvxxxxxxxxxxshipcode) {
		this.c3xxuxxrbvxxxxxxxxxxshipcode = c3xxuxxrbvxxxxxxxxxxshipcode;
	}

	@Column(name = "printmstat")
	public Integer getZ2xxzzprhvxxxxxxxxxxprintmstat() {
		return this.z2xxzzprhvxxxxxxxxxxprintmstat;
	}

	public void setZ2xxzzprhvxxxxxxxxxxprintmstat(
			Integer z2xxzzprhvxxxxxxxxxxprintmstat) {
		this.z2xxzzprhvxxxxxxxxxxprintmstat = z2xxzzprhvxxxxxxxxxxprintmstat;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "prinmtfldt", length = 29)
	public Date getZ3xxczqxlhxxxxxxxxxxprinmtfldt() {
		return this.z3xxczqxlhxxxxxxxxxxprinmtfldt;
	}

	public void setZ3xxczqxlhxxxxxxxxxxprinmtfldt(
			Date z3xxczqxlhxxxxxxxxxxprinmtfldt) {
		this.z3xxczqxlhxxxxxxxxxxprinmtfldt = z3xxczqxlhxxxxxxxxxxprinmtfldt;
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
	public BigDecimal getC4xxzxxxbvxxxxxxxxxxqtylevel1() {
		return this.c4xxzxxxbvxxxxxxxxxxqtylevel1;
	}

	public void setC4xxzxxxbvxxxxxxxxxxqtylevel1(
			BigDecimal c4xxzxxxbvxxxxxxxxxxqtylevel1) {
		this.c4xxzxxxbvxxxxxxxxxxqtylevel1 = c4xxzxxxbvxxxxxxxxxxqtylevel1;
	}

	@Column(name = "unit", length = 12)
	@Size(max = 12)
	public String getC5xxuuxrbv18xxxxxxxxunit() {
		return this.c5xxuuxrbv18xxxxxxxxunit;
	}

	public void setC5xxuuxrbv18xxxxxxxxunit(String c5xxuuxrbv18xxxxxxxxunit) {
		this.c5xxuuxrbv18xxxxxxxxunit = c5xxuuxrbv18xxxxxxxxunit;
	}

	@Column(name = "caseqty", precision = 14)
	public BigDecimal getY4xxuxxrbvxxxxxxxxxxcaseqty() {
		return this.y4xxuxxrbvxxxxxxxxxxcaseqty;
	}

	public void setY4xxuxxrbvxxxxxxxxxxcaseqty(
			BigDecimal y4xxuxxrbvxxxxxxxxxxcaseqty) {
		this.y4xxuxxrbvxxxxxxxxxxcaseqty = y4xxuxxrbvxxxxxxxxxxcaseqty;
	}

	@Column(name = "type", length = 12)
	@Size(max = 12)
	public String getC6xxuxxrbv16xxxxxxxxtype() {
		return this.c6xxuxxrbv16xxxxxxxxtype;
	}

	public void setC6xxuxxrbv16xxxxxxxxtype(String c6xxuxxrbv16xxxxxxxxtype) {
		this.c6xxuxxrbv16xxxxxxxxtype = c6xxuxxrbv16xxxxxxxxtype;
	}

	@Column(name = "tax1")
	public Boolean getC7xxfxz1bvxxxxxxxxxxtax1() {
		return this.c7xxfxz1bvxxxxxxxxxxtax1;
	}

	public void setC7xxfxz1bvxxxxxxxxxxtax1(Boolean c7xxfxz1bvxxxxxxxxxxtax1) {
		this.c7xxfxz1bvxxxxxxxxxxtax1 = c7xxfxz1bvxxxxxxxxxxtax1;
	}

	@Column(name = "tax2")
	public Boolean getC8xxfxz2bvxxxxxxxxxxtax2() {
		return this.c8xxfxz2bvxxxxxxxxxxtax2;
	}

	public void setC8xxfxz2bvxxxxxxxxxxtax2(Boolean c8xxfxz2bvxxxxxxxxxxtax2) {
		this.c8xxfxz2bvxxxxxxxxxxtax2 = c8xxfxz2bvxxxxxxxxxxtax2;
	}

	@Column(name = "tax3")
	public Boolean getY6xxfxz3bvxxxxxxxxxxtax3() {
		return this.y6xxfxz3bvxxxxxxxxxxtax3;
	}

	public void setY6xxfxz3bvxxxxxxxxxxtax3(Boolean y6xxfxz3bvxxxxxxxxxxtax3) {
		this.y6xxfxz3bvxxxxxxxxxxtax3 = y6xxfxz3bvxxxxxxxxxxtax3;
	}

	@Column(name = "aliascode", length = 25)
	@Size(max = 25)
	public String getF1xxuxxrbvxxxxxxxxxxaliascode() {
		return this.f1xxuxxrbvxxxxxxxxxxaliascode;
	}

	public void setF1xxuxxrbvxxxxxxxxxxaliascode(
			String f1xxuxxrbvxxxxxxxxxxaliascode) {
		this.f1xxuxxrbvxxxxxxxxxxaliascode = f1xxuxxrbvxxxxxxxxxxaliascode;
	}

	@Column(name = "avgprice", precision = 14)
	public BigDecimal getF3xxzxxxlvxxxxxxxxxxavgprice() {
		return this.f3xxzxxxlvxxxxxxxxxxavgprice;
	}

	public void setF3xxzxxxlvxxxxxxxxxxavgprice(
			BigDecimal f3xxzxxxlvxxxxxxxxxxavgprice) {
		this.f3xxzxxxlvxxxxxxxxxxavgprice = f3xxzxxxlvxxxxxxxxxxavgprice;
	}

	@Column(name = "avgcost", precision = 14)
	public BigDecimal getZ4xxzxxxlvxxxxxxxxxxavgcost() {
		return this.z4xxzxxxlvxxxxxxxxxxavgcost;
	}

	public void setZ4xxzxxxlvxxxxxxxxxxavgcost(
			BigDecimal z4xxzxxxlvxxxxxxxxxxavgcost) {
		this.z4xxzxxxlvxxxxxxxxxxavgcost = z4xxzxxxlvxxxxxxxxxxavgcost;
	}

	@Column(name = "statusfl")
	public Integer getZ5xxzzfxhhxxxxxxxxxxstatusfl() {
		return this.z5xxzzfxhhxxxxxxxxxxstatusfl;
	}

	public void setZ5xxzzfxhhxxxxxxxxxxstatusfl(
			Integer z5xxzzfxhhxxxxxxxxxxstatusfl) {
		this.z5xxzzfxhhxxxxxxxxxxstatusfl = z5xxzzfxhhxxxxxxxxxxstatusfl;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "statusfldt", length = 29)
	public Date getZ6xxcztxlxxxxxxxxxxxstatusfldt() {
		return this.z6xxcztxlxxxxxxxxxxxstatusfldt;
	}

	public void setZ6xxcztxlxxxxxxxxxxxstatusfldt(
			Date z6xxcztxlxxxxxxxxxxxstatusfldt) {
		this.z6xxcztxlxxxxxxxxxxxstatusfldt = z6xxcztxlxxxxxxxxxxxstatusfldt;
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
	public BigDecimal getZ7xxzxxxlvxxxxxxxxxxcuordqty() {
		return this.z7xxzxxxlvxxxxxxxxxxcuordqty;
	}

	public void setZ7xxzxxxlvxxxxxxxxxxcuordqty(
			BigDecimal z7xxzxxxlvxxxxxxxxxxcuordqty) {
		this.z7xxzxxxlvxxxxxxxxxxcuordqty = z7xxzxxxlvxxxxxxxxxxcuordqty;
	}

	@Column(name = "venorqty", precision = 14)
	public BigDecimal getZ8xxzxxxlvxxxxxxxxxxvenorqty() {
		return this.z8xxzxxxlvxxxxxxxxxxvenorqty;
	}

	public void setZ8xxzxxxlvxxxxxxxxxxvenorqty(
			BigDecimal z8xxzxxxlvxxxxxxxxxxvenorqty) {
		this.z8xxzxxxlvxxxxxxxxxxvenorqty = z8xxzxxxlvxxxxxxxxxxvenorqty;
	}

	@Column(name = "cupicqty", precision = 14)
	public BigDecimal getZ9xxzxxxlvxxxxxxxxxxcupicqty() {
		return this.z9xxzxxxlvxxxxxxxxxxcupicqty;
	}

	public void setZ9xxzxxxlvxxxxxxxxxxcupicqty(
			BigDecimal z9xxzxxxlvxxxxxxxxxxcupicqty) {
		this.z9xxzxxxlvxxxxxxxxxxcupicqty = z9xxzxxxlvxxxxxxxxxxcupicqty;
	}

	@Column(name = "venpiqty", precision = 14)
	public BigDecimal getZaxxzxxxlvxxxxxxxxxxvenpiqty() {
		return this.zaxxzxxxlvxxxxxxxxxxvenpiqty;
	}

	public void setZaxxzxxxlvxxxxxxxxxxvenpiqty(
			BigDecimal zaxxzxxxlvxxxxxxxxxxvenpiqty) {
		this.zaxxzxxxlvxxxxxxxxxxvenpiqty = zaxxzxxxlvxxxxxxxxxxvenpiqty;
	}

	@Column(name = "cuinvqty", precision = 14)
	public BigDecimal getZbxxzxxxlvxxxxxxxxxxcuinvqty() {
		return this.zbxxzxxxlvxxxxxxxxxxcuinvqty;
	}

	public void setZbxxzxxxlvxxxxxxxxxxcuinvqty(
			BigDecimal zbxxzxxxlvxxxxxxxxxxcuinvqty) {
		this.zbxxzxxxlvxxxxxxxxxxcuinvqty = zbxxzxxxlvxxxxxxxxxxcuinvqty;
	}

	@Column(name = "cushiqty", precision = 14)
	public BigDecimal getZcxxzxxxlvxxxxxxxxxxcushiqty() {
		return this.zcxxzxxxlvxxxxxxxxxxcushiqty;
	}

	public void setZcxxzxxxlvxxxxxxxxxxcushiqty(
			BigDecimal zcxxzxxxlvxxxxxxxxxxcushiqty) {
		this.zcxxzxxxlvxxxxxxxxxxcushiqty = zcxxzxxxlvxxxxxxxxxxcushiqty;
	}

	@Column(name = "venshqty", precision = 14)
	public BigDecimal getZdxxzxxxlvxxxxxxxxxxvenshqty() {
		return this.zdxxzxxxlvxxxxxxxxxxvenshqty;
	}

	public void setZdxxzxxxlvxxxxxxxxxxvenshqty(
			BigDecimal zdxxzxxxlvxxxxxxxxxxvenshqty) {
		this.zdxxzxxxlvxxxxxxxxxxvenshqty = zdxxzxxxlvxxxxxxxxxxvenshqty;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "effdate", length = 29)
	public Date getH1xxcxxrlxxxxxxxxxxxeffdate() {
		return this.h1xxcxxrlxxxxxxxxxxxeffdate;
	}

	public void setH1xxcxxrlxxxxxxxxxxxeffdate(Date h1xxcxxrlxxxxxxxxxxxeffdate) {
		this.h1xxcxxrlxxxxxxxxxxxeffdate = h1xxcxxrlxxxxxxxxxxxeffdate;
	}

	@Column(name = "integrset", length = 20)
	@Size(max = 20)
	public String getH2xxuwmrbv40xxxxxxxxintegrset() {
		return this.h2xxuwmrbv40xxxxxxxxintegrset;
	}

	public void setH2xxuwmrbv40xxxxxxxxintegrset(
			String h2xxuwmrbv40xxxxxxxxintegrset) {
		this.h2xxuwmrbv40xxxxxxxxintegrset = h2xxuwmrbv40xxxxxxxxintegrset;
	}

	@Column(name = "notes", length = 60)
	@Size(max = 60)
	public String getY7xxuxznbvxxxxxxxxxxnotes() {
		return this.y7xxuxznbvxxxxxxxxxxnotes;
	}

	public void setY7xxuxznbvxxxxxxxxxxnotes(String y7xxuxznbvxxxxxxxxxxnotes) {
		this.y7xxuxznbvxxxxxxxxxxnotes = y7xxuxznbvxxxxxxxxxxnotes;
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
	public String getZexxutoxlhxxxxxxxxxxowner() {
		return this.zexxutoxlhxxxxxxxxxxowner;
	}

	public void setZexxutoxlhxxxxxxxxxxowner(String zexxutoxlhxxxxxxxxxxowner) {
		this.zexxutoxlhxxxxxxxxxxowner = zexxutoxlhxxxxxxxxxxowner;
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
	public String getZxxrbvxxxvxxxxxxxxxxbarupc() {
		return this.zxxrbvxxxvxxxxxxxxxxbarupc;
	}

	public void setZxxrbvxxxvxxxxxxxxxxbarupc(String zxxrbvxxxvxxxxxxxxxxbarupc) {
		this.zxxrbvxxxvxxxxxxxxxxbarupc = zxxrbvxxxvxxxxxxxxxxbarupc;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "fpxxuq9eexwwqqhefxxxmachine")
	public Set<Xoxxuq9bfxwwqqhexxxxjobassignmentdetails> getXoxxuq9bfxwwqqhexxxxjobassignmentdetailses() {
		return this.xoxxuq9bfxwwqqhexxxxjobassignmentdetailses;
	}

	public void setXoxxuq9bfxwwqqhexxxxjobassignmentdetailses(
			Set<Xoxxuq9bfxwwqqhexxxxjobassignmentdetails> xoxxuq9bfxwwqqhexxxxjobassignmentdetailses) {
		this.xoxxuq9bfxwwqqhexxxxjobassignmentdetailses = xoxxuq9bfxwwqqhexxxxjobassignmentdetailses;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "fpxxuq9eexwwqqhefxxxmachine")
	public Set<Jxxxuq54exwwqqhxxxxxgroupmembers> getJxxxuq54exwwqqhxxxxxgroupmemberses() {
		return this.jxxxuq54exwwqqhxxxxxgroupmemberses;
	}

	public void setJxxxuq54exwwqqhxxxxxgroupmemberses(
			Set<Jxxxuq54exwwqqhxxxxxgroupmembers> jxxxuq54exwwqqhxxxxxgroupmemberses) {
		this.jxxxuq54exwwqqhxxxxxgroupmemberses = jxxxuq54exwwqqhxxxxxgroupmemberses;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "fpxxuq9eexwwqqhefxxxmachine")
	public Set<Trxxuq9aaxwwqqhefxxxjobassignment> getTrxxuq9aaxwwqqhefxxxjobassignments() {
		return this.trxxuq9aaxwwqqhefxxxjobassignments;
	}

	public void setTrxxuq9aaxwwqqhefxxxjobassignments(
			Set<Trxxuq9aaxwwqqhefxxxjobassignment> trxxuq9aaxwwqqhefxxxjobassignments) {
		this.trxxuq9aaxwwqqhefxxxjobassignments = trxxuq9aaxwwqqhefxxxjobassignments;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "fpxxuq9eexwwqqhefxxxmachine")
	public Set<Fpxxuq9eexwwqqhefxxxmachine> getFpxxuq9eexwwqqhefxxxmachines() {
		return this.fpxxuq9eexwwqqhefxxxmachines;
	}

	public void setFpxxuq9eexwwqqhefxxxmachines(
			Set<Fpxxuq9eexwwqqhefxxxmachine> fpxxuq9eexwwqqhefxxxmachines) {
		this.fpxxuq9eexwwqqhefxxxmachines = fpxxuq9eexwwqqhefxxxmachines;
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
