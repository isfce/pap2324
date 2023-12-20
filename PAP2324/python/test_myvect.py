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
        
    def test_triInsertion(self):
        v1 = [5,4,3,2,1]
        v2 = [1,2,3]
        v3 = [5,1,4,2,3,6]
        myvect.triInsertion(v1)
        self.assertListEqual([1,2,3,4,5],v1)
        myvect.triInsertion(v2)
        self.assertListEqual([1,2,3],v2)
        myvect.triInsertion(v3)
        self.assertListEqual([1,2,3,4,5,6],v3)
        
    def test_triBulles(self):
        v1 = [5,4,3,2,1]
        v2 = [1,2,3]
        v3 = [5,1,4,2,3,6]
        v4 = [4,2]
        myvect.triBulles(v1)
        self.assertListEqual([1,2,3,4,5],v1)
        myvect.triBulles(v2)
        self.assertListEqual([1,2,3],v2)
        myvect.triBulles(v3)
        self.assertListEqual([1,2,3,4,5,6],v3)
        myvect.triBulles(v4)
        self.assertListEqual([2,4],v4)
        
        
if __name__ == "__main__":
    unittest.main()