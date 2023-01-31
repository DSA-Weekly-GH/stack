def is_valid(s: str) -> bool:
    stack = []
    parent_map = {")": "(", '}': "{", "]": "["}
    for element in s:
        if element not in parent_map:
            stack.append(element)
        elif not stack or parent_map[element] != stack.pop():
            return False
    return not stack