
def maxElem(v):
    assert len(v)>0 ;"La liste ne peut pas être vide"
    maxi = v[0]
    for i in range(1,len(v)):
        if v[i]>maxi:
            maxi = v[i]
    return maxi

def estTrieV1(v):
    '''vérifie si v est trié'''
    assert len(v)>0;"La liste doit avoir au moins un élément"
    i = 0
    trie = True
    while i< len(v)-1 and trie:
        trie = v[i]<= v[i+1]
        i = i + 1
    return trie

def triInsertion(v):
    for i in range(1,len(v)):
        tmp = v[i]
        j = i - 1
        #Cherche la position de TMP
        while j>=0 and v[j]>tmp:
            v[j+1] = v[j] #décale l'élément
            j = j - 1
        v[j+1] = tmp
        
def triBulles(v):
    inv = len(v) - 1
    while inv != 0:
        fin = inv
        inv = 0
        for i in range(fin):
            if v[i]>v[i+1]:
                v[i] , v[i+1] = v[i+1] , v[i]
                inv = i
    
        

if __name__=="__main__":
    print(maxElem([1,7,20]))