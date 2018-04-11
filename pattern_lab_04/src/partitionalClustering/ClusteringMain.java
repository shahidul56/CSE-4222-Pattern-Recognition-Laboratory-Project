package partitionalClustering;
// Author: Md.Farhan Sadique
import java.io.File;
import java.util.Scanner;

public class ClusteringMain {

	public static void main(String[] args) {
		File file = new File("input.txt");
		try {
			Scanner scanner = new Scanner(file);
			int numOfSamples = scanner.nextInt();
			Sample samples[] = new Sample[numOfSamples];
			for (int i = 0; i < numOfSamples; i++) {
				samples[i] = new Sample(scanner.nextDouble(), scanner.nextDouble());
			}
			System.out.println("1: Forgy's Algorithm");
			System.out.println("2: K-means Algorithm");
			Scanner scanner2 = new Scanner(System.in);
			int flag = scanner2.nextInt();
			System.out.print("k = ");
			int k = scanner2.nextInt();
			if(flag == 1) {
				ForgyAlgorithm forgyAlgorithm = new ForgyAlgorithm(samples, numOfSamples);
				forgyAlgorithm.clustering(k);
			}
			else if(flag == 2) {
				KmeansAlgorithm kmeansAlgorithm = new KmeansAlgorithm(samples, numOfSamples);
				kmeansAlgorithm.clustering(k);
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}
