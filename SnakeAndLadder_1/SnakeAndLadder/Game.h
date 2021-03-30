#pragma once

#include <iostream>
#include <unordered_map>
#include <iterator>
#include <string>

#include "Player.h"
#include "Dice.h"
#include "Board.h"

using namespace std;

class Game 
{

	unordered_map<string, Player*> playersMap;
	Dice* dice;
	Board* board;
	bool hasWinner;
	Player* winner;
	int playerCount;
	list<string> allPlayers;

public:


	Game(list<string> players, unordered_map<int, int> snakes, unordered_map<int, int> ladders, int dicemaxFaceValue = 6);

	//void roll(string player);

	void start();

	void setSnakes(unordered_map<int, int> snakes);

	void setLadders(unordered_map<int, int> ladders);

	bool checkIfGameHasWinner();

	void setWinner(Player* player);

	Player* getWinner();

	void setSnakes(int src, int dest);

	void setLadders(int src, int dest);

	//list<string>::iterator getPlayerIterator();

};


