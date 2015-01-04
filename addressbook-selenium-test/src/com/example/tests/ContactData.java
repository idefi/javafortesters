package com.example.tests;

import com.google.common.collect.ComparisonChain;

public class ContactData implements Comparable<ContactData> {
	public String firstname;
	public String lastname;
	public String address;
	public String home;
	public String mobile;
	public String work;
	public String email;
	public String email2;
	public String bday;
	public String bmonth;
	public String byear;
	public String new_group;
	public String address2;
	public String phone2;
	
public ContactData() {
	this.firstname = firstname;
	this.lastname = lastname;
	this.address = address;
	this.home = home;
	this.mobile = mobile;
	this.work = work;
	this.email = email;
	this.email2 = email2;
	this.bday = bday;
	this.bmonth = bmonth;
	this.byear = byear;
	this.new_group = new_group;
	this.address2 = address2;
	this.phone2 = phone2;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof ContactData)) return false;

		ContactData that = (ContactData) o;

		if (firstname != null ? !firstname.equals(that.firstname) : that.firstname != null) return false;
		if (lastname != null ? !lastname.equals(that.lastname) : that.lastname != null) return false;

		return true;
	}

	@Override
	public String toString() {
		return "ContactData{" +
				"firstname='" + firstname + '\'' +
				", lastname='" + lastname + '\'' +
				'}';
	}

	@Override
	public int hashCode() {
		int result = firstname != null ? firstname.hashCode() : 0;
		result = 31 * result + (lastname != null ? lastname.hashCode() : 0);
		return result;
	}

	@Override
	public int compareTo(ContactData other) {
		/*return ComparisonChain.start()
				.compare(firstname, other.firstname)
				.compare(lastname, other.lastname)
				.result();*/
		return this.lastname.toLowerCase().compareTo(other.lastname.toLowerCase());

	}


}