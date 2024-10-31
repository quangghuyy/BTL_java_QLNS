/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package View;

import Controller.NhapSachCtrl;
import Controller.NhapHangCtrl;
import Controller.XuatHangCtrl;
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
import FileHandler.PhieuXuatFileHandler;
import Model.PhieuXuat;

/**
 *
 * @author Lo Dai Luc
 */
public class XuatHang extends javax.swing.JPanel implements View {

    /**
     * Creates new form NhapHang
     */
    private DefaultTableModel modelSach;
    private DefaultTableModel modelNhapHang;
    private ArrayList<ChiTietPhieu> listCTP;

    public XuatHang() {
        initComponents();
        listCTP = new ArrayList<>();

        modelSach = (DefaultTableModel) tblSach.getModel();
        initTableSach(modelSach);

        modelNhapHang = (DefaultTableModel) tblNhapHang.getModel();
        initTableNhapHang(modelNhapHang);

        txtTongThanhToan.setEditable(false);
//        mauDeMO();
//        PhieuXuatFileHandler.getInstance().writeToFile("phieuxuat.txt", XuatHangCtrl.getList());
//        AutoIdGenerator.initializeCounterMaPhieuNhap(NhapHangCtrl.getList());
        
        this.showData(NhapSachCtrl.getList(), modelSach);
    }

    public void mauDeMO() {
        ChiTietPhieu chiTiet1 = new ChiTietPhieu("PX001", "MS001", "Sách A", 1, 50000.0);
        ChiTietPhieu chiTiet2 = new ChiTietPhieu("PX001", "MS002", "Sách B", 2, 75000.0);
        ChiTietPhieu chiTiet3 = new ChiTietPhieu("PX001", "MS003", "Sách C", 4, 60000.0);

        ChiTietPhieu chiTiet4 = new ChiTietPhieu("PX002", "MS004", "Sách D", 5, 55000.0);
        ChiTietPhieu chiTiet5 = new ChiTietPhieu("PX002", "MS005", "Sách E", 4, 80000.0);

        ChiTietPhieu chiTiet6 = new ChiTietPhieu("PX003", "MS006", "Sách F", 5, 45000.0);
        ChiTietPhieu chiTiet7 = new ChiTietPhieu("PX003", "MS007", "Sách G", 3, 90000.0);
        ChiTietPhieu chiTiet8 = new ChiTietPhieu("PX003", "MS008", "Sách H", 2, 30000.0);
        ChiTietPhieu chiTiet9 = new ChiTietPhieu("PX003", "MS009", "Sách I", 1, 65000.0);

        ArrayList<ChiTietPhieu> listCTP1 = new ArrayList<>(List.of(chiTiet1, chiTiet2, chiTiet3));
        ArrayList<ChiTietPhieu> listCTP2 = new ArrayList<>(List.of(chiTiet4, chiTiet5));
        ArrayList<ChiTietPhieu> listCTP3 = new ArrayList<>(List.of(chiTiet6, chiTiet7, chiTiet8, chiTiet9));

        PhieuXuat phieu1 = new PhieuXuat("PX001", "2024-07-09 10:00:00", listCTP1, 440000.0);
        PhieuXuat phieu2 = new PhieuXuat("PX002", "2024-08-09 11:00:00", listCTP2, 595000.0);
        PhieuXuat phieu3 = new PhieuXuat("PX003", "2024-09-09 12:00:00", listCTP3, 620000.0);

        try {
            XuatHangCtrl.luuPhieuXuat(phieu1);
            XuatHangCtrl.luuPhieuXuat(phieu2);
            XuatHangCtrl.luuPhieuXuat(phieu3);
        } catch (Exception e) {
        }
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
        jScrollPane2 = new javax.swing.JScrollPane();
        tblNhapHang = new javax.swing.JTable();
        btnXoa = new javax.swing.JButton();
        btnSuaSoLuong = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        txtTongThanhToan = new javax.swing.JTextField();
        btnXuatHang = new javax.swing.JButton();

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel2.setText("XUẤT HÀNG");

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(301, 301, 301)
                .addComponent(jLabel2)
                .addContainerGap(313, Short.MAX_VALUE))
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

        btnXuatHang.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnXuatHang.setText("Xuất Hàng");
        btnXuatHang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXuatHangActionPerformed(evt);
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
                        .addComponent(btnXuatHang)
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
                                .addComponent(txtSoLuong, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 184, Short.MAX_VALUE)))
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
                    .addComponent(txtSoLuong))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnXoa)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnSuaSoLuong)
                        .addComponent(jLabel4)
                        .addComponent(txtTongThanhToan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnXuatHang)))
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

    private void btnXuatHangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXuatHangActionPerformed
        // TODO add your handling code here:
        try {
            if (listCTP.isEmpty()) {
                throw new Exception("bạn chưa chọn sản phẩm để nhập hàng");
            }
            String maPhieu = AutoIdGenerator.generateMaPhieuXuat();
            String thoiGianTao = DateTimeUtils.formatDateTimeDefault(DateTimeUtils.getCurrentDateTime());
            String tongThanhToanText = NumberUtils.extractDigits(txtTongThanhToan.getText());
            double tongThanhToan = Double.parseDouble(tongThanhToanText);

            for (ChiTietPhieu cTP : listCTP) {
                cTP.setMaPhieu(maPhieu);
            }

            ArrayList<ChiTietPhieu> addlistCTP = new ArrayList<>(listCTP);
            PhieuXuat pX = new PhieuXuat(maPhieu, thoiGianTao, addlistCTP, tongThanhToan);
            addPhieuXuat(pX);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Lỗi", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnXuatHangActionPerformed
    public void addPhieuXuat(PhieuXuat pX) {
        try {
            XuatHangCtrl.luuPhieuXuat(pX);
            JOptionPane.showMessageDialog(null, "Xuất hàng thành công");

            int res = JOptionPane.showConfirmDialog(this, "Bạn có muốn xuất file pdf ?", "", JOptionPane.YES_NO_OPTION);
            if (res == JOptionPane.YES_OPTION) {
                PhieuXuatFileHandler.getInstance().exportExcel(XuatHangCtrl.getList());
            }
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
    private javax.swing.JButton btnSuaSoLuong;
    private javax.swing.JButton btnThem;
    private javax.swing.JButton btnXoa;
    private javax.swing.JButton btnXuatHang;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
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