import java.util.Stack; // Import the Stack class

/**
 * Represents a Magical Adventurer that implements the Contract interface.
 */

public class MagicalAdventurer implements Contract {
    
    private double currentSize; // Declare current size of the Magical Adventurer
    private int power; // Declare a field to represent the power level
    private Stack<String> backpack; // Declare a Stack to represent the backpack
    private Stack<String> actions; // Declare a Stack to store actions

    /**
     * Constructs a MagicalAdventurer object with initial values for size, power,
     * actions, and backpack.
     */

    public MagicalAdventurer() {
        currentSize = 10.0; // Initalize the size of the Magical Adventurer
        power = 100; // Initialize the power level to 100
        actions = new Stack<>(); // Initialize the actions stack as a new Stack
        backpack = new Stack<>(); // Initialize the backpack as a new Stack
    
    }

    /**
     * Grabs an item and adds it to the backpack.
     * 
     * @param item The item to be grabbed.
     */

    @Override
    public void grab(String item) {
        System.out.println("Magical adventurer grabs " + item + " using their telekinesis.");
        backpack.push(item); // Add the item to the backpack using the push() method
    }
    
    /**
     * Drops an item from the backpack.
     * 
     * @param item The item to be dropped.
     * @return A String describing the result of the action.
     */
    

    @Override
    public String drop(String item) {
        if (backpack.contains(item)) {
            backpack.remove(item); // Remove the item from the backpack
            System.out.println("Magical adventurer drops " + item + " with a wave of their hand.");
            // Implement dropping logic using magic, e.g. item disappears into thin air
            return "The " + item + " disappears into thin air.";
        } else {
            System.out.println("The " + item + " is not in the backpack."); // Print a message if the item is not in the backpack
            return "The " + item + " is not in the backpack.";
        }
    }

    /**
     * Examines an item in the backpack.
     * 
     * @param item The item to be examined.
     */
        

    @Override
    public void examine(String item) {
        System.out.println("Magical adventurer examines " + item + " using their clairvoyance.");
        if (backpack.contains(item)) {
            System.out.println("The " + item + " is in the backpack.");
        } else {
            System.out.println("The " + item + " is not in the backpack.");
        }
    }

    /**
     * Uses an item to cast a spell.
     * 
     * @param item The item to be that the spell was casted upon.
     */
    

    @Override
    public void use(String item) {
        System.out.println("Magical adventurer uses " + item + " to cast a spell.");
        // Implement using logic by casting a spell
    }

    /**
     * Walks in a specified direction.
     * 
     * @param direction The direction to walk.
     * @return Returns true if the action was successful, false otherwise.
     */

    @Override
    public boolean walk(String direction) {
        System.out.println("Magical adventurer walks " + direction + " using levitation.");
        // Implement walking logic using levitation
        return true;
    }

    @Override
    public boolean fly(int x, int y) {
        System.out.println("Magical adventurer flies to (" + x + ", " + y + ") using their wings.");
        // Implement flying logic using teleportation
        return true;
    }

    @Override
    public Double shrink() {
        System.out.println("Magical adventurer shrinks in size using their transformation spell.");
        // Implement shrinking logic using polymorph spell
        currentSize = currentSize * 0.5; // Update currentSize to be half of its current value
        return currentSize; // Return the new size as a fraction of the original size
    }

    @Override
    public Double grow() {
        System.out.println("Magical adventurer grows in size using their enlargement spell.");
        // Implement growing logic using enlargement spell
        currentSize = currentSize * 1.5; // Update currentSize to be 1.5 times its current value
        return currentSize; // Return the new size as a multiple of the original size
    }

     /**
     * Get the current power level of the Magical Adventurer.
     * 
     * @return The current power level of the Magical Adventurer.
     */

    // Define the getPower() method to get the current power level
    public int getPower() {
        return power;
    }

    /**
     * Set the new power level for the Magical Adventurer.
     * 
     * @param newPower The new power level to set for the Magical Adventurer.
     */
    
    // Define the setPower() method to set the new power level
    public void setPower(int newPower) {
        power = newPower;
    }
    
    /**
     * Rest and regain power through meditation.
     * 
     * This method implements resting logic to regain power using meditation. For example, you can increase
     * the power level of the adventurer by a certain amount or set it to a maximum value.
     */

    @Override
    public void rest() {
        System.out.println("Magical adventurer rests and regains their power through meditation.");
        // Implement resting logic to regain power using meditation
        // For example, you can increase the power level of the adventurer
        // by a certain amount or set it to a maximum value.
        int maxPower = 100; // maximum power level
        int powerGained = 20; // power gained through meditation
        int currentPower = getPower(); // get the current power level of the adventurer
        currentPower += powerGained; // increase the current power by the amount gained
        if (currentPower > maxPower) {
            currentPower = maxPower; // cap the power level at the maximum value
        }
        setPower(currentPower); // set the new power level for the adventurer
    }
    /**
     * Undo the last action performed by the Magical Adventurer.
     * 
     * The Magical Adventurer undoes the last action performed using their time manipulation spell.
     * This method pops the last action from the actions stack and performs the opposite action to undo it.
     * If the actions stack is empty, nothing will be undone and a message will be printed.
     */

    @Override
    public void undo() {
        System.out.println("Magical adventurer undoes the last action using their time manipulation spell.");
        // Pop the last action from the stack and perform the opposite action to undo
        if (!actions.isEmpty()) {
            String lastAction = actions.pop(); // Pop the last action from the stack
            String[] actionParts = lastAction.split(" "); // Split the action into parts
            if (actionParts.length == 2) {
                String action = actionParts[0]; // Get the action keyword
                String target = actionParts[1]; // Get the target (e.g. item name)
                if (action.equals("grab")) {
                    // Undo a grab action by calling drop() with the target item to undo
                    System.out.println("Undoing action: " + lastAction);
                    if (backpack.isEmpty()) {
                        System.out.println("Backpack is empty. Nothing to undo.");
                    } else {
                        drop(target); // Call drop() with the target item to undo
                    }
                } else if (action.equals("drop")) {
                    // Undo a drop action by calling grab() with the target item to undo
                    System.out.println("Undoing action: " + lastAction);
                    grab(target); // Call grab() with the target item to undo
                } else if (action.equals("grow")) {
                    // Undo a grow action by calling shrink() to undo
                    System.out.println("Undoing action: " + lastAction);
                    shrink(); // Call shrink() to undo
                } else if (action.equals("shrink")) {
                    // Undo a shrink action by calling grow() to undo
                    System.out.println("Undoing action: " + lastAction);
                    grow(); // Call grow() to undo
                } else {
                    System.out.println("No opposite action found for undoing.");
                }
                actions.push(lastAction); // Add the action being undone back to the actions stack
            } else {
                System.out.println("Invalid action format: " + lastAction);
            }
        } else {
            System.out.println("No actions to undo."); // Print a message if no actions are available to undo
        }
    }

        
}


