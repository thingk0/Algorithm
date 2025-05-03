def solution(s):
    answer = [-1] * len(s)
    last_idx = { chr(c) : -1 for c in range(ord('a'), ord('z') + 1) }

    for i, ch in enumerate(s):
        last = last_idx[ch]
        answer[i] = -1 if last == -1 else i - last
        last_idx[ch] = i

    return answer