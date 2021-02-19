/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package schoool.management.system.Manipulate_Group;

import schoool.management.system.Tool_Group.Checking_Input_Data;
import schoool.management.system.Tool_Group.ConnectionClass;
import schoool.management.system.Menu_Group.Welcome_Admin;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import java.sql.*;
import java.util.ArrayList;

/**
 *
 * @author PC
 */
public class Manipulate_A_Subject extends javax.swing.JFrame {
    DefaultTableModel model;
    private static boolean showTime = true;
    /**
     * Creates new form Manipulate_A_Subject
     */
    public Manipulate_A_Subject() {
        JLabel background = new JLabel(new ImageIcon("src/images/school theme 3.1.jpg"));
        setContentPane(background);
        initComponents();
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
    }

    public ArrayList<Subject> subjectArrayList(){
        ArrayList<Subject> subjectArrayList = new ArrayList<>();
        try
        {
            Connection connection = ConnectionClass.connection();
            String sql = "SELECT * FROM Subject";
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery(sql);
            Subject subject;
            while (rs.next()) {
                subject = new Subject(
                        rs.getString("subject_ID"),
                        rs.getString("subject_name"),
                        rs.getInt("subject_group"));
                subjectArrayList.add(subject);
            }
            connection.close();
        }
        catch (SQLException e) {
            JOptionPane.showMessageDialog(null,e);
        }
        return subjectArrayList;
    }

    public void show_subject() {
        ArrayList<Subject>  list = subjectArrayList();
        model = (DefaultTableModel)tableShowSubject.getModel();
        Object[] row = new Object[3];
        for (int i=0; i<list.size();i++){
            row[0] = list.get(i).getSubject_ID();
            row[1] = list.get(i).getSubject_name();
            row[2] = list.get(i).getSubject_group();
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

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtID = new javax.swing.JTextField();
        txtName = new javax.swing.JTextField();
        txtGroup = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        comboWhatToDo = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        btnShowSubjects = new javax.swing.JButton();
        btnRun = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableShowSubject = new javax.swing.JTable();
        btnMenu = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Microsoft JhengHei Light", 0, 18)); // NOI18N
        jLabel1.setText("Manipulate a subject");

        jLabel2.setFont(new java.awt.Font("Microsoft JhengHei Light", 0, 14)); // NOI18N
        jLabel2.setText("ID:");

        jLabel3.setFont(new java.awt.Font("Microsoft JhengHei Light", 0, 14)); // NOI18N
        jLabel3.setText("Name:");

        jLabel4.setFont(new java.awt.Font("Microsoft JhengHei Light", 0, 14)); // NOI18N
        jLabel4.setText("Group:");

        txtID.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtIDActionPerformed(evt);
            }
        });

        txtName.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        txtGroup.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jLabel5.setFont(new java.awt.Font("Microsoft JhengHei Light", 0, 14)); // NOI18N
        jLabel5.setText("What to do:");

        comboWhatToDo.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        comboWhatToDo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Add", "Remove", "Update" }));
        comboWhatToDo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboWhatToDoActionPerformed(evt);
            }
        });

        jLabel6.setText("Note: ");

        btnShowSubjects.setFont(new java.awt.Font("Microsoft JhengHei Light", 0, 14)); // NOI18N
        btnShowSubjects.setText("Show Subjects");
        btnShowSubjects.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnShowSubjectsActionPerformed(evt);
            }
        });

        btnRun.setFont(new java.awt.Font("Microsoft JhengHei Light", 0, 14)); // NOI18N
        btnRun.setText("Run");
        btnRun.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRunActionPerformed(evt);
            }
        });

        jLabel7.setText("- When add a Subject, the Subject ID must be unique in the subject list.");

        jLabel8.setText("- Click a \"Show Subjects\" button to see which IDs have been created.");

        jLabel9.setText("- If you want to delete a subject, just fill the correct Subject ID and Run.");

        tableShowSubject.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Name", "Group"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tableShowSubject.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableShowSubjectMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tableShowSubject);

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
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnMenu)
                        .addGap(259, 259, 259)
                        .addComponent(jLabel1)
                        .addContainerGap(330, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(comboWhatToDo, 0, 288, Short.MAX_VALUE)
                                    .addComponent(txtID)
                                    .addComponent(txtName)
                                    .addComponent(txtGroup)))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(btnShowSubjects)
                                .addGap(191, 191, 191)
                                .addComponent(btnRun))
                            .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 365, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(20, 20, 20))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(46, 46, 46)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(btnMenu))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(comboWhatToDo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(txtID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(txtGroup, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 13, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel9)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnShowSubjects)
                            .addComponent(btnRun)))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 299, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(53, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void comboWhatToDoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboWhatToDoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_comboWhatToDoActionPerformed

    private void txtIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtIDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtIDActionPerformed

    private void btnShowSubjectsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnShowSubjectsActionPerformed
        // TODO add your handling code here:
        if (showTime) {
            show_subject();
            showTime = false;
        } else {
            model.setRowCount(0);
            show_subject();
        }
    }//GEN-LAST:event_btnShowSubjectsActionPerformed

    private void btnRunActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRunActionPerformed
        // TODO add your handling code here:
        if (comboWhatToDo.getSelectedItem() == null) {
            JOptionPane.showMessageDialog(null, "You need to choose an action!",
                    "Warning!", JOptionPane.WARNING_MESSAGE);
            return;
        }

        String doing = comboWhatToDo.getSelectedItem().toString();

        if (doing.equals("Add")){
            if (txtID.getText().length() == 0 || txtName.getText().length() == 0
                    || txtGroup.getText().length() == 0) {
                JOptionPane.showMessageDialog(null, "No field can be empty!",
                        "Warning!", JOptionPane.WARNING_MESSAGE);
            } else {
                try {
                    if (Checking_Input_Data.Check("subject_ID", txtID.getText(), "Subject", false)){
                        Connection connection = ConnectionClass.connection();
                        String insertQuery = "INSERT INTO Subject VALUES (? ,? ,? )";
                        PreparedStatement preparedStatement = connection.prepareStatement(insertQuery);
                        preparedStatement.setString(1, txtID.getText());
                        preparedStatement.setString(2, txtName.getText());
                        preparedStatement.setString(3, txtGroup.getText());
                        preparedStatement.executeUpdate();
                        if (showTime) {
                            show_subject();
                            showTime = false;
                        } else {
                            model.setRowCount(0);
                            show_subject();
                        }
                        JOptionPane.showMessageDialog(null, "Insert completed!");
                        connection.close();
                    } else {
                        txtID.selectAll();;
                        txtID.replaceSelection("");
                    }
                } catch (SQLException e){
                    JOptionPane.showMessageDialog(null, e);
                }
            }
        } else if (doing.equals("Update")){
            if (txtID.getText().length() == 0 || txtName.getText().length() == 0
                    || txtGroup.getText().length() == 0) {
                JOptionPane.showMessageDialog(null, "No field can be empty!",
                        "Warning!", JOptionPane.WARNING_MESSAGE);
            } else {
                try {
                    if (!Checking_Input_Data.Check("subject_ID", txtID.getText(), "Subject", true)){
                        Connection connection = ConnectionClass.connection();
                        String updateQuery =
                                "UPDATE Subject SET subject_name = ?, subject_group = ? WHERE subject_ID = ?";
                        PreparedStatement preparedStatement = connection.prepareStatement(updateQuery);
                        preparedStatement.setString(3, txtID.getText());
                        preparedStatement.setString(1, txtName.getText());
                        preparedStatement.setString(2, txtGroup.getText());
                        preparedStatement.executeUpdate();
                        if (showTime) {
                            show_subject();
                            showTime = false;
                        } else {
                            model.setRowCount(0);
                            show_subject();
                        }
                        JOptionPane.showMessageDialog(null, "Update completed! Tip: ID cannot be changed.");
                        connection.close();
                    } else {
                        txtID.selectAll();;
                        txtID.replaceSelection("");
                    }
                } catch (SQLException e){
                    JOptionPane.showMessageDialog(null, e);
                }
            }
        } else if (doing.equals("Remove")){
            if (txtID.getText().length() == 0){
                JOptionPane.showMessageDialog(null, "ID cannot be empty!",
                        "Warning!", JOptionPane.WARNING_MESSAGE);
            } else {
                try {
                    if (!Checking_Input_Data.Check("subject_ID", txtID.getText(), "Subject", true)){
                        Connection connection = ConnectionClass.connection();
                        String deleteQuery =
                                "DELETE FROM Subject WHERE subject_ID = ?";
                        PreparedStatement preparedStatement = connection.prepareStatement(deleteQuery);
                        preparedStatement.setString(1, txtID.getText());
                        preparedStatement.executeUpdate();
                        if (showTime) {
                            show_subject();
                            showTime = false;
                        } else {
                            model.setRowCount(0);
                            show_subject();
                        }
                        JOptionPane.showMessageDialog(null, "Delete completed!");
                        connection.close();
                    } else {
                        txtID.selectAll();;
                        txtID.replaceSelection("");
                    }
                } catch (SQLException e) {
                    JOptionPane.showMessageDialog(null, e);
                }
            }
        }
    }//GEN-LAST:event_btnRunActionPerformed

    private void btnMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMenuActionPerformed
        // TODO add your handling code here:
        showTime = true;
        dispose();
        Welcome_Admin.main(new String[]{});
    }//GEN-LAST:event_btnMenuActionPerformed

    private void tableShowSubjectMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableShowSubjectMouseClicked
        // TODO add your handling code here:
        int i = tableShowSubject.getSelectedRow();
        TableModel model = tableShowSubject.getModel();
        txtID.setText(model.getValueAt(i, 0).toString());
        txtName.setText(model.getValueAt(i, 1).toString());
        txtGroup.setText(model.getValueAt(i,2).toString());
    }//GEN-LAST:event_tableShowSubjectMouseClicked

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
            java.util.logging.Logger.getLogger(Manipulate_A_Subject.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Manipulate_A_Subject.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Manipulate_A_Subject.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Manipulate_A_Subject.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Manipulate_A_Subject().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnMenu;
    private javax.swing.JButton btnRun;
    private javax.swing.JButton btnShowSubjects;
    private javax.swing.JComboBox<String> comboWhatToDo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tableShowSubject;
    private javax.swing.JTextField txtGroup;
    private javax.swing.JTextField txtID;
    private javax.swing.JTextField txtName;
    // End of variables declaration//GEN-END:variables
}
