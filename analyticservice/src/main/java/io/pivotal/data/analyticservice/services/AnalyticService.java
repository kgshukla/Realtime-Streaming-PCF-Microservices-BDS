/**
 * 
 */
package io.pivotal.data.analyticservice.services;

import io.pivotal.data.analyticservice.models.DriverIncorrectData;
import io.pivotal.data.analyticservice.models.DriverRevenueData;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

/**
 * @author shuklk2
 *
 */
@Component
public class AnalyticService {

	@Autowired
	JdbcTemplate jdbcTemplate;
	
	public List<DriverIncorrectData> getTop10IncorrectDriverData() {
		
		
		List<DriverIncorrectData> dataList = new ArrayList<DriverIncorrectData>();
		
		String query = "select medallion, count(medallion) total_count from taxi_stream.taxi_data_pxf "+
		                "where pickup_long = 0.000000 or pickup_lat = 0.000000 or dropoff_long = 0.000000 or dropoff_lat = 0.000000 "+
				        "group by medallion order by total_count desc limit 10";
		
		dataList = jdbcTemplate.query(query, new QueryRowMapper());
		
		return dataList;
	}
	
	
	public List<DriverRevenueData> getTop10EarningDrivers() {

		List<DriverRevenueData> dataList = new ArrayList<DriverRevenueData>();
		
		String query = "select medallion, sum(total_amt) total_fare from taxi_stream.taxi_data_pxf group by "+
		                "medallion order by total_fare desc limit 10";
		
		dataList = jdbcTemplate.query(query, new RowMapper<DriverRevenueData>() {

			@Override
			public DriverRevenueData mapRow(ResultSet rs, int rownum)
					throws SQLException {
				DriverRevenueData drd = new DriverRevenueData();
				String drivernum = rs.getString("MEDALLION");
				int earnedrev = rs.getInt("TOTAL_FARE");
				
				drd.setDrivernum(drivernum);
				drd.setEarnedrev(earnedrev);
				return drd;
			}
			
		});
		
		return dataList;
	}
	
}
