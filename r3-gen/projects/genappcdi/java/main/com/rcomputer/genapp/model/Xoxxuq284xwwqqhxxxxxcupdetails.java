package com.rcomputer.genapp.model;
// Generated 27-Jun-2023 8:43:30 PM by Hibernate Tools 4.0.0

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
 * Xoxxuq284xwwqqhxxxxxcupdetails generated by hbm2java
 */
@Entity
@XmlRootElement
@Table(name = "cupdetails")
public class Xoxxuq284xwwqqhxxxxxcupdetails implements java.io.Serializable {

	private Integer a0xxuobxbxxxxxxxxxxxsid;
	private Trexuq277xwwqqhxxxxxcpayment trexuq277xwwqqhxxxxxcpayment;
	private Trexuq266xwwqqhxxxxxcuinvoice trexuq266xwwqqhxxxxxcuinvoice;
	private Integer b1xxzo11bvlxxxxxxxxxline;
	private BigDecimal z3xxeqxxbvnxxxxxxxxxqtyordrd;
	private BigDecimal z5xxzpxravxxxxxxxxxxordprice;
	private String b6xxuxxrbv10xxxxxxxxpaytype;
	private String z5xxuxxrbvxxxxxxxxxxpaybyid;
	private BigDecimal z6xxzxxxavxxxxxxxxxxamountin;
	private BigDecimal zbxxzbxxavxxxxxxxxxxbaseamount;
	private BigDecimal z9xxzlxxavxxxxxxxxxxdelivchrg;
	private BigDecimal zaxxzmxxavxxxxxxxxxxmiscchrg;
	private BigDecimal zbxxzxz1avxxxxxxxxxxtax1amt;
	private BigDecimal zcxxzxz2avxxxxxxxxxxtax2amt;
	private BigDecimal zdxxzxz3avxxxxxxxxxxtax3amt;
	private BigDecimal zgxxzlpxxvxxxxxxxxxxlinetotl;
	private String zzxxu2oxxhxxxxxxxxxxowner2;

	public Xoxxuq284xwwqqhxxxxxcupdetails() {
	}

	public Xoxxuq284xwwqqhxxxxxcupdetails(
			Trexuq277xwwqqhxxxxxcpayment trexuq277xwwqqhxxxxxcpayment) {
		this.trexuq277xwwqqhxxxxxcpayment = trexuq277xwwqqhxxxxxcpayment;
	}
	public Xoxxuq284xwwqqhxxxxxcupdetails(
			Trexuq277xwwqqhxxxxxcpayment trexuq277xwwqqhxxxxxcpayment,
			Trexuq266xwwqqhxxxxxcuinvoice trexuq266xwwqqhxxxxxcuinvoice,
			Integer b1xxzo11bvlxxxxxxxxxline,
			BigDecimal z3xxeqxxbvnxxxxxxxxxqtyordrd,
			BigDecimal z5xxzpxravxxxxxxxxxxordprice,
			String b6xxuxxrbv10xxxxxxxxpaytype,
			String z5xxuxxrbvxxxxxxxxxxpaybyid,
			BigDecimal z6xxzxxxavxxxxxxxxxxamountin,
			BigDecimal zbxxzbxxavxxxxxxxxxxbaseamount,
			BigDecimal z9xxzlxxavxxxxxxxxxxdelivchrg,
			BigDecimal zaxxzmxxavxxxxxxxxxxmiscchrg,
			BigDecimal zbxxzxz1avxxxxxxxxxxtax1amt,
			BigDecimal zcxxzxz2avxxxxxxxxxxtax2amt,
			BigDecimal zdxxzxz3avxxxxxxxxxxtax3amt,
			BigDecimal zgxxzlpxxvxxxxxxxxxxlinetotl,
			String zzxxu2oxxhxxxxxxxxxxowner2) {
		this.trexuq277xwwqqhxxxxxcpayment = trexuq277xwwqqhxxxxxcpayment;
		this.trexuq266xwwqqhxxxxxcuinvoice = trexuq266xwwqqhxxxxxcuinvoice;
		this.b1xxzo11bvlxxxxxxxxxline = b1xxzo11bvlxxxxxxxxxline;
		this.z3xxeqxxbvnxxxxxxxxxqtyordrd = z3xxeqxxbvnxxxxxxxxxqtyordrd;
		this.z5xxzpxravxxxxxxxxxxordprice = z5xxzpxravxxxxxxxxxxordprice;
		this.b6xxuxxrbv10xxxxxxxxpaytype = b6xxuxxrbv10xxxxxxxxpaytype;
		this.z5xxuxxrbvxxxxxxxxxxpaybyid = z5xxuxxrbvxxxxxxxxxxpaybyid;
		this.z6xxzxxxavxxxxxxxxxxamountin = z6xxzxxxavxxxxxxxxxxamountin;
		this.zbxxzbxxavxxxxxxxxxxbaseamount = zbxxzbxxavxxxxxxxxxxbaseamount;
		this.z9xxzlxxavxxxxxxxxxxdelivchrg = z9xxzlxxavxxxxxxxxxxdelivchrg;
		this.zaxxzmxxavxxxxxxxxxxmiscchrg = zaxxzmxxavxxxxxxxxxxmiscchrg;
		this.zbxxzxz1avxxxxxxxxxxtax1amt = zbxxzxz1avxxxxxxxxxxtax1amt;
		this.zcxxzxz2avxxxxxxxxxxtax2amt = zcxxzxz2avxxxxxxxxxxtax2amt;
		this.zdxxzxz3avxxxxxxxxxxtax3amt = zdxxzxz3avxxxxxxxxxxtax3amt;
		this.zgxxzlpxxvxxxxxxxxxxlinetotl = zgxxzlpxxvxxxxxxxxxxlinetotl;
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
	@JoinColumn(name = "cupno", nullable = false)
	@NotNull
	public Trexuq277xwwqqhxxxxxcpayment getTrexuq277xwwqqhxxxxxcpayment() {
		return this.trexuq277xwwqqhxxxxxcpayment;
	}

	public void setTrexuq277xwwqqhxxxxxcpayment(
			Trexuq277xwwqqhxxxxxcpayment trexuq277xwwqqhxxxxxcpayment) {
		this.trexuq277xwwqqhxxxxxcpayment = trexuq277xwwqqhxxxxxcpayment;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "invoice")
	public Trexuq266xwwqqhxxxxxcuinvoice getTrexuq266xwwqqhxxxxxcuinvoice() {
		return this.trexuq266xwwqqhxxxxxcuinvoice;
	}

	public void setTrexuq266xwwqqhxxxxxcuinvoice(
			Trexuq266xwwqqhxxxxxcuinvoice trexuq266xwwqqhxxxxxcuinvoice) {
		this.trexuq266xwwqqhxxxxxcuinvoice = trexuq266xwwqqhxxxxxcuinvoice;
	}

	@Column(name = "line")
	public Integer getB1xxzo11bvlxxxxxxxxxline() {
		return this.b1xxzo11bvlxxxxxxxxxline;
	}

	public void setB1xxzo11bvlxxxxxxxxxline(Integer b1xxzo11bvlxxxxxxxxxline) {
		this.b1xxzo11bvlxxxxxxxxxline = b1xxzo11bvlxxxxxxxxxline;
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

	@Column(name = "baseamount", precision = 14)
	public BigDecimal getZbxxzbxxavxxxxxxxxxxbaseamount() {
		return this.zbxxzbxxavxxxxxxxxxxbaseamount;
	}

	public void setZbxxzbxxavxxxxxxxxxxbaseamount(
			BigDecimal zbxxzbxxavxxxxxxxxxxbaseamount) {
		this.zbxxzbxxavxxxxxxxxxxbaseamount = zbxxzbxxavxxxxxxxxxxbaseamount;
	}

	@Column(name = "delivchrg", precision = 14)
	public BigDecimal getZ9xxzlxxavxxxxxxxxxxdelivchrg() {
		return this.z9xxzlxxavxxxxxxxxxxdelivchrg;
	}

	public void setZ9xxzlxxavxxxxxxxxxxdelivchrg(
			BigDecimal z9xxzlxxavxxxxxxxxxxdelivchrg) {
		this.z9xxzlxxavxxxxxxxxxxdelivchrg = z9xxzlxxavxxxxxxxxxxdelivchrg;
	}

	@Column(name = "miscchrg", precision = 14)
	public BigDecimal getZaxxzmxxavxxxxxxxxxxmiscchrg() {
		return this.zaxxzmxxavxxxxxxxxxxmiscchrg;
	}

	public void setZaxxzmxxavxxxxxxxxxxmiscchrg(
			BigDecimal zaxxzmxxavxxxxxxxxxxmiscchrg) {
		this.zaxxzmxxavxxxxxxxxxxmiscchrg = zaxxzmxxavxxxxxxxxxxmiscchrg;
	}

	@Column(name = "tax1amt", precision = 14)
	public BigDecimal getZbxxzxz1avxxxxxxxxxxtax1amt() {
		return this.zbxxzxz1avxxxxxxxxxxtax1amt;
	}

	public void setZbxxzxz1avxxxxxxxxxxtax1amt(
			BigDecimal zbxxzxz1avxxxxxxxxxxtax1amt) {
		this.zbxxzxz1avxxxxxxxxxxtax1amt = zbxxzxz1avxxxxxxxxxxtax1amt;
	}

	@Column(name = "tax2amt", precision = 14)
	public BigDecimal getZcxxzxz2avxxxxxxxxxxtax2amt() {
		return this.zcxxzxz2avxxxxxxxxxxtax2amt;
	}

	public void setZcxxzxz2avxxxxxxxxxxtax2amt(
			BigDecimal zcxxzxz2avxxxxxxxxxxtax2amt) {
		this.zcxxzxz2avxxxxxxxxxxtax2amt = zcxxzxz2avxxxxxxxxxxtax2amt;
	}

	@Column(name = "tax3amt", precision = 14)
	public BigDecimal getZdxxzxz3avxxxxxxxxxxtax3amt() {
		return this.zdxxzxz3avxxxxxxxxxxtax3amt;
	}

	public void setZdxxzxz3avxxxxxxxxxxtax3amt(
			BigDecimal zdxxzxz3avxxxxxxxxxxtax3amt) {
		this.zdxxzxz3avxxxxxxxxxxtax3amt = zdxxzxz3avxxxxxxxxxxtax3amt;
	}

	@Column(name = "linetotl", precision = 14)
	public BigDecimal getZgxxzlpxxvxxxxxxxxxxlinetotl() {
		return this.zgxxzlpxxvxxxxxxxxxxlinetotl;
	}

	public void setZgxxzlpxxvxxxxxxxxxxlinetotl(
			BigDecimal zgxxzlpxxvxxxxxxxxxxlinetotl) {
		this.zgxxzlpxxvxxxxxxxxxxlinetotl = zgxxzlpxxvxxxxxxxxxxlinetotl;
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
