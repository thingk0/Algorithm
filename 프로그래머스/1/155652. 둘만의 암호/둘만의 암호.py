def solution(s, skip, index):
    # 1) skip에 해당하는 문자 표시
    is_skipped = [False] * 26
    for c in skip:
        is_skipped[ord(c) - ord('a')] = True

    # 2) 결과 누적할 리스트
    result_chars = []

    for ch in s:
        cnt = index
        cur_ord = ord(ch)
        # index만큼 순환 이동
        while cnt > 0:
            cur_ord = ord('a') if cur_ord == ord('z') else cur_ord + 1
            if is_skipped[cur_ord - ord('a')]:
                continue
            cnt -= 1

        result_chars.append(chr(cur_ord))

    return ''.join(result_chars)