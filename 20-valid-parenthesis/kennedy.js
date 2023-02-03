/**
 * @param {string} s
 * @return {boolean}
 */
var isValid = function(s) {
    if (s === '') return true
    const stack = []
    const pairing = {
        "(": ")",
        "{": "}",
        "[": "]"
    }
    for (let element of s) {
        if (pairing[element]) {
            stack.push(pairing[element])
        } else if (stack.pop() !== element) {
            return false
        }
    }
    return stack.length > 0 ? false : true
};