def solution(answers):
    
    patterns = [
        [1, 2, 3, 4, 5],
        [2, 1, 2, 3, 2, 4, 2, 5],
        [3, 3, 1, 1, 2, 2, 4, 4, 5, 5]
    ]
    
    scores = [0] * 3
    for i, ans in enumerate(answers):
        for j, ptn in enumerate(patterns):
            if ans == ptn[i % len(ptn)]:
                scores[j] += 1
                
    max_score = max(scores)
    
    highest_scores = []
    for i, score in enumerate(scores):
        if score == max_score:
            highest_scores.append(i + 1)
    
    return highest_scores