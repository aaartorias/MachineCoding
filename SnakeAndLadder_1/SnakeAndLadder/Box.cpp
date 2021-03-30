#include "Box.h"

bool Box::checkIsSnakeMouth() 
{
	return isSnakeMouth;
}

bool Box::checkIsLadderBottom() 
{
	return isLadderBottom;
}

Box* Box::getNext() 
{
	return nextStep;
}

void Box::setIsSnakeMouth(bool isSnakeMouth) 
{
	this->isSnakeMouth = isSnakeMouth;
}

void Box::setIsLadderBottom(bool isLadderBottom) 
{
	this->isLadderBottom = isLadderBottom;
}

int Box::getPosition() {
	return position;
}

Box::Box(int position, Box* nextStep, bool isSnakeMouth, bool isLadderBottom, bool isSnakeTailOrLadderTop)
{
	this->position = position;
	this->nextStep = nextStep;
	this->isSnakeMouth = isSnakeMouth;
	this->isLadderBottom = isLadderBottom;
	this->isSnakeTailOrLadderTop = isSnakeTailOrLadderTop;
}

void Box::setNext(Box* next)
{
	this->nextStep = next;
}


bool Box::checkIsSnakeTailOrLadderTop()
{
	return this->isSnakeTailOrLadderTop;
}

void Box::setIsSnakeTailOrLadderTop(bool isSnakeTailOrLadderTop)
{
	this->isSnakeTailOrLadderTop = isSnakeTailOrLadderTop;
}