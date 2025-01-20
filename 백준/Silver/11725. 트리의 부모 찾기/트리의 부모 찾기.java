import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    
    static int N;
    static boolean[] visited;
    static ArrayList<Integer>[] tree;
    static int[] answer;
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        visited = new boolean[N + 1];
        tree = new ArrayList[N + 1];
        answer = new int[N + 1];
        
        for (int i = 0; i <= N; i++) { // 인덱스 0부터 N까지 초기화
            tree[i] = new ArrayList<>();
        }
        
        for (int i = 1; i < N; i++) { // N-1개의 간선 입력
            int n1 = sc.nextInt();
            int n2 = sc.nextInt();
            tree[n1].add(n2);
            tree[n2].add(n1);
        }
        
        dfs(1); // 1번 노드를 루트로 DFS 시작
        for (int i = 2; i <= N; i++) { // 2번 노드부터 부모 노드 출력
            System.out.println(answer[i]);
        }
    }
    
    static void dfs(int i) {
        visited[i] = true;
        for (int j : tree[i]) {
            if (!visited[j]) {
                answer[j] = i; // j의 부모 노드는 i
                dfs(j); // 다음 노드 j로 이동
            }
        }
    }
}