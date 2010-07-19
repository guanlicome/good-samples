package com.googlecode.goodsamples.springbatch;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "/batchContext.xml" })
public class SpringContextLoadingTest {
	@Test
	public void springContextShouldBeLoaded() {
	}
}