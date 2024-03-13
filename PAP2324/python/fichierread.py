#Définition d'une classe Achat
class Achat:
    def __init__(self,prenom,nom,montant):
        self.prenom = prenom
        self.nom = nom
        self.montant = montant
try:
    #Ouverture d'un fichier en mode lecture, codé en UTF8
    f = open('achats.txt','r',encoding='utf8')
    achats =[]#liste des achats
    #Affiche les entêtes de ligne
    for txt in f.readline().rstrip('\n').split(';'):
        print(f'{txt:10}',end='')
    print('\n----------------------------')
    for l in f:
        l = l.rstrip('\n')#supprime le passage à la ligne
        txte = l.split(';')#split en une liste
        achat= Achat(txte[0],txte[1],float(txte[2]))
        achats.append(achat)
    #affiche les achats
    for achat in achats:
        print(f'{achat.prenom:10}{achat.nom:10}{achat.montant:7.2f}')
    f.close    
except FileNotFoundError as e:
    print('ERREUR: ',e)       
