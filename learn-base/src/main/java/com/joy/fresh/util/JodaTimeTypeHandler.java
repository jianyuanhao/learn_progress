package com.joy.fresh.util;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;
import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

/**
 * JodaTime转换为数据库可以接受的datetime类型 Created by jianyuanhao on 16-8-18.
 */
public class JodaTimeTypeHandler extends BaseTypeHandler<DateTime> {
    /**
     * 从mysql数据库取出的Date字段为字符串时多了个毫秒位.
     */
    private static final DateTimeFormatter DATE_TIME_FORMATTER = DateTimeFormat.forPattern("yyyy-MM-dd HH:mm:ss.S");

    @Override
    public void setNonNullParameter(PreparedStatement ps, int i, DateTime parameter, JdbcType jdbcType)
            throws SQLException {
        ps.setString(i, parameter.toString(DATE_TIME_FORMATTER));
    }

    @Override
    public DateTime getNullableResult(ResultSet rs, String columnName) throws SQLException {
        return DATE_TIME_FORMATTER.parseDateTime(rs.getString(columnName));
    }

    @Override
    public DateTime getNullableResult(ResultSet rs, int columnIndex) throws SQLException {

        return DATE_TIME_FORMATTER.parseDateTime(rs.getString(columnIndex));
    }

    @Override
    public DateTime getNullableResult(CallableStatement cs, int columnIndex) throws SQLException {

        return DATE_TIME_FORMATTER.parseDateTime(cs.getString(columnIndex));
    }
}
