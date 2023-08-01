package com.rcomputer.genapp.model;
// Generated 28-Jul-2023 8:02:11 PM by Hibernate Tools 4.0.0

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
 * Xoxxuq3e4xwwqqhxxxxxvendqdetails generated by hbm2java
 */
@Entity
@XmlRootElement
@Table(name = "vendqdetails")
public class Xoxxuq3e4xwwqqhxxxxxvendqdetails implements java.io.Serializable {

	private Integer a0xxuobxbxxxxxxxxxxxsid;
	private Jxxxuq201xwwqqhxxxxxcustomer jxxxuq201xwwqqhxxxxxcustomer;
	private Fpxxfq1a5xwwqqhxxxxxitem fpxxfq1a5xwwqqhxxxxxitem;
	private Trexuq333xwwqqhxxxxxvenquote trexuq333xwwqqhxxxxxvenquote;
	private Integer b1xxzo11bvlxxxxxxxxxline;
	private BigDecimal z3xxeqxxbvnxxxxxxxxxqtyordrd;
	private String z4xxuuxxbv19xxxxxxxxordunit;
	private BigDecimal z5xxzpxravxxxxxxxxxxordprice;
	private Date z6xxcxxxbxxxxxxxxxxxiodatet;
	private String z8xxtxsolxxxxxxxxxxxshipoption;
	private BigDecimal z9xxzxxxavxxxxxxxxxxqtyostnd;
	private BigDecimal zbxxzbxxavxxxxxxxxxxbaseamount;
	private BigDecimal zaxxzlxxavxxxxxxxxxxdelivchrg;
	private BigDecimal zbxxzmxxavxxxxxxxxxxmiscchrg;
	private BigDecimal zcxxzxz1avxxxxxxxxxxtax1amt;
	private BigDecimal zdxxzxz2avxxxxxxxxxxtax2amt;
	private BigDecimal zexxzxz3avxxxxxxxxxxtax3amt;
	private BigDecimal zfxxzlpxxvxxxxxxxxxxlinetotl;
	private String zzxxu2oxxhxxxxxxxxxxowner2;

	public Xoxxuq3e4xwwqqhxxxxxvendqdetails() {
	}

	public Xoxxuq3e4xwwqqhxxxxxvendqdetails(
			Trexuq333xwwqqhxxxxxvenquote trexuq333xwwqqhxxxxxvenquote) {
		this.trexuq333xwwqqhxxxxxvenquote = trexuq333xwwqqhxxxxxvenquote;
	}
	public Xoxxuq3e4xwwqqhxxxxxvendqdetails(
			Jxxxuq201xwwqqhxxxxxcustomer jxxxuq201xwwqqhxxxxxcustomer,
			Fpxxfq1a5xwwqqhxxxxxitem fpxxfq1a5xwwqqhxxxxxitem,
			Trexuq333xwwqqhxxxxxvenquote trexuq333xwwqqhxxxxxvenquote,
			Integer b1xxzo11bvlxxxxxxxxxline,
			BigDecimal z3xxeqxxbvnxxxxxxxxxqtyordrd,
			String z4xxuuxxbv19xxxxxxxxordunit,
			BigDecimal z5xxzpxravxxxxxxxxxxordprice,
			Date z6xxcxxxbxxxxxxxxxxxiodatet,
			String z8xxtxsolxxxxxxxxxxxshipoption,
			BigDecimal z9xxzxxxavxxxxxxxxxxqtyostnd,
			BigDecimal zbxxzbxxavxxxxxxxxxxbaseamount,
			BigDecimal zaxxzlxxavxxxxxxxxxxdelivchrg,
			BigDecimal zbxxzmxxavxxxxxxxxxxmiscchrg,
			BigDecimal zcxxzxz1avxxxxxxxxxxtax1amt,
			BigDecimal zdxxzxz2avxxxxxxxxxxtax2amt,
			BigDecimal zexxzxz3avxxxxxxxxxxtax3amt,
			BigDecimal zfxxzlpxxvxxxxxxxxxxlinetotl,
			String zzxxu2oxxhxxxxxxxxxxowner2) {
		this.jxxxuq201xwwqqhxxxxxcustomer = jxxxuq201xwwqqhxxxxxcustomer;
		this.fpxxfq1a5xwwqqhxxxxxitem = fpxxfq1a5xwwqqhxxxxxitem;
		this.trexuq333xwwqqhxxxxxvenquote = trexuq333xwwqqhxxxxxvenquote;
		this.b1xxzo11bvlxxxxxxxxxline = b1xxzo11bvlxxxxxxxxxline;
		this.z3xxeqxxbvnxxxxxxxxxqtyordrd = z3xxeqxxbvnxxxxxxxxxqtyordrd;
		this.z4xxuuxxbv19xxxxxxxxordunit = z4xxuuxxbv19xxxxxxxxordunit;
		this.z5xxzpxravxxxxxxxxxxordprice = z5xxzpxravxxxxxxxxxxordprice;
		this.z6xxcxxxbxxxxxxxxxxxiodatet = z6xxcxxxbxxxxxxxxxxxiodatet;
		this.z8xxtxsolxxxxxxxxxxxshipoption = z8xxtxsolxxxxxxxxxxxshipoption;
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
	@JoinColumn(name = "vendqno", nullable = false)
	@NotNull
	public Trexuq333xwwqqhxxxxxvenquote getTrexuq333xwwqqhxxxxxvenquote() {
		return this.trexuq333xwwqqhxxxxxvenquote;
	}

	public void setTrexuq333xwwqqhxxxxxvenquote(
			Trexuq333xwwqqhxxxxxvenquote trexuq333xwwqqhxxxxxvenquote) {
		this.trexuq333xwwqqhxxxxxvenquote = trexuq333xwwqqhxxxxxvenquote;
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

	@Column(name = "ordunit", length = 12)
	@Size(max = 12)
	public String getZ4xxuuxxbv19xxxxxxxxordunit() {
		return this.z4xxuuxxbv19xxxxxxxxordunit;
	}

	public void setZ4xxuuxxbv19xxxxxxxxordunit(
			String z4xxuuxxbv19xxxxxxxxordunit) {
		this.z4xxuuxxbv19xxxxxxxxordunit = z4xxuuxxbv19xxxxxxxxordunit;
	}

	@Column(name = "ordprice", precision = 14)
	public BigDecimal getZ5xxzpxravxxxxxxxxxxordprice() {
		return this.z5xxzpxravxxxxxxxxxxordprice;
	}

	public void setZ5xxzpxravxxxxxxxxxxordprice(
			BigDecimal z5xxzpxravxxxxxxxxxxordprice) {
		this.z5xxzpxravxxxxxxxxxxordprice = z5xxzpxravxxxxxxxxxxordprice;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "iodatet", length = 29)
	public Date getZ6xxcxxxbxxxxxxxxxxxiodatet() {
		return this.z6xxcxxxbxxxxxxxxxxxiodatet;
	}

	public void setZ6xxcxxxbxxxxxxxxxxxiodatet(Date z6xxcxxxbxxxxxxxxxxxiodatet) {
		this.z6xxcxxxbxxxxxxxxxxxiodatet = z6xxcxxxbxxxxxxxxxxxiodatet;
	}

	@Column(name = "shipoption", length = 20)
	@Size(max = 20)
	public String getZ8xxtxsolxxxxxxxxxxxshipoption() {
		return this.z8xxtxsolxxxxxxxxxxxshipoption;
	}

	public void setZ8xxtxsolxxxxxxxxxxxshipoption(
			String z8xxtxsolxxxxxxxxxxxshipoption) {
		this.z8xxtxsolxxxxxxxxxxxshipoption = z8xxtxsolxxxxxxxxxxxshipoption;
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
