interface Graph {
    public int V();
    public int E();
    public void addEdge(int v, int w);
    public Iterable<Integer> adj(int v);
    //public boolean hasEdge(int v, int w);
}

public class GraphList implements Graph {
    private final int V;
    private int E;
    private Bag<Integer>[] adj;
    private String[] vertices;
    private int size;
    public GraphList(int V) {
        this.V = V;
        this.E = 0;
        vertices = new String[V];
        // System.out.println(V);
        size = 0;
        adj = (Bag<Integer>[]) new Bag[V];
        for (int v = 0; v < V; v++) {
            adj[v] = new Bag<Integer>();
        }
    }
    public int V() {
        return V;
    }
    public int E() {
        return E;
    }
    public void addVertex(String v) {
        vertices[size] = v;
        size++;
    }
    public void addEdge(int v, int w) {
        if (v == w) {
            System.out.println(V + " vertices, " + E + " edges");
            System.out.println("No edges");
            return;
        }
        E++;
        adj[v].add(w);
        adj[w].add(v);
    }
    public Iterable<Integer> adj(int v) {
        return adj[v];
    }

    public int degree(int v) {
        return adj[v].size();
    }
    public String toString() {
        String s = "";
        s += V + " vertices, " + E + " edges" + '\n';
        for (int v = 0; v < V; v++) {
            s += vertices[v] + ": ";
            for (int w : adj[v]) {
                s += vertices[w] + " ";
            }
            s += '\n';
        }
        return s;
    }
}