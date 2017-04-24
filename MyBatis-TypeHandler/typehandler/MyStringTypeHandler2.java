package typehandler;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.MappedJdbcTypes;
import org.apache.ibatis.type.MappedTypes;
import org.apache.ibatis.type.TypeHandler;
import org.apache.log4j.Logger;

//@MappedTypes(String.class)
@MappedJdbcTypes(JdbcType.VARCHAR)
public class MyStringTypeHandler2 implements TypeHandler<String> {

	Logger logger = Logger.getLogger(this.getClass());
	String msg = "Use my typehandler (implementation) to ";
	
	@Override
	public void setParameter(PreparedStatement ps, int i, String parameter, JdbcType jdbcType) throws SQLException {
		logger.info(msg + "set nonNullParameter.");
		ps.setString(i, parameter);
	}

	@Override
	public String getResult(ResultSet rs, String columnName) throws SQLException {
		logger.info(msg + "get nullableResult by column name : " + columnName);
		return rs.getString(columnName);
	}

	@Override
	public String getResult(ResultSet rs, int columnIndex) throws SQLException {
		logger.info(msg + "get nullableResult by column index.");
		return rs.getString(columnIndex);
	}

	@Override
	public String getResult(CallableStatement cs, int columnIndex) throws SQLException {
		logger.info(msg + "get result from callable statement.");
		return cs.getString(columnIndex);
	}

}
