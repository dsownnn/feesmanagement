/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package fee_managment;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author dsown
 */
public final class Add_Fees extends JFrame {

    private int receiptNo;



    /**
     * Creates new form Add_Fees
     */
    public Add_Fees() {
        initComponents();
        displayCashFirst();
        //fillComboBox();
        
        int receiptNo = getReceiptNo();
        txt_receiptNo.setText(Integer.toString(receiptNo));
    }
    
    public void displayCashFirst()
    {
        lbl_transfer_code.setVisible(false);
        lbl_bankName.setVisible(false);
        
        txt_transfer_code.setVisible(false);
        txt_bankName.setVisible(false);
    }
    
    public boolean validation() {
        
        if (txt_receiptNo.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Please enter Receipt number");
            return false;
        }
        
         if (combo_PaymentMode.getSelectedIndex() == 0) {
            JOptionPane.showMessageDialog(this, "Please choose the Payment mode");
            return false;
        }
        
        if (txt_ReceivedFrom.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Please enter payer");
            return false;
        }
        
        if (dateChooser.getDate() == null) {
            JOptionPane.showMessageDialog(this, "Please select a date");
            return false;          
        }
        
        if (txt_Amount.getText().equals("") || txt_Amount.getText().matches("[0-9]+") == false) {
            JOptionPane.showMessageDialog(this, "Please enter amount (in numbers)");
            return false;          
        }
        
        if(combo_PaymentMode.getSelectedItem().toString().equalsIgnoreCase("Transfer")) {
            
            if (txt_transfer_code.getText().equals("")) {
                JOptionPane.showMessageDialog(this, "Please enter Transfer code)");
                return false;
            }
            if (txt_bankName.getText().equals("")) {
                JOptionPane.showMessageDialog(this, "Please enter bank name");
            }
        }
        
        if (combo_PaymentMode.getSelectedItem().toString().equalsIgnoreCase("Card")) {
            if (txt_bankName.getText().equals("")) {
                JOptionPane.showMessageDialog(this, "Please enter bank name");
                return false;
            }
        }
        return true;
    }
    
    /*public void fillComboBox() {
        try {
            Connection con = DBConnection.getConnection();
            PreparedStatement pst = con.prepareStatement("select * from COURSE");
            ResultSet rs = pst.executeQuery();
            while(rs.next());{
                comboCourse.addItem(rs.getString("CNAME"));
            }
            
        } catch(Exception e) {
            e.printStackTrace();
        }
    }*/
    
    public int getReceiptNo() {
               
        try {
            Connection con = DBConnection.getConnection();
            PreparedStatement pst = con.prepareStatement("select max(receipt_no) from feesdetails");
            ResultSet rs = pst.executeQuery();
            
            if (rs.next() != true) {
            } else {
                receiptNo = rs.getInt(1);
            }
        } catch (SQLException e) {
        }
        return receiptNo+1;
    }
    
    public String insertData() {
        
        String status = ("");
        
        int receiptNo = Integer.parseInt(txt_receiptNo.getText());
        String studentName = txt_ReceivedFrom.getText();
        String rollNo = txt_rollNo.getText();
        String paymentMode = combo_PaymentMode.getSelectedItem().toString();
        String bankName = txt_bankName.getText();
        String transfer_code = txt_transfer_code.getText();
        String courseName = txt_CourseName.getText();
        
        //String gstin = txt_GSTNo.getText();
        float totalAmount = Float.parseFloat(txt_total.getText());
        SimpleDateFormat dateFormat = new SimpleDateFormat("YYYY-MM-dd");
        String date = dateFormat.format(dateChooser.getDate());
        float initialAmount = Float.parseFloat(txt_Amount.getText());
        float vat = Float.parseFloat(txt_VAT.getText());
        String remark = txt_remark.getText();
        int year1 = Integer.parseInt(txt_Year1.getText());
        int year2 = Integer.parseInt(txt_Year2.getText());
        
        try {
            Connection con = DBConnection.getConnection();
            PreparedStatement pst = con.prepareStatement("INSERT INTO feesdetails VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
            
            pst.setInt(1, receiptNo);
            pst.setString(2, studentName);
            pst.setString(3, rollNo);
            pst.setString(4, paymentMode);
            pst.setString(5, bankName);
            pst.setString(6, transfer_code);
            
            pst.setString(7, courseName);
            //pst.setString(8, gstin);
            pst.setFloat(8, totalAmount);
            pst.setString(9, date);
            pst.setFloat(10, initialAmount);
            pst.setFloat(11, vat);
            pst.setString(12, remark);
            pst.setInt(13, year1);
            pst.setInt(14, year2);
            
            int rowCount = pst.executeUpdate();
                if (rowCount == 1) {
                    status = "success";
                } else {
                    status = "failed";
                }
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return status;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelSideBar = new javax.swing.JPanel();
        btnHome = new javax.swing.JButton();
        btnSearch = new javax.swing.JButton();
        btnEdit = new javax.swing.JButton();
        btnList = new javax.swing.JButton();
        btnBack = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        btn_print = new javax.swing.JButton();
        jLabel19 = new javax.swing.JLabel();
        txt_total = new javax.swing.JTextField();
        jLabel21 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        txt_VAT = new javax.swing.JTextField();
        txt_Amount = new javax.swing.JTextField();
        jLabel20 = new javax.swing.JLabel();
        txt_CourseName = new javax.swing.JTextField();
        txt_remark = new javax.swing.JTextArea();
        jLabel18 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jSeparator5 = new javax.swing.JSeparator();
        jSeparator6 = new javax.swing.JSeparator();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        txt_Year1 = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        txt_Year2 = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        txt_ReceivedFrom = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        lbl_bankName = new javax.swing.JLabel();
        txt_bankName = new javax.swing.JTextField();
        combo_PaymentMode = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txt_receiptNo = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        dateChooser = new com.toedter.calendar.JDateChooser();
        jLabel7 = new javax.swing.JLabel();
        txt_GSTNo = new javax.swing.JLabel();
        txt_transfer_code = new javax.swing.JTextField();
        lbl_transfer_code = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        txt_rollNo = new javax.swing.JTextField();
        comboCourse = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panelSideBar.setBackground(new java.awt.Color(28, 48, 89));

        btnHome.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N
        btnHome.setIcon(new javax.swing.ImageIcon("/Users/dsown/Desktop/INS3035_JAVA/Tuitionfeemngm/Favicon/search (1).png")); // NOI18N
        btnHome.setText(" View Reports");
        btnHome.setHorizontalAlignment(javax.swing.SwingConstants.LEADING);
        btnHome.setInheritsPopupMenu(true);
        btnHome.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnHomeMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnHomeMouseExited(evt);
            }
        });
        btnHome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHomeActionPerformed(evt);
            }
        });

        btnSearch.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N
        btnSearch.setIcon(new javax.swing.ImageIcon("/Users/dsown/Desktop/INS3035_JAVA/Tuitionfeemngm/Favicon/search.png")); // NOI18N
        btnSearch.setText(" View Records");
        btnSearch.setHorizontalAlignment(javax.swing.SwingConstants.LEADING);
        btnSearch.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        btnSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchActionPerformed(evt);
            }
        });

        btnEdit.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N
        btnEdit.setIcon(new javax.swing.ImageIcon("/Users/dsown/Desktop/INS3035_JAVA/Tuitionfeemngm/Favicon/edit.png")); // NOI18N
        btnEdit.setText(" Edit Courses");
        btnEdit.setHorizontalAlignment(javax.swing.SwingConstants.LEADING);
        btnEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditActionPerformed(evt);
            }
        });

        btnList.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N
        btnList.setIcon(new javax.swing.ImageIcon("/Users/dsown/Desktop/INS3035_JAVA/Tuitionfeemngm/Favicon/file.png")); // NOI18N
        btnList.setText(" Course List");
        btnList.setHorizontalAlignment(javax.swing.SwingConstants.LEADING);
        btnList.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnListActionPerformed(evt);
            }
        });

        btnBack.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N
        btnBack.setIcon(new javax.swing.ImageIcon("/Users/dsown/Desktop/INS3035_JAVA/Tuitionfeemngm/Favicon/back.png")); // NOI18N
        btnBack.setText("Back to Dashboard");
        btnBack.setHorizontalAlignment(javax.swing.SwingConstants.LEADING);
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Lucida Grande", 1, 48)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Add Fees");
        jLabel4.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout panelSideBarLayout = new javax.swing.GroupLayout(panelSideBar);
        panelSideBar.setLayout(panelSideBarLayout);
        panelSideBarLayout.setHorizontalGroup(
            panelSideBarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelSideBarLayout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(panelSideBarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnBack, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnList, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnEdit, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnHome, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(22, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelSideBarLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel4)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panelSideBarLayout.setVerticalGroup(
            panelSideBarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelSideBarLayout.createSequentialGroup()
                .addGap(70, 70, 70)
                .addComponent(jLabel4)
                .addGap(79, 79, 79)
                .addComponent(btnSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnList, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnEdit, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnHome, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 217, Short.MAX_VALUE)
                .addComponent(btnBack, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34))
        );

        getContentPane().add(panelSideBar, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 756));

        btn_print.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N
        btn_print.setText("Insert");
        btn_print.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_printActionPerformed(evt);
            }
        });
        getContentPane().add(btn_print, new org.netbeans.lib.awtextra.AbsoluteConstraints(519, 667, 100, 60));

        jLabel19.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N
        jLabel19.setText("Receiver Signature");
        getContentPane().add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(990, 620, -1, 20));

        txt_total.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N
        getContentPane().add(txt_total, new org.netbeans.lib.awtextra.AbsoluteConstraints(969, 547, 220, 40));

        jLabel21.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N
        jLabel21.setText("Total");
        getContentPane().add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(919, 557, -1, 20));

        jLabel17.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N
        jLabel17.setText("VAT");
        getContentPane().add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(919, 517, -1, 20));

        txt_VAT.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N
        getContentPane().add(txt_VAT, new org.netbeans.lib.awtextra.AbsoluteConstraints(969, 507, 220, 40));

        txt_Amount.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N
        txt_Amount.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_AmountActionPerformed(evt);
            }
        });
        getContentPane().add(txt_Amount, new org.netbeans.lib.awtextra.AbsoluteConstraints(969, 467, 220, 40));

        jLabel20.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N
        jLabel20.setText("Fees*");
        getContentPane().add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(919, 477, -1, 20));

        txt_CourseName.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N
        txt_CourseName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_CourseNameActionPerformed(evt);
            }
        });
        getContentPane().add(txt_CourseName, new org.netbeans.lib.awtextra.AbsoluteConstraints(519, 467, 310, 40));

        txt_remark.setColumns(20);
        txt_remark.setRows(5);
        getContentPane().add(txt_remark, new org.netbeans.lib.awtextra.AbsoluteConstraints(519, 527, 310, 120));

        jLabel18.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N
        jLabel18.setText("Course name:");
        getContentPane().add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(369, 477, -1, 20));

        jLabel15.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N
        jLabel15.setText("Amount (VND)");
        getContentPane().add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(1010, 400, -1, 20));

        jLabel16.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N
        jLabel16.setText("Details");
        getContentPane().add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(639, 400, -1, 20));
        getContentPane().add(jSeparator5, new org.netbeans.lib.awtextra.AbsoluteConstraints(319, 430, 900, 10));
        getContentPane().add(jSeparator6, new org.netbeans.lib.awtextra.AbsoluteConstraints(319, 384, 900, 10));

        jLabel12.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N
        jLabel12.setText("Course");
        getContentPane().add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(369, 318, -1, 20));

        jLabel13.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N
        jLabel13.setText("Roll No:");
        getContentPane().add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(869, 320, -1, 20));

        txt_Year1.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N
        getContentPane().add(txt_Year1, new org.netbeans.lib.awtextra.AbsoluteConstraints(859, 260, 80, 40));

        jLabel11.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N
        jLabel11.setText("to");
        getContentPane().add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(949, 270, -1, 20));

        txt_Year2.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N
        txt_Year2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_Year2ActionPerformed(evt);
            }
        });
        getContentPane().add(txt_Year2, new org.netbeans.lib.awtextra.AbsoluteConstraints(979, 260, 80, 40));

        jLabel10.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N
        jLabel10.setText("the following payment in the college office for the year");
        getContentPane().add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(369, 270, -1, 20));

        txt_ReceivedFrom.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N
        getContentPane().add(txt_ReceivedFrom, new org.netbeans.lib.awtextra.AbsoluteConstraints(549, 220, 200, 40));

        jLabel9.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N
        jLabel9.setText("Received From*:");
        getContentPane().add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(369, 230, -1, 20));

        lbl_bankName.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N
        lbl_bankName.setText("Bank Name*:");
        getContentPane().add(lbl_bankName, new org.netbeans.lib.awtextra.AbsoluteConstraints(369, 190, -1, 20));

        txt_bankName.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N
        getContentPane().add(txt_bankName, new org.netbeans.lib.awtextra.AbsoluteConstraints(549, 180, 200, 40));

        combo_PaymentMode.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N
        combo_PaymentMode.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "--Select--", "Transfer", "Card", "Cash" }));
        combo_PaymentMode.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                combo_PaymentModeActionPerformed(evt);
            }
        });
        getContentPane().add(combo_PaymentMode, new org.netbeans.lib.awtextra.AbsoluteConstraints(549, 100, 200, 40));

        jLabel3.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N
        jLabel3.setText("Mode of payment*:");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(369, 110, -1, 20));

        jLabel1.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N
        jLabel1.setText("Receipt no*:");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(369, 70, -1, 20));

        jLabel2.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N
        jLabel2.setText("REC-");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(499, 70, -1, 20));

        txt_receiptNo.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N
        getContentPane().add(txt_receiptNo, new org.netbeans.lib.awtextra.AbsoluteConstraints(549, 60, 200, 40));

        jLabel6.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N
        jLabel6.setText("Date*:");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(889, 70, -1, 20));

        dateChooser.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N
        getContentPane().add(dateChooser, new org.netbeans.lib.awtextra.AbsoluteConstraints(949, 60, 190, 40));

        jLabel7.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N
        jLabel7.setText("Tax code:");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(889, 110, -1, 20));

        txt_GSTNo.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N
        txt_GSTNo.setText("22HVSJH55");
        getContentPane().add(txt_GSTNo, new org.netbeans.lib.awtextra.AbsoluteConstraints(989, 110, -1, 20));

        txt_transfer_code.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N
        getContentPane().add(txt_transfer_code, new org.netbeans.lib.awtextra.AbsoluteConstraints(549, 140, 200, 40));

        lbl_transfer_code.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N
        lbl_transfer_code.setText("Transfer code*:");
        getContentPane().add(lbl_transfer_code, new org.netbeans.lib.awtextra.AbsoluteConstraints(369, 150, -1, 20));

        jLabel22.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N
        jLabel22.setText("Remark:");
        getContentPane().add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(369, 527, -1, 20));

        txt_rollNo.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N
        txt_rollNo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_rollNoActionPerformed(evt);
            }
        });
        getContentPane().add(txt_rollNo, new org.netbeans.lib.awtextra.AbsoluteConstraints(979, 310, 80, 40));

        comboCourse.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N
        comboCourse.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "--Select--", "Java", "Mysql", "Python" }));
        comboCourse.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboCourseActionPerformed(evt);
            }
        });
        getContentPane().add(comboCourse, new org.netbeans.lib.awtextra.AbsoluteConstraints(552, 308, 200, 40));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txt_Year2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_Year2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_Year2ActionPerformed

    private void btnHomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHomeActionPerformed
        View_Reports report=new View_Reports();
        report.show();
        this.dispose();
    }//GEN-LAST:event_btnHomeActionPerformed

    private void btnHomeMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnHomeMouseExited

    }//GEN-LAST:event_btnHomeMouseExited

    private void btnHomeMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnHomeMouseEntered

    }//GEN-LAST:event_btnHomeMouseEntered

    private void combo_PaymentModeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_combo_PaymentModeActionPerformed
        if (combo_PaymentMode.getSelectedIndex() == 0) {
            lbl_transfer_code.setVisible(false);
            txt_transfer_code.setVisible(false);
            lbl_bankName.setVisible(false);
            txt_bankName.setVisible(false);
        }
        
        if (combo_PaymentMode.getSelectedIndex() == 1) {
            lbl_transfer_code.setVisible(true);
            txt_transfer_code.setVisible(true);
            lbl_bankName.setVisible(true);
            txt_bankName.setVisible(true);
        }
        
        if (combo_PaymentMode.getSelectedItem().equals("Card")) {
            lbl_transfer_code.setVisible(false);
            txt_transfer_code.setVisible(false);
            lbl_bankName.setVisible(true);
            txt_bankName.setVisible(true);
        }
        
        if (combo_PaymentMode.getSelectedItem().equals("Cash")){
            lbl_transfer_code.setVisible(false);
            txt_transfer_code.setVisible(false);
            lbl_bankName.setVisible(false);
            txt_bankName.setVisible(false);
        }
    }//GEN-LAST:event_combo_PaymentModeActionPerformed

    private void btn_printActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_printActionPerformed
        if (validation() == true){
            
            String result = insertData();
            if (result.equals("success")) {
                JOptionPane.showMessageDialog(this, "Record insert successfully");
            } else {
                JOptionPane.showMessageDialog(this, "Record insertion failed");
            }
        }
        
    }//GEN-LAST:event_btn_printActionPerformed

    private void txt_AmountActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_AmountActionPerformed
        Float amnt = Float.parseFloat(txt_Amount.getText());
        Float vat = (float)(amnt * 0.08);
        
        txt_VAT.setText(vat.toString());
        
        float total = amnt + vat;
        txt_total.setText(Float.toString(total));
    }//GEN-LAST:event_txt_AmountActionPerformed

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        Home home=new Home();
        home.show();
        this.dispose();
    }//GEN-LAST:event_btnBackActionPerformed

    private void txt_rollNoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_rollNoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_rollNoActionPerformed

    private void comboCourseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboCourseActionPerformed
        txt_CourseName.setText(comboCourse.getSelectedItem().toString());
    }//GEN-LAST:event_comboCourseActionPerformed

    private void btnSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchActionPerformed
        Search_Record search=new Search_Record();
        search.show();
        this.dispose();
    }//GEN-LAST:event_btnSearchActionPerformed

    private void btnEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditActionPerformed
        Edit_Course edit=new Edit_Course();
        edit.show();
        this.dispose();
    }//GEN-LAST:event_btnEditActionPerformed

    private void btnListActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnListActionPerformed
        View_Courses course=new View_Courses();
        course.show();
        this.dispose();
    }//GEN-LAST:event_btnListActionPerformed

    private void txt_CourseNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_CourseNameActionPerformed
        
    }//GEN-LAST:event_txt_CourseNameActionPerformed

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
            java.util.logging.Logger.getLogger(Add_Fees.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Add_Fees.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Add_Fees.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Add_Fees.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Add_Fees().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnEdit;
    private javax.swing.JButton btnHome;
    private javax.swing.JButton btnList;
    private javax.swing.JButton btnSearch;
    private javax.swing.JButton btn_print;
    private javax.swing.JComboBox<String> comboCourse;
    private javax.swing.JComboBox<String> combo_PaymentMode;
    private com.toedter.calendar.JDateChooser dateChooser;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.JSeparator jSeparator6;
    private javax.swing.JLabel lbl_bankName;
    private javax.swing.JLabel lbl_transfer_code;
    private javax.swing.JPanel panelSideBar;
    private javax.swing.JTextField txt_Amount;
    private javax.swing.JTextField txt_CourseName;
    private javax.swing.JLabel txt_GSTNo;
    private javax.swing.JTextField txt_ReceivedFrom;
    private javax.swing.JTextField txt_VAT;
    private javax.swing.JTextField txt_Year1;
    private javax.swing.JTextField txt_Year2;
    private javax.swing.JTextField txt_bankName;
    private javax.swing.JTextField txt_receiptNo;
    private javax.swing.JTextArea txt_remark;
    private javax.swing.JTextField txt_rollNo;
    private javax.swing.JTextField txt_total;
    private javax.swing.JTextField txt_transfer_code;
    // End of variables declaration//GEN-END:variables

    void setVisiable(boolean b) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
