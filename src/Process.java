import java.util.ArrayList;
import java.util.Scanner;

class NumberExercise {

 
    public static ArrayList<Integer> EnterData(ArrayList<Integer> numbers) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhap so luong phan tu cua mang");
        int n = scanner.nextInt();
        System.out.println("Nhap phan tu mang:");
        for (int i = 0; i < n; i++) {
            numbers.add(scanner.nextInt());
        }
        return numbers;
    }

  
    public static void DisplayData(ArrayList<Integer> numbers) {
        System.out.println("mang so nguyen:");
        for (int i = 0; i < numbers.size(); i++) {
            System.out.print(numbers.get(i) + " ");
        }
        System.out.println();
    }

    
    public static int findMax2(ArrayList<Integer> numbers) {
        if (numbers.size() < 2) {
            throw new IllegalArgumentException("Mang phai co it nhat 2 phan tu.");
        }
        int max1 = Integer.MIN_VALUE;
        int max2 = Integer.MIN_VALUE;

        for (int i = 0; i < numbers.size(); i++) {
            int num = numbers.get(i);
            if (num > max1) {
                max2 = max1;
                max1 = num;
            } else if (num > max2 && num < max1) {
                max2 = num;
            }
        }
        return max2;
    }


    public static void deleteOddNumber(ArrayList<Integer> numbers) {
        for (int i = 0; i < numbers.size(); i++) {
            if (numbers.get(i) % 2 != 0) {
                numbers.remove(i);
                i--; 
            }
        }
    }
}

public class Process {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Integer> numbers = new ArrayList<>();
        boolean running = true;

        while (running) {
            System.out.println("Chon chuc nang:");
            System.out.println("Nhap mang so nguyen");
            System.out.println("Xuat mang ra man hinh");
            System.out.println("Tim gia tri phan tu thu 2");
            System.out.println("Xoa cac phan tu le");
            System.out.println("5. Thoat");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    numbers = NumberExercise.EnterData(numbers);
                    break;
                case 2:
                    NumberExercise.DisplayData(numbers);
                    break;
                case 3:
                    try {
                        int secondMax = NumberExercise.findMax2(numbers);
                        System.out.println("Gia tri phan tu thu 2: " + secondMax);
                    } catch (IllegalArgumentException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 4:
                    NumberExercise.deleteOddNumber(numbers);
                    System.out.println("Xoa cac phan tu le.");
                    break;
                case 5:
                    running = false;
                    System.out.println("thoat chuong trinh");
                    break;
                default:
                    System.out.println("Lua chon khong hop le");
            }
        }
        scanner.close();
    }
}