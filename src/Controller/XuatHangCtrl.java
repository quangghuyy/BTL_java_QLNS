/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import FileHandler.PhieuNhapFileHandler;
import FileHandler.PhieuXuatFileHandler;
import Model.ChiTietPhieu;
import Model.PhieuNhap;
import Model.PhieuXuat;
import Model.Sach;
import Utils.NumberUtils;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Lo Dai Luc
 */
public class XuatHangCtrl {

    private static final XuatHangCtrl instance = new XuatHangCtrl();

    private XuatHangCtrl() {
    }

    public static XuatHangCtrl getInstance() {
        return instance;
    }

    private static final List<PhieuXuat> listPhieuXuat = new ArrayList<>();

    public static List<PhieuXuat> getList() {
        return listPhieuXuat;
    }

    public static void luuPhieuXuat(PhieuXuat pX) throws Exception {
        if (!pX.isMaPhieuDuyNhat(pX.getMaPhieu(), listPhieuXuat)) {
            return;
        }

        List<Sach> tempSachList = new ArrayList<>();
        boolean check = true;
        for (ChiTietPhieu chiTietPhieu : pX.getCTPhieu()) {
            for (Sach sach : NhapSachCtrl.getList()) {
                if (chiTietPhieu.getMaSach().equalsIgnoreCase(sach.getMaSach())) {
                    int soLuong = sach.getSoLuong() - chiTietPhieu.getSoLuong();
                    if (soLuong < 0) {
                        check = false;
                        throw new Exception("Số lượng xuất " + sach.getTenSach() + " nhiều hơn số lượng tồn kho là " + Math.abs(soLuong));
                    } else {
                        Sach tempSach = new Sach(sach.getMaSach(), sach.getTenSach(), sach.getTheLoai(), sach.getTacGia(), sach.getGia(), soLuong);
                        tempSachList.add(tempSach);
                    }
                }
            }
        }

        if (!check) {
            return;
        }

        for (Sach tempSach : tempSachList) {
            for (Sach sach : NhapSachCtrl.getList()) {
                if (tempSach.getMaSach().equalsIgnoreCase(sach.getMaSach())) {
                    sach.setSoLuong(tempSach.getSoLuong());
                }
            }
        }

        listPhieuXuat.add(pX);
        updateFile();
    }

    public static List<PhieuXuat> timKiemPhieuXuat(String keyword) {
        List<PhieuXuat> searchResult = new ArrayList<>();
        String lowerKeyword = keyword.toLowerCase();
        String keywordNumber = NumberUtils.extractDigits(keyword).toLowerCase();

        for (PhieuXuat pX : listPhieuXuat) {
            if (pX.getMaPhieu().toLowerCase().contains(lowerKeyword)
                    || pX.getThoiGianTao().toLowerCase().contains(lowerKeyword)) {
                searchResult.add(pX);
            }
        }
        return searchResult;
    }

    public static List<PhieuXuat> locTheoNgay(String fromDateStr, String toDateStr) throws ParseException {
        List<PhieuXuat> searchResult = new ArrayList<>();

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

        Date minDate = sdf.parse("1970-01-01");
        Date maxDate = sdf.parse("9999-12-31");

        Date fromDate;
        Date toDate;

        if (!fromDateStr.isEmpty()) {
            fromDate = sdf.parse(fromDateStr);
        } else {
            fromDate = minDate;
        }

        if (!toDateStr.isEmpty()) {
            toDate = sdf.parse(toDateStr);
        } else {
            toDate = maxDate;
        }
        
        LocalDate fromLocalDate = new java.sql.Date(fromDate.getTime()).toLocalDate();
        LocalDate toLocalDate = new java.sql.Date(toDate.getTime()).toLocalDate();

        for (PhieuXuat phieuXuat : listPhieuXuat) {
            Date thoiGianTao = sdf.parse(phieuXuat.getThoiGianTao());
            LocalDate thoiGianTaoLocalDate = new java.sql.Date(thoiGianTao.getTime()).toLocalDate();

            if (!thoiGianTaoLocalDate.isBefore(fromLocalDate) && !thoiGianTaoLocalDate.isAfter(toLocalDate)) {
                searchResult.add(phieuXuat);
            }
        }
        return searchResult;
    }

    public static List<PhieuXuat> locTheoGia(Double fromPrice, Double toPrice) {
        List<PhieuXuat> searchResult = new ArrayList<>();

        if (fromPrice == null) {
            fromPrice = Double.MIN_VALUE;
        }

        if (toPrice == null) {
            toPrice = Double.MAX_VALUE;
        }
        for (PhieuXuat phieuXuat : listPhieuXuat) {
            double tongThanhToan = phieuXuat.getTongThanhToan();
            if (tongThanhToan >= fromPrice && tongThanhToan <= toPrice) {
                searchResult.add(phieuXuat);
            }
        }
        return searchResult;
    }

    public static void updateFile() {
        PhieuXuatFileHandler.getInstance().writeToFile("phieuxuat.txt", listPhieuXuat);
    }
}
