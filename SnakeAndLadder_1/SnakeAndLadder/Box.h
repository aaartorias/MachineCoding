#pragma once

class Box 
{

	// we don't need this information: unordered_set<Player> playerSet;
	int position;
	bool isSnakeMouth;
	bool isLadderBottom;
	Box* nextStep;
	bool isSnakeTailOrLadderTop; // don't assign anything else if the box is already a tail of snake or top of ladder
	//GETSET(int, number);
	
public:

	Box(int position, Box* nextStep = nullptr, bool isSnakeMouth = false, bool isLadderBottom = false, bool isSnakeTailOrLadderTop = false);

	bool checkIsSnakeMouth();

	bool checkIsLadderBottom();

	Box* getNext();

	void setNext(Box*);

	void setIsSnakeMouth(bool isSnakeMouth);

	void setIsLadderBottom(bool isLadderBottom);

	int getPosition();

	bool checkIsSnakeTailOrLadderTop();

	void setIsSnakeTailOrLadderTop(bool isSnakeTailOrLadderTop);

	/*	This is responsibility of calling function  to get next step
		if ( true == isSnakeMouth() || isLadderBottom()) {
			return nextStep;
		}

		// Throw some exception -- Trying to access Invalid next step
		return NULL;
	*/

};