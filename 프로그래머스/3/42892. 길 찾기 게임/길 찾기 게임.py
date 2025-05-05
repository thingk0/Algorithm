from collections import deque

class Node:
    def __init__(self, x, y, num):
        self.x = x
        self.y = y
        self.num = num
        self.left = None
        self.right = None

def make_tree(nodeinfo):
    # 노드 정보에 번호 추가하고 정렬
    nodes = []
    for i, (x, y) in enumerate(nodeinfo):
        nodes.append(Node(x, y, i+1))
    
    nodes.sort(key=lambda node: (-node.y, node.x))
    
    if not nodes:
        return None
    
    root = nodes[0]
    
    # 반복문으로 노드 삽입 (재귀 대신)
    for i in range(1, len(nodes)):
        current_node = nodes[i]
        parent = root
        
        while True:
            if current_node.x < parent.x:  # 왼쪽으로
                if parent.left is None:
                    parent.left = current_node
                    break
                parent = parent.left
            else:  # 오른쪽으로
                if parent.right is None:
                    parent.right = current_node
                    break
                parent = parent.right
    
    return root

def preorder_iterative(root):
    if not root:
        return []
    
    result = []
    stack = [root]
    
    while stack:
        node = stack.pop()
        result.append(node.num)
        
        # 스택은 LIFO이므로 오른쪽 먼저 push (왼쪽이 먼저 처리되게)
        if node.right:
            stack.append(node.right)
        if node.left:
            stack.append(node.left)
    
    return result

def postorder_iterative(root):
    if not root:
        return []
    
    result = []
    stack = []
    node = root
    last_visited = None
    
    while stack or node:
        # 왼쪽 끝까지 이동
        if node:
            stack.append(node)
            node = node.left
        else:
            peek = stack[-1]
            
            # 오른쪽 자식이 있고 아직 방문하지 않았으면
            if peek.right and peek.right != last_visited:
                node = peek.right
            else:
                result.append(peek.num)
                last_visited = stack.pop()
    
    return result

def solution(nodeinfo):
    root = make_tree(nodeinfo)
    return [preorder_iterative(root), postorder_iterative(root)]