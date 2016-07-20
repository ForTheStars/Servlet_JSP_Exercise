package code08;

import javax.servlet.http.Cookie;
/*
 * 创建长生存期的cookie
 */
public class LongLivedCookie extends Cookie {
	private static final int SECONDS_PER_YEAR = 60 * 60 * 24 * 365;

	public LongLivedCookie(String name, String value) {
		super(name, value);
		setMaxAge(SECONDS_PER_YEAR);
	}
}
