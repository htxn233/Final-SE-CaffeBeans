/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package coffeeit.system;

import common.OpenPdf;

import controler.BillControler;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import model.Bill;
import java.text.DecimalFormat;

/**
 *
 * @author Win
 */
public class ViewBillsOrder extends javax.swing.JFrame {

    /**
     * Creates new form ViewBillsOrder
     */
    private DecimalFormat decimalFormat = new DecimalFormat("#,##0");

    public ViewBillsOrder() {
        initComponents();
        SimpleDateFormat dFormat = new SimpleDateFormat("dd-MM-yyy");
        Date date = new Date();
        String today = dFormat.format(date);
        txtGetDate.setText(today);
    }
    
    public void tableDetails(){
        String date = txtGetDate.getText();
        String incDec = (String) cbIncDesc.getSelectedItem();
        DefaultTableModel dtm = (DefaultTableModel) jTable1.getModel();
        dtm.setRowCount(0);
        double revenue = 0;
        if(incDec.equals("INC")){
            ArrayList<Bill> list = BillControler.getAllRecordsByInc(date);
            Iterator<Bill> itr = list.iterator();
            while(itr.hasNext()){
                Bill billObj = itr.next();
                dtm.addRow(new Object[] {billObj.getId(), billObj.getName(), billObj.getMobileNumber(), billObj.getEmail(), billObj.getDate(), billObj.getTotal(), billObj.getCreateBy()});
                revenue += Double.parseDouble(billObj.getTotal().replace(",", ""));
            }
        }
        else
        {
            ArrayList<Bill> list = BillControler.getAllRecordsByDesc(date);
            Iterator<Bill> itr = list.iterator();
            while(itr.hasNext()){
                Bill billObj = itr.next();
                dtm.addRow(new Object[] {billObj.getId(), billObj.getName(), billObj.getMobileNumber(), billObj.getEmail(), billObj.getDate(), billObj.getTotal(), billObj.getCreateBy()});
                revenue += Double.parseDouble(billObj.getTotal().replace(",", ""));

            }
        }
        dtm.addRow(new Object[] {"", "", "", "", "", "", ""});
        dtm.addRow(new Object[] {"", "", "", "", "REVENUE", decimalFormat.format(revenue), ""});
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
        jButton1 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        txtGetDate = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        cbIncDesc = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                formComponentShown(evt);
            }
        });
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(51, 102, 0));
        jLabel1.setText("Bill Detail");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 20, 200, 50));

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/quit.png"))); // NOI18N
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1230, 10, -1, -1));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setText("Fillter by Date");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 160, -1, -1));

        txtGetDate.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txtGetDate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtGetDateActionPerformed(evt);
            }
        });
        txtGetDate.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtGetDateKeyReleased(evt);
            }
        });
        getContentPane().add(txtGetDate, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 160, 310, -1));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setText(" Order By ");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 120, -1, -1));

        cbIncDesc.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        cbIncDesc.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "INC", "DESC" }));
        cbIncDesc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbIncDescActionPerformed(evt);
            }
        });
        getContentPane().add(cbIncDesc, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 120, 313, -1));

        jTable1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Name", "Mobile Number", "Email", "Datel", "Total", "CreateBy"
            }
        ));
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 320, 1280, 550));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/My password-bro (2).png"))); // NOI18N
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, -60, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        setVisible(false);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void txtGetDateKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtGetDateKeyReleased
        // TODO add your handling code here:
        tableDetails();
    }//GEN-LAST:event_txtGetDateKeyReleased

    private void cbIncDescActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbIncDescActionPerformed
        // TODO add your handling code here:
        tableDetails();
    }//GEN-LAST:event_cbIncDescActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        // TODO add your handling code here:
        int index = jTable1.getSelectedRow();
        TableModel model = jTable1.getModel();
        String id = model.getValueAt(index, 0).toString();
        String[] dateComponent = id.split("/");
        String impPath = dateComponent[0] + dateComponent[1] + dateComponent[2];
        
        OpenPdf.openById(impPath);
    }//GEN-LAST:event_jTable1MouseClicked

    private void formComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_formComponentShown
        // TODO add your handling code here:
        tableDetails();
    }//GEN-LAST:event_formComponentShown

    private void txtGetDateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtGetDateActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtGetDateActionPerformed

    /**
     * @param args the command line arguments
     */
  

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> cbIncDesc;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField txtGetDate;
    // End of variables declaration//GEN-END:variables
}
