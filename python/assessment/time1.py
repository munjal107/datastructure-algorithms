def number_of_interesting_points(start_time, end_time):
	def is_interesting(time):
			if len(set(time.replace(':', ''))) <= 2:
					# print(time)
					return 1
			return 0

	def step(time):
			second = '{:02d}'.format(int(time[-2:]) + 1)
			if second != '60':
					return '{}:{}:{}'.format(time[:2], time[3:5], second)
			second = '00'
			minute = '{:02d}'.format(int(time[3:5]) + 1)
			if minute != '60':
					return '{}:{}:{}'.format(time[:2], minute, second)
			minute = '00'
			hour = '{:02d}'.format(int(time[:2]) + 1)
			if hour == '24':
					return '00:00:00'
			return '{}:{}:{}'.format(hour, minute, second)

	res = is_interesting(start_time)
	while start_time != end_time:
			start_time = step(start_time)
			res += is_interesting(start_time)

	return res
	
r = number_of_interesting_points('00:00:00', '23:59:59')
print(r)