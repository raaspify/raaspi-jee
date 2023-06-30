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
 * Xxxxiq1c3xwwqqhxxxxxcontrol generated by hbm2java
 */
@Entity
@XmlRootElement
@Table(name = "control")
public class Xxxxiq1c3xwwqqhxxxxxcontrol implements java.io.Serializable {

	private Integer a0xxuobxbxxxxxxxxxxxsid;
	private String a0xxukoxbvxxxxxxxxxxcontrolcode;
	private String b1xxuszsbvxxxxxxxxxxdescript;
	private String b2xxuzsxbvxxxxxxxxxxtypeofcontrol;
	private Integer b3xxzzfxhhxxxxxxxxxxstatusfl;
	private Date b4xxcztxlxxxxxxxxxxxstatusfldt;
	private String b5xxuxznbvxxxxxxxxxxnotes;
	private String b6xxutoxlhxxxxxxxxxxowner;
	private String zzxxu2oxxhxxxxxxxxxxowner2;
	private Set<Lxxxeh177xwwqqhxxxxxcontrolusagebyperiods> lxxxeh177xwwqqhxxxxxcontrolusagebyperiodses = new HashSet<Lxxxeh177xwwqqhxxxxxcontrolusagebyperiods>(
			0);

	public Xxxxiq1c3xwwqqhxxxxxcontrol() {
	}

	public Xxxxiq1c3xwwqqhxxxxxcontrol(String a0xxukoxbvxxxxxxxxxxcontrolcode) {
		this.a0xxukoxbvxxxxxxxxxxcontrolcode = a0xxukoxbvxxxxxxxxxxcontrolcode;
	}
	public Xxxxiq1c3xwwqqhxxxxxcontrol(
			String a0xxukoxbvxxxxxxxxxxcontrolcode,
			String b1xxuszsbvxxxxxxxxxxdescript,
			String b2xxuzsxbvxxxxxxxxxxtypeofcontrol,
			Integer b3xxzzfxhhxxxxxxxxxxstatusfl,
			Date b4xxcztxlxxxxxxxxxxxstatusfldt,
			String b5xxuxznbvxxxxxxxxxxnotes,
			String b6xxutoxlhxxxxxxxxxxowner,
			String zzxxu2oxxhxxxxxxxxxxowner2,
			Set<Lxxxeh177xwwqqhxxxxxcontrolusagebyperiods> lxxxeh177xwwqqhxxxxxcontrolusagebyperiodses) {
		this.a0xxukoxbvxxxxxxxxxxcontrolcode = a0xxukoxbvxxxxxxxxxxcontrolcode;
		this.b1xxuszsbvxxxxxxxxxxdescript = b1xxuszsbvxxxxxxxxxxdescript;
		this.b2xxuzsxbvxxxxxxxxxxtypeofcontrol = b2xxuzsxbvxxxxxxxxxxtypeofcontrol;
		this.b3xxzzfxhhxxxxxxxxxxstatusfl = b3xxzzfxhhxxxxxxxxxxstatusfl;
		this.b4xxcztxlxxxxxxxxxxxstatusfldt = b4xxcztxlxxxxxxxxxxxstatusfldt;
		this.b5xxuxznbvxxxxxxxxxxnotes = b5xxuxznbvxxxxxxxxxxnotes;
		this.b6xxutoxlhxxxxxxxxxxowner = b6xxutoxlhxxxxxxxxxxowner;
		this.zzxxu2oxxhxxxxxxxxxxowner2 = zzxxu2oxxhxxxxxxxxxxowner2;
		this.lxxxeh177xwwqqhxxxxxcontrolusagebyperiodses = lxxxeh177xwwqqhxxxxxcontrolusagebyperiodses;
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

	@Column(name = "controlcode", nullable = false, length = 32)
	@NotNull
	@Size(max = 32)
	public String getA0xxukoxbvxxxxxxxxxxcontrolcode() {
		return this.a0xxukoxbvxxxxxxxxxxcontrolcode;
	}

	public void setA0xxukoxbvxxxxxxxxxxcontrolcode(
			String a0xxukoxbvxxxxxxxxxxcontrolcode) {
		this.a0xxukoxbvxxxxxxxxxxcontrolcode = a0xxukoxbvxxxxxxxxxxcontrolcode;
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

	@Column(name = "typeofcontrol", length = 12)
	@Size(max = 12)
	public String getB2xxuzsxbvxxxxxxxxxxtypeofcontrol() {
		return this.b2xxuzsxbvxxxxxxxxxxtypeofcontrol;
	}

	public void setB2xxuzsxbvxxxxxxxxxxtypeofcontrol(
			String b2xxuzsxbvxxxxxxxxxxtypeofcontrol) {
		this.b2xxuzsxbvxxxxxxxxxxtypeofcontrol = b2xxuzsxbvxxxxxxxxxxtypeofcontrol;
	}

	@Column(name = "statusfl")
	public Integer getB3xxzzfxhhxxxxxxxxxxstatusfl() {
		return this.b3xxzzfxhhxxxxxxxxxxstatusfl;
	}

	public void setB3xxzzfxhhxxxxxxxxxxstatusfl(
			Integer b3xxzzfxhhxxxxxxxxxxstatusfl) {
		this.b3xxzzfxhhxxxxxxxxxxstatusfl = b3xxzzfxhhxxxxxxxxxxstatusfl;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "statusfldt", length = 29)
	public Date getB4xxcztxlxxxxxxxxxxxstatusfldt() {
		return this.b4xxcztxlxxxxxxxxxxxstatusfldt;
	}

	public void setB4xxcztxlxxxxxxxxxxxstatusfldt(
			Date b4xxcztxlxxxxxxxxxxxstatusfldt) {
		this.b4xxcztxlxxxxxxxxxxxstatusfldt = b4xxcztxlxxxxxxxxxxxstatusfldt;
	}

	@Column(name = "notes", length = 60)
	@Size(max = 60)
	public String getB5xxuxznbvxxxxxxxxxxnotes() {
		return this.b5xxuxznbvxxxxxxxxxxnotes;
	}

	public void setB5xxuxznbvxxxxxxxxxxnotes(String b5xxuxznbvxxxxxxxxxxnotes) {
		this.b5xxuxznbvxxxxxxxxxxnotes = b5xxuxznbvxxxxxxxxxxnotes;
	}

	@Column(name = "owner", length = 40)
	@Size(max = 40)
	public String getB6xxutoxlhxxxxxxxxxxowner() {
		return this.b6xxutoxlhxxxxxxxxxxowner;
	}

	public void setB6xxutoxlhxxxxxxxxxxowner(String b6xxutoxlhxxxxxxxxxxowner) {
		this.b6xxutoxlhxxxxxxxxxxowner = b6xxutoxlhxxxxxxxxxxowner;
	}

	@Column(name = "owner2", length = 40)
	@Size(max = 40)
	public String getZzxxu2oxxhxxxxxxxxxxowner2() {
		return this.zzxxu2oxxhxxxxxxxxxxowner2;
	}

	public void setZzxxu2oxxhxxxxxxxxxxowner2(String zzxxu2oxxhxxxxxxxxxxowner2) {
		this.zzxxu2oxxhxxxxxxxxxxowner2 = zzxxu2oxxhxxxxxxxxxxowner2;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "xxxxiq1c3xwwqqhxxxxxcontrol")
	public Set<Lxxxeh177xwwqqhxxxxxcontrolusagebyperiods> getLxxxeh177xwwqqhxxxxxcontrolusagebyperiodses() {
		return this.lxxxeh177xwwqqhxxxxxcontrolusagebyperiodses;
	}

	public void setLxxxeh177xwwqqhxxxxxcontrolusagebyperiodses(
			Set<Lxxxeh177xwwqqhxxxxxcontrolusagebyperiods> lxxxeh177xwwqqhxxxxxcontrolusagebyperiodses) {
		this.lxxxeh177xwwqqhxxxxxcontrolusagebyperiodses = lxxxeh177xwwqqhxxxxxcontrolusagebyperiodses;
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
