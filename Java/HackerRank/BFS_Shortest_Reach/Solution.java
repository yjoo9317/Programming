import java.io.*;

public class Solution {
    public static Scanner scan;
    public static int q, n, m, s;
    public static int [][] map;
    public static int [] d;
    public static Node[] graphs;
    public static Queue<Integer> queue;
    
    
    private static void initDistance()
    {
    	for(int i= 0; i < graphs.length; i++){
    		Node temp = graphs[i];
    		if(temp != null) temp.dist = 0;
    	}
    }
    private static int getMinDist(Node target,Node start){
    	if(target == null || start == null){
    		return -1;
    	}
		if(d[target.id] > 0) return d[target.id];
		
    	Queue<Node> order = new LinkedList<Node>();
    	boolean[] visited = new boolean[n];
    	order.offer(start);
    	int base = 6;
    	while(!order.isEmpty()){
    		Node temp = order.poll();
    		if(visited[temp.id]) continue;
    		
    		if(temp.id == target.id){
    			return d[target.id] = temp.dist;
    		}
    		visited[temp.id] = true;
    		List<Node> list = temp.getConnectedNodes();
    		if(!list.isEmpty()){
	    		for(Node n : list){
	    			if(!visited[n.id] && !order.contains(n)){
	    				n.dist = temp.dist + base;
	    				d[n.id] = n.dist;
	    			}
	    		}
	    		order.addAll(list);
    		}
    	}
    	return -1;
    }
    
    public static void main(String[] args) throws Exception{
        // TODO Auto-generated method stub
        //System.setIn(new FileInputStream("d://input.txt"));
    	scan = new Scanner(System.in);
    	q = scan.nextInt();
    	while(q > 0){
        	n = scan.nextInt();
        	m = scan.nextInt();
        	d = new int[n+1];
        	graphs = new Node[n];
        	for(int i = 0; i < m; i++){
        		int x = scan.nextInt();
        		x -= 1; // starts with 0 index
        		Node xNode = graphs[x];
        		if(xNode == null){
        			xNode = new Node(x);
        		}
        		graphs[x] = xNode;
        		int y = scan.nextInt();
        		y -= 1;
        		Node yNode = graphs[y];
        		if(yNode == null){
        			yNode = new Node(y);
        		}
        		graphs[y] = yNode;
        		
        		xNode.addNode(yNode);
        		yNode.addNode(xNode);
        	}
        	s = scan.nextInt();
        	s -= 1;
        	for(int j = 0; j < graphs.length; j++){
        		if(j != s){
        			//int distance = getDistance(graphs[j], graphs[s]);
        			int distance = getMinDist(graphs[j], graphs[s]);
        			System.out.print(distance+ " ");
        			initDistance();
        		}
        	}
        	System.out.println();
	    	q--;
    	}
    	scan.close();
    }
    
    private static class Node {
    	private List<Node> nodes;
    	private int id;
    	private int dist;
    	public Node(int id){
    		this.id = id;
    		dist = 0;
    		nodes = new LinkedList<Node>();
    	}
    	public void addNode(Node node){
    		nodes.add(node);
    	}
    	
    	public List<Node> getConnectedNodes(){
    		return nodes;
    	}
    }
}
