import java.util.Scanner;
public class Prob_307 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number of defects: ");
        int k = sc.nextInt();  
        System.out.print("Enter the number of chips: ");
        int n = sc.nextInt();  
        sc.close();
        double lambda = (double) k / n;
        double P0 = Math.exp(-lambda);          
        double P1 = lambda * P0;              
        double P2 = (lambda * lambda / 2) * P0; 
        double probNoChipHas3OrMore = Math.pow(P0 + P1 + P2,n);
        
        //double result = 1 - Math.pow(probNoChipHas3OrMore, n);
        //double logProbability = n * Math.log(probNoChipHas3OrMore);
        //double result = 1 - Math.exp(logProbability);
        double result=1- probNoChipHas3OrMore;
        
        System.out.printf("Probability: %.10f%n", result);
    }
    
}


