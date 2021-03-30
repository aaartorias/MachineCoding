#pragma once

#include <iostream>
#include <time.h>

class Dice 
{

	int maxFaceValue;

public:

	// Dice();
	// we don't need Dice() for our use case
	// In our case the game will always provide the face count for dice
	// If user doesn't choose a specific count for dice face before the game starts, the game defaults the face count to 6.

	Dice(int maxFaceValue);

	int rollDice();

	int getMaxFaceValue();

};