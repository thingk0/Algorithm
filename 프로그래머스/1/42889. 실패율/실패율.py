def solution(N, stages):
    # 스테이지별 도전자 수 계산
    stage_counts = [0] * (N + 2)
    for stage in stages:
        stage_counts[stage] += 1
    
    # 실패율 계산
    failure_rates = []
    total_players = len(stages)
    
    for stage in range(1, N + 1):
        if total_players == 0:
            failure_rates.append((stage, 0))
        else:
            failure_rate = stage_counts[stage] / total_players
            failure_rates.append((stage, failure_rate))
            total_players -= stage_counts[stage]
    
    # 실패율 내림차순, 스테이지 번호 오름차순 정렬
    failure_rates.sort(key=lambda x: (-x[1], x[0]))
    
    # 스테이지 번호만 반환
    return [stage for stage, _ in failure_rates]