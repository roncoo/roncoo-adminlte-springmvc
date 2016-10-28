package com.roncoo.adminlte.service.impl.dao.impl.base;

import java.util.List;
import java.util.Map;

public interface CachedDao<K, V> {
	void init();

	void reload();

	V get(K k);

	Map<K, V> getMap();

	List<V> getList();

	// void clear();

	// void set(K k, V v);

	// void remove(K v);
}
