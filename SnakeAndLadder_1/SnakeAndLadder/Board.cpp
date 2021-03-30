#include <iostream>

#include "Board.h"

Box* Board::getBox(int boxNumber) 
{

	if (boxNumber > 0 && boxNumber <= 100) 
	{
		return boxes[boxNumber];
	}
	// throw an exception - invalid box number
	return NULL;
}

void Board::movePlayer(Player* player, int steps)
{

	int currentPosition = player->getPosition();
	int nextPosition = currentPosition + steps;

	if (nextPosition > 100) {
		cout << " Player :: " << player->getName() << " can't move to position " << nextPosition<< ". It's beyond our limit" << endl;
		return;
	}; 

	// currentBox->remove(this); -- won't need it as for our case box is not responsible for keeping player info
	Box* nextBox = this->getBox(nextPosition);
	cout << "Regular Move :: " << player->getName() << " :: moved from :: " << currentPosition << " to " << nextPosition << endl;;
	if (nextBox->checkIsSnakeMouth() || nextBox->checkIsLadderBottom()) 
	{
		currentPosition = nextPosition;
		nextPosition = nextBox->getNext()->getPosition();
		if (nextPosition < currentPosition) {
			cout << "Oops!! Swallowed by snake :: " << player->getName() << " :: moved from :: " << currentPosition << " to " << nextPosition << endl;
		}
		else {
			cout << "Yippee!! Climbing up the ladder ::" << player->getName() << " :: moved from :: " << currentPosition << " to " << nextPosition << endl;
		}
	}
	/*else {
		cout << "Regular Move :: " << player->getName() << " :: moved from :: " << currentPosition << " to " << nextPosition << endl;;
	}*/

	player->setPosition(nextPosition);	
}


Board::Board() {
	for (int i = 0; i <= 101; i++) {
		boxes.push_back(new Box(i));
	}
	
}

Board::Board(unordered_map<int, int> snakes, unordered_map<int, int> ladders) {
	for (int i = 0; i <= 101; i++) {
		boxes.push_back(new Box(i));
	}
	//addSnakes()
}