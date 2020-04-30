import java.util.LinkedList;
import java.util.TreeMap;
public class Graph {
	//No of nodes in the map
    int vertices;
    //Creating linked list to store roads between nodes
    LinkedList<Edge>[] adjacencylist;
    //Used to store all the possible paths between 
    static TreeMap<Integer,String> weight=new TreeMap<Integer,String>();
    LinkedList<Edge>[] temp=null;
    
    
    //Constructor to initialize
    @SuppressWarnings("unchecked")
	public Graph() 
    {
		super();
		vertices = 0;
		//Used to store all the defined routess
		adjacencylist = new LinkedList[vertices];
        //initialize adjacency lists for all the vertices
        for (int i = 0; i <vertices ; i++) {
        	//creating the linked list
            adjacencylist[i] = new LinkedList<>();
        }
	}//Graph

    /*
     * Function used to check whether current node is present 
     * input -int,int node coordinates
     * output - boolean
     * 
     * */
    public boolean presentContains(City city)
    {
 	boolean flag=false;
 	   try 
 	   {
 		   //pulling all the nodes present in the city
		for(City inCities:HalifaxMap.cities)
		   {
			//comparing all the coordinate values
			   if(inCities.x==city.x && inCities.y==city.y)
			   {
				   flag=true;
				   break;
			   }//if
		   }//for
 	   }//try
 	catch (Exception e) 
 	 {
 		flag=false;
	}//catch
 	return flag;
    }//present
    
    
    /*
     * Utility Function used to get the index of the stored node
     * 
     *  input - City node with coordinates
     * output -  int 
     * */
    
    public int presentIndex(City city)
    {
 	   int index=-1;
	try {
		//Pulling all the nodes in the city
		   for(City inCities:HalifaxMap.cities)
		   {
			   if(inCities.x==city.x && inCities.y==city.y)
			   {
				   index=HalifaxMap.cities.indexOf(inCities);
				   break;
			   }//if
		   }//for
	}//try
	catch (Exception e) 
	{
			index=-1;
	}//catch
 	return index;
    }//presentIndex
    
    
    /*
     * Adding the road between given nodes
     * input - City nodes of source and destination
     * output- boolean
     * */
	@SuppressWarnings("unchecked")
	public boolean addEdge(City source, City destination, int sourceIndex, int destinationIndex) 
	{
		boolean flag=false;
		try {
			//no of nodes in the city
			int citiesSize=HalifaxMap.cities.size();
			//getting the old size of routes
			int oldSize=adjacencylist.length;
			
			//checking the capacity of matrix and increasing its size
			if(citiesSize>adjacencylist.length)
			{
				temp=new LinkedList[citiesSize];
				for (int i = 0; i < adjacencylist.length; i++) 
				{ 
			        // copy all array value into temp 
			        temp[i] = adjacencylist[i]; 
			    }//for
				adjacencylist=temp;
				vertices=citiesSize;
				 for (int i =oldSize ;i <vertices ; i++) 
				 {
			            adjacencylist[i] = new LinkedList<>();
			      }//for
				temp=null;
			}//if
			
			//Checking if the defined road is already present or create the new one
			for(int i=0;i<adjacencylist.length;i++)
			{
				//Linked list of path
				LinkedList<Edge> edge=adjacencylist[i];
				//checking the coordinates of the nodes
				for(int j=0;j<edge.size();j++)
				{
					Edge alreadyPresent=edge.get(j);
					if(alreadyPresent.source.x==source.x&&alreadyPresent.source.y==source.y
							&&alreadyPresent.destination.x==destination.x&&alreadyPresent.destination.y==destination.y
							||
							alreadyPresent.destination.x==source.x&&alreadyPresent.destination.y==source.y
							&&alreadyPresent.source.x==destination.x&&alreadyPresent.source.y==destination.y)
					{
					return false;	
					}//if
				}//if
			}//for
			//Calculating the distance between the given nodes
			double distance=Math.pow((destination.x-source.x),2)+Math.pow((destination.y-source.y),2);
			int weight=(int) Math.sqrt(distance);
			Edge edge = new Edge(source, destination,weight);
			//creating the path between nodes
			adjacencylist[sourceIndex].addFirst(edge);
			edge = new Edge(destination, source,weight);
			adjacencylist[destinationIndex].addFirst(edge); //for undirected graph
			flag=true;
		}//try
		catch (Exception e) 
		{
			flag= false;
		}//catch
		return flag;
    }//addEdge

   
	
	/*
	 * Function used to print the shortest path between two given nodes if they have connection
	 * input- Map,int source, int destination
	 * */
    public void printAllPaths(Graph graph, int start, int end)
    {
        try 
        {
        	//Creating falg matrix for processing of visited nodes
			boolean[] visited = new boolean[graph.vertices];
			visited[start] = true;
			int edgeWeight=0;
			print(graph, start, end, "", visited,edgeWeight);
			//printing the shortest path
			System.out.print(weight.get(weight.firstKey()).trim());
			System.out.println();
		}//try 
        catch (Exception e) {
			System.out.println("no path");
		}//catch
   
    }//printAllPaths
    
    
    
    
    /*
     * Function used to print the path in the map
     * input - Map,int int, boolean, distance
     * output- void print
     * */
    public void print(Graph graph, int start, int end, String path, boolean[] visited,int sourceEdgeWeight)
    {
    	try 
    	{
			City cityStart=HalifaxMap.cities.get(start);
			String newPath = path +  "\n" +cityStart.x+"\t"+cityStart.y+"";
			visited[start] = true;
			LinkedList<Edge> list = graph.adjacencylist[start];
			for (int i = 0; i <list.size() ; i++) 
			{
				Edge node = list.get(i);
				int edgeWeight = sourceEdgeWeight;
			    if(presentIndex(node.destination)!=end && visited[presentIndex(node.destination)]==false){
			    	edgeWeight=edgeWeight+node.weight;
			        print(graph,presentIndex(node.destination),end,newPath,visited,edgeWeight);
			    }//if
			    else if(presentIndex(node.destination)==end)
			    {
			    	City destination=HalifaxMap.cities.get(presentIndex(node.destination));
			        weight.put(edgeWeight+node.weight, newPath+ "\n" +destination.x+"\t"+destination.y+"");
			    }//else if
			}//for
			visited[start] = false;
		}//try
    	catch (Exception e) 
    	{
			System.out.println("no path");
		}//catch
    }//print
  
}
