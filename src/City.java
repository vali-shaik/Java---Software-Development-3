
public class City {
	
	
	City(int x,int y)
	{
		this.x=x;
		this.y=y;
	}
	
	//coordinates
	int x,y;

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	@Override
	public String toString() {
		return "City [x=" + x + ", y=" + y + "]";
	}
	

}
