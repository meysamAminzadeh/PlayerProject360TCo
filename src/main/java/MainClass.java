import comunicationInput.ComunicationUI;
import comunicationInput.FactoryCommunicationType;
import message.Message;
import message.MessageStatus;
import player.Player;
import player.IGeneralMessagingBetweenObjects;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

/**
 * This class starts comunication between two players
 * Created by asus on 7/31/2020.
 */

public class MainClass {

    public static void main(String[] args) {

        InititClass inititClass = new InititClass();
        inititClass.prepareInputFile();
    }


}