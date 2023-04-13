public class TestMagicalAdventurer {
    public static void main(String[] args) {
        MagicalAdventurer adventurer = new MagicalAdventurer(); // Create a new instance of MagicalAdventurer
        
        adventurer.grab("Sword"); // Test the grab() method
        adventurer.drop("Sword"); // Test the drop() method
        adventurer.examine("Sword"); // Test the examine() method
        adventurer.use("Magic Wand"); // Test the use() method
        adventurer.walk("north"); // Test the walk() method
        adventurer.fly(10, 20); // Test the fly() method
        adventurer.shrink(); // Test the shrink() method
        adventurer.grow(); // Test the grow() method
        adventurer.rest(); // Test the rest() method
        adventurer.undo(); // Test the undo() method
    }
}

