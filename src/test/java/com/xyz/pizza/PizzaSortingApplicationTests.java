package com.xyz.pizza;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


@RunWith(SpringRunner.class)
@SpringBootTest
public class PizzaSortingApplicationTests {

	@Before
	public void initMocks() {
		MockitoAnnotations.initMocks(this);
	}
	
	@Test
	public void contextLoads() {
	}
	
	@Test
	public void testMain() {
		String[] arg = new String[] { "PizzaSortingApplication", "sampleOrders.txt", "outputFile.txt" };
		PizzaSortingApplication.main(arg);
		Assert.assertTrue(true);
	}
	

}

