
import java.time.LocalDate;

public class Sach {
    // Yêu cầu 1: Tất cả thuộc tính khai báo private
    private String maSach;
    private String tieuDe;
    private String tacGia;
    private int namXuatBan;
    private int soLuong;

    // Constructor mặc định
    public Sach() {
    }

    // Yêu cầu 4: Constructor có tham số đầy đủ (gọi setter để áp dụng ràng buộc kiểm tra dữ liệu)
    public Sach(String maSach, String tieuDe, String tacGia, int namXuatBan, int soLuong) {
        this.maSach = maSach;
        this.tieuDe = tieuDe;
        this.tacGia = tacGia;
        setNamXuatBan(namXuatBan);
        setSoLuong(soLuong);
    }

    // Yêu cầu 2: Các phương thức public getter và setter
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

    // Yêu cầu 3: Kiểm tra năm xuất bản hợp lệ (> 0 và <= năm hiện tại)
    public void setNamXuatBan(int namXuatBan) {
        int currentYear = LocalDate.now().getYear();
        if (namXuatBan > 0 && namXuatBan <= currentYear) {
            this.namXuatBan = namXuatBan;
        } else {
            System.out.println("Năm xuất bản không hợp lệ (" + namXuatBan + "). Phải nằm trong khoảng 1.." + currentYear + ". Giữ nguyên giá trị hiện tại: " + this.namXuatBan);
        }
    }

    public int getSoLuong() {
        return soLuong;
    }

    // Yêu cầu 3: Kiểm tra số lượng không âm (>= 0)
    public void setSoLuong(int soLuong) {
        if (soLuong >= 0) {
            this.soLuong = soLuong;
        } else {
            System.out.println("Số lượng không hợp lệ (" + soLuong + "). Số lượng phải >= 0. Giữ nguyên giá trị hiện tại: " + this.soLuong);
        }
    }

    public void hienThiThongTin() {
        System.out.printf("Mã sách: %-8s | Tiêu đề: %-26s | Tác giả: %-18s | Năm XB: %-5d | Số lượng: %d%n",
                maSach, tieuDe, tacGia, namXuatBan, soLuong);
    }
} 
