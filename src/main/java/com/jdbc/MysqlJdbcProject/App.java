package com.jdbc.MysqlJdbcProject;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.Scanner;

import com.mysql.cj.jdbc.CallableStatement;


/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        try
        {
        	Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc", "root","Mitra@123");
        	Scanner sc = new Scanner(System.in);        	
        	while(true)
        	{
        		System.out.println(" 1 for Insert Data .");
            	System.out.println(" 2 for Update Class Data .");
            	System.out.println(" 3 for Update Department Data .");
            	System.out.println(" 4 for Update Name Data .");
            	System.out.println(" 5 for Update Mobile Number .");
            	System.out.println(" 6 for Update Roll Number .");
            	System.out.println(" 7 for Modify Column => Add Column .");
            	System.out.println(" 8 for Modify Data => Inser Data in newly created Column .");
            	System.out.println(" 9 for Modify Data => Modify Column .");
            	System.out.println(" 10 for Modify Data => Rename Column .");
            	System.out.println(" 11 for Modify Data => Drop Column .");
            	System.out.println(" 12 for Modify Data => Rename Table using Alter Command .");
            	System.out.println(" 13 for Truncate Table .");
            	System.out.println(" 14 for Rename Table .");
            	System.out.println(" 15 for Delete Data .");
            	System.out.println(" 16 for Display Desired Data .");
            	System.out.println(" 17 for Display All Data .");
            	System.out.println(" 18 for Exit .");
            	System.out.println("Choose Option ----------->");
            	
            	int choise = sc.nextInt();
        		switch (choise) 
        		{
					case 1 :	String query1 = "insert into jdbc(id,name,mobile,class,dept,roll) values(?,?,?,?,?,?)";
								PreparedStatement st1 = con.prepareStatement(query1);
								
								System.out.println("Enter Id : ");
								int id = sc.nextInt();
								st1.setInt(1,id);
								
								System.out.println();
								
								System.out.println("Enter Name : ");
								String name = sc.next();
								st1.setString(2, name);
								
								System.out.println();
								
								System.out.println("Enter Mobile : ");
								String mobile = sc.next();
								st1.setString(3, mobile);
								
								System.out.println();
								
								System.out.println("Enter Class : ");
								String cls = sc.next();
								st1.setString(4, cls);
								
								System.out.println();
								
								System.out.println("Enter dept : ");
								String dept = sc.next();
								st1.setString(5, dept);
								
								System.out.println();
								
								System.out.println("Enter Roll : ");
								String roll = sc.next();
								st1.setString(6,roll);
								
								System.out.println();
								
								int r1 = st1.executeUpdate();
								System.out.println("Data Inserted : "+ r1 + " row");
								
					case 2 :	String query2 = "update jdbc set class=? where id = ?";
								PreparedStatement st2 = con.prepareStatement(query2);
								
								System.out.println("Enter Class Name : ");
								String clss = sc.next();
								st2.setString(1, clss);
								
								System.out.println("Enter Id : ");
								int idd = sc.nextInt();
								st2.setInt(2, idd);
								
								int r2 = st2.executeUpdate();
								System.out.println("Data Updated : "+ r2 + " row");
								
					case 3 :	String query3 = "update jdbc set dept=? where id = ?";
								PreparedStatement st3 = con.prepareStatement(query3);
					
								System.out.println("Enter Department Name : ");
								String deptt = sc.next();
								st3.setString(1, deptt);
					
								System.out.println("Enter Id : ");
								int i = sc.nextInt();
								st3.setInt(2, i);
					
								int r3 = st3.executeUpdate();
								System.out.println("Data Updated : "+ r3 + " row");
								
					case 4 :	String query4 = "update jdbc set name=? where id = ?";
								PreparedStatement st4 = con.prepareStatement(query4);
		
								System.out.println("Enter Name : ");
								String nam = sc.next();
								st4.setString(1, nam);
		
								System.out.println("Enter Id : ");
								int ii = sc.nextInt();
								st4.setInt(2, ii);
		
								int r4 = st4.executeUpdate();
								System.out.println("Data Updated : "+ r4 + " row");
								
					case 5 :	String query5 = "update jdbc set mobile=? where id = ?";
								PreparedStatement st5 = con.prepareStatement(query5);

								System.out.println("Enter Mobile Number : ");
								String mob = sc.next();
								st5.setString(1, mob);

								System.out.println("Enter Id : ");
								int id1 = sc.nextInt();
								st5.setInt(2, id1);

								int r5 = st5.executeUpdate();
								System.out.println("Data Updated : "+ r5 + " row");
								
					case 6 :	String query6 = "update jdbc set roll=? where id = ?";
								PreparedStatement st6 = con.prepareStatement(query6);

								System.out.println("Enter Roll Number : ");
								String rol = sc.next();
								st6.setString(1, rol);

								System.out.println("Enter Id : ");
								int Id = sc.nextInt();
								st6.setInt(2, Id);

								int r6 = st6.executeUpdate();
								System.out.println("Data Updated : "+ r6 + " row");
								
					case 7 :	System.out.println("Enter Column Name whose datatype will varchar : ");
								String c_name = sc.next();
								System.out.println("Please Enter varchar(255) DataType either might not work : ");
								String c_type = sc.next();
								String query7 = String.format("alter table jdbc add column %s %s",c_name,c_type);
								PreparedStatement st7 = con.prepareStatement(query7);
								int r7 = st7.executeUpdate();
								System.out.println("Column Added : "+ r7);							
							
					case 8 :	System.out.println("Enter Column Name that Added : ");
								String field = sc.next();
								
								String query8 = String.format("update jdbc set %s = ? where id = ?",field);
								PreparedStatement st8 = con.prepareStatement(query8);					
								
								System.out.println("Enter Value : ");
								String value = sc.next();
								st8.setString(1, value);
								
								System.out.println("Enter Id : ");
								int id_num = sc.nextInt();
								st8.setInt(2, id_num);
								
								int r8 = st8.executeUpdate();
								System.out.println("Value Added in the Newly created Column : "+ r8);
								
					case 9 :	System.out.println("Enter Column Name : ");
								String f_name = sc.next();
								System.out.println("Enter DataType To Modify : ");
								String f_type = sc.next();
								String query9 = String.format("alter table jdbc modify column %s %s",f_name,f_type);
								PreparedStatement st9 = con.prepareStatement(query9);
								int r9 = st9.executeUpdate();
								System.out.println("Column Modified : "+ r9);
								
					case 10 :	System.out.println("Enter old Column Name To Rename : ");
								String o_name = sc.next();	
								System.out.println("Enter new Column Name  : ");
								String n_name = sc.next();	
								String query10 = String.format("alter table jdbc rename column %s to %s",o_name,n_name);
								PreparedStatement st10 = con.prepareStatement(query10);
								st10.executeUpdate();
								System.out.println("Column Renamed .");
								
					case 11 :	System.out.println("Enter Column Name To drop : ");
								String column_name = sc.next();								
								String query11 = String.format("alter table jdbc drop column %s",column_name);
								PreparedStatement st11 = con.prepareStatement(query11);
								st11.executeUpdate();
								System.out.println("Column droped. ");
								
					case 12 :	System.out.println("Enter old Table Name : ");
								String old_name = sc.next();
								System.out.println("Enter new Table Name : ");
								String new_name = sc.next();
								String query12 = String.format("alter table %s rename to %s",old_name,new_name);
								PreparedStatement st12 = con.prepareStatement(query12);
								st12.executeUpdate();
								System.out.println("Table Renamed using Alter Command . ");
					
					case 13 :	System.out.println("Enter Table Name : ");
								String t_name = sc.next();								
								String query13 = String.format("truncate table %s",t_name);
								PreparedStatement st13 = con.prepareStatement(query13);
								st13.executeUpdate();
								System.out.println("Table Truncated. ");
								
					case 14 :	System.out.println("Enter old Table Name : ");
								String od_name = sc.next();
								System.out.println("Enter new Table Name : ");
								String nw_name = sc.next();
								String query14 = String.format("rename table %s to %s",od_name,nw_name);
								PreparedStatement st14 = con.prepareStatement(query14);
								st14.executeUpdate();
								System.out.println("Table Renamed . ");
								
					case 15 :	System.out.println("Enter Table Name : ");
								String ta_name = sc.next();
								System.out.println("Enter Id : ");
								int t_id = sc.nextInt();								
								String query15 = String.format("delete from %s where id = %d",ta_name,t_id);
								PreparedStatement st15 = con.prepareStatement(query15);
								st15.executeUpdate();
								System.out.println("Table Data Deleted . ");

								
					case 16 :	System.out.println("Enter Table Name : ");
								String a_name = sc.next();
								System.out.println("Enter Id : ");
								int a_id = sc.nextInt();
								String query16 = String.format("select * from %s where id = %d",a_name,a_id);
								PreparedStatement st16 = con.prepareStatement(query16);
								ResultSet rs1 = st16.executeQuery();
								System.out.println("Student Data : ");
								while(rs1.next())
					        	{
					        		System.out.println(rs1.getInt(1)+" "+rs1.getString(2)+" "+rs1.getString(3)+" "+rs1.getString(4)+" "
					        							+rs1.getString(5)+" "+rs1.getString(6));
					        	}
								
					case 17 :	System.out.println("Enter Table Name : ");
								String g_name = sc.next();
								String query17 = String.format("select * from %s",g_name);
								PreparedStatement st17 = con.prepareStatement(query17);
								ResultSet rs2 = st17.executeQuery();
								System.out.println("Student Data : ");
								while(rs2.next())
								{
									System.out.println(rs2.getInt(1)+" "+rs2.getString(2)+" "+rs2.getLong(3)+" "+rs2.getString(4)+" "
		        							+rs2.getString(5)+" "+rs2.getLong(6));
								}
								
					case 18 :   System.exit(0);
								break;

					default:	System.out.println("Invalid choice!!! Please make a valid choice. \\n\\n");
								break;
				}
        		
        	}
        	        	
        }
        catch(SQLException e)
        {
        	System.out.println(e.getMessage());
        }
    }
}
