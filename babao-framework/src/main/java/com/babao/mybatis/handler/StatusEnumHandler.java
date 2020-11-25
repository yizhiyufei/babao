//package com.babao.mybatis.handler;
//
//import java.sql.CallableStatement;
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//import java.util.HashMap;
//import java.util.Map;
//import org.apache.ibatis.type.JdbcType;
//import org.apache.ibatis.type.MappedJdbcTypes;
//import org.apache.ibatis.type.MappedTypes;
//import org.apache.ibatis.type.TypeHandler;
//
//import com.babao.system.domain.enums.StatusEnum;
///**
// * 状态常量
// * 枚举类型处理器
// * @author yizhiyufei
// *
// */
///* 数据库中的数据类型 */
//@MappedJdbcTypes(JdbcType.INTEGER)
///* 转化后的数据类型 */
//@MappedTypes(value = StatusEnum.class)
//public class StatusEnumHandler implements TypeHandler<StatusEnum>{
//
//	private final Map<Integer,StatusEnum> statusMap = new HashMap<Integer,StatusEnum>();
//
//	public  StatusEnumHandler() {
//		for(StatusEnum status : StatusEnum.values()) {
//			statusMap.put(status.getCode(), status);
//		}
//	}
//
//	@Override
//	public void setParameter(PreparedStatement ps, int i, StatusEnum parameter, JdbcType jdbcType)
//			throws SQLException {
//		ps.setInt(i, parameter.getCode());
//
//	}
//
//	@Override
//	public StatusEnum getResult(ResultSet rs, String columnName) throws SQLException {
//		Integer code = rs.getInt(columnName);
//		return statusMap.get(code);
//	}
//
//	@Override
//	public StatusEnum getResult(ResultSet rs, int columnIndex) throws SQLException {
//		Integer code = rs.getInt(columnIndex);
//		return statusMap.get(code);
//	}
//
//	@Override
//	public StatusEnum getResult(CallableStatement cs, int columnIndex) throws SQLException {
//		Integer code = cs.getInt(columnIndex);
//		return statusMap.get(code);
//	}
//
//}
