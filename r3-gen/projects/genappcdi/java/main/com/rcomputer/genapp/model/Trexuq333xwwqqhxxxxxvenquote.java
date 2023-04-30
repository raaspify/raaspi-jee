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
 * Trexuq333xwwqqhxxxxxvenquote generated by hbm2java
 */
@Entity
@XmlRootElement
@Table(name = "venquote")
public class Trexuq333xwwqqhxxxxxvenquote implements java.io.Serializable {

	private Integer a0xxuobxbxxxxxxxxxxxsid;
	private Jxxxuq300xwwqqhxxxxxvendor jxxxuq300xwwqqhxxxxxvendor;
	private Jxxxbh400xwwqqhxxxxxemployee jxxxbh400xwwqqhxxxxxemployee;
	private Trexuq333xwwqqhxxxxxvenquote trexuq333xwwqqhxxxxxvenquote;
	private Fpxxfq1a5xwwqqhxxxxxitem fpxxfq1a5xwwqqhxxxxxitem;
	private String a0xxunvqbvxxxxxxxxxxpurchsno;
	private Date b1xxcxxxbvxxxxxxxxxxdelvdatet;
	private BigDecimal z1xxztprlxxxxxxxxxxxamounttotal;
	private BigDecimal z2xxzyprlxxxxxxxxxxxamountostndt;
	private BigDecimal z3xxztqrlxxxxxxxxxxxqtytotal;
	private BigDecimal z4xxzyqrlxxxxxxxxxxxqtyostndt;
	private Integer z5xxzzfxhhxxxxxxxxxxstatusfl;
	private String y2xxuxxrlxxxxxxxxxxxcinvoice;
	private String y3xxuxxrlxxxxxxxxxxxjobno;
	private String y4xxuxxrlxxxxxxxxxxxvpono;
	private String y5xxuxxxbxxxxxxxxxxxrfpord;
	private Date z6xxcztxlxxxxxxxxxxxstatusfldt;
	private String y6xxuxxrxxxxxxxxxxxxrcpono;
	private Date b1xxcxxxbxxxxxxxxxxxodatet;
	private String b2xxcxxxbv09xxxxxxxxterms;
	private Boolean b3xxfxxrbv09xxxxxxxxpriority;
	private Integer z7xxzzprhvxxxxxxxxxxprintmstat;
	private Date z8xxczqxlhxxxxxxxxxxprinmtfldt;
	private String b4xxcxxxbv10xxxxxxxxtype;
	private String y6xxuxxrlxxxxxxxxxxxvinvoice;
	private String y7xxuxxrblxxxxxxxxxxattach;
	private String y8xxuxxrblxxxxxxxxxxshipcode;
	private BigDecimal z7xxzbtxavxxxxxxxxxxbaseamountt;
	private BigDecimal z9xxzltxavxxxxxxxxxxdelivchrgt;
	private BigDecimal zaxxzmtxavxxxxxxxxxxmiscchrgt;
	private BigDecimal zbxxzxz1avxxxxxxxxxxtax1amtt;
	private BigDecimal zcxxzxz2avxxxxxxxxxxtax2amtt;
	private BigDecimal zdxxzxz3avxxxxxxxxxxtax3amtt;
	private Date c2xxcxxxbxxxxxxxxxxxstartdatet;
	private String ycxxuznybvxxxxxxxxxxnotes;
	private String zexxutoxlhxxxxxxxxxxowner;
	private String zzxxu2oxxhxxxxxxxxxxowner2;
	private String ydxxuzdrbvxxxxxxxxxxdocmnt;
	private Set<Trexuq344xwwqqhxxxxxvendorders> trexuq344xwwqqhxxxxxvendorderses = new HashSet<Trexuq344xwwqqhxxxxxvendorders>(
			0);
	private Set<Trexuq333xwwqqhxxxxxvenquote> trexuq333xwwqqhxxxxxvenquotes = new HashSet<Trexuq333xwwqqhxxxxxvenquote>(
			0);
	private Set<Xoxxuq3e4xwwqqhxxxxxvendqdetails> xoxxuq3e4xwwqqhxxxxxvendqdetailses = new HashSet<Xoxxuq3e4xwwqqhxxxxxvendqdetails>(
			0);

	public Trexuq333xwwqqhxxxxxvenquote() {
	}

	public Trexuq333xwwqqhxxxxxvenquote(String a0xxunvqbvxxxxxxxxxxpurchsno) {
		this.a0xxunvqbvxxxxxxxxxxpurchsno = a0xxunvqbvxxxxxxxxxxpurchsno;
	}
	public Trexuq333xwwqqhxxxxxvenquote(
			Jxxxuq300xwwqqhxxxxxvendor jxxxuq300xwwqqhxxxxxvendor,
			Jxxxbh400xwwqqhxxxxxemployee jxxxbh400xwwqqhxxxxxemployee,
			Trexuq333xwwqqhxxxxxvenquote trexuq333xwwqqhxxxxxvenquote,
			Fpxxfq1a5xwwqqhxxxxxitem fpxxfq1a5xwwqqhxxxxxitem,
			String a0xxunvqbvxxxxxxxxxxpurchsno,
			Date b1xxcxxxbvxxxxxxxxxxdelvdatet,
			BigDecimal z1xxztprlxxxxxxxxxxxamounttotal,
			BigDecimal z2xxzyprlxxxxxxxxxxxamountostndt,
			BigDecimal z3xxztqrlxxxxxxxxxxxqtytotal,
			BigDecimal z4xxzyqrlxxxxxxxxxxxqtyostndt,
			Integer z5xxzzfxhhxxxxxxxxxxstatusfl,
			String y2xxuxxrlxxxxxxxxxxxcinvoice,
			String y3xxuxxrlxxxxxxxxxxxjobno,
			String y4xxuxxrlxxxxxxxxxxxvpono,
			String y5xxuxxxbxxxxxxxxxxxrfpord,
			Date z6xxcztxlxxxxxxxxxxxstatusfldt,
			String y6xxuxxrxxxxxxxxxxxxrcpono,
			Date b1xxcxxxbxxxxxxxxxxxodatet,
			String b2xxcxxxbv09xxxxxxxxterms,
			Boolean b3xxfxxrbv09xxxxxxxxpriority,
			Integer z7xxzzprhvxxxxxxxxxxprintmstat,
			Date z8xxczqxlhxxxxxxxxxxprinmtfldt,
			String b4xxcxxxbv10xxxxxxxxtype,
			String y6xxuxxrlxxxxxxxxxxxvinvoice,
			String y7xxuxxrblxxxxxxxxxxattach,
			String y8xxuxxrblxxxxxxxxxxshipcode,
			BigDecimal z7xxzbtxavxxxxxxxxxxbaseamountt,
			BigDecimal z9xxzltxavxxxxxxxxxxdelivchrgt,
			BigDecimal zaxxzmtxavxxxxxxxxxxmiscchrgt,
			BigDecimal zbxxzxz1avxxxxxxxxxxtax1amtt,
			BigDecimal zcxxzxz2avxxxxxxxxxxtax2amtt,
			BigDecimal zdxxzxz3avxxxxxxxxxxtax3amtt,
			Date c2xxcxxxbxxxxxxxxxxxstartdatet,
			String ycxxuznybvxxxxxxxxxxnotes,
			String zexxutoxlhxxxxxxxxxxowner,
			String zzxxu2oxxhxxxxxxxxxxowner2,
			String ydxxuzdrbvxxxxxxxxxxdocmnt,
			Set<Trexuq344xwwqqhxxxxxvendorders> trexuq344xwwqqhxxxxxvendorderses,
			Set<Trexuq333xwwqqhxxxxxvenquote> trexuq333xwwqqhxxxxxvenquotes,
			Set<Xoxxuq3e4xwwqqhxxxxxvendqdetails> xoxxuq3e4xwwqqhxxxxxvendqdetailses) {
		this.jxxxuq300xwwqqhxxxxxvendor = jxxxuq300xwwqqhxxxxxvendor;
		this.jxxxbh400xwwqqhxxxxxemployee = jxxxbh400xwwqqhxxxxxemployee;
		this.trexuq333xwwqqhxxxxxvenquote = trexuq333xwwqqhxxxxxvenquote;
		this.fpxxfq1a5xwwqqhxxxxxitem = fpxxfq1a5xwwqqhxxxxxitem;
		this.a0xxunvqbvxxxxxxxxxxpurchsno = a0xxunvqbvxxxxxxxxxxpurchsno;
		this.b1xxcxxxbvxxxxxxxxxxdelvdatet = b1xxcxxxbvxxxxxxxxxxdelvdatet;
		this.z1xxztprlxxxxxxxxxxxamounttotal = z1xxztprlxxxxxxxxxxxamounttotal;
		this.z2xxzyprlxxxxxxxxxxxamountostndt = z2xxzyprlxxxxxxxxxxxamountostndt;
		this.z3xxztqrlxxxxxxxxxxxqtytotal = z3xxztqrlxxxxxxxxxxxqtytotal;
		this.z4xxzyqrlxxxxxxxxxxxqtyostndt = z4xxzyqrlxxxxxxxxxxxqtyostndt;
		this.z5xxzzfxhhxxxxxxxxxxstatusfl = z5xxzzfxhhxxxxxxxxxxstatusfl;
		this.y2xxuxxrlxxxxxxxxxxxcinvoice = y2xxuxxrlxxxxxxxxxxxcinvoice;
		this.y3xxuxxrlxxxxxxxxxxxjobno = y3xxuxxrlxxxxxxxxxxxjobno;
		this.y4xxuxxrlxxxxxxxxxxxvpono = y4xxuxxrlxxxxxxxxxxxvpono;
		this.y5xxuxxxbxxxxxxxxxxxrfpord = y5xxuxxxbxxxxxxxxxxxrfpord;
		this.z6xxcztxlxxxxxxxxxxxstatusfldt = z6xxcztxlxxxxxxxxxxxstatusfldt;
		this.y6xxuxxrxxxxxxxxxxxxrcpono = y6xxuxxrxxxxxxxxxxxxrcpono;
		this.b1xxcxxxbxxxxxxxxxxxodatet = b1xxcxxxbxxxxxxxxxxxodatet;
		this.b2xxcxxxbv09xxxxxxxxterms = b2xxcxxxbv09xxxxxxxxterms;
		this.b3xxfxxrbv09xxxxxxxxpriority = b3xxfxxrbv09xxxxxxxxpriority;
		this.z7xxzzprhvxxxxxxxxxxprintmstat = z7xxzzprhvxxxxxxxxxxprintmstat;
		this.z8xxczqxlhxxxxxxxxxxprinmtfldt = z8xxczqxlhxxxxxxxxxxprinmtfldt;
		this.b4xxcxxxbv10xxxxxxxxtype = b4xxcxxxbv10xxxxxxxxtype;
		this.y6xxuxxrlxxxxxxxxxxxvinvoice = y6xxuxxrlxxxxxxxxxxxvinvoice;
		this.y7xxuxxrblxxxxxxxxxxattach = y7xxuxxrblxxxxxxxxxxattach;
		this.y8xxuxxrblxxxxxxxxxxshipcode = y8xxuxxrblxxxxxxxxxxshipcode;
		this.z7xxzbtxavxxxxxxxxxxbaseamountt = z7xxzbtxavxxxxxxxxxxbaseamountt;
		this.z9xxzltxavxxxxxxxxxxdelivchrgt = z9xxzltxavxxxxxxxxxxdelivchrgt;
		this.zaxxzmtxavxxxxxxxxxxmiscchrgt = zaxxzmtxavxxxxxxxxxxmiscchrgt;
		this.zbxxzxz1avxxxxxxxxxxtax1amtt = zbxxzxz1avxxxxxxxxxxtax1amtt;
		this.zcxxzxz2avxxxxxxxxxxtax2amtt = zcxxzxz2avxxxxxxxxxxtax2amtt;
		this.zdxxzxz3avxxxxxxxxxxtax3amtt = zdxxzxz3avxxxxxxxxxxtax3amtt;
		this.c2xxcxxxbxxxxxxxxxxxstartdatet = c2xxcxxxbxxxxxxxxxxxstartdatet;
		this.ycxxuznybvxxxxxxxxxxnotes = ycxxuznybvxxxxxxxxxxnotes;
		this.zexxutoxlhxxxxxxxxxxowner = zexxutoxlhxxxxxxxxxxowner;
		this.zzxxu2oxxhxxxxxxxxxxowner2 = zzxxu2oxxhxxxxxxxxxxowner2;
		this.ydxxuzdrbvxxxxxxxxxxdocmnt = ydxxuzdrbvxxxxxxxxxxdocmnt;
		this.trexuq344xwwqqhxxxxxvendorderses = trexuq344xwwqqhxxxxxvendorderses;
		this.trexuq333xwwqqhxxxxxvenquotes = trexuq333xwwqqhxxxxxvenquotes;
		this.xoxxuq3e4xwwqqhxxxxxvendqdetailses = xoxxuq3e4xwwqqhxxxxxvendqdetailses;
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
	@JoinColumn(name = "replicate")
	public Trexuq333xwwqqhxxxxxvenquote getTrexuq333xwwqqhxxxxxvenquote() {
		return this.trexuq333xwwqqhxxxxxvenquote;
	}

	public void setTrexuq333xwwqqhxxxxxvenquote(
			Trexuq333xwwqqhxxxxxvenquote trexuq333xwwqqhxxxxxvenquote) {
		this.trexuq333xwwqqhxxxxxvenquote = trexuq333xwwqqhxxxxxvenquote;
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
	public String getA0xxunvqbvxxxxxxxxxxpurchsno() {
		return this.a0xxunvqbvxxxxxxxxxxpurchsno;
	}

	public void setA0xxunvqbvxxxxxxxxxxpurchsno(
			String a0xxunvqbvxxxxxxxxxxpurchsno) {
		this.a0xxunvqbvxxxxxxxxxxpurchsno = a0xxunvqbvxxxxxxxxxxpurchsno;
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

	@Column(name = "cinvoice", length = 20)
	@Size(max = 20)
	public String getY2xxuxxrlxxxxxxxxxxxcinvoice() {
		return this.y2xxuxxrlxxxxxxxxxxxcinvoice;
	}

	public void setY2xxuxxrlxxxxxxxxxxxcinvoice(
			String y2xxuxxrlxxxxxxxxxxxcinvoice) {
		this.y2xxuxxrlxxxxxxxxxxxcinvoice = y2xxuxxrlxxxxxxxxxxxcinvoice;
	}

	@Column(name = "jobno", length = 20)
	@Size(max = 20)
	public String getY3xxuxxrlxxxxxxxxxxxjobno() {
		return this.y3xxuxxrlxxxxxxxxxxxjobno;
	}

	public void setY3xxuxxrlxxxxxxxxxxxjobno(String y3xxuxxrlxxxxxxxxxxxjobno) {
		this.y3xxuxxrlxxxxxxxxxxxjobno = y3xxuxxrlxxxxxxxxxxxjobno;
	}

	@Column(name = "vpono", length = 20)
	@Size(max = 20)
	public String getY4xxuxxrlxxxxxxxxxxxvpono() {
		return this.y4xxuxxrlxxxxxxxxxxxvpono;
	}

	public void setY4xxuxxrlxxxxxxxxxxxvpono(String y4xxuxxrlxxxxxxxxxxxvpono) {
		this.y4xxuxxrlxxxxxxxxxxxvpono = y4xxuxxrlxxxxxxxxxxxvpono;
	}

	@Column(name = "rfpord", length = 20)
	@Size(max = 20)
	public String getY5xxuxxxbxxxxxxxxxxxrfpord() {
		return this.y5xxuxxxbxxxxxxxxxxxrfpord;
	}

	public void setY5xxuxxxbxxxxxxxxxxxrfpord(String y5xxuxxxbxxxxxxxxxxxrfpord) {
		this.y5xxuxxxbxxxxxxxxxxxrfpord = y5xxuxxxbxxxxxxxxxxxrfpord;
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
	public String getY6xxuxxrxxxxxxxxxxxxrcpono() {
		return this.y6xxuxxrxxxxxxxxxxxxrcpono;
	}

	public void setY6xxuxxrxxxxxxxxxxxxrcpono(String y6xxuxxrxxxxxxxxxxxxrcpono) {
		this.y6xxuxxrxxxxxxxxxxxxrcpono = y6xxuxxrxxxxxxxxxxxxrcpono;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "odatet", length = 29)
	public Date getB1xxcxxxbxxxxxxxxxxxodatet() {
		return this.b1xxcxxxbxxxxxxxxxxxodatet;
	}

	public void setB1xxcxxxbxxxxxxxxxxxodatet(Date b1xxcxxxbxxxxxxxxxxxodatet) {
		this.b1xxcxxxbxxxxxxxxxxxodatet = b1xxcxxxbxxxxxxxxxxxodatet;
	}

	@Column(name = "terms", length = 20)
	@Size(max = 20)
	public String getB2xxcxxxbv09xxxxxxxxterms() {
		return this.b2xxcxxxbv09xxxxxxxxterms;
	}

	public void setB2xxcxxxbv09xxxxxxxxterms(String b2xxcxxxbv09xxxxxxxxterms) {
		this.b2xxcxxxbv09xxxxxxxxterms = b2xxcxxxbv09xxxxxxxxterms;
	}

	@Column(name = "priority")
	public Boolean getB3xxfxxrbv09xxxxxxxxpriority() {
		return this.b3xxfxxrbv09xxxxxxxxpriority;
	}

	public void setB3xxfxxrbv09xxxxxxxxpriority(
			Boolean b3xxfxxrbv09xxxxxxxxpriority) {
		this.b3xxfxxrbv09xxxxxxxxpriority = b3xxfxxrbv09xxxxxxxxpriority;
	}

	@Column(name = "printmstat")
	public Integer getZ7xxzzprhvxxxxxxxxxxprintmstat() {
		return this.z7xxzzprhvxxxxxxxxxxprintmstat;
	}

	public void setZ7xxzzprhvxxxxxxxxxxprintmstat(
			Integer z7xxzzprhvxxxxxxxxxxprintmstat) {
		this.z7xxzzprhvxxxxxxxxxxprintmstat = z7xxzzprhvxxxxxxxxxxprintmstat;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "prinmtfldt", length = 29)
	public Date getZ8xxczqxlhxxxxxxxxxxprinmtfldt() {
		return this.z8xxczqxlhxxxxxxxxxxprinmtfldt;
	}

	public void setZ8xxczqxlhxxxxxxxxxxprinmtfldt(
			Date z8xxczqxlhxxxxxxxxxxprinmtfldt) {
		this.z8xxczqxlhxxxxxxxxxxprinmtfldt = z8xxczqxlhxxxxxxxxxxprinmtfldt;
	}

	@Column(name = "type", length = 25)
	@Size(max = 25)
	public String getB4xxcxxxbv10xxxxxxxxtype() {
		return this.b4xxcxxxbv10xxxxxxxxtype;
	}

	public void setB4xxcxxxbv10xxxxxxxxtype(String b4xxcxxxbv10xxxxxxxxtype) {
		this.b4xxcxxxbv10xxxxxxxxtype = b4xxcxxxbv10xxxxxxxxtype;
	}

	@Column(name = "vinvoice", length = 20)
	@Size(max = 20)
	public String getY6xxuxxrlxxxxxxxxxxxvinvoice() {
		return this.y6xxuxxrlxxxxxxxxxxxvinvoice;
	}

	public void setY6xxuxxrlxxxxxxxxxxxvinvoice(
			String y6xxuxxrlxxxxxxxxxxxvinvoice) {
		this.y6xxuxxrlxxxxxxxxxxxvinvoice = y6xxuxxrlxxxxxxxxxxxvinvoice;
	}

	@Column(name = "attach", length = 20)
	@Size(max = 20)
	public String getY7xxuxxrblxxxxxxxxxxattach() {
		return this.y7xxuxxrblxxxxxxxxxxattach;
	}

	public void setY7xxuxxrblxxxxxxxxxxattach(String y7xxuxxrblxxxxxxxxxxattach) {
		this.y7xxuxxrblxxxxxxxxxxattach = y7xxuxxrblxxxxxxxxxxattach;
	}

	@Column(name = "shipcode", length = 20)
	@Size(max = 20)
	public String getY8xxuxxrblxxxxxxxxxxshipcode() {
		return this.y8xxuxxrblxxxxxxxxxxshipcode;
	}

	public void setY8xxuxxrblxxxxxxxxxxshipcode(
			String y8xxuxxrblxxxxxxxxxxshipcode) {
		this.y8xxuxxrblxxxxxxxxxxshipcode = y8xxuxxrblxxxxxxxxxxshipcode;
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
	public BigDecimal getZ9xxzltxavxxxxxxxxxxdelivchrgt() {
		return this.z9xxzltxavxxxxxxxxxxdelivchrgt;
	}

	public void setZ9xxzltxavxxxxxxxxxxdelivchrgt(
			BigDecimal z9xxzltxavxxxxxxxxxxdelivchrgt) {
		this.z9xxzltxavxxxxxxxxxxdelivchrgt = z9xxzltxavxxxxxxxxxxdelivchrgt;
	}

	@Column(name = "miscchrgt", precision = 14)
	public BigDecimal getZaxxzmtxavxxxxxxxxxxmiscchrgt() {
		return this.zaxxzmtxavxxxxxxxxxxmiscchrgt;
	}

	public void setZaxxzmtxavxxxxxxxxxxmiscchrgt(
			BigDecimal zaxxzmtxavxxxxxxxxxxmiscchrgt) {
		this.zaxxzmtxavxxxxxxxxxxmiscchrgt = zaxxzmtxavxxxxxxxxxxmiscchrgt;
	}

	@Column(name = "tax1amtt", precision = 14)
	public BigDecimal getZbxxzxz1avxxxxxxxxxxtax1amtt() {
		return this.zbxxzxz1avxxxxxxxxxxtax1amtt;
	}

	public void setZbxxzxz1avxxxxxxxxxxtax1amtt(
			BigDecimal zbxxzxz1avxxxxxxxxxxtax1amtt) {
		this.zbxxzxz1avxxxxxxxxxxtax1amtt = zbxxzxz1avxxxxxxxxxxtax1amtt;
	}

	@Column(name = "tax2amtt", precision = 14)
	public BigDecimal getZcxxzxz2avxxxxxxxxxxtax2amtt() {
		return this.zcxxzxz2avxxxxxxxxxxtax2amtt;
	}

	public void setZcxxzxz2avxxxxxxxxxxtax2amtt(
			BigDecimal zcxxzxz2avxxxxxxxxxxtax2amtt) {
		this.zcxxzxz2avxxxxxxxxxxtax2amtt = zcxxzxz2avxxxxxxxxxxtax2amtt;
	}

	@Column(name = "tax3amtt", precision = 14)
	public BigDecimal getZdxxzxz3avxxxxxxxxxxtax3amtt() {
		return this.zdxxzxz3avxxxxxxxxxxtax3amtt;
	}

	public void setZdxxzxz3avxxxxxxxxxxtax3amtt(
			BigDecimal zdxxzxz3avxxxxxxxxxxtax3amtt) {
		this.zdxxzxz3avxxxxxxxxxxtax3amtt = zdxxzxz3avxxxxxxxxxxtax3amtt;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "startdatet", length = 29)
	public Date getC2xxcxxxbxxxxxxxxxxxstartdatet() {
		return this.c2xxcxxxbxxxxxxxxxxxstartdatet;
	}

	public void setC2xxcxxxbxxxxxxxxxxxstartdatet(
			Date c2xxcxxxbxxxxxxxxxxxstartdatet) {
		this.c2xxcxxxbxxxxxxxxxxxstartdatet = c2xxcxxxbxxxxxxxxxxxstartdatet;
	}

	@Column(name = "notes", length = 60)
	@Size(max = 60)
	public String getYcxxuznybvxxxxxxxxxxnotes() {
		return this.ycxxuznybvxxxxxxxxxxnotes;
	}

	public void setYcxxuznybvxxxxxxxxxxnotes(String ycxxuznybvxxxxxxxxxxnotes) {
		this.ycxxuznybvxxxxxxxxxxnotes = ycxxuznybvxxxxxxxxxxnotes;
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
	public String getYdxxuzdrbvxxxxxxxxxxdocmnt() {
		return this.ydxxuzdrbvxxxxxxxxxxdocmnt;
	}

	public void setYdxxuzdrbvxxxxxxxxxxdocmnt(String ydxxuzdrbvxxxxxxxxxxdocmnt) {
		this.ydxxuzdrbvxxxxxxxxxxdocmnt = ydxxuzdrbvxxxxxxxxxxdocmnt;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "trexuq333xwwqqhxxxxxvenquote")
	public Set<Trexuq344xwwqqhxxxxxvendorders> getTrexuq344xwwqqhxxxxxvendorderses() {
		return this.trexuq344xwwqqhxxxxxvendorderses;
	}

	public void setTrexuq344xwwqqhxxxxxvendorderses(
			Set<Trexuq344xwwqqhxxxxxvendorders> trexuq344xwwqqhxxxxxvendorderses) {
		this.trexuq344xwwqqhxxxxxvendorderses = trexuq344xwwqqhxxxxxvendorderses;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "trexuq333xwwqqhxxxxxvenquote")
	public Set<Trexuq333xwwqqhxxxxxvenquote> getTrexuq333xwwqqhxxxxxvenquotes() {
		return this.trexuq333xwwqqhxxxxxvenquotes;
	}

	public void setTrexuq333xwwqqhxxxxxvenquotes(
			Set<Trexuq333xwwqqhxxxxxvenquote> trexuq333xwwqqhxxxxxvenquotes) {
		this.trexuq333xwwqqhxxxxxvenquotes = trexuq333xwwqqhxxxxxvenquotes;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "trexuq333xwwqqhxxxxxvenquote")
	public Set<Xoxxuq3e4xwwqqhxxxxxvendqdetails> getXoxxuq3e4xwwqqhxxxxxvendqdetailses() {
		return this.xoxxuq3e4xwwqqhxxxxxvendqdetailses;
	}

	public void setXoxxuq3e4xwwqqhxxxxxvendqdetailses(
			Set<Xoxxuq3e4xwwqqhxxxxxvendqdetails> xoxxuq3e4xwwqqhxxxxxvendqdetailses) {
		this.xoxxuq3e4xwwqqhxxxxxvendqdetailses = xoxxuq3e4xwwqqhxxxxxvendqdetailses;
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
