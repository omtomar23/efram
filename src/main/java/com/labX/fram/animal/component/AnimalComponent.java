package com.labX.fram.animal.component;

import javax.json.JsonObject;

import com.labX.fram.animal.request.AnimalRequest;
import com.labX.fram.component.Component;

public interface AnimalComponent extends Component {
	JsonObject readAll(final AnimalRequest withType);
}
