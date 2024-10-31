/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package FileHandler;

import Model.ChiTietPhieu;
import Model.PhieuNhap;
import Model.PhieuXuat;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.text.Font;
import com.itextpdf.text.Phrase;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import Utils.NumberUtils;
import javax.swing.filechooser.FileNameExtensionFilter;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 *
 * @author Lo Dai Luc
 */
public class PhieuNhapFileHandler implements FileHandlerInterface {

    private static final PhieuNhapFileHandler instance = new PhieuNhapFileHandler();

    private PhieuNhapFileHandler() {
    }

    public static PhieuNhapFileHandler getInstance() {
        return instance;
    }

    @Override
    public <T> void writeToFile(String fileName, List<T> data) {
        File file = new File(fileName);
        try {
            file.createNewFile();
            FileOutputStream fos = new FileOutputStream(file);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(data);
            oos.close();
            fos.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public <T> List<T> readDaTaFromFile(String fileName) {
        List<T> list = new ArrayList<>();
        File file = new File(fileName);
        if (file.length() > 0) {
            try {
                file.createNewFile();
                FileInputStream fos = new FileInputStream(file);
                ObjectInputStream oos = new ObjectInputStream(fos);
                Object o = oos.readObject();
                list = (List<T>) o;
                oos.close();
                fos.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            } catch (ClassNotFoundException ex) {
                ex.printStackTrace();
            }
        }
        return list;
    }

    @Override
    public void exportPDF(Object obj) {
        PhieuNhap phieu = (PhieuNhap) obj;
        String filePath = phieu.getMaPhieu();
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogTitle("Chọn đường dẫn để lưu file PDF");

        // Thiết lập bộ lọc để chỉ hiển thị các file PDF
        fileChooser.setFileFilter(new javax.swing.filechooser.FileNameExtensionFilter("PDF file", "pdf"));

        // Thiết lập tên mặc định cho file
        fileChooser.setSelectedFile(new java.io.File(filePath + ".pdf"));

        int userSelection = fileChooser.showSaveDialog(null);

        if (userSelection == JFileChooser.APPROVE_OPTION) {
            filePath = fileChooser.getSelectedFile().getAbsolutePath();

            // Nếu tên file không có đuôi .pdf, thêm đuôi này vào
            if (!filePath.toLowerCase().endsWith(".pdf")) {
                filePath += ".pdf";
            }

            Document document = new Document();
            try {
                PdfWriter.getInstance(document, new FileOutputStream(filePath));

                document.open();

                String fontPath = "lib/Roboto/Roboto-Regular.ttf";
                Font fontData = new Font(BaseFont.createFont(fontPath, BaseFont.IDENTITY_H, BaseFont.EMBEDDED), 15, Font.NORMAL);
                Font fontTitle = new Font(BaseFont.createFont(fontPath, BaseFont.IDENTITY_H, BaseFont.EMBEDDED), 25, Font.NORMAL);
                Font fontHeader = new Font(BaseFont.createFont(fontPath, BaseFont.IDENTITY_H, BaseFont.EMBEDDED), 15, Font.NORMAL);

                Paragraph title = new Paragraph("HÓA ĐƠN NHẬP HÀNG", fontTitle);
                title.setAlignment(Element.ALIGN_CENTER);
                document.add(title);
                document.add(new Paragraph(" "));

                Paragraph para1 = new Paragraph("Nhà cung cấp: " + phieu.getNhaCungCap(), fontHeader);
                document.add(para1);

                Paragraph para2 = new Paragraph("Mã phiếu: " + phieu.getMaPhieu(), fontHeader);
                document.add(para2);

                Paragraph para3 = new Paragraph("Thời gian tạo: " + phieu.getThoiGianTao(), fontHeader);
                document.add(para3);

                document.add(new Paragraph(" "));

                //tạo bảng
                PdfPTable table = new PdfPTable(4);
                table.setWidthPercentage(100);
                table.setSpacingBefore(10f);
                table.setSpacingAfter(10f);

                // Thêm tiêu đề cột
                table.addCell(new PdfPCell(new Phrase("Tên sản phẩm", fontHeader)));
                table.addCell(new PdfPCell(new Phrase("Số lượng", fontHeader)));
                table.addCell(new PdfPCell(new Phrase("Đơn giá", fontHeader)));
                table.addCell(new PdfPCell(new Phrase("Thành tiền", fontHeader)));

                for (ChiTietPhieu chiTiet : phieu.getCTPhieu()) {
                    table.addCell(new PdfPCell(new Phrase(String.valueOf(chiTiet.getTenSach()), fontData)));
                    table.addCell(new PdfPCell(new Phrase(String.valueOf(chiTiet.getSoLuong()), fontData)));
                    table.addCell(new PdfPCell(new Phrase(String.valueOf(NumberUtils.formatCurrency(chiTiet.getDonGia())), fontData)));
                    table.addCell(new PdfPCell(new Phrase(String.valueOf(NumberUtils.formatCurrency(chiTiet.getTongTien())), fontData)));
                }

                document.add(table);

                document.add(new Paragraph("Tổng thanh toán: " + NumberUtils.formatCurrency(phieu.getTongThanhToan()), fontHeader));

                System.out.println("PDF tạo thành công!");
            } catch (DocumentException | FileNotFoundException e) {
                e.printStackTrace();
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                if (document != null) {
                    document.close();
                }
            }
        } else {
            System.out.println("Lưu file PDF đã bị hủy bỏ bởi người dùng.");
        }
    }

    @Override
    public <T> void exportExcel(List<T> data) {
        Workbook workbook = new XSSFWorkbook();
        Sheet sheet = workbook.createSheet("Sach");

        String[] headers = {"STT", "Mã phiếu nhập", "Nhà cung cấp", "Thời gian tạo", "Tổng thanh toán"};
        Row headerRow = sheet.createRow(0);

        for (int i = 0; i < headers.length; i++) {
            Cell cell = headerRow.createCell(i);
            cell.setCellValue(headers[i]);
        }

        int rowNum = 1;
        int stt = 1;

        for (T t : data) {
            PhieuNhap pN = (PhieuNhap) t;
            Row row = sheet.createRow(rowNum++);

            row.createCell(0).setCellValue(stt);
            stt++;
            row.createCell(1).setCellValue(pN.getMaPhieu());
            row.createCell(2).setCellValue(pN.getNhaCungCap());
            row.createCell(3).setCellValue(pN.getThoiGianTao());
            row.createCell(4).setCellValue(NumberUtils.formatCurrency(pN.getTongThanhToan()));
        }
        for (int i = 0; i < headers.length; i++) {
            sheet.autoSizeColumn(i);
        }

        JFileChooser fileChooser = new JFileChooser();

        FileNameExtensionFilter filter = new FileNameExtensionFilter("Excel files (*.xlsx)", "xlsx");
        fileChooser.setFileFilter(filter);

        String FileName = "DanhSachPhieuNhap.xlsx";
        fileChooser.setSelectedFile(new java.io.File(FileName));

        int userSelection = fileChooser.showSaveDialog(null);
        if (userSelection == JFileChooser.APPROVE_OPTION) {
            String excelFilePath = fileChooser.getSelectedFile().getAbsolutePath();

            if (!excelFilePath.endsWith(".xlsx")) {
                excelFilePath += ".xlsx";
            }
            try (FileOutputStream fos = new FileOutputStream(excelFilePath)) {
                workbook.write(fos);
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                try {
                    workbook.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

}
