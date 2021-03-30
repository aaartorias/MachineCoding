#pragma once

#include <iostream>
#include <string>

#include "Box.h"
#include "Dice.h"

using namespace std;

class Player {

	Box* currentBox;
	string name;
	int position;

public:

	Player(string name);

	void setCurrentBox(Box* box);

	Box* getCurrentBox();

	void rollDice(Dice* dice);

	void move(int steps);

	int getPosition();

	void setPosition(int position);

	string getName();

};
