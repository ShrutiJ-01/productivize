
package com.example.gui;

import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

import com.example.entites.Manager;
import com.example.entites.Milestone;
import com.example.entites.Project;
import com.example.entites.Task;
import com.example.services.Utilities;
import com.example.tabledao.MilestonesDao;
import com.example.tabledao.ProjectDao;
import com.example.tabledao.TaskDao;
import com.example.tabledao.WorksForDao;
import com.example.viewsdao.ManagerTaskView;

/**
 *
 * @author tanma
 */
public class ManagerDashboard extends javax.swing.JFrame {

    DefaultTableModel model;

    public ManagerDashboard(Manager loggedInManager) {
        manager = loggedInManager;
        initComponents();

    }

    @SuppressWarnings("unchecked")

    private void initComponents() {

        jScrollPane2 = new javax.swing.JScrollPane();
        jScrollPane5 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        ButtonAddProject = new javax.swing.JButton();
        ButtonEditProject = new javax.swing.JButton();
        ButtonDeleteProject = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        TFManagerID = new javax.swing.JTextField("");
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        LabelWorkingEmployees = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTable3 = new javax.swing.JTable();
        ButtonAddMilestone = new javax.swing.JButton();
        ButtonEditMilestone = new javax.swing.JButton();
        ButtonDeleteMilestone = new javax.swing.JButton();
        jScrollPane4 = new javax.swing.JScrollPane();
        jTable4 = new javax.swing.JTable();
        ButtonMAddTask = new javax.swing.JButton();
        ButtonMEditTask = new javax.swing.JButton();
        ButtonMDeleteTask = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        ComboBoxProjectStatus = new javax.swing.JComboBox<>();
        TableWorkingEmployees = new javax.swing.JTable();

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

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Times New Roman", 0, 36)); // NOI18N
        jLabel1.setText("Hello " + manager.first_name + "!");

        jLabel2.setText("Manager ID:");

        ButtonAddProject.setText("Add a project");
        ButtonAddProject.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonAddProjectActionPerformed(evt);
            }
        });

        ButtonEditProject.setText("Edit a project");
        ButtonEditProject.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonEditProjectActionPerformed(evt);
            }
        });

        ButtonDeleteProject.setText("Delete a project");
        ButtonDeleteProject.setMaximumSize(new java.awt.Dimension(99, 23));
        ButtonDeleteProject.setMinimumSize(new java.awt.Dimension(99, 23));
        ButtonDeleteProject.setPreferredSize(new java.awt.Dimension(99, 23));
        ButtonDeleteProject.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonDeleteProjectActionPerformed(evt);
            }
        });

        buildProjectsTableForFilter();
        jScrollPane1.setViewportView(jTable1);
        // setup selection model for projects table
        ListSelectionModel projectSelectionModel = jTable1.getSelectionModel();
        projectSelectionModel.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);

        projectSelectionModel.addListSelectionListener(new ListSelectionListener() {
            public void valueChanged(ListSelectionEvent e) {
                if (jTable1.getSelectedRow() > -1) {
                    // store projectId of selected row
                    selectedProjectId = jTable1.getValueAt(jTable1.getSelectedRow(), 0).toString();
                    // build ProjectId
                    buildMilestoneTableForProject();
                    buildTasksTableForProject();
                }
            }
        });

        TFManagerID.setEditable(false);
        TFManagerID.setText(" " + manager.id);

        jLabel3.setFont(new java.awt.Font("Times New Roman", 0, 14));
        jLabel3.setText("Projects");

        jLabel4.setFont(new java.awt.Font("Times New Roman", 0, 14));
        jLabel4.setText("Milestones");

        buildMilestoneTableForProject();
        jScrollPane3.setViewportView(jTable3);
        // setup selection model for milestones table
        ListSelectionModel milestoneSelectionModel = jTable3.getSelectionModel();
        milestoneSelectionModel.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);

        milestoneSelectionModel.addListSelectionListener(new ListSelectionListener() {
            public void valueChanged(ListSelectionEvent e) {
                if (jTable3.getSelectedRow() > -1) {
                    // store milestoneId of selected row
                    selectedMilestoneId = jTable3.getValueAt(jTable3.getSelectedRow(), 0).toString();
                }
            }
        });

        ButtonAddMilestone.setText("Add a milestone");
        ButtonAddMilestone.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonAddMilestoneActionPerformed(evt);
            }
        });

        ButtonEditMilestone.setText("Edit a milestone");
        ButtonEditMilestone.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonEditMilestoneActionPerformed(evt);
            }
        });

        ButtonDeleteMilestone.setText("Delete a milestone");
        ButtonDeleteMilestone.setMaximumSize(new java.awt.Dimension(83, 23));
        ButtonDeleteMilestone.setMinimumSize(new java.awt.Dimension(83, 23));
        ButtonDeleteMilestone.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonDeleteMilestoneActionPerformed(evt);
            }
        });

        buildTasksTableForProject();
        jScrollPane4.setViewportView(jTable4);
        // setup selection model for milestones table
        ListSelectionModel taskSelectionModel = jTable4.getSelectionModel();
        taskSelectionModel.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);

        taskSelectionModel.addListSelectionListener(new ListSelectionListener() {
            public void valueChanged(ListSelectionEvent e) {
                if (jTable4.getSelectedRow() > -1) {
                    // store milestoneId of selected row
                    selectedTaskId = jTable4.getValueAt(jTable4.getSelectedRow(), 0).toString();
                }
            }
        });

        ButtonMAddTask.setText("Add a task");
        ButtonMAddTask.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonMAddTaskActionPerformed(evt);
            }
        });

        ButtonMEditTask.setText("Edit a task");
        ButtonMEditTask.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonMEditTaskActionPerformed(evt);
            }
        });

        ButtonMDeleteTask.setText("Delete a task");
        ButtonMDeleteTask.setMaximumSize(new java.awt.Dimension(83, 23));
        ButtonMDeleteTask.setMinimumSize(new java.awt.Dimension(83, 23));
        ButtonMDeleteTask.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonMDeleteTaskActionPerformed(evt);
            }
        });

        LabelWorkingEmployees.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        LabelWorkingEmployees.setText("Employees working under me");

        ComboBoxProjectStatus
                .setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "On-going", "Completed", "Blocked" }));
        ComboBoxProjectStatus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buildProjectsTableForFilter();
            }
        });

        jLabel6.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel6.setText("Tasks");

        buildWorkingEmployeesTable();
        jScrollPane5.setViewportView(TableWorkingEmployees);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(33, 33, 33)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addComponent(jLabel4)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED,
                                                        javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(ButtonAddMilestone)
                                                .addGap(18, 18, 18)
                                                .addComponent(ButtonEditMilestone,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE, 120,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addComponent(ButtonDeleteMilestone,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE,
                                                        javax.swing.GroupLayout.DEFAULT_SIZE,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(33, 33, 33))
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout
                                                .createSequentialGroup()
                                                .addGroup(layout
                                                        .createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addGap(0, 0, Short.MAX_VALUE)
                                                                .addComponent(LabelWorkingEmployees)
                                                                .addGap(18, 18, 18)
                                                                .addComponent(jScrollPane5,
                                                                        javax.swing.GroupLayout.PREFERRED_SIZE, 272,
                                                                        javax.swing.GroupLayout.PREFERRED_SIZE))
                                                        .addComponent(jScrollPane3,
                                                                javax.swing.GroupLayout.Alignment.LEADING,
                                                                javax.swing.GroupLayout.DEFAULT_SIZE, 934,
                                                                Short.MAX_VALUE)
                                                        .addComponent(jScrollPane1,
                                                                javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout
                                                                .createSequentialGroup()
                                                                .addComponent(jLabel3)
                                                                .addPreferredGap(
                                                                        javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                                .addComponent(ComboBoxProjectStatus,
                                                                        javax.swing.GroupLayout.PREFERRED_SIZE, 89,
                                                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addPreferredGap(
                                                                        javax.swing.LayoutStyle.ComponentPlacement.RELATED,
                                                                        javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                        Short.MAX_VALUE)
                                                                .addComponent(ButtonAddProject)
                                                                .addGap(18, 18, 18)
                                                                .addComponent(ButtonEditProject,
                                                                        javax.swing.GroupLayout.PREFERRED_SIZE, 98,
                                                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addGap(18, 18, 18)
                                                                .addComponent(ButtonDeleteProject,
                                                                        javax.swing.GroupLayout.PREFERRED_SIZE, 115,
                                                                        javax.swing.GroupLayout.PREFERRED_SIZE))
                                                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout
                                                                .createSequentialGroup()
                                                                .addComponent(jLabel1)
                                                                .addPreferredGap(
                                                                        javax.swing.LayoutStyle.ComponentPlacement.RELATED,
                                                                        javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                        Short.MAX_VALUE)
                                                                .addComponent(jLabel2)
                                                                .addPreferredGap(
                                                                        javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                                .addComponent(TFManagerID,
                                                                        javax.swing.GroupLayout.PREFERRED_SIZE, 69,
                                                                        javax.swing.GroupLayout.PREFERRED_SIZE)))
                                                .addGap(36, 36, 36))
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout
                                                .createSequentialGroup()
                                                .addGroup(layout
                                                        .createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                        .addComponent(jScrollPane4,
                                                                javax.swing.GroupLayout.DEFAULT_SIZE, 937,
                                                                Short.MAX_VALUE)
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addComponent(jLabel6)
                                                                .addPreferredGap(
                                                                        javax.swing.LayoutStyle.ComponentPlacement.RELATED,
                                                                        javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                        Short.MAX_VALUE)
                                                                .addComponent(ButtonMAddTask)
                                                                .addGap(18, 18, 18)
                                                                .addComponent(ButtonMEditTask,
                                                                        javax.swing.GroupLayout.PREFERRED_SIZE, 108,
                                                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addGap(18, 18, 18)
                                                                .addComponent(ButtonMDeleteTask,
                                                                        javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                        javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                        javax.swing.GroupLayout.PREFERRED_SIZE)))
                                                .addGap(33, 33, 33)))));
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(31, 31, 31)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel1)
                                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 22,
                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(TFManagerID, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(34, 34, 34)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel3)
                                        .addComponent(ButtonAddProject)
                                        .addComponent(ButtonEditProject)
                                        .addComponent(ButtonDeleteProject, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(ComboBoxProjectStatus, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 75,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(48, 48, 48)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel4)
                                        .addComponent(ButtonAddMilestone)
                                        .addComponent(ButtonEditMilestone)
                                        .addComponent(ButtonDeleteMilestone, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 75,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(48, 48, 48)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(ButtonMAddTask)
                                        .addComponent(ButtonMEditTask)
                                        .addComponent(ButtonMDeleteTask, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel6))
                                .addGap(18, 18, 18)
                                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 75,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 50,
                                        Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 59,
                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(LabelWorkingEmployees))
                                .addGap(19, 19, 19)));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void buildProjectsTableForFilter() {

        int choice = ComboBoxProjectStatus.getSelectedIndex();
        switch (choice) {
            case 0:
                jTable1.setModel(new javax.swing.table.DefaultTableModel(
                        Utilities.parseToObjectArray(projectDao.getOngoingProjectsForManager(manager.id)),
                        new String[] {
                                "Project ID", "Project name", "Start date", "Due date"
                        }) {
                    boolean[] canEdit = new boolean[] {
                            false, false, false, false
                    };

                    public boolean isCellEditable(int rowIndex, int columnIndex) {
                        return canEdit[columnIndex];
                    }
                });
                break;

            case 1:
                jTable1.setModel(new javax.swing.table.DefaultTableModel(
                        Utilities.parseToObjectArray(projectDao.getCompletedProjectsForManager(manager.id)),
                        new String[] {
                                "Project ID", "Project name", "Start date", "Due date"
                        }) {
                    boolean[] canEdit = new boolean[] {
                            false, false, true, true
                    };

                    public boolean isCellEditable(int rowIndex, int columnIndex) {
                        return canEdit[columnIndex];
                    }
                });
                break;
            case 2:
                jTable1.setModel(new javax.swing.table.DefaultTableModel(
                        Utilities.parseToObjectArray(projectDao.getBlockedProjectsForManager(manager.id)),
                        new String[] {
                                "Project ID", "Project name", "Start date", "Due date"
                        }) {
                    boolean[] canEdit = new boolean[] {
                            false, false, true, true
                    };

                    public boolean isCellEditable(int rowIndex, int columnIndex) {
                        return canEdit[columnIndex];
                    }
                });
                break;
            default:
                jTable1.setModel(new javax.swing.table.DefaultTableModel(
                        Utilities.parseToObjectArray(projectDao.getOngoingProjectsForManager(manager.id)),
                        new String[] {
                                "Project ID", "Project name", "Start date", "Due date"
                        }) {
                    boolean[] canEdit = new boolean[] {
                            false, false, false, false
                    };

                    public boolean isCellEditable(int rowIndex, int columnIndex) {
                        return canEdit[columnIndex];
                    }
                });
                break;
        }

    }

    private void buildMilestoneTableForProject() {
        jTable3.setModel(new javax.swing.table.DefaultTableModel(
                selectedProjectId == null ? new Object[0][0]
                        : Utilities.parseToObjectArray(
                                milestonesDao.getMilestonesForProject(Integer.valueOf(selectedProjectId))),
                new String[] {
                        "Milestone ID", "Milestone name", "Deliverables", "Due date", "Status"
                }) {
            boolean[] canEdit = new boolean[] {
                    false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit[columnIndex];
            }
        });
    }

    private void buildTasksTableForProject() {
        jTable4.setModel(new javax.swing.table.DefaultTableModel(
                selectedMilestoneId == null ? new Object[0][0]
                        : Utilities
                                .parseToObjectArray(
                                        managerView.getTasksforMilestone(Integer.valueOf(selectedMilestoneId))),
                new String[] {
                        "Employee ID", "Employee name", "Task ID", "Task name", "Task Status"
                }) {
            boolean[] canEdit = new boolean[] {
                    false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit[columnIndex];
            }
        });
    }

    private void buildWorkingEmployeesTable() {
        TableWorkingEmployees.setModel(new javax.swing.table.DefaultTableModel(
                Utilities.parseToObjectArray(worksForDao.getEmployeesWorkingForManager(manager.id)),
                new String[] {
                        "Employee ID", "Employee name"
                }) {
            boolean[] canEdit = new boolean[] {
                    false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit[columnIndex];
            }
        });
    }

    private void ButtonDeleteProjectActionPerformed(java.awt.event.ActionEvent evt) {
        JTextField projectid = new JTextField(selectedProjectId);

        final JComponent[] inputs = new JComponent[] {
                new JLabel("Project ID"),
                projectid,

        };
        int response = JOptionPane.showConfirmDialog(null, inputs, "Delete a project", JOptionPane.OK_CANCEL_OPTION,
                JOptionPane.PLAIN_MESSAGE);
        // 0=ok, 2=cancel
        if (response == 0) {

            if (projectid.getText().isEmpty()) {// check validatoins
                JOptionPane.showMessageDialog(null, "Please fill all feilds !");

            } else {// if no feilds are empty
                try {
                    boolean isDeleted = projectDao.delete(Integer.valueOf(projectid.getText()));
                    if (isDeleted) {
                        JOptionPane.showMessageDialog(null, "Deleted Project!");

                        // rebuild table
                        buildProjectsTableForFilter();
                        buildMilestoneTableForProject();
                        buildTasksTableForProject();
                    } else {
                        JOptionPane.showMessageDialog(null, " Could not delete project !");
                    }
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, e.getMessage());
                }

            }

        }

    }

    private void ButtonEditProjectActionPerformed(java.awt.event.ActionEvent evt) {
        JTextField projectid = new JTextField(selectedProjectId);
        JTextField projectname = new JTextField("");
        JTextField startdate = new JTextField("");
        JTextField duedate = new JTextField("");
        JTextField status = new JTextField("");

        final JComponent[] inputs = new JComponent[] {
                new JLabel("Project ID"),
                projectid,
                new JLabel("Project name"),
                projectname,
                new JLabel("Start date"),
                startdate,
                new JLabel("Due date"),
                duedate,
                new JLabel("Status"),
                status,
        };
        int response = JOptionPane.showConfirmDialog(null, inputs, "Edit a project", JOptionPane.OK_CANCEL_OPTION,
                JOptionPane.PLAIN_MESSAGE);

        if (response == 0) {

            if (projectid.getText().isEmpty() || projectname.getText().isEmpty() || startdate.getText().isEmpty()
                    || duedate.getText().isEmpty() || status.getText().isEmpty()) {// check validatoins
                JOptionPane.showMessageDialog(null, "Please fill all feilds !");

            } else {// if no feilds are empty

                boolean isEdited = projectDao
                        .update(new Project(Integer.valueOf(projectid.getText()), projectname.getText(),
                                startdate.getText(), duedate.getText(), manager.id, Integer.valueOf(status.getText())));
                if (isEdited) {
                    JOptionPane.showMessageDialog(null, "Edited Project!");

                    // rebuild table
                    buildProjectsTableForFilter();
                } else {
                    JOptionPane.showMessageDialog(null, " Could not Edit project !");
                }

            }
        }

    }// GEN-LAST:event_ButtonEditProjectActionPerformed

    private void ButtonAddProjectActionPerformed(java.awt.event.ActionEvent evt) {
        JTextField projectname = new JTextField("");
        JTextField startdate = new JTextField("");
        JTextField duedate = new JTextField("");
        final JComponent[] inputs = new JComponent[] {
                new JLabel("Project name"),
                projectname,
                new JLabel("Start date"),
                startdate,
                new JLabel("Due date"),
                duedate
        };
        int response = JOptionPane.showConfirmDialog(null, inputs, "Add a project", JOptionPane.OK_CANCEL_OPTION,
                JOptionPane.PLAIN_MESSAGE);
        // 0=ok, 2=cancel
        if (response == 0) {

            if (projectname.getText().isEmpty() || startdate.getText().isEmpty() || duedate.getText().isEmpty()) {// check
                                                                                                                  // validatoins
                JOptionPane.showMessageDialog(null, "Please fill all feilds !");

            } else {// if no feilds are empty
                try {
                    boolean isInserted = projectDao.insert(
                            new Project(projectname.getText(), startdate.getText(), duedate.getText(), manager.id, 1));
                    if (isInserted) {
                        JOptionPane.showMessageDialog(null, "Inserted Project!");

                        // rebuild table
                        buildProjectsTableForFilter();
                    } else {
                        JOptionPane.showMessageDialog(null, " Could not Insert project !");
                    }
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, e.getMessage());
                }
            }

        }

    }

    private void ButtonDeleteMilestoneActionPerformed(java.awt.event.ActionEvent evt) {
        JTextField milestoneid = new JTextField(selectedMilestoneId);

        final JComponent[] inputs = new JComponent[] {
                new JLabel("Milestone ID"),
                milestoneid,

        };
        int response = JOptionPane.showConfirmDialog(null, inputs, "Delete a milestone", JOptionPane.OK_CANCEL_OPTION,
                JOptionPane.PLAIN_MESSAGE);
        // 0=ok, 2=cancel
        if (response == 0) {

            if (milestoneid.getText().isEmpty()) {// check validatoins
                JOptionPane.showMessageDialog(null, "Please fill all feilds !");

            } else {// if no feilds are empty
                try {
                    boolean isDeleted = milestonesDao.delete(Integer.valueOf(milestoneid.getText()));
                    if (isDeleted) {
                        JOptionPane.showMessageDialog(null, "Deleted Milestone!");

                        // rebuild table
                        buildMilestoneTableForProject();
                        buildTasksTableForProject();
                    } else {
                        JOptionPane.showMessageDialog(null, " Could not delete milestone !");
                    }
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, e.getMessage());
                }
            }

        }
    }

    private void ButtonEditMilestoneActionPerformed(java.awt.event.ActionEvent evt) {
        JTextField milestoneid = new JTextField(selectedMilestoneId);
        JTextField milestonename = new JTextField("");
        JTextField deliverables = new JTextField("");
        JTextField duedate = new JTextField("");
        JTextField projectid = new JTextField(selectedProjectId);
        JTextField status = new JTextField("");

        final JComponent[] inputs = new JComponent[] {
                new JLabel("Milestone ID"),
                milestoneid,
                new JLabel("Milestone name"),
                milestonename,
                new JLabel("Deliverables"),
                deliverables,
                new JLabel("Due date"),
                duedate,
                new JLabel("ProjectID"),
                projectid,
                new JLabel("Status"),
                status
        };
        int response = JOptionPane.showConfirmDialog(null, inputs, "Edit a milestone", JOptionPane.OK_CANCEL_OPTION,
                JOptionPane.PLAIN_MESSAGE);
        if (response == 0) {

            if (milestoneid.getText().isEmpty() || milestonename.getText().isEmpty() || duedate.getText().isEmpty()
                    || deliverables.getText().isEmpty() || projectid.getText().isEmpty()
                    || status.getText().isEmpty()) {// check validatoins
                JOptionPane.showMessageDialog(null, "Please fill all feilds !");

            } else {// if no feilds are empty

                boolean isUpdated = milestonesDao
                        .update(new Milestone(Integer.valueOf(milestoneid.getText()), milestonename.getText(),
                                duedate.getText(), deliverables.getText(), Integer.valueOf(projectid.getText()), 1));
                if (isUpdated) {
                    JOptionPane.showMessageDialog(null, "Updated Milestone!");

                    // rebuild table
                    buildMilestoneTableForProject();
                    buildTasksTableForProject();
                } else {
                    JOptionPane.showMessageDialog(null, " Could not Update Milestone!");
                }
            }
        }
    }

    private void ButtonAddMilestoneActionPerformed(java.awt.event.ActionEvent evt) {
        JTextField milestonename = new JTextField("");
        JTextField deliverables = new JTextField("");
        JTextField duedate = new JTextField("");
        JTextField projectid = new JTextField(selectedProjectId);
        final JComponent[] inputs = new JComponent[] {
                new JLabel("Milestone name"),
                milestonename,
                new JLabel("Deliverables"),
                deliverables,
                new JLabel("Due date"),
                duedate,
                new JLabel("ProjectID"),
                projectid
        };
        int response = JOptionPane.showConfirmDialog(null, inputs, "Add a Milestone", JOptionPane.OK_CANCEL_OPTION,
                JOptionPane.PLAIN_MESSAGE);

        if (response == 0) {

            if (milestonename.getText().isEmpty() || duedate.getText().isEmpty()
                    || deliverables.getText().isEmpty() || projectid.getText().isEmpty()) {// check validatoins
                JOptionPane.showMessageDialog(null, "Please fill all feilds !");

            } else {// if no feilds are empty

                try {
                    boolean isInserted = milestonesDao.insert(new Milestone(milestonename.getText(), duedate.getText(),
                            deliverables.getText(), Integer.valueOf(projectid.getText()), 1));
                    if (isInserted) {
                        JOptionPane.showMessageDialog(null, "Inserted Milestone!");

                        // rebuild table
                        buildMilestoneTableForProject();
                    } else {
                        JOptionPane.showMessageDialog(null, " Could not Insert Milestone!");
                    }
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, e.getMessage());
                }
            }

        }
    }

    private void ButtonMAddTaskActionPerformed(java.awt.event.ActionEvent evt) {
        JTextField taskname = new JTextField("");
        JTextField employeeid = new JTextField("");
        JTextField milestoneid = new JTextField(selectedMilestoneId);
        final JComponent[] inputs = new JComponent[] {
                new JLabel("Task name"),
                taskname,
                new JLabel("Assign to Employee ID"),
                employeeid,
                new JLabel("Milestone ID"),
                milestoneid
        };
        int response = JOptionPane.showConfirmDialog(null, inputs, "Add a Task", JOptionPane.OK_CANCEL_OPTION,
                JOptionPane.PLAIN_MESSAGE);
        if (response == 0) {
            if (taskname.getText().isEmpty() || employeeid.getText().isEmpty() || milestoneid.getText().isEmpty()) {// check
                                                                                                                    // validatoins
                JOptionPane.showMessageDialog(null, "Please fill all feilds !");

            } else {// if no feilds are empty

                try {
                    boolean isInserted = taskDao
                            .insert(new Task(taskname.getText(), Integer.valueOf(employeeid.getText()),
                                    1, Integer.valueOf(milestoneid.getText())));
                    isInserted = worksForDao.insert(Integer.valueOf(employeeid.getText()), manager.id);
                    if (isInserted) {
                        JOptionPane.showMessageDialog(null, "Inserted Task!");

                        // rebuild table
                        buildTasksTableForProject();
                        buildWorkingEmployeesTable();
                    } else {
                        JOptionPane.showMessageDialog(null, " Could not Insert Task!");
                    }
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, e.getMessage());
                }
            }

        }

    }

    private void ButtonMEditTaskActionPerformed(java.awt.event.ActionEvent evt) {
        JTextField taskid = new JTextField(selectedTaskId);
        JTextField taskname = new JTextField("");
        JTextField employeeid = new JTextField("");
        JTextField milestoneid = new JTextField(selectedMilestoneId);

        final JComponent[] inputs = new JComponent[] {
                new JLabel("Task ID"),
                taskid,
                new JLabel("Task name"),
                taskname,
                new JLabel("Assign to Employee ID"),
                employeeid,
                new JLabel("Milestone ID"),
                milestoneid
        };
        int response = JOptionPane.showConfirmDialog(null, inputs, "Edit a task", JOptionPane.OK_CANCEL_OPTION,
                JOptionPane.PLAIN_MESSAGE);
        if (response == 0) {

            if (taskname.getText().isEmpty() || employeeid.getText().isEmpty() || milestoneid.getText().isEmpty()
                    || taskid.getText().isEmpty()) {// check validatoins
                JOptionPane.showMessageDialog(null, "Please fill all feilds !");

            } else {// if no feilds are empty

                boolean isUpdated = taskDao.update(new Task(Integer.valueOf(taskid.getText()), taskname.getText(),
                        Integer.valueOf(employeeid.getText()), 1, Integer.valueOf(milestoneid.getText())));
                isUpdated = worksForDao.insert(Integer.valueOf(employeeid.getText()), manager.id);
                if (isUpdated) {
                    JOptionPane.showMessageDialog(null, "Updated Task!");

                    // rebuild table
                    buildTasksTableForProject();
                    buildWorkingEmployeesTable();
                } else {
                    JOptionPane.showMessageDialog(null, " Could not Update Task!");
                }
            }

        }
    }

    private void ButtonMDeleteTaskActionPerformed(java.awt.event.ActionEvent evt) {
        JTextField taskid = new JTextField(selectedTaskId);

        final JComponent[] inputs = new JComponent[] {
                new JLabel("Task ID"),
                taskid,

        };
        int response = JOptionPane.showConfirmDialog(null, inputs, "Delete a task", JOptionPane.OK_CANCEL_OPTION,
                JOptionPane.PLAIN_MESSAGE);
        // 0=ok, 2=cancel
        if (response == 0) {

            if (taskid.getText().isEmpty()) {
                JOptionPane.showMessageDialog(null, " Please fill all feilds ");
                
            } else {
                try {
                    boolean isDeleted = taskDao.delete(Integer.valueOf(taskid.getText()));
                    if (isDeleted) {
                        JOptionPane.showMessageDialog(null, "Deleted Task!");
    
                        // rebuild table
                        buildTasksTableForProject();
                    } else {
                        JOptionPane.showMessageDialog(null, " Could not delete task !");
                    }
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, e.getMessage());
                }
            }

        }

    }

    public static void build(Manager loggedInManager) {

        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ManagerDashboard.class.getName()).log(java.util.logging.Level.SEVERE,
                    null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ManagerDashboard.class.getName()).log(java.util.logging.Level.SEVERE,
                    null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ManagerDashboard.class.getName()).log(java.util.logging.Level.SEVERE,
                    null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ManagerDashboard.class.getName()).log(java.util.logging.Level.SEVERE,
                    null, ex);
        }

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ManagerDashboard(loggedInManager).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton ButtonAddMilestone;
    private javax.swing.JButton ButtonAddProject;
    private javax.swing.JButton ButtonDeleteMilestone;
    private javax.swing.JButton ButtonDeleteProject;
    private javax.swing.JButton ButtonEditMilestone;
    private javax.swing.JButton ButtonEditProject;
    private javax.swing.JButton ButtonMAddTask;
    private javax.swing.JButton ButtonMDeleteTask;
    private javax.swing.JButton ButtonMEditTask;
    private javax.swing.JComboBox<String> ComboBoxProjectStatus;
    private javax.swing.JTextField TFManagerID;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    private javax.swing.JTable jTable3;
    private javax.swing.JTable jTable4;
    private javax.swing.JLabel LabelWorkingEmployees;
    private javax.swing.JTable TableWorkingEmployees;
    private String selectedProjectId;
    private String selectedMilestoneId;
    private String selectedTaskId;
    private Manager manager;
    private ManagerTaskView managerView = new ManagerTaskView();
    private ProjectDao projectDao = new ProjectDao();
    private MilestonesDao milestonesDao = new MilestonesDao();
    private WorksForDao worksForDao = new WorksForDao();
    private TaskDao taskDao = new TaskDao();

}
