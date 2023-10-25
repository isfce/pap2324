import sys

def calculDecision(note : float)-> str:
    '''
    Détermine la décision sur base de la note
    '''
    assert 0<=note<=100 ; "La note doit être entre 0 et 100"
    if note < 30:
        res = "Refus"
    elif note<50:
        res = "Ajourné"
    else:
        res = "Réussite"
    return res

def calculSomme1(n : int)->int:
    'Calcule la somme de 1 à n via boucle pour'
    assert type(n)==int and n>=1 ; 'n doit être un entier >=1'
    s = 1
    for i in range(2,n+1):
        s = s + i
    return s

def calculSomme2(n : int)->int:
    'Calcule la somme de 1 à n via formule'
    assert type(n)==int and n>=1 ; 'n doit être un entier >=1'
    return n * (n+1) / 2

if __name__=="__main__":
    #Lecteur de la donnée
    n = int(input("Entrez un nombre entre 0 et 100: "))
    while n<0 or n>100:
        print("ERREUR",file = sys.stderr)
        n = int(input("Entrez un nombre entre 0 et 100: "))

    #Traitement
    res = calculDecision(n)
        
    #Ecriture du résultat sur la console
    print(f'votre note {n} donne une décision: {res}')
