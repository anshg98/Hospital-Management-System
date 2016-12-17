
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import net.proteanit.sql.DbUtils;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Ansh Gupta
 */
public class AppointmentRecord extends javax.swing.JFrame {
    
    Connection con=null;
ResultSet rs=null;
PreparedStatement pst=null;

    /**
     * Creates new form AppointmentRecord
     */
    public AppointmentRecord() {
        initComponents();
        con= Connect.ConnectDB();
        Get_Data();
        setLocationRelativeTo(null);
    }
private void Get_Data(){
         String sql="Select Patientname as 'Patient Name', FatherName as 'Father Name', ContactNo as 'Contact No', Age, Gender, BloodGroup as 'Blood Group', Disease, Date, Time, Doctorname as 'Doctor Name', Fees, Fees_Validity as 'Fees Validity', Cabin as 'Cabin No' from Appointment;";
         try{
         pst=con.prepareStatement(sql);
          rs= pst.executeQuery();
         jTable1.setModel(DbUtils.resultSetToTableModel(rs));
         }catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
          
}
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Appointment Record");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1174, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 526, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(19, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
try{
            con=Connect.ConnectDB();
            int row= jTable1.getSelectedRow();
            String table_click= jTable1.getModel().getValueAt(row, 0).toString();
            String sql="Select * from Appointment";   
            pst=con.prepareStatement(sql);
            rs=  pst.executeQuery();
            if(rs.next()){
                this.hide();
                Appointment frm = new Appointment();
                frm.setVisible(true);
                String add1=rs.getString("Doctorname");
                frm.txtDoctorName.setText(add1);
                
                String add10=rs.getString("FatherName");
                frm.txtFatherName.setText(add10);
                
                String add21=rs.getString("Date");
                frm.txtDate.setText(add21);
                
                String add31=rs.getString("Time");
                frm.txtTime.setText(add31);
                
                String add2=rs.getString("Patientname");
                frm.txtPatientName.setText(add2);
                
                String add3=rs.getString("ContactNo");
                frm.txtContactNo.setText(add3);
                
                String add5=rs.getString("Age");
                frm.txtAge.setText(add5);
                
                String add6=rs.getString("Gender");
                frm.cmbGender.setSelectedItem(add6);
                
                String add7=rs.getString("BloodGroup");
                frm.cmbBloodGroup.setSelectedItem(add7);
                
                String add9=rs.getString("Disease");
                frm.txtDisease.setText(add9);
                
                String add11=rs.getString("Fees");
                frm.txtFees.setText(add11);
                
                String add14=rs.getString("Fees_Validity");
                frm.txtFeesValidity.setText(add14);
                
                String add15=rs.getString("Cabin");
                frm.txtCabin.setText(add15);
                
                frm.btnUpdate.setEnabled(true);
                frm.btnDelete.setEnabled(true);
                frm.btnSave.setEnabled(false);
             
            }
        }catch(Exception ex){
            JOptionPane.showMessageDialog(this,ex);
        }

        // TODO add your handling code here:
    }//GEN-LAST:event_jTable1MouseClicked

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
this.hide();
       Appointment frm = new Appointment();
       frm.setVisible(true);
        // TODO add your handling code here:
    }//GEN-LAST:event_formWindowClosing

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(AppointmentRecord.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AppointmentRecord.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AppointmentRecord.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AppointmentRecord.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AppointmentRecord().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
