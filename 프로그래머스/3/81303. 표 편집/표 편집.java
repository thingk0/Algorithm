import java.util.Arrays;
import java.util.ArrayDeque;

class Node {
    int index;
    Node prev;
    Node next;

    public Node(int index) {
        this.index = index;
    }
}

class Solution {
    public String solution(int n, int k, String[] cmd) {
        // 노드 생성 및 초기 연결 설정
        Node[] nodes = new Node[n];
        for (int i = 0; i < n; i++) {
            nodes[i] = new Node(i);
        }
        for (int i = 0; i < n; i++) {
            if (i > 0) nodes[i].prev = nodes[i - 1];
            if (i < n - 1) nodes[i].next = nodes[i + 1];
        }
        
        // 현재 선택 노드 설정
        Node current = nodes[k];
        // 삭제된 노드를 추적하는 스택
        ArrayDeque<Node> deleted = new ArrayDeque<>();

        for (String command : cmd) {
            char op = command.charAt(0);
            if (op == 'U' || op == 'D') {
                String[] parts = command.split(" ");
                int move = Integer.parseInt(parts[1]);
                for (int i = 0; i < move; i++) {
                    current = (op == 'U') ? current.prev : current.next;
                }
            } else if (op == 'C') {
                // 현재 노드 삭제
                deleted.push(current);
                Node prev = current.prev;
                Node next = current.next;
                
                if (prev != null) prev.next = next;
                if (next != null) next.prev = prev;
                
                // 다음 선택할 노드: 다음 노드가 있으면 그걸, 없으면 이전 노드
                current = (next != null) ? next : prev;
            } else if (op == 'Z') {
                // 최근 삭제된 노드 복구
                Node node = deleted.pop();
                if (node.prev != null) node.prev.next = node;
                if (node.next != null) node.next.prev = node;
            }
        }
        
        // 결과 문자열 생성
        char[] result = new char[n];
        Arrays.fill(result, 'O');
        while (!deleted.isEmpty()) {
            Node node = deleted.pop();
            result[node.index] = 'X';
        }
        
        return new String(result);
    }
}