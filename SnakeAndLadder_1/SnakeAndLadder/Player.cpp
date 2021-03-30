#include "Player.h"

Player::Player(string name) 
{
	this->name = name;
}

void Player::setCurrentBox(Box* box) 
{
	this->currentBox = box;
}

Box* Player::getCurrentBox() 
{
	return currentBox;
}

int Player::getPosition()
{
	return position;
}

void Player::setPosition(int position) 
{
	this->position = position;
}

string Player::getName() 
{
	return name;
}