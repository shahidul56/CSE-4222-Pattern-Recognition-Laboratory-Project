package partitionalClustering;
public class KmeansAlgorithm {

	Sample[] samples;
	int numOfSamples;
	public KmeansAlgorithm(Sample[] samples, int numOfSamples)
	{
		this.samples = samples;
		this.numOfSamples = numOfSamples;
	}
	public void clustering(int k) {
		Cluster[] clusters = new Cluster[k];
		for (int i = 0; i < k; i++) {
			clusters[i] = new Cluster(numOfSamples);
			clusters[i].setCentroid(new Sample(samples[i].getX(), samples[i].getY()));
		}
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
			double sumX = 0;
			double sumY = 0;
			for (int j = 0; j < clusters[index].getLength(); j++) {
				Sample temp = clusters[index].getElementsAt(j);
				sumX += temp.getX();
				sumY += temp.getY();
			}
			double meanX = sumX/clusters[index].getLength();
			double meanY = sumY/clusters[index].getLength();
			clusters[index].setCentroid(new Sample(meanX, meanY));
		}
		for (int i = 0; i < k; i++) {
			clusters[i].printCluster();
			clusters[i].clear();
		}
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
			clusters[i].printCluster();
		}
	}
}
