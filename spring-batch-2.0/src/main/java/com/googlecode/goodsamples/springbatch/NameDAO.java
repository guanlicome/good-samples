package com.googlecode.goodsamples.springbatch;

import java.util.LinkedList;

//TODO Cursor ��� ���� �߰� �ʿ�
public interface NameDAO {
	Name insert(Name name);

	Name select(Name name);

	Name update(Name toBeUpdated);

	LinkedList<Name> selectAll();
}
