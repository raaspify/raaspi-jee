package com.rcomputer.genapp.model;
// Generated 11-Jul-2023 11:51:00 AM by Hibernate Tools 4.0.0

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
 * Jxxxuq21bxwwqqhxxxxxccontact generated by hbm2java
 */
@Entity
@XmlRootElement
@Table(name = "ccontact")
public class Jxxxuq21bxwwqqhxxxxxccontact implements java.io.Serializable {

	private Integer a0xxuobxbxxxxxxxxxxxsid;
	private Fxxxcq144xwwqqhxxxxxlocation fxxxcq144xwwqqhxxxxxlocation;
	private Fxxxuq111xwwqqhxxxxxaddress fxxxuq111xwwqqhxxxxxaddressByMailtocode;
	private Jxxxuq201xwwqqhxxxxxcustomer jxxxuq201xwwqqhxxxxxcustomer;
	private Fxxxuq111xwwqqhxxxxxaddress fxxxuq111xwwqqhxxxxxaddressByShiptocode;
	private String a0xxukxxbvxxxxxxxxxxcontact;
	private String b1xxuxxxbv21xxxxxxxxtitle;
	private String b2xxuxxxbv22xxxxxxxxjobtitle;
	private String b3xxuslrbvixxxxxxxxxlastname;
	private String b4xxu3frbvixxxxxxxxxfirstname;
	private String b5xxuxxrbvixxxxxxxxxmiddlenam;
	private Boolean c1xxfxz1bvxxxxxxxxxxtax1;
	private Boolean c2xxfxz2bvxxxxxxxxxxtax2;
	private Boolean y1xxfxz3bvxxxxxxxxxxtax3;
	private String c3xxuz1xbv04xxxxxxxxcusttax1;
	private String c4xxuz2xbv05xxxxxxxxcusttax2;
	private String y2xxuz3xxvxxxxxxxxxxcusttax3;
	private String p1xxh4pobv27xxxxxxxxphoneo;
	private String p2xxh5phbv27xxxxxxxxphoneh;
	private String p3xxhxxxbv27xxxxxxxxphonec;
	private String p4xxhxxxbv27xxxxxxxxphonex;
	private String p5xxhxxrbv19xxxxxxxxlanaddr;
	private String p6xxhxxrbv25xxxxxxxxwanaddr;
	private String p7xxhxxrbv44xxxxxxxxlmailaddr;
	private String p8xxhxxrbv24xxxxxxxximailaddr;
	private String p9xxuxxrbvxxxxxxxxxxrmailaddr;
	private String paxxhxxrbv23xxxxxxxxintaddr;
	private String pbxxhxxrbvxxxxxxxxxxinraddr;
	private Integer z1xxzzprhvxxxxxxxxxxprintmstat;
	private Date z2xxczqxlhxxxxxxxxxxprinmtfldt;
	private Boolean y5xxfxxrbvxxxxxxxxxxshiplabel;
	private String y6xxuxxrbv29xxxxxxxxtype;
	private Integer z3xxzzfxhhxxxxxxxxxxstatusfl;
	private Date z4xxcztxlxxxxxxxxxxxstatusfldt;
	private String y7xxuzkybvxxxxxxxxxxkeywords;
	private String y8xxuznxbvxxxxxxxxxxnotes;
	private String z7xxutoxlhxxxxxxxxxxowner;
	private String zzxxu2oxxhxxxxxxxxxxowner2;
	private String y9xxuzdrbvxxxxxxxxxxdocmnt;

	public Jxxxuq21bxwwqqhxxxxxccontact() {
	}

	public Jxxxuq21bxwwqqhxxxxxccontact(String a0xxukxxbvxxxxxxxxxxcontact) {
		this.a0xxukxxbvxxxxxxxxxxcontact = a0xxukxxbvxxxxxxxxxxcontact;
	}
	public Jxxxuq21bxwwqqhxxxxxccontact(
			Fxxxcq144xwwqqhxxxxxlocation fxxxcq144xwwqqhxxxxxlocation,
			Fxxxuq111xwwqqhxxxxxaddress fxxxuq111xwwqqhxxxxxaddressByMailtocode,
			Jxxxuq201xwwqqhxxxxxcustomer jxxxuq201xwwqqhxxxxxcustomer,
			Fxxxuq111xwwqqhxxxxxaddress fxxxuq111xwwqqhxxxxxaddressByShiptocode,
			String a0xxukxxbvxxxxxxxxxxcontact,
			String b1xxuxxxbv21xxxxxxxxtitle,
			String b2xxuxxxbv22xxxxxxxxjobtitle,
			String b3xxuslrbvixxxxxxxxxlastname,
			String b4xxu3frbvixxxxxxxxxfirstname,
			String b5xxuxxrbvixxxxxxxxxmiddlenam,
			Boolean c1xxfxz1bvxxxxxxxxxxtax1, Boolean c2xxfxz2bvxxxxxxxxxxtax2,
			Boolean y1xxfxz3bvxxxxxxxxxxtax3,
			String c3xxuz1xbv04xxxxxxxxcusttax1,
			String c4xxuz2xbv05xxxxxxxxcusttax2,
			String y2xxuz3xxvxxxxxxxxxxcusttax3,
			String p1xxh4pobv27xxxxxxxxphoneo,
			String p2xxh5phbv27xxxxxxxxphoneh,
			String p3xxhxxxbv27xxxxxxxxphonec,
			String p4xxhxxxbv27xxxxxxxxphonex,
			String p5xxhxxrbv19xxxxxxxxlanaddr,
			String p6xxhxxrbv25xxxxxxxxwanaddr,
			String p7xxhxxrbv44xxxxxxxxlmailaddr,
			String p8xxhxxrbv24xxxxxxxximailaddr,
			String p9xxuxxrbvxxxxxxxxxxrmailaddr,
			String paxxhxxrbv23xxxxxxxxintaddr,
			String pbxxhxxrbvxxxxxxxxxxinraddr,
			Integer z1xxzzprhvxxxxxxxxxxprintmstat,
			Date z2xxczqxlhxxxxxxxxxxprinmtfldt,
			Boolean y5xxfxxrbvxxxxxxxxxxshiplabel,
			String y6xxuxxrbv29xxxxxxxxtype,
			Integer z3xxzzfxhhxxxxxxxxxxstatusfl,
			Date z4xxcztxlxxxxxxxxxxxstatusfldt,
			String y7xxuzkybvxxxxxxxxxxkeywords,
			String y8xxuznxbvxxxxxxxxxxnotes, String z7xxutoxlhxxxxxxxxxxowner,
			String zzxxu2oxxhxxxxxxxxxxowner2, String y9xxuzdrbvxxxxxxxxxxdocmnt) {
		this.fxxxcq144xwwqqhxxxxxlocation = fxxxcq144xwwqqhxxxxxlocation;
		this.fxxxuq111xwwqqhxxxxxaddressByMailtocode = fxxxuq111xwwqqhxxxxxaddressByMailtocode;
		this.jxxxuq201xwwqqhxxxxxcustomer = jxxxuq201xwwqqhxxxxxcustomer;
		this.fxxxuq111xwwqqhxxxxxaddressByShiptocode = fxxxuq111xwwqqhxxxxxaddressByShiptocode;
		this.a0xxukxxbvxxxxxxxxxxcontact = a0xxukxxbvxxxxxxxxxxcontact;
		this.b1xxuxxxbv21xxxxxxxxtitle = b1xxuxxxbv21xxxxxxxxtitle;
		this.b2xxuxxxbv22xxxxxxxxjobtitle = b2xxuxxxbv22xxxxxxxxjobtitle;
		this.b3xxuslrbvixxxxxxxxxlastname = b3xxuslrbvixxxxxxxxxlastname;
		this.b4xxu3frbvixxxxxxxxxfirstname = b4xxu3frbvixxxxxxxxxfirstname;
		this.b5xxuxxrbvixxxxxxxxxmiddlenam = b5xxuxxrbvixxxxxxxxxmiddlenam;
		this.c1xxfxz1bvxxxxxxxxxxtax1 = c1xxfxz1bvxxxxxxxxxxtax1;
		this.c2xxfxz2bvxxxxxxxxxxtax2 = c2xxfxz2bvxxxxxxxxxxtax2;
		this.y1xxfxz3bvxxxxxxxxxxtax3 = y1xxfxz3bvxxxxxxxxxxtax3;
		this.c3xxuz1xbv04xxxxxxxxcusttax1 = c3xxuz1xbv04xxxxxxxxcusttax1;
		this.c4xxuz2xbv05xxxxxxxxcusttax2 = c4xxuz2xbv05xxxxxxxxcusttax2;
		this.y2xxuz3xxvxxxxxxxxxxcusttax3 = y2xxuz3xxvxxxxxxxxxxcusttax3;
		this.p1xxh4pobv27xxxxxxxxphoneo = p1xxh4pobv27xxxxxxxxphoneo;
		this.p2xxh5phbv27xxxxxxxxphoneh = p2xxh5phbv27xxxxxxxxphoneh;
		this.p3xxhxxxbv27xxxxxxxxphonec = p3xxhxxxbv27xxxxxxxxphonec;
		this.p4xxhxxxbv27xxxxxxxxphonex = p4xxhxxxbv27xxxxxxxxphonex;
		this.p5xxhxxrbv19xxxxxxxxlanaddr = p5xxhxxrbv19xxxxxxxxlanaddr;
		this.p6xxhxxrbv25xxxxxxxxwanaddr = p6xxhxxrbv25xxxxxxxxwanaddr;
		this.p7xxhxxrbv44xxxxxxxxlmailaddr = p7xxhxxrbv44xxxxxxxxlmailaddr;
		this.p8xxhxxrbv24xxxxxxxximailaddr = p8xxhxxrbv24xxxxxxxximailaddr;
		this.p9xxuxxrbvxxxxxxxxxxrmailaddr = p9xxuxxrbvxxxxxxxxxxrmailaddr;
		this.paxxhxxrbv23xxxxxxxxintaddr = paxxhxxrbv23xxxxxxxxintaddr;
		this.pbxxhxxrbvxxxxxxxxxxinraddr = pbxxhxxrbvxxxxxxxxxxinraddr;
		this.z1xxzzprhvxxxxxxxxxxprintmstat = z1xxzzprhvxxxxxxxxxxprintmstat;
		this.z2xxczqxlhxxxxxxxxxxprinmtfldt = z2xxczqxlhxxxxxxxxxxprinmtfldt;
		this.y5xxfxxrbvxxxxxxxxxxshiplabel = y5xxfxxrbvxxxxxxxxxxshiplabel;
		this.y6xxuxxrbv29xxxxxxxxtype = y6xxuxxrbv29xxxxxxxxtype;
		this.z3xxzzfxhhxxxxxxxxxxstatusfl = z3xxzzfxhhxxxxxxxxxxstatusfl;
		this.z4xxcztxlxxxxxxxxxxxstatusfldt = z4xxcztxlxxxxxxxxxxxstatusfldt;
		this.y7xxuzkybvxxxxxxxxxxkeywords = y7xxuzkybvxxxxxxxxxxkeywords;
		this.y8xxuznxbvxxxxxxxxxxnotes = y8xxuznxbvxxxxxxxxxxnotes;
		this.z7xxutoxlhxxxxxxxxxxowner = z7xxutoxlhxxxxxxxxxxowner;
		this.zzxxu2oxxhxxxxxxxxxxowner2 = zzxxu2oxxhxxxxxxxxxxowner2;
		this.y9xxuzdrbvxxxxxxxxxxdocmnt = y9xxuzdrbvxxxxxxxxxxdocmnt;
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
	@JoinColumn(name = "mailtocode")
	public Fxxxuq111xwwqqhxxxxxaddress getFxxxuq111xwwqqhxxxxxaddressByMailtocode() {
		return this.fxxxuq111xwwqqhxxxxxaddressByMailtocode;
	}

	public void setFxxxuq111xwwqqhxxxxxaddressByMailtocode(
			Fxxxuq111xwwqqhxxxxxaddress fxxxuq111xwwqqhxxxxxaddressByMailtocode) {
		this.fxxxuq111xwwqqhxxxxxaddressByMailtocode = fxxxuq111xwwqqhxxxxxaddressByMailtocode;
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
	@JoinColumn(name = "shiptocode")
	public Fxxxuq111xwwqqhxxxxxaddress getFxxxuq111xwwqqhxxxxxaddressByShiptocode() {
		return this.fxxxuq111xwwqqhxxxxxaddressByShiptocode;
	}

	public void setFxxxuq111xwwqqhxxxxxaddressByShiptocode(
			Fxxxuq111xwwqqhxxxxxaddress fxxxuq111xwwqqhxxxxxaddressByShiptocode) {
		this.fxxxuq111xwwqqhxxxxxaddressByShiptocode = fxxxuq111xwwqqhxxxxxaddressByShiptocode;
	}

	@Column(name = "contact", nullable = false, length = 32)
	@NotNull
	@Size(max = 32)
	public String getA0xxukxxbvxxxxxxxxxxcontact() {
		return this.a0xxukxxbvxxxxxxxxxxcontact;
	}

	public void setA0xxukxxbvxxxxxxxxxxcontact(
			String a0xxukxxbvxxxxxxxxxxcontact) {
		this.a0xxukxxbvxxxxxxxxxxcontact = a0xxukxxbvxxxxxxxxxxcontact;
	}

	@Column(name = "title", length = 20)
	@Size(max = 20)
	public String getB1xxuxxxbv21xxxxxxxxtitle() {
		return this.b1xxuxxxbv21xxxxxxxxtitle;
	}

	public void setB1xxuxxxbv21xxxxxxxxtitle(String b1xxuxxxbv21xxxxxxxxtitle) {
		this.b1xxuxxxbv21xxxxxxxxtitle = b1xxuxxxbv21xxxxxxxxtitle;
	}

	@Column(name = "jobtitle", length = 20)
	@Size(max = 20)
	public String getB2xxuxxxbv22xxxxxxxxjobtitle() {
		return this.b2xxuxxxbv22xxxxxxxxjobtitle;
	}

	public void setB2xxuxxxbv22xxxxxxxxjobtitle(
			String b2xxuxxxbv22xxxxxxxxjobtitle) {
		this.b2xxuxxxbv22xxxxxxxxjobtitle = b2xxuxxxbv22xxxxxxxxjobtitle;
	}

	@Column(name = "lastname", length = 25)
	@Size(max = 25)
	public String getB3xxuslrbvixxxxxxxxxlastname() {
		return this.b3xxuslrbvixxxxxxxxxlastname;
	}

	public void setB3xxuslrbvixxxxxxxxxlastname(
			String b3xxuslrbvixxxxxxxxxlastname) {
		this.b3xxuslrbvixxxxxxxxxlastname = b3xxuslrbvixxxxxxxxxlastname;
	}

	@Column(name = "firstname", length = 25)
	@Size(max = 25)
	public String getB4xxu3frbvixxxxxxxxxfirstname() {
		return this.b4xxu3frbvixxxxxxxxxfirstname;
	}

	public void setB4xxu3frbvixxxxxxxxxfirstname(
			String b4xxu3frbvixxxxxxxxxfirstname) {
		this.b4xxu3frbvixxxxxxxxxfirstname = b4xxu3frbvixxxxxxxxxfirstname;
	}

	@Column(name = "middlenam", length = 20)
	@Size(max = 20)
	public String getB5xxuxxrbvixxxxxxxxxmiddlenam() {
		return this.b5xxuxxrbvixxxxxxxxxmiddlenam;
	}

	public void setB5xxuxxrbvixxxxxxxxxmiddlenam(
			String b5xxuxxrbvixxxxxxxxxmiddlenam) {
		this.b5xxuxxrbvixxxxxxxxxmiddlenam = b5xxuxxrbvixxxxxxxxxmiddlenam;
	}

	@Column(name = "tax1")
	public Boolean getC1xxfxz1bvxxxxxxxxxxtax1() {
		return this.c1xxfxz1bvxxxxxxxxxxtax1;
	}

	public void setC1xxfxz1bvxxxxxxxxxxtax1(Boolean c1xxfxz1bvxxxxxxxxxxtax1) {
		this.c1xxfxz1bvxxxxxxxxxxtax1 = c1xxfxz1bvxxxxxxxxxxtax1;
	}

	@Column(name = "tax2")
	public Boolean getC2xxfxz2bvxxxxxxxxxxtax2() {
		return this.c2xxfxz2bvxxxxxxxxxxtax2;
	}

	public void setC2xxfxz2bvxxxxxxxxxxtax2(Boolean c2xxfxz2bvxxxxxxxxxxtax2) {
		this.c2xxfxz2bvxxxxxxxxxxtax2 = c2xxfxz2bvxxxxxxxxxxtax2;
	}

	@Column(name = "tax3")
	public Boolean getY1xxfxz3bvxxxxxxxxxxtax3() {
		return this.y1xxfxz3bvxxxxxxxxxxtax3;
	}

	public void setY1xxfxz3bvxxxxxxxxxxtax3(Boolean y1xxfxz3bvxxxxxxxxxxtax3) {
		this.y1xxfxz3bvxxxxxxxxxxtax3 = y1xxfxz3bvxxxxxxxxxxtax3;
	}

	@Column(name = "custtax1", length = 25)
	@Size(max = 25)
	public String getC3xxuz1xbv04xxxxxxxxcusttax1() {
		return this.c3xxuz1xbv04xxxxxxxxcusttax1;
	}

	public void setC3xxuz1xbv04xxxxxxxxcusttax1(
			String c3xxuz1xbv04xxxxxxxxcusttax1) {
		this.c3xxuz1xbv04xxxxxxxxcusttax1 = c3xxuz1xbv04xxxxxxxxcusttax1;
	}

	@Column(name = "custtax2", length = 25)
	@Size(max = 25)
	public String getC4xxuz2xbv05xxxxxxxxcusttax2() {
		return this.c4xxuz2xbv05xxxxxxxxcusttax2;
	}

	public void setC4xxuz2xbv05xxxxxxxxcusttax2(
			String c4xxuz2xbv05xxxxxxxxcusttax2) {
		this.c4xxuz2xbv05xxxxxxxxcusttax2 = c4xxuz2xbv05xxxxxxxxcusttax2;
	}

	@Column(name = "custtax3", length = 25)
	@Size(max = 25)
	public String getY2xxuz3xxvxxxxxxxxxxcusttax3() {
		return this.y2xxuz3xxvxxxxxxxxxxcusttax3;
	}

	public void setY2xxuz3xxvxxxxxxxxxxcusttax3(
			String y2xxuz3xxvxxxxxxxxxxcusttax3) {
		this.y2xxuz3xxvxxxxxxxxxxcusttax3 = y2xxuz3xxvxxxxxxxxxxcusttax3;
	}

	@Column(name = "phoneo", length = 16)
	@Size(max = 16)
	@Pattern(regexp = "^$|^\\s*(?:\\+?(\\d{1,3}))?[-. (]*(\\d{3})[-. )]*(\\d{3})[-. ]*(\\d{4})(?: *x(\\d+))?\\s*$", message = "Code must be phone # pattern and digits and - . space")
	public String getP1xxh4pobv27xxxxxxxxphoneo() {
		return this.p1xxh4pobv27xxxxxxxxphoneo;
	}

	public void setP1xxh4pobv27xxxxxxxxphoneo(String p1xxh4pobv27xxxxxxxxphoneo) {
		this.p1xxh4pobv27xxxxxxxxphoneo = p1xxh4pobv27xxxxxxxxphoneo;
	}

	@Column(name = "phoneh", length = 16)
	@Size(max = 16)
	@Pattern(regexp = "^$|^\\s*(?:\\+?(\\d{1,3}))?[-. (]*(\\d{3})[-. )]*(\\d{3})[-. ]*(\\d{4})(?: *x(\\d+))?\\s*$", message = "Code must be phone # pattern and digits and - . space")
	public String getP2xxh5phbv27xxxxxxxxphoneh() {
		return this.p2xxh5phbv27xxxxxxxxphoneh;
	}

	public void setP2xxh5phbv27xxxxxxxxphoneh(String p2xxh5phbv27xxxxxxxxphoneh) {
		this.p2xxh5phbv27xxxxxxxxphoneh = p2xxh5phbv27xxxxxxxxphoneh;
	}

	@Column(name = "phonec", length = 16)
	@Size(max = 16)
	@Pattern(regexp = "^$|^\\s*(?:\\+?(\\d{1,3}))?[-. (]*(\\d{3})[-. )]*(\\d{3})[-. ]*(\\d{4})(?: *x(\\d+))?\\s*$", message = "Code must be phone # pattern and digits and - . space")
	public String getP3xxhxxxbv27xxxxxxxxphonec() {
		return this.p3xxhxxxbv27xxxxxxxxphonec;
	}

	public void setP3xxhxxxbv27xxxxxxxxphonec(String p3xxhxxxbv27xxxxxxxxphonec) {
		this.p3xxhxxxbv27xxxxxxxxphonec = p3xxhxxxbv27xxxxxxxxphonec;
	}

	@Column(name = "phonex", length = 20)
	@Size(max = 20)
	@Pattern(regexp = "^$|^\\s*(?:\\+?(\\d{1,3}))?[-. (]*(\\d{3})[-. )]*(\\d{3})[-. ]*(\\d{4})(?: *x(\\d+))?\\s*$", message = "Code must be phone # pattern and digits and - . space")
	public String getP4xxhxxxbv27xxxxxxxxphonex() {
		return this.p4xxhxxxbv27xxxxxxxxphonex;
	}

	public void setP4xxhxxxbv27xxxxxxxxphonex(String p4xxhxxxbv27xxxxxxxxphonex) {
		this.p4xxhxxxbv27xxxxxxxxphonex = p4xxhxxxbv27xxxxxxxxphonex;
	}

	@Column(name = "lanaddr", length = 35)
	@Size(max = 35)
	public String getP5xxhxxrbv19xxxxxxxxlanaddr() {
		return this.p5xxhxxrbv19xxxxxxxxlanaddr;
	}

	public void setP5xxhxxrbv19xxxxxxxxlanaddr(
			String p5xxhxxrbv19xxxxxxxxlanaddr) {
		this.p5xxhxxrbv19xxxxxxxxlanaddr = p5xxhxxrbv19xxxxxxxxlanaddr;
	}

	@Column(name = "wanaddr", length = 35)
	@Size(max = 35)
	public String getP6xxhxxrbv25xxxxxxxxwanaddr() {
		return this.p6xxhxxrbv25xxxxxxxxwanaddr;
	}

	public void setP6xxhxxrbv25xxxxxxxxwanaddr(
			String p6xxhxxrbv25xxxxxxxxwanaddr) {
		this.p6xxhxxrbv25xxxxxxxxwanaddr = p6xxhxxrbv25xxxxxxxxwanaddr;
	}

	@Column(name = "lmailaddr", length = 35)
	@Size(max = 35)
	public String getP7xxhxxrbv44xxxxxxxxlmailaddr() {
		return this.p7xxhxxrbv44xxxxxxxxlmailaddr;
	}

	public void setP7xxhxxrbv44xxxxxxxxlmailaddr(
			String p7xxhxxrbv44xxxxxxxxlmailaddr) {
		this.p7xxhxxrbv44xxxxxxxxlmailaddr = p7xxhxxrbv44xxxxxxxxlmailaddr;
	}

	@Column(name = "imailaddr", length = 60)
	@Size(max = 60)
	@Pattern.List({
			@Pattern(regexp = "(^$|.+@.+\\..+)", message = "Bad email value"),
			@Pattern(regexp = "(^$)|(^\\S+$)", message = "email has space character")})
	public String getP8xxhxxrbv24xxxxxxxximailaddr() {
		return this.p8xxhxxrbv24xxxxxxxximailaddr;
	}

	public void setP8xxhxxrbv24xxxxxxxximailaddr(
			String p8xxhxxrbv24xxxxxxxximailaddr) {
		this.p8xxhxxrbv24xxxxxxxximailaddr = p8xxhxxrbv24xxxxxxxximailaddr;
	}

	@Column(name = "rmailaddr", length = 35)
	@Size(max = 35)
	public String getP9xxuxxrbvxxxxxxxxxxrmailaddr() {
		return this.p9xxuxxrbvxxxxxxxxxxrmailaddr;
	}

	public void setP9xxuxxrbvxxxxxxxxxxrmailaddr(
			String p9xxuxxrbvxxxxxxxxxxrmailaddr) {
		this.p9xxuxxrbvxxxxxxxxxxrmailaddr = p9xxuxxrbvxxxxxxxxxxrmailaddr;
	}

	@Column(name = "intaddr", length = 60)
	@Size(max = 60)
	public String getPaxxhxxrbv23xxxxxxxxintaddr() {
		return this.paxxhxxrbv23xxxxxxxxintaddr;
	}

	public void setPaxxhxxrbv23xxxxxxxxintaddr(
			String paxxhxxrbv23xxxxxxxxintaddr) {
		this.paxxhxxrbv23xxxxxxxxintaddr = paxxhxxrbv23xxxxxxxxintaddr;
	}

	@Column(name = "inraddr", length = 35)
	@Size(max = 35)
	public String getPbxxhxxrbvxxxxxxxxxxinraddr() {
		return this.pbxxhxxrbvxxxxxxxxxxinraddr;
	}

	public void setPbxxhxxrbvxxxxxxxxxxinraddr(
			String pbxxhxxrbvxxxxxxxxxxinraddr) {
		this.pbxxhxxrbvxxxxxxxxxxinraddr = pbxxhxxrbvxxxxxxxxxxinraddr;
	}

	@Column(name = "printmstat")
	public Integer getZ1xxzzprhvxxxxxxxxxxprintmstat() {
		return this.z1xxzzprhvxxxxxxxxxxprintmstat;
	}

	public void setZ1xxzzprhvxxxxxxxxxxprintmstat(
			Integer z1xxzzprhvxxxxxxxxxxprintmstat) {
		this.z1xxzzprhvxxxxxxxxxxprintmstat = z1xxzzprhvxxxxxxxxxxprintmstat;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "prinmtfldt", length = 29)
	public Date getZ2xxczqxlhxxxxxxxxxxprinmtfldt() {
		return this.z2xxczqxlhxxxxxxxxxxprinmtfldt;
	}

	public void setZ2xxczqxlhxxxxxxxxxxprinmtfldt(
			Date z2xxczqxlhxxxxxxxxxxprinmtfldt) {
		this.z2xxczqxlhxxxxxxxxxxprinmtfldt = z2xxczqxlhxxxxxxxxxxprinmtfldt;
	}

	@Column(name = "shiplabel")
	public Boolean getY5xxfxxrbvxxxxxxxxxxshiplabel() {
		return this.y5xxfxxrbvxxxxxxxxxxshiplabel;
	}

	public void setY5xxfxxrbvxxxxxxxxxxshiplabel(
			Boolean y5xxfxxrbvxxxxxxxxxxshiplabel) {
		this.y5xxfxxrbvxxxxxxxxxxshiplabel = y5xxfxxrbvxxxxxxxxxxshiplabel;
	}

	@Column(name = "type", length = 12)
	@Size(max = 12)
	public String getY6xxuxxrbv29xxxxxxxxtype() {
		return this.y6xxuxxrbv29xxxxxxxxtype;
	}

	public void setY6xxuxxrbv29xxxxxxxxtype(String y6xxuxxrbv29xxxxxxxxtype) {
		this.y6xxuxxrbv29xxxxxxxxtype = y6xxuxxrbv29xxxxxxxxtype;
	}

	@Column(name = "statusfl")
	public Integer getZ3xxzzfxhhxxxxxxxxxxstatusfl() {
		return this.z3xxzzfxhhxxxxxxxxxxstatusfl;
	}

	public void setZ3xxzzfxhhxxxxxxxxxxstatusfl(
			Integer z3xxzzfxhhxxxxxxxxxxstatusfl) {
		this.z3xxzzfxhhxxxxxxxxxxstatusfl = z3xxzzfxhhxxxxxxxxxxstatusfl;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "statusfldt", length = 29)
	public Date getZ4xxcztxlxxxxxxxxxxxstatusfldt() {
		return this.z4xxcztxlxxxxxxxxxxxstatusfldt;
	}

	public void setZ4xxcztxlxxxxxxxxxxxstatusfldt(
			Date z4xxcztxlxxxxxxxxxxxstatusfldt) {
		this.z4xxcztxlxxxxxxxxxxxstatusfldt = z4xxcztxlxxxxxxxxxxxstatusfldt;
	}

	@Column(name = "keywords", length = 30)
	@Size(max = 30)
	public String getY7xxuzkybvxxxxxxxxxxkeywords() {
		return this.y7xxuzkybvxxxxxxxxxxkeywords;
	}

	public void setY7xxuzkybvxxxxxxxxxxkeywords(
			String y7xxuzkybvxxxxxxxxxxkeywords) {
		this.y7xxuzkybvxxxxxxxxxxkeywords = y7xxuzkybvxxxxxxxxxxkeywords;
	}

	@Column(name = "notes", length = 60)
	@Size(max = 60)
	public String getY8xxuznxbvxxxxxxxxxxnotes() {
		return this.y8xxuznxbvxxxxxxxxxxnotes;
	}

	public void setY8xxuznxbvxxxxxxxxxxnotes(String y8xxuznxbvxxxxxxxxxxnotes) {
		this.y8xxuznxbvxxxxxxxxxxnotes = y8xxuznxbvxxxxxxxxxxnotes;
	}

	@Column(name = "owner", length = 40)
	@Size(max = 40)
	public String getZ7xxutoxlhxxxxxxxxxxowner() {
		return this.z7xxutoxlhxxxxxxxxxxowner;
	}

	public void setZ7xxutoxlhxxxxxxxxxxowner(String z7xxutoxlhxxxxxxxxxxowner) {
		this.z7xxutoxlhxxxxxxxxxxowner = z7xxutoxlhxxxxxxxxxxowner;
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
	public String getY9xxuzdrbvxxxxxxxxxxdocmnt() {
		return this.y9xxuzdrbvxxxxxxxxxxdocmnt;
	}

	public void setY9xxuzdrbvxxxxxxxxxxdocmnt(String y9xxuzdrbvxxxxxxxxxxdocmnt) {
		this.y9xxuzdrbvxxxxxxxxxxdocmnt = y9xxuzdrbvxxxxxxxxxxdocmnt;
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
