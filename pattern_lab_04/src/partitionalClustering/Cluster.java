package partitionalClustering;
public class Cluster {

	Sample[] clusterElements;
	Sample centroid;
	int count;
	public Cluster(int numOfElements) {
		clusterElements = new Sample[numOfElements];
		centroid = new Sample(-1, -1);
		for (int i = 0; i < numOfElements; i++) {
			clusterElements[i] = new Sample(-1, -1);
		}
		count = 0;
	}
	public void setCentroid (Sample centroid) {
		this.centroid = centroid;
	}
	public Sample getCentroid() {
		return this.centroid;
	}
	public int getLength() {
		return count;
	}
	public Sample getElementsAt (int index) {
		return this.clusterElements[index];
	}
	public void add(Sample otherCluster) {
		this.clusterElements[count] = otherCluster;
		count++;
	}
	public void clear() {
		count = 0;
	}
	public void printCluster() {
		System.out.print("( "+this.centroid.getX()+", "+this.centroid.getY()+" )-  ");
		for (int i = 0; i < count; i++) {
			System.out.print("( "+clusterElements[i].getX()+", "+clusterElements[i].getY()+" )");
		}
		System.out.println();
	}
}
