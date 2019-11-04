package ml.kerotori.app.infrastructure.dao;

import static org.junit.jupiter.api.Assertions.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.jupiter.api.Test;

import ml.kerotori.app.domain.Address;

class AddressDaoTest {

	@Test
	void SaveTest1() {
		Address address = new Address();
		address.setNo(1);
		address.setName("佐藤 一郎");
		address.setAddress1("北海道");
		address.setAddress2("札幌市");
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
		Date date = null;
		try {
			date = sdf.parse("1990/10/11");
		} catch (ParseException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
		address.setBirthday(date);
		AddressDao dao = new AddressDao();
		dao.setAddress(address);
		assertTrue(dao.Save());


	}

	@Test
	void LoadTest1() {
		Address address = AddressDao.Load(1);
		assertEquals("佐藤 一郎", address.getName());

	}
}
