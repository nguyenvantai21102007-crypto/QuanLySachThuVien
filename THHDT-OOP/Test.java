import java.util.ArrayList;
import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        // Yêu cầu 4: Quản lý danh sách Sach bằng ArrayList
        ArrayList<Sach> danhSachSach = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);

        // Yêu cầu 3: Tạo đối tượng từ lớp Sach và thêm vào danh sách
        danhSachSach.add(new Sach("S001", "Dế Mèn Phiêu Lưu Ký", "Tô Hoài", 1941, 12));
        danhSachSach.add(new Sach("S002", "Nhà Giả Kim", "Paulo Coelho", 1988, 18));
        danhSachSach.add(new Sach("S003", "Lập Trình Hướng Đối Tượng", "Nguyễn Văn A", 2024, 25));

        int luaChon;
        do {
            System.out.println("\n===== HỆ THỐNG QUẢN LÝ SÁCH THƯ VIỆN =====");
            System.out.println("1. Hiển thị danh sách sách");
            System.out.println("2. Thêm sách mới");
            System.out.println("3. Tìm kiếm sách theo mã");
            System.out.println("4. Cập nhật số lượng sách theo mã");
            System.out.println("5. Xóa sách theo mã");
            System.out.println("0. Thoát");
            System.out.print("Chọn chức năng: ");

            try {
                luaChon = Integer.parseInt(scanner.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.println("Vui lòng nhập số hợp lệ!");
                luaChon = -1;
                continue;
            }

            switch (luaChon) {
                case 1:
                    System.out.println("\n--- DANH SÁCH SÁCH ---");
                    if (danhSachSach.isEmpty()) {
                        System.out.println("Danh sách sách đang trống.");
                    } else {
                        for (Sach s : danhSachSach) {
                            s.hienThiThongTin();
                        }
                    }
                    break;

                case 2:
                    System.out.println("\n--- THÊM SÁCH MỚI ---");
                    System.out.print("Nhập mã sách: ");
                    String ma = scanner.nextLine().trim();
                    System.out.print("Nhập tiêu đề: ");
                    String tieuDe = scanner.nextLine().trim();
                    System.out.print("Nhập tác giả: ");
                    String tacGia = scanner.nextLine().trim();
                    System.out.print("Nhập năm xuất bản: ");
                    int namXB = Integer.parseInt(scanner.nextLine().trim());
                    System.out.print("Nhập số lượng: ");
                    int soLuong = Integer.parseInt(scanner.nextLine().trim());

                    danhSachSach.add(new Sach(ma, tieuDe, tacGia, namXB, soLuong));
                    System.out.println("Đã thêm sách thành công!");
                    break;

                case 3:
                    System.out.print("\nNhập mã sách cần tìm: ");
                    String maTim = scanner.nextLine().trim();
                    Sach sachTim = timSachTheoMa(danhSachSach, maTim);
                    if (sachTim != null) {
                        System.out.println("Thông tin sách tìm thấy:");
                        sachTim.hienThiThongTin();
                    } else {
                        System.out.println("Không tìm thấy sách có mã: " + maTim);
                    }
                    break;

                case 4:
                    System.out.print("\nNhập mã sách cần cập nhật số lượng: ");
                    String maCapNhat = scanner.nextLine().trim();
                    Sach sachCapNhat = timSachTheoMa(danhSachSach, maCapNhat);
                    if (sachCapNhat != null) {
                        System.out.print("Nhập số lượng mới: ");
                        int slMoi = Integer.parseInt(scanner.nextLine().trim());
                        if (slMoi >= 0) {
                            sachCapNhat.setSoLuong(slMoi);
                            System.out.println("Đã cập nhật số lượng thành công!");
                        } else {
                            System.out.println("Số lượng không được nhỏ hơn 0.");
                        }
                    } else {
                        System.out.println("Không tìm thấy sách có mã: " + maCapNhat);
                    }
                    break;

                case 5:
                    System.out.print("\nNhập mã sách cần xóa: ");
                    String maXoa = scanner.nextLine().trim();
                    boolean daXoa = danhSachSach.removeIf(s -> s.getMaSach().equalsIgnoreCase(maXoa));
                    if (daXoa) {
                        System.out.println("Đã xóa sách có mã: " + maXoa);
                    } else {
                        System.out.println("Không tìm thấy sách có mã: " + maXoa);
                    }
                    break;

                case 0:
                    System.out.println("Thoát chương trình.");
                    break;

                default:
                    System.out.println("Lựa chọn không tồn tại!");
            }
        } while (luaChon != 0);

        scanner.close();
    }

    private static Sach timSachTheoMa(ArrayList<Sach> danhSach, String maSach) {
        for (Sach s : danhSach) {
            if (s.getMaSach().equalsIgnoreCase(maSach)) {
                return s;
            }
        }
        return null;
    }
}