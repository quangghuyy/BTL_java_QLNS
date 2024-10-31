package Utils;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Locale;


public class NumberUtils {

    
      //Xóa các ký tự không phải số từ chuỗi  
    public static String extractDigits(String str) {
        if (str == null || str.isEmpty()) {
            return "";
        }
        return str.replaceAll("[^0-9]", "");
    }

     // Định dạng số thành chuỗi định dạng tiền tệ VND
    public static String formatCurrency(double amount) {
        DecimalFormatSymbols symbols = new DecimalFormatSymbols(Locale.getDefault());
        symbols.setGroupingSeparator(',');
        symbols.setDecimalSeparator('.');
        
        DecimalFormat formatter = new DecimalFormat("#,##0 ¤", symbols);
        formatter.setCurrency(java.util.Currency.getInstance("VND"));
        return formatter.format(amount);
    }

}
