package ml.kerotori.app.domain;

import java.io.Serializable;
import java.util.Date;

public class Address implements Serializable {

	private int no;			// 管理用番号
	private String Name;		// 名前
	private String Address1;	// 住所1
	private String Address2;	// 住所2
	private Date Birthday;		// 誕生日


	public Address() {

	}
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public String getAddress1() {
		return Address1;
	}
	public void setAddress1(String address1) {
		Address1 = address1;
	}
	public String getAddress2() {
		return Address2;
	}
	public void setAddress2(String address2) {
		Address2 = address2;
	}
	public Date getBirthday() {
		return Birthday;
	}
	public void setBirthday(Date birthday) {
		Birthday = birthday;
	}

}
