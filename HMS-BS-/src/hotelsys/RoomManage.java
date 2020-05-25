package hotelsys;

import java.io.*;
import java.text.DecimalFormat;
import java.util.*;

public class RoomManage {
	ArrayList<Room> rooms;
	static final String fileName = "RoomInfos.txt";

	RoomManage() {
		rooms = new ArrayList<Room>(); 
	}

	void LoadRoom() throws FileNotFoundException {
		String lineData;
		File file = new File(fileName);
		Scanner fileScan = new Scanner(file);
		Scanner lineScan;
		while (fileScan.hasNext()) {
			lineData = fileScan.nextLine();
			lineScan = new Scanner(lineData);
			lineScan.useDelimiter("/");

			while (lineScan.hasNext()) {
				String roomId = lineScan.next();
				double size = Double.parseDouble(lineScan.next());
				double price = Double.parseDouble(lineScan.next());
				int checkIn = Integer.parseInt(lineScan.next());
				int roomType = Integer.parseInt(lineScan.next());
				Room room = new Room(roomId, size, price, checkIn, roomType); 
				rooms.add(room);
				System.out.println(room);
			}
			lineScan.close();
		}
		fileScan.close();
		
	}
	
	// 分派一个可用的房间
	public String Allocate(int roomType) {
		String roomId = "";
		for (Room room : rooms) {
			if (roomType == room.getRoomType() && 0 == room.getCheckIn()) {
				roomId = room.getRoomId();
			}
		}
		return roomId;
	}

	// 冻结房间
	public void DeactiveRoom(String roomId) {
		for (Room room : rooms) {
			if (0 == roomId.compareTo(room.getRoomId())) {
				room.setCheckIn(1);
			}
		}

		try {
			RefreshFile();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	// 激活房间
	public void ActiveRoom(String roomId) {
		for (Room room : rooms) {
			if (0 == roomId.compareTo(room.getRoomId())) {
				room.setCheckIn(0);
			}
		}

		try {
			RefreshFile();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	// 刷新磁盘文件
	private void RefreshFile() throws IOException {
		File file = new File(fileName);
		Writer writer = new FileWriter(file);
		DecimalFormat fmt = new DecimalFormat("0.##");
		for (Room room : rooms) {
			String lineData = room.getRoomId() + "/" + fmt.format(room.getSize()) + "/"
					+ fmt.format(room.getPrice()) + "/" + room.getCheckIn() + "/"
					+ room.getRoomType() + "\n";
			writer.write(lineData);
		}
		writer.close();
	}
	
	public Room QueryInfo(String roomId) {
		for (Room room : rooms) {
			if (0 == roomId.compareTo(room.getRoomId())) {
				return room;
			}
		}
		return null;
	}

	public String toString() {
		return "RoomManage [rooms=" + rooms + "]";
	}

//	static public void main(String[] args) throws IOException {
//		RoomManage roomMan = new RoomManage();
//		try {
//			roomMan.LoadRoom();
//			roomMan.DeactiveRoom("A8001");
//			System.out.println(roomMan);
//			
//			roomMan.ActiveRoom("A8001");
//			System.out.println(roomMan);
//			roomMan.RefreshFile();
//		} catch (FileNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	}

}
