package com.labX.fram.convert;

public interface Convertor<I, O> {
	O convert(I input);
}
