package com.test.reconstraction;

/**
 * 枚举类型，实现以类型对象取代类型码，的重构方法。
 * @author 张超
 * 2012-7-30下午05:35:51
 *
 */
public enum TracfficTypeEnum {

	traffic_1("1"),
	traffic_2("1"),
	traffic_3("3");
	
	private String value="";

	private TracfficTypeEnum(String value) {
		this.value = value;
	}

	public String getValue() {
		return value;
	}
	
	public TracfficTypeEnum createTypeClassByCode(String value){
		if(value.equals(traffic_1.getValue())){
			return traffic_1;
		}
		if(value.equals(traffic_2.getValue())){
			return traffic_2;
		}
		if(value.equals(traffic_3.getValue())){
			return traffic_3;
		}
		throw new RuntimeException("类型码"+value+"错误");
	}
}
