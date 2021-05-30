import time

def time_it(func):
    def wrapper(*args, **kwargs):
        st = time.time()
        result = func(*args, **kwargs)
        et = time.time()
        print(f"{func.__name__} took ", (et-st)*1000, "mil secs to execute")
        return result
    
    return wrapper

"""
# usage
from utils import *

@time_it 
def myfunc():
    return

"""