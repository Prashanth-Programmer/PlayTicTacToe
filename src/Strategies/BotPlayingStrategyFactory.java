package Strategies;

import Models.DifficultyLevel;

public class BotPlayingStrategyFactory {
    public static BotPlayingStrategies getBotPlayingStrategy(DifficultyLevel difficultyLevel){
        if(difficultyLevel.equals(DifficultyLevel.EASY)){
            return new EasyBotPlayingStrategy();
        }
        if(difficultyLevel.equals(DifficultyLevel.MEDIUM)){
         return new MediumBotPlayingStrategies();
        }
        return  new EasyBotPlayingStrategy();
    }
}
