package com.ppaluch.integracje.integracje;

import com.ppaluch.integracje.integracje.dto.LaptopGuiDto;
import com.ppaluch.integracje.integracje.xml.XmlHelper;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;


@SpringBootTest
class IntegracjeApplicationTests {

	@Test
	public void shouldReadFromXml(){
		XmlHelper xmlHelper = new XmlHelper();
		List<LaptopGuiDto> laptops = xmlHelper.readLaptops("test.xml");

		assertEquals(laptops.size(), 1);
		assertEquals(laptops.get(0).getOperatingSystem(),"Windows 7 Home");
		assertEquals(laptops.get(0).getIsScreenTouch(),"tak");
		assertEquals(laptops.get(0).getDiskType(),"SSD");
	}




}
