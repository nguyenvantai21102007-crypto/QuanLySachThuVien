
import java.util.ArrayList;

public class Test {
    public static void main(String[] args) {
        ArrayList<Sach> danhSachSach = new ArrayList<>();

        // Yêu cầu 4: Khởi tạo bằng constructor có tham số đầy đủ
        Sach s1 = new Sach("S001", "Dế Mèn Phiêu Lưu Ký", "Tô Hoài", 1941, 15);
        Sach s2 = new Sach("S002", "Nhà Giả Kim", "Paulo Coelho", 1988, 20);

        // Kiểm tra Yêu cầu 3: truyền năm xuất bản tương lai / âm và số lượng âm
        Sach s3 = new Sach("S003", "Sách Thử Nghiệm", "Tác Giả X", 2999, -5);
        s3.setNamXuatBan(2024);
        s3.setSoLuong(12);

        danhSachSach.add(s1);
        danhSachSach.add(s2);
        danhSachSach.add(s3);

        System.out.println("--- DANH SÁCH SÁCH ---");
        for (Sach s : danhSachSach) {
            s.hienThiThongTin();
        }

        // Kiểm tra getter & setter
        System.out.println("\nTiêu đề của S001: " + s1.getTieuDe());
        s2.setSoLuong(-10); // Bị từ chối, giữ nguyên 20
        System.out.println("Số lượng của S002 sau khi thử gán -10: " + s2.getSoLuong());
    }
} 
