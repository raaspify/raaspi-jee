package com.rcomputer.genapp.model;
// Generated 30-Jun-2023 1:54:00 PM by Hibernate Tools 4.0.0

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
 * Fxxxcq144xwwqqhxxxxxlocation generated by hbm2java
 */
@Entity
@XmlRootElement
@Table(name = "location")
public class Fxxxcq144xwwqqhxxxxxlocation implements java.io.Serializable {

	private Integer a0xxuobxbxxxxxxxxxxxsid;
	private Fxxxuq111xwwqqhxxxxxaddress fxxxuq111xwwqqhxxxxxaddress;
	private Dxxxch1d3xwwqqhxxlxxcompany dxxxch1d3xwwqqhxxlxxcompany;
	private String a0xxukxxbvxxxxxxxxxxlocation;
	private String b1xxuszsbvxxxxxxxxxxdescript;
	private String b5xxhxxxbv31xxxxxxxxfloor;
	private String b6xxhxxxbv32xxxxxxxxroom;
	private String b7xxhxxxbv33xxxxxxxxrack;
	private Integer b8xxzzprhvxxxxxxxxxxprintmstat;
	private Date b9xxczqxlhxxxxxxxxxxprinmtfldt;
	private Boolean c1xxfxxxbvxxxxxxxxxxexclude;
	private Integer z2xxzzfxhhxxxxxxxxxxstatusfl;
	private Date z3xxcztxlxxxxxxxxxxxstatusfldt;
	private String z4xxuznxbvxxxxxxxxxxnotes;
	private String z5xxutoxlhxxxxxxxxxxowner;
	private String zzxxu2oxxhxxxxxxxxxxowner2;
	private Set<Jxxxuq31bxwwqqhxxxxxvcontact> jxxxuq31bxwwqqhxxxxxvcontacts = new HashSet<Jxxxuq31bxwwqqhxxxxxvcontact>(
			0);
	private Set<Trxxuq9aaxwwqqhefxxxjobassignment> trxxuq9aaxwwqqhefxxxjobassignments = new HashSet<Trxxuq9aaxwwqqhefxxxjobassignment>(
			0);
	private Set<Fxxxuq1skxwwqqhxxxxxseat> fxxxuq1skxwwqqhxxxxxseats = new HashSet<Fxxxuq1skxwwqqhxxxxxseat>(
			0);
	private Set<Fxxxuq89bxwwqqhxxxxxschedule> fxxxuq89bxwwqqhxxxxxschedules = new HashSet<Fxxxuq89bxwwqqhxxxxxschedule>(
			0);
	private Set<Jxxxuq201xwwqqhxxxxxcustomer> jxxxuq201xwwqqhxxxxxcustomers = new HashSet<Jxxxuq201xwwqqhxxxxxcustomer>(
			0);
	private Set<Xoxxuq9bfxwwqqhexxxxjobassignmentdetails> xoxxuq9bfxwwqqhexxxxjobassignmentdetailses = new HashSet<Xoxxuq9bfxwwqqhexxxxjobassignmentdetails>(
			0);
	private Set<Jxxxuq300xwwqqhxxxxxvendor> jxxxuq300xwwqqhxxxxxvendors = new HashSet<Jxxxuq300xwwqqhxxxxxvendor>(
			0);
	private Set<Jxxxbh400xwwqqhxxxxxemployee> jxxxbh400xwwqqhxxxxxemployees = new HashSet<Jxxxbh400xwwqqhxxxxxemployee>(
			0);
	private Set<Jxxxuq21bxwwqqhxxxxxccontact> jxxxuq21bxwwqqhxxxxxccontacts = new HashSet<Jxxxuq21bxwwqqhxxxxxccontact>(
			0);
	private Set<Fpxxfq1a5xwwqqhxxxxxitem> fpxxfq1a5xwwqqhxxxxxitems = new HashSet<Fpxxfq1a5xwwqqhxxxxxitem>(
			0);

	public Fxxxcq144xwwqqhxxxxxlocation() {
	}

	public Fxxxcq144xwwqqhxxxxxlocation(String a0xxukxxbvxxxxxxxxxxlocation) {
		this.a0xxukxxbvxxxxxxxxxxlocation = a0xxukxxbvxxxxxxxxxxlocation;
	}
	public Fxxxcq144xwwqqhxxxxxlocation(
			Fxxxuq111xwwqqhxxxxxaddress fxxxuq111xwwqqhxxxxxaddress,
			Dxxxch1d3xwwqqhxxlxxcompany dxxxch1d3xwwqqhxxlxxcompany,
			String a0xxukxxbvxxxxxxxxxxlocation,
			String b1xxuszsbvxxxxxxxxxxdescript,
			String b5xxhxxxbv31xxxxxxxxfloor,
			String b6xxhxxxbv32xxxxxxxxroom,
			String b7xxhxxxbv33xxxxxxxxrack,
			Integer b8xxzzprhvxxxxxxxxxxprintmstat,
			Date b9xxczqxlhxxxxxxxxxxprinmtfldt,
			Boolean c1xxfxxxbvxxxxxxxxxxexclude,
			Integer z2xxzzfxhhxxxxxxxxxxstatusfl,
			Date z3xxcztxlxxxxxxxxxxxstatusfldt,
			String z4xxuznxbvxxxxxxxxxxnotes,
			String z5xxutoxlhxxxxxxxxxxowner,
			String zzxxu2oxxhxxxxxxxxxxowner2,
			Set<Jxxxuq31bxwwqqhxxxxxvcontact> jxxxuq31bxwwqqhxxxxxvcontacts,
			Set<Trxxuq9aaxwwqqhefxxxjobassignment> trxxuq9aaxwwqqhefxxxjobassignments,
			Set<Fxxxuq1skxwwqqhxxxxxseat> fxxxuq1skxwwqqhxxxxxseats,
			Set<Fxxxuq89bxwwqqhxxxxxschedule> fxxxuq89bxwwqqhxxxxxschedules,
			Set<Jxxxuq201xwwqqhxxxxxcustomer> jxxxuq201xwwqqhxxxxxcustomers,
			Set<Xoxxuq9bfxwwqqhexxxxjobassignmentdetails> xoxxuq9bfxwwqqhexxxxjobassignmentdetailses,
			Set<Jxxxuq300xwwqqhxxxxxvendor> jxxxuq300xwwqqhxxxxxvendors,
			Set<Jxxxbh400xwwqqhxxxxxemployee> jxxxbh400xwwqqhxxxxxemployees,
			Set<Jxxxuq21bxwwqqhxxxxxccontact> jxxxuq21bxwwqqhxxxxxccontacts,
			Set<Fpxxfq1a5xwwqqhxxxxxitem> fpxxfq1a5xwwqqhxxxxxitems) {
		this.fxxxuq111xwwqqhxxxxxaddress = fxxxuq111xwwqqhxxxxxaddress;
		this.dxxxch1d3xwwqqhxxlxxcompany = dxxxch1d3xwwqqhxxlxxcompany;
		this.a0xxukxxbvxxxxxxxxxxlocation = a0xxukxxbvxxxxxxxxxxlocation;
		this.b1xxuszsbvxxxxxxxxxxdescript = b1xxuszsbvxxxxxxxxxxdescript;
		this.b5xxhxxxbv31xxxxxxxxfloor = b5xxhxxxbv31xxxxxxxxfloor;
		this.b6xxhxxxbv32xxxxxxxxroom = b6xxhxxxbv32xxxxxxxxroom;
		this.b7xxhxxxbv33xxxxxxxxrack = b7xxhxxxbv33xxxxxxxxrack;
		this.b8xxzzprhvxxxxxxxxxxprintmstat = b8xxzzprhvxxxxxxxxxxprintmstat;
		this.b9xxczqxlhxxxxxxxxxxprinmtfldt = b9xxczqxlhxxxxxxxxxxprinmtfldt;
		this.c1xxfxxxbvxxxxxxxxxxexclude = c1xxfxxxbvxxxxxxxxxxexclude;
		this.z2xxzzfxhhxxxxxxxxxxstatusfl = z2xxzzfxhhxxxxxxxxxxstatusfl;
		this.z3xxcztxlxxxxxxxxxxxstatusfldt = z3xxcztxlxxxxxxxxxxxstatusfldt;
		this.z4xxuznxbvxxxxxxxxxxnotes = z4xxuznxbvxxxxxxxxxxnotes;
		this.z5xxutoxlhxxxxxxxxxxowner = z5xxutoxlhxxxxxxxxxxowner;
		this.zzxxu2oxxhxxxxxxxxxxowner2 = zzxxu2oxxhxxxxxxxxxxowner2;
		this.jxxxuq31bxwwqqhxxxxxvcontacts = jxxxuq31bxwwqqhxxxxxvcontacts;
		this.trxxuq9aaxwwqqhefxxxjobassignments = trxxuq9aaxwwqqhefxxxjobassignments;
		this.fxxxuq1skxwwqqhxxxxxseats = fxxxuq1skxwwqqhxxxxxseats;
		this.fxxxuq89bxwwqqhxxxxxschedules = fxxxuq89bxwwqqhxxxxxschedules;
		this.jxxxuq201xwwqqhxxxxxcustomers = jxxxuq201xwwqqhxxxxxcustomers;
		this.xoxxuq9bfxwwqqhexxxxjobassignmentdetailses = xoxxuq9bfxwwqqhexxxxjobassignmentdetailses;
		this.jxxxuq300xwwqqhxxxxxvendors = jxxxuq300xwwqqhxxxxxvendors;
		this.jxxxbh400xwwqqhxxxxxemployees = jxxxbh400xwwqqhxxxxxemployees;
		this.jxxxuq21bxwwqqhxxxxxccontacts = jxxxuq21bxwwqqhxxxxxccontacts;
		this.fpxxfq1a5xwwqqhxxxxxitems = fpxxfq1a5xwwqqhxxxxxitems;
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
	@JoinColumn(name = "addresscode")
	public Fxxxuq111xwwqqhxxxxxaddress getFxxxuq111xwwqqhxxxxxaddress() {
		return this.fxxxuq111xwwqqhxxxxxaddress;
	}

	public void setFxxxuq111xwwqqhxxxxxaddress(
			Fxxxuq111xwwqqhxxxxxaddress fxxxuq111xwwqqhxxxxxaddress) {
		this.fxxxuq111xwwqqhxxxxxaddress = fxxxuq111xwwqqhxxxxxaddress;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "companycode")
	public Dxxxch1d3xwwqqhxxlxxcompany getDxxxch1d3xwwqqhxxlxxcompany() {
		return this.dxxxch1d3xwwqqhxxlxxcompany;
	}

	public void setDxxxch1d3xwwqqhxxlxxcompany(
			Dxxxch1d3xwwqqhxxlxxcompany dxxxch1d3xwwqqhxxlxxcompany) {
		this.dxxxch1d3xwwqqhxxlxxcompany = dxxxch1d3xwwqqhxxlxxcompany;
	}

	@Column(name = "location", nullable = false, length = 32)
	@NotNull
	@Size(max = 32)
	public String getA0xxukxxbvxxxxxxxxxxlocation() {
		return this.a0xxukxxbvxxxxxxxxxxlocation;
	}

	public void setA0xxukxxbvxxxxxxxxxxlocation(
			String a0xxukxxbvxxxxxxxxxxlocation) {
		this.a0xxukxxbvxxxxxxxxxxlocation = a0xxukxxbvxxxxxxxxxxlocation;
	}

	@Column(name = "descript", length = 120)
	@Size(max = 120)
	public String getB1xxuszsbvxxxxxxxxxxdescript() {
		return this.b1xxuszsbvxxxxxxxxxxdescript;
	}

	public void setB1xxuszsbvxxxxxxxxxxdescript(
			String b1xxuszsbvxxxxxxxxxxdescript) {
		this.b1xxuszsbvxxxxxxxxxxdescript = b1xxuszsbvxxxxxxxxxxdescript;
	}

	@Column(name = "floor", length = 25)
	@Size(max = 25)
	public String getB5xxhxxxbv31xxxxxxxxfloor() {
		return this.b5xxhxxxbv31xxxxxxxxfloor;
	}

	public void setB5xxhxxxbv31xxxxxxxxfloor(String b5xxhxxxbv31xxxxxxxxfloor) {
		this.b5xxhxxxbv31xxxxxxxxfloor = b5xxhxxxbv31xxxxxxxxfloor;
	}

	@Column(name = "room", length = 25)
	@Size(max = 25)
	public String getB6xxhxxxbv32xxxxxxxxroom() {
		return this.b6xxhxxxbv32xxxxxxxxroom;
	}

	public void setB6xxhxxxbv32xxxxxxxxroom(String b6xxhxxxbv32xxxxxxxxroom) {
		this.b6xxhxxxbv32xxxxxxxxroom = b6xxhxxxbv32xxxxxxxxroom;
	}

	@Column(name = "rack", length = 25)
	@Size(max = 25)
	public String getB7xxhxxxbv33xxxxxxxxrack() {
		return this.b7xxhxxxbv33xxxxxxxxrack;
	}

	public void setB7xxhxxxbv33xxxxxxxxrack(String b7xxhxxxbv33xxxxxxxxrack) {
		this.b7xxhxxxbv33xxxxxxxxrack = b7xxhxxxbv33xxxxxxxxrack;
	}

	@Column(name = "printmstat")
	public Integer getB8xxzzprhvxxxxxxxxxxprintmstat() {
		return this.b8xxzzprhvxxxxxxxxxxprintmstat;
	}

	public void setB8xxzzprhvxxxxxxxxxxprintmstat(
			Integer b8xxzzprhvxxxxxxxxxxprintmstat) {
		this.b8xxzzprhvxxxxxxxxxxprintmstat = b8xxzzprhvxxxxxxxxxxprintmstat;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "prinmtfldt", length = 29)
	public Date getB9xxczqxlhxxxxxxxxxxprinmtfldt() {
		return this.b9xxczqxlhxxxxxxxxxxprinmtfldt;
	}

	public void setB9xxczqxlhxxxxxxxxxxprinmtfldt(
			Date b9xxczqxlhxxxxxxxxxxprinmtfldt) {
		this.b9xxczqxlhxxxxxxxxxxprinmtfldt = b9xxczqxlhxxxxxxxxxxprinmtfldt;
	}

	@Column(name = "exclude")
	public Boolean getC1xxfxxxbvxxxxxxxxxxexclude() {
		return this.c1xxfxxxbvxxxxxxxxxxexclude;
	}

	public void setC1xxfxxxbvxxxxxxxxxxexclude(
			Boolean c1xxfxxxbvxxxxxxxxxxexclude) {
		this.c1xxfxxxbvxxxxxxxxxxexclude = c1xxfxxxbvxxxxxxxxxxexclude;
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
	public String getZ4xxuznxbvxxxxxxxxxxnotes() {
		return this.z4xxuznxbvxxxxxxxxxxnotes;
	}

	public void setZ4xxuznxbvxxxxxxxxxxnotes(String z4xxuznxbvxxxxxxxxxxnotes) {
		this.z4xxuznxbvxxxxxxxxxxnotes = z4xxuznxbvxxxxxxxxxxnotes;
	}

	@Column(name = "owner", length = 40)
	@Size(max = 40)
	public String getZ5xxutoxlhxxxxxxxxxxowner() {
		return this.z5xxutoxlhxxxxxxxxxxowner;
	}

	public void setZ5xxutoxlhxxxxxxxxxxowner(String z5xxutoxlhxxxxxxxxxxowner) {
		this.z5xxutoxlhxxxxxxxxxxowner = z5xxutoxlhxxxxxxxxxxowner;
	}

	@Column(name = "owner2", length = 40)
	@Size(max = 40)
	public String getZzxxu2oxxhxxxxxxxxxxowner2() {
		return this.zzxxu2oxxhxxxxxxxxxxowner2;
	}

	public void setZzxxu2oxxhxxxxxxxxxxowner2(String zzxxu2oxxhxxxxxxxxxxowner2) {
		this.zzxxu2oxxhxxxxxxxxxxowner2 = zzxxu2oxxhxxxxxxxxxxowner2;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "fxxxcq144xwwqqhxxxxxlocation")
	public Set<Jxxxuq31bxwwqqhxxxxxvcontact> getJxxxuq31bxwwqqhxxxxxvcontacts() {
		return this.jxxxuq31bxwwqqhxxxxxvcontacts;
	}

	public void setJxxxuq31bxwwqqhxxxxxvcontacts(
			Set<Jxxxuq31bxwwqqhxxxxxvcontact> jxxxuq31bxwwqqhxxxxxvcontacts) {
		this.jxxxuq31bxwwqqhxxxxxvcontacts = jxxxuq31bxwwqqhxxxxxvcontacts;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "fxxxcq144xwwqqhxxxxxlocation")
	public Set<Trxxuq9aaxwwqqhefxxxjobassignment> getTrxxuq9aaxwwqqhefxxxjobassignments() {
		return this.trxxuq9aaxwwqqhefxxxjobassignments;
	}

	public void setTrxxuq9aaxwwqqhefxxxjobassignments(
			Set<Trxxuq9aaxwwqqhefxxxjobassignment> trxxuq9aaxwwqqhefxxxjobassignments) {
		this.trxxuq9aaxwwqqhefxxxjobassignments = trxxuq9aaxwwqqhefxxxjobassignments;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "fxxxcq144xwwqqhxxxxxlocation")
	public Set<Fxxxuq1skxwwqqhxxxxxseat> getFxxxuq1skxwwqqhxxxxxseats() {
		return this.fxxxuq1skxwwqqhxxxxxseats;
	}

	public void setFxxxuq1skxwwqqhxxxxxseats(
			Set<Fxxxuq1skxwwqqhxxxxxseat> fxxxuq1skxwwqqhxxxxxseats) {
		this.fxxxuq1skxwwqqhxxxxxseats = fxxxuq1skxwwqqhxxxxxseats;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "fxxxcq144xwwqqhxxxxxlocation")
	public Set<Fxxxuq89bxwwqqhxxxxxschedule> getFxxxuq89bxwwqqhxxxxxschedules() {
		return this.fxxxuq89bxwwqqhxxxxxschedules;
	}

	public void setFxxxuq89bxwwqqhxxxxxschedules(
			Set<Fxxxuq89bxwwqqhxxxxxschedule> fxxxuq89bxwwqqhxxxxxschedules) {
		this.fxxxuq89bxwwqqhxxxxxschedules = fxxxuq89bxwwqqhxxxxxschedules;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "fxxxcq144xwwqqhxxxxxlocation")
	public Set<Jxxxuq201xwwqqhxxxxxcustomer> getJxxxuq201xwwqqhxxxxxcustomers() {
		return this.jxxxuq201xwwqqhxxxxxcustomers;
	}

	public void setJxxxuq201xwwqqhxxxxxcustomers(
			Set<Jxxxuq201xwwqqhxxxxxcustomer> jxxxuq201xwwqqhxxxxxcustomers) {
		this.jxxxuq201xwwqqhxxxxxcustomers = jxxxuq201xwwqqhxxxxxcustomers;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "fxxxcq144xwwqqhxxxxxlocation")
	public Set<Xoxxuq9bfxwwqqhexxxxjobassignmentdetails> getXoxxuq9bfxwwqqhexxxxjobassignmentdetailses() {
		return this.xoxxuq9bfxwwqqhexxxxjobassignmentdetailses;
	}

	public void setXoxxuq9bfxwwqqhexxxxjobassignmentdetailses(
			Set<Xoxxuq9bfxwwqqhexxxxjobassignmentdetails> xoxxuq9bfxwwqqhexxxxjobassignmentdetailses) {
		this.xoxxuq9bfxwwqqhexxxxjobassignmentdetailses = xoxxuq9bfxwwqqhexxxxjobassignmentdetailses;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "fxxxcq144xwwqqhxxxxxlocation")
	public Set<Jxxxuq300xwwqqhxxxxxvendor> getJxxxuq300xwwqqhxxxxxvendors() {
		return this.jxxxuq300xwwqqhxxxxxvendors;
	}

	public void setJxxxuq300xwwqqhxxxxxvendors(
			Set<Jxxxuq300xwwqqhxxxxxvendor> jxxxuq300xwwqqhxxxxxvendors) {
		this.jxxxuq300xwwqqhxxxxxvendors = jxxxuq300xwwqqhxxxxxvendors;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "fxxxcq144xwwqqhxxxxxlocation")
	public Set<Jxxxbh400xwwqqhxxxxxemployee> getJxxxbh400xwwqqhxxxxxemployees() {
		return this.jxxxbh400xwwqqhxxxxxemployees;
	}

	public void setJxxxbh400xwwqqhxxxxxemployees(
			Set<Jxxxbh400xwwqqhxxxxxemployee> jxxxbh400xwwqqhxxxxxemployees) {
		this.jxxxbh400xwwqqhxxxxxemployees = jxxxbh400xwwqqhxxxxxemployees;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "fxxxcq144xwwqqhxxxxxlocation")
	public Set<Jxxxuq21bxwwqqhxxxxxccontact> getJxxxuq21bxwwqqhxxxxxccontacts() {
		return this.jxxxuq21bxwwqqhxxxxxccontacts;
	}

	public void setJxxxuq21bxwwqqhxxxxxccontacts(
			Set<Jxxxuq21bxwwqqhxxxxxccontact> jxxxuq21bxwwqqhxxxxxccontacts) {
		this.jxxxuq21bxwwqqhxxxxxccontacts = jxxxuq21bxwwqqhxxxxxccontacts;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "fxxxcq144xwwqqhxxxxxlocation")
	public Set<Fpxxfq1a5xwwqqhxxxxxitem> getFpxxfq1a5xwwqqhxxxxxitems() {
		return this.fpxxfq1a5xwwqqhxxxxxitems;
	}

	public void setFpxxfq1a5xwwqqhxxxxxitems(
			Set<Fpxxfq1a5xwwqqhxxxxxitem> fpxxfq1a5xwwqqhxxxxxitems) {
		this.fpxxfq1a5xwwqqhxxxxxitems = fpxxfq1a5xwwqqhxxxxxitems;
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
