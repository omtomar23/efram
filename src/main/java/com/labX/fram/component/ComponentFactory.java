package com.labX.fram.component;

public interface ComponentFactory {
	<C extends Component> C resolve(final String name);
}
