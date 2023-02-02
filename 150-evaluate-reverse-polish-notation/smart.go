package evaluatereversepolishnotation

import "strconv"

func evalRPN(tokens []string) int {
	stack := make([]int, 0)
	ops := map[string]struct{}{
		"+": {},
		"-": {},
		"*": {},
		"/": {},
	}

	for _, token := range tokens {
		// if token is an operator,
		// perform operation
		if _, ok := ops[token]; ok {
			op1 := stack[len(stack)-2]
			op2 := stack[len(stack)-1]
			res := 0
			switch token {
			case "+":
				res = op1 + op2
			case "-":
				res = op1 - op2
			case "*":
				res = op1 * op2
			case "/":
				res = op1 / op2
			}
			stack = stack[:len(stack)-2]
			stack = append(stack, res)
			continue
		}
		// else just add to stack
		num, _ := strconv.Atoi(token)
		stack = append(stack, num)
	}

	return stack[0]
}
