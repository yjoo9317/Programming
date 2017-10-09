import java.util.*;
public class Solution {
    private static final String NEIGH = "neigh";
    private static int lastIndex;
    private static ArrayList<Node> list = new ArrayList<>();

    public static int numHorse(String A){
        int len = A.length();
        lastIndex = NEIGH.length()-1;
        for(int i = len-1; i >= 0 ; i--){
            char c = A.charAt(i);
            if( c == NEIGH.charAt(lastIndex)){
                Node node = findNode(c);
                if(node == null && list.size() > 0 ){
                    node = getFullNode();
                }
                if(node == null) {
                    node = new Node();
                    list.add(node);
                }
                node.add(c);
            } else {
                Node node = findNode(c);
                if(node == null)
                    return -1;
                node.add(c);
            }
        }
        if(isDone())
            return list.size();
        else return -1;
    }

    private static Node getFullNode(){
        for(Node node : list){
            if(node.isFull())
                return node;
        }
        return null;
    }
    private static Node findNode(char c){
        int n = list.size();
        for(int i = n-1; i >= 0; i--){
            Node node = list.get(i);
            if(node.nextChar == c){
                return node;
            }
        }
        return null;
    }
    private static boolean isDone(){
        for(Node node : list){
            if(!node.isFull())
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
    	// write your code here
        Scanner scan = new Scanner(System.in);
        //ArrayList<Integer> list = new ArrayList<Integer>();
        //list.add(1); list.add(2); list.add(3);
        System.out.println("n : "+numHorse("neigneighhneineighgh"));
        scan.close();
    }

    private static class Node {
        public Stack<Character> list;
        public char nextChar;
        public int count = NEIGH.length();

        public Node(){
            list = new Stack<>();
            nextChar = 'h';
        }

        public void add(char c){
            if(isFull()){
                nextChar = 'h';
                count = NEIGH.length();
            }
            list.add(c);
            System.out.println("add "+c);
            count --;
            if(count > 0){
                nextChar = NEIGH.charAt(count-1);
            } else nextChar = '*';
            System.out.println("next "+nextChar);
        }

        public boolean isFull(){
            if(count == 0) return true;
            return false;
        }
    }
}
