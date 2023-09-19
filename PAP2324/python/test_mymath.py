import unittest
import mymath

class TestMyMath(unittest.TestCase):
    
    def test_estPair(self):
        self.assertEqual(True,mymath.estPair(20))
        self.assertEqual(False,mymath.estPair(21))
        self.assertEqual(True,mymath.estPair(0))
        self.assertRaises(AssertionError,mymath.estPair,-1)
        self.assertRaises(AssertionError,mymath.estPair,5.0)
        self.assertRaises(AssertionError,mymath.estPair,"brol")
    
    def test_fibo(self):
        self.assertEqual(0,mymath.fibo(0))
        self.assertEqual(1,mymath.fibo(1))
        self.assertEqual(1,mymath.fibo(2))
        self.assertEqual(8,mymath.fibo(6))
        self.assertRaises(AssertionError,mymath.fibo,-1)
    
    def test_nbBitsV2Bis(self):
        self.assertEqual(0,mymath.nbBitsV2Bis(0))
        self.assertEqual(32,mymath.nbBitsV2Bis(-1))
        self.assertEqual(2,mymath.nbBitsV2Bis(10))
        self.assertEqual(1,mymath.nbBitsV2Bis(1))
        
    def test_nbBitsV1(self):
        self.assertEqual(0,mymath.nbBitsV1(0))
        self.assertEqual(2,mymath.nbBitsV1(-1))
        self.assertEqual(2,mymath.nbBitsV1(10))
        self.assertEqual(5,mymath.nbBitsV1(-41))
        self.assertEqual(3,mymath.nbBitsV1(41))
        

if __name__ == "__main__":
    unittest.main()