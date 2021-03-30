#pragma once

#include <unordered_map>

#include "Box.h"
#include "Player.h"

class Board 
{

	vector<Box*> boxes;// [] ;

public:

	Board();

	Board(unordered_map<int, int> snakes, unordered_map<int, int> ladders);

	Box* getBox(int boxNumber);

	void movePlayer(Player* player, int steps);

};
