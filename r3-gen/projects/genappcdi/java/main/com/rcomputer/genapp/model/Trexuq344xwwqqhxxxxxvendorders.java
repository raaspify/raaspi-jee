package com.rcomputer.genapp.model;
// Generated 11-Jul-2023 11:51:00 AM by Hibernate Tools 4.0.0

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
 * Trexuq344xwwqqhxxxxxvendorders generated by hbm2java
 */
@Entity
@XmlRootElement
@Table(name = "vendorders")
public class Trexuq344xwwqqhxxxxxvendorders implements java.io.Serializable {

	private Integer a0xxuobxbxxxxxxxxxxxsid;
	private Jxxxuq300xwwqqhxxxxxvendor jxxxuq300xwwqqhxxxxxvendor;
	private Jxxxbh400xwwqqhxxxxxemployee jxxxbh400xwwqqhxxxxxemployee;
	private Fpxxfq1a5xwwqqhxxxxxitem fpxxfq1a5xwwqqhxxxxxitem;
	private Trexuq333xwwqqhxxxxxvenquote trexuq333xwwqqhxxxxxvenquote;
	private String a0xxunvobvxxxxxxxxxxpurchsno;
	private Date b1xxcxxxbvxxxxxxxxxxdelvdatet;
	private BigDecimal z1xxztprlxxxxxxxxxxxamounttotal;
	private BigDecimal z2xxzyprlxxxxxxxxxxxamountostndt;
	private BigDecimal z3xxztqrlxxxxxxxxxxxqtytotal;
	private BigDecimal z4xxzyqrlxxxxxxxxxxxqtyostndt;
	private Integer z5xxzzfxhhxxxxxxxxxxstatusfl;
	private String y2xxuxxrlxxxxxxxxxxxjobno;
	private String y3xxuxxxbxxxxxxxxxxxrfpord;
	private Date z6xxcztxlxxxxxxxxxxxstatusfldt;
	private String y4xxuxxrxxxxxxxxxxxxrcpono;
	private Date c1xxcxxxbxxxxxxxxxxxodatet;
	private String c2xxcxxxbv09xxxxxxxxterms;
	private Boolean c3xxfxxrbv09xxxxxxxxpriority;
	private Integer z6xxzzprhvxxxxxxxxxxprintmstat;
	private Date z7xxczqxlhxxxxxxxxxxprinmtfldt;
	private String d1xxcxxxbv10xxxxxxxxtype;
	private String y4xxuxxrlxxxxxxxxxxxvinvoice;
	private String y5xxuxxrblxxxxxxxxxxattach;
	private String y6xxuxxrblxxxxxxxxxxshipcode;
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
	private Set<Trexuq3a6xwwqqhxxxxxvinvoice> trexuq3a6xwwqqhxxxxxvinvoices = new HashSet<Trexuq3a6xwwqqhxxxxxvinvoice>(
			0);
	private Set<Xoxxuq3d4xwwqqhxxxxxvendodetails> xoxxuq3d4xwwqqhxxxxxvendodetailses = new HashSet<Xoxxuq3d4xwwqqhxxxxxvendodetails>(
			0);
	private Set<Trexuq377xwwqqhxxxxxvshipmen> trexuq377xwwqqhxxxxxvshipmens = new HashSet<Trexuq377xwwqqhxxxxxvshipmen>(
			0);

	public Trexuq344xwwqqhxxxxxvendorders() {
	}

	public Trexuq344xwwqqhxxxxxvendorders(String a0xxunvobvxxxxxxxxxxpurchsno) {
		this.a0xxunvobvxxxxxxxxxxpurchsno = a0xxunvobvxxxxxxxxxxpurchsno;
	}
	public Trexuq344xwwqqhxxxxxvendorders(
			Jxxxuq300xwwqqhxxxxxvendor jxxxuq300xwwqqhxxxxxvendor,
			Jxxxbh400xwwqqhxxxxxemployee jxxxbh400xwwqqhxxxxxemployee,
			Fpxxfq1a5xwwqqhxxxxxitem fpxxfq1a5xwwqqhxxxxxitem,
			Trexuq333xwwqqhxxxxxvenquote trexuq333xwwqqhxxxxxvenquote,
			String a0xxunvobvxxxxxxxxxxpurchsno,
			Date b1xxcxxxbvxxxxxxxxxxdelvdatet,
			BigDecimal z1xxztprlxxxxxxxxxxxamounttotal,
			BigDecimal z2xxzyprlxxxxxxxxxxxamountostndt,
			BigDecimal z3xxztqrlxxxxxxxxxxxqtytotal,
			BigDecimal z4xxzyqrlxxxxxxxxxxxqtyostndt,
			Integer z5xxzzfxhhxxxxxxxxxxstatusfl,
			String y2xxuxxrlxxxxxxxxxxxjobno,
			String y3xxuxxxbxxxxxxxxxxxrfpord,
			Date z6xxcztxlxxxxxxxxxxxstatusfldt,
			String y4xxuxxrxxxxxxxxxxxxrcpono,
			Date c1xxcxxxbxxxxxxxxxxxodatet,
			String c2xxcxxxbv09xxxxxxxxterms,
			Boolean c3xxfxxrbv09xxxxxxxxpriority,
			Integer z6xxzzprhvxxxxxxxxxxprintmstat,
			Date z7xxczqxlhxxxxxxxxxxprinmtfldt,
			String d1xxcxxxbv10xxxxxxxxtype,
			String y4xxuxxrlxxxxxxxxxxxvinvoice,
			String y5xxuxxrblxxxxxxxxxxattach,
			String y6xxuxxrblxxxxxxxxxxshipcode,
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
			Set<Trexuq3a6xwwqqhxxxxxvinvoice> trexuq3a6xwwqqhxxxxxvinvoices,
			Set<Xoxxuq3d4xwwqqhxxxxxvendodetails> xoxxuq3d4xwwqqhxxxxxvendodetailses,
			Set<Trexuq377xwwqqhxxxxxvshipmen> trexuq377xwwqqhxxxxxvshipmens) {
		this.jxxxuq300xwwqqhxxxxxvendor = jxxxuq300xwwqqhxxxxxvendor;
		this.jxxxbh400xwwqqhxxxxxemployee = jxxxbh400xwwqqhxxxxxemployee;
		this.fpxxfq1a5xwwqqhxxxxxitem = fpxxfq1a5xwwqqhxxxxxitem;
		this.trexuq333xwwqqhxxxxxvenquote = trexuq333xwwqqhxxxxxvenquote;
		this.a0xxunvobvxxxxxxxxxxpurchsno = a0xxunvobvxxxxxxxxxxpurchsno;
		this.b1xxcxxxbvxxxxxxxxxxdelvdatet = b1xxcxxxbvxxxxxxxxxxdelvdatet;
		this.z1xxztprlxxxxxxxxxxxamounttotal = z1xxztprlxxxxxxxxxxxamounttotal;
		this.z2xxzyprlxxxxxxxxxxxamountostndt = z2xxzyprlxxxxxxxxxxxamountostndt;
		this.z3xxztqrlxxxxxxxxxxxqtytotal = z3xxztqrlxxxxxxxxxxxqtytotal;
		this.z4xxzyqrlxxxxxxxxxxxqtyostndt = z4xxzyqrlxxxxxxxxxxxqtyostndt;
		this.z5xxzzfxhhxxxxxxxxxxstatusfl = z5xxzzfxhhxxxxxxxxxxstatusfl;
		this.y2xxuxxrlxxxxxxxxxxxjobno = y2xxuxxrlxxxxxxxxxxxjobno;
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
		this.y6xxuxxrblxxxxxxxxxxshipcode = y6xxuxxrblxxxxxxxxxxshipcode;
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
		this.trexuq3a6xwwqqhxxxxxvinvoices = trexuq3a6xwwqqhxxxxxvinvoices;
		this.xoxxuq3d4xwwqqhxxxxxvendodetailses = xoxxuq3d4xwwqqhxxxxxvendodetailses;
		this.trexuq377xwwqqhxxxxxvshipmens = trexuq377xwwqqhxxxxxvshipmens;
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
	@JoinColumn(name = "vendor")
	public Jxxxuq300xwwqqhxxxxxvendor getJxxxuq300xwwqqhxxxxxvendor() {
		return this.jxxxuq300xwwqqhxxxxxvendor;
	}

	public void setJxxxuq300xwwqqhxxxxxvendor(
			Jxxxuq300xwwqqhxxxxxvendor jxxxuq300xwwqqhxxxxxvendor) {
		this.jxxxuq300xwwqqhxxxxxvendor = jxxxuq300xwwqqhxxxxxvendor;
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
	@JoinColumn(name = "matcode")
	public Fpxxfq1a5xwwqqhxxxxxitem getFpxxfq1a5xwwqqhxxxxxitem() {
		return this.fpxxfq1a5xwwqqhxxxxxitem;
	}

	public void setFpxxfq1a5xwwqqhxxxxxitem(
			Fpxxfq1a5xwwqqhxxxxxitem fpxxfq1a5xwwqqhxxxxxitem) {
		this.fpxxfq1a5xwwqqhxxxxxitem = fpxxfq1a5xwwqqhxxxxxitem;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "vendqno")
	public Trexuq333xwwqqhxxxxxvenquote getTrexuq333xwwqqhxxxxxvenquote() {
		return this.trexuq333xwwqqhxxxxxvenquote;
	}

	public void setTrexuq333xwwqqhxxxxxvenquote(
			Trexuq333xwwqqhxxxxxvenquote trexuq333xwwqqhxxxxxvenquote) {
		this.trexuq333xwwqqhxxxxxvenquote = trexuq333xwwqqhxxxxxvenquote;
	}

	@Column(name = "purchsno", nullable = false, length = 32)
	@NotNull
	@Size(max = 32)
	public String getA0xxunvobvxxxxxxxxxxpurchsno() {
		return this.a0xxunvobvxxxxxxxxxxpurchsno;
	}

	public void setA0xxunvobvxxxxxxxxxxpurchsno(
			String a0xxunvobvxxxxxxxxxxpurchsno) {
		this.a0xxunvobvxxxxxxxxxxpurchsno = a0xxunvobvxxxxxxxxxxpurchsno;
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

	@Column(name = "jobno", length = 20)
	@Size(max = 20)
	public String getY2xxuxxrlxxxxxxxxxxxjobno() {
		return this.y2xxuxxrlxxxxxxxxxxxjobno;
	}

	public void setY2xxuxxrlxxxxxxxxxxxjobno(String y2xxuxxrlxxxxxxxxxxxjobno) {
		this.y2xxuxxrlxxxxxxxxxxxjobno = y2xxuxxrlxxxxxxxxxxxjobno;
	}

	@Column(name = "rfpord", length = 20)
	@Size(max = 20)
	public String getY3xxuxxxbxxxxxxxxxxxrfpord() {
		return this.y3xxuxxxbxxxxxxxxxxxrfpord;
	}

	public void setY3xxuxxxbxxxxxxxxxxxrfpord(String y3xxuxxxbxxxxxxxxxxxrfpord) {
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

	@Column(name = "rcpono", length = 20)
	@Size(max = 20)
	public String getY4xxuxxrxxxxxxxxxxxxrcpono() {
		return this.y4xxuxxrxxxxxxxxxxxxrcpono;
	}

	public void setY4xxuxxrxxxxxxxxxxxxrcpono(String y4xxuxxrxxxxxxxxxxxxrcpono) {
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

	@Column(name = "vinvoice", length = 20)
	@Size(max = 20)
	public String getY4xxuxxrlxxxxxxxxxxxvinvoice() {
		return this.y4xxuxxrlxxxxxxxxxxxvinvoice;
	}

	public void setY4xxuxxrlxxxxxxxxxxxvinvoice(
			String y4xxuxxrlxxxxxxxxxxxvinvoice) {
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

	@Column(name = "shipcode", length = 20)
	@Size(max = 20)
	public String getY6xxuxxrblxxxxxxxxxxshipcode() {
		return this.y6xxuxxrblxxxxxxxxxxshipcode;
	}

	public void setY6xxuxxrblxxxxxxxxxxshipcode(
			String y6xxuxxrblxxxxxxxxxxshipcode) {
		this.y6xxuxxrblxxxxxxxxxxshipcode = y6xxuxxrblxxxxxxxxxxshipcode;
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

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "trexuq344xwwqqhxxxxxvendorders")
	public Set<Trexuq3a6xwwqqhxxxxxvinvoice> getTrexuq3a6xwwqqhxxxxxvinvoices() {
		return this.trexuq3a6xwwqqhxxxxxvinvoices;
	}

	public void setTrexuq3a6xwwqqhxxxxxvinvoices(
			Set<Trexuq3a6xwwqqhxxxxxvinvoice> trexuq3a6xwwqqhxxxxxvinvoices) {
		this.trexuq3a6xwwqqhxxxxxvinvoices = trexuq3a6xwwqqhxxxxxvinvoices;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "trexuq344xwwqqhxxxxxvendorders")
	public Set<Xoxxuq3d4xwwqqhxxxxxvendodetails> getXoxxuq3d4xwwqqhxxxxxvendodetailses() {
		return this.xoxxuq3d4xwwqqhxxxxxvendodetailses;
	}

	public void setXoxxuq3d4xwwqqhxxxxxvendodetailses(
			Set<Xoxxuq3d4xwwqqhxxxxxvendodetails> xoxxuq3d4xwwqqhxxxxxvendodetailses) {
		this.xoxxuq3d4xwwqqhxxxxxvendodetailses = xoxxuq3d4xwwqqhxxxxxvendodetailses;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "trexuq344xwwqqhxxxxxvendorders")
	public Set<Trexuq377xwwqqhxxxxxvshipmen> getTrexuq377xwwqqhxxxxxvshipmens() {
		return this.trexuq377xwwqqhxxxxxvshipmens;
	}

	public void setTrexuq377xwwqqhxxxxxvshipmens(
			Set<Trexuq377xwwqqhxxxxxvshipmen> trexuq377xwwqqhxxxxxvshipmens) {
		this.trexuq377xwwqqhxxxxxvshipmens = trexuq377xwwqqhxxxxxvshipmens;
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
