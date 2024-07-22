package com.edubridge.swingingMchine.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.edubridge.swingingMchine.model.SwingingMachine;
import com.edubridge.swingingMchine.util.DButils;

public class SwingingDaoimp1 implements SwingingMachineDao {

	@Override
	public int addSwingingMachine(SwingingMachine s) {
		String insert="Insert into swinging_machine(id,name,description,price,quality,brand,color,model_number)values(?,?,?,?,?,?,?,?)";
		 Connection con = DButils.getConnection();
		 int status=0;
	        try {
	            PreparedStatement ps = con.prepareStatement(insert);
	            ps.setInt(1, s.getId());
	            ps.setString(2, s.getName());
	            ps.setString(3, s.getDescription());
	            ps.setFloat(4, s.getPrice());
	            ps.setString(5,s.getQuality());
	            ps.setString(6, s.getBrand());
	            ps.setString(7, s.getColor());
	            ps.setString(8, s.getModel_number());
	          
	            status = ps.executeUpdate();
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	        return status;
	}

	@Override
	public List<SwingingMachine> getAllSwingingMachines() {
		String select = "SELECT * FROM swinging_machine";
        Connection con = DButils.getConnection();
        List<SwingingMachine> swingingMachines = new ArrayList<>();
        try {
            PreparedStatement ps = con.prepareStatement(select);
            ResultSet rs = ps.executeQuery();
            while(rs.next()) {
            	 SwingingMachine s = new SwingingMachine();
            	 s.setId(rs.getInt("id"));
            	 s.setName(rs.getString("name"));
            	 s.setDescription(rs.getString("description"));
            	 s.setPrice(rs.getFloat("price"));
            	 s.setQuality(rs.getString("quality"));
            	 s.setBrand(rs.getString("brand"));
            	 s.setColor(rs.getString("color"));
            	 s.setModel_number(rs.getString("model_number"));
            	 swingingMachines.add(s);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return swingingMachines;

	}

	@Override
	public SwingingMachine getSwingingMachine(String name) {
		 String select = "SELECT * FROM swinging_machine WHERE name = ?";
	        Connection con = DButils.getConnection();
	        SwingingMachine s = null;
	        try {
	            PreparedStatement ps = con.prepareStatement(select);
	            ps.setString(1, name);
	            ResultSet rs = ps.executeQuery();

	            if (rs.next()) {
	                s = new SwingingMachine();
	                s.setId(rs.getInt("id"));
	            	 s.setName(rs.getString("name"));
	            	 s.setDescription(rs.getString("description"));
	            	 s.setPrice(rs.getFloat("price"));
	            	 s.setQuality(rs.getString("quality"));
	            	 s.setBrand(rs.getString("brand"));
	            	 s.setColor(rs.getString("color"));
	            	 s.setModel_number(rs.getString("model_number"));
	            }
	            }catch(SQLException e) {
	            	 e.printStackTrace();
	            	
	            }
	        return s;

	}

	@Override
	public int updateSwingingMachine(SwingingMachine s) {
	    String update = "UPDATE swinging_machine SET name = ?, description = ?, price = ?, quality = ?, brand = ?, color = ?, model_number = ? WHERE id = ?";
	    Connection con = DButils.getConnection();
	    int status = 0;
	    try {
	        PreparedStatement ps = con.prepareStatement(update);
	        ps.setString(1, s.getName());
	        ps.setString(2, s.getDescription());
	        ps.setFloat(3, s.getPrice());
	        ps.setString(4, s.getQuality());
	        ps.setString(5, s.getBrand());
	        ps.setString(6, s.getColor());
	        ps.setString(7, s.getModel_number());
	        ps.setInt(8, s.getId());
	        
	        status = ps.executeUpdate();
	    } catch (SQLException e) {
	        e.printStackTrace();
	    } finally {
	        // Close resources like PreparedStatement and Connection in a finally block
	        try {
	            con.close();
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }
	    return status;
	}

	@Override
	public int deleteSwingingMachine(String name) {
		String delete = "DELETE FROM swinging_machine WHERE name = ?";
        Connection con = DButils.getConnection();
        int status = 0;
        try {
            PreparedStatement ps = con.prepareStatement(delete);
            ps.setString(1, name);

            status = ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } 
        return status;

	}

	@Override
	public void deleteAllSwingingMachines() {
		String deleteAll = "DELETE FROM swinging_machine";
        Connection con = DButils.getConnection();
        try {
            PreparedStatement ps = con.prepareStatement(deleteAll);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
	}

}
