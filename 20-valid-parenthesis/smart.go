package validparenthesis

func isValid(s string) bool {
	strLen := len(s)

	// if s has odd length, then it definitely isnt valid
	if strLen%2 == 1 {
		return false
	}

	stack := make([]string, 0, strLen)
	bracesMap := map[string]string{
		"{": "}",
		"(": ")",
		"[": "]",
	}
	expectedClosingBrace := ""

	for _, brace := range s {
		if matchingClosingBrace, ok := bracesMap[string(brace)]; ok {
			stack = append(stack, string(brace))
			expectedClosingBrace = matchingClosingBrace
			continue
		}
		if string(brace) == expectedClosingBrace {
			stack = stack[:len(stack)-1]
			if len(stack) > 0 {
				expectedClosingBrace = bracesMap[stack[len(stack)-1]]
			} else {
				expectedClosingBrace = ""
			}
		} else {
			return false
		}
	}

	if len(stack) == 0 {
		return true
	} else {
		return false
	}
}
