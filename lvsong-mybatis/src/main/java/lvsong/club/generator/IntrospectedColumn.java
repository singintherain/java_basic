package lvsong.club.generator;

import org.mybatis.generator.api.dom.java.FullyQualifiedJavaType;

import java.sql.Types;

/**
 * Created by lvsong on 5/12/16.
 */
public class IntrospectedColumn extends org.mybatis.generator.api.IntrospectedColumn {
    @Override
    public void setFullyQualifiedJavaType(FullyQualifiedJavaType fullyQualifiedJavaType) {
        super.setFullyQualifiedJavaType(fullyQualifiedJavaType);
        if (Types.DATE == this.getJdbcType() && "org.joda.time.DateTime".equals(fullyQualifiedJavaType.getFullyQualifiedName())) {
            this.typeHandler = "com.tuan800.mybatis.typehandler.JodaDateTime2DateTypeHandler";
        } else if (Types.TIMESTAMP == this.getJdbcType() && "org.joda.time.DateTime".equals(fullyQualifiedJavaType.getFullyQualifiedName())) {
            this.typeHandler = "com.tuan800.mybatis.typehandler.JodaDateTime2TimestampTypeHandler";
        } else if (Types.TIME == this.getJdbcType() && "org.joda.time.DateTime".equals(fullyQualifiedJavaType.getFullyQualifiedName())) {
            this.typeHandler = "com.tuan800.mybatis.typehandler.JodaDateTime2TimeTypeHandler";
        }
    }
}
