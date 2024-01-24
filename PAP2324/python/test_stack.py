import unittest
import stack

class TestMyStack(unittest.TestCase):
    
    def test_stackArray(self):
        s = stack.StackArray()
        self.assertTrue(s.empty())
        s.push(1)
        s.push(2)
        self.assertFalse(s.empty())
        self.assertEqual(2,s.top())
        self.assertEqual(2,s.pop())
        self.assertEqual(1,s.top())
        self.assertEqual(1,s.pop())
        self.assertTrue(s.empty())
        
    def test_stackListe(self):
        s = stack.StackListe()
        self.assertTrue(s.empty())
        s.push(1)
        s.push(2)
        self.assertFalse(s.empty())
        self.assertEqual(2,s.top())
        self.assertEqual(2,s.pop())
        self.assertEqual(1,s.top())
        self.assertEqual(1,s.pop())
        self.assertTrue(s.empty())
        
if __name__ == "__main__":
    unittest.main()        
        
        