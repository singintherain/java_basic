package lvsong.club.typeHandler;

import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;
import org.joda.time.DateTime;

import java.sql.*;

/**
 * Created by lvsong on 5/12/16.
 */
public class JodaDateTime2TimeTypeHandler extends BaseTypeHandler {
    @Override
    public void setNonNullParameter(PreparedStatement ps, int i, Object parameter, JdbcType jdbcType) throws SQLException {
        DateTime dateTime = (DateTime) parameter;
        ps.setTime(i, new Time(dateTime.getMillis()));
    }

    @Override
    public Object getNullableResult(ResultSet rs, String columnName) throws SQLException {
        DateTime dateTime = null;
        Time time = rs.getTime(columnName);
        if (time != null) {
            dateTime = new DateTime(time.getTime());
        }
        return dateTime;
    }

    @Override
    public Object getNullableResult(CallableStatement cs, int columnIndex) throws SQLException {
        DateTime dateTime = null;
        Time time = cs.getTime(columnIndex);
        if (time != null) {
            dateTime = new DateTime(time.getTime());
        }
        return dateTime;
    }

    public Object getNullableResult(ResultSet rs, int columnIndex) throws SQLException {
        DateTime dateTime = null;
        Time time = rs.getTime(columnIndex);
        if (time != null) {
            dateTime = new DateTime(time.getTime());
        }
        return dateTime;
    }
}
