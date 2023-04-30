package com.rcomputer.genapp.model;
// Generated 13-Apr-2023 9:07:31 PM by Hibernate Tools 4.0.0

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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

/**
 * Yxxxuq1l1xwwqqhxxxxxresource_bundle generated by hbm2java
 */
@Entity
@XmlRootElement
@Table(name = "resource_bundle")
public class Yxxxuq1l1xwwqqhxxxxxresource_bundle
		implements
			java.io.Serializable {

	private Integer a0xxuobxbxxxxxxxxxxxsid;
	private String a0xxukrdbvxxxxxxxxxxname;
	private String a1xxuxxxbvxxxxxxxxxxlanguage;
	private String a1xxuxxxbvxxxxxxxxxxcountry;
	private String a1xxuxxxbvxxxxxxxxxxvariant;
	private Integer zixxzzfxhhxxxxxxxxxxstatusfl;
	private Date zjxxcztxlxxxxxxxxxxxstatusfldt;
	private String z3xxutoxlhxxxxxxxxxxowner;
	private String zzxxu2oxxhxxxxxxxxxxowner2;
	private Set<Yxxxuq1r1xwwqqhxxxxxresource> yxxxuq1r1xwwqqhxxxxxresources = new HashSet<Yxxxuq1r1xwwqqhxxxxxresource>(
			0);

	public Yxxxuq1l1xwwqqhxxxxxresource_bundle() {
	}

	public Yxxxuq1l1xwwqqhxxxxxresource_bundle(String a0xxukrdbvxxxxxxxxxxname,
			String a1xxuxxxbvxxxxxxxxxxlanguage,
			String a1xxuxxxbvxxxxxxxxxxcountry,
			String a1xxuxxxbvxxxxxxxxxxvariant,
			Integer zixxzzfxhhxxxxxxxxxxstatusfl,
			Date zjxxcztxlxxxxxxxxxxxstatusfldt,
			String z3xxutoxlhxxxxxxxxxxowner,
			String zzxxu2oxxhxxxxxxxxxxowner2,
			Set<Yxxxuq1r1xwwqqhxxxxxresource> yxxxuq1r1xwwqqhxxxxxresources) {
		this.a0xxukrdbvxxxxxxxxxxname = a0xxukrdbvxxxxxxxxxxname;
		this.a1xxuxxxbvxxxxxxxxxxlanguage = a1xxuxxxbvxxxxxxxxxxlanguage;
		this.a1xxuxxxbvxxxxxxxxxxcountry = a1xxuxxxbvxxxxxxxxxxcountry;
		this.a1xxuxxxbvxxxxxxxxxxvariant = a1xxuxxxbvxxxxxxxxxxvariant;
		this.zixxzzfxhhxxxxxxxxxxstatusfl = zixxzzfxhhxxxxxxxxxxstatusfl;
		this.zjxxcztxlxxxxxxxxxxxstatusfldt = zjxxcztxlxxxxxxxxxxxstatusfldt;
		this.z3xxutoxlhxxxxxxxxxxowner = z3xxutoxlhxxxxxxxxxxowner;
		this.zzxxu2oxxhxxxxxxxxxxowner2 = zzxxu2oxxhxxxxxxxxxxowner2;
		this.yxxxuq1r1xwwqqhxxxxxresources = yxxxuq1r1xwwqqhxxxxxresources;
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

	@Column(name = "name", length = 50)
	@Size(max = 50)
	public String getA0xxukrdbvxxxxxxxxxxname() {
		return this.a0xxukrdbvxxxxxxxxxxname;
	}

	public void setA0xxukrdbvxxxxxxxxxxname(String a0xxukrdbvxxxxxxxxxxname) {
		this.a0xxukrdbvxxxxxxxxxxname = a0xxukrdbvxxxxxxxxxxname;
	}

	@Column(name = "language", length = 2)
	@Size(max = 2)
	public String getA1xxuxxxbvxxxxxxxxxxlanguage() {
		return this.a1xxuxxxbvxxxxxxxxxxlanguage;
	}

	public void setA1xxuxxxbvxxxxxxxxxxlanguage(
			String a1xxuxxxbvxxxxxxxxxxlanguage) {
		this.a1xxuxxxbvxxxxxxxxxxlanguage = a1xxuxxxbvxxxxxxxxxxlanguage;
	}

	@Column(name = "country", length = 2)
	@Size(max = 2)
	public String getA1xxuxxxbvxxxxxxxxxxcountry() {
		return this.a1xxuxxxbvxxxxxxxxxxcountry;
	}

	public void setA1xxuxxxbvxxxxxxxxxxcountry(
			String a1xxuxxxbvxxxxxxxxxxcountry) {
		this.a1xxuxxxbvxxxxxxxxxxcountry = a1xxuxxxbvxxxxxxxxxxcountry;
	}

	@Column(name = "variant", length = 2)
	@Size(max = 2)
	public String getA1xxuxxxbvxxxxxxxxxxvariant() {
		return this.a1xxuxxxbvxxxxxxxxxxvariant;
	}

	public void setA1xxuxxxbvxxxxxxxxxxvariant(
			String a1xxuxxxbvxxxxxxxxxxvariant) {
		this.a1xxuxxxbvxxxxxxxxxxvariant = a1xxuxxxbvxxxxxxxxxxvariant;
	}

	@Column(name = "statusfl")
	public Integer getZixxzzfxhhxxxxxxxxxxstatusfl() {
		return this.zixxzzfxhhxxxxxxxxxxstatusfl;
	}

	public void setZixxzzfxhhxxxxxxxxxxstatusfl(
			Integer zixxzzfxhhxxxxxxxxxxstatusfl) {
		this.zixxzzfxhhxxxxxxxxxxstatusfl = zixxzzfxhhxxxxxxxxxxstatusfl;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "statusfldt", length = 29)
	public Date getZjxxcztxlxxxxxxxxxxxstatusfldt() {
		return this.zjxxcztxlxxxxxxxxxxxstatusfldt;
	}

	public void setZjxxcztxlxxxxxxxxxxxstatusfldt(
			Date zjxxcztxlxxxxxxxxxxxstatusfldt) {
		this.zjxxcztxlxxxxxxxxxxxstatusfldt = zjxxcztxlxxxxxxxxxxxstatusfldt;
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

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "yxxxuq1l1xwwqqhxxxxxresource_bundle")
	public Set<Yxxxuq1r1xwwqqhxxxxxresource> getYxxxuq1r1xwwqqhxxxxxresources() {
		return this.yxxxuq1r1xwwqqhxxxxxresources;
	}

	public void setYxxxuq1r1xwwqqhxxxxxresources(
			Set<Yxxxuq1r1xwwqqhxxxxxresource> yxxxuq1r1xwwqqhxxxxxresources) {
		this.yxxxuq1r1xwwqqhxxxxxresources = yxxxuq1r1xwwqqhxxxxxresources;
	}

}
