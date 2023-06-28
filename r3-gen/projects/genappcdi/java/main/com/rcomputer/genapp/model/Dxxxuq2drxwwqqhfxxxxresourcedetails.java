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
 * Dxxxuq2drxwwqqhfxxxxresourcedetails generated by hbm2java
 */
@Entity
@XmlRootElement
@Table(name = "resourcedetails")
public class Dxxxuq2drxwwqqhfxxxxresourcedetails
		implements
			java.io.Serializable {

	private Integer a0xxuobxbxxxxxxxxxxxsid;
	private Fxxxuq1kkxwwqqhfxxxxtask fxxxuq1kkxwwqqhfxxxxtask;
	private Jxxxuq54exwwqqhxxxxxgroupmembers jxxxuq54exwwqqhxxxxxgroupmembers;
	private Fxxxuq1ggxwwqqhxxxxxmembersgroup fxxxuq1ggxwwqqhxxxxxmembersgroup;
	private Integer b1xxzk11bvlxxxxxxxxxresourcenumber;
	private BigDecimal z5xxzxxxavxxxxxxxxxxusagepercent;
	private Integer zaxxzzfxhhxxxxxxxxxxstatusfl;
	private Date zbxxcztxlxxxxxxxxxxxstatusfldt;
	private String zcxxutoxlhxxxxxxxxxxowner;
	private String zzxxu2oxxhxxxxxxxxxxowner2;

	public Dxxxuq2drxwwqqhfxxxxresourcedetails() {
	}

	public Dxxxuq2drxwwqqhfxxxxresourcedetails(
			Jxxxuq54exwwqqhxxxxxgroupmembers jxxxuq54exwwqqhxxxxxgroupmembers) {
		this.jxxxuq54exwwqqhxxxxxgroupmembers = jxxxuq54exwwqqhxxxxxgroupmembers;
	}
	public Dxxxuq2drxwwqqhfxxxxresourcedetails(
			Fxxxuq1kkxwwqqhfxxxxtask fxxxuq1kkxwwqqhfxxxxtask,
			Jxxxuq54exwwqqhxxxxxgroupmembers jxxxuq54exwwqqhxxxxxgroupmembers,
			Fxxxuq1ggxwwqqhxxxxxmembersgroup fxxxuq1ggxwwqqhxxxxxmembersgroup,
			Integer b1xxzk11bvlxxxxxxxxxresourcenumber,
			BigDecimal z5xxzxxxavxxxxxxxxxxusagepercent,
			Integer zaxxzzfxhhxxxxxxxxxxstatusfl,
			Date zbxxcztxlxxxxxxxxxxxstatusfldt,
			String zcxxutoxlhxxxxxxxxxxowner, String zzxxu2oxxhxxxxxxxxxxowner2) {
		this.fxxxuq1kkxwwqqhfxxxxtask = fxxxuq1kkxwwqqhfxxxxtask;
		this.jxxxuq54exwwqqhxxxxxgroupmembers = jxxxuq54exwwqqhxxxxxgroupmembers;
		this.fxxxuq1ggxwwqqhxxxxxmembersgroup = fxxxuq1ggxwwqqhxxxxxmembersgroup;
		this.b1xxzk11bvlxxxxxxxxxresourcenumber = b1xxzk11bvlxxxxxxxxxresourcenumber;
		this.z5xxzxxxavxxxxxxxxxxusagepercent = z5xxzxxxavxxxxxxxxxxusagepercent;
		this.zaxxzzfxhhxxxxxxxxxxstatusfl = zaxxzzfxhhxxxxxxxxxxstatusfl;
		this.zbxxcztxlxxxxxxxxxxxstatusfldt = zbxxcztxlxxxxxxxxxxxstatusfldt;
		this.zcxxutoxlhxxxxxxxxxxowner = zcxxutoxlhxxxxxxxxxxowner;
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
	@JoinColumn(name = "taskno")
	public Fxxxuq1kkxwwqqhfxxxxtask getFxxxuq1kkxwwqqhfxxxxtask() {
		return this.fxxxuq1kkxwwqqhfxxxxtask;
	}

	public void setFxxxuq1kkxwwqqhfxxxxtask(
			Fxxxuq1kkxwwqqhfxxxxtask fxxxuq1kkxwwqqhfxxxxtask) {
		this.fxxxuq1kkxwwqqhfxxxxtask = fxxxuq1kkxwwqqhfxxxxtask;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "resource", nullable = false)
	@NotNull
	public Jxxxuq54exwwqqhxxxxxgroupmembers getJxxxuq54exwwqqhxxxxxgroupmembers() {
		return this.jxxxuq54exwwqqhxxxxxgroupmembers;
	}

	public void setJxxxuq54exwwqqhxxxxxgroupmembers(
			Jxxxuq54exwwqqhxxxxxgroupmembers jxxxuq54exwwqqhxxxxxgroupmembers) {
		this.jxxxuq54exwwqqhxxxxxgroupmembers = jxxxuq54exwwqqhxxxxxgroupmembers;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "projectteam")
	public Fxxxuq1ggxwwqqhxxxxxmembersgroup getFxxxuq1ggxwwqqhxxxxxmembersgroup() {
		return this.fxxxuq1ggxwwqqhxxxxxmembersgroup;
	}

	public void setFxxxuq1ggxwwqqhxxxxxmembersgroup(
			Fxxxuq1ggxwwqqhxxxxxmembersgroup fxxxuq1ggxwwqqhxxxxxmembersgroup) {
		this.fxxxuq1ggxwwqqhxxxxxmembersgroup = fxxxuq1ggxwwqqhxxxxxmembersgroup;
	}

	@Column(name = "resourcenumber")
	public Integer getB1xxzk11bvlxxxxxxxxxresourcenumber() {
		return this.b1xxzk11bvlxxxxxxxxxresourcenumber;
	}

	public void setB1xxzk11bvlxxxxxxxxxresourcenumber(
			Integer b1xxzk11bvlxxxxxxxxxresourcenumber) {
		this.b1xxzk11bvlxxxxxxxxxresourcenumber = b1xxzk11bvlxxxxxxxxxresourcenumber;
	}

	@Column(name = "usagepercent", precision = 14)
	public BigDecimal getZ5xxzxxxavxxxxxxxxxxusagepercent() {
		return this.z5xxzxxxavxxxxxxxxxxusagepercent;
	}

	public void setZ5xxzxxxavxxxxxxxxxxusagepercent(
			BigDecimal z5xxzxxxavxxxxxxxxxxusagepercent) {
		this.z5xxzxxxavxxxxxxxxxxusagepercent = z5xxzxxxavxxxxxxxxxxusagepercent;
	}

	@Column(name = "statusfl")
	public Integer getZaxxzzfxhhxxxxxxxxxxstatusfl() {
		return this.zaxxzzfxhhxxxxxxxxxxstatusfl;
	}

	public void setZaxxzzfxhhxxxxxxxxxxstatusfl(
			Integer zaxxzzfxhhxxxxxxxxxxstatusfl) {
		this.zaxxzzfxhhxxxxxxxxxxstatusfl = zaxxzzfxhhxxxxxxxxxxstatusfl;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "statusfldt", length = 29)
	public Date getZbxxcztxlxxxxxxxxxxxstatusfldt() {
		return this.zbxxcztxlxxxxxxxxxxxstatusfldt;
	}

	public void setZbxxcztxlxxxxxxxxxxxstatusfldt(
			Date zbxxcztxlxxxxxxxxxxxstatusfldt) {
		this.zbxxcztxlxxxxxxxxxxxstatusfldt = zbxxcztxlxxxxxxxxxxxstatusfldt;
	}

	@Column(name = "owner", length = 40)
	@Size(max = 40)
	public String getZcxxutoxlhxxxxxxxxxxowner() {
		return this.zcxxutoxlhxxxxxxxxxxowner;
	}

	public void setZcxxutoxlhxxxxxxxxxxowner(String zcxxutoxlhxxxxxxxxxxowner) {
		this.zcxxutoxlhxxxxxxxxxxowner = zcxxutoxlhxxxxxxxxxxowner;
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
