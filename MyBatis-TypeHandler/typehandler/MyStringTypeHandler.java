package typehandler;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.MappedJdbcTypes;
import org.apache.log4j.Logger;

@MappedJdbcTypes(JdbcType.VARCHAR)	// 指定映射的数据库数据类型
public class MyStringTypeHandler extends BaseTypeHandler<String> {

	Logger logger = Logger.getLogger(this.getClass());
	String msg = "Use my typehandler to ";
	@Override
	public void setNonNullParameter(PreparedStatement ps, int i, String parameter, JdbcType jdbcType)
			throws SQLException {
		logger.info(msg + "set nonNullParameter.");
		ps.setString(i, parameter);
	}

	@Override
	public String getNullableResult(ResultSet rs, String columnName) throws SQLException {
		logger.info(msg + "get nullableResult by column name : " + columnName);
		return rs.getString(columnName);
	}

	@Override
	public String getNullableResult(ResultSet rs, int columnIndex) throws SQLException {
		logger.info(msg + "get nullableResult by column index.");
		return rs.getString(columnIndex);
	}

	@Override
	public String getNullableResult(CallableStatement cs, int columnIndex) throws SQLException {
		logger.info(msg + "get result from callable statement.");
		return cs.getString(columnIndex);
	}

}
