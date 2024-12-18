package br.ufrn.imd.primavera.remoting.marshaller;

import br.ufrn.imd.primavera.remoting.marshaller.impl.BinaryMarshaller;
import br.ufrn.imd.primavera.remoting.marshaller.impl.JsonMarshaller;
import br.ufrn.imd.primavera.remoting.marshaller.interfaces.Marshaller;

public enum MarshallerType {
	JSON("JSON Marshaller") {
		@Override
		protected Marshaller<String> createMarshaller() {
			return new JsonMarshaller();
		}
	},
	BYTE("Binary Marshaller") {
		@Override
		protected Marshaller<byte[]> createMarshaller() {
			return new BinaryMarshaller();
		}
	};

	private final String description;

	MarshallerType(String description) {
		this.description = description;
	}

	protected abstract Marshaller<?> createMarshaller();

	public String getDescription() {
		return description;
	}

	public static MarshallerType fromName(String name) {
		for (MarshallerType type : values()) {
			if (type.name().equalsIgnoreCase(name)) {
				return type;
			}
		}
		throw new IllegalArgumentException("Unknown MarshallerType: " + name);
	}
}