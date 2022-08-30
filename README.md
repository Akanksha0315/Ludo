# GAME DEVELOPMENT: THE GAME OF ‘LUDO’
## 1. Problem Statement
Ludo is a very entertaining game that became quite popular during the Pandemic, especially in India. It follows a systematic line of play which is easy to grasp and brings out competitiveness amongst players. I chose this version of the game ‘Ludo’ for my project as it is multiplayer and a new challenge that I would like to take up when it comes to game development.

## 2. About the Game
### 2.1 Game Description
Ludo is a popular board-and-dice game that requires each player to use strategy, tactics, counting and probability in order to race their tokens from start to finish based on the rolls of a single die. A 2-4 player game, each individual has four tokens and a unique trajectory to follow. The design of the board game is of ‘Cross and Circle’ type and is shaped like a symmetrical cross.

### 2.2 Objective of the Game
The Objective of the game is to be the first player to successfully race all 4 of their tokens to the finishing point while reducing the opponents’ chances of doing the same.

### 2.3 Game Rules
The rules for the game are as follows:
1. Each player is assigned a color (from red, yellow, blue, and green) and is provided with
four tokens in their color.
2. Players are required to roll a die; they take turns in a clockwise direction.
3. To enter a token into play, the player must roll a 6.
4. For each 6 rolled, the player is permitted to roll again thus adding to the number of
spaces a single token can move on the board.
5. Each token follows a clockwise path and is required to traverse the entire board with
the exception of
a. the space previous to their starting point, and b. their opponents’ “home” columns
6. Once the player has more than one token on the board, the player is given the option to select which token they choose to move forward.
7. Only one token is allowed to move in a single turn.
8. In order to advance in the game, players must attempt to send their opponents’ tokens
back to the starting point where that opponent would require to roll a 6 (in their turn) to start moving that particular token again. This move is called “capture”. To do this, a player must land on the same space as their opponent’s token.
9. Some spaces are allocated as “safe points” where a token cannot be “captured”.

## 3. Players
### 3.1 Player Management
Ludo is a game usually played between 2-4 people. On this interface, we allow players to enter details for participants. Initially, users are required to enter the number of players they choose to play with. Once this task is complete, they are required to enter the names of the users playing in order to make it easy for users to identify the color they are supposed to represent during the game session.

### 3.2 Player Functions
Players are required to perform the following functions for User Management: 
1. Select Number of Players
2. Enter Valid Usernames for those playing the game
Players are required to perform the following functions during a Game Session:
1. Click button to “roll a die” – this function will generate a random (unbiased) natural
number from 1 – 6 which further corresponds to the appropriate moves of one of their
tokens
2. Once a player has entered more than one tokens into play, they must click on the token
they wish to move in their turn

## 4. Game Elements
### 4.1 Objects
The following are Objects that are required to be created for this game:
1. The Layout of the Game Board
2. 16 Independent Tokens distributed equally among 4 colors (each player has control over
4 tokens of a single color)
3. 1 Dice (unbiased/randomized display of natural numbers between 1-6)

### 4.2 (Potential) Files
The following are Classes/Files that are required to be created for this game:
1. SetUp – class to set up game; associate colors with players [GUI]
a. getNumberPlayers() – to get total number of players (2-4) b. getPlayerName() – to get all the name of the players
c. setNumberPlayers() – to set total number of players (2-4) d. setPlayerName()– to set all the name of the players
2. PlayGame – class to implement rules of the game
a. initializeBoard() – initializes LudoBoard class
b. initializePlayers() – initializes CreatePlayer class
c. draw() – draws the objects (Ludo board, each players’ tokens and information) d. rollDie() – randomized function to display value of a die
e. validRoll() – to check if number rolled is valid for a player’s token to move if not,
call nextPlayer()
f. disableDie() – disables once roll is valid and enables player to click on their token g. validClick() – to check if the player clicked on a valid token
h. validMove() – to check validity of the move of the token clicked based on game
rules
i. moveToken() – moves the clicked token and redraws the screen
j. capture() – to allow player to capture other player’s token based on game rules k. nextPlayer() – to move the turn to next player
3. LudoBoard – class to draw Ludo Board [GUI] a. Draw() – draws the object Ludo board
4. CreatePlayers – class to initiate/create number of players based on input
5. Player – class to initialize users; to associate colors with players
a. setColor() – to set colors to players
b. setToken() – to set 4 tokens to each player (in their color)
c. setPlayerStatus() – to store the ranking of players based on results of the game d. setTokenBase() – to store the number of tokens at base
e. setTokenHome() – to store the number of tokens at home
f. draw() – to display player information
6. Token – class to associate tokens to players; to locate positions of each token a. getPosition() – to get the position of the token
b. setPosition() – to set the position of the token
c. draw() – to draw the token
7. Path – class to store valid paths for tokens, starting point, base, safe points

## 5. Reports
Reports can be generated for the following cases:
1. Error page to inform player of incorrect Player Management input
2. Page to inform all players that the game has ended; displays ranking.


## 6. Functions and Flowcharts 
### 6.1 User Management



#### 6.1.1 User Management Functions
1. Each User is provided with a screen to select a natural number ranging from 2 to 4 representing the number of players.
2. On selection, the user’s screen provides a number of username entry fields corresponding to the number selected previously.

### 6.2 Game Set Up
#### 6.2.1 Game Set Up Functions
1. Each User is provided with a screen which displays the layout of the Game 
2. Alongside the board set up, users are provided with a display box of users’ information relating to the game including – associated color, number of tokens at base, and number of tokens at home

### 6.3 Game Session
#### 6.3.1 Game Session Functions
1. Click button to “roll a die” – this function will generate a random (unbiased) natural number from 1 – 6 which further corresponds to the appropriate moves of one of their tokens
2. Once a player has entered more than one tokens into play, they must click on the token they wish to move in their turn

### 6.4 Game Over
#### 6.4.1 Game Over Function
1. User is provided with a screen that displays the results of the Game Session

## 7. Class Diagrams

## 8. GUI Mockup
### 8.1 User Management Page 1: Select number of players
### 8.2 User Management Page 2: Enter Player Name
### 8.3 User Management Page 3: Error Page
### 8.4 Game Session Page 1: Board Set Up (4 Players)
### 8.5 Game Session Page 2: Game Mid-Session (4 Players)
### 8.6 Game Session Page 3: Game Mid-Session (3 Players)
### 8.7 Game Session Page 4: Game Mid-Session (2 Players)
### 8.8 Game Session Page 5: Game Mid-Session (4 Players)
### 8.9 Game Session Page 6: Game Mid-Session (2 Players)

## 9. RESOURCES
Software used to create this document
1. Microsoft Word – for documentation and Ludo Board MockUps 
2. ClickChart – for flowchart and UML diagram
3. Pencil – for Screen MockUps
