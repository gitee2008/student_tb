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

package com.glaf.ueditor.define;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import com.glaf.ueditor.Encoder;

public class BaseState implements State {

	private boolean state = false;
	private String info = null;
	
	private Map<String, String> infoMap = new HashMap<String, String>();
	
	public BaseState () {
		this.state = true;
	}
	
	public BaseState ( boolean state ) {
		this.setState( state );
	}
	
	public BaseState ( boolean state, String info ) {
		this.setState( state );
		this.info = info;
	}
	
	public BaseState ( boolean state, int infoCode ) {
		this.setState( state );
		this.info = AppInfo.getStateInfo( infoCode );
	}
	
	public boolean isSuccess () {
		return this.state;
	}
	
	public void setState ( boolean state ) {
		this.state = state;
	}
	
	public void setInfo ( String info ) {
		this.info = info;
	}
	
	public void setInfo ( int infoCode ) {
		this.info = AppInfo.getStateInfo( infoCode );
	}
	
	@Override
	public String toJSONString() {
		return this.toString();
	}
	
	public String toString () {
		
		String key = null;
		String stateVal = this.isSuccess() ? AppInfo.getStateInfo( AppInfo.SUCCESS ) : this.info;
		
		StringBuilder builder = new StringBuilder();
		
		builder.append( "{\"state\": \"" + stateVal + "\"" );
		
		Iterator<String> iterator = this.infoMap.keySet().iterator();
		
		while ( iterator.hasNext() ) {
			
			key = iterator.next();
			
			builder.append( ",\"" + key + "\": \"" + this.infoMap.get(key) + "\"" );
			
		}
		
		builder.append( "}" );

		return Encoder.toUnicode( builder.toString() );

	}

	@Override
	public void putInfo(String name, String val) {
		this.infoMap.put(name, val);
	}

	@Override
	public void putInfo(String name, long val) {
		this.putInfo(name, val+"");
	}

}
