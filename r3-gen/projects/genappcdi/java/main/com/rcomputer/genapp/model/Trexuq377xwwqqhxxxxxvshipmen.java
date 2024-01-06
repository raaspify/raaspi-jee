package com.rcomputer.genapp.model;
// Generated 1-Jan-2024 8:59:20 PM by Hibernate Tools 4.0.0

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
 * Trexuq377xwwqqhxxxxxvshipmen generated by hbm2java
 */
@Entity
@XmlRootElement
@Table(name = "vshipmen")
public class Trexuq377xwwqqhxxxxxvshipmen implements java.io.Serializable {

	private Integer a0xxuobxbxxxxxxxxxxxsid;
	private Jxxxuq300xwwqqhxxxxxvendor jxxxuq300xwwqqhxxxxxvendor;
	private Fxxxuq111xwwqqhxxxxxaddress fxxxuq111xwwqqhxxxxxaddressByBilltocode;
	private Jxxxuq201xwwqqhxxxxxcustomer jxxxuq201xwwqqhxxxxxcustomer;
	private Fpxxfq1a5xwwqqhxxxxxitem fpxxfq1a5xwwqqhxxxxxitem;
	private Trexuq344xwwqqhxxxxxvendorders trexuq344xwwqqhxxxxxvendorders;
	private Fxxxuq111xwwqqhxxxxxaddress fxxxuq111xwwqqhxxxxxaddressByShiptocode;
	private String a0xxuksvbvxxxxxxxxxxshipcode;
	private Integer b1xxuxxrbvxxxxxxxxxxshipper;
	private Integer y2xxuxxrbvxxxxxxxxxxcpono;
	private Integer b3xxuxxrbvxxxxxxxxxxinvoice;
	private BigDecimal b5xxztprlxxxxxxxxxxxamounttotal;
	private BigDecimal b6xxzyprlxxxxxxxxxxxamountostndt;
	private BigDecimal b7xxztqrlxxxxxxxxxxxqtytotal;
	private BigDecimal b8xxzyqrlxxxxxxxxxxxqtyostndt;
	private String c1xxuxxrbvxxxxxxxxxxcarrier;
	private String c2xxuxxrbv51xxxxxxxxtype;
	private Date c3xxcxxrlxxxxxxxxxxxshipdatet;
	private Date z3xxcxxrlxxxxxxxxxxxshipdateta;
	private String y3xxuxxrbvxxxxxxxxxxtareno;
	private String y4xxuxxrbvxxxxxxxxxxpackno;
	private Boolean d4xxugbrbvxxxxxxxxxxbilltosameasshipto;
	private String y5xxuxznbvxxxxxxxxxxnotes;
	private Integer z4xxzzfxhhxxxxxxxxxxstatusfl;
	private Date z5xxcztxlxxxxxxxxxxxstatusfldt;
	private String z6xxuxxrbvxxxxxxxxxxserialno;
	private Integer z7xxzzprhvxxxxxxxxxxprintmstat;
	private Date z8xxczqxlhxxxxxxxxxxprinmtfldt;
	private String z9xxutoxlhxxxxxxxxxxowner;
	private String zzxxu2oxxhxxxxxxxxxxowner2;
	private Set<Xoxxuq399xvwwqqhxxxxvshipmendetails> xoxxuq399xvwwqqhxxxxvshipmendetailses = new HashSet<Xoxxuq399xvwwqqhxxxxvshipmendetails>(
			0);
	private Set<Xoxxuq399xvwwqqhxxxxvshipmendetails> xoxxuq399xvwwqqhxxxxvshipmendetailses_1 = new HashSet<Xoxxuq399xvwwqqhxxxxvshipmendetails>(
			0);
	private Set<Trexuq3a6xwwqqhxxxxxvinvoice> trexuq3a6xwwqqhxxxxxvinvoices = new HashSet<Trexuq3a6xwwqqhxxxxxvinvoice>(
			0);
	private Set<Trexuq3a6xwwqqhxxxxxvinvoice> trexuq3a6xwwqqhxxxxxvinvoices_1 = new HashSet<Trexuq3a6xwwqqhxxxxxvinvoice>(
			0);
	private Set<Trexuq444xwwqqhxxxxxemplorders> trexuq444xwwqqhxxxxxemplorderses = new HashSet<Trexuq444xwwqqhxxxxxemplorders>(
			0);
	private Set<Trexuq444xwwqqhxxxxxemplorders> trexuq444xwwqqhxxxxxemplorderses_1 = new HashSet<Trexuq444xwwqqhxxxxxemplorders>(
			0);
	private Set<Trexuq3a6xwwqqhxxxxxvinvoice> trexuq3a6xwwqqhxxxxxvinvoices_2 = new HashSet<Trexuq3a6xwwqqhxxxxxvinvoice>(
			0);

	public Trexuq377xwwqqhxxxxxvshipmen() {
	}

	public Trexuq377xwwqqhxxxxxvshipmen(String a0xxuksvbvxxxxxxxxxxshipcode) {
		this.a0xxuksvbvxxxxxxxxxxshipcode = a0xxuksvbvxxxxxxxxxxshipcode;
	}
	public Trexuq377xwwqqhxxxxxvshipmen(
			Jxxxuq300xwwqqhxxxxxvendor jxxxuq300xwwqqhxxxxxvendor,
			Fxxxuq111xwwqqhxxxxxaddress fxxxuq111xwwqqhxxxxxaddressByBilltocode,
			Jxxxuq201xwwqqhxxxxxcustomer jxxxuq201xwwqqhxxxxxcustomer,
			Fpxxfq1a5xwwqqhxxxxxitem fpxxfq1a5xwwqqhxxxxxitem,
			Trexuq344xwwqqhxxxxxvendorders trexuq344xwwqqhxxxxxvendorders,
			Fxxxuq111xwwqqhxxxxxaddress fxxxuq111xwwqqhxxxxxaddressByShiptocode,
			String a0xxuksvbvxxxxxxxxxxshipcode,
			Integer b1xxuxxrbvxxxxxxxxxxshipper,
			Integer y2xxuxxrbvxxxxxxxxxxcpono,
			Integer b3xxuxxrbvxxxxxxxxxxinvoice,
			BigDecimal b5xxztprlxxxxxxxxxxxamounttotal,
			BigDecimal b6xxzyprlxxxxxxxxxxxamountostndt,
			BigDecimal b7xxztqrlxxxxxxxxxxxqtytotal,
			BigDecimal b8xxzyqrlxxxxxxxxxxxqtyostndt,
			String c1xxuxxrbvxxxxxxxxxxcarrier,
			String c2xxuxxrbv51xxxxxxxxtype,
			Date c3xxcxxrlxxxxxxxxxxxshipdatet,
			Date z3xxcxxrlxxxxxxxxxxxshipdateta,
			String y3xxuxxrbvxxxxxxxxxxtareno,
			String y4xxuxxrbvxxxxxxxxxxpackno,
			Boolean d4xxugbrbvxxxxxxxxxxbilltosameasshipto,
			String y5xxuxznbvxxxxxxxxxxnotes,
			Integer z4xxzzfxhhxxxxxxxxxxstatusfl,
			Date z5xxcztxlxxxxxxxxxxxstatusfldt,
			String z6xxuxxrbvxxxxxxxxxxserialno,
			Integer z7xxzzprhvxxxxxxxxxxprintmstat,
			Date z8xxczqxlhxxxxxxxxxxprinmtfldt,
			String z9xxutoxlhxxxxxxxxxxowner,
			String zzxxu2oxxhxxxxxxxxxxowner2,
			Set<Xoxxuq399xvwwqqhxxxxvshipmendetails> xoxxuq399xvwwqqhxxxxvshipmendetailses,
			Set<Xoxxuq399xvwwqqhxxxxvshipmendetails> xoxxuq399xvwwqqhxxxxvshipmendetailses_1,
			Set<Trexuq3a6xwwqqhxxxxxvinvoice> trexuq3a6xwwqqhxxxxxvinvoices,
			Set<Trexuq3a6xwwqqhxxxxxvinvoice> trexuq3a6xwwqqhxxxxxvinvoices_1,
			Set<Trexuq444xwwqqhxxxxxemplorders> trexuq444xwwqqhxxxxxemplorderses,
			Set<Trexuq444xwwqqhxxxxxemplorders> trexuq444xwwqqhxxxxxemplorderses_1,
			Set<Trexuq3a6xwwqqhxxxxxvinvoice> trexuq3a6xwwqqhxxxxxvinvoices_2) {
		this.jxxxuq300xwwqqhxxxxxvendor = jxxxuq300xwwqqhxxxxxvendor;
		this.fxxxuq111xwwqqhxxxxxaddressByBilltocode = fxxxuq111xwwqqhxxxxxaddressByBilltocode;
		this.jxxxuq201xwwqqhxxxxxcustomer = jxxxuq201xwwqqhxxxxxcustomer;
		this.fpxxfq1a5xwwqqhxxxxxitem = fpxxfq1a5xwwqqhxxxxxitem;
		this.trexuq344xwwqqhxxxxxvendorders = trexuq344xwwqqhxxxxxvendorders;
		this.fxxxuq111xwwqqhxxxxxaddressByShiptocode = fxxxuq111xwwqqhxxxxxaddressByShiptocode;
		this.a0xxuksvbvxxxxxxxxxxshipcode = a0xxuksvbvxxxxxxxxxxshipcode;
		this.b1xxuxxrbvxxxxxxxxxxshipper = b1xxuxxrbvxxxxxxxxxxshipper;
		this.y2xxuxxrbvxxxxxxxxxxcpono = y2xxuxxrbvxxxxxxxxxxcpono;
		this.b3xxuxxrbvxxxxxxxxxxinvoice = b3xxuxxrbvxxxxxxxxxxinvoice;
		this.b5xxztprlxxxxxxxxxxxamounttotal = b5xxztprlxxxxxxxxxxxamounttotal;
		this.b6xxzyprlxxxxxxxxxxxamountostndt = b6xxzyprlxxxxxxxxxxxamountostndt;
		this.b7xxztqrlxxxxxxxxxxxqtytotal = b7xxztqrlxxxxxxxxxxxqtytotal;
		this.b8xxzyqrlxxxxxxxxxxxqtyostndt = b8xxzyqrlxxxxxxxxxxxqtyostndt;
		this.c1xxuxxrbvxxxxxxxxxxcarrier = c1xxuxxrbvxxxxxxxxxxcarrier;
		this.c2xxuxxrbv51xxxxxxxxtype = c2xxuxxrbv51xxxxxxxxtype;
		this.c3xxcxxrlxxxxxxxxxxxshipdatet = c3xxcxxrlxxxxxxxxxxxshipdatet;
		this.z3xxcxxrlxxxxxxxxxxxshipdateta = z3xxcxxrlxxxxxxxxxxxshipdateta;
		this.y3xxuxxrbvxxxxxxxxxxtareno = y3xxuxxrbvxxxxxxxxxxtareno;
		this.y4xxuxxrbvxxxxxxxxxxpackno = y4xxuxxrbvxxxxxxxxxxpackno;
		this.d4xxugbrbvxxxxxxxxxxbilltosameasshipto = d4xxugbrbvxxxxxxxxxxbilltosameasshipto;
		this.y5xxuxznbvxxxxxxxxxxnotes = y5xxuxznbvxxxxxxxxxxnotes;
		this.z4xxzzfxhhxxxxxxxxxxstatusfl = z4xxzzfxhhxxxxxxxxxxstatusfl;
		this.z5xxcztxlxxxxxxxxxxxstatusfldt = z5xxcztxlxxxxxxxxxxxstatusfldt;
		this.z6xxuxxrbvxxxxxxxxxxserialno = z6xxuxxrbvxxxxxxxxxxserialno;
		this.z7xxzzprhvxxxxxxxxxxprintmstat = z7xxzzprhvxxxxxxxxxxprintmstat;
		this.z8xxczqxlhxxxxxxxxxxprinmtfldt = z8xxczqxlhxxxxxxxxxxprinmtfldt;
		this.z9xxutoxlhxxxxxxxxxxowner = z9xxutoxlhxxxxxxxxxxowner;
		this.zzxxu2oxxhxxxxxxxxxxowner2 = zzxxu2oxxhxxxxxxxxxxowner2;
		this.xoxxuq399xvwwqqhxxxxvshipmendetailses = xoxxuq399xvwwqqhxxxxvshipmendetailses;
		this.xoxxuq399xvwwqqhxxxxvshipmendetailses_1 = xoxxuq399xvwwqqhxxxxvshipmendetailses_1;
		this.trexuq3a6xwwqqhxxxxxvinvoices = trexuq3a6xwwqqhxxxxxvinvoices;
		this.trexuq3a6xwwqqhxxxxxvinvoices_1 = trexuq3a6xwwqqhxxxxxvinvoices_1;
		this.trexuq444xwwqqhxxxxxemplorderses = trexuq444xwwqqhxxxxxemplorderses;
		this.trexuq444xwwqqhxxxxxemplorderses_1 = trexuq444xwwqqhxxxxxemplorderses_1;
		this.trexuq3a6xwwqqhxxxxxvinvoices_2 = trexuq3a6xwwqqhxxxxxvinvoices_2;
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
	@JoinColumn(name = "billtocode")
	public Fxxxuq111xwwqqhxxxxxaddress getFxxxuq111xwwqqhxxxxxaddressByBilltocode() {
		return this.fxxxuq111xwwqqhxxxxxaddressByBilltocode;
	}

	public void setFxxxuq111xwwqqhxxxxxaddressByBilltocode(
			Fxxxuq111xwwqqhxxxxxaddress fxxxuq111xwwqqhxxxxxaddressByBilltocode) {
		this.fxxxuq111xwwqqhxxxxxaddressByBilltocode = fxxxuq111xwwqqhxxxxxaddressByBilltocode;
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
	public Trexuq344xwwqqhxxxxxvendorders getTrexuq344xwwqqhxxxxxvendorders() {
		return this.trexuq344xwwqqhxxxxxvendorders;
	}

	public void setTrexuq344xwwqqhxxxxxvendorders(
			Trexuq344xwwqqhxxxxxvendorders trexuq344xwwqqhxxxxxvendorders) {
		this.trexuq344xwwqqhxxxxxvendorders = trexuq344xwwqqhxxxxxvendorders;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "shiptocode")
	public Fxxxuq111xwwqqhxxxxxaddress getFxxxuq111xwwqqhxxxxxaddressByShiptocode() {
		return this.fxxxuq111xwwqqhxxxxxaddressByShiptocode;
	}

	public void setFxxxuq111xwwqqhxxxxxaddressByShiptocode(
			Fxxxuq111xwwqqhxxxxxaddress fxxxuq111xwwqqhxxxxxaddressByShiptocode) {
		this.fxxxuq111xwwqqhxxxxxaddressByShiptocode = fxxxuq111xwwqqhxxxxxaddressByShiptocode;
	}

	@Column(name = "shipcode", nullable = false, length = 32)
	@NotNull
	@Size(max = 32)
	public String getA0xxuksvbvxxxxxxxxxxshipcode() {
		return this.a0xxuksvbvxxxxxxxxxxshipcode;
	}

	public void setA0xxuksvbvxxxxxxxxxxshipcode(
			String a0xxuksvbvxxxxxxxxxxshipcode) {
		this.a0xxuksvbvxxxxxxxxxxshipcode = a0xxuksvbvxxxxxxxxxxshipcode;
	}

	@Column(name = "shipper")
	public Integer getB1xxuxxrbvxxxxxxxxxxshipper() {
		return this.b1xxuxxrbvxxxxxxxxxxshipper;
	}

	public void setB1xxuxxrbvxxxxxxxxxxshipper(
			Integer b1xxuxxrbvxxxxxxxxxxshipper) {
		this.b1xxuxxrbvxxxxxxxxxxshipper = b1xxuxxrbvxxxxxxxxxxshipper;
	}

	@Column(name = "cpono")
	public Integer getY2xxuxxrbvxxxxxxxxxxcpono() {
		return this.y2xxuxxrbvxxxxxxxxxxcpono;
	}

	public void setY2xxuxxrbvxxxxxxxxxxcpono(Integer y2xxuxxrbvxxxxxxxxxxcpono) {
		this.y2xxuxxrbvxxxxxxxxxxcpono = y2xxuxxrbvxxxxxxxxxxcpono;
	}

	@Column(name = "invoice")
	public Integer getB3xxuxxrbvxxxxxxxxxxinvoice() {
		return this.b3xxuxxrbvxxxxxxxxxxinvoice;
	}

	public void setB3xxuxxrbvxxxxxxxxxxinvoice(
			Integer b3xxuxxrbvxxxxxxxxxxinvoice) {
		this.b3xxuxxrbvxxxxxxxxxxinvoice = b3xxuxxrbvxxxxxxxxxxinvoice;
	}

	@Column(name = "amounttotal", precision = 14)
	public BigDecimal getB5xxztprlxxxxxxxxxxxamounttotal() {
		return this.b5xxztprlxxxxxxxxxxxamounttotal;
	}

	public void setB5xxztprlxxxxxxxxxxxamounttotal(
			BigDecimal b5xxztprlxxxxxxxxxxxamounttotal) {
		this.b5xxztprlxxxxxxxxxxxamounttotal = b5xxztprlxxxxxxxxxxxamounttotal;
	}

	@Column(name = "amountostndt", precision = 14)
	public BigDecimal getB6xxzyprlxxxxxxxxxxxamountostndt() {
		return this.b6xxzyprlxxxxxxxxxxxamountostndt;
	}

	public void setB6xxzyprlxxxxxxxxxxxamountostndt(
			BigDecimal b6xxzyprlxxxxxxxxxxxamountostndt) {
		this.b6xxzyprlxxxxxxxxxxxamountostndt = b6xxzyprlxxxxxxxxxxxamountostndt;
	}

	@Column(name = "qtytotal", precision = 14)
	public BigDecimal getB7xxztqrlxxxxxxxxxxxqtytotal() {
		return this.b7xxztqrlxxxxxxxxxxxqtytotal;
	}

	public void setB7xxztqrlxxxxxxxxxxxqtytotal(
			BigDecimal b7xxztqrlxxxxxxxxxxxqtytotal) {
		this.b7xxztqrlxxxxxxxxxxxqtytotal = b7xxztqrlxxxxxxxxxxxqtytotal;
	}

	@Column(name = "qtyostndt", precision = 14)
	public BigDecimal getB8xxzyqrlxxxxxxxxxxxqtyostndt() {
		return this.b8xxzyqrlxxxxxxxxxxxqtyostndt;
	}

	public void setB8xxzyqrlxxxxxxxxxxxqtyostndt(
			BigDecimal b8xxzyqrlxxxxxxxxxxxqtyostndt) {
		this.b8xxzyqrlxxxxxxxxxxxqtyostndt = b8xxzyqrlxxxxxxxxxxxqtyostndt;
	}

	@Column(name = "carrier", length = 20)
	@Size(max = 20)
	public String getC1xxuxxrbvxxxxxxxxxxcarrier() {
		return this.c1xxuxxrbvxxxxxxxxxxcarrier;
	}

	public void setC1xxuxxrbvxxxxxxxxxxcarrier(
			String c1xxuxxrbvxxxxxxxxxxcarrier) {
		this.c1xxuxxrbvxxxxxxxxxxcarrier = c1xxuxxrbvxxxxxxxxxxcarrier;
	}

	@Column(name = "type", length = 12)
	@Size(max = 12)
	public String getC2xxuxxrbv51xxxxxxxxtype() {
		return this.c2xxuxxrbv51xxxxxxxxtype;
	}

	public void setC2xxuxxrbv51xxxxxxxxtype(String c2xxuxxrbv51xxxxxxxxtype) {
		this.c2xxuxxrbv51xxxxxxxxtype = c2xxuxxrbv51xxxxxxxxtype;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "shipdatet", length = 29)
	public Date getC3xxcxxrlxxxxxxxxxxxshipdatet() {
		return this.c3xxcxxrlxxxxxxxxxxxshipdatet;
	}

	public void setC3xxcxxrlxxxxxxxxxxxshipdatet(
			Date c3xxcxxrlxxxxxxxxxxxshipdatet) {
		this.c3xxcxxrlxxxxxxxxxxxshipdatet = c3xxcxxrlxxxxxxxxxxxshipdatet;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "shipdateta", length = 29)
	public Date getZ3xxcxxrlxxxxxxxxxxxshipdateta() {
		return this.z3xxcxxrlxxxxxxxxxxxshipdateta;
	}

	public void setZ3xxcxxrlxxxxxxxxxxxshipdateta(
			Date z3xxcxxrlxxxxxxxxxxxshipdateta) {
		this.z3xxcxxrlxxxxxxxxxxxshipdateta = z3xxcxxrlxxxxxxxxxxxshipdateta;
	}

	@Column(name = "tareno", length = 20)
	@Size(max = 20)
	public String getY3xxuxxrbvxxxxxxxxxxtareno() {
		return this.y3xxuxxrbvxxxxxxxxxxtareno;
	}

	public void setY3xxuxxrbvxxxxxxxxxxtareno(String y3xxuxxrbvxxxxxxxxxxtareno) {
		this.y3xxuxxrbvxxxxxxxxxxtareno = y3xxuxxrbvxxxxxxxxxxtareno;
	}

	@Column(name = "packno", length = 20)
	@Size(max = 20)
	public String getY4xxuxxrbvxxxxxxxxxxpackno() {
		return this.y4xxuxxrbvxxxxxxxxxxpackno;
	}

	public void setY4xxuxxrbvxxxxxxxxxxpackno(String y4xxuxxrbvxxxxxxxxxxpackno) {
		this.y4xxuxxrbvxxxxxxxxxxpackno = y4xxuxxrbvxxxxxxxxxxpackno;
	}

	@Column(name = "billtosameasshipto")
	public Boolean getD4xxugbrbvxxxxxxxxxxbilltosameasshipto() {
		return this.d4xxugbrbvxxxxxxxxxxbilltosameasshipto;
	}

	public void setD4xxugbrbvxxxxxxxxxxbilltosameasshipto(
			Boolean d4xxugbrbvxxxxxxxxxxbilltosameasshipto) {
		this.d4xxugbrbvxxxxxxxxxxbilltosameasshipto = d4xxugbrbvxxxxxxxxxxbilltosameasshipto;
	}

	@Column(name = "notes", length = 60)
	@Size(max = 60)
	public String getY5xxuxznbvxxxxxxxxxxnotes() {
		return this.y5xxuxznbvxxxxxxxxxxnotes;
	}

	public void setY5xxuxznbvxxxxxxxxxxnotes(String y5xxuxznbvxxxxxxxxxxnotes) {
		this.y5xxuxznbvxxxxxxxxxxnotes = y5xxuxznbvxxxxxxxxxxnotes;
	}

	@Column(name = "statusfl")
	public Integer getZ4xxzzfxhhxxxxxxxxxxstatusfl() {
		return this.z4xxzzfxhhxxxxxxxxxxstatusfl;
	}

	public void setZ4xxzzfxhhxxxxxxxxxxstatusfl(
			Integer z4xxzzfxhhxxxxxxxxxxstatusfl) {
		this.z4xxzzfxhhxxxxxxxxxxstatusfl = z4xxzzfxhhxxxxxxxxxxstatusfl;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "statusfldt", length = 29)
	public Date getZ5xxcztxlxxxxxxxxxxxstatusfldt() {
		return this.z5xxcztxlxxxxxxxxxxxstatusfldt;
	}

	public void setZ5xxcztxlxxxxxxxxxxxstatusfldt(
			Date z5xxcztxlxxxxxxxxxxxstatusfldt) {
		this.z5xxcztxlxxxxxxxxxxxstatusfldt = z5xxcztxlxxxxxxxxxxxstatusfldt;
	}

	@Column(name = "serialno", length = 25)
	@Size(max = 25)
	public String getZ6xxuxxrbvxxxxxxxxxxserialno() {
		return this.z6xxuxxrbvxxxxxxxxxxserialno;
	}

	public void setZ6xxuxxrbvxxxxxxxxxxserialno(
			String z6xxuxxrbvxxxxxxxxxxserialno) {
		this.z6xxuxxrbvxxxxxxxxxxserialno = z6xxuxxrbvxxxxxxxxxxserialno;
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

	@Column(name = "owner", length = 40)
	@Size(max = 40)
	public String getZ9xxutoxlhxxxxxxxxxxowner() {
		return this.z9xxutoxlhxxxxxxxxxxowner;
	}

	public void setZ9xxutoxlhxxxxxxxxxxowner(String z9xxutoxlhxxxxxxxxxxowner) {
		this.z9xxutoxlhxxxxxxxxxxowner = z9xxutoxlhxxxxxxxxxxowner;
	}

	@Column(name = "owner2", length = 40)
	@Size(max = 40)
	public String getZzxxu2oxxhxxxxxxxxxxowner2() {
		return this.zzxxu2oxxhxxxxxxxxxxowner2;
	}

	public void setZzxxu2oxxhxxxxxxxxxxowner2(String zzxxu2oxxhxxxxxxxxxxowner2) {
		this.zzxxu2oxxhxxxxxxxxxxowner2 = zzxxu2oxxhxxxxxxxxxxowner2;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "trexuq377xwwqqhxxxxxvshipmen")
	public Set<Xoxxuq399xvwwqqhxxxxvshipmendetails> getXoxxuq399xvwwqqhxxxxvshipmendetailses() {
		return this.xoxxuq399xvwwqqhxxxxvshipmendetailses;
	}

	public void setXoxxuq399xvwwqqhxxxxvshipmendetailses(
			Set<Xoxxuq399xvwwqqhxxxxvshipmendetails> xoxxuq399xvwwqqhxxxxvshipmendetailses) {
		this.xoxxuq399xvwwqqhxxxxvshipmendetailses = xoxxuq399xvwwqqhxxxxvshipmendetailses;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "trexuq377xwwqqhxxxxxvshipmen")
	public Set<Xoxxuq399xvwwqqhxxxxvshipmendetails> getXoxxuq399xvwwqqhxxxxvshipmendetailses_1() {
		return this.xoxxuq399xvwwqqhxxxxvshipmendetailses_1;
	}

	public void setXoxxuq399xvwwqqhxxxxvshipmendetailses_1(
			Set<Xoxxuq399xvwwqqhxxxxvshipmendetails> xoxxuq399xvwwqqhxxxxvshipmendetailses_1) {
		this.xoxxuq399xvwwqqhxxxxvshipmendetailses_1 = xoxxuq399xvwwqqhxxxxvshipmendetailses_1;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "trexuq377xwwqqhxxxxxvshipmen")
	public Set<Trexuq3a6xwwqqhxxxxxvinvoice> getTrexuq3a6xwwqqhxxxxxvinvoices() {
		return this.trexuq3a6xwwqqhxxxxxvinvoices;
	}

	public void setTrexuq3a6xwwqqhxxxxxvinvoices(
			Set<Trexuq3a6xwwqqhxxxxxvinvoice> trexuq3a6xwwqqhxxxxxvinvoices) {
		this.trexuq3a6xwwqqhxxxxxvinvoices = trexuq3a6xwwqqhxxxxxvinvoices;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "trexuq377xwwqqhxxxxxvshipmen")
	public Set<Trexuq3a6xwwqqhxxxxxvinvoice> getTrexuq3a6xwwqqhxxxxxvinvoices_1() {
		return this.trexuq3a6xwwqqhxxxxxvinvoices_1;
	}

	public void setTrexuq3a6xwwqqhxxxxxvinvoices_1(
			Set<Trexuq3a6xwwqqhxxxxxvinvoice> trexuq3a6xwwqqhxxxxxvinvoices_1) {
		this.trexuq3a6xwwqqhxxxxxvinvoices_1 = trexuq3a6xwwqqhxxxxxvinvoices_1;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "trexuq377xwwqqhxxxxxvshipmen")
	public Set<Trexuq444xwwqqhxxxxxemplorders> getTrexuq444xwwqqhxxxxxemplorderses() {
		return this.trexuq444xwwqqhxxxxxemplorderses;
	}

	public void setTrexuq444xwwqqhxxxxxemplorderses(
			Set<Trexuq444xwwqqhxxxxxemplorders> trexuq444xwwqqhxxxxxemplorderses) {
		this.trexuq444xwwqqhxxxxxemplorderses = trexuq444xwwqqhxxxxxemplorderses;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "trexuq377xwwqqhxxxxxvshipmen")
	public Set<Trexuq444xwwqqhxxxxxemplorders> getTrexuq444xwwqqhxxxxxemplorderses_1() {
		return this.trexuq444xwwqqhxxxxxemplorderses_1;
	}

	public void setTrexuq444xwwqqhxxxxxemplorderses_1(
			Set<Trexuq444xwwqqhxxxxxemplorders> trexuq444xwwqqhxxxxxemplorderses_1) {
		this.trexuq444xwwqqhxxxxxemplorderses_1 = trexuq444xwwqqhxxxxxemplorderses_1;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "trexuq377xwwqqhxxxxxvshipmen")
	public Set<Trexuq3a6xwwqqhxxxxxvinvoice> getTrexuq3a6xwwqqhxxxxxvinvoices_2() {
		return this.trexuq3a6xwwqqhxxxxxvinvoices_2;
	}

	public void setTrexuq3a6xwwqqhxxxxxvinvoices_2(
			Set<Trexuq3a6xwwqqhxxxxxvinvoice> trexuq3a6xwwqqhxxxxxvinvoices_2) {
		this.trexuq3a6xwwqqhxxxxxvinvoices_2 = trexuq3a6xwwqqhxxxxxvinvoices_2;
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
