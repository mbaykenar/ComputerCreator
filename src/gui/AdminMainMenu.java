/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;
import java.util.ArrayList;
import source.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import source.Motherboard;
/**
 *
 * @author ArthaS
 */
public class AdminMainMenu extends javax.swing.JFrame {

    /**
     * Creates new form AdminMainMenu
     */
    User currentUser;
    ArrayList<User> users = null;
    
    ArrayList<Motherboard> motherboards = null;
    ArrayList<Cpu> cpus = null;
    ArrayList<Memory> memories = null;
    ArrayList<GraphicsCard> graphicsCards = null;
    ArrayList<Hdd> hdds = null;
    ArrayList<Ssd> ssds = null;
    ArrayList<Monitor> monitors = null;
    ArrayList<Keyboard> keyboards = null;
    ArrayList<Mouse> mice = null;
    ArrayList<OpticDrive> opticDrives = null;
    ArrayList<OperatingSystem> operatingSystems = null;
    
    
    public AdminMainMenu(User u) {
        initComponents();
        setLocationRelativeTo(null);
        currentUser = u;
        jLabel1.setText("Welcome " + currentUser.getName() + " " + currentUser.getSurname());
        
        jComboBox1.removeAllItems();
        
        jComboBox1.addItem("Motherboard");
        jComboBox1.addItem("Cpu");
        jComboBox1.addItem("Memory");
        jComboBox1.addItem("Graphics Card");
        jComboBox1.addItem("HDD");
        jComboBox1.addItem("SSD");
        jComboBox1.addItem("Monitor");
        jComboBox1.addItem("Keyboard");
        jComboBox1.addItem("Mouse");
        jComboBox1.addItem("Optic Drive");
        jComboBox1.addItem("Operating System");
        //jComboBox1.setSelectedIndex(-1);
        
    }
    
    public void reloadUsers(){
        String[] columns = {"Username", "Name", "Surname", "Phone", "Email", "User Role"};
        
        try{
             users = User.retrieveAllUsers();
        }
        catch(Exception e){
            //todo
        }
        
        String[][] data = new String[users.size()][columns.length];
        
        for(int i = 0; i < users.size(); i++){
            data[i][0] = users.get(i).getUsername();
            data[i][1] = users.get(i).getName();
            data[i][2] = users.get(i).getSurname();
            data[i][3] = users.get(i).getPhone();
            data[i][4] = users.get(i).getEmail();
            data[i][5] = users.get(i).getRole() + "";
        }
        
        TableModel tableModel = new DefaultTableModel(data, columns) {
            @Override
            public boolean isCellEditable(int rowIndex, int mColIndex) {
            return false;
            }
        };
        
        jTable1.setModel(tableModel);
    }
    
    public void reloadMotherboards(){
        String[] columns = {"Model", "Vendor", "Socket", "Memory Slots", "Bus Interface", "Price"};
        
        try{
             motherboards = Motherboard.retrieveAllMotherboards();
        }
        catch(Exception e){
            //todo
        }
        
        String[][] data = new String[motherboards.size()][columns.length];
        
        for(int i = 0; i < motherboards.size(); i++){
            data[i][0] = motherboards.get(i).getModel();
            data[i][1] = motherboards.get(i).getVendor();
            data[i][2] = motherboards.get(i).getSocket();
            data[i][3] = motherboards.get(i).getMemorySlots() + "";
            data[i][4] = motherboards.get(i).getBusInterface();
            data[i][5] = motherboards.get(i).getPrice() + "";
        }
        
        TableModel tableModel = new DefaultTableModel(data, columns) {
            @Override
            public boolean isCellEditable(int rowIndex, int mColIndex) {
            return false;
            }
        };
        
        jTable2.setModel(tableModel);
    }
    
    public void reloadCpus(){
        String[] columns = {"Model", "Vendor", "Cores", "Threads", "Cache Size", "Frequency", "Price"};
        
        try{
             cpus = Cpu.retrieveAllCpus();
        }
        catch(Exception e){
            //todo
        }
        
        String[][] data = new String[cpus.size()][columns.length];
        
        for(int i = 0; i < cpus.size(); i++){
            data[i][0] = cpus.get(i).getModel();
            data[i][1] = cpus.get(i).getVendor();
            data[i][2] = cpus.get(i).getCoreNumber() + "";
            data[i][3] = cpus.get(i).getThreadNumber() + "";
            data[i][4] = cpus.get(i).getCacheSize() + "";
            data[i][5] = cpus.get(i).getClockSpeed() + "";
            data[i][6] = cpus.get(i).getPrice() + "";
        }
        
        TableModel tableModel = new DefaultTableModel(data, columns) {
            @Override
            public boolean isCellEditable(int rowIndex, int mColIndex) {
            return false;
            }
        };
        
        jTable2.setModel(tableModel);
    }
    
    public void reloadMemories(){
        String[] columns = {"Model", "Vendor", "Capacity", "Memory Type", "Frequency", "Price"};
        
        try{
             memories = Memory.retrieveAllMemories();
        }
        catch(Exception e){
            //todo
        }
        
        String[][] data = new String[memories.size()][columns.length];
        
        for(int i = 0; i < memories.size(); i++){
            data[i][0] = memories.get(i).getModel();
            data[i][1] = memories.get(i).getVendor();
            data[i][2] = memories.get(i).getCapacity() + "";
            data[i][3] = memories.get(i).getMemoryType();
            data[i][4] = memories.get(i).getFrequency() + "";
            data[i][5] = memories.get(i).getPrice() + "";
        }
        
        TableModel tableModel = new DefaultTableModel(data, columns) {
            @Override
            public boolean isCellEditable(int rowIndex, int mColIndex) {
            return false;
            }
        };
        
        jTable2.setModel(tableModel);
    }
    
    public void reloadGraphicsCards(){
        String[] columns = {"Model", "Vendor", "Cores", "Frequency", "Interface Width", "Texture Fill Rate", "Memory Size", "Price"};
        
        try{
             graphicsCards = GraphicsCard.retrieveAllGraphicsCards();
        }
        catch(Exception e){
            //todo
        }
        
        String[][] data = new String[graphicsCards.size()][columns.length];
        
        for(int i = 0; i < graphicsCards.size(); i++){
            data[i][0] = graphicsCards.get(i).getModel();
            data[i][1] = graphicsCards.get(i).getVendor();
            data[i][2] = graphicsCards.get(i).getCoreNumber() + "";
            data[i][3] = graphicsCards.get(i).getClockSpeed() + "";
            data[i][4] = graphicsCards.get(i).getInterfaceWidth() + "";
            data[i][5] = graphicsCards.get(i).getTextureFillRate() + "";
            data[i][6] = graphicsCards.get(i).getMemorySize() + "";
            data[i][7] = graphicsCards.get(i).getPrice() + "";
        }
        
        TableModel tableModel = new DefaultTableModel(data, columns) {
            @Override
            public boolean isCellEditable(int rowIndex, int mColIndex) {
            return false;
            }
        };
        
        jTable2.setModel(tableModel);
    }
    
    public void reloadHDDs(){
        String[] columns = {"Model", "Vendor", "Capacity", "Interface", "Rpm", "Price"};
        
        try{
            hdds  = Hdd.retrieveAllHdds();
        }
        catch(Exception e){
            //todo
        }
        
        String[][] data = new String[hdds.size()][columns.length];
        
        for(int i = 0; i < hdds.size(); i++){
            data[i][0] = hdds.get(i).getModel();
            data[i][1] = hdds.get(i).getVendor();
            data[i][2] = hdds.get(i).getCapacity() + "";
            data[i][3] = hdds.get(i).getConnectionInterface();
            data[i][4] = hdds.get(i).getRpm() + "";
            data[i][5] = hdds.get(i).getPrice() + "";
        }
        
        TableModel tableModel = new DefaultTableModel(data, columns) {
            @Override
            public boolean isCellEditable(int rowIndex, int mColIndex) {
            return false;
            }
        };
        
        jTable2.setModel(tableModel);
    }
    
    public void reloadSSDs(){
        String[] columns = {"Model", "Vendor", "Capacity", "Interface", "Write Speed", "Read Speed", "Price"};
        
        try{
            ssds  = Ssd.retrieveAllSsds();
        }
        catch(Exception e){
            //todo
        }
        
        String[][] data = new String[ssds.size()][columns.length];
        
        for(int i = 0; i < ssds.size(); i++){
            data[i][0] = ssds.get(i).getModel();
            data[i][1] = ssds.get(i).getVendor();
            data[i][2] = ssds.get(i).getCapacity() + "";
            data[i][3] = ssds.get(i).getConnectionInterface();
            data[i][4] = ssds.get(i).getWriteSpeed() + "";
            data[i][5] = ssds.get(i).getReadSpeed() + "";
            data[i][6] = ssds.get(i).getPrice() + "";
        }
        
        TableModel tableModel = new DefaultTableModel(data, columns) {
            @Override
            public boolean isCellEditable(int rowIndex, int mColIndex) {
            return false;
            }
        };
        
        jTable2.setModel(tableModel);
    }
    
    public void reloadMonitors(){
        String[] columns = {"Model", "Vendor", "Interface", "Type", "Resolution", "Refresh Rate(Hz)", "Screen Size(Inch)", "Price(Dollar)"};
        
        try{
            monitors  = Monitor.retrieveAllMonitors();
        }
        catch(Exception e){
            //todo
        }
        
        String[][] data = new String[monitors.size()][columns.length];
        
        for(int i = 0; i < monitors.size(); i++){
            data[i][0] = monitors.get(i).getModel();
            data[i][1] = monitors.get(i).getVendor();
            data[i][2] = monitors.get(i).getConnectionInterface();
            data[i][3] = monitors.get(i).getType();
            data[i][4] = monitors.get(i).getResolution();
            data[i][5] = monitors.get(i).getRefreshRate() + "";
            data[i][6] = monitors.get(i).getScreenSize() + "";
            data[i][7] = monitors.get(i).getPrice() + "";
        }
        
        TableModel tableModel = new DefaultTableModel(data, columns) {
            @Override
            public boolean isCellEditable(int rowIndex, int mColIndex) {
            return false;
            }
        };
        
        jTable2.setModel(tableModel);
    }
    
    public void reloadKeyboards(){
        String[] columns = {"Model", "Vendor", "Interface", "Type", "Layout", "Price(Dollar)"};
        
        try{
            keyboards  = Keyboard.retrieveAllKeyboards();
        }
        catch(Exception e){
            //todo
        }
        
        String[][] data = new String[keyboards.size()][columns.length];
        
        for(int i = 0; i < keyboards.size(); i++){
            data[i][0] = keyboards.get(i).getModel();
            data[i][1] = keyboards.get(i).getVendor();
            data[i][2] = keyboards.get(i).getConnectionInterface();
            data[i][3] = keyboards.get(i).getType();
            data[i][4] = keyboards.get(i).getLayout();
            data[i][5] = keyboards.get(i).getPrice() + "";
        }
        
        TableModel tableModel = new DefaultTableModel(data, columns) {
            @Override
            public boolean isCellEditable(int rowIndex, int mColIndex) {
            return false;
            }
        };
        
        jTable2.setModel(tableModel);
    }
    
    public void reloadMice(){
        String[] columns = {"Model", "Vendor", "Interface", "Type", "Price(Dollar)"};
        
        try{
            mice  = Mouse.retrieveAllMouses();
        }
        catch(Exception e){
            //todo
        }
        
        String[][] data = new String[mice.size()][columns.length];
        
        for(int i = 0; i < mice.size(); i++){
            data[i][0] = mice.get(i).getModel();
            data[i][1] = mice.get(i).getVendor();
            data[i][2] = mice.get(i).getConnectionInterface();
            data[i][3] = mice.get(i).getType();
            data[i][4] = mice.get(i).getPrice() + "";
        }
        
        TableModel tableModel = new DefaultTableModel(data, columns) {
            @Override
            public boolean isCellEditable(int rowIndex, int mColIndex) {
            return false;
            }
        };
        
        jTable2.setModel(tableModel);
    }
    
    public void reloadOpticDrives(){
        String[] columns = {"Model", "Vendor", "Interface", "Type", "Speed", "Price(Dollar)"};
        
        try{
            opticDrives  = OpticDrive.retrieveAllOpticDrives();
        }
        catch(Exception e){
            //todo
        }
        
        String[][] data = new String[opticDrives.size()][columns.length];
        
        for(int i = 0; i < opticDrives.size(); i++){
            data[i][0] = opticDrives.get(i).getModel();
            data[i][1] = opticDrives.get(i).getVendor();
            data[i][2] = opticDrives.get(i).getConnectionInterface();
            data[i][3] = opticDrives.get(i).getType();
            data[i][4] = opticDrives.get(i).getSpeed() + "x";
            data[i][5] = opticDrives.get(i).getPrice() + "";
        }
        
        TableModel tableModel = new DefaultTableModel(data, columns) {
            @Override
            public boolean isCellEditable(int rowIndex, int mColIndex) {
            return false;
            }
        };
        
        jTable2.setModel(tableModel);
    }
    
    public void reloadOperatingSystems(){
        String[] columns = {"Model", "Vendor", "Version", "Price(Dollar)"};
        
        try{
            operatingSystems  = OperatingSystem.retrieveAllOperatingSystems();
        }
        catch(Exception e){
            //todo
        }
        
        String[][] data = new String[operatingSystems.size()][columns.length];
        
        for(int i = 0; i < operatingSystems.size(); i++){
            data[i][0] = operatingSystems.get(i).getModel();
            data[i][1] = operatingSystems.get(i).getVendor();
            data[i][2] = operatingSystems.get(i).getVersion();
            data[i][3] = operatingSystems.get(i).getPrice() + "";
        }
        
        TableModel tableModel = new DefaultTableModel(data, columns) {
            @Override
            public boolean isCellEditable(int rowIndex, int mColIndex) {
            return false;
            }
        };
        
        jTable2.setModel(tableModel);
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
        jButton13 = new javax.swing.JButton();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton14 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jComboBox1 = new javax.swing.JComboBox();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jButton3 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Welcome");
        setResizable(false);
        addWindowFocusListener(new java.awt.event.WindowFocusListener() {
            public void windowGainedFocus(java.awt.event.WindowEvent evt) {
                formWindowGainedFocus(evt);
            }
            public void windowLostFocus(java.awt.event.WindowEvent evt) {
            }
        });
        addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                formFocusGained(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tarzan", 0, 14)); // NOI18N
        jLabel1.setText("Welcome ");

        jButton13.setText("Logout");
        jButton13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton13ActionPerformed(evt);
            }
        });

        jTable1.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
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
        jScrollPane1.setViewportView(jTable1);

        jButton14.setText("Add New");
        jButton14.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton14ActionPerformed(evt);
            }
        });

        jButton1.setText("Delete User");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Edit");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 552, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 45, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton2)
                    .addComponent(jButton14)
                    .addComponent(jButton1))
                .addGap(29, 29, 29))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(34, 34, 34)
                        .addComponent(jButton14)
                        .addGap(18, 18, 18)
                        .addComponent(jButton2)
                        .addGap(18, 18, 18)
                        .addComponent(jButton1)
                        .addGap(0, 246, Short.MAX_VALUE)))
                .addContainerGap())
        );

        jTabbedPane1.addTab("Users", jPanel1);

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jComboBox1.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jComboBox1ItemStateChanged(evt);
            }
        });

        jLabel2.setText("Select Component");

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane2.setViewportView(jTable2);

        jButton3.setText("Add New");

        jButton6.setText("Delete");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(18, 18, 18)
                        .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 554, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 37, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton3)
                            .addComponent(jButton6))
                        .addGap(41, 41, 41))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jButton3)
                        .addGap(18, 18, 18)
                        .addComponent(jButton6)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 338, Short.MAX_VALUE))
                .addContainerGap())
        );

        jTabbedPane1.addTab("Components", jPanel2);

        jMenu1.setText("About");
        jMenu1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenu1MouseClicked(evt);
            }
        });
        jMenu1.addMenuKeyListener(new javax.swing.event.MenuKeyListener() {
            public void menuKeyTyped(javax.swing.event.MenuKeyEvent evt) {
            }
            public void menuKeyPressed(javax.swing.event.MenuKeyEvent evt) {
                jMenu1MenuKeyPressed(evt);
            }
            public void menuKeyReleased(javax.swing.event.MenuKeyEvent evt) {
            }
        });
        jMenuBar1.add(jMenu1);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 742, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 42, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jButton13)
                        .addGap(62, 62, 62))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 434, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 25, Short.MAX_VALUE)
                .addComponent(jButton13)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton14ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton14ActionPerformed
        new NewUserWindow(1).setVisible(true);
        //reload users
    }//GEN-LAST:event_jButton14ActionPerformed

    private void jMenu1MenuKeyPressed(javax.swing.event.MenuKeyEvent evt) {//GEN-FIRST:event_jMenu1MenuKeyPressed

    }//GEN-LAST:event_jMenu1MenuKeyPressed

    private void jButton13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton13ActionPerformed
        new computerWizardUI().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButton13ActionPerformed

    private void jMenu1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenu1MouseClicked
        new AboutWindow().setVisible(true);
    }//GEN-LAST:event_jMenu1MouseClicked

    private void formFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_formFocusGained
        reloadUsers();
    }//GEN-LAST:event_formFocusGained

    private void formWindowGainedFocus(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowGainedFocus
        reloadUsers();
    }//GEN-LAST:event_formWindowGainedFocus

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        int toDelete = jTable1.getSelectedRow();
        
        if(toDelete != -1){
            try{
                users.get(toDelete).deleteUser();
                reloadUsers();
            }
            catch(Exception e){
                JOptionPane.showMessageDialog(null, "Unable to Delete", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
        
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        if(jTable1.getSelectedRow() != - 1){
            AdminUserEdit a = new AdminUserEdit(users.get(jTable1.getSelectedRow()));
            a.setVisible(true);
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jComboBox1ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jComboBox1ItemStateChanged
        switch(jComboBox1.getSelectedIndex()){
            case 0: reloadMotherboards(); break;
            case 1: reloadCpus(); break;
            case 2: reloadMemories(); break;
            case 3: reloadGraphicsCards(); break;
            case 4: reloadHDDs(); break;
            case 5: reloadSSDs(); break;
            case 6: reloadMonitors(); break;
            case 7: reloadKeyboards(); break;
            case 8: reloadMice(); break;
            case 9: reloadOpticDrives(); break;
            case 10: reloadOperatingSystems(); break;
        }
    }//GEN-LAST:event_jComboBox1ItemStateChanged

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /*
         * Set the Nimbus look and feel
         */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /*
         * If Nimbus (introduced in Java SE 6) is not available, stay with the
         * default look and feel. For details see
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
            java.util.logging.Logger.getLogger(AdminMainMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AdminMainMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AdminMainMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AdminMainMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /*
         * Create and display the form
         */
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                new AdminMainMenu(null).setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton13;
    private javax.swing.JButton jButton14;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton6;
    private javax.swing.JComboBox jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    // End of variables declaration//GEN-END:variables
}
