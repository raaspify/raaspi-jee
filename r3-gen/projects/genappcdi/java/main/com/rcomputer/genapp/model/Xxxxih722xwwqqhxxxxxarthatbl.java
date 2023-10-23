package com.rcomputer.genapp.model;
// Generated 18-Oct-2023 7:34:42 PM by Hibernate Tools 4.0.0

import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
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
 * Xxxxih722xwwqqhxxxxxarthatbl generated by hbm2java
 */
@Entity
@XmlRootElement
@Table(name = "arthatbl")
public class Xxxxih722xwwqqhxxxxxarthatbl implements java.io.Serializable {

	private Integer a0xxuobxbxxxxxxxxxxxsid;
	private String a0xxukwvbvtxxxxxxxxxusage;
	private BigDecimal b1xxzwvwbvxxxxxxxxxxwcbpercnt;
	private BigDecimal b2xxzwvibvxxxxxxxxxxinsfactor;
	private BigDecimal b3xxzwvvbvxxxxxxxxxxvacatonrate;
	private BigDecimal b4xxzwvpbvmxxxxxxxxxpensionmax;
	private BigDecimal b5xxzwvwbvmxxxxxxxxxwcbmax;
	private BigDecimal b6xxzwvibvmxxxxxxxxxinsmax;
	private BigDecimal b7xxzwvibv0xxxxxxxxxitaxlv0rate;
	private BigDecimal b8xxzwvibv1xxxxxxxxxitaxlv1rate;
	private BigDecimal b9xxzwvibv2xxxxxxxxxitaxlv2rate;
	private BigDecimal y1xxzwvibv3xxxxxxxxxitaxlv3rate;
	private Integer z1xxzzfxhhxxxxxxxxxxstatusfl;
	private Date z2xxcztxlxxxxxxxxxxxstatusfldt;
	private String y2xxuznxbvxxxxxxxxxxnotes;
	private String z3xxutoxlhxxxxxxxxxxowner;
	private String zzxxu2oxxhxxxxxxxxxxowner2;

	public Xxxxih722xwwqqhxxxxxarthatbl() {
	}

	public Xxxxih722xwwqqhxxxxxarthatbl(String a0xxukwvbvtxxxxxxxxxusage) {
		this.a0xxukwvbvtxxxxxxxxxusage = a0xxukwvbvtxxxxxxxxxusage;
	}
	public Xxxxih722xwwqqhxxxxxarthatbl(String a0xxukwvbvtxxxxxxxxxusage,
			BigDecimal b1xxzwvwbvxxxxxxxxxxwcbpercnt,
			BigDecimal b2xxzwvibvxxxxxxxxxxinsfactor,
			BigDecimal b3xxzwvvbvxxxxxxxxxxvacatonrate,
			BigDecimal b4xxzwvpbvmxxxxxxxxxpensionmax,
			BigDecimal b5xxzwvwbvmxxxxxxxxxwcbmax,
			BigDecimal b6xxzwvibvmxxxxxxxxxinsmax,
			BigDecimal b7xxzwvibv0xxxxxxxxxitaxlv0rate,
			BigDecimal b8xxzwvibv1xxxxxxxxxitaxlv1rate,
			BigDecimal b9xxzwvibv2xxxxxxxxxitaxlv2rate,
			BigDecimal y1xxzwvibv3xxxxxxxxxitaxlv3rate,
			Integer z1xxzzfxhhxxxxxxxxxxstatusfl,
			Date z2xxcztxlxxxxxxxxxxxstatusfldt,
			String y2xxuznxbvxxxxxxxxxxnotes, String z3xxutoxlhxxxxxxxxxxowner,
			String zzxxu2oxxhxxxxxxxxxxowner2) {
		this.a0xxukwvbvtxxxxxxxxxusage = a0xxukwvbvtxxxxxxxxxusage;
		this.b1xxzwvwbvxxxxxxxxxxwcbpercnt = b1xxzwvwbvxxxxxxxxxxwcbpercnt;
		this.b2xxzwvibvxxxxxxxxxxinsfactor = b2xxzwvibvxxxxxxxxxxinsfactor;
		this.b3xxzwvvbvxxxxxxxxxxvacatonrate = b3xxzwvvbvxxxxxxxxxxvacatonrate;
		this.b4xxzwvpbvmxxxxxxxxxpensionmax = b4xxzwvpbvmxxxxxxxxxpensionmax;
		this.b5xxzwvwbvmxxxxxxxxxwcbmax = b5xxzwvwbvmxxxxxxxxxwcbmax;
		this.b6xxzwvibvmxxxxxxxxxinsmax = b6xxzwvibvmxxxxxxxxxinsmax;
		this.b7xxzwvibv0xxxxxxxxxitaxlv0rate = b7xxzwvibv0xxxxxxxxxitaxlv0rate;
		this.b8xxzwvibv1xxxxxxxxxitaxlv1rate = b8xxzwvibv1xxxxxxxxxitaxlv1rate;
		this.b9xxzwvibv2xxxxxxxxxitaxlv2rate = b9xxzwvibv2xxxxxxxxxitaxlv2rate;
		this.y1xxzwvibv3xxxxxxxxxitaxlv3rate = y1xxzwvibv3xxxxxxxxxitaxlv3rate;
		this.z1xxzzfxhhxxxxxxxxxxstatusfl = z1xxzzfxhhxxxxxxxxxxstatusfl;
		this.z2xxcztxlxxxxxxxxxxxstatusfldt = z2xxcztxlxxxxxxxxxxxstatusfldt;
		this.y2xxuznxbvxxxxxxxxxxnotes = y2xxuznxbvxxxxxxxxxxnotes;
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

	@Column(name = "usage", nullable = false, length = 32)
	@NotNull
	@Size(max = 32)
	public String getA0xxukwvbvtxxxxxxxxxusage() {
		return this.a0xxukwvbvtxxxxxxxxxusage;
	}

	public void setA0xxukwvbvtxxxxxxxxxusage(String a0xxukwvbvtxxxxxxxxxusage) {
		this.a0xxukwvbvtxxxxxxxxxusage = a0xxukwvbvtxxxxxxxxxusage;
	}

	@Column(name = "wcbpercnt", precision = 14)
	public BigDecimal getB1xxzwvwbvxxxxxxxxxxwcbpercnt() {
		return this.b1xxzwvwbvxxxxxxxxxxwcbpercnt;
	}

	public void setB1xxzwvwbvxxxxxxxxxxwcbpercnt(
			BigDecimal b1xxzwvwbvxxxxxxxxxxwcbpercnt) {
		this.b1xxzwvwbvxxxxxxxxxxwcbpercnt = b1xxzwvwbvxxxxxxxxxxwcbpercnt;
	}

	@Column(name = "insfactor", precision = 14)
	public BigDecimal getB2xxzwvibvxxxxxxxxxxinsfactor() {
		return this.b2xxzwvibvxxxxxxxxxxinsfactor;
	}

	public void setB2xxzwvibvxxxxxxxxxxinsfactor(
			BigDecimal b2xxzwvibvxxxxxxxxxxinsfactor) {
		this.b2xxzwvibvxxxxxxxxxxinsfactor = b2xxzwvibvxxxxxxxxxxinsfactor;
	}

	@Column(name = "vacatonrate", precision = 14)
	public BigDecimal getB3xxzwvvbvxxxxxxxxxxvacatonrate() {
		return this.b3xxzwvvbvxxxxxxxxxxvacatonrate;
	}

	public void setB3xxzwvvbvxxxxxxxxxxvacatonrate(
			BigDecimal b3xxzwvvbvxxxxxxxxxxvacatonrate) {
		this.b3xxzwvvbvxxxxxxxxxxvacatonrate = b3xxzwvvbvxxxxxxxxxxvacatonrate;
	}

	@Column(name = "pensionmax", precision = 14)
	public BigDecimal getB4xxzwvpbvmxxxxxxxxxpensionmax() {
		return this.b4xxzwvpbvmxxxxxxxxxpensionmax;
	}

	public void setB4xxzwvpbvmxxxxxxxxxpensionmax(
			BigDecimal b4xxzwvpbvmxxxxxxxxxpensionmax) {
		this.b4xxzwvpbvmxxxxxxxxxpensionmax = b4xxzwvpbvmxxxxxxxxxpensionmax;
	}

	@Column(name = "wcbmax", precision = 14)
	public BigDecimal getB5xxzwvwbvmxxxxxxxxxwcbmax() {
		return this.b5xxzwvwbvmxxxxxxxxxwcbmax;
	}

	public void setB5xxzwvwbvmxxxxxxxxxwcbmax(
			BigDecimal b5xxzwvwbvmxxxxxxxxxwcbmax) {
		this.b5xxzwvwbvmxxxxxxxxxwcbmax = b5xxzwvwbvmxxxxxxxxxwcbmax;
	}

	@Column(name = "insmax", precision = 14)
	public BigDecimal getB6xxzwvibvmxxxxxxxxxinsmax() {
		return this.b6xxzwvibvmxxxxxxxxxinsmax;
	}

	public void setB6xxzwvibvmxxxxxxxxxinsmax(
			BigDecimal b6xxzwvibvmxxxxxxxxxinsmax) {
		this.b6xxzwvibvmxxxxxxxxxinsmax = b6xxzwvibvmxxxxxxxxxinsmax;
	}

	@Column(name = "itaxlv0rate", precision = 14)
	public BigDecimal getB7xxzwvibv0xxxxxxxxxitaxlv0rate() {
		return this.b7xxzwvibv0xxxxxxxxxitaxlv0rate;
	}

	public void setB7xxzwvibv0xxxxxxxxxitaxlv0rate(
			BigDecimal b7xxzwvibv0xxxxxxxxxitaxlv0rate) {
		this.b7xxzwvibv0xxxxxxxxxitaxlv0rate = b7xxzwvibv0xxxxxxxxxitaxlv0rate;
	}

	@Column(name = "itaxlv1rate", precision = 14)
	public BigDecimal getB8xxzwvibv1xxxxxxxxxitaxlv1rate() {
		return this.b8xxzwvibv1xxxxxxxxxitaxlv1rate;
	}

	public void setB8xxzwvibv1xxxxxxxxxitaxlv1rate(
			BigDecimal b8xxzwvibv1xxxxxxxxxitaxlv1rate) {
		this.b8xxzwvibv1xxxxxxxxxitaxlv1rate = b8xxzwvibv1xxxxxxxxxitaxlv1rate;
	}

	@Column(name = "itaxlv2rate", precision = 14)
	public BigDecimal getB9xxzwvibv2xxxxxxxxxitaxlv2rate() {
		return this.b9xxzwvibv2xxxxxxxxxitaxlv2rate;
	}

	public void setB9xxzwvibv2xxxxxxxxxitaxlv2rate(
			BigDecimal b9xxzwvibv2xxxxxxxxxitaxlv2rate) {
		this.b9xxzwvibv2xxxxxxxxxitaxlv2rate = b9xxzwvibv2xxxxxxxxxitaxlv2rate;
	}

	@Column(name = "itaxlv3rate", precision = 14)
	public BigDecimal getY1xxzwvibv3xxxxxxxxxitaxlv3rate() {
		return this.y1xxzwvibv3xxxxxxxxxitaxlv3rate;
	}

	public void setY1xxzwvibv3xxxxxxxxxitaxlv3rate(
			BigDecimal y1xxzwvibv3xxxxxxxxxitaxlv3rate) {
		this.y1xxzwvibv3xxxxxxxxxitaxlv3rate = y1xxzwvibv3xxxxxxxxxitaxlv3rate;
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

	@Column(name = "notes")
	public String getY2xxuznxbvxxxxxxxxxxnotes() {
		return this.y2xxuznxbvxxxxxxxxxxnotes;
	}

	public void setY2xxuznxbvxxxxxxxxxxnotes(String y2xxuznxbvxxxxxxxxxxnotes) {
		this.y2xxuznxbvxxxxxxxxxxnotes = y2xxuznxbvxxxxxxxxxxnotes;
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
