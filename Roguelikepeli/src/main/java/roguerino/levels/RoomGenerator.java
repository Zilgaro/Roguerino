
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
        Room room = new RoomSmall();       

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

   
