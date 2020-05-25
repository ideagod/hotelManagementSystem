package hotelsys;

public class Account {
	/**
	 * @param name
	 * @param passwd
	 */
	public Account(String name, String passwd) {
		super();
		this.name = name;
		this.passwd = passwd;
	}

	private String name;
	private String passwd;
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return the passwd
	 */
	public String getPasswd() {
		return passwd;
	}
	/**
	 * @param passwd the passwd to set
	 */
	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}

}
