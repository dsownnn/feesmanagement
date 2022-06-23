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
        btnViewAll = new javax.swing.JButton();
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

        panelSideBar.setBackground(new java.awt.Color(28, 48, 89));

        btnHome.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N
        btnHome.setText("View Reports");
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
        btnSearch.setText("Search Record");
        btnSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchActionPerformed(evt);
            }
        });

        btnEdit.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N
        btnEdit.setText("Edit Courses");
        btnEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditActionPerformed(evt);
            }
        });

        btnList.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N
        btnList.setText("Course List");
        btnList.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnListActionPerformed(evt);
            }
        });

        btnBack.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N
        btnBack.setText("Back to Dashboard");
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });

        btnViewAll.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N
        btnViewAll.setText("View all Records");
        btnViewAll.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnViewAllActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Lucida Grande", 1, 48)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Add Fees");

        javax.swing.GroupLayout panelSideBarLayout = new javax.swing.GroupLayout(panelSideBar);
        panelSideBar.setLayout(panelSideBarLayout);
        panelSideBarLayout.setHorizontalGroup(
            panelSideBarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelSideBarLayout.createSequentialGroup()
                .addGroup(panelSideBarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelSideBarLayout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addGroup(panelSideBarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(btnViewAll, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnBack, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnList, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnEdit, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnHome, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(panelSideBarLayout.createSequentialGroup()
                        .addGap(35, 35, 35)
                        .addComponent(jLabel4)))
                .addContainerGap(22, Short.MAX_VALUE))
        );
        panelSideBarLayout.setVerticalGroup(
            panelSideBarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelSideBarLayout.createSequentialGroup()
                .addGap(51, 51, 51)
                .addComponent(jLabel4)
                .addGap(55, 55, 55)
                .addComponent(btnSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnViewAll, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnEdit, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnList, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnHome, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnBack, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34))
        );

        btn_print.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N
        btn_print.setText("Insert");
        btn_print.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_printActionPerformed(evt);
            }
        });

        jLabel19.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N
        jLabel19.setText("Receiver Signature");

        txt_total.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N

        jLabel21.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N
        jLabel21.setText("Total");

        jLabel17.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N
        jLabel17.setText("VAT");

        txt_VAT.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N

        txt_Amount.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N
        txt_Amount.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_AmountActionPerformed(evt);
            }
        });

        jLabel20.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N
        jLabel20.setText("Fees*");

        txt_CourseName.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N
        txt_CourseName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_CourseNameActionPerformed(evt);
            }
        });

        txt_remark.setColumns(20);
        txt_remark.setRows(5);

        jLabel18.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N
        jLabel18.setText("Course name:");

        jLabel15.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N
        jLabel15.setText("Amount (VND)");

        jLabel16.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N
        jLabel16.setText("Details");

        jLabel12.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N
        jLabel12.setText("Course");

        jLabel13.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N
        jLabel13.setText("Roll No:");

        txt_Year1.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N

        jLabel11.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N
        jLabel11.setText("to");

        txt_Year2.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N
        txt_Year2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_Year2ActionPerformed(evt);
            }
        });

        jLabel10.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N
        jLabel10.setText("the following payment in the college office for the year");

        txt_ReceivedFrom.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N

        jLabel9.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N
        jLabel9.setText("Received From*:");

        lbl_bankName.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N
        lbl_bankName.setText("Bank Name*:");

        txt_bankName.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N

        combo_PaymentMode.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N
        combo_PaymentMode.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "--Select--", "Transfer", "Card", "Cash" }));
        combo_PaymentMode.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                combo_PaymentModeActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N
        jLabel3.setText("Mode of payment*:");

        jLabel1.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N
        jLabel1.setText("Receipt no*:");

        jLabel2.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N
        jLabel2.setText("REC-");

        txt_receiptNo.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N

        jLabel6.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N
        jLabel6.setText("Date*:");

        dateChooser.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N

        jLabel7.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N
        jLabel7.setText("Tax code:");

        txt_GSTNo.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N
        txt_GSTNo.setText("22HVSJH55");

        txt_transfer_code.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N

        lbl_transfer_code.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N
        lbl_transfer_code.setText("Transfer code*:");

        jLabel22.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N
        jLabel22.setText("Remark:");

        txt_rollNo.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N
        txt_rollNo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_rollNoActionPerformed(evt);
            }
        });

        comboCourse.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N
        comboCourse.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "--Select--", "Java", "Mysql", "Python" }));
        comboCourse.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboCourseActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(panelSideBar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(50, 50, 50)
                        .addComponent(jLabel1)
                        .addGap(24, 24, 24)
                        .addComponent(jLabel2)
                        .addGap(7, 7, 7)
                        .addComponent(txt_receiptNo, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(140, 140, 140)
                        .addComponent(jLabel6)
                        .addGap(5, 5, 5)
                        .addComponent(dateChooser, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(50, 50, 50)
                        .addComponent(jLabel3)
                        .addGap(12, 12, 12)
                        .addComponent(combo_PaymentMode, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(140, 140, 140)
                        .addComponent(jLabel7)
                        .addGap(15, 15, 15)
                        .addComponent(txt_GSTNo))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(50, 50, 50)
                        .addComponent(lbl_transfer_code)
                        .addGap(46, 46, 46)
                        .addComponent(txt_transfer_code, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(50, 50, 50)
                        .addComponent(lbl_bankName)
                        .addGap(67, 67, 67)
                        .addComponent(txt_bankName, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(50, 50, 50)
                        .addComponent(jLabel9)
                        .addGap(39, 39, 39)
                        .addComponent(txt_ReceivedFrom, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jSeparator6, javax.swing.GroupLayout.PREFERRED_SIZE, 900, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(320, 320, 320)
                        .addComponent(jLabel16)
                        .addGap(291, 291, 291)
                        .addComponent(jLabel15))
                    .addComponent(jSeparator5, javax.swing.GroupLayout.PREFERRED_SIZE, 900, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(50, 50, 50)
                        .addComponent(jLabel18)
                        .addGap(30, 30, 30)
                        .addComponent(txt_CourseName, javax.swing.GroupLayout.PREFERRED_SIZE, 310, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(90, 90, 90)
                        .addComponent(jLabel20)
                        .addGap(2, 2, 2)
                        .addComponent(txt_Amount, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(50, 50, 50)
                        .addComponent(jLabel22)
                        .addGap(78, 78, 78)
                        .addComponent(txt_remark, javax.swing.GroupLayout.PREFERRED_SIZE, 310, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(90, 90, 90)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel17)
                            .addComponent(jLabel21))
                        .addGap(6, 6, 6)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txt_VAT, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_total, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel19)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(200, 200, 200)
                        .addComponent(btn_print, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(50, 50, 50)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addComponent(jLabel12)
                                .addGap(123, 123, 123)
                                .addComponent(comboCourse, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(117, 117, 117)
                                .addComponent(jLabel13)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(txt_rollNo, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel10)
                                .addGap(10, 10, 10)
                                .addComponent(txt_Year1, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(10, 10, 10)
                                .addComponent(jLabel11)
                                .addGap(12, 12, 12)
                                .addComponent(txt_Year2, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(60, 60, 60)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txt_receiptNo, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(dateChooser, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(combo_PaymentMode, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_GSTNo, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(lbl_transfer_code, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(txt_transfer_code, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(lbl_bankName, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(txt_bankName, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(txt_ReceivedFrom, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txt_Year1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_Year2, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txt_rollNo, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(comboCourse, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(34, 34, 34)
                .addComponent(jSeparator6, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addComponent(jSeparator5, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txt_CourseName, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_Amount, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(jLabel22, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(txt_remark, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(20, 20, 20)
                        .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(txt_VAT, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(txt_total, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(20, 20, 20)
                        .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(20, 20, 20)
                .addComponent(btn_print, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(panelSideBar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txt_Year2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_Year2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_Year2ActionPerformed

    private void btnViewAllActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnViewAllActionPerformed
        View_All_Records view_all=new View_All_Records();
        view_all.show();
        this.dispose();
    }//GEN-LAST:event_btnViewAllActionPerformed

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
    private javax.swing.JButton btnViewAll;
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
