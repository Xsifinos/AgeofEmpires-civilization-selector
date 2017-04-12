package gr.anneta.civilization_selector;

import gr.anneta.civilization_selector.controller.ConsoleUI;
import java.io.IOException;

/**
 * @author sifis Contains the main method.
 */
public class StartUp {

    public static void main(String[] args) throws IOException {
        ConsoleUI consoleUI = new ConsoleUI();
        consoleUI.menuUI();
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
