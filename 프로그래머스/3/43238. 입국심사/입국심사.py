def solution(n, times):
    # 1. 탐색 범위 초기화
    left, right = 1, max(times) * n
    answer = right

    # 2. 이분 탐색 시작
    while left <= right:
        mid = (left + right) // 2
        # mid 시간 안에 처리 가능한 사람 수 계산
        processed = sum(mid // t for t in times)

        if processed >= n:
            # n명 이상 처리 가능 → 더 짧은 시간(왼쪽 절반)도 확인
            answer = mid
            right = mid - 1
        else:
            # 부족하면 시간 늘리기
            left = mid + 1

    return answer
