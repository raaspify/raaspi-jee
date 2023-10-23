package com.rcomputer.genapp.model;
// Generated 18-Oct-2023 7:34:42 PM by Hibernate Tools 4.0.0

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
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 * Yxxxch575xwwqqhxxxxxuserprofl generated by hbm2java
 */
@Entity
@XmlRootElement
@Table(name = "userprofl")
public class Yxxxch575xwwqqhxxxxxuserprofl implements java.io.Serializable {

	private Integer a0xxuobxbxxxxxxxxxxxsid;
	private Yxxxuh566xwwqqwxxxxxuser yxxxuh566xwwqqwxxxxxuser;
	private String b1xxuxxrbvxxxxxxxxxxrow;
	private String b1xxuxxrbvxxxxxxxxxxoption;
	private String b1xxuxxrbvxxxxxxxxxxselectvalue;
	private String b1xxuxxrbvxxxxxxxxxxscrcolor;
	private String b2xxuxxrbvxxxxxxxxxxhilcolor;
	private String b3xxuxxrbvxxxxxxxxxxtextcolor;
	private String b4xxuxxrbvxxxxxxxxxxbaccolor;
	private Boolean b5xxfxxxbvxxxxxxxxxxbeepsou;
	private Boolean c1xxfxxxbvxxxxxxxxxxconfirm;
	private Boolean c2xxfxxxbvxxxxxxxxxxprompti;
	private String c3xxuxxrbvxxxxxxxxxxp1;
	private String c4xxuxxrbvxxxxxxxxxxp2;
	private String c5xxuxxrbvxxxxxxxxxxp3;
	private String c6xxuxxrbvxxxxxxxxxxp4;
	private String c7xxuxxrbvxxxxxxxxxxp5;
	private String c8xxuxxrbvxxxxxxxxxxp6;
	private String d1xxuxxrbvxxxxxxxxxxmtstyle;
	private String d2xxuxxrbvxxxxxxxxxxststyle;
	private String d3xxuxxrbvxxxxxxxxxxdtstyle;
	private String d4xxuxxrbvxxxxxxxxxxftstyle;
	private String d5xxuxxrbvxxxxxxxxxxdefaultr;
	private String d6xxuxxrbvxxxxxxxxxxdefaultc;
	private String d7xxuxxrbvxxxxxxxxxxdbname;
	private String e1xxuxxrbvxxxxxxxxxxrootdir;
	private String e2xxuxxrbvxxxxxxxxxxkeyorder;
	private BigDecimal e3xxzxxxlvxxxxxxxxxxmargin;
	private BigDecimal e4xxzxxxlvxxxxxxxxxxfooter;
	private Boolean e5xxfxxxbvxxxxxxxxxxlistbuildc;
	private Boolean e6xxfxxxbvxxxxxxxxxxlistbuildv;
	private Boolean e7xxfxxxbvxxxxxxxxxxlistbuilde;
	private Integer e8xxzxxrbvxxxxxxxxxxlistbrownc;
	private Integer e9xxzxxrbvxxxxxxxxxxlistbrownv;
	private Integer eaxxzxxrbvxxxxxxxxxxlistbrowne;
	private Integer z1xxzzfxhhxxxxxxxxxxstatusfl;
	private Date z2xxcztxlxxxxxxxxxxxstatusfldt;
	private String z3xxutoxlhxxxxxxxxxxowner;
	private String zzxxu2oxxhxxxxxxxxxxowner2;

	public Yxxxch575xwwqqhxxxxxuserprofl() {
	}

	public Yxxxch575xwwqqhxxxxxuserprofl(
			Yxxxuh566xwwqqwxxxxxuser yxxxuh566xwwqqwxxxxxuser,
			String b1xxuxxrbvxxxxxxxxxxrow, String b1xxuxxrbvxxxxxxxxxxoption,
			String b1xxuxxrbvxxxxxxxxxxselectvalue,
			String b1xxuxxrbvxxxxxxxxxxscrcolor,
			String b2xxuxxrbvxxxxxxxxxxhilcolor,
			String b3xxuxxrbvxxxxxxxxxxtextcolor,
			String b4xxuxxrbvxxxxxxxxxxbaccolor,
			Boolean b5xxfxxxbvxxxxxxxxxxbeepsou,
			Boolean c1xxfxxxbvxxxxxxxxxxconfirm,
			Boolean c2xxfxxxbvxxxxxxxxxxprompti, String c3xxuxxrbvxxxxxxxxxxp1,
			String c4xxuxxrbvxxxxxxxxxxp2, String c5xxuxxrbvxxxxxxxxxxp3,
			String c6xxuxxrbvxxxxxxxxxxp4, String c7xxuxxrbvxxxxxxxxxxp5,
			String c8xxuxxrbvxxxxxxxxxxp6, String d1xxuxxrbvxxxxxxxxxxmtstyle,
			String d2xxuxxrbvxxxxxxxxxxststyle,
			String d3xxuxxrbvxxxxxxxxxxdtstyle,
			String d4xxuxxrbvxxxxxxxxxxftstyle,
			String d5xxuxxrbvxxxxxxxxxxdefaultr,
			String d6xxuxxrbvxxxxxxxxxxdefaultc,
			String d7xxuxxrbvxxxxxxxxxxdbname,
			String e1xxuxxrbvxxxxxxxxxxrootdir,
			String e2xxuxxrbvxxxxxxxxxxkeyorder,
			BigDecimal e3xxzxxxlvxxxxxxxxxxmargin,
			BigDecimal e4xxzxxxlvxxxxxxxxxxfooter,
			Boolean e5xxfxxxbvxxxxxxxxxxlistbuildc,
			Boolean e6xxfxxxbvxxxxxxxxxxlistbuildv,
			Boolean e7xxfxxxbvxxxxxxxxxxlistbuilde,
			Integer e8xxzxxrbvxxxxxxxxxxlistbrownc,
			Integer e9xxzxxrbvxxxxxxxxxxlistbrownv,
			Integer eaxxzxxrbvxxxxxxxxxxlistbrowne,
			Integer z1xxzzfxhhxxxxxxxxxxstatusfl,
			Date z2xxcztxlxxxxxxxxxxxstatusfldt,
			String z3xxutoxlhxxxxxxxxxxowner, String zzxxu2oxxhxxxxxxxxxxowner2) {
		this.yxxxuh566xwwqqwxxxxxuser = yxxxuh566xwwqqwxxxxxuser;
		this.b1xxuxxrbvxxxxxxxxxxrow = b1xxuxxrbvxxxxxxxxxxrow;
		this.b1xxuxxrbvxxxxxxxxxxoption = b1xxuxxrbvxxxxxxxxxxoption;
		this.b1xxuxxrbvxxxxxxxxxxselectvalue = b1xxuxxrbvxxxxxxxxxxselectvalue;
		this.b1xxuxxrbvxxxxxxxxxxscrcolor = b1xxuxxrbvxxxxxxxxxxscrcolor;
		this.b2xxuxxrbvxxxxxxxxxxhilcolor = b2xxuxxrbvxxxxxxxxxxhilcolor;
		this.b3xxuxxrbvxxxxxxxxxxtextcolor = b3xxuxxrbvxxxxxxxxxxtextcolor;
		this.b4xxuxxrbvxxxxxxxxxxbaccolor = b4xxuxxrbvxxxxxxxxxxbaccolor;
		this.b5xxfxxxbvxxxxxxxxxxbeepsou = b5xxfxxxbvxxxxxxxxxxbeepsou;
		this.c1xxfxxxbvxxxxxxxxxxconfirm = c1xxfxxxbvxxxxxxxxxxconfirm;
		this.c2xxfxxxbvxxxxxxxxxxprompti = c2xxfxxxbvxxxxxxxxxxprompti;
		this.c3xxuxxrbvxxxxxxxxxxp1 = c3xxuxxrbvxxxxxxxxxxp1;
		this.c4xxuxxrbvxxxxxxxxxxp2 = c4xxuxxrbvxxxxxxxxxxp2;
		this.c5xxuxxrbvxxxxxxxxxxp3 = c5xxuxxrbvxxxxxxxxxxp3;
		this.c6xxuxxrbvxxxxxxxxxxp4 = c6xxuxxrbvxxxxxxxxxxp4;
		this.c7xxuxxrbvxxxxxxxxxxp5 = c7xxuxxrbvxxxxxxxxxxp5;
		this.c8xxuxxrbvxxxxxxxxxxp6 = c8xxuxxrbvxxxxxxxxxxp6;
		this.d1xxuxxrbvxxxxxxxxxxmtstyle = d1xxuxxrbvxxxxxxxxxxmtstyle;
		this.d2xxuxxrbvxxxxxxxxxxststyle = d2xxuxxrbvxxxxxxxxxxststyle;
		this.d3xxuxxrbvxxxxxxxxxxdtstyle = d3xxuxxrbvxxxxxxxxxxdtstyle;
		this.d4xxuxxrbvxxxxxxxxxxftstyle = d4xxuxxrbvxxxxxxxxxxftstyle;
		this.d5xxuxxrbvxxxxxxxxxxdefaultr = d5xxuxxrbvxxxxxxxxxxdefaultr;
		this.d6xxuxxrbvxxxxxxxxxxdefaultc = d6xxuxxrbvxxxxxxxxxxdefaultc;
		this.d7xxuxxrbvxxxxxxxxxxdbname = d7xxuxxrbvxxxxxxxxxxdbname;
		this.e1xxuxxrbvxxxxxxxxxxrootdir = e1xxuxxrbvxxxxxxxxxxrootdir;
		this.e2xxuxxrbvxxxxxxxxxxkeyorder = e2xxuxxrbvxxxxxxxxxxkeyorder;
		this.e3xxzxxxlvxxxxxxxxxxmargin = e3xxzxxxlvxxxxxxxxxxmargin;
		this.e4xxzxxxlvxxxxxxxxxxfooter = e4xxzxxxlvxxxxxxxxxxfooter;
		this.e5xxfxxxbvxxxxxxxxxxlistbuildc = e5xxfxxxbvxxxxxxxxxxlistbuildc;
		this.e6xxfxxxbvxxxxxxxxxxlistbuildv = e6xxfxxxbvxxxxxxxxxxlistbuildv;
		this.e7xxfxxxbvxxxxxxxxxxlistbuilde = e7xxfxxxbvxxxxxxxxxxlistbuilde;
		this.e8xxzxxrbvxxxxxxxxxxlistbrownc = e8xxzxxrbvxxxxxxxxxxlistbrownc;
		this.e9xxzxxrbvxxxxxxxxxxlistbrownv = e9xxzxxrbvxxxxxxxxxxlistbrownv;
		this.eaxxzxxrbvxxxxxxxxxxlistbrowne = eaxxzxxrbvxxxxxxxxxxlistbrowne;
		this.z1xxzzfxhhxxxxxxxxxxstatusfl = z1xxzzfxhhxxxxxxxxxxstatusfl;
		this.z2xxcztxlxxxxxxxxxxxstatusfldt = z2xxcztxlxxxxxxxxxxxstatusfldt;
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

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "logonid")
	public Yxxxuh566xwwqqwxxxxxuser getYxxxuh566xwwqqwxxxxxuser() {
		return this.yxxxuh566xwwqqwxxxxxuser;
	}

	public void setYxxxuh566xwwqqwxxxxxuser(
			Yxxxuh566xwwqqwxxxxxuser yxxxuh566xwwqqwxxxxxuser) {
		this.yxxxuh566xwwqqwxxxxxuser = yxxxuh566xwwqqwxxxxxuser;
	}

	@Column(name = "row", length = 20)
	@Size(max = 20)
	public String getB1xxuxxrbvxxxxxxxxxxrow() {
		return this.b1xxuxxrbvxxxxxxxxxxrow;
	}

	public void setB1xxuxxrbvxxxxxxxxxxrow(String b1xxuxxrbvxxxxxxxxxxrow) {
		this.b1xxuxxrbvxxxxxxxxxxrow = b1xxuxxrbvxxxxxxxxxxrow;
	}

	@Column(name = "option")
	public String getB1xxuxxrbvxxxxxxxxxxoption() {
		return this.b1xxuxxrbvxxxxxxxxxxoption;
	}

	public void setB1xxuxxrbvxxxxxxxxxxoption(String b1xxuxxrbvxxxxxxxxxxoption) {
		this.b1xxuxxrbvxxxxxxxxxxoption = b1xxuxxrbvxxxxxxxxxxoption;
	}

	@Column(name = "selectvalue")
	public String getB1xxuxxrbvxxxxxxxxxxselectvalue() {
		return this.b1xxuxxrbvxxxxxxxxxxselectvalue;
	}

	public void setB1xxuxxrbvxxxxxxxxxxselectvalue(
			String b1xxuxxrbvxxxxxxxxxxselectvalue) {
		this.b1xxuxxrbvxxxxxxxxxxselectvalue = b1xxuxxrbvxxxxxxxxxxselectvalue;
	}

	@Column(name = "scrcolor", length = 30)
	@Size(max = 30)
	public String getB1xxuxxrbvxxxxxxxxxxscrcolor() {
		return this.b1xxuxxrbvxxxxxxxxxxscrcolor;
	}

	public void setB1xxuxxrbvxxxxxxxxxxscrcolor(
			String b1xxuxxrbvxxxxxxxxxxscrcolor) {
		this.b1xxuxxrbvxxxxxxxxxxscrcolor = b1xxuxxrbvxxxxxxxxxxscrcolor;
	}

	@Column(name = "hilcolor", length = 30)
	@Size(max = 30)
	public String getB2xxuxxrbvxxxxxxxxxxhilcolor() {
		return this.b2xxuxxrbvxxxxxxxxxxhilcolor;
	}

	public void setB2xxuxxrbvxxxxxxxxxxhilcolor(
			String b2xxuxxrbvxxxxxxxxxxhilcolor) {
		this.b2xxuxxrbvxxxxxxxxxxhilcolor = b2xxuxxrbvxxxxxxxxxxhilcolor;
	}

	@Column(name = "textcolor", length = 30)
	@Size(max = 30)
	public String getB3xxuxxrbvxxxxxxxxxxtextcolor() {
		return this.b3xxuxxrbvxxxxxxxxxxtextcolor;
	}

	public void setB3xxuxxrbvxxxxxxxxxxtextcolor(
			String b3xxuxxrbvxxxxxxxxxxtextcolor) {
		this.b3xxuxxrbvxxxxxxxxxxtextcolor = b3xxuxxrbvxxxxxxxxxxtextcolor;
	}

	@Column(name = "baccolor", length = 30)
	@Size(max = 30)
	public String getB4xxuxxrbvxxxxxxxxxxbaccolor() {
		return this.b4xxuxxrbvxxxxxxxxxxbaccolor;
	}

	public void setB4xxuxxrbvxxxxxxxxxxbaccolor(
			String b4xxuxxrbvxxxxxxxxxxbaccolor) {
		this.b4xxuxxrbvxxxxxxxxxxbaccolor = b4xxuxxrbvxxxxxxxxxxbaccolor;
	}

	@Column(name = "beepsou")
	public Boolean getB5xxfxxxbvxxxxxxxxxxbeepsou() {
		return this.b5xxfxxxbvxxxxxxxxxxbeepsou;
	}

	public void setB5xxfxxxbvxxxxxxxxxxbeepsou(
			Boolean b5xxfxxxbvxxxxxxxxxxbeepsou) {
		this.b5xxfxxxbvxxxxxxxxxxbeepsou = b5xxfxxxbvxxxxxxxxxxbeepsou;
	}

	@Column(name = "confirm")
	public Boolean getC1xxfxxxbvxxxxxxxxxxconfirm() {
		return this.c1xxfxxxbvxxxxxxxxxxconfirm;
	}

	public void setC1xxfxxxbvxxxxxxxxxxconfirm(
			Boolean c1xxfxxxbvxxxxxxxxxxconfirm) {
		this.c1xxfxxxbvxxxxxxxxxxconfirm = c1xxfxxxbvxxxxxxxxxxconfirm;
	}

	@Column(name = "prompti")
	public Boolean getC2xxfxxxbvxxxxxxxxxxprompti() {
		return this.c2xxfxxxbvxxxxxxxxxxprompti;
	}

	public void setC2xxfxxxbvxxxxxxxxxxprompti(
			Boolean c2xxfxxxbvxxxxxxxxxxprompti) {
		this.c2xxfxxxbvxxxxxxxxxxprompti = c2xxfxxxbvxxxxxxxxxxprompti;
	}

	@Column(name = "p1", length = 5)
	@Size(max = 5)
	public String getC3xxuxxrbvxxxxxxxxxxp1() {
		return this.c3xxuxxrbvxxxxxxxxxxp1;
	}

	public void setC3xxuxxrbvxxxxxxxxxxp1(String c3xxuxxrbvxxxxxxxxxxp1) {
		this.c3xxuxxrbvxxxxxxxxxxp1 = c3xxuxxrbvxxxxxxxxxxp1;
	}

	@Column(name = "p2", length = 5)
	@Size(max = 5)
	public String getC4xxuxxrbvxxxxxxxxxxp2() {
		return this.c4xxuxxrbvxxxxxxxxxxp2;
	}

	public void setC4xxuxxrbvxxxxxxxxxxp2(String c4xxuxxrbvxxxxxxxxxxp2) {
		this.c4xxuxxrbvxxxxxxxxxxp2 = c4xxuxxrbvxxxxxxxxxxp2;
	}

	@Column(name = "p3", length = 5)
	@Size(max = 5)
	public String getC5xxuxxrbvxxxxxxxxxxp3() {
		return this.c5xxuxxrbvxxxxxxxxxxp3;
	}

	public void setC5xxuxxrbvxxxxxxxxxxp3(String c5xxuxxrbvxxxxxxxxxxp3) {
		this.c5xxuxxrbvxxxxxxxxxxp3 = c5xxuxxrbvxxxxxxxxxxp3;
	}

	@Column(name = "p4", length = 5)
	@Size(max = 5)
	public String getC6xxuxxrbvxxxxxxxxxxp4() {
		return this.c6xxuxxrbvxxxxxxxxxxp4;
	}

	public void setC6xxuxxrbvxxxxxxxxxxp4(String c6xxuxxrbvxxxxxxxxxxp4) {
		this.c6xxuxxrbvxxxxxxxxxxp4 = c6xxuxxrbvxxxxxxxxxxp4;
	}

	@Column(name = "p5", length = 5)
	@Size(max = 5)
	public String getC7xxuxxrbvxxxxxxxxxxp5() {
		return this.c7xxuxxrbvxxxxxxxxxxp5;
	}

	public void setC7xxuxxrbvxxxxxxxxxxp5(String c7xxuxxrbvxxxxxxxxxxp5) {
		this.c7xxuxxrbvxxxxxxxxxxp5 = c7xxuxxrbvxxxxxxxxxxp5;
	}

	@Column(name = "p6", length = 5)
	@Size(max = 5)
	public String getC8xxuxxrbvxxxxxxxxxxp6() {
		return this.c8xxuxxrbvxxxxxxxxxxp6;
	}

	public void setC8xxuxxrbvxxxxxxxxxxp6(String c8xxuxxrbvxxxxxxxxxxp6) {
		this.c8xxuxxrbvxxxxxxxxxxp6 = c8xxuxxrbvxxxxxxxxxxp6;
	}

	@Column(name = "mtstyle", length = 30)
	@Size(max = 30)
	public String getD1xxuxxrbvxxxxxxxxxxmtstyle() {
		return this.d1xxuxxrbvxxxxxxxxxxmtstyle;
	}

	public void setD1xxuxxrbvxxxxxxxxxxmtstyle(
			String d1xxuxxrbvxxxxxxxxxxmtstyle) {
		this.d1xxuxxrbvxxxxxxxxxxmtstyle = d1xxuxxrbvxxxxxxxxxxmtstyle;
	}

	@Column(name = "ststyle", length = 30)
	@Size(max = 30)
	public String getD2xxuxxrbvxxxxxxxxxxststyle() {
		return this.d2xxuxxrbvxxxxxxxxxxststyle;
	}

	public void setD2xxuxxrbvxxxxxxxxxxststyle(
			String d2xxuxxrbvxxxxxxxxxxststyle) {
		this.d2xxuxxrbvxxxxxxxxxxststyle = d2xxuxxrbvxxxxxxxxxxststyle;
	}

	@Column(name = "dtstyle", length = 30)
	@Size(max = 30)
	public String getD3xxuxxrbvxxxxxxxxxxdtstyle() {
		return this.d3xxuxxrbvxxxxxxxxxxdtstyle;
	}

	public void setD3xxuxxrbvxxxxxxxxxxdtstyle(
			String d3xxuxxrbvxxxxxxxxxxdtstyle) {
		this.d3xxuxxrbvxxxxxxxxxxdtstyle = d3xxuxxrbvxxxxxxxxxxdtstyle;
	}

	@Column(name = "ftstyle", length = 30)
	@Size(max = 30)
	public String getD4xxuxxrbvxxxxxxxxxxftstyle() {
		return this.d4xxuxxrbvxxxxxxxxxxftstyle;
	}

	public void setD4xxuxxrbvxxxxxxxxxxftstyle(
			String d4xxuxxrbvxxxxxxxxxxftstyle) {
		this.d4xxuxxrbvxxxxxxxxxxftstyle = d4xxuxxrbvxxxxxxxxxxftstyle;
	}

	@Column(name = "defaultr", length = 20)
	@Size(max = 20)
	public String getD5xxuxxrbvxxxxxxxxxxdefaultr() {
		return this.d5xxuxxrbvxxxxxxxxxxdefaultr;
	}

	public void setD5xxuxxrbvxxxxxxxxxxdefaultr(
			String d5xxuxxrbvxxxxxxxxxxdefaultr) {
		this.d5xxuxxrbvxxxxxxxxxxdefaultr = d5xxuxxrbvxxxxxxxxxxdefaultr;
	}

	@Column(name = "defaultc", length = 3)
	@Size(max = 3)
	public String getD6xxuxxrbvxxxxxxxxxxdefaultc() {
		return this.d6xxuxxrbvxxxxxxxxxxdefaultc;
	}

	public void setD6xxuxxrbvxxxxxxxxxxdefaultc(
			String d6xxuxxrbvxxxxxxxxxxdefaultc) {
		this.d6xxuxxrbvxxxxxxxxxxdefaultc = d6xxuxxrbvxxxxxxxxxxdefaultc;
	}

	@Column(name = "dbname", length = 20)
	@Size(max = 20)
	public String getD7xxuxxrbvxxxxxxxxxxdbname() {
		return this.d7xxuxxrbvxxxxxxxxxxdbname;
	}

	public void setD7xxuxxrbvxxxxxxxxxxdbname(String d7xxuxxrbvxxxxxxxxxxdbname) {
		this.d7xxuxxrbvxxxxxxxxxxdbname = d7xxuxxrbvxxxxxxxxxxdbname;
	}

	@Column(name = "rootdir", length = 35)
	@Size(max = 35)
	public String getE1xxuxxrbvxxxxxxxxxxrootdir() {
		return this.e1xxuxxrbvxxxxxxxxxxrootdir;
	}

	public void setE1xxuxxrbvxxxxxxxxxxrootdir(
			String e1xxuxxrbvxxxxxxxxxxrootdir) {
		this.e1xxuxxrbvxxxxxxxxxxrootdir = e1xxuxxrbvxxxxxxxxxxrootdir;
	}

	@Column(name = "keyorder", length = 3)
	@Size(max = 3)
	public String getE2xxuxxrbvxxxxxxxxxxkeyorder() {
		return this.e2xxuxxrbvxxxxxxxxxxkeyorder;
	}

	public void setE2xxuxxrbvxxxxxxxxxxkeyorder(
			String e2xxuxxrbvxxxxxxxxxxkeyorder) {
		this.e2xxuxxrbvxxxxxxxxxxkeyorder = e2xxuxxrbvxxxxxxxxxxkeyorder;
	}

	@Column(name = "margin", precision = 14)
	public BigDecimal getE3xxzxxxlvxxxxxxxxxxmargin() {
		return this.e3xxzxxxlvxxxxxxxxxxmargin;
	}

	public void setE3xxzxxxlvxxxxxxxxxxmargin(
			BigDecimal e3xxzxxxlvxxxxxxxxxxmargin) {
		this.e3xxzxxxlvxxxxxxxxxxmargin = e3xxzxxxlvxxxxxxxxxxmargin;
	}

	@Column(name = "footer", precision = 14)
	public BigDecimal getE4xxzxxxlvxxxxxxxxxxfooter() {
		return this.e4xxzxxxlvxxxxxxxxxxfooter;
	}

	public void setE4xxzxxxlvxxxxxxxxxxfooter(
			BigDecimal e4xxzxxxlvxxxxxxxxxxfooter) {
		this.e4xxzxxxlvxxxxxxxxxxfooter = e4xxzxxxlvxxxxxxxxxxfooter;
	}

	@Column(name = "listbuildc")
	public Boolean getE5xxfxxxbvxxxxxxxxxxlistbuildc() {
		return this.e5xxfxxxbvxxxxxxxxxxlistbuildc;
	}

	public void setE5xxfxxxbvxxxxxxxxxxlistbuildc(
			Boolean e5xxfxxxbvxxxxxxxxxxlistbuildc) {
		this.e5xxfxxxbvxxxxxxxxxxlistbuildc = e5xxfxxxbvxxxxxxxxxxlistbuildc;
	}

	@Column(name = "listbuildv")
	public Boolean getE6xxfxxxbvxxxxxxxxxxlistbuildv() {
		return this.e6xxfxxxbvxxxxxxxxxxlistbuildv;
	}

	public void setE6xxfxxxbvxxxxxxxxxxlistbuildv(
			Boolean e6xxfxxxbvxxxxxxxxxxlistbuildv) {
		this.e6xxfxxxbvxxxxxxxxxxlistbuildv = e6xxfxxxbvxxxxxxxxxxlistbuildv;
	}

	@Column(name = "listbuilde")
	public Boolean getE7xxfxxxbvxxxxxxxxxxlistbuilde() {
		return this.e7xxfxxxbvxxxxxxxxxxlistbuilde;
	}

	public void setE7xxfxxxbvxxxxxxxxxxlistbuilde(
			Boolean e7xxfxxxbvxxxxxxxxxxlistbuilde) {
		this.e7xxfxxxbvxxxxxxxxxxlistbuilde = e7xxfxxxbvxxxxxxxxxxlistbuilde;
	}

	@Column(name = "listbrownc")
	public Integer getE8xxzxxrbvxxxxxxxxxxlistbrownc() {
		return this.e8xxzxxrbvxxxxxxxxxxlistbrownc;
	}

	public void setE8xxzxxrbvxxxxxxxxxxlistbrownc(
			Integer e8xxzxxrbvxxxxxxxxxxlistbrownc) {
		this.e8xxzxxrbvxxxxxxxxxxlistbrownc = e8xxzxxrbvxxxxxxxxxxlistbrownc;
	}

	@Column(name = "listbrownv")
	public Integer getE9xxzxxrbvxxxxxxxxxxlistbrownv() {
		return this.e9xxzxxrbvxxxxxxxxxxlistbrownv;
	}

	public void setE9xxzxxrbvxxxxxxxxxxlistbrownv(
			Integer e9xxzxxrbvxxxxxxxxxxlistbrownv) {
		this.e9xxzxxrbvxxxxxxxxxxlistbrownv = e9xxzxxrbvxxxxxxxxxxlistbrownv;
	}

	@Column(name = "listbrowne")
	public Integer getEaxxzxxrbvxxxxxxxxxxlistbrowne() {
		return this.eaxxzxxrbvxxxxxxxxxxlistbrowne;
	}

	public void setEaxxzxxrbvxxxxxxxxxxlistbrowne(
			Integer eaxxzxxrbvxxxxxxxxxxlistbrowne) {
		this.eaxxzxxrbvxxxxxxxxxxlistbrowne = eaxxzxxrbvxxxxxxxxxxlistbrowne;
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
