from behave import given, when, then
from utils import Board
from game import Player

@given('a {width:d}x{height:d} board')
def step_create_board(context, width, height):
    context.board = Board(width, height, obstacle_prob=0)
    context.player = Player(context.board)

@given('the player is at position ({y:d},{x:d})')
def step_set_player_position(context, y, x):
    context.player.pos = (y, x)

@given('there is an obstacle at position ({y:d},{x:d})')
def step_place_obstacle(context, y, x):
    context.board.board[y][x] = 'X'

@when('the player moves "{direction}"')
def step_player_moves(context, direction):
    context.move_result = context.player.move(direction)

@then('the move should fail')
def step_move_should_fail(context):
    assert context.move_result is False
