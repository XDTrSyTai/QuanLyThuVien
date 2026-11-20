import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Scanner;

class Sach {
    private String maSach;
    private String ngayNhap;
    private double donGia;
    private int soLuong;
    private String nhaXuatBan;

    public Sach() {}

    public Sach(String maSach, String ngayNhap, double donGia, int soLuong, String nhaXuatBan) {
        this.maSach = maSach;
        this.ngayNhap = ngayNhap;
        this.donGia = donGia;
        this.soLuong = soLuong;
        this.nhaXuatBan = nhaXuatBan;
    }

    public String getMaSach() { return maSach; }
    public void setMaSach(String maSach) { this.maSach = maSach; }
    public String getNgayNhap() { return ngayNhap; }
    public void setNgayNhap(String ngayNhap) { this.ngayNhap = ngayNhap; }
    public double getDonGia() { return donGia; }
    public void setDonGia(double donGia) { this.donGia = donGia; }
    public int getSoLuong() { return soLuong; }
    public void setSoLuong(int soLuong) { this.soLuong = soLuong; }
    public String getNhaXuatBan() { return nhaXuatBan; }
    public void setNhaXuatBan(String nhaXuatBan) { this.nhaXuatBan = nhaXuatBan; }

    public double tinhThanhTien() {
        return this.soLuong * this.donGia;
    }

    public void hienThiThongTin() {
        DecimalFormat df = new DecimalFormat("#,##0 VNĐ");
        System.out.println("  Mã sách      : " + maSach);
        System.out.println("  Ngày nhập    : " + ngayNhap);
        System.out.println("  Đơn giá      : " + df.format(donGia));
        System.out.println("  Số lượng     : " + soLuong);
        System.out.println("  Nhà xuất bản : " + nhaXuatBan);
    }
}

class SachGiaoKhoa extends Sach {
    private String tinhTrang; // "mới" hoặc "cũ"

    public SachGiaoKhoa() {
        super();
    }

    public SachGiaoKhoa(String maSach, String ngayNhap, double donGia, int soLuong, String nhaXuatBan, String tinhTrang) {
        super(maSach, ngayNhap, donGia, soLuong, nhaXuatBan);
        this.tinhTrang = tinhTrang;
    }

    public String getTinhTrang() { return tinhTrang; }
    public void setTinhTrang(String tinhTrang) { this.tinhTrang = tinhTrang; }

    @Override
    public double tinhThanhTien() {
        if (tinhTrang != null && (tinhTrang.equalsIgnoreCase("mới") || tinhTrang.equalsIgnoreCase("moi"))) {
            return getSoLuong() * getDonGia();
        }
        return getSoLuong() * getDonGia() * 0.5;
    }

    @Override
    public void hienThiThongTin() {
        super.hienThiThongTin();
        DecimalFormat df = new DecimalFormat("#,##0 VNĐ");
        System.out.println("  Tình trạng   : " + tinhTrang);
        System.out.println("  Thành tiền   : " + df.format(tinhThanhTien()));
        System.out.println("----------------------------------------");
    }
}

class SachThamKhao extends Sach {
    private double thue;

    public SachThamKhao() {
        super();
    }

    public SachThamKhao(String maSach, String ngayNhap, double donGia, int soLuong, String nhaXuatBan, double thue) {
        super(maSach, ngayNhap, donGia, soLuong, nhaXuatBan);
        this.thue = thue;
    }

    public double getThue() { return thue; }
    public void setThue(double thue) { this.thue = thue; }

    @Override
    public double tinhThanhTien() {
        return (getSoLuong() * getDonGia()) + thue;
    }

    @Override
    public void hienThiThongTin() {
        super.hienThiThongTin();
        DecimalFormat df = new DecimalFormat("#,##0 VNĐ");
        System.out.println("  Thuế         : " + df.format(thue));
        System.out.println("  Thành tiền   : " + df.format(tinhThanhTien()));
        System.out.println("----------------------------------------");
    }
}

public class BTT9 {
    private static final Scanner sc = new Scanner(System.in);
    private static final DecimalFormat df = new DecimalFormat("#,##0 VNĐ");
    private static final ArrayList<SachGiaoKhoa> dsSGK = new ArrayList<>();
    private static final ArrayList<SachThamKhao> dsSTK = new ArrayList<>();

    public static void main(String[] args) {
        khoiTaoDuLieuMau();

        while (true) {
            System.out.println("\n========== QUẢN LÝ SÁCH (BÀI THỰC HÀNH TUẦN 9) ==========");
            System.out.println("1. Xuất danh sách các loại sách (SGK & STK)");
            System.out.println("2. Thêm sách mới vào thư viện");
            System.out.println("3. Tính tổng thành tiền cho từng loại sách");
            System.out.println("4. Tính trung bình cộng đơn giá sách tham khảo");
            System.out.println("5. Xuất các sách giáo khoa theo nhà xuất bản X");
            System.out.println("0. Thoát chương trình");
            System.out.print("Mời bạn chọn [0-5]: ");

            int chon;
            try {
                chon = Integer.parseInt(sc.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.println(">> Vui lòng nhập số!");
                continue;
            }

            switch (chon) {
                case 1 -> xuatDanhSach();
                case 2 -> themSach();
                case 3 -> tinhTongThanhTien();
                case 4 -> tinhTBCDonGiaSTK();
                case 5 -> xuatSGKTheoNXB();
                case 0 -> {
                    System.out.println(">> Kết thúc chương trình. Tạm biệt!");
                    return;
                }
                default -> System.out.println(">> Lựa chọn không hợp lệ!");
            }
        }
    }

    private static void khoiTaoDuLieuMau() {
        dsSGK.clear();
        dsSTK.clear();
        dsSGK.add(new SachGiaoKhoa("GK01", "10/01/2024", 50000, 10, "Giáo Dục", "mới"));
        dsSGK.add(new SachGiaoKhoa("GK02", "15/02/2024", 60000, 20, "Giáo Dục", "cũ"));
        dsSGK.add(new SachGiaoKhoa("GK03", "20/03/2024", 45000, 15, "Kim Đồng", "mới"));

        dsSTK.add(new SachThamKhao("TK01", "05/01/2024", 120000, 5, "Đại học Quốc gia", 10000));
        dsSTK.add(new SachThamKhao("TK02", "12/02/2024", 150000, 8, "Kỹ thuật", 15000));
        dsSTK.add(new SachThamKhao("TK03", "18/03/2024", 90000, 10, "Tổng Hợp", 8000));
    }

    private static void xuatDanhSach() {
        System.out.println("\n=== DANH SÁCH SÁCH GIÁO KHOA ===");
        if (dsSGK.isEmpty()) System.out.println("(Trống)");
        for (SachGiaoKhoa s : dsSGK) s.hienThiThongTin();

        System.out.println("\n=== DANH SÁCH SÁCH THAM KHẢO ===");
        if (dsSTK.isEmpty()) System.out.println("(Trống)");
        for (SachThamKhao s : dsSTK) s.hienThiThongTin();
    }

    private static void themSach() {
        System.out.print("Chọn loại sách (1: Sách giáo khoa, 2: Sách tham khảo): ");
        String loai = sc.nextLine().trim();
        if (!loai.equals("1") && !loai.equals("2")) {
            System.out.println(">> Lựa chọn không hợp lệ!");
            return;
        }

        System.out.print("Mã sách: ");
        String ma = sc.nextLine().trim();
        System.out.print("Ngày nhập (dd/MM/yyyy): ");
        String ngay = sc.nextLine().trim();
        System.out.print("Đơn giá: ");
        double gia = Double.parseDouble(sc.nextLine().trim());
        System.out.print("Số lượng: ");
        int sl = Integer.parseInt(sc.nextLine().trim());
        System.out.print("Nhà xuất bản: ");
        String nxb = sc.nextLine().trim();

        if (loai.equals("1")) {
            System.out.print("Tình trạng (mới/cũ): ");
            String tinhTrang = sc.nextLine().trim();
            SachGiaoKhoa sgk = new SachGiaoKhoa(ma, ngay, gia, sl, nxb, tinhTrang);
            dsSGK.add(sgk);
            System.out.println(">> Đã thêm sách giáo khoa thành công!");
        } else {
            System.out.print("Tiền thuế: ");
            double thue = Double.parseDouble(sc.nextLine().trim());
            SachThamKhao stk = new SachThamKhao(ma, ngay, gia, sl, nxb, thue);
            dsSTK.add(stk);
            System.out.println(">> Đã thêm sách tham khảo thành công!");
        }
    }

    private static void tinhTongThanhTien() {
        double tongSGK = 0, tongSTK = 0;
        for (SachGiaoKhoa s : dsSGK) tongSGK += s.tinhThanhTien();
        for (SachThamKhao s : dsSTK) tongSTK += s.tinhThanhTien();

        System.out.println("\n>> Tổng thành tiền Sách giáo khoa : " + df.format(tongSGK));
        System.out.println(">> Tổng thành tiền Sách tham khảo : " + df.format(tongSTK));
        System.out.println(">> Tổng cộng cả 2 loại            : " + df.format(tongSGK + tongSTK));
    }

    private static void tinhTBCDonGiaSTK() {
        if (dsSTK.isEmpty()) {
            System.out.println(">> Không có sách tham khảo nào!");
            return;
        }
        double tongDonGia = 0;
        for (SachThamKhao s : dsSTK) tongDonGia += s.getDonGia();
        System.out.println("\n>> Trung bình cộng đơn giá sách tham khảo: " + df.format(tongDonGia / dsSTK.size()));
    }

    private static void xuatSGKTheoNXB() {
        System.out.print("Nhập tên nhà xuất bản cần tìm: ");
        String nxb = sc.nextLine().trim();
        boolean timThay = false;

        System.out.println("\n=== SÁCH GIÁO KHOA CỦA NXB \"" + nxb + "\" ===");
        for (SachGiaoKhoa s : dsSGK) {
            if (s.getNhaXuatBan().equalsIgnoreCase(nxb)) {
                s.hienThiThongTin();
                timThay = true;
            }
        }
        if (!timThay) {
            System.out.println(">> Không tìm thấy sách giáo khoa nào của NXB " + nxb);
        }
    }
}

class Test {
    public static void main(String[] args) {
        BTT9.main(args);
    }
}
