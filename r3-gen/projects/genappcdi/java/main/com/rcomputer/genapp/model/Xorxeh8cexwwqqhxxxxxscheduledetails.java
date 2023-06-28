package com.rcomputer.genapp.model;
// Generated 27-Jun-2023 8:43:30 PM by Hibernate Tools 4.0.0

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
 * Xorxeh8cexwwqqhxxxxxscheduledetails generated by hbm2java
 */
@Entity
@XmlRootElement
@Table(name = "scheduledetails")
public class Xorxeh8cexwwqqhxxxxxscheduledetails
		implements
			java.io.Serializable {

	private Integer a0xxuobxbxxxxxxxxxxxsid;
	private Fxxxuq89bxwwqqhxxxxxschedule fxxxuq89bxwwqqhxxxxxschedule;
	private Jxxxuq300xwwqqhxxxxxvendor jxxxuq300xwwqqhxxxxxvendor;
	private Jxxxuq201xwwqqhxxxxxcustomer jxxxuq201xwwqqhxxxxxcustomer;
	private Jxxxbh400xwwqqhxxxxxemployee jxxxbh400xwwqqhxxxxxemployee;
	private Integer b1xxzo11bvlxxxxxxxxxline;
	private String y8xxuznxbvxxxxxxxxxxnotes;
	private Integer z1xxzzfxhhxxxxxxxxxxstatusfl;
	private String z2xxutoxlhxxxxxxxxxxowner;
	private String zzxxu2oxxhxxxxxxxxxxowner2;

	public Xorxeh8cexwwqqhxxxxxscheduledetails() {
	}

	public Xorxeh8cexwwqqhxxxxxscheduledetails(
			Fxxxuq89bxwwqqhxxxxxschedule fxxxuq89bxwwqqhxxxxxschedule) {
		this.fxxxuq89bxwwqqhxxxxxschedule = fxxxuq89bxwwqqhxxxxxschedule;
	}
	public Xorxeh8cexwwqqhxxxxxscheduledetails(
			Fxxxuq89bxwwqqhxxxxxschedule fxxxuq89bxwwqqhxxxxxschedule,
			Jxxxuq300xwwqqhxxxxxvendor jxxxuq300xwwqqhxxxxxvendor,
			Jxxxuq201xwwqqhxxxxxcustomer jxxxuq201xwwqqhxxxxxcustomer,
			Jxxxbh400xwwqqhxxxxxemployee jxxxbh400xwwqqhxxxxxemployee,
			Integer b1xxzo11bvlxxxxxxxxxline, String y8xxuznxbvxxxxxxxxxxnotes,
			Integer z1xxzzfxhhxxxxxxxxxxstatusfl,
			String z2xxutoxlhxxxxxxxxxxowner, String zzxxu2oxxhxxxxxxxxxxowner2) {
		this.fxxxuq89bxwwqqhxxxxxschedule = fxxxuq89bxwwqqhxxxxxschedule;
		this.jxxxuq300xwwqqhxxxxxvendor = jxxxuq300xwwqqhxxxxxvendor;
		this.jxxxuq201xwwqqhxxxxxcustomer = jxxxuq201xwwqqhxxxxxcustomer;
		this.jxxxbh400xwwqqhxxxxxemployee = jxxxbh400xwwqqhxxxxxemployee;
		this.b1xxzo11bvlxxxxxxxxxline = b1xxzo11bvlxxxxxxxxxline;
		this.y8xxuznxbvxxxxxxxxxxnotes = y8xxuznxbvxxxxxxxxxxnotes;
		this.z1xxzzfxhhxxxxxxxxxxstatusfl = z1xxzzfxhhxxxxxxxxxxstatusfl;
		this.z2xxutoxlhxxxxxxxxxxowner = z2xxutoxlhxxxxxxxxxxowner;
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
	@JoinColumn(name = "schedulesidno", nullable = false)
	@NotNull
	public Fxxxuq89bxwwqqhxxxxxschedule getFxxxuq89bxwwqqhxxxxxschedule() {
		return this.fxxxuq89bxwwqqhxxxxxschedule;
	}

	public void setFxxxuq89bxwwqqhxxxxxschedule(
			Fxxxuq89bxwwqqhxxxxxschedule fxxxuq89bxwwqqhxxxxxschedule) {
		this.fxxxuq89bxwwqqhxxxxxschedule = fxxxuq89bxwwqqhxxxxxschedule;
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
	@JoinColumn(name = "customer")
	public Jxxxuq201xwwqqhxxxxxcustomer getJxxxuq201xwwqqhxxxxxcustomer() {
		return this.jxxxuq201xwwqqhxxxxxcustomer;
	}

	public void setJxxxuq201xwwqqhxxxxxcustomer(
			Jxxxuq201xwwqqhxxxxxcustomer jxxxuq201xwwqqhxxxxxcustomer) {
		this.jxxxuq201xwwqqhxxxxxcustomer = jxxxuq201xwwqqhxxxxxcustomer;
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

	@Column(name = "line")
	public Integer getB1xxzo11bvlxxxxxxxxxline() {
		return this.b1xxzo11bvlxxxxxxxxxline;
	}

	public void setB1xxzo11bvlxxxxxxxxxline(Integer b1xxzo11bvlxxxxxxxxxline) {
		this.b1xxzo11bvlxxxxxxxxxline = b1xxzo11bvlxxxxxxxxxline;
	}

	@Column(name = "notes", length = 60)
	@Size(max = 60)
	public String getY8xxuznxbvxxxxxxxxxxnotes() {
		return this.y8xxuznxbvxxxxxxxxxxnotes;
	}

	public void setY8xxuznxbvxxxxxxxxxxnotes(String y8xxuznxbvxxxxxxxxxxnotes) {
		this.y8xxuznxbvxxxxxxxxxxnotes = y8xxuznxbvxxxxxxxxxxnotes;
	}

	@Column(name = "statusfl")
	public Integer getZ1xxzzfxhhxxxxxxxxxxstatusfl() {
		return this.z1xxzzfxhhxxxxxxxxxxstatusfl;
	}

	public void setZ1xxzzfxhhxxxxxxxxxxstatusfl(
			Integer z1xxzzfxhhxxxxxxxxxxstatusfl) {
		this.z1xxzzfxhhxxxxxxxxxxstatusfl = z1xxzzfxhhxxxxxxxxxxstatusfl;
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
