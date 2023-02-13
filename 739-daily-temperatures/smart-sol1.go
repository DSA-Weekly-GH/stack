package dailytemperatures

func dailyTemperatures(temperatures []int) []int {
	res := make([]int, len(temperatures))
	for i, temp := range temperatures {
		dys := 0
		found := false
		for j := i; j < len(temperatures); j++ {
			if temperatures[j] > temp {
				res[i] = dys
				found = true
				break
			}
			dys++
		}
		if !found {
			res[i] = 0
		}
	}

	return res
}
