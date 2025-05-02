import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {
    public int solution(String[] friends, String[] gifts) {
        // 1. 초기화: 이름을 키로 하는 Map 생성
        Map<String, Integer> sentCount = new HashMap<>();
        Map<String, Integer> receivedCount = new HashMap<>();
        Map<String, Map<String, Integer>> giftCount = new HashMap<>();

        for (String name : friends) {
            sentCount.put(name, 0);
            receivedCount.put(name, 0);
            giftCount.put(name, new HashMap<>());
            for (String other : friends) {
                giftCount.get(name).put(other, 0);
            }
        }

        // 2. 선물 주고받은 횟수 기록
        for (String rec : gifts) {
            String[] parts = rec.split(" ");
            String sender = parts[0];
            String receiver = parts[1];

            sentCount.put(sender, sentCount.get(sender) + 1);
            receivedCount.put(receiver, receivedCount.get(receiver) + 1);
            giftCount.get(sender).put(receiver, giftCount.get(sender).get(receiver) + 1);
        }

        // 3. 선물 지수 계산: 보낸 횟수 – 받은 횟수
        Map<String, Integer> giftScore = new HashMap<>();
        for (String name : friends) {
            giftScore.put(name, sentCount.get(name) - receivedCount.get(name));
        }

        // 4. 다음 달에 받을 예상 선물 수
        Map<String, Integer> nextReceive = new HashMap<>();
        for (String name : friends) {
            nextReceive.put(name, 0);
        }

        int n = friends.length;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                String a = friends[i];
                String b = friends[j];

                int a2b = giftCount.get(a).get(b);
                int b2a = giftCount.get(b).get(a);

                if (a2b > b2a) {
                    nextReceive.put(a, nextReceive.get(a) + 1);
                } else if (a2b < b2a) {
                    nextReceive.put(b, nextReceive.get(b) + 1);
                } else {
                    int scoreA = giftScore.get(a);
                    int scoreB = giftScore.get(b);
                    if (scoreA > scoreB) {
                        nextReceive.put(a, nextReceive.get(a) + 1);
                    } else if (scoreA < scoreB) {
                        nextReceive.put(b, nextReceive.get(b) + 1);
                    }
                }
            }
        }

        // 5. 최대값 반환
        return nextReceive.values()
            .stream()
            .max(Integer::compareTo)
            .orElse(0);
    }
}