#CW Software Maintenance Coursework
COMP2042

Student Name: Chung Hao Xian

Student ID: 20109354

##Extension of the project

- Added Menu scene; Game over scene when the player lost the game; Win scene when player wins the game; Help scene to provide instruction of the game
- Added 10 levels to the game, where number and speed of object will increase, as the level progress
- Added 5 lives for the player, if player 'died' 5 times, the game is over and Game Over scene will appear
- Added score system. When the game ends, player's score will be shown, and a window showing 5 highest score will be shown
- If player's score is the top 5 highest, it will be recorded and shown in the leaderboard.
- Added a LevelInfo() class, where control objects' number and speed on each level.
- Added buttons on each scene for player navigate through different scene.
- Modified the game scene, where it will display current level, player's lives and quit button.
- Added game loops, allow the player to restart the game when player wins or loses the game.
- Added build files, so the game can run on every computer. With Maven
- Added 4 Junit Tests. With Maven

##Refactoring of the code
- MVC pattern is added to the project 
- Classes are divided into 3 packages, Model, View and Controller. Main class remains in package 'p4_group_8_repo'.
- Images, txt files, mp3 files, and font files are added to different folder.
- Created different class for each scene.
- Removed Mystage() class, and used World() as Pane instead.
- Created classes for each object and place it in Model package.
- Deleted unused methods.
- Created a class to add Background Music.
- Reduced amount of code in animationtimer() method, and pass through with methods instead.
- Remove unused variables.

##How to run
- Clone/Download the project

        https://github.com/haox1an/COMP2042_CW_hcyhc1.git

- run Command Prompt, 'CMD'
- Change the directory to the folder

        cd C:\... (folder location)
- Type 
        
        mvnw.cmd clean install
        
- Wait for the installation to complete, then type

        mvnw.cmd exec:java
        
    
    
        