package com.xyz.pizza.utils;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class PizzaUtilTest {

	@Test
	public void testConvertEpochToUTC() throws Exception {
		Assert.assertNotNull(PizzaUtil.convertEpochToUTC(Long.valueOf(1474295087)));
	}

	/**
	 * @throws Exception
	 */
	@Test
	public void testConvertEpochToUTC_Null() throws Exception {
		Assert.assertNull(PizzaUtil.convertEpochToUTC(null));
	}
	
}
