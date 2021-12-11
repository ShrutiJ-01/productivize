package com.example.gui;

import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

import com.example.entites.Employee;
import com.example.entites.Worklog;
import com.example.services.Utilities;
import com.example.tabledao.TaskDao;
import com.example.tabledao.WorklogDao;
import com.example.viewsdao.EmployeeTaskView;
import com.example.viewsdao.EmployeeWorklogView;
//first and last name conjugated in tasks tabel
//autofill textfield values for edit and add based on row selection
//worklog table displays worklogs of task selecte

public class EmployeeDashboard extends javax.swing.JFrame {

    DefaultTableModel model;

    public EmployeeDashboard(Employee loggedInEmployee) {
        employee = loggedInEmployee;
        initComponents();

    }

    @SuppressWarnings("unchecked")

    private void initComponents() {

        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jScrollPane4 = new javax.swing.JScrollPane();
        jList1 = new javax.swing.JList<>();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        ButtonEditTask = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        TFEmpID = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTable3 = new javax.swing.JTable();
        ButtonAddLog = new javax.swing.JButton();
        ButtonEditLog = new javax.swing.JButton();
        ButtonDeleteLog = new javax.swing.JButton();
        ComboBoxTaskStatus = new javax.swing.JComboBox<>();

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
                new Object[][] {
                        { null, null, null, null },
                        { null, null, null, null },
                        { null, null, null, null },
                        { null, null, null, null }
                },
                new String[] {
                        "Title 1", "Title 2", "Title 3", "Title 4"
                }));
        jScrollPane2.setViewportView(jTable2);

        jList1.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };

            public int getSize() {
                return strings.length;
            }

            public String getElementAt(int i) {
                return strings[i];
            }
        });
        jScrollPane4.setViewportView(jList1);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Times New Roman", 0, 36)); // NOI18N
        jLabel1.setText("Hello " + employee.first_name + "!");

        jLabel2.setText("Employee ID:");

        ButtonEditTask.setText("Edit a task");
        ButtonEditTask.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonEditTaskActionPerformed(evt);
            }
        });

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
                Utilities.parseToObjectArray(employeeTaskView.getTodoTasks(employee.id)),
                new String[] {
                        "Task ID", "Task name", "Project ID", "Project name", "Milestones"
                }) {
            boolean[] canEdit = new boolean[] {
                    false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit[columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTable1);
        // setup selection model for task table
        ListSelectionModel taskSelectionModel = jTable1.getSelectionModel();
        taskSelectionModel.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);

        taskSelectionModel.addListSelectionListener(new ListSelectionListener() {
            public void valueChanged(ListSelectionEvent e) {
                if (jTable1.getSelectedRow() > -1) {
                    // store taskid of selected row
                    selectedTaskId = jTable1.getValueAt(jTable1.getSelectedRow(), 0).toString();
                    selectedProjectid = jTable1.getValueAt(jTable1.getSelectedRow(), 2).toString();
                    // build worklogs
                    buildWorklogTable();
                }
            }
        });

        TFEmpID.setEditable(false);
        TFEmpID.setText(" " + employee.id);

        jLabel3.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel3.setText("Your Tasks");

        jLabel4.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel4.setText("Recent Worklog");

        buildWorklogTable();
        jScrollPane3.setViewportView(jTable3);
        // setup selection model for worklog table
        ListSelectionModel worklogSelectionModel = jTable3.getSelectionModel();
        worklogSelectionModel.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);

        worklogSelectionModel.addListSelectionListener(new ListSelectionListener() {
            public void valueChanged(ListSelectionEvent e) {
                if (jTable3.getSelectedRow() > -1) {
                    // store taskid of selected row
                    selectedWorklogId = jTable3.getValueAt(jTable3.getSelectedRow(), 0).toString();
                }
            }
        });

        ButtonAddLog.setText("Add a log");
        ButtonAddLog.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonAddLogActionPerformed(evt);
            }
        });

        ButtonEditLog.setText("Edit a log");
        ButtonEditLog.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonEditLogActionPerformed(evt);
            }
        });

        ButtonDeleteLog.setText("Delete a log");
        ButtonDeleteLog.setMaximumSize(new java.awt.Dimension(83, 23));
        ButtonDeleteLog.setMinimumSize(new java.awt.Dimension(83, 23));
        ButtonDeleteLog.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonDeleteLogActionPerformed(evt);
            }
        });

        ComboBoxTaskStatus
                .setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "To do", "Doing", "Completed" }));
        ComboBoxTaskStatus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buildTaskTableForPickedFilter();
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(33, 33, 33)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 955,
                                                Short.MAX_VALUE)
                                        .addComponent(jScrollPane1)
                                        .addGroup(layout.createSequentialGroup()
                                                .addComponent(jLabel3)
                                                .addGap(18, 18, 18)
                                                .addComponent(ComboBoxTaskStatus,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE, 82,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED,
                                                        javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(ButtonEditTask, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                        83, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(layout.createSequentialGroup()
                                                .addComponent(jLabel1)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED,
                                                        javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(jLabel2)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(TFEmpID, javax.swing.GroupLayout.PREFERRED_SIZE, 69,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(layout.createSequentialGroup()
                                                .addComponent(jLabel4)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED,
                                                        javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(ButtonAddLog)
                                                .addGap(18, 18, 18)
                                                .addComponent(ButtonEditLog, javax.swing.GroupLayout.PREFERRED_SIZE, 83,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(14, 14, 14)
                                                .addComponent(ButtonDeleteLog, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                        javax.swing.GroupLayout.DEFAULT_SIZE,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(36, 36, 36)));
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(31, 31, 31)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel1)
                                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 22,
                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(TFEmpID, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(34, 34, 34)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel3)
                                        .addComponent(ButtonEditTask)
                                        .addComponent(ComboBoxTaskStatus, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(28, 28, 28)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 108,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(71, 71, 71)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel4)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                .addComponent(ButtonAddLog)
                                                .addComponent(ButtonEditLog)
                                                .addComponent(ButtonDeleteLog, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                        javax.swing.GroupLayout.DEFAULT_SIZE,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(31, 31, 31)
                                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 109,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(45, Short.MAX_VALUE)));

        pack();
    }

    private void ButtonAddLogActionPerformed(java.awt.event.ActionEvent evt) {
        JTextField workdone = new JTextField();
        JTextField taskid = new JTextField(selectedTaskId);
        JTextField projectId = new JTextField(selectedProjectid);
        final JComponent[] inputs = new JComponent[] {
                new JLabel("Work done"),
                workdone,
                new JLabel("Task ID"),
                taskid,
                new JLabel("Project ID"),
                projectId,
        };
        int response = JOptionPane.showConfirmDialog(null, inputs, "Add a log", JOptionPane.OK_CANCEL_OPTION,
                JOptionPane.PLAIN_MESSAGE);
        // 0=ok, 2=cancel
        if (response == 0) {

            if (workdone.getText().isEmpty() || taskid.getText().isEmpty() || projectId.getText().isEmpty()) {// check
                                                                                                              // validatoins
                JOptionPane.showMessageDialog(null, "Please Enter all feilds !");

            } else {// if no feilds are empty
                try {
                    boolean isInserted = worklogDao.insert(new Worklog(Integer.valueOf(taskid.getText()),
                            Integer.valueOf(projectId.getText()), workdone.getText(), employee.id));
                    if (isInserted) {
                        JOptionPane.showMessageDialog(null, "Added log!");

                        // rebuild table
                        buildWorklogTable();
                    } else {
                        JOptionPane.showMessageDialog(null, " Could not Insert Worklog !");
                    }
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, e.getMessage());
                }

            }

        }
    }

    private void ButtonEditLogActionPerformed(java.awt.event.ActionEvent evt) {
        JTextField id = new JTextField(selectedWorklogId);
        JTextField workdone = new JTextField();
        JTextField taskid = new JTextField(selectedTaskId);
        JTextField projectid = new JTextField(selectedProjectid);
        final JComponent[] inputs = new JComponent[] {
                new JLabel("Worklog ID"),
                id,
                new JLabel("Work done"),
                workdone,
                new JLabel("Task ID"),
                taskid,
                new JLabel("Project ID"),
                projectid,
        };
        // response is 0 if OK is clicked, 2 if CANCEL is clicked
        int response = JOptionPane.showConfirmDialog(null, inputs, "Edit a log", JOptionPane.OK_CANCEL_OPTION,
                JOptionPane.PLAIN_MESSAGE);
        if (response == 0) {
            if (workdone.getText().isEmpty() || taskid.getText().isEmpty() || projectid.getText().isEmpty()
                    || id.getText().isEmpty()) {// validation of feilds
                JOptionPane.showMessageDialog(null, "Please Enter all feilds !");

            } else {// if all feilds are valid

                boolean isUpdated = worklogDao
                        .update(new Worklog(Integer.valueOf(id.getText()), Integer.valueOf(taskid.getText()),
                                Integer.valueOf(projectid.getText()), workdone.getText(), employee.id));
                if (isUpdated) {
                    JOptionPane.showMessageDialog(null, "Edited Worklog!");
                    // rebuild table
                    buildWorklogTable();
                } else {
                    JOptionPane.showMessageDialog(null, "Could not edit Worklog");
                }
            }

        }
    }// GEN-LAST:event_ButtonEditLogActionPerformed

    private void ButtonDeleteLogActionPerformed(java.awt.event.ActionEvent evt) {
        JTextField id = new JTextField(selectedWorklogId);

        final JComponent[] inputs = new JComponent[] {
                new JLabel("Worklog ID"),
                id,

        };
        // response is 0 if OK is clicked, 2 if CANCEL is clicked
        int response = JOptionPane.showConfirmDialog(null, inputs, "Delete a log", JOptionPane.OK_CANCEL_OPTION,
                JOptionPane.PLAIN_MESSAGE);
        if (response == 0) {

            if (id.getText().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Please Enter all feilds !");
            } else {

                boolean isDeleted = worklogDao.delete(Integer.valueOf(id.getText()));
                if (isDeleted) {
                    JOptionPane.showMessageDialog(null, "Deleted Worklog!");
                    // rebuild table
                    buildWorklogTable();
                } else {
                    JOptionPane.showMessageDialog(null, "Could not delete Worklog");
                }
            }

        }
    }

    private void ButtonEditTaskActionPerformed(java.awt.event.ActionEvent evt) {
        JTextField taskid = new JTextField(selectedTaskId);
        JTextField taskStatus = new JTextField();

        final JComponent[] inputs = new JComponent[] {
                new JLabel("Task ID"),
                taskid,
                new JLabel("New Task Status"),
                taskStatus
        };
        int response = JOptionPane.showConfirmDialog(null, inputs, "Update task Status", JOptionPane.OK_CANCEL_OPTION,
                JOptionPane.PLAIN_MESSAGE);
        if (response == 0) {

            if (taskStatus.getText().isEmpty() || taskid.getText().isEmpty()) {// validation of feilds
                JOptionPane.showMessageDialog(null, "Please Enter all feilds !");

            } else {// if feilds are validated
                boolean isUpdated = taskDao.update(Integer.valueOf(taskid.getText()),
                        Integer.valueOf(taskStatus.getText()));
                if (isUpdated) {
                    JOptionPane.showMessageDialog(null, "Updated task Status!");
                    // rebuild table
                    buildTaskTableForPickedFilter();
                } else {
                    JOptionPane.showMessageDialog(null, "Could'nt update task status!");
                }

            }

        }
    }

    private void buildTaskTableForPickedFilter() {
        int choice = ComboBoxTaskStatus.getSelectedIndex();
        switch (choice) {
            case 0:
                jTable1.setModel(new javax.swing.table.DefaultTableModel(
                        Utilities.parseToObjectArray(employeeTaskView.getTodoTasks(employee.id)),
                        new String[] {
                                "Task ID", "Task name", "Project ID", "Project name", "Milestones"
                        }) {
                    boolean[] canEdit = new boolean[] {
                            false, false, false, false, false
                    };

                    public boolean isCellEditable(int rowIndex, int columnIndex) {
                        return canEdit[columnIndex];
                    }
                });
                break;

            case 1:
                jTable1.setModel(new javax.swing.table.DefaultTableModel(
                        Utilities.parseToObjectArray(employeeTaskView.getDoingTasks(employee.id)),
                        new String[] {
                                "Task ID", "Task name", "Project ID", "Project name", "Milestones"
                        }) {
                    boolean[] canEdit = new boolean[] {
                            false, false, false, false, false
                    };

                    public boolean isCellEditable(int rowIndex, int columnIndex) {
                        return canEdit[columnIndex];
                    }
                });
                break;
            case 2:
                jTable1.setModel(new javax.swing.table.DefaultTableModel(
                        Utilities.parseToObjectArray(employeeTaskView.getCompletedTasks(employee.id)),
                        new String[] {
                                "Task ID", "Task name", "Project ID", "Project name", "Milestones"
                        }) {
                    boolean[] canEdit = new boolean[] {
                            false, false, false, false, false
                    };

                    public boolean isCellEditable(int rowIndex, int columnIndex) {
                        return canEdit[columnIndex];
                    }
                });
                break;
            default:
                break;
        }

    }

    private void buildWorklogTable() {

        jTable3.setModel(new javax.swing.table.DefaultTableModel(
                selectedTaskId == null
                        ? Utilities.parseToObjectArray(employeeWorklogView.getWorklogsOfEmployee(employee.id))
                        : Utilities.parseToObjectArray(employeeWorklogView.getWorklogsOfEmployeeForTask(employee.id,
                                Integer.valueOf(selectedTaskId))),
                new String[] { "ID", "Timestamp", "Work done", "Task ID", "Task name", "Project name" }) {
            boolean[] canEdit = new boolean[] {
                    false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit[columnIndex];
            }
        });
    }

    /**
     * @param args the command line arguments
     */
    public static void build(Employee loggedInEmployee) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(EmployeeDashboard.class.getName()).log(java.util.logging.Level.SEVERE,
                    null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(EmployeeDashboard.class.getName()).log(java.util.logging.Level.SEVERE,
                    null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(EmployeeDashboard.class.getName()).log(java.util.logging.Level.SEVERE,
                    null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(EmployeeDashboard.class.getName()).log(java.util.logging.Level.SEVERE,
                    null, ex);
        }
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new EmployeeDashboard(loggedInEmployee).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton ButtonAddLog;
    private javax.swing.JButton ButtonDeleteLog;
    private javax.swing.JButton ButtonEditLog;
    private javax.swing.JButton ButtonEditTask;
    private javax.swing.JComboBox<String> ComboBoxTaskStatus;
    private javax.swing.JTextField TFEmpID;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JList<String> jList1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    private javax.swing.JTable jTable3;
    private Employee employee;
    private String selectedTaskId;
    private String selectedProjectid;
    private String selectedWorklogId;
    private EmployeeTaskView employeeTaskView = new EmployeeTaskView();
    private EmployeeWorklogView employeeWorklogView = new EmployeeWorklogView();
    private TaskDao taskDao = new TaskDao();
    private WorklogDao worklogDao = new WorklogDao();
}
