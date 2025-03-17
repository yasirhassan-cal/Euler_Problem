import java.math.BigInteger;
import java.util.Scanner;

public class Prob_57{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter the number of expansion: ");
        int number=sc.nextInt();
        int count=0;
        BigInteger numerator=BigInteger.ONE;
        BigInteger denominator=BigInteger.ONE;
        for(int i=0;i<number;i++){
            BigInteger newNumerator=numerator.add(denominator.multiply(BigInteger.TWO));
            BigInteger newDenominator=numerator.add(denominator);
            if(newNumerator.toString().length() > newDenominator.toString().length())
            {
                count ++;
            }
            numerator=newNumerator;
            denominator=newDenominator;
        }
        System.out.println("Total Count: " + count);
    }
}