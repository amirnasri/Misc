price = [100, 80, 60, 60, 60, 75, 85]

def print_stock_span(price):
	s = []
	for p in price:
		t = 1
		while s and s[-2] <= p:
			t += s.pop()
			s.pop()
		s.append(p)
		s.append(t)
		print(p, t)


print_stock_span(price)
		
	

