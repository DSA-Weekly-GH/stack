/**
 * @param {string} s
 * @return {boolean}
 */
var isValid = function(s) {
  if (s.length % 2 === 1) return false
  
  const stack = []
  const bracesMap = {
    '{': '}',
    '(': ')',
    '[': ']',
  }
  let expectedClosingBrace = ''
  let isValid = true
  
  s.split('').forEach(brace => {
    if (isValid) {
      currentClosingBrace = bracesMap[brace]
      
      if (currentClosingBrace) {
        stack.push(brace)
        expectedClosingBrace = currentClosingBrace
        return
      }

      if (brace === expectedClosingBrace) {
        stack.pop()
        expectedClosingBrace = bracesMap[stack[stack.length - 1]]
      } else {
        isValid = false
      }
    }
  })
  
  if (!isValid || stack.length) return false
  else return true
}
