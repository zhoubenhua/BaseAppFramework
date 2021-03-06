/**
 * Copyright (c) 2012-2013, Michael Yang 杨福海 (www.yangfuhai.com).
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
package com.eyunhome.baseappframework.db.sqlite;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import android.text.TextUtils;

import com.eyunhome.baseappframework.common.CommonUtil;
import com.eyunhome.baseappframework.db.table.Id;
import com.eyunhome.baseappframework.db.table.KeyValue;
import com.eyunhome.baseappframework.db.table.Property;
import com.eyunhome.baseappframework.db.table.TableInfo;
import com.eyunhome.baseappframework.exception.DbException;

/**
 * 拼接sql语句
 */
public class SqlBuilder {

	/**
	 * 获取插入的sql语句
	 * @return
	 */
	public static SqlInfo buildInsertSql(Object entity){

		List<KeyValue> keyValueList = getSaveKeyValueListByEntity(entity);

		StringBuffer strSQL=new StringBuffer();
		SqlInfo sqlInfo = null;
		if(keyValueList!=null && keyValueList.size()>0){

			sqlInfo = new SqlInfo();

			strSQL.append("INSERT INTO ");
			strSQL.append(TableInfo.get(entity.getClass()).getTableName());
			strSQL.append(" (");
			for(KeyValue kv : keyValueList){
				strSQL.append(kv.getKey()).append(",");
				sqlInfo.addValue(kv.getValue());
			}
			strSQL.deleteCharAt(strSQL.length() - 1);
			strSQL.append(") VALUES ( ");

			int length = keyValueList.size();
			for(int i =0 ; i < length;i++){
				strSQL.append("?,");
			}
			strSQL.deleteCharAt(strSQL.length() - 1);
			strSQL.append(")");

			sqlInfo.setSql(strSQL.toString());
		}

		return sqlInfo;
	}

	public static List<KeyValue> getSaveKeyValueListByEntity(Object entity){

		List<KeyValue> keyValueList = new ArrayList<KeyValue>();

		TableInfo table=TableInfo.get(entity.getClass());
		Object idvalue = table.getId().getValue(entity);

		if(!(idvalue instanceof Integer)){ //用了非自增长,添加id , 采用自增长就不需要添加id了
			if(idvalue instanceof String && idvalue != null){
				KeyValue kv = new KeyValue(table.getId().getColumn(),idvalue);
				keyValueList.add(kv);
			}
		}

		//添加属性
		Collection<Property> propertys = table.propertyMap.values();
		for(Property property : propertys){
			KeyValue kv = property2KeyValue(property, entity) ;
			if(kv!=null)
				keyValueList.add(kv);
		}

		return keyValueList;
	}


	private static String getDeleteSqlBytableName(String tableName){
		return "DELETE FROM "+ tableName;
	}


	public static SqlInfo buildDeleteSql(Object entity){
		TableInfo table=TableInfo.get(entity.getClass());

		Id id = table.getId();
		Object idvalue = id.getValue(entity);

		if(idvalue == null ){
			throw new DbException("getDeleteSQL:"+entity.getClass()+" id value is null");
		}
		StringBuffer strSQL = new StringBuffer(getDeleteSqlBytableName(table.getTableName()));
		strSQL.append(" WHERE ").append(id.getColumn()).append("=?");

		SqlInfo sqlInfo = new SqlInfo();
		sqlInfo.setSql(strSQL.toString());
		sqlInfo.addValue(idvalue);

		return sqlInfo;
	}

	/**
	 * 根据条件map 封装删除sql语句
	 * @param clazz
	 * @param map 条件map
	 * @return
	 */
	public static SqlInfo buildDeleteSqlByMap(Class<?> clazz , Map<String,String> map){
		TableInfo table=TableInfo.get(clazz);
		StringBuffer strSQL = new StringBuffer(getDeleteSqlBytableName(table.getTableName()));
		strSQL.append(" WHERE ");
		Iterator iterator = map.entrySet().iterator();
		int index = 0;
		SqlInfo sqlInfo = new SqlInfo();
		while(iterator.hasNext()) {
			Map.Entry<String,String> entry = (Map.Entry<String, String>) iterator.next();
			if(!CommonUtil.isEmpty(entry.getKey())) {
				strSQL.append(entry.getKey()).append(" =? ");
				sqlInfo.addValue(entry.getValue());
				if(index != map.size()-1) {
					strSQL.append(" and ");
				}
				index  = index +1;
			}
		}
		sqlInfo.setSql(strSQL.toString());
		return sqlInfo;
	}

	public static SqlInfo buildDeleteSql(Class<?> clazz , Object idValue){
		TableInfo table=TableInfo.get(clazz);
		Id id=table.getId();

		if(null == idValue) {
			throw new DbException("getDeleteSQL:idValue is null");
		}

		StringBuffer strSQL = new StringBuffer(getDeleteSqlBytableName(table.getTableName()));
		strSQL.append(" WHERE ").append(id.getColumn()).append("=?");

		SqlInfo sqlInfo = new SqlInfo();
		sqlInfo.setSql(strSQL.toString());
		sqlInfo.addValue(idValue);

		return sqlInfo;
	}

	/**
	 * 根据条件删除数据 ，条件为空的时候将会删除所有的数据
	 * @param clazz
	 * @param strWhere
	 * @return
	 */
	public static String buildDeleteSql(Class<?> clazz , String strWhere){
		TableInfo table=TableInfo.get(clazz);
		StringBuffer strSQL = new StringBuffer(getDeleteSqlBytableName(table.getTableName()));

		if(!TextUtils.isEmpty(strWhere)){
			strSQL.append(" WHERE ");
			strSQL.append(strWhere);
		}

		return strSQL.toString();
	}


	////////////////////////////select sql start///////////////////////////////////////


	private static String getSelectSqlByTableName(String tableName){
		return new StringBuffer("SELECT * FROM ").append(tableName).toString();
	}


	public static String getSelectSQL(Class<?> clazz,Object idValue){
		TableInfo table=TableInfo.get(clazz);

		StringBuffer strSQL = new StringBuffer(getSelectSqlByTableName(table.getTableName()));
		strSQL.append(" WHERE ");
		strSQL.append(getPropertyStrSql(table.getId().getColumn(), idValue));

		return strSQL.toString();
	}

	public static SqlInfo getSelectSqlAsSqlInfo(Class<?> clazz,Object idValue){
		TableInfo table=TableInfo.get(clazz);

		StringBuffer strSQL = new StringBuffer(getSelectSqlByTableName(table.getTableName()));
		strSQL.append(" WHERE ").append(table.getId().getColumn()).append("=?");

		SqlInfo sqlInfo = new SqlInfo();
		sqlInfo.setSql(strSQL.toString());
		sqlInfo.addValue(idValue);

		return sqlInfo;
	}


	public static String getSelectSQL(Class<?> clazz){
		return getSelectSqlByTableName(TableInfo.get(clazz).getTableName());
	}

	/**
	 * 获取搜索条件sql
	 * @param clazz
	 * @param map
	 * @return
	 */
	public static SqlInfo getSelectSqlInfo(Class<?> clazz,Map<String,String> map){
		TableInfo table=TableInfo.get(clazz);
		StringBuffer strSQL = new StringBuffer(getSelectSqlByTableName(table.getTableName()));
		strSQL.append(" WHERE ");
		Iterator iterator = map.entrySet().iterator();
		String[] values = new String[map.size()];
		int index = 0;
		while(iterator.hasNext()) {
			Map.Entry<String,String> entry = (Map.Entry<String, String>) iterator.next();
			if(!CommonUtil.isEmpty(entry.getKey())) {
				strSQL.append(entry.getKey()).append(" =? ");
				values[index] = entry.getValue();
				if(index != map.size()-1) {
					strSQL.append(" and ");
				}
				index  = index +1;
			}
		}
		SqlInfo sqlInfo = new SqlInfo();
		sqlInfo.setSql(strSQL.toString());
		sqlInfo.addWhere(values);
		return sqlInfo;
	}

	/**
	 * 获取模糊搜索条件sql
	 * @param clazz
	 * @param map
	 * @return
	 */
	public static SqlInfo getLikeSelectSqlInfo(Class<?> clazz,Map<String,String> map){
		TableInfo table=TableInfo.get(clazz);
		StringBuffer strSQL = new StringBuffer(getSelectSqlByTableName(table.getTableName()));
		strSQL.append(" WHERE ");
		Iterator iterator = map.entrySet().iterator();
		String[] values = new String[map.size()];
		int index = 0;
		while(iterator.hasNext()) {
			Map.Entry<String,String> entry = (Map.Entry<String, String>) iterator.next();
			if(!CommonUtil.isEmpty(entry.getKey())) {
				strSQL.append(entry.getKey()).append(" like ? ");
				values[index] = entry.getValue();
				if(index != map.size()-1) {
					strSQL.append(" and ");
				}
				index  = index +1;
			}
		}
		SqlInfo sqlInfo = new SqlInfo();
		sqlInfo.setSql(strSQL.toString());
		sqlInfo.addWhere(values);
		return sqlInfo;
	}



	public static String getSelectSQLByWhere(Class<?> clazz,String strWhere){
		TableInfo table=TableInfo.get(clazz);

		StringBuffer strSQL = new StringBuffer(getSelectSqlByTableName(table.getTableName()));

		if(!TextUtils.isEmpty(strWhere)){
			strSQL.append(" WHERE ").append(strWhere);
		}

		return strSQL.toString();
	}

	//////////////////////////////update sql start/////////////////////////////////////////////

	public static SqlInfo getUpdateSqlAsSqlInfo(Object entity){

		TableInfo table=TableInfo.get(entity.getClass());
		Object idvalue=table.getId().getValue(entity);

		if(null == idvalue ) {//主键值不能为null，否则不能更新
			throw new DbException("this entity["+entity.getClass()+"]'s id value is null");
		}

		List<KeyValue> keyValueList = new ArrayList<KeyValue>();
		//添加属性
		Collection<Property> propertys = table.propertyMap.values();
		for(Property property : propertys){
			KeyValue kv = property2KeyValue(property, entity) ;
			if(kv!=null)
				keyValueList.add(kv);
		}


		if(keyValueList == null || keyValueList.size()==0) return null ;

		SqlInfo sqlInfo = new SqlInfo();
		StringBuffer strSQL=new StringBuffer("UPDATE ");
		strSQL.append(table.getTableName());
		strSQL.append(" SET ");
		for(KeyValue kv : keyValueList){
			strSQL.append(kv.getKey()).append("=?,");
			sqlInfo.addValue(kv.getValue());
		}
		strSQL.deleteCharAt(strSQL.length() - 1);
		strSQL.append(" WHERE ").append(table.getId().getColumn()).append("=?");
		sqlInfo.addValue(idvalue);
		sqlInfo.setSql(strSQL.toString());
		return sqlInfo;
	}




	public static SqlInfo getUpdateSqlAsSqlInfo(Object entity,String  strWhere){

		TableInfo table=TableInfo.get(entity.getClass());

		List<KeyValue> keyValueList = new ArrayList<KeyValue>();

		//添加属性
		Collection<Property> propertys = table.propertyMap.values();
		for(Property property : propertys){
			KeyValue kv = property2KeyValue(property, entity) ;
			if(kv!=null) keyValueList.add(kv);
		}


		if(keyValueList == null || keyValueList.size()==0) {
			throw new DbException("this entity["+entity.getClass()+"] has no property");
		}

		SqlInfo sqlInfo = new SqlInfo();
		StringBuffer strSQL=new StringBuffer("UPDATE ");
		strSQL.append(table.getTableName());
		strSQL.append(" SET ");
		for(KeyValue kv : keyValueList){
			strSQL.append(kv.getKey()).append("=?,");
			sqlInfo.addValue(kv.getValue());
		}
		strSQL.deleteCharAt(strSQL.length() - 1);
		if(!TextUtils.isEmpty(strWhere)){
			strSQL.append(" WHERE ").append(strWhere);
		}
		sqlInfo.setSql(strSQL.toString());
		return sqlInfo;
	}



	public static String getCreatTableSQL(Class<?> clazz){
		TableInfo table=TableInfo.get(clazz);

		Id id=table.getId();
		StringBuffer strSQL = new StringBuffer();
		strSQL.append("CREATE TABLE IF NOT EXISTS ");
		strSQL.append(table.getTableName());
		strSQL.append(" ( ");

		Class<?> primaryClazz = id.getDataType();
		if( primaryClazz == int.class || primaryClazz==Integer.class
				|| primaryClazz == long.class || primaryClazz == Long.class){
			strSQL.append(id.getColumn()).append(" INTEGER PRIMARY KEY AUTOINCREMENT,");
		}else{
			strSQL.append(id.getColumn()).append(" TEXT PRIMARY KEY,");
		}



		Collection<Property> propertys = table.propertyMap.values();
		for(Property property : propertys){
			strSQL.append(property.getColumn());
			Class<?> dataType =  property.getDataType();
			if( dataType== int.class || dataType == Integer.class
					|| dataType == long.class || dataType == Long.class){
				strSQL.append(" INTEGER");
			}else if(dataType == float.class ||dataType == Float.class
					||dataType == double.class || dataType == Double.class){
				strSQL.append(" REAL");
			}else if (dataType == boolean.class || dataType == Boolean.class) {
				strSQL.append(" NUMERIC");
			}
			strSQL.append(",");
		}
		strSQL.deleteCharAt(strSQL.length() - 1);
		strSQL.append(" )");
		return strSQL.toString();
	}


	/**
	 * @param key
	 * @param value
	 * @return eg1: name='afinal'  eg2: id=100
	 */
	private static String getPropertyStrSql(String key,Object value){
		StringBuffer sbSQL = new StringBuffer(key).append("=");
		if(value instanceof String || value instanceof java.util.Date || value instanceof java.sql.Date){
			sbSQL.append("'").append(value).append("'");
		}else{
			sbSQL.append(value);
		}
		return sbSQL.toString();
	}



	private static KeyValue property2KeyValue(Property property , Object entity){
		KeyValue kv = null ;
		String pcolumn=property.getColumn();
		Object value = property.getValue(entity);
		if(value!=null){
			kv = new KeyValue(pcolumn, value);
		}else{
			if(property.getDefaultValue()!=null && property.getDefaultValue().trim().length()!=0)
				kv = new KeyValue(pcolumn, property.getDefaultValue());
		}
		return kv;
	}



}
