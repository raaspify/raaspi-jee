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
 * Trexuq266xwwqqhxxxxxcuinvoice generated by hbm2java
 */
@Entity
@XmlRootElement
@Table(name = "cuinvoice")
public class Trexuq266xwwqqhxxxxxcuinvoice implements java.io.Serializable {

	private Integer a0xxuobxbxxxxxxxxxxxsid;
	private Jxxxbh400xwwqqhxxxxxemployee jxxxbh400xwwqqhxxxxxemployee;
	private Jxxxuq201xwwqqhxxxxxcustomer jxxxuq201xwwqqhxxxxxcustomer;
	private Fpxxfq1a5xwwqqhxxxxxitem fpxxfq1a5xwwqqhxxxxxitem;
	private Trexuq244xwwqqhxxxxxcuorders trexuq244xwwqqhxxxxxcuorders;
	private String a0xxuncibvxxxxxxxxxxinvoice;
	private Date b3xxcxxrlxxxxxxxxxxxinvodate;
	private BigDecimal z1xxztprlxxxxxxxxxxxamounttotal;
	private BigDecimal z2xxzyprlxxxxxxxxxxxamountostndt;
	private BigDecimal z3xxztqrlxxxxxxxxxxxqtytotal;
	private BigDecimal z4xxzyqrlxxxxxxxxxxxqtyostndt;
	private String y3xxuxxrbvxxxxxxxxxxref1typ;
	private String y4xxuxxrbvxxxxxxxxxxref1code;
	private Date c1xxcxxrlxxxxxxxxxxxshipdatet;
	private String c2xxuxxrbv51xxxxxxxxshiptype;
	private String y5xxuxxrblxxxxxxxxxxshipcode;
	private String c3xxuxxrbv09xxxxxxxxterms;
	private Integer z5xxzzfxhhxxxxxxxxxxstatusfl;
	private Date z6xxcztxlxxxxxxxxxxxstatusfldt;
	private Date c4xxcxxrlxxxxxxxxxxxtermsdat;
	private BigDecimal c5xxzixrbxxxxxxxxxxxdiscounp;
	private Date c6xxcxxrlxxxxxxxxxxxdiscoudt;
	private BigDecimal c7xxzxxrlxxxxxxxxxxxdiscouds;
	private Date c8xxcxxrlxxxxxxxxxxxnetddat;
	private BigDecimal c9xxzxxrlxxxxxxxxxxxnetddys;
	private String y6xxuxxrbvxxxxxxxxxxfob;
	private String y7xxuxxrbv10xxxxxxxxtype;
	private String ybxxuwmybv40xxxxxxxxintegrset;
	private String ycxxuxxrbvxxxxxxxxxxattach;
	private BigDecimal z7xxzbtxavxxxxxxxxxxbaseamountt;
	private BigDecimal z7xxzltxavxxxxxxxxxxdelivchrgt;
	private BigDecimal z8xxzmtxavxxxxxxxxxxmiscchrgt;
	private BigDecimal z9xxzxz1avxxxxxxxxxxtax1amtt;
	private BigDecimal zaxxzxz2avxxxxxxxxxxtax2amtt;
	private BigDecimal zbxxzxz3avxxxxxxxxxxtax3amtt;
	private String ydxxuznybvxxxxxxxxxxnotes;
	private Integer zcxxzzprhvxxxxxxxxxxprintmstat;
	private Date zdxxczqxlhxxxxxxxxxxprinmtfldt;
	private String zexxutoxlhxxxxxxxxxxowner;
	private String zzxxu2oxxhxxxxxxxxxxowner2;
	private String yexxuzdrbvxxxxxxxxxxdocmnt;
	private String zgxxuxxrbvxxxxxxxxxxbarinvoice;
	private Set<Trexuq277xwwqqhxxxxxcpayment> trexuq277xwwqqhxxxxxcpayments = new HashSet<Trexuq277xwwqqhxxxxxcpayment>(
			0);
	private Set<Xoxxuq284xwwqqhxxxxxcupdetails> xoxxuq284xwwqqhxxxxxcupdetailses = new HashSet<Xoxxuq284xwwqqhxxxxxcupdetails>(
			0);
	private Set<Trexuq255xwwqqhxxxxxshipment> trexuq255xwwqqhxxxxxshipments = new HashSet<Trexuq255xwwqqhxxxxxshipment>(
			0);
	private Set<Xoxxuq2a4xwwqqhxxxxxcuidetails> xoxxuq2a4xwwqqhxxxxxcuidetailses = new HashSet<Xoxxuq2a4xwwqqhxxxxxcuidetails>(
			0);

	public Trexuq266xwwqqhxxxxxcuinvoice() {
	}

	public Trexuq266xwwqqhxxxxxcuinvoice(String a0xxuncibvxxxxxxxxxxinvoice) {
		this.a0xxuncibvxxxxxxxxxxinvoice = a0xxuncibvxxxxxxxxxxinvoice;
	}
	public Trexuq266xwwqqhxxxxxcuinvoice(
			Jxxxbh400xwwqqhxxxxxemployee jxxxbh400xwwqqhxxxxxemployee,
			Jxxxuq201xwwqqhxxxxxcustomer jxxxuq201xwwqqhxxxxxcustomer,
			Fpxxfq1a5xwwqqhxxxxxitem fpxxfq1a5xwwqqhxxxxxitem,
			Trexuq244xwwqqhxxxxxcuorders trexuq244xwwqqhxxxxxcuorders,
			String a0xxuncibvxxxxxxxxxxinvoice,
			Date b3xxcxxrlxxxxxxxxxxxinvodate,
			BigDecimal z1xxztprlxxxxxxxxxxxamounttotal,
			BigDecimal z2xxzyprlxxxxxxxxxxxamountostndt,
			BigDecimal z3xxztqrlxxxxxxxxxxxqtytotal,
			BigDecimal z4xxzyqrlxxxxxxxxxxxqtyostndt,
			String y3xxuxxrbvxxxxxxxxxxref1typ,
			String y4xxuxxrbvxxxxxxxxxxref1code,
			Date c1xxcxxrlxxxxxxxxxxxshipdatet,
			String c2xxuxxrbv51xxxxxxxxshiptype,
			String y5xxuxxrblxxxxxxxxxxshipcode,
			String c3xxuxxrbv09xxxxxxxxterms,
			Integer z5xxzzfxhhxxxxxxxxxxstatusfl,
			Date z6xxcztxlxxxxxxxxxxxstatusfldt,
			Date c4xxcxxrlxxxxxxxxxxxtermsdat,
			BigDecimal c5xxzixrbxxxxxxxxxxxdiscounp,
			Date c6xxcxxrlxxxxxxxxxxxdiscoudt,
			BigDecimal c7xxzxxrlxxxxxxxxxxxdiscouds,
			Date c8xxcxxrlxxxxxxxxxxxnetddat,
			BigDecimal c9xxzxxrlxxxxxxxxxxxnetddys,
			String y6xxuxxrbvxxxxxxxxxxfob,
			String y7xxuxxrbv10xxxxxxxxtype,
			String ybxxuwmybv40xxxxxxxxintegrset,
			String ycxxuxxrbvxxxxxxxxxxattach,
			BigDecimal z7xxzbtxavxxxxxxxxxxbaseamountt,
			BigDecimal z7xxzltxavxxxxxxxxxxdelivchrgt,
			BigDecimal z8xxzmtxavxxxxxxxxxxmiscchrgt,
			BigDecimal z9xxzxz1avxxxxxxxxxxtax1amtt,
			BigDecimal zaxxzxz2avxxxxxxxxxxtax2amtt,
			BigDecimal zbxxzxz3avxxxxxxxxxxtax3amtt,
			String ydxxuznybvxxxxxxxxxxnotes,
			Integer zcxxzzprhvxxxxxxxxxxprintmstat,
			Date zdxxczqxlhxxxxxxxxxxprinmtfldt,
			String zexxutoxlhxxxxxxxxxxowner,
			String zzxxu2oxxhxxxxxxxxxxowner2,
			String yexxuzdrbvxxxxxxxxxxdocmnt,
			String zgxxuxxrbvxxxxxxxxxxbarinvoice,
			Set<Trexuq277xwwqqhxxxxxcpayment> trexuq277xwwqqhxxxxxcpayments,
			Set<Xoxxuq284xwwqqhxxxxxcupdetails> xoxxuq284xwwqqhxxxxxcupdetailses,
			Set<Trexuq255xwwqqhxxxxxshipment> trexuq255xwwqqhxxxxxshipments,
			Set<Xoxxuq2a4xwwqqhxxxxxcuidetails> xoxxuq2a4xwwqqhxxxxxcuidetailses) {
		this.jxxxbh400xwwqqhxxxxxemployee = jxxxbh400xwwqqhxxxxxemployee;
		this.jxxxuq201xwwqqhxxxxxcustomer = jxxxuq201xwwqqhxxxxxcustomer;
		this.fpxxfq1a5xwwqqhxxxxxitem = fpxxfq1a5xwwqqhxxxxxitem;
		this.trexuq244xwwqqhxxxxxcuorders = trexuq244xwwqqhxxxxxcuorders;
		this.a0xxuncibvxxxxxxxxxxinvoice = a0xxuncibvxxxxxxxxxxinvoice;
		this.b3xxcxxrlxxxxxxxxxxxinvodate = b3xxcxxrlxxxxxxxxxxxinvodate;
		this.z1xxztprlxxxxxxxxxxxamounttotal = z1xxztprlxxxxxxxxxxxamounttotal;
		this.z2xxzyprlxxxxxxxxxxxamountostndt = z2xxzyprlxxxxxxxxxxxamountostndt;
		this.z3xxztqrlxxxxxxxxxxxqtytotal = z3xxztqrlxxxxxxxxxxxqtytotal;
		this.z4xxzyqrlxxxxxxxxxxxqtyostndt = z4xxzyqrlxxxxxxxxxxxqtyostndt;
		this.y3xxuxxrbvxxxxxxxxxxref1typ = y3xxuxxrbvxxxxxxxxxxref1typ;
		this.y4xxuxxrbvxxxxxxxxxxref1code = y4xxuxxrbvxxxxxxxxxxref1code;
		this.c1xxcxxrlxxxxxxxxxxxshipdatet = c1xxcxxrlxxxxxxxxxxxshipdatet;
		this.c2xxuxxrbv51xxxxxxxxshiptype = c2xxuxxrbv51xxxxxxxxshiptype;
		this.y5xxuxxrblxxxxxxxxxxshipcode = y5xxuxxrblxxxxxxxxxxshipcode;
		this.c3xxuxxrbv09xxxxxxxxterms = c3xxuxxrbv09xxxxxxxxterms;
		this.z5xxzzfxhhxxxxxxxxxxstatusfl = z5xxzzfxhhxxxxxxxxxxstatusfl;
		this.z6xxcztxlxxxxxxxxxxxstatusfldt = z6xxcztxlxxxxxxxxxxxstatusfldt;
		this.c4xxcxxrlxxxxxxxxxxxtermsdat = c4xxcxxrlxxxxxxxxxxxtermsdat;
		this.c5xxzixrbxxxxxxxxxxxdiscounp = c5xxzixrbxxxxxxxxxxxdiscounp;
		this.c6xxcxxrlxxxxxxxxxxxdiscoudt = c6xxcxxrlxxxxxxxxxxxdiscoudt;
		this.c7xxzxxrlxxxxxxxxxxxdiscouds = c7xxzxxrlxxxxxxxxxxxdiscouds;
		this.c8xxcxxrlxxxxxxxxxxxnetddat = c8xxcxxrlxxxxxxxxxxxnetddat;
		this.c9xxzxxrlxxxxxxxxxxxnetddys = c9xxzxxrlxxxxxxxxxxxnetddys;
		this.y6xxuxxrbvxxxxxxxxxxfob = y6xxuxxrbvxxxxxxxxxxfob;
		this.y7xxuxxrbv10xxxxxxxxtype = y7xxuxxrbv10xxxxxxxxtype;
		this.ybxxuwmybv40xxxxxxxxintegrset = ybxxuwmybv40xxxxxxxxintegrset;
		this.ycxxuxxrbvxxxxxxxxxxattach = ycxxuxxrbvxxxxxxxxxxattach;
		this.z7xxzbtxavxxxxxxxxxxbaseamountt = z7xxzbtxavxxxxxxxxxxbaseamountt;
		this.z7xxzltxavxxxxxxxxxxdelivchrgt = z7xxzltxavxxxxxxxxxxdelivchrgt;
		this.z8xxzmtxavxxxxxxxxxxmiscchrgt = z8xxzmtxavxxxxxxxxxxmiscchrgt;
		this.z9xxzxz1avxxxxxxxxxxtax1amtt = z9xxzxz1avxxxxxxxxxxtax1amtt;
		this.zaxxzxz2avxxxxxxxxxxtax2amtt = zaxxzxz2avxxxxxxxxxxtax2amtt;
		this.zbxxzxz3avxxxxxxxxxxtax3amtt = zbxxzxz3avxxxxxxxxxxtax3amtt;
		this.ydxxuznybvxxxxxxxxxxnotes = ydxxuznybvxxxxxxxxxxnotes;
		this.zcxxzzprhvxxxxxxxxxxprintmstat = zcxxzzprhvxxxxxxxxxxprintmstat;
		this.zdxxczqxlhxxxxxxxxxxprinmtfldt = zdxxczqxlhxxxxxxxxxxprinmtfldt;
		this.zexxutoxlhxxxxxxxxxxowner = zexxutoxlhxxxxxxxxxxowner;
		this.zzxxu2oxxhxxxxxxxxxxowner2 = zzxxu2oxxhxxxxxxxxxxowner2;
		this.yexxuzdrbvxxxxxxxxxxdocmnt = yexxuzdrbvxxxxxxxxxxdocmnt;
		this.zgxxuxxrbvxxxxxxxxxxbarinvoice = zgxxuxxrbvxxxxxxxxxxbarinvoice;
		this.trexuq277xwwqqhxxxxxcpayments = trexuq277xwwqqhxxxxxcpayments;
		this.xoxxuq284xwwqqhxxxxxcupdetailses = xoxxuq284xwwqqhxxxxxcupdetailses;
		this.trexuq255xwwqqhxxxxxshipments = trexuq255xwwqqhxxxxxshipments;
		this.xoxxuq2a4xwwqqhxxxxxcuidetailses = xoxxuq2a4xwwqqhxxxxxcuidetailses;
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
	@JoinColumn(name = "agent")
	public Jxxxbh400xwwqqhxxxxxemployee getJxxxbh400xwwqqhxxxxxemployee() {
		return this.jxxxbh400xwwqqhxxxxxemployee;
	}

	public void setJxxxbh400xwwqqhxxxxxemployee(
			Jxxxbh400xwwqqhxxxxxemployee jxxxbh400xwwqqhxxxxxemployee) {
		this.jxxxbh400xwwqqhxxxxxemployee = jxxxbh400xwwqqhxxxxxemployee;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "customer")
	public Jxxxuq201xwwqqhxxxxxcustomer getJxxxuq201xwwqqhxxxxxcustomer() {
		return this.jxxxuq201xwwqqhxxxxxcustomer;
	}

	public void setJxxxuq201xwwqqhxxxxxcustomer(
			Jxxxuq201xwwqqhxxxxxcustomer jxxxuq201xwwqqhxxxxxcustomer) {
		this.jxxxuq201xwwqqhxxxxxcustomer = jxxxuq201xwwqqhxxxxxcustomer;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "matcode")
	public Fpxxfq1a5xwwqqhxxxxxitem getFpxxfq1a5xwwqqhxxxxxitem() {
		return this.fpxxfq1a5xwwqqhxxxxxitem;
	}

	public void setFpxxfq1a5xwwqqhxxxxxitem(
			Fpxxfq1a5xwwqqhxxxxxitem fpxxfq1a5xwwqqhxxxxxitem) {
		this.fpxxfq1a5xwwqqhxxxxxitem = fpxxfq1a5xwwqqhxxxxxitem;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "pono")
	public Trexuq244xwwqqhxxxxxcuorders getTrexuq244xwwqqhxxxxxcuorders() {
		return this.trexuq244xwwqqhxxxxxcuorders;
	}

	public void setTrexuq244xwwqqhxxxxxcuorders(
			Trexuq244xwwqqhxxxxxcuorders trexuq244xwwqqhxxxxxcuorders) {
		this.trexuq244xwwqqhxxxxxcuorders = trexuq244xwwqqhxxxxxcuorders;
	}

	@Column(name = "invoice", nullable = false, length = 32)
	@NotNull
	@Size(max = 32)
	public String getA0xxuncibvxxxxxxxxxxinvoice() {
		return this.a0xxuncibvxxxxxxxxxxinvoice;
	}

	public void setA0xxuncibvxxxxxxxxxxinvoice(
			String a0xxuncibvxxxxxxxxxxinvoice) {
		this.a0xxuncibvxxxxxxxxxxinvoice = a0xxuncibvxxxxxxxxxxinvoice;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "invodate", length = 29)
	public Date getB3xxcxxrlxxxxxxxxxxxinvodate() {
		return this.b3xxcxxrlxxxxxxxxxxxinvodate;
	}

	public void setB3xxcxxrlxxxxxxxxxxxinvodate(
			Date b3xxcxxrlxxxxxxxxxxxinvodate) {
		this.b3xxcxxrlxxxxxxxxxxxinvodate = b3xxcxxrlxxxxxxxxxxxinvodate;
	}

	@Column(name = "amounttotal", precision = 14)
	public BigDecimal getZ1xxztprlxxxxxxxxxxxamounttotal() {
		return this.z1xxztprlxxxxxxxxxxxamounttotal;
	}

	public void setZ1xxztprlxxxxxxxxxxxamounttotal(
			BigDecimal z1xxztprlxxxxxxxxxxxamounttotal) {
		this.z1xxztprlxxxxxxxxxxxamounttotal = z1xxztprlxxxxxxxxxxxamounttotal;
	}

	@Column(name = "amountostndt", precision = 14)
	public BigDecimal getZ2xxzyprlxxxxxxxxxxxamountostndt() {
		return this.z2xxzyprlxxxxxxxxxxxamountostndt;
	}

	public void setZ2xxzyprlxxxxxxxxxxxamountostndt(
			BigDecimal z2xxzyprlxxxxxxxxxxxamountostndt) {
		this.z2xxzyprlxxxxxxxxxxxamountostndt = z2xxzyprlxxxxxxxxxxxamountostndt;
	}

	@Column(name = "qtytotal", precision = 14)
	public BigDecimal getZ3xxztqrlxxxxxxxxxxxqtytotal() {
		return this.z3xxztqrlxxxxxxxxxxxqtytotal;
	}

	public void setZ3xxztqrlxxxxxxxxxxxqtytotal(
			BigDecimal z3xxztqrlxxxxxxxxxxxqtytotal) {
		this.z3xxztqrlxxxxxxxxxxxqtytotal = z3xxztqrlxxxxxxxxxxxqtytotal;
	}

	@Column(name = "qtyostndt", precision = 14)
	public BigDecimal getZ4xxzyqrlxxxxxxxxxxxqtyostndt() {
		return this.z4xxzyqrlxxxxxxxxxxxqtyostndt;
	}

	public void setZ4xxzyqrlxxxxxxxxxxxqtyostndt(
			BigDecimal z4xxzyqrlxxxxxxxxxxxqtyostndt) {
		this.z4xxzyqrlxxxxxxxxxxxqtyostndt = z4xxzyqrlxxxxxxxxxxxqtyostndt;
	}

	@Column(name = "ref1typ", length = 20)
	@Size(max = 20)
	public String getY3xxuxxrbvxxxxxxxxxxref1typ() {
		return this.y3xxuxxrbvxxxxxxxxxxref1typ;
	}

	public void setY3xxuxxrbvxxxxxxxxxxref1typ(
			String y3xxuxxrbvxxxxxxxxxxref1typ) {
		this.y3xxuxxrbvxxxxxxxxxxref1typ = y3xxuxxrbvxxxxxxxxxxref1typ;
	}

	@Column(name = "ref1code", length = 35)
	@Size(max = 35)
	public String getY4xxuxxrbvxxxxxxxxxxref1code() {
		return this.y4xxuxxrbvxxxxxxxxxxref1code;
	}

	public void setY4xxuxxrbvxxxxxxxxxxref1code(
			String y4xxuxxrbvxxxxxxxxxxref1code) {
		this.y4xxuxxrbvxxxxxxxxxxref1code = y4xxuxxrbvxxxxxxxxxxref1code;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "shipdatet", length = 29)
	public Date getC1xxcxxrlxxxxxxxxxxxshipdatet() {
		return this.c1xxcxxrlxxxxxxxxxxxshipdatet;
	}

	public void setC1xxcxxrlxxxxxxxxxxxshipdatet(
			Date c1xxcxxrlxxxxxxxxxxxshipdatet) {
		this.c1xxcxxrlxxxxxxxxxxxshipdatet = c1xxcxxrlxxxxxxxxxxxshipdatet;
	}

	@Column(name = "shiptype", length = 12)
	@Size(max = 12)
	public String getC2xxuxxrbv51xxxxxxxxshiptype() {
		return this.c2xxuxxrbv51xxxxxxxxshiptype;
	}

	public void setC2xxuxxrbv51xxxxxxxxshiptype(
			String c2xxuxxrbv51xxxxxxxxshiptype) {
		this.c2xxuxxrbv51xxxxxxxxshiptype = c2xxuxxrbv51xxxxxxxxshiptype;
	}

	@Column(name = "shipcode", length = 20)
	@Size(max = 20)
	public String getY5xxuxxrblxxxxxxxxxxshipcode() {
		return this.y5xxuxxrblxxxxxxxxxxshipcode;
	}

	public void setY5xxuxxrblxxxxxxxxxxshipcode(
			String y5xxuxxrblxxxxxxxxxxshipcode) {
		this.y5xxuxxrblxxxxxxxxxxshipcode = y5xxuxxrblxxxxxxxxxxshipcode;
	}

	@Column(name = "terms", length = 20)
	@Size(max = 20)
	public String getC3xxuxxrbv09xxxxxxxxterms() {
		return this.c3xxuxxrbv09xxxxxxxxterms;
	}

	public void setC3xxuxxrbv09xxxxxxxxterms(String c3xxuxxrbv09xxxxxxxxterms) {
		this.c3xxuxxrbv09xxxxxxxxterms = c3xxuxxrbv09xxxxxxxxterms;
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

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "termsdat", length = 29)
	public Date getC4xxcxxrlxxxxxxxxxxxtermsdat() {
		return this.c4xxcxxrlxxxxxxxxxxxtermsdat;
	}

	public void setC4xxcxxrlxxxxxxxxxxxtermsdat(
			Date c4xxcxxrlxxxxxxxxxxxtermsdat) {
		this.c4xxcxxrlxxxxxxxxxxxtermsdat = c4xxcxxrlxxxxxxxxxxxtermsdat;
	}

	@Column(name = "discounp", precision = 14)
	public BigDecimal getC5xxzixrbxxxxxxxxxxxdiscounp() {
		return this.c5xxzixrbxxxxxxxxxxxdiscounp;
	}

	public void setC5xxzixrbxxxxxxxxxxxdiscounp(
			BigDecimal c5xxzixrbxxxxxxxxxxxdiscounp) {
		this.c5xxzixrbxxxxxxxxxxxdiscounp = c5xxzixrbxxxxxxxxxxxdiscounp;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "discoudt", length = 29)
	public Date getC6xxcxxrlxxxxxxxxxxxdiscoudt() {
		return this.c6xxcxxrlxxxxxxxxxxxdiscoudt;
	}

	public void setC6xxcxxrlxxxxxxxxxxxdiscoudt(
			Date c6xxcxxrlxxxxxxxxxxxdiscoudt) {
		this.c6xxcxxrlxxxxxxxxxxxdiscoudt = c6xxcxxrlxxxxxxxxxxxdiscoudt;
	}

	@Column(name = "discouds", precision = 14)
	public BigDecimal getC7xxzxxrlxxxxxxxxxxxdiscouds() {
		return this.c7xxzxxrlxxxxxxxxxxxdiscouds;
	}

	public void setC7xxzxxrlxxxxxxxxxxxdiscouds(
			BigDecimal c7xxzxxrlxxxxxxxxxxxdiscouds) {
		this.c7xxzxxrlxxxxxxxxxxxdiscouds = c7xxzxxrlxxxxxxxxxxxdiscouds;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "netddat", length = 29)
	public Date getC8xxcxxrlxxxxxxxxxxxnetddat() {
		return this.c8xxcxxrlxxxxxxxxxxxnetddat;
	}

	public void setC8xxcxxrlxxxxxxxxxxxnetddat(Date c8xxcxxrlxxxxxxxxxxxnetddat) {
		this.c8xxcxxrlxxxxxxxxxxxnetddat = c8xxcxxrlxxxxxxxxxxxnetddat;
	}

	@Column(name = "netddys", precision = 14)
	public BigDecimal getC9xxzxxrlxxxxxxxxxxxnetddys() {
		return this.c9xxzxxrlxxxxxxxxxxxnetddys;
	}

	public void setC9xxzxxrlxxxxxxxxxxxnetddys(
			BigDecimal c9xxzxxrlxxxxxxxxxxxnetddys) {
		this.c9xxzxxrlxxxxxxxxxxxnetddys = c9xxzxxrlxxxxxxxxxxxnetddys;
	}

	@Column(name = "fob", length = 20)
	@Size(max = 20)
	public String getY6xxuxxrbvxxxxxxxxxxfob() {
		return this.y6xxuxxrbvxxxxxxxxxxfob;
	}

	public void setY6xxuxxrbvxxxxxxxxxxfob(String y6xxuxxrbvxxxxxxxxxxfob) {
		this.y6xxuxxrbvxxxxxxxxxxfob = y6xxuxxrbvxxxxxxxxxxfob;
	}

	@Column(name = "type", length = 12)
	@Size(max = 12)
	public String getY7xxuxxrbv10xxxxxxxxtype() {
		return this.y7xxuxxrbv10xxxxxxxxtype;
	}

	public void setY7xxuxxrbv10xxxxxxxxtype(String y7xxuxxrbv10xxxxxxxxtype) {
		this.y7xxuxxrbv10xxxxxxxxtype = y7xxuxxrbv10xxxxxxxxtype;
	}

	@Column(name = "integrset", length = 20)
	@Size(max = 20)
	public String getYbxxuwmybv40xxxxxxxxintegrset() {
		return this.ybxxuwmybv40xxxxxxxxintegrset;
	}

	public void setYbxxuwmybv40xxxxxxxxintegrset(
			String ybxxuwmybv40xxxxxxxxintegrset) {
		this.ybxxuwmybv40xxxxxxxxintegrset = ybxxuwmybv40xxxxxxxxintegrset;
	}

	@Column(name = "attach", length = 20)
	@Size(max = 20)
	public String getYcxxuxxrbvxxxxxxxxxxattach() {
		return this.ycxxuxxrbvxxxxxxxxxxattach;
	}

	public void setYcxxuxxrbvxxxxxxxxxxattach(String ycxxuxxrbvxxxxxxxxxxattach) {
		this.ycxxuxxrbvxxxxxxxxxxattach = ycxxuxxrbvxxxxxxxxxxattach;
	}

	@Column(name = "baseamountt", precision = 14)
	public BigDecimal getZ7xxzbtxavxxxxxxxxxxbaseamountt() {
		return this.z7xxzbtxavxxxxxxxxxxbaseamountt;
	}

	public void setZ7xxzbtxavxxxxxxxxxxbaseamountt(
			BigDecimal z7xxzbtxavxxxxxxxxxxbaseamountt) {
		this.z7xxzbtxavxxxxxxxxxxbaseamountt = z7xxzbtxavxxxxxxxxxxbaseamountt;
	}

	@Column(name = "delivchrgt", precision = 14)
	public BigDecimal getZ7xxzltxavxxxxxxxxxxdelivchrgt() {
		return this.z7xxzltxavxxxxxxxxxxdelivchrgt;
	}

	public void setZ7xxzltxavxxxxxxxxxxdelivchrgt(
			BigDecimal z7xxzltxavxxxxxxxxxxdelivchrgt) {
		this.z7xxzltxavxxxxxxxxxxdelivchrgt = z7xxzltxavxxxxxxxxxxdelivchrgt;
	}

	@Column(name = "miscchrgt", precision = 14)
	public BigDecimal getZ8xxzmtxavxxxxxxxxxxmiscchrgt() {
		return this.z8xxzmtxavxxxxxxxxxxmiscchrgt;
	}

	public void setZ8xxzmtxavxxxxxxxxxxmiscchrgt(
			BigDecimal z8xxzmtxavxxxxxxxxxxmiscchrgt) {
		this.z8xxzmtxavxxxxxxxxxxmiscchrgt = z8xxzmtxavxxxxxxxxxxmiscchrgt;
	}

	@Column(name = "tax1amtt", precision = 14)
	public BigDecimal getZ9xxzxz1avxxxxxxxxxxtax1amtt() {
		return this.z9xxzxz1avxxxxxxxxxxtax1amtt;
	}

	public void setZ9xxzxz1avxxxxxxxxxxtax1amtt(
			BigDecimal z9xxzxz1avxxxxxxxxxxtax1amtt) {
		this.z9xxzxz1avxxxxxxxxxxtax1amtt = z9xxzxz1avxxxxxxxxxxtax1amtt;
	}

	@Column(name = "tax2amtt", precision = 14)
	public BigDecimal getZaxxzxz2avxxxxxxxxxxtax2amtt() {
		return this.zaxxzxz2avxxxxxxxxxxtax2amtt;
	}

	public void setZaxxzxz2avxxxxxxxxxxtax2amtt(
			BigDecimal zaxxzxz2avxxxxxxxxxxtax2amtt) {
		this.zaxxzxz2avxxxxxxxxxxtax2amtt = zaxxzxz2avxxxxxxxxxxtax2amtt;
	}

	@Column(name = "tax3amtt", precision = 14)
	public BigDecimal getZbxxzxz3avxxxxxxxxxxtax3amtt() {
		return this.zbxxzxz3avxxxxxxxxxxtax3amtt;
	}

	public void setZbxxzxz3avxxxxxxxxxxtax3amtt(
			BigDecimal zbxxzxz3avxxxxxxxxxxtax3amtt) {
		this.zbxxzxz3avxxxxxxxxxxtax3amtt = zbxxzxz3avxxxxxxxxxxtax3amtt;
	}

	@Column(name = "notes", length = 60)
	@Size(max = 60)
	public String getYdxxuznybvxxxxxxxxxxnotes() {
		return this.ydxxuznybvxxxxxxxxxxnotes;
	}

	public void setYdxxuznybvxxxxxxxxxxnotes(String ydxxuznybvxxxxxxxxxxnotes) {
		this.ydxxuznybvxxxxxxxxxxnotes = ydxxuznybvxxxxxxxxxxnotes;
	}

	@Column(name = "printmstat")
	public Integer getZcxxzzprhvxxxxxxxxxxprintmstat() {
		return this.zcxxzzprhvxxxxxxxxxxprintmstat;
	}

	public void setZcxxzzprhvxxxxxxxxxxprintmstat(
			Integer zcxxzzprhvxxxxxxxxxxprintmstat) {
		this.zcxxzzprhvxxxxxxxxxxprintmstat = zcxxzzprhvxxxxxxxxxxprintmstat;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "prinmtfldt", length = 29)
	public Date getZdxxczqxlhxxxxxxxxxxprinmtfldt() {
		return this.zdxxczqxlhxxxxxxxxxxprinmtfldt;
	}

	public void setZdxxczqxlhxxxxxxxxxxprinmtfldt(
			Date zdxxczqxlhxxxxxxxxxxprinmtfldt) {
		this.zdxxczqxlhxxxxxxxxxxprinmtfldt = zdxxczqxlhxxxxxxxxxxprinmtfldt;
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

	@Column(name = "docmnt", length = 90)
	@Size(max = 90)
	public String getYexxuzdrbvxxxxxxxxxxdocmnt() {
		return this.yexxuzdrbvxxxxxxxxxxdocmnt;
	}

	public void setYexxuzdrbvxxxxxxxxxxdocmnt(String yexxuzdrbvxxxxxxxxxxdocmnt) {
		this.yexxuzdrbvxxxxxxxxxxdocmnt = yexxuzdrbvxxxxxxxxxxdocmnt;
	}

	@Column(name = "barinvoice", length = 30)
	@Size(max = 30)
	public String getZgxxuxxrbvxxxxxxxxxxbarinvoice() {
		return this.zgxxuxxrbvxxxxxxxxxxbarinvoice;
	}

	public void setZgxxuxxrbvxxxxxxxxxxbarinvoice(
			String zgxxuxxrbvxxxxxxxxxxbarinvoice) {
		this.zgxxuxxrbvxxxxxxxxxxbarinvoice = zgxxuxxrbvxxxxxxxxxxbarinvoice;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "trexuq266xwwqqhxxxxxcuinvoice")
	public Set<Trexuq277xwwqqhxxxxxcpayment> getTrexuq277xwwqqhxxxxxcpayments() {
		return this.trexuq277xwwqqhxxxxxcpayments;
	}

	public void setTrexuq277xwwqqhxxxxxcpayments(
			Set<Trexuq277xwwqqhxxxxxcpayment> trexuq277xwwqqhxxxxxcpayments) {
		this.trexuq277xwwqqhxxxxxcpayments = trexuq277xwwqqhxxxxxcpayments;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "trexuq266xwwqqhxxxxxcuinvoice")
	public Set<Xoxxuq284xwwqqhxxxxxcupdetails> getXoxxuq284xwwqqhxxxxxcupdetailses() {
		return this.xoxxuq284xwwqqhxxxxxcupdetailses;
	}

	public void setXoxxuq284xwwqqhxxxxxcupdetailses(
			Set<Xoxxuq284xwwqqhxxxxxcupdetails> xoxxuq284xwwqqhxxxxxcupdetailses) {
		this.xoxxuq284xwwqqhxxxxxcupdetailses = xoxxuq284xwwqqhxxxxxcupdetailses;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "trexuq266xwwqqhxxxxxcuinvoice")
	public Set<Trexuq255xwwqqhxxxxxshipment> getTrexuq255xwwqqhxxxxxshipments() {
		return this.trexuq255xwwqqhxxxxxshipments;
	}

	public void setTrexuq255xwwqqhxxxxxshipments(
			Set<Trexuq255xwwqqhxxxxxshipment> trexuq255xwwqqhxxxxxshipments) {
		this.trexuq255xwwqqhxxxxxshipments = trexuq255xwwqqhxxxxxshipments;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "trexuq266xwwqqhxxxxxcuinvoice")
	public Set<Xoxxuq2a4xwwqqhxxxxxcuidetails> getXoxxuq2a4xwwqqhxxxxxcuidetailses() {
		return this.xoxxuq2a4xwwqqhxxxxxcuidetailses;
	}

	public void setXoxxuq2a4xwwqqhxxxxxcuidetailses(
			Set<Xoxxuq2a4xwwqqhxxxxxcuidetails> xoxxuq2a4xwwqqhxxxxxcuidetailses) {
		this.xoxxuq2a4xwwqqhxxxxxcuidetailses = xoxxuq2a4xwwqqhxxxxxcuidetailses;
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
