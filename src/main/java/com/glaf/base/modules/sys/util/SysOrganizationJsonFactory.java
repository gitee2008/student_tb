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

package com.glaf.base.modules.sys.util;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.glaf.base.modules.sys.model.SysOrganization;
import com.glaf.core.util.DateUtils;

public class SysOrganizationJsonFactory {

	public static java.util.List<SysOrganization> arrayToList(JSONArray array) {
		java.util.List<SysOrganization> list = new java.util.ArrayList<SysOrganization>();
		for (int i = 0; i < array.size(); i++) {
			JSONObject jsonObject = array.getJSONObject(i);
			SysOrganization model = jsonToObject(jsonObject);
			list.add(model);
		}
		return list;
	}

	public static SysOrganization jsonToObject(JSONObject jsonObject) {
		SysOrganization model = new SysOrganization();
		if (jsonObject.containsKey("id")) {
			model.setId(jsonObject.getLong("id"));
		}
		if (jsonObject.containsKey("parentId")) {
			model.setParentId(jsonObject.getLong("parentId"));
		}
		if (jsonObject.containsKey("tenantId")) {
			model.setTenantId(jsonObject.getString("tenantId"));
		}
		if (jsonObject.containsKey("name")) {
			model.setName(jsonObject.getString("name"));
		}
		if (jsonObject.containsKey("namePinyin")) {
			model.setNamePinyin(jsonObject.getString("namePinyin"));
		}
		if (jsonObject.containsKey("description")) {
			model.setDescription(jsonObject.getString("description"));
		}
		if (jsonObject.containsKey("createTime")) {
			model.setCreateTime(jsonObject.getDate("createTime"));
		}
		if (jsonObject.containsKey("createBy")) {
			model.setCreateBy(jsonObject.getString("createBy"));
		}
		if (jsonObject.containsKey("updateBy")) {
			model.setUpdateBy(jsonObject.getString("updateBy"));
		}
		if (jsonObject.containsKey("updateDate")) {
			model.setUpdateDate(jsonObject.getDate("updateDate"));
		}
		if (jsonObject.containsKey("sort")) {
			model.setSort(jsonObject.getInteger("sort"));
		}
		if (jsonObject.containsKey("no")) {
			model.setNo(jsonObject.getString("no"));
		}
		if (jsonObject.containsKey("code")) {
			model.setCode(jsonObject.getString("code"));
		}
		if (jsonObject.containsKey("code2")) {
			model.setCode2(jsonObject.getString("code2"));
		}
		if (jsonObject.containsKey("locked")) {
			model.setLocked(jsonObject.getInteger("locked"));
		}
		if (jsonObject.containsKey("fincode")) {
			model.setFincode(jsonObject.getString("fincode"));
		}
		if (jsonObject.containsKey("address")) {
			model.setAddress(jsonObject.getString("address"));
		}
		if (jsonObject.containsKey("telphone")) {
			model.setTelphone(jsonObject.getString("telphone"));
		}
		if (jsonObject.containsKey("principal")) {
			model.setPrincipal(jsonObject.getString("principal"));
		}
		if (jsonObject.containsKey("type")) {
			model.setType(jsonObject.getString("type"));
		}
		if (jsonObject.containsKey("url")) {
			model.setUrl(jsonObject.getString("url"));
		}
		if (jsonObject.containsKey("level")) {
			model.setLevel(jsonObject.getInteger("level"));
		}

		if (jsonObject.containsKey("parent")) {
			JSONObject parentJson = jsonObject.getJSONObject("parent");
			SysOrganization parent = jsonToObject(parentJson);
			model.setParent(parent);
		}

		return model;
	}

	public static JSONArray listToArray(java.util.List<SysOrganization> list) {
		JSONArray array = new JSONArray();
		if (list != null && !list.isEmpty()) {
			for (SysOrganization model : list) {
				JSONObject jsonObject = model.toJsonObject();
				array.add(jsonObject);
			}
		}
		return array;
	}

	public static JSONObject toJsonObject(SysOrganization model) {
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("id", model.getId());
		jsonObject.put("_id_", model.getId());
		jsonObject.put("_oid_", model.getId());
		jsonObject.put("organizationId", model.getId());
		jsonObject.put("parentId", model.getParentId());

		if (model.getTenantId() != null) {
			jsonObject.put("tenantId", model.getTenantId());
		}

		if (model.getName() != null) {
			jsonObject.put("name", model.getName());
		}
		if (model.getNamePinyin() != null) {
			jsonObject.put("namePinyin", model.getNamePinyin());
		}
		if (model.getDescription() != null) {
			jsonObject.put("description", model.getDescription());
		}
		if (model.getCreateTime() != null) {
			jsonObject.put("createTime", DateUtils.getDate(model.getCreateTime()));
			jsonObject.put("createTime_date", DateUtils.getDate(model.getCreateTime()));
			jsonObject.put("createTime_datetime", DateUtils.getDateTime(model.getCreateTime()));
		}
		if (model.getCreateBy() != null) {
			jsonObject.put("createBy", model.getCreateBy());
		}
		if (model.getUpdateBy() != null) {
			jsonObject.put("updateBy", model.getUpdateBy());
		}
		if (model.getUpdateDate() != null) {
			jsonObject.put("updateDate", DateUtils.getDate(model.getUpdateDate()));
			jsonObject.put("updateDate_date", DateUtils.getDate(model.getUpdateDate()));
			jsonObject.put("updateDate_datetime", DateUtils.getDateTime(model.getUpdateDate()));
		}
		jsonObject.put("sort", model.getSort());
		if (model.getNo() != null) {
			jsonObject.put("no", model.getNo());
		}
		if (model.getCode() != null) {
			jsonObject.put("code", model.getCode());
		}
		if (model.getCode2() != null) {
			jsonObject.put("code2", model.getCode2());
		}
		jsonObject.put("locked", model.getLocked());
		if (model.getFincode() != null) {
			jsonObject.put("fincode", model.getFincode());
		}
		if (model.getAddress() != null) {
			jsonObject.put("address", model.getAddress());
		}
		if (model.getTelphone() != null) {
			jsonObject.put("telphone", model.getTelphone());
		}
		if (model.getPrincipal() != null) {
			jsonObject.put("principal", model.getPrincipal());
		}
		if (model.getType() != null) {
			jsonObject.put("type", model.getType());
		}
		if (model.getUrl() != null) {
			jsonObject.put("url", model.getUrl());
		}

		jsonObject.put("level", model.getLevel());

		if (model.getParent() != null) {
			if (model.getParent() instanceof SysOrganization) {
				JSONObject parent = toJsonObject((SysOrganization) model.getParent());
				jsonObject.put("parent", parent);
			}
		}

		return jsonObject;
	}

	public static ObjectNode toObjectNode(SysOrganization model) {
		ObjectNode jsonObject = new ObjectMapper().createObjectNode();
		jsonObject.put("id", model.getId());
		jsonObject.put("_id_", model.getId());
		jsonObject.put("_oid_", model.getId());
		jsonObject.put("organizationId", model.getId());
		jsonObject.put("parentId", model.getParentId());

		if (model.getTenantId() != null) {
			jsonObject.put("tenantId", model.getTenantId());
		}

		if (model.getName() != null) {
			jsonObject.put("name", model.getName());
		}
		if (model.getNamePinyin() != null) {
			jsonObject.put("namePinyin", model.getNamePinyin());
		}
		if (model.getDescription() != null) {
			jsonObject.put("description", model.getDescription());
		}
		if (model.getCreateTime() != null) {
			jsonObject.put("createTime", DateUtils.getDate(model.getCreateTime()));
			jsonObject.put("createTime_date", DateUtils.getDate(model.getCreateTime()));
			jsonObject.put("createTime_datetime", DateUtils.getDateTime(model.getCreateTime()));
		}
		if (model.getCreateBy() != null) {
			jsonObject.put("createBy", model.getCreateBy());
		}
		if (model.getUpdateBy() != null) {
			jsonObject.put("updateBy", model.getUpdateBy());
		}
		if (model.getUpdateDate() != null) {
			jsonObject.put("updateDate", DateUtils.getDate(model.getUpdateDate()));
			jsonObject.put("updateDate_date", DateUtils.getDate(model.getUpdateDate()));
			jsonObject.put("updateDate_datetime", DateUtils.getDateTime(model.getUpdateDate()));
		}
		jsonObject.put("sort", model.getSort());
		if (model.getNo() != null) {
			jsonObject.put("no", model.getNo());
		}
		if (model.getCode() != null) {
			jsonObject.put("code", model.getCode());
		}
		if (model.getCode2() != null) {
			jsonObject.put("code2", model.getCode2());
		}
		jsonObject.put("locked", model.getLocked());
		if (model.getFincode() != null) {
			jsonObject.put("fincode", model.getFincode());
		}
		if (model.getAddress() != null) {
			jsonObject.put("address", model.getAddress());
		}
		if (model.getTelphone() != null) {
			jsonObject.put("telphone", model.getTelphone());
		}
		if (model.getPrincipal() != null) {
			jsonObject.put("principal", model.getPrincipal());
		}
		if (model.getType() != null) {
			jsonObject.put("type", model.getType());
		}
		if (model.getUrl() != null) {
			jsonObject.put("url", model.getUrl());
		}
		jsonObject.put("level", model.getLevel());

		if (model.getParent() != null) {
			if (model.getParent() instanceof SysOrganization) {
				ObjectNode parent = toObjectNode((SysOrganization) model.getParent());
				jsonObject.set("parent", parent);
			}
		}

		return jsonObject;
	}

	private SysOrganizationJsonFactory() {

	}

}
