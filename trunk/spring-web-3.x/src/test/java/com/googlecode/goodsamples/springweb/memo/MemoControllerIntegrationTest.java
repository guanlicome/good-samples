package com.googlecode.goodsamples.springweb.memo;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.servlet.ModelAndView;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:META-INF/spring/applicationContext.xml", "classpath:META-INF/spring/sample-servlet.xml"})
@Transactional
public class MemoControllerIntegrationTest {
	@Autowired
	private MemoController sut;

	@Test
	public void ��������_��������_���յǾ���Ѵ�() {
		ModelAndView result = sut.memolist(1);

		assertThat(result, is(notNullValue()));
	}
}
