package partitionalClustering;
public class ForgyAlgorithm {

	Sample[] samples;
	int numOfSamples;
	public ForgyAlgorithm(Sample[] samples, int numOfSamples)
	{
		this.samples = samples;
		this.numOfSamples = numOfSamples;
	}
	public void clustering(int k) {
		Cluster[] clusters = new Cluster[k];
		double[] oldCentroidX = new double[k];
		double[] oldCentroidY = new double[k];
		for (int i = 0; i < k; i++) {
			clusters[i] = new Cluster(numOfSamples);
			clusters[i].setCentroid(new Sample(samples[i].getX(), samples[i].getY()));
			oldCentroidX[i] = clusters[i].getCentroid().getX();
			oldCentroidY[i] = clusters[i].getCentroid().getY();
		}
		
		while(true) {
			for (int i = 0; i < numOfSamples; i++) {
				int index = -1;
				double minDistance = 999999.0;
				for (int j = 0; j < k; j++) {
					double distance = Math.sqrt(Math.pow((samples[i].getX() - clusters[j].getCentroid().getX()), 2) + Math.pow((samples[i].getY() - clusters[j].getCentroid().getY()), 2));
					if (distance < minDistance) {
						minDistance = distance;
						index = j;
					}
				}
				clusters[index].add(samples[i]);
			}
			for (int i = 0; i < k; i++) {
				oldCentroidX[i] = clusters[i].getCentroid().getX();
				oldCentroidY[i] = clusters[i].getCentroid().getY();
				clusters[i].printCluster();
			}
			int flag2 = 0;
			for (int i = 0; i < k; i++) {
				double sumX = 0;
				double sumY = 0;
				for (int j = 0; j < clusters[i].getLength(); j++) {
					Sample temp = clusters[i].getElementsAt(j);
					sumX += temp.getX();
					sumY += temp.getY();
				}
				double meanX = sumX/clusters[i].getLength();
				double meanY = sumY/clusters[i].getLength();
				clusters[i].setCentroid(new Sample(meanX, meanY));
				if (oldCentroidX[i] == clusters[i].getCentroid().getX() && oldCentroidY[i] == clusters[i].getCentroid().getY()) {
					flag2++;
				}
			}
			if (flag2 == k)
			{
				break;
			}
			for (int i = 0; i < k; i++) {
				clusters[i].clear();
			}
		}
	}
}
