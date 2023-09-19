import math

class Parabole:
    ''' Equation du 2ème degré '''
    __eps = 0.000001
     
    def __init__(self,a,b,c):
        ''' a doit être != 0 '''
        assert a != 0 , " a doit être != 0"
        self.__a = a
        self.__b = b
        self.__c = c
        d = b * b - 4.0 * a * c
        self.__delta = d if math.fabs(d)>= Parabole.__eps else 0.0
        
    def getNbRacines(self):
        ''' Calcule le nombre de racines'''
        if self.__delta==0: return 1
        elif self.__delta>0: return 2
        else : return 0
    
    def getRacine1(self):
        '''Donne la première racine'''
        assert self.__delta>=0 , " pas de solution, delta doit être >= 0"
        return (-self.__b + math.sqrt(self.__delta))/(2.0 * self.__a)
    
    def getRacine2(self):
        '''Donne la deuxième racine'''
        assert self.__delta>=0 , " pas de solution, delta doit être >= 0"
        return (-self.__b-math.sqrt(self.__delta))/(2.0 * self.__a)
    
    def f(self,x):
        '''Calcule f(x)'''
        return self.__a* x * x + self.__b * x + self.__c
    
    def getSommet(self):
        '''Calcule le sommet de la parabole'''
        x1 = - self.__b /( 2.0 * self.__a)
        return x1 , self.f(x1)
        
    def getEps():
        '''Donne la précision utilisée pour savoir si delta=0'''
        return Parabole.__eps


def estPair(n : int)-> bool:
    '''indique si un nombre est pair'''
    assert type(n) == int and n>=0, "Le nombre doit être un entier >=0"
    return n%2==0

def fibo(n : int) -> int :
    '''Calcule le nème nbr de Fibonacci '''
    assert type(n)==int and n>=0 , " Doit être un entier >=0"
    f0 , f1 , f2 = 0 , 1 , n
    for i in range(1,n):
        f2 = f1 + f0
        f1 , f0 = f2 , f1
    return f2

def calculPhi(prec : float)-> (int,float):
    '''Calcul le nombre d'itérations pour avoir le nombre d'or
        avec une précision donnée '''
    assert 0< prec <=1 , "Doit respecter: 0< prec <=1"
    phi= (1 + math.sqrt(5))/2
    f0 = f1 = 1
    n = 2
    while math.fabs(phi - f1 / f0)> prec:
        f2 = f1 + f0
        f0 , f1 = f1 , f2
        n = n + 1
    return n , f1/f0


def nbBitsV1(n:int)->int:
    '''Calcule le nombre de bits à 1 au minimum pour coder le nombre n'''
    taille=n.bit_length()
    # comptabilise le bit de signe si négatif
    cpt = 0 if n>=0 else 1
    m = 1
    for i in range(0,taille):
        if (n & m)!=0 :
            cpt = cpt + 1
        m = m << 1
    return  cpt
            
    
    

    
def nbBitsV2Bis(n:int)->int:
    '''Calcule le nbr de bits à 1 sur une zone de 32bits'''
    assert  -(1<<31)<= n < (1<<31) , "le nombre doit tenir sur 32bits"
    #Si négatif conversion en un motif sur 32 bits entier
    if n<0 :
        n = (1<< 32) + n
    cpt = 0
    while n != 0 :
        cpt = cpt + (n & 1)
        n= n>>1
    return cpt

    
    
    
    

#print("Nom module: ",__name__)

if __name__ == "__main__":
    print(nbBitsV2Bis(-1))
    print(f'Calcul n: {calculPhi(0.1)}')
    print(f'Le nombre 20 est pair {estPair(20)}')
    print(f'Le nombre 27 est pair {estPair(27)}')