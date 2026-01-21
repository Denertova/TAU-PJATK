import random

class Board:
    def __init__(self, width: int, height: int, obstacle_prob: float = 0.2):
        if width < 5 or height < 5:
            raise ValueError("Plansza musi mieć minimum 5x5")
        
        self.width = width
        self.height = height
        self.board = [[' ' for _ in range(width)] for _ in range(height)]
        
        self.start = self._place_edge('A')
        self.stop = self._place_edge('B', avoid=[self.start])
        self._place_obstacles(obstacle_prob)

    def _place_edge(self, symbol: str, avoid: list = []):
        edges = []
        for x in range(self.width):
            edges.append((0, x))
            edges.append((self.height-1, x))
        for y in range(1, self.height-1):
            edges.append((y, 0))
            edges.append((y, self.width-1))
        
        edges = [e for e in edges if e not in avoid]
        pos = random.choice(edges)
        self.board[pos[0]][pos[1]] = symbol
        return pos

    def _place_obstacles(self, prob: float):
        for y in range(self.height):
            for x in range(self.width):
                if self.board[y][x] == ' ' and random.random() < prob:
                    self.board[y][x] = 'X'

    def display(self):
        for row in self.board:
            print(' '.join(row))
