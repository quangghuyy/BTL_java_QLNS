package Utils;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class DateTimeUtils {

    // Lấy ngày giờ hiện tại
    public static LocalDateTime getCurrentDateTime() {
        return LocalDateTime.now();
    }

    // Định dạng ngày giờ theo định dạng mặc định
    public static String formatDateTimeDefault(LocalDateTime dateTime) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        return dateTime.format(formatter);
    }
}
