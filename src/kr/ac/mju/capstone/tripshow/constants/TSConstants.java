package kr.ac.mju.capstone.tripshow.constants;

public class TSConstants {
	//socket information
		public static final String IP_ADDRESS = "117.17.158.165";
//		public static final String IP_ADDRESS = "117.17.158.39";
		public static final int PORT_NUMBER = 5999;
		
		//msg result information
		public static final int RECEIVE_SUCCESS = 0;
		public static final int RECEIVE_FAIL = 1;
		
		//GPS
		public static final int GPS_YES = 2;
		public static final int GPS_NO = 3;
		
		/////////
		public static final int BLUETOOTH_NORMALLY_STOP = 18;
		public static final int BLUETOOTH_ABNORMALLY_STOP = 19;
		
		public static final int REQUEST_CONNECT_DEVICE = 4;
		public static final int REQUEST_ENABLE_BT = 5;
		
		public static final int MESSAGE_STATE_CHANGE = 6;
		public static final int MESSAGE_READ = 7;
		public static final int MESSAGE_WRITE = 21;
		public static final int MESSAGE_DEVICE_NAME = 8;
		public static final int MESSAGE_TOAST = 9;
		
		public static final int STATE_NONE = 10; // we're doing nothing
		public static final int STATE_LISTEN = 11; // now listening for incoming connections
		public static final int STATE_CONNECTING = 12; // now initiating an outgoing connection
		public static final int STATE_CONNECTED = 13; // now connected to a remote device
		////////////////
		
		public static final int CONNECTED_SERVER = 14;
		public static final int NOT_CONNECTED_SERVER = 15;
		public static final int CONNECTED_DEVICE = 16;
		public static final int NOT_CONNECTED_DEVICE = 17;
		
		public static final String DEVICE_NAME = "device_name";
		public static final String TOAST = "toast";
		
		public static final int CONNECTION_LOST = 20;
		
		//log
		public static final String ERROR = "ERROR";
		public static final String DEBUG = "DEBUG";
		
		//INTENT STATE
		public static final String INTENT_STATE = "intent_state";
		public static final int ADMIN_REQUEST = 30;
		public static final int INIT = 31;
		
		public static final String LOCATION_CHANGED = "location_changed";
		public static final String LOCATIONS = "locationss";
		
		
		//crypto
		public static final String CRYPTO_SEED_KEY ="60dc26ddc7604defb7e83da1eb37dc3f";
}
