package com.cpal.common.util;

import java.util.Arrays;
import java.util.Objects;

public class ObjectUtil {
	
	private ObjectUtil() {
		
	}
	
	public static boolean anyNulls(Object... values) {
		if(values == null) {
			return Boolean.FALSE;
		}
		return Arrays.stream(values).anyMatch(Objects::isNull);
	}

}
