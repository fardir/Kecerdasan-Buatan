import java.util.*;
public class UninformCostSearch {
   public void uninformCostSearch(Node asal, Node tujuan) {
       List<Node> list = new ArrayList<>();
       asal.setCost(0);
       PriorityQueue<Node> queue = new PriorityQueue<Node>(23, new Comparator<Node>() {
           public int compare(Node i, Node j) {
               if (i.getCost() > j.getCost()) {
                   return 1;
               } else if (i.getCost() < j.getCost()) {
                   return -1;
               } else {
                   return 0;
               }
           }
       });
       queue.add(asal);
       Set<Node> explored = new HashSet<>();
       List<Node> path = new ArrayList<>();
       do {
           path.clear();
           Node current = queue.remove();
           explored.add(current);
           for (Node node = current; node != null; node = node.getParent()) {
               path.add(node);
           }
           if (current.getNama().equals(tujuan.getNama())) {
               tujuan.setParent(current.getParent());
               tujuan.setCost(current.getCost());
               break;
           }
           for (Edge e : current.getAdj()) {
               Node child = e.getKoneksi();
               int cost = e.getBerat();
               if ((!queue.contains(child) || !explored.contains(child)) && !path.contains(child)) {
                   Node n = new Node(child);
                   list.add(n);
                   list.get(list.size() - 1).setCost(current.getCost() + cost);
                   list.get(list.size() - 1).setParent(current);
                   queue.add(list.get(list.size() - 1));
               } else if (!path.contains(child)) {
                   child.setCost(current.getCost() + cost);
                   child.setParent(current);
                   queue.add(child);
                   System.out.println(child.printPath());
               }
           }
       } while (!queue.isEmpty());
   }

   public List<Node> printPath(Node target) {
       List<Node> path = new ArrayList<>();
       for (Node node = target; node != null; node = node.getParent()) {
           path.add(node);
       }
       Collections.reverse(path);
       return path;
   }

   public static void main(String[] args) {
       Scanner in = new Scanner(System.in);
       Node a = new Node("A");
       Node b = new Node("B");
       Node c = new Node("C");
       Node d = new Node("D");
       Node e = new Node("E");
       Node f = new Node("F");
       Node g = new Node("G");
       Node h = new Node("H");
       Node i = new Node("I");
       Node j = new Node("J");
       Node k = new Node("K");
       Node l = new Node("L");
       Node m = new Node("M");
       Node n = new Node("N");
       Node o = new Node("O");
       Node p = new Node("P");
       Node q = new Node("Q");
       Node r = new Node("R");
       Node s = new Node("S");
       Node t = new Node("T");
       Node u = new Node("U");
       Node v = new Node("V");
       Node w = new Node("W");
       Node x = new Node("X");
       a.setAdj(new Edge[]{
               new Edge(v, 167),
               new Edge(x, 55),
               new Edge(i, 148),
               new Edge(b, 145)
       });
       b.setAdj(new Edge[]{
               new Edge(a, 145),
               new Edge(c, 98)
       });
       c.setAdj(new Edge[]{
               new Edge(b, 98),
               new Edge(d, 212)
       });
       d.setAdj(new Edge[]{
               new Edge(c, 212),
               new Edge(k, 102),
               new Edge(e, 102)
       });
       e.setAdj(new Edge[]{
               new Edge(m, 73),
               new Edge(n, 97),
               new Edge(f, 152),
               new Edge(l, 95),
               new Edge(d, 102)
       });
       f.setAdj(new Edge[]{
               new Edge(e, 152),
               new Edge(g, 83)
       });
       g.setAdj(new Edge[]{
               new Edge(f, 83),
               new Edge(h, 75)
       });
       h.setAdj(new Edge[]{
               new Edge(g, 75)
       });
       i.setAdj(new Edge[]{
               new Edge(a, 148),
               new Edge(q, 25),
               new Edge(j, 75)
       });
       j.setAdj(new Edge[]{
               new Edge(i, 75),
               new Edge(k, 95)
       });
       k.setAdj(new Edge[]{
               new Edge(j, 95),
               new Edge(d, 102)
       });
       l.setAdj(new Edge[]{
               new Edge(e, 95)
       });
       m.setAdj(new Edge[]{
               new Edge(e, 73)
       });
       n.setAdj(new Edge[]{
               new Edge(e, 97),
               new Edge(p, 65),
               new Edge(o, 25)
       });
       o.setAdj(new Edge[]{
               new Edge(n, 25)
       });
       p.setAdj(new Edge[]{
               new Edge(n, 65)
       });
       q.setAdj(new Edge[]{
               new Edge(x, 30),
               new Edge(i, 25)
       });
       r.setAdj(new Edge[]{
               new Edge(s, 93),
               new Edge(x, 57)
       });
       s.setAdj(new Edge[]{
               new Edge(t, 112),
               new Edge(r, 93)
       });
       t.setAdj(new Edge[]{
               new Edge(u, 75),
               new Edge(v, 25),
               new Edge(s, 112)
       });
       u.setAdj(new Edge[]{
               new Edge(t, 75),
               new Edge(v, 85)
       });
       v.setAdj(new Edge[]{
               new Edge(u, 85),
               new Edge(t, 25),
               new Edge(a, 167)
       });
       w.setAdj(new Edge[]{
       });
       x.setAdj(new Edge[]{
               new Edge(r, 57),
               new Edge(a, 55),
               new Edge(q, 30)
       });

       //test case A ke D
       String a1 = "A";
       String t1 = "D";
       System.out.println("Asal : " + a1);
       System.out.println("Tujuan : " + t1);
       UninformCostSearch ucs1 = new UninformCostSearch();
       ucs1.uninformCostSearch(a, d);
       List<Node> pathAD = ucs1.printPath(d);
       System.out.printf("Path %s-%s : :" + pathAD + "\n\n", a1, t1);

       //test case H ke N
       String a2 = "H";
       String t2 = "N";
       System.out.println("Asal : " + a2);
       System.out.println("Tujuan : " + t2);
       UninformCostSearch ucs2 = new UninformCostSearch();
       ucs2.uninformCostSearch(h, n);
       List<Node> pathHN = ucs2.printPath(n);
       System.out.printf("Path %s-%s : :" + pathHN + "\n\n", a2, t2);

       //test case H ke U
       String a3 = "H";
       String t3 = "U";
       System.out.println("Asal : " + a3);
       System.out.println("Tujuan : " + t3);
       UninformCostSearch ucs3 = new UninformCostSearch();
       ucs3.uninformCostSearch(h, u);
       List<Node> pathHU = ucs3.printPath(u);
       System.out.printf("Path %s-%s : :" + pathHU + "\n\n", a3, t3);

       //test case O ke H
       String a4 = "O";
       String t4 = "H";
       System.out.println("Asal : " + a4);
       System.out.println("Tujuan : " + t4);
       UninformCostSearch ucs4 = new UninformCostSearch();
       ucs4.uninformCostSearch(o, h);
       List<Node> pathOH = ucs4.printPath(h);
       System.out.printf("Path %s-%s : :" + pathOH + "\n\n", a4, t4);

       //test case I ke A
       String a5 = "I";
       String t5 = "A";
       System.out.println("Asal : " + a5);
       System.out.println("Tujuan : " + t5);
       UninformCostSearch ucs5 = new UninformCostSearch();
       ucs5.uninformCostSearch(i, a);
       List<Node> pathIA = ucs5.printPath(a);
       System.out.printf("Path %s-%s : :" + pathIA + "\n", a5, t5);
   }
}
