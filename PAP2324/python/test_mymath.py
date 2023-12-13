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
    
    def test_nbBitsV1(self):
        self.assertEqual(0,mymath.nbBitsV1(0))
        self.assertEqual(1,mymath.nbBitsV1(1))
        self.assertEqual(6,mymath.nbBitsV1(207))
        
if __name__ == "__main__":
    unittest.main()