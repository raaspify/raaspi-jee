package com.rcomputer.genapp.model;
// Generated 30-Jun-2023 1:54:00 PM by Hibernate Tools 4.0.0

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
 * Xxxxch6ahxhhhhhxxxxxhlogfile generated by hbm2java
 */
@Entity
@XmlRootElement
@Table(name = "hlogfile")
public class Xxxxch6ahxhhhhhxxxxxhlogfile implements java.io.Serializable {

	private Integer a0xxuobxbxxxxxxxxxxxsid;
	private String a0xxukxxbvxxxxxxxxxxserialno;
	private String z1xxuxxrbvxxxxxxxxxxmatcode;
	private Integer z2xxzxqrbvxxxxxxxxxxquanrecd;
	private String z3xxuxxrbvxxxxxxxxxxvendor;
	private String z5xxuxxrbvlxxxxxxxxxlocation;
	private String z6xxuxxrbvxxxxxxxxxxrecvrpt;
	private Boolean z7xxfxxxbvxxxxxxxxxxinflg;
	private Boolean z8xxfxxxbvxxxxxxxxxxphy;
	private Date z9xxcxxrlxxxxxxxxxxxdatetin;
	private Date zaxxcxxrlxxxxxxxxxxxdatetout;
	private String zbxxuxxrbvxxxxxxxxxxjobno;
	private Integer zcxxzzprhvxxxxxxxxxxprintmstat;
	private Date zdxxczqxlhxxxxxxxxxxprinmtfldt;
	private String zexxuxxrbvxxxxxxxxxxpono;
	private Date zfxxcxxrlxxxxxxxxxxxscandatet;
	private Integer zgxxzxqrbvxxxxxxxxxxquanissd;
	private String zhxxuxxrbvxxxxxxxxxxbutt;
	private Integer zixxzzfxhhxxxxxxxxxxstatusfl;
	private BigDecimal zjxxcxqrlxxxxxxxxxxxquanrejd;
	private String zkxxuxxrbvxxxxxxxxxxcustomer;
	private String zmxxuxxrbvxxxxxxxxxxcpono;
	private String xznxuxxrbvxxxxxxxxxxcustomej;
	private BigDecimal zpxxzcxrlxxxxxxxxxxxorgcost;
	private String zqxxuxxrbvxxxxxxxxxxorgpono;
	private String zrxxuxxrbvxxxxxxxxxxorgjobno;
	private String zsxxuxxrbvxxxxxxxxxxaltserno;
	private BigDecimal ztxxcxxrlxxxxxxxxxxxselprice;
	private BigDecimal zuxxcxxrlxxxxxxxxxxxphysqty;
	private String zvxxuxxrbvxxsxxxxxxxsperson;
	private String zwxxuxxrbvxxxxxxxxxxcartonid;
	private Boolean zxxxfxxxbvxxxxxxxxxxcartonpr;
	private String zyxxuxxrbvxxxxxxxxxxpackcode;
	private String zzxxuxxrbvxxxxxxxxxxtarecode;
	private String zzxxuxxrbvxxxxxxxxxxshipcode;
	private String zzxxuxxrbvxxxxxxxxxxtype;
	private Date zzxxcztxlxxxxxxxxxxxstatusfldt;
	private String zzxxutoxlhxxxxxxxxxxowner;
	private String zzxxu2oxxhxxxxxxxxxxowner2;

	public Xxxxch6ahxhhhhhxxxxxhlogfile() {
	}

	public Xxxxch6ahxhhhhhxxxxxhlogfile(String a0xxukxxbvxxxxxxxxxxserialno) {
		this.a0xxukxxbvxxxxxxxxxxserialno = a0xxukxxbvxxxxxxxxxxserialno;
	}
	public Xxxxch6ahxhhhhhxxxxxhlogfile(String a0xxukxxbvxxxxxxxxxxserialno,
			String z1xxuxxrbvxxxxxxxxxxmatcode,
			Integer z2xxzxqrbvxxxxxxxxxxquanrecd,
			String z3xxuxxrbvxxxxxxxxxxvendor,
			String z5xxuxxrbvlxxxxxxxxxlocation,
			String z6xxuxxrbvxxxxxxxxxxrecvrpt,
			Boolean z7xxfxxxbvxxxxxxxxxxinflg, Boolean z8xxfxxxbvxxxxxxxxxxphy,
			Date z9xxcxxrlxxxxxxxxxxxdatetin,
			Date zaxxcxxrlxxxxxxxxxxxdatetout,
			String zbxxuxxrbvxxxxxxxxxxjobno,
			Integer zcxxzzprhvxxxxxxxxxxprintmstat,
			Date zdxxczqxlhxxxxxxxxxxprinmtfldt,
			String zexxuxxrbvxxxxxxxxxxpono,
			Date zfxxcxxrlxxxxxxxxxxxscandatet,
			Integer zgxxzxqrbvxxxxxxxxxxquanissd,
			String zhxxuxxrbvxxxxxxxxxxbutt,
			Integer zixxzzfxhhxxxxxxxxxxstatusfl,
			BigDecimal zjxxcxqrlxxxxxxxxxxxquanrejd,
			String zkxxuxxrbvxxxxxxxxxxcustomer,
			String zmxxuxxrbvxxxxxxxxxxcpono,
			String xznxuxxrbvxxxxxxxxxxcustomej,
			BigDecimal zpxxzcxrlxxxxxxxxxxxorgcost,
			String zqxxuxxrbvxxxxxxxxxxorgpono,
			String zrxxuxxrbvxxxxxxxxxxorgjobno,
			String zsxxuxxrbvxxxxxxxxxxaltserno,
			BigDecimal ztxxcxxrlxxxxxxxxxxxselprice,
			BigDecimal zuxxcxxrlxxxxxxxxxxxphysqty,
			String zvxxuxxrbvxxsxxxxxxxsperson,
			String zwxxuxxrbvxxxxxxxxxxcartonid,
			Boolean zxxxfxxxbvxxxxxxxxxxcartonpr,
			String zyxxuxxrbvxxxxxxxxxxpackcode,
			String zzxxuxxrbvxxxxxxxxxxtarecode,
			String zzxxuxxrbvxxxxxxxxxxshipcode,
			String zzxxuxxrbvxxxxxxxxxxtype,
			Date zzxxcztxlxxxxxxxxxxxstatusfldt,
			String zzxxutoxlhxxxxxxxxxxowner, String zzxxu2oxxhxxxxxxxxxxowner2) {
		this.a0xxukxxbvxxxxxxxxxxserialno = a0xxukxxbvxxxxxxxxxxserialno;
		this.z1xxuxxrbvxxxxxxxxxxmatcode = z1xxuxxrbvxxxxxxxxxxmatcode;
		this.z2xxzxqrbvxxxxxxxxxxquanrecd = z2xxzxqrbvxxxxxxxxxxquanrecd;
		this.z3xxuxxrbvxxxxxxxxxxvendor = z3xxuxxrbvxxxxxxxxxxvendor;
		this.z5xxuxxrbvlxxxxxxxxxlocation = z5xxuxxrbvlxxxxxxxxxlocation;
		this.z6xxuxxrbvxxxxxxxxxxrecvrpt = z6xxuxxrbvxxxxxxxxxxrecvrpt;
		this.z7xxfxxxbvxxxxxxxxxxinflg = z7xxfxxxbvxxxxxxxxxxinflg;
		this.z8xxfxxxbvxxxxxxxxxxphy = z8xxfxxxbvxxxxxxxxxxphy;
		this.z9xxcxxrlxxxxxxxxxxxdatetin = z9xxcxxrlxxxxxxxxxxxdatetin;
		this.zaxxcxxrlxxxxxxxxxxxdatetout = zaxxcxxrlxxxxxxxxxxxdatetout;
		this.zbxxuxxrbvxxxxxxxxxxjobno = zbxxuxxrbvxxxxxxxxxxjobno;
		this.zcxxzzprhvxxxxxxxxxxprintmstat = zcxxzzprhvxxxxxxxxxxprintmstat;
		this.zdxxczqxlhxxxxxxxxxxprinmtfldt = zdxxczqxlhxxxxxxxxxxprinmtfldt;
		this.zexxuxxrbvxxxxxxxxxxpono = zexxuxxrbvxxxxxxxxxxpono;
		this.zfxxcxxrlxxxxxxxxxxxscandatet = zfxxcxxrlxxxxxxxxxxxscandatet;
		this.zgxxzxqrbvxxxxxxxxxxquanissd = zgxxzxqrbvxxxxxxxxxxquanissd;
		this.zhxxuxxrbvxxxxxxxxxxbutt = zhxxuxxrbvxxxxxxxxxxbutt;
		this.zixxzzfxhhxxxxxxxxxxstatusfl = zixxzzfxhhxxxxxxxxxxstatusfl;
		this.zjxxcxqrlxxxxxxxxxxxquanrejd = zjxxcxqrlxxxxxxxxxxxquanrejd;
		this.zkxxuxxrbvxxxxxxxxxxcustomer = zkxxuxxrbvxxxxxxxxxxcustomer;
		this.zmxxuxxrbvxxxxxxxxxxcpono = zmxxuxxrbvxxxxxxxxxxcpono;
		this.xznxuxxrbvxxxxxxxxxxcustomej = xznxuxxrbvxxxxxxxxxxcustomej;
		this.zpxxzcxrlxxxxxxxxxxxorgcost = zpxxzcxrlxxxxxxxxxxxorgcost;
		this.zqxxuxxrbvxxxxxxxxxxorgpono = zqxxuxxrbvxxxxxxxxxxorgpono;
		this.zrxxuxxrbvxxxxxxxxxxorgjobno = zrxxuxxrbvxxxxxxxxxxorgjobno;
		this.zsxxuxxrbvxxxxxxxxxxaltserno = zsxxuxxrbvxxxxxxxxxxaltserno;
		this.ztxxcxxrlxxxxxxxxxxxselprice = ztxxcxxrlxxxxxxxxxxxselprice;
		this.zuxxcxxrlxxxxxxxxxxxphysqty = zuxxcxxrlxxxxxxxxxxxphysqty;
		this.zvxxuxxrbvxxsxxxxxxxsperson = zvxxuxxrbvxxsxxxxxxxsperson;
		this.zwxxuxxrbvxxxxxxxxxxcartonid = zwxxuxxrbvxxxxxxxxxxcartonid;
		this.zxxxfxxxbvxxxxxxxxxxcartonpr = zxxxfxxxbvxxxxxxxxxxcartonpr;
		this.zyxxuxxrbvxxxxxxxxxxpackcode = zyxxuxxrbvxxxxxxxxxxpackcode;
		this.zzxxuxxrbvxxxxxxxxxxtarecode = zzxxuxxrbvxxxxxxxxxxtarecode;
		this.zzxxuxxrbvxxxxxxxxxxshipcode = zzxxuxxrbvxxxxxxxxxxshipcode;
		this.zzxxuxxrbvxxxxxxxxxxtype = zzxxuxxrbvxxxxxxxxxxtype;
		this.zzxxcztxlxxxxxxxxxxxstatusfldt = zzxxcztxlxxxxxxxxxxxstatusfldt;
		this.zzxxutoxlhxxxxxxxxxxowner = zzxxutoxlhxxxxxxxxxxowner;
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

	@Column(name = "serialno", nullable = false, length = 25)
	@NotNull
	@Size(max = 25)
	public String getA0xxukxxbvxxxxxxxxxxserialno() {
		return this.a0xxukxxbvxxxxxxxxxxserialno;
	}

	public void setA0xxukxxbvxxxxxxxxxxserialno(
			String a0xxukxxbvxxxxxxxxxxserialno) {
		this.a0xxukxxbvxxxxxxxxxxserialno = a0xxukxxbvxxxxxxxxxxserialno;
	}

	@Column(name = "matcode", length = 32)
	@Size(max = 32)
	public String getZ1xxuxxrbvxxxxxxxxxxmatcode() {
		return this.z1xxuxxrbvxxxxxxxxxxmatcode;
	}

	public void setZ1xxuxxrbvxxxxxxxxxxmatcode(
			String z1xxuxxrbvxxxxxxxxxxmatcode) {
		this.z1xxuxxrbvxxxxxxxxxxmatcode = z1xxuxxrbvxxxxxxxxxxmatcode;
	}

	@Column(name = "quanrecd")
	public Integer getZ2xxzxqrbvxxxxxxxxxxquanrecd() {
		return this.z2xxzxqrbvxxxxxxxxxxquanrecd;
	}

	public void setZ2xxzxqrbvxxxxxxxxxxquanrecd(
			Integer z2xxzxqrbvxxxxxxxxxxquanrecd) {
		this.z2xxzxqrbvxxxxxxxxxxquanrecd = z2xxzxqrbvxxxxxxxxxxquanrecd;
	}

	@Column(name = "vendor", length = 20)
	@Size(max = 20)
	public String getZ3xxuxxrbvxxxxxxxxxxvendor() {
		return this.z3xxuxxrbvxxxxxxxxxxvendor;
	}

	public void setZ3xxuxxrbvxxxxxxxxxxvendor(String z3xxuxxrbvxxxxxxxxxxvendor) {
		this.z3xxuxxrbvxxxxxxxxxxvendor = z3xxuxxrbvxxxxxxxxxxvendor;
	}

	@Column(name = "location", length = 20)
	@Size(max = 20)
	public String getZ5xxuxxrbvlxxxxxxxxxlocation() {
		return this.z5xxuxxrbvlxxxxxxxxxlocation;
	}

	public void setZ5xxuxxrbvlxxxxxxxxxlocation(
			String z5xxuxxrbvlxxxxxxxxxlocation) {
		this.z5xxuxxrbvlxxxxxxxxxlocation = z5xxuxxrbvlxxxxxxxxxlocation;
	}

	@Column(name = "recvrpt", length = 25)
	@Size(max = 25)
	public String getZ6xxuxxrbvxxxxxxxxxxrecvrpt() {
		return this.z6xxuxxrbvxxxxxxxxxxrecvrpt;
	}

	public void setZ6xxuxxrbvxxxxxxxxxxrecvrpt(
			String z6xxuxxrbvxxxxxxxxxxrecvrpt) {
		this.z6xxuxxrbvxxxxxxxxxxrecvrpt = z6xxuxxrbvxxxxxxxxxxrecvrpt;
	}

	@Column(name = "inflg")
	public Boolean getZ7xxfxxxbvxxxxxxxxxxinflg() {
		return this.z7xxfxxxbvxxxxxxxxxxinflg;
	}

	public void setZ7xxfxxxbvxxxxxxxxxxinflg(Boolean z7xxfxxxbvxxxxxxxxxxinflg) {
		this.z7xxfxxxbvxxxxxxxxxxinflg = z7xxfxxxbvxxxxxxxxxxinflg;
	}

	@Column(name = "phy")
	public Boolean getZ8xxfxxxbvxxxxxxxxxxphy() {
		return this.z8xxfxxxbvxxxxxxxxxxphy;
	}

	public void setZ8xxfxxxbvxxxxxxxxxxphy(Boolean z8xxfxxxbvxxxxxxxxxxphy) {
		this.z8xxfxxxbvxxxxxxxxxxphy = z8xxfxxxbvxxxxxxxxxxphy;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "datetin", length = 29)
	public Date getZ9xxcxxrlxxxxxxxxxxxdatetin() {
		return this.z9xxcxxrlxxxxxxxxxxxdatetin;
	}

	public void setZ9xxcxxrlxxxxxxxxxxxdatetin(Date z9xxcxxrlxxxxxxxxxxxdatetin) {
		this.z9xxcxxrlxxxxxxxxxxxdatetin = z9xxcxxrlxxxxxxxxxxxdatetin;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "datetout", length = 29)
	public Date getZaxxcxxrlxxxxxxxxxxxdatetout() {
		return this.zaxxcxxrlxxxxxxxxxxxdatetout;
	}

	public void setZaxxcxxrlxxxxxxxxxxxdatetout(
			Date zaxxcxxrlxxxxxxxxxxxdatetout) {
		this.zaxxcxxrlxxxxxxxxxxxdatetout = zaxxcxxrlxxxxxxxxxxxdatetout;
	}

	@Column(name = "jobno", length = 20)
	@Size(max = 20)
	public String getZbxxuxxrbvxxxxxxxxxxjobno() {
		return this.zbxxuxxrbvxxxxxxxxxxjobno;
	}

	public void setZbxxuxxrbvxxxxxxxxxxjobno(String zbxxuxxrbvxxxxxxxxxxjobno) {
		this.zbxxuxxrbvxxxxxxxxxxjobno = zbxxuxxrbvxxxxxxxxxxjobno;
	}

	@Column(name = "printmstat")
	public Integer getZcxxzzprhvxxxxxxxxxxprintmstat() {
		return this.zcxxzzprhvxxxxxxxxxxprintmstat;
	}

	public void setZcxxzzprhvxxxxxxxxxxprintmstat(
			Integer zcxxzzprhvxxxxxxxxxxprintmstat) {
		this.zcxxzzprhvxxxxxxxxxxprintmstat = zcxxzzprhvxxxxxxxxxxprintmstat;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "prinmtfldt", length = 29)
	public Date getZdxxczqxlhxxxxxxxxxxprinmtfldt() {
		return this.zdxxczqxlhxxxxxxxxxxprinmtfldt;
	}

	public void setZdxxczqxlhxxxxxxxxxxprinmtfldt(
			Date zdxxczqxlhxxxxxxxxxxprinmtfldt) {
		this.zdxxczqxlhxxxxxxxxxxprinmtfldt = zdxxczqxlhxxxxxxxxxxprinmtfldt;
	}

	@Column(name = "pono", length = 20)
	@Size(max = 20)
	public String getZexxuxxrbvxxxxxxxxxxpono() {
		return this.zexxuxxrbvxxxxxxxxxxpono;
	}

	public void setZexxuxxrbvxxxxxxxxxxpono(String zexxuxxrbvxxxxxxxxxxpono) {
		this.zexxuxxrbvxxxxxxxxxxpono = zexxuxxrbvxxxxxxxxxxpono;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "scandatet", length = 29)
	public Date getZfxxcxxrlxxxxxxxxxxxscandatet() {
		return this.zfxxcxxrlxxxxxxxxxxxscandatet;
	}

	public void setZfxxcxxrlxxxxxxxxxxxscandatet(
			Date zfxxcxxrlxxxxxxxxxxxscandatet) {
		this.zfxxcxxrlxxxxxxxxxxxscandatet = zfxxcxxrlxxxxxxxxxxxscandatet;
	}

	@Column(name = "quanissd")
	public Integer getZgxxzxqrbvxxxxxxxxxxquanissd() {
		return this.zgxxzxqrbvxxxxxxxxxxquanissd;
	}

	public void setZgxxzxqrbvxxxxxxxxxxquanissd(
			Integer zgxxzxqrbvxxxxxxxxxxquanissd) {
		this.zgxxzxqrbvxxxxxxxxxxquanissd = zgxxzxqrbvxxxxxxxxxxquanissd;
	}

	@Column(name = "butt", length = 25)
	@Size(max = 25)
	public String getZhxxuxxrbvxxxxxxxxxxbutt() {
		return this.zhxxuxxrbvxxxxxxxxxxbutt;
	}

	public void setZhxxuxxrbvxxxxxxxxxxbutt(String zhxxuxxrbvxxxxxxxxxxbutt) {
		this.zhxxuxxrbvxxxxxxxxxxbutt = zhxxuxxrbvxxxxxxxxxxbutt;
	}

	@Column(name = "statusfl")
	public Integer getZixxzzfxhhxxxxxxxxxxstatusfl() {
		return this.zixxzzfxhhxxxxxxxxxxstatusfl;
	}

	public void setZixxzzfxhhxxxxxxxxxxstatusfl(
			Integer zixxzzfxhhxxxxxxxxxxstatusfl) {
		this.zixxzzfxhhxxxxxxxxxxstatusfl = zixxzzfxhhxxxxxxxxxxstatusfl;
	}

	@Column(name = "quanrejd", precision = 14)
	public BigDecimal getZjxxcxqrlxxxxxxxxxxxquanrejd() {
		return this.zjxxcxqrlxxxxxxxxxxxquanrejd;
	}

	public void setZjxxcxqrlxxxxxxxxxxxquanrejd(
			BigDecimal zjxxcxqrlxxxxxxxxxxxquanrejd) {
		this.zjxxcxqrlxxxxxxxxxxxquanrejd = zjxxcxqrlxxxxxxxxxxxquanrejd;
	}

	@Column(name = "customer", length = 25)
	@Size(max = 25)
	public String getZkxxuxxrbvxxxxxxxxxxcustomer() {
		return this.zkxxuxxrbvxxxxxxxxxxcustomer;
	}

	public void setZkxxuxxrbvxxxxxxxxxxcustomer(
			String zkxxuxxrbvxxxxxxxxxxcustomer) {
		this.zkxxuxxrbvxxxxxxxxxxcustomer = zkxxuxxrbvxxxxxxxxxxcustomer;
	}

	@Column(name = "cpono", length = 20)
	@Size(max = 20)
	public String getZmxxuxxrbvxxxxxxxxxxcpono() {
		return this.zmxxuxxrbvxxxxxxxxxxcpono;
	}

	public void setZmxxuxxrbvxxxxxxxxxxcpono(String zmxxuxxrbvxxxxxxxxxxcpono) {
		this.zmxxuxxrbvxxxxxxxxxxcpono = zmxxuxxrbvxxxxxxxxxxcpono;
	}

	@Column(name = "customej", length = 25)
	@Size(max = 25)
	public String getXznxuxxrbvxxxxxxxxxxcustomej() {
		return this.xznxuxxrbvxxxxxxxxxxcustomej;
	}

	public void setXznxuxxrbvxxxxxxxxxxcustomej(
			String xznxuxxrbvxxxxxxxxxxcustomej) {
		this.xznxuxxrbvxxxxxxxxxxcustomej = xznxuxxrbvxxxxxxxxxxcustomej;
	}

	@Column(name = "orgcost", precision = 14)
	public BigDecimal getZpxxzcxrlxxxxxxxxxxxorgcost() {
		return this.zpxxzcxrlxxxxxxxxxxxorgcost;
	}

	public void setZpxxzcxrlxxxxxxxxxxxorgcost(
			BigDecimal zpxxzcxrlxxxxxxxxxxxorgcost) {
		this.zpxxzcxrlxxxxxxxxxxxorgcost = zpxxzcxrlxxxxxxxxxxxorgcost;
	}

	@Column(name = "orgpono", length = 20)
	@Size(max = 20)
	public String getZqxxuxxrbvxxxxxxxxxxorgpono() {
		return this.zqxxuxxrbvxxxxxxxxxxorgpono;
	}

	public void setZqxxuxxrbvxxxxxxxxxxorgpono(
			String zqxxuxxrbvxxxxxxxxxxorgpono) {
		this.zqxxuxxrbvxxxxxxxxxxorgpono = zqxxuxxrbvxxxxxxxxxxorgpono;
	}

	@Column(name = "orgjobno", length = 20)
	@Size(max = 20)
	public String getZrxxuxxrbvxxxxxxxxxxorgjobno() {
		return this.zrxxuxxrbvxxxxxxxxxxorgjobno;
	}

	public void setZrxxuxxrbvxxxxxxxxxxorgjobno(
			String zrxxuxxrbvxxxxxxxxxxorgjobno) {
		this.zrxxuxxrbvxxxxxxxxxxorgjobno = zrxxuxxrbvxxxxxxxxxxorgjobno;
	}

	@Column(name = "altserno", length = 25)
	@Size(max = 25)
	public String getZsxxuxxrbvxxxxxxxxxxaltserno() {
		return this.zsxxuxxrbvxxxxxxxxxxaltserno;
	}

	public void setZsxxuxxrbvxxxxxxxxxxaltserno(
			String zsxxuxxrbvxxxxxxxxxxaltserno) {
		this.zsxxuxxrbvxxxxxxxxxxaltserno = zsxxuxxrbvxxxxxxxxxxaltserno;
	}

	@Column(name = "selprice", precision = 14)
	public BigDecimal getZtxxcxxrlxxxxxxxxxxxselprice() {
		return this.ztxxcxxrlxxxxxxxxxxxselprice;
	}

	public void setZtxxcxxrlxxxxxxxxxxxselprice(
			BigDecimal ztxxcxxrlxxxxxxxxxxxselprice) {
		this.ztxxcxxrlxxxxxxxxxxxselprice = ztxxcxxrlxxxxxxxxxxxselprice;
	}

	@Column(name = "physqty", precision = 14)
	public BigDecimal getZuxxcxxrlxxxxxxxxxxxphysqty() {
		return this.zuxxcxxrlxxxxxxxxxxxphysqty;
	}

	public void setZuxxcxxrlxxxxxxxxxxxphysqty(
			BigDecimal zuxxcxxrlxxxxxxxxxxxphysqty) {
		this.zuxxcxxrlxxxxxxxxxxxphysqty = zuxxcxxrlxxxxxxxxxxxphysqty;
	}

	@Column(name = "sperson", length = 25)
	@Size(max = 25)
	public String getZvxxuxxrbvxxsxxxxxxxsperson() {
		return this.zvxxuxxrbvxxsxxxxxxxsperson;
	}

	public void setZvxxuxxrbvxxsxxxxxxxsperson(
			String zvxxuxxrbvxxsxxxxxxxsperson) {
		this.zvxxuxxrbvxxsxxxxxxxsperson = zvxxuxxrbvxxsxxxxxxxsperson;
	}

	@Column(name = "cartonid", length = 25)
	@Size(max = 25)
	public String getZwxxuxxrbvxxxxxxxxxxcartonid() {
		return this.zwxxuxxrbvxxxxxxxxxxcartonid;
	}

	public void setZwxxuxxrbvxxxxxxxxxxcartonid(
			String zwxxuxxrbvxxxxxxxxxxcartonid) {
		this.zwxxuxxrbvxxxxxxxxxxcartonid = zwxxuxxrbvxxxxxxxxxxcartonid;
	}

	@Column(name = "cartonpr")
	public Boolean getZxxxfxxxbvxxxxxxxxxxcartonpr() {
		return this.zxxxfxxxbvxxxxxxxxxxcartonpr;
	}

	public void setZxxxfxxxbvxxxxxxxxxxcartonpr(
			Boolean zxxxfxxxbvxxxxxxxxxxcartonpr) {
		this.zxxxfxxxbvxxxxxxxxxxcartonpr = zxxxfxxxbvxxxxxxxxxxcartonpr;
	}

	@Column(name = "packcode", length = 20)
	@Size(max = 20)
	public String getZyxxuxxrbvxxxxxxxxxxpackcode() {
		return this.zyxxuxxrbvxxxxxxxxxxpackcode;
	}

	public void setZyxxuxxrbvxxxxxxxxxxpackcode(
			String zyxxuxxrbvxxxxxxxxxxpackcode) {
		this.zyxxuxxrbvxxxxxxxxxxpackcode = zyxxuxxrbvxxxxxxxxxxpackcode;
	}

	@Column(name = "tarecode", length = 20)
	@Size(max = 20)
	public String getZzxxuxxrbvxxxxxxxxxxtarecode() {
		return this.zzxxuxxrbvxxxxxxxxxxtarecode;
	}

	public void setZzxxuxxrbvxxxxxxxxxxtarecode(
			String zzxxuxxrbvxxxxxxxxxxtarecode) {
		this.zzxxuxxrbvxxxxxxxxxxtarecode = zzxxuxxrbvxxxxxxxxxxtarecode;
	}

	@Column(name = "shipcode", length = 20)
	@Size(max = 20)
	public String getZzxxuxxrbvxxxxxxxxxxshipcode() {
		return this.zzxxuxxrbvxxxxxxxxxxshipcode;
	}

	public void setZzxxuxxrbvxxxxxxxxxxshipcode(
			String zzxxuxxrbvxxxxxxxxxxshipcode) {
		this.zzxxuxxrbvxxxxxxxxxxshipcode = zzxxuxxrbvxxxxxxxxxxshipcode;
	}

	@Column(name = "type", length = 12)
	@Size(max = 12)
	public String getZzxxuxxrbvxxxxxxxxxxtype() {
		return this.zzxxuxxrbvxxxxxxxxxxtype;
	}

	public void setZzxxuxxrbvxxxxxxxxxxtype(String zzxxuxxrbvxxxxxxxxxxtype) {
		this.zzxxuxxrbvxxxxxxxxxxtype = zzxxuxxrbvxxxxxxxxxxtype;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "statusfldt", length = 29)
	public Date getZzxxcztxlxxxxxxxxxxxstatusfldt() {
		return this.zzxxcztxlxxxxxxxxxxxstatusfldt;
	}

	public void setZzxxcztxlxxxxxxxxxxxstatusfldt(
			Date zzxxcztxlxxxxxxxxxxxstatusfldt) {
		this.zzxxcztxlxxxxxxxxxxxstatusfldt = zzxxcztxlxxxxxxxxxxxstatusfldt;
	}

	@Column(name = "owner", length = 40)
	@Size(max = 40)
	public String getZzxxutoxlhxxxxxxxxxxowner() {
		return this.zzxxutoxlhxxxxxxxxxxowner;
	}

	public void setZzxxutoxlhxxxxxxxxxxowner(String zzxxutoxlhxxxxxxxxxxowner) {
		this.zzxxutoxlhxxxxxxxxxxowner = zzxxutoxlhxxxxxxxxxxowner;
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
