package hotelsys;

// 房间
public class Room {
	// 房号
	private String roomId;
	// 房间大小
	private double size;
	// 每晚单价
	private double price;
	// 是否已有人入住: 0, 空闲; 1, 已有人入住
	private int checkIn;
	// 房间类型: 0,单人房; 1,双人房; 2, 豪华大床房;
	private int roomType;

	/**
	 * @param roomId
	 * @param size
	 * @param price
	 * @param checkIn
	 * @param roomType
	 */
	public Room(String roomId, double size, double price, int checkIn, int roomType) {
		super();
		this.roomId = roomId;
		this.size = size;
		this.price = price;
		this.checkIn = checkIn;
		this.roomType = roomType;
	}

	/**
	 * @return the price
	 */
	public double getPrice() {
		return price;
	}

	/**
	 * @param price
	 *            the price to set
	 */
	public void setPrice(double price) {
		this.price = price;
	}

	/**
	 * @return the checkIn
	 */
	public int getCheckIn() {
		return checkIn;
	}

	/**
	 * @param checkIn
	 *            the checkIn to set
	 */
	public void setCheckIn(int checkIn) {
		this.checkIn = checkIn;
	}

	/**
	 * @return the roomType
	 */
	public int getRoomType() {
		return roomType;
	}

	/**
	 * @param roomType
	 *            the roomType to set
	 */
	public void setRoomType(int roomType) {
		this.roomType = roomType;
	}

	/**
	 * @return the roomId
	 */
	public String getRoomId() {
		return roomId;
	}

	/**
	 * @param roomId the roomId to set
	 */
	public void setRoomId(String roomId) {
		this.roomId = roomId;
	}

	/**
	 * @return the size
	 */
	public double getSize() {
		return size;
	}

	/**
	 * @param size the size to set
	 */
	public void setSize(double size) {
		this.size = size;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Room [roomId=" + roomId + ", size=" + size + ", price=" + price + ", checkIn=" + checkIn + ", roomType="
				+ roomType + "]";
	}
	
}
