package player;

import comunicationOutput.OutPut;
import message.Message;

import java.util.HashMap;
import java.util.Map;

/**
 * show a player which is able to send and receive message with other players
 *
 * @author Meysam Aminzade on 7/31/2020.
 */

public final class Player implements IGeneralMessagingBetweenObjects {

    /**
     * Player name
     */
    private String name;

    /**
     * Keep capacitystaus of each player which I can understand how many message
     * recieve from each players
     */
    private final Map<Player, Integer> capacityStauts = new HashMap<>();

    /**
     * Create a new player with the provided name
     *
     * @param name
     */
    public Player(String name) {
        this.name = name;

    }

    /**
     * @return the player name
     */
    public String getName() {
        return name;
    }

    /**
     * set the player name
     */
    public void setName(String name) {
        this.name = name;
    }


    @Override
    /**
     * Send a message to another player
     * @param Message get message with receiveplayer, message text ,
     *                and message status content
     * @return return message after make it on receiveMessage method
     */
    public String sendMessage(Message message) {
        Player player = (Player) message.getRecieverObject();

        OutPut.write(this.name + " sent a message '" + message.getMessage() + "' to "
                + player.getName(), player.getName());

        return player.receiveMessage(this, message, player);


    }

    @Override
    /**
     * get me the last count of capacity for each players
     * @param IGeneralMessagingBetweenObjects player that I need capacity counter
     * @return return capacity counter
     */
    public int findCountSendMessage(IGeneralMessagingBetweenObjects player) {
        return capacityStauts.getOrDefault(player, 0);
    }

    /**
     * this method get receive message and make reply message
     *
     * @param rPlayer show reciever player
     * @param message show message that receive
     * @param tPlayer show players that want to it message
     * @return return  reply message
     */
    public String receiveMessage(Player rPlayer, Message message, Player tPlayer) {
        Integer counter = findCountSendMessage(rPlayer) + 1;
        capacityStauts.put(rPlayer, counter);

        String returnMessage = rPlayer.name + " received a (counter: " + counter + ") message '" + message.getMessage()
                + "' from " + tPlayer.name;

        OutPut.write(returnMessage, tPlayer.getName());

        return returnMessage;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Player)) return false;

        Player player = (Player) o;

        if (getName() != null ? !getName().equals(player.getName()) : player.getName() != null) return false;
        return !(capacityStauts != null ? !capacityStauts.equals(player.capacityStauts) : player.capacityStauts != null);

    }

    @Override
    public int hashCode() {
        int result = getName() != null ? getName().hashCode() : 0;
        result = 31 * result + (capacityStauts != null ? capacityStauts.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "player.Player{" +
                "name='" + name + '\'' +
                ", capacityStauts=" + capacityStauts +
                '}';
    }
}
