//package com.babao.mybatis.handler;
//
//import java.sql.CallableStatement;
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//import java.util.HashMap;
//import java.util.Map;
//
//import org.apache.ibatis.type.JdbcType;
//import org.apache.ibatis.type.MappedJdbcTypes;
//import org.apache.ibatis.type.MappedTypes;
//import org.apache.ibatis.type.TypeHandler;
//import com.babao.common.enums.MenuType;
///**
// * 菜单枚举映射过滤器
// * @author yizhiyufei
// *
// */
///* 数据库中的数据类型 */
//@MappedJdbcTypes(JdbcType.CHAR)
///* 转化后的数据类型 */
//@MappedTypes(value = MenuType.class)
//public class MenuTypeHandler implements TypeHandler<MenuType> {
//
//	Map<String,MenuType> map = new HashMap<String,MenuType>();
//
//	public MenuTypeHandler() {
//		for(MenuType type : MenuType.values()) {
//			map.put(type.getCode(), type);
//		}
//	}
//
//	@Override
//	public void setParameter(PreparedStatement ps, int i, MenuType parameter, JdbcType jdbcType) throws SQLException {
//		ps.setString(i, parameter.getCode());
//
//
//	}
//
//	@Override
//	public MenuType getResult(ResultSet rs, String columnName) throws SQLException {
//		String code = rs.getString(columnName);
//		return map.get(code);
//	}
//
//	@Override
//	public MenuType getResult(ResultSet rs, int columnIndex) throws SQLException {
//		String code = rs.getString(columnIndex);
//		return map.get(code);
//	}
//
//	@Override
//	public MenuType getResult(CallableStatement cs, int columnIndex) throws SQLException {
//		String code = cs.getString(columnIndex);
//		return map.get(code);
//	}
//
//}
