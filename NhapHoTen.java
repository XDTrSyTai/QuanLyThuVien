import java.util.Scanner;

public class NhapHoTen {
    public static void main(String[] args) {
        // Khởi tạo đối tượng Scanner để đọc dữ liệu từ bàn phím
        Scanner scanner = new Scanner(System.in);

        System.out.print("Nhập họ và tên của bạn: ");
        // Sử dụngnextLine() để đọc cả dòng (bao gồm cả khoảng trắng)
        String hoTen = scanner.nextLine();

        // In ra màn hình họ tên vừa nhập
        System.out.println("Họ và tên của bạn là: " + hoTen);

        // Đóng scanner
        scanner.close();
    }
}