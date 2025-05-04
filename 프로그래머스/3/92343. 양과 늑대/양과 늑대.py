from collections import deque

def solution(info, edges):
    # 트리 구조
    tree = [[] for _ in range(len(info))]
    for parent, child in edges:
        tree[parent].append(child)

    max_sheep = 0
    # (현재노드, 양, 늑대, 방문가능 노드집합)
    q = deque([(0, 1, 0, set(tree[0]))])

    while q:
        curr, sheep, wolf, avail = q.popleft()
        max_sheep = max(max_sheep, sheep)

        for nxt in avail:
            new_avail = avail.copy()
            new_avail.remove(nxt)
            # 다음 노드의 자식들을 방문가능에 추가
            new_avail.update(tree[nxt])

            if info[nxt] == 0:  # 양
                q.append((nxt, sheep + 1, wolf, new_avail))
            else:  # 늑대
                if sheep > wolf + 1:
                    q.append((nxt, sheep, wolf + 1, new_avail))

    return max_sheep