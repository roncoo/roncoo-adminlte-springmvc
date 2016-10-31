/*
 * Copyright 2015-2016 RonCoo(http://www.roncoo.com) Group.
 *  
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *  
 *      http://www.apache.org/licenses/LICENSE-2.0
 *  
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.roncoo.adminlte.util.cache;

import java.util.List;
import java.util.concurrent.ConcurrentMap;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.roncoo.adminlte.bean.entity.RcEmailAccountInfo;
import com.roncoo.adminlte.bean.entity.RcEmailAccountInfoExample;
import com.roncoo.adminlte.service.impl.dao.impl.base.imple.CachedDaoImpl;
import com.roncoo.adminlte.service.impl.dao.impl.mybatis.RcEmailAccountInfoMapper;

@Component
public class EmailAccountInfoCache extends CachedDaoImpl<String, RcEmailAccountInfo> {

	@Autowired
	private RcEmailAccountInfoMapper mapper;

	private final static Long  INITIALDELAY = 300L;
	private final static Long  PERIOD = 300L;
	
	@PostConstruct
	@Override
	public void init() {
		super.init(INITIALDELAY, PERIOD);
	}

	@Override
	public void reloadFromDb(ConcurrentMap<String, RcEmailAccountInfo> cached) {
		RcEmailAccountInfoExample example = new RcEmailAccountInfoExample();
		example.setOrderByClause("create_time desc");
		List<RcEmailAccountInfo> infoList = mapper.selectByExample(example);
		for (int i = 0; i < infoList.size(); i++) {
			String key = Integer.toString(i);
			cached.putIfAbsent(key, infoList.get(i));
		}
	}

}
