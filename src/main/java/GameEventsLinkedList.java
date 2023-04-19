class GameEvent {
    protected int playerNumber; // stores unique identifier for a player
    protected String eventType; // tag for different categories of events
    protected String eventDetails; // description of the game event
    public GameEvent(int playerNumber, String eventType, String eventDetails) {
        this.playerNumber = playerNumber;
        this.eventType = eventType;
        this.eventDetails = eventDetails;
    }
    public GameEvent() {
        this(0, "", "");
    }
    public int getPlayerNumber() {
        return this.playerNumber;
    }
    public String getEventType() {
        return this.eventType;
    }
    public String getEventDetails() {
        return this.eventDetails;
    }
    public void setPlayerNumber(int playerNumber) {
        this.playerNumber = playerNumber;
    }
    public void setEventType(String eventType) {
        this.eventType = eventType;
    }
    public void setEventDetails(String eventDetails) {
        this.eventDetails = eventDetails;
    }
}

class GameEventNode {
    protected GameEvent gameState; // stores specific game event
    protected GameEventNode next; // stores next game event node

    public GameEventNode(GameEvent gameState) {
        this.gameState = gameState;
        this.next = null;
    }

    public GameEvent getGameState() {
        return this.gameState;
    }
    public GameEventNode getNext() {
        return this.next;
    }
    public void setGameState(GameEvent gameState) {
        this.gameState = gameState;
    }
    public void setNext(GameEventNode next) {
        this.next = next;
    }
}
public class GameEventsLinkedList {
    protected GameEventNode head; // first game event
    protected int size; // size of the linked list

    public GameEventNode getHead() {
        return this.head;
    }
    public int getSize() {
        return this.size;
    }
    public void setHead(GameEventNode head) {
        this.head = head;
    }
    public GameEventsLinkedList() {
        this.head = null;
        this.size = 0;
    }

    public boolean isEmpty() {
        return (head == null);
    }

    public void add(GameEventNode newNode) {
        if (this.isEmpty()) {
            this.head = newNode;
        }
        else {
            GameEventNode current = this.head;
            while (current.getNext() != null) {
                current = current.getNext();
            }
            current.setNext(newNode);
        }
        this.size += 1;
    }

    public GameEvent remove(GameEventNode removedNode) {
        GameEventNode current = this.head;
        if (current == removedNode) {
            this.head = current.getNext();
            current.setNext(null);
            this.size -= 1;
            return current.getGameState();
        }
        while (current.getNext() != null) {
            while (current.getNext() != removedNode) {
                current = current.getNext();
            }
            current.setNext(removedNode.getNext());
            this.size -= 1;
            removedNode.setNext(null);
            return removedNode.getGameState();
        }
        return null;
    }

    public GameEventsLinkedList extract(String eventType) {
        GameEventsLinkedList eventList = new GameEventsLinkedList();
        GameEventNode current = this.head;
        while (current != null) {
            if (current.getGameState().getEventType().equals(eventType)) {
                GameEventNode dummyNode = new GameEventNode(new GameEvent(current.getGameState().getPlayerNumber(),
                        current.getGameState().getEventType(), current.getGameState().getEventDetails()));
                eventList.add(dummyNode);
            }
            current = current.getNext();

        }
        return eventList;
    }

    public void display() {
        GameEventNode current = this.head;
        while (current != null) {
            System.out.println(current.getGameState().getEventDetails());
            current = current.getNext();
        }
    }
}
