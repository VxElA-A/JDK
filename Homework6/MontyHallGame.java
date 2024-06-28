package JavaDelevomentKitLesson6;


import java.util.HashMap;
import java.util.Map;
import java.util.Random;

    public class MontyHallGame {
        private final Random random;
        private int wins;
        private int losses;

        public MontyHallGame() {
            this.random = new Random();
        }

        public void playGame(int numIterations) {
            wins = 0;
            losses = 0;
            for (int i = 0; i < numIterations; i++) {
                int prizeDoor = random.nextInt(3);
                int chosenDoor = random.nextInt(3);

                int openedDoor;
                do {
                    openedDoor = random.nextInt(3);
                } while (openedDoor == prizeDoor || openedDoor == chosenDoor);

                int finalChoice = switchDoor(chosenDoor, openedDoor);

                if (finalChoice == prizeDoor) {
                    wins++;
                } else {
                    losses++;
                }
            }
        }

        private int switchDoor(int chosenDoor, int openedDoor) {
            int remainingDoor = 3 - chosenDoor - openedDoor;
            return remainingDoor;
        }

        public Map<String, Integer> getGameResult() {
            Map<String, Integer> result = new HashMap<>();
            result.put("Wins", wins);
            result.put("Losses", losses);
            return result;
        }

        public static void main(String[] args) {
            MontyHallGame game = new MontyHallGame();
            game.playGame(1000);
            Map<String, Integer> gameResult = game.getGameResult();
            gameResult.forEach((key, value) -> System.out.println(key + ": " + value));
        }
    }

