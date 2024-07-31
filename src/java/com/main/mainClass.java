/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.main;

import java.sql.Connection;
import com.conn.DBConnect;
import com.entity.contact;
import com.dao.contactDAO;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author 91861
 */
public class mainClass {
    public static void main(String[] args) {
        boolean f=true;

        while(f)
    {
        System.out.println("");
        System.out.println("1. Create Contact"); 
        System.out.println("2. Edit Contact");
        System.out.println("3. Delete Contact");
        System.out.println("4. View Contact");
        System.out.println("5. Exit");
        System.out.println(".......");
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter No");
        int no=sc.nextInt();
        contactDAO dao=new contactDAO(DBConnect.getConn());
        
        switch (no) {
            case 1: 
                System.out.println("Enter Name"); 
                String name=sc.next();
                System.out.println("Enter Ph No");
                String phno=sc.next();
                contact c = new contact();
                c.setName(name);
                c.setPhno(phno);
                f = dao.saveContact(c);
                
                if (f == true) {
                    System.out.println("Success");
                } else {
                    System.out.println("Something Wrong in server");
                }
                break;
            case 2:
                System.out.println("Enter Name"); 
                String name1=sc.next();
                System.out.println("Enter Ph No");
                String phno1=sc.next();
                System.out.println("Enter ID");
                int id1=sc.nextInt();
                contact c1 = new contact();
                c1.setName(name1);
                c1.setPhno(phno1);
                f = dao.saveContact(c1);
                
                if (f == true) {
                    System.out.println(" EDIT Success");
                } else {
                    System.out.println("Something Wrong in server");
                }
                break;
            case 3:
                System.out.println("Enter Id");
		int id3 = sc.nextInt();
                boolean s3 = dao.deleteContact(id3);

		if (s3) {
                    System.out.println("Phno Delete Sucessfully..");
		} else {
                    System.out.println("User Is not Available");
		}
                break;
            case 4:
                List<contact> list = dao.getContact();

		if (list.isEmpty()) {
                    System.out.println("Phno is Not Available");
		} else {
                    for (contact con : list) {
			System.out.println("Id=" + con.getId());
			System.out.println("Name=" + con.getName());
			System.out.println("Phno=" + con.getPhno());
			System.out.println("---------------------");
			}
		}
                break;
            case 5:
                f = false;
		System.out.println("Thank u..Visit Again..");
                break;
            default:
                System.out.println("Please Enter Correct No..");
                break;
        }
    }
}
}
