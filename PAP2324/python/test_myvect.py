import unittest
import myvect

class TestMyVect(unittest.TestCase):
    vo=[]
    v1=[1]
    v2=[1,2,2,3]
    v3=[1,2,3,1]
    
    def test_maxElem(self):
        self.assertEqual(20,myvect.maxElem([1,4,20]))
        self.assertEqual(100,myvect.maxElem([100,4,20]))  
        self.assertRaises(AssertionError,myvect.maxElem,[])
    
    def test_estTrie(self):
        vo=[]
        v1=[1]
        v2=[1,2,2,3]
        v3=[1,2,3,1]
        self.assertTrue(myvect.estTrieV1(v1))
        self.assertTrue(myvect.estTrieV1(v2))
        self.assertFalse(myvect.estTrieV1(v3))
        self.assertRaises(AssertionError,myvect.estTrieV1,vo)
        
if __name__ == "__main__":
    unittest.main()