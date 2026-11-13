import java.util.ArrayList;

// Yêu cầu 1 & 2: Tạo lớp Sach biểu diễn thông tin cuốn sách và phương thức hiển thị
class Sach {
    private String maSach;
    private String tieuDe;
    private String tacGia;
    private int namXuatBan;
    private int soLuong;

    // Constructor mặc định
    public Sach() {
    }

    // Constructor đầy đủ tham số
    public Sach(String maSach, String tieuDe, String tacGia, int namXuatBan, int soLuong) {
        this.maSach = maSach;
        this.tieuDe = tieuDe;
        this.tacGia = tacGia;
        this.namXuatBan = namXuatBan;
        this.soLuong = soLuong;
    }

    // Các phương thức Getter và Setter
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

    public void setNamXuatBan(int namXuatBan) {
        this.namXuatBan = namXuatBan;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    // Yêu cầu 2: Phương thức hienThiThongTin() in chi tiết cuốn sách ra màn hình
    public void hienThiThongTin() {
        System.out.println("Mã sách      : " + maSach);
        System.out.println("Tiêu đề      : " + tieuDe);
        System.out.println("Tác giả      : " + tacGia);
        System.out.println("Năm xuất bản : " + namXuatBan);
        System.out.println("Số lượng     : " + soLuong);
        System.out.println("----------------------------------------");
    }
}

// Yêu cầu 3 & 4: Lớp BTT7 kiểm thử đối tượng Sach và quản lý danh sách bằng ArrayList
public class BTT7 {
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
            if (s.getMaSach().trim().equalsIgnoreCase(maCanTim.trim())) {
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
        // Yêu cầu 3: Tạo các đối tượng từ lớp Sach
        Sach sach1 = new Sach("S001", "Lập trình hướng đối tượng với Java", "Nguyễn Văn A", 2023, 15);
        Sach sach2 = new Sach("S002", "Cấu trúc dữ liệu và Giải thuật", "Trần Thị B", 2022, 10);
        Sach sach3 = new Sach("S003", "Cơ sở dữ liệu SQL Server", "Lê Văn C", 2024, 20);

        // Yêu cầu 4: Tạo và quản lý danh sách Sach bằng ArrayList
        ArrayList<Sach> danhSachSach = new ArrayList<>();
        themSach(danhSachSach, sach1);
        themSach(danhSachSach, sach2);
        themSach(danhSachSach, sach3);

        // 1. In toàn bộ danh sách sách trong thư viện
        System.out.println("=== DANH SÁCH SÁCH TRONG THƯ VIỆN ===");
        hienThiDanhSach(danhSachSach);

        // 2. Tìm kiếm và cập nhật số lượng sách
        String maTim = "S002";
        System.out.println("=== TÌM KIẾM & CẬP NHẬT SÁCH CÓ MÃ " + maTim + " ===");
        Sach ketQuaTim = timSachTheoMa(danhSachSach, maTim);
        if (ketQuaTim != null) {
            ketQuaTim.setSoLuong(25);
            System.out.println("Đã cập nhật số lượng mới cho sách " + maTim + ":");
            ketQuaTim.hienThiThongTin();
        } else {
            System.out.println("Không tìm thấy sách có mã: " + maTim);
        }

        // 3. Xóa một cuốn sách khỏi danh sách
        String maXoa = "S001";
        System.out.println("=== XÓA SÁCH CÓ MÃ " + maXoa + " ===");
        if (xoaSachTheoMa(danhSachSach, maXoa)) {
            System.out.println("Đã xóa thành công sách có mã " + maXoa + "!\n");
        } else {
            System.out.println("Không tìm thấy sách có mã " + maXoa + " để xóa!\n");
        }

        // 4. Hiển thị lại danh sách sau khi cập nhật và xóa
        System.out.println("=== DANH SÁCH SÁCH SAU KHI CẬP NHẬT ===");
        hienThiDanhSach(danhSachSach);
    }
}

// Yêu cầu 3: Lớp Test theo đúng tên gọi trong đề bài
class Test {
    public static void main(String[] args) {
        BTT7.main(args);
    }
}

