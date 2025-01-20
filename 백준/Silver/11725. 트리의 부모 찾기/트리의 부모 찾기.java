import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    
    static int N;
    static int[] answer;
    static ArrayList<Integer>[] tree;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        N = Integer.parseInt(br.readLine());
        
        tree = new ArrayList[N + 1];
        answer = new int[N + 1];
        
        for (int i = 0; i <= N; i++) {
            tree[i] = new ArrayList<>();
        }
        
        for (int i = 1; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n1 = Integer.parseInt(st.nextToken());
            int n2 = Integer.parseInt(st.nextToken());
            tree[n1].add(n2);
            tree[n2].add(n1);
        }
        
        dfs(1);
        
        StringBuilder sb = new StringBuilder();
        for (int i = 2; i <= N; i++) {
            sb.append(answer[i]).append('\n');
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
    
    static void dfs(int i) {
        for (int j : tree[i]) {
            if (answer[j] == 0) {
                answer[j] = i;
                dfs(j);
            }
        }
    }
}