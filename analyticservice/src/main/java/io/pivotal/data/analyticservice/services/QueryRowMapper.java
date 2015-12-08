/**
 * 
 */
package io.pivotal.data.analyticservice.services;

import java.sql.ResultSet;
import java.sql.SQLException;

import io.pivotal.data.analyticservice.models.DriverIncorrectData;

import org.springframework.jdbc.core.RowMapper;

/**
 * @author shuklk2
 *
 */
public class QueryRowMapper implements RowMapper<DriverIncorrectData> {

	@Override
	public DriverIncorrectData mapRow(ResultSet rs, int rownum)
			throws SQLException {
		
		DriverIncorrectData did = new DriverIncorrectData();
		
		String drivernum = rs.getString("MEDALLION");
		int numoferrors = rs.getInt("TOTAL_COUNT");
		
		did.setDrivernum(drivernum);
		did.setNumoferrors(numoferrors);
		return did;
	}

}
