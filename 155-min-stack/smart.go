package minstack

type MinStack struct {
	elements    []int
	minElements []int
}

func Constructor() MinStack {
	return MinStack{
		elements:    make([]int, 0),
		minElements: make([]int, 0),
	}
}

func (this *MinStack) Push(val int) {
	if len(this.minElements) == 0 || (val <= this.minElements[len(this.minElements)-1]) {
		this.minElements = append(this.minElements, val)
	}
	this.elements = append(this.elements, val)
}

func (this *MinStack) Pop() {
	val := this.elements[len(this.elements)-1]
	this.elements = this.elements[:len(this.elements)-1]

	if this.minElements[len(this.minElements)-1] == val {
		this.minElements = this.minElements[:len(this.minElements)-1]
	}
}

func (this *MinStack) Top() int {
	return this.elements[len(this.elements)-1]
}

func (this *MinStack) GetMin() int {
	return this.minElements[len(this.minElements)-1]
}

/**
 * Your MinStack object will be instantiated and called as such:
 * obj := Constructor();
 * obj.Push(val);
 * obj.Pop();
 * param_3 := obj.Top();
 * param_4 := obj.GetMin();
 */
