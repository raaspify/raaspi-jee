package com.rcomputer.genapp.model;
// Generated 27-Jun-2023 8:43:30 PM by Hibernate Tools 4.0.0

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
 * Yxxxuq582xwwqqhsgxxxgenoptions generated by hbm2java
 */
@Entity
@XmlRootElement
@Table(name = "genoptions")
public class Yxxxuq582xwwqqhsgxxxgenoptions implements java.io.Serializable {

	private Integer a0xxuobxbxxxxxxxxxxxsid;
	private String a0xxukgxbvxxxxxxxxxxrow;
	private String b1xxuo01bvxxxxxxxxxxgenoptions01;
	private String b2xxup01bvxxxxxxxxxxgenpurpose01;
	private String b3xxuv01bvxxxxxxxxxxgenvalue01;
	private String b4xxuo02bvxxxxxxxxxxgenoptions02;
	private String b5xxup02bvxxxxxxxxxxgenpurpose02;
	private String b6xxuv02bvxxxxxxxxxxgenvalue02;
	private String b7xxuo03bvxxxxxxxxxxgenoptions03;
	private String b8xxup03bvxxxxxxxxxxgenpurpose03;
	private String b9xxuv03bvxxxxxxxxxxgenvalue03;
	private String c1xxuo04bvxxxxxxxxxxgenoptions04;
	private String c2xxup04bvxxxxxxxxxxgenpurpose04;
	private String c3xxuv04bvxxxxxxxxxxgenvalue04;
	private String c4xxuo05bvxxxxxxxxxxgenoptions05;
	private String c5xxup05bvxxxxxxxxxxgenpurpose05;
	private String c6xxuv05bvxxxxxxxxxxgenvalue05;
	private String c7xxuo06bvxxxxxxxxxxgenoptions06;
	private String c8xxup06bvxxxxxxxxxxgenpurpose06;
	private String c9xxuv06bvxxxxxxxxxxgenvalue06;
	private String d1xxuo07bvxxxxxxxxxxgenoptions07;
	private String d2xxup07bvxxxxxxxxxxgenpurpose07;
	private String d3xxuv07bvxxxxxxxxxxgenvalue07;
	private String d4xxuo08bvxxxxxxxxxxgenoptions08;
	private String d5xxup08bvxxxxxxxxxxgenpurpose08;
	private String d6xxuv08bvxxxxxxxxxxgenvalue08;
	private String d7xxuo09bvxxxxxxxxxxgenoptions09;
	private String d8xxup09bvxxxxxxxxxxgenpurpose09;
	private String d9xxuv09bvxxxxxxxxxxgenvalue09;
	private String e1xxuo10bvxxxxxxxxxxgenoptions10;
	private String e2xxup10bvxxxxxxxxxxgenpurpose10;
	private String e3xxuv10bvxxxxxxxxxxgenvalue10;
	private String e4xxuo11bvxxxxxxxxxxgenoptions11;
	private String e5xxup11bvxxxxxxxxxxgenpurpose11;
	private String e6xxuv11bvxxxxxxxxxxgenvalue11;
	private String e7xxuo12bvxxxxxxxxxxgenoptions12;
	private String e8xxup12bvxxxxxxxxxxgenpurpose12;
	private String e9xxuv12bvxxxxxxxxxxgenvalue12;
	private String f1xxuo13bvxxxxxxxxxxgenoptions13;
	private String f2xxup13bvxxxxxxxxxxgenpurpose13;
	private String f3xxuv13bvxxxxxxxxxxgenvalue13;
	private String f4xxuo14bvxxxxxxxxxxgenoptions14;
	private String f5xxup14bvxxxxxxxxxxgenpurpose14;
	private String f6xxuv14bvxxxxxxxxxxgenvalue14;
	private String f7xxuo15bvxxxxxxxxxxgenoptions15;
	private String f8xxup15bvxxxxxxxxxxgenpurpose15;
	private String f9xxuv15bvxxxxxxxxxxgenvalue15;
	private String g1xxuo16bvxxxxxxxxxxgenoptions16;
	private String g2xxup16bvxxxxxxxxxxgenpurpose16;
	private String g3xxuv16bvxxxxxxxxxxgenvalue16;
	private String g4xxuo17bvxxxxxxxxxxgenoptions17;
	private String g5xxup17bvxxxxxxxxxxgenpurpose17;
	private String g6xxuv17bvxxxxxxxxxxgenvalue17;
	private String g7xxuo18bvxxxxxxxxxxgenoptions18;
	private String g8xxup18bvxxxxxxxxxxgenpurpose18;
	private String g9xxuv18bvxxxxxxxxxxgenvalue18;
	private String h1xxuo19bvxxxxxxxxxxgenoptions19;
	private String h2xxup19bvxxxxxxxxxxgenpurpose19;
	private String h3xxuv19bvxxxxxxxxxxgenvalue19;
	private String h4xxuo20bvxxxxxxxxxxgenoptions20;
	private String h5xxup20bvxxxxxxxxxxgenpurpose20;
	private String h6xxuv20bvxxxxxxxxxxgenvalue20;
	private Integer r7xxzzfxhhxxxxxxxxxxstatusfl;
	private Date r8xxcztxlxxxxxxxxxxxstatusfldt;
	private String r9xxuxznbvxxxxxxxxxxnotes;
	private String s1xxutoxlhxxxxxxxxxxowner;
	private String zzxxu2oxxhxxxxxxxxxxowner2;

	public Yxxxuq582xwwqqhsgxxxgenoptions() {
	}

	public Yxxxuq582xwwqqhsgxxxgenoptions(String a0xxukgxbvxxxxxxxxxxrow) {
		this.a0xxukgxbvxxxxxxxxxxrow = a0xxukgxbvxxxxxxxxxxrow;
	}
	public Yxxxuq582xwwqqhsgxxxgenoptions(String a0xxukgxbvxxxxxxxxxxrow,
			String b1xxuo01bvxxxxxxxxxxgenoptions01,
			String b2xxup01bvxxxxxxxxxxgenpurpose01,
			String b3xxuv01bvxxxxxxxxxxgenvalue01,
			String b4xxuo02bvxxxxxxxxxxgenoptions02,
			String b5xxup02bvxxxxxxxxxxgenpurpose02,
			String b6xxuv02bvxxxxxxxxxxgenvalue02,
			String b7xxuo03bvxxxxxxxxxxgenoptions03,
			String b8xxup03bvxxxxxxxxxxgenpurpose03,
			String b9xxuv03bvxxxxxxxxxxgenvalue03,
			String c1xxuo04bvxxxxxxxxxxgenoptions04,
			String c2xxup04bvxxxxxxxxxxgenpurpose04,
			String c3xxuv04bvxxxxxxxxxxgenvalue04,
			String c4xxuo05bvxxxxxxxxxxgenoptions05,
			String c5xxup05bvxxxxxxxxxxgenpurpose05,
			String c6xxuv05bvxxxxxxxxxxgenvalue05,
			String c7xxuo06bvxxxxxxxxxxgenoptions06,
			String c8xxup06bvxxxxxxxxxxgenpurpose06,
			String c9xxuv06bvxxxxxxxxxxgenvalue06,
			String d1xxuo07bvxxxxxxxxxxgenoptions07,
			String d2xxup07bvxxxxxxxxxxgenpurpose07,
			String d3xxuv07bvxxxxxxxxxxgenvalue07,
			String d4xxuo08bvxxxxxxxxxxgenoptions08,
			String d5xxup08bvxxxxxxxxxxgenpurpose08,
			String d6xxuv08bvxxxxxxxxxxgenvalue08,
			String d7xxuo09bvxxxxxxxxxxgenoptions09,
			String d8xxup09bvxxxxxxxxxxgenpurpose09,
			String d9xxuv09bvxxxxxxxxxxgenvalue09,
			String e1xxuo10bvxxxxxxxxxxgenoptions10,
			String e2xxup10bvxxxxxxxxxxgenpurpose10,
			String e3xxuv10bvxxxxxxxxxxgenvalue10,
			String e4xxuo11bvxxxxxxxxxxgenoptions11,
			String e5xxup11bvxxxxxxxxxxgenpurpose11,
			String e6xxuv11bvxxxxxxxxxxgenvalue11,
			String e7xxuo12bvxxxxxxxxxxgenoptions12,
			String e8xxup12bvxxxxxxxxxxgenpurpose12,
			String e9xxuv12bvxxxxxxxxxxgenvalue12,
			String f1xxuo13bvxxxxxxxxxxgenoptions13,
			String f2xxup13bvxxxxxxxxxxgenpurpose13,
			String f3xxuv13bvxxxxxxxxxxgenvalue13,
			String f4xxuo14bvxxxxxxxxxxgenoptions14,
			String f5xxup14bvxxxxxxxxxxgenpurpose14,
			String f6xxuv14bvxxxxxxxxxxgenvalue14,
			String f7xxuo15bvxxxxxxxxxxgenoptions15,
			String f8xxup15bvxxxxxxxxxxgenpurpose15,
			String f9xxuv15bvxxxxxxxxxxgenvalue15,
			String g1xxuo16bvxxxxxxxxxxgenoptions16,
			String g2xxup16bvxxxxxxxxxxgenpurpose16,
			String g3xxuv16bvxxxxxxxxxxgenvalue16,
			String g4xxuo17bvxxxxxxxxxxgenoptions17,
			String g5xxup17bvxxxxxxxxxxgenpurpose17,
			String g6xxuv17bvxxxxxxxxxxgenvalue17,
			String g7xxuo18bvxxxxxxxxxxgenoptions18,
			String g8xxup18bvxxxxxxxxxxgenpurpose18,
			String g9xxuv18bvxxxxxxxxxxgenvalue18,
			String h1xxuo19bvxxxxxxxxxxgenoptions19,
			String h2xxup19bvxxxxxxxxxxgenpurpose19,
			String h3xxuv19bvxxxxxxxxxxgenvalue19,
			String h4xxuo20bvxxxxxxxxxxgenoptions20,
			String h5xxup20bvxxxxxxxxxxgenpurpose20,
			String h6xxuv20bvxxxxxxxxxxgenvalue20,
			Integer r7xxzzfxhhxxxxxxxxxxstatusfl,
			Date r8xxcztxlxxxxxxxxxxxstatusfldt,
			String r9xxuxznbvxxxxxxxxxxnotes, String s1xxutoxlhxxxxxxxxxxowner,
			String zzxxu2oxxhxxxxxxxxxxowner2) {
		this.a0xxukgxbvxxxxxxxxxxrow = a0xxukgxbvxxxxxxxxxxrow;
		this.b1xxuo01bvxxxxxxxxxxgenoptions01 = b1xxuo01bvxxxxxxxxxxgenoptions01;
		this.b2xxup01bvxxxxxxxxxxgenpurpose01 = b2xxup01bvxxxxxxxxxxgenpurpose01;
		this.b3xxuv01bvxxxxxxxxxxgenvalue01 = b3xxuv01bvxxxxxxxxxxgenvalue01;
		this.b4xxuo02bvxxxxxxxxxxgenoptions02 = b4xxuo02bvxxxxxxxxxxgenoptions02;
		this.b5xxup02bvxxxxxxxxxxgenpurpose02 = b5xxup02bvxxxxxxxxxxgenpurpose02;
		this.b6xxuv02bvxxxxxxxxxxgenvalue02 = b6xxuv02bvxxxxxxxxxxgenvalue02;
		this.b7xxuo03bvxxxxxxxxxxgenoptions03 = b7xxuo03bvxxxxxxxxxxgenoptions03;
		this.b8xxup03bvxxxxxxxxxxgenpurpose03 = b8xxup03bvxxxxxxxxxxgenpurpose03;
		this.b9xxuv03bvxxxxxxxxxxgenvalue03 = b9xxuv03bvxxxxxxxxxxgenvalue03;
		this.c1xxuo04bvxxxxxxxxxxgenoptions04 = c1xxuo04bvxxxxxxxxxxgenoptions04;
		this.c2xxup04bvxxxxxxxxxxgenpurpose04 = c2xxup04bvxxxxxxxxxxgenpurpose04;
		this.c3xxuv04bvxxxxxxxxxxgenvalue04 = c3xxuv04bvxxxxxxxxxxgenvalue04;
		this.c4xxuo05bvxxxxxxxxxxgenoptions05 = c4xxuo05bvxxxxxxxxxxgenoptions05;
		this.c5xxup05bvxxxxxxxxxxgenpurpose05 = c5xxup05bvxxxxxxxxxxgenpurpose05;
		this.c6xxuv05bvxxxxxxxxxxgenvalue05 = c6xxuv05bvxxxxxxxxxxgenvalue05;
		this.c7xxuo06bvxxxxxxxxxxgenoptions06 = c7xxuo06bvxxxxxxxxxxgenoptions06;
		this.c8xxup06bvxxxxxxxxxxgenpurpose06 = c8xxup06bvxxxxxxxxxxgenpurpose06;
		this.c9xxuv06bvxxxxxxxxxxgenvalue06 = c9xxuv06bvxxxxxxxxxxgenvalue06;
		this.d1xxuo07bvxxxxxxxxxxgenoptions07 = d1xxuo07bvxxxxxxxxxxgenoptions07;
		this.d2xxup07bvxxxxxxxxxxgenpurpose07 = d2xxup07bvxxxxxxxxxxgenpurpose07;
		this.d3xxuv07bvxxxxxxxxxxgenvalue07 = d3xxuv07bvxxxxxxxxxxgenvalue07;
		this.d4xxuo08bvxxxxxxxxxxgenoptions08 = d4xxuo08bvxxxxxxxxxxgenoptions08;
		this.d5xxup08bvxxxxxxxxxxgenpurpose08 = d5xxup08bvxxxxxxxxxxgenpurpose08;
		this.d6xxuv08bvxxxxxxxxxxgenvalue08 = d6xxuv08bvxxxxxxxxxxgenvalue08;
		this.d7xxuo09bvxxxxxxxxxxgenoptions09 = d7xxuo09bvxxxxxxxxxxgenoptions09;
		this.d8xxup09bvxxxxxxxxxxgenpurpose09 = d8xxup09bvxxxxxxxxxxgenpurpose09;
		this.d9xxuv09bvxxxxxxxxxxgenvalue09 = d9xxuv09bvxxxxxxxxxxgenvalue09;
		this.e1xxuo10bvxxxxxxxxxxgenoptions10 = e1xxuo10bvxxxxxxxxxxgenoptions10;
		this.e2xxup10bvxxxxxxxxxxgenpurpose10 = e2xxup10bvxxxxxxxxxxgenpurpose10;
		this.e3xxuv10bvxxxxxxxxxxgenvalue10 = e3xxuv10bvxxxxxxxxxxgenvalue10;
		this.e4xxuo11bvxxxxxxxxxxgenoptions11 = e4xxuo11bvxxxxxxxxxxgenoptions11;
		this.e5xxup11bvxxxxxxxxxxgenpurpose11 = e5xxup11bvxxxxxxxxxxgenpurpose11;
		this.e6xxuv11bvxxxxxxxxxxgenvalue11 = e6xxuv11bvxxxxxxxxxxgenvalue11;
		this.e7xxuo12bvxxxxxxxxxxgenoptions12 = e7xxuo12bvxxxxxxxxxxgenoptions12;
		this.e8xxup12bvxxxxxxxxxxgenpurpose12 = e8xxup12bvxxxxxxxxxxgenpurpose12;
		this.e9xxuv12bvxxxxxxxxxxgenvalue12 = e9xxuv12bvxxxxxxxxxxgenvalue12;
		this.f1xxuo13bvxxxxxxxxxxgenoptions13 = f1xxuo13bvxxxxxxxxxxgenoptions13;
		this.f2xxup13bvxxxxxxxxxxgenpurpose13 = f2xxup13bvxxxxxxxxxxgenpurpose13;
		this.f3xxuv13bvxxxxxxxxxxgenvalue13 = f3xxuv13bvxxxxxxxxxxgenvalue13;
		this.f4xxuo14bvxxxxxxxxxxgenoptions14 = f4xxuo14bvxxxxxxxxxxgenoptions14;
		this.f5xxup14bvxxxxxxxxxxgenpurpose14 = f5xxup14bvxxxxxxxxxxgenpurpose14;
		this.f6xxuv14bvxxxxxxxxxxgenvalue14 = f6xxuv14bvxxxxxxxxxxgenvalue14;
		this.f7xxuo15bvxxxxxxxxxxgenoptions15 = f7xxuo15bvxxxxxxxxxxgenoptions15;
		this.f8xxup15bvxxxxxxxxxxgenpurpose15 = f8xxup15bvxxxxxxxxxxgenpurpose15;
		this.f9xxuv15bvxxxxxxxxxxgenvalue15 = f9xxuv15bvxxxxxxxxxxgenvalue15;
		this.g1xxuo16bvxxxxxxxxxxgenoptions16 = g1xxuo16bvxxxxxxxxxxgenoptions16;
		this.g2xxup16bvxxxxxxxxxxgenpurpose16 = g2xxup16bvxxxxxxxxxxgenpurpose16;
		this.g3xxuv16bvxxxxxxxxxxgenvalue16 = g3xxuv16bvxxxxxxxxxxgenvalue16;
		this.g4xxuo17bvxxxxxxxxxxgenoptions17 = g4xxuo17bvxxxxxxxxxxgenoptions17;
		this.g5xxup17bvxxxxxxxxxxgenpurpose17 = g5xxup17bvxxxxxxxxxxgenpurpose17;
		this.g6xxuv17bvxxxxxxxxxxgenvalue17 = g6xxuv17bvxxxxxxxxxxgenvalue17;
		this.g7xxuo18bvxxxxxxxxxxgenoptions18 = g7xxuo18bvxxxxxxxxxxgenoptions18;
		this.g8xxup18bvxxxxxxxxxxgenpurpose18 = g8xxup18bvxxxxxxxxxxgenpurpose18;
		this.g9xxuv18bvxxxxxxxxxxgenvalue18 = g9xxuv18bvxxxxxxxxxxgenvalue18;
		this.h1xxuo19bvxxxxxxxxxxgenoptions19 = h1xxuo19bvxxxxxxxxxxgenoptions19;
		this.h2xxup19bvxxxxxxxxxxgenpurpose19 = h2xxup19bvxxxxxxxxxxgenpurpose19;
		this.h3xxuv19bvxxxxxxxxxxgenvalue19 = h3xxuv19bvxxxxxxxxxxgenvalue19;
		this.h4xxuo20bvxxxxxxxxxxgenoptions20 = h4xxuo20bvxxxxxxxxxxgenoptions20;
		this.h5xxup20bvxxxxxxxxxxgenpurpose20 = h5xxup20bvxxxxxxxxxxgenpurpose20;
		this.h6xxuv20bvxxxxxxxxxxgenvalue20 = h6xxuv20bvxxxxxxxxxxgenvalue20;
		this.r7xxzzfxhhxxxxxxxxxxstatusfl = r7xxzzfxhhxxxxxxxxxxstatusfl;
		this.r8xxcztxlxxxxxxxxxxxstatusfldt = r8xxcztxlxxxxxxxxxxxstatusfldt;
		this.r9xxuxznbvxxxxxxxxxxnotes = r9xxuxznbvxxxxxxxxxxnotes;
		this.s1xxutoxlhxxxxxxxxxxowner = s1xxutoxlhxxxxxxxxxxowner;
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

	@Column(name = "row", nullable = false, length = 2)
	@NotNull
	@Size(max = 2)
	public String getA0xxukgxbvxxxxxxxxxxrow() {
		return this.a0xxukgxbvxxxxxxxxxxrow;
	}

	public void setA0xxukgxbvxxxxxxxxxxrow(String a0xxukgxbvxxxxxxxxxxrow) {
		this.a0xxukgxbvxxxxxxxxxxrow = a0xxukgxbvxxxxxxxxxxrow;
	}

	@Column(name = "genoptions01", length = 159)
	@Size(max = 159)
	public String getB1xxuo01bvxxxxxxxxxxgenoptions01() {
		return this.b1xxuo01bvxxxxxxxxxxgenoptions01;
	}

	public void setB1xxuo01bvxxxxxxxxxxgenoptions01(
			String b1xxuo01bvxxxxxxxxxxgenoptions01) {
		this.b1xxuo01bvxxxxxxxxxxgenoptions01 = b1xxuo01bvxxxxxxxxxxgenoptions01;
	}

	@Column(name = "genpurpose01", length = 159)
	@Size(max = 159)
	public String getB2xxup01bvxxxxxxxxxxgenpurpose01() {
		return this.b2xxup01bvxxxxxxxxxxgenpurpose01;
	}

	public void setB2xxup01bvxxxxxxxxxxgenpurpose01(
			String b2xxup01bvxxxxxxxxxxgenpurpose01) {
		this.b2xxup01bvxxxxxxxxxxgenpurpose01 = b2xxup01bvxxxxxxxxxxgenpurpose01;
	}

	@Column(name = "genvalue01", length = 159)
	@Size(max = 159)
	public String getB3xxuv01bvxxxxxxxxxxgenvalue01() {
		return this.b3xxuv01bvxxxxxxxxxxgenvalue01;
	}

	public void setB3xxuv01bvxxxxxxxxxxgenvalue01(
			String b3xxuv01bvxxxxxxxxxxgenvalue01) {
		this.b3xxuv01bvxxxxxxxxxxgenvalue01 = b3xxuv01bvxxxxxxxxxxgenvalue01;
	}

	@Column(name = "genoptions02", length = 159)
	@Size(max = 159)
	public String getB4xxuo02bvxxxxxxxxxxgenoptions02() {
		return this.b4xxuo02bvxxxxxxxxxxgenoptions02;
	}

	public void setB4xxuo02bvxxxxxxxxxxgenoptions02(
			String b4xxuo02bvxxxxxxxxxxgenoptions02) {
		this.b4xxuo02bvxxxxxxxxxxgenoptions02 = b4xxuo02bvxxxxxxxxxxgenoptions02;
	}

	@Column(name = "genpurpose02", length = 159)
	@Size(max = 159)
	public String getB5xxup02bvxxxxxxxxxxgenpurpose02() {
		return this.b5xxup02bvxxxxxxxxxxgenpurpose02;
	}

	public void setB5xxup02bvxxxxxxxxxxgenpurpose02(
			String b5xxup02bvxxxxxxxxxxgenpurpose02) {
		this.b5xxup02bvxxxxxxxxxxgenpurpose02 = b5xxup02bvxxxxxxxxxxgenpurpose02;
	}

	@Column(name = "genvalue02", length = 159)
	@Size(max = 159)
	public String getB6xxuv02bvxxxxxxxxxxgenvalue02() {
		return this.b6xxuv02bvxxxxxxxxxxgenvalue02;
	}

	public void setB6xxuv02bvxxxxxxxxxxgenvalue02(
			String b6xxuv02bvxxxxxxxxxxgenvalue02) {
		this.b6xxuv02bvxxxxxxxxxxgenvalue02 = b6xxuv02bvxxxxxxxxxxgenvalue02;
	}

	@Column(name = "genoptions03", length = 159)
	@Size(max = 159)
	public String getB7xxuo03bvxxxxxxxxxxgenoptions03() {
		return this.b7xxuo03bvxxxxxxxxxxgenoptions03;
	}

	public void setB7xxuo03bvxxxxxxxxxxgenoptions03(
			String b7xxuo03bvxxxxxxxxxxgenoptions03) {
		this.b7xxuo03bvxxxxxxxxxxgenoptions03 = b7xxuo03bvxxxxxxxxxxgenoptions03;
	}

	@Column(name = "genpurpose03", length = 159)
	@Size(max = 159)
	public String getB8xxup03bvxxxxxxxxxxgenpurpose03() {
		return this.b8xxup03bvxxxxxxxxxxgenpurpose03;
	}

	public void setB8xxup03bvxxxxxxxxxxgenpurpose03(
			String b8xxup03bvxxxxxxxxxxgenpurpose03) {
		this.b8xxup03bvxxxxxxxxxxgenpurpose03 = b8xxup03bvxxxxxxxxxxgenpurpose03;
	}

	@Column(name = "genvalue03", length = 159)
	@Size(max = 159)
	public String getB9xxuv03bvxxxxxxxxxxgenvalue03() {
		return this.b9xxuv03bvxxxxxxxxxxgenvalue03;
	}

	public void setB9xxuv03bvxxxxxxxxxxgenvalue03(
			String b9xxuv03bvxxxxxxxxxxgenvalue03) {
		this.b9xxuv03bvxxxxxxxxxxgenvalue03 = b9xxuv03bvxxxxxxxxxxgenvalue03;
	}

	@Column(name = "genoptions04", length = 159)
	@Size(max = 159)
	public String getC1xxuo04bvxxxxxxxxxxgenoptions04() {
		return this.c1xxuo04bvxxxxxxxxxxgenoptions04;
	}

	public void setC1xxuo04bvxxxxxxxxxxgenoptions04(
			String c1xxuo04bvxxxxxxxxxxgenoptions04) {
		this.c1xxuo04bvxxxxxxxxxxgenoptions04 = c1xxuo04bvxxxxxxxxxxgenoptions04;
	}

	@Column(name = "genpurpose04", length = 159)
	@Size(max = 159)
	public String getC2xxup04bvxxxxxxxxxxgenpurpose04() {
		return this.c2xxup04bvxxxxxxxxxxgenpurpose04;
	}

	public void setC2xxup04bvxxxxxxxxxxgenpurpose04(
			String c2xxup04bvxxxxxxxxxxgenpurpose04) {
		this.c2xxup04bvxxxxxxxxxxgenpurpose04 = c2xxup04bvxxxxxxxxxxgenpurpose04;
	}

	@Column(name = "genvalue04", length = 159)
	@Size(max = 159)
	public String getC3xxuv04bvxxxxxxxxxxgenvalue04() {
		return this.c3xxuv04bvxxxxxxxxxxgenvalue04;
	}

	public void setC3xxuv04bvxxxxxxxxxxgenvalue04(
			String c3xxuv04bvxxxxxxxxxxgenvalue04) {
		this.c3xxuv04bvxxxxxxxxxxgenvalue04 = c3xxuv04bvxxxxxxxxxxgenvalue04;
	}

	@Column(name = "genoptions05", length = 159)
	@Size(max = 159)
	public String getC4xxuo05bvxxxxxxxxxxgenoptions05() {
		return this.c4xxuo05bvxxxxxxxxxxgenoptions05;
	}

	public void setC4xxuo05bvxxxxxxxxxxgenoptions05(
			String c4xxuo05bvxxxxxxxxxxgenoptions05) {
		this.c4xxuo05bvxxxxxxxxxxgenoptions05 = c4xxuo05bvxxxxxxxxxxgenoptions05;
	}

	@Column(name = "genpurpose05", length = 159)
	@Size(max = 159)
	public String getC5xxup05bvxxxxxxxxxxgenpurpose05() {
		return this.c5xxup05bvxxxxxxxxxxgenpurpose05;
	}

	public void setC5xxup05bvxxxxxxxxxxgenpurpose05(
			String c5xxup05bvxxxxxxxxxxgenpurpose05) {
		this.c5xxup05bvxxxxxxxxxxgenpurpose05 = c5xxup05bvxxxxxxxxxxgenpurpose05;
	}

	@Column(name = "genvalue05", length = 159)
	@Size(max = 159)
	public String getC6xxuv05bvxxxxxxxxxxgenvalue05() {
		return this.c6xxuv05bvxxxxxxxxxxgenvalue05;
	}

	public void setC6xxuv05bvxxxxxxxxxxgenvalue05(
			String c6xxuv05bvxxxxxxxxxxgenvalue05) {
		this.c6xxuv05bvxxxxxxxxxxgenvalue05 = c6xxuv05bvxxxxxxxxxxgenvalue05;
	}

	@Column(name = "genoptions06", length = 159)
	@Size(max = 159)
	public String getC7xxuo06bvxxxxxxxxxxgenoptions06() {
		return this.c7xxuo06bvxxxxxxxxxxgenoptions06;
	}

	public void setC7xxuo06bvxxxxxxxxxxgenoptions06(
			String c7xxuo06bvxxxxxxxxxxgenoptions06) {
		this.c7xxuo06bvxxxxxxxxxxgenoptions06 = c7xxuo06bvxxxxxxxxxxgenoptions06;
	}

	@Column(name = "genpurpose06", length = 159)
	@Size(max = 159)
	public String getC8xxup06bvxxxxxxxxxxgenpurpose06() {
		return this.c8xxup06bvxxxxxxxxxxgenpurpose06;
	}

	public void setC8xxup06bvxxxxxxxxxxgenpurpose06(
			String c8xxup06bvxxxxxxxxxxgenpurpose06) {
		this.c8xxup06bvxxxxxxxxxxgenpurpose06 = c8xxup06bvxxxxxxxxxxgenpurpose06;
	}

	@Column(name = "genvalue06", length = 159)
	@Size(max = 159)
	public String getC9xxuv06bvxxxxxxxxxxgenvalue06() {
		return this.c9xxuv06bvxxxxxxxxxxgenvalue06;
	}

	public void setC9xxuv06bvxxxxxxxxxxgenvalue06(
			String c9xxuv06bvxxxxxxxxxxgenvalue06) {
		this.c9xxuv06bvxxxxxxxxxxgenvalue06 = c9xxuv06bvxxxxxxxxxxgenvalue06;
	}

	@Column(name = "genoptions07", length = 159)
	@Size(max = 159)
	public String getD1xxuo07bvxxxxxxxxxxgenoptions07() {
		return this.d1xxuo07bvxxxxxxxxxxgenoptions07;
	}

	public void setD1xxuo07bvxxxxxxxxxxgenoptions07(
			String d1xxuo07bvxxxxxxxxxxgenoptions07) {
		this.d1xxuo07bvxxxxxxxxxxgenoptions07 = d1xxuo07bvxxxxxxxxxxgenoptions07;
	}

	@Column(name = "genpurpose07", length = 159)
	@Size(max = 159)
	public String getD2xxup07bvxxxxxxxxxxgenpurpose07() {
		return this.d2xxup07bvxxxxxxxxxxgenpurpose07;
	}

	public void setD2xxup07bvxxxxxxxxxxgenpurpose07(
			String d2xxup07bvxxxxxxxxxxgenpurpose07) {
		this.d2xxup07bvxxxxxxxxxxgenpurpose07 = d2xxup07bvxxxxxxxxxxgenpurpose07;
	}

	@Column(name = "genvalue07", length = 159)
	@Size(max = 159)
	public String getD3xxuv07bvxxxxxxxxxxgenvalue07() {
		return this.d3xxuv07bvxxxxxxxxxxgenvalue07;
	}

	public void setD3xxuv07bvxxxxxxxxxxgenvalue07(
			String d3xxuv07bvxxxxxxxxxxgenvalue07) {
		this.d3xxuv07bvxxxxxxxxxxgenvalue07 = d3xxuv07bvxxxxxxxxxxgenvalue07;
	}

	@Column(name = "genoptions08", length = 159)
	@Size(max = 159)
	public String getD4xxuo08bvxxxxxxxxxxgenoptions08() {
		return this.d4xxuo08bvxxxxxxxxxxgenoptions08;
	}

	public void setD4xxuo08bvxxxxxxxxxxgenoptions08(
			String d4xxuo08bvxxxxxxxxxxgenoptions08) {
		this.d4xxuo08bvxxxxxxxxxxgenoptions08 = d4xxuo08bvxxxxxxxxxxgenoptions08;
	}

	@Column(name = "genpurpose08", length = 159)
	@Size(max = 159)
	public String getD5xxup08bvxxxxxxxxxxgenpurpose08() {
		return this.d5xxup08bvxxxxxxxxxxgenpurpose08;
	}

	public void setD5xxup08bvxxxxxxxxxxgenpurpose08(
			String d5xxup08bvxxxxxxxxxxgenpurpose08) {
		this.d5xxup08bvxxxxxxxxxxgenpurpose08 = d5xxup08bvxxxxxxxxxxgenpurpose08;
	}

	@Column(name = "genvalue08", length = 159)
	@Size(max = 159)
	public String getD6xxuv08bvxxxxxxxxxxgenvalue08() {
		return this.d6xxuv08bvxxxxxxxxxxgenvalue08;
	}

	public void setD6xxuv08bvxxxxxxxxxxgenvalue08(
			String d6xxuv08bvxxxxxxxxxxgenvalue08) {
		this.d6xxuv08bvxxxxxxxxxxgenvalue08 = d6xxuv08bvxxxxxxxxxxgenvalue08;
	}

	@Column(name = "genoptions09", length = 159)
	@Size(max = 159)
	public String getD7xxuo09bvxxxxxxxxxxgenoptions09() {
		return this.d7xxuo09bvxxxxxxxxxxgenoptions09;
	}

	public void setD7xxuo09bvxxxxxxxxxxgenoptions09(
			String d7xxuo09bvxxxxxxxxxxgenoptions09) {
		this.d7xxuo09bvxxxxxxxxxxgenoptions09 = d7xxuo09bvxxxxxxxxxxgenoptions09;
	}

	@Column(name = "genpurpose09", length = 159)
	@Size(max = 159)
	public String getD8xxup09bvxxxxxxxxxxgenpurpose09() {
		return this.d8xxup09bvxxxxxxxxxxgenpurpose09;
	}

	public void setD8xxup09bvxxxxxxxxxxgenpurpose09(
			String d8xxup09bvxxxxxxxxxxgenpurpose09) {
		this.d8xxup09bvxxxxxxxxxxgenpurpose09 = d8xxup09bvxxxxxxxxxxgenpurpose09;
	}

	@Column(name = "genvalue09", length = 159)
	@Size(max = 159)
	public String getD9xxuv09bvxxxxxxxxxxgenvalue09() {
		return this.d9xxuv09bvxxxxxxxxxxgenvalue09;
	}

	public void setD9xxuv09bvxxxxxxxxxxgenvalue09(
			String d9xxuv09bvxxxxxxxxxxgenvalue09) {
		this.d9xxuv09bvxxxxxxxxxxgenvalue09 = d9xxuv09bvxxxxxxxxxxgenvalue09;
	}

	@Column(name = "genoptions10", length = 159)
	@Size(max = 159)
	public String getE1xxuo10bvxxxxxxxxxxgenoptions10() {
		return this.e1xxuo10bvxxxxxxxxxxgenoptions10;
	}

	public void setE1xxuo10bvxxxxxxxxxxgenoptions10(
			String e1xxuo10bvxxxxxxxxxxgenoptions10) {
		this.e1xxuo10bvxxxxxxxxxxgenoptions10 = e1xxuo10bvxxxxxxxxxxgenoptions10;
	}

	@Column(name = "genpurpose10", length = 159)
	@Size(max = 159)
	public String getE2xxup10bvxxxxxxxxxxgenpurpose10() {
		return this.e2xxup10bvxxxxxxxxxxgenpurpose10;
	}

	public void setE2xxup10bvxxxxxxxxxxgenpurpose10(
			String e2xxup10bvxxxxxxxxxxgenpurpose10) {
		this.e2xxup10bvxxxxxxxxxxgenpurpose10 = e2xxup10bvxxxxxxxxxxgenpurpose10;
	}

	@Column(name = "genvalue10", length = 159)
	@Size(max = 159)
	public String getE3xxuv10bvxxxxxxxxxxgenvalue10() {
		return this.e3xxuv10bvxxxxxxxxxxgenvalue10;
	}

	public void setE3xxuv10bvxxxxxxxxxxgenvalue10(
			String e3xxuv10bvxxxxxxxxxxgenvalue10) {
		this.e3xxuv10bvxxxxxxxxxxgenvalue10 = e3xxuv10bvxxxxxxxxxxgenvalue10;
	}

	@Column(name = "genoptions11", length = 159)
	@Size(max = 159)
	public String getE4xxuo11bvxxxxxxxxxxgenoptions11() {
		return this.e4xxuo11bvxxxxxxxxxxgenoptions11;
	}

	public void setE4xxuo11bvxxxxxxxxxxgenoptions11(
			String e4xxuo11bvxxxxxxxxxxgenoptions11) {
		this.e4xxuo11bvxxxxxxxxxxgenoptions11 = e4xxuo11bvxxxxxxxxxxgenoptions11;
	}

	@Column(name = "genpurpose11", length = 159)
	@Size(max = 159)
	public String getE5xxup11bvxxxxxxxxxxgenpurpose11() {
		return this.e5xxup11bvxxxxxxxxxxgenpurpose11;
	}

	public void setE5xxup11bvxxxxxxxxxxgenpurpose11(
			String e5xxup11bvxxxxxxxxxxgenpurpose11) {
		this.e5xxup11bvxxxxxxxxxxgenpurpose11 = e5xxup11bvxxxxxxxxxxgenpurpose11;
	}

	@Column(name = "genvalue11", length = 159)
	@Size(max = 159)
	public String getE6xxuv11bvxxxxxxxxxxgenvalue11() {
		return this.e6xxuv11bvxxxxxxxxxxgenvalue11;
	}

	public void setE6xxuv11bvxxxxxxxxxxgenvalue11(
			String e6xxuv11bvxxxxxxxxxxgenvalue11) {
		this.e6xxuv11bvxxxxxxxxxxgenvalue11 = e6xxuv11bvxxxxxxxxxxgenvalue11;
	}

	@Column(name = "genoptions12", length = 159)
	@Size(max = 159)
	public String getE7xxuo12bvxxxxxxxxxxgenoptions12() {
		return this.e7xxuo12bvxxxxxxxxxxgenoptions12;
	}

	public void setE7xxuo12bvxxxxxxxxxxgenoptions12(
			String e7xxuo12bvxxxxxxxxxxgenoptions12) {
		this.e7xxuo12bvxxxxxxxxxxgenoptions12 = e7xxuo12bvxxxxxxxxxxgenoptions12;
	}

	@Column(name = "genpurpose12", length = 159)
	@Size(max = 159)
	public String getE8xxup12bvxxxxxxxxxxgenpurpose12() {
		return this.e8xxup12bvxxxxxxxxxxgenpurpose12;
	}

	public void setE8xxup12bvxxxxxxxxxxgenpurpose12(
			String e8xxup12bvxxxxxxxxxxgenpurpose12) {
		this.e8xxup12bvxxxxxxxxxxgenpurpose12 = e8xxup12bvxxxxxxxxxxgenpurpose12;
	}

	@Column(name = "genvalue12", length = 159)
	@Size(max = 159)
	public String getE9xxuv12bvxxxxxxxxxxgenvalue12() {
		return this.e9xxuv12bvxxxxxxxxxxgenvalue12;
	}

	public void setE9xxuv12bvxxxxxxxxxxgenvalue12(
			String e9xxuv12bvxxxxxxxxxxgenvalue12) {
		this.e9xxuv12bvxxxxxxxxxxgenvalue12 = e9xxuv12bvxxxxxxxxxxgenvalue12;
	}

	@Column(name = "genoptions13", length = 159)
	@Size(max = 159)
	public String getF1xxuo13bvxxxxxxxxxxgenoptions13() {
		return this.f1xxuo13bvxxxxxxxxxxgenoptions13;
	}

	public void setF1xxuo13bvxxxxxxxxxxgenoptions13(
			String f1xxuo13bvxxxxxxxxxxgenoptions13) {
		this.f1xxuo13bvxxxxxxxxxxgenoptions13 = f1xxuo13bvxxxxxxxxxxgenoptions13;
	}

	@Column(name = "genpurpose13", length = 159)
	@Size(max = 159)
	public String getF2xxup13bvxxxxxxxxxxgenpurpose13() {
		return this.f2xxup13bvxxxxxxxxxxgenpurpose13;
	}

	public void setF2xxup13bvxxxxxxxxxxgenpurpose13(
			String f2xxup13bvxxxxxxxxxxgenpurpose13) {
		this.f2xxup13bvxxxxxxxxxxgenpurpose13 = f2xxup13bvxxxxxxxxxxgenpurpose13;
	}

	@Column(name = "genvalue13", length = 159)
	@Size(max = 159)
	public String getF3xxuv13bvxxxxxxxxxxgenvalue13() {
		return this.f3xxuv13bvxxxxxxxxxxgenvalue13;
	}

	public void setF3xxuv13bvxxxxxxxxxxgenvalue13(
			String f3xxuv13bvxxxxxxxxxxgenvalue13) {
		this.f3xxuv13bvxxxxxxxxxxgenvalue13 = f3xxuv13bvxxxxxxxxxxgenvalue13;
	}

	@Column(name = "genoptions14", length = 159)
	@Size(max = 159)
	public String getF4xxuo14bvxxxxxxxxxxgenoptions14() {
		return this.f4xxuo14bvxxxxxxxxxxgenoptions14;
	}

	public void setF4xxuo14bvxxxxxxxxxxgenoptions14(
			String f4xxuo14bvxxxxxxxxxxgenoptions14) {
		this.f4xxuo14bvxxxxxxxxxxgenoptions14 = f4xxuo14bvxxxxxxxxxxgenoptions14;
	}

	@Column(name = "genpurpose14", length = 159)
	@Size(max = 159)
	public String getF5xxup14bvxxxxxxxxxxgenpurpose14() {
		return this.f5xxup14bvxxxxxxxxxxgenpurpose14;
	}

	public void setF5xxup14bvxxxxxxxxxxgenpurpose14(
			String f5xxup14bvxxxxxxxxxxgenpurpose14) {
		this.f5xxup14bvxxxxxxxxxxgenpurpose14 = f5xxup14bvxxxxxxxxxxgenpurpose14;
	}

	@Column(name = "genvalue14", length = 159)
	@Size(max = 159)
	public String getF6xxuv14bvxxxxxxxxxxgenvalue14() {
		return this.f6xxuv14bvxxxxxxxxxxgenvalue14;
	}

	public void setF6xxuv14bvxxxxxxxxxxgenvalue14(
			String f6xxuv14bvxxxxxxxxxxgenvalue14) {
		this.f6xxuv14bvxxxxxxxxxxgenvalue14 = f6xxuv14bvxxxxxxxxxxgenvalue14;
	}

	@Column(name = "genoptions15", length = 159)
	@Size(max = 159)
	public String getF7xxuo15bvxxxxxxxxxxgenoptions15() {
		return this.f7xxuo15bvxxxxxxxxxxgenoptions15;
	}

	public void setF7xxuo15bvxxxxxxxxxxgenoptions15(
			String f7xxuo15bvxxxxxxxxxxgenoptions15) {
		this.f7xxuo15bvxxxxxxxxxxgenoptions15 = f7xxuo15bvxxxxxxxxxxgenoptions15;
	}

	@Column(name = "genpurpose15", length = 159)
	@Size(max = 159)
	public String getF8xxup15bvxxxxxxxxxxgenpurpose15() {
		return this.f8xxup15bvxxxxxxxxxxgenpurpose15;
	}

	public void setF8xxup15bvxxxxxxxxxxgenpurpose15(
			String f8xxup15bvxxxxxxxxxxgenpurpose15) {
		this.f8xxup15bvxxxxxxxxxxgenpurpose15 = f8xxup15bvxxxxxxxxxxgenpurpose15;
	}

	@Column(name = "genvalue15", length = 159)
	@Size(max = 159)
	public String getF9xxuv15bvxxxxxxxxxxgenvalue15() {
		return this.f9xxuv15bvxxxxxxxxxxgenvalue15;
	}

	public void setF9xxuv15bvxxxxxxxxxxgenvalue15(
			String f9xxuv15bvxxxxxxxxxxgenvalue15) {
		this.f9xxuv15bvxxxxxxxxxxgenvalue15 = f9xxuv15bvxxxxxxxxxxgenvalue15;
	}

	@Column(name = "genoptions16", length = 159)
	@Size(max = 159)
	public String getG1xxuo16bvxxxxxxxxxxgenoptions16() {
		return this.g1xxuo16bvxxxxxxxxxxgenoptions16;
	}

	public void setG1xxuo16bvxxxxxxxxxxgenoptions16(
			String g1xxuo16bvxxxxxxxxxxgenoptions16) {
		this.g1xxuo16bvxxxxxxxxxxgenoptions16 = g1xxuo16bvxxxxxxxxxxgenoptions16;
	}

	@Column(name = "genpurpose16", length = 159)
	@Size(max = 159)
	public String getG2xxup16bvxxxxxxxxxxgenpurpose16() {
		return this.g2xxup16bvxxxxxxxxxxgenpurpose16;
	}

	public void setG2xxup16bvxxxxxxxxxxgenpurpose16(
			String g2xxup16bvxxxxxxxxxxgenpurpose16) {
		this.g2xxup16bvxxxxxxxxxxgenpurpose16 = g2xxup16bvxxxxxxxxxxgenpurpose16;
	}

	@Column(name = "genvalue16", length = 159)
	@Size(max = 159)
	public String getG3xxuv16bvxxxxxxxxxxgenvalue16() {
		return this.g3xxuv16bvxxxxxxxxxxgenvalue16;
	}

	public void setG3xxuv16bvxxxxxxxxxxgenvalue16(
			String g3xxuv16bvxxxxxxxxxxgenvalue16) {
		this.g3xxuv16bvxxxxxxxxxxgenvalue16 = g3xxuv16bvxxxxxxxxxxgenvalue16;
	}

	@Column(name = "genoptions17", length = 159)
	@Size(max = 159)
	public String getG4xxuo17bvxxxxxxxxxxgenoptions17() {
		return this.g4xxuo17bvxxxxxxxxxxgenoptions17;
	}

	public void setG4xxuo17bvxxxxxxxxxxgenoptions17(
			String g4xxuo17bvxxxxxxxxxxgenoptions17) {
		this.g4xxuo17bvxxxxxxxxxxgenoptions17 = g4xxuo17bvxxxxxxxxxxgenoptions17;
	}

	@Column(name = "genpurpose17", length = 159)
	@Size(max = 159)
	public String getG5xxup17bvxxxxxxxxxxgenpurpose17() {
		return this.g5xxup17bvxxxxxxxxxxgenpurpose17;
	}

	public void setG5xxup17bvxxxxxxxxxxgenpurpose17(
			String g5xxup17bvxxxxxxxxxxgenpurpose17) {
		this.g5xxup17bvxxxxxxxxxxgenpurpose17 = g5xxup17bvxxxxxxxxxxgenpurpose17;
	}

	@Column(name = "genvalue17", length = 159)
	@Size(max = 159)
	public String getG6xxuv17bvxxxxxxxxxxgenvalue17() {
		return this.g6xxuv17bvxxxxxxxxxxgenvalue17;
	}

	public void setG6xxuv17bvxxxxxxxxxxgenvalue17(
			String g6xxuv17bvxxxxxxxxxxgenvalue17) {
		this.g6xxuv17bvxxxxxxxxxxgenvalue17 = g6xxuv17bvxxxxxxxxxxgenvalue17;
	}

	@Column(name = "genoptions18", length = 159)
	@Size(max = 159)
	public String getG7xxuo18bvxxxxxxxxxxgenoptions18() {
		return this.g7xxuo18bvxxxxxxxxxxgenoptions18;
	}

	public void setG7xxuo18bvxxxxxxxxxxgenoptions18(
			String g7xxuo18bvxxxxxxxxxxgenoptions18) {
		this.g7xxuo18bvxxxxxxxxxxgenoptions18 = g7xxuo18bvxxxxxxxxxxgenoptions18;
	}

	@Column(name = "genpurpose18", length = 159)
	@Size(max = 159)
	public String getG8xxup18bvxxxxxxxxxxgenpurpose18() {
		return this.g8xxup18bvxxxxxxxxxxgenpurpose18;
	}

	public void setG8xxup18bvxxxxxxxxxxgenpurpose18(
			String g8xxup18bvxxxxxxxxxxgenpurpose18) {
		this.g8xxup18bvxxxxxxxxxxgenpurpose18 = g8xxup18bvxxxxxxxxxxgenpurpose18;
	}

	@Column(name = "genvalue18", length = 159)
	@Size(max = 159)
	public String getG9xxuv18bvxxxxxxxxxxgenvalue18() {
		return this.g9xxuv18bvxxxxxxxxxxgenvalue18;
	}

	public void setG9xxuv18bvxxxxxxxxxxgenvalue18(
			String g9xxuv18bvxxxxxxxxxxgenvalue18) {
		this.g9xxuv18bvxxxxxxxxxxgenvalue18 = g9xxuv18bvxxxxxxxxxxgenvalue18;
	}

	@Column(name = "genoptions19", length = 159)
	@Size(max = 159)
	public String getH1xxuo19bvxxxxxxxxxxgenoptions19() {
		return this.h1xxuo19bvxxxxxxxxxxgenoptions19;
	}

	public void setH1xxuo19bvxxxxxxxxxxgenoptions19(
			String h1xxuo19bvxxxxxxxxxxgenoptions19) {
		this.h1xxuo19bvxxxxxxxxxxgenoptions19 = h1xxuo19bvxxxxxxxxxxgenoptions19;
	}

	@Column(name = "genpurpose19", length = 159)
	@Size(max = 159)
	public String getH2xxup19bvxxxxxxxxxxgenpurpose19() {
		return this.h2xxup19bvxxxxxxxxxxgenpurpose19;
	}

	public void setH2xxup19bvxxxxxxxxxxgenpurpose19(
			String h2xxup19bvxxxxxxxxxxgenpurpose19) {
		this.h2xxup19bvxxxxxxxxxxgenpurpose19 = h2xxup19bvxxxxxxxxxxgenpurpose19;
	}

	@Column(name = "genvalue19", length = 159)
	@Size(max = 159)
	public String getH3xxuv19bvxxxxxxxxxxgenvalue19() {
		return this.h3xxuv19bvxxxxxxxxxxgenvalue19;
	}

	public void setH3xxuv19bvxxxxxxxxxxgenvalue19(
			String h3xxuv19bvxxxxxxxxxxgenvalue19) {
		this.h3xxuv19bvxxxxxxxxxxgenvalue19 = h3xxuv19bvxxxxxxxxxxgenvalue19;
	}

	@Column(name = "genoptions20", length = 159)
	@Size(max = 159)
	public String getH4xxuo20bvxxxxxxxxxxgenoptions20() {
		return this.h4xxuo20bvxxxxxxxxxxgenoptions20;
	}

	public void setH4xxuo20bvxxxxxxxxxxgenoptions20(
			String h4xxuo20bvxxxxxxxxxxgenoptions20) {
		this.h4xxuo20bvxxxxxxxxxxgenoptions20 = h4xxuo20bvxxxxxxxxxxgenoptions20;
	}

	@Column(name = "genpurpose20", length = 159)
	@Size(max = 159)
	public String getH5xxup20bvxxxxxxxxxxgenpurpose20() {
		return this.h5xxup20bvxxxxxxxxxxgenpurpose20;
	}

	public void setH5xxup20bvxxxxxxxxxxgenpurpose20(
			String h5xxup20bvxxxxxxxxxxgenpurpose20) {
		this.h5xxup20bvxxxxxxxxxxgenpurpose20 = h5xxup20bvxxxxxxxxxxgenpurpose20;
	}

	@Column(name = "genvalue20", length = 159)
	@Size(max = 159)
	public String getH6xxuv20bvxxxxxxxxxxgenvalue20() {
		return this.h6xxuv20bvxxxxxxxxxxgenvalue20;
	}

	public void setH6xxuv20bvxxxxxxxxxxgenvalue20(
			String h6xxuv20bvxxxxxxxxxxgenvalue20) {
		this.h6xxuv20bvxxxxxxxxxxgenvalue20 = h6xxuv20bvxxxxxxxxxxgenvalue20;
	}

	@Column(name = "statusfl")
	public Integer getR7xxzzfxhhxxxxxxxxxxstatusfl() {
		return this.r7xxzzfxhhxxxxxxxxxxstatusfl;
	}

	public void setR7xxzzfxhhxxxxxxxxxxstatusfl(
			Integer r7xxzzfxhhxxxxxxxxxxstatusfl) {
		this.r7xxzzfxhhxxxxxxxxxxstatusfl = r7xxzzfxhhxxxxxxxxxxstatusfl;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "statusfldt", length = 29)
	public Date getR8xxcztxlxxxxxxxxxxxstatusfldt() {
		return this.r8xxcztxlxxxxxxxxxxxstatusfldt;
	}

	public void setR8xxcztxlxxxxxxxxxxxstatusfldt(
			Date r8xxcztxlxxxxxxxxxxxstatusfldt) {
		this.r8xxcztxlxxxxxxxxxxxstatusfldt = r8xxcztxlxxxxxxxxxxxstatusfldt;
	}

	@Column(name = "notes", length = 60)
	@Size(max = 60)
	public String getR9xxuxznbvxxxxxxxxxxnotes() {
		return this.r9xxuxznbvxxxxxxxxxxnotes;
	}

	public void setR9xxuxznbvxxxxxxxxxxnotes(String r9xxuxznbvxxxxxxxxxxnotes) {
		this.r9xxuxznbvxxxxxxxxxxnotes = r9xxuxznbvxxxxxxxxxxnotes;
	}

	@Column(name = "owner", length = 40)
	@Size(max = 40)
	public String getS1xxutoxlhxxxxxxxxxxowner() {
		return this.s1xxutoxlhxxxxxxxxxxowner;
	}

	public void setS1xxutoxlhxxxxxxxxxxowner(String s1xxutoxlhxxxxxxxxxxowner) {
		this.s1xxutoxlhxxxxxxxxxxowner = s1xxutoxlhxxxxxxxxxxowner;
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
