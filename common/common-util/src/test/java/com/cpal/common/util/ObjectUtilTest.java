package com.cpal.common.util;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class ObjectUtilTest {

	@Test
	public void anyNulls_returnsTrue_whenNullInObjectArray() {
		assertTrue(ObjectUtil.anyNulls("NA", null));
	}

	@Test
	public void anyNulls_returnsFalse_whenNoNullInObjectArray() {
		assertFalse(ObjectUtil.anyNulls("NA"));
	}
	
	@Test
	public void anyNulls_returnsFalse_whenValuesInObjectArray() {
		assertFalse(ObjectUtil.anyNulls());
	}
	
	@Test
	public void anyNulls_returnsTrue_whenAllNullsInObjectArray() {
		assertTrue(ObjectUtil.anyNulls(null,null));
	}
}
