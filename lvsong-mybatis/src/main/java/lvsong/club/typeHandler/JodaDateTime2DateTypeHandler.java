package lvsong.club.typeHandler;

import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;
import org.joda.time.DateTime;

import java.sql.*;

/**
 * Created by lvsong on 5/12/16.
 */
public class JodaDateTime2DateTypeHandler extends BaseTypeHandler {

    @Override
    public void setNonNullParameter(PreparedStatement ps, int i, Object parameter, JdbcType jdbcType) throws SQLException {
        DateTime dateTime = (DateTime) parameter;
        ps.setDate(i, new Date(dateTime.getMillis()));
    }

    @Override
    public Object getNullableResult(ResultSet rs, String columnName) throws SQLException {
        DateTime dateTime = null;
        Date date = rs.getDate(columnName);
        if (date != null) {
            dateTime = new DateTime(date.getTime());
        }
        return dateTime;
    }

    @Override
    public Object getNullableResult(CallableStatement cs, int columnIndex) throws SQLException {
        DateTime dateTime = null;
        Date date = cs.getDate(columnIndex);
        if (date != null) {
            dateTime = new DateTime(date.getTime());
        }
        return dateTime;
    }

    public Object getNullableResult(ResultSet rs, int columnIndex) throws SQLException {
        DateTime dateTime = null;
        Date date = rs.getDate(columnIndex);
        if (date != null) {
            dateTime = new DateTime(date.getTime());
        }
        return dateTime;
    }
}
