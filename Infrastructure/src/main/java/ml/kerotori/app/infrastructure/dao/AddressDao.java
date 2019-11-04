package ml.kerotori.app.infrastructure.dao;

import java.io.Serializable;

import ml.kerotori.app.domain.Address;
import ml.kerotori.app.infrastructure.core.Load;
import ml.kerotori.app.infrastructure.core.Save;

public class AddressDao implements Serializable,Save<Address>, Load<Address> {

	private Address address;

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public static Address Load(int no) {
		return Load.loadXml(no + ".xml");
	}

	public boolean Save() {
		return Save.saveXml(this.address.getNo() + ".xml", address);
	}
}
