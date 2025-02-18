package com.practice.ManyToMany.pojo;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;

	@Entity
	public class Laptop {
		
		@Id
		private int Laptop_Id ;
		@Column
		private String Laptop_Name ;
		
		@ManyToMany
		@Column
		private List<Student> student = new ArrayList<>();

		public int getlId() {
			return Laptop_Id;
		}

		public void setlId(int lId) {
			this.Laptop_Id = lId;
		}

		public String getlName() {
			return Laptop_Name;
		}

		public void setlName(String lName) {
			this.Laptop_Name = lName;
		}

		public List<Student> getStudent() {
			return student;
		}

		public void setStudent(List<Student> student) {
			this.student = student;
		}

		@Override
		public String toString() {
			return "Laptop [lId=" + Laptop_Id + ", lName=" + Laptop_Name + ", student=" + student + "]";
		}
		
	}
