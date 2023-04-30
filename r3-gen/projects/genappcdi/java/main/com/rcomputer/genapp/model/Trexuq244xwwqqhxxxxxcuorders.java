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
 * Trexuq244xwwqqhxxxxxcuorders generated by hbm2java
 */
@Entity
@XmlRootElement
@Table(name = "cuorders")
public class Trexuq244xwwqqhxxxxxcuorders implements java.io.Serializable {

	private Integer a0xxuobxbxxxxxxxxxxxsid;
	private Fxxxuq111xwwqqhxxxxxaddress fxxxuq111xwwqqhxxxxxaddressByShipcodefrompay;
	private Fxxxuq111xwwqqhxxxxxaddress fxxxuq111xwwqqhxxxxxaddressByShipcode;
	private Trexuq233xwwqqhxxxxxcuquote trexuq233xwwqqhxxxxxcuquote;
	private Jxxxbh400xwwqqhxxxxxemployee jxxxbh400xwwqqhxxxxxemployee;
	private Jxxxuq201xwwqqhxxxxxcustomer jxxxuq201xwwqqhxxxxxcustomer;
	private Fpxxfq1a5xwwqqhxxxxxitem fpxxfq1a5xwwqqhxxxxxitem;
	private String a0xxuncobvxxxxxxxxxxpurchsno;
	private Date b1xxcxxxbvxxxxxxxxxxdelvdatet;
	private Integer b4xxuxxrlxxxcxxxxxxxcinvoice;
	private Integer y4xxuxxrlxxxxxxxxxxxjobno;
	private BigDecimal z1xxztprlxxxxxxxxxxxamounttotal;
	private BigDecimal z2xxzyprlxxxxxxxxxxxamountostndt;
	private BigDecimal b5xxztqrlxxxxxxxxxxxqtytotal;
	private BigDecimal z3xxzyqrlxxxxxxxxxxxqtyostndt;
	private Integer y6xxuxxrlxxxxxxxxxxxvpono;
	private Integer y7xxuxxxbxxxxxxxxxxxrfpord;
	private Integer y8xxuxxrxxxxxxxxxxxxrcpono;
	private Date c1xxcxxxbxxxxxxxxxxxodatet;
	private String c2xxcxxxbv09xxxxxxxxterms;
	private Boolean c3xxfxxrbv09xxxxxxxxpriority;
	private Integer z4xxzzprhvxxxxxxxxxxprintmstat;
	private Date z5xxczqxlhxxxxxxxxxxprinmtfldt;
	private String y9xxcxxxbv10xxxxxxxxtype;
	private Integer yaxxuxxrlxxxxxxxxxxxvinvoice;
	private String ybxxuxxrblxxxxxxxxxxattach;
	private BigDecimal z7xxzbtxavxxxxxxxxxxbaseamountt;
	private BigDecimal z6xxzltxavxxxxxxxxxxdelivchrgt;
	private BigDecimal z7xxzmtxavxxxxxxxxxxmiscchrgt;
	private BigDecimal z8xxzxz1avxxxxxxxxxxtax1amtt;
	private BigDecimal z9xxzxz2avxxxxxxxxxxtax2amtt;
	private BigDecimal zaxxzxz3avxxxxxxxxxxtax3amtt;
	private Date zbxxzxxxavxxxxxxxxxxstartdatet;
	private Integer zcxxzzfxhhxxxxxxxxxxstatusfl;
	private Date zdxxcztxlxxxxxxxxxxxstatusfldt;
	private String yexxuznybvxxxxxxxxxxnotes;
	private String zexxutoxlhxxxxxxxxxxowner;
	private String zzxxu2oxxhxxxxxxxxxxowner2;
	private String yfxxuzdrbvxxxxxxxxxxdocmnt;
	private String zgxxuxxrbvxxxxxxxxxxbarpo;
	private Set<Xoxxuq2b4xwwqqhxxxxxcuodetails> xoxxuq2b4xwwqqhxxxxxcuodetailses = new HashSet<Xoxxuq2b4xwwqqhxxxxxcuodetails>(
			0);
	private Set<Xxxxuq9ccxwwqqhxxxxxprocessdetails> xxxxuq9ccxwwqqhxxxxxprocessdetailses = new HashSet<Xxxxuq9ccxwwqqhxxxxxprocessdetails>(
			0);
	private Set<Trexuq255xwwqqhxxxxxshipment> trexuq255xwwqqhxxxxxshipments = new HashSet<Trexuq255xwwqqhxxxxxshipment>(
			0);
	private Set<Trexuq266xwwqqhxxxxxcuinvoice> trexuq266xwwqqhxxxxxcuinvoices = new HashSet<Trexuq266xwwqqhxxxxxcuinvoice>(
			0);

	public Trexuq244xwwqqhxxxxxcuorders() {
	}

	public Trexuq244xwwqqhxxxxxcuorders(String a0xxuncobvxxxxxxxxxxpurchsno) {
		this.a0xxuncobvxxxxxxxxxxpurchsno = a0xxuncobvxxxxxxxxxxpurchsno;
	}
	public Trexuq244xwwqqhxxxxxcuorders(
			Fxxxuq111xwwqqhxxxxxaddress fxxxuq111xwwqqhxxxxxaddressByShipcodefrompay,
			Fxxxuq111xwwqqhxxxxxaddress fxxxuq111xwwqqhxxxxxaddressByShipcode,
			Trexuq233xwwqqhxxxxxcuquote trexuq233xwwqqhxxxxxcuquote,
			Jxxxbh400xwwqqhxxxxxemployee jxxxbh400xwwqqhxxxxxemployee,
			Jxxxuq201xwwqqhxxxxxcustomer jxxxuq201xwwqqhxxxxxcustomer,
			Fpxxfq1a5xwwqqhxxxxxitem fpxxfq1a5xwwqqhxxxxxitem,
			String a0xxuncobvxxxxxxxxxxpurchsno,
			Date b1xxcxxxbvxxxxxxxxxxdelvdatet,
			Integer b4xxuxxrlxxxcxxxxxxxcinvoice,
			Integer y4xxuxxrlxxxxxxxxxxxjobno,
			BigDecimal z1xxztprlxxxxxxxxxxxamounttotal,
			BigDecimal z2xxzyprlxxxxxxxxxxxamountostndt,
			BigDecimal b5xxztqrlxxxxxxxxxxxqtytotal,
			BigDecimal z3xxzyqrlxxxxxxxxxxxqtyostndt,
			Integer y6xxuxxrlxxxxxxxxxxxvpono,
			Integer y7xxuxxxbxxxxxxxxxxxrfpord,
			Integer y8xxuxxrxxxxxxxxxxxxrcpono,
			Date c1xxcxxxbxxxxxxxxxxxodatet,
			String c2xxcxxxbv09xxxxxxxxterms,
			Boolean c3xxfxxrbv09xxxxxxxxpriority,
			Integer z4xxzzprhvxxxxxxxxxxprintmstat,
			Date z5xxczqxlhxxxxxxxxxxprinmtfldt,
			String y9xxcxxxbv10xxxxxxxxtype,
			Integer yaxxuxxrlxxxxxxxxxxxvinvoice,
			String ybxxuxxrblxxxxxxxxxxattach,
			BigDecimal z7xxzbtxavxxxxxxxxxxbaseamountt,
			BigDecimal z6xxzltxavxxxxxxxxxxdelivchrgt,
			BigDecimal z7xxzmtxavxxxxxxxxxxmiscchrgt,
			BigDecimal z8xxzxz1avxxxxxxxxxxtax1amtt,
			BigDecimal z9xxzxz2avxxxxxxxxxxtax2amtt,
			BigDecimal zaxxzxz3avxxxxxxxxxxtax3amtt,
			Date zbxxzxxxavxxxxxxxxxxstartdatet,
			Integer zcxxzzfxhhxxxxxxxxxxstatusfl,
			Date zdxxcztxlxxxxxxxxxxxstatusfldt,
			String yexxuznybvxxxxxxxxxxnotes,
			String zexxutoxlhxxxxxxxxxxowner,
			String zzxxu2oxxhxxxxxxxxxxowner2,
			String yfxxuzdrbvxxxxxxxxxxdocmnt,
			String zgxxuxxrbvxxxxxxxxxxbarpo,
			Set<Xoxxuq2b4xwwqqhxxxxxcuodetails> xoxxuq2b4xwwqqhxxxxxcuodetailses,
			Set<Xxxxuq9ccxwwqqhxxxxxprocessdetails> xxxxuq9ccxwwqqhxxxxxprocessdetailses,
			Set<Trexuq255xwwqqhxxxxxshipment> trexuq255xwwqqhxxxxxshipments,
			Set<Trexuq266xwwqqhxxxxxcuinvoice> trexuq266xwwqqhxxxxxcuinvoices) {
		this.fxxxuq111xwwqqhxxxxxaddressByShipcodefrompay = fxxxuq111xwwqqhxxxxxaddressByShipcodefrompay;
		this.fxxxuq111xwwqqhxxxxxaddressByShipcode = fxxxuq111xwwqqhxxxxxaddressByShipcode;
		this.trexuq233xwwqqhxxxxxcuquote = trexuq233xwwqqhxxxxxcuquote;
		this.jxxxbh400xwwqqhxxxxxemployee = jxxxbh400xwwqqhxxxxxemployee;
		this.jxxxuq201xwwqqhxxxxxcustomer = jxxxuq201xwwqqhxxxxxcustomer;
		this.fpxxfq1a5xwwqqhxxxxxitem = fpxxfq1a5xwwqqhxxxxxitem;
		this.a0xxuncobvxxxxxxxxxxpurchsno = a0xxuncobvxxxxxxxxxxpurchsno;
		this.b1xxcxxxbvxxxxxxxxxxdelvdatet = b1xxcxxxbvxxxxxxxxxxdelvdatet;
		this.b4xxuxxrlxxxcxxxxxxxcinvoice = b4xxuxxrlxxxcxxxxxxxcinvoice;
		this.y4xxuxxrlxxxxxxxxxxxjobno = y4xxuxxrlxxxxxxxxxxxjobno;
		this.z1xxztprlxxxxxxxxxxxamounttotal = z1xxztprlxxxxxxxxxxxamounttotal;
		this.z2xxzyprlxxxxxxxxxxxamountostndt = z2xxzyprlxxxxxxxxxxxamountostndt;
		this.b5xxztqrlxxxxxxxxxxxqtytotal = b5xxztqrlxxxxxxxxxxxqtytotal;
		this.z3xxzyqrlxxxxxxxxxxxqtyostndt = z3xxzyqrlxxxxxxxxxxxqtyostndt;
		this.y6xxuxxrlxxxxxxxxxxxvpono = y6xxuxxrlxxxxxxxxxxxvpono;
		this.y7xxuxxxbxxxxxxxxxxxrfpord = y7xxuxxxbxxxxxxxxxxxrfpord;
		this.y8xxuxxrxxxxxxxxxxxxrcpono = y8xxuxxrxxxxxxxxxxxxrcpono;
		this.c1xxcxxxbxxxxxxxxxxxodatet = c1xxcxxxbxxxxxxxxxxxodatet;
		this.c2xxcxxxbv09xxxxxxxxterms = c2xxcxxxbv09xxxxxxxxterms;
		this.c3xxfxxrbv09xxxxxxxxpriority = c3xxfxxrbv09xxxxxxxxpriority;
		this.z4xxzzprhvxxxxxxxxxxprintmstat = z4xxzzprhvxxxxxxxxxxprintmstat;
		this.z5xxczqxlhxxxxxxxxxxprinmtfldt = z5xxczqxlhxxxxxxxxxxprinmtfldt;
		this.y9xxcxxxbv10xxxxxxxxtype = y9xxcxxxbv10xxxxxxxxtype;
		this.yaxxuxxrlxxxxxxxxxxxvinvoice = yaxxuxxrlxxxxxxxxxxxvinvoice;
		this.ybxxuxxrblxxxxxxxxxxattach = ybxxuxxrblxxxxxxxxxxattach;
		this.z7xxzbtxavxxxxxxxxxxbaseamountt = z7xxzbtxavxxxxxxxxxxbaseamountt;
		this.z6xxzltxavxxxxxxxxxxdelivchrgt = z6xxzltxavxxxxxxxxxxdelivchrgt;
		this.z7xxzmtxavxxxxxxxxxxmiscchrgt = z7xxzmtxavxxxxxxxxxxmiscchrgt;
		this.z8xxzxz1avxxxxxxxxxxtax1amtt = z8xxzxz1avxxxxxxxxxxtax1amtt;
		this.z9xxzxz2avxxxxxxxxxxtax2amtt = z9xxzxz2avxxxxxxxxxxtax2amtt;
		this.zaxxzxz3avxxxxxxxxxxtax3amtt = zaxxzxz3avxxxxxxxxxxtax3amtt;
		this.zbxxzxxxavxxxxxxxxxxstartdatet = zbxxzxxxavxxxxxxxxxxstartdatet;
		this.zcxxzzfxhhxxxxxxxxxxstatusfl = zcxxzzfxhhxxxxxxxxxxstatusfl;
		this.zdxxcztxlxxxxxxxxxxxstatusfldt = zdxxcztxlxxxxxxxxxxxstatusfldt;
		this.yexxuznybvxxxxxxxxxxnotes = yexxuznybvxxxxxxxxxxnotes;
		this.zexxutoxlhxxxxxxxxxxowner = zexxutoxlhxxxxxxxxxxowner;
		this.zzxxu2oxxhxxxxxxxxxxowner2 = zzxxu2oxxhxxxxxxxxxxowner2;
		this.yfxxuzdrbvxxxxxxxxxxdocmnt = yfxxuzdrbvxxxxxxxxxxdocmnt;
		this.zgxxuxxrbvxxxxxxxxxxbarpo = zgxxuxxrbvxxxxxxxxxxbarpo;
		this.xoxxuq2b4xwwqqhxxxxxcuodetailses = xoxxuq2b4xwwqqhxxxxxcuodetailses;
		this.xxxxuq9ccxwwqqhxxxxxprocessdetailses = xxxxuq9ccxwwqqhxxxxxprocessdetailses;
		this.trexuq255xwwqqhxxxxxshipments = trexuq255xwwqqhxxxxxshipments;
		this.trexuq266xwwqqhxxxxxcuinvoices = trexuq266xwwqqhxxxxxcuinvoices;
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
	@JoinColumn(name = "shipcodefrompay")
	public Fxxxuq111xwwqqhxxxxxaddress getFxxxuq111xwwqqhxxxxxaddressByShipcodefrompay() {
		return this.fxxxuq111xwwqqhxxxxxaddressByShipcodefrompay;
	}

	public void setFxxxuq111xwwqqhxxxxxaddressByShipcodefrompay(
			Fxxxuq111xwwqqhxxxxxaddress fxxxuq111xwwqqhxxxxxaddressByShipcodefrompay) {
		this.fxxxuq111xwwqqhxxxxxaddressByShipcodefrompay = fxxxuq111xwwqqhxxxxxaddressByShipcodefrompay;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "shipcode")
	public Fxxxuq111xwwqqhxxxxxaddress getFxxxuq111xwwqqhxxxxxaddressByShipcode() {
		return this.fxxxuq111xwwqqhxxxxxaddressByShipcode;
	}

	public void setFxxxuq111xwwqqhxxxxxaddressByShipcode(
			Fxxxuq111xwwqqhxxxxxaddress fxxxuq111xwwqqhxxxxxaddressByShipcode) {
		this.fxxxuq111xwwqqhxxxxxaddressByShipcode = fxxxuq111xwwqqhxxxxxaddressByShipcode;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "cuquote")
	public Trexuq233xwwqqhxxxxxcuquote getTrexuq233xwwqqhxxxxxcuquote() {
		return this.trexuq233xwwqqhxxxxxcuquote;
	}

	public void setTrexuq233xwwqqhxxxxxcuquote(
			Trexuq233xwwqqhxxxxxcuquote trexuq233xwwqqhxxxxxcuquote) {
		this.trexuq233xwwqqhxxxxxcuquote = trexuq233xwwqqhxxxxxcuquote;
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

	@Column(name = "purchsno", nullable = false, length = 32)
	@NotNull
	@Size(max = 32)
	public String getA0xxuncobvxxxxxxxxxxpurchsno() {
		return this.a0xxuncobvxxxxxxxxxxpurchsno;
	}

	public void setA0xxuncobvxxxxxxxxxxpurchsno(
			String a0xxuncobvxxxxxxxxxxpurchsno) {
		this.a0xxuncobvxxxxxxxxxxpurchsno = a0xxuncobvxxxxxxxxxxpurchsno;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "delvdatet", length = 29)
	public Date getB1xxcxxxbvxxxxxxxxxxdelvdatet() {
		return this.b1xxcxxxbvxxxxxxxxxxdelvdatet;
	}

	public void setB1xxcxxxbvxxxxxxxxxxdelvdatet(
			Date b1xxcxxxbvxxxxxxxxxxdelvdatet) {
		this.b1xxcxxxbvxxxxxxxxxxdelvdatet = b1xxcxxxbvxxxxxxxxxxdelvdatet;
	}

	@Column(name = "cinvoice")
	public Integer getB4xxuxxrlxxxcxxxxxxxcinvoice() {
		return this.b4xxuxxrlxxxcxxxxxxxcinvoice;
	}

	public void setB4xxuxxrlxxxcxxxxxxxcinvoice(
			Integer b4xxuxxrlxxxcxxxxxxxcinvoice) {
		this.b4xxuxxrlxxxcxxxxxxxcinvoice = b4xxuxxrlxxxcxxxxxxxcinvoice;
	}

	@Column(name = "jobno")
	public Integer getY4xxuxxrlxxxxxxxxxxxjobno() {
		return this.y4xxuxxrlxxxxxxxxxxxjobno;
	}

	public void setY4xxuxxrlxxxxxxxxxxxjobno(Integer y4xxuxxrlxxxxxxxxxxxjobno) {
		this.y4xxuxxrlxxxxxxxxxxxjobno = y4xxuxxrlxxxxxxxxxxxjobno;
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
	public BigDecimal getB5xxztqrlxxxxxxxxxxxqtytotal() {
		return this.b5xxztqrlxxxxxxxxxxxqtytotal;
	}

	public void setB5xxztqrlxxxxxxxxxxxqtytotal(
			BigDecimal b5xxztqrlxxxxxxxxxxxqtytotal) {
		this.b5xxztqrlxxxxxxxxxxxqtytotal = b5xxztqrlxxxxxxxxxxxqtytotal;
	}

	@Column(name = "qtyostndt", precision = 14)
	public BigDecimal getZ3xxzyqrlxxxxxxxxxxxqtyostndt() {
		return this.z3xxzyqrlxxxxxxxxxxxqtyostndt;
	}

	public void setZ3xxzyqrlxxxxxxxxxxxqtyostndt(
			BigDecimal z3xxzyqrlxxxxxxxxxxxqtyostndt) {
		this.z3xxzyqrlxxxxxxxxxxxqtyostndt = z3xxzyqrlxxxxxxxxxxxqtyostndt;
	}

	@Column(name = "vpono")
	public Integer getY6xxuxxrlxxxxxxxxxxxvpono() {
		return this.y6xxuxxrlxxxxxxxxxxxvpono;
	}

	public void setY6xxuxxrlxxxxxxxxxxxvpono(Integer y6xxuxxrlxxxxxxxxxxxvpono) {
		this.y6xxuxxrlxxxxxxxxxxxvpono = y6xxuxxrlxxxxxxxxxxxvpono;
	}

	@Column(name = "rfpord")
	public Integer getY7xxuxxxbxxxxxxxxxxxrfpord() {
		return this.y7xxuxxxbxxxxxxxxxxxrfpord;
	}

	public void setY7xxuxxxbxxxxxxxxxxxrfpord(Integer y7xxuxxxbxxxxxxxxxxxrfpord) {
		this.y7xxuxxxbxxxxxxxxxxxrfpord = y7xxuxxxbxxxxxxxxxxxrfpord;
	}

	@Column(name = "rcpono")
	public Integer getY8xxuxxrxxxxxxxxxxxxrcpono() {
		return this.y8xxuxxrxxxxxxxxxxxxrcpono;
	}

	public void setY8xxuxxrxxxxxxxxxxxxrcpono(Integer y8xxuxxrxxxxxxxxxxxxrcpono) {
		this.y8xxuxxrxxxxxxxxxxxxrcpono = y8xxuxxrxxxxxxxxxxxxrcpono;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "odatet", length = 29)
	public Date getC1xxcxxxbxxxxxxxxxxxodatet() {
		return this.c1xxcxxxbxxxxxxxxxxxodatet;
	}

	public void setC1xxcxxxbxxxxxxxxxxxodatet(Date c1xxcxxxbxxxxxxxxxxxodatet) {
		this.c1xxcxxxbxxxxxxxxxxxodatet = c1xxcxxxbxxxxxxxxxxxodatet;
	}

	@Column(name = "terms", length = 20)
	@Size(max = 20)
	public String getC2xxcxxxbv09xxxxxxxxterms() {
		return this.c2xxcxxxbv09xxxxxxxxterms;
	}

	public void setC2xxcxxxbv09xxxxxxxxterms(String c2xxcxxxbv09xxxxxxxxterms) {
		this.c2xxcxxxbv09xxxxxxxxterms = c2xxcxxxbv09xxxxxxxxterms;
	}

	@Column(name = "priority")
	public Boolean getC3xxfxxrbv09xxxxxxxxpriority() {
		return this.c3xxfxxrbv09xxxxxxxxpriority;
	}

	public void setC3xxfxxrbv09xxxxxxxxpriority(
			Boolean c3xxfxxrbv09xxxxxxxxpriority) {
		this.c3xxfxxrbv09xxxxxxxxpriority = c3xxfxxrbv09xxxxxxxxpriority;
	}

	@Column(name = "printmstat")
	public Integer getZ4xxzzprhvxxxxxxxxxxprintmstat() {
		return this.z4xxzzprhvxxxxxxxxxxprintmstat;
	}

	public void setZ4xxzzprhvxxxxxxxxxxprintmstat(
			Integer z4xxzzprhvxxxxxxxxxxprintmstat) {
		this.z4xxzzprhvxxxxxxxxxxprintmstat = z4xxzzprhvxxxxxxxxxxprintmstat;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "prinmtfldt", length = 29)
	public Date getZ5xxczqxlhxxxxxxxxxxprinmtfldt() {
		return this.z5xxczqxlhxxxxxxxxxxprinmtfldt;
	}

	public void setZ5xxczqxlhxxxxxxxxxxprinmtfldt(
			Date z5xxczqxlhxxxxxxxxxxprinmtfldt) {
		this.z5xxczqxlhxxxxxxxxxxprinmtfldt = z5xxczqxlhxxxxxxxxxxprinmtfldt;
	}

	@Column(name = "type", length = 25)
	@Size(max = 25)
	public String getY9xxcxxxbv10xxxxxxxxtype() {
		return this.y9xxcxxxbv10xxxxxxxxtype;
	}

	public void setY9xxcxxxbv10xxxxxxxxtype(String y9xxcxxxbv10xxxxxxxxtype) {
		this.y9xxcxxxbv10xxxxxxxxtype = y9xxcxxxbv10xxxxxxxxtype;
	}

	@Column(name = "vinvoice")
	public Integer getYaxxuxxrlxxxxxxxxxxxvinvoice() {
		return this.yaxxuxxrlxxxxxxxxxxxvinvoice;
	}

	public void setYaxxuxxrlxxxxxxxxxxxvinvoice(
			Integer yaxxuxxrlxxxxxxxxxxxvinvoice) {
		this.yaxxuxxrlxxxxxxxxxxxvinvoice = yaxxuxxrlxxxxxxxxxxxvinvoice;
	}

	@Column(name = "attach", length = 90)
	@Size(max = 90)
	public String getYbxxuxxrblxxxxxxxxxxattach() {
		return this.ybxxuxxrblxxxxxxxxxxattach;
	}

	public void setYbxxuxxrblxxxxxxxxxxattach(String ybxxuxxrblxxxxxxxxxxattach) {
		this.ybxxuxxrblxxxxxxxxxxattach = ybxxuxxrblxxxxxxxxxxattach;
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
	public BigDecimal getZ6xxzltxavxxxxxxxxxxdelivchrgt() {
		return this.z6xxzltxavxxxxxxxxxxdelivchrgt;
	}

	public void setZ6xxzltxavxxxxxxxxxxdelivchrgt(
			BigDecimal z6xxzltxavxxxxxxxxxxdelivchrgt) {
		this.z6xxzltxavxxxxxxxxxxdelivchrgt = z6xxzltxavxxxxxxxxxxdelivchrgt;
	}

	@Column(name = "miscchrgt", precision = 14)
	public BigDecimal getZ7xxzmtxavxxxxxxxxxxmiscchrgt() {
		return this.z7xxzmtxavxxxxxxxxxxmiscchrgt;
	}

	public void setZ7xxzmtxavxxxxxxxxxxmiscchrgt(
			BigDecimal z7xxzmtxavxxxxxxxxxxmiscchrgt) {
		this.z7xxzmtxavxxxxxxxxxxmiscchrgt = z7xxzmtxavxxxxxxxxxxmiscchrgt;
	}

	@Column(name = "tax1amtt", precision = 14)
	public BigDecimal getZ8xxzxz1avxxxxxxxxxxtax1amtt() {
		return this.z8xxzxz1avxxxxxxxxxxtax1amtt;
	}

	public void setZ8xxzxz1avxxxxxxxxxxtax1amtt(
			BigDecimal z8xxzxz1avxxxxxxxxxxtax1amtt) {
		this.z8xxzxz1avxxxxxxxxxxtax1amtt = z8xxzxz1avxxxxxxxxxxtax1amtt;
	}

	@Column(name = "tax2amtt", precision = 14)
	public BigDecimal getZ9xxzxz2avxxxxxxxxxxtax2amtt() {
		return this.z9xxzxz2avxxxxxxxxxxtax2amtt;
	}

	public void setZ9xxzxz2avxxxxxxxxxxtax2amtt(
			BigDecimal z9xxzxz2avxxxxxxxxxxtax2amtt) {
		this.z9xxzxz2avxxxxxxxxxxtax2amtt = z9xxzxz2avxxxxxxxxxxtax2amtt;
	}

	@Column(name = "tax3amtt", precision = 14)
	public BigDecimal getZaxxzxz3avxxxxxxxxxxtax3amtt() {
		return this.zaxxzxz3avxxxxxxxxxxtax3amtt;
	}

	public void setZaxxzxz3avxxxxxxxxxxtax3amtt(
			BigDecimal zaxxzxz3avxxxxxxxxxxtax3amtt) {
		this.zaxxzxz3avxxxxxxxxxxtax3amtt = zaxxzxz3avxxxxxxxxxxtax3amtt;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "startdatet", length = 29)
	public Date getZbxxzxxxavxxxxxxxxxxstartdatet() {
		return this.zbxxzxxxavxxxxxxxxxxstartdatet;
	}

	public void setZbxxzxxxavxxxxxxxxxxstartdatet(
			Date zbxxzxxxavxxxxxxxxxxstartdatet) {
		this.zbxxzxxxavxxxxxxxxxxstartdatet = zbxxzxxxavxxxxxxxxxxstartdatet;
	}

	@Column(name = "statusfl")
	public Integer getZcxxzzfxhhxxxxxxxxxxstatusfl() {
		return this.zcxxzzfxhhxxxxxxxxxxstatusfl;
	}

	public void setZcxxzzfxhhxxxxxxxxxxstatusfl(
			Integer zcxxzzfxhhxxxxxxxxxxstatusfl) {
		this.zcxxzzfxhhxxxxxxxxxxstatusfl = zcxxzzfxhhxxxxxxxxxxstatusfl;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "statusfldt", length = 29)
	public Date getZdxxcztxlxxxxxxxxxxxstatusfldt() {
		return this.zdxxcztxlxxxxxxxxxxxstatusfldt;
	}

	public void setZdxxcztxlxxxxxxxxxxxstatusfldt(
			Date zdxxcztxlxxxxxxxxxxxstatusfldt) {
		this.zdxxcztxlxxxxxxxxxxxstatusfldt = zdxxcztxlxxxxxxxxxxxstatusfldt;
	}

	@Column(name = "notes", length = 60)
	@Size(max = 60)
	public String getYexxuznybvxxxxxxxxxxnotes() {
		return this.yexxuznybvxxxxxxxxxxnotes;
	}

	public void setYexxuznybvxxxxxxxxxxnotes(String yexxuznybvxxxxxxxxxxnotes) {
		this.yexxuznybvxxxxxxxxxxnotes = yexxuznybvxxxxxxxxxxnotes;
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
	public String getYfxxuzdrbvxxxxxxxxxxdocmnt() {
		return this.yfxxuzdrbvxxxxxxxxxxdocmnt;
	}

	public void setYfxxuzdrbvxxxxxxxxxxdocmnt(String yfxxuzdrbvxxxxxxxxxxdocmnt) {
		this.yfxxuzdrbvxxxxxxxxxxdocmnt = yfxxuzdrbvxxxxxxxxxxdocmnt;
	}

	@Column(name = "barpo", length = 30)
	@Size(max = 30)
	public String getZgxxuxxrbvxxxxxxxxxxbarpo() {
		return this.zgxxuxxrbvxxxxxxxxxxbarpo;
	}

	public void setZgxxuxxrbvxxxxxxxxxxbarpo(String zgxxuxxrbvxxxxxxxxxxbarpo) {
		this.zgxxuxxrbvxxxxxxxxxxbarpo = zgxxuxxrbvxxxxxxxxxxbarpo;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "trexuq244xwwqqhxxxxxcuorders")
	public Set<Xoxxuq2b4xwwqqhxxxxxcuodetails> getXoxxuq2b4xwwqqhxxxxxcuodetailses() {
		return this.xoxxuq2b4xwwqqhxxxxxcuodetailses;
	}

	public void setXoxxuq2b4xwwqqhxxxxxcuodetailses(
			Set<Xoxxuq2b4xwwqqhxxxxxcuodetails> xoxxuq2b4xwwqqhxxxxxcuodetailses) {
		this.xoxxuq2b4xwwqqhxxxxxcuodetailses = xoxxuq2b4xwwqqhxxxxxcuodetailses;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "trexuq244xwwqqhxxxxxcuorders")
	public Set<Xxxxuq9ccxwwqqhxxxxxprocessdetails> getXxxxuq9ccxwwqqhxxxxxprocessdetailses() {
		return this.xxxxuq9ccxwwqqhxxxxxprocessdetailses;
	}

	public void setXxxxuq9ccxwwqqhxxxxxprocessdetailses(
			Set<Xxxxuq9ccxwwqqhxxxxxprocessdetails> xxxxuq9ccxwwqqhxxxxxprocessdetailses) {
		this.xxxxuq9ccxwwqqhxxxxxprocessdetailses = xxxxuq9ccxwwqqhxxxxxprocessdetailses;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "trexuq244xwwqqhxxxxxcuorders")
	public Set<Trexuq255xwwqqhxxxxxshipment> getTrexuq255xwwqqhxxxxxshipments() {
		return this.trexuq255xwwqqhxxxxxshipments;
	}

	public void setTrexuq255xwwqqhxxxxxshipments(
			Set<Trexuq255xwwqqhxxxxxshipment> trexuq255xwwqqhxxxxxshipments) {
		this.trexuq255xwwqqhxxxxxshipments = trexuq255xwwqqhxxxxxshipments;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "trexuq244xwwqqhxxxxxcuorders")
	public Set<Trexuq266xwwqqhxxxxxcuinvoice> getTrexuq266xwwqqhxxxxxcuinvoices() {
		return this.trexuq266xwwqqhxxxxxcuinvoices;
	}

	public void setTrexuq266xwwqqhxxxxxcuinvoices(
			Set<Trexuq266xwwqqhxxxxxcuinvoice> trexuq266xwwqqhxxxxxcuinvoices) {
		this.trexuq266xwwqqhxxxxxcuinvoices = trexuq266xwwqqhxxxxxcuinvoices;
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