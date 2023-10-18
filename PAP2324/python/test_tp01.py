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

if __name__ == "__main__":
    unittest.main()