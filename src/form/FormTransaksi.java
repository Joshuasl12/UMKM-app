/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package form;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author Joshua
 */
public class FormTransaksi extends javax.swing.JFrame {
    public PreparedStatement st1;
    public Statement st;
    public ResultSet rs;
    Connection cn = koneksi.KoneksiDB.BukaKoneksi();
    
    public FormTransaksi() {
        initComponents();
        showData();
        refreshComboMenu();
        refreshComboCashier();
    }
    
    class transaksi extends FormTransaksi{
        int harga, jumlah_beli, total_bayar;
        String id_transaksi, id_menu, id_kasir, nama_kasir, nama_menu, tanggal;
        
        public transaksi(){
            String cmb = cmbCashier.getSelectedItem().toString();
            String combo = cmbMenu.getSelectedItem().toString();
            String[] arr = combo.split(":");
            String[] arr1 = cmb.split(":");
            try{
                Date date = txtDate.getDate();
                DateFormat dateformat = new SimpleDateFormat("YYYY-MM-dd");
                this.tanggal = dateformat.format(date); 
            }catch(Exception e){
                JOptionPane.showMessageDialog(null, e);
            }
            this.id_menu = arr[0];
            this.nama_menu = arr[1];
            this.harga = Integer.parseInt(arr[2]);
            this.id_kasir = arr1[0];
            this.nama_kasir = arr1[1];
            this.id_transaksi = txtTransactionID.getText();
            this.jumlah_beli = Integer.parseInt(txtTotalBuy.getText());
            this.total_bayar = this.harga * this.jumlah_beli;
        }
    }
    
    
    public void refreshComboMenu(){
         try{
            st = cn.createStatement();
            rs = st.executeQuery("SELECT * FROM menu");
            while(rs.next()){
                    cmbMenu.addItem(rs.getString("id_menu")+":"+rs.getString("nama_menu")+":"+rs.getString("harga"));
            }
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
    }
    
    public void refreshComboCashier(){
         try{
            st = cn.createStatement();
            rs = st.executeQuery("SELECT * FROM user");  
            while(rs.next()){
                    cmbCashier.addItem(rs.getString("id_kasir")+":"+rs.getString("nama_kasir"));
            }
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
    }
    
    private void Clear(){
        txtTransactionID.setText("");
        txtTotalBuy.setText("");
        txtTotalPay.setText("");
          
        txtTransactionID.setEditable(true);
        btnSave.setText("Save");
    }
    
    private void searchData(){
        try {
            st = cn.createStatement();
            rs = st.executeQuery("SELECT * FROM transaksi WHERE " + 
                    cmbSearch.getSelectedItem().toString() + 
                    " LIKE '%" + txtSearch.getText() + "%'");
                    
            DefaultTableModel model = new DefaultTableModel();
            model.addColumn("ID Transaksi");
//            model.addColumn("ID Menu");
//            model.addColumn("ID Kasir");
            model.addColumn("Nama Kasir");
            model.addColumn("Tanggal");
            model.addColumn("Nama Menu");
            model.addColumn("Harga");
            model.addColumn("Jumlah Beli");
            model.addColumn("Total Bayar");
            
            model.getDataVector().removeAllElements();
            model.fireTableDataChanged();
            model.setRowCount(0);
            
            while(rs.next()){
                Object [] data = {
                    rs.getString("id_transaksi"),
//                    rs.getString("id_menu"),
//                    rs.getString("id_kasir"),
                    rs.getString("nama_kasir"),
                    rs.getString("tanggal"),
                    rs.getString("nama_menu"),
                    rs.getString("harga"),
                    rs.getString("jumlah_beli"),
                    rs.getString("total_bayar"),
                };
                model.addRow(data);
                tblTransaksi.setModel(model);
            }
            
        } catch (Exception e) {
            
        }           
    }
    
    private void showData(){
        try {
            st = cn.createStatement();
            rs = st.executeQuery("SELECT * FROM transaksi");
            
            DefaultTableModel model = new DefaultTableModel();
            model.addColumn("ID Transaksi");
//            model.addColumn("ID Menu");
//            model.addColumn("ID Kasir");
            model.addColumn("Nama Kasir");
            model.addColumn("Tanggal");
            model.addColumn("Nama Menu");
            model.addColumn("Harga");
            model.addColumn("Jumlah Beli");
            model.addColumn("Total Bayar");
            
            model.getDataVector().removeAllElements();
            model.fireTableDataChanged();
            model.setRowCount(0);
            
            while(rs.next()){
                Object [] data = {
                    rs.getString("id_transaksi"),
//                    rs.getString("id_menu"),
//                    rs.getString("id_kasir"),
                    rs.getString("nama_kasir"),
                    rs.getString("tanggal"),
                    rs.getString("nama_menu"),
                    rs.getString("harga"),
                    rs.getString("jumlah_beli"),
                    rs.getString("total_bayar"),
                };
                model.addRow(data);
                tblTransaksi.setModel(model);
            }
            
        } catch (Exception e) {
            
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

        jButton1 = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        cmbSearch = new javax.swing.JComboBox<>();
        txtTransactionID = new javax.swing.JTextField();
        txtSearch = new javax.swing.JTextField();
        btnExit = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        txtTotalBuy = new javax.swing.JTextField();
        btnSave = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        btnCancel = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblTransaksi = new javax.swing.JTable();
        jLabel6 = new javax.swing.JLabel();
        label = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtTotalPay = new javax.swing.JTextField();
        btnListMenu = new javax.swing.JButton();
        txtDate = new com.toedter.calendar.JDateChooser();
        cmbMenu = new javax.swing.JComboBox<>();
        cmbCashier = new javax.swing.JComboBox<>();
        btnPrint = new javax.swing.JButton();

        jButton1.setText("jButton1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Transaksi");
        setResizable(false);

        jLabel4.setText("Nama Menu  :");

        jLabel8.setText("Cari Data");

        jLabel5.setText("Jumlah Beli    :");

        cmbSearch.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "id_transaksi", "nama_kasir", "nama_menu" }));

        txtSearch.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtSearchKeyPressed(evt);
            }
        });

        btnExit.setText("Exit");
        btnExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExitActionPerformed(evt);
            }
        });

        jLabel2.setText("Transaksi");

        btnSave.setText("Save");
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });

        btnDelete.setText("Delete");
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });

        btnCancel.setText("Cancel");
        btnCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelActionPerformed(evt);
            }
        });

        jLabel1.setText("ID Transaksi   :");

        tblTransaksi.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "ID Transaksi", "Nama Kasir", "Tanggal", "Nama Menu", "Harga", "Jumlah Beli", "Total Bayar"
            }
        ));
        tblTransaksi.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblTransaksiMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblTransaksi);

        jLabel6.setText("Tanggal       :");

        label.setText("Nama Kasir  :");

        jLabel3.setText("Total Bayar    :");

        txtTotalPay.setEditable(false);

        btnListMenu.setText("Lihat Menu");
        btnListMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnListMenuActionPerformed(evt);
            }
        });

        btnPrint.setText("Print");
        btnPrint.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPrintActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel5)
                                            .addComponent(jLabel4)
                                            .addComponent(jLabel3))
                                        .addGap(20, 20, 20)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                            .addComponent(cmbMenu, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(txtTotalBuy, javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(txtTotalPay, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                        .addComponent(jLabel1)
                                        .addGap(18, 18, 18)
                                        .addComponent(txtTransactionID, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(btnSave, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(btnDelete)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(btnCancel)
                                        .addGap(18, 18, 18)
                                        .addComponent(btnListMenu)))
                                .addGap(40, 40, 40)))
                        .addGap(26, 26, 26)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(btnPrint, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnExit)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel6)
                                    .addComponent(label))
                                .addGap(19, 19, 19)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(cmbCashier, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtDate, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jLabel8)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(cmbSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 650, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(30, 30, 30))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(txtTransactionID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(cmbMenu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnExit)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(label)
                            .addComponent(cmbCashier, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addComponent(txtTotalBuy, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(13, 13, 13)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(30, 30, 30)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnSave)
                            .addComponent(btnDelete)
                            .addComponent(btnCancel)
                            .addComponent(btnListMenu)
                            .addComponent(btnPrint)))
                    .addComponent(txtTotalPay, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(25, 25, 25)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(cmbSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(40, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void txtSearchKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSearchKeyPressed
        // TODO add your handling code here:
        searchData();
    }//GEN-LAST:event_txtSearchKeyPressed

    private void btnExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExitActionPerformed
        // TODO add your handling code here:
        new FormMainMenu().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnExitActionPerformed

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
        // TODO add your handling code here:
        if(btnSave.getText()== "Save"){
            try{
                transaksi tran = new transaksi();
                txtTotalPay.setText("" + tran.total_bayar);
                this.st1 = cn.prepareStatement("insert into transaksi values(?,?,?,?,?,?,?,?,?)");
                this.st1.setString(1, tran.id_transaksi);
                this.st1.setString(2, tran.id_menu);
                this.st1.setString(3, tran.id_kasir);
                this.st1.setString(4, tran.nama_kasir);
                this.st1.setString(5, tran.tanggal);
                this.st1.setString(6, tran.nama_menu);
                this.st1.setInt(7, tran.harga);
                this.st1.setInt(8, tran.jumlah_beli);
                this.st1.setInt(9, tran.total_bayar);
                int choose = JOptionPane.showConfirmDialog(null, 
                            "Tanggal: " + tran.tanggal +
                            "\nPembelian: " + tran.jumlah_beli + " " + tran.nama_menu +
                            "\nTotal Bayar: " + tran.total_bayar + "\n",
                            "Tambahkan Transaksi?",
                            JOptionPane.YES_NO_OPTION);
                if(choose == JOptionPane.YES_OPTION){
                        this.st1.executeUpdate();
                        JOptionPane.showMessageDialog(null, "Data berhasil tersimpan" );
                        showData();
                        Clear();
                    }else{
                        Clear();
                    }
            }catch(Exception e){
                JOptionPane.showMessageDialog(null, e );
            }
        }else{
            try{
            transaksi tran = new transaksi();
            tran.id_transaksi = txtTransactionID.getText();
            this.st1 = cn.prepareStatement("update transaksi set id_menu=?,"
            + "id_kasir=?,nama_kasir=?,tanggal=?,nama_menu=?,harga=?,jumlah_beli=?,total_bayar=? "
            + "where id_transaksi=?");
            this.st1.setString(1, tran.id_menu);
            this.st1.setString(2, tran.id_kasir);
            this.st1.setString(3, tran.nama_kasir);
            this.st1.setString(4, tran.tanggal);
            this.st1.setString(5, tran.nama_menu);
            this.st1.setInt(6, tran.harga);
            this.st1.setInt(7, tran.jumlah_beli);
            this.st1.setInt(8, tran.total_bayar);
            this.st1.setString(9, tran.id_transaksi);
            this.st1.executeUpdate();
            JOptionPane.showMessageDialog(null, "Data berhasil terupdate" );
            showData();
            Clear();
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e );
        }
    }
    }//GEN-LAST:event_btnSaveActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        // TODO add your handling code here:
        if(txtTransactionID.getText().equals("")){
            JOptionPane.showMessageDialog(this, "Silahkan pilih data yang akan dihapus");
        }else{
            int answer = JOptionPane.showConfirmDialog(null, "Data akan terhapus, lanjutkan ?", "Konfirmasi", JOptionPane.YES_NO_OPTION);
            if(answer == 0){
                try {
                    st = cn.createStatement();
                    String sql = "DELETE FROM transaksi WHERE id_transaksi = '" + txtTransactionID.getText() + "'";
                    st.executeUpdate(sql);
                    showData();
                    Clear();
                    JOptionPane.showMessageDialog(null, "Data berhasil dihapus");         
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, e);
                }
            }
        }
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void btnCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelActionPerformed
        // TODO add your handling code here:
        Clear();
    }//GEN-LAST:event_btnCancelActionPerformed

    private void tblTransaksiMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblTransaksiMouseClicked
        // TODO add your handling code here:
        txtTransactionID.setText(tblTransaksi.getValueAt(tblTransaksi.getSelectedRow(), 0).toString());
        txtTotalBuy.setText(tblTransaksi.getValueAt(tblTransaksi.getSelectedRow(), 5).toString());
        txtTotalPay.setText(tblTransaksi.getValueAt(tblTransaksi.getSelectedRow(), 6).toString());
        try {
            DefaultTableModel model = (DefaultTableModel)tblTransaksi.getModel();
            int index = tblTransaksi.getSelectedRow();
            Date date = new SimpleDateFormat("YYYY-MM-dd").parse((String)model.getValueAt(index, 2));
            txtDate.setDate(date);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        txtTransactionID.setEditable(false);
        btnSave.setText("Edit");
    }//GEN-LAST:event_tblTransaksiMouseClicked

    private void btnListMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnListMenuActionPerformed
        // TODO add your handling code here:
        new FormData().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnListMenuActionPerformed

    private void btnPrintActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPrintActionPerformed
        // TODO add your handling code here:
         try{
            JasperPrint jp = JasperFillManager.fillReport(getClass().getResourceAsStream("reportTransaksi.jasper"),
                null, koneksi.KoneksiDB.BukaKoneksi());
            JasperViewer.viewReport(jp);
        }catch (Exception ex){
            JOptionPane.showMessageDialog(rootPane, ex);
        }
    }//GEN-LAST:event_btnPrintActionPerformed

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
            java.util.logging.Logger.getLogger(FormTransaksi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FormTransaksi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FormTransaksi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FormTransaksi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FormTransaksi().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancel;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnExit;
    private javax.swing.JButton btnListMenu;
    private javax.swing.JButton btnPrint;
    private javax.swing.JButton btnSave;
    private javax.swing.JComboBox<String> cmbCashier;
    private javax.swing.JComboBox<String> cmbMenu;
    private javax.swing.JComboBox<String> cmbSearch;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel label;
    private javax.swing.JTable tblTransaksi;
    private com.toedter.calendar.JDateChooser txtDate;
    private javax.swing.JTextField txtSearch;
    private javax.swing.JTextField txtTotalBuy;
    private javax.swing.JTextField txtTotalPay;
    private javax.swing.JTextField txtTransactionID;
    // End of variables declaration//GEN-END:variables
}
