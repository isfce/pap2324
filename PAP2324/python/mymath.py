import math

def estPair(n : int)-> bool:
    '''indique si un nombre est pair'''
    assert type(n) == int and n>=0, "Le nombre doit être un entier >=0"
    return n%2==0
