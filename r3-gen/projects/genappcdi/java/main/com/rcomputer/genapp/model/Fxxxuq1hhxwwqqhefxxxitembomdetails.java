package com.rcomputer.genapp.model;
// Generated 18-Oct-2023 7:34:42 PM by Hibernate Tools 4.0.0

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
 * Fxxxuq1hhxwwqqhefxxxitembomdetails generated by hbm2java
 */
@Entity
@XmlRootElement
@Table(name = "itembomdetails")
public class Fxxxuq1hhxwwqqhefxxxitembomdetails implements java.io.Serializable {

	private Integer a0xxuobxbxxxxxxxxxxxsid;
	private Fxxxuq166xwwqqhefmxxitembom fxxxuq166xwwqqhefmxxitembom;
	private Fpxxfq1a5xwwqqhxxxxxitem fpxxfq1a5xwwqqhxxxxxitem;
	private Boolean b2xxfxxxbvxxxxxxxxxxmode;
	private BigDecimal b3xxzqxxavxxxxxxxxxxsubqty;
	private String b4xxuxzsbvxxxxxxxxxxdescript;
	private String b5xxzkxrbvxxxxxxxxxxseq;
	private String b6xxzwprbvxxxxxxxxxxnotes;
	private Integer z1xxzzfxhhxxxxxxxxxxstatusfl;
	private Date z2xxcztxlxxxxxxxxxxxstatusfldt;
	private String z3xxutoxlhxxxxxxxxxxowner;
	private String zzxxu2oxxhxxxxxxxxxxowner2;

	public Fxxxuq1hhxwwqqhefxxxitembomdetails() {
	}

	public Fxxxuq1hhxwwqqhefxxxitembomdetails(
			Fxxxuq166xwwqqhefmxxitembom fxxxuq166xwwqqhefmxxitembom,
			Fpxxfq1a5xwwqqhxxxxxitem fpxxfq1a5xwwqqhxxxxxitem) {
		this.fxxxuq166xwwqqhefmxxitembom = fxxxuq166xwwqqhefmxxitembom;
		this.fpxxfq1a5xwwqqhxxxxxitem = fpxxfq1a5xwwqqhxxxxxitem;
	}
	public Fxxxuq1hhxwwqqhefxxxitembomdetails(
			Fxxxuq166xwwqqhefmxxitembom fxxxuq166xwwqqhefmxxitembom,
			Fpxxfq1a5xwwqqhxxxxxitem fpxxfq1a5xwwqqhxxxxxitem,
			Boolean b2xxfxxxbvxxxxxxxxxxmode,
			BigDecimal b3xxzqxxavxxxxxxxxxxsubqty,
			String b4xxuxzsbvxxxxxxxxxxdescript,
			String b5xxzkxrbvxxxxxxxxxxseq, String b6xxzwprbvxxxxxxxxxxnotes,
			Integer z1xxzzfxhhxxxxxxxxxxstatusfl,
			Date z2xxcztxlxxxxxxxxxxxstatusfldt,
			String z3xxutoxlhxxxxxxxxxxowner, String zzxxu2oxxhxxxxxxxxxxowner2) {
		this.fxxxuq166xwwqqhefmxxitembom = fxxxuq166xwwqqhefmxxitembom;
		this.fpxxfq1a5xwwqqhxxxxxitem = fpxxfq1a5xwwqqhxxxxxitem;
		this.b2xxfxxxbvxxxxxxxxxxmode = b2xxfxxxbvxxxxxxxxxxmode;
		this.b3xxzqxxavxxxxxxxxxxsubqty = b3xxzqxxavxxxxxxxxxxsubqty;
		this.b4xxuxzsbvxxxxxxxxxxdescript = b4xxuxzsbvxxxxxxxxxxdescript;
		this.b5xxzkxrbvxxxxxxxxxxseq = b5xxzkxrbvxxxxxxxxxxseq;
		this.b6xxzwprbvxxxxxxxxxxnotes = b6xxzwprbvxxxxxxxxxxnotes;
		this.z1xxzzfxhhxxxxxxxxxxstatusfl = z1xxzzfxhhxxxxxxxxxxstatusfl;
		this.z2xxcztxlxxxxxxxxxxxstatusfldt = z2xxcztxlxxxxxxxxxxxstatusfldt;
		this.z3xxutoxlhxxxxxxxxxxowner = z3xxutoxlhxxxxxxxxxxowner;
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
	@JoinColumn(name = "bomcode", nullable = false)
	@NotNull
	public Fxxxuq166xwwqqhefmxxitembom getFxxxuq166xwwqqhefmxxitembom() {
		return this.fxxxuq166xwwqqhefmxxitembom;
	}

	public void setFxxxuq166xwwqqhefmxxitembom(
			Fxxxuq166xwwqqhefmxxitembom fxxxuq166xwwqqhefmxxitembom) {
		this.fxxxuq166xwwqqhefmxxitembom = fxxxuq166xwwqqhefmxxitembom;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "matcode", nullable = false)
	@NotNull
	public Fpxxfq1a5xwwqqhxxxxxitem getFpxxfq1a5xwwqqhxxxxxitem() {
		return this.fpxxfq1a5xwwqqhxxxxxitem;
	}

	public void setFpxxfq1a5xwwqqhxxxxxitem(
			Fpxxfq1a5xwwqqhxxxxxitem fpxxfq1a5xwwqqhxxxxxitem) {
		this.fpxxfq1a5xwwqqhxxxxxitem = fpxxfq1a5xwwqqhxxxxxitem;
	}

	@Column(name = "mode")
	public Boolean getB2xxfxxxbvxxxxxxxxxxmode() {
		return this.b2xxfxxxbvxxxxxxxxxxmode;
	}

	public void setB2xxfxxxbvxxxxxxxxxxmode(Boolean b2xxfxxxbvxxxxxxxxxxmode) {
		this.b2xxfxxxbvxxxxxxxxxxmode = b2xxfxxxbvxxxxxxxxxxmode;
	}

	@Column(name = "subqty", precision = 14)
	public BigDecimal getB3xxzqxxavxxxxxxxxxxsubqty() {
		return this.b3xxzqxxavxxxxxxxxxxsubqty;
	}

	public void setB3xxzqxxavxxxxxxxxxxsubqty(
			BigDecimal b3xxzqxxavxxxxxxxxxxsubqty) {
		this.b3xxzqxxavxxxxxxxxxxsubqty = b3xxzqxxavxxxxxxxxxxsubqty;
	}

	@Column(name = "descript", length = 1200)
	@Size(max = 1200)
	public String getB4xxuxzsbvxxxxxxxxxxdescript() {
		return this.b4xxuxzsbvxxxxxxxxxxdescript;
	}

	public void setB4xxuxzsbvxxxxxxxxxxdescript(
			String b4xxuxzsbvxxxxxxxxxxdescript) {
		this.b4xxuxzsbvxxxxxxxxxxdescript = b4xxuxzsbvxxxxxxxxxxdescript;
	}

	@Column(name = "seq", length = 4)
	@Size(max = 4)
	public String getB5xxzkxrbvxxxxxxxxxxseq() {
		return this.b5xxzkxrbvxxxxxxxxxxseq;
	}

	public void setB5xxzkxrbvxxxxxxxxxxseq(String b5xxzkxrbvxxxxxxxxxxseq) {
		this.b5xxzkxrbvxxxxxxxxxxseq = b5xxzkxrbvxxxxxxxxxxseq;
	}

	@Column(name = "notes", length = 60)
	@Size(max = 60)
	public String getB6xxzwprbvxxxxxxxxxxnotes() {
		return this.b6xxzwprbvxxxxxxxxxxnotes;
	}

	public void setB6xxzwprbvxxxxxxxxxxnotes(String b6xxzwprbvxxxxxxxxxxnotes) {
		this.b6xxzwprbvxxxxxxxxxxnotes = b6xxzwprbvxxxxxxxxxxnotes;
	}

	@Column(name = "statusfl")
	public Integer getZ1xxzzfxhhxxxxxxxxxxstatusfl() {
		return this.z1xxzzfxhhxxxxxxxxxxstatusfl;
	}

	public void setZ1xxzzfxhhxxxxxxxxxxstatusfl(
			Integer z1xxzzfxhhxxxxxxxxxxstatusfl) {
		this.z1xxzzfxhhxxxxxxxxxxstatusfl = z1xxzzfxhhxxxxxxxxxxstatusfl;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "statusfldt", length = 29)
	public Date getZ2xxcztxlxxxxxxxxxxxstatusfldt() {
		return this.z2xxcztxlxxxxxxxxxxxstatusfldt;
	}

	public void setZ2xxcztxlxxxxxxxxxxxstatusfldt(
			Date z2xxcztxlxxxxxxxxxxxstatusfldt) {
		this.z2xxcztxlxxxxxxxxxxxstatusfldt = z2xxcztxlxxxxxxxxxxxstatusfldt;
	}

	@Column(name = "owner", length = 40)
	@Size(max = 40)
	public String getZ3xxutoxlhxxxxxxxxxxowner() {
		return this.z3xxutoxlhxxxxxxxxxxowner;
	}

	public void setZ3xxutoxlhxxxxxxxxxxowner(String z3xxutoxlhxxxxxxxxxxowner) {
		this.z3xxutoxlhxxxxxxxxxxowner = z3xxutoxlhxxxxxxxxxxowner;
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
