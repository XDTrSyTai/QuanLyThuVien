import java.time.Year;
import java.util.ArrayList;

// Lớp Sach biểu diễn thông tin về một cuốn sách (Đóng gói dữ liệu - Encapsulation)
class Sach {
    // Yêu cầu 1: Tất cả các thuộc tính được khai báo với từ khóa private
    private String maSach;
    private String tieuDe;
    private String tacGia;
    private int namXuatBan;
    private int soLuong;

    // Constructor mặc định
    public Sach() {
    }

    // Yêu cầu 4: Constructor có tham số đầy đủ để khởi tạo tất cả các thuộc tính
    // (Gọi các phương thức setter để đảm bảo dữ liệu khởi tạo cũng tuân theo điều
    // kiện kiểm tra)
    public Sach(String maSach, String tieuDe, String tacGia, int namXuatBan, int soLuong) {
        this.maSach = maSach;
        this.tieuDe = tieuDe;
        this.tacGia = tacGia;
        setNamXuatBan(namXuatBan);
        setSoLuong(soLuong);
    }

    // Yêu cầu 2: Cung cấp đầy đủ các phương thức public getters và setters
    public String getMaSach() {
        return maSach;
    }

    public void setMaSach(String maSach) {
        this.maSach = maSach;
    }

    public String getTieuDe() {
        return tieuDe;
    }

    public void setTieuDe(String tieuDe) {
        this.tieuDe = tieuDe;
    }

    public String getTacGia() {
        return tacGia;
    }

    public void setTacGia(String tacGia) {
        this.tacGia = tacGia;
    }

    public int getNamXuatBan() {
        return namXuatBan;
    }

    // Yêu cầu 3: Kiểm tra namXuatBan > 0 và namXuatBan <= currentYear
    public void setNamXuatBan(int namXuatBan) {
        int currentYear = Year.now().getValue();
        if (namXuatBan > 0 && namXuatBan <= currentYear) {
            this.namXuatBan = namXuatBan;
        } else {
            System.out.println("[Lỗi] Năm xuất bản không hợp lệ (" + namXuatBan
                    + "). Năm xuất bản phải lớn hơn 0 và không vượt quá " + currentYear + ".");
        }
    }

    public int getSoLuong() {
        return soLuong;
    }

    // Yêu cầu 3: Kiểm tra soLuong không âm (soLuong >= 0)
    public void setSoLuong(int soLuong) {
        if (soLuong >= 0) {
            this.soLuong = soLuong;
        } else {
            System.out.println("[Lỗi] Số lượng sách không hợp lệ (" + soLuong
                    + "). Số lượng không được là số âm.");
        }
    }

    // Phương thức hiển thị chi tiết thông tin cuốn sách ra màn hình
    public void hienThiThongTin() {
        System.out.println("Mã sách      : " + maSach);
        System.out.println("Tiêu đề      : " + tieuDe);
        System.out.println("Tác giả      : " + tacGia);
        System.out.println("Năm xuất bản : " + namXuatBan);
        System.out.println("Số lượng     : " + soLuong);
        System.out.println("----------------------------------------");
    }
}

// Lớp BTT8 để khởi tạo đối tượng Sach, kiểm tra ràng buộc đóng gói và quản lý bằng ArrayList
public class BTT8 {
    // Thêm sách mới vào danh sách
    public static void themSach(ArrayList<Sach> danhSach, Sach sachMoi) {
        danhSach.add(sachMoi);
    }

    // Hiển thị toàn bộ danh sách sách
    public static void hienThiDanhSach(ArrayList<Sach> danhSach) {
        if (danhSach.isEmpty()) {
            System.out.println("Danh sách sách hiện đang trống!");
            return;
        }
        for (Sach s : danhSach) {
            s.hienThiThongTin();
        }
    }

    // Tìm kiếm sách theo mã sách
    public static Sach timSachTheoMa(ArrayList<Sach> danhSach, String maCanTim) {
        for (Sach s : danhSach) {
            if (s.getMaSach().equalsIgnoreCase(maCanTim)) {
                return s;
            }
        }
        return null;
    }

    // Xóa sách theo mã sách
    public static boolean xoaSachTheoMa(ArrayList<Sach> danhSach, String maCanXoa) {
        Sach sach = timSachTheoMa(danhSach, maCanXoa);
        if (sach != null) {
            danhSach.remove(sach);
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        // Tạo các đối tượng từ lớp Sach bằng constructor đầy đủ tham số
        Sach sach1 = new Sach("S001", "Lập trình hướng đối tượng với Java", "Nguyễn Văn A", 2023, 15);
        Sach sach2 = new Sach("S002", "Cấu trúc dữ liệu và Giải thuật", "Trần Thị B", 2022, 10);
        Sach sach3 = new Sach("S003", "Cơ sở dữ liệu SQL Server", "Lê Văn C", 2024, 20);

        // Quản lý danh sách Sach bằng ArrayList
        ArrayList<Sach> danhSachSach = new ArrayList<>();
        themSach(danhSachSach, sach1);
        themSach(danhSachSach, sach2);
        themSach(danhSachSach, sach3);

        // 1. In toàn bộ danh sách sách trong thư viện
        System.out.println("=== DANH SÁCH SÁCH TRONG THƯ VIỆN ===");
        hienThiDanhSach(danhSachSach);

        // 2. Kiểm tra điều kiện ràng buộc trong setNamXuatBan() và setSoLuong()
        System.out.println("=== KIỂM TRA RÀNG BUỘC DỮ LIỆU (SETTERS) ===");
        System.out
                .println("-> Thử cập nhật năm xuất bản lớn hơn năm hiện tại (2035) và số lượng âm (-5) cho sách S001:");
        sach1.setNamXuatBan(2035); // Sẽ báo lỗi và giữ nguyên năm cũ (2023)
        sach1.setSoLuong(-5); // Sẽ báo lỗi và giữ nguyên số lượng cũ (15)
        sach1.hienThiThongTin();

        // 3. Tìm kiếm và cập nhật dữ liệu hợp lệ
        String maTim = "S002";
        System.out.println("=== TÌM KIẾM & CẬP NHẬT HỢP LỆ CHO SÁCH " + maTim + " ===");
        Sach ketQuaTim = timSachTheoMa(danhSachSach, maTim);
        if (ketQuaTim != null) {
            ketQuaTim.setNamXuatBan(2025);
            ketQuaTim.setSoLuong(25);
            System.out.println("Đã cập nhật thành công cho sách " + maTim + ":");
            ketQuaTim.hienThiThongTin();
        } else {
            System.out.println("Không tìm thấy sách có mã: " + maTim);
        }

        // 4. Xóa một cuốn sách khỏi danh sách
        String maXoa = "S003";
        System.out.println("=== XÓA SÁCH CÓ MÃ " + maXoa + " ===");
        if (xoaSachTheoMa(danhSachSach, maXoa)) {
            System.out.println("Đã xóa thành công sách có mã " + maXoa + "!\n");
        } else {
            System.out.println("Không tìm thấy sách có mã " + maXoa + " để xóa!\n");
        }

        // 5. Hiển thị lại danh sách sau khi cập nhật và xóa
        System.out.println("=== DANH SÁCH SÁCH SAU KHI CẬP NHẬT ===");
        hienThiDanhSach(danhSachSach);
    }
}

// Lớp Test để chạy tương thích nếu chạy bằng lệnh 'java Test'
class Test {
    public static void main(String[] args) {
        BTT8.main(args);
    }
}
