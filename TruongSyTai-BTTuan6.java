import java.text.DecimalFormat;
import java.time.Year;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/**
 * BÀI THỰC HÀNH TUẦN 6: MẢNG VÀ DANH SÁCH (LIST) TRONG JAVA
 * Họ và tên: Trương Sỹ Tài
 * Tên file: TruongSyTai-BTTuan6.java
 * 
 * YÊU CẦU THỰC HÀNH:
 * - Bài 1: Tạo mảng int[] soLuong; nhập số lượng 5 cuốn sách. Hiển thị, tính tổng, tìm max.
 * - Bài 2: Dùng ArrayList<String> lưu mã sách. Thêm, hiển thị, tìm, xóa mã sách.
 * - Bài 3: Xây dựng ArrayList<String> danhSachSach; mỗi phần tử đại diện cho thông tin 1 cuốn sách.
 *          Thực hiện: Thêm sách, Hiển thị sách, Tìm sách, Xóa sách, Sửa sách.
 * - Bài 4: Xây dựng menu hoàn chỉnh:
 *          1. Thêm sách
 *          2. Hiển thị sách
 *          3. Tìm sách
 *          4. Xóa sách
 *          5. Sửa sách
 *          6. Tính tổng số lượng
 *          7. Tính tổng giá trị
 *          8. Thoát
 *          (Kèm theo mục 9 & 10 để thực thi Bài 1 và Bài 2)
 */

class TruongSyTai_BTTuan6 {
    private static final Scanner scanner = new Scanner(System.in);
    private static final DecimalFormat df = new DecimalFormat("#,##0");

    // BÀI 3 & 4: ArrayList<String> lưu danh sách sách trong thư viện
    // Định dạng mỗi chuỗi phần tử: "maSach|tenSach|tacGia|namXuatBan|donGia|soLuong"
    private static final ArrayList<String> danhSachSach = new ArrayList<>();

    // BÀI 2: ArrayList<String> lưu mã sách riêng biệt theo yêu cầu Bài 2
    private static final ArrayList<String> dsMaSachBai2 = new ArrayList<>();

    public static void main(String[] args) {
        // Nạp sẵn một số cuốn sách mẫu ban đầu để dễ kiểm thử
        khoiTaoDuLieuMau();

        int luaChon;

        // Vòng lặp do-while điều khiển menu chính hoạt động liên tục (kết thúc khi chọn 8)
        do {
            inMenuChinh();
            luaChon = nhapSoNguyen("Mời bạn chọn chức năng [1-11]: ");
            System.out.println();

            switch (luaChon) {
                case 1:
                    // BÀI 3 & 4 - Mục 1: Thêm sách
                    chucNang1_ThemSach();
                    break;
                case 2:
                    // BÀI 3 & 4 - Mục 2: Hiển thị sách
                    chucNang2_HienThiSach();
                    break;
                case 3:
                    // BÀI 3 & 4 - Mục 3: Tìm sách
                    chucNang3_TimSach();
                    break;
                case 4:
                    // BÀI 3 & 4 - Mục 4: Xóa sách
                    chucNang4_XoaSach();
                    break;
                case 5:
                    // BÀI 3 & 4 - Mục 5: Sửa sách
                    chucNang5_SuaSach();
                    break;
                case 6:
                    // BÀI 4 - Mục 6: Tính tổng số lượng
                    chucNang6_TinhTongSoLuong();
                    break;
                case 7:
                    // BÀI 4 - Mục 7: Tính tổng giá trị
                    chucNang7_TinhTongGiaTri();
                    break;
                case 8:
                    // BÀI 4 - Mục 8: Thoát
                    System.out.println("====================================================");
                    System.out.println("  CẢM ƠN BẠN ĐÃ SỬ DỤNG CHƯƠNG TRÌNH QUẢN LÝ THƯ VIỆN!");
                    System.out.println("  CHÚC BẠN HỌC TỐT MÔN LẬP TRÌNH JAVA!");
                    System.out.println("====================================================");
                    break;
                case 9:
                    // BÀI 1: Mảng int[] soLuong (5 cuốn sách)
                    thucHienBai1_MangSoLuong();
                    break;
                case 10:
                    // BÀI 2: ArrayList<String> lưu mã sách
                    thucHienBai2_QuanLyMaSach();
                    break;
                case 11:
                    // Tiện ích: Nạp lại dữ liệu mẫu
                    khoiTaoDuLieuMau();
                    System.out.println(">> Đã nạp lại dữ liệu sách mẫu thành công!");
                    chucNang2_HienThiSach();
                    break;
                default:
                    System.out.println(">> Lựa chọn không hợp lệ! Vui lòng chọn từ 1 đến 11.");
                    break;
            }

            if (luaChon != 8) {
                System.out.println("\nNhấn phím [Enter] để tiếp tục...");
                scanner.nextLine();
            }

        } while (luaChon != 8);
    }

    /**
     * BÀI 4: Hiển thị giao diện menu hoàn chỉnh
     */
    private static void inMenuChinh() {
        System.out.println("\n========================================================");
        System.out.println("       CHƯƠNG TRÌNH QUẢN LÝ THƯ VIỆN SÁCH - TUẦN 6     ");
        System.out.println("               Sinh viên: Trương Sỹ Tài                 ");
        System.out.println("========================================================");
        System.out.println(" [1] 1. Thêm sách                                       ");
        System.out.println(" [2] 2. Hiển thị sách                                   ");
        System.out.println(" [3] 3. Tìm sách                                        ");
        System.out.println(" [4] 4. Xóa sách                                        ");
        System.out.println(" [5] 5. Sửa sách                                        ");
        System.out.println(" [6] 6. Tính tổng số lượng                              ");
        System.out.println(" [7] 7. Tính tổng giá trị                               ");
        System.out.println(" [8] 8. Thoát                                           ");
        System.out.println("--------------------------------------------------------");
        System.out.println(" [9]  [Bài 1] Thao tác với mảng int[] soLuong (5 cuốn)  ");
        System.out.println(" [10] [Bài 2] Thao tác với ArrayList<String> mã sách   ");
        System.out.println(" [11] Nạp lại dữ liệu sách mẫu                          ");
        System.out.println("========================================================");
    }

    // =========================================================================
    // CÁC CHỨC NĂNG CỦA BÀI 3 & BÀI 4 (SỬ DỤNG ArrayList<String> danhSachSach)
    // =========================================================================

    /**
     * BÀI 3 & 4 - Mục 1: Thêm sách vào ArrayList<String> danhSachSach
     */
    private static void chucNang1_ThemSach() {
        System.out.println("--- [1] THÊM SÁCH MỚI VÀO THƯ VIỆN ---");
        int namHienTai = Year.now().getValue();

        // 1. Nhập mã sách (kiểm tra không được rỗng và không được trùng)
        String maSach;
        while (true) {
            System.out.print("Nhập mã sách: ");
            maSach = scanner.nextLine().trim();
            if (maSach.isEmpty()) {
                System.out.println(">> Mã sách không được để trống!");
                continue;
            }
            if (timViTriSachTheoMa(maSach) != -1) {
                System.out.println(">> Lỗi: Mã sách [" + maSach + "] đã tồn tại! Vui lòng nhập mã khác.");
                continue;
            }
            break;
        }

        // 2. Nhập tên sách
        String tenSach;
        while (true) {
            System.out.print("Nhập tên sách: ");
            tenSach = scanner.nextLine().trim();
            if (!tenSach.isEmpty()) {
                break;
            }
            System.out.println(">> Tên sách không được để trống!");
        }

        // 3. Nhập tác giả
        String tacGia;
        while (true) {
            System.out.print("Nhập tác giả: ");
            tacGia = scanner.nextLine().trim();
            if (!tacGia.isEmpty()) {
                break;
            }
            System.out.println(">> Tác giả không được để trống!");
        }

        // 4. Nhập năm xuất bản
        int namXuatBan;
        while (true) {
            namXuatBan = nhapSoNguyen("Nhập năm xuất bản (1500 - " + namHienTai + "): ");
            if (namXuatBan >= 1500 && namXuatBan <= namHienTai) {
                break;
            }
            System.out.println(">> Năm xuất bản không hợp lệ! Vui lòng nhập từ 1500 đến " + namHienTai + ".");
        }

        // 5. Nhập đơn giá
        double donGia;
        while (true) {
            donGia = nhapSoThuc("Nhập đơn giá (> 0 VNĐ): ");
            if (donGia > 0) {
                break;
            }
            System.out.println(">> Đơn giá phải lớn hơn 0!");
        }

        // 6. Nhập số lượng
        int soLuong;
        while (true) {
            soLuong = nhapSoNguyen("Nhập số lượng (>= 0): ");
            if (soLuong >= 0) {
                break;
            }
            System.out.println(">> Số lượng phải lớn hơn hoặc bằng 0!");
        }

        // Tạo chuỗi đại diện cho thông tin cuốn sách phân tách bởi dấu "|"
        String thongTinSach = maSach + "|" + tenSach + "|" + tacGia + "|" + namXuatBan + "|" + (long)donGia + "|" + soLuong;
        danhSachSach.add(thongTinSach);

        // Đồng thời cập nhật vào danh sách mã sách của Bài 2
        if (!dsMaSachBai2.contains(maSach)) {
            dsMaSachBai2.add(maSach);
        }

        System.out.println(">> THÊM THÀNH CÔNG: Cuốn sách \"" + tenSach + "\" đã được lưu vào ArrayList!");
    }

    /**
     * BÀI 3 & 4 - Mục 2: Hiển thị toàn bộ sách trong ArrayList<String> danhSachSach
     */
    private static void chucNang2_HienThiSach() {
        System.out.println("--- [2] HIỂN THỊ DANH SÁCH TOÀN BỘ SÁCH TRONG THƯ VIỆN ---");
        if (danhSachSach.isEmpty()) {
            System.out.println(">> Hiện tại thư viện chưa có cuốn sách nào!");
            return;
        }

        inTieuDeBang();
        for (int i = 0; i < danhSachSach.size(); i++) {
            String[] parts = danhSachSach.get(i).split("\\|");
            String ma = parts[0];
            String ten = parts[1];
            String tacGia = parts[2];
            int namXB = Integer.parseInt(parts[3]);
            double gia = Double.parseDouble(parts[4]);
            int sl = Integer.parseInt(parts[5]);
            double thanhTien = gia * sl;

            System.out.printf("| %-10s | %-25s | %-20s | %-8d | %-15s | %-10d | %-18s |\n",
                    ma,
                    ten.length() > 25 ? ten.substring(0, 22) + "..." : ten,
                    tacGia.length() > 20 ? tacGia.substring(0, 17) + "..." : tacGia,
                    namXB,
                    df.format(gia) + " VNĐ",
                    sl,
                    df.format(thanhTien) + " VNĐ");
        }
        inDuongKeBang();
        System.out.println("Tổng số cuốn sách trong danh sách: " + danhSachSach.size());
    }

    /**
     * BÀI 3 & 4 - Mục 3: Tìm sách theo mã trong ArrayList<String> danhSachSach
     */
    private static void chucNang3_TimSach() {
        System.out.println("--- [3] TÌM KIẾM SÁCH THEO MÃ SÁCH ---");
        if (danhSachSach.isEmpty()) {
            System.out.println(">> Thư viện chưa có sách để tìm kiếm!");
            return;
        }

        System.out.print("Nhập mã sách cần tìm: ");
        String maCanTim = scanner.nextLine().trim();

        int viTri = timViTriSachTheoMa(maCanTim);
        if (viTri != -1) {
            System.out.println("\n>> TÌM THẤY SÁCH TẠI VỊ TRÍ INDEX = " + viTri + ":");
            inChiTietSach(danhSachSach.get(viTri));
        } else {
            System.out.println(">> KHÔNG TÌM THẤY cuốn sách nào có mã: \"" + maCanTim + "\"!");
        }
    }

    /**
     * BÀI 3 & 4 - Mục 4: Xóa sách theo mã khỏi ArrayList<String> danhSachSach
     */
    private static void chucNang4_XoaSach() {
        System.out.println("--- [4] XÓA SÁCH KHỎI THƯ VIỆN ---");
        if (danhSachSach.isEmpty()) {
            System.out.println(">> Thư viện chưa có sách để xóa!");
            return;
        }

        System.out.print("Nhập mã sách cần xóa: ");
        String maCanXoa = scanner.nextLine().trim();

        int viTri = timViTriSachTheoMa(maCanXoa);
        if (viTri != -1) {
            inChiTietSach(danhSachSach.get(viTri));
            System.out.print("Bạn có chắc chắn muốn xóa cuốn sách này không? (y/n): ");
            String xacNhan = scanner.nextLine().trim();
            if (xacNhan.equalsIgnoreCase("y")) {
                // Sử dụng phương thức remove(int index) của ArrayList
                String sachDaXoa = danhSachSach.remove(viTri);
                String[] parts = sachDaXoa.split("\\|");
                dsMaSachBai2.remove(parts[0]); // Đồng bộ xóa bên danh sách mã Bài 2

                System.out.println(">> ĐÃ XÓA THÀNH CÔNG cuốn sách có mã: [" + maCanXoa + "]!");
            } else {
                System.out.println(">> Đã hủy thao tác xóa sách.");
            }
        } else {
            System.out.println(">> Không tìm thấy mã sách [" + maCanXoa + "] để xóa!");
        }
    }

    /**
     * BÀI 3 & 4 - Mục 5: Sửa thông tin sách trong ArrayList<String> danhSachSach
     */
    private static void chucNang5_SuaSach() {
        System.out.println("--- [5] SỬA THÔNG TIN SÁCH ---");
        if (danhSachSach.isEmpty()) {
            System.out.println(">> Thư viện chưa có sách để sửa!");
            return;
        }

        System.out.print("Nhập mã sách cần sửa thông tin: ");
        String maCanSua = scanner.nextLine().trim();

        int viTri = timViTriSachTheoMa(maCanSua);
        if (viTri == -1) {
            System.out.println(">> Không tìm thấy sách có mã [" + maCanSua + "]!");
            return;
        }

        String[] parts = danhSachSach.get(viTri).split("\\|");
        String maCu = parts[0];
        String tenCu = parts[1];
        String tacGiaCu = parts[2];
        int namXBCu = Integer.parseInt(parts[3]);
        double donGiaCu = Double.parseDouble(parts[4]);
        int soLuongCu = Integer.parseInt(parts[5]);

        System.out.println("\n>> THÔNG TIN HIỆN TẠI:");
        inChiTietSach(danhSachSach.get(viTri));
        System.out.println("(Gợi ý: Nhấn phím Enter để giữ nguyên giá trị cũ)");

        // 1. Sửa tên sách
        System.out.print("Nhập tên sách mới [" + tenCu + "]: ");
        String tenMoi = scanner.nextLine().trim();
        if (tenMoi.isEmpty()) tenMoi = tenCu;

        // 2. Sửa tác giả
        System.out.print("Nhập tác giả mới [" + tacGiaCu + "]: ");
        String tacGiaMoi = scanner.nextLine().trim();
        if (tacGiaMoi.isEmpty()) tacGiaMoi = tacGiaCu;

        // 3. Sửa năm xuất bản
        int namHienTai = Year.now().getValue();
        int namXBMoi = namXBCu;
        while (true) {
            System.out.print("Nhập năm xuất bản mới [" + namXBCu + "]: ");
            String input = scanner.nextLine().trim();
            if (input.isEmpty()) {
                break;
            }
            try {
                int val = Integer.parseInt(input);
                if (val >= 1500 && val <= namHienTai) {
                    namXBMoi = val;
                    break;
                }
                System.out.println(">> Năm xuất bản không hợp lệ (1500 - " + namHienTai + ")!");
            } catch (NumberFormatException e) {
                System.out.println(">> Năm xuất bản phải là số nguyên!");
            }
        }

        // 4. Sửa đơn giá
        double donGiaMoi = donGiaCu;
        while (true) {
            System.out.print("Nhập đơn giá mới [" + df.format(donGiaCu) + "]: ");
            String input = scanner.nextLine().trim();
            if (input.isEmpty()) {
                break;
            }
            try {
                double val = Double.parseDouble(input);
                if (val > 0) {
                    donGiaMoi = val;
                    break;
                }
                System.out.println(">> Đơn giá phải lớn hơn 0!");
            } catch (NumberFormatException e) {
                System.out.println(">> Đơn giá phải là số thực!");
            }
        }

        // 5. Sửa số lượng
        int soLuongMoi = soLuongCu;
        while (true) {
            System.out.print("Nhập số lượng mới [" + soLuongCu + "]: ");
            String input = scanner.nextLine().trim();
            if (input.isEmpty()) {
                break;
            }
            try {
                int val = Integer.parseInt(input);
                if (val >= 0) {
                    soLuongMoi = val;
                    break;
                }
                System.out.println(">> Số lượng phải lớn hơn hoặc bằng 0!");
            } catch (NumberFormatException e) {
                System.out.println(">> Số lượng phải là số nguyên!");
            }
        }

        // Cập nhật phần tử vào ArrayList bằng phương thức set(int index, E element)
        String thongTinMoi = maCu + "|" + tenMoi + "|" + tacGiaMoi + "|" + namXBMoi + "|" + (long)donGiaMoi + "|" + soLuongMoi;
        danhSachSach.set(viTri, thongTinMoi);

        System.out.println("\n>> CẬP NHẬT THÀNH CÔNG SÁCH MÃ [" + maCu + "]!");
        inChiTietSach(danhSachSach.get(viTri));
    }

    /**
     * BÀI 4 - Mục 6: Tính tổng số lượng của toàn bộ sách trong thư viện
     */
    private static void chucNang6_TinhTongSoLuong() {
        System.out.println("--- [6] TÍNH TỔNG SỐ LƯỢNG SÁCH TRONG THƯ VIỆN ---");
        if (danhSachSach.isEmpty()) {
            System.out.println(">> Thư viện chưa có sách để tính tổng số lượng!");
            return;
        }

        int tongSoLuong = 0;
        // Duyệt ArrayList<String> và lấy giá trị số lượng ở parts[5]
        for (String item : danhSachSach) {
            String[] parts = item.split("\\|");
            tongSoLuong += Integer.parseInt(parts[5]);
        }

        System.out.println("========================================================");
        System.out.println(" - Tổng số đầu sách (loại sách)  : " + danhSachSach.size() + " loại");
        System.out.println(" - TỔNG SỐ LƯỢNG SÁCH TRONG KHO   : " + tongSoLuong + " cuốn");
        System.out.println("========================================================");
    }

    /**
     * BÀI 4 - Mục 7: Tính tổng giá trị của toàn bộ sách trong thư viện
     * Giá trị mỗi sách = đơn giá * số lượng
     */
    private static void chucNang7_TinhTongGiaTri() {
        System.out.println("--- [7] TÍNH TỔNG GIÁ TRỊ SÁCH TRONG THƯ VIỆN ---");
        if (danhSachSach.isEmpty()) {
            System.out.println(">> Thư viện chưa có sách để tính tổng giá trị!");
            return;
        }

        double tongGiaTri = 0.0;
        // Duyệt ArrayList<String> để tính tổng giá trị (đơn giá * số lượng)
        for (String item : danhSachSach) {
            String[] parts = item.split("\\|");
            double donGia = Double.parseDouble(parts[4]);
            int soLuong = Integer.parseInt(parts[5]);
            tongGiaTri += (donGia * soLuong);
        }

        double phiVanChuyen = tongGiaTri * 0.05; // 5% phí vận chuyển theo bài tuần 3
        double tongTienNhap = tongGiaTri + phiVanChuyen;

        System.out.println("========================================================");
        System.out.println("  KẾT QUẢ TÍNH TỔNG GIÁ TRỊ SÁCH:");
        System.out.println("--------------------------------------------------------");
        System.out.println(" - Tổng số đầu sách hiện có      : " + danhSachSach.size() + " loại");
        System.out.println(" - TỔNG GIÁ TRỊ SÁCH (THÀNH TIỀN): " + df.format(tongGiaTri) + " VNĐ");
        System.out.println(" - Phí vận chuyển ước tính (5%)  : " + df.format(phiVanChuyen) + " VNĐ");
        System.out.println(" - TỔNG TIỀN NHẬP KHO DỰ KIẾN     : " + df.format(tongTienNhap) + " VNĐ");
        System.out.println("========================================================");
    }

    // =========================================================================
    // BÀI 1: MẢNG int[] soLuong (5 CUỐN SÁCH)
    // =========================================================================

    /**
     * BÀI 1: Tạo mảng: int[] soLuong; cho phép nhập số lượng của 5 cuốn sách.
     * Sau đó: Hiển thị số lượng, tính tổng, tìm số lượng lớn nhất.
     */
    private static void thucHienBai1_MangSoLuong() {
        System.out.println("========================================================");
        System.out.println(" [BÀI 1] THAO TÁC VỚI MẢNG: int[] soLuong (5 CUỐN SÁCH)  ");
        System.out.println("========================================================");

        // 1. Khai báo mảng int[] soLuong gồm 5 phần tử
        int[] soLuong = new int[5];

        // 2. Nhập số lượng của 5 cuốn sách
        System.out.println("Vui lòng nhập số lượng cho 5 cuốn sách:");
        for (int i = 0; i < soLuong.length; i++) {
            while (true) {
                int sl = nhapSoNguyen(" -> Số lượng cuốn sách thứ " + (i + 1) + ": ");
                if (sl >= 0) {
                    soLuong[i] = sl;
                    break;
                }
                System.out.println("   >> Số lượng không được âm! Vui lòng nhập lại.");
            }
        }

        // 3. Hiển thị số lượng 5 cuốn sách
        System.out.println("\n--------------------------------------------------------");
        System.out.println(">> Danh sách số lượng các cuốn sách vừa nhập (mảng):");
        System.out.println("   Mảng dạng chuỗi: " + Arrays.toString(soLuong));
        for (int i = 0; i < soLuong.length; i++) {
            System.out.printf("   + Cuốn sách thứ %d: %d cuốn\n", (i + 1), soLuong[i]);
        }

        // 4. Tính tổng số lượng
        int tong = 0;
        for (int i = 0; i < soLuong.length; i++) {
            tong += soLuong[i];
        }

        // 5. Tìm số lượng lớn nhất (Max)
        int max = soLuong[0];
        for (int i = 1; i < soLuong.length; i++) {
            if (soLuong[i] > max) {
                max = soLuong[i];
            }
        }

        // Tìm các vị trí đạt max
        StringBuilder viTriMax = new StringBuilder();
        for (int i = 0; i < soLuong.length; i++) {
            if (soLuong[i] == max) {
                if (viTriMax.length() > 0) viTriMax.append(", ");
                viTriMax.append("thứ ").append(i + 1);
            }
        }

        System.out.println("--------------------------------------------------------");
        System.out.println(">> TỔNG SỐ LƯỢNG 5 CUỐN SÁCH  : " + tong + " cuốn");
        System.out.println(">> SỐ LƯỢNG LỚN NHẤT (MAX)     : " + max + " cuốn (ở vị trí sách " + viTriMax + ")");
        System.out.println("========================================================");
    }

    // =========================================================================
    // BÀI 2: SỬ DỤNG ArrayList<String> ĐỂ LƯU MÃ SÁCH
    // =========================================================================

    /**
     * BÀI 2: Sử dụng ArrayList<String> để lưu mã sách.
     * Thực hiện: Thêm, hiển thị, tìm, xóa mã sách.
     */
    private static void thucHienBai2_QuanLyMaSach() {
        int chon;
        do {
            System.out.println("\n--------------------------------------------------------");
            System.out.println("   [BÀI 2] QUẢN LÝ MÃ SÁCH BẰNG ArrayList<String>       ");
            System.out.println("--------------------------------------------------------");
            System.out.println(" 1. Thêm mã sách");
            System.out.println(" 2. Hiển thị danh sách mã sách");
            System.out.println(" 3. Tìm mã sách (sử dụng contains / indexOf)");
            System.out.println(" 4. Xóa mã sách (sử dụng remove)");
            System.out.println(" 0. Quay lại Menu chính");
            System.out.println("--------------------------------------------------------");
            chon = nhapSoNguyen("Mời chọn thao tác [0-4]: ");

            switch (chon) {
                case 1:
                    System.out.print("Nhập mã sách cần thêm: ");
                    String maMoi = scanner.nextLine().trim();
                    if (maMoi.isEmpty()) {
                        System.out.println(">> Mã sách không được để trống!");
                    } else if (dsMaSachBai2.contains(maMoi)) {
                        System.out.println(">> Mã sách [" + maMoi + "] đã tồn tại trong danh sách!");
                    } else {
                        dsMaSachBai2.add(maMoi);
                        System.out.println(">> Đã thêm thành công mã: " + maMoi);
                    }
                    break;
                case 2:
                    System.out.println(">> Danh sách các mã sách hiện có (size = " + dsMaSachBai2.size() + "):");
                    if (dsMaSachBai2.isEmpty()) {
                        System.out.println("   (Danh sách mã sách đang trống)");
                    } else {
                        for (int i = 0; i < dsMaSachBai2.size(); i++) {
                            System.out.println("   [" + i + "] " + dsMaSachBai2.get(i));
                        }
                    }
                    break;
                case 3:
                    System.out.print("Nhập mã sách cần tìm: ");
                    String maTim = scanner.nextLine().trim();
                    if (dsMaSachBai2.contains(maTim)) {
                        int index = dsMaSachBai2.indexOf(maTim);
                        System.out.println(">> TÌM THẤY mã sách [" + maTim + "] tại vị trí index = " + index);
                    } else {
                        System.out.println(">> KHÔNG TÌM THẤY mã sách [" + maTim + "]!");
                    }
                    break;
                case 4:
                    System.out.print("Nhập mã sách cần xóa: ");
                    String maXoa = scanner.nextLine().trim();
                    if (dsMaSachBai2.remove(maXoa)) {
                        System.out.println(">> ĐÃ XÓA THÀNH CÔNG mã sách: [" + maXoa + "]");
                    } else {
                        System.out.println(">> Không tìm thấy mã sách [" + maXoa + "] để xóa!");
                    }
                    break;
                case 0:
                    System.out.println(">> Quay lại Menu chính...");
                    break;
                default:
                    System.out.println(">> Lựa chọn không hợp lệ!");
                    break;
            }
        } while (chon != 0);
    }

    // =========================================================================
    // CÁC HÀM TIỆN ÍCH HỖ TRỢ
    // =========================================================================

    /**
     * Tìm vị trí index của cuốn sách trong ArrayList<String> danhSachSach theo mã sách
     * @return index nếu tìm thấy, -1 nếu không tìm thấy
     */
    private static int timViTriSachTheoMa(String maSach) {
        for (int i = 0; i < danhSachSach.size(); i++) {
            String[] parts = danhSachSach.get(i).split("\\|");
            if (parts[0].equalsIgnoreCase(maSach)) {
                return i;
            }
        }
        return -1;
    }

    /**
     * In thông tin chi tiết một cuốn sách từ chuỗi định dạng
     */
    private static void inChiTietSach(String thongTin) {
        String[] parts = thongTin.split("\\|");
        String ma = parts[0];
        String ten = parts[1];
        String tacGia = parts[2];
        int namXB = Integer.parseInt(parts[3]);
        double gia = Double.parseDouble(parts[4]);
        int sl = Integer.parseInt(parts[5]);
        double thanhTien = gia * sl;

        System.out.println("-------------------------------------------------------");
        System.out.println(" Mã sách         : " + ma);
        System.out.println(" Tên sách        : " + ten);
        System.out.println(" Tác giả         : " + tacGia);
        System.out.println(" Năm xuất bản    : " + namXB);
        System.out.println(" Đơn giá         : " + df.format(gia) + " VNĐ");
        System.out.println(" Số lượng        : " + sl + " cuốn");
        System.out.println(" Thành tiền      : " + df.format(thanhTien) + " VNĐ");
        System.out.println("-------------------------------------------------------");
    }

    /**
     * Nạp sẵn các cuốn sách mẫu vào ArrayList để kiểm thử nhanh
     */
    private static void khoiTaoDuLieuMau() {
        danhSachSach.clear();
        dsMaSachBai2.clear();

        themSachMau("MS01", "Lap trinh Java co ban", "Nguyen Van A", 2022, 75000, 20);
        themSachMau("MS02", "Lap trinh huong doi tuong", "Pham Thi B", 2023, 120000, 15);
        themSachMau("MS03", "Cau truc du lieu & GT", "Tran Van C", 2021, 95000, 10);
        themSachMau("MS04", "Co so du lieu nang cao", "Le Thi D", 2024, 150000, 5);
    }

    private static void themSachMau(String ma, String ten, String tacGia, int namXB, double gia, int sl) {
        danhSachSach.add(ma + "|" + ten + "|" + tacGia + "|" + namXB + "|" + (long)gia + "|" + sl);
        dsMaSachBai2.add(ma);
    }

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
