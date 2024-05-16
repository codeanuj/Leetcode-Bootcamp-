class Solution {
    // Function to return Breadth First Traversal of given graph.
    public ArrayList<Integer> bfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj) {
        // Code here
        ArrayList<Integer> answer = new ArrayList<Integer>();
        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[V];
        
        queue.add(0);
        
        while(!queue.isEmpty()){
            
            int curr_vertex = queue.remove();
            
            if(visited[curr_vertex]) continue;
            
            answer.add(curr_vertex);
            visited[curr_vertex] = true;
            
            ArrayList<Integer> neighbour = adj.get(curr_vertex);
            
            for(int curr_neighbour : neighbour){
                queue.add(curr_neighbour);
            }
        }
        return answer;
    }
}
