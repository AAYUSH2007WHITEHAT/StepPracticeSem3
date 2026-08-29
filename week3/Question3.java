import java.util.Scanner;
public class Question3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a number: ");
        int num = sc.nextInt();

        int originalNum = num;
        int reversedNum = 0;
        while(num > 0){
            reversedNum = reversedNum * 10 + num % 10;
            num = num / 10;
        }
        if(originalNum == reversedNum){
            System.out.println("Is the number " + originalNum + " a palindrome? true");
        } else {
            System.out.println("Is the number " + originalNum + " a palindrome? false");
        }
    }
}
