/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package schoool.management.system.Arrangement_Group;

import schoool.management.system.Menu_Group.Welcome_Admin;
import schoool.management.system.Menu_Group.Welcome_Staff;
import schoool.management.system.Menu_Group.Welcome_Student;
import schoool.management.system.Tool_Group.Checking_Input_Data;
import schoool.management.system.Tool_Group.ConnectionClass;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import java.sql.*;
import java.util.ArrayList;

/**
 *
 * @author PC
 */
public class Classroom_Assignment extends javax.swing.JFrame {
    DefaultTableModel model;
    private static boolean showTime = true;
    private static int role = 0;
    private static String ID = null;
    private static int real_ID = 0;

    public static int getReal_ID() {
        return real_ID;
    }

    public static void setReal_ID(int real_ID) {
        Classroom_Assignment.real_ID = real_ID;
    }

    public static int getRole() {
        return role;
    }

    public static void setRole(int role) {
        Classroom_Assignment.role = role;
    }

    public static String getID() {
        return ID;
    }

    public static void setID(String ID) {
        Classroom_Assignment.ID = ID;
    }

    /**
     * Creates new form Classroom_Assignment
     */
    public Classroom_Assignment() {
        JLabel background = new JLabel(new ImageIcon("src/images/school theme 2.2.jpg"));
        setContentPane(background);
        initComponents();
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);
        setLocationRelativeTo(null);
        if (role == 0){
            btnRun.setEnabled(false);
        }
    }

    public ArrayList<Assignment> assignmentArrayList() {
        ArrayList<Assignment> assignmentArrayList = new ArrayList<>();
        try {
            Connection connection = ConnectionClass.connection();
            String sql = "SELECT * FROM Classroom_assignments";
            Statement preparedStatement = connection.createStatement();
            ResultSet rs = preparedStatement.executeQuery(sql);
            Assignment assignment;
            while (rs.next()) {
                assignment = new Assignment(
                        rs.getInt("assignment_ID"),
                        rs.getInt("staff_ID"),
                        rs.getString("subject_ID"),
                        rs.getString("assignment_details")
                      );
                assignmentArrayList.add(assignment);
            }
            connection.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        }
        return assignmentArrayList;
    }

    public void show_assignment() {
        ArrayList<Assignment> list = assignmentArrayList();
        model = (DefaultTableModel) tableShowAssignment.getModel();
        Object[] row = new Object[4];
        for (int i = 0; i < list.size(); i++) {
            row[0] = list.get(i).getAssignment_ID();
            row[1] = list.get(i).getStaff_ID();
            row[2] = list.get(i).getSubject_ID();
            row[3] = list.get(i).getAssignment_Details();
            model.addRow(row);
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

        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        comboboxWhatToDo = new javax.swing.JComboBox<>();
        txtAssignmentID = new javax.swing.JTextField();
        txtDetails = new javax.swing.JTextField();
        txtStaffID = new javax.swing.JTextField();
        txtSubjectID = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        btnBrowse = new javax.swing.JButton();
        btnRun = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableShowAssignment = new javax.swing.JTable();
        jLabel12 = new javax.swing.JLabel();
        btnMenu = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel3.setFont(new java.awt.Font("Microsoft JhengHei Light", 0, 14)); // NOI18N
        jLabel3.setText("Assignment ID:");

        jLabel4.setFont(new java.awt.Font("Microsoft JhengHei Light", 0, 14)); // NOI18N
        jLabel4.setText("Staff ID:");

        jLabel5.setFont(new java.awt.Font("Microsoft JhengHei Light", 0, 14)); // NOI18N
        jLabel5.setText("Subject ID:");

        jLabel6.setFont(new java.awt.Font("Microsoft JhengHei Light", 0, 14)); // NOI18N
        jLabel6.setText("Details:");

        comboboxWhatToDo.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        comboboxWhatToDo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Add", "Remove", "Update", " " }));

        txtAssignmentID.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        txtDetails.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        txtStaffID.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        txtSubjectID.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jLabel2.setFont(new java.awt.Font("Microsoft JhengHei Light", 0, 14)); // NOI18N
        jLabel2.setText("What to do:");

        jLabel1.setText("Note");

        jLabel7.setText("- Assignment ID is unique, browse all to help you fill a unique value.");

        jLabel8.setText("- When update, fill the correct existed Assigment ID and fill the rest with");

        jLabel9.setText("new values.");

        jLabel10.setText("- When delete, just fill the existed Assignment ID and Run.");

        jLabel11.setText("- Staffs are able to modify only their own information in the list.");

        btnBrowse.setFont(new java.awt.Font("Microsoft JhengHei Light", 0, 14)); // NOI18N
        btnBrowse.setText("Browse");
        btnBrowse.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBrowseActionPerformed(evt);
            }
        });

        btnRun.setFont(new java.awt.Font("Microsoft JhengHei Light", 0, 14)); // NOI18N
        btnRun.setText("Run");
        btnRun.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRunActionPerformed(evt);
            }
        });

        tableShowAssignment.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Assignment ID", "Staff ID", "Subject ID", "Details"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tableShowAssignment.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableShowAssignmentMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tableShowAssignment);

        jLabel12.setFont(new java.awt.Font("Microsoft JhengHei Light", 0, 18)); // NOI18N
        jLabel12.setText("Classroom Assignment");

        btnMenu.setFont(new java.awt.Font("Microsoft JhengHei Light", 0, 10)); // NOI18N
        btnMenu.setText("Menu");
        btnMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMenuActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(352, 352, 352)
                .addComponent(jLabel12)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnRun)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnBrowse)
                        .addGap(311, 311, 311))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3))
                                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(btnMenu))
                            .addGap(60, 60, 60)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(comboboxWhatToDo, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(txtAssignmentID, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(txtStaffID, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txtSubjectID, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txtDetails, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(324, 324, 324))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, 390, Short.MAX_VALUE)
                                    .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel10, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 390, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 69, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(btnMenu))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(comboboxWhatToDo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(txtAssignmentID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(txtStaffID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(txtSubjectID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(txtDetails, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel9)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel10)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel11)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnRun)
                            .addComponent(btnBrowse)))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 304, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(70, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnBrowseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBrowseActionPerformed
        // TODO add your handling code here:
        if (showTime) {
            show_assignment();
            showTime = false;
        } else {
            model.setRowCount(0);
            show_assignment();
        }
    }//GEN-LAST:event_btnBrowseActionPerformed

    private void btnMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMenuActionPerformed
        // TODO add your handling code here:
        showTime = true;
        dispose();
        if (role == 0){
            Welcome_Student.main(new String[]{});
        } else if (role == 1){
            Welcome_Staff.main(new String[]{});
        } else {
            Welcome_Admin.main(new String[]{});
        }
    }//GEN-LAST:event_btnMenuActionPerformed

    private void tableShowAssignmentMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableShowAssignmentMouseClicked
        // TODO add your handling code here:
        int i = tableShowAssignment.getSelectedRow();
        TableModel model = tableShowAssignment.getModel();
        txtAssignmentID.setText(model.getValueAt(i, 0).toString());
        txtStaffID.setText(model.getValueAt(i, 1).toString());
        txtSubjectID.setText(model.getValueAt(i, 2).toString());
        txtDetails.setText(model.getValueAt(i, 3).toString());
    }//GEN-LAST:event_tableShowAssignmentMouseClicked

    private void btnRunActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRunActionPerformed
        // TODO add your handling code here:
        if (comboboxWhatToDo.getSelectedItem() == null) {
            JOptionPane.showMessageDialog(null, "You need to choose an action!",
                    "Warning!", JOptionPane.WARNING_MESSAGE);
            return;
        }

        String doing = comboboxWhatToDo.getSelectedItem().toString();

        if (doing.equals("Add")){
            if (txtAssignmentID.getText().length() == 0 || txtStaffID.getText().length() == 0
                    || txtSubjectID.getText().length()==0 || txtDetails.getText().length() == 0) {
                JOptionPane.showMessageDialog(null, "No field can be empty!",
                        "Warning!", JOptionPane.WARNING_MESSAGE);
            } else {
                try {
                    if (Checking_Input_Data.Check("assignment_ID", txtAssignmentID.getText(),
                            "Classroom_assignments", false)){

                        Connection con = ConnectionClass.connection();
                        Statement statement;
                        ResultSet resultSet;

                        int userID;
                        if (role == 1){
                            String findStudent = "SELECT * FROM Staff WHERE staff_ID = "
                                    + txtStaffID.getText();
                            statement = con.createStatement();
                            resultSet = statement.executeQuery(findStudent);
                            if (resultSet.next()){
                                userID = resultSet.getInt("staff_ID");
                            } else {
                                return;
                            }
                            if (!(userID == real_ID)){
                                JOptionPane.showMessageDialog(null,
                                        "You're allowed to add your own information only! ",
                                        "Warning!", JOptionPane.WARNING_MESSAGE);
                                txtStaffID.selectAll();
                                txtStaffID.replaceSelection("");
                                return;
                            }
                        }

                        String checkValidStaffIDAndSubjectID =
                                "SELECT * FROM Class_allocation WHERE staff_ID = "
                                        + txtStaffID.getText()
                                        +" AND subject_ID = '"
                                        + txtSubjectID.getText()
                                        +"'";
                        statement = con.createStatement();
                        resultSet = statement.executeQuery(checkValidStaffIDAndSubjectID);
                        if (!resultSet.next()){
                            JOptionPane.showMessageDialog(null,
                                    "This Staff did not teach that Subject!", "Warning!",
                                    JOptionPane.WARNING_MESSAGE);
                            txtStaffID.selectAll();
                            txtStaffID.replaceSelection("");
                            txtSubjectID.selectAll();
                            txtSubjectID.replaceSelection("");
                            return;
                        }
                        con.close();

                        Connection connection = ConnectionClass.connection();
                        String insertQuery = "INSERT INTO Classroom_assignments VALUES (? ,?, ?, ? )";
                        PreparedStatement preparedStatement = connection.prepareStatement(insertQuery);
                        preparedStatement.setString(1, txtAssignmentID.getText());
                        preparedStatement.setString(2, txtStaffID.getText());
                        preparedStatement.setString(3, txtSubjectID.getText());
                        preparedStatement.setString(4, txtDetails.getText());
                        preparedStatement.executeUpdate();
                        if (showTime) {
                            show_assignment();
                            showTime = false;
                        } else {
                            model.setRowCount(0);
                            show_assignment();
                        }
                        JOptionPane.showMessageDialog(null, "Insert completed!");
                        connection.close();
                    }
                    else {
                        txtAssignmentID.selectAll();
                        txtAssignmentID.replaceSelection("");
                    }
                } catch (SQLException e){
                    JOptionPane.showMessageDialog(null, e);
                }
            }
        } else if (doing.equals("Update")) {
            if (txtAssignmentID.getText().length() == 0 || txtDetails.getText().length() == 0) {
                JOptionPane.showMessageDialog(null, "Assignment ID and Details cannot be empty!",
                        "Warning!", JOptionPane.WARNING_MESSAGE);
            } else {
                try {
                    if (!Checking_Input_Data.Check("assignment_ID", txtAssignmentID.getText(),
                            "Classroom_assignments", true)){
                        Connection connection = ConnectionClass.connection();

                        Statement statement;
                        ResultSet resultSet;
                        int staffID;
                        if (role == 1){
                            String findStaffID =
                                    "SELECT * FROM Classroom_assignments WHERE assignment_ID = "
                                            + txtAssignmentID.getText();
                            statement = connection.createStatement();
                            resultSet = statement.executeQuery(findStaffID);

                            if (resultSet.next()){
                                staffID = resultSet.getInt("staff_ID");
                            } else {
                                return;
                            }
                            System.out.println(staffID);
                            System.out.println(real_ID);
                            if (!(staffID == real_ID)){
                                JOptionPane.showMessageDialog(null,
                                        "You're allowed to update your own information only! ",
                                        "Warning!", JOptionPane.WARNING_MESSAGE);
                                System.out.println("USERNAME NOT YOU");
                                txtAssignmentID.selectAll();
                                txtAssignmentID.replaceSelection("");
                                return;
                            }
                        }
                        String updateQuery =
                                "UPDATE Classroom_assignments SET assignment_details=? WHERE assignment_ID = ?";
                        PreparedStatement preparedStatement = connection.prepareStatement(updateQuery);
                        preparedStatement.setString(1, txtDetails.getText());
                        preparedStatement.setString(2, txtAssignmentID.getText());
                        preparedStatement.executeUpdate();
                        if (showTime) {
                            show_assignment();
                            showTime = false;
                        } else {
                            model.setRowCount(0);
                            show_assignment();
                        }
                        JOptionPane.showMessageDialog(null,
                                "Update completed! \nTip: ID, Staff ID and Subject ID cannot be changed.");
                        connection.close();
                    } else {
                        txtAssignmentID.selectAll();
                        txtAssignmentID.replaceSelection("");
                    }
                } catch (SQLException e){
                    JOptionPane.showMessageDialog(null, e);
                }
            }
        } else if (doing.equals("Remove")) {
            if (txtAssignmentID.getText().length() == 0) {
                JOptionPane.showMessageDialog(null, "ID cannot be empty!",
                        "Warning!", JOptionPane.WARNING_MESSAGE);
            } else {
                try {
                    if (!Checking_Input_Data.Check("assignment_ID", txtAssignmentID.getText(), "Classroom_assignments", true)){
                        Connection connection = ConnectionClass.connection();

                        Statement statement;
                        ResultSet resultSet;
                        int staffID;
                        if (role == 1){
                            String findStaffID =
                                    "SELECT * FROM Classroom_assignments WHERE assignment_ID = "
                                            + txtAssignmentID.getText();
                            statement = connection.createStatement();
                            resultSet = statement.executeQuery(findStaffID);

                            if (resultSet.next()){
                                staffID = resultSet.getInt("staff_ID");
                            } else {
                                return;
                            }
                            System.out.println(staffID);
                            System.out.println(real_ID);
                            if (!(staffID == real_ID)){
                                JOptionPane.showMessageDialog(null,
                                        "You're allowed to remove your own information only! ",
                                        "Warning!", JOptionPane.WARNING_MESSAGE);
                                System.out.println("USERNAME NOT YOU");
                                txtAssignmentID.selectAll();
                                txtAssignmentID.replaceSelection("");
                                return;
                            }
                        }

                        String removeQuery =
                                "DELETE FROM Classroom_assignments WHERE assignment_ID = ?";
                        PreparedStatement preparedStatement = connection.prepareStatement(removeQuery);
                        preparedStatement.setString(1, txtAssignmentID.getText());
                        preparedStatement.executeUpdate();
                        if (showTime) {
                            show_assignment();
                            showTime = false;
                        } else {
                            model.setRowCount(0);
                            show_assignment();
                        }
                        JOptionPane.showMessageDialog(null, "Delete completed!");
                        connection.close();
                    } else {
                        txtAssignmentID.selectAll();
                        txtAssignmentID.replaceSelection("");
                    }
                } catch (SQLException e){
                    JOptionPane.showMessageDialog(null, e);
                }
            }
        }
    }//GEN-LAST:event_btnRunActionPerformed

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
            java.util.logging.Logger.getLogger(Classroom_Assignment.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Classroom_Assignment.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Classroom_Assignment.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Classroom_Assignment.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Classroom_Assignment().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBrowse;
    private javax.swing.JButton btnMenu;
    private javax.swing.JButton btnRun;
    private javax.swing.JComboBox<String> comboboxWhatToDo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tableShowAssignment;
    private javax.swing.JTextField txtAssignmentID;
    private javax.swing.JTextField txtDetails;
    private javax.swing.JTextField txtStaffID;
    private javax.swing.JTextField txtSubjectID;
    // End of variables declaration//GEN-END:variables
}
