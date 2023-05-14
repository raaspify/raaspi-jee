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
 * Fxxxuq1ggxwwqqhxxxxxmembersgroup generated by hbm2java
 */
@Entity
@XmlRootElement
@Table(name = "membersgroup")
public class Fxxxuq1ggxwwqqhxxxxxmembersgroup implements java.io.Serializable {

	private Integer a0xxuobxbxxxxxxxxxxxsid;
	private String a0xxukxxbvxxxxxxxxxxgroupid;
	private String b1xxuszsbvxxxxxxxxxxdescript;
	private BigDecimal z1xxziqxlvxxxxxxxxxxquantity;
	private Boolean b2xxfxxxbvxxxxxxxxxxmode;
	private Integer z1xxzzfxhhxxxxxxxxxxstatusfl;
	private Date z2xxcztxlxxxxxxxxxxxstatusfldt;
	private String z3xxutoxlhxxxxxxxxxxowner;
	private String zzxxu2oxxhxxxxxxxxxxowner2;
	private Set<Fxxxuq1kkxwwqqhfxxxxtask> fxxxuq1kkxwwqqhfxxxxtasks = new HashSet<Fxxxuq1kkxwwqqhfxxxxtask>(
			0);
	private Set<Fxxxuq89bxwwqqhxxxxxschedule> fxxxuq89bxwwqqhxxxxxschedules = new HashSet<Fxxxuq89bxwwqqhxxxxxschedule>(
			0);
	private Set<Jxxxuq54exwwqqhxxxxxgroupmembers> jxxxuq54exwwqqhxxxxxgroupmemberses = new HashSet<Jxxxuq54exwwqqhxxxxxgroupmembers>(
			0);
	private Set<Dxxxuq2drxwwqqhfxxxxresourcedetails> dxxxuq2drxwwqqhfxxxxresourcedetailses = new HashSet<Dxxxuq2drxwwqqhfxxxxresourcedetails>(
			0);

	public Fxxxuq1ggxwwqqhxxxxxmembersgroup() {
	}

	public Fxxxuq1ggxwwqqhxxxxxmembersgroup(String a0xxukxxbvxxxxxxxxxxgroupid) {
		this.a0xxukxxbvxxxxxxxxxxgroupid = a0xxukxxbvxxxxxxxxxxgroupid;
	}
	public Fxxxuq1ggxwwqqhxxxxxmembersgroup(
			String a0xxukxxbvxxxxxxxxxxgroupid,
			String b1xxuszsbvxxxxxxxxxxdescript,
			BigDecimal z1xxziqxlvxxxxxxxxxxquantity,
			Boolean b2xxfxxxbvxxxxxxxxxxmode,
			Integer z1xxzzfxhhxxxxxxxxxxstatusfl,
			Date z2xxcztxlxxxxxxxxxxxstatusfldt,
			String z3xxutoxlhxxxxxxxxxxowner,
			String zzxxu2oxxhxxxxxxxxxxowner2,
			Set<Fxxxuq1kkxwwqqhfxxxxtask> fxxxuq1kkxwwqqhfxxxxtasks,
			Set<Fxxxuq89bxwwqqhxxxxxschedule> fxxxuq89bxwwqqhxxxxxschedules,
			Set<Jxxxuq54exwwqqhxxxxxgroupmembers> jxxxuq54exwwqqhxxxxxgroupmemberses,
			Set<Dxxxuq2drxwwqqhfxxxxresourcedetails> dxxxuq2drxwwqqhfxxxxresourcedetailses) {
		this.a0xxukxxbvxxxxxxxxxxgroupid = a0xxukxxbvxxxxxxxxxxgroupid;
		this.b1xxuszsbvxxxxxxxxxxdescript = b1xxuszsbvxxxxxxxxxxdescript;
		this.z1xxziqxlvxxxxxxxxxxquantity = z1xxziqxlvxxxxxxxxxxquantity;
		this.b2xxfxxxbvxxxxxxxxxxmode = b2xxfxxxbvxxxxxxxxxxmode;
		this.z1xxzzfxhhxxxxxxxxxxstatusfl = z1xxzzfxhhxxxxxxxxxxstatusfl;
		this.z2xxcztxlxxxxxxxxxxxstatusfldt = z2xxcztxlxxxxxxxxxxxstatusfldt;
		this.z3xxutoxlhxxxxxxxxxxowner = z3xxutoxlhxxxxxxxxxxowner;
		this.zzxxu2oxxhxxxxxxxxxxowner2 = zzxxu2oxxhxxxxxxxxxxowner2;
		this.fxxxuq1kkxwwqqhfxxxxtasks = fxxxuq1kkxwwqqhfxxxxtasks;
		this.fxxxuq89bxwwqqhxxxxxschedules = fxxxuq89bxwwqqhxxxxxschedules;
		this.jxxxuq54exwwqqhxxxxxgroupmemberses = jxxxuq54exwwqqhxxxxxgroupmemberses;
		this.dxxxuq2drxwwqqhfxxxxresourcedetailses = dxxxuq2drxwwqqhfxxxxresourcedetailses;
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

	@Column(name = "groupid", nullable = false, length = 32)
	@NotNull
	@Size(max = 32)
	public String getA0xxukxxbvxxxxxxxxxxgroupid() {
		return this.a0xxukxxbvxxxxxxxxxxgroupid;
	}

	public void setA0xxukxxbvxxxxxxxxxxgroupid(
			String a0xxukxxbvxxxxxxxxxxgroupid) {
		this.a0xxukxxbvxxxxxxxxxxgroupid = a0xxukxxbvxxxxxxxxxxgroupid;
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

	@Column(name = "quantity", precision = 14)
	public BigDecimal getZ1xxziqxlvxxxxxxxxxxquantity() {
		return this.z1xxziqxlvxxxxxxxxxxquantity;
	}

	public void setZ1xxziqxlvxxxxxxxxxxquantity(
			BigDecimal z1xxziqxlvxxxxxxxxxxquantity) {
		this.z1xxziqxlvxxxxxxxxxxquantity = z1xxziqxlvxxxxxxxxxxquantity;
	}

	@Column(name = "mode")
	public Boolean getB2xxfxxxbvxxxxxxxxxxmode() {
		return this.b2xxfxxxbvxxxxxxxxxxmode;
	}

	public void setB2xxfxxxbvxxxxxxxxxxmode(Boolean b2xxfxxxbvxxxxxxxxxxmode) {
		this.b2xxfxxxbvxxxxxxxxxxmode = b2xxfxxxbvxxxxxxxxxxmode;
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

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "fxxxuq1ggxwwqqhxxxxxmembersgroup")
	public Set<Fxxxuq1kkxwwqqhfxxxxtask> getFxxxuq1kkxwwqqhfxxxxtasks() {
		return this.fxxxuq1kkxwwqqhfxxxxtasks;
	}

	public void setFxxxuq1kkxwwqqhfxxxxtasks(
			Set<Fxxxuq1kkxwwqqhfxxxxtask> fxxxuq1kkxwwqqhfxxxxtasks) {
		this.fxxxuq1kkxwwqqhfxxxxtasks = fxxxuq1kkxwwqqhfxxxxtasks;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "fxxxuq1ggxwwqqhxxxxxmembersgroup")
	public Set<Fxxxuq89bxwwqqhxxxxxschedule> getFxxxuq89bxwwqqhxxxxxschedules() {
		return this.fxxxuq89bxwwqqhxxxxxschedules;
	}

	public void setFxxxuq89bxwwqqhxxxxxschedules(
			Set<Fxxxuq89bxwwqqhxxxxxschedule> fxxxuq89bxwwqqhxxxxxschedules) {
		this.fxxxuq89bxwwqqhxxxxxschedules = fxxxuq89bxwwqqhxxxxxschedules;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "fxxxuq1ggxwwqqhxxxxxmembersgroup")
	public Set<Jxxxuq54exwwqqhxxxxxgroupmembers> getJxxxuq54exwwqqhxxxxxgroupmemberses() {
		return this.jxxxuq54exwwqqhxxxxxgroupmemberses;
	}

	public void setJxxxuq54exwwqqhxxxxxgroupmemberses(
			Set<Jxxxuq54exwwqqhxxxxxgroupmembers> jxxxuq54exwwqqhxxxxxgroupmemberses) {
		this.jxxxuq54exwwqqhxxxxxgroupmemberses = jxxxuq54exwwqqhxxxxxgroupmemberses;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "fxxxuq1ggxwwqqhxxxxxmembersgroup")
	public Set<Dxxxuq2drxwwqqhfxxxxresourcedetails> getDxxxuq2drxwwqqhfxxxxresourcedetailses() {
		return this.dxxxuq2drxwwqqhfxxxxresourcedetailses;
	}

	public void setDxxxuq2drxwwqqhfxxxxresourcedetailses(
			Set<Dxxxuq2drxwwqqhfxxxxresourcedetails> dxxxuq2drxwwqqhfxxxxresourcedetailses) {
		this.dxxxuq2drxwwqqhfxxxxresourcedetailses = dxxxuq2drxwwqqhfxxxxresourcedetailses;
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
