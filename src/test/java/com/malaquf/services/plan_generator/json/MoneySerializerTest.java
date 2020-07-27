package com.malaquf.services.plan_generator.json;

import static org.mockito.Mockito.verify;

import java.io.IOException;
import java.math.BigDecimal;

import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.malaquf.services.plan_generator.json.MoneySerializer;

@SpringBootTest
class MoneySerializerTest {

	private MoneySerializer testInstance = new MoneySerializer();
	
	@Mock
	private JsonGenerator jsonGeneratorMock;
	
	@Mock
	private SerializerProvider serializerProviderMock;
	
	@Test
	public void serializeTest() throws IOException {
		this.testInstance.serialize(
				BigDecimal.valueOf(5.7), 
				jsonGeneratorMock, 
				serializerProviderMock);
		verify(this.jsonGeneratorMock).writeString("5.70");
		
	}
	
}
