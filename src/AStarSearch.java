//import java.util.*;
//public class AStarSearch {
//
//    public static List<NodeA> printPath(NodeA target) {
//        List<NodeA> path = new ArrayList<>();
//        for (NodeA node = target; node != null; node = node.parent) {
//            path.add(node);
//        }
//        Collections.reverse(path);
//        return path;
//    }
//
//    public static void AStarSearch(NodeA source, NodeA goal) {
//        Set<NodeA> explored = new HashSet<>();
//        PriorityQueue<NodeA> queue = new PriorityQueue<>(20,
//                new Comparator<NodeA>() {
//                    @Override
//                    public int compare(NodeA i, NodeA j) {
//                        if (i.fn > j.fn) {
//                            return 1;
//                        } else if (i.fn < j.fn) {
//                            return -1;
//                        } else {
//                            return 0;
//                        }
//                    }
//                });
//        source.gn = 0;
//        queue.add(source);
//        boolean found = false;
//        while ((!queue.isEmpty()) && (!found)) {
//            NodeA current = queue.poll();
//            explored.add(current);
//            if (current.value.equals(goal.value)) {
//                found = true;
//            }
//            for (EdgeA e : current.tujuan) {
//                NodeA child = e.target;
//                double cost = e.cost;
//                double temp_gn = current.gn + cost;
//                double temp_fn = temp_gn + child.hn;
//                if ((explored.contains(child)) && (temp_fn >= child.fn)) {
//                    continue;
//                } else if ((!queue.contains(child)) || (temp_fn < child.fn)) {
//                    child.parent = current;
//                    child.gn = temp_gn;
//                    child.fn = temp_fn;
//                    if (queue.contains(child)) {
//                        queue.remove(child);
//                    }
//                    queue.add(child);
//                }
//            }
//        }
//    }
//
//    public static void main(String[] args) {
//        NodeA A = new NodeA("A", 140);
//        NodeA B = new NodeA("B", 30);
//        NodeA C = new NodeA("C", 29);
//        NodeA D = new NodeA("D", 0);
//        NodeA E = new NodeA("E", 50);
//        NodeA F = new NodeA("F", 35);
//        NodeA G = new NodeA("G", 100);
//        A.tujuan = new EdgeA[]{
//                new EdgeA(B, 30),
//                new EdgeA(G, 40),
//                new EdgeA(F, 80)
//        };
//        B.tujuan = new EdgeA[]{
//                new EdgeA(A, 30),
//                new EdgeA(C, 143),
//                new EdgeA(D, 100),
//                new EdgeA(G, 65)
//        };
//        C.tujuan = new EdgeA[]{
//                new EdgeA(B, 143),
//                new EdgeA(D, 90)
//        };
//        D.tujuan = new EdgeA[]{
//                new EdgeA(B, 100),
//                new EdgeA(C, 90),
//                new EdgeA(E, 85),
//                new EdgeA(F, 120)
//        };
//        E.tujuan = new EdgeA[]{
//                new EdgeA(D, 85),
//                new EdgeA(F, 200)
//        };
//        F.tujuan = new EdgeA[]{
//                new EdgeA(A, 80),
//                new EdgeA(D, 120),
//                new EdgeA(E, 200),
//                new EdgeA(G, 30)
//        };
//        G.tujuan = new EdgeA[]{
//                new EdgeA(A, 40),
//                new EdgeA(B, 65),
//                new EdgeA(F, 30)
//        };
//        AStarSearch a = new AStarSearch();
//        a.AStarSearch(A, D);
//        List<NodeA> path = a.printPath(D);
//        System.out.println("Path: " + path);
//    }
//}