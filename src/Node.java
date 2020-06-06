public class Node {
   final String NAMA;
   int cost;
   private Edge[] adj;
   private Node parent;

   public Node(String nama) {
       this.NAMA = nama;
   }

   public Node(Node node) {
       int i = 0;
       adj = new Edge[node.adj.length];
       this.NAMA = node.NAMA;
       this.cost = node.cost;
       for (Edge e : node.adj) {
           adj[i++] = e;
       }
       this.parent = node.parent;
   }

   public String printPath() {
       return NAMA;
   }

   public String toString() {
       return NAMA + " = " + cost + " ";
   }

   public String getNama() {
       return NAMA;
   }

   public int getCost() {
       return cost;
   }

   public void setCost(int cost) {
       this.cost = cost;
   }

   public Edge[] getAdj() {
       return adj;
   }

   public void setAdj(Edge[] adj) {
       this.adj = adj;
   }

   public Node getParent() {
       return parent;
   }

   public void setParent(Node parent) {
       this.parent = parent;
   }
}
