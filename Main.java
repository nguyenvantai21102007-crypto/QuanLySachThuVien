
import java.util.Scanner;

public class Main {
cd C:\nvt\THHDTcd C:\nvt\THHDT    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String maSach[] = new String[100];
        String tenSach[] = new String[100];
        String tacGia[] = new String[100];
        int namXuatBan[] = new int[100];
        int soLuong[] = new int[100];
        double donGia[] = new double[100];

        int n = 0;
        int chon;

        do {
            System.out.println("\n===== QUAN LY THU VIEN =====");
            System.out.println("1. Nhap danh sach sach");
            System.out.println("2. Tinh tong so luong va tong gia tri");
            System.out.println("3. Hien thi danh sach sach");
            System.out.println("4. Tim sach theo ma");
            System.out.println("0. Thoat");

            System.out.print("Nhap lua chon: ");
            chon = sc.nextInt();
            sc.nextLine();

            switch (chon) {

                // Bai 1: Nhap n sach
                case 1:
                    System.out.print("Nhap so luong sach: ");
                    n = sc.nextInt();
                    sc.nextLine();

                    for (int i = 0; i < n; i++) {
                        System.out.println("\nNhap sach thu " + (i + 1));

                        System.out.print("Ma sach: ");
                        maSach[i] = sc.nextLine();

                        System.out.print("Ten sach: ");
                        tenSach[i] = sc.nextLine();

                        System.out.print("Tac gia: ");
                        tacGia[i] = sc.nextLine();

                        System.out.print("Nam xuat ban: ");
                        namXuatBan[i] = sc.nextInt();

                        System.out.print("Don gia: ");
                        donGia[i] = sc.nextDouble();

                        System.out.print("So luong: ");
                        soLuong[i] = sc.nextInt();
                        sc.nextLine();
                    }
                    break;

                // Bai 2: Tinh tong so luong va tong gia tri
                case 2:
                    int tongSoLuong = 0;
                    double tongGiaTri = 0;

                    for (int i = 0; i < n; i++) {
                        tongSoLuong += soLuong[i];
                        tongGiaTri += donGia[i] * soLuong[i];
                    }

                    System.out.println("Tong so luong sach: " + tongSoLuong);
                    System.out.println("Tong gia tri sach: " + tongGiaTri);
                    break;

                // Hien thi danh sach sach
                case 3:
                    if (n == 0) {
                        System.out.println("Chua co sach!");
                    } else {
                        for (int i = 0; i < n; i++) {
                            System.out.println("\n===== SACH THU " + (i + 1) + " =====");
                            System.out.println("Ma sach: " + maSach[i]);
                            System.out.println("Ten sach: " + tenSach[i]);
                            System.out.println("Tac gia: " + tacGia[i]);
                            System.out.println("Nam xuat ban: " + namXuatBan[i]);
                            System.out.println("Don gia: " + donGia[i]);
                            System.out.println("So luong: " + soLuong[i]);
                        }
                    }
                    break;

                // Bai 4: Tim sach theo ma
                case 4:
                    System.out.print("Nhap ma sach can tim: ");
                    String maTim = sc.nextLine();

                    boolean timThay = false;

                    for (int i = 0; i < n; i++) {
                        if (maSach[i].equalsIgnoreCase(maTim)) {
                            System.out.println("\nTim thay sach!");
                            System.out.println("Ma sach: " + maSach[i]);
                            System.out.println("Ten sach: " + tenSach[i]);
                            System.out.println("Tac gia: " + tacGia[i]);
                            System.out.println("Nam xuat ban: " + namXuatBan[i]);
                            System.out.println("Don gia: " + donGia[i]);
                            System.out.println("So luong: " + soLuong[i]);

                            timThay = true;
                        }
                    }

                    if (!timThay) {
                        System.out.println("Khong tim thay sach!");
                    }
                    break;

                case 0:
                    System.out.println("Thoat chuong trinh!");
                    break;

                default:
                    System.out.println("Lua chon khong hop le!");
            }

        } while (chon != 0);

        sc.close();
    }
}