/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;
import com.itextpdf.text.Document;
import com.itextpdf.text.Element;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.File;
import java.io.FileFilter;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import source.*;

/**
 *
 * @author SifresizAdmin
 */
public class SuggestionResultWindow extends javax.swing.JFrame {
    
    public ArrayList<Motherboard> motherboard = new ArrayList<Motherboard>();
    public ArrayList<Cpu> cpu = new ArrayList<Cpu>();
    public ArrayList<Memory> memory = new ArrayList<Memory>();
    public ArrayList<GraphicsCard> gpu = new ArrayList<GraphicsCard>();
    public ArrayList<Monitor> monitor = new ArrayList<Monitor>();
    public ArrayList<Hdd> hdd = new ArrayList<Hdd>();
    public ArrayList<Mouse> mouse = new ArrayList<Mouse>();
    public ArrayList<Keyboard> keyboard = new ArrayList<Keyboard>();
    public ArrayList<OpticDrive> opticdrive = new ArrayList<OpticDrive>();
    public ArrayList<Ssd> ssd = new ArrayList<Ssd>();
    public ArrayList<OperatingSystem> os = new ArrayList<OperatingSystem>();
    
    private DefaultComboBoxModel jComboBox1Model;
    private DefaultComboBoxModel jComboBox12Model;
    private DefaultComboBoxModel jComboBox13Model;
    private DefaultComboBoxModel jComboBox14Model;
    private DefaultComboBoxModel jComboBox15Model;
    private DefaultComboBoxModel jComboBox16Model;
    private DefaultComboBoxModel jComboBox17Model;
    private DefaultComboBoxModel jComboBox18Model;
    private DefaultComboBoxModel jComboBox19Model;
    private DefaultComboBoxModel jComboBox20Model;
    private DefaultComboBoxModel jComboBox21Model;
                    
    User currentUser = null;
    /**
     * Creates new form UserMainMenu
     */
    public SuggestionResultWindow(User u){        
        initComponents();
        initEntities();
        initPrices();
        currentUser = u;
        setLocationRelativeTo( null ); //to center the window
    }
    
    /*
     * cpu, gpu, memory, storage listeleri motherboard secimine bagli olarak ayrıca doldurulacagi icin
     * bu metodda doldurmaya gerek yok.
     */
    private void initEntities(){
        try{
            motherboard = new ArrayList<Motherboard>();
            monitor = new ArrayList<Monitor>();
            hdd = new ArrayList<Hdd>();
            mouse = new ArrayList<Mouse>();
            keyboard = new ArrayList<Keyboard>();
            opticdrive = new ArrayList<OpticDrive>();
            ssd = new ArrayList<Ssd>();
            os = new ArrayList<OperatingSystem>();
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, "Unable to connect to database!", "Error", JOptionPane.ERROR_MESSAGE);
        }
        
        jComboBox1.setEnabled(false);
        jComboBox12.setEnabled(false);
        jComboBox13.setEnabled(false);
        jComboBox14.setEnabled(false);
        jComboBox15.setEnabled(false);
        jComboBox16.setEnabled(false);
        jComboBox17.setEnabled(false);
        jComboBox18.setEnabled(false);
        jComboBox19.setEnabled(false);
        jComboBox20.setEnabled(false);
        jComboBox21.setEnabled(false);
        
    }
    
    public void loadEntities(){
        int mbsize = motherboard.size();
        String [] motherboardModel = new String[mbsize];
        for(int i=0; i<mbsize; i++){
            motherboardModel[i] = motherboard.get(i).getVendor()+" "+motherboard.get(i).getModel();
        }
        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel(motherboardModel));
        
        //cpu
        int cpusize = cpu.size();
        String [] cpuModel = new String[cpusize];
        for(int i=0; i<cpusize; i++){
            cpuModel[i] = cpu.get(i).getVendor()+" "+cpu.get(i).getModel();
        }
        jComboBox12.setModel(new javax.swing.DefaultComboBoxModel(cpuModel));
        
        //gpu
        int gpusize = gpu.size();
        String [] gpuModel = new String[gpusize];
        for(int i=0; i<gpusize; i++){
            gpuModel[i] = gpu.get(i).getVendor()+" "+gpu.get(i).getModel();
        }
        jComboBox14.setModel(new javax.swing.DefaultComboBoxModel(gpuModel));
        
        //memory
        int memorysize = memory.size();
        String [] memoryModel = new String[memorysize];
        for(int i=0; i<memorysize; i++){
            memoryModel[i] = memory.get(i).getVendor()+" "+memory.get(i).getModel();
        }
        jComboBox13.setModel(new javax.swing.DefaultComboBoxModel(memoryModel));
        
        //hdd
        int hddsize = hdd.size();
        String [] hddModel = new String[hddsize];
        for(int i=0; i<hddsize; i++){
            hddModel[i] = hdd.get(i).getVendor()+" "+hdd.get(i).getModel();
        }
        jComboBox16.setModel(new javax.swing.DefaultComboBoxModel(hddModel));
        
        //ssd
        int ssdsize = ssd.size();
        String [] ssdModel = new String[ssdsize];
        for(int i=0; i<ssdsize; i++){
            ssdModel[i] = ssd.get(i).getVendor()+" "+ssd.get(i).getModel();
        }
        jComboBox17.setModel(new javax.swing.DefaultComboBoxModel(ssdModel));
        
        int monitorsize = monitor.size();
        String [] monitorModel = new String[monitorsize];
        for(int i=0; i<monitorsize; i++){
            monitorModel[i] = monitor.get(i).getVendor()+" "+monitor.get(i).getModel();
        }
        jComboBox15.setModel(new javax.swing.DefaultComboBoxModel(monitorModel));
        
        int keyboardsize = keyboard.size();
        String [] keyboardModel = new String[keyboardsize];
        for(int i=0; i<keyboardsize; i++){
            keyboardModel[i] = keyboard.get(i).getVendor()+" "+keyboard.get(i).getModel();
        }
        jComboBox18.setModel(new javax.swing.DefaultComboBoxModel(keyboardModel)); 
        
        int mousesize = mouse.size();
        String [] mouseModel = new String[mousesize];
        for(int i=0; i<mousesize; i++){
            mouseModel[i] = mouse.get(i).getVendor()+" "+mouse.get(i).getModel();
        }
        jComboBox19.setModel(new javax.swing.DefaultComboBoxModel(mouseModel)); 
        
        int opticdrivesize = opticdrive.size();
        String [] opticdriveModel = new String[opticdrivesize];
        for(int i=0; i<opticdrivesize; i++){
            opticdriveModel[i] = opticdrive.get(i).getVendor()+" "+opticdrive.get(i).getModel();
        }
        jComboBox20.setModel(new javax.swing.DefaultComboBoxModel(opticdriveModel));
        
        int ossize = os.size();
        String [] osModel = new String[ossize];
        for(int i=0; i<ossize; i++){
            osModel[i] = os.get(i).getVendor()+" "+os.get(i).getModel();
        }
        jComboBox21.setModel(new javax.swing.DefaultComboBoxModel(osModel));
        
        updateTotalPrice();
    }
    
    public void initPrices(){
        jTextField1.setText("0");
        jTextField2.setText("0");
        jTextField3.setText("0");
        jTextField4.setText("0");
        jTextField5.setText("0");
        jTextField6.setText("0");
        jTextField7.setText("0");
        jTextField8.setText("0");
        jTextField9.setText("0");
        jTextField10.setText("0");
        jTextField11.setText("0");
    }
    
    public void loadPrices(){
        jTextField1.setText(motherboard.get(0).getPrice() + "");
        jTextField2.setText(cpu.get(0).getPrice() + "");
        jTextField3.setText(memory.get(0).getPrice() + "");
        jTextField4.setText(gpu.get(0).getPrice() + "");
        jTextField5.setText(monitor.get(0).getPrice() + "");
        jTextField6.setText(hdd.get(0).getPrice() + "");
        jTextField7.setText(ssd.get(0).getPrice() + "");
        jTextField8.setText(keyboard.get(0).getPrice() + "");
        jTextField9.setText(mouse.get(0).getPrice() + "");
        jTextField10.setText(opticdrive.get(0).getPrice() + "");
        jTextField11.setText(os.get(0).getPrice() + "");
    }
    
    public void updateTotalPrice(){
        double total = 0;
        total += Double.valueOf(jTextField1.getText());
        total += Double.valueOf(jTextField2.getText());
        total += Double.valueOf(jTextField3.getText());
        total += Double.valueOf(jTextField4.getText());
        total += Double.valueOf(jTextField5.getText());
        total += Double.valueOf(jTextField6.getText());
        total += Double.valueOf(jTextField7.getText());
        total += Double.valueOf(jTextField8.getText());
        total += Double.valueOf(jTextField9.getText());
        total += Double.valueOf(jTextField10.getText());
        total += Double.valueOf(jTextField11.getText());
        
        jTextField12.setText(total+"");
    }
    
    private void displayMotherboard() {
        int mbIndex = jComboBox1.getSelectedIndex();
        Motherboard mb = this.motherboard.get(mbIndex);
        new DisplayMotherboard(mb).setVisible(true);
    }

    private void displayCpu() {
        int cpuIndex = jComboBox12.getSelectedIndex();
        Cpu cpu = this.cpu.get(cpuIndex);
        new DisplayCpu(cpu).setVisible(true);  
    }

    private void displayMemory() {
        int memoryIndex = jComboBox13.getSelectedIndex();
        Memory memory = this.memory.get(memoryIndex);
        new DisplayMemory(memory).setVisible(true);
        
    }

    private void displayGpu() {
        int gpuIndex = jComboBox14.getSelectedIndex();
        GraphicsCard gpu = this.gpu.get(gpuIndex);
        new DisplayGpu(gpu).setVisible(true);
    }

    private void displayMonitor() {
        int index = jComboBox15.getSelectedIndex();
        Monitor monitor = this.monitor.get(index);
        new DisplayMonitor(monitor).setVisible(true);
    }

    private void displayHdd() {
        int index = jComboBox16.getSelectedIndex();
        Hdd hdd = this.hdd.get(index);
        new DisplayHdd(hdd).setVisible(true);
    }

    private void displaySsd() {
        int index = jComboBox17.getSelectedIndex();
        Ssd ssd = this.ssd.get(index);
        new DisplaySsd(ssd).setVisible(true);
    }

    private void displayKeyboard() {
        int index = jComboBox18.getSelectedIndex();
        Keyboard kb = this.keyboard.get(index);
        new DisplayKeyboard(kb).setVisible(true);
    }

    private void displayMouse() {
        int index = jComboBox19.getSelectedIndex();
        Mouse mouse = this.mouse.get(index);
        new DisplayMouse(mouse).setVisible(true);
    }

    private void displayOpticDrive() {
        int index = jComboBox20.getSelectedIndex();
        Hdd hdd = this.hdd.get(index);
        new DisplayHdd(hdd).setVisible(true);
    }

    private void displayOperatingSystem() {
        int index = jComboBox21.getSelectedIndex();
        OperatingSystem os = this.os.get(index);
        new DisplayOperatingSystem(os).setVisible(true);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jComboBox1 = new javax.swing.JComboBox();
        jComboBox12 = new javax.swing.JComboBox();
        jComboBox13 = new javax.swing.JComboBox();
        jComboBox14 = new javax.swing.JComboBox();
        jComboBox15 = new javax.swing.JComboBox();
        jComboBox16 = new javax.swing.JComboBox();
        jComboBox17 = new javax.swing.JComboBox();
        jComboBox18 = new javax.swing.JComboBox();
        jComboBox19 = new javax.swing.JComboBox();
        jComboBox20 = new javax.swing.JComboBox();
        jComboBox21 = new javax.swing.JComboBox();
        jLabel23 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();
        jTextField3 = new javax.swing.JTextField();
        jTextField4 = new javax.swing.JTextField();
        jTextField5 = new javax.swing.JTextField();
        jTextField6 = new javax.swing.JTextField();
        jTextField7 = new javax.swing.JTextField();
        jTextField8 = new javax.swing.JTextField();
        jTextField9 = new javax.swing.JTextField();
        jTextField10 = new javax.swing.JTextField();
        jTextField11 = new javax.swing.JTextField();
        jLabel22 = new javax.swing.JLabel();
        jTextField12 = new javax.swing.JTextField();
        jButton3 = new javax.swing.JButton();
        jRadioButton1 = new javax.swing.JRadioButton();
        jRadioButton2 = new javax.swing.JRadioButton();
        jRadioButton3 = new javax.swing.JRadioButton();
        jRadioButton4 = new javax.swing.JRadioButton();
        jRadioButton5 = new javax.swing.JRadioButton();
        jRadioButton6 = new javax.swing.JRadioButton();
        jRadioButton7 = new javax.swing.JRadioButton();
        jRadioButton8 = new javax.swing.JRadioButton();
        jRadioButton9 = new javax.swing.JRadioButton();
        jRadioButton10 = new javax.swing.JRadioButton();
        jRadioButton11 = new javax.swing.JRadioButton();
        jButton1 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Our Suggestion");
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(204, 204, 204));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Calibri", 1, 12))); // NOI18N

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel(new String[] {}));
        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });

        jComboBox12.setModel(new javax.swing.DefaultComboBoxModel(new String[] {}));
        jComboBox12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox12ActionPerformed(evt);
            }
        });

        jComboBox13.setModel(new javax.swing.DefaultComboBoxModel(new String[] {}));
        jComboBox13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox13ActionPerformed(evt);
            }
        });

        jComboBox14.setModel(new javax.swing.DefaultComboBoxModel(new String[] {}));
        jComboBox14.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox14ActionPerformed(evt);
            }
        });

        jComboBox15.setModel(new javax.swing.DefaultComboBoxModel(new String[] {}));
        jComboBox15.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox15ActionPerformed(evt);
            }
        });

        jComboBox16.setModel(new javax.swing.DefaultComboBoxModel(new String[] {}));
        jComboBox16.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox16ActionPerformed(evt);
            }
        });

        jComboBox17.setModel(new javax.swing.DefaultComboBoxModel(new String[] {}));
        jComboBox17.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox17ActionPerformed(evt);
            }
        });

        jComboBox18.setModel(new javax.swing.DefaultComboBoxModel(new String[] {}));
        jComboBox18.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox18ActionPerformed(evt);
            }
        });

        jComboBox19.setModel(new javax.swing.DefaultComboBoxModel(new String[] {}));
        jComboBox19.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox19ActionPerformed(evt);
            }
        });

        jComboBox20.setModel(new javax.swing.DefaultComboBoxModel(new String[] {}));
        jComboBox20.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox20ActionPerformed(evt);
            }
        });

        jComboBox21.setModel(new javax.swing.DefaultComboBoxModel(new String[] {}));
        jComboBox21.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox21ActionPerformed(evt);
            }
        });

        jLabel23.setText("PRICE ($)");

        jTextField1.setEditable(false);
        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });

        jTextField2.setEditable(false);
        jTextField2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField2ActionPerformed(evt);
            }
        });

        jTextField3.setEditable(false);

        jTextField4.setEditable(false);

        jTextField5.setEditable(false);

        jTextField6.setEditable(false);

        jTextField7.setEditable(false);

        jTextField8.setEditable(false);

        jTextField9.setEditable(false);

        jTextField10.setEditable(false);

        jTextField11.setEditable(false);

        jLabel22.setText("TOTAL");

        jTextField12.setEditable(false);

        jButton3.setText("Inspect");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        buttonGroup1.add(jRadioButton1);
        jRadioButton1.setText("Motherboard");

        buttonGroup1.add(jRadioButton2);
        jRadioButton2.setText("CPU");

        buttonGroup1.add(jRadioButton3);
        jRadioButton3.setText("Memory");

        buttonGroup1.add(jRadioButton4);
        jRadioButton4.setText("GPU");

        buttonGroup1.add(jRadioButton5);
        jRadioButton5.setText("Monitor");

        buttonGroup1.add(jRadioButton6);
        jRadioButton6.setText("HDD");

        buttonGroup1.add(jRadioButton7);
        jRadioButton7.setText("SSD");

        buttonGroup1.add(jRadioButton8);
        jRadioButton8.setText("Keyboard");

        buttonGroup1.add(jRadioButton9);
        jRadioButton9.setText("Mouse");

        buttonGroup1.add(jRadioButton10);
        jRadioButton10.setText("Optic Drive");

        buttonGroup1.add(jRadioButton11);
        jRadioButton11.setText("Operating System");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(41, 41, 41)
                                .addComponent(jButton3)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jRadioButton2)
                                    .addComponent(jRadioButton1)
                                    .addComponent(jRadioButton4)
                                    .addComponent(jRadioButton5)
                                    .addComponent(jRadioButton6)
                                    .addComponent(jRadioButton3)
                                    .addComponent(jRadioButton7)
                                    .addComponent(jRadioButton8)
                                    .addComponent(jRadioButton9)
                                    .addComponent(jRadioButton10)
                                    .addComponent(jRadioButton11))))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jComboBox13, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jComboBox14, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jComboBox15, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jComboBox16, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jComboBox17, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jComboBox18, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jComboBox19, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jComboBox20, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jComboBox21, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jComboBox12, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel23)
                            .addComponent(jTextField2)
                            .addComponent(jTextField3)
                            .addComponent(jTextField4)
                            .addComponent(jTextField5)
                            .addComponent(jTextField6)
                            .addComponent(jTextField7)
                            .addComponent(jTextField8)
                            .addComponent(jTextField9)
                            .addComponent(jTextField10)
                            .addComponent(jTextField11)
                            .addComponent(jTextField1)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(315, 315, 315)
                        .addComponent(jLabel22)
                        .addGap(18, 18, 18)
                        .addComponent(jTextField12, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(116, Short.MAX_VALUE))
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jComboBox1, jComboBox12, jComboBox13, jComboBox14, jComboBox15, jComboBox16, jComboBox17, jComboBox18, jComboBox19, jComboBox20, jComboBox21});

        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel23)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(jComboBox1))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jRadioButton1)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jComboBox12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jRadioButton2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jComboBox13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jRadioButton3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jComboBox14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jRadioButton4))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jComboBox15, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jRadioButton5))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jComboBox16, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jRadioButton6)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jComboBox17, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jRadioButton7))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jComboBox18, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jRadioButton8))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jComboBox19, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jRadioButton9)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jTextField7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jComboBox20, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jRadioButton10))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jComboBox21, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jRadioButton11)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jTextField10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel22))
                .addGap(13, 13, 13)
                .addComponent(jButton3)
                .addGap(28, 28, 28))
        );

        jButton1.setText("Exit");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton4.setText("Export to PDF");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(33, 33, 33)
                        .addComponent(jButton4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton1)
                    .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField1ActionPerformed

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
        
        int mbIndex = jComboBox1.getSelectedIndex();
        Motherboard mb = motherboard.get(mbIndex);
        jTextField1.setText(mb.getPrice()+"");
        
        updateTotalPrice();
    }//GEN-LAST:event_jComboBox1ActionPerformed

    private void jComboBox13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox13ActionPerformed
        // TODO add your handling code here:
        int memoryIndex = jComboBox13.getSelectedIndex();
        Memory memory = this.memory.get(memoryIndex);
        jTextField3.setText(memory.getPrice()+"");
        
        updateTotalPrice();
    }//GEN-LAST:event_jComboBox13ActionPerformed

    private void jComboBox12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox12ActionPerformed
        // TODO add your handling code here:
        int cpuIndex = jComboBox12.getSelectedIndex();
        Cpu cpu = this.cpu.get(cpuIndex);
        jTextField2.setText(cpu.getPrice()+"");
        
        updateTotalPrice();
    }//GEN-LAST:event_jComboBox12ActionPerformed

    private void jComboBox14ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox14ActionPerformed
        // TODO add your handling code here:
        int gpuIndex = jComboBox14.getSelectedIndex();
        GraphicsCard gpu = this.gpu.get(gpuIndex);
        jTextField4.setText(gpu.getPrice()+"");
        
        updateTotalPrice();
    }//GEN-LAST:event_jComboBox14ActionPerformed

    private void jComboBox15ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox15ActionPerformed
        // TODO add your handling code here:
        int index = jComboBox15.getSelectedIndex();
        Monitor monitor = this.monitor.get(index);
        jTextField5.setText(monitor.getPrice()+"");
        
        updateTotalPrice();
    }//GEN-LAST:event_jComboBox15ActionPerformed

    private void jComboBox16ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox16ActionPerformed
        // TODO add your handling code here:
        int index = jComboBox16.getSelectedIndex();
        Hdd hdd = this.hdd.get(index);
        jTextField6.setText(hdd.getPrice()+"");
        
        updateTotalPrice();
    }//GEN-LAST:event_jComboBox16ActionPerformed

    private void jComboBox17ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox17ActionPerformed
        // TODO add your handling code here:
        int index = jComboBox17.getSelectedIndex();
        Ssd ssd = this.ssd.get(index);
        jTextField7.setText(ssd.getPrice()+"");
        
        updateTotalPrice();
    }//GEN-LAST:event_jComboBox17ActionPerformed

    private void jComboBox18ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox18ActionPerformed
        // TODO add your handling code here:
        int index = jComboBox15.getSelectedIndex();
        Keyboard keyboard = this.keyboard.get(index);
        jTextField8.setText(keyboard.getPrice()+"");
        
        updateTotalPrice();
    }//GEN-LAST:event_jComboBox18ActionPerformed

    private void jComboBox19ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox19ActionPerformed
        // TODO add your handling code here:
        int index = jComboBox19.getSelectedIndex();
        Mouse mouse = this.mouse.get(index);
        jTextField9.setText(mouse.getPrice()+"");
        
        updateTotalPrice();
    }//GEN-LAST:event_jComboBox19ActionPerformed

    private void jComboBox20ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox20ActionPerformed
        // TODO add your handling code here:
        int index = jComboBox20.getSelectedIndex();
        OpticDrive od = this.opticdrive.get(index);
        jTextField10.setText(od.getPrice()+"");
        
        updateTotalPrice();
    }//GEN-LAST:event_jComboBox20ActionPerformed

    private void jComboBox21ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox21ActionPerformed
        // TODO add your handling code here:
        int index = jComboBox21.getSelectedIndex();
        OperatingSystem os = this.os.get(index);
        jTextField11.setText(os.getPrice()+"");
        
        updateTotalPrice();
    }//GEN-LAST:event_jComboBox21ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        if(jRadioButton1.isSelected())
            displayMotherboard();   
        else if(jRadioButton2.isSelected())
            displayCpu();
        else if(jRadioButton3.isSelected())
            displayMemory();
        else if(jRadioButton4.isSelected())
            displayGpu();
        else if(jRadioButton5.isSelected())
            displayMonitor();
        else if(jRadioButton6.isSelected())
            displayHdd();
        else if(jRadioButton7.isSelected())
            displaySsd();
        else if(jRadioButton8.isSelected())
            displayKeyboard();
        else if(jRadioButton9.isSelected())
            displayMouse();
        else if(jRadioButton10.isSelected())
            displayOpticDrive();
        else if(jRadioButton11.isSelected())
            displayOperatingSystem();
        else
            JOptionPane.showMessageDialog(null, "Please select a component to display.", "Error", JOptionPane.ERROR_MESSAGE);
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jTextField2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField2ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        try {
            JFileChooser jf = new JFileChooser();
            File selFile = null;
            
            jf.setAcceptAllFileFilterUsed(false);
            FileNameExtensionFilter filter = new FileNameExtensionFilter("PDF", "pdf", "pdf");
            jf.setFileFilter(filter);
            
            if(jf.showSaveDialog(this) == JFileChooser.APPROVE_OPTION){
                selFile = jf.getSelectedFile();
            }
            
            String filepath = selFile.getAbsolutePath();
            Document document = new Document();
            PdfWriter.getInstance(document, new FileOutputStream(filepath + ".pdf"));
            document.open();


            //       create a table
            PdfPTable table = new PdfPTable(3);

            PdfPCell c1 = new PdfPCell(new Phrase("COMPONENTS"));
            c1.setHorizontalAlignment(Element.ALIGN_CENTER);
            table.addCell(c1);

            c1 = new PdfPCell(new Phrase("MODEL"));
            c1.setHorizontalAlignment(Element.ALIGN_CENTER);
            table.addCell(c1);

            c1 = new PdfPCell(new Phrase("PRICE"));
            c1.setHorizontalAlignment(Element.ALIGN_CENTER);
            table.addCell(c1);

//            c1 = new PdfPCell(new Phrase("Table Header 3"));
//            c1.setHorizontalAlignment(Element.ALIGN_CENTER);
//            table.addCell(c1);
//            table.setHeaderRows(1);

            double price = 0.0;

            table.addCell("Motherboard");
            table.addCell(motherboard.get(jComboBox1.getSelectedIndex()).getModel());
            table.addCell(Double.toString(motherboard.get(jComboBox1.getSelectedIndex()).getPrice()));
            price += motherboard.get(jComboBox1.getSelectedIndex()).getPrice();

            table.addCell("CPU");
            table.addCell(cpu.get(jComboBox12.getSelectedIndex()).getModel());
            table.addCell(Double.toString(cpu.get(jComboBox12.getSelectedIndex()).getPrice()));
            price += cpu.get(jComboBox12.getSelectedIndex()).getPrice();

            table.addCell("Memory");
            table.addCell(memory.get(jComboBox13.getSelectedIndex()).getModel());
            table.addCell(Double.toString(memory.get(jComboBox13.getSelectedIndex()).getPrice()));
            price += memory.get(jComboBox13.getSelectedIndex()).getPrice();

            table.addCell("GPU");
            table.addCell(gpu.get(jComboBox14.getSelectedIndex()).getModel());
            table.addCell(Double.toString(gpu.get(jComboBox14.getSelectedIndex()).getPrice()));
            price += gpu.get(jComboBox14.getSelectedIndex()).getPrice();

            table.addCell("Monitor");
            table.addCell(monitor.get(jComboBox15.getSelectedIndex()).getModel());
            table.addCell(Double.toString(monitor.get(jComboBox15.getSelectedIndex()).getPrice()));
            price += monitor.get(jComboBox15.getSelectedIndex()).getPrice();

            table.addCell("HDD");
            table.addCell(hdd.get(jComboBox16.getSelectedIndex()).getModel());
            table.addCell(Double.toString(hdd.get(jComboBox16.getSelectedIndex()).getPrice()));
            price += hdd.get(jComboBox16.getSelectedIndex()).getPrice();

            table.addCell("SSD");
            table.addCell(ssd.get(jComboBox17.getSelectedIndex()).getModel());
            table.addCell(Double.toString(ssd.get(jComboBox17.getSelectedIndex()).getPrice()));
            price += ssd.get(jComboBox17.getSelectedIndex()).getPrice();

            table.addCell("Keyboard");
            table.addCell(keyboard.get(jComboBox18.getSelectedIndex()).getModel());
            table.addCell(Double.toString(keyboard.get(jComboBox18.getSelectedIndex()).getPrice()));
            price += keyboard.get(jComboBox18.getSelectedIndex()).getPrice();

            table.addCell("Mouse");
            table.addCell(mouse.get(jComboBox19.getSelectedIndex()).getModel());
            table.addCell(Double.toString(mouse.get(jComboBox19.getSelectedIndex()).getPrice()));
            price += mouse.get(jComboBox19.getSelectedIndex()).getPrice();

            table.addCell("Optic Drive");
            table.addCell(opticdrive.get(jComboBox20.getSelectedIndex()).getModel());
            table.addCell(Double.toString(opticdrive.get(jComboBox20.getSelectedIndex()).getPrice()));
            price += opticdrive.get(jComboBox20.getSelectedIndex()).getPrice();

            table.addCell("Operating System");
            table.addCell(os.get(jComboBox21.getSelectedIndex()).getModel());
            table.addCell(Double.toString(os.get(jComboBox21.getSelectedIndex()).getPrice()));
            price += os.get(jComboBox21.getSelectedIndex()).getPrice();

            table.addCell("");
            table.addCell("TOTAL");
            table.addCell(Double.toString(price));

            document.add(table);





            document.close();

        } catch (Exception e) {
            // to do
        }
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        new UserHelpMenu(currentUser).setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

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
            java.util.logging.Logger.getLogger(SuggestionResultWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SuggestionResultWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SuggestionResultWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SuggestionResultWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /*
         * Create and display the form
         */
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                try {
                    new SuggestionResultWindow(null).setVisible(true);
                } catch (Exception ex) {
                    Logger.getLogger(SuggestionResultWindow.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JComboBox jComboBox1;
    private javax.swing.JComboBox jComboBox12;
    private javax.swing.JComboBox jComboBox13;
    private javax.swing.JComboBox jComboBox14;
    private javax.swing.JComboBox jComboBox15;
    private javax.swing.JComboBox jComboBox16;
    private javax.swing.JComboBox jComboBox17;
    private javax.swing.JComboBox jComboBox18;
    private javax.swing.JComboBox jComboBox19;
    private javax.swing.JComboBox jComboBox20;
    private javax.swing.JComboBox jComboBox21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    public javax.swing.JPanel jPanel1;
    private javax.swing.JRadioButton jRadioButton1;
    private javax.swing.JRadioButton jRadioButton10;
    private javax.swing.JRadioButton jRadioButton11;
    private javax.swing.JRadioButton jRadioButton2;
    private javax.swing.JRadioButton jRadioButton3;
    private javax.swing.JRadioButton jRadioButton4;
    private javax.swing.JRadioButton jRadioButton5;
    private javax.swing.JRadioButton jRadioButton6;
    private javax.swing.JRadioButton jRadioButton7;
    private javax.swing.JRadioButton jRadioButton8;
    private javax.swing.JRadioButton jRadioButton9;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField10;
    private javax.swing.JTextField jTextField11;
    private javax.swing.JTextField jTextField12;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField5;
    private javax.swing.JTextField jTextField6;
    private javax.swing.JTextField jTextField7;
    private javax.swing.JTextField jTextField8;
    private javax.swing.JTextField jTextField9;
    // End of variables declaration//GEN-END:variables
}
