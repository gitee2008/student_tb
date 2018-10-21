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

package com.glaf.base.district.service;

import java.util.*;

import org.springframework.transaction.annotation.Transactional;

import com.glaf.core.base.TreeModel;
import com.glaf.core.query.TreeModelQuery;
import com.glaf.base.district.domain.*;
import com.glaf.base.district.query.*;

@Transactional(readOnly = true)
public interface DistrictService {

	void deleteById(long id);

	/**
	 * 根据主键获取一条记录
	 * 
	 * @return
	 */
	District getDistrict(long id);

	/**
	 * 根据编码获取一条记录
	 * 
	 * @return
	 */
	District getDistrictByCode(String code);

	/**
	 * 根据名称获取一条记录
	 * 
	 * @return
	 */
	District getDistrictByName(String name);

	/**
	 * 根据查询参数获取记录总数
	 * 
	 * @return
	 */
	int getDistrictCountByQueryCriteria(DistrictQuery query);

	List<District> getDistrictList(long parentId);

	/**
	 * 根据查询参数获取一页的数据
	 * 
	 * @return
	 */
	List<District> getDistrictsByQueryCriteria(int start, int pageSize, DistrictQuery query);

	int getDistrictTreeModelCount(TreeModelQuery query);

	List<TreeModel> getDistrictTreeModels(TreeModelQuery query);

	/**
	 * 根据查询参数获取记录列表
	 * 
	 * @return
	 */
	List<District> list(DistrictQuery query);

	/**
	 * 保存一条记录
	 * 
	 * @return
	 */
	@Transactional
	void save(District district);

}