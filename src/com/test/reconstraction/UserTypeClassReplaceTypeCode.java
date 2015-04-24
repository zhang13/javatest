package com.test.reconstraction;

/**
 * 以类型对象取代类型码，的重构方法。
 * 在传参的时候用 UserTypeClassReplaceTypeCode.TRAFFIC_STATUS_1对象，再要使用数据类型的时候，用TRAFFIC_STATUS_1.getCode()
 * @author 张超
 * 2012-7-27下午05:23:41
 *
 */
public class UserTypeClassReplaceTypeCode {

	private String code;

	private UserTypeClassReplaceTypeCode(String code) {
		this.code = code;
	}

	public String getCode() {
		return code;
	}

	/**
	 * 严重拥堵
	 */
	public static final UserTypeClassReplaceTypeCode TRAFFIC_STATUS_1 = new UserTypeClassReplaceTypeCode(
			"1");
	/**
	 * 中度拥堵
	 */
	public static final UserTypeClassReplaceTypeCode TRAFFIC_STATUS_2 = new UserTypeClassReplaceTypeCode(
			"2");
	/**
	 * 轻度拥堵
	 */
	public static final UserTypeClassReplaceTypeCode TRAFFIC_STATUS_3 = new UserTypeClassReplaceTypeCode(
			"3");
	/**
	 * 基本畅通
	 */
	public static final UserTypeClassReplaceTypeCode TRAFFIC_STATUS_4 = new UserTypeClassReplaceTypeCode(
			"4");
	/**
	 * 畅通
	 */
	public static final UserTypeClassReplaceTypeCode TRAFFIC_STATUS_5 = new UserTypeClassReplaceTypeCode(
			"5");

	public static UserTypeClassReplaceTypeCode createByCode(String code) {
		if (code.equals(TRAFFIC_STATUS_1.getCode())) {
			return TRAFFIC_STATUS_1;
		}

		if (code.equals(TRAFFIC_STATUS_2.getCode())) {
			return TRAFFIC_STATUS_2;
		}

		if (code.equals(TRAFFIC_STATUS_3.getCode())) {
			return TRAFFIC_STATUS_3;
		}

		if (code.equals(TRAFFIC_STATUS_4.getCode())) {
			return TRAFFIC_STATUS_4;
		}

		if (code.equals(TRAFFIC_STATUS_5.getCode())) {
			return TRAFFIC_STATUS_5;
		}
		throw new RuntimeException("类型码" + code + "错误");
	}
}
