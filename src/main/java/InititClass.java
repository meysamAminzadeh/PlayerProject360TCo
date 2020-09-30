import comunicationInput.ComunicationUI;
import comunicationInput.FactoryCommunicationType;
import message.Message;
import message.MessageStatus;
import player.IGeneralMessagingBetweenObjects;
import player.Player;

import java.util.Scanner;

/**
 * This class is a initit class and prepares the program for further tasks with the help of its methods.
 * @author Meysam Aminzade on 8/2/2020.
 */
public class InititClass {

    /**
     * This method is used to prepare the type of input and messages of the program.
     */
    public static void prepareInputFile() {
       ComunicationUI comunicationUI = FactoryCommunicationType.factoryComunicationtype("file");
       comunicationUI.makeCommunicationInfoBetween2Player();
       playComunication();
   }

    /**
     * This method is used to start the resume and start transmitting messages
     * between two players
     */
    public static void playComunication() {

        IGeneralMessagingBetweenObjects player1 = new Player("initiator");
        IGeneralMessagingBetweenObjects player2 = new Player("player2");
        Scanner scanner = new Scanner(System.in);
        int counter=1;
        while (scanner.hasNextLine()) {
            String message = scanner.nextLine();
            if(counter==11)
                break;
            String returnStringFromObject = player1.sendMessage(new Message(player2, message, MessageStatus.SEND));
            counter++;
         }


    }

}
