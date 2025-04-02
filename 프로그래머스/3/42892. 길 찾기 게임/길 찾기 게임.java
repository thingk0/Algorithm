import java.util.Arrays;
import java.util.ArrayList;

class Solution {

    private static class Node {
        int x, y, num;
        Node left, right;

        public Node(int num, int x, int y) {
            this.num = num;
            this.x = x;
            this.y = y;
        }
    }

    // 노드를 트리에 삽입하는 도우미 메서드
    private static void insertNode(Node parent, Node child) {
        if (child.x < parent.x) { // 왼쪽 서브트리로 가야 함
            if (parent.left == null) {
                parent.left = child;
            } else {
                insertNode(parent.left, child);
            }
        } else { // 오른쪽 서브트리로 가야 함
            if (parent.right == null) {
                parent.right = child;
            } else {
                insertNode(parent.right, child);
            }
        }
    }

    private static Node makeBT(int[][] nodeinfo) {
        Node[] nodes = new Node[nodeinfo.length];
        for (int i = 0; i < nodeinfo.length; i++) {
            nodes[i] = new Node(i + 1, nodeinfo[i][0], nodeinfo[i][1]);
        }

        // Y 좌표 내림차순, Y 같으면 X 좌표 오름차순으로 정렬
        Arrays.sort(nodes, (o1, o2) -> {
            if (o1.y == o2.y) {
                return Integer.compare(o1.x, o2.x); // X 오름차순
            }
            return Integer.compare(o2.y, o1.y); // Y 내림차순 (o2.y 와 o1.y 비교)
        });

        Node root = nodes[0]; // 정렬 후 첫 번째 노드가 루트

        // 나머지 노드들을 트리에 삽입
        for (int i = 1; i < nodes.length; i++) {
            insertNode(root, nodes[i]);
        }

        return root; // 루트 노드 반환
    }

    private static void preOrder(Node curr, ArrayList<Integer> answer) {
        if (curr == null) {
            return;
        }

        answer.add(curr.num);
        preOrder(curr.left, answer);
        preOrder(curr.right, answer);
    }

    private static void postOrder(Node curr, ArrayList<Integer> answer) {
        if (curr == null) {
            return;
        }

        postOrder(curr.left, answer);
        postOrder(curr.right, answer);
        answer.add(curr.num);
    }

    public int[][] solution(int[][] nodeinfo) {
        Node root = makeBT(nodeinfo);
        ArrayList<Integer> preOrderList = new ArrayList<>();
        preOrder(root, preOrderList);
        ArrayList<Integer> postOrderList = new ArrayList<>();
        postOrder(root, postOrderList);

        int[][] answer = new int[2][nodeinfo.length];
        answer[0] = preOrderList.stream().mapToInt(Integer::intValue).toArray();
        answer[1] = postOrderList.stream().mapToInt(Integer::intValue).toArray();
        return answer;
    }
}