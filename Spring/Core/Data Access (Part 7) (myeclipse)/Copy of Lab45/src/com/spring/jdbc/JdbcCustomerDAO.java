package com.spring.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

public class JdbcCustomerDAO extends JdbcDaoSupport implements CustomerDAO{

	@Override
	public void addCustomer(final CustomerTO cto) {
		PreparedStatementCreator psc = new PreparedStatementCreator() {
			
			@Override
			public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
				PreparedStatement ps = con.prepareStatement("insert into customers values(?,?,?,?,?)");
				ps.setInt(1, cto.getCid());
				ps.setString(2, cto.getCname());
				ps.setString(3, cto.getEmail());
				ps.setLong(4, cto.getPhone());
				ps.setString(5, cto.getCity());
				
				return ps;
			}
		};
		getJdbcTemplate().update(psc);
	}

	@Override
	public List<CustomerTO> getAllCustomers() {
		PreparedStatementCreator psc = new PreparedStatementCreator() {
			
			@Override
			public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
				PreparedStatement ps = con.prepareStatement("select * from customers");
				
				return ps;
			}
		};
		List list = getJdbcTemplate().query(psc, new CustomerRowMapper());
		return list;
	}
		
}
