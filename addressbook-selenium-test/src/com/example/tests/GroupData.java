package com.example.tests;

public class GroupData implements Comparable<GroupData>{
	public String name;
	public String header;
	public String footer;

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
}