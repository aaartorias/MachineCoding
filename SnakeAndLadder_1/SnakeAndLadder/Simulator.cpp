#include <iostream>
#include <vector>
#include <list>
#include <unordered_map>
#include <unordered_set>

#include "Board.h"
#include "Box.h"
#include "Dice.h"
#include "Game.h"
#include "Player.h"

/*
#define GETSET(type, var) \
private: \
    type var; \
public: \
    type Get##var() \
{\
return var; \
}\
void Set##var(type val) \
{\
	var = val; \
}


class Character {

};

class Snake: public Character {


};

class Ladder : public Character {


};


// Two design choices --
// 1) have a snake reference in Box itself - and snake will have face and tail Boxes
//	  similarly keep a ladder object and Ladder object will have reference to top and bottom Boxes

// 2) Don't use Snake and Ladder as entitiy but rather as property of Box object
// Let's use this anology, a snake (mouth)or ladder (Top)either exists in a box or don't.
// if snake or ladder exists then there must be some information about next step
// Caller of box is reponsible for checking whether if box has snake or ladder before calling for next step
// I am using this methodology

*/
using namespace std;

class Simulation
{
	list<string> players;
	int diceMaxFaceValue;
	Game* game;
	unordered_map<int, int> snakes;
	unordered_map<int, int> ladders;

public:

	//Simulation(list<string> players, int diceMaxFaceValue, unordered_map<int, int> snakes, unordered_map<int, int> ladders);

	void addPlayers(string player);

	void setDicemaxFaceValue(int dicemaxFaceValue);

	void simulate();

	void addSnake(int src, int dest);

	void addLadder(int src, int dest);

	void createSimulation();

};

void Simulation::createSimulation()
{
	game = new Game(players, snakes, ladders, diceMaxFaceValue);
}

//Simulation::Simulation(list<string> players, int diceMaxFaceValue, unordered_map<int, int> snakes, unordered_map<int, int> ladders)

void Simulation::addPlayers(string player) 
{
	players.push_back(player);
}

void Simulation::setDicemaxFaceValue(int diceMaxFaceValue) 
{
	this->diceMaxFaceValue = diceMaxFaceValue;
}


void Simulation::addSnake(int src, int dest)
{

	if (src < dest)
	{
		// throw invalid assignment
		cout << "Can't assign snake with head at :: " << src << " and tail at :: "<< dest << endl;
		return;
	}

	if (snakes.find(src) != snakes.end())
	{
		// throw illegal assignment exception
		cout << "Can't assign snake to an already assigned snake";
		return;
	}

	snakes[src] = dest;

}

void Simulation::addLadder(int src, int dest)
{

	if (src > dest)
	{
		// throw invalid assignment
		cout << "Can't assign ladder with bottom at :: " << src << " and top at :: " << dest << endl;
		return;
	}

	if (ladders.find(src) != ladders.end())
	{
		// throw illegal assignment exception
		cout << "Can't assign ladder to an already assigned ladder";
		return;
	}

	ladders[src] = dest;

}


void Simulation::simulate() 
{

	game = new Game(players, snakes, ladders, diceMaxFaceValue);
	game->start();
	/*
	auto itr = players.begin();
	while (!game->checkIfGameHasWinner())
	{

		if (itr == players.end()) 
		{
			itr = players.begin();
		}
		game->roll(*itr);
		itr++;

	}
	*/
}

int main() {

	list<string> players = {
							"Ram",
							"Shyam",
							"Kalu",
							"Bhalu"
						};

	unordered_map<int, int> snakes;
	unordered_map<int, int> ladders;

	Simulation* sim = new Simulation();

	for (auto player : players) 
	{
		sim->addPlayers(player);
	}

	sim->setDicemaxFaceValue(8); // use it if you want to set a specific value to dice face otherwise reject it
	sim->addSnake(25,3);
	sim->addLadder(4,28);
	sim->addSnake(96, 33);
	sim->addLadder(30, 60);

	sim->simulate();
	cout << "Thanks for playing the game" << endl;




	return 0;

}