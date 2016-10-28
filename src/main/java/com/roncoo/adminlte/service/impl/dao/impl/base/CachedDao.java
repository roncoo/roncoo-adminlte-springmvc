package com.roncoo.adminlte.service.impl.dao.impl.base;

import java.util.List;
import java.util.Map;

/**
 * 
 * @author wujing
 * @param <K>
 * @param <V>
 */
public interface CachedDao<K, V> {
	void init();

	void reload();

	V get(K k);

	Map<K, V> getMap();

	List<V> getList();

}
