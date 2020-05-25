package hotelsys;

public class CheckinRecord {
	private String customerName;
	private String customerId;
	private String roomId;
	private String checkinTime;
	private String checkoutTime;
	
	/**
	 * @param customerName
	 * @param customerId
	 * @param roomId
	 * @param checkinTime
	 * @param checkoutTime
	 */
	public CheckinRecord(String customerName, String customerId, String roomId, String checkinTime, String checkoutTime) {
		super();
		this.customerName = customerName;
		this.customerId = customerId;
		this.roomId = roomId;
		this.checkinTime = checkinTime;
		this.checkoutTime = checkoutTime;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "CheckinRecord [customerName=" + customerName + ", customerId=" + customerId + ", roomId=" + roomId + ", checkinTime=" + checkinTime
				+ ", checkoutTime=" + checkoutTime + "]";
	}

	/**
	 * @return the customerName
	 */
	public String getCustomerName() {
		return customerName;
	}

	/**
	 * @param customerName the customerName to set
	 */
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	/**
	 * @return the customerId
	 */
	public String getCustomerId() {
		return customerId;
	}

	/**
	 * @param customerId the customerId to set
	 */
	public void setCustomerId(String customerId) {
		this.customerId = customerId;
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
	 * @return the checkinTime
	 */
	public String getCheckinTime() {
		return checkinTime;
	}

	/**
	 * @param checkinTime the checkinTime to set
	 */
	public void setCheckinTime(String checkinTime) {
		this.checkinTime = checkinTime;
	}

	/**
	 * @return the checkoutTime
	 */
	public String getCheckoutTime() {
		return checkoutTime;
	}

	/**
	 * @param checkoutTime the checkoutTime to set
	 */
	public void setCheckoutTime(String checkoutTime) {
		this.checkoutTime = checkoutTime;
	}
}
