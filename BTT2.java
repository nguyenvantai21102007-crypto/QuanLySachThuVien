import java.util.Scanner;

public class BTT2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Nhap ho va ten: ");
        String hoTen = sc.nextLine();

        System.out.println("Ho va ten cua toi la: " + hoTen);

        sc.close();
    }
}