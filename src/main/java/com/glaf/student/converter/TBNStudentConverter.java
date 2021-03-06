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

package com.glaf.student.converter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import com.glaf.core.util.DateUtils;
import com.glaf.core.util.ExcelUtils;
import com.glaf.core.util.StringTools;

import com.glaf.student.domain.Person;

public class TBNStudentConverter {
	protected final static Log logger = LogFactory.getLog(TBNStudentConverter.class);

	public List<Person> getPersons(java.io.InputStream inputStream) {
		logger.debug("----------------TBNStudentConverter------------------");
		HSSFWorkbook wb = null;
		try {
			wb = new HSSFWorkbook(inputStream);
		} catch (Exception ex) {
			throw new RuntimeException(ex);
		} finally {
			if (wb != null) {
				try {
					wb.close();
				} catch (IOException e) {
				}
			}
		}
		HSSFSheet sheet = wb.getSheetAt(0);
		List<Person> persons = new ArrayList<Person>();
		int rows = sheet.getLastRowNum();
		logger.debug("row num:" + rows);
		for (int rowIndex = 2; rowIndex <= rows; rowIndex++) {// 第三行开始取数
			HSSFRow row = sheet.getRow(rowIndex);
			if (row == null) {
				continue;
			}
			Person person = new Person();
			HSSFCell cell = null;
			String cellValue = null;
			int cells = row.getLastCellNum();
			for (int colIndex = 0; colIndex < cells; colIndex++) {
				cell = row.getCell(colIndex);
				if (cell != null) {
					cellValue = ExcelUtils.getStringOrDateValue(cell, 0);
					if (cellValue == null) {
						cellValue = "";
					}
					cellValue = cellValue.trim();
					switch (colIndex) {
					case 0:// 班级
						person.setGradeName(cellValue);
						break;
					case 1:// 姓名
						person.setName(cellValue);
						break;
					case 2:// 档案号
						person.setStudentCode(cellValue);
						break;
					case 3:// 性别
						if (StringUtils.contains(cellValue, "男")) {
							person.setSex("男");
						}
						if (StringUtils.contains(cellValue, "女")) {
							person.setSex("女");
						}
						break;
					case 4:// 出生日期
						cellValue = StringTools.replace(cellValue, ".", "-");
						cellValue = StringTools.replace(cellValue, "/", "-");
						try {
							person.setBirthday(DateUtils.toDate(cellValue));
						} catch (Throwable ex) {

						}
						break;
					case 5: // 民族
						person.setNation(cellValue);
						break;
					case 7:// 入园日期
						cellValue = StringTools.replace(cellValue, ".", "-");
						cellValue = StringTools.replace(cellValue, "/", "-");
						try {
							person.setJoinDate(DateUtils.toDate(cellValue));
						} catch (Throwable ex) {
						}
						break;
					case 9:// 家庭住址
						person.setHomeAddress(cellValue);
						break;
					case 10:// 联系电话
						person.setTelephone(cellValue);
						break;
					case 12:// 身份证号码
						person.setIdCardNo(cellValue);
						break;
					case 15:// 过敏史
						person.setAllergy(cellValue);
						break;
					case 16:// 疾病史,既往史
						person.setPreviousHistory(cellValue);
						break;

					default:
						break;
					}
				}
			}
			if (StringUtils.isNotEmpty(person.getName()) && person.getBirthday() != null) {
				persons.add(person);
			}
		}
		return persons;
	}

}
