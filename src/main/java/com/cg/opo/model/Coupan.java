package com.cg.opo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="coupan")
public class Coupan {

	@Id
	@Column(name="coupan_id",length=10)
	private int coupanId;
	@Column(name="coupan_name",length=20)
	private String coupanName;
	@Column(name="coupan_type",length=20)
	private String coupanType;
	@Column(name="coupan_description",length=80)
	private String coupanDescription;
	
		public Coupan() {
		
	}

		public Coupan(int coupanId, String coupanName, String coupanType, String coupanDescription) {
			super();
			this.coupanId = coupanId;
			this.coupanName = coupanName;
			this.coupanType = coupanType;
			this.coupanDescription = coupanDescription;
		}


		public int getCoupanId() {
			return coupanId;
		}

		public void setCoupanId(int coupanId) {
			this.coupanId = coupanId;
		}

		public String getCoupanName() {
			return coupanName;
		}

		public void setCoupanName(String coupanName) {
			this.coupanName = coupanName;
		}

		public String getCoupanType() {
			return coupanType;
		}

		public void setCoupanType(String coupanType) {
			this.coupanType = coupanType;
		}

		public String getCoupanDescription() {
			return coupanDescription;
		}

		public void setCoupanDescription(String coupanDescription) {
			this.coupanDescription = coupanDescription;
		}


		@Override
		public String toString() {
			return "Coupan [coupanId=" + coupanId + ", coupanName=" + coupanName + ", coupanType=" + coupanType
					+ ", coupanDescription=" + coupanDescription + "]";
		}


}