class Stack:
    ''' Stack implémenté via une liste Python'''
    def __init__(self):
        self.__v=[]
        
    def push(self,elem):
        self.__v.append(elem)
        
    def pop(self):
        assert len(self.__v) != 0 ; "Stack Underflow"
        elem=self.__v[-1]
        del(self.__v[-1])
        return elem
    
    def top(self):
        return self.__v[-1]
    
    def empty(self):
        return len(self.__v)==0
if __name__=="__main__":
    s1= Stack()
    s1.push(10)
    s1.push(20)
    print(s1.empty())
    print(s1.pop())
    print(s1.top())
    print(s1.pop())
    print(s1.empty())
    s1 = None # libère le stack pour le GC

