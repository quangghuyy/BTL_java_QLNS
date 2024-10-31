/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import com.itextpdf.text.pdf.PdfPCell;
import java.io.Serializable;


public class ChiTietPhieu implements Serializable{

    private String maPhieu;
    private String maSach;
    private String tenSach;
    private int soLuong;
    private double donGia;

    public ChiTietPhieu() {
    }

    public ChiTietPhieu(String maPhieu, String maSach, String tenSach, int soLuong, double donGia) {
        this.maPhieu = maPhieu;
        this.maSach = maSach;
        this.tenSach = tenSach;
        this.soLuong = soLuong;
        this.donGia = donGia;
    }

    

    public String getMaPhieu() {
        return maPhieu;
    }

    public void setMaPhieu(String maPhieu) {
        this.maPhieu = maPhieu;
    }

    public String getMaSach() {
        return maSach;
    }

    public void setMaSach(String maSach) {
        this.maSach = maSach;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public double getDonGia() {
        return donGia;
    }

    public void setDonGia(double donGia) {
        this.donGia = donGia;
    }

    public String getTenSach() {
        return tenSach;
    }

    public void setTenSach(String tenSach) {
        this.tenSach = tenSach;
    }  
    public double getTongTien()
    {
        return soLuong * donGia;
    }

}
