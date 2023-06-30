package com.rcomputer.genapp.model;
// Generated 30-Jun-2023 1:54:00 PM by Hibernate Tools 4.0.0

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
 * Fxxxuq89bxwwqqhxxxxxschedule generated by hbm2java
 */
@Entity
@XmlRootElement
@Table(name = "schedule")
public class Fxxxuq89bxwwqqhxxxxxschedule implements java.io.Serializable {

	private Integer a0xxuobxbxxxxxxxxxxxsid;
	private Fxxxcq144xwwqqhxxxxxlocation fxxxcq144xwwqqhxxxxxlocation;
	private Jxxxuq300xwwqqhxxxxxvendor jxxxuq300xwwqqhxxxxxvendor;
	private Fxxxuq111xwwqqhxxxxxaddress fxxxuq111xwwqqhxxxxxaddress;
	private Fxxxuq188xwwqqhxxxxxactivity fxxxuq188xwwqqhxxxxxactivity;
	private Jxxxuq201xwwqqhxxxxxcustomer jxxxuq201xwwqqhxxxxxcustomer;
	private Fxxxuq1ggxwwqqhxxxxxmembersgroup fxxxuq1ggxwwqqhxxxxxmembersgroup;
	private Jxxxbh400xwwqqhxxxxxemployee jxxxbh400xwwqqhxxxxxemployee;
	private String a0xxhkscbxxxxxxxxxxxtodo;
	private String b1xxhszsbv35xxxxxxxxdescript;
	private String b2xxuxsxbvxxxxxxxxxxssdatet;
	private Date b5gxdxsdbvxxxxxxxxxxsdatet;
	private Integer b5xxexdhbvxxxxxxxxxxdurationh;
	private Integer b6xx0xdmbvxxxxxxxxxxdurationm;
	private Integer b7xxexshbvxxxxxxxxxxstimeh;
	private Integer b8bx0xsmbvxxxxxxxxxxstimem;
	private Boolean b8extxsabvxxxxxxxxxxstimeampm;
	private Date b8xxceedbvxxxxxxxxxxedatet;
	private Boolean b9xxfxxxbv08xxxxxxxxpriority;
	private BigDecimal baxxzxxrlvxxxxxxxxxxpercntdone;
	private Integer ycxxuxxrbvxxxxxxxxxxvontact;
	private String bexxuxxrbv37xxxxxxxxtype;
	private Integer yfxxuxxrbvxxxxxxxxxxotheremplo;
	private String bgxxuxxrbv18xxxxxxxxrepeatf;
	private Integer z1xxzzfxhhxxxxxxxxxxstatusfl;
	private Date z8xxcztxlxxxxxxxxxxxstatusfldt;
	private Boolean yhxxfxxybvxxxxxxxxxxprivateind;
	private String yhxxuznybvxxxxxxxxxxnotes;
	private String z2xxutoxlhxxxxxxxxxxowner;
	private String zzxxu2oxxhxxxxxxxxxxowner2;
	private String yixxuzdrbvxxxxxxxxxxdocmnt;
	private Set<Xorxeh8cexwwqqhxxxxxscheduledetails> xorxeh8cexwwqqhxxxxxscheduledetailses = new HashSet<Xorxeh8cexwwqqhxxxxxscheduledetails>(
			0);

	public Fxxxuq89bxwwqqhxxxxxschedule() {
	}

	public Fxxxuq89bxwwqqhxxxxxschedule(String a0xxhkscbxxxxxxxxxxxtodo) {
		this.a0xxhkscbxxxxxxxxxxxtodo = a0xxhkscbxxxxxxxxxxxtodo;
	}
	public Fxxxuq89bxwwqqhxxxxxschedule(
			Fxxxcq144xwwqqhxxxxxlocation fxxxcq144xwwqqhxxxxxlocation,
			Jxxxuq300xwwqqhxxxxxvendor jxxxuq300xwwqqhxxxxxvendor,
			Fxxxuq111xwwqqhxxxxxaddress fxxxuq111xwwqqhxxxxxaddress,
			Fxxxuq188xwwqqhxxxxxactivity fxxxuq188xwwqqhxxxxxactivity,
			Jxxxuq201xwwqqhxxxxxcustomer jxxxuq201xwwqqhxxxxxcustomer,
			Fxxxuq1ggxwwqqhxxxxxmembersgroup fxxxuq1ggxwwqqhxxxxxmembersgroup,
			Jxxxbh400xwwqqhxxxxxemployee jxxxbh400xwwqqhxxxxxemployee,
			String a0xxhkscbxxxxxxxxxxxtodo,
			String b1xxhszsbv35xxxxxxxxdescript,
			String b2xxuxsxbvxxxxxxxxxxssdatet,
			Date b5gxdxsdbvxxxxxxxxxxsdatet,
			Integer b5xxexdhbvxxxxxxxxxxdurationh,
			Integer b6xx0xdmbvxxxxxxxxxxdurationm,
			Integer b7xxexshbvxxxxxxxxxxstimeh,
			Integer b8bx0xsmbvxxxxxxxxxxstimem,
			Boolean b8extxsabvxxxxxxxxxxstimeampm,
			Date b8xxceedbvxxxxxxxxxxedatet,
			Boolean b9xxfxxxbv08xxxxxxxxpriority,
			BigDecimal baxxzxxrlvxxxxxxxxxxpercntdone,
			Integer ycxxuxxrbvxxxxxxxxxxvontact,
			String bexxuxxrbv37xxxxxxxxtype,
			Integer yfxxuxxrbvxxxxxxxxxxotheremplo,
			String bgxxuxxrbv18xxxxxxxxrepeatf,
			Integer z1xxzzfxhhxxxxxxxxxxstatusfl,
			Date z8xxcztxlxxxxxxxxxxxstatusfldt,
			Boolean yhxxfxxybvxxxxxxxxxxprivateind,
			String yhxxuznybvxxxxxxxxxxnotes,
			String z2xxutoxlhxxxxxxxxxxowner,
			String zzxxu2oxxhxxxxxxxxxxowner2,
			String yixxuzdrbvxxxxxxxxxxdocmnt,
			Set<Xorxeh8cexwwqqhxxxxxscheduledetails> xorxeh8cexwwqqhxxxxxscheduledetailses) {
		this.fxxxcq144xwwqqhxxxxxlocation = fxxxcq144xwwqqhxxxxxlocation;
		this.jxxxuq300xwwqqhxxxxxvendor = jxxxuq300xwwqqhxxxxxvendor;
		this.fxxxuq111xwwqqhxxxxxaddress = fxxxuq111xwwqqhxxxxxaddress;
		this.fxxxuq188xwwqqhxxxxxactivity = fxxxuq188xwwqqhxxxxxactivity;
		this.jxxxuq201xwwqqhxxxxxcustomer = jxxxuq201xwwqqhxxxxxcustomer;
		this.fxxxuq1ggxwwqqhxxxxxmembersgroup = fxxxuq1ggxwwqqhxxxxxmembersgroup;
		this.jxxxbh400xwwqqhxxxxxemployee = jxxxbh400xwwqqhxxxxxemployee;
		this.a0xxhkscbxxxxxxxxxxxtodo = a0xxhkscbxxxxxxxxxxxtodo;
		this.b1xxhszsbv35xxxxxxxxdescript = b1xxhszsbv35xxxxxxxxdescript;
		this.b2xxuxsxbvxxxxxxxxxxssdatet = b2xxuxsxbvxxxxxxxxxxssdatet;
		this.b5gxdxsdbvxxxxxxxxxxsdatet = b5gxdxsdbvxxxxxxxxxxsdatet;
		this.b5xxexdhbvxxxxxxxxxxdurationh = b5xxexdhbvxxxxxxxxxxdurationh;
		this.b6xx0xdmbvxxxxxxxxxxdurationm = b6xx0xdmbvxxxxxxxxxxdurationm;
		this.b7xxexshbvxxxxxxxxxxstimeh = b7xxexshbvxxxxxxxxxxstimeh;
		this.b8bx0xsmbvxxxxxxxxxxstimem = b8bx0xsmbvxxxxxxxxxxstimem;
		this.b8extxsabvxxxxxxxxxxstimeampm = b8extxsabvxxxxxxxxxxstimeampm;
		this.b8xxceedbvxxxxxxxxxxedatet = b8xxceedbvxxxxxxxxxxedatet;
		this.b9xxfxxxbv08xxxxxxxxpriority = b9xxfxxxbv08xxxxxxxxpriority;
		this.baxxzxxrlvxxxxxxxxxxpercntdone = baxxzxxrlvxxxxxxxxxxpercntdone;
		this.ycxxuxxrbvxxxxxxxxxxvontact = ycxxuxxrbvxxxxxxxxxxvontact;
		this.bexxuxxrbv37xxxxxxxxtype = bexxuxxrbv37xxxxxxxxtype;
		this.yfxxuxxrbvxxxxxxxxxxotheremplo = yfxxuxxrbvxxxxxxxxxxotheremplo;
		this.bgxxuxxrbv18xxxxxxxxrepeatf = bgxxuxxrbv18xxxxxxxxrepeatf;
		this.z1xxzzfxhhxxxxxxxxxxstatusfl = z1xxzzfxhhxxxxxxxxxxstatusfl;
		this.z8xxcztxlxxxxxxxxxxxstatusfldt = z8xxcztxlxxxxxxxxxxxstatusfldt;
		this.yhxxfxxybvxxxxxxxxxxprivateind = yhxxfxxybvxxxxxxxxxxprivateind;
		this.yhxxuznybvxxxxxxxxxxnotes = yhxxuznybvxxxxxxxxxxnotes;
		this.z2xxutoxlhxxxxxxxxxxowner = z2xxutoxlhxxxxxxxxxxowner;
		this.zzxxu2oxxhxxxxxxxxxxowner2 = zzxxu2oxxhxxxxxxxxxxowner2;
		this.yixxuzdrbvxxxxxxxxxxdocmnt = yixxuzdrbvxxxxxxxxxxdocmnt;
		this.xorxeh8cexwwqqhxxxxxscheduledetailses = xorxeh8cexwwqqhxxxxxscheduledetailses;
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
	@JoinColumn(name = "vendor")
	public Jxxxuq300xwwqqhxxxxxvendor getJxxxuq300xwwqqhxxxxxvendor() {
		return this.jxxxuq300xwwqqhxxxxxvendor;
	}

	public void setJxxxuq300xwwqqhxxxxxvendor(
			Jxxxuq300xwwqqhxxxxxvendor jxxxuq300xwwqqhxxxxxvendor) {
		this.jxxxuq300xwwqqhxxxxxvendor = jxxxuq300xwwqqhxxxxxvendor;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "mailtocode")
	public Fxxxuq111xwwqqhxxxxxaddress getFxxxuq111xwwqqhxxxxxaddress() {
		return this.fxxxuq111xwwqqhxxxxxaddress;
	}

	public void setFxxxuq111xwwqqhxxxxxaddress(
			Fxxxuq111xwwqqhxxxxxaddress fxxxuq111xwwqqhxxxxxaddress) {
		this.fxxxuq111xwwqqhxxxxxaddress = fxxxuq111xwwqqhxxxxxaddress;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "activitycode")
	public Fxxxuq188xwwqqhxxxxxactivity getFxxxuq188xwwqqhxxxxxactivity() {
		return this.fxxxuq188xwwqqhxxxxxactivity;
	}

	public void setFxxxuq188xwwqqhxxxxxactivity(
			Fxxxuq188xwwqqhxxxxxactivity fxxxuq188xwwqqhxxxxxactivity) {
		this.fxxxuq188xwwqqhxxxxxactivity = fxxxuq188xwwqqhxxxxxactivity;
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
	@JoinColumn(name = "mgroup")
	public Fxxxuq1ggxwwqqhxxxxxmembersgroup getFxxxuq1ggxwwqqhxxxxxmembersgroup() {
		return this.fxxxuq1ggxwwqqhxxxxxmembersgroup;
	}

	public void setFxxxuq1ggxwwqqhxxxxxmembersgroup(
			Fxxxuq1ggxwwqqhxxxxxmembersgroup fxxxuq1ggxwwqqhxxxxxmembersgroup) {
		this.fxxxuq1ggxwwqqhxxxxxmembersgroup = fxxxuq1ggxwwqqhxxxxxmembersgroup;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "employee")
	public Jxxxbh400xwwqqhxxxxxemployee getJxxxbh400xwwqqhxxxxxemployee() {
		return this.jxxxbh400xwwqqhxxxxxemployee;
	}

	public void setJxxxbh400xwwqqhxxxxxemployee(
			Jxxxbh400xwwqqhxxxxxemployee jxxxbh400xwwqqhxxxxxemployee) {
		this.jxxxbh400xwwqqhxxxxxemployee = jxxxbh400xwwqqhxxxxxemployee;
	}

	@Column(name = "todo", nullable = false, length = 35)
	@NotNull
	@Size(max = 35)
	public String getA0xxhkscbxxxxxxxxxxxtodo() {
		return this.a0xxhkscbxxxxxxxxxxxtodo;
	}

	public void setA0xxhkscbxxxxxxxxxxxtodo(String a0xxhkscbxxxxxxxxxxxtodo) {
		this.a0xxhkscbxxxxxxxxxxxtodo = a0xxhkscbxxxxxxxxxxxtodo;
	}

	@Column(name = "descript", length = 120)
	@Size(max = 120)
	public String getB1xxhszsbv35xxxxxxxxdescript() {
		return this.b1xxhszsbv35xxxxxxxxdescript;
	}

	public void setB1xxhszsbv35xxxxxxxxdescript(
			String b1xxhszsbv35xxxxxxxxdescript) {
		this.b1xxhszsbv35xxxxxxxxdescript = b1xxhszsbv35xxxxxxxxdescript;
	}

	@Column(name = "ssdatet", length = 30)
	@Size(max = 30)
	public String getB2xxuxsxbvxxxxxxxxxxssdatet() {
		return this.b2xxuxsxbvxxxxxxxxxxssdatet;
	}

	public void setB2xxuxsxbvxxxxxxxxxxssdatet(
			String b2xxuxsxbvxxxxxxxxxxssdatet) {
		this.b2xxuxsxbvxxxxxxxxxxssdatet = b2xxuxsxbvxxxxxxxxxxssdatet;
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

	@Column(name = "vontact")
	public Integer getYcxxuxxrbvxxxxxxxxxxvontact() {
		return this.ycxxuxxrbvxxxxxxxxxxvontact;
	}

	public void setYcxxuxxrbvxxxxxxxxxxvontact(
			Integer ycxxuxxrbvxxxxxxxxxxvontact) {
		this.ycxxuxxrbvxxxxxxxxxxvontact = ycxxuxxrbvxxxxxxxxxxvontact;
	}

	@Column(name = "type", length = 20)
	@Size(max = 20)
	public String getBexxuxxrbv37xxxxxxxxtype() {
		return this.bexxuxxrbv37xxxxxxxxtype;
	}

	public void setBexxuxxrbv37xxxxxxxxtype(String bexxuxxrbv37xxxxxxxxtype) {
		this.bexxuxxrbv37xxxxxxxxtype = bexxuxxrbv37xxxxxxxxtype;
	}

	@Column(name = "otheremplo")
	public Integer getYfxxuxxrbvxxxxxxxxxxotheremplo() {
		return this.yfxxuxxrbvxxxxxxxxxxotheremplo;
	}

	public void setYfxxuxxrbvxxxxxxxxxxotheremplo(
			Integer yfxxuxxrbvxxxxxxxxxxotheremplo) {
		this.yfxxuxxrbvxxxxxxxxxxotheremplo = yfxxuxxrbvxxxxxxxxxxotheremplo;
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
	public Date getZ8xxcztxlxxxxxxxxxxxstatusfldt() {
		return this.z8xxcztxlxxxxxxxxxxxstatusfldt;
	}

	public void setZ8xxcztxlxxxxxxxxxxxstatusfldt(
			Date z8xxcztxlxxxxxxxxxxxstatusfldt) {
		this.z8xxcztxlxxxxxxxxxxxstatusfldt = z8xxcztxlxxxxxxxxxxxstatusfldt;
	}

	@Column(name = "privateind")
	public Boolean getYhxxfxxybvxxxxxxxxxxprivateind() {
		return this.yhxxfxxybvxxxxxxxxxxprivateind;
	}

	public void setYhxxfxxybvxxxxxxxxxxprivateind(
			Boolean yhxxfxxybvxxxxxxxxxxprivateind) {
		this.yhxxfxxybvxxxxxxxxxxprivateind = yhxxfxxybvxxxxxxxxxxprivateind;
	}

	@Column(name = "notes", length = 60)
	@Size(max = 60)
	public String getYhxxuznybvxxxxxxxxxxnotes() {
		return this.yhxxuznybvxxxxxxxxxxnotes;
	}

	public void setYhxxuznybvxxxxxxxxxxnotes(String yhxxuznybvxxxxxxxxxxnotes) {
		this.yhxxuznybvxxxxxxxxxxnotes = yhxxuznybvxxxxxxxxxxnotes;
	}

	@Column(name = "owner", length = 40)
	@Size(max = 40)
	public String getZ2xxutoxlhxxxxxxxxxxowner() {
		return this.z2xxutoxlhxxxxxxxxxxowner;
	}

	public void setZ2xxutoxlhxxxxxxxxxxowner(String z2xxutoxlhxxxxxxxxxxowner) {
		this.z2xxutoxlhxxxxxxxxxxowner = z2xxutoxlhxxxxxxxxxxowner;
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
	public String getYixxuzdrbvxxxxxxxxxxdocmnt() {
		return this.yixxuzdrbvxxxxxxxxxxdocmnt;
	}

	public void setYixxuzdrbvxxxxxxxxxxdocmnt(String yixxuzdrbvxxxxxxxxxxdocmnt) {
		this.yixxuzdrbvxxxxxxxxxxdocmnt = yixxuzdrbvxxxxxxxxxxdocmnt;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "fxxxuq89bxwwqqhxxxxxschedule")
	public Set<Xorxeh8cexwwqqhxxxxxscheduledetails> getXorxeh8cexwwqqhxxxxxscheduledetailses() {
		return this.xorxeh8cexwwqqhxxxxxscheduledetailses;
	}

	public void setXorxeh8cexwwqqhxxxxxscheduledetailses(
			Set<Xorxeh8cexwwqqhxxxxxscheduledetails> xorxeh8cexwwqqhxxxxxscheduledetailses) {
		this.xorxeh8cexwwqqhxxxxxscheduledetailses = xorxeh8cexwwqqhxxxxxscheduledetailses;
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
