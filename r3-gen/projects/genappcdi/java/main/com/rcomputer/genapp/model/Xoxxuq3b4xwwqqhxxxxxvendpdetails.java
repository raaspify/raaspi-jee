package com.rcomputer.genapp.model;
// Generated 18-Oct-2023 7:34:42 PM by Hibernate Tools 4.0.0

import java.math.BigDecimal;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 * Xoxxuq3b4xwwqqhxxxxxvendpdetails generated by hbm2java
 */
@Entity
@XmlRootElement
@Table(name = "vendpdetails")
public class Xoxxuq3b4xwwqqhxxxxxvendpdetails implements java.io.Serializable {

	private Integer a0xxuobxbxxxxxxxxxxxsid;
	private Trexuq3a6xwwqqhxxxxxvinvoice trexuq3a6xwwqqhxxxxxvinvoice;
	private Jxxxuq300xwwqqhxxxxxvendor jxxxuq300xwwqqhxxxxxvendor;
	private Trexuq388xwwqqhxxxxxvpayment trexuq388xwwqqhxxxxxvpayment;
	private Integer a1xxzo11bvlxxxxxxxxxline;
	private BigDecimal z3xxeqxxbvnxxxxxxxxxqtyordrd;
	private BigDecimal z5xxzpxravxxxxxxxxxxordprice;
	private String b6xxuxxrbv10xxxxxxxxpaytype;
	private String z5xxuxxrbvxxxxxxxxxxpaybyid;
	private BigDecimal z6xxzxxxavxxxxxxxxxxamountin;
	private Integer z8xxurxravxxxxxxxxxxvontact;
	private BigDecimal z9xxzxxxavxxxxxxxxxxqtyostnd;
	private BigDecimal zbxxzbxxavxxxxxxxxxxbaseamount;
	private BigDecimal zaxxzlxxavxxxxxxxxxxdelivchrg;
	private BigDecimal zbxxzmxxavxxxxxxxxxxmiscchrg;
	private BigDecimal zcxxzxz1avxxxxxxxxxxtax1amt;
	private BigDecimal zdxxzxz2avxxxxxxxxxxtax2amt;
	private BigDecimal zexxzxz3avxxxxxxxxxxtax3amt;
	private BigDecimal zfxxzlpxxvxxxxxxxxxxlinetotl;
	private String zzxxu2oxxhxxxxxxxxxxowner2;

	public Xoxxuq3b4xwwqqhxxxxxvendpdetails() {
	}

	public Xoxxuq3b4xwwqqhxxxxxvendpdetails(
			Trexuq388xwwqqhxxxxxvpayment trexuq388xwwqqhxxxxxvpayment) {
		this.trexuq388xwwqqhxxxxxvpayment = trexuq388xwwqqhxxxxxvpayment;
	}
	public Xoxxuq3b4xwwqqhxxxxxvendpdetails(
			Trexuq3a6xwwqqhxxxxxvinvoice trexuq3a6xwwqqhxxxxxvinvoice,
			Jxxxuq300xwwqqhxxxxxvendor jxxxuq300xwwqqhxxxxxvendor,
			Trexuq388xwwqqhxxxxxvpayment trexuq388xwwqqhxxxxxvpayment,
			Integer a1xxzo11bvlxxxxxxxxxline,
			BigDecimal z3xxeqxxbvnxxxxxxxxxqtyordrd,
			BigDecimal z5xxzpxravxxxxxxxxxxordprice,
			String b6xxuxxrbv10xxxxxxxxpaytype,
			String z5xxuxxrbvxxxxxxxxxxpaybyid,
			BigDecimal z6xxzxxxavxxxxxxxxxxamountin,
			Integer z8xxurxravxxxxxxxxxxvontact,
			BigDecimal z9xxzxxxavxxxxxxxxxxqtyostnd,
			BigDecimal zbxxzbxxavxxxxxxxxxxbaseamount,
			BigDecimal zaxxzlxxavxxxxxxxxxxdelivchrg,
			BigDecimal zbxxzmxxavxxxxxxxxxxmiscchrg,
			BigDecimal zcxxzxz1avxxxxxxxxxxtax1amt,
			BigDecimal zdxxzxz2avxxxxxxxxxxtax2amt,
			BigDecimal zexxzxz3avxxxxxxxxxxtax3amt,
			BigDecimal zfxxzlpxxvxxxxxxxxxxlinetotl,
			String zzxxu2oxxhxxxxxxxxxxowner2) {
		this.trexuq3a6xwwqqhxxxxxvinvoice = trexuq3a6xwwqqhxxxxxvinvoice;
		this.jxxxuq300xwwqqhxxxxxvendor = jxxxuq300xwwqqhxxxxxvendor;
		this.trexuq388xwwqqhxxxxxvpayment = trexuq388xwwqqhxxxxxvpayment;
		this.a1xxzo11bvlxxxxxxxxxline = a1xxzo11bvlxxxxxxxxxline;
		this.z3xxeqxxbvnxxxxxxxxxqtyordrd = z3xxeqxxbvnxxxxxxxxxqtyordrd;
		this.z5xxzpxravxxxxxxxxxxordprice = z5xxzpxravxxxxxxxxxxordprice;
		this.b6xxuxxrbv10xxxxxxxxpaytype = b6xxuxxrbv10xxxxxxxxpaytype;
		this.z5xxuxxrbvxxxxxxxxxxpaybyid = z5xxuxxrbvxxxxxxxxxxpaybyid;
		this.z6xxzxxxavxxxxxxxxxxamountin = z6xxzxxxavxxxxxxxxxxamountin;
		this.z8xxurxravxxxxxxxxxxvontact = z8xxurxravxxxxxxxxxxvontact;
		this.z9xxzxxxavxxxxxxxxxxqtyostnd = z9xxzxxxavxxxxxxxxxxqtyostnd;
		this.zbxxzbxxavxxxxxxxxxxbaseamount = zbxxzbxxavxxxxxxxxxxbaseamount;
		this.zaxxzlxxavxxxxxxxxxxdelivchrg = zaxxzlxxavxxxxxxxxxxdelivchrg;
		this.zbxxzmxxavxxxxxxxxxxmiscchrg = zbxxzmxxavxxxxxxxxxxmiscchrg;
		this.zcxxzxz1avxxxxxxxxxxtax1amt = zcxxzxz1avxxxxxxxxxxtax1amt;
		this.zdxxzxz2avxxxxxxxxxxtax2amt = zdxxzxz2avxxxxxxxxxxtax2amt;
		this.zexxzxz3avxxxxxxxxxxtax3amt = zexxzxz3avxxxxxxxxxxtax3amt;
		this.zfxxzlpxxvxxxxxxxxxxlinetotl = zfxxzlpxxvxxxxxxxxxxlinetotl;
		this.zzxxu2oxxhxxxxxxxxxxowner2 = zzxxu2oxxhxxxxxxxxxxowner2;
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
	@JoinColumn(name = "invoice")
	public Trexuq3a6xwwqqhxxxxxvinvoice getTrexuq3a6xwwqqhxxxxxvinvoice() {
		return this.trexuq3a6xwwqqhxxxxxvinvoice;
	}

	public void setTrexuq3a6xwwqqhxxxxxvinvoice(
			Trexuq3a6xwwqqhxxxxxvinvoice trexuq3a6xwwqqhxxxxxvinvoice) {
		this.trexuq3a6xwwqqhxxxxxvinvoice = trexuq3a6xwwqqhxxxxxvinvoice;
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
	@JoinColumn(name = "vendpno", nullable = false)
	@NotNull
	public Trexuq388xwwqqhxxxxxvpayment getTrexuq388xwwqqhxxxxxvpayment() {
		return this.trexuq388xwwqqhxxxxxvpayment;
	}

	public void setTrexuq388xwwqqhxxxxxvpayment(
			Trexuq388xwwqqhxxxxxvpayment trexuq388xwwqqhxxxxxvpayment) {
		this.trexuq388xwwqqhxxxxxvpayment = trexuq388xwwqqhxxxxxvpayment;
	}

	@Column(name = "line")
	public Integer getA1xxzo11bvlxxxxxxxxxline() {
		return this.a1xxzo11bvlxxxxxxxxxline;
	}

	public void setA1xxzo11bvlxxxxxxxxxline(Integer a1xxzo11bvlxxxxxxxxxline) {
		this.a1xxzo11bvlxxxxxxxxxline = a1xxzo11bvlxxxxxxxxxline;
	}

	@Column(name = "qtyordrd", precision = 14)
	public BigDecimal getZ3xxeqxxbvnxxxxxxxxxqtyordrd() {
		return this.z3xxeqxxbvnxxxxxxxxxqtyordrd;
	}

	public void setZ3xxeqxxbvnxxxxxxxxxqtyordrd(
			BigDecimal z3xxeqxxbvnxxxxxxxxxqtyordrd) {
		this.z3xxeqxxbvnxxxxxxxxxqtyordrd = z3xxeqxxbvnxxxxxxxxxqtyordrd;
	}

	@Column(name = "ordprice", precision = 14)
	public BigDecimal getZ5xxzpxravxxxxxxxxxxordprice() {
		return this.z5xxzpxravxxxxxxxxxxordprice;
	}

	public void setZ5xxzpxravxxxxxxxxxxordprice(
			BigDecimal z5xxzpxravxxxxxxxxxxordprice) {
		this.z5xxzpxravxxxxxxxxxxordprice = z5xxzpxravxxxxxxxxxxordprice;
	}

	@Column(name = "paytype", length = 12)
	@Size(max = 12)
	public String getB6xxuxxrbv10xxxxxxxxpaytype() {
		return this.b6xxuxxrbv10xxxxxxxxpaytype;
	}

	public void setB6xxuxxrbv10xxxxxxxxpaytype(
			String b6xxuxxrbv10xxxxxxxxpaytype) {
		this.b6xxuxxrbv10xxxxxxxxpaytype = b6xxuxxrbv10xxxxxxxxpaytype;
	}

	@Column(name = "paybyid", length = 12)
	@Size(max = 12)
	public String getZ5xxuxxrbvxxxxxxxxxxpaybyid() {
		return this.z5xxuxxrbvxxxxxxxxxxpaybyid;
	}

	public void setZ5xxuxxrbvxxxxxxxxxxpaybyid(
			String z5xxuxxrbvxxxxxxxxxxpaybyid) {
		this.z5xxuxxrbvxxxxxxxxxxpaybyid = z5xxuxxrbvxxxxxxxxxxpaybyid;
	}

	@Column(name = "amountin", precision = 14)
	public BigDecimal getZ6xxzxxxavxxxxxxxxxxamountin() {
		return this.z6xxzxxxavxxxxxxxxxxamountin;
	}

	public void setZ6xxzxxxavxxxxxxxxxxamountin(
			BigDecimal z6xxzxxxavxxxxxxxxxxamountin) {
		this.z6xxzxxxavxxxxxxxxxxamountin = z6xxzxxxavxxxxxxxxxxamountin;
	}

	@Column(name = "vontact")
	public Integer getZ8xxurxravxxxxxxxxxxvontact() {
		return this.z8xxurxravxxxxxxxxxxvontact;
	}

	public void setZ8xxurxravxxxxxxxxxxvontact(
			Integer z8xxurxravxxxxxxxxxxvontact) {
		this.z8xxurxravxxxxxxxxxxvontact = z8xxurxravxxxxxxxxxxvontact;
	}

	@Column(name = "qtyostnd", precision = 14)
	public BigDecimal getZ9xxzxxxavxxxxxxxxxxqtyostnd() {
		return this.z9xxzxxxavxxxxxxxxxxqtyostnd;
	}

	public void setZ9xxzxxxavxxxxxxxxxxqtyostnd(
			BigDecimal z9xxzxxxavxxxxxxxxxxqtyostnd) {
		this.z9xxzxxxavxxxxxxxxxxqtyostnd = z9xxzxxxavxxxxxxxxxxqtyostnd;
	}

	@Column(name = "baseamount", precision = 14)
	public BigDecimal getZbxxzbxxavxxxxxxxxxxbaseamount() {
		return this.zbxxzbxxavxxxxxxxxxxbaseamount;
	}

	public void setZbxxzbxxavxxxxxxxxxxbaseamount(
			BigDecimal zbxxzbxxavxxxxxxxxxxbaseamount) {
		this.zbxxzbxxavxxxxxxxxxxbaseamount = zbxxzbxxavxxxxxxxxxxbaseamount;
	}

	@Column(name = "delivchrg", precision = 14)
	public BigDecimal getZaxxzlxxavxxxxxxxxxxdelivchrg() {
		return this.zaxxzlxxavxxxxxxxxxxdelivchrg;
	}

	public void setZaxxzlxxavxxxxxxxxxxdelivchrg(
			BigDecimal zaxxzlxxavxxxxxxxxxxdelivchrg) {
		this.zaxxzlxxavxxxxxxxxxxdelivchrg = zaxxzlxxavxxxxxxxxxxdelivchrg;
	}

	@Column(name = "miscchrg", precision = 14)
	public BigDecimal getZbxxzmxxavxxxxxxxxxxmiscchrg() {
		return this.zbxxzmxxavxxxxxxxxxxmiscchrg;
	}

	public void setZbxxzmxxavxxxxxxxxxxmiscchrg(
			BigDecimal zbxxzmxxavxxxxxxxxxxmiscchrg) {
		this.zbxxzmxxavxxxxxxxxxxmiscchrg = zbxxzmxxavxxxxxxxxxxmiscchrg;
	}

	@Column(name = "tax1amt", precision = 14)
	public BigDecimal getZcxxzxz1avxxxxxxxxxxtax1amt() {
		return this.zcxxzxz1avxxxxxxxxxxtax1amt;
	}

	public void setZcxxzxz1avxxxxxxxxxxtax1amt(
			BigDecimal zcxxzxz1avxxxxxxxxxxtax1amt) {
		this.zcxxzxz1avxxxxxxxxxxtax1amt = zcxxzxz1avxxxxxxxxxxtax1amt;
	}

	@Column(name = "tax2amt", precision = 14)
	public BigDecimal getZdxxzxz2avxxxxxxxxxxtax2amt() {
		return this.zdxxzxz2avxxxxxxxxxxtax2amt;
	}

	public void setZdxxzxz2avxxxxxxxxxxtax2amt(
			BigDecimal zdxxzxz2avxxxxxxxxxxtax2amt) {
		this.zdxxzxz2avxxxxxxxxxxtax2amt = zdxxzxz2avxxxxxxxxxxtax2amt;
	}

	@Column(name = "tax3amt", precision = 14)
	public BigDecimal getZexxzxz3avxxxxxxxxxxtax3amt() {
		return this.zexxzxz3avxxxxxxxxxxtax3amt;
	}

	public void setZexxzxz3avxxxxxxxxxxtax3amt(
			BigDecimal zexxzxz3avxxxxxxxxxxtax3amt) {
		this.zexxzxz3avxxxxxxxxxxtax3amt = zexxzxz3avxxxxxxxxxxtax3amt;
	}

	@Column(name = "linetotl", precision = 14)
	public BigDecimal getZfxxzlpxxvxxxxxxxxxxlinetotl() {
		return this.zfxxzlpxxvxxxxxxxxxxlinetotl;
	}

	public void setZfxxzlpxxvxxxxxxxxxxlinetotl(
			BigDecimal zfxxzlpxxvxxxxxxxxxxlinetotl) {
		this.zfxxzlpxxvxxxxxxxxxxlinetotl = zfxxzlpxxvxxxxxxxxxxlinetotl;
	}

	@Column(name = "owner2", length = 40)
	@Size(max = 40)
	public String getZzxxu2oxxhxxxxxxxxxxowner2() {
		return this.zzxxu2oxxhxxxxxxxxxxowner2;
	}

	public void setZzxxu2oxxhxxxxxxxxxxowner2(String zzxxu2oxxhxxxxxxxxxxowner2) {
		this.zzxxu2oxxhxxxxxxxxxxowner2 = zzxxu2oxxhxxxxxxxxxxowner2;
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
