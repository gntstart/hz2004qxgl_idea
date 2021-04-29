package com.gnt.qxgl.common;

import java.io.Serializable;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;

import org.apache.commons.lang.builder.HashCodeBuilder;
import org.hibernate.HibernateException;
import org.hibernate.usertype.UserType;

public class LongToString implements UserType, Serializable {
	private static final long serialVersionUID = 1L;
	
	 /* 有几个字段就有几个值，这里容易出错，要多注意 */
    private static final int[] SQL_TYPES = { java.sql.Types.DECIMAL};

    /* 这个方法告诉Hibernate在成生DDL时对列采用什么样的SQL语法 */
    public int[] sqlTypes() {
        return SQL_TYPES;
    }
    
    /*
     * Hibernate返回什么样的映射类型，与 <property name="address" type="model.AddressType">
     * 指定的类一致。事实上也可以把AddressType拆分为两个类，一个类是只携带信息的JavaBean，它里面
     * 没有逻辑操作也没有实现UserType（比如AddressBean）；而另一个类实现了UserType，它所面对的就不是现在这个
     * AddressType类的homeAddr和homeAddr属性，它面对的是AddressBean。在本例中为了简洁方便，只用了一个类。
     */
    public Class returnedClass() {
        return String.class;
    }
    
    /*
     * 表明这个类的实例在创建以后就不可以改变属性。Hibernate能为不可改变的类作一些性能优化。
     */
    public boolean isMutable() {
        return false;
    }
    
    /*
     * 由于AddressType是不可变的，所以深拷贝可以直接返回对象引用。拷贝的对象由应用程序使用， 而原版对象由Hibernate维护以做脏数据检查
     */
    public Object deepCopy(Object value) {
        return value; // Address is immutable
    }

	/* 两个对象是否相等，使用了apache的common工具包来进行属性比对 */
    public boolean equals(Object x, Object y) {
        if (x == y)
            return true;
        
        if (x == null || y == null)
            return false;
        
        return x.equals(y);
    }
    

    /* 得到hash码 */

    public int hashCode(Object x) throws HibernateException {
        return new HashCodeBuilder()//使用HashCodeBuilder类来方便地进行比对
                .append(x)
                .toHashCode();
    }
    
    /* 读取数据并组装成一个AddressType对象。names[]中的参数顺序依照映射文件中定义的顺序 */
    public Object nullSafeGet(ResultSet rs, String[] names, Object owner)
            throws HibernateException, SQLException {
        //if (rs.wasNull())
         //   return null;
    	//未读取数据
    	
        Object str = rs.getString(names[0]);

        return str;
    }
    
    /* 保存数据，index的顺序按照映射文件定义的顺序，从0开始。 */
    public void nullSafeSet(PreparedStatement st, Object value, int index)
            throws HibernateException, SQLException {
        String str = (String) value;
        if (value == null) {
              st.setNull(index, Types.VARCHAR);
        } else {
            st.setString(index, str);
        }
    }
    
    /* 当把AddressType类型数据写入二级缓存时，此方法被调用 */
    public Serializable disassemble(Object value) throws HibernateException {
        return null;
    }

    /* 当从二级缓存中读取AddressType类型数据时，此方法被调用 */
    public Object assemble(Serializable cached, Object owner)
            throws HibernateException {
        return null;
    }

    public Object replace(Object original, Object target, Object owner)
            throws HibernateException {
        return null;
    }
}
