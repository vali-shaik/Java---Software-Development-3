import java.util.ArrayList;
/*Halifax Map class contains the different city nodes and path between all cities using 
 * navigate
 * adding new city
 * defining new path between nodes
*/
public class HalifaxMap 
{
	//Contains all nodes of the Map
	static ArrayList<City> cities;
	//Route between two cities
	static Edge edge; 
	//Map of the Halifax
	static  Graph  graph;

	//Constructor
    public HalifaxMap()
    {
	   cities=new ArrayList<City>();
	   graph = new Graph();
    }
    
   //Checks whether node address is already defined
    /*
     * input - City type with coordinates
     * output - boolean
     * */
   public boolean presentContains(City city)
   {
	boolean flag=false;
			try 
			{
				//checking if there are nodes in a City
				if(cities!=null)
				{
				//pulling all all nodes in the city for checking if it is already present
				for(City inCities:cities)
				   {
						//checking the coordinates for all nodes
					   if(inCities.x==city.x && inCities.y==city.y)
					   {
						   //checking the cordinate values, if it matche then return false as it i present 
						   flag=true;
						   break;
					   }//if
				   }//for
				}//if
			}
			catch (Exception e) 
			{
				flag=false;
			}//catch
	return flag;
   }//present
   
   
 //Utility function to return the index of the Node for processing
/*
 * input - City
 * output - Integer
 * */   
   public int presentIndex(City city)
   {
	   int index=-1;
	try 
	{
		//pulling all the nodes
		   for(City inCities:cities)
		   {
			   //checking the coordinate values
			   if(inCities.x==city.x && inCities.y==city.y)
			   {
				   index=cities.indexOf(inCities);
				   break;
			   }//if
		   }//for
	} 
	catch (Exception e) 
	{
		index=-1;
	}
	   
	return index;
   }//presentIndex
   
	
   /*Funciton used to create a node within a city
    * 
    * Input- coordinates of type int
    * output - boolean
    * */
   boolean newIntersection(int x,int y)
	{
		boolean flag=false;
		try
		{
			//creating a new node and adding it to the city
					City city=new City(x, y);
					if(cities!=null)
					{
								if(cities.size()==0)
									{
										cities.add(new City(x,y));
										flag=true;
									}//if
									else
									{
										if(!presentContains(city))
										{
											cities.add(new City(x,y));
											flag=true;
										}
									}//else
					
					}//if
					
		}//try
		catch(Exception e)
		{
			flag=false;
		}
		return flag;
	}//new Intersection
	
   
  /*
   * Funciton used to define the path between two nodes
   * input- nodes with coordinates
   * output - boolean
   * */
	boolean defineRoad(int x1,int y1,int x2,int y2)
	{
		boolean flag=false;
				try 
				{
					if(x1==x2&&y1==y2)
					{
						flag=false;
					}//if
					else
					{
						City source=new City(x1,y1);
						City destination=new City(x2,y2);
						//checking the nodes whether already present
							if(presentContains(source)&&presentContains(destination))
							{
								//getting the index location of source nodes
								 int sourceIndex=presentIndex(source);
								//getting the index location of destination nodes
							     int destinationIndex=presentIndex(destination);
							     //adding the path between nodes
							     if(graph.addEdge(source, destination,sourceIndex,destinationIndex)==true)
							     {
							    	 flag=true;
							     }//if
							 }//if
							else
							{
								flag=false;
							}//else
					}
				}//try
				catch (Exception e) {
					// TODO Auto-generated catch block
					flag=false;
				}//catch
		return flag;
	}//defineRoad
	
	
	
	/*
	 * Function used to display the shortest path between two nodes within map having a route
	 * 
	 *  input - int coordinates
	 *  output - void
	 * */
	void navigate(int x1,int y1,int x2,int y2)
	{
		try 
		{
			if(x1==x2&&y1==y2)
			{
				System.out.println("no path");
			}//if
			else
			{
					City source=new City(x1,y1);
					City destination=new City(x2,y2);
					//checking if the given source and destination is present
					if(presentContains(source)&&presentContains(destination))
					{
						int sourceIndex=presentIndex(source);
						int destinationIndex=presentIndex(destination);
						//printing the route 
						graph.printAllPaths(graph,sourceIndex,destinationIndex);
					}//if
					else
					{
						System.out.println("no path");
					}//else
			}//else
		}//true
		catch (Exception e) 
		{
			System.out.println("no path");
		}//catch
		
	}//navigate
	
	
	
	public static void main(String args[])
	{
		
		HalifaxMap hMap=new HalifaxMap();
		graph = new Graph();
		hMap.newIntersection(5, -4);//0
		hMap.newIntersection(-14, 6);//1
		hMap.newIntersection(3, 1);//2
		hMap.newIntersection(7, 9);//3
		hMap.newIntersection(6, 4);//4
		hMap.defineRoad(5, -4, -14,6);//0 1
		hMap.newIntersection(89, 90);//0
		hMap.navigate(5,-4,-14,6);
	
	}
	
	
	
}
