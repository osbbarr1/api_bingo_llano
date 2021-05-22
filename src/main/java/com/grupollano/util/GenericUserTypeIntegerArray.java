package com.grupollano.util;


//Fuente https://stackoverflow.com/questions/39119164/how-to-use-spring-data-jpa-to-insert-into-a-postgres-array-type-column/39167241


import java.io.Serializable;
import java.sql.Array;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;

import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.usertype.UserType;


public class GenericUserTypeIntegerArray implements UserType {

	protected static final int[] SQL_TYPES = { Types.ARRAY };

	@Override
	public int[] sqlTypes() {
		// TODO Auto-generated method stub
		return new int[] {Types.ARRAY};
	}

	@Override
	public Class<Integer[]> returnedClass() {
		// TODO Auto-generated method stub
		return Integer[].class;
	}

	@Override
	public boolean equals(Object x, Object y) throws HibernateException {

		if (x == null) {
			return y == null;
		}
		return x.equals(y);
	}

	@Override
	public int hashCode(Object x) throws HibernateException {
		// TODO Auto-generated method stub
		return x.hashCode();
	}

	@Override
	public Object nullSafeGet(ResultSet resultSet, String[] names, SharedSessionContractImplementor session, Object owner)
			throws HibernateException, SQLException {
		if (resultSet.wasNull()) {
	        return null;
	    }
	    if (resultSet.getArray(names[0]) == null) {
	        return new Integer[0];
	    }

	    Array array = resultSet.getArray(names[0]);
	    Integer[] javaArray = (Integer[]) array.getArray();
	    return javaArray;
	}

	@Override
	public void nullSafeSet(PreparedStatement statement, Object value, int index, SharedSessionContractImplementor session)
			throws HibernateException, SQLException {
		Connection connection = statement.getConnection();
	    if (value == null) {
	        statement.setNull(index, SQL_TYPES[0]);
	    } else {
	        Integer[] castObject = (Integer[]) value;
	        Array array = connection.createArrayOf("integer", castObject);
	        statement.setArray(index, array);
	    }

	}

	@Override
	public Object deepCopy(Object value) throws HibernateException {
		// TODO Auto-generated method stub
		return value;
	}

	@Override
	public boolean isMutable() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public Serializable disassemble(Object value) throws HibernateException {
		// TODO Auto-generated method stub
		return (Integer[]) this.deepCopy(value);
	}

	@Override
	public Object assemble(Serializable cached, Object owner) throws HibernateException {
		// TODO Auto-generated method stub
		return this.deepCopy(cached);
	}

	@Override
	public Object replace(Object original, Object target, Object owner) throws HibernateException {
		// TODO Auto-generated method stub
		return original;
	}

}
