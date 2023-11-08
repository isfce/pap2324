import math

def estPair(n : int)-> bool:
    '''indique si un nombre est pair'''
    assert type(n) == int and n>=0, "Le nombre doit être un entier >=0"
    return n%2==0

def nbBitsV1(n : int)-> int:
    '''Retourne le nombre de bits à 1 '''
    taille = n.bit_length();#retourne le nombre de bits de n
    cpt = 0
    masque = 1
    for _ in range(0, taille):
        if (n & masque) != 0:
            cpt = cpt + 1
        masque = masque <<1
    return cpt

