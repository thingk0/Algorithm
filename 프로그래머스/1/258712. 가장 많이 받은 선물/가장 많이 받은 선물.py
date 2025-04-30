def solution(friends, gifts):
    num_friends = len(friends)
    name_idx_map = {name: idx for idx, name in enumerate(friends)}

    # 1. 선물 주고받은 횟수 기록
    gift_count = [[0] * num_friends for _ in range(num_friends)]
    sent_count = [0] * num_friends
    received_count = [0] * num_friends

    for rec in gifts:
        sender, receiver = rec.split()
        sender_idx = name_idx_map[sender]
        receiver_idx = name_idx_map[receiver]

        gift_count[sender_idx][receiver_idx] += 1
        sent_count[sender_idx] += 1
        received_count[receiver_idx] += 1

    # 2. 선물 지수: (보낸 횟수) – (받은 횟수)
    gift_score = [sent_count[i] - received_count[i] for i in range(num_friends)]

    # 3. 다음 달에 받을 예상 선물 수
    next_month_receive = [0] * num_friends
    for i in range(num_friends):
        for j in range(i + 1, num_friends):
            sent_i_to_j = gift_count[i][j]
            sent_j_to_i = gift_count[j][i]

            if sent_i_to_j > sent_j_to_i:
                next_month_receive[i] += 1
            elif sent_i_to_j < sent_j_to_i:
                next_month_receive[j] += 1
            else:
                # 동률인 경우, gift_score 비교
                if gift_score[i] > gift_score[j]:
                    next_month_receive[i] += 1
                elif gift_score[i] < gift_score[j]:
                    next_month_receive[j] += 1
                # 같으면 증가 없음

    return max(next_month_receive)