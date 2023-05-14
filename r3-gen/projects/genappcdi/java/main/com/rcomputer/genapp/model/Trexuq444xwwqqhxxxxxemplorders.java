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
 * Trexuq444xwwqqhxxxxxemplorders generated by hbm2java
 */
@Entity
@XmlRootElement
@Table(name = "emplorders")
public class Trexuq444xwwqqhxxxxxemplorders implements java.io.Serializable {

	private Integer a0xxuobxbxxxxxxxxxxxsid;
	private Trexuq377xwwqqhxxxxxvshipmen trexuq377xwwqqhxxxxxvshipmen;
	private Jxxxbh400xwwqqhxxxxxemployee jxxxbh400xwwqqhxxxxxemployeeByAgent;
	private Fpxxfq1a5xwwqqhxxxxxitem fpxxfq1a5xwwqqhxxxxxitem;
	private Jxxxbh400xwwqqhxxxxxemployee jxxxbh400xwwqqhxxxxxemployeeByEmployee;
	private String a0xxuneobvxxxxxxxxxxpurchsno;
	private Date b1xxcxxxbvxxxxxxxxxxdelvdatet;
	private BigDecimal z1xxztprlxxxxxxxxxxxamounttotal;
	private BigDecimal z2xxzyprlxxxxxxxxxxxamountostndt;
	private BigDecimal z3xxztqrlxxxxxxxxxxxqtytotal;
	private BigDecimal z4xxzyqrlxxxxxxxxxxxqtyostndt;
	private Integer z5xxzzfxhhxxxxxxxxxxstatusfl;
	private Integer y2xxuxxrlxxxxxxxxxxxjobno;
	private Integer b4xxuxxrlxxxxxxxxxxxvpono;
	private Integer y3xxuxxxbxxxxxxxxxxxrfpord;
	private Date z6xxcztxlxxxxxxxxxxxstatusfldt;
	private Integer y4xxuxxrxxxxxxxxxxxxrcpono;
	private Date c1xxcxxxbxxxxxxxxxxxodatet;
	private String c2xxcxxxbv09xxxxxxxxterms;
	private Boolean c3xxfxxrbv09xxxxxxxxpriority;
	private Integer z6xxzzprhvxxxxxxxxxxprintmstat;
	private Date z7xxczqxlhxxxxxxxxxxprinmtfldt;
	private String d1xxcxxxbv10xxxxxxxxtype;
	private Integer y4xxuxxrlxxxxxxxxxxxvinvoice;
	private String y5xxuxxrblxxxxxxxxxxattach;
	private BigDecimal z7xxzbtxavxxxxxxxxxxbaseamountt;
	private BigDecimal z8xxzltxavxxxxxxxxxxdelivchrgt;
	private BigDecimal z9xxzmtxavxxxxxxxxxxmiscchrgt;
	private BigDecimal zaxxzxz1avxxxxxxxxxxtax1amtt;
	private BigDecimal zbxxzxz2avxxxxxxxxxxtax2amtt;
	private BigDecimal zcxxzxz3avxxxxxxxxxxtax3amtt;
	private Date d3xxcxxxbxxxxxxxxxxxstartdatet;
	private String yaxxuznybvxxxxxxxxxxnotes;
	private String zdxxutoxlhxxxxxxxxxxowner;
	private String zzxxu2oxxhxxxxxxxxxxowner2;
	private String ybxxuzdrbvxxxxxxxxxxdocmnt;
	private Set<Xoxxuq454xwwqqhxxxxxemplodetails> xoxxuq454xwwqqhxxxxxemplodetailses = new HashSet<Xoxxuq454xwwqqhxxxxxemplodetails>(
			0);

	public Trexuq444xwwqqhxxxxxemplorders() {
	}

	public Trexuq444xwwqqhxxxxxemplorders(String a0xxuneobvxxxxxxxxxxpurchsno) {
		this.a0xxuneobvxxxxxxxxxxpurchsno = a0xxuneobvxxxxxxxxxxpurchsno;
	}
	public Trexuq444xwwqqhxxxxxemplorders(
			Trexuq377xwwqqhxxxxxvshipmen trexuq377xwwqqhxxxxxvshipmen,
			Jxxxbh400xwwqqhxxxxxemployee jxxxbh400xwwqqhxxxxxemployeeByAgent,
			Fpxxfq1a5xwwqqhxxxxxitem fpxxfq1a5xwwqqhxxxxxitem,
			Jxxxbh400xwwqqhxxxxxemployee jxxxbh400xwwqqhxxxxxemployeeByEmployee,
			String a0xxuneobvxxxxxxxxxxpurchsno,
			Date b1xxcxxxbvxxxxxxxxxxdelvdatet,
			BigDecimal z1xxztprlxxxxxxxxxxxamounttotal,
			BigDecimal z2xxzyprlxxxxxxxxxxxamountostndt,
			BigDecimal z3xxztqrlxxxxxxxxxxxqtytotal,
			BigDecimal z4xxzyqrlxxxxxxxxxxxqtyostndt,
			Integer z5xxzzfxhhxxxxxxxxxxstatusfl,
			Integer y2xxuxxrlxxxxxxxxxxxjobno,
			Integer b4xxuxxrlxxxxxxxxxxxvpono,
			Integer y3xxuxxxbxxxxxxxxxxxrfpord,
			Date z6xxcztxlxxxxxxxxxxxstatusfldt,
			Integer y4xxuxxrxxxxxxxxxxxxrcpono,
			Date c1xxcxxxbxxxxxxxxxxxodatet,
			String c2xxcxxxbv09xxxxxxxxterms,
			Boolean c3xxfxxrbv09xxxxxxxxpriority,
			Integer z6xxzzprhvxxxxxxxxxxprintmstat,
			Date z7xxczqxlhxxxxxxxxxxprinmtfldt,
			String d1xxcxxxbv10xxxxxxxxtype,
			Integer y4xxuxxrlxxxxxxxxxxxvinvoice,
			String y5xxuxxrblxxxxxxxxxxattach,
			BigDecimal z7xxzbtxavxxxxxxxxxxbaseamountt,
			BigDecimal z8xxzltxavxxxxxxxxxxdelivchrgt,
			BigDecimal z9xxzmtxavxxxxxxxxxxmiscchrgt,
			BigDecimal zaxxzxz1avxxxxxxxxxxtax1amtt,
			BigDecimal zbxxzxz2avxxxxxxxxxxtax2amtt,
			BigDecimal zcxxzxz3avxxxxxxxxxxtax3amtt,
			Date d3xxcxxxbxxxxxxxxxxxstartdatet,
			String yaxxuznybvxxxxxxxxxxnotes,
			String zdxxutoxlhxxxxxxxxxxowner,
			String zzxxu2oxxhxxxxxxxxxxowner2,
			String ybxxuzdrbvxxxxxxxxxxdocmnt,
			Set<Xoxxuq454xwwqqhxxxxxemplodetails> xoxxuq454xwwqqhxxxxxemplodetailses) {
		this.trexuq377xwwqqhxxxxxvshipmen = trexuq377xwwqqhxxxxxvshipmen;
		this.jxxxbh400xwwqqhxxxxxemployeeByAgent = jxxxbh400xwwqqhxxxxxemployeeByAgent;
		this.fpxxfq1a5xwwqqhxxxxxitem = fpxxfq1a5xwwqqhxxxxxitem;
		this.jxxxbh400xwwqqhxxxxxemployeeByEmployee = jxxxbh400xwwqqhxxxxxemployeeByEmployee;
		this.a0xxuneobvxxxxxxxxxxpurchsno = a0xxuneobvxxxxxxxxxxpurchsno;
		this.b1xxcxxxbvxxxxxxxxxxdelvdatet = b1xxcxxxbvxxxxxxxxxxdelvdatet;
		this.z1xxztprlxxxxxxxxxxxamounttotal = z1xxztprlxxxxxxxxxxxamounttotal;
		this.z2xxzyprlxxxxxxxxxxxamountostndt = z2xxzyprlxxxxxxxxxxxamountostndt;
		this.z3xxztqrlxxxxxxxxxxxqtytotal = z3xxztqrlxxxxxxxxxxxqtytotal;
		this.z4xxzyqrlxxxxxxxxxxxqtyostndt = z4xxzyqrlxxxxxxxxxxxqtyostndt;
		this.z5xxzzfxhhxxxxxxxxxxstatusfl = z5xxzzfxhhxxxxxxxxxxstatusfl;
		this.y2xxuxxrlxxxxxxxxxxxjobno = y2xxuxxrlxxxxxxxxxxxjobno;
		this.b4xxuxxrlxxxxxxxxxxxvpono = b4xxuxxrlxxxxxxxxxxxvpono;
		this.y3xxuxxxbxxxxxxxxxxxrfpord = y3xxuxxxbxxxxxxxxxxxrfpord;
		this.z6xxcztxlxxxxxxxxxxxstatusfldt = z6xxcztxlxxxxxxxxxxxstatusfldt;
		this.y4xxuxxrxxxxxxxxxxxxrcpono = y4xxuxxrxxxxxxxxxxxxrcpono;
		this.c1xxcxxxbxxxxxxxxxxxodatet = c1xxcxxxbxxxxxxxxxxxodatet;
		this.c2xxcxxxbv09xxxxxxxxterms = c2xxcxxxbv09xxxxxxxxterms;
		this.c3xxfxxrbv09xxxxxxxxpriority = c3xxfxxrbv09xxxxxxxxpriority;
		this.z6xxzzprhvxxxxxxxxxxprintmstat = z6xxzzprhvxxxxxxxxxxprintmstat;
		this.z7xxczqxlhxxxxxxxxxxprinmtfldt = z7xxczqxlhxxxxxxxxxxprinmtfldt;
		this.d1xxcxxxbv10xxxxxxxxtype = d1xxcxxxbv10xxxxxxxxtype;
		this.y4xxuxxrlxxxxxxxxxxxvinvoice = y4xxuxxrlxxxxxxxxxxxvinvoice;
		this.y5xxuxxrblxxxxxxxxxxattach = y5xxuxxrblxxxxxxxxxxattach;
		this.z7xxzbtxavxxxxxxxxxxbaseamountt = z7xxzbtxavxxxxxxxxxxbaseamountt;
		this.z8xxzltxavxxxxxxxxxxdelivchrgt = z8xxzltxavxxxxxxxxxxdelivchrgt;
		this.z9xxzmtxavxxxxxxxxxxmiscchrgt = z9xxzmtxavxxxxxxxxxxmiscchrgt;
		this.zaxxzxz1avxxxxxxxxxxtax1amtt = zaxxzxz1avxxxxxxxxxxtax1amtt;
		this.zbxxzxz2avxxxxxxxxxxtax2amtt = zbxxzxz2avxxxxxxxxxxtax2amtt;
		this.zcxxzxz3avxxxxxxxxxxtax3amtt = zcxxzxz3avxxxxxxxxxxtax3amtt;
		this.d3xxcxxxbxxxxxxxxxxxstartdatet = d3xxcxxxbxxxxxxxxxxxstartdatet;
		this.yaxxuznybvxxxxxxxxxxnotes = yaxxuznybvxxxxxxxxxxnotes;
		this.zdxxutoxlhxxxxxxxxxxowner = zdxxutoxlhxxxxxxxxxxowner;
		this.zzxxu2oxxhxxxxxxxxxxowner2 = zzxxu2oxxhxxxxxxxxxxowner2;
		this.ybxxuzdrbvxxxxxxxxxxdocmnt = ybxxuzdrbvxxxxxxxxxxdocmnt;
		this.xoxxuq454xwwqqhxxxxxemplodetailses = xoxxuq454xwwqqhxxxxxemplodetailses;
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
	@JoinColumn(name = "shipcode")
	public Trexuq377xwwqqhxxxxxvshipmen getTrexuq377xwwqqhxxxxxvshipmen() {
		return this.trexuq377xwwqqhxxxxxvshipmen;
	}

	public void setTrexuq377xwwqqhxxxxxvshipmen(
			Trexuq377xwwqqhxxxxxvshipmen trexuq377xwwqqhxxxxxvshipmen) {
		this.trexuq377xwwqqhxxxxxvshipmen = trexuq377xwwqqhxxxxxvshipmen;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "agent")
	public Jxxxbh400xwwqqhxxxxxemployee getJxxxbh400xwwqqhxxxxxemployeeByAgent() {
		return this.jxxxbh400xwwqqhxxxxxemployeeByAgent;
	}

	public void setJxxxbh400xwwqqhxxxxxemployeeByAgent(
			Jxxxbh400xwwqqhxxxxxemployee jxxxbh400xwwqqhxxxxxemployeeByAgent) {
		this.jxxxbh400xwwqqhxxxxxemployeeByAgent = jxxxbh400xwwqqhxxxxxemployeeByAgent;
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
	@JoinColumn(name = "employee")
	public Jxxxbh400xwwqqhxxxxxemployee getJxxxbh400xwwqqhxxxxxemployeeByEmployee() {
		return this.jxxxbh400xwwqqhxxxxxemployeeByEmployee;
	}

	public void setJxxxbh400xwwqqhxxxxxemployeeByEmployee(
			Jxxxbh400xwwqqhxxxxxemployee jxxxbh400xwwqqhxxxxxemployeeByEmployee) {
		this.jxxxbh400xwwqqhxxxxxemployeeByEmployee = jxxxbh400xwwqqhxxxxxemployeeByEmployee;
	}

	@Column(name = "purchsno", nullable = false, length = 32)
	@NotNull
	@Size(max = 32)
	public String getA0xxuneobvxxxxxxxxxxpurchsno() {
		return this.a0xxuneobvxxxxxxxxxxpurchsno;
	}

	public void setA0xxuneobvxxxxxxxxxxpurchsno(
			String a0xxuneobvxxxxxxxxxxpurchsno) {
		this.a0xxuneobvxxxxxxxxxxpurchsno = a0xxuneobvxxxxxxxxxxpurchsno;
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

	@Column(name = "statusfl")
	public Integer getZ5xxzzfxhhxxxxxxxxxxstatusfl() {
		return this.z5xxzzfxhhxxxxxxxxxxstatusfl;
	}

	public void setZ5xxzzfxhhxxxxxxxxxxstatusfl(
			Integer z5xxzzfxhhxxxxxxxxxxstatusfl) {
		this.z5xxzzfxhhxxxxxxxxxxstatusfl = z5xxzzfxhhxxxxxxxxxxstatusfl;
	}

	@Column(name = "jobno")
	public Integer getY2xxuxxrlxxxxxxxxxxxjobno() {
		return this.y2xxuxxrlxxxxxxxxxxxjobno;
	}

	public void setY2xxuxxrlxxxxxxxxxxxjobno(Integer y2xxuxxrlxxxxxxxxxxxjobno) {
		this.y2xxuxxrlxxxxxxxxxxxjobno = y2xxuxxrlxxxxxxxxxxxjobno;
	}

	@Column(name = "vpono")
	public Integer getB4xxuxxrlxxxxxxxxxxxvpono() {
		return this.b4xxuxxrlxxxxxxxxxxxvpono;
	}

	public void setB4xxuxxrlxxxxxxxxxxxvpono(Integer b4xxuxxrlxxxxxxxxxxxvpono) {
		this.b4xxuxxrlxxxxxxxxxxxvpono = b4xxuxxrlxxxxxxxxxxxvpono;
	}

	@Column(name = "rfpord")
	public Integer getY3xxuxxxbxxxxxxxxxxxrfpord() {
		return this.y3xxuxxxbxxxxxxxxxxxrfpord;
	}

	public void setY3xxuxxxbxxxxxxxxxxxrfpord(Integer y3xxuxxxbxxxxxxxxxxxrfpord) {
		this.y3xxuxxxbxxxxxxxxxxxrfpord = y3xxuxxxbxxxxxxxxxxxrfpord;
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

	@Column(name = "rcpono")
	public Integer getY4xxuxxrxxxxxxxxxxxxrcpono() {
		return this.y4xxuxxrxxxxxxxxxxxxrcpono;
	}

	public void setY4xxuxxrxxxxxxxxxxxxrcpono(Integer y4xxuxxrxxxxxxxxxxxxrcpono) {
		this.y4xxuxxrxxxxxxxxxxxxrcpono = y4xxuxxrxxxxxxxxxxxxrcpono;
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
	public Integer getZ6xxzzprhvxxxxxxxxxxprintmstat() {
		return this.z6xxzzprhvxxxxxxxxxxprintmstat;
	}

	public void setZ6xxzzprhvxxxxxxxxxxprintmstat(
			Integer z6xxzzprhvxxxxxxxxxxprintmstat) {
		this.z6xxzzprhvxxxxxxxxxxprintmstat = z6xxzzprhvxxxxxxxxxxprintmstat;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "prinmtfldt", length = 29)
	public Date getZ7xxczqxlhxxxxxxxxxxprinmtfldt() {
		return this.z7xxczqxlhxxxxxxxxxxprinmtfldt;
	}

	public void setZ7xxczqxlhxxxxxxxxxxprinmtfldt(
			Date z7xxczqxlhxxxxxxxxxxprinmtfldt) {
		this.z7xxczqxlhxxxxxxxxxxprinmtfldt = z7xxczqxlhxxxxxxxxxxprinmtfldt;
	}

	@Column(name = "type", length = 25)
	@Size(max = 25)
	public String getD1xxcxxxbv10xxxxxxxxtype() {
		return this.d1xxcxxxbv10xxxxxxxxtype;
	}

	public void setD1xxcxxxbv10xxxxxxxxtype(String d1xxcxxxbv10xxxxxxxxtype) {
		this.d1xxcxxxbv10xxxxxxxxtype = d1xxcxxxbv10xxxxxxxxtype;
	}

	@Column(name = "vinvoice")
	public Integer getY4xxuxxrlxxxxxxxxxxxvinvoice() {
		return this.y4xxuxxrlxxxxxxxxxxxvinvoice;
	}

	public void setY4xxuxxrlxxxxxxxxxxxvinvoice(
			Integer y4xxuxxrlxxxxxxxxxxxvinvoice) {
		this.y4xxuxxrlxxxxxxxxxxxvinvoice = y4xxuxxrlxxxxxxxxxxxvinvoice;
	}

	@Column(name = "attach", length = 20)
	@Size(max = 20)
	public String getY5xxuxxrblxxxxxxxxxxattach() {
		return this.y5xxuxxrblxxxxxxxxxxattach;
	}

	public void setY5xxuxxrblxxxxxxxxxxattach(String y5xxuxxrblxxxxxxxxxxattach) {
		this.y5xxuxxrblxxxxxxxxxxattach = y5xxuxxrblxxxxxxxxxxattach;
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
	public BigDecimal getZ8xxzltxavxxxxxxxxxxdelivchrgt() {
		return this.z8xxzltxavxxxxxxxxxxdelivchrgt;
	}

	public void setZ8xxzltxavxxxxxxxxxxdelivchrgt(
			BigDecimal z8xxzltxavxxxxxxxxxxdelivchrgt) {
		this.z8xxzltxavxxxxxxxxxxdelivchrgt = z8xxzltxavxxxxxxxxxxdelivchrgt;
	}

	@Column(name = "miscchrgt", precision = 14)
	public BigDecimal getZ9xxzmtxavxxxxxxxxxxmiscchrgt() {
		return this.z9xxzmtxavxxxxxxxxxxmiscchrgt;
	}

	public void setZ9xxzmtxavxxxxxxxxxxmiscchrgt(
			BigDecimal z9xxzmtxavxxxxxxxxxxmiscchrgt) {
		this.z9xxzmtxavxxxxxxxxxxmiscchrgt = z9xxzmtxavxxxxxxxxxxmiscchrgt;
	}

	@Column(name = "tax1amtt", precision = 14)
	public BigDecimal getZaxxzxz1avxxxxxxxxxxtax1amtt() {
		return this.zaxxzxz1avxxxxxxxxxxtax1amtt;
	}

	public void setZaxxzxz1avxxxxxxxxxxtax1amtt(
			BigDecimal zaxxzxz1avxxxxxxxxxxtax1amtt) {
		this.zaxxzxz1avxxxxxxxxxxtax1amtt = zaxxzxz1avxxxxxxxxxxtax1amtt;
	}

	@Column(name = "tax2amtt", precision = 14)
	public BigDecimal getZbxxzxz2avxxxxxxxxxxtax2amtt() {
		return this.zbxxzxz2avxxxxxxxxxxtax2amtt;
	}

	public void setZbxxzxz2avxxxxxxxxxxtax2amtt(
			BigDecimal zbxxzxz2avxxxxxxxxxxtax2amtt) {
		this.zbxxzxz2avxxxxxxxxxxtax2amtt = zbxxzxz2avxxxxxxxxxxtax2amtt;
	}

	@Column(name = "tax3amtt", precision = 14)
	public BigDecimal getZcxxzxz3avxxxxxxxxxxtax3amtt() {
		return this.zcxxzxz3avxxxxxxxxxxtax3amtt;
	}

	public void setZcxxzxz3avxxxxxxxxxxtax3amtt(
			BigDecimal zcxxzxz3avxxxxxxxxxxtax3amtt) {
		this.zcxxzxz3avxxxxxxxxxxtax3amtt = zcxxzxz3avxxxxxxxxxxtax3amtt;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "startdatet", length = 29)
	public Date getD3xxcxxxbxxxxxxxxxxxstartdatet() {
		return this.d3xxcxxxbxxxxxxxxxxxstartdatet;
	}

	public void setD3xxcxxxbxxxxxxxxxxxstartdatet(
			Date d3xxcxxxbxxxxxxxxxxxstartdatet) {
		this.d3xxcxxxbxxxxxxxxxxxstartdatet = d3xxcxxxbxxxxxxxxxxxstartdatet;
	}

	@Column(name = "notes", length = 60)
	@Size(max = 60)
	public String getYaxxuznybvxxxxxxxxxxnotes() {
		return this.yaxxuznybvxxxxxxxxxxnotes;
	}

	public void setYaxxuznybvxxxxxxxxxxnotes(String yaxxuznybvxxxxxxxxxxnotes) {
		this.yaxxuznybvxxxxxxxxxxnotes = yaxxuznybvxxxxxxxxxxnotes;
	}

	@Column(name = "owner", length = 40)
	@Size(max = 40)
	public String getZdxxutoxlhxxxxxxxxxxowner() {
		return this.zdxxutoxlhxxxxxxxxxxowner;
	}

	public void setZdxxutoxlhxxxxxxxxxxowner(String zdxxutoxlhxxxxxxxxxxowner) {
		this.zdxxutoxlhxxxxxxxxxxowner = zdxxutoxlhxxxxxxxxxxowner;
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
	public String getYbxxuzdrbvxxxxxxxxxxdocmnt() {
		return this.ybxxuzdrbvxxxxxxxxxxdocmnt;
	}

	public void setYbxxuzdrbvxxxxxxxxxxdocmnt(String ybxxuzdrbvxxxxxxxxxxdocmnt) {
		this.ybxxuzdrbvxxxxxxxxxxdocmnt = ybxxuzdrbvxxxxxxxxxxdocmnt;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "trexuq444xwwqqhxxxxxemplorders")
	public Set<Xoxxuq454xwwqqhxxxxxemplodetails> getXoxxuq454xwwqqhxxxxxemplodetailses() {
		return this.xoxxuq454xwwqqhxxxxxemplodetailses;
	}

	public void setXoxxuq454xwwqqhxxxxxemplodetailses(
			Set<Xoxxuq454xwwqqhxxxxxemplodetails> xoxxuq454xwwqqhxxxxxemplodetailses) {
		this.xoxxuq454xwwqqhxxxxxemplodetailses = xoxxuq454xwwqqhxxxxxemplodetailses;
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
