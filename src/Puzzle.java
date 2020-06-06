import java.util.*;
import java.util.stream.IntStream;

class Node {

    int[][] position;
    int gn, fn;
    Node parent;

    Node(int[][] pos) {
        this.position = pos;
    }

    int h(Node goal) {
        //jumlah angka yang salah posisi(manhattan distance)
        int hn = 0;
        for (int a = 0; a < 9; a++) {
            int i1 = -1, j1 = -1, i2 = -1, j2 = -1;
            for (int b = 0; b < 3; b++)
                for (int c = 0; c < 3; c++) {
                    if (this.position[b][c] == a) {
                        i1 = b;
                        j1 = c;
                    }
                    if (goal.position[b][c] == a) {
                        i2 = b;
                        j2 = c;
                    }
                }
            hn += Math.abs(i1 - i2) + Math.abs(j1 - j2);
        }
        return hn;
    }

    int f(Node goal) {
        return this.gn + h(goal);
    }

    void move(int x1, int y1, int x2, int y2) {
        this.position[x1][y1] = this.position[x2][y2];
        this.position[x2][y2] = 0;
    }

    void setParent(Node parent) {
        this.parent = parent;
    }

    boolean isSameState(int[][] A, int[][] B) {
        boolean hasil = true;
        for (int i = 0; i < 3; i++) for (int j = 0; j < 3; j++)
            if (A[i][j] != B[i][j]) {
                hasil = false;
                break;
            }
        return hasil;
    }

    int[][] copyState() {
        int[][] copy = new int[3][3];
        IntStream.range(0, 3).forEach(i -> System.arraycopy(this.position[i], 0, copy[i], 0, 3));
        return copy;
    }
}

class Search {

    ArrayList<Node> generateChild(Node curr) {
        ArrayList<Node> childs = new ArrayList<>();
        for (int i = 0; i < 3; i++)
            for (int j = 0; j < 3; j++)
                if (curr.position[i][j] == 0) {
                    if (j + 1 < 3) {
                        int[][] state = curr.copyState();
                        Node b = new Node(state);
                        b.move(i, j, i, j + 1);
                        childs.add(b);
                    }
                    if (j - 1 > -1) {
                        int[][] state = curr.copyState();
                        Node c = new Node(state);
                        c.move(i, j, i, j - 1);
                        childs.add(c);
                    }
                    if (i + 1 < 3) {
                        int[][] state = curr.copyState();
                        Node d = new Node(state);
                        d.move(i, j, i + 1, j);
                        childs.add(d);
                    }
                    if (i - 1 > -1) {
                        int[][] state = curr.copyState();
                        Node e = new Node(state);
                        e.move(i, j, i - 1, j);
                        childs.add(e);
                    }
                    break;
                }
        return childs;
    }

    ArrayList<Node> aStarFinding(Node init, Node goal) {
        ArrayList<Node> path = new ArrayList<>();
        ArrayList<Node> explored = new ArrayList<>();
        ArrayList<Node> initial = new ArrayList<>();
        ArrayList<Node> end = new ArrayList<>();
        init.h(goal);
        initial.add(init);
        System.out.println("Pilih Jalur:");
        do {
            int fn = Integer.MAX_VALUE;
            Node temp = init;
            for (Node n : initial) {
                if (n.fn < fn) {
                    fn = n.fn;
                    temp = n;
                }
            }
            System.out.println("\n\nNode yang terpilih :");
            printState(temp.position);
            initial.remove(temp);
            end.add(temp);

            if (temp.isSameState(temp.position, goal.position)) {
                Node current = temp;
                do {
                    path.add(current);
                    current = current.parent;
                } while (current != init && current != null);
                path.add(current);
                break;
            }

            boolean cek = true;
            for (Node n : explored) if (n.isSameState(temp.position, n.position)) cek = false;
            if (cek) explored.add(temp);
            ArrayList<Node> childs = generateChild(temp);
            System.out.println("\n\nNode child :");
            for (Node n : childs) {
                n.setParent(temp);
                System.out.println();
                printState(n.position);
                if (end.contains(n)) continue;
                n.gn = temp.gn + 1;
                n.fn = n.f(goal);
                if (initial.contains(n)) continue;
                initial.add(n);
            }
        } while (!initial.isEmpty());
        return path;
    }

    public void printState(int[][] position) {
        for (int i = 0; i < 3; i++) {
            System.out.print("\n|");
            for (int j = 0; j < 3; j++) {
                String str = (position[i][j] != 0) ? Integer.toString(position[i][j]) : " ";
                System.out.print(str + "|");
            }
        }
    }

    void printPath(Node init, Node goal) {
        ArrayList<Node> path = aStarFinding(init, goal);
        Collections.reverse(path);
        System.out.println("\n\nPath yang ditemukan");
        path.forEach(n -> {
            printState(n.position);
            System.out.println();
        });
        System.out.println("finish");
    }
}

public class Puzzle {

    public static void main(String[] args) {
        // 0 MERUPAKAN TANDA TIDAK ADA ANGKA DI TILE TERSEBUT
        int[][] init = {{2, 4, 3}, {1, 5, 6}, {7, 0, 8}};
        int[][] goal = {{1, 2, 3}, {4, 5, 6}, {7, 8, 0}};
        
        Node Initial = new Node(init);
        Node Goal = new Node(goal);
        Search find = new Search();
        find.printPath(Initial, Goal);
    }
}
