// Question 1: O(n)
// Question 2: O(n^2)
// Question 3: O(a + b)
// Question 4: O(n^2)
// Question 5: O(n^2), space complexity is linear

// Question 6:

const n = new Set();

for (const value of arr) {
	if (n.has(value)) {
		return true;
	} else {
		n.add(value);
	}
}
return false;
}
// this is my first time coding in JavaScript, so I had to look up some of the stuff
