package com.rcomputer.genapp.model;
// Generated 13-Apr-2023 9:07:31 PM by Hibernate Tools 4.0.0

import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
 * Xoxxuq295xwwqqhxxxxxshipmentdetails generated by hbm2java
 */
@Entity
@XmlRootElement
@Table(name = "shipmentdetails")
public class Xoxxuq295xwwqqhxxxxxshipmentdetails
		implements
			java.io.Serializable {

	private Integer a0xxuobxbxxxxxxxxxxxsid;
	private Trexuq255xwwqqhxxxxxshipment trexuq255xwwqqhxxxxxshipment;
	private Fxxxuq111xwwqqhxxxxxaddress fxxxuq111xwwqqhxxxxxaddressByMailtocode;
	private Fpxxfq1a5xwwqqhxxxxxitem fpxxfq1a5xwwqqhxxxxxitem;
	private Fxxxuq111xwwqqhxxxxxaddress fxxxuq111xwwqqhxxxxxaddressByShiptocode;
	private Integer b1xxzo11bvlxxxxxxxxxline;
	private BigDecimal z3xxeqxxbvnxxxxxxxxxqtyshipped;
	private BigDecimal z5xxzpxravxxxxxxxxxxshippingprice;
	private Integer z3xxuxxrbvxxxxxxxxxxshipper;
	private Integer z4xxuxcobvxxxxxxxxxxpono;
	private Integer z5xxuxxrbvxxxxxxxxxxcpono;
	private Integer z6xxuxxrbvxxxxxxxxxxinvoice;
	private BigDecimal z8xxztprlxxxxxxxxxxxamount;
	private BigDecimal z9xxzyprlxxxxxxxxxxxamountostnd;
	private BigDecimal zaxxztqrlxxxxxxxxxxxqty;
	private BigDecimal zbxxzyqrlxxxxxxxxxxxqtyostnd;
	private Integer zcxxuxxrbvxxxxxxxxxxcarrier;
	private String zdxxuxxrbv51xxxxxxxxtype;
	private Date zexxcxxrlxxxxxxxxxxxshipdatet;
	private Date zfxxcxxrlxxxxxxxxxxxshipdateta;
	private String zgxxuxxrbvxxxxxxxxxxtareno;
	private String zhxxuxxrbvxxxxxxxxxxpackno;
	private Integer zixxudrrbvxxxxxxxxxxcustomer;
	private String zlxxuxznbvxxxxxxxxxxnotes;
	private Integer zmxxzzfxhhxxxxxxxxxxstatusfl;
	private Date xznxcztxlxxxxxxxxxxxstatusfldt;
	private String zoxxuxxrbvxxxxxxxxxxserialno;
	private Integer zpxxzzprhvxxxxxxxxxxprintmstat;
	private Date zqxxczqxlhxxxxxxxxxxprinmtfldt;
	private String zrxxutoxlhxxxxxxxxxxowner;
	private String zzxxu2oxxhxxxxxxxxxxowner2;
	private String zsxxuxxrbvxxxxxxxxxxbarshipcod;
	private BigDecimal zgxxzlpxxvxxxxxxxxxxlinetotl;

	public Xoxxuq295xwwqqhxxxxxshipmentdetails() {
	}

	public Xoxxuq295xwwqqhxxxxxshipmentdetails(
			Trexuq255xwwqqhxxxxxshipment trexuq255xwwqqhxxxxxshipment) {
		this.trexuq255xwwqqhxxxxxshipment = trexuq255xwwqqhxxxxxshipment;
	}
	public Xoxxuq295xwwqqhxxxxxshipmentdetails(
			Trexuq255xwwqqhxxxxxshipment trexuq255xwwqqhxxxxxshipment,
			Fxxxuq111xwwqqhxxxxxaddress fxxxuq111xwwqqhxxxxxaddressByMailtocode,
			Fpxxfq1a5xwwqqhxxxxxitem fpxxfq1a5xwwqqhxxxxxitem,
			Fxxxuq111xwwqqhxxxxxaddress fxxxuq111xwwqqhxxxxxaddressByShiptocode,
			Integer b1xxzo11bvlxxxxxxxxxline,
			BigDecimal z3xxeqxxbvnxxxxxxxxxqtyshipped,
			BigDecimal z5xxzpxravxxxxxxxxxxshippingprice,
			Integer z3xxuxxrbvxxxxxxxxxxshipper,
			Integer z4xxuxcobvxxxxxxxxxxpono,
			Integer z5xxuxxrbvxxxxxxxxxxcpono,
			Integer z6xxuxxrbvxxxxxxxxxxinvoice,
			BigDecimal z8xxztprlxxxxxxxxxxxamount,
			BigDecimal z9xxzyprlxxxxxxxxxxxamountostnd,
			BigDecimal zaxxztqrlxxxxxxxxxxxqty,
			BigDecimal zbxxzyqrlxxxxxxxxxxxqtyostnd,
			Integer zcxxuxxrbvxxxxxxxxxxcarrier,
			String zdxxuxxrbv51xxxxxxxxtype,
			Date zexxcxxrlxxxxxxxxxxxshipdatet,
			Date zfxxcxxrlxxxxxxxxxxxshipdateta,
			String zgxxuxxrbvxxxxxxxxxxtareno,
			String zhxxuxxrbvxxxxxxxxxxpackno,
			Integer zixxudrrbvxxxxxxxxxxcustomer,
			String zlxxuxznbvxxxxxxxxxxnotes,
			Integer zmxxzzfxhhxxxxxxxxxxstatusfl,
			Date xznxcztxlxxxxxxxxxxxstatusfldt,
			String zoxxuxxrbvxxxxxxxxxxserialno,
			Integer zpxxzzprhvxxxxxxxxxxprintmstat,
			Date zqxxczqxlhxxxxxxxxxxprinmtfldt,
			String zrxxutoxlhxxxxxxxxxxowner,
			String zzxxu2oxxhxxxxxxxxxxowner2,
			String zsxxuxxrbvxxxxxxxxxxbarshipcod,
			BigDecimal zgxxzlpxxvxxxxxxxxxxlinetotl) {
		this.trexuq255xwwqqhxxxxxshipment = trexuq255xwwqqhxxxxxshipment;
		this.fxxxuq111xwwqqhxxxxxaddressByMailtocode = fxxxuq111xwwqqhxxxxxaddressByMailtocode;
		this.fpxxfq1a5xwwqqhxxxxxitem = fpxxfq1a5xwwqqhxxxxxitem;
		this.fxxxuq111xwwqqhxxxxxaddressByShiptocode = fxxxuq111xwwqqhxxxxxaddressByShiptocode;
		this.b1xxzo11bvlxxxxxxxxxline = b1xxzo11bvlxxxxxxxxxline;
		this.z3xxeqxxbvnxxxxxxxxxqtyshipped = z3xxeqxxbvnxxxxxxxxxqtyshipped;
		this.z5xxzpxravxxxxxxxxxxshippingprice = z5xxzpxravxxxxxxxxxxshippingprice;
		this.z3xxuxxrbvxxxxxxxxxxshipper = z3xxuxxrbvxxxxxxxxxxshipper;
		this.z4xxuxcobvxxxxxxxxxxpono = z4xxuxcobvxxxxxxxxxxpono;
		this.z5xxuxxrbvxxxxxxxxxxcpono = z5xxuxxrbvxxxxxxxxxxcpono;
		this.z6xxuxxrbvxxxxxxxxxxinvoice = z6xxuxxrbvxxxxxxxxxxinvoice;
		this.z8xxztprlxxxxxxxxxxxamount = z8xxztprlxxxxxxxxxxxamount;
		this.z9xxzyprlxxxxxxxxxxxamountostnd = z9xxzyprlxxxxxxxxxxxamountostnd;
		this.zaxxztqrlxxxxxxxxxxxqty = zaxxztqrlxxxxxxxxxxxqty;
		this.zbxxzyqrlxxxxxxxxxxxqtyostnd = zbxxzyqrlxxxxxxxxxxxqtyostnd;
		this.zcxxuxxrbvxxxxxxxxxxcarrier = zcxxuxxrbvxxxxxxxxxxcarrier;
		this.zdxxuxxrbv51xxxxxxxxtype = zdxxuxxrbv51xxxxxxxxtype;
		this.zexxcxxrlxxxxxxxxxxxshipdatet = zexxcxxrlxxxxxxxxxxxshipdatet;
		this.zfxxcxxrlxxxxxxxxxxxshipdateta = zfxxcxxrlxxxxxxxxxxxshipdateta;
		this.zgxxuxxrbvxxxxxxxxxxtareno = zgxxuxxrbvxxxxxxxxxxtareno;
		this.zhxxuxxrbvxxxxxxxxxxpackno = zhxxuxxrbvxxxxxxxxxxpackno;
		this.zixxudrrbvxxxxxxxxxxcustomer = zixxudrrbvxxxxxxxxxxcustomer;
		this.zlxxuxznbvxxxxxxxxxxnotes = zlxxuxznbvxxxxxxxxxxnotes;
		this.zmxxzzfxhhxxxxxxxxxxstatusfl = zmxxzzfxhhxxxxxxxxxxstatusfl;
		this.xznxcztxlxxxxxxxxxxxstatusfldt = xznxcztxlxxxxxxxxxxxstatusfldt;
		this.zoxxuxxrbvxxxxxxxxxxserialno = zoxxuxxrbvxxxxxxxxxxserialno;
		this.zpxxzzprhvxxxxxxxxxxprintmstat = zpxxzzprhvxxxxxxxxxxprintmstat;
		this.zqxxczqxlhxxxxxxxxxxprinmtfldt = zqxxczqxlhxxxxxxxxxxprinmtfldt;
		this.zrxxutoxlhxxxxxxxxxxowner = zrxxutoxlhxxxxxxxxxxowner;
		this.zzxxu2oxxhxxxxxxxxxxowner2 = zzxxu2oxxhxxxxxxxxxxowner2;
		this.zsxxuxxrbvxxxxxxxxxxbarshipcod = zsxxuxxrbvxxxxxxxxxxbarshipcod;
		this.zgxxzlpxxvxxxxxxxxxxlinetotl = zgxxzlpxxvxxxxxxxxxxlinetotl;
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
	@JoinColumn(name = "shipcode", nullable = false)
	@NotNull
	public Trexuq255xwwqqhxxxxxshipment getTrexuq255xwwqqhxxxxxshipment() {
		return this.trexuq255xwwqqhxxxxxshipment;
	}

	public void setTrexuq255xwwqqhxxxxxshipment(
			Trexuq255xwwqqhxxxxxshipment trexuq255xwwqqhxxxxxshipment) {
		this.trexuq255xwwqqhxxxxxshipment = trexuq255xwwqqhxxxxxshipment;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "mailtocode")
	public Fxxxuq111xwwqqhxxxxxaddress getFxxxuq111xwwqqhxxxxxaddressByMailtocode() {
		return this.fxxxuq111xwwqqhxxxxxaddressByMailtocode;
	}

	public void setFxxxuq111xwwqqhxxxxxaddressByMailtocode(
			Fxxxuq111xwwqqhxxxxxaddress fxxxuq111xwwqqhxxxxxaddressByMailtocode) {
		this.fxxxuq111xwwqqhxxxxxaddressByMailtocode = fxxxuq111xwwqqhxxxxxaddressByMailtocode;
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
	@JoinColumn(name = "shiptocode")
	public Fxxxuq111xwwqqhxxxxxaddress getFxxxuq111xwwqqhxxxxxaddressByShiptocode() {
		return this.fxxxuq111xwwqqhxxxxxaddressByShiptocode;
	}

	public void setFxxxuq111xwwqqhxxxxxaddressByShiptocode(
			Fxxxuq111xwwqqhxxxxxaddress fxxxuq111xwwqqhxxxxxaddressByShiptocode) {
		this.fxxxuq111xwwqqhxxxxxaddressByShiptocode = fxxxuq111xwwqqhxxxxxaddressByShiptocode;
	}

	@Column(name = "line")
	public Integer getB1xxzo11bvlxxxxxxxxxline() {
		return this.b1xxzo11bvlxxxxxxxxxline;
	}

	public void setB1xxzo11bvlxxxxxxxxxline(Integer b1xxzo11bvlxxxxxxxxxline) {
		this.b1xxzo11bvlxxxxxxxxxline = b1xxzo11bvlxxxxxxxxxline;
	}

	@Column(name = "qtyshipped", precision = 14)
	public BigDecimal getZ3xxeqxxbvnxxxxxxxxxqtyshipped() {
		return this.z3xxeqxxbvnxxxxxxxxxqtyshipped;
	}

	public void setZ3xxeqxxbvnxxxxxxxxxqtyshipped(
			BigDecimal z3xxeqxxbvnxxxxxxxxxqtyshipped) {
		this.z3xxeqxxbvnxxxxxxxxxqtyshipped = z3xxeqxxbvnxxxxxxxxxqtyshipped;
	}

	@Column(name = "shippingprice", precision = 14)
	public BigDecimal getZ5xxzpxravxxxxxxxxxxshippingprice() {
		return this.z5xxzpxravxxxxxxxxxxshippingprice;
	}

	public void setZ5xxzpxravxxxxxxxxxxshippingprice(
			BigDecimal z5xxzpxravxxxxxxxxxxshippingprice) {
		this.z5xxzpxravxxxxxxxxxxshippingprice = z5xxzpxravxxxxxxxxxxshippingprice;
	}

	@Column(name = "shipper")
	public Integer getZ3xxuxxrbvxxxxxxxxxxshipper() {
		return this.z3xxuxxrbvxxxxxxxxxxshipper;
	}

	public void setZ3xxuxxrbvxxxxxxxxxxshipper(
			Integer z3xxuxxrbvxxxxxxxxxxshipper) {
		this.z3xxuxxrbvxxxxxxxxxxshipper = z3xxuxxrbvxxxxxxxxxxshipper;
	}

	@Column(name = "pono")
	public Integer getZ4xxuxcobvxxxxxxxxxxpono() {
		return this.z4xxuxcobvxxxxxxxxxxpono;
	}

	public void setZ4xxuxcobvxxxxxxxxxxpono(Integer z4xxuxcobvxxxxxxxxxxpono) {
		this.z4xxuxcobvxxxxxxxxxxpono = z4xxuxcobvxxxxxxxxxxpono;
	}

	@Column(name = "cpono")
	public Integer getZ5xxuxxrbvxxxxxxxxxxcpono() {
		return this.z5xxuxxrbvxxxxxxxxxxcpono;
	}

	public void setZ5xxuxxrbvxxxxxxxxxxcpono(Integer z5xxuxxrbvxxxxxxxxxxcpono) {
		this.z5xxuxxrbvxxxxxxxxxxcpono = z5xxuxxrbvxxxxxxxxxxcpono;
	}

	@Column(name = "invoice")
	public Integer getZ6xxuxxrbvxxxxxxxxxxinvoice() {
		return this.z6xxuxxrbvxxxxxxxxxxinvoice;
	}

	public void setZ6xxuxxrbvxxxxxxxxxxinvoice(
			Integer z6xxuxxrbvxxxxxxxxxxinvoice) {
		this.z6xxuxxrbvxxxxxxxxxxinvoice = z6xxuxxrbvxxxxxxxxxxinvoice;
	}

	@Column(name = "amount", precision = 14)
	public BigDecimal getZ8xxztprlxxxxxxxxxxxamount() {
		return this.z8xxztprlxxxxxxxxxxxamount;
	}

	public void setZ8xxztprlxxxxxxxxxxxamount(
			BigDecimal z8xxztprlxxxxxxxxxxxamount) {
		this.z8xxztprlxxxxxxxxxxxamount = z8xxztprlxxxxxxxxxxxamount;
	}

	@Column(name = "amountostnd", precision = 14)
	public BigDecimal getZ9xxzyprlxxxxxxxxxxxamountostnd() {
		return this.z9xxzyprlxxxxxxxxxxxamountostnd;
	}

	public void setZ9xxzyprlxxxxxxxxxxxamountostnd(
			BigDecimal z9xxzyprlxxxxxxxxxxxamountostnd) {
		this.z9xxzyprlxxxxxxxxxxxamountostnd = z9xxzyprlxxxxxxxxxxxamountostnd;
	}

	@Column(name = "qty", precision = 14)
	public BigDecimal getZaxxztqrlxxxxxxxxxxxqty() {
		return this.zaxxztqrlxxxxxxxxxxxqty;
	}

	public void setZaxxztqrlxxxxxxxxxxxqty(BigDecimal zaxxztqrlxxxxxxxxxxxqty) {
		this.zaxxztqrlxxxxxxxxxxxqty = zaxxztqrlxxxxxxxxxxxqty;
	}

	@Column(name = "qtyostnd", precision = 14)
	public BigDecimal getZbxxzyqrlxxxxxxxxxxxqtyostnd() {
		return this.zbxxzyqrlxxxxxxxxxxxqtyostnd;
	}

	public void setZbxxzyqrlxxxxxxxxxxxqtyostnd(
			BigDecimal zbxxzyqrlxxxxxxxxxxxqtyostnd) {
		this.zbxxzyqrlxxxxxxxxxxxqtyostnd = zbxxzyqrlxxxxxxxxxxxqtyostnd;
	}

	@Column(name = "carrier")
	public Integer getZcxxuxxrbvxxxxxxxxxxcarrier() {
		return this.zcxxuxxrbvxxxxxxxxxxcarrier;
	}

	public void setZcxxuxxrbvxxxxxxxxxxcarrier(
			Integer zcxxuxxrbvxxxxxxxxxxcarrier) {
		this.zcxxuxxrbvxxxxxxxxxxcarrier = zcxxuxxrbvxxxxxxxxxxcarrier;
	}

	@Column(name = "type", length = 12)
	@Size(max = 12)
	public String getZdxxuxxrbv51xxxxxxxxtype() {
		return this.zdxxuxxrbv51xxxxxxxxtype;
	}

	public void setZdxxuxxrbv51xxxxxxxxtype(String zdxxuxxrbv51xxxxxxxxtype) {
		this.zdxxuxxrbv51xxxxxxxxtype = zdxxuxxrbv51xxxxxxxxtype;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "shipdatet", length = 29)
	public Date getZexxcxxrlxxxxxxxxxxxshipdatet() {
		return this.zexxcxxrlxxxxxxxxxxxshipdatet;
	}

	public void setZexxcxxrlxxxxxxxxxxxshipdatet(
			Date zexxcxxrlxxxxxxxxxxxshipdatet) {
		this.zexxcxxrlxxxxxxxxxxxshipdatet = zexxcxxrlxxxxxxxxxxxshipdatet;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "shipdateta", length = 29)
	public Date getZfxxcxxrlxxxxxxxxxxxshipdateta() {
		return this.zfxxcxxrlxxxxxxxxxxxshipdateta;
	}

	public void setZfxxcxxrlxxxxxxxxxxxshipdateta(
			Date zfxxcxxrlxxxxxxxxxxxshipdateta) {
		this.zfxxcxxrlxxxxxxxxxxxshipdateta = zfxxcxxrlxxxxxxxxxxxshipdateta;
	}

	@Column(name = "tareno", length = 20)
	@Size(max = 20)
	public String getZgxxuxxrbvxxxxxxxxxxtareno() {
		return this.zgxxuxxrbvxxxxxxxxxxtareno;
	}

	public void setZgxxuxxrbvxxxxxxxxxxtareno(String zgxxuxxrbvxxxxxxxxxxtareno) {
		this.zgxxuxxrbvxxxxxxxxxxtareno = zgxxuxxrbvxxxxxxxxxxtareno;
	}

	@Column(name = "packno", length = 20)
	@Size(max = 20)
	public String getZhxxuxxrbvxxxxxxxxxxpackno() {
		return this.zhxxuxxrbvxxxxxxxxxxpackno;
	}

	public void setZhxxuxxrbvxxxxxxxxxxpackno(String zhxxuxxrbvxxxxxxxxxxpackno) {
		this.zhxxuxxrbvxxxxxxxxxxpackno = zhxxuxxrbvxxxxxxxxxxpackno;
	}

	@Column(name = "customer")
	public Integer getZixxudrrbvxxxxxxxxxxcustomer() {
		return this.zixxudrrbvxxxxxxxxxxcustomer;
	}

	public void setZixxudrrbvxxxxxxxxxxcustomer(
			Integer zixxudrrbvxxxxxxxxxxcustomer) {
		this.zixxudrrbvxxxxxxxxxxcustomer = zixxudrrbvxxxxxxxxxxcustomer;
	}

	@Column(name = "notes", length = 60)
	@Size(max = 60)
	public String getZlxxuxznbvxxxxxxxxxxnotes() {
		return this.zlxxuxznbvxxxxxxxxxxnotes;
	}

	public void setZlxxuxznbvxxxxxxxxxxnotes(String zlxxuxznbvxxxxxxxxxxnotes) {
		this.zlxxuxznbvxxxxxxxxxxnotes = zlxxuxznbvxxxxxxxxxxnotes;
	}

	@Column(name = "statusfl")
	public Integer getZmxxzzfxhhxxxxxxxxxxstatusfl() {
		return this.zmxxzzfxhhxxxxxxxxxxstatusfl;
	}

	public void setZmxxzzfxhhxxxxxxxxxxstatusfl(
			Integer zmxxzzfxhhxxxxxxxxxxstatusfl) {
		this.zmxxzzfxhhxxxxxxxxxxstatusfl = zmxxzzfxhhxxxxxxxxxxstatusfl;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "statusfldt", length = 29)
	public Date getXznxcztxlxxxxxxxxxxxstatusfldt() {
		return this.xznxcztxlxxxxxxxxxxxstatusfldt;
	}

	public void setXznxcztxlxxxxxxxxxxxstatusfldt(
			Date xznxcztxlxxxxxxxxxxxstatusfldt) {
		this.xznxcztxlxxxxxxxxxxxstatusfldt = xznxcztxlxxxxxxxxxxxstatusfldt;
	}

	@Column(name = "serialno", length = 25)
	@Size(max = 25)
	public String getZoxxuxxrbvxxxxxxxxxxserialno() {
		return this.zoxxuxxrbvxxxxxxxxxxserialno;
	}

	public void setZoxxuxxrbvxxxxxxxxxxserialno(
			String zoxxuxxrbvxxxxxxxxxxserialno) {
		this.zoxxuxxrbvxxxxxxxxxxserialno = zoxxuxxrbvxxxxxxxxxxserialno;
	}

	@Column(name = "printmstat")
	public Integer getZpxxzzprhvxxxxxxxxxxprintmstat() {
		return this.zpxxzzprhvxxxxxxxxxxprintmstat;
	}

	public void setZpxxzzprhvxxxxxxxxxxprintmstat(
			Integer zpxxzzprhvxxxxxxxxxxprintmstat) {
		this.zpxxzzprhvxxxxxxxxxxprintmstat = zpxxzzprhvxxxxxxxxxxprintmstat;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "prinmtfldt", length = 29)
	public Date getZqxxczqxlhxxxxxxxxxxprinmtfldt() {
		return this.zqxxczqxlhxxxxxxxxxxprinmtfldt;
	}

	public void setZqxxczqxlhxxxxxxxxxxprinmtfldt(
			Date zqxxczqxlhxxxxxxxxxxprinmtfldt) {
		this.zqxxczqxlhxxxxxxxxxxprinmtfldt = zqxxczqxlhxxxxxxxxxxprinmtfldt;
	}

	@Column(name = "owner", length = 40)
	@Size(max = 40)
	public String getZrxxutoxlhxxxxxxxxxxowner() {
		return this.zrxxutoxlhxxxxxxxxxxowner;
	}

	public void setZrxxutoxlhxxxxxxxxxxowner(String zrxxutoxlhxxxxxxxxxxowner) {
		this.zrxxutoxlhxxxxxxxxxxowner = zrxxutoxlhxxxxxxxxxxowner;
	}

	@Column(name = "owner2", length = 40)
	@Size(max = 40)
	public String getZzxxu2oxxhxxxxxxxxxxowner2() {
		return this.zzxxu2oxxhxxxxxxxxxxowner2;
	}

	public void setZzxxu2oxxhxxxxxxxxxxowner2(String zzxxu2oxxhxxxxxxxxxxowner2) {
		this.zzxxu2oxxhxxxxxxxxxxowner2 = zzxxu2oxxhxxxxxxxxxxowner2;
	}

	@Column(name = "barshipcod", length = 30)
	@Size(max = 30)
	public String getZsxxuxxrbvxxxxxxxxxxbarshipcod() {
		return this.zsxxuxxrbvxxxxxxxxxxbarshipcod;
	}

	public void setZsxxuxxrbvxxxxxxxxxxbarshipcod(
			String zsxxuxxrbvxxxxxxxxxxbarshipcod) {
		this.zsxxuxxrbvxxxxxxxxxxbarshipcod = zsxxuxxrbvxxxxxxxxxxbarshipcod;
	}

	@Column(name = "linetotl", precision = 14)
	public BigDecimal getZgxxzlpxxvxxxxxxxxxxlinetotl() {
		return this.zgxxzlpxxvxxxxxxxxxxlinetotl;
	}

	public void setZgxxzlpxxvxxxxxxxxxxlinetotl(
			BigDecimal zgxxzlpxxvxxxxxxxxxxlinetotl) {
		this.zgxxzlpxxvxxxxxxxxxxlinetotl = zgxxzlpxxvxxxxxxxxxxlinetotl;
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