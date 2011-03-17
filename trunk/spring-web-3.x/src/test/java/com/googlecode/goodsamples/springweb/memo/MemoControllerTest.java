package com.googlecode.goodsamples.springweb.memo;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.springframework.web.servlet.ModelAndView;

public class MemoControllerTest {
	private MemoService mockMemoService = mock(MemoService.class);
	private MemoController sut = new MemoController(mockMemoService);

	@Test
	public void �޸�_View��_�����ؾ��Ѵ�() {
		int page = 1;
		List<String> expectedMemos = new ArrayList<String>();
		expectedMemos.add("someMemo#1");
		expectedMemos.add("someMemo#2");
		when(mockMemoService.findBy(page)).thenReturn(expectedMemos);

		ModelAndView result = sut.memolist(page);

		@SuppressWarnings("unchecked") List<String> memos = (List<String>)result.getModel().get("memos");
		assertThat(memos, is(notNullValue()));
		assertThat(memos, is(expectedMemos));
	}

	@Test(expected = IllegalArgumentException.class)
	public void ��������_1����_�����ؾ��Ѵ�() {
		int invalidPage = 0;
		sut.memolist(invalidPage);
	}
}
