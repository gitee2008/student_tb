/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.glaf.base.modules.sys.service;

import java.util.*;
import org.springframework.transaction.annotation.Transactional;

import com.glaf.base.modules.sys.model.*;
import com.glaf.base.modules.sys.query.*;

@Transactional(readOnly = true)
public interface SysTenantService {

	/**
	 * 根据主键删除记录
	 * 
	 * @return
	 */
	@Transactional
	void deleteById(long id);

	/**
	 * 根据主键删除多条记录
	 * 
	 * @return
	 */
	@Transactional
	void deleteByIds(List<Long> ids);

	/**
	 * 根据主键获取一条记录
	 * 
	 * @return
	 */
	SysTenant getSysTenant(long id);

	/**
	 * 根据name获取一条记录
	 * 
	 * @return
	 */
	SysTenant getSysTenantByName(String name);
	
	/**
	 * 根据主键获取一条记录
	 * 
	 * @return
	 */
	SysTenant getSysTenantByTenantId(String tenantId);

	/**
	 * 根据查询参数获取记录总数
	 * 
	 * @return
	 */
	int getSysTenantCountByQueryCriteria(SysTenantQuery query);

	/**
	 * 根据查询参数获取一页的数据
	 * 
	 * @return
	 */
	List<SysTenant> getSysTenantsByQueryCriteria(int start, int pageSize, SysTenantQuery query);

	/**
	 * 根据查询参数获取记录列表
	 * 
	 * @return
	 */
	List<SysTenant> list(SysTenantQuery query);

	@Transactional
	void register(SysTenant sysTenant, SysUser user);

	/**
	 * 保存一条记录
	 * 
	 * @return
	 */
	@Transactional
	void save(SysTenant tenant);

}
