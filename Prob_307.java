import java.util.Scanner;
public class Prob_307 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        // Input number of defects and chips
        System.out.print("Enter the number of defects: ");
        int k = sc.nextInt();  // Number of defects (e.g., 20000)
        System.out.print("Enter the number of chips: ");
        int n = sc.nextInt();  // Total number of chips (e.g., 1000000)
        sc.close();
        
        // Calculate the Poisson distribution parameter lambda
        double lambda = (double) k / n;

        // Calculate the probability that no chip has 3 or more defects
        double P0 = Math.exp(-lambda);          // Probability of 0 defects
        double P1 = lambda * P0;               // Probability of 1 defect
        double P2 = (lambda * lambda / 2) * P0; // Probability of 2 defects
        
        // Probability that no chip has 3 or more defects
        double probNoChipHas3OrMore = Math.pow(P0 + P1 + P2,n);
        
        // The probability that at least one chip has 3 or more defects
        //double result = 1 - Math.pow(probNoChipHas3OrMore, n);
        //double logProbability = n * Math.log(probNoChipHas3OrMore);
        //double result = 1 - Math.exp(logProbability);
        double result=1- probNoChipHas3OrMore;
        
        // Output the result with 10 decimal places
        System.out.printf("Probability: %.10f%n", result);
    }
    
}


