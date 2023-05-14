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
 * Xxxxuq9ccxwwqqhxxxxxprocessdetails generated by hbm2java
 */
@Entity
@XmlRootElement
@Table(name = "processdetails")
public class Xxxxuq9ccxwwqqhxxxxxprocessdetails implements java.io.Serializable {

	private Integer a0xxuobxbxxxxxxxxxxxsid;
	private Trexuq244xwwqqhxxxxxcuorders trexuq244xwwqqhxxxxxcuorders;
	private Jxxxuq201xwwqqhxxxxxcustomer jxxxuq201xwwqqhxxxxxcustomer;
	private Fpxxfq1a5xwwqqhxxxxxitem fpxxfq1a5xwwqqhxxxxxitem;
	private String a0xxukpdbvxxxxxxxxxxprocess;
	private Date y5gxdxxxbvxxxxxxxxxxsdatet;
	private Integer y5xxexdhbvxxxxxxxxxxdurationh;
	private Integer y6xx0xdmbvxxxxxxxxxxdurationm;
	private Integer y7xxexshbvxxxxxxxxxxstimeh;
	private Integer y8bx0xsmbvxxxxxxxxxxstimem;
	private Boolean y8extxsabvxxxxxxxxxxstimeampm;
	private Date y8xxceedbvxxxxxxxxxxedatet;
	private Boolean y9xxfxxxbv08xxxxxxxxpriority;
	private BigDecimal yaxxzxxrlvxxxxxxxxxxpercntdone;
	private Integer z2xxzzfxhhxxxxxxxxxxstatusfl;
	private Date z3xxcztxlxxxxxxxxxxxstatusfldt;
	private String b9xxuxznbvxxxxxxxxxxnotes;
	private String z4xxutoxlhxxxxxxxxxxowner;
	private String zzxxu2oxxhxxxxxxxxxxowner2;
	private Set<Xoxxuq9f4xwwqqhxxxxxprocessattributes> xoxxuq9f4xwwqqhxxxxxprocessattributeses = new HashSet<Xoxxuq9f4xwwqqhxxxxxprocessattributes>(
			0);

	public Xxxxuq9ccxwwqqhxxxxxprocessdetails() {
	}

	public Xxxxuq9ccxwwqqhxxxxxprocessdetails(String a0xxukpdbvxxxxxxxxxxprocess) {
		this.a0xxukpdbvxxxxxxxxxxprocess = a0xxukpdbvxxxxxxxxxxprocess;
	}
	public Xxxxuq9ccxwwqqhxxxxxprocessdetails(
			Trexuq244xwwqqhxxxxxcuorders trexuq244xwwqqhxxxxxcuorders,
			Jxxxuq201xwwqqhxxxxxcustomer jxxxuq201xwwqqhxxxxxcustomer,
			Fpxxfq1a5xwwqqhxxxxxitem fpxxfq1a5xwwqqhxxxxxitem,
			String a0xxukpdbvxxxxxxxxxxprocess,
			Date y5gxdxxxbvxxxxxxxxxxsdatet,
			Integer y5xxexdhbvxxxxxxxxxxdurationh,
			Integer y6xx0xdmbvxxxxxxxxxxdurationm,
			Integer y7xxexshbvxxxxxxxxxxstimeh,
			Integer y8bx0xsmbvxxxxxxxxxxstimem,
			Boolean y8extxsabvxxxxxxxxxxstimeampm,
			Date y8xxceedbvxxxxxxxxxxedatet,
			Boolean y9xxfxxxbv08xxxxxxxxpriority,
			BigDecimal yaxxzxxrlvxxxxxxxxxxpercntdone,
			Integer z2xxzzfxhhxxxxxxxxxxstatusfl,
			Date z3xxcztxlxxxxxxxxxxxstatusfldt,
			String b9xxuxznbvxxxxxxxxxxnotes,
			String z4xxutoxlhxxxxxxxxxxowner,
			String zzxxu2oxxhxxxxxxxxxxowner2,
			Set<Xoxxuq9f4xwwqqhxxxxxprocessattributes> xoxxuq9f4xwwqqhxxxxxprocessattributeses) {
		this.trexuq244xwwqqhxxxxxcuorders = trexuq244xwwqqhxxxxxcuorders;
		this.jxxxuq201xwwqqhxxxxxcustomer = jxxxuq201xwwqqhxxxxxcustomer;
		this.fpxxfq1a5xwwqqhxxxxxitem = fpxxfq1a5xwwqqhxxxxxitem;
		this.a0xxukpdbvxxxxxxxxxxprocess = a0xxukpdbvxxxxxxxxxxprocess;
		this.y5gxdxxxbvxxxxxxxxxxsdatet = y5gxdxxxbvxxxxxxxxxxsdatet;
		this.y5xxexdhbvxxxxxxxxxxdurationh = y5xxexdhbvxxxxxxxxxxdurationh;
		this.y6xx0xdmbvxxxxxxxxxxdurationm = y6xx0xdmbvxxxxxxxxxxdurationm;
		this.y7xxexshbvxxxxxxxxxxstimeh = y7xxexshbvxxxxxxxxxxstimeh;
		this.y8bx0xsmbvxxxxxxxxxxstimem = y8bx0xsmbvxxxxxxxxxxstimem;
		this.y8extxsabvxxxxxxxxxxstimeampm = y8extxsabvxxxxxxxxxxstimeampm;
		this.y8xxceedbvxxxxxxxxxxedatet = y8xxceedbvxxxxxxxxxxedatet;
		this.y9xxfxxxbv08xxxxxxxxpriority = y9xxfxxxbv08xxxxxxxxpriority;
		this.yaxxzxxrlvxxxxxxxxxxpercntdone = yaxxzxxrlvxxxxxxxxxxpercntdone;
		this.z2xxzzfxhhxxxxxxxxxxstatusfl = z2xxzzfxhhxxxxxxxxxxstatusfl;
		this.z3xxcztxlxxxxxxxxxxxstatusfldt = z3xxcztxlxxxxxxxxxxxstatusfldt;
		this.b9xxuxznbvxxxxxxxxxxnotes = b9xxuxznbvxxxxxxxxxxnotes;
		this.z4xxutoxlhxxxxxxxxxxowner = z4xxutoxlhxxxxxxxxxxowner;
		this.zzxxu2oxxhxxxxxxxxxxowner2 = zzxxu2oxxhxxxxxxxxxxowner2;
		this.xoxxuq9f4xwwqqhxxxxxprocessattributeses = xoxxuq9f4xwwqqhxxxxxprocessattributeses;
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
	@JoinColumn(name = "cpono")
	public Trexuq244xwwqqhxxxxxcuorders getTrexuq244xwwqqhxxxxxcuorders() {
		return this.trexuq244xwwqqhxxxxxcuorders;
	}

	public void setTrexuq244xwwqqhxxxxxcuorders(
			Trexuq244xwwqqhxxxxxcuorders trexuq244xwwqqhxxxxxcuorders) {
		this.trexuq244xwwqqhxxxxxcuorders = trexuq244xwwqqhxxxxxcuorders;
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

	@Column(name = "process", nullable = false, length = 32)
	@NotNull
	@Size(max = 32)
	public String getA0xxukpdbvxxxxxxxxxxprocess() {
		return this.a0xxukpdbvxxxxxxxxxxprocess;
	}

	public void setA0xxukpdbvxxxxxxxxxxprocess(
			String a0xxukpdbvxxxxxxxxxxprocess) {
		this.a0xxukpdbvxxxxxxxxxxprocess = a0xxukpdbvxxxxxxxxxxprocess;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "sdatet", length = 29)
	public Date getY5gxdxxxbvxxxxxxxxxxsdatet() {
		return this.y5gxdxxxbvxxxxxxxxxxsdatet;
	}

	public void setY5gxdxxxbvxxxxxxxxxxsdatet(Date y5gxdxxxbvxxxxxxxxxxsdatet) {
		this.y5gxdxxxbvxxxxxxxxxxsdatet = y5gxdxxxbvxxxxxxxxxxsdatet;
	}

	@Column(name = "durationh")
	public Integer getY5xxexdhbvxxxxxxxxxxdurationh() {
		return this.y5xxexdhbvxxxxxxxxxxdurationh;
	}

	public void setY5xxexdhbvxxxxxxxxxxdurationh(
			Integer y5xxexdhbvxxxxxxxxxxdurationh) {
		this.y5xxexdhbvxxxxxxxxxxdurationh = y5xxexdhbvxxxxxxxxxxdurationh;
	}

	@Column(name = "durationm")
	public Integer getY6xx0xdmbvxxxxxxxxxxdurationm() {
		return this.y6xx0xdmbvxxxxxxxxxxdurationm;
	}

	public void setY6xx0xdmbvxxxxxxxxxxdurationm(
			Integer y6xx0xdmbvxxxxxxxxxxdurationm) {
		this.y6xx0xdmbvxxxxxxxxxxdurationm = y6xx0xdmbvxxxxxxxxxxdurationm;
	}

	@Column(name = "stimeh")
	public Integer getY7xxexshbvxxxxxxxxxxstimeh() {
		return this.y7xxexshbvxxxxxxxxxxstimeh;
	}

	public void setY7xxexshbvxxxxxxxxxxstimeh(Integer y7xxexshbvxxxxxxxxxxstimeh) {
		this.y7xxexshbvxxxxxxxxxxstimeh = y7xxexshbvxxxxxxxxxxstimeh;
	}

	@Column(name = "stimem")
	public Integer getY8bx0xsmbvxxxxxxxxxxstimem() {
		return this.y8bx0xsmbvxxxxxxxxxxstimem;
	}

	public void setY8bx0xsmbvxxxxxxxxxxstimem(Integer y8bx0xsmbvxxxxxxxxxxstimem) {
		this.y8bx0xsmbvxxxxxxxxxxstimem = y8bx0xsmbvxxxxxxxxxxstimem;
	}

	@Column(name = "stimeampm")
	public Boolean getY8extxsabvxxxxxxxxxxstimeampm() {
		return this.y8extxsabvxxxxxxxxxxstimeampm;
	}

	public void setY8extxsabvxxxxxxxxxxstimeampm(
			Boolean y8extxsabvxxxxxxxxxxstimeampm) {
		this.y8extxsabvxxxxxxxxxxstimeampm = y8extxsabvxxxxxxxxxxstimeampm;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "edatet", length = 29)
	public Date getY8xxceedbvxxxxxxxxxxedatet() {
		return this.y8xxceedbvxxxxxxxxxxedatet;
	}

	public void setY8xxceedbvxxxxxxxxxxedatet(Date y8xxceedbvxxxxxxxxxxedatet) {
		this.y8xxceedbvxxxxxxxxxxedatet = y8xxceedbvxxxxxxxxxxedatet;
	}

	@Column(name = "priority")
	public Boolean getY9xxfxxxbv08xxxxxxxxpriority() {
		return this.y9xxfxxxbv08xxxxxxxxpriority;
	}

	public void setY9xxfxxxbv08xxxxxxxxpriority(
			Boolean y9xxfxxxbv08xxxxxxxxpriority) {
		this.y9xxfxxxbv08xxxxxxxxpriority = y9xxfxxxbv08xxxxxxxxpriority;
	}

	@Column(name = "percntdone", precision = 14)
	public BigDecimal getYaxxzxxrlvxxxxxxxxxxpercntdone() {
		return this.yaxxzxxrlvxxxxxxxxxxpercntdone;
	}

	public void setYaxxzxxrlvxxxxxxxxxxpercntdone(
			BigDecimal yaxxzxxrlvxxxxxxxxxxpercntdone) {
		this.yaxxzxxrlvxxxxxxxxxxpercntdone = yaxxzxxrlvxxxxxxxxxxpercntdone;
	}

	@Column(name = "statusfl")
	public Integer getZ2xxzzfxhhxxxxxxxxxxstatusfl() {
		return this.z2xxzzfxhhxxxxxxxxxxstatusfl;
	}

	public void setZ2xxzzfxhhxxxxxxxxxxstatusfl(
			Integer z2xxzzfxhhxxxxxxxxxxstatusfl) {
		this.z2xxzzfxhhxxxxxxxxxxstatusfl = z2xxzzfxhhxxxxxxxxxxstatusfl;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "statusfldt", length = 29)
	public Date getZ3xxcztxlxxxxxxxxxxxstatusfldt() {
		return this.z3xxcztxlxxxxxxxxxxxstatusfldt;
	}

	public void setZ3xxcztxlxxxxxxxxxxxstatusfldt(
			Date z3xxcztxlxxxxxxxxxxxstatusfldt) {
		this.z3xxcztxlxxxxxxxxxxxstatusfldt = z3xxcztxlxxxxxxxxxxxstatusfldt;
	}

	@Column(name = "notes", length = 60)
	@Size(max = 60)
	public String getB9xxuxznbvxxxxxxxxxxnotes() {
		return this.b9xxuxznbvxxxxxxxxxxnotes;
	}

	public void setB9xxuxznbvxxxxxxxxxxnotes(String b9xxuxznbvxxxxxxxxxxnotes) {
		this.b9xxuxznbvxxxxxxxxxxnotes = b9xxuxznbvxxxxxxxxxxnotes;
	}

	@Column(name = "owner", length = 40)
	@Size(max = 40)
	public String getZ4xxutoxlhxxxxxxxxxxowner() {
		return this.z4xxutoxlhxxxxxxxxxxowner;
	}

	public void setZ4xxutoxlhxxxxxxxxxxowner(String z4xxutoxlhxxxxxxxxxxowner) {
		this.z4xxutoxlhxxxxxxxxxxowner = z4xxutoxlhxxxxxxxxxxowner;
	}

	@Column(name = "owner2", length = 40)
	@Size(max = 40)
	public String getZzxxu2oxxhxxxxxxxxxxowner2() {
		return this.zzxxu2oxxhxxxxxxxxxxowner2;
	}

	public void setZzxxu2oxxhxxxxxxxxxxowner2(String zzxxu2oxxhxxxxxxxxxxowner2) {
		this.zzxxu2oxxhxxxxxxxxxxowner2 = zzxxu2oxxhxxxxxxxxxxowner2;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "xxxxuq9ccxwwqqhxxxxxprocessdetails")
	public Set<Xoxxuq9f4xwwqqhxxxxxprocessattributes> getXoxxuq9f4xwwqqhxxxxxprocessattributeses() {
		return this.xoxxuq9f4xwwqqhxxxxxprocessattributeses;
	}

	public void setXoxxuq9f4xwwqqhxxxxxprocessattributeses(
			Set<Xoxxuq9f4xwwqqhxxxxxprocessattributes> xoxxuq9f4xwwqqhxxxxxprocessattributeses) {
		this.xoxxuq9f4xwwqqhxxxxxprocessattributeses = xoxxuq9f4xwwqqhxxxxxprocessattributeses;
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
