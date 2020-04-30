public class Edge {
	City source,destination;
    int weight;

    public Edge(City source, City destination, int weight) {
        this.source = source;
        this.destination = destination;
        this.weight = weight;
    }

	public City getSource() {
		return source;
	}

	public void setSource(City source) {
		this.source = source;
	}

	public City getDestination() {
		return destination;
	}

	public void setDestination(City destination) {
		this.destination = destination;
	}

	public int getWeight() {
		return weight;
	}

	public void setWeight(int weight) {
		this.weight = weight;
	}

	@Override
	public String toString() {
		return "Edge [source=" + source + ", destination=" + destination + ", weight=" + weight + "]";
	}

    
}
