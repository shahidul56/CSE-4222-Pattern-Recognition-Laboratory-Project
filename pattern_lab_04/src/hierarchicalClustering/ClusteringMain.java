package hierarchicalClustering;

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
			System.out.println("1: Single-Linkage");
			System.out.println("2: Complete-Linkage");
			System.out.println("3: Average-Linkage");
			//System.out.println("4: Ward's Method");
			Scanner scanner2 = new Scanner(System.in);
			int flag = scanner2.nextInt();
			if(flag == 1) {
				SingleLinkageAlgorithm singleLinkageAlgorithm = new SingleLinkageAlgorithm(samples, numOfSamples);
				singleLinkageAlgorithm.clustering();
			}
			else if(flag == 2) {
				CompleteLinkageAlgorithm completeLinkageAlgorithm = new CompleteLinkageAlgorithm(samples, numOfSamples);
				completeLinkageAlgorithm.clustering();
			}
			else if(flag == 3) {
				AverageLinkageAlgorithm averageLinkageAlgorithm = new AverageLinkageAlgorithm(samples, numOfSamples);
				averageLinkageAlgorithm.clustering();
			}
			else if(flag == 4) {
				WardMethod wardMethod = new WardMethod(samples, numOfSamples);
				wardMethod.clustering();
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}
