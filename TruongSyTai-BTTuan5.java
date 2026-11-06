import java.text.DecimalFormat;
import java.time.Year;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * BÀI THỰC HÀNH TUẦN 5: CÂU LỆNH LẶP TRONG JAVA
 * Họ và tên: Trương Sỹ Tài
 * Tên file: TruongSyTai-BTTuan5.java
 * 
 * Mục tiêu thực hành Tuần 5:
 * - Vận dụng thành thạo các cấu trúc vòng lặp: for, while, do-while.
 * - Bài 1: Nhập n sách bằng vòng lặp.
 * - Bài 2: Tính tổng số lượng và tổng giá trị sách.
 * - Bài 3: Menu lặp đến khi chọn Thoát (do-while).
 * - Bài 4: Tìm sách theo mã.
 */

// Lớp biểu diễn thông tin một cuốn sách trong thư viện
class Sach {
    private String maSach;
    private String tenSach;
    private String tacGia;
    private int namXuatBan;
    private double donGia;
    private int soLuong;

    public Sach() {
    }

    public Sach(String maSach, String tenSach, String tacGia, int namXuatBan, double donGia, int soLuong) {
        this.maSach = maSach;
        this.tenSach = tenSach;
        this.tacGia = tacGia;
        this.namXuatBan = namXuatBan;
        this.donGia = donGia;
        this.soLuong = soLuong;
    }

    public String getMaSach() {
        return maSach;
    }

    public void setMaSach(String maSach) {
        this.maSach = maSach;
    }

    public String getTenSach() {
        return tenSach;
    }

    public void setTenSach(String tenSach) {
        this.tenSach = tenSach;
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

    public double getDonGia() {
        return donGia;
    }

    public void setDonGia(double donGia) {
        this.donGia = donGia;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    // Tính thành tiền = đơn giá * số lượng (Giá trị sách theo bài Tuần 3)
    public double tinhThanhTien() {
        return donGia * soLuong;
    }

    // Hiển thị dạng bảng
    public void hienThiThongTin(DecimalFormat df) {
        System.out.printf("| %-10s | %-25s | %-20s | %-8d | %-15s | %-10d | %-18s |\n",
                maSach,
                tenSach.length() > 25 ? tenSach.substring(0, 22) + "..." : tenSach,
                tacGia.length() > 20 ? tacGia.substring(0, 17) + "..." : tacGia,
                namXuatBan,
                df.format(donGia) + " VNĐ",
                soLuong,
                df.format(tinhThanhTien()) + " VNĐ");
    }

    // Hiển thị chi tiết khi tìm thấy mã sách (Bài 4)
    public void hienThiChiTiet(DecimalFormat df) {
        System.out.println("-------------------------------------------------------");
        System.out.println(" Mã sách         : " + maSach);
        System.out.println(" Tên sách        : " + tenSach);
        System.out.println(" Tác giả         : " + tacGia);
        System.out.println(" Năm xuất bản    : " + namXuatBan);
        System.out.println(" Đơn giá         : " + df.format(donGia) + " VNĐ");
        System.out.println(" Số lượng        : " + soLuong);
        System.out.println(" Thành tiền      : " + df.format(tinhThanhTien()) + " VNĐ");
        System.out.println("-------------------------------------------------------");
    }
}

// Lớp chính thực thi chương trình
class TruongSyTai_BTTuan5 {
    private static final Scanner scanner = new Scanner(System.in);
    private static final ArrayList<Sach> danhSachSach = new ArrayList<>();
    private static final DecimalFormat df = new DecimalFormat("#,##0");

    public static void main(String[] args) {
        int luaChon;

        // BÀI 3: Vòng lặp do-while điều khiển menu, lặp liên tục đến khi chọn 0 (Thoát)
        do {
            inMenu();
            luaChon = nhapSoNguyen("Mời bạn chọn chức năng [0-5]: ");

            System.out.println();
            switch (luaChon) {
                case 1:
                    // BÀI 1: Nhập n sách bằng vòng lặp
                    thucHienBai1_NhapNSach();
                    break;
                case 2:
                    // Hiển thị danh sách các cuốn sách đã nhập
                    hienThiDanhSachSach();
                    break;
                case 3:
                    // BÀI 2: Tính tổng số lượng và tổng giá trị sách
                    thucHienBai2_TinhTong();
                    break;
                case 4:
                    // BÀI 4: Tìm sách theo mã
                    thucHienBai4_TimSachTheoMa();
                    break;
                case 5:
                    // Tiện ích: Thêm dữ liệu mẫu thử nghiệm nhanh
                    themDuLieuMau();
                    break;
                case 0:
                    // BÀI 3: Thoát chương trình
                    System.out.println("====================================================");
                    System.out.println("  CẢM ƠN BẠN ĐÃ SỬ DỤNG CHƯƠNG TRÌNH!");
                    System.out.println("  CHÚC BẠN HỌC TỐT MÔN LẬP TRÌNH JAVA!");
                    System.out.println("====================================================");
                    break;
                default:
                    System.out.println(">> Lựa chọn không hợp lệ! Vui lòng chọn từ 0 đến 5.");
                    break;
            }

            if (luaChon != 0) {
                System.out.println("\nNhấn phím [Enter] để quay lại menu chính...");
                scanner.nextLine();
            }

        } while (luaChon != 0); // Vòng lặp dừng khi luaChon == 0
    }

    /**
     * In giao diện Menu chính
     */
    private static void inMenu() {
        System.out.println("\n========================================================");
        System.out.println("       CHƯƠNG TRÌNH QUẢN LÝ SÁCH THƯ VIỆN - TUẦN 5     ");
        System.out.println("               Sinh viên: Trương Sỹ Tài                 ");
        System.out.println("========================================================");
        System.out.println(" [1] Bài 1: Nhập n sách bằng vòng lặp                   ");
        System.out.println(" [2] Hiển thị danh sách toàn bộ sách hiện có            ");
        System.out.println(" [3] Bài 2: Tính tổng số lượng và tổng giá trị sách     ");
        System.out.println(" [4] Bài 4: Tìm kiếm sách theo mã                       ");
        System.out.println(" [5] Thêm nhanh dữ liệu sách mẫu (để kiểm thử)         ");
        System.out.println(" [0] Bài 3: Thoát chương trình                          ");
        System.out.println("========================================================");
    }

    /**
     * BÀI 1: Nhập n sách bằng vòng lặp.
     * Sử dụng vòng lặp while để kiểm tra tính hợp lệ số lượng n > 0.
     * Sử dụng vòng lặp for để lặp qua từng cuốn sách từ 1 đến n.
     */
    private static void thucHienBai1_NhapNSach() {
        System.out.println("--- [BÀI 1] NHẬP n CUỐN SÁCH BẰNG VÒNG LẶP ---");

        int n;
        // Vòng lặp while kiểm tra n phải lớn hơn 0
        while (true) {
            n = nhapSoNguyen("Nhập số lượng sách cần thêm (n > 0): ");
            if (n > 0) {
                break;
            }
            System.out.println(">> Lỗi: Số lượng sách phải lớn hơn 0! Vui lòng nhập lại.");
        }

        int namHienTai = Year.now().getValue();

        // Vòng lặp for để nhập thông tin cho từng cuốn sách
        for (int i = 1; i <= n; i++) {
            System.out.println("\n--- Nhập thông tin cuốn sách thứ " + i + "/" + n + " ---");

            // Nhập mã sách (kiểm tra không để trống và không trùng lặp)
            String maSach;
            while (true) {
                System.out.print("Nhập mã sách: ");
                maSach = scanner.nextLine().trim();
                if (maSach.isEmpty()) {
                    System.out.println(">> Mã sách không được để trống!");
                    continue;
                }
                if (kiemTraTonTaiMaSach(maSach)) {
                    System.out.println(">> Mã sách [" + maSach + "] đã tồn tại trong thư viện! Vui lòng nhập mã khác.");
                    continue;
                }
                break;
            }

            // Nhập tên sách
            String tenSach;
            while (true) {
                System.out.print("Nhập tên sách: ");
                tenSach = scanner.nextLine().trim();
                if (!tenSach.isEmpty()) {
                    break;
                }
                System.out.println(">> Tên sách không được để trống!");
            }

            // Nhập tác giả
            String tacGia;
            while (true) {
                System.out.print("Nhập tác giả: ");
                tacGia = scanner.nextLine().trim();
                if (!tacGia.isEmpty()) {
                    break;
                }
                System.out.println(">> Tên tác giả không được để trống!");
            }

            // Nhập năm xuất bản (vòng lặp while kiểm tra năm hợp lệ)
            int namXuatBan;
            while (true) {
                namXuatBan = nhapSoNguyen("Nhập năm xuất bản (1500 - " + namHienTai + "): ");
                if (namXuatBan >= 1500 && namXuatBan <= namHienTai) {
                    break;
                }
                System.out.println(">> Năm xuất bản không hợp lệ! Vui lòng nhập từ 1500 đến " + namHienTai + ".");
            }

            // Nhập đơn giá (vòng lặp while kiểm tra đơn giá > 0)
            double donGia;
            while (true) {
                donGia = nhapSoThuc("Nhập đơn giá (> 0 VNĐ): ");
                if (donGia > 0) {
                    break;
                }
                System.out.println(">> Đơn giá phải lớn hơn 0! Vui lòng nhập lại.");
            }

            // Nhập số lượng (vòng lặp while kiểm tra số lượng >= 0)
            int soLuong;
            while (true) {
                soLuong = nhapSoNguyen("Nhập số lượng (>= 0): ");
                if (soLuong >= 0) {
                    break;
                }
                System.out.println(">> Số lượng phải lớn hơn hoặc bằng 0! Vui lòng nhập lại.");
            }

            // Khởi tạo đối tượng sách và lưu vào danh sách
            Sach sachMoi = new Sach(maSach, tenSach, tacGia, namXuatBan, donGia, soLuong);
            danhSachSach.add(sachMoi);

            System.out.println(">> Thêm thành công cuốn sách: " + tenSach + " (Thành tiền: " + df.format(sachMoi.tinhThanhTien()) + " VNĐ)");
        }

        System.out.println("\n>> ĐÃ NHẬP XONG " + n + " CUỐN SÁCH VÀO THƯ VIỆN!");
    }

    /**
     * Hiển thị bảng danh sách toàn bộ sách hiện có
     */
    private static void hienThiDanhSachSach() {
        System.out.println("--- DANH SÁCH SÁCH TRONG THƯ VIỆN ---");
        if (danhSachSach.isEmpty()) {
            System.out.println(">> Hiện tại thư viện chưa có cuốn sách nào. Hãy chọn mục 1 hoặc 5 để thêm sách!");
            return;
        }

        inTieuDeBang();
        // Vòng lặp for để hiển thị từng cuốn sách
        for (int i = 0; i < danhSachSach.size(); i++) {
            danhSachSach.get(i).hienThiThongTin(df);
        }
        inDuongKeBang();
        System.out.println("Tổng số đầu sách hiện có: " + danhSachSach.size());
    }

    /**
     * BÀI 2: Tính tổng số lượng và tổng giá trị sách
     * Sử dụng vòng lặp for duyệt qua danh sách sách để tính:
     * - Tổng số lượng sách
     * - Tổng giá trị sách (= tổng thành tiền các cuốn sách)
     */
    private static void thucHienBai2_TinhTong() {
        System.out.println("--- [BÀI 2] TÍNH TỔNG SỐ LƯỢNG VÀ TỔNG GIÁ TRỊ SÁCH ---");

        if (danhSachSach.isEmpty()) {
            System.out.println(">> Thư viện chưa có sách để tính toán! Vui lòng nhập sách trước.");
            return;
        }

        int tongSoLuong = 0;
        double tongGiaTri = 0.0;

        // Vòng lặp for duyệt qua từng cuốn sách để cộng dồn
        for (int i = 0; i < danhSachSach.size(); i++) {
            Sach s = danhSachSach.get(i);
            tongSoLuong += s.getSoLuong();
            tongGiaTri += s.tinhThanhTien();
        }

        // Tính thêm chi phí phụ trợ theo nghiệp vụ tuần 3:
        double phiVanChuyen = tongGiaTri * 0.05; // 5% giá trị sách
        double tongTienNhap = tongGiaTri + phiVanChuyen;

        System.out.println("========================================================");
        System.out.println("  KẾT QUẢ THỐNG KÊ TOÀN BỘ THƯ VIỆN:");
        System.out.println("--------------------------------------------------------");
        System.out.println(" - Tổng số đầu sách (loại sách) : " + danhSachSach.size());
        System.out.println(" - TỔNG SỐ LƯỢNG SÁCH TRONG KHO  : " + tongSoLuong + " cuốn");
        System.out.println(" - TỔNG GIÁ TRỊ SÁCH (THÀNH TIỀN): " + df.format(tongGiaTri) + " VNĐ");
        System.out.println(" - Phí vận chuyển ước tính (5%) : " + df.format(phiVanChuyen) + " VNĐ");
        System.out.println(" - TỔNG TIỀN NHẬP KHO DỰ KIẾN    : " + df.format(tongTienNhap) + " VNĐ");
        System.out.println("========================================================");
    }

    /**
     * BÀI 4: Tìm sách theo mã.
     * Sử dụng vòng lặp for duyệt danh sách và so sánh mã sách.
     */
    private static void thucHienBai4_TimSachTheoMa() {
        System.out.println("--- [BÀI 4] TÌM KIẾM SÁCH THEO MÃ ---");

        if (danhSachSach.isEmpty()) {
            System.out.println(">> Thư viện chưa có cuốn sách nào để tìm kiếm! Vui lòng nhập sách trước.");
            return;
        }

        System.out.print("Nhập mã sách cần tìm: ");
        String maCanTim = scanner.nextLine().trim();

        boolean timThay = false;

        // Vòng lặp for duyệt để tìm kiếm sách theo mã
        for (int i = 0; i < danhSachSach.size(); i++) {
            Sach s = danhSachSach.get(i);
            // So sánh mã sách (không phân biệt chữ hoa hay chữ thường)
            if (s.getMaSach().equalsIgnoreCase(maCanTim)) {
                System.out.println("\n>> TÌM THẤY THÔNG TIN SÁCH:");
                s.hienThiChiTiet(df);
                timThay = true;
                break; // Tìm thấy thì dừng vòng lặp ngay
            }
        }

        // Nếu duyệt hết danh sách mà không tìm thấy
        if (!timThay) {
            System.out.println(">> KHÔNG TÌM THẤY cuốn sách nào có mã: \"" + maCanTim + "\"!");
        }
    }

    /**
     * Tiện ích: Thêm dữ liệu mẫu vào danh sách để kiểm thử nhanh
     */
    private static void themDuLieuMau() {
        if (!danhSachSach.isEmpty()) {
            System.out.print("Danh sách hiện đã có sách. Bạn có muốn thêm tiếp dữ liệu mẫu không? (y/n): ");
            String ans = scanner.nextLine().trim();
            if (!ans.equalsIgnoreCase("y")) {
                System.out.println(">> Đã hủy thêm dữ liệu mẫu.");
                return;
            }
        }

        danhSachSach.add(new Sach("MS01", "Lap trinh Java co ban", "Nguyen Van A", 2022, 75000, 20));
        danhSachSach.add(new Sach("MS02", "Lap trinh huong doi tuong", "Pham Thi B", 2023, 120000, 15));
        danhSachSach.add(new Sach("MS03", "Cau truc du lieu va GT", "Tran Van C", 2021, 95000, 10));
        danhSachSach.add(new Sach("MS04", "Co so du lieu nang cao", "Le Thi D", 2024, 150000, 5));

        System.out.println(">> Đã thêm thành công 4 cuốn sách mẫu vào thư viện!");
        hienThiDanhSachSach();
    }

    /**
     * Kiểm tra xem mã sách đã tồn tại trong danh sách chưa
     */
    private static boolean kiemTraTonTaiMaSach(String maSach) {
        for (Sach s : danhSachSach) {
            if (s.getMaSach().equalsIgnoreCase(maSach)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Nhập số nguyên an toàn, có bẫy lỗi khi người dùng nhập sai kiểu
     */
    private static int nhapSoNguyen(String thongBao) {
        while (true) {
            try {
                System.out.print(thongBao);
                String input = scanner.nextLine().trim();
                return Integer.parseInt(input);
            } catch (NumberFormatException e) {
                System.out.println(">> Giá trị nhập vào phải là số nguyên! Vui lòng nhập lại.");
            }
        }
    }

    /**
     * Nhập số thực an toàn, có bẫy lỗi khi người dùng nhập sai kiểu
     */
    private static double nhapSoThuc(String thongBao) {
        while (true) {
            try {
                System.out.print(thongBao);
                String input = scanner.nextLine().trim();
                return Double.parseDouble(input);
            } catch (NumberFormatException e) {
                System.out.println(">> Giá trị nhập vào phải là số thực! Vui lòng nhập lại.");
            }
        }
    }

    private static void inDuongKeBang() {
        System.out.println("+------------+---------------------------+----------------------+----------+-----------------+------------+--------------------+");
    }

    private static void inTieuDeBang() {
        inDuongKeBang();
        System.out.printf("| %-10s | %-25s | %-20s | %-8s | %-15s | %-10s | %-18s |\n",
                "MÃ SÁCH", "TÊN SÁCH", "TÁC GIẢ", "NĂM XB", "ĐƠN GIÁ", "SỐ LƯỢNG", "THÀNH TIỀN");
        inDuongKeBang();
    }
}

