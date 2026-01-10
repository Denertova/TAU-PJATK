import unittest
from utils import Board
from game import Player

class TestPlayerMovement(unittest.TestCase):
    def setUp(self):
        self.board = Board(5, 5)
        self.player = Player(self.board)

    def test_move_outside_board(self):
        y, x = self.player.pos
        self.player.pos = (0, 0)
        self.assertFalse(self.player.move('up'))
        self.assertFalse(self.player.move('left'))

    def test_move_into_obstacle(self):
        self.board.board[1][0] = 'X'
        self.player.pos = (0,0)
        self.assertFalse(self.player.move('down'))

if __name__ == "__main__":
    unittest.main()
