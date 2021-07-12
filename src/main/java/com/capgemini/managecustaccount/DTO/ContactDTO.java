package com.capgemini.managecustaccount.DTO;

public class ContactDTO {
		
		private String emailId;
		
		private String homePhone;
		
		private String workPhone;
		
		private String address1;
		private String address2;
		private String city;
		private String state;
		private String zip;
		private String country;

		public ContactDTO() {
			super();
		}
		
		public ContactDTO(String emailId, String homePhone, String workPhone, String address1, String address2,
				String city, String state, String zip, String country) {
			super();
			this.emailId = emailId;
			this.homePhone = homePhone;
			this.workPhone = workPhone;
			this.address1 = address1;
			this.address2 = address2;
			this.city = city;
			this.state = state;
			this.zip = zip;
			this.country = country;
		}

		@Override
		public String toString() {
			return "ContactDTO [emailId=" + emailId + ", homePhone=" + homePhone + ", workPhone=" + workPhone
					+ ", address1=" + address1 + ", address2=" + address2 + ", city=" + city + ", state=" + state
					+ ", zip=" + zip + ", country=" + country + "]";
		}
	
}
