/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import FileHandler.PhieuNhapFileHandler;
import FileHandler.PhieuXuatFileHandler;
import Model.Sach;
import java.util.ArrayList;
import java.util.List;
import FileHandler.SachFileHandler;
import Model.PhieuXuat;
import javax.swing.JOptionPane;
import Utils.NumberUtils;
/**
 *
 * @author Lo Dai Luc
 */
public class NhapSachCtrl {

    private static final NhapSachCtrl instance = new NhapSachCtrl();

    private NhapSachCtrl() {
    }

    public static NhapSachCtrl getInstance() {
        return instance;
    }

    private static final List<Sach> listSach = new ArrayList<>();

    public static List<Sach> getList() {
        return listSach;
    }

    public static void luuSach(Sach s) {
        listSach.add(s);
         updateFile();
    }

    public static void validateNotEmpty(String tenSach, String theLoai, String tacGia, String giaText) throws Exception {
        if (tenSach.isEmpty() || theLoai.isEmpty() || tacGia.isEmpty() || giaText.isEmpty()) {
            throw new Exception("Tất cả các trường không được để trống. Vui lòng nhập lại.");
        }
    }

    public static void validateGia(String giaText) throws Exception {
        double gia;
        try {
            gia = Double.parseDouble(giaText);
        } catch (NumberFormatException e) {
            throw new Exception("Giá phải là số nguyên dương. Vui lòng nhập lại.");
        }

        if (gia <= 0) {
            throw new Exception("Giá phải lớn hơn 0. Vui lòng nhập lại.");
        }
    }

    public static void validateTenSachDuyNhat(String tenSach, List<Sach> sachList) throws Exception {
        for (Sach s : sachList) {
            if (s.getTenSach().equalsIgnoreCase(tenSach)) {
                throw new Exception("Tên sách '" + tenSach + "' đã tồn tại. Vui lòng nhập tên sách khác.");
            }
        }
    }

    public static List<Sach> timKiemSach(String keyword) {
        List<Sach> searchResult = new ArrayList<>();
        String lowerKeyword = keyword.toLowerCase();
 
                
        for (Sach sach : listSach) {
            if (sach.getMaSach().toLowerCase().contains(lowerKeyword)
                    || sach.getTenSach().toLowerCase().contains(lowerKeyword)
                    || sach.getTheLoai().toLowerCase().contains(lowerKeyword)
                    || sach.getTacGia().toLowerCase().contains(lowerKeyword)){
                searchResult.add(sach);
            }
        }
        return searchResult;
    }
    public static Sach findSachByMaSach(String maSach) {
        for (Sach sach : listSach) {
            if (sach.getMaSach().equalsIgnoreCase(maSach)) {
                return sach;
            }
        }
        return null; 
    }
    public static void updateFile()
    {
        SachFileHandler.getInstance().writeToFile("sach.txt", listSach);
    }
}
