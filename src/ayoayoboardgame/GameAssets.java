/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ayoayoboardgame;

import javafx.scene.image.Image;

/**
 *
 * @author Odigie Oseme Utibe | osemeodigie@yahoo.com | http://osemeodigie.com
 */
public class GameAssets {
    
    //Please Note that I haven't yet created the game board or the resources folder... 
        // will do it as soon as I have tested to verify all is working as modelled....
    
    
    // Style sheets location
    public static final Image SPLASH_IMAGE = new Image("resources/images/player.png");
    
    // Style sheets location
    public static String SPLASH_SCREEN_STYLE = "resources/css/AyoSplashScreenStyle.css";
    public static String MENU_STYLE = "resources/css/AyoMenuStyle.css";
    public static String MAIN_GAME_STYLE = "resources/css/MainAyoGameBoardStyle.css";

    // How To Play File location
    public static String HOW_TO_PLAY_DOC_LOCATION = "/resources/others/how_to_play.txt";

    
    // Sound Files location
    public static String MENU_MUSIC = "/resources/sound/game_music.mp3";
    public static String GAME_MUSIC = "/resources/sound/Akashic_Records-Epic.mp3";
    public static String GAME_FX_SOUND = "/resources/sound/fx_sound.mp3";
    
        // The Ayo game board from the resources folder...
    public static final Image AyoGameBoardImage = new Image("file:resources/images/AyoGameBoard.png");
    
        // The Ayo seeds
    public static final Image AYO_SEED_IMAGE = new Image("resources/images/ayo_seed.png");
    
    
        // The Artifical intelligence (AI) players avater images
    public static final Image BeginnerPlayerAvater = new Image("file:resources/images/Avater1.png");
    
    public static final Image NormalPlayerAvater = new Image("file:resources/images/Avater2.png");
    
    public static final Image HardPlayerAvater = new Image("file:resources/images/Avater3.png");
    
    public static final Image VeryHardPlayerAvater = new Image("file:resources/images/Avater4.png");
    
}
