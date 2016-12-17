/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Ansh Gupta
 */
import java.sql.*;
import javax.swing.*;
public class Connect {
     
   
        public static Connection ConnectDB(){
            
            Connection con;
     Statement stmt;
     ResultSet rs;
             try{
           
          Class.forName("com.mysql.jdbc.Driver");
         con = DriverManager.getConnection("jdbc:mysql://localhost:3306/hospital","root","ansh@123");
          stmt=con.createStatement();
          
          
          
          String y = "use hospital;";
            stmt.executeUpdate(y);
          
            String x = "create table if not exists users (UserName varchar(10), user_Password varchar(20),usertype varchar(20),primary key(UserName));";
            stmt.executeUpdate(x);
            
            String v = "create table if not exists Doctor (Doctorname varchar(20), DoctorID varchar(10), Address varchar(40), ContactNo bigint(11), Qualifications varchar(20), Specialization varchar(15), Fees integer(3), Fees_Validity integer(1), DateOfJoining date, Cabin integer(2), primary key(DoctorID));";
            stmt.executeUpdate(v);
            
            String u = "create table if not exists Bill_Ward(BillingDate date,BedCharges bigint(5),ServiceCharges bigint(5),PaymentMode varchar(20),PaymentModeDetails varchar(20),ChargesPaid bigint(5),DueCharges bigint(5),TotalCharges bigint(5),NoOfDays integer(2),TotalBedCharges bigint(5));";
            stmt.executeUpdate(u);
            
            String w = "create table if not exists Bill_Room(BillingDate date,RoomCharges bigint(5),ServiceCharges bigint(5),PaymentMode varchar(20),PaymentModeDetails varchar(20),ChargesPaid bigint(5),DueCharges bigint(5),TotalCharges bigint(5),NoOfDays integer(2),TotalRoomCharges bigint(5));";
            stmt.executeUpdate(w);
            
            String z = "create table if not exists Room(RoomNo integer(3),RoomType varchar (10),RoomCharges bigint(5),RoomStatus varchar(10),primary key(RoomNo));";
            stmt.executeUpdate(z);
            
            String a = "create table if not exists ward(Wardname varchar(10),wardType varchar(10),NoOfBeds integer(2),Charges bigint(5),primary key(Wardname));";
            stmt.executeUpdate(a);
            
            String b = "create table if not exists Registration(username varchar(20),password varchar(20),nameofuser varchar(10),Email varchar(30),ContactNo bigint(10),usertype varchar(10),primary key(username));";
            stmt.executeUpdate(b);
            
            String c = "create table if not exists Services(ServiceID varchar(10),ServiceName varchar(20),ServiceDate date,PatientID varchar(10),ServiceCharges bigint(5),primary key(ServiceID));";
            stmt.executeUpdate(c);
            
            String d = "create table if not exists Wardboy_Nurse_tbl(ID varchar(10),W_N_name varchar(20),Category varchar(20),Email varchar(30),ContactNo bigint(10),Qualifications varchar(20),DateOfJoining date,Address varchar(30),primary key(ID));";
            stmt.executeUpdate(d);
            
            String e = "create table if not exists PatientRegistration(PatientID varchar(10),Patientname varchar(20),FatherName varchar(20),Email varchar(30),ContactNo bigint(10),Age integer(2),Remarks varchar(100),Gen varchar(1),BG varchar(3),Address varchar(30),primary key(PatientID));";
            stmt.executeUpdate(e);
            
            String f = "create table if not exists AdmitPatient_Room(PatientID varchar(10),Disease varchar(10),AdmitDate date,RoomNo integer(3),DoctorID varchar(10),AP_Remarks varchar(100));";
            stmt.executeUpdate(f);
            
            String g = "create table if not exists AdmitPatient_Ward(PatientID varchar(10),Disease varchar(10),AdmitDate date,Wardname varchar(10),DoctorID varchar(100),AP_Remarks varchar(100));";
            stmt.executeUpdate(g);
            
            String h = "create table if not exists DischargePatient_Room(DischargeDate date,DP_Remarks varchar(100));";
            stmt.executeUpdate(h);
            
            String j = "create table if not exists DischargePatient_Ward(DischargeDate date,DP_Remarks varchar(100));";
            stmt.executeUpdate(j);
            
            String k = "create table if not exists Appointment(Patientname varchar(20), FatherName varchar(20), ContactNo bigint(10), Age integer(2), Gender varchar(1), BloodGroup varchar(3), Disease varchar(10), Date date, Time time, Doctorname varchar(20), Fees integer(3), Fees_Validity integer(1), Cabin integer(2));";
            stmt.executeUpdate(k);
            
            
         }
             catch(ClassNotFoundException | SQLException e){
            JOptionPane.showMessageDialog(null, e);
            return null;
    }      
             return con;
}
}
