package main;
import java.util.ArrayList;
import java.util.Scanner;
public class nguyenvantai {

    static Scanner sc = new Scanner(System.in);

    // Du lieu bai 2, 3, 4
    static ArrayList<String> danhSachMa = new ArrayList<>();
    static ArrayList<String> danhSachSach = new ArrayList<>();

    // ================= BAI 1 =================
    static void bai1() {
        int[] soLuong = new int[5];
        int tong = 0;
        int max;

        for (int i = 0; i < 5; i++) {
            System.out.print("Nhap so luong sach thu " + (i + 1) + ": ");
            soLuong[i] = Integer.parseInt(sc.nextLine());
        }

        max = soLuong[0];

        System.out.println("\nDanh sach so luong:");
        for (int i = 0; i < 5; i++) {
            System.out.println("Sach " + (i + 1) + ": " + soLuong[i]);

            tong += soLuong[i];

            if (soLuong[i] > max) {
                max = soLuong[i];
            }
        }

        System.out.println("Tong so luong: " + tong);
        System.out.println("So luong lon nhat: " + max);
    }

    // ================= BAI 2 =================
    static void bai2() {
        int chon;

        do {
            System.out.println("\n===== BAI 2 =====");
            System.out.println("1. Them ma sach");
            System.out.println("2. Hien thi ma sach");
            System.out.println("3. Tim ma sach");
            System.out.println("4. Xoa ma sach");
            System.out.println("5. Quay lai");
            System.out.print("Chon: ");

            chon = Integer.parseInt(sc.nextLine());

            switch (chon) {
                case 1:
                    System.out.print("Nhap ma sach: ");
                    danhSachMa.add(sc.nextLine());
                    break;

                case 2:
                    System.out.println(danhSachMa);
                    break;

                case 3:
                    System.out.print("Nhap ma sach can tim: ");
                    String maTim = sc.nextLine();

                    if (danhSachMa.contains(maTim))
                        System.out.println("Tim thay!");
                    else
                        System.out.println("Khong tim thay!");
                    break;

                case 4:
                    System.out.print("Nhap ma sach can xoa: ");
                    String maXoa = sc.nextLine();

                    if (danhSachMa.remove(maXoa))
                        System.out.println("Xoa thanh cong!");
                    else
                        System.out.println("Khong tim thay!");
                    break;
            }

        } while (chon != 5);
    }

    // ================= TIM SACH =================
    static int timSach(String ma) {
        for (int i = 0; i < danhSachSach.size(); i++) {
            String[] tt = danhSachSach.get(i).split("\\|");

            if (tt[0].equalsIgnoreCase(ma)) {
                return i;
            }
        }
        return -1;
    }

    // ================= BAI 3 =================
    static void bai3() {
        int chon;

        do {
            System.out.println("\n===== BAI 3 =====");
            System.out.println("1. Them sach");
            System.out.println("2. Hien thi sach");
            System.out.println("3. Tim sach");
            System.out.println("4. Xoa sach");
            System.out.println("5. Sua sach");
            System.out.println("6. Quay lai");
            System.out.print("Chon: ");

            chon = Integer.parseInt(sc.nextLine());

            switch (chon) {
                case 1:
                    themSach();
                    break;

                case 2:
                    hienThiSach();
                    break;

                case 3:
                    timKiemSach();
                    break;

                case 4:
                    xoaSach();
                    break;

                case 5:
                    suaSach();
                    break;
            }

        } while (chon != 6);
    }

    // ================= CAC CHUC NANG SACH =================
    static void themSach() {
        System.out.print("Nhap ma sach: ");
        String ma = sc.nextLine();

        if (timSach(ma) != -1) {
            System.out.println("Ma sach da ton tai!");
            return;
        }

        System.out.print("Nhap ten sach: ");
        String ten = sc.nextLine();

        System.out.print("Nhap tac gia: ");
        String tacGia = sc.nextLine();

        System.out.print("Nhap so luong: ");
        int soLuong = Integer.parseInt(sc.nextLine());

        System.out.print("Nhap don gia: ");
        double donGia = Double.parseDouble(sc.nextLine());

        if (soLuong < 0 || donGia < 0) {
            System.out.println("Du lieu khong hop le!");
            return;
        }

        String sach = ma + "|" + ten + "|" + tacGia
                    + "|" + soLuong + "|" + donGia;

        danhSachSach.add(sach);

        System.out.println("Them thanh cong!");
    }

    static void hienThiSach() {
        if (danhSachSach.isEmpty()) {
            System.out.println("Danh sach rong!");
            return;
        }

        for (String s : danhSachSach) {
            String[] tt = s.split("\\|");

            System.out.println("Ma: " + tt[0]);
            System.out.println("Ten: " + tt[1]);
            System.out.println("Tac gia: " + tt[2]);
            System.out.println("So luong: " + tt[3]);
            System.out.println("Don gia: " + tt[4]);
            System.out.println("----------------");
        }
    }

    static void timKiemSach() {
        System.out.print("Nhap ma sach can tim: ");
        String ma = sc.nextLine();

        int vt = timSach(ma);

        if (vt == -1)
            System.out.println("Khong tim thay!");
        else
            System.out.println(danhSachSach.get(vt));
    }

    static void xoaSach() {
        System.out.print("Nhap ma sach can xoa: ");
        String ma = sc.nextLine();

        int vt = timSach(ma);

        if (vt == -1)
            System.out.println("Khong tim thay!");
        else {
            danhSachSach.remove(vt);
            System.out.println("Xoa thanh cong!");
        }
    }

    static void suaSach() {
        System.out.print("Nhap ma sach can sua: ");
        String ma = sc.nextLine();

        int vt = timSach(ma);

        if (vt == -1) {
            System.out.println("Khong tim thay!");
            return;
        }

        System.out.print("Nhap ten moi: ");
        String ten = sc.nextLine();

        System.out.print("Nhap tac gia moi: ");
        String tacGia = sc.nextLine();

        System.out.print("Nhap so luong moi: ");
        int soLuong = Integer.parseInt(sc.nextLine());

        System.out.print("Nhap don gia moi: ");
        double donGia = Double.parseDouble(sc.nextLine());

        if (soLuong < 0 || donGia < 0) {
            System.out.println("Du lieu khong hop le!");
            return;
        }

        String sachMoi = ma + "|" + ten + "|" + tacGia
                       + "|" + soLuong + "|" + donGia;

        danhSachSach.set(vt, sachMoi);

        System.out.println("Sua thanh cong!");
    }

    // ================= BAI 4 =================
    static void bai4() {
        int chon;

        do {
            System.out.println("\n===== QUAN LY THU VIEN =====");
            System.out.println("1. Them sach");
            System.out.println("2. Hien thi sach");
            System.out.println("3. Tim sach");
            System.out.println("4. Xoa sach");
            System.out.println("5. Sua sach");
            System.out.println("6. Tinh tong so luong");
            System.out.println("7. Tinh tong gia tri");
            System.out.println("8. Thoat");
            System.out.print("Chon: ");

            chon = Integer.parseInt(sc.nextLine());

            switch (chon) {
                case 1:
                    themSach();
                    break;

                case 2:
                    hienThiSach();
                    break;

                case 3:
                    timKiemSach();
                    break;

                case 4:
                    xoaSach();
                    break;

                case 5:
                    suaSach();
                    break;

                case 6:
                    int tong = 0;

                    for (String s : danhSachSach) {
                        String[] tt = s.split("\\|");
                        tong += Integer.parseInt(tt[3]);
                    }

                    System.out.println("Tong so luong: " + tong);
                    break;

                case 7:
                    double tongGiaTri = 0;

                    for (String s : danhSachSach) {
                        String[] tt = s.split("\\|");

                        int sl = Integer.parseInt(tt[3]);
                        double gia = Double.parseDouble(tt[4]);

                        tongGiaTri += sl * gia;
                    }

                    System.out.println("Tong gia tri: " + tongGiaTri);
                    break;

                case 8:
                    System.out.println("Thoat chuong trinh!");
                    break;

                default:
                    System.out.println("Lua chon khong hop le!");
            }

        } while (chon != 8);
    }

    // ================= MAIN =================
    public static void main(String[] args) {
        int chon;

        do {
            System.out.println("\n===== BAI THUC HANH 6 =====");
            System.out.println("1. Bai 1 - Mang int[]");
            System.out.println("2. Bai 2 - ArrayList ma sach");
            System.out.println("3. Bai 3 - Quan ly danh sach sach");
            System.out.println("4. Bai 4 - Menu thu vien");
            System.out.println("5. Thoat");
            System.out.print("Nhap lua chon: ");

            chon = Integer.parseInt(sc.nextLine());

            switch (chon) {
                case 1:
                    bai1();
                    break;

                case 2:
                    bai2();
                    break;

                case 3:
                    bai3();
                    break;

                case 4:
                    bai4();
                    break;

                case 5:
                    System.out.println("Ket thuc!");
                    break;

                default:
                    System.out.println("Lua chon khong hop le!");
            }

        } while (chon != 5);

        sc.close();
    }
}
    
}
