class Solution {
    // Function to return a list containing the DFS traversal of the graph.
    public ArrayList<Integer> dfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj) {
        // Code here
        ArrayList<Integer> answer = new ArrayList<Integer>();
        dfsOfGraph(0, adj, new boolean[V], answer);
        return answer;
    }
    
    private void dfsOfGraph(int curr_vertex, ArrayList<ArrayList<Integer>> adj, boolean[] visited, ArrayList<Integer> answer){
        if(visited[curr_vertex]) return;
        
        visited[curr_vertex] = true;
        answer.add(curr_vertex);
        
        ArrayList<Integer> neighbour = adj.get(curr_vertex);
        
        for(int curr_neighbour : neighbour){
            dfsOfGraph(curr_neighbour, adj, visited, answer);
        }
        
        return;
    }
}
