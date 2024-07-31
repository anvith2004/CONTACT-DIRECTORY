/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dao;
import java.sql.Connection;
import com.entity.contact;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class contactDAO {
    private Connection conn;
    
    public contactDAO(Connection conn) {
        super();
        this.conn = conn;
    }
    
    public boolean saveContact(contact c) {
        boolean f = false;
        PreparedStatement ps = null;
        
        try {
            ps = conn.prepareStatement("insert into phonebook(name, phno) values(?, ?)");
            ps.setString(1, c.getName());
            ps.setString(2, c.getPhno());
            int i = ps.executeUpdate();
            
            if(i == 1) {
                f = true;
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return f;
    }
    
    public boolean editContact(contact c) {
        boolean f = false;
        PreparedStatement ps = null;
        
        try {
            ps = conn.prepareStatement("update phonebook set name=? phno=? where id=?");
            ps.setInt(3, c.getId());
            ps.setString(1, c.getName());
            ps.setString(2, c.getPhno());
            int i = ps.executeUpdate();
            
            if(i == 1) {
                f = true;
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return f;
    }
    
    public boolean deleteContact(int id) {
        boolean f = false;
        PreparedStatement ps = null;
        
        try {
            ps = conn.prepareStatement("delete from phonebook where id=?");
            ps.setInt(1, id);
            int i = ps.executeUpdate();
            
            if(i == 1) {
                f = true;
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return f;
    }
    
    public List<contact> getContact() {
        List<contact> list = new ArrayList<contact>();
        contact obj = null;
        try {
            PreparedStatement ps = conn.prepareStatement("select * from phonebook");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                obj = new contact();
                obj.setId(rs.getInt(1));
                obj.setName(rs.getString(2));
                obj.setPhno(rs.getString(3));
                list.add(obj);
            }
        } catch(Exception e) {
            e.printStackTrace();
        }
        return list;
    }
}
