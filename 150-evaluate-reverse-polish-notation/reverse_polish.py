def evalRPN(tokens: List[str]) -> int:
    ops = {'+', '-', '/', '*'}
    operand = []
    for i in tokens:
        w = ''
        if i in ops:
            b, a = operand.pop(), operand.pop()
            if i == '/':
                w += str(eval(f'int({a}{i}{b})'))
            else:
                w += str(eval(f'({a}{i}{b})'))
            operand.append(w)
        else:
            operand.append(i)
    return int(operand[0])