import sys
#Définition d'une classe Achat
class Achat:
    def __init__(self,prenom,nom,montant):
        self.prenom = prenom
        self.nom = nom
        self.montant = montant
        
#Crée une liste d'achats
achats=[Achat("Didier","VO",124.90),Achat("Lola","COOL",123.77)]
#Ouverture du fichier avec l'encodage
nom = 'c:/aaa/listeAchats.txt'
try:#gère les exceptions d'erreurs
    #ouvre le fichier en append avec un encodage 'utf8'
    with open(nom,'a',encoding = 'utf8') as f:
        for achat in achats:
            #écrit une ligne avec le séparateur ';' et une fin de ligne
            f.write(achat.prenom+';'+achat.nom+';'+str(achat.montant)+'\n')
except PermissionError as e:#gestion d'erreur de permission
    #Sortie sur l'output d'erreur standard
    sys.stderr.write(f'Le fichier existe déjà: {e}')
    