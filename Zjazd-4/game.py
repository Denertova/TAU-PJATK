from utils import Board

class Player:
    def __init__(self, board: Board):
        self.board = board
        self.pos = board.start

    def move(self, direction: str) -> bool:
        y, x = self.pos
        if direction == 'up':
            new_pos = (y-1, x)
        elif direction == 'down':
            new_pos = (y+1, x)
        elif direction == 'left':
            new_pos = (y, x-1)
        elif direction == 'right':
            new_pos = (y, x+1)
        else:
            raise ValueError("Nieznany kierunek")

        if self._can_move(new_pos):
            self.pos = new_pos
            return True
        return False

    def _can_move(self, pos):
        y, x = pos
        if not (0 <= x < self.board.width and 0 <= y < self.board.height):
            return False  
        if self.board.board[y][x] == 'X':
            return False 
        return True

if __name__ == "__main__":
    board = Board(6, 6)
    board.display()
    
    player = Player(board)
    print("Start:", player.pos)
    print("Ruch w dół:", player.move('down'))
    print("Nowa pozycja:", player.pos)
