package gr.anneta.civilization_selector;

import java.io.IOException;
//import javafx.application.Application;
//import javafx.fxml.FXMLLoader;
//import javafx.scene.Parent;
//import javafx.scene.Scene;
//import javafx.stage.Stage;
import gr.anneta.civilization_selector.dao.CivilizationRepository;
import gr.anneta.civilization_selector.service.CivilizationService;
import gr.anneta.civilization_selector.dao.PlayerRepository;
import gr.anneta.civilization_selector.domain.Civilization;
import gr.anneta.civilization_selector.domain.Player;
import gr.anneta.civilization_selector.controller.ConsoleUI;
import gr.softaware.lib.javafx.exception.SifinosException;

/**
 * @author sifis Contains the main method.
 */
public class StartUp {      //extends Application {

//    @Override
//    public void start(Stage stage) throws Exception {
//        Parent root = FXMLLoader.load(getClass().getResource("/views/MainView.fxml"));
//        Scene scene = new Scene(root);
//        scene.getStylesheets().add("/files/css/common.css");
//        stage.setTitle("Age of Empires Civilization Selector - Main");
//        stage.setScene(scene);
//        stage.show();
//    }
    public static void main(String[] args) throws IOException, SifinosException {
//        launch(args);
        ConsoleUI consoleUI = new ConsoleUI();
        consoleUI.menuUI();
//        Civilization civil=new Civilization();
//        CivilizationRepository civilizationRepository=new CivilizationRepository();
//        civilizationRepository.readById(2);
//        CivilizationService civilizationService = new CivilizationService();
//        civilizationService.delete(civil);
//        Player player = new Player("xristos","  s  ifi s ");
//        PlayerRepository playerRepository = new PlayerRepository();
//        playerRepository.delete(player);
    }
}

//////////   Tests  //////////////
//        FileUtils fileUtils = new FileUtils("/home/sifis/Project/AgeofEmpires/a.txt");
//        fileUtils.writeInFile("");
//        fileUtils.appendInFile("");
//        fileUtils.readFile();
//        fileUtils.deleteFile();
//        Player player = new Player("xristos","  s  ifi s ");
//        PlayerService playerService = new PlayerService();
//        PlayerRepository playerRepository = new PlayerRepository();
//                    playerService.create(player);
//        playerService.find();
//        playerService.delete("sifis");
//        playerService.update(player);
//            playerRepository.readByUsername("si fis");
//        playerRepository.delete(player);
//        ObjectMapper mapper = new ObjectMapper();
//        String jsonInString = mapper.writeValueAsString(player);
//        Player player1 = mapper.readValue(jsonInString, Player.class);
//        String a="  abacd da 3   ";
//        String[] aArray=a.split(" ");
//        for(int i=0;i<aArray.length;i++){System.out.print(aArray[i]);}
//        System.out.println("--->" + a.replace(" ", ""));
//        User user=new User();
//        user.editUser();
//        Boolean allowduplicatebool = consoleUI.getAllowduplicatebool();
//        AgeofEmpires ageofEmpires = new AgeofEmpires();
//            for (String username : consoleUI.getUsernames()) {
//                String randomCivilization = ageofEmpires.getRandomCivilization(allowduplicatebool);
//                System.out.println(username + ":" + randomCivilization);
//            }
