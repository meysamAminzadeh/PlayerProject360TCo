# PlayerProject360TCo
Given a Player class - an instance of which can communicate with other Players.

The requirements are as follows:

    create 2 Player instances
    one of the players should send a message to second player (let's call this player "initiator")
    when a player receives a message, it should reply with a message that contains the received message concatenated with the value of a counter holding the number of messages this player already sent.
    finalize the program (gracefully) after the initiator sent 10 messages and received back 10 messages (stop condition)
    both players should run in the same java process (strong requirement)
    document for every class the responsibilities it has.
    additional challenge (nice to have) opposite to 5: have every player in a separate JAVA process.

Please use core Java as much as possible without additional frameworks like Spring etc; focus on design and not on the technology. Please include a maven project with the source code to build the jar and a shell script to start the program. Everything not specified is to be decided by you; everything specified is a hard requirement.

You should send your source code as an archive attached to the e-mail; inline links for downloading will be ignored.
