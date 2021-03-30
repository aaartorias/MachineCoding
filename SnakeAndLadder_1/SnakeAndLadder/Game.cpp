#include "Game.h"

Game::Game(list<string> players, unordered_map<int, int> snakes, unordered_map<int, int> ladders, int dicemaxFaceValue)
{

	// Create dice
	this->dice = new Dice(dicemaxFaceValue);
	
	// Create players
	for (auto playerName : players) 
	{
		Player* player = new Player(playerName);
		playersMap[playerName] = player;
		allPlayers.push_back(playerName);
	}

	// Create board
	this->board = new Board();

	// There is no winner at this point
	this->hasWinner = false;

	this->winner = NULL;

	this->playerCount = players.size();
	
	setSnakes(snakes);

	setLadders(ladders);
}

//void Game::roll(string playerName) 
void Game::start()
{

	list<string>::iterator playerName = allPlayers.begin();//this->getPlayerIterator();

	while (!this->checkIfGameHasWinner())
	{

		if (playerName == allPlayers.end())
		{
			playerName = allPlayers.begin();
		}

		if (this->hasWinner) 
		{
			cout << "Can't proceed further!! the game already has a winner :: " << playersMap[*playerName] << endl;
			cout << "Please start new game" << endl;
			return;
		}
		
		int steps = this->dice->rollDice();
		Player* player = playersMap[*playerName];

		// If rolled dice gave out number equals the maxFaceValue of dice then player gets to roll again
		while (steps == this->dice->getMaxFaceValue()) 
		{
			board->movePlayer(player, steps);
			cout << "Player :: " << player->getName() << " played a 6. He goes again" << endl;
			steps = this->dice->rollDice();
			// if player reaches last cell declare winner 
			// We can decide whether we want to announce player winner or make him keep rolling until a smaller value comes and then make call
			if (player->getPosition() + steps == 100) break;

		}

		board->movePlayer(player, steps);

		if (player->getPosition() == 100) 
		{
			// Declare winner
			cout << "We have a winner :: player :: " << player->getName() << endl;
			this->setWinner(player);
			return;
		}

		playerName++;

	}
	
}
 

void Game::setSnakes(unordered_map<int,int> snakes) 
{
	unordered_map<int, int>::iterator itr = snakes.begin();
	for (itr; itr != snakes.end(); itr++)
	{
		Box* srcBox = board->getBox(itr->first);
		Box* destBox = board->getBox(itr->second);
		if (srcBox->getPosition() < destBox->getPosition())
		{
			cout << "Can't assign snake" << endl;
			// throw illegalSnakeAssignment Exception
			return;
		}

		if (srcBox->getNext() != nullptr || srcBox->checkIsSnakeTailOrLadderTop() || destBox->getNext() != nullptr)
		{
			// throw illegal assignment exception
			cout << "Can't assign ladder to an already assigned box";
			return;
		}

		srcBox->setIsSnakeMouth(true);
		srcBox->setNext(destBox);
		destBox->setIsSnakeTailOrLadderTop(true);

	}
}


void Game::setLadders(unordered_map<int, int> ladders) 
{
	unordered_map<int, int>::iterator itr = ladders.begin();

	for (itr; itr != ladders.end(); itr++)
	{
		Box* srcBox = board->getBox(itr->first);
		Box* destBox = board->getBox(itr->second);
		if (srcBox->getPosition() > destBox->getPosition())
		{
			cout << "Can't assign ladder" << endl;
			// throw illegalLadderAssignment Exception
			return;
		}

		if (srcBox->getNext() != nullptr || srcBox->checkIsSnakeTailOrLadderTop() || destBox->getNext() != nullptr)
		{
			// throw illegal assignment exception
			cout << "Can't assign ladder to an already assigned box";
			return;
		}

		srcBox->setIsLadderBottom(true);
		srcBox->setNext(destBox);
		destBox->setIsSnakeTailOrLadderTop(true);

	}

}


void Game::setSnakes(int src, int dest)
{
	if (src < dest)
	{
		// throw invalid assignment
		cout << "Can't assign ladder with bottom at :: " << src << " and top at :: " << dest << endl;
		return;
	}

	Box* srcBox = board->getBox(src);
	Box* destBox = board->getBox(dest);
	// if src is already set with next, or src is already a snake tail or ladder top, or dest is already a snake mouth(swallowed) or ladder bottom(climbing up)
	if (srcBox->getNext() != nullptr || srcBox->checkIsSnakeTailOrLadderTop() || destBox->getNext() != nullptr)
	{
		// throw illegal assignment exception
		cout << "Can't assign ladder to an already assigned box";
		return;
	}

	srcBox->setIsSnakeMouth(true);
	srcBox->setNext(destBox);
	destBox->setIsSnakeTailOrLadderTop(true);

}

void Game::setLadders(int src, int dest) 
{
	if (src > dest)
	{
		// throw invalid assignment
		cout << "Can't assign ladder with bottom at :: " << src << " and top at :: " << dest << endl;
		return;
	}

	Box* srcBox = board->getBox(src);
	Box* destBox = board->getBox(dest);

	// if src is already set with next, or src is already a snake tail or ladder top, or dest is already a snake mouth(swallowed) or ladder bottom(climbing up)
	if (srcBox->getNext() != nullptr || srcBox->checkIsSnakeTailOrLadderTop() || destBox->getNext() != nullptr)
	{
		// throw illegal assignment exception
		cout << "Can't assign ladder to an already assigned box";
		return;
	}

	srcBox->setIsLadderBottom(true);
	srcBox->setNext(destBox);
	destBox->setIsSnakeTailOrLadderTop(true);

}

bool Game::checkIfGameHasWinner()
{
	return this->hasWinner;
}

void Game::setWinner(Player* player)
{
	this->winner = player;
}

Player* Game::getWinner()
{
	return this->winner;
}

/*
list<string>::iterator Game::getPlayerIterator() 
{
	return allPlayers.begin();
}
*/