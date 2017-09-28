package adress;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class HostLocalAddress {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String d = null;
		InetAddress localAddress = null;
		try {
			localAddress = InetAddress.getLocalHost();
			d = localAddress.getHostAddress();
			System.out.println(localAddress.getHostAddress());
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			localAddress.getHostAddress();

		}
		System.out.println(d);
	}

}
