from enum import Enum

class Couleur(Enum):
    NOIR=0
    ROUGE=1
    
class Motif(Enum):
    AS=0
    DEUX=1
    TROIS=2
    QUATRE=3
    CINQ=4
    SIX=5
    SEPT=6
    HUIT=7
    NEUF=8
    DIX=9
    VALET=10
    DAME=11
    ROI=12
    
class Forme(Enum):
    PIQUE=0
    TREFLE=1
    CARREAU=2
    COEUR=3
    
dameCoeur = (12,Motif.DAME, Forme.COEUR,Couleur.ROUGE)
print(dameCoeur)