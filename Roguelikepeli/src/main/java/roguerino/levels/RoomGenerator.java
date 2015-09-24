
package roguerino.levels;


import java.util.Random;

public class RoomGenerator {

    private Random random;

    public RoomGenerator() {

    }

    public Room generateRandomRoom() {
        //this.random = new Random();
        //int roomType = this.random.nextInt(2);
        Room room = roomSmall();

        return room;
    }

    /*
    private Room roomType(int roomType) {
        if (roomType == 0) {
            return roomSmall();
        }
        return roomMedium();     
    }

    /*
     W= wall
     D= door
     .= empty ei black;
    
     WWW
     D.W
     WWW
     */
    public Room roomSmall() {
        Room room = new Room(4, 3);
        
        Block wallBlock = new Block();
        wallBlock.setWall(true);
        
        for (int i = 0; i < 3; i++) {
            for (int j = 1; j < 4; j++) {
                if (i == 1 && j == 1) { 
                    continue;
                } else if ( i == 1 && j == 2) {
                    continue;
                } else {
                    room.setBlock(wallBlock, j, i);
                }     
            }    
            }   
        
        Block doorBlock = new Block();
        doorBlock.setBlack(false);
        doorBlock.setDoor(true);
        
        room.setBlock(doorBlock, 1, 1);

        
        Block emptyBlock = new Block();
        emptyBlock.setBlack(false);
        emptyBlock.setFloor(true);
        
        room.setBlock(emptyBlock, 2, 1);

        /*
         Block nothingHere = new Block();
         noShitHereBlock.setnothingHere(true);
         noShitHereBlock.setBlack(false);
         */
        
        room.setBlock(new Block(null, false, false, false, false), 0, 0);
        room.setBlock(new Block(null, false, false, false, false), 0, 1);
        room.setBlock(new Block(null, false, false, false, false), 0, 2);

        Random r = new Random();
        int a = r.nextInt(4);
        for (int i = 0; i < a; i++) {
            room = rotateRoom(room);
        }

        return room;
    }

    public Room rotateRoom(Room room) {
        Room rotatedRoom = new Room(room.getHeight(), room.getWidth());

        for (int i = 0; i < room.getWidth(); i++) {
            for (int j = 0; j < room.getHeight(); j++) {
                rotatedRoom.setBlock(room.getBlock(i, j), j, room.getWidth() - 1 - i);
            }
        }
        return rotatedRoom;
    }
}

   
