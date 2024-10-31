/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package View;

import Controller.NhapSachCtrl;
import Controller.NhapHangCtrl;
import Model.PhieuNhap;
import Model.Sach;
import java.util.List;
import javax.swing.table.DefaultTableModel;
import Utils.NumberUtils;
import Utils.AutoIdGenerator;
import Model.ChiTietPhieu;
import Utils.DateTimeUtils;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import static javax.swing.JOptionPane.QUESTION_MESSAGE;
import FileHandler.PhieuNhapFileHandler;

/**
 *
 * @author Lo Dai Luc
 */
public class NhapHang extends javax.swing.JPanel implements View {

    /**
     * Creates new form NhapHang
     */
    private DefaultTableModel modelSach;
    private DefaultTableModel modelNhapHang;
    private ArrayList<ChiTietPhieu> listCTP;

    public NhapHang() {
        initComponents();
        listCTP = new ArrayList<>();

        modelSach = (DefaultTableModel) tblSach.getModel();
        initTableSach(modelSach);

        modelNhapHang = (DefaultTableModel) tblNhapHang.getModel();
        initTableNhapHang(modelNhapHang);

        cboNhaCungCap.setSelectedItem(null);

        txtTongThanhToan.setEditable(false);
        
//        mauDeMO();
//        PhieuNhapFileHandler.getInstance().writeToFile("phieunhap.txt", NhapHangCtrl.getList());
//        AutoIdGenerator.initializeCounterMaPhieuNhap(NhapHangCtrl.getList());
        
        this.showData(NhapSachCtrl.getList(), modelSach);
    }

    public void mauDeMO() {
        ChiTietPhieu chiTiet1 = new ChiTietPhieu("PN001", "MS001", "Sách A", 10, 50000.0);
        ChiTietPhieu chiTiet2 = new ChiTietPhieu("PN001", "MS002", "Sách B", 5, 75000.0);
        ChiTietPhieu chiTiet3 = new ChiTietPhieu("PN001", "MS003", "Sách C", 20, 60000.0);

        ChiTietPhieu chiTiet4 = new ChiTietPhieu("PN002", "MS004", "Sách D", 15, 55000.0);
        ChiTietPhieu chiTiet5 = new ChiTietPhieu("PN002", "MS005", "Sách E", 8, 80000.0);

        ChiTietPhieu chiTiet6 = new ChiTietPhieu("PN003", "MS006", "Sách F", 12, 45000.0);
        ChiTietPhieu chiTiet7 = new ChiTietPhieu("PN003", "MS007", "Sách G", 7, 90000.0);
        ChiTietPhieu chiTiet8 = new ChiTietPhieu("PN003", "MS008", "Sách H", 25, 30000.0);
        ChiTietPhieu chiTiet9 = new ChiTietPhieu("PN003", "MS009", "Sách I", 11, 65000.0);

        ArrayList<ChiTietPhieu> listCTP1 = new ArrayList<>(List.of(chiTiet1, chiTiet2, chiTiet3));
        ArrayList<ChiTietPhieu> listCTP2 = new ArrayList<>(List.of(chiTiet4, chiTiet5));
        ArrayList<ChiTietPhieu> listCTP3 = new ArrayList<>(List.of(chiTiet6, chiTiet7, chiTiet8, chiTiet9));

        PhieuNhap phieuNhap1 = new PhieuNhap("Nhà Cung Cấp 1", "PN001", "2024-07-09 10:00:00", listCTP1, 1550000.0);
        PhieuNhap phieuNhap2 = new PhieuNhap("Nhà Cung Cấp 2", "PN002", "2024-08-09 11:00:00", listCTP2, 1350000.0);
        PhieuNhap phieuNhap3 = new PhieuNhap("Nhà Cung Cấp 3", "PN003", "2024-09-09 12:00:00", listCTP3, 3650000.0);

        NhapHangCtrl.luuPhieuNhap(phieuNhap1);
        NhapHangCtrl.luuPhieuNhap(phieuNhap2);
        NhapHangCtrl.luuPhieuNhap(phieuNhap3);
    }

    public final void initTableSach(DefaultTableModel modelSach) {
        String[] headerTbl = new String[]{"STT", "Mã sách", "Tên sách", "Thể loại", "Tác giả", "Giá", "Số Lượng"};
        modelSach.setColumnIdentifiers(headerTbl);
        tblSach.setModel(modelSach);

        tblSach.getColumnModel().getColumn(0).setPreferredWidth(5);
        tblSach.getColumnModel().getColumn(1).setPreferredWidth(50);
        tblSach.getColumnModel().getColumn(2).setPreferredWidth(200);
        tblSach.getColumnModel().getColumn(3).setPreferredWidth(100);
        tblSach.getColumnModel().getColumn(4).setPreferredWidth(150);
        tblSach.getColumnModel().getColumn(5).setPreferredWidth(100);
        tblSach.getColumnModel().getColumn(6).setPreferredWidth(50);

        tblSach.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
    }

    public final void initTableNhapHang(DefaultTableModel modelNhapHang) {
        String[] headerTbl = new String[]{"STT", "Mã sách", "Tên sách", "Số lượng", "Đơn giá", "Thành tiền"};
        modelNhapHang.setColumnIdentifiers(headerTbl);
        tblNhapHang.setModel(modelNhapHang);

        tblNhapHang.getColumnModel().getColumn(0).setPreferredWidth(5);
        tblNhapHang.getColumnModel().getColumn(1).setPreferredWidth(50);
        tblNhapHang.getColumnModel().getColumn(2).setPreferredWidth(200);
        tblNhapHang.getColumnModel().getColumn(3).setPreferredWidth(50);
        tblNhapHang.getColumnModel().getColumn(4).setPreferredWidth(100);
        tblNhapHang.getColumnModel().getColumn(5).setPreferredWidth(100);

        tblNhapHang.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel6 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        txtTimKiem = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblSach = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        txtSoLuong = new javax.swing.JTextField();
        btnThem = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblNhapHang = new javax.swing.JTable();
        btnXoa = new javax.swing.JButton();
        btnSuaSoLuong = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        txtTongThanhToan = new javax.swing.JTextField();
        btnNhapHang = new javax.swing.JButton();
        cboNhaCungCap = new javax.swing.JComboBox<>();

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel2.setText("NHẬP HÀNG");

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(301, 301, 301)
                .addComponent(jLabel2)
                .addContainerGap(309, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addContainerGap(21, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addGap(19, 19, 19))
        );

        txtTimKiem.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        txtTimKiem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTimKiemActionPerformed(evt);
            }
        });
        txtTimKiem.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtTimKiemKeyReleased(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel6.setText("Tìm Kiếm:");

        tblSach.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "STT", "Mã Sách", "Tên Sách", "Thể Loại", "Tác Giả", "Giá", "Số Lượng"
            }
        ));
        jScrollPane1.setViewportView(tblSach);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel1.setText("Số Lượng:");

        txtSoLuong.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        btnThem.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnThem.setText("Thêm");
        btnThem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel3.setText("Nhà Cung Cấp:");

        tblNhapHang.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "STT", "Mã Sách", "Tên Sách", "Số Lượng", "Đơn Giá", "Thành Tiền"
            }
        ));
        jScrollPane2.setViewportView(tblNhapHang);

        btnXoa.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnXoa.setText("Xóa");
        btnXoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaActionPerformed(evt);
            }
        });

        btnSuaSoLuong.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnSuaSoLuong.setText("Sửa Số Lượng");
        btnSuaSoLuong.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSuaSoLuongActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel4.setText("Tổng Thanh Toán:");

        txtTongThanhToan.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N

        btnNhapHang.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnNhapHang.setText("Nhập Hàng");
        btnNhapHang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNhapHangActionPerformed(evt);
            }
        });

        cboNhaCungCap.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        cboNhaCungCap.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Nhà xuất bản Lao Động", "Nhà xuất bản Kim Đồng", "Nhà xuất bản Giáo dục", "Nhà xuất bản Thanh Niên", "Nhà xuất bản Trẻ" }));
        cboNhaCungCap.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboNhaCungCapActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(60, 60, 60)
                        .addComponent(btnXoa)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnSuaSoLuong)
                        .addGap(34, 34, 34)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtTongThanhToan, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnNhapHang)
                        .addGap(44, 44, 44))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(145, 145, 145)
                                .addComponent(jLabel6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 329, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(93, 93, 93)
                                .addComponent(btnThem)
                                .addGap(20, 20, 20)
                                .addComponent(jLabel1)
                                .addGap(18, 18, 18)
                                .addComponent(txtSoLuong, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(61, 61, 61)
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cboNhaCungCap, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnThem)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtSoLuong)
                    .addComponent(jLabel3)
                    .addComponent(cboNhaCungCap, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnXoa)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnSuaSoLuong)
                        .addComponent(jLabel4)
                        .addComponent(txtTongThanhToan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnNhapHang)))
                .addGap(61, 61, 61))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void txtTimKiemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTimKiemActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTimKiemActionPerformed

    private void txtTimKiemKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTimKiemKeyReleased
        // TODO add your handling code here:
        String keyword = txtTimKiem.getText().trim().toLowerCase();

        List<Sach> searchResult = NhapSachCtrl.timKiemSach(keyword);
        showData(searchResult, modelSach);
    }//GEN-LAST:event_txtTimKiemKeyReleased

    private void btnThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemActionPerformed
        // TODO add your handling code here:
        ChiTietPhieu cTP = new ChiTietPhieu();
        int selectedRow = tblSach.getSelectedRow();

        try {
            if (selectedRow < 0) {
                throw new Exception("Vui lòng chọn sách để nhập hàng.");
            }

            String soLuongText = txtSoLuong.getText();
            int soLuong = Integer.parseInt(soLuongText);

            if (soLuong <= 0) {
                throw new Exception("Số lượng nhập phải là số nguyên dương lớn hơn 0.");
            }
            String nhaCungCap = (String) cboNhaCungCap.getSelectedItem();
            if (nhaCungCap == null) {
                throw new Exception("vui lòng chọn nhà cung cấp");
            }

            Sach selectedSach = NhapSachCtrl.getList().get(selectedRow);
            for (ChiTietPhieu kiemTraCTP : listCTP) {
                if (selectedSach.getMaSach().equalsIgnoreCase(kiemTraCTP.getMaSach())) {
                    int themSoLuong = kiemTraCTP.getSoLuong() + soLuong;
                    kiemTraCTP.setSoLuong(themSoLuong);
                    showData(listCTP, modelNhapHang);
                    txtTongThanhToan.setText(TongThanhToan(modelNhapHang));
                    return;
                }
            }

            cTP.setMaSach(selectedSach.getMaSach());
            cTP.setTenSach(selectedSach.getTenSach());
            cTP.setDonGia(selectedSach.getGia());
            cTP.setSoLuong(soLuong);
            listCTP.add(cTP);

            showData(listCTP, modelNhapHang);
            txtTongThanhToan.setText(TongThanhToan(modelNhapHang));
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Số lượng không hợp lệ. Vui lòng nhập số nguyên dương.", "Lỗi", JOptionPane.ERROR_MESSAGE);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Lỗi", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnThemActionPerformed
    public String TongThanhToan(DefaultTableModel modelNhapHang) {
        int col = 5; // Cột thành tiền

        double tong = 0;
        for (int row = 0; row < modelNhapHang.getRowCount(); row++) {
            String valueText = (String) modelNhapHang.getValueAt(row, col);
            valueText = NumberUtils.extractDigits(valueText);
            double value = Double.parseDouble(valueText);
            tong += value;
        }
        return NumberUtils.formatCurrency(tong);
    }
    private void cboNhaCungCapActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboNhaCungCapActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cboNhaCungCapActionPerformed

    private void btnXoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaActionPerformed
        // TODO add your handling code here:
        int selectedRow = tblNhapHang.getSelectedRow();
        if (selectedRow != -1) {
            listCTP.remove(selectedRow);
            showData(listCTP, modelNhapHang);
            txtTongThanhToan.setText(TongThanhToan(modelNhapHang));
        } else {
            JOptionPane.showMessageDialog(null, "Vui lòng chọn một sản phẩm để xóa.", "Lỗi", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnXoaActionPerformed

    private void btnSuaSoLuongActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuaSoLuongActionPerformed
        // TODO add your handling code here:
        int selectedRow = tblNhapHang.getSelectedRow();

        try {
            if (selectedRow == -1) {
                throw new Exception("Vui lòng chọn sản phẩm để sửa số lượng");
            }
            String soLuongText = JOptionPane.showInputDialog(this, "Nhập số lượng cần thay đổi", "Thay đổi số lượng", QUESTION_MESSAGE);

            if (soLuongText == null) {
                return;
            }

            int soLuong = Integer.parseInt(soLuongText);
            if (soLuong <= 0) {
                throw new Exception("Số lượng nhập phải là số nguyên dương lớn hơn 0.");
            }

            ChiTietPhieu selectedCTP = listCTP.get(selectedRow);
            selectedCTP.setSoLuong(soLuong);
            showData(listCTP, modelNhapHang);
            txtTongThanhToan.setText(TongThanhToan(modelNhapHang));
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Số lượng không hợp lệ. Vui lòng nhập số nguyên dương.", "Lỗi", JOptionPane.ERROR_MESSAGE);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Lỗi", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnSuaSoLuongActionPerformed

    private void btnNhapHangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNhapHangActionPerformed
        // TODO add your handling code here:
        try {
            if (listCTP.isEmpty()) {
                throw new Exception("bạn chưa chọn sản phẩm để nhập hàng");
            }

            String nhaCungCap = (String) cboNhaCungCap.getSelectedItem();
            String maPhieu = AutoIdGenerator.generateMaPhieuNhap();
            String thoiGianTao = DateTimeUtils.formatDateTimeDefault(DateTimeUtils.getCurrentDateTime());
            String tongThanhToanText = NumberUtils.extractDigits(txtTongThanhToan.getText());
            double tongThanhToan = Double.parseDouble(tongThanhToanText);

            for (ChiTietPhieu cTP : listCTP) {
                cTP.setMaPhieu(maPhieu);
            }

            ArrayList<ChiTietPhieu> addlistCTP = new ArrayList<>(listCTP);
            PhieuNhap pN = new PhieuNhap(nhaCungCap, maPhieu, thoiGianTao, addlistCTP, tongThanhToan);
            addPhieuNhap(pN);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Lỗi", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnNhapHangActionPerformed
    public void addPhieuNhap(PhieuNhap pN) {
        try {
            NhapHangCtrl.luuPhieuNhap(pN);
            JOptionPane.showMessageDialog(null, "nhập hàng thành công");

            int res = JOptionPane.showConfirmDialog(this, "Bạn có muốn xuất file pdf ?", "", JOptionPane.YES_NO_OPTION);
            if (res == JOptionPane.YES_OPTION) {
                PhieuNhapFileHandler.getInstance().exportPDF(pN);
            }
            cboNhaCungCap.setSelectedItem(null);
            txtSoLuong.setText("");
            txtTongThanhToan.setText("");

            listCTP.clear();
            
            showData(listCTP, modelNhapHang);
            showData(NhapSachCtrl.getList(), modelSach);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Lỗi", JOptionPane.ERROR_MESSAGE);
        }

    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnNhapHang;
    private javax.swing.JButton btnSuaSoLuong;
    private javax.swing.JButton btnThem;
    private javax.swing.JButton btnXoa;
    private javax.swing.JComboBox<String> cboNhaCungCap;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tblNhapHang;
    private javax.swing.JTable tblSach;
    private javax.swing.JTextField txtSoLuong;
    private javax.swing.JTextField txtTimKiem;
    private javax.swing.JTextField txtTongThanhToan;
    // End of variables declaration//GEN-END:variables

    @Override
    public <T> void showData(List<T> list, DefaultTableModel model) {
        model.setRowCount(0);
        int n = 1;
        for (T t : list) {
            if (t instanceof Sach) {
                Sach s = (Sach) t;
                model.addRow(new Object[]{
                    n++, s.getMaSach(), s.getTenSach(), s.getTheLoai(), s.getTacGia(),
                    NumberUtils.formatCurrency(s.getGia()), s.getSoLuong()
                });
            }
        }

        for (T t : list) {
            if (t instanceof ChiTietPhieu) {
                ChiTietPhieu cTP = (ChiTietPhieu) t;
                model.addRow(new Object[]{
                    n++, cTP.getMaSach(), cTP.getTenSach(), cTP.getSoLuong(),
                    NumberUtils.formatCurrency(cTP.getDonGia()), NumberUtils.formatCurrency(cTP.getTongTien())
                });
            }
        }
    }
}
