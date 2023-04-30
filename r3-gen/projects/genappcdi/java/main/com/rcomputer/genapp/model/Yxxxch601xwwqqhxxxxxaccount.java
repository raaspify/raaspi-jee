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
 * Yxxxch601xwwqqhxxxxxaccount generated by hbm2java
 */
@Entity
@XmlRootElement
@Table(name = "account")
public class Yxxxch601xwwqqhxxxxxaccount implements java.io.Serializable {

	private Integer a0xxuobxbxxxxxxxxxxxsid;
	private Fxxxch133xhhxqhxxlxxdivision fxxxch133xhhxqhxxlxxdivision;
	private Fxxxch122xhhxqhxxlxxdepartment fxxxch122xhhxqhxxlxxdepartment;
	private Dxxxch1d3xwwqqhxxlxxcompany dxxxch1d3xwwqqhxxlxxcompany;
	private String a0xxukwxbvxxxxxxxxxxaccount;
	private String a1xxuzsxbvxxxxxxxxxxdescript;
	private String b1xxuwgxbv01xxxxxxxxcategory;
	private String b2xxuwtxbv02xxxxxxxxtype;
	private BigDecimal b3xxzwbxbvxxxxxxxxxxbudget;
	private BigDecimal b4xxzwaxlvxxxxxxxxxxactual;
	private BigDecimal z2xxzwanlvxxxxxxxxxxactualn;
	private BigDecimal z3xxzwbpavxxxxxxxxxxprevbudg;
	private BigDecimal z4xxzwaplvxxxxxxxxxxprevact;
	private Integer y2xxzwsxavxxxxxxxxxxsequence;
	private String y3xxuwcxbvxxxxxxxxxxchild;
	private String y4xxzwpxbvxxxxxxxxxxparent;
	private Integer y5xxzwrqlvxxxxxxxxxxrollupq;
	private Integer z5xxzzfxhhxxxxxxxxxxstatusfl;
	private Date z6xxcztxlxxxxxxxxxxxstatusfldt;
	private String b4xxuwuxbv34xxxxxxxxcurrency;
	private String y8xxuznxbvxxxxxxxxxxnotes;
	private String z5xxutoxlhxxxxxxxxxxowner;
	private String zzxxu2oxxhxxxxxxxxxxowner2;
	private BigDecimal z6xxzw0xlvxxxxxxxxxxp0;
	private BigDecimal z7xxzw1xlvxxxxxxxxxxp1;
	private BigDecimal z8xxzw2xlvxxxxxxxxxxp2;
	private BigDecimal z9xxzw3xlvxxxxxxxxxxp3;
	private BigDecimal zaxxzw4xlvxxxxxxxxxxp4;
	private BigDecimal zbxxzw5xlvxxxxxxxxxxp5;
	private BigDecimal zcxxzw6xlvxxxxxxxxxxp6;
	private BigDecimal zdxxzw7xlvxxxxxxxxxxp7;
	private BigDecimal zexxzw8xlvxxxxxxxxxxp8;
	private BigDecimal zfxxzw9xlvxxxxxxxxxxp9;
	private BigDecimal zgxxzw10lvxxxxxxxxxxp10;
	private BigDecimal zhxxzw11lvxxxxxxxxxxp11;
	private BigDecimal zixxzw12lvxxxxxxxxxxp12;
	private BigDecimal zjxxzw13lvxxxxxxxxxxp13;
	private BigDecimal zkxxzw14lvxxxxxxxxxxp14;
	private BigDecimal zlxxzw8tlvxxxxxxxxxxp8t;
	private BigDecimal zmxxzw9tlvxxxxxxxxxxp9t;
	private BigDecimal znxxzwatlvxxxxxxxxxxp10t;
	private BigDecimal zoxxzwbtlvxxxxxxxxxxp11t;
	private Set<Xorxeh66exwwqqhxxxxxgentriesdetails> xorxeh66exwwqqhxxxxxgentriesdetailses = new HashSet<Xorxeh66exwwqqhxxxxxgentriesdetails>(
			0);
	private Set<Trexuq277xwwqqhxxxxxcpayment> trexuq277xwwqqhxxxxxcpayments = new HashSet<Trexuq277xwwqqhxxxxxcpayment>(
			0);
	private Set<Yxxxch643xwwqqhxxxxxacintegr> yxxxch643xwwqqhxxxxxacintegrs = new HashSet<Yxxxch643xwwqqhxxxxxacintegr>(
			0);
	private Set<Jxxxuq300xwwqqhxxxxxvendor> jxxxuq300xwwqqhxxxxxvendors = new HashSet<Jxxxuq300xwwqqhxxxxxvendor>(
			0);
	private Set<Trexuq388xwwqqhxxxxxvpayment> trexuq388xwwqqhxxxxxvpayments = new HashSet<Trexuq388xwwqqhxxxxxvpayment>(
			0);
	private Set<Jxxxuq201xwwqqhxxxxxcustomer> jxxxuq201xwwqqhxxxxxcustomers = new HashSet<Jxxxuq201xwwqqhxxxxxcustomer>(
			0);
	private Set<Jxxxbh400xwwqqhxxxxxemployee> jxxxbh400xwwqqhxxxxxemployees = new HashSet<Jxxxbh400xwwqqhxxxxxemployee>(
			0);
	private Set<Yxxxch65exwwqqhxxxxxglentries> yxxxch65exwwqqhxxxxxglentrieses = new HashSet<Yxxxch65exwwqqhxxxxxglentries>(
			0);

	public Yxxxch601xwwqqhxxxxxaccount() {
	}

	public Yxxxch601xwwqqhxxxxxaccount(String a0xxukwxbvxxxxxxxxxxaccount) {
		this.a0xxukwxbvxxxxxxxxxxaccount = a0xxukwxbvxxxxxxxxxxaccount;
	}
	public Yxxxch601xwwqqhxxxxxaccount(
			Fxxxch133xhhxqhxxlxxdivision fxxxch133xhhxqhxxlxxdivision,
			Fxxxch122xhhxqhxxlxxdepartment fxxxch122xhhxqhxxlxxdepartment,
			Dxxxch1d3xwwqqhxxlxxcompany dxxxch1d3xwwqqhxxlxxcompany,
			String a0xxukwxbvxxxxxxxxxxaccount,
			String a1xxuzsxbvxxxxxxxxxxdescript,
			String b1xxuwgxbv01xxxxxxxxcategory,
			String b2xxuwtxbv02xxxxxxxxtype,
			BigDecimal b3xxzwbxbvxxxxxxxxxxbudget,
			BigDecimal b4xxzwaxlvxxxxxxxxxxactual,
			BigDecimal z2xxzwanlvxxxxxxxxxxactualn,
			BigDecimal z3xxzwbpavxxxxxxxxxxprevbudg,
			BigDecimal z4xxzwaplvxxxxxxxxxxprevact,
			Integer y2xxzwsxavxxxxxxxxxxsequence,
			String y3xxuwcxbvxxxxxxxxxxchild,
			String y4xxzwpxbvxxxxxxxxxxparent,
			Integer y5xxzwrqlvxxxxxxxxxxrollupq,
			Integer z5xxzzfxhhxxxxxxxxxxstatusfl,
			Date z6xxcztxlxxxxxxxxxxxstatusfldt,
			String b4xxuwuxbv34xxxxxxxxcurrency,
			String y8xxuznxbvxxxxxxxxxxnotes,
			String z5xxutoxlhxxxxxxxxxxowner,
			String zzxxu2oxxhxxxxxxxxxxowner2,
			BigDecimal z6xxzw0xlvxxxxxxxxxxp0,
			BigDecimal z7xxzw1xlvxxxxxxxxxxp1,
			BigDecimal z8xxzw2xlvxxxxxxxxxxp2,
			BigDecimal z9xxzw3xlvxxxxxxxxxxp3,
			BigDecimal zaxxzw4xlvxxxxxxxxxxp4,
			BigDecimal zbxxzw5xlvxxxxxxxxxxp5,
			BigDecimal zcxxzw6xlvxxxxxxxxxxp6,
			BigDecimal zdxxzw7xlvxxxxxxxxxxp7,
			BigDecimal zexxzw8xlvxxxxxxxxxxp8,
			BigDecimal zfxxzw9xlvxxxxxxxxxxp9,
			BigDecimal zgxxzw10lvxxxxxxxxxxp10,
			BigDecimal zhxxzw11lvxxxxxxxxxxp11,
			BigDecimal zixxzw12lvxxxxxxxxxxp12,
			BigDecimal zjxxzw13lvxxxxxxxxxxp13,
			BigDecimal zkxxzw14lvxxxxxxxxxxp14,
			BigDecimal zlxxzw8tlvxxxxxxxxxxp8t,
			BigDecimal zmxxzw9tlvxxxxxxxxxxp9t,
			BigDecimal znxxzwatlvxxxxxxxxxxp10t,
			BigDecimal zoxxzwbtlvxxxxxxxxxxp11t,
			Set<Xorxeh66exwwqqhxxxxxgentriesdetails> xorxeh66exwwqqhxxxxxgentriesdetailses,
			Set<Trexuq277xwwqqhxxxxxcpayment> trexuq277xwwqqhxxxxxcpayments,
			Set<Yxxxch643xwwqqhxxxxxacintegr> yxxxch643xwwqqhxxxxxacintegrs,
			Set<Jxxxuq300xwwqqhxxxxxvendor> jxxxuq300xwwqqhxxxxxvendors,
			Set<Trexuq388xwwqqhxxxxxvpayment> trexuq388xwwqqhxxxxxvpayments,
			Set<Jxxxuq201xwwqqhxxxxxcustomer> jxxxuq201xwwqqhxxxxxcustomers,
			Set<Jxxxbh400xwwqqhxxxxxemployee> jxxxbh400xwwqqhxxxxxemployees,
			Set<Yxxxch65exwwqqhxxxxxglentries> yxxxch65exwwqqhxxxxxglentrieses) {
		this.fxxxch133xhhxqhxxlxxdivision = fxxxch133xhhxqhxxlxxdivision;
		this.fxxxch122xhhxqhxxlxxdepartment = fxxxch122xhhxqhxxlxxdepartment;
		this.dxxxch1d3xwwqqhxxlxxcompany = dxxxch1d3xwwqqhxxlxxcompany;
		this.a0xxukwxbvxxxxxxxxxxaccount = a0xxukwxbvxxxxxxxxxxaccount;
		this.a1xxuzsxbvxxxxxxxxxxdescript = a1xxuzsxbvxxxxxxxxxxdescript;
		this.b1xxuwgxbv01xxxxxxxxcategory = b1xxuwgxbv01xxxxxxxxcategory;
		this.b2xxuwtxbv02xxxxxxxxtype = b2xxuwtxbv02xxxxxxxxtype;
		this.b3xxzwbxbvxxxxxxxxxxbudget = b3xxzwbxbvxxxxxxxxxxbudget;
		this.b4xxzwaxlvxxxxxxxxxxactual = b4xxzwaxlvxxxxxxxxxxactual;
		this.z2xxzwanlvxxxxxxxxxxactualn = z2xxzwanlvxxxxxxxxxxactualn;
		this.z3xxzwbpavxxxxxxxxxxprevbudg = z3xxzwbpavxxxxxxxxxxprevbudg;
		this.z4xxzwaplvxxxxxxxxxxprevact = z4xxzwaplvxxxxxxxxxxprevact;
		this.y2xxzwsxavxxxxxxxxxxsequence = y2xxzwsxavxxxxxxxxxxsequence;
		this.y3xxuwcxbvxxxxxxxxxxchild = y3xxuwcxbvxxxxxxxxxxchild;
		this.y4xxzwpxbvxxxxxxxxxxparent = y4xxzwpxbvxxxxxxxxxxparent;
		this.y5xxzwrqlvxxxxxxxxxxrollupq = y5xxzwrqlvxxxxxxxxxxrollupq;
		this.z5xxzzfxhhxxxxxxxxxxstatusfl = z5xxzzfxhhxxxxxxxxxxstatusfl;
		this.z6xxcztxlxxxxxxxxxxxstatusfldt = z6xxcztxlxxxxxxxxxxxstatusfldt;
		this.b4xxuwuxbv34xxxxxxxxcurrency = b4xxuwuxbv34xxxxxxxxcurrency;
		this.y8xxuznxbvxxxxxxxxxxnotes = y8xxuznxbvxxxxxxxxxxnotes;
		this.z5xxutoxlhxxxxxxxxxxowner = z5xxutoxlhxxxxxxxxxxowner;
		this.zzxxu2oxxhxxxxxxxxxxowner2 = zzxxu2oxxhxxxxxxxxxxowner2;
		this.z6xxzw0xlvxxxxxxxxxxp0 = z6xxzw0xlvxxxxxxxxxxp0;
		this.z7xxzw1xlvxxxxxxxxxxp1 = z7xxzw1xlvxxxxxxxxxxp1;
		this.z8xxzw2xlvxxxxxxxxxxp2 = z8xxzw2xlvxxxxxxxxxxp2;
		this.z9xxzw3xlvxxxxxxxxxxp3 = z9xxzw3xlvxxxxxxxxxxp3;
		this.zaxxzw4xlvxxxxxxxxxxp4 = zaxxzw4xlvxxxxxxxxxxp4;
		this.zbxxzw5xlvxxxxxxxxxxp5 = zbxxzw5xlvxxxxxxxxxxp5;
		this.zcxxzw6xlvxxxxxxxxxxp6 = zcxxzw6xlvxxxxxxxxxxp6;
		this.zdxxzw7xlvxxxxxxxxxxp7 = zdxxzw7xlvxxxxxxxxxxp7;
		this.zexxzw8xlvxxxxxxxxxxp8 = zexxzw8xlvxxxxxxxxxxp8;
		this.zfxxzw9xlvxxxxxxxxxxp9 = zfxxzw9xlvxxxxxxxxxxp9;
		this.zgxxzw10lvxxxxxxxxxxp10 = zgxxzw10lvxxxxxxxxxxp10;
		this.zhxxzw11lvxxxxxxxxxxp11 = zhxxzw11lvxxxxxxxxxxp11;
		this.zixxzw12lvxxxxxxxxxxp12 = zixxzw12lvxxxxxxxxxxp12;
		this.zjxxzw13lvxxxxxxxxxxp13 = zjxxzw13lvxxxxxxxxxxp13;
		this.zkxxzw14lvxxxxxxxxxxp14 = zkxxzw14lvxxxxxxxxxxp14;
		this.zlxxzw8tlvxxxxxxxxxxp8t = zlxxzw8tlvxxxxxxxxxxp8t;
		this.zmxxzw9tlvxxxxxxxxxxp9t = zmxxzw9tlvxxxxxxxxxxp9t;
		this.znxxzwatlvxxxxxxxxxxp10t = znxxzwatlvxxxxxxxxxxp10t;
		this.zoxxzwbtlvxxxxxxxxxxp11t = zoxxzwbtlvxxxxxxxxxxp11t;
		this.xorxeh66exwwqqhxxxxxgentriesdetailses = xorxeh66exwwqqhxxxxxgentriesdetailses;
		this.trexuq277xwwqqhxxxxxcpayments = trexuq277xwwqqhxxxxxcpayments;
		this.yxxxch643xwwqqhxxxxxacintegrs = yxxxch643xwwqqhxxxxxacintegrs;
		this.jxxxuq300xwwqqhxxxxxvendors = jxxxuq300xwwqqhxxxxxvendors;
		this.trexuq388xwwqqhxxxxxvpayments = trexuq388xwwqqhxxxxxvpayments;
		this.jxxxuq201xwwqqhxxxxxcustomers = jxxxuq201xwwqqhxxxxxcustomers;
		this.jxxxbh400xwwqqhxxxxxemployees = jxxxbh400xwwqqhxxxxxemployees;
		this.yxxxch65exwwqqhxxxxxglentrieses = yxxxch65exwwqqhxxxxxglentrieses;
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
	@JoinColumn(name = "divcode")
	public Fxxxch133xhhxqhxxlxxdivision getFxxxch133xhhxqhxxlxxdivision() {
		return this.fxxxch133xhhxqhxxlxxdivision;
	}

	public void setFxxxch133xhhxqhxxlxxdivision(
			Fxxxch133xhhxqhxxlxxdivision fxxxch133xhhxqhxxlxxdivision) {
		this.fxxxch133xhhxqhxxlxxdivision = fxxxch133xhhxqhxxlxxdivision;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "depcode")
	public Fxxxch122xhhxqhxxlxxdepartment getFxxxch122xhhxqhxxlxxdepartment() {
		return this.fxxxch122xhhxqhxxlxxdepartment;
	}

	public void setFxxxch122xhhxqhxxlxxdepartment(
			Fxxxch122xhhxqhxxlxxdepartment fxxxch122xhhxqhxxlxxdepartment) {
		this.fxxxch122xhhxqhxxlxxdepartment = fxxxch122xhhxqhxxlxxdepartment;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "companycode")
	public Dxxxch1d3xwwqqhxxlxxcompany getDxxxch1d3xwwqqhxxlxxcompany() {
		return this.dxxxch1d3xwwqqhxxlxxcompany;
	}

	public void setDxxxch1d3xwwqqhxxlxxcompany(
			Dxxxch1d3xwwqqhxxlxxcompany dxxxch1d3xwwqqhxxlxxcompany) {
		this.dxxxch1d3xwwqqhxxlxxcompany = dxxxch1d3xwwqqhxxlxxcompany;
	}

	@Column(name = "account", nullable = false, length = 20)
	@NotNull
	@Size(max = 20)
	public String getA0xxukwxbvxxxxxxxxxxaccount() {
		return this.a0xxukwxbvxxxxxxxxxxaccount;
	}

	public void setA0xxukwxbvxxxxxxxxxxaccount(
			String a0xxukwxbvxxxxxxxxxxaccount) {
		this.a0xxukwxbvxxxxxxxxxxaccount = a0xxukwxbvxxxxxxxxxxaccount;
	}

	@Column(name = "descript", length = 120)
	@Size(max = 120)
	public String getA1xxuzsxbvxxxxxxxxxxdescript() {
		return this.a1xxuzsxbvxxxxxxxxxxdescript;
	}

	public void setA1xxuzsxbvxxxxxxxxxxdescript(
			String a1xxuzsxbvxxxxxxxxxxdescript) {
		this.a1xxuzsxbvxxxxxxxxxxdescript = a1xxuzsxbvxxxxxxxxxxdescript;
	}

	@Column(name = "category", length = 20)
	@Size(max = 20)
	public String getB1xxuwgxbv01xxxxxxxxcategory() {
		return this.b1xxuwgxbv01xxxxxxxxcategory;
	}

	public void setB1xxuwgxbv01xxxxxxxxcategory(
			String b1xxuwgxbv01xxxxxxxxcategory) {
		this.b1xxuwgxbv01xxxxxxxxcategory = b1xxuwgxbv01xxxxxxxxcategory;
	}

	@Column(name = "type", length = 12)
	@Size(max = 12)
	public String getB2xxuwtxbv02xxxxxxxxtype() {
		return this.b2xxuwtxbv02xxxxxxxxtype;
	}

	public void setB2xxuwtxbv02xxxxxxxxtype(String b2xxuwtxbv02xxxxxxxxtype) {
		this.b2xxuwtxbv02xxxxxxxxtype = b2xxuwtxbv02xxxxxxxxtype;
	}

	@Column(name = "budget", precision = 14)
	public BigDecimal getB3xxzwbxbvxxxxxxxxxxbudget() {
		return this.b3xxzwbxbvxxxxxxxxxxbudget;
	}

	public void setB3xxzwbxbvxxxxxxxxxxbudget(
			BigDecimal b3xxzwbxbvxxxxxxxxxxbudget) {
		this.b3xxzwbxbvxxxxxxxxxxbudget = b3xxzwbxbvxxxxxxxxxxbudget;
	}

	@Column(name = "actual", precision = 14)
	public BigDecimal getB4xxzwaxlvxxxxxxxxxxactual() {
		return this.b4xxzwaxlvxxxxxxxxxxactual;
	}

	public void setB4xxzwaxlvxxxxxxxxxxactual(
			BigDecimal b4xxzwaxlvxxxxxxxxxxactual) {
		this.b4xxzwaxlvxxxxxxxxxxactual = b4xxzwaxlvxxxxxxxxxxactual;
	}

	@Column(name = "actualn", precision = 14)
	public BigDecimal getZ2xxzwanlvxxxxxxxxxxactualn() {
		return this.z2xxzwanlvxxxxxxxxxxactualn;
	}

	public void setZ2xxzwanlvxxxxxxxxxxactualn(
			BigDecimal z2xxzwanlvxxxxxxxxxxactualn) {
		this.z2xxzwanlvxxxxxxxxxxactualn = z2xxzwanlvxxxxxxxxxxactualn;
	}

	@Column(name = "prevbudg", precision = 14)
	public BigDecimal getZ3xxzwbpavxxxxxxxxxxprevbudg() {
		return this.z3xxzwbpavxxxxxxxxxxprevbudg;
	}

	public void setZ3xxzwbpavxxxxxxxxxxprevbudg(
			BigDecimal z3xxzwbpavxxxxxxxxxxprevbudg) {
		this.z3xxzwbpavxxxxxxxxxxprevbudg = z3xxzwbpavxxxxxxxxxxprevbudg;
	}

	@Column(name = "prevact", precision = 14)
	public BigDecimal getZ4xxzwaplvxxxxxxxxxxprevact() {
		return this.z4xxzwaplvxxxxxxxxxxprevact;
	}

	public void setZ4xxzwaplvxxxxxxxxxxprevact(
			BigDecimal z4xxzwaplvxxxxxxxxxxprevact) {
		this.z4xxzwaplvxxxxxxxxxxprevact = z4xxzwaplvxxxxxxxxxxprevact;
	}

	@Column(name = "sequence")
	public Integer getY2xxzwsxavxxxxxxxxxxsequence() {
		return this.y2xxzwsxavxxxxxxxxxxsequence;
	}

	public void setY2xxzwsxavxxxxxxxxxxsequence(
			Integer y2xxzwsxavxxxxxxxxxxsequence) {
		this.y2xxzwsxavxxxxxxxxxxsequence = y2xxzwsxavxxxxxxxxxxsequence;
	}

	@Column(name = "child", length = 20)
	@Size(max = 20)
	public String getY3xxuwcxbvxxxxxxxxxxchild() {
		return this.y3xxuwcxbvxxxxxxxxxxchild;
	}

	public void setY3xxuwcxbvxxxxxxxxxxchild(String y3xxuwcxbvxxxxxxxxxxchild) {
		this.y3xxuwcxbvxxxxxxxxxxchild = y3xxuwcxbvxxxxxxxxxxchild;
	}

	@Column(name = "parent", length = 20)
	@Size(max = 20)
	public String getY4xxzwpxbvxxxxxxxxxxparent() {
		return this.y4xxzwpxbvxxxxxxxxxxparent;
	}

	public void setY4xxzwpxbvxxxxxxxxxxparent(String y4xxzwpxbvxxxxxxxxxxparent) {
		this.y4xxzwpxbvxxxxxxxxxxparent = y4xxzwpxbvxxxxxxxxxxparent;
	}

	@Column(name = "rollupq")
	public Integer getY5xxzwrqlvxxxxxxxxxxrollupq() {
		return this.y5xxzwrqlvxxxxxxxxxxrollupq;
	}

	public void setY5xxzwrqlvxxxxxxxxxxrollupq(
			Integer y5xxzwrqlvxxxxxxxxxxrollupq) {
		this.y5xxzwrqlvxxxxxxxxxxrollupq = y5xxzwrqlvxxxxxxxxxxrollupq;
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

	@Column(name = "currency", length = 3)
	@Size(max = 3)
	public String getB4xxuwuxbv34xxxxxxxxcurrency() {
		return this.b4xxuwuxbv34xxxxxxxxcurrency;
	}

	public void setB4xxuwuxbv34xxxxxxxxcurrency(
			String b4xxuwuxbv34xxxxxxxxcurrency) {
		this.b4xxuwuxbv34xxxxxxxxcurrency = b4xxuwuxbv34xxxxxxxxcurrency;
	}

	@Column(name = "notes")
	public String getY8xxuznxbvxxxxxxxxxxnotes() {
		return this.y8xxuznxbvxxxxxxxxxxnotes;
	}

	public void setY8xxuznxbvxxxxxxxxxxnotes(String y8xxuznxbvxxxxxxxxxxnotes) {
		this.y8xxuznxbvxxxxxxxxxxnotes = y8xxuznxbvxxxxxxxxxxnotes;
	}

	@Column(name = "owner", length = 40)
	@Size(max = 40)
	public String getZ5xxutoxlhxxxxxxxxxxowner() {
		return this.z5xxutoxlhxxxxxxxxxxowner;
	}

	public void setZ5xxutoxlhxxxxxxxxxxowner(String z5xxutoxlhxxxxxxxxxxowner) {
		this.z5xxutoxlhxxxxxxxxxxowner = z5xxutoxlhxxxxxxxxxxowner;
	}

	@Column(name = "owner2", length = 40)
	@Size(max = 40)
	public String getZzxxu2oxxhxxxxxxxxxxowner2() {
		return this.zzxxu2oxxhxxxxxxxxxxowner2;
	}

	public void setZzxxu2oxxhxxxxxxxxxxowner2(String zzxxu2oxxhxxxxxxxxxxowner2) {
		this.zzxxu2oxxhxxxxxxxxxxowner2 = zzxxu2oxxhxxxxxxxxxxowner2;
	}

	@Column(name = "p0", precision = 14)
	public BigDecimal getZ6xxzw0xlvxxxxxxxxxxp0() {
		return this.z6xxzw0xlvxxxxxxxxxxp0;
	}

	public void setZ6xxzw0xlvxxxxxxxxxxp0(BigDecimal z6xxzw0xlvxxxxxxxxxxp0) {
		this.z6xxzw0xlvxxxxxxxxxxp0 = z6xxzw0xlvxxxxxxxxxxp0;
	}

	@Column(name = "p1", precision = 14)
	public BigDecimal getZ7xxzw1xlvxxxxxxxxxxp1() {
		return this.z7xxzw1xlvxxxxxxxxxxp1;
	}

	public void setZ7xxzw1xlvxxxxxxxxxxp1(BigDecimal z7xxzw1xlvxxxxxxxxxxp1) {
		this.z7xxzw1xlvxxxxxxxxxxp1 = z7xxzw1xlvxxxxxxxxxxp1;
	}

	@Column(name = "p2", precision = 14)
	public BigDecimal getZ8xxzw2xlvxxxxxxxxxxp2() {
		return this.z8xxzw2xlvxxxxxxxxxxp2;
	}

	public void setZ8xxzw2xlvxxxxxxxxxxp2(BigDecimal z8xxzw2xlvxxxxxxxxxxp2) {
		this.z8xxzw2xlvxxxxxxxxxxp2 = z8xxzw2xlvxxxxxxxxxxp2;
	}

	@Column(name = "p3", precision = 14)
	public BigDecimal getZ9xxzw3xlvxxxxxxxxxxp3() {
		return this.z9xxzw3xlvxxxxxxxxxxp3;
	}

	public void setZ9xxzw3xlvxxxxxxxxxxp3(BigDecimal z9xxzw3xlvxxxxxxxxxxp3) {
		this.z9xxzw3xlvxxxxxxxxxxp3 = z9xxzw3xlvxxxxxxxxxxp3;
	}

	@Column(name = "p4", precision = 14)
	public BigDecimal getZaxxzw4xlvxxxxxxxxxxp4() {
		return this.zaxxzw4xlvxxxxxxxxxxp4;
	}

	public void setZaxxzw4xlvxxxxxxxxxxp4(BigDecimal zaxxzw4xlvxxxxxxxxxxp4) {
		this.zaxxzw4xlvxxxxxxxxxxp4 = zaxxzw4xlvxxxxxxxxxxp4;
	}

	@Column(name = "p5", precision = 14)
	public BigDecimal getZbxxzw5xlvxxxxxxxxxxp5() {
		return this.zbxxzw5xlvxxxxxxxxxxp5;
	}

	public void setZbxxzw5xlvxxxxxxxxxxp5(BigDecimal zbxxzw5xlvxxxxxxxxxxp5) {
		this.zbxxzw5xlvxxxxxxxxxxp5 = zbxxzw5xlvxxxxxxxxxxp5;
	}

	@Column(name = "p6", precision = 14)
	public BigDecimal getZcxxzw6xlvxxxxxxxxxxp6() {
		return this.zcxxzw6xlvxxxxxxxxxxp6;
	}

	public void setZcxxzw6xlvxxxxxxxxxxp6(BigDecimal zcxxzw6xlvxxxxxxxxxxp6) {
		this.zcxxzw6xlvxxxxxxxxxxp6 = zcxxzw6xlvxxxxxxxxxxp6;
	}

	@Column(name = "p7", precision = 14)
	public BigDecimal getZdxxzw7xlvxxxxxxxxxxp7() {
		return this.zdxxzw7xlvxxxxxxxxxxp7;
	}

	public void setZdxxzw7xlvxxxxxxxxxxp7(BigDecimal zdxxzw7xlvxxxxxxxxxxp7) {
		this.zdxxzw7xlvxxxxxxxxxxp7 = zdxxzw7xlvxxxxxxxxxxp7;
	}

	@Column(name = "p8", precision = 14)
	public BigDecimal getZexxzw8xlvxxxxxxxxxxp8() {
		return this.zexxzw8xlvxxxxxxxxxxp8;
	}

	public void setZexxzw8xlvxxxxxxxxxxp8(BigDecimal zexxzw8xlvxxxxxxxxxxp8) {
		this.zexxzw8xlvxxxxxxxxxxp8 = zexxzw8xlvxxxxxxxxxxp8;
	}

	@Column(name = "p9", precision = 14)
	public BigDecimal getZfxxzw9xlvxxxxxxxxxxp9() {
		return this.zfxxzw9xlvxxxxxxxxxxp9;
	}

	public void setZfxxzw9xlvxxxxxxxxxxp9(BigDecimal zfxxzw9xlvxxxxxxxxxxp9) {
		this.zfxxzw9xlvxxxxxxxxxxp9 = zfxxzw9xlvxxxxxxxxxxp9;
	}

	@Column(name = "p10", precision = 14)
	public BigDecimal getZgxxzw10lvxxxxxxxxxxp10() {
		return this.zgxxzw10lvxxxxxxxxxxp10;
	}

	public void setZgxxzw10lvxxxxxxxxxxp10(BigDecimal zgxxzw10lvxxxxxxxxxxp10) {
		this.zgxxzw10lvxxxxxxxxxxp10 = zgxxzw10lvxxxxxxxxxxp10;
	}

	@Column(name = "p11", precision = 14)
	public BigDecimal getZhxxzw11lvxxxxxxxxxxp11() {
		return this.zhxxzw11lvxxxxxxxxxxp11;
	}

	public void setZhxxzw11lvxxxxxxxxxxp11(BigDecimal zhxxzw11lvxxxxxxxxxxp11) {
		this.zhxxzw11lvxxxxxxxxxxp11 = zhxxzw11lvxxxxxxxxxxp11;
	}

	@Column(name = "p12", precision = 14)
	public BigDecimal getZixxzw12lvxxxxxxxxxxp12() {
		return this.zixxzw12lvxxxxxxxxxxp12;
	}

	public void setZixxzw12lvxxxxxxxxxxp12(BigDecimal zixxzw12lvxxxxxxxxxxp12) {
		this.zixxzw12lvxxxxxxxxxxp12 = zixxzw12lvxxxxxxxxxxp12;
	}

	@Column(name = "p13", precision = 14)
	public BigDecimal getZjxxzw13lvxxxxxxxxxxp13() {
		return this.zjxxzw13lvxxxxxxxxxxp13;
	}

	public void setZjxxzw13lvxxxxxxxxxxp13(BigDecimal zjxxzw13lvxxxxxxxxxxp13) {
		this.zjxxzw13lvxxxxxxxxxxp13 = zjxxzw13lvxxxxxxxxxxp13;
	}

	@Column(name = "p14", precision = 14)
	public BigDecimal getZkxxzw14lvxxxxxxxxxxp14() {
		return this.zkxxzw14lvxxxxxxxxxxp14;
	}

	public void setZkxxzw14lvxxxxxxxxxxp14(BigDecimal zkxxzw14lvxxxxxxxxxxp14) {
		this.zkxxzw14lvxxxxxxxxxxp14 = zkxxzw14lvxxxxxxxxxxp14;
	}

	@Column(name = "p8t", precision = 14)
	public BigDecimal getZlxxzw8tlvxxxxxxxxxxp8t() {
		return this.zlxxzw8tlvxxxxxxxxxxp8t;
	}

	public void setZlxxzw8tlvxxxxxxxxxxp8t(BigDecimal zlxxzw8tlvxxxxxxxxxxp8t) {
		this.zlxxzw8tlvxxxxxxxxxxp8t = zlxxzw8tlvxxxxxxxxxxp8t;
	}

	@Column(name = "p9t", precision = 14)
	public BigDecimal getZmxxzw9tlvxxxxxxxxxxp9t() {
		return this.zmxxzw9tlvxxxxxxxxxxp9t;
	}

	public void setZmxxzw9tlvxxxxxxxxxxp9t(BigDecimal zmxxzw9tlvxxxxxxxxxxp9t) {
		this.zmxxzw9tlvxxxxxxxxxxp9t = zmxxzw9tlvxxxxxxxxxxp9t;
	}

	@Column(name = "p10t", precision = 14)
	public BigDecimal getZnxxzwatlvxxxxxxxxxxp10t() {
		return this.znxxzwatlvxxxxxxxxxxp10t;
	}

	public void setZnxxzwatlvxxxxxxxxxxp10t(BigDecimal znxxzwatlvxxxxxxxxxxp10t) {
		this.znxxzwatlvxxxxxxxxxxp10t = znxxzwatlvxxxxxxxxxxp10t;
	}

	@Column(name = "p11t", precision = 14)
	public BigDecimal getZoxxzwbtlvxxxxxxxxxxp11t() {
		return this.zoxxzwbtlvxxxxxxxxxxp11t;
	}

	public void setZoxxzwbtlvxxxxxxxxxxp11t(BigDecimal zoxxzwbtlvxxxxxxxxxxp11t) {
		this.zoxxzwbtlvxxxxxxxxxxp11t = zoxxzwbtlvxxxxxxxxxxp11t;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "yxxxch601xwwqqhxxxxxaccount")
	public Set<Xorxeh66exwwqqhxxxxxgentriesdetails> getXorxeh66exwwqqhxxxxxgentriesdetailses() {
		return this.xorxeh66exwwqqhxxxxxgentriesdetailses;
	}

	public void setXorxeh66exwwqqhxxxxxgentriesdetailses(
			Set<Xorxeh66exwwqqhxxxxxgentriesdetails> xorxeh66exwwqqhxxxxxgentriesdetailses) {
		this.xorxeh66exwwqqhxxxxxgentriesdetailses = xorxeh66exwwqqhxxxxxgentriesdetailses;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "yxxxch601xwwqqhxxxxxaccount")
	public Set<Trexuq277xwwqqhxxxxxcpayment> getTrexuq277xwwqqhxxxxxcpayments() {
		return this.trexuq277xwwqqhxxxxxcpayments;
	}

	public void setTrexuq277xwwqqhxxxxxcpayments(
			Set<Trexuq277xwwqqhxxxxxcpayment> trexuq277xwwqqhxxxxxcpayments) {
		this.trexuq277xwwqqhxxxxxcpayments = trexuq277xwwqqhxxxxxcpayments;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "yxxxch601xwwqqhxxxxxaccount")
	public Set<Yxxxch643xwwqqhxxxxxacintegr> getYxxxch643xwwqqhxxxxxacintegrs() {
		return this.yxxxch643xwwqqhxxxxxacintegrs;
	}

	public void setYxxxch643xwwqqhxxxxxacintegrs(
			Set<Yxxxch643xwwqqhxxxxxacintegr> yxxxch643xwwqqhxxxxxacintegrs) {
		this.yxxxch643xwwqqhxxxxxacintegrs = yxxxch643xwwqqhxxxxxacintegrs;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "yxxxch601xwwqqhxxxxxaccount")
	public Set<Jxxxuq300xwwqqhxxxxxvendor> getJxxxuq300xwwqqhxxxxxvendors() {
		return this.jxxxuq300xwwqqhxxxxxvendors;
	}

	public void setJxxxuq300xwwqqhxxxxxvendors(
			Set<Jxxxuq300xwwqqhxxxxxvendor> jxxxuq300xwwqqhxxxxxvendors) {
		this.jxxxuq300xwwqqhxxxxxvendors = jxxxuq300xwwqqhxxxxxvendors;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "yxxxch601xwwqqhxxxxxaccount")
	public Set<Trexuq388xwwqqhxxxxxvpayment> getTrexuq388xwwqqhxxxxxvpayments() {
		return this.trexuq388xwwqqhxxxxxvpayments;
	}

	public void setTrexuq388xwwqqhxxxxxvpayments(
			Set<Trexuq388xwwqqhxxxxxvpayment> trexuq388xwwqqhxxxxxvpayments) {
		this.trexuq388xwwqqhxxxxxvpayments = trexuq388xwwqqhxxxxxvpayments;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "yxxxch601xwwqqhxxxxxaccount")
	public Set<Jxxxuq201xwwqqhxxxxxcustomer> getJxxxuq201xwwqqhxxxxxcustomers() {
		return this.jxxxuq201xwwqqhxxxxxcustomers;
	}

	public void setJxxxuq201xwwqqhxxxxxcustomers(
			Set<Jxxxuq201xwwqqhxxxxxcustomer> jxxxuq201xwwqqhxxxxxcustomers) {
		this.jxxxuq201xwwqqhxxxxxcustomers = jxxxuq201xwwqqhxxxxxcustomers;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "yxxxch601xwwqqhxxxxxaccount")
	public Set<Jxxxbh400xwwqqhxxxxxemployee> getJxxxbh400xwwqqhxxxxxemployees() {
		return this.jxxxbh400xwwqqhxxxxxemployees;
	}

	public void setJxxxbh400xwwqqhxxxxxemployees(
			Set<Jxxxbh400xwwqqhxxxxxemployee> jxxxbh400xwwqqhxxxxxemployees) {
		this.jxxxbh400xwwqqhxxxxxemployees = jxxxbh400xwwqqhxxxxxemployees;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "yxxxch601xwwqqhxxxxxaccount")
	public Set<Yxxxch65exwwqqhxxxxxglentries> getYxxxch65exwwqqhxxxxxglentrieses() {
		return this.yxxxch65exwwqqhxxxxxglentrieses;
	}

	public void setYxxxch65exwwqqhxxxxxglentrieses(
			Set<Yxxxch65exwwqqhxxxxxglentries> yxxxch65exwwqqhxxxxxglentrieses) {
		this.yxxxch65exwwqqhxxxxxglentrieses = yxxxch65exwwqqhxxxxxglentrieses;
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