#pragma once;

#include "Dice.h"

	Dice::Dice(int maxFaceValue)
	{
		srand(time(0));
		this->maxFaceValue = maxFaceValue;
	}

	int Dice::rollDice()
	{
		return (1 + rand() % maxFaceValue);
	}

	int Dice::getMaxFaceValue()
	{
		return this->maxFaceValue;
	}