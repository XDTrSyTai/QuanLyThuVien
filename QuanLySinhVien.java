import java.util.ArrayList;
import java.util.Scanner;

// Lớp SinhVien - đại diện cho một sinh viên
class SinhVien {
    private String maSV;
    private String hoTen;
    private double diemTB;

    public SinhVien(String maSV, String hoTen, double diemTB) {
        this.maSV = maSV;
        this.hoTen = hoTen;
        this.diemTB = diemTB;
    }

    public String getMaSV() { return maSV; }
    public String getHoTen() { return hoTen; }
    public double getDiemTB() { return diemTB; }

    public String xepLoai() {
        if (diemTB >= 8.0) return "Gioi";
        else if (diemTB >= 6.5) return "Kha";
        else if (diemTB >= 5.0) return "Trung binh";
        else return "Yeu";
    }

    @Override
    public String toString() {
        return String.format("%-8s | %-20s | %5.2f | %s",
                maSV, hoTen, diemTB, xepLoai());
    }
}

// Lớp chính
public class QuanLySinhVien {
    static ArrayList<SinhVien> danhSach = new ArrayList<>();
    static Scanner scanner = new Scanner(System.in);

    // Thêm sinh viên mẫu
    static void khoiTaoDuLieu() {
        danhSach.add(new SinhVien("SV001", "Nguyen Van An", 8.5));
        danhSach.add(new SinhVien("SV002", "Tran Thi Binh", 7.2));
        danhSach.add(new SinhVien("SV003", "Le Van Cuong", 5.8));
        danhSach.add(new SinhVien("SV004", "Pham Thi Dung", 9.1));
        danhSach.add(new SinhVien("SV005", "Hoang Van Em", 4.5));
    }

    // Hiển thị danh sách
    static void hienThiDanhSach() {
        System.out.println("\n--- DANH SACH SINH VIEN ---");
        System.out.printf("%-8s | %-20s | %5s | %s%n",
                "Ma SV", "Ho Ten", "Diem", "Xep Loai");
        System.out.println("----------------------------------------------------");
        for (SinhVien sv : danhSach) {
            System.out.println(sv);
        }
    }

    // Tính điểm trung bình cả lớp
    static double tinhDiemTrungBinh() {
        if (danhSach.isEmpty()) return 0;
        double tong = 0;
        for (SinhVien sv : danhSach) tong += sv.getDiemTB();
        return tong / danhSach.size();
    }

    // Tìm sinh viên điểm cao nhất
    static SinhVien timDiemCaoNhat() {
        if (danhSach.isEmpty()) return null;
        SinhVien max = danhSach.get(0);
        for (SinhVien sv : danhSach) {
            if (sv.getDiemTB() > max.getDiemTB()) max = sv;
        }
        return max;
    }

    // Đếm số sinh viên theo xếp loại
    static void thongKeXepLoai() {
        int gioi = 0, kha = 0, tb = 0, yeu = 0;
        for (SinhVien sv : danhSach) {
            switch (sv.xepLoai()) {
                case "Gioi": gioi++; break;
                case "Kha": kha++; break;
                case "Trung binh": tb++; break;
                default: yeu++;
            }
        }
        System.out.println("\n--- THONG KE XEP LOAI ---");
        System.out.println("Gioi: " + gioi);
        System.out.println("Kha: " + kha);
        System.out.println("Trung binh: " + tb);
        System.out.println("Yeu: " + yeu);
    }

    // Main
    public static void main(String[] args) {
        System.out.println("=== CHUONG TRINH QUAN LY SINH VIEN ===");

        khoiTaoDuLieu();
        hienThiDanhSach();

        System.out.printf("\nDiem trung binh ca lop: %.2f%n", tinhDiemTrungBinh());

        SinhVien top = timDiemCaoNhat();
        if (top != null) {
            System.out.println("Sinh vien diem cao nhat: " + top.getHoTen() 
                    + " (" + top.getDiemTB() + ")");
        }

        thongKeXepLoai();

        // Test vòng lặp và điều kiện
        System.out.print("\nNhap so nguyen n (kiem tra so chan/le): ");
        try {
            int n = Integer.parseInt(scanner.nextLine());
            if (n % 2 == 0) System.out.println(n + " la so chan");
            else System.out.println(n + " la so le");

            System.out.print("Cac so tu 1 den " + n + ": ");
            for (int i = 1; i <= n; i++) System.out.print(i + " ");
            System.out.println();
        } catch (NumberFormatException e) {
            System.out.println("Ban nhap khong phai so nguyen!");
        }

        System.out.println("\n=== KET THUC CHUONG TRINH ===");
        scanner.close();
    }
}