package com.example.tests;

public class GroupData implements Comparable<GroupData>{
	private String name;
	private String header;
	private String footer;

	public GroupData() {
	}
	
	public GroupData(String name, String header, String footer) {
		this.name = name;
		this.header = header;
		this.footer = footer;
	}

	@Override
	public int hashCode() {
		int name = 1;
		//return name != null ? name.hashCode() : 0;
		return name;
	}


	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		GroupData groupData = (GroupData) o;

		if (name != null ? !name.equals(groupData.name) : groupData.name != null) return false;

		return true;
	}

	@Override
	public String toString() {
		return "GroupData{" +
				"name='" + name + '\'' +
				", header='" + header + '\'' +
				", footer='" + footer + '\'' +
				'}';
	}

	@Override
	public int compareTo(GroupData other) {
		return this.name.toLowerCase().compareTo(other.name.toLowerCase());
	}

	public GroupData withName(String name) {
		this.name=name;
		return this;
	}

	public GroupData withHeader(String header) {
		this.header=header;
		return this;
	}

	public GroupData withFooter(String footer) {
		this.footer=footer;
		return this;
	}

	public String getFooter() {
		return footer;
	}

	public String getHeader() {
		return header;
	}

	public String getName() {
		return name;
	}
}