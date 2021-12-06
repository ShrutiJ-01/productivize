/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.example.gui;

import java.awt.Color;
import javax.swing.BorderFactory;
import javax.swing.JOptionPane;
import javax.swing.border.Border;

import com.example.entites.Employee;
import com.example.entites.Manager;
import com.example.tabledao.Authenticate;

/**
 *
 * @author tanma
 */
public class RegisterationSystem extends javax.swing.JFrame {

    /**
     * Creates new form RegisterationSystem
     */

    // create borders
    Border default_top_border = BorderFactory.createMatteBorder(2, 0, 0, 0, new Color(202, 204, 204));
    Border red_top_border = BorderFactory.createMatteBorder(2, 0, 0, 0, Color.red);

    public RegisterationSystem() {
        initComponents();

        // center form
        this.setLocationRelativeTo(null);

        // set borders
        LabelEmployee.setBorder(default_top_border);
        LabelManager.setBorder(default_top_border);

        // call the jlabel mouse click event
        LabelEmployeeMouseClicked(null);

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated
    // Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        LabelRegistrationSystem = new javax.swing.JLabel();
        PanelRegistration = new javax.swing.JPanel();
        LabelEmployee = new javax.swing.JLabel();
        LabelManager = new javax.swing.JLabel();
        PanelEmployee = new javax.swing.JPanel();
        TFEmployeeName = new javax.swing.JTextField();
        PasswordFieldEmployee = new javax.swing.JPasswordField();
        ButtonEmployeeRegistration = new javax.swing.JButton();
        PanelManager = new javax.swing.JPanel();
        TFManagerName = new javax.swing.JTextField();
        PasswordFieldManager = new javax.swing.JPasswordField();
        ButtonManagerRegistration = new javax.swing.JButton();

        jLabel2.setText("jLabel2");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        LabelRegistrationSystem.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        LabelRegistrationSystem.setText("Create an account");

        LabelEmployee.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        LabelEmployee.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        LabelEmployee.setText("Employee");
        LabelEmployee.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                LabelEmployeeMouseClicked(evt);
            }
        });

        LabelManager.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        LabelManager.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        LabelManager.setText("Manager");
        LabelManager.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                LabelManagerMouseClicked(evt);
            }
        });

        TFEmployeeName.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        TFEmployeeName.setForeground(new java.awt.Color(153, 153, 153));
        TFEmployeeName.setText("First Name");
        TFEmployeeName.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                TFEmployeeNameFocusGained(evt);
            }

            public void focusLost(java.awt.event.FocusEvent evt) {
                TFEmployeeNameFocusLost(evt);
            }
        });

        PasswordFieldEmployee.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        PasswordFieldEmployee.setForeground(new java.awt.Color(153, 153, 153));
        PasswordFieldEmployee.setText("password");
        PasswordFieldEmployee.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                PasswordFieldEmployeeFocusGained(evt);
            }

            public void focusLost(java.awt.event.FocusEvent evt) {
                PasswordFieldEmployeeFocusLost(evt);
            }
        });

        ButtonEmployeeRegistration.setText("Register");
        ButtonEmployeeRegistration.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonEmployeeRegistrationActionPerformed(TFEmployeeName.getText(),
                        String.valueOf(PasswordFieldEmployee.getPassword()));
            }
        });

        javax.swing.GroupLayout PanelEmployeeLayout = new javax.swing.GroupLayout(PanelEmployee);
        PanelEmployee.setLayout(PanelEmployeeLayout);
        PanelEmployeeLayout.setHorizontalGroup(
                PanelEmployeeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(PanelEmployeeLayout.createSequentialGroup()
                                .addGap(55, 55, 55)
                                .addGroup(PanelEmployeeLayout
                                        .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(ButtonEmployeeRegistration, javax.swing.GroupLayout.DEFAULT_SIZE,
                                                212, Short.MAX_VALUE)
                                        .addComponent(PasswordFieldEmployee)
                                        .addComponent(TFEmployeeName, javax.swing.GroupLayout.DEFAULT_SIZE, 212,
                                                Short.MAX_VALUE))
                                .addContainerGap(65, Short.MAX_VALUE)));
        PanelEmployeeLayout.setVerticalGroup(
                PanelEmployeeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(PanelEmployeeLayout.createSequentialGroup()
                                .addGap(37, 37, 37)
                                .addComponent(TFEmployeeName, javax.swing.GroupLayout.PREFERRED_SIZE, 37,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(PasswordFieldEmployee, javax.swing.GroupLayout.PREFERRED_SIZE, 36,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(33, 33, 33)
                                .addComponent(ButtonEmployeeRegistration, javax.swing.GroupLayout.PREFERRED_SIZE, 38,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(37, Short.MAX_VALUE)));

        PanelManager.setMinimumSize(new java.awt.Dimension(100, 100));

        TFManagerName.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        TFManagerName.setForeground(new java.awt.Color(153, 153, 153));
        TFManagerName.setText("First Name");
        TFManagerName.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                TFManagerNameFocusGained(evt);
            }

            public void focusLost(java.awt.event.FocusEvent evt) {
                TFManagerNameFocusLost(evt);
            }
        });

        PasswordFieldManager.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        PasswordFieldManager.setForeground(new java.awt.Color(153, 153, 153));
        PasswordFieldManager.setText("password");
        PasswordFieldManager.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                PasswordFieldManagerFocusGained(evt);
            }

            public void focusLost(java.awt.event.FocusEvent evt) {
                PasswordFieldManagerFocusLost(evt);
            }
        });

        ButtonManagerRegistration.setText("Register");
        ButtonManagerRegistration.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonManagerRegistrationActionPerformed(TFManagerName.getText(),
                        String.valueOf(PasswordFieldManager.getPassword()));
            }
        });

        javax.swing.GroupLayout PanelManagerLayout = new javax.swing.GroupLayout(PanelManager);
        PanelManager.setLayout(PanelManagerLayout);
        PanelManagerLayout.setHorizontalGroup(
                PanelManagerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelManagerLayout.createSequentialGroup()
                                .addContainerGap(58, Short.MAX_VALUE)
                                .addGroup(PanelManagerLayout
                                        .createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(ButtonManagerRegistration, javax.swing.GroupLayout.DEFAULT_SIZE,
                                                javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(TFManagerName)
                                        .addComponent(PasswordFieldManager, javax.swing.GroupLayout.DEFAULT_SIZE, 217,
                                                Short.MAX_VALUE))
                                .addGap(58, 58, 58)));
        PanelManagerLayout.setVerticalGroup(
                PanelManagerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(PanelManagerLayout.createSequentialGroup()
                                .addGap(45, 45, 45)
                                .addComponent(TFManagerName, javax.swing.GroupLayout.PREFERRED_SIZE, 37,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(PasswordFieldManager, javax.swing.GroupLayout.PREFERRED_SIZE, 36,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(27, 27, 27)
                                .addComponent(ButtonManagerRegistration, javax.swing.GroupLayout.PREFERRED_SIZE, 35,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(38, Short.MAX_VALUE)));

        javax.swing.GroupLayout PanelRegistrationLayout = new javax.swing.GroupLayout(PanelRegistration);
        PanelRegistration.setLayout(PanelRegistrationLayout);
        PanelRegistrationLayout.setHorizontalGroup(
                PanelRegistrationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(PanelRegistrationLayout.createSequentialGroup()
                                .addGap(22, 22, 22)
                                .addComponent(LabelEmployee, javax.swing.GroupLayout.PREFERRED_SIZE, 137,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED,
                                        javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(LabelManager, javax.swing.GroupLayout.PREFERRED_SIZE, 137,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(32, 32, 32))
                        .addGroup(PanelRegistrationLayout.createSequentialGroup()
                                .addGap(49, 49, 49)
                                .addComponent(PanelEmployee, javax.swing.GroupLayout.PREFERRED_SIZE,
                                        javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(50, Short.MAX_VALUE))
                        .addGroup(PanelRegistrationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING,
                                        PanelRegistrationLayout.createSequentialGroup()
                                                .addContainerGap(46, Short.MAX_VALUE)
                                                .addComponent(PanelManager, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                        javax.swing.GroupLayout.DEFAULT_SIZE,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addContainerGap(52, Short.MAX_VALUE))));
        PanelRegistrationLayout.setVerticalGroup(
                PanelRegistrationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(PanelRegistrationLayout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(PanelRegistrationLayout
                                        .createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(LabelEmployee, javax.swing.GroupLayout.PREFERRED_SIZE, 44,
                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(LabelManager, javax.swing.GroupLayout.PREFERRED_SIZE, 44,
                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(PanelEmployee, javax.swing.GroupLayout.PREFERRED_SIZE,
                                        javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 25, Short.MAX_VALUE))
                        .addGroup(PanelRegistrationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING,
                                        PanelRegistrationLayout.createSequentialGroup()
                                                .addContainerGap(60, Short.MAX_VALUE)
                                                .addComponent(PanelManager, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                        javax.swing.GroupLayout.DEFAULT_SIZE,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addContainerGap(26, Short.MAX_VALUE))));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(144, 144, 144)
                                .addComponent(LabelRegistrationSystem)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addComponent(PanelRegistration, javax.swing.GroupLayout.DEFAULT_SIZE,
                                javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE));
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(LabelRegistrationSystem)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(PanelRegistration, javax.swing.GroupLayout.PREFERRED_SIZE,
                                        javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void LabelEmployeeMouseClicked(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_LabelEmployeeMouseClicked
        // display the employee panel
        PanelEmployee.setVisible(true);
        PanelManager.setVisible(false);

        // design the Employee Label [on-click]
        LabelEmployee.setBorder(red_top_border);
        LabelEmployee.setBackground(Color.black);
        LabelEmployee.setForeground(Color.black);

        // design the Manager Label [on-click]
        LabelManager.setBorder(default_top_border);
        LabelManager.setBackground(Color.black);
        LabelManager.setForeground(Color.black);
    }// GEN-LAST:event_LabelEmployeeMouseClicked

    private void LabelManagerMouseClicked(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_LabelManagerMouseClicked
        // display the manager panel
        PanelManager.setVisible(true);
        PanelEmployee.setVisible(false);

        // design the Manager Label [on-click]
        LabelManager.setBorder(red_top_border);
        LabelManager.setBackground(Color.black);
        LabelManager.setForeground(Color.black);

        // design the Employee Label [on-click]
        LabelEmployee.setBorder(default_top_border);
        LabelEmployee.setBackground(Color.black);
        LabelEmployee.setForeground(Color.black);
    }// GEN-LAST:event_LabelManagerMouseClicked

    private void TFEmployeeNameFocusGained(java.awt.event.FocusEvent evt) {// GEN-FIRST:event_TFEmployeeNameFocusGained
        // if the EmployeeName text = employeename
        // clear the textfield
        String employeenameValue = TFEmployeeName.getText().trim().toLowerCase();

        if (employeenameValue.equals("employeename")) {
            TFEmployeeName.setText("");
            TFEmployeeName.setForeground(Color.black);
        }

    }// GEN-LAST:event_TFEmployeeNameFocusGained

    private void TFEmployeeNameFocusLost(java.awt.event.FocusEvent evt) {// GEN-FIRST:event_TFEmployeeNameFocusLost
        // if the textfield is empty -> set the text to 'employeename'
        String employeenameValue = TFEmployeeName.getText().trim().toLowerCase();

        if (employeenameValue.equals("employeename") || employeenameValue.equals("")) {
            TFEmployeeName.setText("employeename");
            TFEmployeeName.setForeground(new Color(153, 153, 153));
        }
    }// GEN-LAST:event_TFEmployeeNameFocusLost

    private void PasswordFieldEmployeeFocusGained(java.awt.event.FocusEvent evt) {// GEN-FIRST:event_PasswordFieldEmployeeFocusGained
        // if the PasswordFieldEmployee field = password
        // clear the field
        String passValue = String.valueOf(PasswordFieldEmployee.getPassword()).trim().toLowerCase();

        if (passValue.equals("password")) {
            PasswordFieldEmployee.setText("");
            PasswordFieldEmployee.setForeground(Color.black);
        }
    }// GEN-LAST:event_PasswordFieldEmployeeFocusGained

    private void PasswordFieldEmployeeFocusLost(java.awt.event.FocusEvent evt) {// GEN-FIRST:event_PasswordFieldEmployeeFocusLost
        // if the textfield is empty -> set the text to 'password'
        String passValue = String.valueOf(PasswordFieldEmployee.getPassword()).trim().toLowerCase();

        if (passValue.equals("password") || passValue.equals("")) {
            PasswordFieldEmployee.setText("password");
            PasswordFieldEmployee.setForeground(new Color(153, 153, 153));
        }
    }// GEN-LAST:event_PasswordFieldEmployeeFocusLost

    private void TFManagerNameFocusGained(java.awt.event.FocusEvent evt) {// GEN-FIRST:event_TFManagerNameFocusGained
        // if the ManagerName text = managername
        // clear the textfield
        String managernameValue = TFManagerName.getText().trim().toLowerCase();

        if (managernameValue.equals("managername")) {
            TFManagerName.setText("");
            TFManagerName.setForeground(Color.black);
        }
    }// GEN-LAST:event_TFManagerNameFocusGained

    private void TFManagerNameFocusLost(java.awt.event.FocusEvent evt) {// GEN-FIRST:event_TFManagerNameFocusLost
        // if the textfield is empty -> set the text to 'managername'
        String managernameValue = TFManagerName.getText().trim().toLowerCase();

        if (managernameValue.equals("managername") || managernameValue.equals("")) {
            TFManagerName.setText("managername");
            TFManagerName.setForeground(new Color(153, 153, 153));
        }
    }// GEN-LAST:event_TFManagerNameFocusLost

    private void PasswordFieldManagerFocusGained(java.awt.event.FocusEvent evt) {// GEN-FIRST:event_PasswordFieldManagerFocusGained
        // if the PasswordFieldManager field = password
        // clear the field
        String passValue = String.valueOf(PasswordFieldManager.getPassword()).trim().toLowerCase();

        if (passValue.equals("password")) {
            PasswordFieldManager.setText("");
            PasswordFieldManager.setForeground(Color.black);
        }
    }// GEN-LAST:event_PasswordFieldManagerFocusGained

    private void PasswordFieldManagerFocusLost(java.awt.event.FocusEvent evt) {// GEN-FIRST:event_PasswordFieldManagerFocusLost
        // if the textfield is empty -> set the text to 'password'
        String passValue = String.valueOf(PasswordFieldManager.getPassword()).trim().toLowerCase();

        if (passValue.equals("password") || passValue.equals("")) {
            PasswordFieldManager.setText("password");
            PasswordFieldManager.setForeground(new Color(153, 153, 153));
        }
    }// GEN-LAST:event_PasswordFieldManagerFocusLost

    private void ButtonManagerRegistrationActionPerformed(String name, String password) {
        name = name.trim();
        String[] managerName = name.split(" ", 2);
        try {
            Manager registeredManager = authentication.registerManager(managerName[0], managerName[1], password);
            System.out.println(" registered Id is : " + registeredManager.id);
            JOptionPane.showMessageDialog(null, "your manager Id is : " + registeredManager.id
                    + " \n Please login with this Manager Id and password again");
            dispose();// dispose pf registration window
            LoginSystem.build();// build the login UI
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }

    }

    private void ButtonEmployeeRegistrationActionPerformed(String name, String password) {
        name = name.trim();
        String[] employeeName = name.split(" ", 2);
        try {
            Employee registeredEmployee = authentication.registerEmployee(employeeName[0], employeeName[1], password);
            System.out.println(" registered Id is : " + registeredEmployee.id);
            JOptionPane.showMessageDialog(null, "your employee Id is : " + registeredEmployee.id
                    + " \n Please login with this Employee Id and password again");
            dispose();// dispose pf registration window
            LoginSystem.build();// build the login UI
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        // <editor-fold defaultstate="collapsed" desc=" Look and feel setting code
        // (optional) ">
        /*
         * If Nimbus (introduced in Java SE 6) is not available, stay with the default
         * look and feel.
         * For details see
         * http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(RegisterationSystem.class.getName()).log(java.util.logging.Level.SEVERE,
                    null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(RegisterationSystem.class.getName()).log(java.util.logging.Level.SEVERE,
                    null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(RegisterationSystem.class.getName()).log(java.util.logging.Level.SEVERE,
                    null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(RegisterationSystem.class.getName()).log(java.util.logging.Level.SEVERE,
                    null, ex);
        }
        // </editor-fold>
        // </editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new RegisterationSystem().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton ButtonEmployeeRegistration;
    private javax.swing.JButton ButtonManagerRegistration;
    private javax.swing.JLabel LabelEmployee;
    private javax.swing.JLabel LabelManager;
    private javax.swing.JLabel LabelRegistrationSystem;
    private javax.swing.JPanel PanelEmployee;
    private javax.swing.JPanel PanelManager;
    private javax.swing.JPanel PanelRegistration;
    private javax.swing.JPasswordField PasswordFieldEmployee;
    private javax.swing.JPasswordField PasswordFieldManager;
    private javax.swing.JTextField TFEmployeeName;
    private javax.swing.JTextField TFManagerName;
    private javax.swing.JLabel jLabel2;
    private Authenticate authentication = new Authenticate();
    // End of variables declaration//GEN-END:variables
}