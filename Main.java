import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String maSach, tenSach, tacGia;
        int namXuatBan, soLuong;
        double donGia, thanhTien, phiVanChuyen, tongTien;

        // Bai 1: Nhap thong tin sach
        System.out.print("Nhap ma sach: ");
        maSach = sc.nextLine();

        System.out.print("Nhap ten sach: ");
        tenSach = sc.nextLine();

        System.out.print("Nhap tac gia: ");
        tacGia = sc.nextLine();

        System.out.print("Nhap nam xuat ban: ");
        namXuatBan = sc.nextInt();

        System.out.print("Nhap don gia: ");
        donGia = sc.nextDouble();

        System.out.print("Nhap so luong: ");
        soLuong = sc.nextInt();

        // Bai2:Tinh thanh tien
        thanhTien = donGia * soLuong;

        // Bai3:Tinh phi van chuyen
        phiVanChuyen = thanhTien * 5 / 100;

        // Bai4:Tinh tong tien nhap
        tongTien = thanhTien + phiVanChuyen;

        // Hien thi thong tin
        System.out.println("\n===== THONG TIN SACH =====");
        System.out.println("Ma sach: " + maSach);
        System.out.println("Ten sach: " + tenSach);
        System.out.println("Tac gia: " + tacGia);
        System.out.println("Nam xuat ban: " + namXuatBan);
        System.out.println("Don gia: " + donGia);
        System.out.println("So luong: " + soLuong);

        System.out.println("Thanh tien: " + thanhTien);
        System.out.println("Phi van chuyen: " + phiVanChuyen);
        System.out.println("Tong tien nhap: " + tongTien);

        sc.close();
    }
}