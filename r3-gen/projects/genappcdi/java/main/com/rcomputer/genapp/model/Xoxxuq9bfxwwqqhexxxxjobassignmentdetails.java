package com.rcomputer.genapp.model;
// Generated 27-Jun-2023 8:43:30 PM by Hibernate Tools 4.0.0

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
 * Xoxxuq9bfxwwqqhexxxxjobassignmentdetails generated by hbm2java
 */
@Entity
@XmlRootElement
@Table(name = "jobassignmentdetails")
public class Xoxxuq9bfxwwqqhexxxxjobassignmentdetails
		implements
			java.io.Serializable {

	private Integer a0xxuobxbxxxxxxxxxxxsid;
	private Fxxxcq144xwwqqhxxxxxlocation fxxxcq144xwwqqhxxxxxlocation;
	private Fpxxuq9eexwwqqhefxxxmachine fpxxuq9eexwwqqhefxxxmachine;
	private Dxxxuq92bxwwqqhefxxxitemjob dxxxuq92bxwwqqhefxxxitemjob;
	private Jxxxuq300xwwqqhxxxxxvendor jxxxuq300xwwqqhxxxxxvendor;
	private Trxxuq9aaxwwqqhefxxxjobassignment trxxuq9aaxwwqqhefxxxjobassignment;
	private Jxxxuq201xwwqqhxxxxxcustomer jxxxuq201xwwqqhxxxxxcustomer;
	private Fpxxfq1a5xwwqqhxxxxxitem fpxxfq1a5xwwqqhxxxxxitem;
	private Integer b1xxzo11bvlxxxxxxxxxline;
	private String b1xxuxxrbvxxxxxxxxxxsequence;
	private Date b5gxdxsdbvxxxxxxxxxxsdatet;
	private Integer b5xxexdhbvxxxxxxxxxxdurationh;
	private Integer b6xx0xdmbvxxxxxxxxxxdurationm;
	private Integer b7xxexshbvxxxxxxxxxxstimeh;
	private Integer b8bx0xsmbvxxxxxxxxxxstimem;
	private Boolean b8extxsabvxxxxxxxxxxstimeampm;
	private Date b8xxceedbvxxxxxxxxxxedatet;
	private Boolean b9xxfxxxbv08xxxxxxxxpriority;
	private BigDecimal baxxzxxrlvxxxxxxxxxxpercntdone;
	private String bgxxuxxrbv18xxxxxxxxrepeatf;
	private BigDecimal b5xxztqrlxxxxxxxxxxxqtytotal;
	private BigDecimal b6xxzyqrlxxxxxxxxxxxqtyostndt;
	private Integer b6xxuxcobvxxxxxxxxxxpono;
	private Integer b9xxuxxrbvxxxxxxxxxxcpono;
	private Integer z3xxzzfxhhxxxxxxxxxxstatusfl;
	private BigDecimal z3xxzlpxxvxxxxxxxxxxlinetotl;
	private String z4xxutoxlhxxxxxxxxxxowner;
	private String zzxxu2oxxhxxxxxxxxxxowner2;
	private String b9xxuxxrbvxxxxxxxxxxjafield1;
	private String b9xxuxxrbvxxxxxxxxxxjafield2;
	private String b9xxuxxrbvxxxxxxxxxxjafield3;
	private String b9xxuxxrbvxxxxxxxxxxjafield4;
	private String b9xxuxznbvxxxxxxxxxxnotes;

	public Xoxxuq9bfxwwqqhexxxxjobassignmentdetails() {
	}

	public Xoxxuq9bfxwwqqhexxxxjobassignmentdetails(
			Trxxuq9aaxwwqqhefxxxjobassignment trxxuq9aaxwwqqhefxxxjobassignment) {
		this.trxxuq9aaxwwqqhefxxxjobassignment = trxxuq9aaxwwqqhefxxxjobassignment;
	}
	public Xoxxuq9bfxwwqqhexxxxjobassignmentdetails(
			Fxxxcq144xwwqqhxxxxxlocation fxxxcq144xwwqqhxxxxxlocation,
			Fpxxuq9eexwwqqhefxxxmachine fpxxuq9eexwwqqhefxxxmachine,
			Dxxxuq92bxwwqqhefxxxitemjob dxxxuq92bxwwqqhefxxxitemjob,
			Jxxxuq300xwwqqhxxxxxvendor jxxxuq300xwwqqhxxxxxvendor,
			Trxxuq9aaxwwqqhefxxxjobassignment trxxuq9aaxwwqqhefxxxjobassignment,
			Jxxxuq201xwwqqhxxxxxcustomer jxxxuq201xwwqqhxxxxxcustomer,
			Fpxxfq1a5xwwqqhxxxxxitem fpxxfq1a5xwwqqhxxxxxitem,
			Integer b1xxzo11bvlxxxxxxxxxline,
			String b1xxuxxrbvxxxxxxxxxxsequence,
			Date b5gxdxsdbvxxxxxxxxxxsdatet,
			Integer b5xxexdhbvxxxxxxxxxxdurationh,
			Integer b6xx0xdmbvxxxxxxxxxxdurationm,
			Integer b7xxexshbvxxxxxxxxxxstimeh,
			Integer b8bx0xsmbvxxxxxxxxxxstimem,
			Boolean b8extxsabvxxxxxxxxxxstimeampm,
			Date b8xxceedbvxxxxxxxxxxedatet,
			Boolean b9xxfxxxbv08xxxxxxxxpriority,
			BigDecimal baxxzxxrlvxxxxxxxxxxpercntdone,
			String bgxxuxxrbv18xxxxxxxxrepeatf,
			BigDecimal b5xxztqrlxxxxxxxxxxxqtytotal,
			BigDecimal b6xxzyqrlxxxxxxxxxxxqtyostndt,
			Integer b6xxuxcobvxxxxxxxxxxpono,
			Integer b9xxuxxrbvxxxxxxxxxxcpono,
			Integer z3xxzzfxhhxxxxxxxxxxstatusfl,
			BigDecimal z3xxzlpxxvxxxxxxxxxxlinetotl,
			String z4xxutoxlhxxxxxxxxxxowner,
			String zzxxu2oxxhxxxxxxxxxxowner2,
			String b9xxuxxrbvxxxxxxxxxxjafield1,
			String b9xxuxxrbvxxxxxxxxxxjafield2,
			String b9xxuxxrbvxxxxxxxxxxjafield3,
			String b9xxuxxrbvxxxxxxxxxxjafield4,
			String b9xxuxznbvxxxxxxxxxxnotes) {
		this.fxxxcq144xwwqqhxxxxxlocation = fxxxcq144xwwqqhxxxxxlocation;
		this.fpxxuq9eexwwqqhefxxxmachine = fpxxuq9eexwwqqhefxxxmachine;
		this.dxxxuq92bxwwqqhefxxxitemjob = dxxxuq92bxwwqqhefxxxitemjob;
		this.jxxxuq300xwwqqhxxxxxvendor = jxxxuq300xwwqqhxxxxxvendor;
		this.trxxuq9aaxwwqqhefxxxjobassignment = trxxuq9aaxwwqqhefxxxjobassignment;
		this.jxxxuq201xwwqqhxxxxxcustomer = jxxxuq201xwwqqhxxxxxcustomer;
		this.fpxxfq1a5xwwqqhxxxxxitem = fpxxfq1a5xwwqqhxxxxxitem;
		this.b1xxzo11bvlxxxxxxxxxline = b1xxzo11bvlxxxxxxxxxline;
		this.b1xxuxxrbvxxxxxxxxxxsequence = b1xxuxxrbvxxxxxxxxxxsequence;
		this.b5gxdxsdbvxxxxxxxxxxsdatet = b5gxdxsdbvxxxxxxxxxxsdatet;
		this.b5xxexdhbvxxxxxxxxxxdurationh = b5xxexdhbvxxxxxxxxxxdurationh;
		this.b6xx0xdmbvxxxxxxxxxxdurationm = b6xx0xdmbvxxxxxxxxxxdurationm;
		this.b7xxexshbvxxxxxxxxxxstimeh = b7xxexshbvxxxxxxxxxxstimeh;
		this.b8bx0xsmbvxxxxxxxxxxstimem = b8bx0xsmbvxxxxxxxxxxstimem;
		this.b8extxsabvxxxxxxxxxxstimeampm = b8extxsabvxxxxxxxxxxstimeampm;
		this.b8xxceedbvxxxxxxxxxxedatet = b8xxceedbvxxxxxxxxxxedatet;
		this.b9xxfxxxbv08xxxxxxxxpriority = b9xxfxxxbv08xxxxxxxxpriority;
		this.baxxzxxrlvxxxxxxxxxxpercntdone = baxxzxxrlvxxxxxxxxxxpercntdone;
		this.bgxxuxxrbv18xxxxxxxxrepeatf = bgxxuxxrbv18xxxxxxxxrepeatf;
		this.b5xxztqrlxxxxxxxxxxxqtytotal = b5xxztqrlxxxxxxxxxxxqtytotal;
		this.b6xxzyqrlxxxxxxxxxxxqtyostndt = b6xxzyqrlxxxxxxxxxxxqtyostndt;
		this.b6xxuxcobvxxxxxxxxxxpono = b6xxuxcobvxxxxxxxxxxpono;
		this.b9xxuxxrbvxxxxxxxxxxcpono = b9xxuxxrbvxxxxxxxxxxcpono;
		this.z3xxzzfxhhxxxxxxxxxxstatusfl = z3xxzzfxhhxxxxxxxxxxstatusfl;
		this.z3xxzlpxxvxxxxxxxxxxlinetotl = z3xxzlpxxvxxxxxxxxxxlinetotl;
		this.z4xxutoxlhxxxxxxxxxxowner = z4xxutoxlhxxxxxxxxxxowner;
		this.zzxxu2oxxhxxxxxxxxxxowner2 = zzxxu2oxxhxxxxxxxxxxowner2;
		this.b9xxuxxrbvxxxxxxxxxxjafield1 = b9xxuxxrbvxxxxxxxxxxjafield1;
		this.b9xxuxxrbvxxxxxxxxxxjafield2 = b9xxuxxrbvxxxxxxxxxxjafield2;
		this.b9xxuxxrbvxxxxxxxxxxjafield3 = b9xxuxxrbvxxxxxxxxxxjafield3;
		this.b9xxuxxrbvxxxxxxxxxxjafield4 = b9xxuxxrbvxxxxxxxxxxjafield4;
		this.b9xxuxznbvxxxxxxxxxxnotes = b9xxuxznbvxxxxxxxxxxnotes;
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
	@JoinColumn(name = "location")
	public Fxxxcq144xwwqqhxxxxxlocation getFxxxcq144xwwqqhxxxxxlocation() {
		return this.fxxxcq144xwwqqhxxxxxlocation;
	}

	public void setFxxxcq144xwwqqhxxxxxlocation(
			Fxxxcq144xwwqqhxxxxxlocation fxxxcq144xwwqqhxxxxxlocation) {
		this.fxxxcq144xwwqqhxxxxxlocation = fxxxcq144xwwqqhxxxxxlocation;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "machine")
	public Fpxxuq9eexwwqqhefxxxmachine getFpxxuq9eexwwqqhefxxxmachine() {
		return this.fpxxuq9eexwwqqhefxxxmachine;
	}

	public void setFpxxuq9eexwwqqhefxxxmachine(
			Fpxxuq9eexwwqqhefxxxmachine fpxxuq9eexwwqqhefxxxmachine) {
		this.fpxxuq9eexwwqqhefxxxmachine = fpxxuq9eexwwqqhefxxxmachine;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "jobno")
	public Dxxxuq92bxwwqqhefxxxitemjob getDxxxuq92bxwwqqhefxxxitemjob() {
		return this.dxxxuq92bxwwqqhefxxxitemjob;
	}

	public void setDxxxuq92bxwwqqhefxxxitemjob(
			Dxxxuq92bxwwqqhefxxxitemjob dxxxuq92bxwwqqhefxxxitemjob) {
		this.dxxxuq92bxwwqqhefxxxitemjob = dxxxuq92bxwwqqhefxxxitemjob;
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
	@JoinColumn(name = "jobassign", nullable = false)
	@NotNull
	public Trxxuq9aaxwwqqhefxxxjobassignment getTrxxuq9aaxwwqqhefxxxjobassignment() {
		return this.trxxuq9aaxwwqqhefxxxjobassignment;
	}

	public void setTrxxuq9aaxwwqqhefxxxjobassignment(
			Trxxuq9aaxwwqqhefxxxjobassignment trxxuq9aaxwwqqhefxxxjobassignment) {
		this.trxxuq9aaxwwqqhefxxxjobassignment = trxxuq9aaxwwqqhefxxxjobassignment;
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

	@Column(name = "line")
	public Integer getB1xxzo11bvlxxxxxxxxxline() {
		return this.b1xxzo11bvlxxxxxxxxxline;
	}

	public void setB1xxzo11bvlxxxxxxxxxline(Integer b1xxzo11bvlxxxxxxxxxline) {
		this.b1xxzo11bvlxxxxxxxxxline = b1xxzo11bvlxxxxxxxxxline;
	}

	@Column(name = "sequence", length = 12)
	@Size(max = 12)
	public String getB1xxuxxrbvxxxxxxxxxxsequence() {
		return this.b1xxuxxrbvxxxxxxxxxxsequence;
	}

	public void setB1xxuxxrbvxxxxxxxxxxsequence(
			String b1xxuxxrbvxxxxxxxxxxsequence) {
		this.b1xxuxxrbvxxxxxxxxxxsequence = b1xxuxxrbvxxxxxxxxxxsequence;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "sdatet", length = 29)
	public Date getB5gxdxsdbvxxxxxxxxxxsdatet() {
		return this.b5gxdxsdbvxxxxxxxxxxsdatet;
	}

	public void setB5gxdxsdbvxxxxxxxxxxsdatet(Date b5gxdxsdbvxxxxxxxxxxsdatet) {
		this.b5gxdxsdbvxxxxxxxxxxsdatet = b5gxdxsdbvxxxxxxxxxxsdatet;
	}

	@Column(name = "durationh")
	public Integer getB5xxexdhbvxxxxxxxxxxdurationh() {
		return this.b5xxexdhbvxxxxxxxxxxdurationh;
	}

	public void setB5xxexdhbvxxxxxxxxxxdurationh(
			Integer b5xxexdhbvxxxxxxxxxxdurationh) {
		this.b5xxexdhbvxxxxxxxxxxdurationh = b5xxexdhbvxxxxxxxxxxdurationh;
	}

	@Column(name = "durationm")
	public Integer getB6xx0xdmbvxxxxxxxxxxdurationm() {
		return this.b6xx0xdmbvxxxxxxxxxxdurationm;
	}

	public void setB6xx0xdmbvxxxxxxxxxxdurationm(
			Integer b6xx0xdmbvxxxxxxxxxxdurationm) {
		this.b6xx0xdmbvxxxxxxxxxxdurationm = b6xx0xdmbvxxxxxxxxxxdurationm;
	}

	@Column(name = "stimeh")
	public Integer getB7xxexshbvxxxxxxxxxxstimeh() {
		return this.b7xxexshbvxxxxxxxxxxstimeh;
	}

	public void setB7xxexshbvxxxxxxxxxxstimeh(Integer b7xxexshbvxxxxxxxxxxstimeh) {
		this.b7xxexshbvxxxxxxxxxxstimeh = b7xxexshbvxxxxxxxxxxstimeh;
	}

	@Column(name = "stimem")
	public Integer getB8bx0xsmbvxxxxxxxxxxstimem() {
		return this.b8bx0xsmbvxxxxxxxxxxstimem;
	}

	public void setB8bx0xsmbvxxxxxxxxxxstimem(Integer b8bx0xsmbvxxxxxxxxxxstimem) {
		this.b8bx0xsmbvxxxxxxxxxxstimem = b8bx0xsmbvxxxxxxxxxxstimem;
	}

	@Column(name = "stimeampm")
	public Boolean getB8extxsabvxxxxxxxxxxstimeampm() {
		return this.b8extxsabvxxxxxxxxxxstimeampm;
	}

	public void setB8extxsabvxxxxxxxxxxstimeampm(
			Boolean b8extxsabvxxxxxxxxxxstimeampm) {
		this.b8extxsabvxxxxxxxxxxstimeampm = b8extxsabvxxxxxxxxxxstimeampm;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "edatet", length = 29)
	public Date getB8xxceedbvxxxxxxxxxxedatet() {
		return this.b8xxceedbvxxxxxxxxxxedatet;
	}

	public void setB8xxceedbvxxxxxxxxxxedatet(Date b8xxceedbvxxxxxxxxxxedatet) {
		this.b8xxceedbvxxxxxxxxxxedatet = b8xxceedbvxxxxxxxxxxedatet;
	}

	@Column(name = "priority")
	public Boolean getB9xxfxxxbv08xxxxxxxxpriority() {
		return this.b9xxfxxxbv08xxxxxxxxpriority;
	}

	public void setB9xxfxxxbv08xxxxxxxxpriority(
			Boolean b9xxfxxxbv08xxxxxxxxpriority) {
		this.b9xxfxxxbv08xxxxxxxxpriority = b9xxfxxxbv08xxxxxxxxpriority;
	}

	@Column(name = "percntdone", precision = 14)
	public BigDecimal getBaxxzxxrlvxxxxxxxxxxpercntdone() {
		return this.baxxzxxrlvxxxxxxxxxxpercntdone;
	}

	public void setBaxxzxxrlvxxxxxxxxxxpercntdone(
			BigDecimal baxxzxxrlvxxxxxxxxxxpercntdone) {
		this.baxxzxxrlvxxxxxxxxxxpercntdone = baxxzxxrlvxxxxxxxxxxpercntdone;
	}

	@Column(name = "repeatf", length = 20)
	@Size(max = 20)
	public String getBgxxuxxrbv18xxxxxxxxrepeatf() {
		return this.bgxxuxxrbv18xxxxxxxxrepeatf;
	}

	public void setBgxxuxxrbv18xxxxxxxxrepeatf(
			String bgxxuxxrbv18xxxxxxxxrepeatf) {
		this.bgxxuxxrbv18xxxxxxxxrepeatf = bgxxuxxrbv18xxxxxxxxrepeatf;
	}

	@Column(name = "qtytotal", precision = 14)
	public BigDecimal getB5xxztqrlxxxxxxxxxxxqtytotal() {
		return this.b5xxztqrlxxxxxxxxxxxqtytotal;
	}

	public void setB5xxztqrlxxxxxxxxxxxqtytotal(
			BigDecimal b5xxztqrlxxxxxxxxxxxqtytotal) {
		this.b5xxztqrlxxxxxxxxxxxqtytotal = b5xxztqrlxxxxxxxxxxxqtytotal;
	}

	@Column(name = "qtyostndt", precision = 14)
	public BigDecimal getB6xxzyqrlxxxxxxxxxxxqtyostndt() {
		return this.b6xxzyqrlxxxxxxxxxxxqtyostndt;
	}

	public void setB6xxzyqrlxxxxxxxxxxxqtyostndt(
			BigDecimal b6xxzyqrlxxxxxxxxxxxqtyostndt) {
		this.b6xxzyqrlxxxxxxxxxxxqtyostndt = b6xxzyqrlxxxxxxxxxxxqtyostndt;
	}

	@Column(name = "pono")
	public Integer getB6xxuxcobvxxxxxxxxxxpono() {
		return this.b6xxuxcobvxxxxxxxxxxpono;
	}

	public void setB6xxuxcobvxxxxxxxxxxpono(Integer b6xxuxcobvxxxxxxxxxxpono) {
		this.b6xxuxcobvxxxxxxxxxxpono = b6xxuxcobvxxxxxxxxxxpono;
	}

	@Column(name = "cpono")
	public Integer getB9xxuxxrbvxxxxxxxxxxcpono() {
		return this.b9xxuxxrbvxxxxxxxxxxcpono;
	}

	public void setB9xxuxxrbvxxxxxxxxxxcpono(Integer b9xxuxxrbvxxxxxxxxxxcpono) {
		this.b9xxuxxrbvxxxxxxxxxxcpono = b9xxuxxrbvxxxxxxxxxxcpono;
	}

	@Column(name = "statusfl")
	public Integer getZ3xxzzfxhhxxxxxxxxxxstatusfl() {
		return this.z3xxzzfxhhxxxxxxxxxxstatusfl;
	}

	public void setZ3xxzzfxhhxxxxxxxxxxstatusfl(
			Integer z3xxzzfxhhxxxxxxxxxxstatusfl) {
		this.z3xxzzfxhhxxxxxxxxxxstatusfl = z3xxzzfxhhxxxxxxxxxxstatusfl;
	}

	@Column(name = "linetotl", precision = 14)
	public BigDecimal getZ3xxzlpxxvxxxxxxxxxxlinetotl() {
		return this.z3xxzlpxxvxxxxxxxxxxlinetotl;
	}

	public void setZ3xxzlpxxvxxxxxxxxxxlinetotl(
			BigDecimal z3xxzlpxxvxxxxxxxxxxlinetotl) {
		this.z3xxzlpxxvxxxxxxxxxxlinetotl = z3xxzlpxxvxxxxxxxxxxlinetotl;
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

	@Column(name = "jafield1", length = 60)
	@Size(max = 60)
	public String getB9xxuxxrbvxxxxxxxxxxjafield1() {
		return this.b9xxuxxrbvxxxxxxxxxxjafield1;
	}

	public void setB9xxuxxrbvxxxxxxxxxxjafield1(
			String b9xxuxxrbvxxxxxxxxxxjafield1) {
		this.b9xxuxxrbvxxxxxxxxxxjafield1 = b9xxuxxrbvxxxxxxxxxxjafield1;
	}

	@Column(name = "jafield2", length = 60)
	@Size(max = 60)
	public String getB9xxuxxrbvxxxxxxxxxxjafield2() {
		return this.b9xxuxxrbvxxxxxxxxxxjafield2;
	}

	public void setB9xxuxxrbvxxxxxxxxxxjafield2(
			String b9xxuxxrbvxxxxxxxxxxjafield2) {
		this.b9xxuxxrbvxxxxxxxxxxjafield2 = b9xxuxxrbvxxxxxxxxxxjafield2;
	}

	@Column(name = "jafield3", length = 60)
	@Size(max = 60)
	public String getB9xxuxxrbvxxxxxxxxxxjafield3() {
		return this.b9xxuxxrbvxxxxxxxxxxjafield3;
	}

	public void setB9xxuxxrbvxxxxxxxxxxjafield3(
			String b9xxuxxrbvxxxxxxxxxxjafield3) {
		this.b9xxuxxrbvxxxxxxxxxxjafield3 = b9xxuxxrbvxxxxxxxxxxjafield3;
	}

	@Column(name = "jafield4", length = 60)
	@Size(max = 60)
	public String getB9xxuxxrbvxxxxxxxxxxjafield4() {
		return this.b9xxuxxrbvxxxxxxxxxxjafield4;
	}

	public void setB9xxuxxrbvxxxxxxxxxxjafield4(
			String b9xxuxxrbvxxxxxxxxxxjafield4) {
		this.b9xxuxxrbvxxxxxxxxxxjafield4 = b9xxuxxrbvxxxxxxxxxxjafield4;
	}

	@Column(name = "notes", length = 60)
	@Size(max = 60)
	public String getB9xxuxznbvxxxxxxxxxxnotes() {
		return this.b9xxuxznbvxxxxxxxxxxnotes;
	}

	public void setB9xxuxznbvxxxxxxxxxxnotes(String b9xxuxznbvxxxxxxxxxxnotes) {
		this.b9xxuxznbvxxxxxxxxxxnotes = b9xxuxznbvxxxxxxxxxxnotes;
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
