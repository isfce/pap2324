import unittest
import tp01

class TestTp00(unittest.TestCase):
    
    def test_calculDecision(self):
        self.assertEqual("Refus",tp01.calculDecision(0))
        self.assertEqual("Refus",tp01.calculDecision(29))
        self.assertEqual("Ajourné",tp01.calculDecision(30))
        self.assertEqual("Ajourné",tp01.calculDecision(49))
        self.assertEqual("Réussite",tp01.calculDecision(50))
        self.assertEqual("Réussite",tp01.calculDecision(100))        
        self.assertRaises(AssertionError,tp01.calculDecision,-1)
        self.assertRaises(AssertionError,tp01.calculDecision,101)
    
    def test_calculSomme1(self):
        self.assertEqual(1,tp01.calculSomme1(1))
        self.assertEqual(10,tp01.calculSomme1(4))
        self.assertRaises(AssertionError,tp01.calculSomme1,-1)
        self.assertRaises(AssertionError,tp01.calculSomme1,2.7)
        
    def test_calculSomme2(self):
        self.assertEqual(1,tp01.calculSomme2(1))
        self.assertEqual(10,tp01.calculSomme2(4))
        self.assertRaises(AssertionError,tp01.calculSomme2,-1)
        self.assertRaises(AssertionError,tp01.calculSomme2,2.7)
        
        
        

if __name__ == "__main__":
    unittest.main()