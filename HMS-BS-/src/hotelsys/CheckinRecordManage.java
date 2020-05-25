package hotelsys;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class CheckinRecordManage {
	ArrayList<CheckinRecord> records;
	static final String fileName = "CheckinRecords.txt";
	static final String DOOMSDAY = "9999-12-31 23:59:59";
	CheckinRecordManage() {
		records = new ArrayList<CheckinRecord>(); 
	}

	void LoadRecords() throws FileNotFoundException {
		String lineData;
		File file = new File(fileName);
		Scanner fileScan = new Scanner(file);
		Scanner lineScan;
		while (fileScan.hasNext()) {
			lineData = fileScan.nextLine();
			lineScan = new Scanner(lineData);
			lineScan.useDelimiter("/");

			while (lineScan.hasNext()) {
				String customerName = lineScan.next();
				String customerId = lineScan.next();
				String roomId = lineScan.next();
				String checkinTime = lineScan.next();
				String checkoutTime = lineScan.next();

				CheckinRecord record = new CheckinRecord(customerName, customerId, roomId, checkinTime, checkoutTime); 
				records.add(record);
				System.out.println(record);
			}
			lineScan.close();
		}
		fileScan.close();
		
	}

	// 开房
	public void OpenRoom(String customerName, String customerId, String roomId) {
		Date now = new Date();
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		CheckinRecord record = new CheckinRecord(customerName, customerId, roomId, df.format(now), DOOMSDAY);
		records.add(record);
		try {
			RefreshFile();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	// 退房
	public void CloseRoom(String customerId, String roomId) {
		for (CheckinRecord record : records) {
			if (0 == customerId.compareTo(record.getCustomerId()) && 0 == roomId.compareTo(record.getRoomId())) {
				Date now = new Date();
				SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				record.setCheckoutTime(df.format(now));
				try {
					RefreshFile();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	public CheckinRecord QueryInfo(String customerId, String roomId) {
		for (CheckinRecord record : records) {
			if (0 == customerId.compareTo(record.getCustomerId()) && 0 == roomId.compareTo(record.getRoomId())) {
				return record;
			}
		}
		return null;
	}

	// 刷新磁盘文件
	private void RefreshFile() throws IOException {
		File file = new File(fileName);
		Writer writer = new FileWriter(file);
		for (CheckinRecord record : records) {
			String lineData = record.getCustomerName() + "/" + record.getCustomerId() + "/" + record.getRoomId() + "/"
					+ record.getCheckinTime() + "/" + record.getCheckoutTime() + "\n";
			writer.write(lineData);
		}
		writer.close();
	}

//	public static void main(String[] args) {
//		// TODO Auto-generated method stub
//		CheckinRecordManage manage = new CheckinRecordManage();
//		try {
//			manage.LoadRecords();
//		} catch (FileNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//
//	}

}
